package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QFSPersonalFeedItemView extends QCircleBaseWidgetView<com.tencent.biz.qqcircle.immersive.personal.bean.k> implements Observer<e30.b> {
    private TextView C;
    private String D;
    private View E;
    private TextView F;
    private TextView G;
    private View H;
    private Option I;
    private e30.b J;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f89255d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f89256e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f89257f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f89258h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f89259i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f89260m;

    public QFSPersonalFeedItemView(@NonNull Context context) {
        super(context);
        this.I = null;
        u0(this);
    }

    private void A0() {
        if (!q50.b.e().h() || this.I == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QFSPersonalFeedItemView", 2, "[updateLowDevicePicture] load image url cache key: " + this.I.getCacheKey());
        }
        QCircleFeedPicLoader.g().loadImage(this.I);
    }

    private void B0() {
        ImageView imageView = this.f89255d;
        if (imageView != null && this.f89259i != null && this.f89260m != null && this.H != null) {
            if (imageView.getVisibility() != 0 && this.f89259i.getVisibility() != 0 && this.f89260m.getVisibility() != 0) {
                this.H.setBackground(null);
            } else {
                this.H.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.kky, null));
            }
        }
    }

    private boolean C0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        if (kVar == null) {
            QLog.i(getLogTag(), 1, "useVisitorCountUpdateCount feedInfo is null");
            return false;
        }
        if (!com.tencent.biz.qqcircle.immersive.utils.r.v0(kVar.n())) {
            return false;
        }
        if (kVar.p() != 20101 && kVar.p() != 20105 && kVar.p() != 20112) {
            return false;
        }
        return true;
    }

    private Drawable m0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int i3;
        if (feedCloudMeta$StFeed == null) {
            return null;
        }
        cq cqVar = cq.f92752a;
        if (cqVar.s(feedCloudMeta$StFeed)) {
            if (!QCirclePluginUtil.isFeedOwner(feedCloudMeta$StFeed) || (i3 = cqVar.i(feedCloudMeta$StFeed)) == 1) {
                return null;
            }
            return cqVar.m(getContext(), i3);
        }
        if (feedCloudMeta$StFeed.right.ugcRight.rightFlag.get() != 2) {
            return null;
        }
        return QCircleSkinHelper.getInstance().getDrawable(getContext(), R.drawable.osp);
    }

    private void n0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        this.G.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(kVar.b().countinfo.barragecount.get()));
        this.E.setVisibility(8);
    }

    private void o0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        int i3;
        boolean v06 = com.tencent.biz.qqcircle.immersive.utils.r.v0(kVar.n());
        ImageView imageView = this.f89257f;
        QCircleSkinHelper qCircleSkinHelper = QCircleSkinHelper.getInstance();
        if (v06 && (kVar.p() == 20101 || kVar.p() == 20105 || kVar.p() == 20112)) {
            i3 = R.drawable.oqr;
        } else {
            i3 = R.drawable.orj;
        }
        imageView.setImageDrawable(qCircleSkinHelper.getDrawable(i3));
        this.f89257f.setVisibility(8);
        if (v06 && !TextUtils.isEmpty(kVar.o())) {
            this.f89258h.setVisibility(8);
            Option targetView = Option.obtain().setUrl(kVar.o()).setTargetView(this.f89258h);
            targetView.setLoadingDrawable(new ColorDrawable(getResources().getColor(R.color.qvideo_skin_color_bg_default)));
            QCircleFeedPicLoader.g().loadImage(targetView);
            return;
        }
        this.f89258h.setVisibility(8);
    }

    private void p0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        if (!TextUtils.isEmpty(this.D) && (TextUtils.equals(this.D, kVar.a()) || TextUtils.equals(QCircleFeedPicLoader.getUniKeyFromUrl(this.D), QCircleFeedPicLoader.getUniKeyFromUrl(kVar.a())))) {
            return;
        }
        this.D = kVar.a();
        this.f89256e.setImageDrawable(null);
        post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.n
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalFeedItemView.this.w0();
            }
        });
    }

    private void q0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        int i3;
        ImageView imageView = this.f89259i;
        if (kVar.l() == 2) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private void r0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        if (kVar == null) {
            return;
        }
        Drawable m06 = m0(kVar.b());
        if (m06 == null) {
            this.f89260m.setVisibility(8);
            if (this.f89259i.getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f89259i.getLayoutParams();
                layoutParams.rightMargin = 0;
                this.f89259i.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.f89260m.setVisibility(8);
        this.f89260m.setImageDrawable(m06);
        if (this.f89259i.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f89259i.getLayoutParams();
            layoutParams2.rightMargin = cx.a(20.0f);
            this.f89259i.setLayoutParams(layoutParams2);
        }
    }

    private void s0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        int i3;
        ImageView imageView = this.f89255d;
        if (kVar.q()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private void u0(View view) {
        this.f89255d = (ImageView) view.findViewById(R.id.y9q);
        this.f89256e = (ImageView) view.findViewById(R.id.lnn);
        this.f89257f = (ImageView) view.findViewById(R.id.y56);
        this.f89258h = (ImageView) view.findViewById(R.id.y8_);
        this.f89259i = (ImageView) view.findViewById(R.id.y6u);
        this.f89260m = (ImageView) view.findViewById(R.id.f241708e);
        this.C = (TextView) view.findViewById(R.id.f109666gf);
        this.E = view.findViewById(R.id.t4p);
        this.G = (TextView) view.findViewById(R.id.t4o);
        this.F = (TextView) view.findViewById(R.id.f112656oi);
        this.H = view.findViewById(R.id.f241808f);
    }

    private void v0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        this.F.setText(kVar.b().visitorInfo.yesterday_desc.get());
        this.F.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0() {
        if (this.D != null && this.f89256e != null) {
            Option targetView = Option.obtain().setUrl(this.D).setTargetView(this.f89256e);
            this.I = targetView;
            targetView.setSupportRecycler(true);
            q50.b.e().q(this.I, false);
            this.I.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
            this.I.setLoadingDrawableColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_skeleton));
            QCircleFeedPicLoader.g().loadImage(this.I, null);
        }
    }

    private void y0() {
        if (!q50.b.e().h() || this.I == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QFSPersonalFeedItemView", 2, "[releaseLowDevicePicture] load image url cache key: " + this.I.getCacheKey());
        }
        q50.b.e().b(this.I);
    }

    private void z0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        String f16;
        if (C0(kVar)) {
            f16 = com.tencent.biz.qqcircle.immersive.utils.r.f(kVar.b().visitorInfo.viewCount.get());
        } else {
            f16 = com.tencent.biz.qqcircle.immersive.utils.r.f(kVar.b().likeInfo.count.get());
        }
        this.C.setText(f16);
        this.C.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gll;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalFeedItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar, int i3) {
        if (kVar != null && kVar.b() != null) {
            p0(kVar);
            q0(kVar);
            s0(kVar);
            r0(kVar);
            o0(kVar);
            n0(kVar);
            v0(kVar);
            z0(kVar);
            B0();
            this.J = new e30.b(kVar.b());
            w20.a.j().observerGlobalState(this.J, this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        A0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y0();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i3) * 4) / 3, 1073741824));
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        if (bVar != null && bVar.g() != null && this.C != null && getData() != null && C0(getData())) {
            this.C.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(bVar.g().visitorInfo.viewCount.get()));
        }
    }
}
