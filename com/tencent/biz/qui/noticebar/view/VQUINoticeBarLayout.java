package com.tencent.biz.qui.noticebar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.theme.SkinnableView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u001b\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qui/noticebar/view/VQUINoticeBarLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/theme/SkinnableView;", "", "onThemeChanged", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "d", "Lcom/tencent/theme/SkinnableView;", "getDelegate", "()Lcom/tencent/theme/SkinnableView;", "setDelegate", "(Lcom/tencent/theme/SkinnableView;)V", "delegate", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class VQUINoticeBarLayout extends FrameLayout implements SkinnableView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SkinnableView delegate;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VQUINoticeBarLayout(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        if (ev5 != null && isClickable()) {
            int actionMasked = ev5.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 3) {
                        setPressed(false);
                    }
                } else {
                    setPressed(false);
                }
            } else {
                setPressed(true);
            }
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        SkinnableView skinnableView = this.delegate;
        if (skinnableView != null) {
            skinnableView.onThemeChanged();
        }
    }

    public final void setDelegate(@Nullable SkinnableView skinnableView) {
        this.delegate = skinnableView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VQUINoticeBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
