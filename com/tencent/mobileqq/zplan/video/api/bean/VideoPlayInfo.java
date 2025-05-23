package com.tencent.mobileqq.zplan.video.api.bean;

import com.tencent.ark.ark;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00032\u00020\u0001:\u0001\u000bB\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/video/api/bean/e;", "", "Lorg/json/JSONObject;", "d", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "componentId", "b", "c", "openId", "hostOpenId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.video.api.bean.e, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class VideoPlayInfo {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String componentId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String openId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String hostOpenId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/video/api/bean/e$a;", "", "Lorg/json/JSONObject;", "playJson", "Lcom/tencent/mobileqq/zplan/video/api/bean/e;", "b", ark.ARKMETADATA_JSON, "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.video.api.bean.e$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoPlayInfo a(JSONObject json) {
            String optString = json != null ? json.optString("tvId") : null;
            if (optString == null) {
                optString = "";
            }
            String optString2 = json != null ? json.optString("openId") : null;
            if (optString2 == null) {
                optString2 = "";
            }
            String optString3 = json != null ? json.optString("ownerOpenId") : null;
            return new VideoPlayInfo(optString, optString2, optString3 != null ? optString3 : "");
        }

        @JvmStatic
        public final VideoPlayInfo b(JSONObject playJson) {
            Intrinsics.checkNotNullParameter(playJson, "playJson");
            String componentId = playJson.optString("ComponentId");
            String openId = playJson.optString("OpenId");
            String hostOpenId = playJson.optString("HostOpenId");
            Intrinsics.checkNotNullExpressionValue(componentId, "componentId");
            Intrinsics.checkNotNullExpressionValue(openId, "openId");
            Intrinsics.checkNotNullExpressionValue(hostOpenId, "hostOpenId");
            return new VideoPlayInfo(componentId, openId, hostOpenId);
        }

        Companion() {
        }
    }

    public VideoPlayInfo(String componentId, String openId, String hostOpenId) {
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(hostOpenId, "hostOpenId");
        this.componentId = componentId;
        this.openId = openId;
        this.hostOpenId = hostOpenId;
    }

    /* renamed from: a, reason: from getter */
    public final String getComponentId() {
        return this.componentId;
    }

    /* renamed from: b, reason: from getter */
    public final String getHostOpenId() {
        return this.hostOpenId;
    }

    /* renamed from: c, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    public final JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ComponentId", this.componentId);
        jSONObject.put("OpenId", this.openId);
        jSONObject.put("HostOpenId", this.hostOpenId);
        return jSONObject;
    }

    public int hashCode() {
        return (((this.componentId.hashCode() * 31) + this.openId.hashCode()) * 31) + this.hostOpenId.hashCode();
    }

    public String toString() {
        return "VideoPlayInfo(componentId=" + this.componentId + ", openId=" + this.openId + ", hostOpenId=" + this.hostOpenId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoPlayInfo)) {
            return false;
        }
        VideoPlayInfo videoPlayInfo = (VideoPlayInfo) other;
        return Intrinsics.areEqual(this.componentId, videoPlayInfo.componentId) && Intrinsics.areEqual(this.openId, videoPlayInfo.openId) && Intrinsics.areEqual(this.hostOpenId, videoPlayInfo.hostOpenId);
    }
}
