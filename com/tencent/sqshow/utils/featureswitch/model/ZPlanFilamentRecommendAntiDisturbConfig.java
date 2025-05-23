package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/w;", "", "", "toString", "", "hashCode", "other", "", "equals", "antiDisturbDurationSecond", "I", "a", "()I", "<init>", "(I)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.w, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanFilamentRecommendAntiDisturbConfig {

    @SerializedName("anti_disturb_duration_second")
    private final int antiDisturbDurationSecond;

    public ZPlanFilamentRecommendAntiDisturbConfig() {
        this(0, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getAntiDisturbDurationSecond() {
        return this.antiDisturbDurationSecond;
    }

    public int hashCode() {
        return this.antiDisturbDurationSecond;
    }

    public String toString() {
        return "ZPlanFilamentRecommendAntiDisturbConfig(antiDisturbDurationSecond=" + this.antiDisturbDurationSecond + ')';
    }

    public ZPlanFilamentRecommendAntiDisturbConfig(int i3) {
        this.antiDisturbDurationSecond = i3;
    }

    public /* synthetic */ ZPlanFilamentRecommendAntiDisturbConfig(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? QzoneConfig.DefaultValue.QZONESETTINGS_AIO_FEEDS_MIN_REFRESH_TIME : i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ZPlanFilamentRecommendAntiDisturbConfig) && this.antiDisturbDurationSecond == ((ZPlanFilamentRecommendAntiDisturbConfig) other).antiDisturbDurationSecond;
    }
}
