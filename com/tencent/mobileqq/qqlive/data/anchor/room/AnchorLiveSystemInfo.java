package com.tencent.mobileqq.qqlive.data.anchor.room;

import androidx.fragment.app.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\nH\u00c6\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00d6\u0001J\t\u0010 \u001a\u00020!H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqlive/data/anchor/room/AnchorLiveSystemInfo;", "", "upSourceSpeed", "", "gateWayRtt", "upSourceLoss", "", "cpuStatus", "anchorLiveNetQuality", "memoryRate", "", "(FFIIIJ)V", "getAnchorLiveNetQuality", "()I", "getCpuStatus", "getGateWayRtt", "()F", "getMemoryRate", "()J", "getUpSourceLoss", "getUpSourceSpeed", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final /* data */ class AnchorLiveSystemInfo {
    static IPatchRedirector $redirector_;
    private final int anchorLiveNetQuality;
    private final int cpuStatus;
    private final float gateWayRtt;
    private final long memoryRate;
    private final int upSourceLoss;
    private final float upSourceSpeed;

    public AnchorLiveSystemInfo(float f16, float f17, int i3, int i16, int i17, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3));
            return;
        }
        this.upSourceSpeed = f16;
        this.gateWayRtt = f17;
        this.upSourceLoss = i3;
        this.cpuStatus = i16;
        this.anchorLiveNetQuality = i17;
        this.memoryRate = j3;
    }

    public static /* synthetic */ AnchorLiveSystemInfo copy$default(AnchorLiveSystemInfo anchorLiveSystemInfo, float f16, float f17, int i3, int i16, int i17, long j3, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            f16 = anchorLiveSystemInfo.upSourceSpeed;
        }
        if ((i18 & 2) != 0) {
            f17 = anchorLiveSystemInfo.gateWayRtt;
        }
        float f18 = f17;
        if ((i18 & 4) != 0) {
            i3 = anchorLiveSystemInfo.upSourceLoss;
        }
        int i19 = i3;
        if ((i18 & 8) != 0) {
            i16 = anchorLiveSystemInfo.cpuStatus;
        }
        int i26 = i16;
        if ((i18 & 16) != 0) {
            i17 = anchorLiveSystemInfo.anchorLiveNetQuality;
        }
        int i27 = i17;
        if ((i18 & 32) != 0) {
            j3 = anchorLiveSystemInfo.memoryRate;
        }
        return anchorLiveSystemInfo.copy(f16, f18, i19, i26, i27, j3);
    }

    public final float component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.upSourceSpeed;
    }

    public final float component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this)).floatValue();
        }
        return this.gateWayRtt;
    }

    public final int component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.upSourceLoss;
    }

    public final int component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.cpuStatus;
    }

    public final int component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.anchorLiveNetQuality;
    }

    public final long component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.memoryRate;
    }

    @NotNull
    public final AnchorLiveSystemInfo copy(float upSourceSpeed, float gateWayRtt, int upSourceLoss, int cpuStatus, int anchorLiveNetQuality, long memoryRate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (AnchorLiveSystemInfo) iPatchRedirector.redirect((short) 14, this, Float.valueOf(upSourceSpeed), Float.valueOf(gateWayRtt), Integer.valueOf(upSourceLoss), Integer.valueOf(cpuStatus), Integer.valueOf(anchorLiveNetQuality), Long.valueOf(memoryRate));
        }
        return new AnchorLiveSystemInfo(upSourceSpeed, gateWayRtt, upSourceLoss, cpuStatus, anchorLiveNetQuality, memoryRate);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnchorLiveSystemInfo)) {
            return false;
        }
        AnchorLiveSystemInfo anchorLiveSystemInfo = (AnchorLiveSystemInfo) other;
        if (Float.compare(this.upSourceSpeed, anchorLiveSystemInfo.upSourceSpeed) == 0 && Float.compare(this.gateWayRtt, anchorLiveSystemInfo.gateWayRtt) == 0 && this.upSourceLoss == anchorLiveSystemInfo.upSourceLoss && this.cpuStatus == anchorLiveSystemInfo.cpuStatus && this.anchorLiveNetQuality == anchorLiveSystemInfo.anchorLiveNetQuality && this.memoryRate == anchorLiveSystemInfo.memoryRate) {
            return true;
        }
        return false;
    }

    public final int getAnchorLiveNetQuality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.anchorLiveNetQuality;
    }

    public final int getCpuStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.cpuStatus;
    }

    public final float getGateWayRtt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        return this.gateWayRtt;
    }

    public final long getMemoryRate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.memoryRate;
    }

    public final int getUpSourceLoss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.upSourceLoss;
    }

    public final float getUpSourceSpeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
        }
        return this.upSourceSpeed;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return (((((((((Float.floatToIntBits(this.upSourceSpeed) * 31) + Float.floatToIntBits(this.gateWayRtt)) * 31) + this.upSourceLoss) * 31) + this.cpuStatus) * 31) + this.anchorLiveNetQuality) * 31) + a.a(this.memoryRate);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "AnchorLiveSystemInfo(upSourceSpeed=" + this.upSourceSpeed + ", gateWayRtt=" + this.gateWayRtt + ", upSourceLoss=" + this.upSourceLoss + ", cpuStatus=" + this.cpuStatus + ", anchorLiveNetQuality=" + this.anchorLiveNetQuality + ", memoryRate=" + this.memoryRate + ")";
    }
}
