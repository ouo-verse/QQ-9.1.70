package hu0;

import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007\u00a2\u0006\u0004\b&\u0010'J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR\u001a\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u001a\u0010\u001a\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\fR\u001a\u0010 \u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b!\u0010\fR\u001a\u0010\"\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006("}, d2 = {"Lhu0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "minBufferDuration", "I", "g", "()I", "bufferPacketMaxTotalDuration", "a", "minBufferingTime", h.F, "maxBufferingTime", "e", "bufferingTimeout", "c", "bufferPacketMinTotalDuration", "b", "reduceLiveLatencyAction", "j", "", "reduceLatencySpeedUpRate", UserInfo.SEX_FEMALE, "i", "()F", "maxPreloadDuration", "f", "updateDownloadInfoDuration", "k", "enableOpenPlayerAllLog", "Z", "d", "()Z", "<init>", "(IIIIIIIFIIZ)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: hu0.a, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class IcgSvrPlayerConfig {

    @SerializedName("buffer_packet_max_total_duration")
    private final int bufferPacketMaxTotalDuration;

    @SerializedName("buffer_packet_min_total_duration")
    private final int bufferPacketMinTotalDuration;

    @SerializedName("buffering_timeout")
    private final int bufferingTimeout;

    @SerializedName("enable_open_player_all_log")
    private final boolean enableOpenPlayerAllLog;

    @SerializedName("max_buffering_time")
    private final int maxBufferingTime;

    @SerializedName("max_preload_duration")
    private final int maxPreloadDuration;

    @SerializedName("min_buffer_duration")
    private final int minBufferDuration;

    @SerializedName("min_buffering_time")
    private final int minBufferingTime;

    @SerializedName("reduce_latency_speed_up_rate")
    private final float reduceLatencySpeedUpRate;

    @SerializedName("reduce_live_latency_action")
    private final int reduceLiveLatencyAction;

    @SerializedName("update_download_info_duration")
    private final int updateDownloadInfoDuration;

    public IcgSvrPlayerConfig() {
        this(0, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0, false, 2047, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getBufferPacketMaxTotalDuration() {
        return this.bufferPacketMaxTotalDuration;
    }

    /* renamed from: b, reason: from getter */
    public final int getBufferPacketMinTotalDuration() {
        return this.bufferPacketMinTotalDuration;
    }

    /* renamed from: c, reason: from getter */
    public final int getBufferingTimeout() {
        return this.bufferingTimeout;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getEnableOpenPlayerAllLog() {
        return this.enableOpenPlayerAllLog;
    }

    /* renamed from: e, reason: from getter */
    public final int getMaxBufferingTime() {
        return this.maxBufferingTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IcgSvrPlayerConfig)) {
            return false;
        }
        IcgSvrPlayerConfig icgSvrPlayerConfig = (IcgSvrPlayerConfig) other;
        if (this.minBufferDuration == icgSvrPlayerConfig.minBufferDuration && this.bufferPacketMaxTotalDuration == icgSvrPlayerConfig.bufferPacketMaxTotalDuration && this.minBufferingTime == icgSvrPlayerConfig.minBufferingTime && this.maxBufferingTime == icgSvrPlayerConfig.maxBufferingTime && this.bufferingTimeout == icgSvrPlayerConfig.bufferingTimeout && this.bufferPacketMinTotalDuration == icgSvrPlayerConfig.bufferPacketMinTotalDuration && this.reduceLiveLatencyAction == icgSvrPlayerConfig.reduceLiveLatencyAction && Float.compare(this.reduceLatencySpeedUpRate, icgSvrPlayerConfig.reduceLatencySpeedUpRate) == 0 && this.maxPreloadDuration == icgSvrPlayerConfig.maxPreloadDuration && this.updateDownloadInfoDuration == icgSvrPlayerConfig.updateDownloadInfoDuration && this.enableOpenPlayerAllLog == icgSvrPlayerConfig.enableOpenPlayerAllLog) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getMaxPreloadDuration() {
        return this.maxPreloadDuration;
    }

    /* renamed from: g, reason: from getter */
    public final int getMinBufferDuration() {
        return this.minBufferDuration;
    }

    /* renamed from: h, reason: from getter */
    public final int getMinBufferingTime() {
        return this.minBufferingTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((((((((((((((((((this.minBufferDuration * 31) + this.bufferPacketMaxTotalDuration) * 31) + this.minBufferingTime) * 31) + this.maxBufferingTime) * 31) + this.bufferingTimeout) * 31) + this.bufferPacketMinTotalDuration) * 31) + this.reduceLiveLatencyAction) * 31) + Float.floatToIntBits(this.reduceLatencySpeedUpRate)) * 31) + this.maxPreloadDuration) * 31) + this.updateDownloadInfoDuration) * 31;
        boolean z16 = this.enableOpenPlayerAllLog;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return floatToIntBits + i3;
    }

    /* renamed from: i, reason: from getter */
    public final float getReduceLatencySpeedUpRate() {
        return this.reduceLatencySpeedUpRate;
    }

    /* renamed from: j, reason: from getter */
    public final int getReduceLiveLatencyAction() {
        return this.reduceLiveLatencyAction;
    }

    /* renamed from: k, reason: from getter */
    public final int getUpdateDownloadInfoDuration() {
        return this.updateDownloadInfoDuration;
    }

    @NotNull
    public String toString() {
        return "IcgSvrPlayerConfig(minBufferDuration=" + this.minBufferDuration + ", bufferPacketMaxTotalDuration=" + this.bufferPacketMaxTotalDuration + ", minBufferingTime=" + this.minBufferingTime + ", maxBufferingTime=" + this.maxBufferingTime + ", bufferingTimeout=" + this.bufferingTimeout + ", bufferPacketMinTotalDuration=" + this.bufferPacketMinTotalDuration + ", reduceLiveLatencyAction=" + this.reduceLiveLatencyAction + ", reduceLatencySpeedUpRate=" + this.reduceLatencySpeedUpRate + ", maxPreloadDuration=" + this.maxPreloadDuration + ", updateDownloadInfoDuration=" + this.updateDownloadInfoDuration + ", enableOpenPlayerAllLog=" + this.enableOpenPlayerAllLog + ")";
    }

    public IcgSvrPlayerConfig(int i3, int i16, int i17, int i18, int i19, int i26, int i27, float f16, int i28, int i29, boolean z16) {
        this.minBufferDuration = i3;
        this.bufferPacketMaxTotalDuration = i16;
        this.minBufferingTime = i17;
        this.maxBufferingTime = i18;
        this.bufferingTimeout = i19;
        this.bufferPacketMinTotalDuration = i26;
        this.reduceLiveLatencyAction = i27;
        this.reduceLatencySpeedUpRate = f16;
        this.maxPreloadDuration = i28;
        this.updateDownloadInfoDuration = i29;
        this.enableOpenPlayerAllLog = z16;
    }

    public /* synthetic */ IcgSvrPlayerConfig(int i3, int i16, int i17, int i18, int i19, int i26, int i27, float f16, int i28, int i29, boolean z16, int i36, DefaultConstructorMarker defaultConstructorMarker) {
        this((i36 & 1) != 0 ? 2000 : i3, (i36 & 2) != 0 ? 60000 : i16, (i36 & 4) != 0 ? 100 : i17, (i36 & 8) != 0 ? 5000 : i18, (i36 & 16) != 0 ? 30000 : i19, (i36 & 32) != 0 ? 4000 : i26, (i36 & 64) != 0 ? 1 : i27, (i36 & 128) != 0 ? 1.2f : f16, (i36 & 256) != 0 ? 6000 : i28, (i36 & 512) != 0 ? 1000 : i29, (i36 & 1024) != 0 ? false : z16);
    }
}
