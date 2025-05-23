package com.tencent.mobileqq.qwallet.ad;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0002H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014J\b\u0010\t\u001a\u00020\u0002H\u0014\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/ad/PaySuccessAdView;", "Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView;", "", "Q0", "S0", "X0", "N0", "U0", "V0", "P0", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PaySuccessAdView extends BaseGdtAdView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaySuccessAdView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView
    protected int N0() {
        return R.id.sbm;
    }

    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView
    protected int P0() {
        return R.id.sbv;
    }

    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView
    protected int Q0() {
        return R.layout.hke;
    }

    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView
    protected int S0() {
        return R.id.yzt;
    }

    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView
    protected int U0() {
        return R.id.f163981fi;
    }

    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView
    protected int V0() {
        return R.id.f163993fz;
    }

    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView
    protected int X0() {
        return R.id.sbn;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaySuccessAdView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaySuccessAdView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PaySuccessAdView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaySuccessAdView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
