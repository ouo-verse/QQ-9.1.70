package com.tencent.ecommerce.base.account.api;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\u0014\u0015J=\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fH&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/base/account/api/IECFaceVerification;", "", "", "psKey", "uin", "idNum", "name", "", "nonce", "Lcom/tencent/ecommerce/base/account/api/IECFaceVerification$b;", "requestForFaceVerificationConfig", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "identificationConfig", "Lcom/tencent/ecommerce/base/account/api/IECFaceVerification$a;", "startFaceVerification", "(Landroid/content/Context;Lcom/tencent/ecommerce/base/account/api/IECFaceVerification$b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "onRelease", "a", "b", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECFaceVerification {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/base/account/api/IECFaceVerification$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "idKey", "appId", "c", "openId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.account.api.IECFaceVerification$a, reason: from toString */
    /* loaded from: classes5.dex */
    public static final /* data */ class FaceVerificationResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String idKey;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String appId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String openId;

        public FaceVerificationResult(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            this.idKey = str;
            this.appId = str2;
            this.openId = str3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getIdKey() {
            return this.idKey;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getOpenId() {
            return this.openId;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof FaceVerificationResult) {
                    FaceVerificationResult faceVerificationResult = (FaceVerificationResult) other;
                    if (!Intrinsics.areEqual(this.idKey, faceVerificationResult.idKey) || !Intrinsics.areEqual(this.appId, faceVerificationResult.appId) || !Intrinsics.areEqual(this.openId, faceVerificationResult.openId)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            int i16;
            String str = this.idKey;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = i3 * 31;
            String str2 = this.appId;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i19 = (i18 + i16) * 31;
            String str3 = this.openId;
            if (str3 != null) {
                i17 = str3.hashCode();
            }
            return i19 + i17;
        }

        @NotNull
        public String toString() {
            return "FaceVerificationResult(idKey=" + this.idKey + ", appId=" + this.appId + ", openId=" + this.openId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/base/account/api/IECFaceVerification$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "openId", "b", "tmpKey", "c", "uin", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.account.api.IECFaceVerification$b, reason: from toString */
    /* loaded from: classes5.dex */
    public static final /* data */ class IdentificationConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String openId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String tmpKey;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String uin;

        public IdentificationConfig(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            this.openId = str;
            this.tmpKey = str2;
            this.uin = str3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getOpenId() {
            return this.openId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getTmpKey() {
            return this.tmpKey;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof IdentificationConfig) {
                    IdentificationConfig identificationConfig = (IdentificationConfig) other;
                    if (!Intrinsics.areEqual(this.openId, identificationConfig.openId) || !Intrinsics.areEqual(this.tmpKey, identificationConfig.tmpKey) || !Intrinsics.areEqual(this.uin, identificationConfig.uin)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            int i16;
            String str = this.openId;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = i3 * 31;
            String str2 = this.tmpKey;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i19 = (i18 + i16) * 31;
            String str3 = this.uin;
            if (str3 != null) {
                i17 = str3.hashCode();
            }
            return i19 + i17;
        }

        @NotNull
        public String toString() {
            return "IdentificationConfig(openId=" + this.openId + ", tmpKey=" + this.tmpKey + ", uin=" + this.uin + ")";
        }
    }

    void onRelease(@NotNull Context context);

    @Nullable
    Object requestForFaceVerificationConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, long j3, @NotNull Continuation<? super IdentificationConfig> continuation);

    @Nullable
    Object startFaceVerification(@NotNull Context context, @NotNull IdentificationConfig identificationConfig, @NotNull Continuation<? super FaceVerificationResult> continuation);
}
