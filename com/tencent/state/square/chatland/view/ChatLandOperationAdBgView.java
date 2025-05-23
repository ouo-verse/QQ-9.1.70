package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.Location;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.template.data.OperationAd;
import com.tencent.state.template.data.OperationAdBackground;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.view.SquareImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/chatland/view/ChatLandOperationAdBgView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/state/square/chatland/view/IOperationView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentAd", "Lcom/tencent/state/template/data/OperationAd;", "image", "Lcom/tencent/state/view/SquareImageView;", "checkIsSameMedia", "", "ad", "destroy", "", "hide", "resetElevation", "location", "Lcom/tencent/state/map/Location;", "showDebugTools", "update", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandOperationAdBgView extends FrameLayout implements IOperationView {
    private static final String TAG = "ChatLandOperationAdBgView";
    private OperationAd currentAd;
    private SquareImageView image;

    public ChatLandOperationAdBgView(Context context) {
        this(context, null, 0, 6, null);
    }

    @Override // com.tencent.state.square.chatland.view.IOperationView
    public boolean checkIsSameMedia(OperationAd ad5) {
        OperationAdBackground background;
        Intrinsics.checkNotNullParameter(ad5, "ad");
        OperationAd operationAd = this.currentAd;
        boolean areEqual = Intrinsics.areEqual((operationAd == null || (background = operationAd.getBackground()) == null) ? null : background.getSrc(), ad5.getBackground().getSrc());
        SquareBaseKt.getSquareLog().i(TAG, "isSameUrl: " + areEqual + ", " + ad5.getBackground().getSrc());
        return areEqual;
    }

    @Override // com.tencent.state.square.chatland.view.IOperationView
    public void destroy() {
        hide();
    }

    @Override // com.tencent.state.square.chatland.view.IOperationView
    public void resetElevation(Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        setElevation(location.getCenterY() * 5);
    }

    @Override // com.tencent.state.square.chatland.view.IOperationView
    public void showDebugTools() {
        if (Square.INSTANCE.getConfig().isDebug()) {
            Drawable drawable = DrawableUtil.INSTANCE.getDrawable(R.drawable.i7b);
            if (drawable != null) {
                drawable.setAlpha(128);
            }
            setBackground(drawable);
        }
    }

    @Override // com.tencent.state.square.chatland.view.IOperationView
    public void update(OperationAd ad5) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(ad5, "ad");
        final OperationAdBackground background = ad5.getBackground();
        isBlank = StringsKt__StringsJVMKt.isBlank(background.getSrc());
        if (!isBlank) {
            if (!checkIsSameMedia(ad5)) {
                ViewExtensionsKt.setUri(this.image, background.getSrc());
            }
            ViewExtensionsKt.updateLayoutParams(this, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandOperationAdBgView$update$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FrameLayout.LayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    receiver.width = OperationAdBackground.this.getLocation().getWidth();
                    receiver.height = OperationAdBackground.this.getLocation().getHeight();
                    receiver.topMargin = OperationAdBackground.this.getLocation().getY();
                    receiver.leftMargin = OperationAdBackground.this.getLocation().getX();
                }
            });
            resetElevation(background.getLocation());
            this.currentAd = ad5;
            setVisibility(0);
            return;
        }
        hide();
    }

    public ChatLandOperationAdBgView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ChatLandOperationAdBgView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final void hide() {
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandOperationAdBgView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        SquareImageView squareImageView = new SquareImageView(context);
        squareImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Unit unit = Unit.INSTANCE;
        this.image = squareImageView;
        setVisibility(4);
        addView(this.image, new FrameLayout.LayoutParams(-1, -1));
    }
}
