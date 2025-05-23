package com.tencent.mobileqq.wink.api;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.wink.export.model.WinkExportTask;
import com.tencent.mobileqq.wink.model.WinkExportParams;

@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWinkMultiExportAPI extends QRouteApi {
    void addTask(WinkExportTask winkExportTask, x73.a aVar);

    void addTaskToMain(WinkExportTask winkExportTask);

    void cancelTask(String str);

    void cancelTaskToMain(String str);

    LocalMediaInfo getExportVideoInfo(String str);

    WinkExportParams getExportVideoParams(String str);

    boolean hasRunningTask();

    void setScene(String str);
}
