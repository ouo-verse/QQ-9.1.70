package com.tencent.soter.wrapper.wrap_fingerprint;

/* compiled from: P */
@Deprecated
/* loaded from: classes25.dex */
public interface SoterFingerprintStateCallback {
    void onAuthenticationCancelled();

    void onAuthenticationError(int i3, CharSequence charSequence);

    void onAuthenticationFailed();

    void onAuthenticationHelp(int i3, CharSequence charSequence);

    void onAuthenticationSucceed();

    void onStartAuthentication();
}
