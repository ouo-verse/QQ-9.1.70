package com.tencent.mobileqq.winkpublish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;

@PluginInterface
/* loaded from: classes21.dex */
public class PublishUploadTaskResultEvent extends SimpleBaseEvent {
    private boolean byUser;
    private String clientKey;
    private String coverUrl;
    private long createTime;
    private String feedId;
    private boolean isSuccess;
    private String localVideoPath;
    private String missionId;
    private int targetPage;

    public PublishUploadTaskResultEvent(boolean z16, String str, String str2, String str3, String str4, String str5, long j3) {
        this.isSuccess = z16;
        this.missionId = str;
        this.coverUrl = str2;
        this.localVideoPath = str3;
        this.feedId = str4;
        this.clientKey = str5;
        this.createTime = j3;
    }

    public boolean getByUser() {
        return this.byUser;
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public String getLocalVideoPath() {
        return this.localVideoPath;
    }

    public String getMissionId() {
        return this.missionId;
    }

    public int getTargetPage() {
        return this.targetPage;
    }

    public String getUploadCoverUrl() {
        return this.coverUrl;
    }

    public boolean isUploadSuccess() {
        return this.isSuccess;
    }

    public void setByUser(boolean z16) {
        this.byUser = z16;
    }

    public void setTargetPage(int i3) {
        this.targetPage = i3;
    }

    public String toString() {
        return "PublishUploadTaskResultEvent{isSuccess=" + this.isSuccess + ", missionId='" + this.missionId + "', coverUrl='" + this.coverUrl + "', feedId='" + this.feedId + "', clientKey='" + this.clientKey + "', createTime=" + this.createTime + ", targetPage=" + this.targetPage + ", byUser=" + this.byUser + '}';
    }
}
