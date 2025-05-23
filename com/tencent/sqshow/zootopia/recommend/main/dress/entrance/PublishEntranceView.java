package com.tencent.sqshow.zootopia.recommend.main.dress.entrance;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.portal.detail.scrollingheader.ScrollingHeaderLayout;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishApiImpl;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.sqshow.zootopia.utils.AnimViewWrapper;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.i;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.cj;
import tl.h;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001PB'\b\u0007\u0012\u0006\u0010I\u001a\u00020H\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J\u0012\b\b\u0002\u0010L\u001a\u00020\u001a\u00a2\u0006\u0004\bM\u0010NJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0006\u0010\u000b\u001a\u00020\u0003J\"\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001e\u0010(\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0017\u0010%\u0012\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010%R\u0016\u0010*\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001cR\u0016\u0010,\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u001cR\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00106R\u0018\u00109\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00106R$\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00150<j\b\u0012\u0004\u0012\u00020\u0015`=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006Q"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/dress/entrance/PublishEntranceView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/sqshow/zootopia/recommend/main/dress/entrance/a;", "", "k", ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, "j", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "p", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "publishSource", "publishBackScheme", "setSource", "show", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View$OnClickListener;", "l", h.F, "Lcom/tencent/sqshow/zootopia/portal/detail/scrollingheader/ScrollingHeaderLayout$c;", "hide", "", "d", "I", "mState", "Ln74/cj;", "e", "Ln74/cj;", "mBinding", "f", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "mSource", "Ljava/lang/String;", "getMPublishSource$annotations", "()V", "mPublishSource", "mPublishBackScheme", "mNormalSize", BdhLogUtil.LogTag.Tag_Conn, "mSmallSize", "", "D", UserInfo.SEX_FEMALE, "mMaxTransX", "Lcom/tencent/sqshow/zootopia/utils/AnimViewWrapper;", "E", "Lcom/tencent/sqshow/zootopia/utils/AnimViewWrapper;", "mTargetView", "Landroid/animation/ObjectAnimator;", "Landroid/animation/ObjectAnimator;", "mShowTranXAnim", "G", "mHideTranXAnim", "H", "mHideSizeAnim", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mClickListenerPool", "Lcom/tencent/sqshow/zootopia/recommend/main/dress/entrance/PublishEntranceController;", "J", "Lcom/tencent/sqshow/zootopia/recommend/main/dress/entrance/PublishEntranceController;", "mController", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "K", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "mReporter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PublishEntranceView extends FrameLayout implements a {

    /* renamed from: C, reason: from kotlin metadata */
    private int mSmallSize;

    /* renamed from: D, reason: from kotlin metadata */
    private float mMaxTransX;

    /* renamed from: E, reason: from kotlin metadata */
    private AnimViewWrapper mTargetView;

    /* renamed from: F, reason: from kotlin metadata */
    private ObjectAnimator mShowTranXAnim;

    /* renamed from: G, reason: from kotlin metadata */
    private ObjectAnimator mHideTranXAnim;

    /* renamed from: H, reason: from kotlin metadata */
    private ObjectAnimator mHideSizeAnim;

    /* renamed from: I, reason: from kotlin metadata */
    private final HashSet<View.OnClickListener> mClickListenerPool;

    /* renamed from: J, reason: from kotlin metadata */
    private final PublishEntranceController mController;

    /* renamed from: K, reason: from kotlin metadata */
    private final ZplanViewReportHelper mReporter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final cj mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ZootopiaSource mSource;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String mPublishSource;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String mPublishBackScheme;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mNormalSize;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/dress/entrance/PublishEntranceView$b", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends oc4.a {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            PublishEntranceView.this.mState = 2;
            PublishEntranceView.this.q();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/dress/entrance/PublishEntranceView$c", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends oc4.a {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            PublishEntranceView.this.mState = 3;
            PublishEntranceView.this.r();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PublishEntranceView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PublishEntranceView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mClickListenerPool.isEmpty()) {
            ZplanViewReportHelper zplanViewReportHelper = this$0.mReporter;
            ImageView imageView = this$0.mBinding.f419024b;
            Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.publishIconIgv");
            ZplanViewReportHelper.f(zplanViewReportHelper, imageView, "em_zplan_publisher_entrance", null, 4, null);
            this$0.p();
            return;
        }
        Iterator<T> it = this$0.mClickListenerPool.iterator();
        while (it.hasNext()) {
            ((View.OnClickListener) it.next()).onClick(view);
        }
    }

    private final void i() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTargetView.getRView(), "translationX", 0.0f, this.mMaxTransX);
        animatorSet.play(ofFloat);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.mTargetView, "size", this.mNormalSize, this.mSmallSize);
        animatorSet.play(ofInt);
        animatorSet.setDuration(100L);
        animatorSet.setInterpolator(new com.tencent.sqshow.zootopia.utils.ui.e());
        animatorSet.addListener(new b());
        animatorSet.start();
        this.mHideTranXAnim = ofFloat;
        this.mHideSizeAnim = ofInt;
    }

    private final void j() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTargetView.getRView(), "translationX", this.mMaxTransX, 0.0f);
        ofFloat.setInterpolator(new com.tencent.sqshow.zootopia.utils.ui.c());
        ofFloat.setDuration(270L);
        ofFloat.addListener(new c());
        this.mShowTranXAnim = ofFloat;
        ofFloat.start();
    }

    private final void k() {
        ObjectAnimator objectAnimator = this.mHideSizeAnim;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.mHideTranXAnim;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        ObjectAnimator objectAnimator3 = this.mShowTranXAnim;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
    }

    private final void n() {
        r();
        post(new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.main.dress.entrance.f
            @Override // java.lang.Runnable
            public final void run() {
                PublishEntranceView.o(PublishEntranceView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(PublishEntranceView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        this.mTargetView.getRView().setTranslationX(this.mMaxTransX);
        this.mTargetView.setWidth(this.mNormalSize);
        this.mTargetView.setHeight(this.mNormalSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        this.mTargetView.getRView().setTranslationX(0.0f);
        this.mTargetView.setWidth(this.mNormalSize);
        this.mTargetView.setHeight(this.mNormalSize);
        ZplanViewReportHelper zplanViewReportHelper = this.mReporter;
        ImageView imageView = this.mBinding.f419024b;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.publishIconIgv");
        ZplanViewReportHelper.h(zplanViewReportHelper, imageView, "em_zplan_publisher_entrance", null, false, null, false, 60, null);
    }

    private final void s() {
        q();
        post(new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.main.dress.entrance.e
            @Override // java.lang.Runnable
            public final void run() {
                PublishEntranceView.t(PublishEntranceView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(PublishEntranceView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j();
    }

    public void h(View.OnClickListener l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mClickListenerPool.add(l3);
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.dress.entrance.a
    public void hide() {
        int i3 = this.mState;
        if (i3 == 0 || i3 == 2 || i3 == 1) {
            return;
        }
        QLog.i("PublishEntranceView_", 1, "hide(). mState: " + i3);
        k();
        this.mState = 0;
        n();
    }

    public ScrollingHeaderLayout.c l() {
        return this.mController.getMAppLayoutScrollListener();
    }

    public RecyclerView.OnScrollListener m() {
        return this.mController.g();
    }

    public final void p() {
        Context ctx = getContext();
        if (ctx == null) {
            ctx = BaseApplication.context;
        }
        ZPlanPublishApiImpl zPlanPublishApiImpl = ZPlanPublishApiImpl.f372397a;
        Intrinsics.checkNotNullExpressionValue(ctx, "ctx");
        ZootopiaSource zootopiaSource = this.mSource;
        String str = this.mPublishSource;
        if (str == null) {
            str = ZPlanPublishSource.FROM_DRESS_SQUARE_TITLE;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.mPublishBackScheme)) {
            bundle.putString("zplan_publish_back_scheme", this.mPublishBackScheme);
        }
        Unit unit = Unit.INSTANCE;
        zPlanPublishApiImpl.a(ctx, zootopiaSource, str, bundle);
    }

    public void setSource(ZootopiaSource source, String publishSource, String publishBackScheme) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(publishSource, "publishSource");
        this.mSource = source;
        this.mPublishSource = publishSource;
        this.mPublishBackScheme = publishBackScheme;
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.dress.entrance.a
    public void show() {
        QLog.i("PublishEntranceView_", 1, "show mState:" + this.mState);
        int i3 = this.mState;
        if (i3 != 1 && i3 != 3 && i3 != 1) {
            k();
            this.mState = 1;
            s();
            return;
        }
        QLog.w("PublishEntranceView_", 1, "show state is ANIMATING or SHOW, give up!");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PublishEntranceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PublishEntranceView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishEntranceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mState = 2;
        cj f16 = cj.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.mSource = ZootopiaSource.INSTANCE.g();
        this.mNormalSize = i.b(63);
        this.mSmallSize = i.b(1);
        this.mMaxTransX = this.mNormalSize + i.d(14.5f);
        this.mClickListenerPool = new HashSet<>();
        this.mController = new PublishEntranceController(this);
        this.mReporter = new ZplanViewReportHelper();
        setClipChildren(false);
        ImageView imageView = f16.f419024b;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.publishIconIgv");
        aa.d(imageView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.recommend.main.dress.entrance.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublishEntranceView.d(PublishEntranceView.this, view);
            }
        });
        ImageView imageView2 = f16.f419024b;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.publishIconIgv");
        this.mTargetView = new AnimViewWrapper(imageView2);
        q();
    }
}
