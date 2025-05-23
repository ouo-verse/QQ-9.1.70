package com.tencent.mobileqq.matchfriend.reborn.content.msg.setting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.l;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0016\u0010\f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/ClearAllMsgItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mobileqq/widget/listitem/l;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemBackgroundType;", "type", "Landroid/graphics/drawable/Drawable;", "z0", "", "A0", "setBackgroundType", "d", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemBackgroundType;", "backgroundType", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ClearAllMsgItemView extends ConstraintLayout implements l {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUIListItemBackgroundType backgroundType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClearAllMsgItemView(Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final void A0() {
        setBackground(z0(this.backgroundType));
    }

    private final Drawable z0(QUIListItemBackgroundType type) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return type.getBackground(context, 1000);
    }

    @Override // com.tencent.mobileqq.widget.listitem.l
    public void setBackgroundType(QUIListItemBackgroundType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.backgroundType = type;
        A0();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClearAllMsgItemView(Context ctx, AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClearAllMsgItemView(Context ctx, AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.backgroundType = QUIListItemBackgroundType.AllRound;
    }

    public /* synthetic */ ClearAllMsgItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
