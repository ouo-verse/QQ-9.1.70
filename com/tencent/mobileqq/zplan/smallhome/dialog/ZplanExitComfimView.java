package com.tencent.mobileqq.zplan.smallhome.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.d;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.sqshow.zootopia.utils.i;
import fi3.bw;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001d\u0010\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001fB\u001b\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001d\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/dialog/ZplanExitComfimView;", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "Lcom/tencent/mobileqq/widget/qus/d;", "Landroid/view/View;", "createContentView", "", "defaultHeight", NodeProps.MAX_HEIGHT, "minMarginTop", NodeProps.MIN_HEIGHT, "showMode", "initState", "", HippyTKDListViewAdapter.X, "y", "", "canScrollUp", "canScrollDown", "Lfi3/bw;", "s0", "Lfi3/bw;", "getBinding", "()Lfi3/bw;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanExitComfimView extends QUSHalfScreenFloatingView implements d {

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private final bw binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanExitComfimView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        bw g16 = bw.g(LayoutInflater.from(context), null, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), null, false)");
        this.binding = g16;
        setDraggable(true);
        setQUSDragFloatController(this);
        setIsHeightWrapContent(true);
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public boolean canScrollDown(float x16, float y16) {
        return false;
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public boolean canScrollUp(float x16, float y16) {
        return false;
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public View createContentView() {
        LinearLayoutCompat linearLayoutCompat = this.binding.f399174d;
        Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "binding.exitComfirmContainer");
        return linearLayoutCompat;
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public int initState() {
        return 0;
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public int maxHeight() {
        return 0;
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public int minHeight() {
        return A() / 2;
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public int minMarginTop() {
        return 0;
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public int showMode() {
        return 1;
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public int defaultHeight() {
        return i.b(450);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZplanExitComfimView(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZplanExitComfimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
