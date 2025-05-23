package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/u;", "", "", "toString", "", "hashCode", "other", "", "equals", "enableUpdateEmoticonSize", "Z", "getEnableUpdateEmoticonSize", "()Z", "recordWidth", "I", "d", "()I", "recordHeight", "c", "encodeWidth", "b", "encodeHeight", "a", "<init>", "(ZIIII)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.u, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanEmoticonSizeConfig {

    @SerializedName("enableUpdateEmoticonSize")
    private final boolean enableUpdateEmoticonSize;

    @SerializedName("encodeHeight")
    private final int encodeHeight;

    @SerializedName("encodeWidth")
    private final int encodeWidth;

    @SerializedName("recordHeight")
    private final int recordHeight;

    @SerializedName("recordWidth")
    private final int recordWidth;

    public ZPlanEmoticonSizeConfig() {
        this(false, 0, 0, 0, 0, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getEncodeHeight() {
        return this.encodeHeight;
    }

    /* renamed from: b, reason: from getter */
    public final int getEncodeWidth() {
        return this.encodeWidth;
    }

    /* renamed from: c, reason: from getter */
    public final int getRecordHeight() {
        return this.recordHeight;
    }

    /* renamed from: d, reason: from getter */
    public final int getRecordWidth() {
        return this.recordWidth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z16 = this.enableUpdateEmoticonSize;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((((r06 * 31) + this.recordWidth) * 31) + this.recordHeight) * 31) + this.encodeWidth) * 31) + this.encodeHeight;
    }

    public String toString() {
        return "ZPlanEmoticonSizeConfig(enableUpdateEmoticonSize=" + this.enableUpdateEmoticonSize + ", recordWidth=" + this.recordWidth + ", recordHeight=" + this.recordHeight + ", encodeWidth=" + this.encodeWidth + ", encodeHeight=" + this.encodeHeight + ')';
    }

    public ZPlanEmoticonSizeConfig(boolean z16, int i3, int i16, int i17, int i18) {
        this.enableUpdateEmoticonSize = z16;
        this.recordWidth = i3;
        this.recordHeight = i16;
        this.encodeWidth = i17;
        this.encodeHeight = i18;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanEmoticonSizeConfig)) {
            return false;
        }
        ZPlanEmoticonSizeConfig zPlanEmoticonSizeConfig = (ZPlanEmoticonSizeConfig) other;
        return this.enableUpdateEmoticonSize == zPlanEmoticonSizeConfig.enableUpdateEmoticonSize && this.recordWidth == zPlanEmoticonSizeConfig.recordWidth && this.recordHeight == zPlanEmoticonSizeConfig.recordHeight && this.encodeWidth == zPlanEmoticonSizeConfig.encodeWidth && this.encodeHeight == zPlanEmoticonSizeConfig.encodeHeight;
    }

    public /* synthetic */ ZPlanEmoticonSizeConfig(boolean z16, int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? true : z16, (i19 & 2) != 0 ? 360 : i3, (i19 & 4) != 0 ? 360 : i16, (i19 & 8) != 0 ? 360 : i17, (i19 & 16) == 0 ? i18 : 360);
    }
}
