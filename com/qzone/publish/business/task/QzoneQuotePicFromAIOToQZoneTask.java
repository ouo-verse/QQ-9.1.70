package com.qzone.publish.business.task;

import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.publish.business.protocol.QzoneQuotePhotoFromAIOToQzoneRequest;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.util.image.NetImageInfo;
import com.qzone.util.l;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.mobileqq.R;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class QzoneQuotePicFromAIOToQZoneTask extends QZoneQueueTask {

    @NeedParcel
    private String albumName;

    @NeedParcel
    private String albumid;

    @NeedParcel
    private String desc;

    @NeedParcel
    private ArrayList<NetImageInfo> imageInfos;

    @NeedParcel
    private long srcType;

    @NeedParcel
    private long srcUin;

    public QzoneQuotePicFromAIOToQZoneTask() {
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey */
    public String getCommentUniKey() {
        return this.clientKey;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return 11;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public c getInfo() {
        c info = super.getInfo();
        info.f51185a = l.a(R.string.s7f) + this.albumName + "\u300b";
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
        this.mRequest = new QzoneQuotePhotoFromAIOToQzoneRequest(this.albumid, this.albumName, this.batchId, this.desc, this.imageInfos, this.srcUin, this.srcType);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        QZonePublishQueue.w().g(this, qZoneTask.succeeded());
        QZoneWriteOperationService.v0().onTaskResponse(qZoneTask);
    }

    public QzoneQuotePicFromAIOToQZoneTask(int i3, String str, String str2, long j3, String str3, String str4, long j16, long j17, ArrayList<NetImageInfo> arrayList) {
        super(i3);
        this.albumid = str;
        this.albumName = str2;
        this.batchId = j3;
        this.desc = str4;
        this.srcUin = j16;
        this.srcType = j17;
        this.imageInfos = arrayList;
        this.clientKey = str3;
    }
}
