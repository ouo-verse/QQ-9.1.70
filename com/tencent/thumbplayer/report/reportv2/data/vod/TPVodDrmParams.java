package com.tencent.thumbplayer.report.reportv2.data.vod;

import com.tencent.thumbplayer.report.reportv2.data.TPCommonParams;

/* loaded from: classes26.dex */
public class TPVodDrmParams extends TPCommonParams {

    @TPCommonParams.TPReportParam(key = "certificateetimems")
    private long mCertificateETimeMs;

    @TPCommonParams.TPReportParam(key = "certificatestimems")
    private long mCertificateSTimeMs;

    @TPCommonParams.TPReportParam(key = "getkeyreqetimems")
    private long mGetKeyReqETimeMs;

    @TPCommonParams.TPReportParam(key = "getkeyreqstimems")
    private long mGetKeyReqSTimeMs;

    @TPCommonParams.TPReportParam(key = "getprovisionreqetimems")
    private long mGetProvisionReqETimeMs;

    @TPCommonParams.TPReportParam(key = "getprovisionreqstimems")
    private long mGetProvisionReqSTimeMs;

    @TPCommonParams.TPReportParam(key = "licenseetimems")
    private long mLicenseETimeMs;

    @TPCommonParams.TPReportParam(key = "licensestimems")
    private long mLicenseSTimeMs;

    @TPCommonParams.TPReportParam(key = "opensessionetimems")
    private long mOpenSessionETimeMs;

    @TPCommonParams.TPReportParam(key = "opensessionstimems")
    private long mOpenSessionSTimeMs;

    @TPCommonParams.TPReportParam(key = "providekeyrespetimems")
    private long mProvideKeyRespETimeMs;

    @TPCommonParams.TPReportParam(key = "providekeyrespstimems")
    private long mProvideKeyRespSTimeMs;

    @TPCommonParams.TPReportParam(key = "provideprovisionrespetimems")
    private long mProvideProvisionRespETimeMs;

    @TPCommonParams.TPReportParam(key = "provideprovisionrespstimems")
    private long mProvideProvisionRespSTimeMs;

    @TPCommonParams.TPReportParam(key = "recvkeyresptimems")
    private long mRecvKeyRespTimeMs;

    @TPCommonParams.TPReportParam(key = "recvprovisionresptimems")
    private long mRecvProvisionRespTimeMs;

    @TPCommonParams.TPReportParam(key = "sendkeyreqtimems")
    private long mSendKeyReqTimeMs;

    @TPCommonParams.TPReportParam(key = "sendprovisionreqtimems")
    private long mSendProvisionReqTimeMs;

    @TPCommonParams.TPReportParam(key = "drmtype")
    private int mDrmType = -1;

    @TPCommonParams.TPReportParam(key = "securelevel")
    private int mSecureLevel = -1;

    @TPCommonParams.TPReportParam(key = "preparestimems")
    private long mPrepareSTimeMs = 0;

    @TPCommonParams.TPReportParam(key = "prepareetimems")
    private long mPrepareETimeMs = 0;

    @TPCommonParams.TPReportParam(key = "supportsecuredecoder")
    private int mSupportSecureDecoder = -1;

    @TPCommonParams.TPReportParam(key = "supportsecuredecrypt")
    private int mSupportSecureDecrypt = -1;

    @TPCommonParams.TPReportParam(key = "componentname")
    private String mComponentName = "";

    public long getCertificateETimeMs() {
        return this.mCertificateETimeMs;
    }

    public long getCertificateSTimeMs() {
        return this.mCertificateSTimeMs;
    }

    public String getComponentName() {
        return this.mComponentName;
    }

    public int getDrmType() {
        return this.mDrmType;
    }

    public long getGetKeyReqETimeMs() {
        return this.mGetKeyReqETimeMs;
    }

    public long getGetKeyReqSTimeMs() {
        return this.mGetKeyReqSTimeMs;
    }

    public long getGetProvisionReqETimeMs() {
        return this.mGetProvisionReqETimeMs;
    }

    public long getGetProvisionReqSTimeMs() {
        return this.mGetProvisionReqSTimeMs;
    }

    public long getLicenseETimeMs() {
        return this.mLicenseETimeMs;
    }

    public long getLicenseSTimeMs() {
        return this.mLicenseSTimeMs;
    }

