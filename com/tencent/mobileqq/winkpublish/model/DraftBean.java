package com.tencent.mobileqq.winkpublish.model;

import com.tencent.mobileqq.qroute.annotation.PluginInterface;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@PluginInterface
/* loaded from: classes21.dex */
public class DraftBean implements Comparable<DraftBean> {
    private boolean canSelect;
    private String clientKey;
    private String clientTraceId;
    private String content;
    private String coverUrl;
    private long createTime;
    private boolean isSelected;
    private int mediaType;
    private String missionId;
    private List<String> originPathList;
    private int picCount;
    private long taskId;
    private int toastStatus;
    private int uploadStatus;
    private int videoCount;

    public DraftBean() {
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public String getClientTraceId() {
        return this.clientTraceId;
    }

    public String getContent() {
        return this.content;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public String getMissionId() {
        return this.missionId;
    }

    public List<String> getOriginPath() {
        return this.originPathList;
    }

    public int getPicCount() {
        return this.picCount;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public int getToastStatus() {
        return this.toastStatus;
    }

    public int getUploadStatus() {
        return this.uploadStatus;
    }

    public int getVideoCount() {
        return this.videoCount;
    }

    public boolean isCanSelect() {
        return this.canSelect;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setCanSelect(boolean z16) {
        this.canSelect = z16;
    }

    public void setClientKey(String str) {
        this.clientKey = str;
    }

    public DraftBean setClientTraceId(String str) {
        this.clientTraceId = str;
        return this;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setCreateTime(long j3) {
        this.createTime = j3;
    }

    public void setMediaType(int i3) {
        this.mediaType = i3;
    }

    public void setMissionId(String str) {
        this.missionId = str;
    }

    public DraftBean setOriginPath(List<String> list) {
        this.originPathList = list;
        return this;
    }

    public void setPicCount(int i3) {
        this.picCount = i3;
    }

    public void setSelected(boolean z16) {
        this.isSelected = z16;
    }

    public void setTaskId(long j3) {
        this.taskId = j3;
    }

    public void setToastStatus(int i3) {
        this.toastStatus = i3;
    }

    public void setUploadStatus(int i3) {
        this.uploadStatus = i3;
    }

    public void setVideoCount(int i3) {
        this.videoCount = i3;
    }

    public String toString() {
        return "DraftBean{uploadStatus=" + this.uploadStatus + ", toastStatus=" + this.toastStatus + ", missionId='" + this.missionId + "', content='" + this.content + "', createTime=" + this.createTime + ", coverUrl='" + this.coverUrl + "', picCount=" + this.picCount + ", videoCount=" + this.videoCount + ", originPathList='" + this.originPathList + "', mediaType=" + this.mediaType + ", clientKey='" + this.clientKey + "', taskId='" + this.taskId + "'}";
    }

    public DraftBean(DraftBean draftBean) {
        this.uploadStatus = draftBean.uploadStatus;
        this.toastStatus = draftBean.toastStatus;
        this.missionId = draftBean.missionId;
        this.content = draftBean.content;
        this.createTime = draftBean.createTime;
        this.coverUrl = draftBean.coverUrl;
        this.picCount = draftBean.picCount;
        this.videoCount = draftBean.videoCount;
        this.isSelected = draftBean.isSelected;
        this.canSelect = draftBean.canSelect;
        this.originPathList = draftBean.originPathList != null ? new ArrayList(draftBean.originPathList) : null;
        this.mediaType = draftBean.mediaType;
        this.clientKey = draftBean.clientKey;
        this.clientTraceId = draftBean.clientTraceId;
        this.taskId = draftBean.taskId;
    }

    @Override // java.lang.Comparable
    public int compareTo(DraftBean draftBean) {
        if (draftBean == null) {
            throw new ClassCastException("can't trans to DraftBean...");
        }
        if (draftBean.getCreateTime() > getCreateTime()) {
            return 1;
        }
        return draftBean.getCreateTime() < getCreateTime() ? -1 : 0;
    }
}
