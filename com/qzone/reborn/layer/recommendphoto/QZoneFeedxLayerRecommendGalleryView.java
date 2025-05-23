package com.qzone.reborn.layer.recommendphoto;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.component.banner.util.QZoneAvatarLoopAnimationManager;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.util.h;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.reborn.widget.QZoneRoundCorneredLayout;
import com.qzone.util.ar;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import yo.d;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxLayerRecommendGalleryView extends QZoneBaseWidgetView<QZoneFeedxLayerGalleryBean> {
    private static final int S = ar.d(160.0f);
    private static final int T = ar.d(32.0f);
    private static final int U = ar.d(36.0f);
    private QZoneUserAvatarView C;
    private QZoneUserAvatarView D;
    private QZoneRoundCorneredLayout E;
    private QZoneRoundCorneredLayout F;
    private QZoneRoundCorneredLayout G;
    private ImageView H;
    private ImageView I;
    private ImageView J;
    private QZoneAvatarLoopAnimationManager K;
    private FrameLayout L;
    private ImageView M;
    private String N;
    private QZoneFeedxLayerGalleryBean P;
    private boolean Q;
    private View.OnClickListener R;

    /* renamed from: e, reason: collision with root package name */
    private View f58071e;

    /* renamed from: f, reason: collision with root package name */
    private Context f58072f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f58073h;

    /* renamed from: i, reason: collision with root package name */
    private QZoneUserAvatarView f58074i;

    /* renamed from: m, reason: collision with root package name */
    private QZoneUserAvatarView f58075m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (TextUtils.isEmpty(QZoneFeedxLayerRecommendGalleryView.this.N)) {
                RFWLog.e("QZoneFeedxLayerRecommendGalleryView", RFWLog.USR, "string url is empty");
            } else {
                QZoneFeedxLayerRecommendGalleryView qZoneFeedxLayerRecommendGalleryView = QZoneFeedxLayerRecommendGalleryView.this;
                qZoneFeedxLayerRecommendGalleryView.v0(false, qZoneFeedxLayerRecommendGalleryView.P);
                d.d(QZoneFeedxLayerRecommendGalleryView.this.N, QZoneFeedxLayerRecommendGalleryView.this.f58072f, "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QZoneFeedxLayerRecommendGalleryView(Context context) {
        super(context);
        this.R = new a();
        this.f58072f = context;
        y0(this);
    }

    private void B0(boolean z16) {
        FrameLayout frameLayout;
        if (this.M == null || (frameLayout = this.L) == null) {
            return;
        }
        frameLayout.setVisibility(z16 ? 0 : 8);
        this.M.setVisibility(z16 ? 0 : 8);
    }

    private void D0(ArrayList<String> arrayList) {
        ArrayList<QZoneUserAvatarView> w06 = w0(arrayList);
        if (this.K == null) {
            this.K = new QZoneAvatarLoopAnimationManager(w06, arrayList);
        }
        this.K.u(14);
        this.K.v(ThreadManagerV2.getUIHandlerV2());
        this.K.w();
    }

    private int r0() {
        return ((ar.l() - T) - U) / 3;
    }

    private ArrayList<QZoneUserAvatarView> w0(ArrayList<String> arrayList) {
        ArrayList<QZoneUserAvatarView> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() >= 4) {
            A0(this.f58074i, arrayList.get(0));
            A0(this.f58075m, arrayList.get(1));
            A0(this.C, arrayList.get(2));
            A0(this.D, arrayList.get(3));
        }
        arrayList2.add(this.f58074i);
        arrayList2.add(this.f58075m);
        arrayList2.add(this.C);
        arrayList2.add(this.D);
        return arrayList2;
    }

    private void x0() {
        C0(this.E);
        C0(this.F);
        C0(this.G);
    }

    private void z0(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        I0(imageView);
        h.i(this.f58072f, imageView, str, r0(), S);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cfq;
    }

    private void F0(QZoneFeedxLayerGalleryBean qZoneFeedxLayerGalleryBean) {
        if (qZoneFeedxLayerGalleryBean == null) {
            RFWLog.e("QZoneFeedxLayerRecommendGalleryView", RFWLog.USR, "bean is null");
            return;
        }
        ArrayList<String> arrayList = qZoneFeedxLayerGalleryBean.coverUrlList;
        if (arrayList != null && arrayList.size() >= 3) {
            z0(arrayList.get(0), this.H);
            z0(arrayList.get(1), this.I);
            z0(arrayList.get(2), this.J);
            return;
        }
        QLog.d("QZoneFeedxLayerRecommendGalleryView", 1, "item list is size less than 3");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void bindData(QZoneFeedxLayerGalleryBean qZoneFeedxLayerGalleryBean, int i3) {
        if (qZoneFeedxLayerGalleryBean == null) {
            RFWLog.e("QZoneFeedxLayerRecommendGalleryView", RFWLog.USR, "bean is null");
            setVisibility(8);
            return;
        }
        if (getHostActivity() != null && (getHostActivity().isFinishing() || getHostActivity().isDestroyed())) {
            RFWLog.e("QZoneFeedxLayerRecommendGalleryView", RFWLog.USR, "activity is finishing, stop setting data");
            return;
        }
        this.P = qZoneFeedxLayerGalleryBean;
        setVisibility(0);
        G0(qZoneFeedxLayerGalleryBean);
        H0(qZoneFeedxLayerGalleryBean);
        E0(qZoneFeedxLayerGalleryBean);
        F0(qZoneFeedxLayerGalleryBean);
    }

    private void A0(QZoneUserAvatarView qZoneUserAvatarView, String str) {
        if (qZoneUserAvatarView == null || TextUtils.isEmpty(str)) {
            return;
        }
        qZoneUserAvatarView.setUser(Long.parseLong(str));
        qZoneUserAvatarView.setIsShieldJumpToMainPage(true);
        qZoneUserAvatarView.setOnClickListener(this.R);
    }

    private void G0(QZoneFeedxLayerGalleryBean qZoneFeedxLayerGalleryBean) {
        if (qZoneFeedxLayerGalleryBean == null) {
            RFWLog.e("QZoneFeedxLayerRecommendGalleryView", RFWLog.USR, "bean is null");
            return;
        }
        View view = this.f58071e;
        if (view == null) {
            return;
        }
        this.N = qZoneFeedxLayerGalleryBean.jumpUrl;
        view.setOnClickListener(this.R);
    }

    private void H0(QZoneFeedxLayerGalleryBean qZoneFeedxLayerGalleryBean) {
        if (qZoneFeedxLayerGalleryBean == null) {
            RFWLog.e("QZoneFeedxLayerRecommendGalleryView", RFWLog.USR, "bean is null");
            return;
        }
        String str = qZoneFeedxLayerGalleryBean.galleryTitle;
        TextView textView = this.f58073h;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    private void s0(QZoneFeedxLayerGalleryBean qZoneFeedxLayerGalleryBean) {
        if (qZoneFeedxLayerGalleryBean == null || qZoneFeedxLayerGalleryBean.isDataIllegal) {
            return;
        }
        LpReportInfo_pf00064.allReport(1400, 8, 2, String.valueOf(qZoneFeedxLayerGalleryBean.refer), qZoneFeedxLayerGalleryBean.feedIdString);
    }

    private void u0(QZoneFeedxLayerGalleryBean qZoneFeedxLayerGalleryBean) {
        if (qZoneFeedxLayerGalleryBean == null || qZoneFeedxLayerGalleryBean.isDataIllegal || this.Q) {
            return;
        }
        this.Q = true;
        LpReportInfo_pf00064.allReport(1400, 8, 1, String.valueOf(qZoneFeedxLayerGalleryBean.refer), qZoneFeedxLayerGalleryBean.feedIdString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(boolean z16, QZoneFeedxLayerGalleryBean qZoneFeedxLayerGalleryBean) {
        if (z16) {
            u0(qZoneFeedxLayerGalleryBean);
        } else {
            s0(qZoneFeedxLayerGalleryBean);
        }
    }

    private void C0(QZoneRoundCorneredLayout qZoneRoundCorneredLayout) {
        if (qZoneRoundCorneredLayout == null) {
            return;
        }
        int i3 = fd.a.f398302a;
        qZoneRoundCorneredLayout.setRadius(i3, i3, i3, i3);
    }

    private void I0(ImageView imageView) {
        ViewGroup.LayoutParams layoutParams;
        if (imageView == null || (layoutParams = imageView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = r0();
        imageView.setLayoutParams(layoutParams);
    }

    public void y0(View view) {
        if (view == null) {
            return;
        }
        this.f58071e = view;
        this.f58073h = (TextView) view.findViewById(R.id.ndm);
        this.f58074i = (QZoneUserAvatarView) view.findViewById(R.id.nc6);
        this.f58075m = (QZoneUserAvatarView) view.findViewById(R.id.nc8);
        this.C = (QZoneUserAvatarView) view.findViewById(R.id.nc_);
        this.D = (QZoneUserAvatarView) view.findViewById(R.id.ncb);
        this.H = (ImageView) view.findViewById(R.id.n_o);
        this.I = (ImageView) view.findViewById(R.id.n_q);
        this.J = (ImageView) view.findViewById(R.id.n_s);
        this.E = (QZoneRoundCorneredLayout) view.findViewById(R.id.n_p);
        this.F = (QZoneRoundCorneredLayout) view.findViewById(R.id.n_r);
        this.G = (QZoneRoundCorneredLayout) view.findViewById(R.id.n_t);
        this.L = (FrameLayout) view.findViewById(R.id.ndi);
        this.M = (ImageView) view.findViewById(R.id.n2m);
        x0();
        setVisibility(8);
    }

    private void E0(QZoneFeedxLayerGalleryBean qZoneFeedxLayerGalleryBean) {
        if (qZoneFeedxLayerGalleryBean == null) {
            RFWLog.e("QZoneFeedxLayerRecommendGalleryView", RFWLog.USR, "bean is null");
            return;
        }
        ArrayList<String> arrayList = qZoneFeedxLayerGalleryBean.userList;
        if (arrayList.size() < 3) {
            B0(false);
            return;
        }
        if (arrayList.size() == 3) {
            A0(this.f58074i, arrayList.get(0));
            A0(this.f58075m, arrayList.get(1));
            A0(this.C, arrayList.get(2));
            B0(true);
            return;
        }
        B0(true);
        D0(arrayList);
    }
}
