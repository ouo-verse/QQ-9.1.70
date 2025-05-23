package com.tencent.timi.game.liveroom.impl.room.view.rank;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.liveroom.impl.room.view.rank.base.BaseRankViewAdapter;
import com.tencent.timi.game.sso.request.QQLiveRankConfigRequest;
import com.tencent.timi.game.sso.request.QQLiveRankListRequest;
import d55.j;

/* compiled from: P */
/* loaded from: classes26.dex */
public class RankViewModel {

    /* renamed from: e, reason: collision with root package name */
    private boolean f378835e;

    /* renamed from: g, reason: collision with root package name */
    private int f378837g;

    /* renamed from: h, reason: collision with root package name */
    private a f378838h;

    /* renamed from: a, reason: collision with root package name */
    private j f378831a = null;

    /* renamed from: b, reason: collision with root package name */
    private d55.e f378832b = null;

    /* renamed from: c, reason: collision with root package name */
    private long f378833c = -1;

    /* renamed from: d, reason: collision with root package name */
    private long f378834d = -1;

    /* renamed from: f, reason: collision with root package name */
    private zi4.a<j> f378836f = null;

    /* renamed from: i, reason: collision with root package name */
    private boolean f378839i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f378840j = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f378841k = false;

    /* renamed from: l, reason: collision with root package name */
    private int f378842l = -1;

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f378843m = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.view.rank.RankViewModel.3
        @Override // java.lang.Runnable
        public void run() {
            if (RankViewModel.this.f378836f == null) {
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("RankViewModel", 1, "fetch rankList finish, roomId=" + RankViewModel.this.f378833c);
                return;
            }
            RankViewModel rankViewModel = RankViewModel.this;
            rankViewModel.h(true, rankViewModel.f378836f);
        }
    };

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface a {
        void show(boolean z16);
    }

    @Nullable
    private d55.e f(d55.e eVar) {
        d55.h[] hVarArr;
        int i3;
        if (eVar == null) {
            return null;
        }
        d55.h[] hVarArr2 = eVar.f393068c;
        if (hVarArr2 != null && hVarArr2.length != 0 && !TextUtils.isEmpty(eVar.f393067b)) {
            i3 = eVar.f393068c.length;
            hVarArr = new d55.h[i3 + 1];
        } else {
            hVarArr = new d55.h[1];
            i3 = -1;
        }
        if (i3 > 0 && hVarArr.length > i3) {
            System.arraycopy(eVar.f393068c, 0, hVarArr, 1, i3);
        }
        d55.h hVar = new d55.h();
        hVar.f393081b = BaseRankViewAdapter.INSTANCE.a();
        hVar.f393080a = 0;
        hVarArr[0] = hVar;
        eVar.f393068c = hVarArr;
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(QQLiveResponse qQLiveResponse) {
        if (!qQLiveResponse.isFailed() && qQLiveResponse.getRsp() != null) {
            d55.e f16 = f((d55.e) qQLiveResponse.getRsp());
            this.f378832b = f16;
            if (f16 == null) {
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e("RankViewModel", 1, "fetchRankConfig, error, data is null, roomId=" + this.f378833c);
                return;
            }
            this.f378841k = true;
            return;
        }
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e("RankViewModel", 1, "fetchRankConfig, roomId=" + this.f378833c + " errCode: " + qQLiveResponse.getRetCode() + ", errMsg: " + qQLiveResponse.getErrMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(zi4.a aVar, boolean z16, QQLiveResponse qQLiveResponse) {
        if (!qQLiveResponse.isFailed() && qQLiveResponse.getRsp() != null) {
            j jVar = (j) qQLiveResponse.getRsp();
            this.f378831a = jVar;
            this.f378837g = jVar.f393091d * 1000;
            aVar.success((j) qQLiveResponse.getRsp());
        } else {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w("RankViewModel", "request rank list failed, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
        }
        if (this.f378837g > 0 && z16) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f378843m);
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.f378843m, this.f378837g);
        }
    }

    private void s() {
        boolean z16;
        a aVar = this.f378838h;
        if (aVar != null) {
            if (this.f378839i && this.f378840j) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.show(z16);
        }
    }

    public void e() {
        this.f378836f = null;
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f378843m);
    }

    public void g() {
        if (this.f378833c == -1 || this.f378841k) {
            return;
        }
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e("RankViewModel", 1, "fetchRankConfig roomId=" + this.f378833c);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveRankConfigRequest(this.f378833c), new ILiveNetRequest.Callback() { // from class: com.tencent.timi.game.liveroom.impl.room.view.rank.g
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                RankViewModel.this.q(qQLiveResponse);
            }
        });
    }

    public void h(final boolean z16, final zi4.a<j> aVar) {
        if (aVar == null) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e("RankViewModel", 1, "fetchRankListForDetail ignore, callback is null");
            return;
        }
        if (this.f378833c == -1) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e("RankViewModel", 1, "mRoomId == " + this.f378833c + " anchorId = " + this.f378834d);
            return;
        }
        this.f378836f = aVar;
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("RankViewModel", 1, "fetchRankListForDetail roomId=" + this.f378833c + ", anchorId=" + this.f378834d + ", startInterval=" + z16);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveRankListRequest(this.f378833c, this.f378834d, 10), new ILiveNetRequest.Callback() { // from class: com.tencent.timi.game.liveroom.impl.room.view.rank.h
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                RankViewModel.this.r(aVar, z16, qQLiveResponse);
            }
        });
    }

    public long i() {
        return this.f378834d;
    }

    public d55.e j() {
        return this.f378832b;
    }

    public j k() {
        return this.f378831a;
    }

    public long l() {
        return this.f378833c;
    }

    public boolean m() {
        return this.f378835e;
    }

    public void n(a aVar) {
        boolean z16;
        int i3 = this.f378842l;
        if (i3 >= 0) {
            if (i3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.show(z16);
            return;
        }
        this.f378838h = aVar;
    }

    public boolean o() {
        if (j() != null) {
            return j().f393066a;
        }
        g();
        return true;
    }

    public boolean p() {
        long j3;
        boolean z16;
        LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo(QQLiveBusinessConfig.QQLIVE_APP_ID, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        if (loginInfo != null) {
            j3 = loginInfo.q();
        } else {
            j3 = 0;
        }
        if (i() == j3 && !m()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("RankViewModel", 1, "isSelfLiveRoom, do not update rankList");
        }
        return z16;
    }

    public void t(boolean z16) {
        this.f378835e = z16;
    }

    public void u(long j3) {
        this.f378834d = j3;
    }

    public void w(boolean z16) {
        this.f378840j = z16;
        s();
    }

    public void x(long j3) {
        this.f378833c = j3;
    }

    public void y(boolean z16) {
        if (z16) {
            this.f378842l = 1;
        } else {
            this.f378842l = 0;
        }
    }

    public void v(vi4.a aVar) {
    }
}
