package cd;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.business.qboss.QbossAdvDesc;
import com.qzone.common.account.LoginData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.VasQzoneYellowThread;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.AnimateUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b<\u0010=J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\rR\u0018\u0010)\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010!R\u0018\u0010+\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010$R\u0018\u0010-\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u001dR\u0018\u0010/\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u001dR\u0018\u00101\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\u001dR\u0018\u00103\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u001dR\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006>"}, d2 = {"Lcd/i;", "", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "g", "f", "e", "Lcom/qzone/business/qboss/QbossAdvDesc;", "commentQbossAdvDesc", "pictureViewerQbossAdvDesc", "i", "a", "Landroid/view/ViewGroup;", "mRootView", "", "b", "Z", "mShowBarrageEffectBtn", "", "c", "Ljava/lang/String;", "mGuideImageViewJumpUrl", "d", "mIsQun", "Lcom/qzone/business/qboss/QbossAdvDesc;", "mCommentQbossAdvDesc", "mPictureViewerCommentQbossAdvDesc", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mGuideImageView", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", tl.h.F, "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "mPrivateCheckBox", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mPrivateTextView", "j", "mPrivateAreaGuide", "k", "mPrivateIconGuide", "l", "mPrivateTextGuide", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mFontIconGuide", DomainData.DOMAIN_NAME, "mViewBarrageEffectGuide", "o", "mViewFontBtn", "p", "mViewBarrageEffectBtn", "Landroid/view/View$OnClickListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View$OnClickListener;", "onClickListenerForGuideTips", "Landroid/view/animation/Animation$AnimationListener;", "r", "Landroid/view/animation/Animation$AnimationListener;", "mGuideOutAnimationListener", "<init>", "(Landroid/view/ViewGroup;ZLjava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup mRootView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean mShowBarrageEffectBtn;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String mGuideImageViewJumpUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean mIsQun;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QbossAdvDesc mCommentQbossAdvDesc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QbossAdvDesc mPictureViewerCommentQbossAdvDesc;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private ImageView mGuideImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QUICheckBox mPrivateCheckBox;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mPrivateTextView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mPrivateAreaGuide;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private QUICheckBox mPrivateIconGuide;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private TextView mPrivateTextGuide;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mFontIconGuide;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private ImageView mViewBarrageEffectGuide;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private ImageView mViewFontBtn;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private ImageView mViewBarrageEffectBtn;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final View.OnClickListener onClickListenerForGuideTips;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final Animation.AnimationListener mGuideOutAnimationListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"cd/i$a", "Lcom/tencent/util/AnimateUtils$AnimationAdapter;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationEnd", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class a extends AnimateUtils.AnimationAdapter {
        a() {
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            i.this.e();
        }
    }

    public i(ViewGroup mRootView, boolean z16, String str) {
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        this.mRootView = mRootView;
        this.mShowBarrageEffectBtn = z16;
        this.mGuideImageViewJumpUrl = str;
        g(mRootView);
        this.onClickListenerForGuideTips = new View.OnClickListener() { // from class: cd.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.h(i.this, view);
            }
        };
        this.mGuideOutAnimationListener = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        ImageView imageView = this.mGuideImageView;
        Intrinsics.checkNotNull(imageView);
        imageView.setVisibility(8);
        if (this.mFontIconGuide != null) {
            ViewGroup viewGroup = this.mPrivateAreaGuide;
            Intrinsics.checkNotNull(viewGroup);
            viewGroup.setVisibility(8);
            ImageView imageView2 = this.mFontIconGuide;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setVisibility(8);
            ImageView imageView3 = this.mViewBarrageEffectGuide;
            Intrinsics.checkNotNull(imageView3);
            imageView3.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!TextUtils.isEmpty(this$0.mGuideImageViewJumpUrl)) {
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
            if (((Integer) tag).intValue() == 0) {
                LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(225, 2, 2), false, false);
            } else {
                Object tag2 = view.getTag();
                Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type kotlin.Int");
                if (((Integer) tag2).intValue() == 1) {
                    LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(225, 2, 4), false, false);
                }
            }
            yo.d.b(this$0.mRootView.getContext(), new yo.g(this$0.mGuideImageViewJumpUrl));
            this$0.mGuideImageViewJumpUrl = null;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mCommentQbossAdvDesc != null) {
            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(225, 1, 2), false, false);
            IQbossReportManager iQbossReportManager = (IQbossReportManager) QRoute.api(IQbossReportManager.class);
            QbossAdvDesc qbossAdvDesc = this$0.mCommentQbossAdvDesc;
            Intrinsics.checkNotNull(qbossAdvDesc);
            iQbossReportManager.reportExpose(qbossAdvDesc.res_traceinfo, LoginData.getInstance().getUinString());
            m5.a.H().C(LoginData.getInstance().getUinString(), 2655);
            this$0.mCommentQbossAdvDesc = null;
            return;
        }
        if (this$0.mPictureViewerCommentQbossAdvDesc != null) {
            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(225, 1, 4), false, false);
            m5.a.H().C(LoginData.getInstance().getUinString(), 2864);
            this$0.mPictureViewerCommentQbossAdvDesc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
    }

    private final void f() {
        int i3;
        if (this.mGuideImageView == null || this.mFontIconGuide == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(280L);
        alphaAnimation.setFillAfter(true);
        ImageView imageView = this.mFontIconGuide;
        Intrinsics.checkNotNull(imageView);
        imageView.startAnimation(alphaAnimation);
        ImageView imageView2 = this.mViewFontBtn;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setVisibility(0);
        if (this.mViewBarrageEffectBtn == null || !this.mShowBarrageEffectBtn) {
            i3 = 0;
        } else {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(280L);
            alphaAnimation2.setStartOffset(80);
            alphaAnimation2.setFillAfter(true);
            ImageView imageView3 = this.mViewBarrageEffectGuide;
            Intrinsics.checkNotNull(imageView3);
            imageView3.startAnimation(alphaAnimation2);
            ImageView imageView4 = this.mViewBarrageEffectBtn;
            Intrinsics.checkNotNull(imageView4);
            imageView4.setVisibility(0);
            i3 = 80;
        }
        int i16 = i3 + 80;
        AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation3.setDuration(280L);
        alphaAnimation3.setStartOffset(i16);
        alphaAnimation3.setFillAfter(true);
        QUICheckBox qUICheckBox = this.mPrivateIconGuide;
        Intrinsics.checkNotNull(qUICheckBox);
        qUICheckBox.startAnimation(alphaAnimation3);
        QUICheckBox qUICheckBox2 = this.mPrivateCheckBox;
        Intrinsics.checkNotNull(qUICheckBox2);
        qUICheckBox2.setVisibility(0);
        AlphaAnimation alphaAnimation4 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation4.setDuration(280L);
        alphaAnimation4.setStartOffset(i16 + 80);
        alphaAnimation4.setFillAfter(true);
        TextView textView = this.mPrivateTextGuide;
        Intrinsics.checkNotNull(textView);
        textView.startAnimation(alphaAnimation4);
        TextView textView2 = this.mPrivateTextView;
        Intrinsics.checkNotNull(textView2);
        textView2.setVisibility(0);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f));
        animationSet.setDuration(280L);
        animationSet.setStartOffset(r1 + 80);
        animationSet.setFillAfter(true);
        ImageView imageView5 = this.mGuideImageView;
        Intrinsics.checkNotNull(imageView5);
        imageView5.startAnimation(animationSet);
        animationSet.setAnimationListener(this.mGuideOutAnimationListener);
        ImageView imageView6 = this.mGuideImageView;
        Intrinsics.checkNotNull(imageView6);
        imageView6.setVisibility(8);
    }

    private final void g(ViewGroup rootView) {
        if (rootView == null) {
            return;
        }
        this.mPrivateCheckBox = (QUICheckBox) rootView.findViewById(R.id.msj);
        this.mPrivateTextView = (TextView) rootView.findViewById(R.id.msl);
        this.mGuideImageView = (ImageView) rootView.findViewById(R.id.msi);
        this.mPrivateAreaGuide = (ViewGroup) rootView.findViewById(R.id.msh);
        this.mPrivateIconGuide = (QUICheckBox) rootView.findViewById(R.id.msk);
        this.mPrivateTextGuide = (TextView) rootView.findViewById(R.id.msm);
        this.mFontIconGuide = (ImageView) rootView.findViewById(R.id.ms5);
        this.mViewBarrageEffectGuide = (ImageView) rootView.findViewById(R.id.mrl);
        this.mViewFontBtn = (ImageView) rootView.findViewById(R.id.f162817ms4);
        this.mViewBarrageEffectBtn = (ImageView) rootView.findViewById(R.id.mry);
    }

    public final void i(QbossAdvDesc commentQbossAdvDesc, QbossAdvDesc pictureViewerQbossAdvDesc) {
        int i3;
        this.mCommentQbossAdvDesc = commentQbossAdvDesc;
        this.mPictureViewerCommentQbossAdvDesc = pictureViewerQbossAdvDesc;
        if (this.mGuideImageView != null) {
            if ((commentQbossAdvDesc == null && pictureViewerQbossAdvDesc == null) || this.mFontIconGuide == null) {
                return;
            }
            ViewGroup viewGroup = this.mPrivateAreaGuide;
            Intrinsics.checkNotNull(viewGroup);
            viewGroup.setVisibility(this.mIsQun ? 8 : 0);
            ImageView imageView = this.mViewFontBtn;
            Intrinsics.checkNotNull(imageView);
            imageView.setVisibility(8);
            ImageView imageView2 = this.mFontIconGuide;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setVisibility(0);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(280L);
            ImageView imageView3 = this.mFontIconGuide;
            Intrinsics.checkNotNull(imageView3);
            imageView3.startAnimation(scaleAnimation);
            ImageView imageView4 = this.mViewBarrageEffectBtn;
            if (imageView4 == null || !this.mShowBarrageEffectBtn) {
                i3 = 80;
            } else {
                Intrinsics.checkNotNull(imageView4);
                imageView4.setVisibility(8);
                ImageView imageView5 = this.mViewBarrageEffectGuide;
                Intrinsics.checkNotNull(imageView5);
                imageView5.setVisibility(0);
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(280L);
                scaleAnimation2.setStartOffset(80);
                ImageView imageView6 = this.mViewBarrageEffectGuide;
                Intrinsics.checkNotNull(imageView6);
                imageView6.startAnimation(scaleAnimation2);
                i3 = 160;
            }
            QUICheckBox qUICheckBox = this.mPrivateCheckBox;
            Intrinsics.checkNotNull(qUICheckBox);
            qUICheckBox.setVisibility(8);
            QUICheckBox qUICheckBox2 = this.mPrivateIconGuide;
            Intrinsics.checkNotNull(qUICheckBox2);
            qUICheckBox2.setVisibility(0);
            ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation3.setDuration(280L);
            scaleAnimation3.setStartOffset(i3);
            QUICheckBox qUICheckBox3 = this.mPrivateIconGuide;
            Intrinsics.checkNotNull(qUICheckBox3);
            qUICheckBox3.startAnimation(scaleAnimation3);
            int i16 = i3 + 80;
            TextView textView = this.mPrivateTextView;
            Intrinsics.checkNotNull(textView);
            textView.setVisibility(8);
            TextView textView2 = this.mPrivateTextGuide;
            Intrinsics.checkNotNull(textView2);
            textView2.setVisibility(0);
            ScaleAnimation scaleAnimation4 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation4.setDuration(280L);
            scaleAnimation4.setStartOffset(i16);
            TextView textView3 = this.mPrivateTextGuide;
            Intrinsics.checkNotNull(textView3);
            textView3.startAnimation(scaleAnimation4);
            int i17 = i16 + 80 + 80;
            ImageView imageView7 = this.mGuideImageView;
            Intrinsics.checkNotNull(imageView7);
            imageView7.setVisibility(0);
            ImageView imageView8 = this.mGuideImageView;
            Intrinsics.checkNotNull(imageView8);
            imageView8.setOnClickListener(LoginData.getInstance().isQzoneVip() ? null : this.onClickListenerForGuideTips);
            ImageView imageView9 = this.mGuideImageView;
            Intrinsics.checkNotNull(imageView9);
            imageView9.setTag(Integer.valueOf(this.mCommentQbossAdvDesc == null ? 1 : 0));
            ImageView imageView10 = this.mGuideImageView;
            Intrinsics.checkNotNull(imageView10);
            imageView10.requestLayout();
            ScaleAnimation scaleAnimation5 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation5.setDuration(280L);
            scaleAnimation5.setStartOffset(i17);
            ImageView imageView11 = this.mGuideImageView;
            Intrinsics.checkNotNull(imageView11);
            imageView11.startAnimation(scaleAnimation5);
            VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: cd.g
                @Override // java.lang.Runnable
                public final void run() {
                    i.j(i.this);
                }
            });
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: cd.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.k(i.this);
                }
            }, 2660L);
        }
    }
}
