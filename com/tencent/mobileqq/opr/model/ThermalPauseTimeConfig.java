package com.tencent.mobileqq.opr.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\u0006\u0010\u0017\u001a\u00020\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/opr/model/ThermalPauseTimeConfig;", "", "start", "", "end", "pause", "", "(IID)V", "getEnd", "()I", "getPause", "()D", "getStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "valid", "opr_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final /* data */ class ThermalPauseTimeConfig {
    static IPatchRedirector $redirector_;

    @SerializedName("end")
    private final int end;

    @SerializedName("pause")
    private final double pause;

    @SerializedName("start")
    private final int start;

    public ThermalPauseTimeConfig() {
        this(0, 0, 0.0d, 7, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this);
    }

    public static /* synthetic */ ThermalPauseTimeConfig copy$default(ThermalPauseTimeConfig thermalPauseTimeConfig, int i3, int i16, double d16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = thermalPauseTimeConfig.start;
        }
        if ((i17 & 2) != 0) {
            i16 = thermalPauseTimeConfig.end;
        }
        if ((i17 & 4) != 0) {
            d16 = thermalPauseTimeConfig.pause;
        }
        return thermalPauseTimeConfig.copy(i3, i16, d16);
    }

    public final int component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.start;
    }

    public final int component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.end;
    }

    public final double component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Double) iPatchRedirector.redirect((short) 9, (Object) this)).doubleValue();
        }
        return this.pause;
    }

    @NotNull
    public final ThermalPauseTimeConfig copy(int start, int end, double pause) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ThermalPauseTimeConfig) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(start), Integer.valueOf(end), Double.valueOf(pause));
        }
        return new ThermalPauseTimeConfig(start, end, pause);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThermalPauseTimeConfig)) {
            return false;
        }
        ThermalPauseTimeConfig thermalPauseTimeConfig = (ThermalPauseTimeConfig) other;
        if (this.start == thermalPauseTimeConfig.start && this.end == thermalPauseTimeConfig.end && Intrinsics.areEqual((Object) Double.valueOf(this.pause), (Object) Double.valueOf(thermalPauseTimeConfig.pause))) {
            return true;
        }
        return false;
    }

    public final int getEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.end;
    }

    public final double getPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Double) iPatchRedirector.redirect((short) 5, (Object) this)).doubleValue();
        }
        return this.pause;
    }

    public final int getStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.start;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return (((this.start * 31) + this.end) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.pause);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "ThermalPauseTimeConfig(start=" + this.start + ", end=" + this.end + ", pause=" + this.pause + ')';
    }

    public final boolean valid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.pause >= 0.0d && this.start < this.end) {
            return true;
        }
        return false;
    }

    public ThermalPauseTimeConfig(int i3, int i16, double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Double.valueOf(d16));
            return;
        }
        this.start = i3;
        this.end = i16;
        this.pause = d16;
    }

    public /* synthetic */ ThermalPauseTimeConfig(int i3, int i16, double d16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? Integer.MIN_VALUE : i3, (i17 & 2) != 0 ? Integer.MAX_VALUE : i16, (i17 & 4) != 0 ? 0.0d : d16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Double.valueOf(d16), Integer.valueOf(i17), defaultConstructorMarker);
    }
}
