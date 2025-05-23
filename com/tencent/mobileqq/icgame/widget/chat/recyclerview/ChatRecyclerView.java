package com.tencent.mobileqq.icgame.widget.chat.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u001eB/\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/recyclerview/ChatRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "height", "", BdhLogUtil.LogTag.Tag_Conn, "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "widthSpec", "heightSpec", "onMeasure", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "direction", "canScrollHorizontally", "f", "I", "sizeHeight", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "def", "<init>", "(Landroid/content/Context;ILandroid/util/AttributeSet;I)V", "a", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ChatRecyclerView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int sizeHeight;

    public /* synthetic */ ChatRecyclerView(Context context, int i3, AttributeSet attributeSet, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i3, (i17 & 4) != 0 ? null : attributeSet, (i17 & 8) != 0 ? 0 : i16);
    }

    public final void C(int height) {
        a.INSTANCE.k("ICGameChat_Message|ICGameChatRecyclerView", "updateSizeHeight", "height:" + height);
        if (this.sizeHeight != height) {
            this.sizeHeight = height;
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = this.sizeHeight;
                setLayoutParams(layoutParams);
                RecyclerView.LayoutManager layoutManager = getLayoutManager();
                if (layoutManager != null) {
                    layoutManager.setAutoMeasureEnabled(false);
                }
                setHasFixedSize(true);
            }
            postInvalidate();
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        return super.dispatchTouchEvent(ev5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int widthSpec, int heightSpec) {
        if (this.sizeHeight > 0) {
            int size = View.MeasureSpec.getSize(heightSpec);
            int i3 = this.sizeHeight;
            if (size > i3) {
                super.onMeasure(widthSpec, View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE));
                return;
            }
        }
        super.onMeasure(widthSpec, heightSpec);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        a.INSTANCE.f("ICGameChat_Message|ICGameChatRecyclerView", "AnchorMsgRecyclerView onSizeChanged w = [" + w3 + "], h = [" + h16 + "], oldw = [" + oldw + "], oldh = [" + oldh + ']');
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatRecyclerView(@NotNull Context ctx, int i3, @Nullable AttributeSet attributeSet, int i16) {
        super(ctx, attributeSet, i16);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.sizeHeight = i3;
    }
}
