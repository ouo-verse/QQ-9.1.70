package com.qzone.reborn.feedx.part.detail;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Observer;
import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.common.activities.base.cb;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.event.EventCenter;
import com.qzone.detail.business.service.QZoneDetailService;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.feed.utils.e;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.event.QZoneFavorStateChangeEvent;
import com.qzone.reborn.feedx.viewmodel.QZoneBlogDetailViewModel;
import com.qzone.reborn.feedx.viewmodel.h;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import n5.d;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aa extends com.qzone.reborn.base.k implements gf.f, h.b, d5.n<BusinessFeedData>, SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    public cb f55148d;

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.h f55149e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f55150f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f55151h = true;

    /* renamed from: i, reason: collision with root package name */
    private boolean f55152i;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements Observer<UIStateData<BusinessFeedData>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<BusinessFeedData> uIStateData) {
            aa.this.X9(uIStateData.getData());
        }
    }

    private void I9(QZoneResult qZoneResult) {
        int i3 = qZoneResult.what;
        if (i3 == 1000106) {
            if (qZoneResult.getSucceed()) {
                ToastUtil.o(R.string.gny, 5);
                this.f55149e.M2(true);
                W9();
                return;
            }
            ToastUtil.o(R.string.gnx, 5);
            return;
        }
        if (i3 == 1000107) {
            if (qZoneResult.getSucceed()) {
                ToastUtil.o(R.string.gd8, 5);
                this.f55149e.M2(false);
                W9();
                return;
            }
            ToastUtil.o(R.string.gd7, 5);
        }
    }

    private void J9() {
        if (this.f55149e.T1() == 7035 || this.f55149e.X1() == null) {
            return;
        }
        QzoneFavoriteService.M().Q(new QzoneFavoriteService.d() { // from class: com.qzone.reborn.feedx.part.detail.x
            @Override // com.qzone.business.favorite.service.QzoneFavoriteService.d
            public final void a(String str, boolean z16) {
                aa.this.Q9(str, z16);
            }
        }, this.f55149e.X1().getFeedCommInfo().ugckey);
    }

    private boolean K9() {
        return this.f55149e.f2() == 0;
    }

    private boolean L9() {
        return 2 == this.f55149e.f2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N9(final BusinessFeedData businessFeedData, final String str, final boolean z16) {
        getHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.part.detail.w
            @Override // java.lang.Runnable
            public final void run() {
                aa.this.M9(z16, businessFeedData, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O9(BusinessAlbumInfo businessAlbumInfo) {
        Intent x16 = ak.x(getActivity(), getActivity().getResources().getString(R.string.gng), 0);
        if (businessAlbumInfo != null) {
            x16.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_DEFAULT_ALBUM_ID, businessAlbumInfo.mAlbumId);
        }
        getActivity().startActivityForResult(x16, QZoneContant.QZ_SELECT_ALBUM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q9(String str, final boolean z16) {
        getActivity().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.part.detail.y
            @Override // java.lang.Runnable
            public final void run() {
                aa.this.P9(z16);
            }
        });
    }

    private void R9(QZoneResult qZoneResult) {
        com.qzone.reborn.feedx.viewmodel.h hVar;
        z5.a f16 = z5.a.f();
        x6.a g16 = (f16 == null || (hVar = this.f55149e) == null) ? null : f16.g(hVar.r2());
        if (qZoneResult.getSucceed()) {
            if (g16 != null) {
                g16.isExcluded = true;
                ToastUtil.s(getString(R.string.gof), 5);
                f16.t(g16);
            }
            com.qzone.reborn.feedx.viewmodel.h hVar2 = this.f55149e;
            if (hVar2 != null && hVar2.X1() != null && this.f55149e.X1().getUser() != null) {
                EventCenter.getInstance().post("Permission", 1, Long.valueOf(this.f55149e.X1().getUser().uin));
            }
            if (getActivity() != null) {
                getActivity().finish();
                return;
            }
            return;
        }
        if (qZoneResult.getMessage() != null && qZoneResult.getMessage().length() > 0) {
            ToastUtil.s(qZoneResult.getMessage(), 4);
        } else if (g16 != null) {
            ToastUtil.o(R.string.f173117hh4, 4);
        }
    }

    private void T9(QZoneResult qZoneResult) {
        if (qZoneResult.getSucceed()) {
            if (getActivity() != null) {
                getActivity().finish();
                return;
            }
            return;
        }
        ToastUtil.o(R.string.gft, 4);
    }

    private void V9() {
        if (this.f55148d != null && this.f55149e.X1() != null) {
            if (!this.f55152i) {
                QZLog.e(getTAG(), 1, "[toggleSharePanel] operation not inited");
                return;
            } else if (this.f55148d.M()) {
                this.f55148d.r();
                return;
            } else {
                this.f55148d.u0(this.f55149e.X1());
                return;
            }
        }
        QZLog.e(getTAG(), 1, "[toggleSharePanel] mShareOpPanel or currentDetailData is null");
    }

    private void W9() {
        if (this.f55148d != null) {
            if (K9() || L9()) {
                this.f55148d.A0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X9(BusinessFeedData businessFeedData) {
        cb cbVar = this.f55148d;
        if (cbVar == null || businessFeedData == null) {
            return;
        }
        cbVar.m0(businessFeedData);
        this.f55148d.n0(Boolean.valueOf(businessFeedData.getFeedCommInfo().isFollowed));
        if (businessFeedData.getFeedCommInfo().operatemask != 0) {
            RFWLog.d("QZoneFeedxDetailSharePanelPart", RFWLog.USR, "updateSharePanel, initMoreAction, " + this + ", feedData: " + businessFeedData);
            this.f55148d.J();
            this.f55148d.j();
            this.f55152i = true;
        }
    }

    @Override // gf.f
    public boolean I1() {
        return false;
    }

    @Override // com.qzone.reborn.feedx.viewmodel.h.b
    public void K6(QZoneResult qZoneResult) {
        switch (qZoneResult.what) {
            case 999984:
                R9(qZoneResult);
                return;
            case 1000028:
                S9(qZoneResult.getSucceed(), qZoneResult.getMessage(), 3585);
                return;
            case 1000029:
                S9(qZoneResult.getSucceed(), qZoneResult.getMessage(), 3586);
                return;
            case 1000083:
                cb cbVar = this.f55148d;
                if (cbVar != null) {
                    cbVar.I(qZoneResult);
                    return;
                }
                return;
            case 1000106:
            case 1000107:
                I9(qZoneResult);
                return;
            case 1000108:
                T9(qZoneResult);
                return;
            default:
                return;
        }
    }

    @Override // d5.n
    public boolean Lc() {
        return true;
    }

    @Override // gf.f
    public String S6() {
        return this.f55149e.e2();
    }

    @Override // gf.f
    public QZoneDetailService T0() {
        return this.f55149e.b2();
    }

    @Override // gf.f
    public void U3() {
        if (this.f55151h) {
            this.f55151h = false;
            getActivity().startActivityForResult(ak.r(getActivity(), "jhan_feedzhiding", getString(R.string.gia), false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip()), 2);
        }
    }

    /* renamed from: U9, reason: merged with bridge method [inline-methods] */
    public void P9(boolean z16) {
        if (QZoneFeedUtil.k(this.f55149e.X1(), 17)) {
            this.f55150f = z16;
            cb cbVar = this.f55148d;
            if (cbVar != null) {
                cbVar.z0();
            }
        }
    }

    @Override // gf.f
    public QZoneDetailService X3() {
        return this.f55149e.b2();
    }

    @Override // gf.f
    public d.g Z4() {
        return new d.g() { // from class: com.qzone.reborn.feedx.part.detail.z
            @Override // n5.d.g
            public final void a(BusinessAlbumInfo businessAlbumInfo) {
                aa.this.O9(businessAlbumInfo);
            }
        };
    }

    @Override // gf.f
    public void a7() {
        broadcastMessage("DELETE_BLOG", null);
    }

    @Override // d5.n
    public void b9(d5.k<BusinessFeedData> kVar) {
        final BusinessFeedData X1 = this.f55149e.X1();
        if (X1 == null) {
            return;
        }
        QzoneFavoriteService.M().Q(new QzoneFavoriteService.d() { // from class: com.qzone.reborn.feedx.part.detail.v
            @Override // com.qzone.business.favorite.service.QzoneFavoriteService.d
            public final void a(String str, boolean z16) {
                aa.this.N9(X1, str, z16);
            }
        }, X1.getFeedCommInfo().ugckey);
    }

    @Override // gf.f
    public int getAppid() {
        return this.f55149e.T1();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneFavorStateChangeEvent.class);
        return arrayList;
    }

    @Override // gf.f
    public String getFeedId() {
        return this.f55149e.d2();
    }

    @Override // gf.f
    public Handler getHandler() {
        return this.f55149e.g2();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxDetailSharePanelPart";
    }

    @Override // gf.f
    public int getRefer() {
        return this.f55149e.f2();
    }

    @Override // gf.f
    public Resources getResources() {
        return getActivity().getResources();
    }

    @Override // gf.f
    public String getString(int i3) {
        return getActivity().getString(i3);
    }

    @Override // gf.f
    public long getUin() {
        return this.f55149e.r2();
    }

    @Override // gf.f
    public TouchWebView getWebView() {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "toggle_share_panel")) {
            V9();
        }
    }

    @Override // gf.f
    public boolean isFavorite() {
        return this.f55150f;
    }

    @Override // gf.f
    public boolean j6() {
        return this.f55149e.v2();
    }

    @Override // gf.f
    public void m1() {
        broadcastMessage("DELETE_FEED", null);
    }

    @Override // gf.f
    public void m7(int i3) {
        QZoneFeedUtil.f0(i3, this.f55149e.X1(), this.f55149e.g2(), this);
    }

    @Override // gf.f
    public void n1(BusinessFeedData businessFeedData) {
        BusinessFeedData X1 = this.f55149e.X1();
        if (X1 != null) {
            QZoneWriteOperationService.v0().i2(getHandler(), X1.getIdInfo().cellId, X1.getFeedCommInfo().ugckey);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (I1()) {
            this.f55149e = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(QZoneBlogDetailViewModel.class);
        } else {
            this.f55149e = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
        }
        this.f55149e.P1(this);
        cb cbVar = new cb(getActivity(), getHandler(), this, "detail");
        this.f55148d = cbVar;
        cbVar.o0(getHostFragment());
        this.f55148d.q0(this.f55149e.C2());
        this.f55148d.p0("pg_qz_dynamic_detail_page");
        this.f55149e.f55901m.observe(getPartHost().getLifecycleOwner(), new a());
        J9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        cb cbVar = this.f55148d;
        if (cbVar != null) {
            cbVar.q();
            this.f55148d = null;
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        cb cbVar = this.f55148d;
        if (cbVar == null || !cbVar.M()) {
            return;
        }
        this.f55148d.r();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneFavorStateChangeEvent) {
            P9(((QZoneFavorStateChangeEvent) simpleBaseEvent).getIsFavor());
        }
    }

    @Override // d5.n
    public void F7() {
        P9(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M9(boolean z16, BusinessFeedData businessFeedData, String str) {
        if (z16) {
            P9(false);
            QzoneFavoriteService.M().I(businessFeedData.getUser().uin, str, businessFeedData.getFeedCommInfo().ugckey, businessFeedData.getFeedCommInfo().appid, businessFeedData.getFeedCommInfo().subid, getHandler());
        }
    }

    private void S9(boolean z16, String str, int i3) {
        if (3585 == i3) {
            QfavHelper.B(getActivity(), String.valueOf(LoginData.getInstance().getUin()), z16, str, false);
            return;
        }
        if (3586 == i3) {
            if (z16) {
                P9(false);
                ToastUtil.o(R.string.gfr, 5);
                return;
            }
            P9(true);
            if (TextUtils.isEmpty(str)) {
                ToastUtil.o(R.string.b3x, 4);
            } else {
                ToastUtil.s(str, 4);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        String stringExtra;
        if (i3 == 2) {
            if (intent == null) {
                stringExtra = "";
            } else {
                stringExtra = intent.getStringExtra("contentIntentKey");
            }
            if (TextUtils.isEmpty(stringExtra)) {
                this.f55151h = true;
            }
        }
    }

    @Override // com.qzone.reborn.feedx.viewmodel.h.b
    public void onHandleMessage(Message message) {
    }

    @Override // gf.f
    public void w9(int i3) {
    }

    @Override // gf.f
    public void x0(e.a aVar, Serializable serializable, Parcelable parcelable, Map<String, Object> map) {
    }
}
