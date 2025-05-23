package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import e63.EffectMaskLocation;
import g63.CommonConfig;
import g63.LayoutConfig;
import i63.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tB%\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskView;", "Landroid/view/View;", "Landroid/view/MotionEvent;", "event", "", "d", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/a;", "controller", "", "a", "Le63/a;", "data", "b", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskView$a;", "listener", "setEffectMaskViewClickListener", "c", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/a;", "effectMaskController", "e", "Le63/a;", "effectData", "f", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskView$a;", "clickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class EffectMaskView extends View {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.a effectMaskController;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EffectMaskLocation effectData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a clickListener;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f319431h;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskView$a;", "", "Le63/a;", "effectData", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void a(@Nullable EffectMaskLocation effectData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EffectMaskView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f319431h = new LinkedHashMap();
    }

    private final boolean d(MotionEvent event) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        int measuredWidth = getMeasuredWidth() + i3;
        int measuredHeight = getMeasuredHeight() + i16;
        if (event.getRawX() < i3 || event.getRawX() > measuredWidth || event.getRawY() < i16 || event.getRawY() > measuredHeight) {
            return false;
        }
        return true;
    }

    public final void a(@Nullable com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.a controller) {
        this.effectMaskController = controller;
    }

    public final void b(@NotNull EffectMaskLocation data) {
        int i3;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i16;
        int i17;
        b m3;
        b m16;
        CommonConfig h16;
        LayoutConfig layoutConfig;
        Intrinsics.checkNotNullParameter(data, "data");
        this.effectData = data;
        int i18 = 0;
        if (data.i()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
        setBackgroundColor(data.getColor());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = null;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.a aVar = this.effectMaskController;
            if (aVar != null && (h16 = aVar.h()) != null && (layoutConfig = h16.getLayoutConfig()) != null) {
                i16 = layoutConfig.getPanelStartOffset();
            } else {
                i16 = 0;
            }
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.a aVar2 = this.effectMaskController;
            if (aVar2 != null && (m16 = aVar2.m()) != null) {
                i17 = m16.y(data.getStartPositionMs() * 1000);
            } else {
                i17 = 0;
            }
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.a aVar3 = this.effectMaskController;
            if (aVar3 != null && (m3 = aVar3.m()) != null) {
                i18 = m3.y(data.getStopPositionMs() * 1000);
            }
            marginLayoutParams.setMarginStart(i16 + i17);
            marginLayoutParams.width = i18 - i17;
            marginLayoutParams2 = marginLayoutParams;
        }
        setLayoutParams(marginLayoutParams2);
        invalidate();
    }

    public final boolean c(@NotNull MotionEvent event) {
        a aVar;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!d(event) || (aVar = this.clickListener) == null) {
            return false;
        }
        if (aVar != null) {
            aVar.a(this.effectData);
            return true;
        }
        return true;
    }

    public final void setEffectMaskViewClickListener(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.clickListener = listener;
    }

    public /* synthetic */ EffectMaskView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
