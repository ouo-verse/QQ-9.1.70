package com.qzone.common.activities.base;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import cooperation.qzone.api.QZoneContant;

/* compiled from: P */
@Named("BaseFeedFragmentJumpImp")
/* loaded from: classes39.dex */
public class r implements d5.t<BusinessFeedData> {

    /* renamed from: a, reason: collision with root package name */
    protected d5.u f45533a;

    /* renamed from: b, reason: collision with root package name */
    private d5.c f45534b;

    @Inject
    public r() {
    }

    @Override // d5.t
    public void a(d5.k<BusinessFeedData> kVar, int i3) {
        ho.i.e().j(this.f45533a.getActivity(), kVar.b());
    }

    @Override // d5.t
    public void b(String str, String str2) {
        this.f45533a.a(ak.r(this.f45533a.getActivity(), str, str2, false, this.f45534b.c(), this.f45534b.isVip()), QZoneContant.QZ_REQUEST_OPEN_VIP);
    }

    @Override // d5.t
    public void c(long j3, String str, String str2) {
        ho.i.z().m(this.f45533a.getActivity(), j3);
    }

    @Override // d5.t
    public void e(d5.k<BusinessFeedData> kVar, int i3, long j3) {
        ho.i.e().i(this.f45533a.getActivity(), kVar.b(), i3, j3);
    }

    @Override // d5.t
    public void g(long j3, String str) {
        vo.c.A(this.f45533a.getActivity(), j3, str);
    }

    @Override // d5.t
    public void h(String str, Long l3, String str2, int i3, boolean z16) {
        vo.b.c(this.f45533a.getActivity(), str, l3, str2, i3, z16);
    }

    @Override // d5.t
    public void i(long j3, int i3) {
        vo.a.a(j3, i3);
    }

    @Override // d5.t
    public void k(long j3, String str) {
        vo.c.E(this.f45533a.getActivity(), j3, str);
    }

    @Override // d5.t
    public void l(String str) {
        ho.i.g().d(this.f45533a.getActivity(), str);
    }

    @Inject
    @Named("BaseFragmentConfigImp")
    public void setConfigInf(d5.c cVar) {
        this.f45534b = cVar;
    }

    @Inject
    public void setContainer(d5.u uVar) {
        this.f45533a = uVar;
    }

    @Override // d5.t
    public void f(String str, Long l3, String str2, int i3, long j3, long j16) {
        vo.b.b(this.f45533a.getActivity(), str, l3, str2, i3, j3, j16);
    }

    @Override // d5.t
    public void d(d5.k<BusinessFeedData> kVar, int i3, long j3, int i16) {
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            ho.i.f().d(this.f45533a.getActivity(), kVar.b(), i3, i16, false);
        } else {
            ho.i.e().b(this.f45533a.getActivity(), kVar.b(), i3, 0L, i16, false);
        }
    }

    @Override // d5.t
    public void m(Intent intent) {
        if (intent != null) {
            Uri data = intent.getData();
            Intent intent2 = new Intent(this.f45533a.getActivity(), lc.b.b());
            intent2.putExtra("IsBack", true);
            Bundle bundle = new Bundle();
            bundle.putParcelable(QzoneCameraConst.Tag.ARG_PARAM_IMAGE_URI, data);
            bundle.putInt("NEXT_CMD", 313);
            intent2.putExtras(bundle);
            Intent intent3 = this.f45533a.getIntent();
            if (intent3 != null) {
                String stringExtra = intent3.getStringExtra("selfUin");
                String stringExtra2 = intent3.getStringExtra(QZoneContant.SELFSID);
                intent2.putExtra("selfUin", stringExtra);
                intent2.putExtra(QZoneContant.SELFSID, stringExtra2);
            }
            ho.i.w().b(this.f45533a.getActivity(), new QZonePublishMoodInitBean(System.currentTimeMillis()), 100, intent2);
        }
    }

    @Override // d5.t
    public void j(String str, boolean z16) {
    }
}
