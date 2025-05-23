package com.tencent.state.square.location;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.state.square.Square;
import com.tencent.state.square.databinding.VasSquareLocationViewBinding;
import com.tencent.state.utils.DrawableUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/square/location/LocationView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareLocationViewBinding;", "iconType", "Lcom/tencent/state/square/location/LocationIconType;", "setIconType", "", "setImage", "drawableId", IECSearchBar.METHOD_SET_TEXT, "text", "", "setTextColor", "colorId", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class LocationView extends LinearLayout {
    private final VasSquareLocationViewBinding binding;
    private LocationIconType iconType;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LocationIconType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LocationIconType.LOCATION_SELECT_BAR.ordinal()] = 1;
            iArr[LocationIconType.SQUARE_AND_PROFILE_DOUBLE.ordinal()] = 2;
            iArr[LocationIconType.PROFILE_SINGLE.ordinal()] = 3;
        }
    }

    public LocationView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void setImage(int drawableId) {
        Drawable drawable;
        if (Square.INSTANCE.getApplication() == null || (drawable = DrawableUtil.INSTANCE.getDrawable(drawableId)) == null) {
            return;
        }
        this.binding.image.setImageDrawable(drawable);
    }

    public final void setIconType(LocationIconType iconType) {
        Intrinsics.checkNotNullParameter(iconType, "iconType");
        this.iconType = iconType;
        int i3 = WhenMappings.$EnumSwitchMapping$0[iconType.ordinal()];
        if (i3 == 1) {
            setImage(R.drawable.iax);
        } else if (i3 == 2) {
            setImage(R.drawable.i9k);
        } else {
            if (i3 != 3) {
                return;
            }
            setImage(R.drawable.ib5);
        }
    }

    public final void setText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = this.binding.locationText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.locationText");
        textView.setText(text);
    }

    public final void setTextColor(int colorId) {
        this.binding.locationText.setTextColor(ContextCompat.getColor(getContext(), colorId));
    }

    public LocationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ LocationView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareLocationViewBinding inflate = VasSquareLocationViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLocationViewBin\u2026ater.from(context), this)");
        this.binding = inflate;
        this.iconType = LocationIconType.LOCATION_SELECT_BAR;
        setOrientation(0);
    }
}
