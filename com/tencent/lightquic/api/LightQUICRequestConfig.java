package com.tencent.lightquic.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.java_websocket.WebSocketImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/lightquic/api/LightQUICRequestConfig;", "", "host", "", "bodyBufferEnabled", "", "recvTimeoutSec", "", "quicPort", "", "(Ljava/lang/String;ZFI)V", "getBodyBufferEnabled", "()Z", "getHost", "()Ljava/lang/String;", "getQuicPort", "()I", "getRecvTimeoutSec", "()F", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "LightQUIC_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final /* data */ class LightQUICRequestConfig {
    static IPatchRedirector $redirector_;
    private final boolean bodyBufferEnabled;

    @NotNull
    private final String host;
    private final int quicPort;
    private final float recvTimeoutSec;

    public LightQUICRequestConfig() {
        this(null, false, 0.0f, 0, 15, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this);
    }

    public static /* synthetic */ LightQUICRequestConfig copy$default(LightQUICRequestConfig lightQUICRequestConfig, String str, boolean z16, float f16, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = lightQUICRequestConfig.host;
        }
        if ((i16 & 2) != 0) {
            z16 = lightQUICRequestConfig.bodyBufferEnabled;
        }
        if ((i16 & 4) != 0) {
            f16 = lightQUICRequestConfig.recvTimeoutSec;
        }
        if ((i16 & 8) != 0) {
            i3 = lightQUICRequestConfig.quicPort;
        }
        return lightQUICRequestConfig.copy(str, z16, f16, i3);
    }

    @NotNull
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.host;
    }

    public final boolean component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.bodyBufferEnabled;
    }

    public final float component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        return this.recvTimeoutSec;
    }

    public final int component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.quicPort;
    }

    @NotNull
    public final LightQUICRequestConfig copy(@NotNull String host, boolean bodyBufferEnabled, float recvTimeoutSec, int quicPort) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (LightQUICRequestConfig) iPatchRedirector.redirect((short) 12, this, host, Boolean.valueOf(bodyBufferEnabled), Float.valueOf(recvTimeoutSec), Integer.valueOf(quicPort));
        }
        Intrinsics.checkNotNullParameter(host, "host");
        return new LightQUICRequestConfig(host, bodyBufferEnabled, recvTimeoutSec, quicPort);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof LightQUICRequestConfig) {
                LightQUICRequestConfig lightQUICRequestConfig = (LightQUICRequestConfig) other;
                if (!Intrinsics.areEqual(this.host, lightQUICRequestConfig.host) || this.bodyBufferEnabled != lightQUICRequestConfig.bodyBufferEnabled || Float.compare(this.recvTimeoutSec, lightQUICRequestConfig.recvTimeoutSec) != 0 || this.quicPort != lightQUICRequestConfig.quicPort) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean getBodyBufferEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.bodyBufferEnabled;
    }

    @NotNull
    public final String getHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.host;
    }

    public final int getQuicPort() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.quicPort;
    }

    public final float getRecvTimeoutSec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        return this.recvTimeoutSec;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        String str = this.host;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i16 = i3 * 31;
        boolean z16 = this.bodyBufferEnabled;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        return ((((i16 + i17) * 31) + Float.floatToIntBits(this.recvTimeoutSec)) * 31) + this.quicPort;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "LightQUICRequestConfig(host=" + this.host + ", bodyBufferEnabled=" + this.bodyBufferEnabled + ", recvTimeoutSec=" + this.recvTimeoutSec + ", quicPort=" + this.quicPort + ")";
    }

    public LightQUICRequestConfig(@NotNull String host, boolean z16, float f16, int i3) {
        Intrinsics.checkNotNullParameter(host, "host");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, host, Boolean.valueOf(z16), Float.valueOf(f16), Integer.valueOf(i3));
            return;
        }
        this.host = host;
        this.bodyBufferEnabled = z16;
        this.recvTimeoutSec = f16;
        this.quicPort = i3;
    }

    public /* synthetic */ LightQUICRequestConfig(String str, boolean z16, float f16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? true : z16, (i16 & 4) != 0 ? 0.0f : f16, (i16 & 8) != 0 ? WebSocketImpl.DEFAULT_WSS_PORT : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16), Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
