package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildLiteBannerPresenter;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ac extends c implements View.OnClickListener {
    private LinearLayout D;
    private View E;
    private SquareImageView F;
    private TextView G;
    private TextView H;
    private ImageView I;
    private View J;
    private int K;

    public ac(@NonNull com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
    }

    private void A() {
        Drawable drawable;
        if (this.f90602e != null && this.F != null) {
            if (this.K == 8) {
                drawable = j().getResources().getDrawable(R.drawable.f162042oo2);
            } else {
                drawable = j().getResources().getDrawable(R.drawable.f162043oo3);
            }
            String str = this.f90602e.liteBanner.thumbURL.get();
            QLog.d("QFSFeedTakeTheSameStyleView", 4, "[updateLeftIcon] url = " + str);
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestWidth(cx.a(24.0f)).setRequestHeight(cx.a(24.0f)).setLoadingDrawable(drawable).setFailDrawable(drawable).setUrl(str).setTargetView(this.F));
            return;
        }
        QLog.e("QFSFeedTakeTheSameStyleView", 1, "[updateLeftIcon] mFeed == null.");
    }

    private void B() {
        Drawable drawable;
        if (this.I == null) {
            QLog.e("QFSFeedTakeTheSameStyleView", 1, "[updateRightIcon] mRightBtn == null.");
            return;
        }
        if (this.K == 8) {
            drawable = j().getResources().getDrawable(R.drawable.nqf);
        } else {
            drawable = j().getResources().getDrawable(R.drawable.nqg);
        }
        this.I.setImageDrawable(drawable);
    }

    private void C() {
        View view = this.J;
        if (view == null) {
            QLog.e("QFSFeedTakeTheSameStyleView", 1, "[updateRightIconBg] mRightBtnBg == null.");
            return;
        }
        view.setVisibility(8);
        if (com.tencent.biz.qqcircle.immersive.utils.r.G0(this.f90601d)) {
            QLog.d("QFSFeedTakeTheSameStyleView", 1, "[updateRightIconBg] is strengthened");
            this.J.setVisibility(0);
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.J, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setStartDelay(3000L);
        ofFloat.setDuration(250L);
        ofFloat.start();
        ofFloat.addListener(new a());
    }

    private void D() {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && this.G != null && this.H != null) {
            String str2 = feedCloudMeta$StFeed.liteBanner.title.get();
            QLog.d("QFSFeedTakeTheSameStyleView", 2, "[updateText] bannerString = " + str2);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] split = str2.split("\u00b7");
            TextView textView = this.G;
            String str3 = "";
            if (split.length <= 0) {
                str = "";
            } else {
                str = split[0];
            }
            textView.setText(str);
            TextView textView2 = this.H;
            if (split.length > 1) {
                str3 = split[1];
            }
            textView2.setText(str3);
            return;
        }
        QLog.e("QFSFeedTakeTheSameStyleView", 1, "[updateText] mFeed == null.");
    }

    private void u() {
        View view = this.E;
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_SAME_GUIDE_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.f90602e.poster.f398463id.get());
        String str = this.f90602e.liteBanner.jumpUrl.get();
        if (!TextUtils.isEmpty(str)) {
            Map<String, String> p16 = QFSFeedChildLiteBannerPresenter.p1(str);
            if (p16.containsKey("xsj_material_type")) {
                buildElementParams.put("xsj_material_type", p16.get("xsj_material_type"));
            }
            if (p16.containsKey("xsj_material_id")) {
                buildElementParams.put("xsj_material_id", p16.get("xsj_material_id"));
            }
        }
        VideoReport.setElementParams(this.E, buildElementParams);
    }

    private boolean v(int i3) {
        this.K = i3;
        QLog.d("QFSFeedTakeTheSameStyleView", 4, "[isCanShowType] styleType = " + i3);
        if (i3 != 7 && i3 != 8) {
            return false;
        }
        return true;
    }

    private void w() {
        if (this.f90602e == null) {
            return;
        }
        com.tencent.biz.qqcircle.launcher.c.g(j(), this.f90602e.liteBanner.jumpUrl.get());
    }

    private void x(@NonNull View view) {
        View inflate;
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f54722fz);
        this.D = (LinearLayout) view.findViewById(R.id.f34340yw);
        if (viewStub == null || (inflate = viewStub.inflate()) == null) {
            return;
        }
        this.E = inflate.findViewById(R.id.f54692fw);
        this.F = (SquareImageView) inflate.findViewById(R.id.f54682fv);
        this.G = (TextView) inflate.findViewById(R.id.f54672fu);
        this.H = (TextView) inflate.findViewById(R.id.f54662ft);
        this.I = (ImageView) inflate.findViewById(R.id.f54702fx);
        View findViewById = inflate.findViewById(R.id.f54712fy);
        this.J = findViewById;
        findViewById.setVisibility(8);
        this.E.setOnClickListener(this);
    }

    private void y(boolean z16) {
        int i3;
        View view = this.E;
        int i16 = 0;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
        LinearLayout linearLayout = this.D;
        if (linearLayout != null) {
            if (!z16) {
                i16 = 8;
            }
            linearLayout.setVisibility(i16);
        }
    }

    private void z() {
        D();
        A();
        B();
        C();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 107;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(feedCloudMeta$StFeed.liteBanner.title.get()) && v(this.f90602e.liteBanner.style_type.get())) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f54692fw) {
            w();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        x(this.f90604h);
        z();
        y(true);
        u();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        y(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QLog.e("QFSFeedTakeTheSameStyleView", 4, "animatorSet onAnimationCancel");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.e("QFSFeedTakeTheSameStyleView", 4, "animatorSet onAnimationEnd");
            com.tencent.biz.qqcircle.immersive.utils.r.d1(ac.this.f90601d, true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (ac.this.J != null) {
                ac.this.J.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
    }
}
