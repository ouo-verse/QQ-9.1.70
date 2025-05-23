package com.tencent.state.square.location;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.databinding.VasSquareLocationIconViewBinding;
import com.tencent.state.view.SquareImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u000f\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/location/LocationIconView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareLocationIconViewBinding;", "initLocation", "", "info", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "resetLocationBar", "setImageAlpha", c.f123400v, "", IECSearchBar.METHOD_SET_TEXT, "text", "", "setTextColor", "colorId", "updateLocation", "updateLocationText", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class LocationIconView extends LinearLayout {
    private final VasSquareLocationIconViewBinding binding;

    public LocationIconView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void resetLocationBar() {
        String string = getContext().getString(R.string.xgp);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ation_select_detail_text)");
        setText(string);
        setTextColor(R.color.f81567);
        setImageAlpha(0.55f);
    }

    private final void setImageAlpha(float alpha) {
        SquareImageView squareImageView = this.binding.image;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.image");
        squareImageView.setAlpha(alpha);
    }

    private final void updateLocationText(String text) {
        setText(text);
        setTextColor(R.color.f7985q);
        setImageAlpha(1.0f);
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

    public final void updateLocation(AvatarLocationInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (!(info.getPoiId().length() == 0) && !info.getPoiId().equals(AvatarPoiHandler.INSTANCE.getINVALIDE_POI_ID())) {
            updateLocationText(info.getPoi());
        } else {
            resetLocationBar();
        }
    }

    public LocationIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ LocationIconView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final void initLocation(AvatarLocationInfo info) {
        if (info != null) {
            if (info.getPoi().length() > 0) {
                updateLocationText(info.getPoi());
            } else {
                resetLocationBar();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationIconView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareLocationIconViewBinding inflate = VasSquareLocationIconViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLocationIconVie\u2026rom(context), this, true)");
        this.binding = inflate;
    }
}
