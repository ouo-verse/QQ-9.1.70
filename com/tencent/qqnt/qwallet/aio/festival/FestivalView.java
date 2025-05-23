package com.tencent.qqnt.qwallet.aio.festival;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi;
import com.tencent.mobileqq.qwallet.hb.view.FestivalHbPagView;
import com.tencent.mobileqq.qwallet.k;
import com.tencent.mobileqq.qwallet.utils.m;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qwallet.aio.hb.AbstractHbView;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGView;
import tk2.FestivalHbData;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010G\u001a\u00020F\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0014J\b\u0010\u0010\u001a\u00020\u0005H\u0014J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u001b\u0010$\u001a\u00020\u001f8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u0004\u0018\u00010)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001a\u0010;\u001a\u00020\t8\u0014X\u0094D\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00101R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\t0>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u001c\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u001c\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010@\u00a8\u0006J"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/festival/FestivalView;", "Lcom/tencent/qqnt/qwallet/aio/hb/AbstractHbView;", "Landroidx/lifecycle/LifecycleObserver;", "Ltk2/a$b;", "anim", "", "d1", ICustomDataEditor.STRING_ARRAY_PARAM_1, "b1", "", "X0", "initView", "Landroid/view/View;", "E0", "z0", "D0", "K0", "L0", "stateText", "I0", "onResume", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "coverView", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "tailView", UserInfo.SEX_FEMALE, "stateView", "Lcom/tencent/qqnt/qwallet/aio/festival/FestivalViewModel;", "G", "Lkotlin/Lazy;", "Z0", "()Lcom/tencent/qqnt/qwallet/aio/festival/FestivalViewModel;", "viewModel", "", "H", "I", "layoutResId", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "Lcom/tencent/mobileqq/qwallet/hb/view/FestivalHbPagView;", "J", "Lcom/tencent/mobileqq/qwallet/hb/view/FestivalHbPagView;", "animView", "K", "Ltk2/a$b;", "currentAnim", "Lcom/tencent/mobileqq/qwallet/hb/IQWalletFestivalHbApi;", "L", "Lcom/tencent/mobileqq/qwallet/hb/IQWalletFestivalHbApi;", "hbApi", "M", "Ljava/lang/String;", "Y0", "()Ljava/lang/String;", "typeText", "N", "cancelAnim", "Landroidx/lifecycle/Observer;", "P", "Landroidx/lifecycle/Observer;", "tailObserver", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "animObserver", BdhLogUtil.LogTag.Tag_Req, "bgObserver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class FestivalView extends AbstractHbView {

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView coverView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView tailView;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView stateView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: H, reason: from kotlin metadata */
    private final int layoutResId;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private final Drawable defaultDrawable;

    /* renamed from: J, reason: from kotlin metadata */
    private FestivalHbPagView animView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private FestivalHbData.Anim currentAnim;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final IQWalletFestivalHbApi hbApi;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final String typeText;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private FestivalHbData.Anim cancelAnim;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Observer<String> tailObserver;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Observer<FestivalHbData.Anim> animObserver;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Observer<FestivalHbData.Anim> bgObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FestivalView(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FestivalViewModel>() { // from class: com.tencent.qqnt.qwallet.aio.festival.FestivalView$viewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FestivalViewModel invoke() {
                return new FestivalViewModel();
            }
        });
        this.viewModel = lazy;
        this.layoutResId = R.layout.hhs;
        this.defaultDrawable = ContextCompat.getDrawable(MobileQQ.sMobileQQ, R.drawable.fpw);
        QRouteApi api = QRoute.api(IQWalletFestivalHbApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQWalletFestivalHbApi::class.java)");
        this.hbApi = (IQWalletFestivalHbApi) api;
        this.typeText = "\u8282\u65e5\u7ea2\u5305";
        this.tailObserver = new Observer() { // from class: com.tencent.qqnt.qwallet.aio.festival.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FestivalView.c1(FestivalView.this, (String) obj);
            }
        };
        this.animObserver = new Observer() { // from class: com.tencent.qqnt.qwallet.aio.festival.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FestivalView.V0(FestivalView.this, (FestivalHbData.Anim) obj);
            }
        };
        this.bgObserver = new Observer() { // from class: com.tencent.qqnt.qwallet.aio.festival.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FestivalView.W0(FestivalView.this, (FestivalHbData.Anim) obj);
            }
        };
        m mVar = m.f279290a;
        int b16 = mVar.b(context, R.dimen.cav);
        int b17 = mVar.b(context, R.dimen.caw);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.setMargins(b16, b17, b16, 0);
        setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(FestivalView this$0, FestivalHbData.Anim anim) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (anim == null) {
            FestivalHbPagView festivalHbPagView = this$0.animView;
            if (festivalHbPagView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animView");
                festivalHbPagView = null;
            }
            festivalHbPagView.setVisibility(4);
            QLog.d(this$0.getTAG(), 1, "animObserver" + this$0.X0() + " anim == null");
            return;
        }
        QLog.d(this$0.getTAG(), 1, "animObserver" + this$0.X0() + " post");
        this$0.a1(anim);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(FestivalView this$0, FestivalHbData.Anim anim) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.getTAG(), 1, "bgObserver" + this$0.X0() + " anim = " + anim);
        if (anim == null) {
            return;
        }
        this$0.currentAnim = anim;
        this$0.d1(anim);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String X0() {
        return W0().h2();
    }

    private final void a1(final FestivalHbData.Anim anim) {
        boolean z16;
        if (W0().S1().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        FestivalHbPagView festivalHbPagView = null;
        if (z16) {
            FestivalHbPagView festivalHbPagView2 = this.animView;
            if (festivalHbPagView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animView");
            } else {
                festivalHbPagView = festivalHbPagView2;
            }
            festivalHbPagView.setVisibility(4);
            QLog.i(getTAG(), 1, "[playBgAnim" + X0() + "],return state is not empty");
            return;
        }
        if (anim != null && !a.f361721a.d(W0().k2(), W0().M1().getMsgTime())) {
            QLog.i(getTAG(), 1, "[playBgAnim" + X0() + "], start");
            b1();
            FestivalHbPagView festivalHbPagView3 = this.animView;
            if (festivalHbPagView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animView");
                festivalHbPagView3 = null;
            }
            festivalHbPagView3.setVisibility(0);
            this.cancelAnim = null;
            FestivalHbPagView festivalHbPagView4 = this.animView;
            if (festivalHbPagView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animView");
            } else {
                festivalHbPagView = festivalHbPagView4;
            }
            festivalHbPagView.i().api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.qqnt.qwallet.aio.festival.FestivalView$playBgAnim$1$1

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/qwallet/aio/festival/FestivalView$playBgAnim$1$1$a", "Lcom/tencent/mobileqq/qwallet/hb/view/FestivalHbPagView$a;", "Lorg/libpag/PAGView;", "pagView", "", "onAnimationCancel", "onAnimationEnd", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes25.dex */
                public static final class a extends FestivalHbPagView.a {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ PAGView f361716d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ FestivalView f361717e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ FestivalHbData.Anim f361718f;

                    a(PAGView pAGView, FestivalView festivalView, FestivalHbData.Anim anim) {
                        this.f361716d = pAGView;
                        this.f361717e = festivalView;
                        this.f361718f = anim;
                    }

                    @Override // com.tencent.mobileqq.qwallet.hb.view.FestivalHbPagView.a, org.libpag.PAGView.PAGViewListener
                    public void onAnimationCancel(@Nullable PAGView pagView) {
                        FestivalHbPagView festivalHbPagView;
                        String tag;
                        String X0;
                        this.f361716d.removeListener(this);
                        this.f361717e.cancelAnim = this.f361718f;
                        festivalHbPagView = this.f361717e.animView;
                        if (festivalHbPagView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("animView");
                            festivalHbPagView = null;
                        }
                        festivalHbPagView.setVisibility(4);
                        tag = this.f361717e.getTAG();
                        X0 = this.f361717e.X0();
                        QLog.e(tag, 1, "[playBgAnim" + X0 + "] onAnimationCancel");
                    }

                    @Override // org.libpag.PAGView.PAGViewListener
                    public void onAnimationEnd(@Nullable PAGView pagView) {
                        FestivalHbPagView festivalHbPagView;
                        String tag;
                        String X0;
                        this.f361716d.removeListener(this);
                        festivalHbPagView = this.f361717e.animView;
                        if (festivalHbPagView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("animView");
                            festivalHbPagView = null;
                        }
                        festivalHbPagView.setVisibility(4);
                        com.tencent.qqnt.qwallet.aio.festival.a.f361721a.a(this.f361717e.W0().k2(), this.f361717e.W0().M1().getMsgTime());
                        tag = this.f361717e.getTAG();
                        X0 = this.f361717e.X0();
                        QLog.i(tag, 1, "[playBgAnim" + X0 + "] onAnimationEnd");
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                    invoke2(pAGView);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PAGView it) {
                    IQWalletFestivalHbApi iQWalletFestivalHbApi;
                    FestivalHbPagView festivalHbPagView5;
                    String tag;
                    String X0;
                    FestivalHbPagView festivalHbPagView6;
                    String tag2;
                    String X02;
                    Intrinsics.checkNotNullParameter(it, "it");
                    FestivalView festivalView = FestivalView.this;
                    FestivalHbData.Anim anim2 = anim;
                    if (it.isPlaying()) {
                        tag2 = festivalView.getTAG();
                        X02 = festivalView.X0();
                        QLog.i(tag2, 1, "[playBgAnim" + X02 + "] isPlaying stop");
                        it.stop();
                    }
                    iQWalletFestivalHbApi = festivalView.hbApi;
                    it.setPath(iQWalletFestivalHbApi.getResPath(anim2.getAioUrl(), anim2.getAioAnimSuffix()));
                    it.setRepeatCount(1);
                    it.addListener(new a(it, festivalView, anim2));
                    it.play();
                    festivalHbPagView5 = festivalView.animView;
                    FestivalHbPagView festivalHbPagView7 = null;
                    if (festivalHbPagView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("animView");
                        festivalHbPagView5 = null;
                    }
                    festivalHbPagView5.setVisibility(0);
                    tag = festivalView.getTAG();
                    X0 = festivalView.X0();
                    QLog.i(tag, 1, "[playBgAnim" + X0 + "] play");
                    festivalHbPagView6 = FestivalView.this.animView;
                    if (festivalHbPagView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("animView");
                    } else {
                        festivalHbPagView7 = festivalHbPagView6;
                    }
                    festivalHbPagView7.setVisibility(0);
                }
            });
            return;
        }
        FestivalHbPagView festivalHbPagView5 = this.animView;
        if (festivalHbPagView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animView");
        } else {
            festivalHbPagView = festivalHbPagView5;
        }
        festivalHbPagView.setVisibility(4);
        QLog.i(getTAG(), 1, "[playBgAnim" + X0() + "],return isPlayed");
    }

    private final void b1() {
        com.tencent.mobileqq.qwallet.c.e("wrap.aio.show", String.valueOf(W0().getSkinId()), "1", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(FestivalView this$0, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.tailView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tailView");
            textView = null;
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = this$0.getTypeText();
        }
        textView.setText(str);
    }

    private final void d1(FestivalHbData.Anim anim) {
        boolean z16;
        String aioOpenedBgSuffix;
        if (W0().S1().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            aioOpenedBgSuffix = anim.getAioBgSuffix();
        } else {
            aioOpenedBgSuffix = anim.getAioOpenedBgSuffix();
        }
        String resPath = this.hbApi.getResPath(anim.getAioUrl(), aioOpenedBgSuffix);
        ImageView imageView = null;
        if (resPath != null) {
            ImageView imageView2 = this.coverView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverView");
            } else {
                imageView = imageView2;
            }
            imageView.setImageDrawable(QWalletPicHelper.getDrawableForAIO(resPath, this.defaultDrawable));
            return;
        }
        ImageView imageView3 = this.coverView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverView");
        } else {
            imageView = imageView3;
        }
        imageView.setImageDrawable(this.defaultDrawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void D0() {
        super.D0();
        QLog.d(getTAG(), 1, "addDataObservers" + X0() + " ");
        W0().j2().observeForever(this.tailObserver);
        W0().f2().observeForever(this.animObserver);
        W0().g2().observeForever(this.bgObserver);
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    @NotNull
    public View E0() {
        ImageView imageView = this.coverView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverView");
            return null;
        }
        return imageView;
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void I0(@NotNull String stateText) {
        Intrinsics.checkNotNullParameter(stateText, "stateText");
        FestivalHbData.Anim anim = this.currentAnim;
        if (anim != null) {
            d1(anim);
        }
        TextView textView = this.stateView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
            textView = null;
        }
        textView.setText(stateText);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void K0() {
        super.K0();
        QLog.d(getTAG(), 1, "removeDataObservers" + X0() + " ");
        W0().j2().removeObserver(this.tailObserver);
        W0().f2().removeObserver(this.animObserver);
        W0().g2().removeObserver(this.bgObserver);
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void L0() {
        TextView textView = this.tailView;
        FestivalHbPagView festivalHbPagView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tailView");
            textView = null;
        }
        textView.setText(getTypeText());
        TextView textView2 = this.stateView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
            textView2 = null;
        }
        textView2.setText("");
        FestivalHbPagView festivalHbPagView2 = this.animView;
        if (festivalHbPagView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animView");
        } else {
            festivalHbPagView = festivalHbPagView2;
        }
        festivalHbPagView.setVisibility(4);
    }

    @NotNull
    /* renamed from: Y0, reason: from getter */
    protected String getTypeText() {
        return this.typeText;
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    @NotNull
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public FestivalViewModel W0() {
        return (FestivalViewModel) this.viewModel.getValue();
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void initView() {
        QLog.d(getTAG(), 1, "initView" + X0() + MsgSummary.STR_COLON);
        View.inflate(getContext(), this.layoutResId, this);
        View findViewById = findViewById(R.id.x6o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.hb_festival_cover)");
        this.coverView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.x7f);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.hb_tail_view)");
        this.tailView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.v4t);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.festival_hb_anim_fg_view)");
        this.animView = (FestivalHbPagView) findViewById3;
        View findViewById4 = findViewById(R.id.x6n);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.hb_envelope_state_text)");
        this.stateView = (TextView) findViewById4;
        ImageView imageView = this.coverView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverView");
            imageView = null;
        }
        k.b(imageView, ViewUtils.dip2px(6.0f));
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void onResume() {
        super.onResume();
        QLog.d(getTAG(), 1, "onResume" + X0());
        FestivalHbData.Anim anim = this.cancelAnim;
        if (anim != null) {
            QLog.d(getTAG(), 1, "onResume" + X0() + " currentAnim != null");
            a1(anim);
        }
    }

    @Override // com.tencent.qqnt.qwallet.aio.AIOContentView
    @Nullable
    public View z0() {
        ImageView imageView = this.coverView;
        if (imageView == null) {
            return null;
        }
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverView");
            return null;
        }
        return imageView;
    }
}
