package com.tencent.biz.qqcircle.beans;

import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalEditViewModel;

/* loaded from: classes4.dex */
public class QCircleEditProfileBean extends QCircleInitBean {
    private String mAvatarUrl;
    private String mBindChannel;
    private String mBindChannelID;
    private int mBindChannelStatus;
    private String mCompany;
    private int mConstellation;
    private String mDesc;
    private int mGender;
    private QFSPersonalEditViewModel.Group mGroup;
    private boolean mHasDecorateRedPoint;
    private String mHostUin;
    private String mLocation;
    private String mLocationCode;
    private String mNick;
    private String mSchool;
    private boolean mShowSchool;
    private byte[] mStProfileBizData;
    private int mUpdateSchoolNum;

    public String getAvatarUrl() {
        return this.mAvatarUrl;
    }

    public String getBindChannel() {
        return this.mBindChannel;
    }

    public String getBindChannelID() {
        return this.mBindChannelID;
    }

    public int getBindChannelStatus() {
        return this.mBindChannelStatus;
    }

    public String getCompany() {
        return this.mCompany;
    }

    public int getConstellation() {
        return this.mConstellation;
    }

    public String getDesc() {
        return this.mDesc;
    }

    public int getGender() {
        return this.mGender;
    }

    public QFSPersonalEditViewModel.Group getGroup() {
        return this.mGroup;
    }

    public String getHostUin() {
        return this.mHostUin;
    }

    public String getLocation() {
        return this.mLocation;
    }

    public String getLocationCode() {
        return this.mLocationCode;
    }

    public String getNick() {
        return this.mNick;
    }

    public String getSchool() {
        return this.mSchool;
    }

    public boolean getShowSchool() {
        return this.mShowSchool;
    }

    public byte[] getStProfileBizData() {
        return this.mStProfileBizData;
    }

    public int getUpdateSchoolNum() {
        return this.mUpdateSchoolNum;
    }

    public boolean hasDecorateRedPoint() {
        return this.mHasDecorateRedPoint;
    }

    public void setAvatarUrl(String str) {
        this.mAvatarUrl = str;
    }

    public void setBindChannel(String str) {
        this.mBindChannel = str;
    }

    public void setBindChannelID(String str) {
        this.mBindChannelID = str;
    }

    public void setBindChannelStatus(int i3) {
        this.mBindChannelStatus = i3;
    }

    public void setCompany(String str) {
        this.mCompany = str;
    }

    public void setConstellation(int i3) {
        this.mConstellation = i3;
    }

    public void setDesc(String str) {
        this.mDesc = str;
    }

    public void setGender(int i3) {
        this.mGender = i3;
    }

    public void setGroup(QFSPersonalEditViewModel.Group group) {
        this.mGroup = group;
    }

    public void setHasDecorateRedPoint(boolean z16) {
        this.mHasDecorateRedPoint = z16;
    }

    public void setHostUin(String str) {
        this.mHostUin = str;
    }

    public void setLocation(String str) {
        this.mLocation = str;
    }

    public void setLocationCode(String str) {
        this.mLocationCode = str;
    }

    public void setNick(String str) {
        this.mNick = str;
    }

    public void setSchool(String str) {
        this.mSchool = str;
    }

    public void setShowSchool(boolean z16) {
        this.mShowSchool = z16;
    }

    public void setStProfileBizData(byte[] bArr) {
        this.mStProfileBizData = bArr;
    }

    public void setUpdateSchoolNum(int i3) {
        this.mUpdateSchoolNum = i3;
    }
}
