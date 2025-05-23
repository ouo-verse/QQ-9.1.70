package com.tencent.state.map;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u001c\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\tH&J\b\u0010\u0012\u001a\u00020\u0003H&J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\tH&J\u001a\u0010\u0015\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/map/IMapPlayManager;", "Lcom/tencent/state/map/IMapComponent;", "clearInvisibleFilamentAvatar", "", "cb", "Lkotlin/Function0;", "initialize", "onCenterScaled", "isCenterScaled", "", "onFilamentResume", HippyQQPagView.EventName.ON_PLAY_END, "data", "Lcom/tencent/state/map/MapPlayableItem;", "onPlayFilament", "listener", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "needCheckVm", "onScrollIdled", "onStopFilament", "waitForAnimationEnd", "onUpdateFilament", "onVisibilityChanged", NodeProps.VISIBLE, "pauseAndEnsurePlay", "index", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public interface IMapPlayManager extends IMapComponent {
    void clearInvisibleFilamentAvatar(Function0<Unit> cb5);

    void initialize();

    void onCenterScaled(boolean isCenterScaled);

    void onFilamentResume();

    void onPlayEnd(MapPlayableItem data);

    void onPlayFilament(MapPlayableItem data, IAvatarAnimListener listener);

    void onPlayFilament(MapPlayableItem data, boolean needCheckVm);

    void onScrollIdled();

    void onStopFilament(MapPlayableItem data, boolean waitForAnimationEnd);

    void onUpdateFilament(MapPlayableItem data, IAvatarAnimListener listener);

    void onVisibilityChanged(boolean visible);

    void pauseAndEnsurePlay(int index);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void clearInvisibleFilamentAvatar$default(IMapPlayManager iMapPlayManager, Function0 function0, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    function0 = null;
                }
                iMapPlayManager.clearInvisibleFilamentAvatar(function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearInvisibleFilamentAvatar");
        }

        public static /* synthetic */ void onPlayFilament$default(IMapPlayManager iMapPlayManager, MapPlayableItem mapPlayableItem, IAvatarAnimListener iAvatarAnimListener, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    iAvatarAnimListener = null;
                }
                iMapPlayManager.onPlayFilament(mapPlayableItem, iAvatarAnimListener);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPlayFilament");
        }

        public static /* synthetic */ void onStopFilament$default(IMapPlayManager iMapPlayManager, MapPlayableItem mapPlayableItem, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                iMapPlayManager.onStopFilament(mapPlayableItem, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onStopFilament");
        }
    }
}
