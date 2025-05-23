package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001-B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\u0003\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J0\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u0012\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010#\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/widget/SubAccountPullRefreshHeader;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/widget/p;", "", "pullType", "", "setPullType", "", "lastTime", "i", "d", tl.h.F, RemoteProxy.KEY_RESULT_TYPE, "l", "", "tip", "c", "Landroid/view/View;", "b", "g", "k", "clrPull", "clrRelease", "clrUpdate", "clrResult", "clrTime", "setTextColor", "resId", "setHeaderBgRes", "clrBg", "setHeaderBgColor", "Landroid/graphics/drawable/Drawable;", "bgDrawable", "setHeaderBgDrawable", "Landroid/widget/ProgressBar;", "Landroid/widget/ProgressBar;", "progressBar", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "a", "qqsubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class SubAccountPullRefreshHeader extends FrameLayout implements p {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ProgressBar progressBar;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SubAccountPullRefreshHeader(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.widget.p
    public void c(int resultType, @Nullable String tip) {
        this.progressBar.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.widget.p
    public void h(long lastTime) {
        this.progressBar.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.widget.p
    public void i(long lastTime) {
        this.progressBar.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.widget.p
    public long k() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.widget.p
    public void l(int resultType) {
        this.progressBar.setVisibility(8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SubAccountPullRefreshHeader(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SubAccountPullRefreshHeader(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SubAccountPullRefreshHeader(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.hr_, (ViewGroup) this, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.ProgressBar");
        ProgressBar progressBar = (ProgressBar) inflate;
        this.progressBar = progressBar;
        progressBar.setIndeterminateDrawable(LoadingUtil.getLoadingDrawable(context, 2));
        int dpToPx = ViewUtils.dpToPx(16.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams.gravity = 17;
        addView(progressBar, layoutParams);
    }

    @Override // com.tencent.mobileqq.widget.p
    @NotNull
    public View b() {
        return this;
    }

    @Override // com.tencent.mobileqq.widget.p
    public void g() {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void d(long lastTime) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setHeaderBgColor(int clrBg) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setHeaderBgDrawable(@Nullable Drawable bgDrawable) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setHeaderBgRes(int resId) {
    }

    public void setPullType(int pullType) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setTextColor(int clrPull, int clrRelease, int clrUpdate, int clrResult, int clrTime) {
    }
}
