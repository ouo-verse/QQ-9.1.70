package com.qzone.reborn.layer.recommendphoto;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.qzone.reborn.albumx.qzonex.utils.d;
import com.qzone.reborn.qzmoment.view.blur.QZMBlurry;
import com.qzone.util.ar;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.gdtad.util.e;
import com.tencent.gdtad.util.j;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.logic.IAdVideoViewController;
import com.tencent.mobileqq.vas.adv.qzone.logic.IAlbumRecommendAdvController;
import com.tencent.qphone.base.util.QLog;
import fo.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes37.dex */
public class QZoneFeedxAlbumRecommendPage extends FrameLayout {
    private QZoneFeedxLayerUserHomeEntranceView C;
    private QZoneFeedxLayerRecommendTitleView D;
    private IAlbumRecommendAdvController E;
    private IAdVideoViewController F;
    private AlumBasicData G;
    private boolean H;
    private QZoneFeedxLayerRecommendPhotoBean I;
    private com.tencent.mobileqq.vas.adv.qzone.logic.a J;

    /* renamed from: d, reason: collision with root package name */
    private Context f58063d;

    /* renamed from: e, reason: collision with root package name */
    private ScrollView f58064e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f58065f;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f58066h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f58067i;

    /* renamed from: m, reason: collision with root package name */
    private QZoneFeedxLayerRecommendPhotoView f58068m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements IPicLoadStateListener {
        a() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (!loadState.isFinishSuccess()) {
                QZoneFeedxAlbumRecommendPage.this.B(false);
                return;
            }
            if (QZoneFeedxAlbumRecommendPage.this.f58066h == null || QZoneFeedxAlbumRecommendPage.this.f58065f == null || option == null || option.getResultBitMap() == null) {
                return;
            }
            QZoneFeedxAlbumRecommendPage.this.B(true);
            QZMBlurry.d().c().e(10).f(4).c().d(option.getResultBitMap()).a(QZoneFeedxAlbumRecommendPage.this.f58065f);
        }
    }

    /* loaded from: classes37.dex */
    class b implements com.tencent.mobileqq.vas.adv.qzone.logic.a {
        b() {
        }

        @Override // com.tencent.mobileqq.vas.adv.qzone.logic.a
        public void a(String str, String str2) {
            QZoneFeedxAlbumRecommendPage.this.y(str, str2);
        }

        @Override // com.tencent.mobileqq.vas.adv.qzone.logic.a
        public void b(String str, String str2) {
            QZoneFeedxAlbumRecommendPage.this.z(str, str2);
        }
    }

    public QZoneFeedxAlbumRecommendPage(Context context) {
        super(context);
        this.J = new b();
        this.f58063d = context;
    }

    private void A(int i3) {
        QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean = this.I;
        if (qZoneFeedxLayerRecommendPhotoBean == null) {
            return;
        }
        HashMap<String, Object> hashMap = qZoneFeedxLayerRecommendPhotoBean.extraParams;
        if (hashMap != null && !hashMap.isEmpty()) {
            if (i3 == 0) {
                c.j(this, this.I.extraParams, "pg_qz_dynamic_floating_final", true);
                return;
            } else {
                if (i3 == 1) {
                    c.k(this, this.I.extraParams, "pg_qz_dynamic_floating_final", true);
                    return;
                }
                return;
            }
        }
        HashMap hashMap2 = new HashMap();
        QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean2 = this.I;
        int i16 = qZoneFeedxLayerRecommendPhotoBean2.refer;
        if (i16 == 3 || i16 == 4) {
            hashMap2.put("group_uin", Long.valueOf(qZoneFeedxLayerRecommendPhotoBean2.albumOwnerUin));
            hashMap2.put("albumid", this.I.layerAlbumId);
            hashMap2.put("album_name", this.I.layerAlbumName);
            if (i3 == 0) {
                c.j(this, hashMap2, "pg_qz_group_album_endpage", true);
            } else if (i3 == 1) {
                c.k(this, hashMap2, "pg_qz_group_album_endpage", true);
            }
        }
        if (q()) {
            hashMap2.put("come_from", Integer.valueOf(this.I.refer == 1 ? 0 : 1));
            hashMap2.put("albumid", this.I.layerAlbumId);
            hashMap2.put("album_name", this.I.layerAlbumName);
            if (i3 == 0) {
                c.j(this, hashMap2, "pg_qz_dynamic_floating_final", true);
            } else if (i3 == 1) {
                c.k(this, hashMap2, "pg_qz_dynamic_floating_final", true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(boolean z16) {
        ImageView imageView = this.f58065f;
        if (imageView == null || this.f58066h == null) {
            return;
        }
        imageView.setVisibility(z16 ? 0 : 8);
        this.f58066h.setVisibility(z16 ? 0 : 8);
    }

    private void C(boolean z16) {
        QZoneFeedxLayerUserHomeEntranceView qZoneFeedxLayerUserHomeEntranceView = this.C;
        if (qZoneFeedxLayerUserHomeEntranceView == null) {
            return;
        }
        qZoneFeedxLayerUserHomeEntranceView.setVisibility(z16 ? 0 : 8);
    }

    private void j() {
        if (this.f58067i != null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.f58063d);
        this.f58067i = linearLayout;
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f58067i.setOrientation(1);
    }

    private void k() {
        if (this.f58067i != null && this.E == null && this.F == null) {
            IVasQZoneApi iVasQZoneApi = (IVasQZoneApi) QRoute.api(IVasQZoneApi.class);
            this.E = iVasQZoneApi.createAlbumAdvViewController(this.f58063d, this.f58067i);
            IAdVideoViewController createAdVideoViewController = iVasQZoneApi.createAdVideoViewController(this.f58063d);
            this.F = createAdVideoViewController;
            createAdVideoViewController.initStubView(this.f58067i);
            Context context = this.f58063d;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                this.E.setOutActivity(activity);
                this.F.setOutActivity(activity);
            }
            this.f58067i.addView(this.E.getView());
            this.f58067i.addView(this.F.getView());
            this.E.setAdReportEventListener(new WeakReference<>(this.J));
            this.F.setAdReportEventListener(new WeakReference<>(this.J));
        }
    }

    private void l(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean) {
        if (this.f58067i == null) {
            return;
        }
        QZoneFeedxLayerRecommendPhotoView qZoneFeedxLayerRecommendPhotoView = new QZoneFeedxLayerRecommendPhotoView(this.f58063d);
        this.f58068m = qZoneFeedxLayerRecommendPhotoView;
        qZoneFeedxLayerRecommendPhotoView.setData(qZoneFeedxLayerRecommendPhotoBean);
        this.f58067i.addView(this.f58068m);
    }

    private void m(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean) {
        if (this.D != null) {
            return;
        }
        QZoneFeedxLayerRecommendTitleView qZoneFeedxLayerRecommendTitleView = new QZoneFeedxLayerRecommendTitleView(this.f58063d, qZoneFeedxLayerRecommendPhotoBean);
        this.D = qZoneFeedxLayerRecommendTitleView;
        addView(qZoneFeedxLayerRecommendTitleView);
    }

    private void n() {
        if (this.f58064e == null) {
            this.f58064e = new ScrollView(this.f58063d);
        }
        this.f58064e.setVerticalScrollBarEnabled(false);
        this.f58064e.addView(this.f58067i);
        addView(this.f58064e);
    }

    private void o(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean) {
        if (this.f58067i == null || qZoneFeedxLayerRecommendPhotoBean == null || !qZoneFeedxLayerRecommendPhotoBean.isShowUserHomeEntrance) {
            return;
        }
        QZoneFeedxLayerUserHomeEntranceView qZoneFeedxLayerUserHomeEntranceView = new QZoneFeedxLayerUserHomeEntranceView(this.f58063d);
        this.C = qZoneFeedxLayerUserHomeEntranceView;
        qZoneFeedxLayerUserHomeEntranceView.setData(qZoneFeedxLayerRecommendPhotoBean);
        this.f58067i.addView(this.C);
    }

    private boolean p() {
        AlumBasicData alumBasicData = this.G;
        return alumBasicData != null && (alumBasicData.isVideoAdvType() || this.G.isPicAdvType());
    }

    private boolean q() {
        int i3;
        return this.I != null && d.a() && ((i3 = this.I.refer) == 1 || i3 == 2);
    }

    private void r(String str) {
        if (TextUtils.isEmpty(str) || this.f58065f == null) {
            return;
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(str).setRequestWidth(ar.l()).setRequestHeight(ar.k()), new a());
    }

    private void x() {
        QZoneFeedxLayerRecommendPhotoView qZoneFeedxLayerRecommendPhotoView = this.f58068m;
        if (qZoneFeedxLayerRecommendPhotoView == null) {
            return;
        }
        qZoneFeedxLayerRecommendPhotoView.S0();
        this.f58068m.U0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (q()) {
            QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean = this.I;
            if (qZoneFeedxLayerRecommendPhotoBean != null) {
                hashMap.put("come_from", Integer.valueOf(qZoneFeedxLayerRecommendPhotoBean.refer == 1 ? 0 : 1));
                hashMap.put("albumid", this.I.layerAlbumId);
                hashMap.put("album_name", this.I.layerAlbumName);
            }
            str2 = "pg_qz_dynamic_floating_final";
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            hashMap.put("qq_eid", "em_qz_ad_module");
            hashMap.put("qq_pgid", str2);
            hashMap.put("advertising_id", str);
            c.c("qq_clck", hashMap);
            QLog.d("QZoneFeedxAlbumRecommendPage", 2, "reportDtAdClick aid:", str, ",pageId:", str2);
            return;
        }
        QLog.d("QZoneFeedxAlbumRecommendPage", 2, "reportDtAdClick return, aid:", str, ",pageId:", str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (q()) {
            QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean = this.I;
            if (qZoneFeedxLayerRecommendPhotoBean != null) {
                hashMap.put("come_from", Integer.valueOf(qZoneFeedxLayerRecommendPhotoBean.refer == 1 ? 0 : 1));
                hashMap.put("albumid", this.I.layerAlbumId);
                hashMap.put("album_name", this.I.layerAlbumName);
            }
            str2 = "pg_qz_dynamic_floating_final";
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            hashMap.put("qq_eid", "em_qz_ad_module");
            hashMap.put("qq_pgid", str2);
            hashMap.put("advertising_id", str);
            c.c("qq_imp", hashMap);
            QLog.d("QZoneFeedxAlbumRecommendPage", 2, "reportDtAdExpo aid:", str, ",pageId:", str2);
            return;
        }
        QLog.d("QZoneFeedxAlbumRecommendPage", 2, "reportDtAdExpo return, aid:", str, ",pageId:", str2);
    }

    public void f(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean) {
        if (this.f58067i != null) {
            return;
        }
        this.I = qZoneFeedxLayerRecommendPhotoBean;
        i(qZoneFeedxLayerRecommendPhotoBean);
        j();
        l(qZoneFeedxLayerRecommendPhotoBean);
        o(qZoneFeedxLayerRecommendPhotoBean);
        k();
        n();
        m(qZoneFeedxLayerRecommendPhotoBean);
    }

    public void h() {
        if (this.E == null || this.F == null) {
            return;
        }
        C(!this.H);
        this.E.hideAdView();
        this.F.setVideoDataChanged(null, -1);
    }

    public void s() {
        if (this.F == null || this.E == null || !p()) {
            return;
        }
        e.b(j.f109555a.e(), "" + this.G.traceId, Long.valueOf(System.currentTimeMillis()));
        this.F.onResume();
        this.E.onResume();
    }

    public void t() {
        IAdVideoViewController iAdVideoViewController = this.F;
        if (iAdVideoViewController != null) {
            iAdVideoViewController.onDestroy();
        }
        IAlbumRecommendAdvController iAlbumRecommendAdvController = this.E;
        if (iAlbumRecommendAdvController != null) {
            iAlbumRecommendAdvController.onDestroy();
        }
        this.f58063d = null;
    }

    public void u() {
        if (this.F == null || this.E == null || !p()) {
            return;
        }
        this.F.onPause();
        this.E.onPause();
    }

    public void v() {
        A(0);
        x();
    }

    public void w() {
        A(1);
        QZoneFeedxLayerRecommendPhotoView qZoneFeedxLayerRecommendPhotoView = this.f58068m;
        if (qZoneFeedxLayerRecommendPhotoView == null) {
            return;
        }
        qZoneFeedxLayerRecommendPhotoView.T0();
    }

    public QZoneFeedxAlbumRecommendPage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.J = new b();
        this.f58063d = context;
    }

    private void i(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean) {
        if (qZoneFeedxLayerRecommendPhotoBean == null) {
            return;
        }
        ImageView imageView = new ImageView(this.f58063d);
        this.f58065f = imageView;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f58065f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f58065f);
        FrameLayout frameLayout = new FrameLayout(this.f58063d);
        this.f58066h = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f58066h.setBackgroundResource(R.drawable.f153041);
        addView(this.f58066h);
        B(false);
        if (Build.VERSION.SDK_INT <= 25) {
            RFWLog.i("QZoneFeedxAlbumRecommendPage", RFWLog.USR, "sdk version is lower than android 7");
        } else {
            r(qZoneFeedxLayerRecommendPhotoBean.backgroundUrl);
        }
    }

    public void g(AlumBasicData alumBasicData) {
        IAdVideoViewController iAdVideoViewController;
        if (alumBasicData == null) {
            RFWLog.e("QZoneFeedxAlbumRecommendPage", RFWLog.USR, "adv data is null");
            return;
        }
        alumBasicData.isFeedxLayer = true;
        this.G = alumBasicData;
        if (this.E == null || (iAdVideoViewController = this.F) == null || iAdVideoViewController.isAdClosed() || this.E.isAdClosed()) {
            return;
        }
        C(false);
        if (alumBasicData.isPicAdvType()) {
            this.E.initAndRenderData(alumBasicData);
            this.F.setVideoDataChanged(null, -1);
        } else if (alumBasicData.isVideoAdvType()) {
            this.E.hideAdView();
            this.F.setVideoDataChanged(alumBasicData, 103);
        }
    }
}
