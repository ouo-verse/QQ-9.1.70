package com.tencent.biz.richframework.queue;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWDownloadQueueUtils {
    public static RFWDownloadTaskStateData copyDownloadTaskStateData(RFWDownloadTaskStateData rFWDownloadTaskStateData) {
        if (rFWDownloadTaskStateData == null) {
            RFWLog.e("DQ-RFWDownloadQueueUtils", RFWLog.USR, "copyDownloadTaskStateData  params error");
            return null;
        }
        RFWDownloadTaskStateData rFWDownloadTaskStateData2 = new RFWDownloadTaskStateData(rFWDownloadTaskStateData.getBusinessKey(), rFWDownloadTaskStateData.getUrl());
        rFWDownloadTaskStateData2.setState(rFWDownloadTaskStateData.getState());
        rFWDownloadTaskStateData2.setFilePath(rFWDownloadTaskStateData.getFilePath());
        rFWDownloadTaskStateData2.setPercent(rFWDownloadTaskStateData.getPercent());
        rFWDownloadTaskStateData2.setDownloadedLength(rFWDownloadTaskStateData.getDownloadedLength());
        rFWDownloadTaskStateData2.setTotalLength(rFWDownloadTaskStateData.getTotalLength());
        rFWDownloadTaskStateData2.setExtMap(rFWDownloadTaskStateData.getExtMap());
        return rFWDownloadTaskStateData2;
    }

    public static String mapToString(Map<String, String> map) {
        boolean z16 = true;
        if (map == null) {
            RFWLog.e("DQ-RFWDownloadQueueUtils", RFWLog.USR, "mapToString  params error");
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!z16) {
                sb5.append(", ");
            }
            sb5.append(entry.getKey());
            sb5.append(MsgSummary.STR_COLON);
            sb5.append(entry.getValue());
            z16 = false;
        }
        sb5.append("}");
        return sb5.toString();
    }

    public static RFWDownloadTask stateDataTransformTask(RFWDownloadTaskStateData rFWDownloadTaskStateData, Handler handler, RFWDownloadQueueStrategy rFWDownloadQueueStrategy, RFWDownloadStateProgressBox rFWDownloadStateProgressBox) {
        if (rFWDownloadTaskStateData != null && handler != null && rFWDownloadQueueStrategy != null && rFWDownloadStateProgressBox != null) {
            RFWDownloadTask rFWDownloadTask = new RFWDownloadTask(rFWDownloadQueueStrategy, rFWDownloadTaskStateData.getUrl(), handler, rFWDownloadStateProgressBox);
            rFWDownloadTask.setState(rFWDownloadTaskStateData.getState());
            rFWDownloadTask.setPercent(rFWDownloadTaskStateData.getPercent());
            rFWDownloadTask.setDownloadedLength(rFWDownloadTaskStateData.getDownloadedLength());
            rFWDownloadTask.setTotalLength(rFWDownloadTaskStateData.getTotalLength());
            rFWDownloadTask.setFilePath(rFWDownloadTaskStateData.getFilePath());
            rFWDownloadTask.setExtMap(rFWDownloadTaskStateData.getExtMap());
            return rFWDownloadTask;
        }
        RFWLog.e("DQ-RFWDownloadQueueUtils", RFWLog.USR, "stateDataTransformTask  params error");
        return null;
    }

    public static List<RFWDownloadTaskStateData> taskListTransformStateDataList(List<RFWDownloadTask> list) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<RFWDownloadTask> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(taskTransformStateData(it.next()));
            }
            return arrayList;
        }
        return null;
    }

    public static RFWDownloadTaskStateData taskTransformStateData(RFWDownloadTask rFWDownloadTask) {
        if (rFWDownloadTask != null && rFWDownloadTask.getStrategy() != null) {
            RFWDownloadTaskStateData rFWDownloadTaskStateData = new RFWDownloadTaskStateData(rFWDownloadTask.getStrategy().getBusinessKey(), rFWDownloadTask.getUrl());
            rFWDownloadTaskStateData.setState(rFWDownloadTask.getState());
            rFWDownloadTaskStateData.setFilePath(rFWDownloadTask.getFilePath());
            rFWDownloadTaskStateData.setPercent(rFWDownloadTask.getPercent());
            rFWDownloadTaskStateData.setDownloadedLength(rFWDownloadTask.getDownloadedLength());
            rFWDownloadTaskStateData.setTotalLength(rFWDownloadTask.getTotalLength());
            rFWDownloadTaskStateData.setExtMap(rFWDownloadTask.getExtMap());
            return rFWDownloadTaskStateData;
        }
        RFWLog.e("DQ-RFWDownloadQueueUtils", RFWLog.USR, "taskTransformStateData  params error");
        return null;
    }
}
