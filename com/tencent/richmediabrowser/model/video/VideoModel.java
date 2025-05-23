package com.tencent.richmediabrowser.model.video;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.richmediabrowser.presenter.video.VideoPresenter;
import f04.a;
import f04.b;
import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
public class VideoModel implements a {
    private VideoPresenter videoPresenter;

    public VideoModel(b bVar) {
        if (bVar instanceof VideoPresenter) {
            this.videoPresenter = (VideoPresenter) bVar;
        }
    }

    public boolean isVideoFileExisits(VideoData videoData) {
        if (videoData != null && !TextUtils.isEmpty(videoData.filePath)) {
            return new File(videoData.filePath).exists();
        }
        return false;
    }

    @Override // f04.a
    public void buildComplete() {
    }

    @Override // f04.a
    public void buildModel() {
    }

    @Override // f04.a
    public void buildParams(Intent intent) {
    }
}
