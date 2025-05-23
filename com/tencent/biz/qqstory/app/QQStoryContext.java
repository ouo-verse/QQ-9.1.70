package com.tencent.biz.qqstory.app;

import ad0.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqstory.base.StoryBoss;
import com.tencent.biz.qqstory.base.b;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.Bosses;
import hd0.c;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QQStoryContext {

    /* renamed from: f, reason: collision with root package name */
    protected static BaseApplicationImpl f93959f;

    /* renamed from: a, reason: collision with root package name */
    protected QQStoryCmdHandler f93961a;

    /* renamed from: b, reason: collision with root package name */
    protected EntityManagerFactory f93962b;

    /* renamed from: c, reason: collision with root package name */
    public static String f93956c = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv/";

    /* renamed from: d, reason: collision with root package name */
    public static String f93957d = "testserver";

    /* renamed from: e, reason: collision with root package name */
    public static String f93958e = "last_env";

    /* renamed from: g, reason: collision with root package name */
    public static boolean f93960g = true;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class StoryBroadcastReceiver extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private static final String f93963a = "StoryBroadcastReceiver_" + MobileQQ.processName;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            c.b(f93963a, "onReceive, [context, intent=%s]", intent);
        }
    }

    public static AppInterface a() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return (PeakAppInterface) BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
    }

    public static QQAppInterface g() {
        return (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
    }

    public static QQStoryContext h() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return ((b) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.QQSTORY_MANAGER)).f93990h;
        }
        if (runtime instanceof ToolAppRuntime) {
            PeakAppInterface peakAppInterface = (PeakAppInterface) ((ToolAppRuntime) runtime).onGetSubRuntime("peak");
            peakAppInterface.i();
            return peakAppInterface.h();
        }
        AppRuntime appRuntime = BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
        if (appRuntime instanceof PeakAppInterface) {
            return ((PeakAppInterface) appRuntime).h();
        }
        return new QQStoryContext();
    }

    public static boolean i() {
        h();
        return ThemeUtil.isNowThemeIsNight(a(), false, null);
    }

    public BaseApplicationImpl b() {
        return f93959f;
    }

    public QQStoryCmdHandler c() {
        return this.f93961a;
    }

    public String d() {
        return a().getAccount();
    }

    public EntityManagerFactory e() {
        String d16 = d();
        if (d16 != null) {
            synchronized (this) {
                if (this.f93962b == null) {
                    a aVar = new a(d16);
                    aVar.verifyAuthentication();
                    this.f93962b = aVar;
                }
            }
            return this.f93962b;
        }
        throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }

    public long f() {
        return a().getLongAccountUin();
    }

    public void j() {
        boolean z16;
        try {
            synchronized (QQStoryContext.class) {
                if (f93959f == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                f93960g = z16;
                BaseApplicationImpl application = BaseApplicationImpl.getApplication();
                f93959f = application;
                if (f93960g) {
                    Bosses.initWithBoss(application, new StoryBoss(f93959f));
                    c.r(hd0.b.b());
                }
            }
            c.a("Q.qqstory.user.QQStoryRuntime", "on create");
            this.f93961a = new QQStoryCmdHandler();
        } catch (Throwable th5) {
            c.h("Q.qqstory.user.QQStoryRuntime", "onCreate error!", th5);
        }
    }
}
