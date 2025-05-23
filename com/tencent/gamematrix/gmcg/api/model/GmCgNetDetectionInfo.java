package com.tencent.gamematrix.gmcg.api.model;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GmCgNetDetectionInfo {

    /* renamed from: ip, reason: collision with root package name */
    public String f107682ip;
    public float lostRate;
    private float mDetectionSpeedRate;
    private String mRealIpAddress;
    public float rtt;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class Builder {
        private float bDetectionAgvDelay;
        private float bDetectionAgvLoss;
        private float bDetectionSpeedRate;
        private String bIpAddress;
        private String bRealIpAddress;

        public GmCgNetDetectionInfo build() {
            return new GmCgNetDetectionInfo(this);
        }

        public Builder setAgvDelay(float f16) {
            this.bDetectionAgvDelay = f16;
            return this;
        }

        public Builder setAgvLoss(float f16) {
            this.bDetectionAgvLoss = f16;
            return this;
        }

        public Builder setIpAddress(String str) {
            this.bIpAddress = str;
            return this;
        }

        public Builder setRealIpAddress(String str) {
            this.bRealIpAddress = str;
            return this;
        }

        public Builder setSpeedRate(float f16) {
            this.bDetectionSpeedRate = f16;
            return this;
        }
    }

    public float getDetectionAgvDelay() {
        return this.rtt;
    }

    public float getDetectionAgvLoss() {
        return this.lostRate;
    }

    public float getDetectionSpeedRate() {
        return this.mDetectionSpeedRate;
    }

    public String getIpAddress() {
        return this.f107682ip;
    }

    public String getRealIpAddress() {
        return this.mRealIpAddress;
    }

    public String toString() {
        return "GmCgNetDetectionInfo{ip=" + this.f107682ip + "', realIpAddress=" + this.mRealIpAddress + "', speedRate='" + this.mDetectionSpeedRate + "', detectionAgvDelay=" + this.rtt + "', detectionAgvLoss=" + this.lostRate + '}';
    }

    GmCgNetDetectionInfo(Builder builder) {
        this.f107682ip = builder.bIpAddress;
        this.mRealIpAddress = builder.bRealIpAddress;
        this.lostRate = builder.bDetectionAgvLoss;
        this.rtt = builder.bDetectionAgvDelay;
        this.mDetectionSpeedRate = builder.bDetectionSpeedRate;
    }
}
