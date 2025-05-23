package com.tencent.biz.qqcircle.beans;

/* loaded from: classes4.dex */
public class QFSGalleryMainPageBean extends QCircleInitBean {
    private static final String TAG = "QFSGalleryMainPageBean";
    private int mSceneId;
    private String mScheme;
    private int mSourceFrom;
    private int mSourceType;
    private String mTabName;
    private int mTabPos;

    public int getSceneId() {
        return this.mSceneId;
    }

    public String getScheme() {
        return this.mScheme;
    }

    public int getSource() {
        return this.mSourceType;
    }

    public int getSourceFrom() {
        return this.mSourceFrom;
    }

    public String getTabName() {
        return this.mTabName;
    }

    public int getTabPos() {
        return this.mTabPos;
    }

    public void setSceneId(int i3) {
        this.mSceneId = i3;
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setSource(int i3) {
        this.mSourceType = i3;
    }

    public void setSourceFrom(int i3) {
        this.mSourceFrom = i3;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setTabPos(int i3) {
        this.mTabPos = i3;
    }
}
