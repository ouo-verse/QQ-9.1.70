package com.tencent.guild.aio.msglist.text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BH\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014R2\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/aio/msglist/text/TextContentFrameLayout;", "Landroid/widget/FrameLayout;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "widthSize", "d", "Lkotlin/jvm/functions/Function1;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "callback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Landroid/util/AttributeSet;I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class TextContentFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> callback;

    public /* synthetic */ TextContentFrameLayout(Context context, Function1 function1, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, function1, (i16 & 4) != 0 ? null : attributeSet, (i16 & 8) != 0 ? 0 : i3);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.callback.invoke(Integer.valueOf(View.MeasureSpec.getSize(widthMeasureSpec)));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TextContentFrameLayout(@NotNull Context context, @NotNull Function1<? super Integer, Unit> callback, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }
}
