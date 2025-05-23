package com.tencent.mobileqq.qwallet.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$VirtualAsset;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0007J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/BaseAssetView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "C0", "", "isExposure", "", "type", "", "title", "E0", "initView", "B0", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$VirtualAsset;", "asset", "D0", "A0", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "titleView", "e", "subTitleView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class BaseAssetView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView titleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView subTitleView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseAssetView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void C0() {
        View.inflate(getContext(), B0(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(boolean isExposure, int type, String title) {
        String str;
        if (isExposure) {
            str = "index.property.show";
        } else {
            str = "index.property.click";
        }
        u.m(str, String.valueOf(type), null, null, title, 0, 44, null);
    }

    public void A0(@NotNull QWalletHomePage$VirtualAsset asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        if (com.tencent.mobileqq.utils.u.a().b()) {
            return;
        }
        com.tencent.mobileqq.qwallet.utils.k.h(getContext(), asset.url.get());
    }

    @LayoutRes
    public final int B0() {
        return R.layout.hig;
    }

    public void D0(@Nullable final QWalletHomePage$VirtualAsset asset) {
        Unit unit = null;
        TextView textView = null;
        if (asset != null) {
            setVisibility(0);
            TextView textView2 = this.titleView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleView");
            } else {
                textView = textView2;
            }
            textView.setText(asset.title.get());
            int i3 = asset.type.get();
            String str = asset.title.get();
            Intrinsics.checkNotNullExpressionValue(str, "a.title.get()");
            E0(true, i3, str);
            com.tencent.mobileqq.qwallet.k.d(this, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.home.BaseAssetView$renderAssetInfo$1$1
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
                    BaseAssetView.this.A0(asset);
                    BaseAssetView baseAssetView = BaseAssetView.this;
                    int i16 = asset.type.get();
                    String str2 = asset.title.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "a.title.get()");
                    baseAssetView.E0(false, i16, str2);
                }
            }, 1, null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            setVisibility(8);
        }
    }

    public void initView() {
        C0();
        View findViewById = findViewById(R.id.swe);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.asset_title)");
        TextView textView = (TextView) findViewById;
        this.titleView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            textView = null;
        }
        ol2.b.f(textView, 0, false, 6, null);
        View findViewById2 = findViewById(R.id.swd);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.asset_subtitle)");
        TextView textView2 = (TextView) findViewById2;
        this.subTitleView = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subTitleView");
            textView2 = null;
        }
        ol2.b.f(textView2, 15, false, 4, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseAssetView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseAssetView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BaseAssetView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseAssetView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        setVisibility(8);
    }
}
