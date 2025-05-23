package com.tencent.mobileqq.pymk;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.pymk.k;
import com.tencent.mobileqq.pymk.request.PYMKHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.util.QQToastUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u000fJ\"\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u0006J\u0018\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u000fJ\u0006\u0010\u001d\u001a\u00020\u0006R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/pymk/k;", "", "", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "l", "", "e", "guildCLoseLastTimeStamp", "", "guildCLoseTimes", "b", "Lcom/tencent/mobileqq/pymk/i;", "listener", "from", "", "a", tl.h.F, "g", "isSwitchOn", "app", "needReqData", "j", "Lmqq/app/AppRuntime;", "senceId", "d", "f", "c", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "pymkSwitchChangeListenerList", "Z", "useSimplifyTop2", "Lcom/tencent/mobileqq/pymk/h;", "Lcom/tencent/mobileqq/pymk/h;", "observer", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f261468a = new k();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<i> pymkSwitchChangeListenerList = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final boolean useSimplifyTop2 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("use_simplify_top2", false);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final h observer = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/pymk/k$a", "Lcom/tencent/mobileqq/pymk/h;", "", "result", "", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends h {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "$msg");
            QQToastUtil.showQQToast(2, msg2);
        }

        @Override // com.tencent.mobileqq.pymk.h
        public void a(boolean result) {
            final String str;
            QLog.i("PymkSwitchAGuideUtil", 1, "onSetPYMKSwitch " + result);
            if (result) {
                str = "\u5df2\u5f00\u542f\u201c\u53ef\u80fd\u8ba4\u8bc6\u7684\u4eba\u201d";
            } else {
                str = "\u5f00\u542f\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc";
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.pymk.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.a.c(str);
                }
            });
            if (result) {
                k.f261468a.j(true, null, false);
            }
        }
    }

    k() {
    }

    private final String l(long timeStamp) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timeStamp));
        Intrinsics.checkNotNullExpressionValue(format, "simpleDateFormat.format(date)");
        return format;
    }

    public final void a(i listener, String from) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(from, "from");
        CopyOnWriteArrayList<i> copyOnWriteArrayList = pymkSwitchChangeListenerList;
        if (copyOnWriteArrayList.isEmpty()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            ((QQAppInterface) peekAppRuntime).addObserver(observer);
        }
        copyOnWriteArrayList.add(listener);
        QLog.i("PymkSwitchAGuideUtil", 1, "addPYMKSwitchChangeListener from " + from + " listener " + listener.hashCode());
    }

    public final long b(long guildCLoseLastTimeStamp, int guildCLoseTimes) {
        int i3;
        boolean pymkTestSwitch = ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).pymkTestSwitch();
        if (guildCLoseTimes == 1) {
            i3 = pymkTestSwitch ? 90000 : 604800000;
        } else {
            if (guildCLoseTimes != 2) {
                return 0L;
            }
            i3 = pymkTestSwitch ? 180000 : 1209600000;
        }
        return guildCLoseLastTimeStamp + i3;
    }

    public final boolean c() {
        return f.f261465a.h();
    }

    public final boolean e() {
        f fVar = f.f261465a;
        if (!fVar.i()) {
            QLog.i("PymkSwitchAGuideUtil", 1, "not show PYMK guide : no PYMK swtich data");
            return false;
        }
        if (!c() && !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            if (((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).getLocalRecommendData(4).isEmpty()) {
                QLog.i("PymkSwitchAGuideUtil", 1, "not show PYMK guide : top2/4 no data");
                return false;
            }
            int b16 = fVar.b();
            long a16 = fVar.a();
            if (b16 >= 3) {
                QLog.i("PymkSwitchAGuideUtil", 1, "not show PYMK guide : close 3 times");
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long b17 = b(a16, b16);
            if (b17 > currentTimeMillis) {
                QLog.i("PymkSwitchAGuideUtil", 1, "not show PYMK guide : close " + b16 + " next time " + l(b17));
                return false;
            }
            QLog.i("PymkSwitchAGuideUtil", 1, "show PYMK guide");
            return true;
        }
        QLog.i("PymkSwitchAGuideUtil", 1, "not show PYMK guide :  pymk switch on or study mode");
        return false;
    }

    public final void f(boolean isSwitchOn) {
        Unit unit;
        Iterator<i> it = pymkSwitchChangeListenerList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "pymkSwitchChangeListenerList.iterator()");
        while (it.hasNext()) {
            i next = it.next();
            if (next != null) {
                next.a(isSwitchOn);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                it.remove();
            }
        }
    }

    public final void g() {
        f fVar = f.f261465a;
        fVar.k(fVar.b() + 1);
        fVar.j(System.currentTimeMillis());
    }

    public final void h(i listener, String from) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(from, "from");
        CopyOnWriteArrayList<i> copyOnWriteArrayList = pymkSwitchChangeListenerList;
        copyOnWriteArrayList.remove(listener);
        if (copyOnWriteArrayList.isEmpty()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            ((QQAppInterface) peekAppRuntime).removeObserver(observer);
        }
        QLog.i("PymkSwitchAGuideUtil", 1, "removePYMKSwitchChangeListener from " + from + " listener " + listener.hashCode());
    }

    public final void i() {
        boolean h16 = f.f261465a.h();
        if (h16) {
            QLog.i("PymkSwitchAGuideUtil", 1, "reqOpenPYMKSetting fail switch " + h16);
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ)) {
            QQToast.makeText(MobileQQ.sMobileQQ, "\u5f00\u542f\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc", 0).show();
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        BusinessHandler businessHandler = appInterface.getBusinessHandler(PYMKHandler.class.getName());
        PYMKHandler pYMKHandler = businessHandler instanceof PYMKHandler ? (PYMKHandler) businessHandler : null;
        if (pYMKHandler != null) {
            pYMKHandler.G2(true);
        }
        QLog.i("PymkSwitchAGuideUtil", 1, "start reqOpenPYMKSetting");
    }

    public final void j(boolean isSwitchOn, Object app, boolean needReqData) {
        if (isSwitchOn == c() && f.f261465a.i()) {
            QLog.i("PymkSwitchAGuideUtil", 1, "setPYMKSwitch " + isSwitchOn + " return\uff0cnot change and has saved");
            d(app instanceof AppRuntime ? (AppRuntime) app : null, 1);
            return;
        }
        f.f261465a.p(isSwitchOn);
        f(isSwitchOn);
        QLog.i("PymkSwitchAGuideUtil", 1, "setPYMKSwitch " + isSwitchOn);
        if (needReqData) {
            d(app instanceof AppRuntime ? (AppRuntime) app : null, 6);
            ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).fetchRecommendDataRemoteForceAll();
        }
    }

    public final boolean m() {
        boolean z16 = useSimplifyTop2;
        QLog.i("PymkSwitchAGuideUtil", 1, "useSimplifyTop2 " + z16);
        return z16;
    }

    public final void d(AppRuntime app, int senceId) {
        if (app == null) {
            app = MobileQQ.sMobileQQ.peekAppRuntime();
        }
        if (app != null) {
            QLog.i("PymkSwitchAGuideUtil", 1, "get C26 sence swich after pymk switch change");
            Manager manager = app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.MayknowRecommendManager");
            ((MayknowRecommendManager) manager).g(senceId);
            return;
        }
        QLog.i("PymkSwitchAGuideUtil", 1, "get C26 sence switch fail because no QQAppInterface");
    }

    public static /* synthetic */ void k(k kVar, boolean z16, Object obj, boolean z17, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        kVar.j(z16, obj, z17);
    }
}
