package com.tencent.state.template.data;

import as4.d;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\f\u00a2\u0006\u0004\b7\u00108B\u0011\b\u0016\u0012\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\b7\u0010;J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\t\u0010\b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\r\u001a\u00020\fH\u00c6\u0003J\t\u0010\u000e\u001a\u00020\fH\u00c6\u0003J\t\u0010\u000f\u001a\u00020\fH\u00c6\u0003J\t\u0010\u0010\u001a\u00020\fH\u00c6\u0003JY\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\fH\u00c6\u0001J\t\u0010\u001a\u001a\u00020\fH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010#\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\"\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010,\u001a\u0004\b1\u0010.\"\u0004\b2\u00100R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\"\u0010\u0018\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010,\u001a\u0004\b5\u0010.\"\u0004\b6\u00100\u00a8\u0006<"}, d2 = {"Lcom/tencent/state/template/data/FloatingSphereInfo;", "", "", "needShowCallBackIcon", "", "pastTime", "countDownTime", "", "component1", "component2", "component3", "component4", "", "component5", "component6", "component7", "component8", "scene", "startTs", "heartbeatLastTs", "maxLifeSeconds", "tip", "url", "detail", WadlProxyConsts.KEY_JUMP_URL, "copy", "toString", "hashCode", "other", "equals", "I", "getScene", "()I", "setScene", "(I)V", "J", "getStartTs", "()J", "setStartTs", "(J)V", "getHeartbeatLastTs", "setHeartbeatLastTs", "getMaxLifeSeconds", "setMaxLifeSeconds", "Ljava/lang/String;", "getTip", "()Ljava/lang/String;", "setTip", "(Ljava/lang/String;)V", "getUrl", "setUrl", "getDetail", "setDetail", "getJumpUrl", "setJumpUrl", "<init>", "(IJJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Las4/d;", "pb", "(Las4/d;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class FloatingSphereInfo {
    private String detail;
    private long heartbeatLastTs;
    private String jumpUrl;
    private int maxLifeSeconds;
    private int scene;
    private long startTs;
    private String tip;
    private String url;

    public FloatingSphereInfo(int i3, long j3, long j16, int i16, String tip, String url, String detail, String jumpUrl) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        this.scene = i3;
        this.startTs = j3;
        this.heartbeatLastTs = j16;
        this.maxLifeSeconds = i16;
        this.tip = tip;
        this.url = url;
        this.detail = detail;
        this.jumpUrl = jumpUrl;
    }

    /* renamed from: component1, reason: from getter */
    public final int getScene() {
        return this.scene;
    }

    /* renamed from: component2, reason: from getter */
    public final long getStartTs() {
        return this.startTs;
    }

    /* renamed from: component3, reason: from getter */
    public final long getHeartbeatLastTs() {
        return this.heartbeatLastTs;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMaxLifeSeconds() {
        return this.maxLifeSeconds;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTip() {
        return this.tip;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDetail() {
        return this.detail;
    }

    /* renamed from: component8, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final FloatingSphereInfo copy(int scene, long startTs, long heartbeatLastTs, int maxLifeSeconds, String tip, String url, String detail, String jumpUrl) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        return new FloatingSphereInfo(scene, startTs, heartbeatLastTs, maxLifeSeconds, tip, url, detail, jumpUrl);
    }

    public final long countDownTime() {
        return this.maxLifeSeconds - ((System.currentTimeMillis() / 1000) - this.heartbeatLastTs);
    }

    public final String getDetail() {
        return this.detail;
    }

    public final long getHeartbeatLastTs() {
        return this.heartbeatLastTs;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final int getMaxLifeSeconds() {
        return this.maxLifeSeconds;
    }

    public final int getScene() {
        return this.scene;
    }

    public final long getStartTs() {
        return this.startTs;
    }

    public final String getTip() {
        return this.tip;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int a16 = ((((((this.scene * 31) + c.a(this.startTs)) * 31) + c.a(this.heartbeatLastTs)) * 31) + this.maxLifeSeconds) * 31;
        String str = this.tip;
        int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.detail;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.jumpUrl;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final boolean needShowCallBackIcon() {
        return this.startTs > 0 && this.heartbeatLastTs > 0 && this.maxLifeSeconds > 0 && (System.currentTimeMillis() / ((long) 1000)) - this.heartbeatLastTs < ((long) this.maxLifeSeconds);
    }

    public final long pastTime() {
        return System.currentTimeMillis() - (this.heartbeatLastTs * 1000);
    }

    public final void setDetail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.detail = str;
    }

    public final void setHeartbeatLastTs(long j3) {
        this.heartbeatLastTs = j3;
    }

    public final void setJumpUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpUrl = str;
    }

    public final void setMaxLifeSeconds(int i3) {
        this.maxLifeSeconds = i3;
    }

    public final void setScene(int i3) {
        this.scene = i3;
    }

    public final void setStartTs(long j3) {
        this.startTs = j3;
    }

    public final void setTip(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tip = str;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public String toString() {
        return "FloatingSphereInfo(scene=" + this.scene + ", startTs=" + this.startTs + ", heartbeatLastTs=" + this.heartbeatLastTs + ", maxLifeSeconds=" + this.maxLifeSeconds + ", tip=" + this.tip + ", url=" + this.url + ", detail=" + this.detail + ", jumpUrl=" + this.jumpUrl + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FloatingSphereInfo(d pb5) {
        this(r2, r3, r5, r7, r8, r9, r10, r11);
        Intrinsics.checkNotNullParameter(pb5, "pb");
        int i3 = pb5.f26886a;
        long j3 = pb5.f26887b;
        long j16 = pb5.f26888c;
        int i16 = pb5.f26889d;
        String str = pb5.f26890e;
        Intrinsics.checkNotNullExpressionValue(str, "pb.tip");
        String str2 = pb5.f26891f;
        Intrinsics.checkNotNullExpressionValue(str2, "pb.url");
        String str3 = pb5.f26892g;
        Intrinsics.checkNotNullExpressionValue(str3, "pb.deatil");
        String str4 = pb5.f26893h;
        Intrinsics.checkNotNullExpressionValue(str4, "pb.jumpUrl");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FloatingSphereInfo)) {
            return false;
        }
        FloatingSphereInfo floatingSphereInfo = (FloatingSphereInfo) other;
        return this.scene == floatingSphereInfo.scene && this.startTs == floatingSphereInfo.startTs && this.heartbeatLastTs == floatingSphereInfo.heartbeatLastTs && this.maxLifeSeconds == floatingSphereInfo.maxLifeSeconds && Intrinsics.areEqual(this.tip, floatingSphereInfo.tip) && Intrinsics.areEqual(this.url, floatingSphereInfo.url) && Intrinsics.areEqual(this.detail, floatingSphereInfo.detail) && Intrinsics.areEqual(this.jumpUrl, floatingSphereInfo.jumpUrl);
    }
}
