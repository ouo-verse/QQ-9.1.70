package com.tencent.biz.qqcircle.beans;

import cooperation.qqcircle.report.QCircleReportBean;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleFolderBean extends QCircleInitBean {
    HashMap<String, String> attrs;
    private boolean isPublish;
    private boolean mForceFromPushPreloadCache;
    private String mForcedInsertedFeedId;
    private String mFrom;
    private boolean mHasRedDot;
    private String mLastPageScheme;
    private int mQQCircleUnreadRedNum;
    private byte[] mRedDotTransInfo;
    private QCircleReportBean mReportDataBean;
    private byte[] mSchemeJumpInfo;
    private int mTabType = -1;
    private int mSubTabType = -1;
    private float mBottomMargin = 0.0f;
    private boolean mIsFromPublish = false;
    private boolean mIsTeenModeLimit = false;
    private boolean mOpenSharePanel = false;
    private boolean mIsTabFullScreenMode = false;

    public QCircleFolderBean() {
    }

    public int getAssignShowSubTabType() {
        return this.mSubTabType;
    }

    public int getAssignShowTabType() {
        return this.mTabType;
    }

    public HashMap<String, String> getAttrs() {
        return this.attrs;
    }

    public float getBottomMarginPx() {
        return this.mBottomMargin;
    }

    public String getForcedInsertedFeedId() {
        return this.mForcedInsertedFeedId;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public boolean getIsFromPublish() {
        return this.mIsFromPublish;
    }

    public String getLastPageScheme() {
        return this.mLastPageScheme;
    }

    public boolean getOpenSharePanel() {
        return this.mOpenSharePanel;
    }

    public int getQQCircleUnreadRedNum() {
        return this.mQQCircleUnreadRedNum;
    }

    public byte[] getRedDotTransInfo() {
        return this.mRedDotTransInfo;
    }

    public byte[] getSchemeJumpInfo() {
        return this.mSchemeJumpInfo;
    }

    public boolean hasRedDotShownOnEntrance() {
        return this.mHasRedDot;
    }

    public boolean isForceFromPushPreloadCache() {
        return this.mForceFromPushPreloadCache;
    }

    public boolean isPublish() {
        return this.isPublish;
    }

    public boolean isTabFullScreenMode() {
        return this.mIsTabFullScreenMode;
    }

    public boolean isTeenModeLimit() {
        return this.mIsTeenModeLimit;
    }

    public void setAssignShowSubTabType(int i3) {
        this.mSubTabType = i3;
    }

    public void setAssignShowTabType(int i3) {
        this.mTabType = i3;
    }

    public void setAttrs(HashMap<String, String> hashMap) {
        this.attrs = hashMap;
        this.mSchemeAttrs = hashMap;
    }

    public void setBottomMargin(float f16) {
        this.mBottomMargin = f16;
    }

    public void setForceFromPushPreloadCache(boolean z16) {
        this.mForceFromPushPreloadCache = z16;
    }

    public void setForcedInsertedFeedId(String str) {
        this.mForcedInsertedFeedId = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setHasRedDot(boolean z16) {
        this.mHasRedDot = z16;
    }

    public void setIsFromPublish(boolean z16) {
        this.mIsFromPublish = z16;
    }

    public void setIsTeenModeLimit(boolean z16) {
        this.mIsTeenModeLimit = z16;
    }

    public void setLastPageScheme(String str) {
        this.mLastPageScheme = str;
    }

    public void setOpenSharePanel(boolean z16) {
        this.mOpenSharePanel = z16;
    }

    public void setPublish(boolean z16) {
        this.isPublish = z16;
    }

    public void setRedDotTransInfo(byte[] bArr) {
        this.mRedDotTransInfo = bArr;
    }

    public QCircleFolderBean setSchemeJumpInfo(byte[] bArr) {
        this.mSchemeJumpInfo = bArr;
        return this;
    }

    public void setTabFullScreenMode(boolean z16) {
        this.mIsTabFullScreenMode = z16;
    }

    public void setUnreadRedNum(int i3) {
        this.mQQCircleUnreadRedNum = i3;
    }

    public QCircleFolderBean(QCircleReportBean qCircleReportBean) {
        this.mReportDataBean = qCircleReportBean;
    }
}
