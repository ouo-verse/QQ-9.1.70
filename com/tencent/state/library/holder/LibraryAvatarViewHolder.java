package com.tencent.state.library.holder;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.data.UserCommon;
import com.tencent.state.library.data.LibraryAvatarItem;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.map.MapPlayableViewHolder;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.IDecodeTaskCompletionListener;
import com.tencent.state.square.api.IFaceDecoder;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.data.FilamentResource;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.databinding.VasSquareItemLibraryAvatarBinding;
import com.tencent.state.square.resource.IResourceManager;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import com.tencent.state.utils.SquareSwitchUtils;
import com.tencent.state.view.CircleBoarderImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001/B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J,\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0018\u0010#\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020\rH\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0018\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020$H\u0014J\u0010\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020'H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/tencent/state/library/holder/LibraryAvatarViewHolder;", "Lcom/tencent/state/map/MapPlayableViewHolder;", "Lcom/tencent/state/library/data/LibraryAvatarItem;", "Lcom/tencent/state/square/api/IDecodeTaskCompletionListener;", "Landroid/view/View$OnClickListener;", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemLibraryAvatarBinding;", "(Lcom/tencent/state/square/databinding/VasSquareItemLibraryAvatarBinding;)V", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareItemLibraryAvatarBinding;", "faceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", "adjustAvatarLocation", "", "data", "adjustBubbleLocation", "bindAvatar", "bindBubble", "bindListeners", "doBind", "index", "", "getPlayerView", "Lcom/tencent/state/square/avatar/SquareAvatarView;", "onBackFromDetail", NodeProps.ON_CLICK, "v", "Landroid/view/View;", "onDecodeTaskCompleted", "remainingTasks", "type", "uin", "", "avatar", "Landroid/graphics/Bitmap;", "onFirstScreenCompleted", "Lcom/tencent/state/map/MapItem;", "onRecycled", "onScaleToDetail", "", "resizeAvatar", "setHeadImage", "view", "Landroid/widget/ImageView;", "transform", "updateNeighborBubbleVisible", "isVisible", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryAvatarViewHolder extends MapPlayableViewHolder<LibraryAvatarItem> implements IDecodeTaskCompletionListener, View.OnClickListener {
    private static final String TAG = "LibraryAvatarViewHolder";
    private final VasSquareItemLibraryAvatarBinding binding;
    private IFaceDecoder faceDecoder;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LibraryAvatarViewHolder(VasSquareItemLibraryAvatarBinding binding) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        RelativeLayout mRv = binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        this.binding = binding;
    }

    private final void adjustAvatarLocation(LibraryAvatarItem data) {
        final Rect itemViewLocation = data.getItemViewLocation();
        final Location location = data.getLocation();
        SquareAvatarView squareAvatarView = this.binding.avatar;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.avatar");
        ViewExtensionsKt.updateLayoutParams(squareAvatarView, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.library.holder.LibraryAvatarViewHolder$adjustAvatarLocation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RelativeLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.width = Location.this.getWidth();
                receiver.height = Location.this.getHeight();
                receiver.leftMargin = Location.this.getX() - itemViewLocation.left;
                receiver.topMargin = Location.this.getY() - itemViewLocation.top;
            }
        });
    }

    private final void adjustBubbleLocation(LibraryAvatarItem data) {
        Table table;
        final Point bubbleCoordinate;
        SitDownInfo sitDown = data.getUser().getSitDown();
        if (sitDown == null || (table = sitDown.getTable()) == null || (bubbleCoordinate = table.getBubbleCoordinate()) == null) {
            return;
        }
        RelativeLayout relativeLayout = this.binding.bubble;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.bubble");
        ViewExtensionsKt.updateLayoutParams(relativeLayout, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.library.holder.LibraryAvatarViewHolder$adjustBubbleLocation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Point point = bubbleCoordinate;
                receiver.leftMargin = point.x;
                receiver.topMargin = -point.y;
            }
        });
    }

    private final void bindBubble(LibraryAvatarItem data) {
        String str;
        CommonTagInfo tag;
        UserCommon info = data.getUser().getInfo();
        CircleBoarderImageView circleBoarderImageView = this.binding.head;
        Intrinsics.checkNotNullExpressionValue(circleBoarderImageView, "binding.head");
        setHeadImage(circleBoarderImageView, String.valueOf(info.getUin()));
        TextView textView = this.binding.nick;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.nick");
        textView.setText(info.getNick());
        TextView textView2 = this.binding.focusText;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.focusText");
        SitDownInfo sitDown = data.getUser().getSitDown();
        if (sitDown == null || (tag = sitDown.getTag()) == null || (str = tag.getText()) == null) {
            str = "";
        }
        textView2.setText(str);
        RelativeLayout relativeLayout = this.binding.bubble;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.bubble");
        relativeLayout.setVisibility(0);
    }

    private final void bindListeners(LibraryAvatarItem data) {
        this.binding.hitArea.setOnClickListener(this);
        this.binding.bubble.setOnClickListener(this);
    }

    private final void setHeadImage(ImageView view, String uin) {
        if (this.faceDecoder == null) {
            IFaceDecoder faceDecoder = Square.INSTANCE.getConfig().getObtainInstanceHelper().getFaceDecoder();
            faceDecoder.setDecodeTaskCompletionListener(this);
            Unit unit = Unit.INSTANCE;
            this.faceDecoder = faceDecoder;
        }
        IFaceDecoder iFaceDecoder = this.faceDecoder;
        Bitmap bitmapFromCache = iFaceDecoder != null ? iFaceDecoder.getBitmapFromCache(uin, false) : null;
        if (bitmapFromCache != null) {
            SquareBaseKt.getSquareLog().i(TAG, "setHeadImage: set directly from cache");
            view.setImageBitmap(bitmapFromCache);
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "setHeadImage: requestDecodeFace");
        IFaceDecoder iFaceDecoder2 = this.faceDecoder;
        if (iFaceDecoder2 != null) {
            iFaceDecoder2.requestDecodeFace(uin, false);
        }
        view.setImageResource(R.drawable.i9d);
    }

    private final void updateNeighborBubbleVisible(boolean isVisible) {
        VasSquareItemLibraryAvatarBinding vasSquareItemLibraryAvatarBinding;
        RelativeLayout relativeLayout;
        IMapItemViewManager viewManager;
        IMapItemViewManager viewManager2;
        MapItemController controller = getController();
        Integer valueOf = (controller == null || (viewManager2 = controller.getViewManager()) == null) ? null : Integer.valueOf(viewManager2.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.library.holder.LibraryAvatarViewHolder$updateNeighborBubbleVisible$index$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                return Boolean.valueOf(invoke2(mapItem));
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(MapItem it) {
                User user;
                SitDownInfo sitDown;
                Table table;
                Table neighbor;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it instanceof LibraryAvatarItem) {
                    LibraryAvatarItem libraryAvatarItem = (LibraryAvatarItem) LibraryAvatarViewHolder.this.getData();
                    Long valueOf2 = (libraryAvatarItem == null || (user = libraryAvatarItem.getUser()) == null || (sitDown = user.getSitDown()) == null || (table = sitDown.getTable()) == null || (neighbor = table.getNeighbor()) == null) ? null : Long.valueOf(neighbor.getId());
                    SitDownInfo sitDown2 = ((LibraryAvatarItem) it).getUser().getSitDown();
                    if (Intrinsics.areEqual(valueOf2, sitDown2 != null ? Long.valueOf(sitDown2.getTableId()) : null)) {
                        return true;
                    }
                }
                return false;
            }
        }));
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            MapItemController controller2 = getController();
            MapViewHolder<?> viewHolder = (controller2 == null || (viewManager = controller2.getViewManager()) == null) ? null : viewManager.getViewHolder(intValue);
            LibraryAvatarViewHolder libraryAvatarViewHolder = (LibraryAvatarViewHolder) (viewHolder instanceof LibraryAvatarViewHolder ? viewHolder : null);
            if (libraryAvatarViewHolder == null || (vasSquareItemLibraryAvatarBinding = libraryAvatarViewHolder.binding) == null || (relativeLayout = vasSquareItemLibraryAvatarBinding.bubble) == null) {
                return;
            }
            relativeLayout.setVisibility(isVisible ? 0 : 8);
        }
    }

    public final VasSquareItemLibraryAvatarBinding getBinding() {
        return this.binding;
    }

    @Override // com.tencent.state.map.MapPlayableViewHolder
    public SquareAvatarView getPlayerView() {
        SquareAvatarView squareAvatarView = this.binding.avatar;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.avatar");
        return squareAvatarView;
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onBackFromDetail() {
        super.onBackFromDetail();
        RelativeLayout relativeLayout = this.binding.bubble;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.bubble");
        relativeLayout.setVisibility(0);
        updateNeighborBubbleVisible(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.square.api.IDecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int remainingTasks, int type, String uin, final Bitmap avatar) {
        User user;
        LibraryAvatarItem libraryAvatarItem = (LibraryAvatarItem) getData();
        if (!Intrinsics.areEqual(uin, (libraryAvatarItem == null || (user = libraryAvatarItem.getUser()) == null) ? null : user.getUin()) || avatar == null) {
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "setHeadImage: onDecodeTaskCompleted: uin: " + uin);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.library.holder.LibraryAvatarViewHolder$onDecodeTaskCompleted$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LibraryAvatarViewHolder.this.getBinding().head.setImageBitmap(avatar);
            }
        });
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onFirstScreenCompleted(MapItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.map.MapPlayableViewHolder, com.tencent.state.map.MapViewHolder
    public void onRecycled() {
        super.onRecycled();
        IFaceDecoder iFaceDecoder = this.faceDecoder;
        if (iFaceDecoder != null) {
            iFaceDecoder.destroy();
        }
        this.faceDecoder = null;
        this.binding.avatar.setStaticSource(null, true);
        this.binding.head.setImageDrawable(null);
    }

    @Override // com.tencent.state.map.MapViewHolder
    public boolean onScaleToDetail() {
        boolean onScaleToDetail = super.onScaleToDetail();
        if (onScaleToDetail) {
            MapItemController controller = getController();
            if (controller != null) {
                controller.setItemAlpha(0.0f);
            }
            RelativeLayout relativeLayout = this.binding.bubble;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.bubble");
            relativeLayout.setVisibility(8);
            updateNeighborBubbleVisible(false);
        }
        return onScaleToDetail;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapPlayableViewHolder
    public void bindAvatar(LibraryAvatarItem data) {
        Resource userResource;
        FilamentResource filament;
        Intrinsics.checkNotNullParameter(data, "data");
        this.binding.avatar.setData(data);
        if (SquareSwitchUtils.INSTANCE.enableFilamentIndex() && (userResource = data.getUserResource()) != null && (filament = userResource.getFilament()) != null) {
            filament.setUrl("");
        }
        IResourceManager.DefaultImpls.setAvatarResource$default(getRm(), data, false, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public void doBind(LibraryAvatarItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        bindAvatar(data);
        resizeAvatar(data);
        bindBubble(data);
        bindListeners(data);
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        MapItemController controller = getController();
        itemView.setAlpha(controller != null ? controller.getItemAlpha() : 1.0f);
    }

    @Override // com.tencent.state.map.MapPlayableViewHolder
    public void resizeAvatar(LibraryAvatarItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        adjustAvatarLocation(data);
        adjustBubbleLocation(data);
        View view = this.binding.hitArea;
        Intrinsics.checkNotNullExpressionValue(view, "binding.hitArea");
        ViewHolderExtensionsKt.adjustHitAreaLocation(view, data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public LibraryAvatarItem transform(MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof LibraryAvatarItem)) {
            data = null;
        }
        return (LibraryAvatarItem) data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        MapItemController controller;
        IMapViewListener listener;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.pzs) {
            MapViewHolder.doScaleToDetail$default(this, 1, null, 2, null);
            return;
        }
        if (valueOf == null || valueOf.intValue() != R.id.pgr || (controller = getController()) == null || (listener = controller.getListener()) == null) {
            return;
        }
        int index = getIndex();
        MapItem data = getData();
        LibraryAvatarItem libraryAvatarItem = (LibraryAvatarItem) getData();
        listener.onItemClicked(this, index, data, 3, libraryAvatarItem != null ? libraryAvatarItem.getUin() : null);
    }
}
