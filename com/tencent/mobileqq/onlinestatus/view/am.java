package com.tencent.mobileqq.onlinestatus.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.OnlineStatusExtInfoServlet;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import com.tencent.mobileqq.onlinestatus.bv;
import com.tencent.mobileqq.onlinestatus.w;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class am extends com.tencent.mobileqq.onlinestatus.w {

    /* renamed from: k, reason: collision with root package name */
    kc2.e f256509k;

    /* renamed from: l, reason: collision with root package name */
    private String f256510l;

    /* renamed from: m, reason: collision with root package name */
    private String f256511m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends kc2.e {
        a() {
        }

        @Override // kc2.e
        public void a(boolean z16, @Nullable Bundle bundle) {
            super.a(z16, bundle);
            if (bundle != null) {
                am.this.f256511m = bundle.getString("key_today_constellation_trend");
            }
            am.this.j();
            if (((com.tencent.mobileqq.onlinestatus.w) am.this).f256881j && ((com.tencent.mobileqq.onlinestatus.w) am.this).f256877f != null) {
                ((com.tencent.mobileqq.onlinestatus.w) am.this).f256877f.f();
            }
        }
    }

    public am(long j3, w.a aVar, AppInterface appInterface, QBaseActivity qBaseActivity) {
        super(j3, aVar, appInterface, qBaseActivity);
        a aVar2 = new a();
        this.f256509k = aVar2;
        this.f256510l = "";
        this.f256511m = "";
        appInterface.registObserver(aVar2);
        this.f256510l = com.tencent.mobileqq.onlinestatus.bs.u(((IProfileCardUtil) QRoute.api(IProfileCardUtil.class)).initCard(appInterface, appInterface.getCurrentAccountUin()).constellation);
    }

    @Override // com.tencent.mobileqq.onlinestatus.w
    public void b(boolean z16) {
        if (z16) {
            OnlineStatusExtInfoServlet.b(this.f256880i, this.f256510l);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.w
    public void d() {
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = com.tencent.mobileqq.onlinestatus.bs.H("OnlineStatusConstellationDisplayInfo");
        if (H == null) {
            QLog.w("OnlineStatusConstellationDisplayInfo", 1, "handleOnlineStatusDesClick simpleInfo is null");
        } else {
            kc2.a.f412010a.a(this.f256879h, H.m(), 4015);
            bv.a("0X800AF4D");
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.w
    public void e() {
        kc2.a.f412010a.b(this.f256879h, "VAL_FROM_STATUS_SETTING");
        bv.a("0X800AF97");
    }

    @Override // com.tencent.mobileqq.onlinestatus.w
    public void f(boolean z16, OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem) {
        kc2.d.f412021a.a(this.f256880i, 1040);
    }

    @Override // com.tencent.mobileqq.onlinestatus.w
    public void g(int i3, int i16, Intent intent) {
        super.g(i3, i16, intent);
        this.f256510l = ae.a(this.f256880i, intent, this.f256510l).getSecond();
    }

    @Override // com.tencent.mobileqq.onlinestatus.w
    public void h() {
        super.h();
        this.f256880i.unRegistObserver(this.f256509k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.onlinestatus.w
    public void j() {
        this.f256872a = this.f256879h.getString(R.string.f197134j7);
        this.f256875d = false;
        this.f256876e = this.f256879h.getString(R.string.f196964iq);
        if (!TextUtils.isEmpty(this.f256511m)) {
            this.f256873b = this.f256510l + APLogFileUtil.SEPARATOR_LOG + this.f256511m;
            return;
        }
        this.f256873b = this.f256510l;
    }
}
