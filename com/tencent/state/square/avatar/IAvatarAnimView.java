package com.tencent.state.square.avatar;

import android.view.View;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.square.media.MapPlayableSource;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016J$\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0003H&J$\u0010\u0018\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0019\u001a\u00020\rH&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\rH\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006'"}, d2 = {"Lcom/tencent/state/square/avatar/IAvatarAnimView;", "", "addListener", "", "listener", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "addListeners", "listeners", "", "changeSourceWithAnim", "source", "Lcom/tencent/state/square/media/MapPlayableSource;", "needCleanAll", "", "clearListeners", "destroy", "getListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "getView", "Landroid/view/View;", "isPlaying", "pause", "removeListener", "resume", "setAnimSource", "needAnim", "setAutoShowStatic", "autoStatic", "setConfig", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/avatar/AvatarAnimConfig;", "setData", "data", "Lcom/tencent/state/map/MapPlayableItem;", "setLoopPlay", "isLoop", "start", "stop", "updateAnimSource", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IAvatarAnimView {
    void addListener(IAvatarAnimListener listener);

    void addListeners(Set<? extends IAvatarAnimListener> listeners);

    void changeSourceWithAnim(MapPlayableSource source, IAvatarAnimListener listener, boolean needCleanAll);

    void clearListeners();

    void destroy();

    CopyOnWriteArraySet<IAvatarAnimListener> getListeners();

    View getView();

    boolean isPlaying();

    void pause();

    void removeListener(IAvatarAnimListener listener);

    void resume();

    void setAnimSource(MapPlayableSource source, IAvatarAnimListener listener, boolean needAnim);

    void setAutoShowStatic(boolean autoStatic);

    void setConfig(AvatarAnimConfig r16);

    void setData(MapPlayableItem data);

    void setLoopPlay(boolean isLoop);

    void start();

    void stop();

    void updateAnimSource(MapPlayableSource source);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static void addListeners(IAvatarAnimView iAvatarAnimView, Set<? extends IAvatarAnimListener> listeners) {
            Intrinsics.checkNotNullParameter(listeners, "listeners");
        }

        public static void changeSourceWithAnim(IAvatarAnimView iAvatarAnimView, MapPlayableSource source, IAvatarAnimListener iAvatarAnimListener, boolean z16) {
            Intrinsics.checkNotNullParameter(source, "source");
        }

        public static CopyOnWriteArraySet<IAvatarAnimListener> getListeners(IAvatarAnimView iAvatarAnimView) {
            return null;
        }

        public static boolean isPlaying(IAvatarAnimView iAvatarAnimView) {
            return false;
        }

        public static void removeListener(IAvatarAnimView iAvatarAnimView, IAvatarAnimListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        public static void setConfig(IAvatarAnimView iAvatarAnimView, AvatarAnimConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
        }

        public static void setData(IAvatarAnimView iAvatarAnimView, MapPlayableItem data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        public static void start(IAvatarAnimView iAvatarAnimView) {
            iAvatarAnimView.resume();
        }

        public static void stop(IAvatarAnimView iAvatarAnimView) {
            iAvatarAnimView.pause();
        }

        public static void updateAnimSource(IAvatarAnimView iAvatarAnimView, MapPlayableSource source) {
            Intrinsics.checkNotNullParameter(source, "source");
        }

        public static /* synthetic */ void changeSourceWithAnim$default(IAvatarAnimView iAvatarAnimView, MapPlayableSource mapPlayableSource, IAvatarAnimListener iAvatarAnimListener, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                iAvatarAnimView.changeSourceWithAnim(mapPlayableSource, iAvatarAnimListener, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeSourceWithAnim");
        }

        public static /* synthetic */ void setAnimSource$default(IAvatarAnimView iAvatarAnimView, MapPlayableSource mapPlayableSource, IAvatarAnimListener iAvatarAnimListener, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = true;
                }
                iAvatarAnimView.setAnimSource(mapPlayableSource, iAvatarAnimListener, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAnimSource");
        }

        public static void clearListeners(IAvatarAnimView iAvatarAnimView) {
        }

        public static void addListener(IAvatarAnimView iAvatarAnimView, IAvatarAnimListener iAvatarAnimListener) {
        }

        public static void setAutoShowStatic(IAvatarAnimView iAvatarAnimView, boolean z16) {
        }

        public static void setLoopPlay(IAvatarAnimView iAvatarAnimView, boolean z16) {
        }
    }
}
