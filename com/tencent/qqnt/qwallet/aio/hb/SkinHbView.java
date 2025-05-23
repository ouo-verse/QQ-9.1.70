package com.tencent.qqnt.qwallet.aio.hb;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 22\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010/\u001a\u00020.\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0014J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\b\u0010\u0010\u001a\u00020\u0002H\u0014R\u001b\u0010\u0016\u001a\u00020\u00118VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00178\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u001c\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010'\u00a8\u00064"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/SkinHbView;", "Lcom/tencent/qqnt/qwallet/aio/hb/DefaultHbView;", "", "m1", "", "isSpecialShape", "h1", "initView", "L0", "isOpened", "", "stateText", "J0", "title", "X0", "D0", "K0", "Lcom/tencent/qqnt/qwallet/aio/hb/SkinHbViewModel;", "N", "Lkotlin/Lazy;", "g1", "()Lcom/tencent/qqnt/qwallet/aio/hb/SkinHbViewModel;", "viewModel", "", "P", "I", "Q0", "()I", "layoutResId", "Landroid/widget/ImageView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/ImageView;", "specialShapeBgView", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "smallWishTextView", "Landroidx/lifecycle/Observer;", ExifInterface.LATITUDE_SOUTH, "Landroidx/lifecycle/Observer;", "skinUrlObserver", "T", "openIconUrlObserver", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$Tail;", "U", "tailObserver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class SkinHbView extends DefaultHbView {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: P, reason: from kotlin metadata */
    private final int layoutResId;

    /* renamed from: Q, reason: from kotlin metadata */
    private ImageView specialShapeBgView;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView smallWishTextView;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Observer<String> skinUrlObserver;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Observer<String> openIconUrlObserver;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Observer<HbSkinData.Tail> tailObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkinHbView(@NotNull final Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SkinHbViewModel>() { // from class: com.tencent.qqnt.qwallet.aio.hb.SkinHbView$viewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SkinHbViewModel invoke() {
                return new SkinHbViewModel();
            }
        });
        this.viewModel = lazy;
        this.layoutResId = R.layout.hht;
        this.skinUrlObserver = new Observer() { // from class: com.tencent.qqnt.qwallet.aio.hb.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SkinHbView.k1(SkinHbView.this, context, (String) obj);
            }
        };
        this.openIconUrlObserver = new Observer() { // from class: com.tencent.qqnt.qwallet.aio.hb.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SkinHbView.i1(SkinHbView.this, (String) obj);
            }
        };
        this.tailObserver = new Observer() { // from class: com.tencent.qqnt.qwallet.aio.hb.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SkinHbView.l1(SkinHbView.this, context, (HbSkinData.Tail) obj);
            }
        };
    }

    private final void h1(boolean isSpecialShape) {
        U0().setVisibility(8);
        R0().setVisibility(8);
        if (isSpecialShape) {
            P0().getOpenIcon().setVisibility(8);
            P0().getBgView().setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(SkinHbView this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).updateOpenIcon(this$0.P0().getOpenIcon(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(SkinHbView this$0, Context context, String skinImgUrl) {
        ImageView bgView;
        int bgResId;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.m1();
        boolean n26 = this$0.B0().n2();
        if (n26) {
            bgView = this$0.specialShapeBgView;
            if (bgView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("specialShapeBgView");
                bgView = null;
            }
        } else {
            bgView = this$0.P0().getBgView();
        }
        if (n26) {
            bgResId = R.drawable.nut;
        } else {
            bgResId = this$0.getBgResId();
        }
        Drawable drawable = ContextCompat.getDrawable(context, bgResId);
        if (skinImgUrl != null && skinImgUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            bgView.setImageDrawable(drawable);
            this$0.R0().setVisibility(0);
            this$0.U0().setVisibility(0);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(QWalletPicHelper.KEY_EXTRA_CACHE_SUFFIX, this$0.B0().M1().getBillNo());
        com.tencent.qqnt.qwallet.util.b bVar = com.tencent.qqnt.qwallet.util.b.f361906a;
        Intrinsics.checkNotNullExpressionValue(skinImgUrl, "skinImgUrl");
        URLDrawable e16 = com.tencent.qqnt.qwallet.util.b.e(bVar, skinImgUrl, drawable, drawable, null, null, bundle, null, 88, null);
        this$0.h1(n26);
        bgView.setImageDrawable(e16);
        this$0.R0().setVisibility(8);
        this$0.U0().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(SkinHbView this$0, final Context context, final HbSkinData.Tail tail) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        TextView S0 = this$0.S0();
        String str3 = null;
        if (tail != null) {
            str = tail.getWord();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str2 = this$0.getTypeText();
        } else if (tail != null) {
            str2 = tail.getWord();
        } else {
            str2 = null;
        }
        S0.setText(str2);
        TextView S02 = this$0.S0();
        com.tencent.mobileqq.qwallet.utils.m mVar = com.tencent.mobileqq.qwallet.utils.m.f279290a;
        if (tail != null) {
            str3 = tail.getColor();
        }
        S02.setTextColor(mVar.c(str3, -1));
        com.tencent.mobileqq.qwallet.k.d(this$0.S0(), 0L, new Function0<Unit>() { // from class: com.tencent.qqnt.qwallet.aio.hb.SkinHbView$tailObserver$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Context context2 = context;
                HbSkinData.Tail tail2 = tail;
                com.tencent.mobileqq.qwallet.utils.k.h(context2, tail2 != null ? tail2.getUrl() : null);
            }
        }, 1, null);
    }

    private final void m1() {
        boolean z16;
        String value = B0().k2().getValue();
        int i3 = 0;
        boolean z17 = true;
        if (value != null && value.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean z18 = !z16;
        if (B0().S1().length() != 0) {
            z17 = false;
        }
        TextView textView = this.smallWishTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallWishTextView");
            textView = null;
        }
        if (!z18 || !z17) {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView, com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    protected void D0() {
        super.D0();
        B0().k2().observeForever(this.skinUrlObserver);
        B0().j2().observeForever(this.openIconUrlObserver);
        B0().l2().observeForever(this.tailObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void J0(boolean isOpened, @NotNull String stateText) {
        PorterDuffColorFilter porterDuffColorFilter;
        Intrinsics.checkNotNullParameter(stateText, "stateText");
        super.J0(isOpened, stateText);
        int color = ContextCompat.getColor(getContext(), R.color.buy);
        int i3 = 8;
        if (B0().n2()) {
            ImageView imageView = null;
            if (isOpened) {
                porterDuffColorFilter = new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            } else {
                porterDuffColorFilter = null;
            }
            ImageView imageView2 = this.specialShapeBgView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("specialShapeBgView");
            } else {
                imageView = imageView2;
            }
            imageView.setColorFilter(porterDuffColorFilter);
            P0().getMaskView().setVisibility(8);
        } else {
            View maskView = P0().getMaskView();
            if (isOpened) {
                i3 = 0;
            }
            maskView.setVisibility(i3);
        }
        m1();
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView, com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    protected void K0() {
        super.K0();
        B0().k2().removeObserver(this.skinUrlObserver);
        B0().j2().removeObserver(this.openIconUrlObserver);
        B0().l2().removeObserver(this.tailObserver);
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView, com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void L0() {
        super.L0();
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (B0().n2()) {
            P0().getRedArc().setVisibility(8);
            P0().getBgView().setVisibility(8);
            ImageView imageView = this.specialShapeBgView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("specialShapeBgView");
                imageView = null;
            }
            imageView.setVisibility(0);
        } else {
            P0().getRedArc().setVisibility(0);
            P0().getBgView().setVisibility(0);
            ImageView imageView2 = this.specialShapeBgView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("specialShapeBgView");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
        }
        if (!(B0().M1() instanceof rx3.h)) {
            if (B0().n2()) {
                ViewGroup.LayoutParams layoutParams = P0().getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                }
                if (marginLayoutParams != null) {
                    marginLayoutParams.topMargin = ViewUtils.dpToPx(20.0f);
                }
            } else {
                ViewGroup.LayoutParams layoutParams2 = P0().getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                }
                if (marginLayoutParams != null) {
                    marginLayoutParams.topMargin = ViewUtils.dpToPx(10.0f);
                }
            }
        }
        R0().setVisibility(0);
        U0().setVisibility(0);
        P0().getMaskView().setVisibility(8);
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView
    /* renamed from: Q0, reason: from getter */
    protected int getLayoutResId() {
        return this.layoutResId;
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView
    protected void X0(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        super.X0(title);
        TextView textView = this.smallWishTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallWishTextView");
            textView = null;
        }
        textView.setText(title);
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView
    @NotNull
    /* renamed from: g1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public SkinHbViewModel G0() {
        return (SkinHbViewModel) this.viewModel.getValue();
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView, com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void initView() {
        super.initView();
        View findViewById = findViewById(R.id.f87214tr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.special_shape_bg_view)");
        this.specialShapeBgView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f86394rj);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.small_wish_text_view)");
        this.smallWishTextView = (TextView) findViewById2;
    }
}
