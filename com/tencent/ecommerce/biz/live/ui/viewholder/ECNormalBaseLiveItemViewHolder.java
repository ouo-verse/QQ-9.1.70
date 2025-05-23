package com.tencent.ecommerce.biz.live.ui.viewholder;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.live.ui.ECLiveLabelView;
import com.tencent.ecommerce.biz.util.ECDateUtil;
import com.tencent.ecommerce.biz.util.i;
import com.tencent.ecommerce.repo.live.ActivityPrice;
import com.tencent.ecommerce.repo.live.ActivitySellingPoint;
import com.tencent.ecommerce.repo.live.ActivityStatus;
import com.tencent.ecommerce.repo.live.ActivityStock;
import com.tencent.ecommerce.repo.live.HotLabel;
import com.tencent.ecommerce.repo.live.LiveActivity;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.ecommerce.repo.live.LiveShowItem;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 A2\u00020\u0001:\u0001BB?\u0012\u0006\u0010:\u001a\u00020#\u0012\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0;j\u0002`<\u0012\u0016\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0;j\u0002`<\u00a2\u0006\u0004\b?\u0010@J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u001a\u0010\r\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J2\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u0012\u0010\u001d\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0004R\u001b\u0010\"\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010%R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00100\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u0010\u001f\u001a\u0004\b7\u00108\u00a8\u0006C"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/viewholder/ECNormalBaseLiveItemViewHolder;", "Lcom/tencent/ecommerce/biz/live/ui/viewholder/ECBaseLiveItemViewHolder;", "", "position", "Lcom/tencent/ecommerce/repo/live/q;", "liveProduct", "", "isEditable", "", "", "payloads", "", "Z", "Y", "Lcom/tencent/ecommerce/repo/live/r;", "showItem", "a0", "Lcom/tencent/ecommerce/repo/live/l;", "liveActivity", "f0", "j0", "i0", "width", "U", "", HippyControllerProps.STRING, "W", "e0", "t", "b0", "g0", "Lkotlin/Lazy;", "d0", "()Z", "isMaster", "Landroid/view/View;", "h0", "Landroid/view/View;", "productLayoutContainer", "activityProgressContainer", "Landroid/widget/ProgressBar;", "Landroid/widget/ProgressBar;", "progressBar", "Landroid/widget/TextView;", "k0", "Landroid/widget/TextView;", "countDownTextView", "l0", "remainStockTextView", "Landroid/widget/LinearLayout;", "m0", "Landroid/widget/LinearLayout;", "labelsLayoutContainer", "Landroid/graphics/Paint;", "n0", "c0", "()Landroid/graphics/Paint;", "remainStockPaint", "itemView", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/live/ui/adapter/CustomClick;", "onItemClick", "onActionClick", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "w0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class ECNormalBaseLiveItemViewHolder extends ECBaseLiveItemViewHolder {

    /* renamed from: o0, reason: collision with root package name */
    private static final Lazy f102798o0;

    /* renamed from: p0, reason: collision with root package name */
    private static final Lazy f102799p0;

    /* renamed from: q0, reason: collision with root package name */
    private static final Lazy f102800q0;

    /* renamed from: r0, reason: collision with root package name */
    private static final Lazy f102801r0;

    /* renamed from: s0, reason: collision with root package name */
    private static final Lazy f102802s0;

    /* renamed from: t0, reason: collision with root package name */
    private static final Lazy f102803t0;

    /* renamed from: u0, reason: collision with root package name */
    private static final Lazy f102804u0;

    /* renamed from: v0, reason: collision with root package name */
    private static final Lazy f102805v0;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final Lazy isMaster;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final View productLayoutContainer;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private final View activityProgressContainer;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private final ProgressBar progressBar;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private final TextView countDownTextView;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private final TextView remainStockTextView;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout labelsLayoutContainer;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private final Lazy remainStockPaint;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0013\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001b\u0010\u0016\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001b\u0010\u0019\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001b\u0010\u001c\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u0014\u0010\u001e\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0014\u0010$\u001a\u00020#8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006("}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/viewholder/ECNormalBaseLiveItemViewHolder$a;", "", "", "PROGRESS_BAR_DEFAULT_WIDTH$delegate", "Lkotlin/Lazy;", "d", "()I", "PROGRESS_BAR_DEFAULT_WIDTH", "RIGHT_PADDING$delegate", tl.h.F, "RIGHT_PADDING", "PROGRESS_MAX_WIDTH$delegate", "e", "PROGRESS_MAX_WIDTH", "REMAIN_TEXT_SIZE$delegate", "g", "REMAIN_TEXT_SIZE", "REMAIN_TEXT_PADDING$delegate", "f", "REMAIN_TEXT_PADDING", "LABEL_PADDING$delegate", "c", "LABEL_PADDING", "LABEL_CONTAINER_WIDTH_MAX$delegate", "a", "LABEL_CONTAINER_WIDTH_MAX", "LABEL_CONTAINER_WIDTH_MAX_EDITABLE$delegate", "b", "LABEL_CONTAINER_WIDTH_MAX_EDITABLE", "", "FAKE_PROGRESS_MAX", UserInfo.SEX_FEMALE, "MIN_PROGRESS_UI", "PROGRESS_MAX", "SHOW_STOCK_NUM_MIN", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalBaseLiveItemViewHolder$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final int a() {
            return ((Number) ECNormalBaseLiveItemViewHolder.f102804u0.getValue()).intValue();
        }

        public final int b() {
            return ((Number) ECNormalBaseLiveItemViewHolder.f102805v0.getValue()).intValue();
        }

        public final int c() {
            return ((Number) ECNormalBaseLiveItemViewHolder.f102803t0.getValue()).intValue();
        }

        public final int d() {
            return ((Number) ECNormalBaseLiveItemViewHolder.f102798o0.getValue()).intValue();
        }

        public final int e() {
            return ((Number) ECNormalBaseLiveItemViewHolder.f102800q0.getValue()).intValue();
        }

        public final int f() {
            return ((Number) ECNormalBaseLiveItemViewHolder.f102802s0.getValue()).intValue();
        }

        public final int g() {
            return ((Number) ECNormalBaseLiveItemViewHolder.f102801r0.getValue()).intValue();
        }

        public final int h() {
            return ((Number) ECNormalBaseLiveItemViewHolder.f102799p0.getValue()).intValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (!(animatedValue instanceof Float)) {
                animatedValue = null;
            }
            Float f16 = (Float) animatedValue;
            if (f16 != null) {
                ECNormalBaseLiveItemViewHolder.this.progressBar.setProgress((int) f16.floatValue());
            }
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalBaseLiveItemViewHolder$Companion$PROGRESS_BAR_DEFAULT_WIDTH$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(120.0f);
            }
        });
        f102798o0 = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalBaseLiveItemViewHolder$Companion$RIGHT_PADDING$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(16.0f);
            }
        });
        f102799p0 = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalBaseLiveItemViewHolder$Companion$PROGRESS_MAX_WIDTH$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(120.0f);
            }
        });
        f102800q0 = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalBaseLiveItemViewHolder$Companion$REMAIN_TEXT_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(10.0f);
            }
        });
        f102801r0 = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalBaseLiveItemViewHolder$Companion$REMAIN_TEXT_PADDING$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(10.0f);
            }
        });
        f102802s0 = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalBaseLiveItemViewHolder$Companion$LABEL_PADDING$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(5.0f);
            }
        });
        f102803t0 = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalBaseLiveItemViewHolder$Companion$LABEL_CONTAINER_WIDTH_MAX$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(240.0f);
            }
        });
        f102804u0 = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalBaseLiveItemViewHolder$Companion$LABEL_CONTAINER_WIDTH_MAX_EDITABLE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(163.0f);
            }
        });
        f102805v0 = lazy8;
    }

    public ECNormalBaseLiveItemViewHolder(View view, Function1<? super LiveProduct, Unit> function1, Function1<? super LiveProduct, Unit> function12) {
        super(view, function1, function12);
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalBaseLiveItemViewHolder$isMaster$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                return ECNormalBaseLiveItemViewHolder.this instanceof ECNormalMasterLiveItemViewHolder;
            }
        });
        this.isMaster = lazy;
        this.productLayoutContainer = view.findViewById(R.id.o7_);
        this.activityProgressContainer = view.findViewById(R.id.npc);
        this.progressBar = (ProgressBar) view.findViewById(R.id.ob6);
        this.countDownTextView = (TextView) view.findViewById(R.id.npe);
        this.remainStockTextView = (TextView) view.findViewById(R.id.npd);
        this.labelsLayoutContainer = (LinearLayout) view.findViewById(R.id.o79);
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Paint>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalBaseLiveItemViewHolder$remainStockPaint$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Paint invoke() {
                Paint paint = new Paint();
                paint.setTextSize(ECNormalBaseLiveItemViewHolder.INSTANCE.g());
                return paint;
            }
        });
        this.remainStockPaint = lazy2;
    }

    private final int W(String string) {
        return (int) c0().measureText(string);
    }

    private final void Z(int position, LiveProduct liveProduct, boolean isEditable, List<Object> payloads) {
        LiveActivity liveActivity;
        cg0.a.b("ECLiveNormalBaseItemViewHolder", "configItemUIWithPayloads position:" + position + " payloads:" + payloads + " liveProduct:" + liveProduct);
        Object obj = payloads.get(0);
        if (!(obj instanceof ItemPayload)) {
            obj = null;
        }
        ItemPayload itemPayload = (ItemPayload) obj;
        if (itemPayload != null) {
            int i3 = e.f102824a[itemPayload.payloadType.ordinal()];
            if (i3 == 1) {
                t(position, liveProduct, isEditable, null);
                return;
            }
            if (i3 == 2) {
                Object data = itemPayload.getData();
                String str = (String) (data instanceof String ? data : null);
                if (str != null) {
                    this.countDownTextView.setText(str);
                    return;
                }
                return;
            }
            if (i3 != 3) {
                if (i3 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (liveProduct == null || (liveActivity = liveProduct.getLiveActivity()) == null) {
                    return;
                }
                i0(liveActivity);
            }
        }
    }

    private final void a0(LiveShowItem showItem, boolean isEditable) {
        int a16;
        this.labelsLayoutContainer.setVisibility(0);
        this.labelsLayoutContainer.removeAllViews();
        this.activityProgressContainer.setVisibility(8);
        List<HotLabel> a17 = showItem.a();
        if (a17 != null) {
            boolean z16 = a17.size() > 2;
            int size = a17.size();
            int i3 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                HotLabel hotLabel = a17.get(i16);
                ECLiveLabelView eCLiveLabelView = new ECLiveLabelView(getContext(), null, 0, 6, null);
                eCLiveLabelView.c(hotLabel);
                ECLiveLabelView.Companion companion = ECLiveLabelView.INSTANCE;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, companion.a());
                if (i16 != 0) {
                    layoutParams.leftMargin = INSTANCE.c();
                } else {
                    layoutParams.leftMargin = 0;
                }
                if (z16) {
                    long currentTimeMillis = System.currentTimeMillis();
                    eCLiveLabelView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(companion.a(), 1073741824));
                    if (isEditable) {
                        a16 = INSTANCE.b();
                    } else {
                        a16 = INSTANCE.a();
                    }
                    int i17 = a16 - i3;
                    cg0.a.b("ECLiveNormalBaseItemViewHolder", "configLabelUI " + i16 + " measure cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms labelView.measuredWidth:" + eCLiveLabelView.getMeasuredWidth() + " remainWidth:" + i17);
                    if (i17 <= eCLiveLabelView.getMeasuredWidth()) {
                        return;
                    }
                    this.labelsLayoutContainer.addView(eCLiveLabelView, layoutParams);
                    i3 += eCLiveLabelView.getMeasuredWidth();
                    if (i16 != 0) {
                        i3 += INSTANCE.c();
                    }
                } else {
                    this.labelsLayoutContainer.addView(eCLiveLabelView, layoutParams);
                }
            }
        }
    }

    private final Paint c0() {
        return (Paint) this.remainStockPaint.getValue();
    }

    private final boolean d0() {
        return ((Boolean) this.isMaster.getValue()).booleanValue();
    }

    private final void e0(LiveActivity liveActivity) {
        long serverTimeMillis = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket().getServerTimeMillis() / 1000;
        if (d0() && serverTimeMillis < liveActivity.getActivityTimeRange().beginSec) {
            this.countDownTextView.setText(Intrinsics.stringPlus(ECDateUtil.f104850a.g(liveActivity.getActivityTimeRange().beginSec), "\u5f00\u552e"));
        } else {
            this.countDownTextView.setText(liveActivity.a(getContext()));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
    
        if ((!r0) == true) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void f0(LiveActivity liveActivity) {
        boolean z16;
        boolean isBlank;
        ActivitySellingPoint activitySellingPoint = liveActivity.getActivitySellingPoint();
        if (activitySellingPoint != null) {
            getPrePriceTextView().setText(activitySellingPoint.label);
            TextView prePriceTextView = getPrePriceTextView();
            String str = activitySellingPoint.label;
            if (str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                z16 = true;
            }
            z16 = false;
            prePriceTextView.setVisibility(z16 ? 0 : 8);
        }
        ActivityPrice activityPrice = liveActivity.getActivityPrice();
        if (activityPrice != null) {
            TextView priceTextView = getPriceTextView();
            com.tencent.ecommerce.biz.live.a aVar = com.tencent.ecommerce.biz.live.a.f102661d;
            priceTextView.setText(aVar.i(activityPrice.getLiveSpecialPrice()));
            getPriceSuffixTextView().setVisibility(8);
            if (activityPrice.livePrice > activityPrice.getLiveSpecialPrice()) {
                getSecondPriceTextView().setText('\u00a5' + aVar.i(activityPrice.livePrice));
                getSecondPriceTextView().setPaintFlags(getSecondPriceTextView().getPaintFlags() | 16);
                getSecondPriceTextView().setVisibility(0);
                return;
            }
            getSecondPriceTextView().setVisibility(8);
        }
    }

    private final int U(int width) {
        return (int) ((width / INSTANCE.e()) * 100.0f);
    }

    private final void Y(LiveProduct liveProduct, boolean isEditable) {
        LiveShowItem normalShowItem;
        if (liveProduct != null && liveProduct.F()) {
            this.activityProgressContainer.setVisibility(0);
            this.labelsLayoutContainer.setVisibility(8);
            LiveActivity liveActivity = liveProduct.getLiveActivity();
            if (liveActivity != null) {
                f0(liveActivity);
                j0(liveProduct, isEditable);
                i0(liveActivity);
                e0(liveActivity);
                return;
            }
            return;
        }
        if (liveProduct == null || !liveProduct.E()) {
            if (liveProduct == null || (normalShowItem = liveProduct.getNormalShowItem()) == null) {
                return;
            }
            a0(normalShowItem, isEditable);
            LiveProduct.Price price = normalShowItem.getPrice();
            if (price != null) {
                u(price, liveProduct.getOriPrice());
                return;
            }
            return;
        }
        LiveShowItem couponShowItem = liveProduct.getCouponShowItem();
        if (couponShowItem != null) {
            a0(couponShowItem, isEditable);
            LiveProduct.Price price2 = couponShowItem.getPrice();
            if (price2 != null) {
                u(price2, liveProduct.getOriPrice());
            }
        }
    }

    private final void j0(LiveProduct liveProduct, boolean isEditable) {
        if (isEditable) {
            ViewGroup.LayoutParams layoutParams = this.progressBar.getLayoutParams();
            if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
                layoutParams = null;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (layoutParams2 != null) {
                layoutParams2.width = 0;
                layoutParams2.weight = 1.0f;
                this.progressBar.setLayoutParams(layoutParams2);
            }
            this.productLayoutContainer.setPadding(0, 0, INSTANCE.h(), 0);
        } else {
            ProgressBar progressBar = this.progressBar;
            progressBar.getLayoutParams().width = INSTANCE.d();
            new LinearLayout.LayoutParams(progressBar.getLayoutParams()).weight = 0.0f;
            this.productLayoutContainer.setPadding(0, 0, 0, 0);
        }
        if (liveProduct.getIsExplaining()) {
            if (QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getNightManager().isNightMode()) {
                this.progressBar.setBackground(ECSkin.INSTANCE.getDrawable(R.drawable.bu9));
                return;
            } else {
                this.progressBar.setBackground(ECSkin.INSTANCE.getDrawable(R.drawable.blh));
                return;
            }
        }
        this.progressBar.setBackground(ECSkin.INSTANCE.getDrawable(R.drawable.bu9));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b0(LiveProduct liveProduct) {
        boolean z16;
        String adTxt;
        boolean z17;
        String adTxt2;
        boolean z18;
        boolean z19;
        boolean isBlank;
        boolean isBlank2;
        boolean z26;
        boolean isBlank3;
        boolean isBlank4;
        boolean z27;
        boolean isBlank5;
        boolean isBlank6;
        String adTxt3 = liveProduct != null ? liveProduct.getAdTxt() : null;
        if (adTxt3 != null) {
            isBlank6 = StringsKt__StringsJVMKt.isBlank(adTxt3);
            if (!isBlank6) {
                z16 = false;
                if (z16) {
                    String salesTxt = liveProduct != null ? liveProduct.getSalesTxt() : null;
                    if (salesTxt != null) {
                        isBlank5 = StringsKt__StringsJVMKt.isBlank(salesTxt);
                        if (!isBlank5) {
                            z27 = false;
                            if (z27) {
                                getSecondTitleTextView().setVisibility(8);
                                getThirdTitleTextView().setVisibility(8);
                                return;
                            }
                        }
                    }
                    z27 = true;
                    if (z27) {
                    }
                }
                adTxt = liveProduct == null ? liveProduct.getAdTxt() : null;
                if (adTxt != null) {
                    isBlank4 = StringsKt__StringsJVMKt.isBlank(adTxt);
                    if (!isBlank4) {
                        z17 = false;
                        if (!z17) {
                            String salesTxt2 = liveProduct != null ? liveProduct.getSalesTxt() : null;
                            if (salesTxt2 != null) {
                                isBlank3 = StringsKt__StringsJVMKt.isBlank(salesTxt2);
                                if (!isBlank3) {
                                    z26 = false;
                                    if (z26) {
                                        getSecondTitleTextView().setText(liveProduct != null ? liveProduct.getAdTxt() : null);
                                        getSecondTitleTextView().setVisibility(0);
                                        getThirdTitleTextView().setVisibility(8);
                                        return;
                                    }
                                }
                            }
                            z26 = true;
                            if (z26) {
                            }
                        }
                        adTxt2 = liveProduct != null ? liveProduct.getAdTxt() : null;
                        if (adTxt2 != null) {
                            isBlank2 = StringsKt__StringsJVMKt.isBlank(adTxt2);
                            if (!isBlank2) {
                                z18 = false;
                                if (z18) {
                                    String salesTxt3 = liveProduct != null ? liveProduct.getSalesTxt() : null;
                                    if (salesTxt3 != null) {
                                        isBlank = StringsKt__StringsJVMKt.isBlank(salesTxt3);
                                        if (!isBlank) {
                                            z19 = false;
                                            if (!z19) {
                                                getSecondTitleTextView().setText(liveProduct != null ? liveProduct.getSalesTxt() : null);
                                                getSecondTitleTextView().setVisibility(0);
                                                getThirdTitleTextView().setVisibility(8);
                                                return;
                                            }
                                        }
                                    }
                                    z19 = true;
                                    if (!z19) {
                                    }
                                }
                                getSecondTitleTextView().setText(liveProduct == null ? liveProduct.getAdTxt() : null);
                                getSecondTitleTextView().setVisibility(0);
                                if ((liveProduct != null || !liveProduct.F()) && (liveProduct == null || !liveProduct.E())) {
                                    if ((liveProduct == null ? liveProduct.getNormalShowItem() : null) == null) {
                                        getThirdTitleTextView().setText(liveProduct != null ? liveProduct.getSalesTxt() : null);
                                        getThirdTitleTextView().setVisibility(0);
                                        return;
                                    }
                                }
                                getThirdTitleTextView().setVisibility(8);
                            }
                        }
                        z18 = true;
                        if (z18) {
                        }
                        getSecondTitleTextView().setText(liveProduct == null ? liveProduct.getAdTxt() : null);
                        getSecondTitleTextView().setVisibility(0);
                        if (liveProduct != null) {
                        }
                        if ((liveProduct == null ? liveProduct.getNormalShowItem() : null) == null) {
                        }
                        getThirdTitleTextView().setVisibility(8);
                    }
                }
                z17 = true;
                if (!z17) {
                }
                if (liveProduct != null) {
                }
                if (adTxt2 != null) {
                }
                z18 = true;
                if (z18) {
                }
                getSecondTitleTextView().setText(liveProduct == null ? liveProduct.getAdTxt() : null);
                getSecondTitleTextView().setVisibility(0);
                if (liveProduct != null) {
                }
                if ((liveProduct == null ? liveProduct.getNormalShowItem() : null) == null) {
                }
                getThirdTitleTextView().setVisibility(8);
            }
        }
        z16 = true;
        if (z16) {
        }
        if (liveProduct == null) {
        }
        if (adTxt != null) {
        }
        z17 = true;
        if (!z17) {
        }
        if (liveProduct != null) {
        }
        if (adTxt2 != null) {
        }
        z18 = true;
        if (z18) {
        }
        getSecondTitleTextView().setText(liveProduct == null ? liveProduct.getAdTxt() : null);
        getSecondTitleTextView().setVisibility(0);
        if (liveProduct != null) {
        }
        if ((liveProduct == null ? liveProduct.getNormalShowItem() : null) == null) {
        }
        getThirdTitleTextView().setVisibility(8);
    }

    @Override // com.tencent.ecommerce.biz.live.ui.viewholder.ECBaseLiveItemViewHolder
    public void t(int position, LiveProduct liveProduct, boolean isEditable, List<Object> payloads) {
        boolean isBlank;
        boolean z16 = true;
        if (payloads != null && (!payloads.isEmpty()) && liveProduct != null && liveProduct.F()) {
            Z(position, liveProduct, isEditable, payloads);
            return;
        }
        if (d0()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(position + 1)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            getIndexTextView().setText(format);
        } else {
            String indexTxt = liveProduct != null ? liveProduct.getIndexTxt() : null;
            if (indexTxt != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(indexTxt);
                if (!isBlank) {
                    z16 = false;
                }
            }
            if (!z16) {
                getIndexTextView().setText(liveProduct != null ? liveProduct.getIndexTxt() : null);
            }
        }
        super.t(position, liveProduct, isEditable, payloads);
        Y(liveProduct, isEditable);
        ei0.d.f396304b.g(getItemRoot(), liveProduct);
    }

    private final void i0(LiveActivity liveActivity) {
        String string;
        int i3 = (int) 35.0f;
        int color = getContext().getResources().getColor(R.color.f62815);
        ActivityStock activityStock = liveActivity.getActivityStock();
        ActivityStatus activityStatus = liveActivity.getActivityStatus();
        int i16 = e.f102825b[liveActivity.n().ordinal()];
        String str = null;
        if (i16 == 1) {
            i3 = (int) 100.0f;
            if (d0()) {
                str = getContext().getString(R.string.wlf, Long.valueOf(activityStock.getActivityInit()));
            } else if (QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket().getServerTimeMillis() / 1000 < liveActivity.getActivityTimeRange().beginSec) {
                str = ECDateUtil.f104850a.g(liveActivity.getActivityTimeRange().beginSec) + "\u5f00\u552e";
            }
            getIndexTextView().setText(getIndexTextView().getText() + TokenParser.SP + getContext().getString(R.string.wm5));
            getIndexTextView().setBackground(getContext().getDrawable(R.drawable.bj8));
        } else if (i16 != 2) {
            getIndexTextView().setBackground(getContext().getDrawable(R.drawable.bj7));
        } else {
            getIndexTextView().setBackground(getContext().getDrawable(R.drawable.bj7));
            if (!activityStock.d() && activityStock.getActivityInit() > 0) {
                if (d0()) {
                    String string2 = getContext().getString(R.string.wlf, Long.valueOf(activityStock.activityRemain));
                    long currentTimeMillis = System.currentTimeMillis();
                    float activityInit = (((float) activityStock.activityRemain) / ((float) activityStock.getActivityInit())) * 100.0f;
                    Companion companion = INSTANCE;
                    float e16 = (activityInit / 100.0f) * companion.e();
                    int W = W(string2) + companion.f();
                    if (e16 < W) {
                        if (activityStock.activityRemain >= 10000) {
                            string2 = '\u5269' + i.f104869a.e(activityStock.activityRemain) + '\u4ef6';
                            int W2 = W(string2) + companion.f();
                            if (e16 < W2) {
                                i3 = U(W2);
                            }
                        } else {
                            i3 = U(W);
                        }
                        cg0.a.b("ECLiveNormalBaseItemViewHolder", "updateActivityProgressContent cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms progress:" + i3);
                        str = string2;
                    }
                    i3 = (int) activityInit;
                    cg0.a.b("ECLiveNormalBaseItemViewHolder", "updateActivityProgressContent cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms progress:" + i3);
                    str = string2;
                } else if (activityStatus == ActivityStatus.ACTIVITY_STATUS_PENDING) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(100.0f, 90.0f);
                    ofFloat.setDuration(300L);
                    ofFloat.setRepeatCount(1);
                    ofFloat.setInterpolator(new LinearInterpolator());
                    ofFloat.addUpdateListener(new b());
                    ofFloat.start();
                } else {
                    long j3 = activityStock.activityRemain;
                    int max = (int) Math.max((((float) j3) / ((float) activityStock.getActivityInit())) * 90.0f, 35.0f);
                    if (((float) j3) <= 10.0f) {
                        string = getContext().getString(R.string.wlf, Long.valueOf(j3));
                    } else {
                        string = getContext().getString(R.string.wlk);
                    }
                    str = string;
                    i3 = max;
                }
            } else {
                str = getContext().getString(R.string.wlf, 0L);
                color = getContext().getResources().getColor(R.color.f6411h);
                i3 = 0;
            }
        }
        this.progressBar.setProgress(i3);
        this.remainStockTextView.setText(str);
        this.remainStockTextView.setTextColor(color);
    }
}
