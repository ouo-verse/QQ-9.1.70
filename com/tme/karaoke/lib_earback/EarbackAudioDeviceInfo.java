package com.tme.karaoke.lib_earback;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u00a2\u0006\u0004\b#\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016\u00a8\u0006%"}, d2 = {"Lcom/tme/karaoke/lib_earback/c;", "", "", "d", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Object;", "()Ljava/lang/Object;", "e", "(Ljava/lang/Object;)V", "audioDeviceInfo", "b", "Z", "c", "()Z", "i", "(Z)V", "isFullBand", "g", "isBlueToothSupport", "I", "getBlueToothLatency", "()I", "f", "(I)V", "blueToothLatency", "getBlueToothSupportMic", h.F, "blueToothSupportMic", "<init>", "(Ljava/lang/Object;ZZIZ)V", "lib_earback_release"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tme.karaoke.lib_earback.c, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class EarbackAudioDeviceInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Object audioDeviceInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isFullBand;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isBlueToothSupport;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int blueToothLatency;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean blueToothSupportMic;

    public EarbackAudioDeviceInfo() {
        this(null, false, false, 0, false, 31, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Object getAudioDeviceInfo() {
        return this.audioDeviceInfo;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsBlueToothSupport() {
        return this.isBlueToothSupport;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsFullBand() {
        return this.isFullBand;
    }

    public final void d() {
        this.audioDeviceInfo = null;
        this.isFullBand = false;
        this.isBlueToothSupport = false;
        this.blueToothLatency = 0;
        this.blueToothSupportMic = false;
    }

    public final void e(@Nullable Object obj) {
        this.audioDeviceInfo = obj;
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (this != other) {
            if (other instanceof EarbackAudioDeviceInfo) {
                EarbackAudioDeviceInfo earbackAudioDeviceInfo = (EarbackAudioDeviceInfo) other;
                if (Intrinsics.areEqual(this.audioDeviceInfo, earbackAudioDeviceInfo.audioDeviceInfo)) {
                    if (this.isFullBand == earbackAudioDeviceInfo.isFullBand) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        if (this.isBlueToothSupport == earbackAudioDeviceInfo.isBlueToothSupport) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            if (this.blueToothLatency == earbackAudioDeviceInfo.blueToothLatency) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (z18) {
                                if (this.blueToothSupportMic == earbackAudioDeviceInfo.blueToothSupportMic) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                if (z19) {
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void f(int i3) {
        this.blueToothLatency = i3;
    }

    public final void g(boolean z16) {
        this.isBlueToothSupport = z16;
    }

    public final void h(boolean z16) {
        this.blueToothSupportMic = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        Object obj = this.audioDeviceInfo;
        if (obj != null) {
            i3 = obj.hashCode();
        } else {
            i3 = 0;
        }
        int i16 = i3 * 31;
        boolean z16 = this.isFullBand;
        int i17 = 1;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        int i19 = (i16 + i18) * 31;
        boolean z17 = this.isBlueToothSupport;
        int i26 = z17;
        if (z17 != 0) {
            i26 = 1;
        }
        int i27 = (((i19 + i26) * 31) + this.blueToothLatency) * 31;
        boolean z18 = this.blueToothSupportMic;
        if (!z18) {
            i17 = z18 ? 1 : 0;
        }
        return i27 + i17;
    }

    public final void i(boolean z16) {
        this.isFullBand = z16;
    }

    @NotNull
    public String toString() {
        return "EarbackAudioDeviceInfo(audioDeviceInfo=" + this.audioDeviceInfo + ", isFullBand=" + this.isFullBand + ", isBlueToothSupport=" + this.isBlueToothSupport + ", blueToothLatency=" + this.blueToothLatency + ", blueToothSupportMic=" + this.blueToothSupportMic + ')';
    }

    public EarbackAudioDeviceInfo(@Nullable Object obj, boolean z16, boolean z17, int i3, boolean z18) {
        this.audioDeviceInfo = obj;
        this.isFullBand = z16;
        this.isBlueToothSupport = z17;
        this.blueToothLatency = i3;
        this.blueToothSupportMic = z18;
    }

    public /* synthetic */ EarbackAudioDeviceInfo(Object obj, boolean z16, boolean z17, int i3, boolean z18, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : obj, (i16 & 2) != 0 ? false : z16, (i16 & 4) != 0 ? false : z17, (i16 & 8) != 0 ? 0 : i3, (i16 & 16) == 0 ? z18 : false);
    }
}
