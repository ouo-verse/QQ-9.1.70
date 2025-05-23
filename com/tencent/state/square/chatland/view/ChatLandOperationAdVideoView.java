package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.Location;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.template.data.OperationAd;
import com.tencent.state.template.data.OperationAdVideo;
import com.tencent.state.utils.DrawableUtil;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B-\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0006\u0010\u0017\u001a\u00020\u0015J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\u0006\u0010\u001d\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0015J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0015J\b\u0010$\u001a\u00020\u0019H\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/tencent/state/square/chatland/view/ChatLandOperationAdVideoView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/state/square/chatland/view/IOperationView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "listener", "Lcom/tencent/state/square/chatland/view/IVideoListener;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/state/square/chatland/view/IVideoListener;)V", "currentAd", "Lcom/tencent/state/template/data/OperationAd;", "getListener", "()Lcom/tencent/state/square/chatland/view/IVideoListener;", "player", "Lcom/tencent/state/square/chatland/view/AdVideoPlayer;", "view", "Landroid/view/TextureView;", "checkIsSameMedia", "", "ad", "checkViewVisible", "defaultViewSize", "", "info", "Lcom/tencent/state/template/data/OperationAdVideo;", "destroy", "hide", "pause", "isFragment", "resetElevation", "location", "Lcom/tencent/state/map/Location;", "resume", "showDebugTools", "update", "updateVideoSize", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandOperationAdVideoView extends FrameLayout implements IOperationView {
    private static final String TAG = "ChatLandOperationAdVideoView";
    private OperationAd currentAd;
    private final IVideoListener listener;
    private AdVideoPlayer player;
    private TextureView view;

    public ChatLandOperationAdVideoView(Context context, AttributeSet attributeSet, IVideoListener iVideoListener) {
        this(context, attributeSet, 0, iVideoListener, 4, null);
    }

    private final void defaultViewSize(final OperationAdVideo info) {
        ViewExtensionsKt.updateLayoutParams(this.view, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandOperationAdVideoView$defaultViewSize$1
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
                if (OperationAdVideo.this.getLocation().getWidth() > OperationAdVideo.this.getLocation().getHeight()) {
                    int width = OperationAdVideo.this.getLocation().getWidth();
                    receiver.width = width;
                    receiver.height = (width * 9) / 16;
                } else {
                    int height = OperationAdVideo.this.getLocation().getHeight();
                    receiver.height = height;
                    receiver.width = (height * 9) / 16;
                }
                SquareBaseKt.getSquareLog().i("ChatLandOperationAdVideoView", "defaultViewSize: " + receiver.width + ", " + receiver.height + ", " + OperationAdVideo.this.getLocation().getWidth() + ", " + OperationAdVideo.this.getLocation().getHeight());
            }
        });
    }

    @Override // com.tencent.state.square.chatland.view.IOperationView
    public boolean checkIsSameMedia(OperationAd ad5) {
        OperationAdVideo video;
        Intrinsics.checkNotNullParameter(ad5, "ad");
        OperationAd operationAd = this.currentAd;
        boolean areEqual = Intrinsics.areEqual((operationAd == null || (video = operationAd.getVideo()) == null) ? null : video.getUrl(), ad5.getVideo().getUrl());
        SquareBaseKt.getSquareLog().i(TAG, "isSameUrl: " + areEqual + ", " + ad5 + ".video.url");
        return areEqual;
    }

    public final boolean checkViewVisible() {
        return getVisibility() == 0;
    }

    @Override // com.tencent.state.square.chatland.view.IOperationView
    public void destroy() {
        hide();
    }

    public final IVideoListener getListener() {
        return this.listener;
    }

    public final void pause(boolean isFragment) {
        AdVideoPlayer adVideoPlayer = this.player;
        if (adVideoPlayer != null) {
            adVideoPlayer.pauseVideo();
        }
    }

    @Override // com.tencent.state.square.chatland.view.IOperationView
    public void resetElevation(Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        setElevation(location.getCenterY() * 10);
    }

    public final void resume(boolean isFragment) {
        AdVideoPlayer adVideoPlayer = this.player;
        if (adVideoPlayer != null) {
            adVideoPlayer.resumeVideo();
        }
    }

    @Override // com.tencent.state.square.chatland.view.IOperationView
    public void showDebugTools() {
        if (Square.INSTANCE.getConfig().isDebug()) {
            Drawable drawable = DrawableUtil.INSTANCE.getDrawable(R.drawable.i7c);
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
        final OperationAdVideo video = ad5.getVideo();
        isBlank = StringsKt__StringsJVMKt.isBlank(video.getUrl());
        if (!isBlank) {
            if (!checkIsSameMedia(ad5)) {
                SquareBaseKt.getSquareThread().postOnUi(new ChatLandOperationAdVideoView$update$1(this, video, ad5));
            } else {
                AdVideoPlayer adVideoPlayer = this.player;
                if (adVideoPlayer != null) {
                    adVideoPlayer.resumeVideo();
                }
            }
            ViewExtensionsKt.updateLayoutParams(this, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandOperationAdVideoView$update$2
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
                    receiver.width = OperationAdVideo.this.getLocation().getWidth();
                    receiver.height = OperationAdVideo.this.getLocation().getHeight();
                    receiver.topMargin = OperationAdVideo.this.getLocation().getY();
                    receiver.leftMargin = OperationAdVideo.this.getLocation().getX();
                }
            });
            resetElevation(video.getLocation());
            setVisibility(0);
            return;
        }
        hide();
    }

    public ChatLandOperationAdVideoView(Context context, IVideoListener iVideoListener) {
        this(context, null, 0, iVideoListener, 6, null);
    }

    public /* synthetic */ ChatLandOperationAdVideoView(Context context, AttributeSet attributeSet, int i3, IVideoListener iVideoListener, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, iVideoListener);
    }

    public final void hide() {
        setVisibility(8);
        this.currentAd = null;
        AdVideoPlayer adVideoPlayer = this.player;
        if (adVideoPlayer != null) {
            adVideoPlayer.stopVideo();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandOperationAdVideoView(Context context, AttributeSet attributeSet, int i3, IVideoListener listener) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.view = new TextureView(context);
        setVisibility(4);
        View view = this.view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView(view, layoutParams);
        SquareBaseKt.getSquareReporter().setElementInfo(this, SquareReportConst.ElementId.ELEMENT_ID_NEARBY_LAND_VIDEO, new LinkedHashMap(), false, false);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.view.ChatLandOperationAdVideoView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                squareReporter.reportEvent("clck", it, new LinkedHashMap());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateVideoSize(OperationAdVideo info) {
    }
}
