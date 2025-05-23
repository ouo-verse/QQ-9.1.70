package com.tencent.mobileqq.qwallet.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.home.QWalletHomeVipPopVM;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J0\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0015R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/AssetPrivilegeView;", "Lcom/tencent/mobileqq/qwallet/home/BaseAssetView;", "", "size", "", "G0", "", "changed", "left", "top", "right", "bottom", "onLayout", "f", "I", "privilegeSize", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeVipPopVM;", tl.h.F, "Lkotlin/Lazy;", "F0", "()Lcom/tencent/mobileqq/qwallet/home/QWalletHomeVipPopVM;", "vipViewModel", "", "i", "[I", "iconPosition", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AssetPrivilegeView extends BaseAssetView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int privilegeSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vipViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] iconPosition;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AssetPrivilegeView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final QWalletHomeVipPopVM F0() {
        return (QWalletHomeVipPopVM) this.vipViewModel.getValue();
    }

    public final void G0(int size) {
        this.privilegeSize = size;
        TextView textView = (TextView) findViewById(R.id.swb);
        if (size == 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(String.valueOf(size));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        QWalletHomeVipPopVM.PopInfo value;
        super.onLayout(changed, left, top, right, bottom);
        QWalletHomeVipPopVM F0 = F0();
        if (F0 == null || (value = F0.e2().getValue()) == null) {
            return;
        }
        QWalletHomeVipPopVM.AnchorInfo anchorInfo = value.getAnchorInfo();
        boolean z16 = false;
        if (anchorInfo != null && anchorInfo.d()) {
            z16 = true;
        }
        if (!z16 && left != 0) {
            QLog.i("QWalletHomeVipPopVM", 2, "anchor onLayout " + left + " " + top + " " + right + " " + bottom);
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            getLocationOnScreen(this.iconPosition);
            value.k(new QWalletHomeVipPopVM.AnchorInfo(this, measuredWidth, measuredHeight, this.iconPosition));
            F0.e2().postValue(value);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AssetPrivilegeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AssetPrivilegeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AssetPrivilegeView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AssetPrivilegeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QWalletHomeVipPopVM>() { // from class: com.tencent.mobileqq.qwallet.home.AssetPrivilegeView$vipViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final QWalletHomeVipPopVM invoke() {
                return ((QWalletHomeFragment) FragmentManager.findFragment(AssetPrivilegeView.this)).Ph();
            }
        });
        this.vipViewModel = lazy;
        this.iconPosition = new int[2];
    }
}
