package kj;

import com.qzone.common.account.LoginData;
import com.qzone.reborn.intimate.config.download.QZoneIntimateDownloadDbTaskState;
import com.qzone.reborn.util.g;
import com.tencent.biz.richframework.queue.DownloadState;
import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b\u00a8\u0006\r"}, d2 = {"Lkj/f;", "", "Lcom/qzone/reborn/intimate/config/download/QZoneIntimateDownloadDbTaskState;", "taskState", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;", "b", "taskStateData", "c", "", "dbList", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f412545a = new f();

    f() {
    }

    private final RFWDownloadTaskStateData b(QZoneIntimateDownloadDbTaskState taskState) {
        if (taskState == null) {
            return null;
        }
        RFWDownloadTaskStateData rFWDownloadTaskStateData = new RFWDownloadTaskStateData(taskState.getBusinessKey(), taskState.getUrl());
        rFWDownloadTaskStateData.setState(DownloadState.fromCode(taskState.getState()));
        rFWDownloadTaskStateData.setFilePath(taskState.getFilePath());
        rFWDownloadTaskStateData.setPercent(taskState.getPercent());
        rFWDownloadTaskStateData.setDownloadedLength(taskState.getDownloadedLength());
        rFWDownloadTaskStateData.setTotalLength(taskState.getTotalLength());
        rFWDownloadTaskStateData.setTaskGenerateTime(taskState.getTaskGenerateTime());
        rFWDownloadTaskStateData.setExtMap(g.b(taskState.getExtMapJson()));
        return rFWDownloadTaskStateData;
    }

    public final List<RFWDownloadTaskStateData> a(List<? extends QZoneIntimateDownloadDbTaskState> dbList) {
        if (dbList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<? extends QZoneIntimateDownloadDbTaskState> it = dbList.iterator();
        while (it.hasNext()) {
            RFWDownloadTaskStateData b16 = f412545a.b(it.next());
            if (b16 != null) {
                arrayList.add(b16);
            }
        }
        return arrayList;
    }

    public final QZoneIntimateDownloadDbTaskState c(RFWDownloadTaskStateData taskStateData) {
        if (taskStateData == null) {
            return null;
        }
        QZoneIntimateDownloadDbTaskState qZoneIntimateDownloadDbTaskState = new QZoneIntimateDownloadDbTaskState();
        HashMap<String, String> extMap = taskStateData.getExtMap();
        String str = extMap != null ? extMap.get("ext_key_uin") : null;
        if (str == null) {
            str = LoginData.getInstance().getUinString();
        }
        qZoneIntimateDownloadDbTaskState.setUin(str);
        qZoneIntimateDownloadDbTaskState.setUrl(taskStateData.getUrl());
        qZoneIntimateDownloadDbTaskState.setBusinessKey(taskStateData.getBusinessKey());
        qZoneIntimateDownloadDbTaskState.setState(taskStateData.getState().ordinal());
        qZoneIntimateDownloadDbTaskState.setFilePath(taskStateData.getFilePath());
        qZoneIntimateDownloadDbTaskState.setPercent(taskStateData.getPercent());
        qZoneIntimateDownloadDbTaskState.setDownloadedLength(taskStateData.getDownloadedLength());
        qZoneIntimateDownloadDbTaskState.setTotalLength(taskStateData.getTotalLength());
        qZoneIntimateDownloadDbTaskState.setTaskGenerateTime(taskStateData.getTaskGenerateTime());
        qZoneIntimateDownloadDbTaskState.setExtMapJson(g.c(taskStateData.getExtMap()));
        return qZoneIntimateDownloadDbTaskState;
    }
}
