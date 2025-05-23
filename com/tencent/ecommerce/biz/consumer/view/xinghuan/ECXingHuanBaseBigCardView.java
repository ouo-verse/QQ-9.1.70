package com.tencent.ecommerce.biz.consumer.view.xinghuan;

import ah0.b;
import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import cg0.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.videnevent.api.IECVideoControlDelegate;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView;
import com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00182\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/J4\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000e\u001a\u00020\fH&J@\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H&JX\u0010\"\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H&J8\u0010#\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H&J8\u0010$\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H&J\b\u0010%\u001a\u00020\fH&J\u0018\u0010(\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0002H\u0014J\u000e\u0010+\u001a\u00020\f2\u0006\u0010*\u001a\u00020)\u00a8\u00061"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanBaseBigCardView;", "Landroid/widget/FrameLayout;", "", "uiType", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IECXingHuanGameButton;", "bigBtn", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "clickListener", "Landroid/view/View$OnClickListener;", "closeListener", "", "f", "i", "smallBgWidth", "smallBgHeight", "smallIconWidth", "smallIconHeight", "", "smallBgLoc", "smallTitleLoc", "Landroid/animation/Animator$AnimatorListener;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mediumBgWidth", "mediumBgHeight", "mediumCoverWidth", "mediumCoverHeight", "mediumBtnWidth", "mediumBtnHeight", "mediumBgLoc", "mediumBtnLoc", "mediumTitleLoc", "l", "k", "j", h.F, "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "contentId", "g", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class ECXingHuanBaseBigCardView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f101863d;

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy f101864e;

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy f101865f;

    /* renamed from: h, reason: collision with root package name */
    private static final Lazy f101866h;

    /* renamed from: i, reason: collision with root package name */
    private static final b f101867i;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0017\u0010\u0012\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00168\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u001bR\u0014\u0010!\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanBaseBigCardView$a;", "", "", "BIG_CARD_MARGIN_FLOAT$delegate", "Lkotlin/Lazy;", "b", "()F", "BIG_CARD_MARGIN_FLOAT", "BIG_MEDIUM_GAP_CARD_MARGIN_FLOAT$delegate", "d", "BIG_MEDIUM_GAP_CARD_MARGIN_FLOAT", "TEXT_CUSTOM_MARGIN_FLOAT$delegate", "e", "TEXT_CUSTOM_MARGIN_FLOAT", "BIG_MEDIUM_BTN_GAP_FLOAT$delegate", "c", "BIG_MEDIUM_BTN_GAP_FLOAT", "Lah0/b;", "BEZIER_TRANSLATION_A", "Lah0/b;", "a", "()Lah0/b;", "", "ALPHA_ANIMATION_DURATION", "J", "ANIMATION_DURATION", "BTN_SIZE_MEDIUM_DIVIDE_BIG", UserInfo.SEX_FEMALE, "DELAY_ALPHA_ANIMATION_DURATION", "", "TAG", "Ljava/lang/String;", "TEXT_SIZE_MEDIUM_DIVIDE_BIG", "TEXT_SIZE_SMALL_DIVIDE_BIG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final b a() {
            return ECXingHuanBaseBigCardView.f101867i;
        }

        public final float b() {
            return ((Number) ECXingHuanBaseBigCardView.f101863d.getValue()).floatValue();
        }

        public final float c() {
            return ((Number) ECXingHuanBaseBigCardView.f101866h.getValue()).floatValue();
        }

        public final float d() {
            return ((Number) ECXingHuanBaseBigCardView.f101864e.getValue()).floatValue();
        }

        public final float e() {
            return ((Number) ECXingHuanBaseBigCardView.f101865f.getValue()).floatValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView$Companion$BIG_CARD_MARGIN_FLOAT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(12.0f);
            }
        });
        f101863d = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView$Companion$BIG_MEDIUM_GAP_CARD_MARGIN_FLOAT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(4.0f);
            }
        });
        f101864e = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView$Companion$TEXT_CUSTOM_MARGIN_FLOAT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(20.0f);
            }
        });
        f101865f = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView$Companion$BIG_MEDIUM_BTN_GAP_FLOAT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(52.0f);
            }
        });
        f101866h = lazy4;
        f101867i = new b(0.4f, 0.0f, 0.68f, 0.06f);
    }

    public ECXingHuanBaseBigCardView(Context context) {
        super(context);
    }

    public abstract void f(int uiType, UIInfo uiInfo, IECXingHuanGameButton bigBtn, IECGoodsCardView.IGoodsCardClickListener clickListener, View.OnClickListener closeListener);

    public final void g(String contentId) {
        IECVideoControlDelegate videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl();
        if (videoControl != null) {
            videoControl.sendVideoInfoViewShowEvent(contentId, false, true);
        }
    }

    public abstract void h();

    public abstract void i();

    public abstract void j(int mediumBgWidth, int mediumBgHeight, int mediumCoverWidth, int mediumCoverHeight, int[] mediumBgLoc, Animator.AnimatorListener listener);

    public abstract void k(int smallBgWidth, int smallBgHeight, int smallIconWidth, int smallIconHeight, int[] smallBgLoc, Animator.AnimatorListener listener);

    public abstract void l(int mediumBgWidth, int mediumBgHeight, int mediumCoverWidth, int mediumCoverHeight, int mediumBtnWidth, int mediumBtnHeight, int[] mediumBgLoc, int[] mediumBtnLoc, int[] mediumTitleLoc, Animator.AnimatorListener listener);

    public abstract void m(int smallBgWidth, int smallBgHeight, int smallIconWidth, int smallIconHeight, int[] smallBgLoc, int[] smallTitleLoc, Animator.AnimatorListener listener);

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        ECXingHuanGameCardView.Companion companion = ECXingHuanGameCardView.INSTANCE;
        if (size > companion.i()) {
            a.b("ECXingHuanBaseBigCardView", "adjust width " + size + " to " + companion.i());
            size = companion.i();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), heightMeasureSpec);
    }
}
