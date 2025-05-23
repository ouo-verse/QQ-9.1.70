package com.tencent.state.square.avatar;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.square.avatar.IAvatarAnimView;
import com.tencent.state.square.media.MapPlayableSource;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/square/avatar/ISquareAvatarView;", "Lcom/tencent/state/square/avatar/IAvatarAnimView;", "setAlpha", "", c.f123400v, "", "setImageViewVisibility", ViewStickEventHelper.IS_SHOW, "", "setStaticSource", "source", "Lcom/tencent/state/square/media/MapPlayableSource;", NodeProps.VISIBLE, "setVideoViewVisibility", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ISquareAvatarView extends IAvatarAnimView {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static void addListener(ISquareAvatarView iSquareAvatarView, IAvatarAnimListener iAvatarAnimListener) {
            IAvatarAnimView.DefaultImpls.addListener(iSquareAvatarView, iAvatarAnimListener);
        }

        public static void addListeners(ISquareAvatarView iSquareAvatarView, Set<? extends IAvatarAnimListener> listeners) {
            Intrinsics.checkNotNullParameter(listeners, "listeners");
            IAvatarAnimView.DefaultImpls.addListeners(iSquareAvatarView, listeners);
        }

        public static void changeSourceWithAnim(ISquareAvatarView iSquareAvatarView, MapPlayableSource source, IAvatarAnimListener iAvatarAnimListener, boolean z16) {
            Intrinsics.checkNotNullParameter(source, "source");
            IAvatarAnimView.DefaultImpls.changeSourceWithAnim(iSquareAvatarView, source, iAvatarAnimListener, z16);
        }

        public static void clearListeners(ISquareAvatarView iSquareAvatarView) {
            IAvatarAnimView.DefaultImpls.clearListeners(iSquareAvatarView);
        }

        public static CopyOnWriteArraySet<IAvatarAnimListener> getListeners(ISquareAvatarView iSquareAvatarView) {
            return IAvatarAnimView.DefaultImpls.getListeners(iSquareAvatarView);
        }

        public static boolean isPlaying(ISquareAvatarView iSquareAvatarView) {
            return IAvatarAnimView.DefaultImpls.isPlaying(iSquareAvatarView);
        }

        public static void removeListener(ISquareAvatarView iSquareAvatarView, IAvatarAnimListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            IAvatarAnimView.DefaultImpls.removeListener(iSquareAvatarView, listener);
        }

        public static void setAutoShowStatic(ISquareAvatarView iSquareAvatarView, boolean z16) {
            IAvatarAnimView.DefaultImpls.setAutoShowStatic(iSquareAvatarView, z16);
        }

        public static void setConfig(ISquareAvatarView iSquareAvatarView, AvatarAnimConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
            IAvatarAnimView.DefaultImpls.setConfig(iSquareAvatarView, config);
        }

        public static void setData(ISquareAvatarView iSquareAvatarView, MapPlayableItem data) {
            Intrinsics.checkNotNullParameter(data, "data");
            IAvatarAnimView.DefaultImpls.setData(iSquareAvatarView, data);
        }

        public static void setLoopPlay(ISquareAvatarView iSquareAvatarView, boolean z16) {
            IAvatarAnimView.DefaultImpls.setLoopPlay(iSquareAvatarView, z16);
        }

        public static void start(ISquareAvatarView iSquareAvatarView) {
            IAvatarAnimView.DefaultImpls.start(iSquareAvatarView);
        }

        public static void stop(ISquareAvatarView iSquareAvatarView) {
            IAvatarAnimView.DefaultImpls.stop(iSquareAvatarView);
        }

        public static void updateAnimSource(ISquareAvatarView iSquareAvatarView, MapPlayableSource source) {
            Intrinsics.checkNotNullParameter(source, "source");
            IAvatarAnimView.DefaultImpls.updateAnimSource(iSquareAvatarView, source);
        }
    }

    void setAlpha(float alpha);

    void setImageViewVisibility(boolean isShow);

    void setStaticSource(MapPlayableSource source, boolean visible);

    void setVideoViewVisibility(boolean isShow);
}
