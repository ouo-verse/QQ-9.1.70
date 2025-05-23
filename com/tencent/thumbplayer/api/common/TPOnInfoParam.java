package com.tencent.thumbplayer.api.common;

import androidx.annotation.Nullable;

/* loaded from: classes26.dex */
public class TPOnInfoParam {
    private float mFloatParam1;
    private float mFloatParam2;
    private long mLongParam1;
    private long mLongParam2;
    private Object mObjParam;
    private String mStrParam1;
    private String mStrParam2;

    /* loaded from: classes26.dex */
    public static class Builder {
        private float mFloatParam1;
        private float mFloatParam2;
        private long mLongParam1;
        private long mLongParam2;
        private Object mObjParam;
        private String mStrParam1;
        private String mStrParam2;

        public Builder() {
            this.mLongParam1 = 0L;
            this.mLongParam2 = 0L;
            this.mFloatParam1 = 0.0f;
            this.mFloatParam2 = 0.0f;
            this.mStrParam1 = null;
            this.mStrParam2 = null;
            this.mObjParam = null;
        }

        public TPOnInfoParam build() {
            TPOnInfoParam tPOnInfoParam = new TPOnInfoParam();
            tPOnInfoParam.mLongParam1 = this.mLongParam1;
            tPOnInfoParam.mLongParam2 = this.mLongParam2;
            tPOnInfoParam.mFloatParam1 = this.mFloatParam1;
            tPOnInfoParam.mFloatParam2 = this.mFloatParam2;
            tPOnInfoParam.mStrParam1 = this.mStrParam1;
            tPOnInfoParam.mStrParam2 = this.mStrParam2;
            tPOnInfoParam.mObjParam = this.mObjParam;
            return tPOnInfoParam;
        }

        public Builder setFloatParam(float f16) {
            this.mFloatParam1 = f16;
            return this;
        }

        public Builder setLongParam(long j3) {
            this.mLongParam1 = j3;
            return this;
        }

        public Builder setObjParam(Object obj) {
            this.mObjParam = obj;
            return this;
        }

        public Builder setStrParam(String str) {
            this.mStrParam1 = str;
            return this;
        }

        public Builder setFloatParam(float f16, float f17) {
            this.mFloatParam1 = f16;
            this.mFloatParam2 = f17;
            return this;
        }

        public Builder setLongParam(long j3, long j16) {
            this.mLongParam1 = j3;
            this.mLongParam2 = j16;
            return this;
        }

        public Builder setStrParam(String str, String str2) {
            this.mStrParam1 = str;
            this.mStrParam2 = str2;
            return this;
        }

        public Builder(TPOnInfoParam tPOnInfoParam) {
            this.mLongParam1 = 0L;
            this.mLongParam2 = 0L;
            this.mFloatParam1 = 0.0f;
            this.mFloatParam2 = 0.0f;
            this.mStrParam1 = null;
            this.mStrParam2 = null;
            this.mObjParam = null;
            this.mLongParam1 = tPOnInfoParam.getLongParam1();
            this.mLongParam2 = tPOnInfoParam.getLongParam2();
            this.mFloatParam1 = tPOnInfoParam.getFloatParam1();
            this.mFloatParam2 = tPOnInfoParam.getFloatParam2();
            this.mStrParam1 = tPOnInfoParam.getStrParam1();
            this.mStrParam2 = tPOnInfoParam.getStrParam2();
            this.mObjParam = tPOnInfoParam.getObjParam();
        }
    }

    public float getFloatParam1() {
        return this.mFloatParam1;
    }

    public float getFloatParam2() {
        return this.mFloatParam2;
    }

    public long getLongParam1() {
        return this.mLongParam1;
    }

    public long getLongParam2() {
        return this.mLongParam2;
    }

    @Nullable
    public Object getObjParam() {
        return this.mObjParam;
    }

    @Nullable
    public String getStrParam1() {
        return this.mStrParam1;
    }

    @Nullable
    public String getStrParam2() {
        return this.mStrParam2;
    }

    TPOnInfoParam() {
        this.mLongParam1 = 0L;
        this.mLongParam2 = 0L;
        this.mFloatParam1 = 0.0f;
        this.mFloatParam2 = 0.0f;
        this.mStrParam1 = null;
        this.mStrParam2 = null;
        this.mObjParam = null;
    }
}
