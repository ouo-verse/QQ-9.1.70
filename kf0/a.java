package kf0;

import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements Manager {

    /* renamed from: e, reason: collision with root package name */
    protected static BaseApplicationImpl f412281e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f412282f = true;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f412283d;

    public a(AppInterface appInterface) {
        this.f412283d = appInterface;
        a();
    }

    public void a() {
        synchronized (a.class) {
            f412281e = BaseApplicationImpl.getApplication();
            if (f412282f) {
                f412282f = false;
            }
            VSConfigManager.c();
        }
        QLog.i("Q.videostory.VSManager", 1, "init");
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
