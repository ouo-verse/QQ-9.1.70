package com.tenpay.sdk.net.core.encrypt;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J4\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J(\u0010\u0012\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/tenpay/sdk/net/core/encrypt/BizEncryptController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "decrypt", "Lcom/tenpay/sdk/net/core/encrypt/DecryptResult;", "uin", "", "keyIndex", "", "data", "isEcdhEncrypt", "", "encryptResult", "Lcom/tenpay/sdk/net/core/encrypt/EncryptResult;", "encrypt", "encryptParams", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BizEncryptController {

    @NotNull
    public static final String TAG = "QWalletHttp-BizEncrypt";

    @NotNull
    private final Context context;

    public BizEncryptController(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Nullable
    public final DecryptResult decrypt(@Nullable String uin, int keyIndex, @NotNull String data, boolean isEcdhEncrypt, @Nullable EncryptResult encryptResult) {
        EcdhEncryptResult ecdhEncryptResult;
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        if (isEcdhEncrypt) {
            String str2 = null;
            if (encryptResult instanceof EcdhEncryptResult) {
                ecdhEncryptResult = (EcdhEncryptResult) encryptResult;
            } else {
                ecdhEncryptResult = null;
            }
            PayEncryptUtils payEncryptUtils = PayEncryptUtils.INSTANCE;
            Context context = this.context;
            if (ecdhEncryptResult != null) {
                str = ecdhEncryptResult.getSecretKey();
            } else {
                str = null;
            }
            if (ecdhEncryptResult != null) {
                str2 = ecdhEncryptResult.getPublicKey();
            }
            return payEncryptUtils.ecdhDecrypt(context, data, str, str2, uin);
        }
        return PayEncryptUtils.INSTANCE.desDecrypt(this.context, data, keyIndex);
    }

    @NotNull
    public final EncryptResult encrypt(@Nullable String uin, int keyIndex, @NotNull String encryptParams, boolean isEcdhEncrypt) {
        Intrinsics.checkNotNullParameter(encryptParams, "encryptParams");
        if (isEcdhEncrypt) {
            return PayEncryptUtils.INSTANCE.ecdhEncrypt(this.context, encryptParams, uin);
        }
        return PayEncryptUtils.INSTANCE.desEncrypt(this.context, encryptParams, uin, keyIndex);
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }
}
