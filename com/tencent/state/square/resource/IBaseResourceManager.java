package com.tencent.state.square.resource;

import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import com.tencent.state.square.data.Resource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J:\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0003H&J.\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u0012\u001a\u00020\u0011H&J\u0014\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/resource/IBaseResourceManager;", "", "isOccupied", "", "playAvatar", "data", "Lcom/tencent/state/map/MapPlayableItem;", "resource", "Lcom/tencent/state/square/data/Resource;", "callback", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "delay", "", "needAnim", "setAvatarResource", "isAutoPlay", "showAvatar", "", "stop", "stopWaitForAnimationEnd", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IBaseResourceManager {
    boolean isOccupied();

    boolean playAvatar(MapPlayableItem data, Resource resource, IAvatarAnimListener callback, long delay, boolean needAnim);

    boolean setAvatarResource(MapPlayableItem data, Resource resource, boolean isAutoPlay, IAvatarAnimListener callback);

    void showAvatar(MapPlayableItem data, Resource resource, IAvatarAnimListener callback);

    void stop();

    void stop(MapPlayableItem data);

    void stopWaitForAnimationEnd(MapPlayableItem data);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static boolean isOccupied(IBaseResourceManager iBaseResourceManager) {
            return false;
        }

        public static boolean setAvatarResource(IBaseResourceManager iBaseResourceManager, MapPlayableItem data, Resource resource, boolean z16, IAvatarAnimListener iAvatarAnimListener) {
            Intrinsics.checkNotNullParameter(data, "data");
            return false;
        }

        public static /* synthetic */ boolean playAvatar$default(IBaseResourceManager iBaseResourceManager, MapPlayableItem mapPlayableItem, Resource resource, IAvatarAnimListener iAvatarAnimListener, long j3, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    resource = mapPlayableItem.getResource();
                }
                Resource resource2 = resource;
                if ((i3 & 8) != 0) {
                    j3 = 0;
                }
                long j16 = j3;
                if ((i3 & 16) != 0) {
                    z16 = true;
                }
                return iBaseResourceManager.playAvatar(mapPlayableItem, resource2, iAvatarAnimListener, j16, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playAvatar");
        }

        public static /* synthetic */ void showAvatar$default(IBaseResourceManager iBaseResourceManager, MapPlayableItem mapPlayableItem, Resource resource, IAvatarAnimListener iAvatarAnimListener, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    resource = mapPlayableItem.getResource();
                }
                if ((i3 & 4) != 0) {
                    iAvatarAnimListener = null;
                }
                iBaseResourceManager.showAvatar(mapPlayableItem, resource, iAvatarAnimListener);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAvatar");
        }

        public static /* synthetic */ boolean setAvatarResource$default(IBaseResourceManager iBaseResourceManager, MapPlayableItem mapPlayableItem, Resource resource, boolean z16, IAvatarAnimListener iAvatarAnimListener, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    iAvatarAnimListener = null;
                }
                return iBaseResourceManager.setAvatarResource(mapPlayableItem, resource, z16, iAvatarAnimListener);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAvatarResource");
        }

        public static /* synthetic */ void stop$default(IBaseResourceManager iBaseResourceManager, MapPlayableItem mapPlayableItem, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    mapPlayableItem = null;
                }
                iBaseResourceManager.stop(mapPlayableItem);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stop");
        }
    }
}
