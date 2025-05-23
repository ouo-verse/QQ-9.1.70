package com.tenpay.compat;

import com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\n"}, d2 = {"Lcom/tenpay/compat/SoterBiometricStateCallbackCompat;", "Lcom/tencent/soter/wrapper/wrap_biometric/SoterBiometricStateCallback;", "()V", "onAuthenticationError", "", "errCode", "", "errMsg", "", "onAuthenticationErrorCompat", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public abstract class SoterBiometricStateCallbackCompat implements SoterBiometricStateCallback {
    @Override // com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback
    public final void onAuthenticationError(int errCode, @Nullable CharSequence errMsg) {
        if (errCode != 5 && errCode != 10) {
            onAuthenticationErrorCompat(errCode, errMsg);
        } else {
            onAuthenticationCancelled();
        }
    }

    public abstract void onAuthenticationErrorCompat(int errCode, @Nullable CharSequence errMsg);
}
