package com.tencent.gamematrix.gmcg.api;

import androidx.annotation.MainThread;

/* loaded from: classes6.dex */
public interface GmCgPlayPushEventListener {
    @MainThread
    void onGmCgGameTimeInfo(int i3, String str, int i16);

    @MainThread
    void onGmCgPlayPushEventGameRechargeGiveTime(String str, int i3, int i16, String str2);

    @MainThread
    void onGmCgPlayPushEventMcGameRechargeGiveTime(String str, int i3, int i16, String str2, String str3);

    @MainThread
    void onGmCgPlayPushEventTimeNotEnough(long j3, boolean z16);

    @MainThread
    void onGmCgPlayPushEventTimeNotEnoughV2(long j3, long j16, boolean z16, @GmCgTimeNotEnoughHintType int i3);

    @MainThread
    void onGmCgPlayPushEventTimeUpdate(long j3);

    @MainThread
    void onGmCgPlayPushEventUnknown(String str);
}
