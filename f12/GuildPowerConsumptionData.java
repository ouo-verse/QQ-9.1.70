package f12;

import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0011\u0012\b\b\u0002\u0010!\u001a\u00020\u0011\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0004\u00a2\u0006\u0004\b,\u0010-J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\"\u0010!\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\"\u001a\u0004\b\n\u0010#\"\u0004\b$\u0010%R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b\u0018\u0010#\"\u0004\b(\u0010%R\"\u0010+\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b*\u0010\u000f\u00a8\u0006."}, d2 = {"Lf12/j;", "", "", "i", "", "toString", "", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setMScene", "(Ljava/lang/String;)V", "mScene", "", "b", "J", "()J", "setMCpuJiffies", "(J)V", "mCpuJiffies", "c", "d", "setMRxBytes", "mRxBytes", tl.h.F, "setMTxBytes", "mTxBytes", "f", "setMSensorAccelarationTime", "mSensorAccelarationTime", "Z", "()Z", "setMBackGround", "(Z)V", "mBackGround", "g", "setMInGuildTab", "mInGuildTab", "setMSideScene", "mSideScene", "<init>", "(Ljava/lang/String;JJJJZZLjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: f12.j, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildPowerConsumptionData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String mScene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long mCpuJiffies;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long mRxBytes;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private long mTxBytes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long mSensorAccelarationTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean mBackGround;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean mInGuildTab;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String mSideScene;

    public GuildPowerConsumptionData() {
        this(null, 0L, 0L, 0L, 0L, false, false, null, 255, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getMBackGround() {
        return this.mBackGround;
    }

    /* renamed from: b, reason: from getter */
    public final long getMCpuJiffies() {
        return this.mCpuJiffies;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getMInGuildTab() {
        return this.mInGuildTab;
    }

    /* renamed from: d, reason: from getter */
    public final long getMRxBytes() {
        return this.mRxBytes;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getMScene() {
        return this.mScene;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildPowerConsumptionData)) {
            return false;
        }
        GuildPowerConsumptionData guildPowerConsumptionData = (GuildPowerConsumptionData) other;
        if (Intrinsics.areEqual(this.mScene, guildPowerConsumptionData.mScene) && this.mCpuJiffies == guildPowerConsumptionData.mCpuJiffies && this.mRxBytes == guildPowerConsumptionData.mRxBytes && this.mTxBytes == guildPowerConsumptionData.mTxBytes && this.mSensorAccelarationTime == guildPowerConsumptionData.mSensorAccelarationTime && this.mBackGround == guildPowerConsumptionData.mBackGround && this.mInGuildTab == guildPowerConsumptionData.mInGuildTab && Intrinsics.areEqual(this.mSideScene, guildPowerConsumptionData.mSideScene)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final long getMSensorAccelarationTime() {
        return this.mSensorAccelarationTime;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getMSideScene() {
        return this.mSideScene;
    }

    /* renamed from: h, reason: from getter */
    public final long getMTxBytes() {
        return this.mTxBytes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.mScene.hashCode() * 31) + androidx.fragment.app.a.a(this.mCpuJiffies)) * 31) + androidx.fragment.app.a.a(this.mRxBytes)) * 31) + androidx.fragment.app.a.a(this.mTxBytes)) * 31) + androidx.fragment.app.a.a(this.mSensorAccelarationTime)) * 31;
        boolean z16 = this.mBackGround;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.mInGuildTab;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i17 + i3) * 31) + this.mSideScene.hashCode();
    }

    public final boolean i() {
        if (this.mCpuJiffies < 800 && this.mRxBytes < IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE && this.mTxBytes < IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE && this.mSensorAccelarationTime < 2000 && !Intrinsics.areEqual(this.mScene, "null")) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "GuildPowerConsumptionData(mScene=" + this.mScene + ", mCpuJiffies=" + this.mCpuJiffies + ", mRxBytes=" + this.mRxBytes + ", mTxBytes=" + this.mTxBytes + ", mSensorAccelarationTime=" + this.mSensorAccelarationTime + ", mBackGround=" + this.mBackGround + ", mInGuildTab=" + this.mInGuildTab + ", mSideScene=" + this.mSideScene + ")";
    }

    public GuildPowerConsumptionData(@NotNull String mScene, long j3, long j16, long j17, long j18, boolean z16, boolean z17, @NotNull String mSideScene) {
        Intrinsics.checkNotNullParameter(mScene, "mScene");
        Intrinsics.checkNotNullParameter(mSideScene, "mSideScene");
        this.mScene = mScene;
        this.mCpuJiffies = j3;
        this.mRxBytes = j16;
        this.mTxBytes = j17;
        this.mSensorAccelarationTime = j18;
        this.mBackGround = z16;
        this.mInGuildTab = z17;
        this.mSideScene = mSideScene;
    }

    public /* synthetic */ GuildPowerConsumptionData(String str, long j3, long j16, long j17, long j18, boolean z16, boolean z17, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "default" : str, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? 0L : j16, (i3 & 8) != 0 ? 0L : j17, (i3 & 16) == 0 ? j18 : 0L, (i3 & 32) != 0 ? false : z16, (i3 & 64) == 0 ? z17 : false, (i3 & 128) == 0 ? str2 : "default");
    }
}
