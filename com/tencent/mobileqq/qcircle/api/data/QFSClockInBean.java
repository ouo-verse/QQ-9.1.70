package com.tencent.mobileqq.qcircle.api.data;

import com.tencent.mobileqq.pb.ByteStringMicro;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QFSClockInBean {
    public static final String KEY_CLOCK_BACK_PLATE_FINISHED = "clock_backplate_finished";
    public static final String KEY_CLOCK_BACK_PLATE_NUMBER = "clock_backplate_number";
    public static final String KEY_CLOCK_BACK_PLATE_NUMBER_TEXT = "clock_backplate_number_text";
    public static final String KEY_CLOCK_BACK_PLATE_SIGNED = "clock_backplate_signed";
    public static final String KEY_CLOCK_FINISHED_REFRESHING_RESOURCE = "clock_finished_refreshing_resourse_android";
    public static final String KEY_CLOCK_LOCKED_IMG = "clock_locked_img";
    public static final String KEY_CLOCK_LOCKED_TEXT = "clock_locked_text";
    public static final String KEY_CLOCK_LOCKED_TO_FINISHED_RESOURCE = "clock_locked_to_finished_resourse_android";
    public static final String KEY_CLOCK_LOCKED_TO_SIGNED_RESOURCE = "clock_locked_to_signed_resourse_android";
    public static final String KEY_CLOCK_NUMBER_TEXT = "clock_number_text";
    public static final String KEY_CLOCK_SIGNED_REFRESHING_RESOURCE = "clock_signed_refreshing_resourse_android";
    public static final String KEY_CLOCK_SIGNED_TEXT = "clock_signed_text";
    public static final String KEY_CLOCK_SLIDE_TEXT = "clock_slide_text";
    public static final String KEY_CLOCK_UNLOCKED_IMG = "clock_unlocked_img";
    private String mBackPlateFinishedUrl;
    private String mBackPlateNumberUrl;
    private String mBackPlateSignedUrl;
    private String mClockedText;
    private String mCollapseClockText;
    private int mDayCount;
    private int mDuration;
    private String mExpandClockText;
    private String mFinishedRefreshUrl;
    private boolean mIsLastDay;
    private String mJumpUrl;
    private String mLockedImgUrl;
    private String mLockedToFinishedUrl;
    private String mLockedToSignedUrl;
    private String mSignedRefreshingUrl;
    private String mSignedText;
    private String mSlideText;
    private int mStatus;
    private ByteStringMicro mTransInfo;
    private String mUnLockedImgUrl;

    public String getBackPlateFinishedUrl() {
        return this.mBackPlateFinishedUrl;
    }

    public String getBackPlateNumberUrl() {
        return this.mBackPlateNumberUrl;
    }

    public String getBackPlateSignedUrl() {
        return this.mBackPlateSignedUrl;
    }

    public String getClockedText() {
        return this.mClockedText;
    }

    public String getCollapseClockText() {
        return this.mCollapseClockText;
    }

    public int getDayCount() {
        return this.mDayCount;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public String getExpandClockText() {
        return this.mExpandClockText;
    }

    public String getFinishedRefreshUrl() {
        return this.mFinishedRefreshUrl;
    }

    public String getJumpUrl() {
        return this.mJumpUrl;
    }

    public String getLockedImgUrl() {
        return this.mLockedImgUrl;
    }

    public String getLockedToFinishedUrl() {
        return this.mLockedToFinishedUrl;
    }

    public String getLockedToSignedUrl() {
        return this.mLockedToSignedUrl;
    }

    public String getSignedRefreshingUrl() {
        return this.mSignedRefreshingUrl;
    }

    public String getSignedText() {
        return this.mSignedText;
    }

    public String getSlideText() {
        return this.mSlideText;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public ByteStringMicro getTransInfo() {
        return this.mTransInfo;
    }

    public String getUnLockedImgUrl() {
        return this.mUnLockedImgUrl;
    }

    public boolean isLastDay() {
        return this.mIsLastDay;
    }

    public void setBackPlateFinishedUrl(String str) {
        this.mBackPlateFinishedUrl = str;
    }

    public void setBackPlateNumberUrl(String str) {
        this.mBackPlateNumberUrl = str;
    }

    public void setBackPlateSignedUrl(String str) {
        this.mBackPlateSignedUrl = str;
    }

    public void setClockedText(String str) {
        this.mClockedText = str;
    }

    public void setCollapseClockText(String str) {
        this.mCollapseClockText = str;
    }

    public void setDayCount(int i3) {
        this.mDayCount = i3;
    }

    public void setDuration(int i3) {
        this.mDuration = i3;
    }

    public void setExpandClockText(String str) {
        this.mExpandClockText = str;
    }

    public void setFinishedRefreshUrl(String str) {
        this.mFinishedRefreshUrl = str;
    }

    public void setJumpUrl(String str) {
        this.mJumpUrl = str;
    }

    public void setLastDay(boolean z16) {
        this.mIsLastDay = z16;
    }

    public void setLockedImgUrl(String str) {
        this.mLockedImgUrl = str;
    }

    public void setLockedToFinishedUrl(String str) {
        this.mLockedToFinishedUrl = str;
    }

    public void setLockedToSignedUrl(String str) {
        this.mLockedToSignedUrl = str;
    }

    public void setSignedRefreshingUrl(String str) {
        this.mSignedRefreshingUrl = str;
    }

    public void setSignedText(String str) {
        this.mSignedText = str;
    }

    public void setSlideText(String str) {
        this.mSlideText = str;
    }

    public void setStatus(int i3) {
        this.mStatus = i3;
    }

    public void setTransInfo(ByteStringMicro byteStringMicro) {
        this.mTransInfo = byteStringMicro;
    }

    public void setUnLockedImgUrl(String str) {
        this.mUnLockedImgUrl = str;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public QFSClockInBean m215clone() {
        QFSClockInBean qFSClockInBean = new QFSClockInBean();
        qFSClockInBean.setDayCount(this.mDayCount);
        qFSClockInBean.setStatus(this.mStatus);
        qFSClockInBean.setDuration(this.mDuration);
        qFSClockInBean.setLastDay(this.mIsLastDay);
        qFSClockInBean.setJumpUrl(this.mJumpUrl);
        qFSClockInBean.setTransInfo(this.mTransInfo);
        qFSClockInBean.setLockedImgUrl(this.mLockedImgUrl);
        qFSClockInBean.setUnLockedImgUrl(this.mUnLockedImgUrl);
        qFSClockInBean.setBackPlateFinishedUrl(this.mBackPlateFinishedUrl);
        qFSClockInBean.setBackPlateSignedUrl(this.mBackPlateSignedUrl);
        qFSClockInBean.setBackPlateNumberUrl(this.mBackPlateNumberUrl);
        qFSClockInBean.setLockedToSignedUrl(this.mLockedToSignedUrl);
        qFSClockInBean.setLockedToFinishedUrl(this.mLockedToFinishedUrl);
        qFSClockInBean.setFinishedRefreshUrl(this.mFinishedRefreshUrl);
        qFSClockInBean.setSignedRefreshingUrl(this.mSignedRefreshingUrl);
        qFSClockInBean.setSignedText(this.mSignedText);
        qFSClockInBean.setClockedText(this.mClockedText);
        qFSClockInBean.setExpandClockText(this.mExpandClockText);
        qFSClockInBean.setCollapseClockText(this.mCollapseClockText);
        return qFSClockInBean;
    }
}
