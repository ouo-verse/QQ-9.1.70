package com.tencent.superplayer.preload;

import android.app.Activity;
import com.tencent.superplayer.api.ISPlayerPreLoader;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes26.dex */
public class SPlayerPreLoaderImpl implements ISPlayerPreLoader {
    private int mMaxTaskSize;
    private int mSceneId;
    private Queue<Integer> mTaskQueue = new ConcurrentLinkedQueue();

    public SPlayerPreLoaderImpl(int i3, int i16) {
        this.mSceneId = i3;
        this.mMaxTaskSize = i16;
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreLoader
    public synchronized void release() {
        Iterator<Integer> it = this.mTaskQueue.iterator();
        while (it.hasNext()) {
            PreloadPlayerMgr.getInstance().stopPreloadTask(it.next().intValue());
        }
        this.mTaskQueue.clear();
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreLoader
    public synchronized int startPreloadTask(Activity activity, SuperPlayerVideoInfo superPlayerVideoInfo) {
        int startPreloadTask;
        Integer poll;
        startPreloadTask = PreloadPlayerMgr.getInstance().startPreloadTask(activity, this.mSceneId, superPlayerVideoInfo);
        this.mTaskQueue.offer(Integer.valueOf(startPreloadTask));
        if (this.mTaskQueue.size() > this.mMaxTaskSize && (poll = this.mTaskQueue.poll()) != null) {
            PreloadPlayerMgr.getInstance().stopPreloadTask(poll.intValue());
        }
        return startPreloadTask;
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreLoader
    public synchronized void stopPreloadTask(int i3) {
        if (this.mTaskQueue.contains(Integer.valueOf(i3))) {
            PreloadPlayerMgr.getInstance().stopPreloadTask(i3);
            this.mTaskQueue.remove(Integer.valueOf(i3));
        }
    }
}
