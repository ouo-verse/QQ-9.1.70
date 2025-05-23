package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IloginAdapter {
    void addWTLoginRecordFromNT(WTLoginRecord wTLoginRecord);

    void deleteWTLoginRecord(long j3, int i3);

    void getWTLoginRecord(long j3, int i3, IGetLoginRecordFromWTCallback iGetLoginRecordFromWTCallback);
}
