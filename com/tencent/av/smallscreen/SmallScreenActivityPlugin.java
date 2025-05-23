package com.tencent.av.smallscreen;

import com.tencent.av.smallscreen.api.ISmallScreenActivityPluginHelperApi;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes3.dex */
public class SmallScreenActivityPlugin {

    /* renamed from: e, reason: collision with root package name */
    private static volatile SmallScreenActivityPlugin f74481e;

    /* renamed from: a, reason: collision with root package name */
    boolean f74482a = false;

    /* renamed from: b, reason: collision with root package name */
    boolean f74483b = true;

    /* renamed from: c, reason: collision with root package name */
    boolean f74484c = false;

    /* renamed from: d, reason: collision with root package name */
    BaseVideoAppInterface f74485d;

    SmallScreenActivityPlugin(BaseVideoAppInterface baseVideoAppInterface) {
        this.f74485d = baseVideoAppInterface;
    }

    public static SmallScreenActivityPlugin a(BaseVideoAppInterface baseVideoAppInterface) {
        if (f74481e == null) {
            synchronized (SmallScreenActivityPlugin.class) {
                if (f74481e == null) {
                    f74481e = new SmallScreenActivityPlugin(baseVideoAppInterface);
                }
            }
        }
        return f74481e;
    }

    public boolean b() {
        if (!this.f74482a && SmallScreenUtils.w()) {
            return false;
        }
        return true;
    }

    public void c() {
        this.f74482a = false;
    }

    public void d() {
        if (SmallScreenUtils.w()) {
            this.f74482a = false;
        }
    }

    public void e(boolean z16) {
        if (SmallScreenUtils.w()) {
            this.f74482a = false;
            this.f74483b = false;
        }
    }

    public void f(long j3, boolean z16) {
        boolean z17;
        ISmallScreenActivityPluginHelperApi iSmallScreenActivityPluginHelperApi = (ISmallScreenActivityPluginHelperApi) QRoute.api(ISmallScreenActivityPluginHelperApi.class);
        BaseVideoAppInterface baseVideoAppInterface = this.f74485d;
        if (!this.f74484c && this.f74483b) {
            z17 = true;
        } else {
            z17 = false;
        }
        iSmallScreenActivityPluginHelperApi.onPauseRender(j3, baseVideoAppInterface, z17, z16);
    }

    public void g() {
        final long d16 = com.tencent.av.utils.e.d();
        boolean v3 = SmallScreenUtils.v();
        if (QLog.isColorLevel()) {
            QLog.w("SmallScreenActivityPlugin", 1, "onResume, seq[" + d16 + "] isShareToastShow=" + v3);
        }
        if (SmallScreenUtils.w()) {
            this.f74482a = false;
            this.f74483b = true;
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenActivityPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    SmallScreenUtils.a(d16, 2, SmallScreenActivityPlugin.this.f74485d.getApp());
                }
            }, 16, null, false, 50L);
        }
        if (!v3) {
            SmallScreenUtils.B(d16, this.f74485d, 0);
        }
    }

    public void h(boolean z16) {
        this.f74484c = z16;
    }
}
