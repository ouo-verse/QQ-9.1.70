package com.tencent.component.media.image;

import android.util.Log;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageTaskManager {
    private static ConcurrentHashMap<Integer, DecodeImageTask> mWaitToDecodeImageTaskRecord = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, ImageTask> mImageTaskSet = new ConcurrentHashMap<>();
    private static ImageTaskManager mInstance = new ImageTaskManager();
    private static long requestNum = 0;

    ImageTaskManager() {
    }

    public static void addImageTask(ImageTask imageTask) {
        if (imageTask != null && imageTask.getImageKey() != null) {
            Log.d("ImageTaskManager", "addImageTask | imageKey:" + imageTask.getImageKey() + " url:" + imageTask.getImageKey().url);
            mImageTaskSet.put(Integer.valueOf(imageTask.getImageKey().hashCodeEx()), imageTask);
        }
    }

    public static void addRequest() {
        synchronized (ImageTaskManager.class) {
            requestNum++;
            Log.i("ttt", "requestNum: " + requestNum);
        }
    }

    public static void cancelImageTask(ImageKey imageKey) {
        ImageTask imageTask;
        if (imageKey != null && (imageTask = mImageTaskSet.get(Integer.valueOf(imageKey.hashCodeEx()))) != null) {
            Log.d("ImageTaskManager", "cancelImageTask | imageKey:" + imageKey.hashCodeEx() + " url:" + imageKey.url);
            imageTask.cancel();
        }
    }

    public static void clearAllImageTask() {
        mImageTaskSet.clear();
    }

    public static ImageTaskManager getInstance() {
        return mInstance;
    }

    @Deprecated
    public static void removeImageTask(ImageKey imageKey) {
        ImageTask remove;
        if (imageKey != null && (remove = mImageTaskSet.remove(Integer.valueOf(imageKey.hashCodeEx()))) != null && (remove instanceof CancelStreamDecodeGifTask)) {
            Log.d("ImageTaskManager", "removeImageTask | imageKey:" + imageKey.hashCodeEx() + " url:" + imageKey.url);
            ((CancelStreamDecodeGifTask) remove).removeRecord(imageKey.url);
        }
    }

    public static void removeRequest() {
        synchronized (ImageTaskManager.class) {
            requestNum--;
            Log.i("ttt", "requestNum: " + requestNum);
        }
    }

    public void addWaitToDecodeImageTask(DecodeImageTask decodeImageTask) {
        synchronized (mWaitToDecodeImageTaskRecord) {
            mWaitToDecodeImageTaskRecord.put(Integer.valueOf(decodeImageTask.getImageKey().hashCodeEx()), decodeImageTask);
        }
    }

    public void cancelDownload(String str) {
        DownloadImageTask.getDownloader().cancel(str);
    }

    public boolean hasWaitToDecodeImageTask(int i3) {
        ConcurrentHashMap<Integer, DecodeImageTask> concurrentHashMap;
        if (ImageTaskTracer.OPEN_GET_IMAGE_SUCCESS_RECORDER && (concurrentHashMap = mWaitToDecodeImageTaskRecord) != null) {
            return concurrentHashMap.containsKey(Integer.valueOf(i3));
        }
        return false;
    }

    public void resumeDecodeImageTask() {
        Iterator<Integer> it;
        synchronized (mWaitToDecodeImageTaskRecord) {
            Set<Integer> keySet = mWaitToDecodeImageTaskRecord.keySet();
            if (keySet != null && (it = keySet.iterator()) != null) {
                while (it.hasNext()) {
                    DecodeImageTask decodeImageTask = mWaitToDecodeImageTaskRecord.get(Integer.valueOf(it.next().intValue()));
                    if (decodeImageTask != null) {
                        decodeImageTask.startDecodeTask();
                    }
                }
            }
            mWaitToDecodeImageTaskRecord.clear();
        }
    }
}
