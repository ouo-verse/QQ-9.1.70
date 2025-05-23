package com.tencent.mobileqq.guild.mainframe.create.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.x;
import com.tencent.theme.SkinnableView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\n\u001a\u00020\u0005H\u0016R\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/widget/GuildCreateOperationIconView;", "Landroid/widget/ImageView;", "Lcom/tencent/theme/SkinnableView;", "", "type", "", "b", "Landroid/graphics/drawable/LayerDrawable;", "a", "setOperationIconType", "onThemeChanged", "d", "I", "iconType", "e", "Landroid/graphics/drawable/LayerDrawable;", "addIconDrawable", "f", "minusIconDrawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildCreateOperationIconView extends ImageView implements SkinnableView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int iconType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LayerDrawable addIconDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LayerDrawable minusIconDrawable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildCreateOperationIconView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final LayerDrawable a(int type) {
        int i3;
        int a16 = x.a(0.5f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setStrokeWidth(a16);
        shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
        shapeDrawable.getPaint().setColor(getContext().getResources().getColor(R.color.qui_button_border_ghost_default));
        Resources resources = getResources();
        if (type == 4) {
            i3 = R.drawable.guild_create_member_minus_icon;
        } else {
            i3 = R.drawable.guild_create_member_add_icon;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(resources, i3));
        bitmapDrawable.setTint(getContext().getResources().getColor(R.color.qui_common_icon_primary));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, bitmapDrawable});
        int a17 = x.a(14.0f);
        layerDrawable.setLayerInset(0, a16, a16, a16, a16);
        layerDrawable.setLayerInset(1, a17, a17, a17, a17);
        return layerDrawable;
    }

    private final void b(int type) {
        if (type != 3) {
            if (type == 4) {
                if (this.minusIconDrawable == null) {
                    this.minusIconDrawable = a(type);
                }
                setImageDrawable(this.minusIconDrawable);
                return;
            }
            return;
        }
        if (this.addIconDrawable == null) {
            this.addIconDrawable = a(type);
        }
        setImageDrawable(this.addIconDrawable);
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        setOperationIconType(this.iconType);
    }

    public final void setOperationIconType(int type) {
        this.iconType = type;
        b(type);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildCreateOperationIconView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildCreateOperationIconView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildCreateOperationIconView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
