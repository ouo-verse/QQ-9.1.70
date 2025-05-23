package com.tencent.oskplayer.proxy;

import android.text.TextUtils;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoRequestManager {
    private static final String TAG = "RequestManager";
    private ArrayList<RequestListener> mListeners = new ArrayList<>();
    private final Object mLock = new Object();
    private final LinkedHashMap<String, ArrayList<VideoRequest>> requestMap = new LinkedHashMap<>(8, 0.75f);

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface RequestListener {
        void onBeforeRequestRemove(VideoRequest videoRequest);
    }

    private void cancelRequest(VideoRequest videoRequest, boolean z16) {
        PlayerUtils.log(4, TAG, "start cancel request=" + videoRequest);
        videoRequest.cancel(z16);
    }

    private synchronized void cancelVideoRequestByUuid(String str, boolean z16) {
        Iterator<VideoRequest> it = getVideoRequestByUuid(str).iterator();
        while (it.hasNext()) {
            cancelRequest(it.next(), z16);
        }
    }

    public synchronized void addRequest(String str, VideoRequest videoRequest) {
        ArrayList<VideoRequest> arrayList = this.requestMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.requestMap.put(str, arrayList);
            PlayerUtils.log(3, TAG, "init requestMap for url " + str);
        }
        arrayList.add(videoRequest);
    }

    public void addRequestListener(RequestListener requestListener) {
        synchronized (this.mLock) {
            if (requestListener == null) {
                return;
            }
            this.mListeners.add(requestListener);
        }
    }

    public synchronized void cancelAllPreloadRequestAsync(boolean z16) {
        Iterator<Map.Entry<String, ArrayList<VideoRequest>>> it = this.requestMap.entrySet().iterator();
        while (it.hasNext()) {
            ArrayList<VideoRequest> value = it.next().getValue();
            if (value != null) {
                Iterator<VideoRequest> it5 = value.iterator();
                while (it5.hasNext()) {
                    VideoRequest next = it5.next();
                    if (next.getPrority() <= 10) {
                        PlayerUtils.log(4, TAG, "preload cancel url " + next);
                        cancelRequest(next, z16);
                        it5.remove();
                    }
                }
            } else {
                PlayerUtils.log(4, TAG, "cancel url fail, associate request not found, mediaplayer is dead?");
            }
        }
    }

    public synchronized void cancelPreloadRequestByRequest(VideoRequest videoRequest, boolean z16) {
        if (videoRequest != null) {
            videoRequest.cancel(z16);
        }
    }

    public synchronized ArrayList<VideoRequest> getActiveVideoRequest() {
        ArrayList<VideoRequest> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, ArrayList<VideoRequest>>> it = this.requestMap.entrySet().iterator();
        while (it.hasNext()) {
            ArrayList<VideoRequest> value = it.next().getValue();
            if (value.size() > 0) {
                arrayList.addAll(value);
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<VideoRequest> getPriorityRequest(int i3) {
        ArrayList<VideoRequest> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, ArrayList<VideoRequest>>> it = this.requestMap.entrySet().iterator();
        while (it.hasNext()) {
            ArrayList<VideoRequest> value = it.next().getValue();
            if (value.size() > 0 && i3 == value.get(0).getPrority()) {
                arrayList.addAll(value);
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<VideoRequest> getVideoRequestByUuid(String str, int i3) {
        ArrayList<VideoRequest> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, ArrayList<VideoRequest>>> it = this.requestMap.entrySet().iterator();
        while (it.hasNext()) {
            ArrayList<VideoRequest> value = it.next().getValue();
            if (value.size() > 0) {
                VideoRequest videoRequest = value.get(0);
                if (str.equals(videoRequest.getUuid())) {
                    if (i3 != -1) {
                        if (i3 == videoRequest.getPrority()) {
                            arrayList.addAll(value);
                        }
                    } else {
                        arrayList.addAll(value);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<VideoRequest> getVideoRequestByVideoKey(String str, int i3) {
        ArrayList<VideoRequest> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, ArrayList<VideoRequest>>> it = this.requestMap.entrySet().iterator();
        while (it.hasNext()) {
            ArrayList<VideoRequest> value = it.next().getValue();
            if (value.size() > 0) {
                VideoRequest videoRequest = value.get(0);
                if (str.equals(videoRequest.getVideoKey())) {
                    if (i3 != -1) {
                        if (i3 == videoRequest.getPrority()) {
                            arrayList.addAll(value);
                        }
                    } else {
                        arrayList.addAll(value);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void removeRequest(VideoRequest videoRequest) {
        ArrayList<VideoRequest> arrayList = this.requestMap.get(videoRequest.getSourceUrl());
        if (arrayList != null) {
            Iterator<VideoRequest> it = arrayList.iterator();
            while (it.hasNext()) {
                if (videoRequest.equals(it.next())) {
                    if (PlayerConfig.g().isDebugVersion()) {
                        PlayerUtils.log(3, TAG, "remove request " + videoRequest);
                    }
                    Iterator<RequestListener> it5 = this.mListeners.iterator();
                    while (it5.hasNext()) {
                        it5.next().onBeforeRequestRemove(videoRequest);
                    }
                    it.remove();
                }
            }
        }
    }

    public void removeRequestListener(RequestListener requestListener) {
        synchronized (this.mLock) {
            if (requestListener == null) {
                return;
            }
            this.mListeners.remove(requestListener);
        }
    }

    public synchronized String toString() {
        String str;
        str = super.toString() + "[";
        Iterator<Map.Entry<String, ArrayList<VideoRequest>>> it = this.requestMap.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<VideoRequest> it5 = it.next().getValue().iterator();
            while (it5.hasNext()) {
                str = (str + it5.next().toString()) + ",\n";
            }
        }
        return str + "]";
    }

    public synchronized void cancelVideoRequestByUuid(String str) {
        if (!TextUtils.isEmpty(str)) {
            cancelVideoRequestByUuid(str, true);
        }
    }

    public synchronized ArrayList<VideoRequest> getVideoRequestByUuid(String str) {
        return getVideoRequestByUuid(str, -1);
    }
}
