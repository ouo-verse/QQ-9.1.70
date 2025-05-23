package com.tencent.state.square.resource;

import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.resource.IBaseResourceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J&\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u000eH&J\u001a\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/square/resource/IResourceManager;", "Lcom/tencent/state/square/resource/IBaseResourceManager;", "changeSource", "", "data", "Lcom/tencent/state/map/MapPlayableItem;", "resource", "Lcom/tencent/state/square/data/Resource;", "callback", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "onRecycled", "setAvatarResource", "isAutoPlay", "", "Lcom/tencent/state/square/resource/IResourceCallback;", "startRecord", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IResourceManager extends IBaseResourceManager {
    void changeSource(MapPlayableItem data, Resource resource, IAvatarAnimListener callback);

    void onRecycled(MapPlayableItem data);

    void setAvatarResource(MapPlayableItem data, boolean isAutoPlay, IResourceCallback callback);

    void startRecord(MapPlayableItem data, IResourceCallback callback);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static void changeSource(IResourceManager iResourceManager, MapPlayableItem data, Resource resource, IAvatarAnimListener iAvatarAnimListener) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resource, "resource");
        }

        public static boolean isOccupied(IResourceManager iResourceManager) {
            return IBaseResourceManager.DefaultImpls.isOccupied(iResourceManager);
        }

        public static boolean setAvatarResource(IResourceManager iResourceManager, MapPlayableItem data, Resource resource, boolean z16, IAvatarAnimListener iAvatarAnimListener) {
            Intrinsics.checkNotNullParameter(data, "data");
            return IBaseResourceManager.DefaultImpls.setAvatarResource(iResourceManager, data, resource, z16, iAvatarAnimListener);
        }

        public static void startRecord(IResourceManager iResourceManager, MapPlayableItem data, IResourceCallback iResourceCallback) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        public static /* synthetic */ void changeSource$default(IResourceManager iResourceManager, MapPlayableItem mapPlayableItem, Resource resource, IAvatarAnimListener iAvatarAnimListener, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    iAvatarAnimListener = null;
                }
                iResourceManager.changeSource(mapPlayableItem, resource, iAvatarAnimListener);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeSource");
        }

        public static /* synthetic */ void onRecycled$default(IResourceManager iResourceManager, MapPlayableItem mapPlayableItem, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    mapPlayableItem = null;
                }
                iResourceManager.onRecycled(mapPlayableItem);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRecycled");
        }

        public static /* synthetic */ void setAvatarResource$default(IResourceManager iResourceManager, MapPlayableItem mapPlayableItem, boolean z16, IResourceCallback iResourceCallback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                if ((i3 & 4) != 0) {
                    iResourceCallback = null;
                }
                iResourceManager.setAvatarResource(mapPlayableItem, z16, iResourceCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAvatarResource");
        }
    }
}
