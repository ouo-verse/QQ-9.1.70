package com.tenpay.fingerpay.soter;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tenpay/fingerpay/soter/SoterManagerCallback;", "", "onAuthenticationCancelled", "", "onAuthenticationErrorCompat", "errorCode", "", "errorString", "", "onAuthenticationFailed", "onAuthenticationSucceed", "onSoterFingerLocked", "onSoterProcessFailed", "onSoterProcessRetry", "onSoterProcessSucceed", "onStartAuthentication", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public interface SoterManagerCallback {
    void onAuthenticationCancelled();

    void onAuthenticationErrorCompat(int errorCode, @Nullable CharSequence errorString);

    void onAuthenticationFailed();

    void onAuthenticationSucceed();

    void onSoterFingerLocked();

    void onSoterProcessFailed();

    void onSoterProcessRetry();

    void onSoterProcessSucceed();

    void onStartAuthentication();
}
