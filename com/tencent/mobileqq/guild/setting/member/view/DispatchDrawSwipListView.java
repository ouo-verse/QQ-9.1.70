package com.tencent.mobileqq.guild.setting.member.view;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.widget.SwipListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u001b\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/view/DispatchDrawSwipListView;", "Lcom/tencent/widget/SwipListView;", "Landroid/graphics/Canvas;", "c", "", "onDraw", "Lkv1/a;", "drawListener", "setDrawListener", "b0", "d", "Lkv1/a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DispatchDrawSwipListView extends SwipListView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private kv1.a drawListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DispatchDrawSwipListView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void b0() {
        this.drawListener = null;
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas c16) {
        super.onDraw(c16);
        kv1.a aVar = this.drawListener;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void setDrawListener(@NotNull kv1.a drawListener) {
        Intrinsics.checkNotNullParameter(drawListener, "drawListener");
        this.drawListener = drawListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DispatchDrawSwipListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DispatchDrawSwipListView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
