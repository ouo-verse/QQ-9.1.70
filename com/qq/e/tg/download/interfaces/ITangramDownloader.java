package com.qq.e.tg.download.interfaces;

import com.qq.e.tg.download.data.ITGDownloaderTaskInfo;
import com.qq.e.tg.download.data.MediaCustomDownloaderCallBackInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface ITangramDownloader {
    MediaCustomDownloaderCallBackInfo getTaskInDbByTaskId(String str);

    List<MediaCustomDownloaderCallBackInfo> getTasksInDB();

    void pause(String str);

    void remove(String str);

    void resume(String str);

    void setTangramDownloadCallback(ITangramDownloadCallback iTangramDownloadCallback);

    void start(ITGDownloaderTaskInfo iTGDownloaderTaskInfo);
}
