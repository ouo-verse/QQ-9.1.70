package com.tencent.biz.qqcircle.beans;

import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalEditViewModel;

/* loaded from: classes4.dex */
public class QFSPersonalGroupInfoInitBean extends QCircleInitBean {
    private QFSPersonalEditViewModel.Group mBoundGroupInfoList;
    private String mHostUin;
    private long mSelectGroupId;
    private boolean selectWhenClick;

    public QFSPersonalEditViewModel.Group getBoundGroupInfoList() {
        return this.mBoundGroupInfoList;
    }

    public String getHostUin() {
        return this.mHostUin;
    }

    public long getSelectGroupId() {
        return this.mSelectGroupId;
    }

    public boolean isSelectWhenClick() {
        return this.selectWhenClick;
    }

    public void setBoundGroupInfoList(QFSPersonalEditViewModel.Group group) {
        this.mBoundGroupInfoList = group;
    }

    public void setHostUin(String str) {
        this.mHostUin = str;
    }

    public void setSelectGroupId(long j3) {
        this.mSelectGroupId = j3;
    }

    public void setSelectWhenClick(boolean z16) {
        this.selectWhenClick = z16;
    }

    public String toString() {
        return "QFSPersonalGroupInfoInitBean{mHostUin='" + this.mHostUin + "', mBoundGroupInfoList=" + this.mBoundGroupInfoList + ", mSelectGroupId=" + this.mSelectGroupId + ", selectWhenClick=" + this.selectWhenClick + '}';
    }
}
