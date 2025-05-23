package com.tencent.sqshow.zootopia.nativeui.view.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/loading/NativePanelLoadingIgv;", "Landroid/widget/ImageView;", "", "d", "f", "g", "", "Z", "mPlaying", "Lcom/airbnb/lottie/LottieDrawable;", "e", "Lcom/airbnb/lottie/LottieDrawable;", "mLoadingDrawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class NativePanelLoadingIgv extends ImageView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mPlaying;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LottieDrawable mLoadingDrawable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NativePanelLoadingIgv(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(NativePanelLoadingIgv this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d();
    }

    private final void d() {
        int dimension = (int) getContext().getResources().getDimension(R.dimen.f11334h);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        LottieHelper.b(getContext(), "zootopia_load_more.json", null, measuredWidth <= 0 ? dimension : measuredWidth, measuredHeight <= 0 ? dimension : measuredHeight, -1, new LottieHelper.d() { // from class: ia4.b
            @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
            public final void onLoad(LottieDrawable lottieDrawable) {
                NativePanelLoadingIgv.e(NativePanelLoadingIgv.this, lottieDrawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(NativePanelLoadingIgv this$0, LottieDrawable lottieDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mLoadingDrawable = lottieDrawable;
        this$0.setImageDrawable(lottieDrawable);
        if (this$0.mPlaying) {
            this$0.f();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NativePanelLoadingIgv(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void f() {
        this.mPlaying = true;
        LottieDrawable lottieDrawable = this.mLoadingDrawable;
        if (lottieDrawable == null || lottieDrawable.isAnimating()) {
            return;
        }
        lottieDrawable.start();
    }

    public final void g() {
        this.mPlaying = false;
        LottieDrawable lottieDrawable = this.mLoadingDrawable;
        if (lottieDrawable != null) {
            lottieDrawable.stop();
        }
    }

    public /* synthetic */ NativePanelLoadingIgv(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativePanelLoadingIgv(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        post(new Runnable() { // from class: ia4.a
            @Override // java.lang.Runnable
            public final void run() {
                NativePanelLoadingIgv.c(NativePanelLoadingIgv.this);
            }
        });
    }
}
