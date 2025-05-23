package com.tencent.timi.game.liveroom.impl.room.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.timi.game.widget.MediumBoldTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nr2.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u001b\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0016B#\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0002H\u0014R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/widget/AudienceBackToPreviousView;", "Landroid/widget/LinearLayout;", "", "a", "", "w", "setWidth", NodeProps.ON_DETACHED_FROM_WINDOW, "", "d", "Z", "isDismissed", "Lnr2/q;", "e", "Lnr2/q;", "binding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AudienceBackToPreviousView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isDismissed;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudienceBackToPreviousView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        q f16 = q.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        a();
    }

    private final void a() {
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(R.drawable.lql);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.isDismissed = true;
        super.onDetachedFromWindow();
    }

    public final void setWidth(int w3) {
        ViewGroup.LayoutParams layoutParams;
        MediumBoldTextView mediumBoldTextView = this.binding.f421109b;
        if (mediumBoldTextView != null) {
            layoutParams = mediumBoldTextView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.width = w3;
        }
        MediumBoldTextView mediumBoldTextView2 = this.binding.f421109b;
        if (mediumBoldTextView2 != null) {
            mediumBoldTextView2.requestLayout();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudienceBackToPreviousView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        q f16 = q.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudienceBackToPreviousView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        q f16 = q.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        a();
    }
}
