package com.tenpay.sdk.net.core.encrypt;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\bJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tenpay/sdk/net/core/encrypt/EncryptResult;", "", "getEncryptText", "", "getStatistic", "Lcom/tenpay/sdk/net/core/encrypt/EncryptResult$EncryptStatisticInfo;", "toParamMap", "", "EncryptStatisticInfo", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public interface EncryptResult {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tenpay/sdk/net/core/encrypt/EncryptResult$EncryptStatisticInfo;", "", "encryptAlgorithm", "", "dhCostTime", "", "encryptTime", "(Ljava/lang/String;JJ)V", "getDhCostTime", "()J", "setDhCostTime", "(J)V", "getEncryptAlgorithm", "()Ljava/lang/String;", "setEncryptAlgorithm", "(Ljava/lang/String;)V", "getEncryptTime", "setEncryptTime", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class EncryptStatisticInfo {
        private long dhCostTime;

        @NotNull
        private String encryptAlgorithm;
        private long encryptTime;

        public EncryptStatisticInfo() {
            this(null, 0L, 0L, 7, null);
        }

        public final long getDhCostTime() {
            return this.dhCostTime;
        }

        @NotNull
        public final String getEncryptAlgorithm() {
            return this.encryptAlgorithm;
        }

        public final long getEncryptTime() {
            return this.encryptTime;
        }

        public final void setDhCostTime(long j3) {
            this.dhCostTime = j3;
        }

        public final void setEncryptAlgorithm(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encryptAlgorithm = str;
        }

        public final void setEncryptTime(long j3) {
            this.encryptTime = j3;
        }

        public EncryptStatisticInfo(@NotNull String encryptAlgorithm, long j3, long j16) {
            Intrinsics.checkNotNullParameter(encryptAlgorithm, "encryptAlgorithm");
            this.encryptAlgorithm = encryptAlgorithm;
            this.dhCostTime = j3;
            this.encryptTime = j16;
        }

        public /* synthetic */ EncryptStatisticInfo(String str, long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? 0L : j16);
        }
    }

    @Nullable
    String getEncryptText();

    @NotNull
    EncryptStatisticInfo getStatistic();

    @NotNull
    Map<String, String> toParamMap();
}
