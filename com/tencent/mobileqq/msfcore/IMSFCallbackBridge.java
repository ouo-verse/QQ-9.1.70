package com.tencent.mobileqq.msfcore;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IMSFCallbackBridge {
    void onMSFApnState(int i3);

    void onMSFBadNetworkState(boolean z16, int i3);

    void onMSFError(int i3, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4);

    void onMSFNetworkState(int i3, int i16);

    void onMSFPacketState(@NonNull MSFResponseAdapter mSFResponseAdapter);

    void onMSFServerTimeUpdated(int i3);

    void onSSORetError(int i3, @NonNull String str, @NonNull String str2, @NonNull String str3);
}
