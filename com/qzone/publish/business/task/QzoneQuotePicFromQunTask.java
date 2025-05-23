package com.qzone.publish.business.task;

import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.publish.business.protocol.QZoneQuotePicFromQunRequest;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.util.image.NetImageInfo;
import com.qzone.util.l;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.mobileqq.R;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class QzoneQuotePicFromQunTask extends QZoneQueueTask {

    @NeedParcel
    private String albumName;

    @NeedParcel
    private String albumid;

    @NeedParcel
    private String desc;

    @NeedParcel
    private ArrayList<NetImageInfo> imageInfos;

    @NeedParcel
    private String qunid;

    public QzoneQuotePicFromQunTask() {
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey */
    public String getCommentUniKey() {
        return this.clientKey;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return 9;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public c getInfo() {
        c info = super.getInfo();
        info.f51185a = l.a(R.string.s7e) + this.albumName + "\u300b";
        return info;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public String getPhotoSource() {
        ArrayList<NetImageInfo> arrayList = this.imageInfos;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return this.imageInfos.get(0).mSmallPath;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
        this.mRequest = new QZoneQuotePicFromQunRequest(this.qunid, this.albumid, this.albumName, this.batchId, this.imageInfos, this.desc);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask.succeeded()) {
            QZonePublishQueue.w().g(this, true);
            QZoneWriteOperationService.v0().onTaskResponse(qZoneTask);
        } else {
            QZonePublishQueue.w().g(this, false);
        }
    }

    public QzoneQuotePicFromQunTask(int i3, String str, String str2, String str3, long j3, String str4, ArrayList<NetImageInfo> arrayList, String str5) {
        super(i3);
        this.qunid = str;
        this.albumid = str2;
        this.albumName = str3;
        this.batchId = j3;
        this.clientKey = str4;
        this.desc = str5;
        this.imageInfos = arrayList;
    }
}
