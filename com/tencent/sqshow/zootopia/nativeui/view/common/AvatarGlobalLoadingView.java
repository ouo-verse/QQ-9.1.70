package com.tencent.sqshow.zootopia.nativeui.view.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.m;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarGlobalLoadingView;", "Landroid/widget/FrameLayout;", "", "delayMillis", "", h.F, "e", "", "g", "Ln74/m;", "d", "Ln74/m;", "mBinding", "Z", "mIsShowing", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "showLoadingRunnable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AvatarGlobalLoadingView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final m mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsShowing;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Runnable showLoadingRunnable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarGlobalLoadingView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AvatarGlobalLoadingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NativePanelLoadingIgv nativePanelLoadingIgv = this$0.mBinding.f419373b;
        Intrinsics.checkNotNullExpressionValue(nativePanelLoadingIgv, "mBinding.loadingCircleView");
        nativePanelLoadingIgv.setVisibility(8);
        nativePanelLoadingIgv.g();
        this$0.setVisibility(8);
        QLog.i("AvatarGlobalLoadingView", 1, "hideLoading real run");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AvatarGlobalLoadingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mIsShowing = true;
        NativePanelLoadingIgv nativePanelLoadingIgv = this$0.mBinding.f419373b;
        Intrinsics.checkNotNullExpressionValue(nativePanelLoadingIgv, "mBinding.loadingCircleView");
        nativePanelLoadingIgv.f();
        nativePanelLoadingIgv.setVisibility(0);
        this$0.setVisibility(0);
        QLog.i("AvatarGlobalLoadingView", 1, "showLoading real run");
    }

    public final void e() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.showLoadingRunnable);
        this.mIsShowing = false;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.common.c
            @Override // java.lang.Runnable
            public final void run() {
                AvatarGlobalLoadingView.f(AvatarGlobalLoadingView.this);
            }
        });
    }

    /* renamed from: g, reason: from getter */
    public final boolean getMIsShowing() {
        return this.mIsShowing;
    }

    public final void h(long delayMillis) {
        if (this.mIsShowing) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.showLoadingRunnable, delayMillis);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarGlobalLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View view) {
        QLog.i("AvatarGlobalLoadingView", 1, "clicked!");
    }

    public /* synthetic */ AvatarGlobalLoadingView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarGlobalLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        m f16 = m.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.showLoadingRunnable = new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.common.a
            @Override // java.lang.Runnable
            public final void run() {
                AvatarGlobalLoadingView.i(AvatarGlobalLoadingView.this);
            }
        };
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.common.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AvatarGlobalLoadingView.d(view);
            }
        });
    }
}
