package com.tencent.biz.qqcircle.beans;

import java.util.List;

/* loaded from: classes4.dex */
public class QCircleCommentPicLayerBean extends QCircleInitBean {
    private String fromHashCode;
    private List<QFSCommentPicInfo> mCommentPicInfoList;
    private boolean mNeedSaveOperate;
    private int mStartPreviewIndex = 0;
    private QFSTransitionAnimBean mTransitionAnimBean;
    private boolean needAddImageOperate;

    public List<QFSCommentPicInfo> getCommentPicInfoList() {
        return this.mCommentPicInfoList;
    }

    public String getFromHashCode() {
        return this.fromHashCode;
    }

    public boolean getNeedAddImageOperate() {
        return this.needAddImageOperate;
    }

    public int getStartPreviewIndex() {
        return this.mStartPreviewIndex;
    }

    public QFSTransitionAnimBean getTransitionAnimBean() {
        return this.mTransitionAnimBean;
    }

    public boolean needSaveOperate() {
        return this.mNeedSaveOperate;
    }

    public void setCommentPicInfoList(List<QFSCommentPicInfo> list) {
        this.mCommentPicInfoList = list;
    }

    public void setFromHashCode(String str) {
        this.fromHashCode = str;
    }

    public void setNeedAddImageOperate(boolean z16) {
        this.needAddImageOperate = z16;
    }

    public void setNeedSaveOperate(boolean z16) {
        this.mNeedSaveOperate = z16;
    }

    public void setStartPreviewIndex(int i3) {
        this.mStartPreviewIndex = i3;
    }

    public void setTransitionAnimBean(QFSTransitionAnimBean qFSTransitionAnimBean) {
        this.mTransitionAnimBean = qFSTransitionAnimBean;
    }
}
