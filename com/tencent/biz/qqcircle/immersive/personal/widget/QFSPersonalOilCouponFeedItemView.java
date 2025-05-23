package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.animation.QCircleAnimationHelper;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

/* loaded from: classes4.dex */
public class QFSPersonalOilCouponFeedItemView extends QCircleBaseWidgetView<com.tencent.biz.qqcircle.immersive.personal.bean.k> {
    private TextView C;
    private TextView D;
    private String E;
    private QQAnimationDrawable F;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f89286d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f89287e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f89288f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f89289h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f89290i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f89291m;

    public QFSPersonalOilCouponFeedItemView(@NonNull Context context) {
        super(context);
        y0(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        QQAnimationDrawable qQAnimationDrawable;
        ImageView imageView = this.f89288f;
        if (imageView != null && (qQAnimationDrawable = this.F) != null) {
            imageView.setBackground(qQAnimationDrawable);
            this.F.setOneShot(true);
            this.F.start();
            QLog.d("QFSPersonalOilCouponFeedItemView", 1, "frame animation start");
        }
    }

    private void B0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        this.D.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(kVar.b().visitorInfo.viewCount.get()));
    }

    private void q0() {
        AnimationDrawableCreateOption.Builder createTimeOut = QCircleAnimationHelper.getDefaultBuilder("https://downv6.qq.com/video_story/qcircle/animation/qfs_personal_oil_coupon_feed_item_mask_anim.zip").setFrameDuration(16).setCreateTimeOut(TTL.MAX_VALUE);
        QLog.d("QFSPersonalOilCouponFeedItemView", 1, "frameAnimation start download!");
        q50.a.a(hashCode(), createTimeOut.build(), r0());
    }

    private AnimationDrawableFactory.CreateResultListener r0() {
        return new AnimationDrawableFactory.CreateResultListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOilCouponFeedItemView.2
            @Override // com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener
            public void onCreateResult(boolean z16, QQAnimationDrawable qQAnimationDrawable) {
                if (z16 && QFSPersonalOilCouponFeedItemView.this.f89288f != null) {
                    QLog.d("QFSPersonalOilCouponFeedItemView", 1, "frameAnimation has downloaded!");
                    QFSPersonalOilCouponFeedItemView.this.F = qQAnimationDrawable;
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOilCouponFeedItemView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QFSPersonalOilCouponFeedItemView.this.A0();
                        }
                    });
                }
            }
        };
    }

    private void s0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        if (!TextUtils.isEmpty(kVar.o())) {
            this.f89289h.setVisibility(8);
            Option targetView = Option.obtain().setUrl(kVar.o()).setTargetView(this.f89289h);
            targetView.setLoadingDrawable(new ColorDrawable(getResources().getColor(R.color.qvideo_skin_color_bg_default)));
            QCircleFeedPicLoader.g().loadImage(targetView);
            return;
        }
        this.f89289h.setVisibility(8);
    }

    private void u0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        if (!TextUtils.isEmpty(this.E)) {
            if (TextUtils.equals(this.E, kVar.a())) {
                QLog.d("QFSPersonalOilCouponFeedItemView", 4, "[initImage] -> url is same ! url = " + this.E);
                return;
            }
            if (TextUtils.equals(QCircleFeedPicLoader.getUniKeyFromUrl(this.E), QCircleFeedPicLoader.getUniKeyFromUrl(kVar.a()))) {
                QLog.d("QFSPersonalOilCouponFeedItemView", 4, "[initImage] -> getUniKeyFromUrl is same ! oldUrl = " + this.E + " newUrl = " + kVar.a());
                return;
            }
            QLog.d("QFSPersonalOilCouponFeedItemView", 4, "[initImage] -> update image ! oldUrl = " + this.E + " newUrl = " + kVar.a());
        }
        this.E = kVar.a();
        this.f89287e.setImageDrawable(null);
        post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOilCouponFeedItemView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QFSPersonalOilCouponFeedItemView.this.E != null && QFSPersonalOilCouponFeedItemView.this.f89287e != null) {
                    QLog.d("QFSPersonalOilCouponFeedItemView", 4, "[initImage] -> getMeasuredHeight() = " + QFSPersonalOilCouponFeedItemView.this.getMeasuredHeight() + " getMeasuredWidth() = " + QFSPersonalOilCouponFeedItemView.this.getMeasuredWidth());
                    Option targetView = Option.obtain().setRequestHeight(QFSPersonalOilCouponFeedItemView.this.getMeasuredHeight()).setRequestWidth(QFSPersonalOilCouponFeedItemView.this.getMeasuredWidth()).setUrl(QFSPersonalOilCouponFeedItemView.this.E).setTargetView(QFSPersonalOilCouponFeedItemView.this.f89287e);
                    targetView.setLoadingDrawable(new ColorDrawable(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_skeleton)));
                    QCircleFeedPicLoader.g().loadImage(targetView);
                }
            }
        });
    }

    private void v0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        int i3;
        ImageView imageView = this.f89290i;
        if (kVar.l() == 2) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private void w0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        if (kVar == null) {
            return;
        }
        long j3 = kVar.b().right.ugcRight.rightFlag.get();
        if (j3 != 1 && j3 != 0) {
            if (j3 == 2) {
                this.f89291m.setVisibility(8);
                return;
            }
            return;
        }
        this.f89291m.setVisibility(8);
    }

    private void x0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        int i3;
        ImageView imageView = this.f89286d;
        if (kVar.q()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private void y0(View view) {
        this.f89286d = (ImageView) view.findViewById(R.id.y9q);
        this.f89287e = (ImageView) view.findViewById(R.id.y2y);
        this.f89288f = (ImageView) view.findViewById(R.id.f165926y32);
        this.f89289h = (ImageView) view.findViewById(R.id.y8_);
        this.f89290i = (ImageView) view.findViewById(R.id.y6u);
        this.f89291m = (ImageView) view.findViewById(R.id.f241708e);
        this.D = (TextView) view.findViewById(R.id.f109666gf);
        this.C = (TextView) view.findViewById(R.id.f112656oi);
    }

    private void z0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        this.C.setText(kVar.b().visitorInfo.yesterday_desc.get());
        this.C.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.glk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalOilCouponFeedItemView";
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i3) * 4) / 3, 1073741824));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void bindData(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar, int i3) {
        if (kVar != null && kVar.b() != null) {
            u0(kVar);
            v0(kVar);
            x0(kVar);
            w0(kVar);
            s0(kVar);
            z0(kVar);
            B0(kVar);
            if (!QCircleDeviceInfoUtils.isLowDevice()) {
                q0();
            }
        }
    }
}
