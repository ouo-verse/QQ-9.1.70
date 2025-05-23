package com.tencent.lightquic.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0012J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0007H\u00c6\u0003J\t\u0010!\u001a\u00020\u000fH\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0007H\u00c6\u0003J\t\u0010%\u001a\u00020\u0007H\u00c6\u0003J\t\u0010&\u001a\u00020\nH\u00c6\u0003J\t\u0010'\u001a\u00020\u0007H\u00c6\u0003J\t\u0010(\u001a\u00020\rH\u00c6\u0003J\t\u0010)\u001a\u00020\u000fH\u00c6\u0003Jw\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u00c6\u0001J\u0013\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020\u000fH\u00d6\u0001J\t\u0010.\u001a\u00020/H\u00d6\u0001R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018\u00a8\u00060"}, d2 = {"Lcom/tencent/lightquic/api/LightQUICEngineConfig;", "", "connectTimeoutSec", "", "recvTimeoutSec", "idleTimeoutSec", "isPlaintext", "", "isReuseSession", "quicVersion", "Lcom/tencent/lightquic/api/QUICVersion;", "isCallbackHttp1Header", "congestionType", "Lcom/tencent/lightquic/api/CongestionType;", "congestionInitialWindow", "", "isPingKeepAlive", "pingKeepAliveSec", "(FFFZZLcom/tencent/lightquic/api/QUICVersion;ZLcom/tencent/lightquic/api/CongestionType;IZI)V", "getCongestionInitialWindow", "()I", "getCongestionType", "()Lcom/tencent/lightquic/api/CongestionType;", "getConnectTimeoutSec", "()F", "getIdleTimeoutSec", "()Z", "getPingKeepAliveSec", "getQuicVersion", "()Lcom/tencent/lightquic/api/QUICVersion;", "getRecvTimeoutSec", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "LightQUIC_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final /* data */ class LightQUICEngineConfig {
    static IPatchRedirector $redirector_;
    private final int congestionInitialWindow;

    @NotNull
    private final CongestionType congestionType;
    private final float connectTimeoutSec;
    private final float idleTimeoutSec;
    private final boolean isCallbackHttp1Header;
    private final boolean isPingKeepAlive;
    private final boolean isPlaintext;
    private final boolean isReuseSession;
    private final int pingKeepAliveSec;

    @NotNull
    private final QUICVersion quicVersion;
    private final float recvTimeoutSec;

    public LightQUICEngineConfig() {
        this(0.0f, 0.0f, 0.0f, false, false, null, false, null, 0, false, 0, 2047, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this);
    }

    public static /* synthetic */ LightQUICEngineConfig copy$default(LightQUICEngineConfig lightQUICEngineConfig, float f16, float f17, float f18, boolean z16, boolean z17, QUICVersion qUICVersion, boolean z18, CongestionType congestionType, int i3, boolean z19, int i16, int i17, Object obj) {
        float f19;
        float f26;
        float f27;
        boolean z26;
        boolean z27;
        QUICVersion qUICVersion2;
        boolean z28;
        CongestionType congestionType2;
        int i18;
        boolean z29;
        int i19;
        if ((i17 & 1) != 0) {
            f19 = lightQUICEngineConfig.connectTimeoutSec;
        } else {
            f19 = f16;
        }
        if ((i17 & 2) != 0) {
            f26 = lightQUICEngineConfig.recvTimeoutSec;
        } else {
            f26 = f17;
        }
        if ((i17 & 4) != 0) {
            f27 = lightQUICEngineConfig.idleTimeoutSec;
        } else {
            f27 = f18;
        }
        if ((i17 & 8) != 0) {
            z26 = lightQUICEngineConfig.isPlaintext;
        } else {
            z26 = z16;
        }
        if ((i17 & 16) != 0) {
            z27 = lightQUICEngineConfig.isReuseSession;
        } else {
            z27 = z17;
        }
        if ((i17 & 32) != 0) {
            qUICVersion2 = lightQUICEngineConfig.quicVersion;
        } else {
            qUICVersion2 = qUICVersion;
        }
        if ((i17 & 64) != 0) {
            z28 = lightQUICEngineConfig.isCallbackHttp1Header;
        } else {
            z28 = z18;
        }
        if ((i17 & 128) != 0) {
            congestionType2 = lightQUICEngineConfig.congestionType;
        } else {
            congestionType2 = congestionType;
        }
        if ((i17 & 256) != 0) {
            i18 = lightQUICEngineConfig.congestionInitialWindow;
        } else {
            i18 = i3;
        }
        if ((i17 & 512) != 0) {
            z29 = lightQUICEngineConfig.isPingKeepAlive;
        } else {
            z29 = z19;
        }
        if ((i17 & 1024) != 0) {
            i19 = lightQUICEngineConfig.pingKeepAliveSec;
        } else {
            i19 = i16;
        }
        return lightQUICEngineConfig.copy(f19, f26, f27, z26, z27, qUICVersion2, z28, congestionType2, i18, z29, i19);
    }

    public final float component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Float) iPatchRedirector.redirect((short) 15, (Object) this)).floatValue();
        }
        return this.connectTimeoutSec;
    }

    public final boolean component10() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return this.isPingKeepAlive;
    }

    public final int component11() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return this.pingKeepAliveSec;
    }

    public final float component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Float) iPatchRedirector.redirect((short) 16, (Object) this)).floatValue();
        }
        return this.recvTimeoutSec;
    }

    public final float component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Float) iPatchRedirector.redirect((short) 17, (Object) this)).floatValue();
        }
        return this.idleTimeoutSec;
    }

    public final boolean component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.isPlaintext;
    }

    public final boolean component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.isReuseSession;
    }

    @NotNull
    public final QUICVersion component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (QUICVersion) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.quicVersion;
    }

    public final boolean component7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.isCallbackHttp1Header;
    }

    @NotNull
    public final CongestionType component8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (CongestionType) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.congestionType;
    }

    public final int component9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.congestionInitialWindow;
    }

    @NotNull
    public final LightQUICEngineConfig copy(float connectTimeoutSec, float recvTimeoutSec, float idleTimeoutSec, boolean isPlaintext, boolean isReuseSession, @NotNull QUICVersion quicVersion, boolean isCallbackHttp1Header, @NotNull CongestionType congestionType, int congestionInitialWindow, boolean isPingKeepAlive, int pingKeepAliveSec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (LightQUICEngineConfig) iPatchRedirector.redirect((short) 26, this, Float.valueOf(connectTimeoutSec), Float.valueOf(recvTimeoutSec), Float.valueOf(idleTimeoutSec), Boolean.valueOf(isPlaintext), Boolean.valueOf(isReuseSession), quicVersion, Boolean.valueOf(isCallbackHttp1Header), congestionType, Integer.valueOf(congestionInitialWindow), Boolean.valueOf(isPingKeepAlive), Integer.valueOf(pingKeepAliveSec));
        }
        Intrinsics.checkNotNullParameter(quicVersion, "quicVersion");
        Intrinsics.checkNotNullParameter(congestionType, "congestionType");
        return new LightQUICEngineConfig(connectTimeoutSec, recvTimeoutSec, idleTimeoutSec, isPlaintext, isReuseSession, quicVersion, isCallbackHttp1Header, congestionType, congestionInitialWindow, isPingKeepAlive, pingKeepAliveSec);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof LightQUICEngineConfig) {
                LightQUICEngineConfig lightQUICEngineConfig = (LightQUICEngineConfig) other;
                if (Float.compare(this.connectTimeoutSec, lightQUICEngineConfig.connectTimeoutSec) != 0 || Float.compare(this.recvTimeoutSec, lightQUICEngineConfig.recvTimeoutSec) != 0 || Float.compare(this.idleTimeoutSec, lightQUICEngineConfig.idleTimeoutSec) != 0 || this.isPlaintext != lightQUICEngineConfig.isPlaintext || this.isReuseSession != lightQUICEngineConfig.isReuseSession || !Intrinsics.areEqual(this.quicVersion, lightQUICEngineConfig.quicVersion) || this.isCallbackHttp1Header != lightQUICEngineConfig.isCallbackHttp1Header || !Intrinsics.areEqual(this.congestionType, lightQUICEngineConfig.congestionType) || this.congestionInitialWindow != lightQUICEngineConfig.congestionInitialWindow || this.isPingKeepAlive != lightQUICEngineConfig.isPingKeepAlive || this.pingKeepAliveSec != lightQUICEngineConfig.pingKeepAliveSec) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getCongestionInitialWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.congestionInitialWindow;
    }

    @NotNull
    public final CongestionType getCongestionType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CongestionType) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.congestionType;
    }

    public final float getConnectTimeoutSec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Float) iPatchRedirector.redirect((short) 1, (Object) this)).floatValue();
        }
        return this.connectTimeoutSec;
    }

    public final float getIdleTimeoutSec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        return this.idleTimeoutSec;
    }

    public final int getPingKeepAliveSec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.pingKeepAliveSec;
    }

    @NotNull
    public final QUICVersion getQuicVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QUICVersion) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.quicVersion;
    }

    public final float getRecvTimeoutSec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
        }
        return this.recvTimeoutSec;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        int floatToIntBits = ((((Float.floatToIntBits(this.connectTimeoutSec) * 31) + Float.floatToIntBits(this.recvTimeoutSec)) * 31) + Float.floatToIntBits(this.idleTimeoutSec)) * 31;
        boolean z16 = this.isPlaintext;
        int i16 = 1;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (floatToIntBits + i17) * 31;
        boolean z17 = this.isReuseSession;
        int i19 = z17;
        if (z17 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        QUICVersion qUICVersion = this.quicVersion;
        int i27 = 0;
        if (qUICVersion != null) {
            i3 = qUICVersion.hashCode();
        } else {
            i3 = 0;
        }
        int i28 = (i26 + i3) * 31;
        boolean z18 = this.isCallbackHttp1Header;
        int i29 = z18;
        if (z18 != 0) {
            i29 = 1;
        }
        int i36 = (i28 + i29) * 31;
        CongestionType congestionType = this.congestionType;
        if (congestionType != null) {
            i27 = congestionType.hashCode();
        }
        int i37 = (((i36 + i27) * 31) + this.congestionInitialWindow) * 31;
        boolean z19 = this.isPingKeepAlive;
        if (!z19) {
            i16 = z19 ? 1 : 0;
        }
        return ((i37 + i16) * 31) + this.pingKeepAliveSec;
    }

    public final boolean isCallbackHttp1Header() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isCallbackHttp1Header;
    }

    public final boolean isPingKeepAlive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.isPingKeepAlive;
    }

    public final boolean isPlaintext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isPlaintext;
    }

    public final boolean isReuseSession() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isReuseSession;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return "LightQUICEngineConfig(connectTimeoutSec=" + this.connectTimeoutSec + ", recvTimeoutSec=" + this.recvTimeoutSec + ", idleTimeoutSec=" + this.idleTimeoutSec + ", isPlaintext=" + this.isPlaintext + ", isReuseSession=" + this.isReuseSession + ", quicVersion=" + this.quicVersion + ", isCallbackHttp1Header=" + this.isCallbackHttp1Header + ", congestionType=" + this.congestionType + ", congestionInitialWindow=" + this.congestionInitialWindow + ", isPingKeepAlive=" + this.isPingKeepAlive + ", pingKeepAliveSec=" + this.pingKeepAliveSec + ")";
    }

    public LightQUICEngineConfig(float f16, float f17, float f18, boolean z16, boolean z17, @NotNull QUICVersion quicVersion, boolean z18, @NotNull CongestionType congestionType, int i3, boolean z19, int i16) {
        Intrinsics.checkNotNullParameter(quicVersion, "quicVersion");
        Intrinsics.checkNotNullParameter(congestionType, "congestionType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Boolean.valueOf(z16), Boolean.valueOf(z17), quicVersion, Boolean.valueOf(z18), congestionType, Integer.valueOf(i3), Boolean.valueOf(z19), Integer.valueOf(i16));
            return;
        }
        this.connectTimeoutSec = f16;
        this.recvTimeoutSec = f17;
        this.idleTimeoutSec = f18;
        this.isPlaintext = z16;
        this.isReuseSession = z17;
        this.quicVersion = quicVersion;
        this.isCallbackHttp1Header = z18;
        this.congestionType = congestionType;
        this.congestionInitialWindow = i3;
        this.isPingKeepAlive = z19;
        this.pingKeepAliveSec = i16;
    }

    public /* synthetic */ LightQUICEngineConfig(float f16, float f17, float f18, boolean z16, boolean z17, QUICVersion qUICVersion, boolean z18, CongestionType congestionType, int i3, boolean z19, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 4.0f : f16, (i17 & 2) != 0 ? 4.0f : f17, (i17 & 4) != 0 ? 90.0f : f18, (i17 & 8) != 0 ? false : z16, (i17 & 16) != 0 ? true : z17, (i17 & 32) != 0 ? QUICVersion.GQUIC_43 : qUICVersion, (i17 & 64) != 0 ? true : z18, (i17 & 128) != 0 ? CongestionType.CUBIC_BYTES : congestionType, (i17 & 256) != 0 ? 0 : i3, (i17 & 512) != 0 ? false : z19, (i17 & 1024) != 0 ? 0 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Boolean.valueOf(z16), Boolean.valueOf(z17), qUICVersion, Boolean.valueOf(z18), congestionType, Integer.valueOf(i3), Boolean.valueOf(z19), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }
}
