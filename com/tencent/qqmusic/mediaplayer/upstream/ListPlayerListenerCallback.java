package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes23.dex */
public class ListPlayerListenerCallback implements PlayerListenerCallback {
    private final CopyOnWriteArrayList<PlayerListenerCallback> mCallbacks = new CopyOnWriteArrayList<>();

    public synchronized void add(PlayerListenerCallback playerListenerCallback) {
        this.mCallbacks.add(playerListenerCallback);
    }

    public synchronized void addAll(List<PlayerListenerCallback> list) {
        this.mCallbacks.addAll(list);
    }

    public synchronized void clear() {
        this.mCallbacks.clear();
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i3) {
        Iterator<PlayerListenerCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onBufferingUpdate(baseMediaPlayer, i3);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onCompletion(BaseMediaPlayer baseMediaPlayer) {
        Iterator<PlayerListenerCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onCompletion(baseMediaPlayer);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onError(BaseMediaPlayer baseMediaPlayer, int i3, int i16, int i17) {
        Iterator<PlayerListenerCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onError(baseMediaPlayer, i3, i16, i17);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onPrepared(BaseMediaPlayer baseMediaPlayer) {
        Iterator<PlayerListenerCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onPrepared(baseMediaPlayer);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onSeekComplete(BaseMediaPlayer baseMediaPlayer, int i3) {
        Iterator<PlayerListenerCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onSeekComplete(baseMediaPlayer, i3);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onStarted(BaseMediaPlayer baseMediaPlayer) {
        Iterator<PlayerListenerCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onStarted(baseMediaPlayer);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onStateChanged(BaseMediaPlayer baseMediaPlayer, int i3) {
        Iterator<PlayerListenerCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(baseMediaPlayer, i3);
        }
    }

    public synchronized void remove(PlayerListenerCallback playerListenerCallback) {
        this.mCallbacks.remove(playerListenerCallback);
    }

    public synchronized List<PlayerListenerCallback> toCollection() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.mCallbacks);
        return arrayList;
    }

    public synchronized void add(ListPlayerListenerCallback listPlayerListenerCallback) {
        this.mCallbacks.addAll(listPlayerListenerCallback.toCollection());
    }
}
