package com.tencent.state.map;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.avatar.AvatarAnimConfig;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.resource.IBaseResourceManager;
import com.tencent.state.square.resource.IResourceCallback;
import com.tencent.state.square.resource.IResourceManager;
import com.tencent.state.square.resource.SquareResourceManager;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 6*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u00016B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018J%\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0015\u00a2\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH&J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\bJ\u0010\u0010#\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\bH\u0004J\b\u0010&\u001a\u00020\u0013H\u0017J\u0016\u0010'\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)J\u0015\u0010*\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0015J\u0018\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001bH\u0004J\u0010\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u00132\b\b\u0002\u00101\u001a\u00020\bJ\u0006\u00102\u001a\u00020\u0013J\u0012\u00103\u001a\u00020\u00132\b\u00104\u001a\u0004\u0018\u000105H\u0004R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u00067"}, d2 = {"Lcom/tencent/state/map/MapPlayableViewHolder;", "T", "Lcom/tencent/state/map/MapPlayableItem;", "Lcom/tencent/state/map/MapViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "isPlayError", "", "()Z", "setPlayError", "(Z)V", MsfCmdConfig.CMD_DELETE_FILE, "Lcom/tencent/state/square/resource/IResourceManager;", "getRm", "()Lcom/tencent/state/square/resource/IResourceManager;", "rm$delegate", "Lkotlin/Lazy;", "bindAvatar", "", "data", "(Lcom/tencent/state/map/MapPlayableItem;)V", "changeSource", "resource", "Lcom/tencent/state/square/data/Resource;", "doBind", "index", "", "event", "(Lcom/tencent/state/map/MapPlayableItem;II)V", "getPlayerView", "Lcom/tencent/state/square/avatar/SquareAvatarView;", "getPlayerViewLocation", "Lcom/tencent/state/map/Location;", "isOccupy", "onChangeSource", "onItemCoverRecord", QQPermissionConstants.Permission.AUIDO_GROUP, "onRecycled", "playOtherResource", "delay", "", "resizeAvatar", "width", "height", "setMapAdapter", "adapter", "Lcom/tencent/state/map/MapAdapter;", "stop", "deleteFilamentAvatar", "stopWaitForAnimationEnd", "updateCover", QQWinkConstants.COVER_PATH, "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public abstract class MapPlayableViewHolder<T extends MapPlayableItem> extends MapViewHolder<T> {
    private static final String TAG = "MapPlayableViewHolder";
    private boolean isPlayError;

    /* renamed from: rm$delegate, reason: from kotlin metadata */
    private final Lazy rm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapPlayableViewHolder(View itemView) {
        super(itemView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SquareResourceManager>() { // from class: com.tencent.state.map.MapPlayableViewHolder$rm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareResourceManager invoke() {
                return new SquareResourceManager(MapPlayableViewHolder.this.getPlayerView(), new Function2<MapPlayableItem, IAvatarAnimListener, Unit>() { // from class: com.tencent.state.map.MapPlayableViewHolder$rm$2.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(MapPlayableItem mapPlayableItem, IAvatarAnimListener iAvatarAnimListener) {
                        invoke2(mapPlayableItem, iAvatarAnimListener);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(MapPlayableItem data, IAvatarAnimListener iAvatarAnimListener) {
                        IMapPlayManager rpm;
                        Intrinsics.checkNotNullParameter(data, "data");
                        MapItemController controller = MapPlayableViewHolder.this.getController();
                        if (controller == null || (rpm = controller.getRpm()) == null) {
                            return;
                        }
                        rpm.onUpdateFilament(data, iAvatarAnimListener);
                    }
                }, new Function2<MapPlayableItem, IAvatarAnimListener, Unit>() { // from class: com.tencent.state.map.MapPlayableViewHolder$rm$2.2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(MapPlayableItem mapPlayableItem, IAvatarAnimListener iAvatarAnimListener) {
                        invoke2(mapPlayableItem, iAvatarAnimListener);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(MapPlayableItem data, IAvatarAnimListener iAvatarAnimListener) {
                        IMapPlayManager rpm;
                        Intrinsics.checkNotNullParameter(data, "data");
                        MapItemController controller = MapPlayableViewHolder.this.getController();
                        if (controller == null || (rpm = controller.getRpm()) == null) {
                            return;
                        }
                        rpm.onPlayFilament(data, iAvatarAnimListener);
                    }
                }, new Function2<MapPlayableItem, Boolean, Unit>() { // from class: com.tencent.state.map.MapPlayableViewHolder$rm$2.3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(MapPlayableItem mapPlayableItem, Boolean bool) {
                        invoke(mapPlayableItem, bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(MapPlayableItem data, boolean z16) {
                        IMapPlayManager rpm;
                        Intrinsics.checkNotNullParameter(data, "data");
                        MapItemController controller = MapPlayableViewHolder.this.getController();
                        if (controller == null || (rpm = controller.getRpm()) == null) {
                            return;
                        }
                        rpm.onStopFilament(data, z16);
                    }
                }, new Function1<MapPlayableItem, Unit>() { // from class: com.tencent.state.map.MapPlayableViewHolder$rm$2.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(MapPlayableItem mapPlayableItem) {
                        invoke2(mapPlayableItem);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(MapPlayableItem data) {
                        IMapPlayManager rpm;
                        Intrinsics.checkNotNullParameter(data, "data");
                        MapItemController controller = MapPlayableViewHolder.this.getController();
                        if (controller == null || (rpm = controller.getRpm()) == null) {
                            return;
                        }
                        rpm.onPlayEnd(data);
                    }
                }, new Function2<Resource, IResourceCallback, Unit>() { // from class: com.tencent.state.map.MapPlayableViewHolder$rm$2.5
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Resource resource, IResourceCallback iResourceCallback) {
                        invoke2(resource, iResourceCallback);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Resource resource, IResourceCallback iResourceCallback) {
                        IMapViewListener listener;
                        Intrinsics.checkNotNullParameter(resource, "resource");
                        MapItemController controller = MapPlayableViewHolder.this.getController();
                        if (controller == null || (listener = controller.getListener()) == null) {
                            return;
                        }
                        listener.onStartRecord(resource, iResourceCallback);
                    }
                });
            }
        });
        this.rm = lazy;
    }

    protected abstract void bindAvatar(T data);

    public final void changeSource(MapPlayableItem data, Resource resource) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resource, "resource");
        IResourceManager.DefaultImpls.changeSource$default(getRm(), data, resource, null, 4, null);
        onChangeSource(resource);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public void doBind(T data, int index, int event) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public abstract SquareAvatarView getPlayerView();

    /* JADX INFO: Access modifiers changed from: protected */
    public final IResourceManager getRm() {
        return (IResourceManager) this.rm.getValue();
    }

    public final boolean isOccupy() {
        return getRm().isOccupied();
    }

    /* renamed from: isPlayError, reason: from getter */
    public final boolean getIsPlayError() {
        return this.isPlayError;
    }

    public void onChangeSource(Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.map.MapViewHolder
    public void onRecycled() {
        getPlayerView().destroy();
        getRm().onRecycled((MapPlayableItem) getData());
        super.onRecycled();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean playOtherResource(Resource resource, long delay) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        MapPlayableItem mapPlayableItem = (MapPlayableItem) getData();
        if (mapPlayableItem == null) {
            return false;
        }
        onChangeSource(resource);
        return IBaseResourceManager.DefaultImpls.playAvatar$default(getRm(), mapPlayableItem, resource, new IAvatarAnimListener() { // from class: com.tencent.state.map.MapPlayableViewHolder$playOtherResource$1
            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onFirstFrame() {
                IAvatarAnimListener.DefaultImpls.onFirstFrame(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayEnd() {
                IAvatarAnimListener.DefaultImpls.onPlayEnd(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayError(int errorCode) {
                MapPlayableViewHolder.this.setPlayError(true);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayStart() {
                IAvatarAnimListener.DefaultImpls.onPlayStart(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onRemovedListener() {
                IAvatarAnimListener.DefaultImpls.onRemovedListener(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onStaticFailed() {
                IAvatarAnimListener.DefaultImpls.onStaticFailed(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onStaticSuccess() {
                IAvatarAnimListener.DefaultImpls.onStaticSuccess(this);
            }
        }, delay, false, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final void resizeAvatar(int width, int height) {
        ViewGroup.LayoutParams layoutParams = getPlayerView().getLayoutParams();
        if (layoutParams == null) {
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            layoutParams = new RelativeLayout.LayoutParams(itemView.getContext(), (AttributeSet) null);
        }
        layoutParams.width = width;
        layoutParams.height = height;
        getPlayerView().setLayoutParams(layoutParams);
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("resizeAvatar: index=");
        sb5.append(getIndex());
        sb5.append(", name=");
        MapPlayableItem mapPlayableItem = (MapPlayableItem) getData();
        sb5.append(mapPlayableItem != null ? mapPlayableItem.getNickName() : null);
        sb5.append(", width=");
        sb5.append(width);
        sb5.append(", height=");
        sb5.append(height);
        squareLog.i(TAG, sb5.toString());
    }

    public abstract void resizeAvatar(T data);

    @Override // com.tencent.state.map.MapViewHolder
    public void setMapAdapter(MapAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        super.setMapAdapter(adapter);
        SquareAvatarView playerView = getPlayerView();
        MapItemController controller = adapter.getController();
        playerView.setConfig(new AvatarAnimConfig(false, controller != null ? controller.getPlayerPool() : null, null, true, 5, null));
    }

    public final void setPlayError(boolean z16) {
        this.isPlayError = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void stopWaitForAnimationEnd() {
        MapPlayableItem mapPlayableItem = (MapPlayableItem) getData();
        if (mapPlayableItem != null) {
            getRm().stopWaitForAnimationEnd(mapPlayableItem);
        }
    }

    public final Location getPlayerViewLocation() {
        View itemView = this.itemView;
        ViewGroup viewGroup = (ViewGroup) (!(itemView instanceof ViewGroup) ? null : itemView);
        if (viewGroup != null) {
            Location relativeLocation = MapPlayableViewHolderKt.getRelativeLocation(viewGroup, getPlayerView());
            return new Location((int) (viewGroup.getX() + relativeLocation.getX()), (int) (viewGroup.getY() + relativeLocation.getY()), relativeLocation.getWidth(), relativeLocation.getHeight(), 0, 0, 48, null);
        }
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        int x16 = (int) itemView.getX();
        View itemView2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
        int y16 = (int) itemView2.getY();
        View itemView3 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView3, "itemView");
        int width = itemView3.getWidth();
        View itemView4 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView4, "itemView");
        return new Location(x16, y16, width, itemView4.getHeight(), 0, 0, 48, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.state.map.MapItem] */
    public final void onItemCoverRecord(boolean record) {
        MapItemController controller;
        IMapViewListener listener;
        if (!record || (controller = getController()) == null || (listener = controller.getListener()) == null) {
            return;
        }
        IMapViewListener.DefaultImpls.onItemRecordCover$default(listener, getData(), null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void stop(boolean deleteFilamentAvatar) {
        if (deleteFilamentAvatar) {
            getRm().stop((MapPlayableItem) getData());
        } else {
            getRm().stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void updateCover(String coverPath) {
        if (coverPath != null) {
            getPlayerView().updateImageView(coverPath);
        }
    }

    public static /* synthetic */ void stop$default(MapPlayableViewHolder mapPlayableViewHolder, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = true;
            }
            mapPlayableViewHolder.stop(z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stop");
    }
}
