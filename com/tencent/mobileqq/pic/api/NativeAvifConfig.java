package com.tencent.mobileqq.pic.api;

import androidx.fragment.app.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/pic/api/NativeAvifConfig;", "", "avif_enable", "", "pic_width", "", "pic_height", "(ZJJ)V", "getAvif_enable", "()Z", "setAvif_enable", "(Z)V", "getPic_height", "()J", "setPic_height", "(J)V", "getPic_width", "setPic_width", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "pic_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final /* data */ class NativeAvifConfig {
    static IPatchRedirector $redirector_;
    private boolean avif_enable;
    private long pic_height;
    private long pic_width;

    public NativeAvifConfig(boolean z16, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.avif_enable = z16;
        this.pic_width = j3;
        this.pic_height = j16;
    }

    public static /* synthetic */ NativeAvifConfig copy$default(NativeAvifConfig nativeAvifConfig, boolean z16, long j3, long j16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = nativeAvifConfig.avif_enable;
        }
        if ((i3 & 2) != 0) {
            j3 = nativeAvifConfig.pic_width;
        }
        long j17 = j3;
        if ((i3 & 4) != 0) {
            j16 = nativeAvifConfig.pic_height;
        }
        return nativeAvifConfig.copy(z16, j17, j16);
    }

    public final boolean component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.avif_enable;
    }

    public final long component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.pic_width;
    }

    public final long component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.pic_height;
    }

    @NotNull
    public final NativeAvifConfig copy(boolean avif_enable, long pic_width, long pic_height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (NativeAvifConfig) iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(avif_enable), Long.valueOf(pic_width), Long.valueOf(pic_height));
        }
        return new NativeAvifConfig(avif_enable, pic_width, pic_height);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeAvifConfig)) {
            return false;
        }
        NativeAvifConfig nativeAvifConfig = (NativeAvifConfig) other;
        if (this.avif_enable == nativeAvifConfig.avif_enable && this.pic_width == nativeAvifConfig.pic_width && this.pic_height == nativeAvifConfig.pic_height) {
            return true;
        }
        return false;
    }

    public final boolean getAvif_enable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.avif_enable;
    }

    public final long getPic_height() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.pic_height;
    }

    public final long getPic_width() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.pic_width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        boolean z16 = this.avif_enable;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + a.a(this.pic_width)) * 31) + a.a(this.pic_height);
    }

    public final void setAvif_enable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.avif_enable = z16;
        }
    }

    public final void setPic_height(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            this.pic_height = j3;
        }
    }

    public final void setPic_width(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            this.pic_width = j3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "NativeAvifConfig(avif_enable=" + this.avif_enable + ", pic_width=" + this.pic_width + ", pic_height=" + this.pic_height + ")";
    }
}
