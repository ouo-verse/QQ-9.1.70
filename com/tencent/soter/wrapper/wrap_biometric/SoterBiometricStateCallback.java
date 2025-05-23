package com.tencent.soter.wrapper.wrap_biometric;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface SoterBiometricStateCallback {
    void onAuthenticationCancelled();

    void onAuthenticationError(int i3, CharSequence charSequence);

    void onAuthenticationFailed();

    void onAuthenticationHelp(int i3, CharSequence charSequence);

    void onAuthenticationSucceed();

    void onStartAuthentication();
}
