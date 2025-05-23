package ch4;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.widget.util.KeyboardUtils;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ui.ViewWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ^2\u00020\u0001:\u0001+B\u001f\u0012\u0006\u0010/\u001a\u00020*\u0012\u0006\u00105\u001a\u000200\u0012\u0006\u0010;\u001a\u000206\u00a2\u0006\u0004\b\\\u0010]J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0002J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u001a\u0010&\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0006\u0010'\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0005J\b\u0010)\u001a\u0004\u0018\u00010\rR\u0017\u0010/\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u00105\u001a\u0002008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0017\u0010;\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010\"R\u0014\u0010@\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010\"R\u0014\u0010B\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010\"R\u0014\u0010D\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010\"R\u0014\u0010F\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010\"R\u0014\u0010H\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010\"R\u0014\u0010J\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010\"R\u0014\u0010M\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010Z\u00a8\u0006_"}, d2 = {"Lch4/x;", "", "", "T", "B", "", "withSearchTask", "r", "K", "Landroid/animation/AnimatorSet;", "animSet", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "U", "Landroid/view/View;", "target", "", "startAlpha", "endAlpha", "Landroid/animation/ObjectAnimator;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", "Lch4/y;", "param", "Ljava/lang/Runnable;", "taskOnAnimStart", "V", "D", "N", "L", "M", "O", "J", "I", "H", UserInfo.SEX_FEMALE, "G", "P", "E", BdhLogUtil.LogTag.Tag_Conn, "w", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "context", "Landroid/view/ViewGroup;", "b", "Landroid/view/ViewGroup;", "v", "()Landroid/view/ViewGroup;", "pageRoot", "Lch4/a;", "c", "Lch4/a;", "u", "()Lch4/a;", "action", "", "d", "cancelTxvWidth", "e", "leftMargin", "f", "rightMargin", "g", "editTextLeftMargin", tl.h.F, "searchBarHeight", "i", "searchAreaWidthWithCancel", "j", "searchAreaWidthWithoutCancel", "k", "Landroid/view/View;", "decorView", "Lnr2/u;", "l", "Lnr2/u;", "binding", "Landroid/widget/RelativeLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/RelativeLayout;", "resultRootView", DomainData.DOMAIN_NAME, "Z", "showState", "o", "Lch4/y;", "mShowAnimParam", "<init>", "(Landroid/app/Activity;Landroid/view/ViewGroup;Lch4/a;)V", "p", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup pageRoot;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a action;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int cancelTxvWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int leftMargin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int rightMargin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int editTextLeftMargin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int searchBarHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int searchAreaWidthWithCancel;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final int searchAreaWidthWithoutCancel;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View decorView;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final nr2.u binding;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout resultRootView;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean showState;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ShowAnimParam mShowAnimParam;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ch4/x$b", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animation", "", "onAnimationUpdate", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@Nullable ValueAnimator animation) {
            Object obj;
            Integer num = null;
            if (animation != null) {
                obj = animation.getAnimatedValue();
            } else {
                obj = null;
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
            }
            if (num != null) {
                int intValue = num.intValue();
                ViewGroup.LayoutParams layoutParams = x.this.binding.f421140e.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.leftMargin = intValue;
                x.this.binding.f421140e.setLayoutParams(layoutParams2);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ch4/x$c", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animation", "", "onAnimationUpdate", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@Nullable ValueAnimator animation) {
            Object obj;
            Integer num = null;
            if (animation != null) {
                obj = animation.getAnimatedValue();
            } else {
                obj = null;
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
            }
            if (num != null) {
                int intValue = num.intValue();
                ViewGroup.LayoutParams layoutParams = x.this.binding.f421143h.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = intValue;
                x.this.binding.f421143h.setLayoutParams(layoutParams2);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ch4/x$d", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animation", "", "onAnimationUpdate", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@Nullable ValueAnimator animation) {
            Object obj;
            Integer num = null;
            if (animation != null) {
                obj = animation.getAnimatedValue();
            } else {
                obj = null;
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
            }
            if (num != null) {
                int intValue = num.intValue();
                ViewGroup.LayoutParams layoutParams = x.this.binding.f421140e.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.leftMargin = intValue;
                x.this.binding.f421140e.setLayoutParams(layoutParams2);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ch4/x$e", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animation", "", "onAnimationUpdate", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@Nullable ValueAnimator animation) {
            Object obj;
            Integer num = null;
            if (animation != null) {
                obj = animation.getAnimatedValue();
            } else {
                obj = null;
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
            }
            if (num != null) {
                int intValue = num.intValue();
                ViewGroup.LayoutParams layoutParams = x.this.binding.f421143h.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = intValue;
                x.this.binding.f421143h.setLayoutParams(layoutParams2);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"ch4/x$f", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationRepeat", "onAnimationEnd", "", "isReverse", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f extends com.tencent.mobileqq.widget.f {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f30903e;

        f(boolean z16) {
            this.f30903e = z16;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            x.this.getPageRoot().removeView(x.this.resultRootView);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation, boolean isReverse) {
            if (this.f30903e) {
                x.this.getAction().i();
            }
            x.this.getPageRoot().removeView(x.this.resultRootView);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }
    }

    public x(@NotNull Activity context, @NotNull ViewGroup pageRoot, @NotNull a action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageRoot, "pageRoot");
        Intrinsics.checkNotNullParameter(action, "action");
        this.context = context;
        this.pageRoot = pageRoot;
        this.action = action;
        int a16 = com.tencent.timi.game.utils.b.a(60);
        this.cancelTxvWidth = a16;
        int a17 = com.tencent.timi.game.utils.b.a(16);
        this.leftMargin = a17;
        int a18 = com.tencent.timi.game.utils.b.a(16);
        this.rightMargin = a18;
        this.editTextLeftMargin = com.tencent.timi.game.utils.b.a(19);
        this.searchBarHeight = com.tencent.timi.game.utils.b.a(60);
        this.searchAreaWidthWithCancel = (ScreenUtils.getAppScreenWidth() - a17) - a16;
        this.searchAreaWidthWithoutCancel = (ScreenUtils.getAppScreenWidth() - a17) - a18;
        View decorView = context.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "context.window.decorView");
        this.decorView = decorView;
        nr2.u g16 = nr2.u.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.binding = g16;
        RelativeLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        this.resultRootView = root;
        this.mShowAnimParam = new ShowAnimParam(null, 0L, null, null, null, 31, null);
        g16.f421141f.setOnClickListener(new View.OnClickListener() { // from class: ch4.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x.j(x.this, view);
            }
        });
        g16.f421140e.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ch4.q
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean k3;
                k3 = x.k(x.this, textView, i3, keyEvent);
                return k3;
            }
        });
        g16.f421143h.setOnClickListener(new View.OnClickListener() { // from class: ch4.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x.l(view);
            }
        });
        g16.f421138c.setOnClickListener(new View.OnClickListener() { // from class: ch4.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x.m(x.this, view);
            }
        });
        g16.f421137b.setOnClickListener(new View.OnClickListener() { // from class: ch4.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x.n(x.this, view);
            }
        });
    }

    private final void A(boolean withSearchTask, AnimatorSet animSet) {
        int i3;
        ViewGroup.LayoutParams layoutParams = this.binding.f421143h.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        int i16 = ((RelativeLayout.LayoutParams) layoutParams).topMargin;
        if (withSearchTask) {
            i3 = this.action.c().top - this.action.h();
        } else {
            i3 = this.action.c().top;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i16, i3);
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new c());
        animSet.play(ofInt);
    }

    private final void B() {
        KeyboardUtils.c(this.binding.f421140e);
    }

    private final boolean D() {
        if (this.action.getState() == 1) {
            return true;
        }
        return false;
    }

    private final void F(ShowAnimParam param) {
        boolean z16;
        ViewGroup.LayoutParams layoutParams = this.binding.f421140e.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (param.getKeyWord().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.binding.f421140e.setText(param.getKeyWord());
            this.binding.f421140e.setSelection(param.getKeyWord().length());
        } else {
            this.binding.f421140e.setText("");
        }
        if (param.getCurrentState() == 2) {
            layoutParams2.leftMargin = this.editTextLeftMargin;
        } else {
            layoutParams2.leftMargin = param.getSearchBarHintPos().getLeft() - this.leftMargin;
        }
        this.binding.f421140e.setLayoutParams(layoutParams2);
    }

    private final void G(ShowAnimParam param) {
        this.binding.f421141f.setAlpha(0.0f);
        if (D()) {
            this.binding.f421138c.setAlpha(0.0f);
            this.binding.f421137b.setAlpha(0.0f);
        } else {
            this.binding.f421138c.setAlpha(1.0f);
            this.binding.f421137b.setAlpha(1.0f);
        }
    }

    private final void H(ShowAnimParam param) {
        int i3;
        ViewGroup.LayoutParams layoutParams = this.binding.f421139d.getLayoutParams();
        if (param.getCurrentState() == 2) {
            i3 = this.searchAreaWidthWithCancel;
        } else {
            i3 = this.searchAreaWidthWithoutCancel;
        }
        layoutParams.width = i3;
        this.binding.f421139d.setLayoutParams(layoutParams);
    }

    private final void I(ShowAnimParam param) {
        ViewGroup.LayoutParams layoutParams = this.binding.f421143h.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = param.getSearchBarStart().getTop();
        this.binding.f421143h.setLayoutParams(layoutParams2);
    }

    private final void J(ShowAnimParam param) {
        I(param);
        H(param);
        F(param);
        G(param);
    }

    private final void K() {
        this.action.updateUI();
    }

    private final void L(ShowAnimParam param, AnimatorSet animSet) {
        boolean z16;
        if (param.getKeyWord().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.binding.f421140e.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ValueAnimator ofInt = ValueAnimator.ofInt(((RelativeLayout.LayoutParams) layoutParams).leftMargin, this.editTextLeftMargin);
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new d());
        animSet.play(ofInt);
    }

    private final void M(ShowAnimParam param, AnimatorSet animSet) {
        int width = this.binding.f421139d.getWidth();
        int i3 = this.searchAreaWidthWithCancel;
        if (width == i3) {
            return;
        }
        RelativeLayout relativeLayout = this.binding.f421139d;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.inputArea");
        ObjectAnimator ofInt = ObjectAnimator.ofInt(new ViewWrapper(relativeLayout), "width", width, i3);
        ofInt.setDuration(300L);
        animSet.play(ofInt);
    }

    private final void N(ShowAnimParam param, AnimatorSet animSet) {
        if (D()) {
            TextView textView = this.binding.f421137b;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.cancelTxv");
            animSet.play(q(textView, 0.0f, 1.0f));
            ImageView imageView = this.binding.f421138c;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.clearIgv");
            animSet.play(q(imageView, 0.0f, 1.0f));
        }
        View view = this.binding.f421141f;
        Intrinsics.checkNotNullExpressionValue(view, "binding.mask");
        animSet.play(q(view, 0.0f, 1.0f));
    }

    private final void O(ShowAnimParam param, AnimatorSet animSet) {
        ViewGroup.LayoutParams layoutParams = this.binding.f421143h.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ValueAnimator ofInt = ValueAnimator.ofInt(((RelativeLayout.LayoutParams) layoutParams).topMargin, param.getSearchBarTarget().getTop());
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new e());
        animSet.play(ofInt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(final x this$0, final ShowAnimParam param, final Runnable runnable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(param, "$param");
        this$0.J(param);
        this$0.resultRootView.post(new Runnable() { // from class: ch4.v
            @Override // java.lang.Runnable
            public final void run() {
                x.R(x.this, param, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(final x this$0, final ShowAnimParam param, final Runnable runnable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(param, "$param");
        this$0.resultRootView.setVisibility(0);
        this$0.resultRootView.post(new Runnable() { // from class: ch4.w
            @Override // java.lang.Runnable
            public final void run() {
                x.S(x.this, param, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(x this$0, ShowAnimParam param, Runnable runnable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(param, "$param");
        this$0.V(param, runnable);
        this$0.T();
        this$0.showState = true;
    }

    private final void T() {
        KeyboardUtils.e(this.binding.f421140e);
    }

    private final void U(boolean withSearchTask) {
        AnimatorSet animatorSet = new AnimatorSet();
        z(animatorSet);
        x(animatorSet);
        A(withSearchTask, animatorSet);
        y(animatorSet);
        animatorSet.addListener(new f(withSearchTask));
        animatorSet.start();
    }

    private final void V(ShowAnimParam param, Runnable taskOnAnimStart) {
        AnimatorSet animatorSet = new AnimatorSet();
        O(param, animatorSet);
        M(param, animatorSet);
        L(param, animatorSet);
        N(param, animatorSet);
        animatorSet.addListener(new g(taskOnAnimStart, this));
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(x this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        s(this$0, false, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(x this$0, TextView textView, int i3, KeyEvent keyEvent) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = false;
        if (i3 != 3) {
            return false;
        }
        Editable text = this$0.binding.f421140e.getText();
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        this$0.action.f(str, false);
        if (str.length() > 0) {
            z16 = true;
        }
        this$0.r(z16);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.timi.game.utils.l.i("SearchResultPageHelper_", "searchRootView click");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(x this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Editable text = this$0.binding.f421140e.getText();
        if (text != null) {
            text.clear();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(x this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        s(this$0, false, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final ObjectAnimator q(View target, float startAlpha, float endAlpha) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(target, com.tencent.luggage.wxa.c8.c.f123400v, startAlpha, endAlpha);
        anim.setDuration(300L);
        Intrinsics.checkNotNullExpressionValue(anim, "anim");
        return anim;
    }

    private final void r(final boolean withSearchTask) {
        this.showState = false;
        K();
        this.resultRootView.post(new Runnable() { // from class: ch4.o
            @Override // java.lang.Runnable
            public final void run() {
                x.t(x.this, withSearchTask);
            }
        });
    }

    static /* synthetic */ void s(x xVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        xVar.r(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(x this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U(z16);
        this$0.B();
    }

    private final void x(AnimatorSet animSet) {
        boolean z16;
        if (this.action.j().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.binding.f421140e.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ValueAnimator ofInt = ValueAnimator.ofInt(((RelativeLayout.LayoutParams) layoutParams).leftMargin, this.mShowAnimParam.getSearchBarHintPos().getLeft() - this.leftMargin);
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new b());
        animSet.play(ofInt);
    }

    private final void y(AnimatorSet animSet) {
        boolean z16;
        int i3;
        int width = this.binding.f421139d.getWidth();
        if (this.action.j().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = this.searchAreaWidthWithCancel;
        } else {
            i3 = this.searchAreaWidthWithoutCancel;
        }
        if (width == i3) {
            return;
        }
        RelativeLayout relativeLayout = this.binding.f421139d;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.inputArea");
        ObjectAnimator ofInt = ObjectAnimator.ofInt(new ViewWrapper(relativeLayout), "width", width, i3);
        ofInt.setDuration(300L);
        animSet.play(ofInt);
    }

    private final void z(AnimatorSet animSet) {
        if (D()) {
            TextView textView = this.binding.f421137b;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.cancelTxv");
            animSet.play(q(textView, 1.0f, 0.0f));
            ImageView imageView = this.binding.f421138c;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.clearIgv");
            animSet.play(q(imageView, 1.0f, 0.0f));
        }
        View view = this.binding.f421141f;
        Intrinsics.checkNotNullExpressionValue(view, "binding.mask");
        animSet.play(q(view, 1.0f, 0.0f));
    }

    /* renamed from: C, reason: from getter */
    public final boolean getShowState() {
        return this.showState;
    }

    public final boolean E() {
        if (!this.showState) {
            return false;
        }
        s(this, false, 1, null);
        return true;
    }

    public final void P(@NotNull final ShowAnimParam param, @Nullable final Runnable taskOnAnimStart) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.mShowAnimParam = param;
        this.resultRootView.setVisibility(4);
        this.pageRoot.removeView(this.resultRootView);
        this.pageRoot.addView(this.resultRootView);
        this.resultRootView.post(new Runnable() { // from class: ch4.u
            @Override // java.lang.Runnable
            public final void run() {
                x.Q(x.this, param, taskOnAnimStart);
            }
        });
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final a getAction() {
        return this.action;
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public final ViewGroup getPageRoot() {
        return this.pageRoot;
    }

    @Nullable
    public final View w() {
        if (this.showState) {
            return this.resultRootView;
        }
        return null;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"ch4/x$g", "Lcom/tencent/mobileqq/widget/f;", "", "e", "Landroid/animation/Animator;", "animation", "onAnimationCancel", "onAnimationRepeat", "onAnimationEnd", "onAnimationStart", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class g extends com.tencent.mobileqq.widget.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f30904d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ x f30905e;

        g(Runnable runnable, x xVar) {
            this.f30904d = runnable;
            this.f30905e = xVar;
        }

        private final void e() {
            boolean z16;
            if (this.f30905e.getAction().j().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.f30905e.getAction().e();
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            e();
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            Runnable runnable = this.f30904d;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }
    }
}
