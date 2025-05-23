package com.tencent.mobileqq.zplan.cloudmod.impl.cloudgame.data;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/cloudmod/impl/cloudgame/data/CloudUpdateProgressEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "status", "", "msg", Constants.SP_DEVICE_ID, "gmUid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getGmUid", "getMsg", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class CloudUpdateProgressEvent extends SimpleBaseEvent {
    private final String deviceId;
    private final String gmUid;
    private final String msg;
    private final String status;

    public CloudUpdateProgressEvent(String status, String msg2, String deviceId, String gmUid) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(gmUid, "gmUid");
        this.status = status;
        this.msg = msg2;
        this.deviceId = deviceId;
        this.gmUid = gmUid;
    }

    /* renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getGmUid() {
        return this.gmUid;
    }

    public final CloudUpdateProgressEvent copy(String status, String msg2, String deviceId, String gmUid) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(gmUid, "gmUid");
        return new CloudUpdateProgressEvent(status, msg2, deviceId, gmUid);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getGmUid() {
        return this.gmUid;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((this.status.hashCode() * 31) + this.msg.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.gmUid.hashCode();
    }

    public String toString() {
        return "CloudUpdateProgressEvent(status=" + this.status + ", msg=" + this.msg + ", deviceId=" + this.deviceId + ", gmUid=" + this.gmUid + ")";
    }

    public static /* synthetic */ CloudUpdateProgressEvent copy$default(CloudUpdateProgressEvent cloudUpdateProgressEvent, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = cloudUpdateProgressEvent.status;
        }
        if ((i3 & 2) != 0) {
            str2 = cloudUpdateProgressEvent.msg;
        }
        if ((i3 & 4) != 0) {
            str3 = cloudUpdateProgressEvent.deviceId;
        }
        if ((i3 & 8) != 0) {
            str4 = cloudUpdateProgressEvent.gmUid;
        }
        return cloudUpdateProgressEvent.copy(str, str2, str3, str4);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CloudUpdateProgressEvent)) {
            return false;
        }
        CloudUpdateProgressEvent cloudUpdateProgressEvent = (CloudUpdateProgressEvent) other;
        return Intrinsics.areEqual(this.status, cloudUpdateProgressEvent.status) && Intrinsics.areEqual(this.msg, cloudUpdateProgressEvent.msg) && Intrinsics.areEqual(this.deviceId, cloudUpdateProgressEvent.deviceId) && Intrinsics.areEqual(this.gmUid, cloudUpdateProgressEvent.gmUid);
    }
}
