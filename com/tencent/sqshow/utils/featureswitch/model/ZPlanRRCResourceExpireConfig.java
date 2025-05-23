package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/ac;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "cloudCommonExpireDelay", "J", "a", "()J", "localCommonExpireDelay", "c", "cloudForceExpireTimestamp", "b", "<init>", "(JJJ)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.ac, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanRRCResourceExpireConfig {

    @SerializedName("zplan_rrc_cloud_common_expire_delay")
    private final long cloudCommonExpireDelay;

    @SerializedName("zplan_rrc_cloud_force_expire_timestamp")
    private final long cloudForceExpireTimestamp;

    @SerializedName("zplan_rrc_local_common_expire_delay")
    private final long localCommonExpireDelay;

    public ZPlanRRCResourceExpireConfig() {
        this(0L, 0L, 0L, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getCloudCommonExpireDelay() {
        return this.cloudCommonExpireDelay;
    }

    /* renamed from: b, reason: from getter */
    public final long getCloudForceExpireTimestamp() {
        return this.cloudForceExpireTimestamp;
    }

    /* renamed from: c, reason: from getter */
    public final long getLocalCommonExpireDelay() {
        return this.localCommonExpireDelay;
    }

    public int hashCode() {
        return (((com.tencent.mobileqq.vas.banner.c.a(this.cloudCommonExpireDelay) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.localCommonExpireDelay)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.cloudForceExpireTimestamp);
    }

    public String toString() {
        return "ZPlanRRCResourceExpireConfig(cloudCommonExpireDelay=" + this.cloudCommonExpireDelay + ", localCommonExpireDelay=" + this.localCommonExpireDelay + ", cloudForceExpireTimestamp=" + this.cloudForceExpireTimestamp + ')';
    }

    public ZPlanRRCResourceExpireConfig(long j3, long j16, long j17) {
        this.cloudCommonExpireDelay = j3;
        this.localCommonExpireDelay = j16;
        this.cloudForceExpireTimestamp = j17;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanRRCResourceExpireConfig)) {
            return false;
        }
        ZPlanRRCResourceExpireConfig zPlanRRCResourceExpireConfig = (ZPlanRRCResourceExpireConfig) other;
        return this.cloudCommonExpireDelay == zPlanRRCResourceExpireConfig.cloudCommonExpireDelay && this.localCommonExpireDelay == zPlanRRCResourceExpireConfig.localCommonExpireDelay && this.cloudForceExpireTimestamp == zPlanRRCResourceExpireConfig.cloudForceExpireTimestamp;
    }

    public /* synthetic */ ZPlanRRCResourceExpireConfig(long j3, long j16, long j17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? JoinTimeType.FIFTEEN_DAY : j3, (i3 & 2) != 0 ? 0L : j16, (i3 & 4) != 0 ? 0L : j17);
    }
}
