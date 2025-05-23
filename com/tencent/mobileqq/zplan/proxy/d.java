package com.tencent.mobileqq.zplan.proxy;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/d;", "Lzx4/d;", "", "b", tl.h.F, "isPreloadEnable", "o", "k", "j", "i", DomainData.DOMAIN_NAME, "a", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "c", "g", "", "l", "d", "f", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d implements zx4.d {
    @Override // zx4.d
    public boolean a() {
        boolean Z2 = ZPlanFeatureSwitch.f369852a.Z2();
        QLog.i("[zplan]_ZPlanConfigProxy", 1, "isDownloadInZPlanProcess " + Z2);
        return Z2;
    }

    @Override // zx4.d
    public boolean b() {
        ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
        return zPlanFeatureSwitch.f3() && !zPlanFeatureSwitch.n3();
    }

    @Override // zx4.d
    public boolean c() {
        return ZPlanFeatureSwitch.f369852a.n();
    }

    @Override // zx4.d
    public int d() {
        return ZPlanFeatureSwitch.f369852a.F0();
    }

    @Override // zx4.d
    public String e() {
        return com.tencent.sqshow.zootopia.utils.ab.INSTANCE.c();
    }

    @Override // zx4.d
    public boolean f() {
        return ZPlanFeatureSwitch.f369852a.G0();
    }

    @Override // zx4.d
    public boolean g() {
        return ZPlanFeatureSwitch.f369852a.J();
    }

    @Override // zx4.d
    public boolean h() {
        return ZPlanFeatureSwitch.f369852a.n3();
    }

    @Override // zx4.d
    public boolean i() {
        return ZPlanFeatureSwitch.f369852a.O();
    }

    @Override // zx4.d
    public boolean isPreloadEnable() {
        return ZPlanFeatureSwitch.f369852a.f3();
    }

    @Override // zx4.d
    public boolean j() {
        return ZPlanFeatureSwitch.f369852a.B();
    }

    @Override // zx4.d
    public boolean k() {
        return ZPlanFeatureSwitch.f369852a.A();
    }

    @Override // zx4.d
    public int l() {
        return ZPlanFeatureSwitch.f369852a.p1();
    }

    @Override // zx4.d
    public String m() {
        String L2 = ZPlanFeatureSwitch.f369852a.L2();
        QLog.i("[zplan]_ZPlanConfigProxy", 1, "getZPlanUe4SwitchConfig " + L2);
        return L2;
    }

    @Override // zx4.d
    public boolean n() {
        return ZPlanFeatureSwitch.f369852a.G();
    }

    @Override // zx4.d
    public boolean o() {
        return ZPlanFeatureSwitch.f369852a.N();
    }
}
