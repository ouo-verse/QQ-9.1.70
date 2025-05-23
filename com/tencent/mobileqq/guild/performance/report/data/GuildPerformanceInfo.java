package com.tencent.mobileqq.guild.performance.report.data;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t\u0012\b\b\u0002\u0010!\u001a\u00020\t\u0012\b\b\u0002\u0010$\u001a\u00020\t\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020+\u0012\b\b\u0002\u00106\u001a\u00020\u0007\u0012\b\b\u0002\u00108\u001a\u00020\u0007\u0012\b\b\u0002\u0010;\u001a\u00020\u0002\u0012\b\b\u0002\u0010B\u001a\u00020<\u0012\b\b\u0002\u0010E\u001a\u00020<\u00a2\u0006\u0004\bF\u0010GJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\"\u0010!\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR\"\u0010$\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b#\u0010\u000fR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00100\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010,\u001a\u0004\b\u001e\u0010-\"\u0004\b.\u0010/R\"\u00106\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b\"\u00103\"\u0004\b4\u00105R\"\u00108\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u00102\u001a\u0004\b\u001a\u00103\"\u0004\b7\u00105R\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010%\u001a\u0004\b1\u0010'\"\u0004\b:\u0010)R\"\u0010B\u001a\u00020<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b9\u0010?\"\u0004\b@\u0010AR\"\u0010E\u001a\u00020<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010>\u001a\u0004\b=\u0010?\"\u0004\bD\u0010A\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/data/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "d", "()F", "setMFps", "(F)V", "mFps", "b", "c", "setMDeviceFps", "mDeviceFps", "k", "setMSmoothRate", "mSmoothRate", "setMCpuUsage", "mCpuUsage", "e", h.F, "setMProcessMemoryUsage", "mProcessMemoryUsage", "f", "getMTotalPhoneMemory", "setMTotalPhoneMemory", "mTotalPhoneMemory", "g", "setMAllocatedHeapMemory", "mAllocatedHeapMemory", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "setMScene", "(Ljava/lang/String;)V", "mScene", "Lcom/tencent/mobileqq/guild/performance/report/data/InfoType;", "Lcom/tencent/mobileqq/guild/performance/report/data/InfoType;", "()Lcom/tencent/mobileqq/guild/performance/report/data/InfoType;", "setMInfoType", "(Lcom/tencent/mobileqq/guild/performance/report/data/InfoType;)V", "mInfoType", "j", "Z", "()Z", "setMIsBackground", "(Z)V", "mIsBackground", "setMInGuildTab", "mInGuildTab", "l", "setMSideScene", "mSideScene", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "D", "()D", "setMTempDiff", "(D)V", "mTempDiff", DomainData.DOMAIN_NAME, "setMTemperature", "mTemperature", "<init>", "(FFFFFFFLjava/lang/String;Lcom/tencent/mobileqq/guild/performance/report/data/InfoType;ZZLjava/lang/String;DD)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.performance.report.data.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildPerformanceInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private float mFps;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private float mDeviceFps;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private float mSmoothRate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private float mCpuUsage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private float mProcessMemoryUsage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private float mTotalPhoneMemory;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private float mAllocatedHeapMemory;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String mScene;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private InfoType mInfoType;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean mIsBackground;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean mInGuildTab;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String mSideScene;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private double mTempDiff;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private double mTemperature;

    public GuildPerformanceInfo() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, false, false, null, 0.0d, 0.0d, 16383, null);
    }

    /* renamed from: a, reason: from getter */
    public final float getMAllocatedHeapMemory() {
        return this.mAllocatedHeapMemory;
    }

    /* renamed from: b, reason: from getter */
    public final float getMCpuUsage() {
        return this.mCpuUsage;
    }

    /* renamed from: c, reason: from getter */
    public final float getMDeviceFps() {
        return this.mDeviceFps;
    }

    /* renamed from: d, reason: from getter */
    public final float getMFps() {
        return this.mFps;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getMInGuildTab() {
        return this.mInGuildTab;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildPerformanceInfo)) {
            return false;
        }
        GuildPerformanceInfo guildPerformanceInfo = (GuildPerformanceInfo) other;
        if (Float.compare(this.mFps, guildPerformanceInfo.mFps) == 0 && Float.compare(this.mDeviceFps, guildPerformanceInfo.mDeviceFps) == 0 && Float.compare(this.mSmoothRate, guildPerformanceInfo.mSmoothRate) == 0 && Float.compare(this.mCpuUsage, guildPerformanceInfo.mCpuUsage) == 0 && Float.compare(this.mProcessMemoryUsage, guildPerformanceInfo.mProcessMemoryUsage) == 0 && Float.compare(this.mTotalPhoneMemory, guildPerformanceInfo.mTotalPhoneMemory) == 0 && Float.compare(this.mAllocatedHeapMemory, guildPerformanceInfo.mAllocatedHeapMemory) == 0 && Intrinsics.areEqual(this.mScene, guildPerformanceInfo.mScene) && this.mInfoType == guildPerformanceInfo.mInfoType && this.mIsBackground == guildPerformanceInfo.mIsBackground && this.mInGuildTab == guildPerformanceInfo.mInGuildTab && Intrinsics.areEqual(this.mSideScene, guildPerformanceInfo.mSideScene) && Double.compare(this.mTempDiff, guildPerformanceInfo.mTempDiff) == 0 && Double.compare(this.mTemperature, guildPerformanceInfo.mTemperature) == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final InfoType getMInfoType() {
        return this.mInfoType;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getMIsBackground() {
        return this.mIsBackground;
    }

    /* renamed from: h, reason: from getter */
    public final float getMProcessMemoryUsage() {
        return this.mProcessMemoryUsage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((((((((((((((((Float.floatToIntBits(this.mFps) * 31) + Float.floatToIntBits(this.mDeviceFps)) * 31) + Float.floatToIntBits(this.mSmoothRate)) * 31) + Float.floatToIntBits(this.mCpuUsage)) * 31) + Float.floatToIntBits(this.mProcessMemoryUsage)) * 31) + Float.floatToIntBits(this.mTotalPhoneMemory)) * 31) + Float.floatToIntBits(this.mAllocatedHeapMemory)) * 31) + this.mScene.hashCode()) * 31) + this.mInfoType.hashCode()) * 31;
        boolean z16 = this.mIsBackground;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (floatToIntBits + i16) * 31;
        boolean z17 = this.mInGuildTab;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((((((i17 + i3) * 31) + this.mSideScene.hashCode()) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.mTempDiff)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.mTemperature);
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getMScene() {
        return this.mScene;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getMSideScene() {
        return this.mSideScene;
    }

    /* renamed from: k, reason: from getter */
    public final float getMSmoothRate() {
        return this.mSmoothRate;
    }

    /* renamed from: l, reason: from getter */
    public final double getMTempDiff() {
        return this.mTempDiff;
    }

    /* renamed from: m, reason: from getter */
    public final double getMTemperature() {
        return this.mTemperature;
    }

    @NotNull
    public String toString() {
        return "GuildPerformanceInfo(mFps=" + this.mFps + ", mDeviceFps=" + this.mDeviceFps + ", mSmoothRate=" + this.mSmoothRate + ", mCpuUsage=" + this.mCpuUsage + ", mProcessMemoryUsage=" + this.mProcessMemoryUsage + ", mTotalPhoneMemory=" + this.mTotalPhoneMemory + ", mAllocatedHeapMemory=" + this.mAllocatedHeapMemory + ", mScene=" + this.mScene + ", mInfoType=" + this.mInfoType + ", mIsBackground=" + this.mIsBackground + ", mInGuildTab=" + this.mInGuildTab + ", mSideScene=" + this.mSideScene + ", mTempDiff=" + this.mTempDiff + ", mTemperature=" + this.mTemperature + ')';
    }

    public GuildPerformanceInfo(float f16, float f17, float f18, float f19, float f26, float f27, float f28, @NotNull String mScene, @NotNull InfoType mInfoType, boolean z16, boolean z17, @NotNull String mSideScene, double d16, double d17) {
        Intrinsics.checkNotNullParameter(mScene, "mScene");
        Intrinsics.checkNotNullParameter(mInfoType, "mInfoType");
        Intrinsics.checkNotNullParameter(mSideScene, "mSideScene");
        this.mFps = f16;
        this.mDeviceFps = f17;
        this.mSmoothRate = f18;
        this.mCpuUsage = f19;
        this.mProcessMemoryUsage = f26;
        this.mTotalPhoneMemory = f27;
        this.mAllocatedHeapMemory = f28;
        this.mScene = mScene;
        this.mInfoType = mInfoType;
        this.mIsBackground = z16;
        this.mInGuildTab = z17;
        this.mSideScene = mSideScene;
        this.mTempDiff = d16;
        this.mTemperature = d17;
    }

    public /* synthetic */ GuildPerformanceInfo(float f16, float f17, float f18, float f19, float f26, float f27, float f28, String str, InfoType infoType, boolean z16, boolean z17, String str2, double d16, double d17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) != 0 ? 0.0f : f18, (i3 & 8) != 0 ? 0.0f : f19, (i3 & 16) != 0 ? 0.0f : f26, (i3 & 32) != 0 ? 0.0f : f27, (i3 & 64) == 0 ? f28 : 0.0f, (i3 & 128) != 0 ? "default" : str, (i3 & 256) != 0 ? InfoType.DEFAULT_INFO : infoType, (i3 & 512) != 0 ? false : z16, (i3 & 1024) == 0 ? z17 : false, (i3 & 2048) == 0 ? str2 : "default", (i3 & 4096) != 0 ? 0.0d : d16, (i3 & 8192) == 0 ? d17 : 0.0d);
    }
}
