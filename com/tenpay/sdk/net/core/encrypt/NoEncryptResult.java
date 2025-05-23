package com.tenpay.sdk.net.core.encrypt;

import com.tenpay.sdk.net.core.encrypt.EncryptResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0006J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000fH\u0016R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tenpay/sdk/net/core/encrypt/NoEncryptResult;", "Lcom/tenpay/sdk/net/core/encrypt/EncryptResult;", "paramMap", "", "", "paramString", "(Ljava/util/Map;Ljava/lang/String;)V", "getParamMap", "()Ljava/util/Map;", "getParamString", "()Ljava/lang/String;", "getEncryptText", "getStatistic", "Lcom/tenpay/sdk/net/core/encrypt/EncryptResult$EncryptStatisticInfo;", "toParamMap", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class NoEncryptResult implements EncryptResult {

    @NotNull
    private final Map<String, String> paramMap;

    @Nullable
    private final String paramString;

    public NoEncryptResult(@NotNull Map<String, String> paramMap, @Nullable String str) {
        Intrinsics.checkNotNullParameter(paramMap, "paramMap");
        this.paramMap = paramMap;
        this.paramString = str;
    }

    @Override // com.tenpay.sdk.net.core.encrypt.EncryptResult
    @Nullable
    /* renamed from: getEncryptText, reason: from getter */
    public String getParamString() {
        return this.paramString;
    }

    @NotNull
    public final Map<String, String> getParamMap() {
        return this.paramMap;
    }

    @Nullable
    public final String getParamString() {
        return this.paramString;
    }

    @Override // com.tenpay.sdk.net.core.encrypt.EncryptResult
    @NotNull
    public EncryptResult.EncryptStatisticInfo getStatistic() {
        return new EncryptResult.EncryptStatisticInfo("TYPE_PLAINTEXT", 0L, 0L, 6, null);
    }

    @Override // com.tenpay.sdk.net.core.encrypt.EncryptResult
    @NotNull
    public Map<String, String> toParamMap() {
        return this.paramMap;
    }
}
