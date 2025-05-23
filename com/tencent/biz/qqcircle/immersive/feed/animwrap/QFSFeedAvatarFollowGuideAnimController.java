package com.tencent.biz.qqcircle.immersive.feed.animwrap;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAvatarFollowGuideAnimController;
import com.tencent.biz.qqcircle.immersive.repository.QFSFeedFollowGuideAnimRepository;
import com.tencent.biz.qqcircle.immersive.views.QFSPlusFollowView;
import com.tencent.biz.qqcircle.widgets.QCircleMarqueeTextView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StGuideInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0002&)B?\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010.\u001a\u00020\u0002\u0012\u0006\u00100\u001a\u00020\u0002\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u00108\u001a\u000205\u00a2\u0006\u0004\b]\u0010^J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0016\u0010\u0012\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0002J\u0016\u0010\u0013\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u0007J\u0016\u0010 \u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000bJ\u000e\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!J\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020\u0007R\u0014\u0010(\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0014\u0010,\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010'R\u0014\u0010.\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010'R\u0014\u00100\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010'R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010'R\u0018\u0010;\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010'R\u0018\u0010=\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010'R\u0018\u0010?\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010'R\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010\u001f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010\u0006\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010\u0019R\u0016\u0010G\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010AR\u0016\u0010I\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010\u0011R\u0016\u0010J\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010CR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR$\u0010Y\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0018\u0010\\\u001a\u00020!*\u00020Z8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bH\u0010[\u00a8\u0006_"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/animwrap/QFSFeedAvatarFollowGuideAnimController;", "", "Landroid/view/View;", "avatarGuideAnimLayout", "", "postName", "fansCount", "", "t", "P", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Lkotlin/Function0;", "onAnimationEnd", "L", "startByFollowed", "I", "G", "E", "D", BdhLogUtil.LogTag.Tag_Conn, "O", "N", "K", "J", "Lfeedcloud/FeedCloudMeta$StFeed;", "stFeed", "v", HippyTKDListViewAdapter.X, "posterId", "isFollowed", "y", "", "progressMills", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "a", "Landroid/view/View;", "avatarView", "b", "avatarStrokeView", "c", "avatarDecorateView", "d", "liveAnimView", "e", "circleAnimView", "Lcom/tencent/biz/qqcircle/immersive/views/QFSPlusFollowView;", "f", "Lcom/tencent/biz/qqcircle/immersive/views/QFSPlusFollowView;", "followView", "Landroid/view/ViewStub;", "g", "Landroid/view/ViewStub;", "avatarGuideAnimLayoutViewStub", tl.h.F, "i", "bgView", "j", "nameView", "k", "fansView", "l", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "", DomainData.DOMAIN_NAME, "o", "posterName", "p", "displayTimeSecond", "hasPlayAnim", "Ljava/lang/Runnable;", "r", "Ljava/lang/Runnable;", "collapseAnimatorRunnable", "Lcom/tencent/biz/qqcircle/widgets/QFSFollowView$e;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/biz/qqcircle/widgets/QFSFollowView$e;", "followViewClickListener", "Lcom/tencent/biz/qqcircle/immersive/feed/animwrap/QFSFeedAvatarFollowGuideAnimController$b;", "Lcom/tencent/biz/qqcircle/immersive/feed/animwrap/QFSFeedAvatarFollowGuideAnimController$b;", "getReportListener", "()Lcom/tencent/biz/qqcircle/immersive/feed/animwrap/QFSFeedAvatarFollowGuideAnimController$b;", "B", "(Lcom/tencent/biz/qqcircle/immersive/feed/animwrap/QFSFeedAvatarFollowGuideAnimController$b;)V", "reportListener", "", "(F)I", "dp", "<init>", "(Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Lcom/tencent/biz/qqcircle/immersive/views/QFSPlusFollowView;Landroid/view/ViewStub;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSFeedAvatarFollowGuideAnimController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View avatarView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View avatarStrokeView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View avatarDecorateView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View liveAnimView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View circleAnimView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QFSPlusFollowView followView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewStub avatarGuideAnimLayoutViewStub;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View avatarGuideAnimLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View bgView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View nameView;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View fansView;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String posterId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isFollowed;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long fansCount;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String posterName;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int displayTimeSecond;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean hasPlayAnim;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable collapseAnimatorRunnable;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QFSFollowView.e followViewClickListener;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b reportListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/animwrap/QFSFeedAvatarFollowGuideAnimController$b;", "", "", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void b();
    }

    public QFSFeedAvatarFollowGuideAnimController(@NotNull View avatarView, @NotNull View avatarStrokeView, @NotNull View avatarDecorateView, @NotNull View liveAnimView, @NotNull View circleAnimView, @NotNull QFSPlusFollowView followView, @NotNull ViewStub avatarGuideAnimLayoutViewStub) {
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        Intrinsics.checkNotNullParameter(avatarStrokeView, "avatarStrokeView");
        Intrinsics.checkNotNullParameter(avatarDecorateView, "avatarDecorateView");
        Intrinsics.checkNotNullParameter(liveAnimView, "liveAnimView");
        Intrinsics.checkNotNullParameter(circleAnimView, "circleAnimView");
        Intrinsics.checkNotNullParameter(followView, "followView");
        Intrinsics.checkNotNullParameter(avatarGuideAnimLayoutViewStub, "avatarGuideAnimLayoutViewStub");
        this.avatarView = avatarView;
        this.avatarStrokeView = avatarStrokeView;
        this.avatarDecorateView = avatarDecorateView;
        this.liveAnimView = liveAnimView;
        this.circleAnimView = circleAnimView;
        this.followView = followView;
        this.avatarGuideAnimLayoutViewStub = avatarGuideAnimLayoutViewStub;
        this.posterId = "";
        this.posterName = "";
        this.displayTimeSecond = -1;
        this.collapseAnimatorRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.o
            @Override // java.lang.Runnable
            public final void run() {
                QFSFeedAvatarFollowGuideAnimController.n(QFSFeedAvatarFollowGuideAnimController.this);
            }
        };
        this.followViewClickListener = new QFSFollowView.e() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.p
            @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.e
            public final void beforeClick() {
                QFSFeedAvatarFollowGuideAnimController.o(QFSFeedAvatarFollowGuideAnimController.this);
            }
        };
    }

    private final void C() {
        boolean z16;
        int p16;
        if (this.liveAnimView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            p16 = p(112.0f);
        } else {
            p16 = p(118.0f);
        }
        float f16 = -p16;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.avatarView, "translationX", f16, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.avatarStrokeView, "translationX", f16, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.avatarDecorateView, "translationX", f16, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.liveAnimView, "translationX", f16, 0.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.circleAnimView, "translationX", f16, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5);
        animatorSet.setDuration(400L);
        animatorSet.start();
    }

    private final void D() {
        boolean z16;
        int p16;
        if (this.liveAnimView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            p16 = p(112.0f);
        } else {
            p16 = p(118.0f);
        }
        float f16 = -p16;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.avatarView, "translationX", 0.0f, f16);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.avatarStrokeView, "translationX", 0.0f, f16);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.avatarDecorateView, "translationX", 0.0f, f16);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.liveAnimView, "translationX", 0.0f, f16);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.circleAnimView, "translationX", 0.0f, f16);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5);
        animatorSet.setDuration(600L);
        animatorSet.start();
    }

    private final void E(Function0<Unit> onAnimationEnd) {
        final View view = this.bgView;
        if (view == null) {
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(p(176.0f), p(58.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.r
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSFeedAvatarFollowGuideAnimController.F(view, valueAnimator);
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofInt, ofFloat);
        animatorSet.setDuration(400L);
        animatorSet.addListener(new c(onAnimationEnd));
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(View localBgView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(localBgView, "$localBgView");
        ViewGroup.LayoutParams layoutParams = localBgView.getLayoutParams();
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.width = ((Integer) animatedValue).intValue();
        localBgView.requestLayout();
    }

    private final void G(Function0<Unit> onAnimationEnd) {
        final View view = this.bgView;
        if (view == null) {
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(p(58.0f), p(176.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.u
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSFeedAvatarFollowGuideAnimController.H(view, valueAnimator);
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofInt, ofFloat);
        animatorSet.setDuration(600L);
        animatorSet.addListener(new d(onAnimationEnd));
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(View localBgView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(localBgView, "$localBgView");
        ViewGroup.LayoutParams layoutParams = localBgView.getLayoutParams();
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.width = ((Integer) animatedValue).intValue();
        localBgView.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(boolean startByFollowed) {
        E(new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAvatarFollowGuideAnimController$startCollapseAnimation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QFSFeedAvatarFollowGuideAnimController.this.A();
            }
        });
        C();
        J();
        if (!startByFollowed) {
            N();
        }
    }

    private final void J() {
        View view = this.nameView;
        View view2 = this.fansView;
        if (view != null && view2 != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.setDuration(200L);
            animatorSet.start();
        }
    }

    private final void K() {
        View view = this.nameView;
        View view2 = this.fansView;
        if (view != null && view2 != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.setDuration(200L);
            animatorSet.setStartDelay(400L);
            animatorSet.addListener(new e(view, view2));
            animatorSet.start();
        }
    }

    private final void L(final View avatarGuideAnimLayout, final Function0<Unit> onAnimationEnd) {
        q(avatarGuideAnimLayout);
        avatarGuideAnimLayout.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.q
            @Override // java.lang.Runnable
            public final void run() {
                QFSFeedAvatarFollowGuideAnimController.M(QFSFeedAvatarFollowGuideAnimController.this, avatarGuideAnimLayout, onAnimationEnd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(QFSFeedAvatarFollowGuideAnimController this$0, View avatarGuideAnimLayout, Function0 onAnimationEnd) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(avatarGuideAnimLayout, "$avatarGuideAnimLayout");
        Intrinsics.checkNotNullParameter(onAnimationEnd, "$onAnimationEnd");
        if (this$0.u(avatarGuideAnimLayout)) {
            this$0.G(onAnimationEnd);
            this$0.D();
            this$0.K();
            this$0.O();
        }
    }

    private final void N() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.followView, "translationY", -p(24.0f), 0.0f);
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(100L);
        ofFloat.start();
    }

    private final void O() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.followView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.05f);
        ofFloat.setRepeatCount(5);
        ofFloat.setRepeatMode(2);
        ofFloat.setDuration(500L);
        ofFloat.setStartDelay(500L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.followView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.05f);
        ofFloat2.setRepeatCount(5);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(500L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.followView, "translationY", 0.0f, -p(24.0f));
        ofFloat3.setDuration(400L);
        ofFloat3.setStartDelay(100L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.start();
    }

    private final void P(View avatarGuideAnimLayout) {
        L(avatarGuideAnimLayout, new QFSFeedAvatarFollowGuideAnimController$startFollowGuideAnimation$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(QFSFeedAvatarFollowGuideAnimController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(QFSFeedAvatarFollowGuideAnimController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.avatarGuideAnimLayout != null) {
            b bVar = this$0.reportListener;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        QLog.e("QFSFeedAvatarGuideAnimController", 1, "followViewClickListener onClick, avatarGuideAnimLayout = null");
    }

    private final int p(float f16) {
        return DisplayUtil.dip2px(QCircleServiceImpl.getAppRunTime().getApplicationContext(), f16);
    }

    private final void q(View avatarGuideAnimLayout) {
        avatarGuideAnimLayout.setVisibility(4);
        View findViewById = avatarGuideAnimLayout.findViewById(R.id.vcp);
        findViewById.setAlpha(0.0f);
        findViewById.getLayoutParams().width = p(58.0f);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSFeedAvatarFollowGuideAnimController.r(QFSFeedAvatarFollowGuideAnimController.this, view);
            }
        });
        this.bgView = findViewById;
        avatarGuideAnimLayout.findViewById(R.id.vco).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSFeedAvatarFollowGuideAnimController.s(QFSFeedAvatarFollowGuideAnimController.this, view);
            }
        });
        String string = avatarGuideAnimLayout.getContext().getString(R.string.f188343wf, com.tencent.biz.qqcircle.immersive.utils.r.f(this.fansCount));
        Intrinsics.checkNotNullExpressionValue(string, "avatarGuideAnimLayout.co\u2026nfer(fansCount)\n        )");
        t(avatarGuideAnimLayout, this.posterName, string);
        ViewGroup.LayoutParams layoutParams = avatarGuideAnimLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).bottomMargin = 0;
        avatarGuideAnimLayout.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(QFSFeedAvatarFollowGuideAnimController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.avatarView.performClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(QFSFeedAvatarFollowGuideAnimController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.followView.performClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t(View avatarGuideAnimLayout, String postName, String fansCount) {
        int p16 = p(60.0f);
        TextView initContentView$lambda$4 = (TextView) avatarGuideAnimLayout.findViewById(R.id.f166376zm1);
        QCircleMarqueeTextView marqueeNameView = (QCircleMarqueeTextView) avatarGuideAnimLayout.findViewById(R.id.yxh);
        float f16 = p16;
        if (initContentView$lambda$4.getPaint().measureText(postName) > f16) {
            Intrinsics.checkNotNullExpressionValue(initContentView$lambda$4, "nameView");
            initContentView$lambda$4.setVisibility(8);
            marqueeNameView.setText(postName);
            Intrinsics.checkNotNullExpressionValue(marqueeNameView, "initContentView$lambda$3");
            marqueeNameView.setVisibility(0);
            marqueeNameView.setTextSpeed(0.0f);
            marqueeNameView.f();
            initContentView$lambda$4 = marqueeNameView;
        } else {
            Intrinsics.checkNotNullExpressionValue(marqueeNameView, "marqueeNameView");
            marqueeNameView.setVisibility(8);
            initContentView$lambda$4.setText(postName);
            Intrinsics.checkNotNullExpressionValue(initContentView$lambda$4, "initContentView$lambda$4");
            initContentView$lambda$4.setVisibility(0);
        }
        this.nameView = initContentView$lambda$4;
        initContentView$lambda$4.setAlpha(0.0f);
        initContentView$lambda$4.getLayoutParams().width = p16;
        TextView initContentView$lambda$7 = (TextView) avatarGuideAnimLayout.findViewById(R.id.f165134v03);
        QCircleMarqueeTextView marqueeFansView = (QCircleMarqueeTextView) avatarGuideAnimLayout.findViewById(R.id.yxg);
        if (initContentView$lambda$7.getPaint().measureText(fansCount) > f16) {
            Intrinsics.checkNotNullExpressionValue(initContentView$lambda$7, "fansView");
            initContentView$lambda$7.setVisibility(8);
            marqueeFansView.setText(fansCount);
            Intrinsics.checkNotNullExpressionValue(marqueeFansView, "initContentView$lambda$6");
            marqueeFansView.setVisibility(0);
            marqueeFansView.setTextSpeed(0.0f);
            marqueeFansView.f();
            initContentView$lambda$7 = marqueeFansView;
        } else {
            Intrinsics.checkNotNullExpressionValue(marqueeFansView, "marqueeFansView");
            marqueeFansView.setVisibility(8);
            initContentView$lambda$7.setText(fansCount);
            Intrinsics.checkNotNullExpressionValue(initContentView$lambda$7, "initContentView$lambda$7");
            initContentView$lambda$7.setVisibility(0);
        }
        this.fansView = initContentView$lambda$7;
        View view = this.nameView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = initContentView$lambda$7.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(5, view.getId());
            layoutParams2.addRule(3, view.getId());
        }
        View view2 = this.fansView;
        if (view2 != null) {
            view2.setAlpha(0.0f);
            view2.getLayoutParams().width = p16;
        }
    }

    private final boolean u(View avatarGuideAnimLayout) {
        avatarGuideAnimLayout.setVisibility(0);
        b bVar = this.reportListener;
        if (bVar != null) {
            bVar.a();
        }
        ViewGroup.LayoutParams layoutParams = avatarGuideAnimLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int[] iArr = new int[2];
        this.avatarView.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        avatarGuideAnimLayout.getLocationInWindow(iArr2);
        int i3 = iArr2[1];
        int i16 = iArr[1];
        if (i16 <= 0 || i3 <= 0) {
            return false;
        }
        QLog.i("QFSFeedAvatarGuideAnimController", 1, "locateAvatarGuideAnimLayout, oldBottomMargin=" + layoutParams2.bottomMargin);
        int p16 = (i3 - i16) + p(4.0f);
        layoutParams2.bottomMargin = p16;
        QLog.i("QFSFeedAvatarGuideAnimController", 1, "locateAvatarGuideAnimLayout, avatarGuideAnimLayoutLocation[1]=" + iArr2[1] + ", avatarViewLocation[1]=" + iArr[1] + ",layoutParams.bottomMargin=" + p16);
        if (layoutParams2.bottomMargin < 0) {
            avatarGuideAnimLayout.setVisibility(8);
            return false;
        }
        avatarGuideAnimLayout.requestLayout();
        return true;
    }

    public final void A() {
        RFWThreadManager.getUIHandler().removeCallbacks(this.collapseAnimatorRunnable);
        View view = this.avatarGuideAnimLayout;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.bgView;
        if (view2 != null) {
            view2.getLayoutParams().width = p(58.0f);
            view2.setAlpha(0.0f);
        }
        this.avatarView.setTranslationX(0.0f);
        this.avatarStrokeView.setTranslationX(0.0f);
        this.avatarDecorateView.setTranslationX(0.0f);
        this.liveAnimView.setTranslationX(0.0f);
        this.circleAnimView.setTranslationX(0.0f);
        QFSPlusFollowView qFSPlusFollowView = this.followView;
        qFSPlusFollowView.setDismissAnimationListener(null);
        qFSPlusFollowView.setTranslationY(0.0f);
        qFSPlusFollowView.C(this.followViewClickListener);
    }

    public final void B(@Nullable b bVar) {
        this.reportListener = bVar;
    }

    public final void v(@NotNull FeedCloudMeta$StFeed stFeed) {
        boolean z16;
        Object obj;
        PBInt32Field pBInt32Field;
        PBInt32Field pBInt32Field2;
        boolean z17;
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        String str = stFeed.poster.f398463id.get();
        Intrinsics.checkNotNullExpressionValue(str, "stFeed.poster.id.get()");
        this.posterId = str;
        boolean z18 = true;
        if (stFeed.poster.followState.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isFollowed = z16;
        List<FeedCloudMeta$StGuideInfo> guideInfoList = stFeed.guideInfos.get();
        Intrinsics.checkNotNullExpressionValue(guideInfoList, "guideInfoList");
        Iterator<T> it = guideInfoList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((FeedCloudMeta$StGuideInfo) obj).guide_type.get() == 2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FeedCloudMeta$StGuideInfo feedCloudMeta$StGuideInfo = (FeedCloudMeta$StGuideInfo) obj;
        if (feedCloudMeta$StGuideInfo == null || (pBInt32Field2 = feedCloudMeta$StGuideInfo.displayTimeSecond) == null || !pBInt32Field2.has()) {
            z18 = false;
        }
        int i3 = -1;
        if (z18 && (pBInt32Field = feedCloudMeta$StGuideInfo.displayTimeSecond) != null) {
            i3 = pBInt32Field.get();
        }
        this.displayTimeSecond = i3;
        this.hasPlayAnim = false;
        this.fansCount = stFeed.poster.fansCount.get();
        String str2 = stFeed.poster.nick.get();
        Intrinsics.checkNotNullExpressionValue(str2, "stFeed.poster.nick.get()");
        this.posterName = str2;
        A();
    }

    public final void w() {
        A();
    }

    public final void x() {
        boolean z16 = true;
        QLog.i("QFSFeedAvatarGuideAnimController", 1, "onFeedSelected, displayTimeSecond= " + this.displayTimeSecond);
        if (RFWApplication.isDebug()) {
            if (this.displayTimeSecond <= 0 || this.hasPlayAnim || !QFSFeedFollowGuideAnimRepository.c() || !QFSFeedFollowGuideAnimRepository.a(this.posterId) || this.isFollowed) {
                z16 = false;
            }
            if (z16) {
                QQToast.makeText(this.avatarView.getContext(), this.displayTimeSecond + " \u79d2\u540e\u51fa\u73b0\u5173\u6ce8\u5f15\u5bfc\u52a8\u753b", 0).show();
            }
        }
    }

    public final void y(@NotNull String posterId, boolean isFollowed) {
        Intrinsics.checkNotNullParameter(posterId, "posterId");
        if (!Intrinsics.areEqual(this.posterId, posterId)) {
            return;
        }
        this.isFollowed = isFollowed;
    }

    public final void z(int progressMills) {
        int i3 = this.displayTimeSecond;
        if (i3 >= 0 && !this.hasPlayAnim && progressMills / 1000 > i3) {
            if (!QFSFeedFollowGuideAnimRepository.c()) {
                QLog.i("QFSFeedAvatarGuideAnimController", 1, "onVideoProgressChange, has not leftPlayCountToAllInNaturalDay");
                this.hasPlayAnim = true;
                return;
            }
            if (!QFSFeedFollowGuideAnimRepository.a(this.posterId)) {
                QLog.i("QFSFeedAvatarGuideAnimController", 1, "onVideoProgressChange, hasPlayAnimToAnchorInNaturalDay");
                this.hasPlayAnim = true;
                return;
            }
            QLog.i("QFSFeedAvatarGuideAnimController", 1, "onVideoProgressChange, reach play anim point, isFollowed = " + this.isFollowed);
            if (!this.isFollowed) {
                this.hasPlayAnim = true;
                if (this.avatarGuideAnimLayout == null) {
                    this.avatarGuideAnimLayout = this.avatarGuideAnimLayoutViewStub.inflate();
                }
                View view = this.avatarGuideAnimLayout;
                if (view != null) {
                    P(view);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/animwrap/QFSFeedAvatarFollowGuideAnimController$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f85873d;

        c(Function0<Unit> function0) {
            this.f85873d = function0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            this.f85873d.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/animwrap/QFSFeedAvatarFollowGuideAnimController$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f85874d;

        d(Function0<Unit> function0) {
            this.f85874d = function0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            this.f85874d.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/animwrap/QFSFeedAvatarFollowGuideAnimController$e", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f85875d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f85876e;

        e(View view, View view2) {
            this.f85875d = view;
            this.f85876e = view2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(View view, View view2) {
            if (view instanceof QCircleMarqueeTextView) {
                QCircleMarqueeTextView qCircleMarqueeTextView = (QCircleMarqueeTextView) view;
                qCircleMarqueeTextView.setTextSpeed(0.5f);
                qCircleMarqueeTextView.e();
            }
            if (view2 instanceof QCircleMarqueeTextView) {
                QCircleMarqueeTextView qCircleMarqueeTextView2 = (QCircleMarqueeTextView) view2;
                qCircleMarqueeTextView2.setTextSpeed(0.5f);
                qCircleMarqueeTextView2.e();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final View view = this.f85875d;
            final View view2 = this.f85876e;
            uIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.v
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFeedAvatarFollowGuideAnimController.e.b(view, view2);
                }
            }, 1000L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }
}
