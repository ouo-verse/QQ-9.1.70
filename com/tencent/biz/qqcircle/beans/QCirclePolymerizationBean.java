package com.tencent.biz.qqcircle.beans;

/* loaded from: classes4.dex */
public class QCirclePolymerizationBean extends QCircleInitBean {
    public static final int DEFAULT_VALUE = -1;
    private int mExt1From;
    private boolean mIsFromGalleryPage;
    private String mOperationActivityId;
    private String mPolymerizationName;
    private int mPolymerizationType;
    private String mTabName;
    private String mFeedTagPageFromType = "0";
    private int mTagTabType = -1;
    private int mSelectedTabType = -1;

    public int getExt1From() {
        return this.mExt1From;
    }

    public String getFeedTagPageFromType() {
        return this.mFeedTagPageFromType;
    }

    public String getOperationActivityId() {
        return this.mOperationActivityId;
    }

    public String getPolymerizationName() {
        return this.mPolymerizationName;
    }

    @Override // com.tencent.biz.qqcircle.beans.QCircleInitBean
    public int getPolymerizationType() {
        return this.mPolymerizationType;
    }

    public int getSelectedTabType() {
        return this.mSelectedTabType;
    }

    public String getTabName() {
        return this.mTabName;
    }

    public int getTagTabType() {
        return this.mTagTabType;
    }

    public boolean isFromGalleryPage() {
        return this.mIsFromGalleryPage;
    }

    public void setExt1From(int i3) {
        this.mExt1From = i3;
    }

    public void setFeedTagPageFromType(String str) {
        this.mFeedTagPageFromType = str;
    }

    public void setIsFromGalleryPage(boolean z16) {
        this.mIsFromGalleryPage = z16;
    }

    public void setOperationActivityId(String str) {
        this.mOperationActivityId = str;
    }

    public void setPolymerizationName(String str) {
        this.mPolymerizationName = str;
    }

    @Override // com.tencent.biz.qqcircle.beans.QCircleInitBean
    public void setPolymerizationType(int i3) {
        this.mPolymerizationType = i3;
    }

    public void setSelectedTabType(int i3) {
        this.mSelectedTabType = i3;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setTagTabType(int i3) {
        this.mTagTabType = i3;
    }
}
