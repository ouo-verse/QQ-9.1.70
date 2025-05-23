package com.qzone.common.activities.base;

import com.qzone.app.QZoneAppInterface;
import com.qzone.common.account.LoginData;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import mqq.app.AppRuntime;

/* compiled from: P */
@Named("BaseFragmentConfigImp")
/* loaded from: classes39.dex */
public class ab implements d5.c {
    @Inject
    public ab() {
    }

    @Override // d5.c
    public void a() {
        u5.a.f();
    }

    @Override // d5.c
    public int b() {
        return QZoneAppInterface.activetyNum.getAndIncrement();
    }

    @Override // d5.c
    public long c() {
        return LoginData.getInstance().getUin();
    }

    @Override // d5.c
    public int d() {
        return u5.a.f438265c;
    }

    @Override // d5.c
    public String f() {
        return LoginData.getInstance().getUinString();
    }

    @Override // d5.c
    public int getScreenHeight() {
        return u5.a.c();
    }

    @Override // d5.c
    public int getScreenWidth() {
        return u5.a.d();
    }

    public AppRuntime h() {
        return LoginData.getInstance().getQzoneAppInterface();
    }

    @Override // d5.c
    public boolean isLoaded() {
        AppRuntime h16 = h();
        if (h16 instanceof QZoneAppInterface) {
            return ((QZoneAppInterface) h16).isLoaded();
        }
        return true;
    }

    @Override // d5.c
    public boolean isVip() {
        return LoginData.getInstance().isQzoneVip();
    }

    @Override // d5.c
    public void e(String str) {
        if (str == null) {
            return;
        }
        u5.b.u0(str, System.currentTimeMillis(), c());
    }

    @Override // d5.c
    public long g(String str) {
        if (str == null) {
            return 0L;
        }
        return u5.b.K(str, 0L, c());
    }
}
