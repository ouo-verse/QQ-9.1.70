package com.tencent.gamematrix;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CgConfig {
    static final int BBR = 2;
    static final int BBRv2 = 5;
    static final int CubicBytes = 0;
    static final int GoogCC = 4;
    static final int PCC = 3;
    static final int RenoBytes = 1;
    public String mFilePath;
    public int mLogLevel;
    public int mSessionMaxRecvWindowSize = 15728640;
    public int mStreamMaxRecvWindowSize = 6291456;
    public int mCongestionType = 0;
    public int mConnectTimeoutMillis = 2000;
    public int mIdleTimeoutMillis = 10000;
    public int mQuicVersion = 50;
    public int mPingIntervalMillis = 2500;
    public byte mFecDataShards = 5;
    public byte mFecParityShards = 3;

    public int getCongestionType() {
        return this.mCongestionType;
    }

    public int getConnectTimeoutMillis() {
        return this.mConnectTimeoutMillis;
    }

    public byte getFecDataShards() {
        return this.mFecDataShards;
    }

    public byte getFecParityShards() {
        return this.mFecParityShards;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public int getIdleTimeoutMillis() {
        return this.mIdleTimeoutMillis;
    }

    public int getLoglevel() {
        return this.mLogLevel;
    }

    public int getPingIntervalMillis() {
        return this.mPingIntervalMillis;
    }

    public int getQuicVersion() {
        return this.mQuicVersion;
    }

    public int getSessionMaxRecvWindowSize() {
        return this.mSessionMaxRecvWindowSize;
    }

    public int getStreamMaxRecvWindowSize() {
        return this.mStreamMaxRecvWindowSize;
    }
}
