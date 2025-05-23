package com.tencent.mobileqq.aio.reserve2.animate;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.reserve2.animate.PhotoPanelDragAnimateState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.x;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 @2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001AB\u000f\u0012\u0006\u0010=\u001a\u00020\u0015\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\f\u001a\u00020\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00040\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0016\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001b0\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016R$\u0010$\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve2/animate/PhotoPanelSwipeAnimateVB;", "Lcom/tencent/qqnt/aio/lazy/lazyInit/a;", "Lol3/b;", "Lcom/tencent/mobileqq/aio/reserve2/animate/PhotoPanelDragAnimateState;", "", "m1", "Lcom/tencent/mobileqq/aio/reserve2/animate/PhotoPanelDragAnimateState$PhotoPanelAnimateState;", "uiState", "p1", "Lkotlin/Function1;", "Lcom/airbnb/lottie/LottieDrawable;", "cb", "g1", "", "ratio", "", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/base/route/MsgIntent;", "initIntent", "Lcom/tencent/qqnt/aio/lazy/lazyInit/b;", "b1", "l1", "", "Ljava/lang/Class;", "getObserverStates", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "e", "Lcom/airbnb/lottie/LottieDrawable;", "getMLottieDrawable", "()Lcom/airbnb/lottie/LottieDrawable;", "setMLottieDrawable", "(Lcom/airbnb/lottie/LottieDrawable;)V", "mLottieDrawable", "Lcom/airbnb/lottie/LottieAnimationView;", "f", "Lcom/airbnb/lottie/LottieAnimationView;", "j1", "()Lcom/airbnb/lottie/LottieAnimationView;", ICustomDataEditor.NUMBER_PARAM_1, "(Lcom/airbnb/lottie/LottieAnimationView;)V", "lottieAnimationView", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "k1", "()Landroid/widget/TextView;", "o1", "(Landroid/widget/TextView;)V", "sendTipsView", "Landroid/content/Context;", "i", "Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/RelativeLayout;", "root", "initMsgIntent", "<init>", "(Lcom/tencent/mvi/base/route/MsgIntent;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PhotoPanelSwipeAnimateVB extends com.tencent.qqnt.aio.lazy.lazyInit.a<ol3.b, PhotoPanelDragAnimateState> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Lazy<Integer> D;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LottieDrawable mLottieDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public LottieAnimationView lottieAnimationView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public TextView sendTipsView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout root;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0016\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve2/animate/PhotoPanelSwipeAnimateVB$a;", "", "", "STAR_COLOR_AlPHA$delegate", "Lkotlin/Lazy;", "b", "()I", "STAR_COLOR_AlPHA", "", "COLOR_AlPHA_CHANGE_PERCENT", UserInfo.SEX_FEMALE, "END_COLOR_ALPHA", "I", "END_COLOR_BLUE", "END_COLOR_GREEN", "END_COLOR_RED", "", "LOTTIE_FILE", "Ljava/lang/String;", "STAR_COLOR_BLUE", "STAR_COLOR_GREEN", "STAR_COLOR_RED", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.reserve2.animate.PhotoPanelSwipeAnimateVB$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b() {
            return ((Number) PhotoPanelSwipeAnimateVB.D.getValue()).intValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<Integer> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64863);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(PhotoPanelSwipeAnimateVB$Companion$STAR_COLOR_AlPHA$2.INSTANCE);
        D = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoPanelSwipeAnimateVB(@NotNull MsgIntent initMsgIntent) {
        super(initMsgIntent);
        Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) initMsgIntent);
        }
    }

    private final int f1(float ratio) {
        int b16;
        int i3 = 26;
        int i16 = 8;
        int i17 = 3;
        if (ratio < 0.8f) {
            Companion companion = INSTANCE;
            b16 = (int) (companion.b() + ((204 - companion.b()) * ratio));
        } else {
            i17 = (int) (3 + (27 * ratio));
            i16 = (int) (8 + (178 * ratio));
            i3 = (int) (26 + (226 * ratio));
            b16 = INSTANCE.b();
        }
        return Color.argb(b16, i17, i16, i3);
    }

    private final void g1(final Function1<? super LottieDrawable, Unit> cb5) {
        LottieDrawable lottieDrawable = this.mLottieDrawable;
        if (lottieDrawable != null) {
            cb5.invoke(lottieDrawable);
        } else {
            LottieCompositionFactory.fromAsset(getMContext(), "photo_list_panel_drag.json").addListener(new LottieListener() { // from class: com.tencent.mobileqq.aio.reserve2.animate.a
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    PhotoPanelSwipeAnimateVB.h1(PhotoPanelSwipeAnimateVB.this, cb5, (LottieComposition) obj);
                }
            }).addFailureListener(new LottieListener() { // from class: com.tencent.mobileqq.aio.reserve2.animate.b
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    PhotoPanelSwipeAnimateVB.i1((Throwable) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(PhotoPanelSwipeAnimateVB this$0, Function1 cb5, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        if (this$0.mLottieDrawable == null) {
            LottieDrawable lottieDrawable = new LottieDrawable();
            this$0.mLottieDrawable = lottieDrawable;
            lottieDrawable.setComposition(lottieComposition);
            LottieDrawable lottieDrawable2 = this$0.mLottieDrawable;
            if (lottieDrawable2 != null) {
                lottieDrawable2.setRepeatCount(-1);
            }
        }
        cb5.invoke(this$0.mLottieDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(Throwable th5) {
        QLog.e("GuildPhotoPanelSwipeAnimateVB", 1, "loadLottieERR " + th5);
    }

    private final void m1() {
        if (this.lottieAnimationView == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("GuildPhotoPanelSwipeAnimateVB", 2, "initView lottieAnimationView");
            }
            LottieAnimationView lottieAnimationView = new LottieAnimationView(this.context);
            lottieAnimationView.setId(View.generateViewId());
            lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(x.a(60.0f), x.a(60.0f));
            layoutParams.addRule(14);
            layoutParams.addRule(15);
            lottieAnimationView.setLayoutParams(layoutParams);
            n1(lottieAnimationView);
            RelativeLayout relativeLayout = this.root;
            if (relativeLayout != null) {
                relativeLayout.addView(j1());
            }
        }
        if (this.sendTipsView == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("GuildPhotoPanelSwipeAnimateVB", 2, "initView sendTipsView");
            }
            TextView textView = new TextView(this.context);
            textView.setId(View.generateViewId());
            textView.setTextColor(-1);
            textView.setTextSize(17.0f);
            textView.setTypeface(Typeface.defaultFromStyle(1));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = x.a(9.0f);
            layoutParams2.addRule(3, j1().getId());
            layoutParams2.addRule(14);
            textView.setLayoutParams(layoutParams2);
            o1(textView);
            RelativeLayout relativeLayout2 = this.root;
            if (relativeLayout2 != null) {
                relativeLayout2.addView(k1());
            }
        }
    }

    private final void p1(PhotoPanelDragAnimateState.PhotoPanelAnimateState uiState) {
        final float a16;
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildPhotoPanelSwipeAnimateVB", 2, "update " + uiState.b() + " " + uiState.a());
        }
        m1();
        if (uiState.a() > 1.0f) {
            a16 = 1.0f;
        } else {
            a16 = uiState.a();
        }
        if (uiState.b()) {
            View hostView = getHostView();
            hostView.setBackgroundColor(f1(a16));
            hostView.setVisibility(0);
            LottieAnimationView j16 = j1();
            j16.setScaleX(a16);
            j16.setScaleY(a16);
            g1(new Function1<LottieDrawable, Unit>(a16, this) { // from class: com.tencent.mobileqq.aio.reserve2.animate.PhotoPanelSwipeAnimateVB$updatePhotoPanelAnimate$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ float $ratio;
                final /* synthetic */ PhotoPanelSwipeAnimateVB this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$ratio = a16;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, Float.valueOf(a16), this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LottieDrawable lottieDrawable) {
                    invoke2(lottieDrawable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable LottieDrawable lottieDrawable) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) lottieDrawable);
                        return;
                    }
                    if (this.$ratio >= 1.0f) {
                        if ((lottieDrawable == null || lottieDrawable.isRunning()) ? false : true) {
                            this.this$0.j1().setPadding(0, 0, 0, 0);
                            this.this$0.j1().setImageDrawable(lottieDrawable);
                            lottieDrawable.start();
                            return;
                        }
                        return;
                    }
                    if (lottieDrawable != null) {
                        lottieDrawable.cancelAnimation();
                    }
                    this.this$0.j1().setImageResource(R.drawable.k6j);
                    LottieAnimationView j17 = this.this$0.j1();
                    int a17 = x.a(8.0f);
                    j17.setPadding(a17, a17, a17, a17);
                }
            });
            TextView k16 = k1();
            if (a16 >= 1.0f) {
                k16.setText(R.string.f174162v4);
                return;
            } else {
                k16.setText(R.string.f174152v3);
                return;
            }
        }
        getHostView().setVisibility(8);
    }

    @Override // com.tencent.qqnt.aio.lazy.lazyInit.a
    @NotNull
    public com.tencent.qqnt.aio.lazy.lazyInit.b<ol3.b, PhotoPanelDragAnimateState> b1(@NotNull MsgIntent initIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.qqnt.aio.lazy.lazyInit.b) iPatchRedirector.redirect((short) 9, (Object) this, (Object) initIntent);
        }
        Intrinsics.checkNotNullParameter(initIntent, "initIntent");
        return new c(initIntent);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends PhotoPanelDragAnimateState>> getObserverStates() {
        List<Class<? extends PhotoPanelDragAnimateState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(PhotoPanelDragAnimateState.PhotoPanelAnimateState.class);
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 11, (Object) this);
    }

    @NotNull
    public final LottieAnimationView j1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LottieAnimationView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        LottieAnimationView lottieAnimationView = this.lottieAnimationView;
        if (lottieAnimationView != null) {
            return lottieAnimationView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lottieAnimationView");
        return null;
    }

    @NotNull
    public final TextView k1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TextView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        TextView textView = this.sendTipsView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sendTipsView");
        return null;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull PhotoPanelDragAnimateState uiState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) uiState);
            return;
        }
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        if (uiState instanceof PhotoPanelDragAnimateState.PhotoPanelAnimateState) {
            p1((PhotoPanelDragAnimateState.PhotoPanelAnimateState) uiState);
        }
    }

    public final void n1(@NotNull LottieAnimationView lottieAnimationView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) lottieAnimationView);
        } else {
            Intrinsics.checkNotNullParameter(lottieAnimationView, "<set-?>");
            this.lottieAnimationView = lottieAnimationView;
        }
    }

    public final void o1(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.sendTipsView = textView;
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        this.context = createViewParams.a();
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        relativeLayout.setBackgroundResource(R.color.black);
        relativeLayout.setAlpha(0.6f);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, 0);
        layoutParams.topToTop = 0;
        layoutParams.bottomToTop = R.id.slg;
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setVisibility(8);
        this.root = relativeLayout;
        return relativeLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onDestroy();
        LottieDrawable lottieDrawable = this.mLottieDrawable;
        if (lottieDrawable != null) {
            lottieDrawable.cancelAnimation();
        }
        if (this.lottieAnimationView != null) {
            j1().cancelAnimation();
        }
    }
}