    public long getOpenSessionETimeMs() {
        return this.mOpenSessionETimeMs;
    }

    public long getOpenSessionSTimeMs() {
        return this.mOpenSessionSTimeMs;
    }

    public long getPrepareETimeMs() {
        return this.mPrepareETimeMs;
    }

    public long getPrepareSTimeMs() {
        return this.mPrepareSTimeMs;
    }

    public long getProvideKeyRespETimeMs() {
        return this.mProvideKeyRespETimeMs;
    }

    public long getProvideKeyRespSTimeMs() {
        return this.mProvideKeyRespSTimeMs;
    }

    public long getProvideProvisionRespETimeMs() {
        return this.mProvideProvisionRespETimeMs;
    }

    public long getProvideProvisionRespSTimeMs() {
        return this.mProvideProvisionRespSTimeMs;
    }

    public long getRecvKeyRespTimeMs() {
        return this.mRecvKeyRespTimeMs;
    }

    public long getRecvProvisionRespTimeMs() {
        return this.mRecvProvisionRespTimeMs;
    }

    public int getSecureLevel() {
        return this.mSecureLevel;
    }

    public long getSendKeyReqTimeMs() {
        return this.mSendKeyReqTimeMs;
    }

    public long getSendProvisionReqTimeMs() {
        return this.mSendProvisionReqTimeMs;
    }

    public int getSupportSecureDecoder() {
        return this.mSupportSecureDecoder;
    }

    public int getSupportSecureDecrypt() {
        return this.mSupportSecureDecrypt;
    }

    public void setCertificateETimeMs(long j3) {
        this.mCertificateETimeMs = j3;
    }

    public void setCertificateSTimeMs(long j3) {
        this.mCertificateSTimeMs = j3;
    }

    public void setComponentName(String str) {
        this.mComponentName = str;
    }

    public void setDrmType(int i3) {
        this.mDrmType = i3;
    }

    public void setGetKeyReqETimeMs(long j3) {
        this.mGetKeyReqETimeMs = j3;
    }

    public void setGetKeyReqSTimeMs(long j3) {
        this.mGetKeyReqSTimeMs = j3;
    }

    public void setGetProvisionReqETimeMs(long j3) {
        this.mGetProvisionReqETimeMs = j3;
    }

    public void setGetProvisionReqSTimeMs(long j3) {
        this.mGetProvisionReqSTimeMs = j3;
    }

    public void setLicenseETimeMs(long j3) {
        this.mLicenseETimeMs = j3;
    }

    public void setLicenseSTimeMs(long j3) {
        this.mLicenseSTimeMs = j3;
    }

    public void setOpenSessionETimeMs(long j3) {
        this.mOpenSessionETimeMs = j3;
    }

    public void setOpenSessionSTimeMs(long j3) {
        this.mOpenSessionSTimeMs = j3;
    }

    public void setPrepareETimeMs(long j3) {
        this.mPrepareETimeMs = j3;
    }

    public void setPrepareSTimeMs(long j3) {
        this.mPrepareSTimeMs = j3;
    }

    public void setProvideKeyRespETimeMs(long j3) {
        this.mProvideKeyRespETimeMs = j3;
    }

    public void setProvideKeyRespSTimeMs(long j3) {
        this.mProvideKeyRespSTimeMs = j3;
    }

    public void setProvideProvisionRespETimeMs(long j3) {
        this.mProvideProvisionRespETimeMs = j3;
    }

    public void setProvideProvisionRespSTimeMs(long j3) {
        this.mProvideProvisionRespSTimeMs = j3;
    }

    public void setRecvKeyRespTimeMs(long j3) {
        this.mRecvKeyRespTimeMs = j3;
    }

    public void setRecvProvisionRespTimeMs(long j3) {
        this.mRecvProvisionRespTimeMs = j3;
    }

    public void setSecureLevel(int i3) {
        this.mSecureLevel = i3;
    }

    public void setSendKeyReqTimeMs(long j3) {
        this.mSendKeyReqTimeMs = j3;
    }

    public void setSendProvisionReqTimeMs(long j3) {
        this.mSendProvisionReqTimeMs = j3;
    }

    public void setSupportSecureDecoder(int i3) {
        this.mSupportSecureDecoder = i3;
    }

    public void setSupportSecureDecrypt(int i3) {
        this.mSupportSecureDecrypt = i3;
    }
}
