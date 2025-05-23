package com.qzone.publish.business.task;

import NS_MOBILE_QUN.qun_upload_finish_rsp;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.publish.business.protocol.QZoneQuoteQunPhotoRequest;
import com.qzone.publish.business.protocol.QzoneQunUploadPicFinishRequest;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.util.ToastUtil;
import com.qzone.util.image.NetImageInfo;
import com.qzone.util.l;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes39.dex */
public class QzoneQuoteQunPicTask extends QZoneQueueTask {
    private static final int STEP_FINISH = 2;
    private static final int STEP_QUOTE = 1;

    @NeedParcel
    private String albumName;

    @NeedParcel
    private String albumid;

    @NeedParcel
    private String desc;

    @NeedParcel
    private long fromUin;

    @NeedParcel
    private List<NetImageInfo> imageInfos;

    @NeedParcel
    private String qunid;

    @NeedParcel
    private String refer;

    @NeedParcel
    private int step;

    @NeedParcel
    private long svrTime;
    private int uploadFinishRetryCount;

    public QzoneQuoteQunPicTask() {
        this.step = 1;
        this.uploadFinishRetryCount = 0;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey */
    public String getCommentUniKey() {
        return this.clientKey;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return 8;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public c getInfo() {
        c info = super.getInfo();
        info.f51185a = l.a(R.string.s7g) + this.albumName + "\u300b";
        return info;
    }

    public Map<String, String> getLocalUrlMap() {
        long j3 = this.svrTime;
        HashMap hashMap = new HashMap();
        Iterator<NetImageInfo> it = this.imageInfos.iterator();
        while (it.hasNext()) {
            j3++;
            hashMap.put(LoginData.getInstance().getUin() + "_" + j3 + "_" + this.clientKey, it.next().mSmallPath);
        }
        return hashMap;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public String getPhotoSource() {
        List<NetImageInfo> list = this.imageInfos;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.imageInfos.get(0).mSmallPath;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
        int i3 = this.step;
        if (i3 == 1) {
            this.mRequest = new QZoneQuoteQunPhotoRequest(this.qunid, this.albumid, this.batchId, this.fromUin, this.imageInfos, this.clientKey, this.desc, this.svrTime);
            return;
        }
        if (i3 != 2) {
            return;
        }
        String str = this.qunid;
        long j3 = this.batchId;
        String str2 = this.albumid;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        List<NetImageInfo> list = this.imageInfos;
        int size = list != null ? list.size() : 0;
        List<NetImageInfo> list2 = this.imageInfos;
        QzoneQunUploadPicFinishRequest qzoneQunUploadPicFinishRequest = new QzoneQunUploadPicFinishRequest(str, j3, str3, size, list2 != null ? list2.size() : 0, this.clientKey, this.uploadFinishRetryCount, TextUtils.isEmpty(this.albumid) ? 1 : 0);
        this.mRequest = qzoneQunUploadPicFinishRequest;
        qzoneQunUploadPicFinishRequest.setRefer(this.refer);
        this.uploadFinishRetryCount++;
    }

    public QzoneQuoteQunPicTask(String str, String str2, String str3, long j3, List<NetImageInfo> list, String str4, int i3, long j16, String str5, long j17, String str6) {
        super(i3);
        this.step = 1;
        this.uploadFinishRetryCount = 0;
        this.qunid = str;
        this.albumid = str2;
        this.albumName = str3;
        this.fromUin = j3;
        this.imageInfos = list;
        this.desc = str4;
        this.batchId = j16;
        this.clientKey = str5;
        this.svrTime = j17;
        this.refer = str6;
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask == null) {
            return;
        }
        int i3 = this.step;
        boolean z16 = true;
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            qun_upload_finish_rsp qun_upload_finish_rspVar = (qun_upload_finish_rsp) qZoneTask.mRequest.rsp;
            if (qun_upload_finish_rspVar == null || qun_upload_finish_rspVar.retry_timeout <= 0) {
                z16 = false;
            } else {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.QzoneQuoteQunPicTask.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QzoneQuoteQunPicTask.this.run();
                    }
                }, qun_upload_finish_rspVar.retry_timeout * 1000);
            }
            if (z16) {
                return;
            }
            QZoneWriteOperationService.v0().onTaskResponse(qZoneTask);
            return;
        }
        QZonePublishQueue.w().g(this, qZoneTask.succeeded());
        if (qZoneTask.succeeded()) {
            this.step = 2;
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.QzoneQuoteQunPicTask.1
                @Override // java.lang.Runnable
                public void run() {
                    QzoneQuoteQunPicTask.this.run();
                }
            }, 1000L);
            return;
        }
        ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoQuoteFail", "\u8f6c\u8f7d\u5931\u8d25\uff01") + qZoneTask.f45835msg, 4);
    }
}
