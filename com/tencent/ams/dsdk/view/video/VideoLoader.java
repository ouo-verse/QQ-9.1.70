package com.tencent.ams.dsdk.view.video;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface VideoLoader {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface VideoLoadListener {
        void onLoadFinish(String str);

        void onLoadStart();
    }

    void loadVideoByUrl(String str, VideoLoadListener videoLoadListener);

    void loadVideoByVid(String str, VideoLoadListener videoLoadListener);
}
