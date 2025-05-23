package com.tencent.mobileqq.guild.feed.nativepublish.feature.movement;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditText;
import com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.GuildFeedPublishMediaPreviewVB;
import com.tencent.mobileqq.guild.feed.nativepublish.title.SimplifiedFeedEditorTitleMviUIState;
import com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.SimplifiedFeedEditorViewBinding;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yl1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 R2\u00020\u0001:\u0001-B2\u0012\u0006\u00101\u001a\u00020,\u0012!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110$\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u001a02\u00a2\u0006\u0004\bP\u0010QJ\u0016\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J$\u0010\u0006\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u00aa\u0001\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\u000b2\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00020\r2\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00020\r2\u0006\u0010\u0010\u001a\u00020\t2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J&\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002Jp\u0010\u001f\u001a\u00020\u001c2\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00020\r2\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J \u0010#\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0002J\u001c\u0010'\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020$H\u0002J\u0014\u0010)\u001a\u00020\u001a2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001a0\rJ\u0006\u0010*\u001a\u00020\u001aJ\u0006\u0010+\u001a\u00020\u001aR\u0017\u00101\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R2\u0010:\u001a\u001d\u0012\u0013\u0012\u00110$\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u001a028\u0006\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001d\u0010\f\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010E\u001a\u0004\bF\u0010GR\u001d\u0010L\u001a\u0004\u0018\u00010H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010E\u001a\u0004\bJ\u0010KR\u001d\u0010O\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010E\u001a\u0004\bM\u0010N\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorFullScreenModeEffect;", "", "Lkotlin/Pair;", "", HippyTKDListViewAdapter.X, "Lmm1/a;", "y", "", "endMarginBottom", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "p", "Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/b;", "inputViewBinding", "Lkotlin/Function0;", "grayFrameHeightKeyframe", "inputHeightKeyframe", "whiteSheetTopGuideLineAnimateUpdateListener", "mediaAreaScaleKeyframe", "arrowAlphaKeyframe", "titleAlphaKeyframe", "targetWhiteSheetRadius", "", "titleAnimatorStartDelay", "arrowAnimatorStartDelay", "Landroid/animation/Animator$AnimatorListener;", "animationListener", "", "f", "Landroid/animation/ValueAnimator;", "v", "whiteSheetTopGuideLineUpdateListener", "t", "frac", "start", "end", "o", "", "needLog", "ignoreCache", tl.h.F, "onAnimationEnd", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/SimplifiedFeedEditorViewBinding;", "a", "Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/SimplifiedFeedEditorViewBinding;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/SimplifiedFeedEditorViewBinding;", "rootViewBinding", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, "b", "Lkotlin/jvm/functions/Function1;", "l", "()Lkotlin/jvm/functions/Function1;", "onFinishTransitionCallback", "Landroid/graphics/Rect;", "c", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "d", "Z", "needRecomputeMeasureCache", "e", "I", "grayFrameTargetFullScreenHeight", "Lkotlin/Lazy;", "j", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/GuildFeedPublishMediaPreviewVB$a$a;", "g", "k", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/GuildFeedPublishMediaPreviewVB$a$a;", "mediaLayerScaleHandle", DomainData.DOMAIN_NAME, "()Lmm1/a;", "titleOperationApi", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/SimplifiedFeedEditorViewBinding;Lkotlin/jvm/functions/Function1;)V", "i", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SimplifiedFeedEditorFullScreenModeEffect {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final a f221983i = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SimplifiedFeedEditorViewBinding rootViewBinding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Boolean, Unit> onFinishTransitionCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect rect;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean needRecomputeMeasureCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int grayFrameTargetFullScreenHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy inputViewBinding;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaLayerScaleHandle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy titleOperationApi;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorFullScreenModeEffect$a;", "", "", "ANIM_DURATION", "J", "ARROW_ANIM_DURATION", "DISMISS_ANIM_DURATION", "", "MEDIA_LAYER_SCALE_FACTOR", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "TITLE_ANIM_DURATION", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorFullScreenModeEffect$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f221992d;

        b(Function0<Unit> function0) {
            this.f221992d = function0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            this.f221992d.invoke();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorFullScreenModeEffect$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b f221994e;

        c(com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar) {
            this.f221994e = bVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            SimplifiedFeedEditorFullScreenModeEffect.this.l().invoke(Boolean.TRUE);
            this.f221994e.v();
            SimplifiedFeedEditorFullScreenModeEffect.this.getRootViewBinding().B();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorFullScreenModeEffect$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b f221996e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ mm1.a f221997f;

        d(com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b bVar, mm1.a aVar) {
            this.f221996e = bVar;
            this.f221997f = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            View view;
            SimplifiedFeedEditorFullScreenModeEffect.this.l().invoke(Boolean.FALSE);
            this.f221996e.w();
            mm1.a aVar = this.f221997f;
            boolean z16 = false;
            if (aVar != null && aVar.B0()) {
                z16 = true;
            }
            if (!z16) {
                mm1.a aVar2 = this.f221997f;
                if (aVar2 != null) {
                    view = aVar2.getRoot();
                } else {
                    view = null;
                }
                if (view != null) {
                    view.setVisibility(8);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimplifiedFeedEditorFullScreenModeEffect(@NotNull SimplifiedFeedEditorViewBinding rootViewBinding, @NotNull Function1<? super Boolean, Unit> onFinishTransitionCallback) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(rootViewBinding, "rootViewBinding");
        Intrinsics.checkNotNullParameter(onFinishTransitionCallback, "onFinishTransitionCallback");
        this.rootViewBinding = rootViewBinding;
        this.onFinishTransitionCallback = onFinishTransitionCallback;
        this.rect = new Rect();
        this.needRecomputeMeasureCache = true;
        this.grayFrameTargetFullScreenHeight = -1;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.SimplifiedFeedEditorFullScreenModeEffect$inputViewBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b invoke() {
                View findViewById = SimplifiedFeedEditorFullScreenModeEffect.this.getRootViewBinding().getConstraintFixFrame().findViewById(SimplifiedFeedEditorViewBinding.INSTANCE.e());
                if (findViewById != null) {
                    return (com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b) n.s(findViewById, com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b.class);
                }
                return null;
            }
        });
        this.inputViewBinding = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<GuildFeedPublishMediaPreviewVB.Companion.C7768a>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.SimplifiedFeedEditorFullScreenModeEffect$mediaLayerScaleHandle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final GuildFeedPublishMediaPreviewVB.Companion.C7768a invoke() {
                Object tag = ((FrameLayout) SimplifiedFeedEditorFullScreenModeEffect.this.getRootViewBinding().getConstraintFixFrame().findViewById(SimplifiedFeedEditorViewBinding.INSTANCE.g())).getTag();
                if (tag instanceof GuildFeedPublishMediaPreviewVB.Companion.C7768a) {
                    return (GuildFeedPublishMediaPreviewVB.Companion.C7768a) tag;
                }
                return null;
            }
        });
        this.mediaLayerScaleHandle = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<mm1.a>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.SimplifiedFeedEditorFullScreenModeEffect$titleOperationApi$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final mm1.a invoke() {
                return (mm1.a) n.s(SimplifiedFeedEditorFullScreenModeEffect.this.getRootViewBinding().getConstraintFixFrame(), mm1.a.class);
            }
        });
        this.titleOperationApi = lazy3;
    }

    private final void f(final com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b inputViewBinding, Function0<Pair<Integer, Integer>> grayFrameHeightKeyframe, Function0<Pair<Integer, Integer>> inputHeightKeyframe, ValueAnimator.AnimatorUpdateListener whiteSheetTopGuideLineAnimateUpdateListener, Pair<Float, Float> mediaAreaScaleKeyframe, final Pair<Float, Float> arrowAlphaKeyframe, Pair<Float, Float> titleAlphaKeyframe, float targetWhiteSheetRadius, long titleAnimatorStartDelay, long arrowAnimatorStartDelay, Animator.AnimatorListener animationListener) {
        ve1.b bVar = new ve1.b(0.65f, 0.0f, 0.35f, 1.0f);
        ValueAnimator t16 = t(grayFrameHeightKeyframe, inputHeightKeyframe, inputViewBinding, whiteSheetTopGuideLineAnimateUpdateListener, targetWhiteSheetRadius, mediaAreaScaleKeyframe, animationListener);
        t16.setInterpolator(bVar);
        ValueAnimator v3 = v(titleAnimatorStartDelay, titleAlphaKeyframe);
        v3.setInterpolator(bVar);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(bVar);
        ofFloat.setDuration(100L);
        ofFloat.setStartDelay(arrowAnimatorStartDelay);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SimplifiedFeedEditorFullScreenModeEffect.g(com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b.this, this, arrowAlphaKeyframe, valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(t16, ofFloat, v3);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b inputViewBinding, SimplifiedFeedEditorFullScreenModeEffect this$0, Pair arrowAlphaKeyframe, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(inputViewBinding, "$inputViewBinding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(arrowAlphaKeyframe, "$arrowAlphaKeyframe");
        View fullScreenSwitchArrowLayout = inputViewBinding.getFullScreenSwitchArrowLayout();
        if (fullScreenSwitchArrowLayout != null) {
            fullScreenSwitchArrowLayout.setAlpha(this$0.o(valueAnimator.getAnimatedFraction(), ((Number) arrowAlphaKeyframe.getFirst()).floatValue(), ((Number) arrowAlphaKeyframe.getSecond()).floatValue()));
        }
    }

    private final int h(boolean needLog, boolean ignoreCache) {
        int d16;
        Function0<Integer> a16;
        if (!ignoreCache && !this.needRecomputeMeasureCache) {
            return this.grayFrameTargetFullScreenHeight;
        }
        int i3 = 0;
        this.needRecomputeMeasureCache = false;
        this.rootViewBinding.getBottomLinearLayout().getGlobalVisibleRect(this.rect);
        GuildFeedPublishMediaPreviewVB.Companion.C7768a k3 = k();
        if (k3 != null && (a16 = k3.a()) != null) {
            i3 = a16.invoke().intValue();
        }
        if (i3 > 0) {
            GuildFeedPublishMediaPreviewVB.Companion.C7768a k16 = k();
            Intrinsics.checkNotNull(k16);
            d16 = (int) (((i3 - r0) * 1.2f) + k16.b().invoke().intValue());
        } else {
            d16 = SimplifiedFeedEditorViewBinding.INSTANCE.d();
        }
        int i16 = this.rect.top - d16;
        SimplifiedFeedEditorViewBinding.Companion companion = SimplifiedFeedEditorViewBinding.INSTANCE;
        int k17 = (i16 - companion.k()) - companion.n();
        if (needLog) {
            QLog.d("FeedEditor.FullScreenEffect", 1, "functionBar.top(" + this.rect.top + ") - mediaLayer.height(" + d16 + ") - title.height(" + companion.k() + ") - topPadding(" + companion.n() + ") = " + k17);
        }
        this.grayFrameTargetFullScreenHeight = k17;
        return k17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int i(SimplifiedFeedEditorFullScreenModeEffect simplifiedFeedEditorFullScreenModeEffect, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        return simplifiedFeedEditorFullScreenModeEffect.h(z16, z17);
    }

    private final com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b j() {
        return (com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b) this.inputViewBinding.getValue();
    }

    private final GuildFeedPublishMediaPreviewVB.Companion.C7768a k() {
        return (GuildFeedPublishMediaPreviewVB.Companion.C7768a) this.mediaLayerScaleHandle.getValue();
    }

    private final mm1.a n() {
        return (mm1.a) this.titleOperationApi.getValue();
    }

    private final float o(float frac, float start, float end) {
        return ((end - start) * frac) + start;
    }

    private final ValueAnimator.AnimatorUpdateListener p(final int endMarginBottom) {
        final int i3;
        ViewGroup.LayoutParams layoutParams = this.rootViewBinding.getWhiteSheetTopGuideLine().getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            i3 = marginLayoutParams.bottomMargin;
        } else {
            i3 = 0;
        }
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SimplifiedFeedEditorFullScreenModeEffect.q(SimplifiedFeedEditorFullScreenModeEffect.this, i3, endMarginBottom, valueAnimator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(SimplifiedFeedEditorFullScreenModeEffect this$0, int i3, int i16, ValueAnimator valueAnimator) {
        int roundToInt;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View whiteSheetTopGuideLine = this$0.rootViewBinding.getWhiteSheetTopGuideLine();
        ViewGroup.LayoutParams layoutParams = whiteSheetTopGuideLine.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            roundToInt = MathKt__MathJVMKt.roundToInt(this$0.o(valueAnimator.getAnimatedFraction(), i3, i16));
            marginLayoutParams.bottomMargin = roundToInt;
            whiteSheetTopGuideLine.setLayoutParams(marginLayoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float s(float f16) {
        return (float) ((Math.cos((f16 + 1) * 3.141592653589793d) / 2.0d) + 0.5d);
    }

    private final ValueAnimator t(final Function0<Pair<Integer, Integer>> grayFrameHeightKeyframe, final Function0<Pair<Integer, Integer>> inputHeightKeyframe, final com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b inputViewBinding, final ValueAnimator.AnimatorUpdateListener whiteSheetTopGuideLineUpdateListener, final float targetWhiteSheetRadius, final Pair<Float, Float> mediaAreaScaleKeyframe, Animator.AnimatorListener animationListener) {
        final float o16 = SimplifiedFeedEditorViewBinding.INSTANCE.o();
        final float[] fArr = {o16, o16, o16, o16, 0.0f, 0.0f, 0.0f, 0.0f};
        ValueAnimator contentAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        contentAnimator.setDuration(200L).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SimplifiedFeedEditorFullScreenModeEffect.u(Function0.this, inputViewBinding, inputHeightKeyframe, whiteSheetTopGuideLineUpdateListener, this, mediaAreaScaleKeyframe, o16, targetWhiteSheetRadius, fArr, valueAnimator);
            }
        });
        contentAnimator.addListener(animationListener);
        Intrinsics.checkNotNullExpressionValue(contentAnimator, "contentAnimator");
        return contentAnimator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function0 grayFrameHeightKeyframe, com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b inputViewBinding, Function0 inputHeightKeyframe, ValueAnimator.AnimatorUpdateListener whiteSheetTopGuideLineUpdateListener, SimplifiedFeedEditorFullScreenModeEffect this$0, Pair mediaAreaScaleKeyframe, float f16, float f17, float[] whiteSheetRadii, ValueAnimator valueAnimator) {
        Function1<Float, Unit> c16;
        Intrinsics.checkNotNullParameter(grayFrameHeightKeyframe, "$grayFrameHeightKeyframe");
        Intrinsics.checkNotNullParameter(inputViewBinding, "$inputViewBinding");
        Intrinsics.checkNotNullParameter(inputHeightKeyframe, "$inputHeightKeyframe");
        Intrinsics.checkNotNullParameter(whiteSheetTopGuideLineUpdateListener, "$whiteSheetTopGuideLineUpdateListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaAreaScaleKeyframe, "$mediaAreaScaleKeyframe");
        Intrinsics.checkNotNullParameter(whiteSheetRadii, "$whiteSheetRadii");
        Pair pair = (Pair) grayFrameHeightKeyframe.invoke();
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        ViewGroup grayFrame = inputViewBinding.getGrayFrame();
        ViewGroup.LayoutParams layoutParams = grayFrame.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = (int) this$0.o(valueAnimator.getAnimatedFraction(), intValue, intValue2);
            grayFrame.setLayoutParams(layoutParams);
            Pair pair2 = (Pair) inputHeightKeyframe.invoke();
            int intValue3 = ((Number) pair2.component1()).intValue();
            int intValue4 = ((Number) pair2.component2()).intValue();
            GuildFeedEditText input = inputViewBinding.getInput();
            ViewGroup.LayoutParams layoutParams2 = input.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = (int) this$0.o(valueAnimator.getAnimatedFraction(), intValue3, intValue4);
                input.setLayoutParams(layoutParams2);
                whiteSheetTopGuideLineUpdateListener.onAnimationUpdate(valueAnimator);
                Drawable background = this$0.rootViewBinding.getWhiteSheetBackground().getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = null;
                }
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                if (gradientDrawable != null) {
                    float o16 = this$0.o(valueAnimator.getAnimatedFraction(), f16, f17);
                    whiteSheetRadii[0] = o16;
                    whiteSheetRadii[1] = o16;
                    whiteSheetRadii[2] = o16;
                    whiteSheetRadii[3] = o16;
                    gradientDrawable.setCornerRadii(whiteSheetRadii);
                }
                GuildFeedPublishMediaPreviewVB.Companion.C7768a k3 = this$0.k();
                if (k3 != null && (c16 = k3.c()) != null) {
                    c16.invoke(Float.valueOf(this$0.o(valueAnimator.getAnimatedFraction(), ((Number) mediaAreaScaleKeyframe.getFirst()).floatValue(), ((Number) mediaAreaScaleKeyframe.getSecond()).floatValue())));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    private final ValueAnimator v(long titleAnimatorStartDelay, final Pair<Float, Float> titleAlphaKeyframe) {
        ValueAnimator titleAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        titleAnimator.setDuration(100L);
        titleAnimator.setStartDelay(titleAnimatorStartDelay);
        final mm1.a n3 = n();
        if (n3 == null) {
            Intrinsics.checkNotNullExpressionValue(titleAnimator, "titleAnimator");
            return titleAnimator;
        }
        if (titleAlphaKeyframe != null) {
            titleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SimplifiedFeedEditorFullScreenModeEffect.w(mm1.a.this, this, titleAlphaKeyframe, valueAnimator);
                }
            });
        }
        Intrinsics.checkNotNullExpressionValue(titleAnimator, "titleAnimator");
        return titleAnimator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(mm1.a titleApi, SimplifiedFeedEditorFullScreenModeEffect this$0, Pair pair, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(titleApi, "$titleApi");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View root = titleApi.getRoot();
        if (root != null) {
            root.setAlpha(this$0.o(valueAnimator.getAnimatedFraction(), ((Number) pair.getFirst()).floatValue(), ((Number) pair.getSecond()).floatValue()));
        }
    }

    private final Pair<Float, Float> x() {
        mm1.a n3 = n();
        if (n3 != null) {
            n3.C();
            View root = n3.getRoot();
            if (root != null) {
                root.setVisibility(0);
            }
            n3.z0(new SimplifiedFeedEditorTitleMviUIState.TitleStyle(1));
            if (!n3.B0()) {
                Pair<Float, Float> pair = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(1.0f));
                View root2 = n3.getRoot();
                if (root2 != null) {
                    ViewGroup.LayoutParams layoutParams = root2.getLayoutParams();
                    if (layoutParams != null) {
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                        SimplifiedFeedEditorViewBinding.Companion companion = SimplifiedFeedEditorViewBinding.INSTANCE;
                        ((ViewGroup.MarginLayoutParams) layoutParams2).height = companion.k();
                        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = companion.n();
                        layoutParams2.bottomToTop = -1;
                        layoutParams2.topToTop = 0;
                        root2.setLayoutParams(layoutParams2);
                        return pair;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                return pair;
            }
        }
        return null;
    }

    private final Pair<mm1.a, Pair<Float, Float>> y() {
        Pair pair;
        mm1.a n3 = n();
        if (n3 != null) {
            View root = n3.getRoot();
            if (root != null) {
                root.setVisibility(0);
            }
            n3.z0(new SimplifiedFeedEditorTitleMviUIState.TitleStyle(0));
            if (!n3.B0()) {
                pair = TuplesKt.to(Float.valueOf(1.0f), Float.valueOf(0.0f));
                return new Pair<>(n3, pair);
            }
            View root2 = n3.getRoot();
            if (root2 != null) {
                root2.setLayoutParams(SimplifiedFeedEditorViewBinding.INSTANCE.l());
            }
        }
        pair = null;
        return new Pair<>(n3, pair);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A() {
        com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b j3 = j();
        if (j3 == null) {
            return;
        }
        final int height = j3.getGrayFrame().getHeight();
        final int height2 = j3.getInput().getHeight();
        Triple<Integer, Integer, Integer> f16 = j3.f();
        final int intValue = f16.component1().intValue();
        final int intValue2 = f16.component2().intValue();
        int intValue3 = f16.component3().intValue();
        j3.n(true);
        j3.r(Integer.valueOf(intValue3));
        this.rootViewBinding.C();
        Pair<mm1.a, Pair<Float, Float>> y16 = y();
        mm1.a component1 = y16.component1();
        Pair<Float, Float> component2 = y16.component2();
        View whiteSheetTopGuideLine = this.rootViewBinding.getWhiteSheetTopGuideLine();
        ViewGroup.LayoutParams layoutParams = whiteSheetTopGuideLine.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            SimplifiedFeedEditorViewBinding.Companion companion = SimplifiedFeedEditorViewBinding.INSTANCE;
            marginLayoutParams.bottomMargin = companion.n() + companion.k();
            whiteSheetTopGuideLine.setLayoutParams(marginLayoutParams);
            f(j3, new Function0<Pair<? extends Integer, ? extends Integer>>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.SimplifiedFeedEditorFullScreenModeEffect$transitionToHalfScreen$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Pair<? extends Integer, ? extends Integer> invoke() {
                    return TuplesKt.to(Integer.valueOf(height), Integer.valueOf(intValue2));
                }
            }, new Function0<Pair<? extends Integer, ? extends Integer>>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.SimplifiedFeedEditorFullScreenModeEffect$transitionToHalfScreen$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Pair<? extends Integer, ? extends Integer> invoke() {
                    return TuplesKt.to(Integer.valueOf(height2), Integer.valueOf(intValue));
                }
            }, p(this.rootViewBinding.t()), TuplesKt.to(Float.valueOf(1.2f), Float.valueOf(1.0f)), TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(1.0f)), component2, companion.o(), 0L, 100L, new d(j3, component1));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @NotNull
    public final Function1<Boolean, Unit> l() {
        return this.onFinishTransitionCallback;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final SimplifiedFeedEditorViewBinding getRootViewBinding() {
        return this.rootViewBinding;
    }

    public final void r(@NotNull Function0<Unit> onAnimationEnd) {
        Intrinsics.checkNotNullParameter(onAnimationEnd, "onAnimationEnd");
        this.rootViewBinding.getMRv().animate().translationY(this.rootViewBinding.getMRv().getHeight()).setDuration(250L).setInterpolator(new TimeInterpolator() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.b
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f16) {
                float s16;
                s16 = SimplifiedFeedEditorFullScreenModeEffect.s(f16);
                return s16;
            }
        }).setListener(new b(onAnimationEnd)).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z() {
        com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b j3 = j();
        if (j3 == null) {
            return;
        }
        final int height = j3.getGrayFrame().getHeight();
        final int height2 = j3.getInput().getHeight();
        j3.u();
        Pair<Float, Float> x16 = x();
        SimplifiedFeedEditorViewBinding.Companion companion = SimplifiedFeedEditorViewBinding.INSTANCE;
        ValueAnimator.AnimatorUpdateListener p16 = p(companion.n() + companion.k());
        this.needRecomputeMeasureCache = true;
        f(j3, new Function0<Pair<? extends Integer, ? extends Integer>>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.SimplifiedFeedEditorFullScreenModeEffect$transitionToFullScreen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Pair<? extends Integer, ? extends Integer> invoke() {
                return TuplesKt.to(Integer.valueOf(height), Integer.valueOf(SimplifiedFeedEditorFullScreenModeEffect.i(this, false, false, 3, null)));
            }
        }, new Function0<Pair<? extends Integer, ? extends Integer>>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.SimplifiedFeedEditorFullScreenModeEffect$transitionToFullScreen$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Pair<? extends Integer, ? extends Integer> invoke() {
                return TuplesKt.to(Integer.valueOf(height2), Integer.valueOf(SimplifiedFeedEditorFullScreenModeEffect.i(this, false, false, 3, null) - (com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b.INSTANCE.f() * 2)));
            }
        }, p16, TuplesKt.to(Float.valueOf(1.0f), Float.valueOf(1.2f)), TuplesKt.to(Float.valueOf(1.0f), Float.valueOf(0.0f)), x16, 0.0f, 90L, 0L, new c(j3));
    }
}
