package com.tencent.ecommerce.base.pageopener.api.imageselector;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/base/pageopener/api/imageselector/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/ECCaptureAbility;", "a", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/ECCaptureAbility;", "()Lcom/tencent/ecommerce/base/pageopener/api/imageselector/ECCaptureAbility;", "captureAbility", "<init>", "(Lcom/tencent/ecommerce/base/pageopener/api/imageselector/ECCaptureAbility;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.pageopener.api.imageselector.a, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECCameraConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ECCaptureAbility captureAbility;

    public ECCameraConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final ECCaptureAbility getCaptureAbility() {
        return this.captureAbility;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof ECCameraConfig) || !Intrinsics.areEqual(this.captureAbility, ((ECCameraConfig) other).captureAbility)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public int hashCode() {
        ECCaptureAbility eCCaptureAbility = this.captureAbility;
        if (eCCaptureAbility != null) {
            return eCCaptureAbility.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "ECCameraConfig(captureAbility=" + this.captureAbility + ")";
    }

    public ECCameraConfig(@NotNull ECCaptureAbility eCCaptureAbility) {
        this.captureAbility = eCCaptureAbility;
    }

    public /* synthetic */ ECCameraConfig(ECCaptureAbility eCCaptureAbility, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ECCaptureAbility.ALL_MEDIA : eCCaptureAbility);
    }
}
