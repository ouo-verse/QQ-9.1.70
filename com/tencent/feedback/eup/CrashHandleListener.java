package com.tencent.feedback.eup;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface CrashHandleListener {
    byte[] getCrashExtraData(boolean z16, String str, String str2, String str3, int i3, long j3);

    String getCrashExtraMessage(boolean z16, String str, String str2, String str3, int i3, long j3);

    boolean onCrashHandleEnd(boolean z16);

    void onCrashHandleStart(boolean z16);

    boolean onCrashSaving(boolean z16, String str, String str2, String str3, String str4, int i3, long j3, String str5, String str6, String str7, String str8);
}
