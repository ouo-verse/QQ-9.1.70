package com.tencent.sqshow.zootopia.widget.bubble;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.ap;
import pu4.g;
import tl.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001\tB'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\u0006R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/bubble/ZPlanBubbleView;", "Landroid/widget/FrameLayout;", "Lpu4/g;", WadlProxyConsts.KEY_MATERIAL, "", "text", "", "b", "", "a", "Landroid/graphics/drawable/Drawable;", "drawable", "setDefaultIconDrawable", "c", "Ln74/ap;", "d", "Ln74/ap;", "binding", "e", "Lpu4/g;", "bubbleMaterial", "f", "Ljava/lang/String;", "bubbleText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanBubbleView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ap binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private g bubbleMaterial;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String bubbleText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanBubbleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final boolean a() {
        if (this.bubbleMaterial == null) {
            return false;
        }
        String str = this.bubbleText;
        return !(str == null || str.length() == 0);
    }

    public final void b(g material, String text) {
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(text, "text");
        this.bubbleMaterial = material;
        this.bubbleText = text;
        this.binding.f418686c.e(material);
        this.binding.f418687d.setText(text);
    }

    public final void c() {
        this.binding.f418686c.stop();
    }

    public final void setDefaultIconDrawable(Drawable drawable) {
        this.binding.f418686c.setDefaultDrawable(drawable);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanBubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZPlanBubbleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanBubbleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ap f16 = ap.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
    }
}
