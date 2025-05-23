package com.tme.karaoke.lib_earback;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0017\u0012\b\b\u0002\u0010%\u001a\u00020\u001f\u0012\b\b\u0002\u0010*\u001a\u00020\u0007\u0012\b\b\u0002\u00101\u001a\u00020+\u0012\b\b\u0002\u00107\u001a\u000202\u00a2\u0006\u0004\b8\u00109J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010*\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010&\u001a\u0004\b\u0018\u0010'\"\u0004\b(\u0010)R\"\u00101\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00107\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u00103\u001a\u0004\b\n\u00104\"\u0004\b5\u00106\u00a8\u0006:"}, d2 = {"Lcom/tme/karaoke/lib_earback/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tme/karaoke/lib_earback/EarBackType;", "a", "Lcom/tme/karaoke/lib_earback/EarBackType;", "e", "()Lcom/tme/karaoke/lib_earback/EarBackType;", "j", "(Lcom/tme/karaoke/lib_earback/EarBackType;)V", "earBackType", "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "g", "(Ljava/lang/Object;)V", "earBackImpl", "Lcom/tme/karaoke/lib_earback/EarBackState;", "c", "Lcom/tme/karaoke/lib_earback/EarBackState;", "d", "()Lcom/tme/karaoke/lib_earback/EarBackState;", "i", "(Lcom/tme/karaoke/lib_earback/EarBackState;)V", "earBackStatus", "Lcom/tme/karaoke/lib_earback/EarBackUserWill;", "Lcom/tme/karaoke/lib_earback/EarBackUserWill;", "f", "()Lcom/tme/karaoke/lib_earback/EarBackUserWill;", "k", "(Lcom/tme/karaoke/lib_earback/EarBackUserWill;)V", "earBackUserWill", "Z", "()Z", h.F, "(Z)V", "earBackIsCanControlInApp", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getEarBackHadEvaluate", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setEarBackHadEvaluate", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "earBackHadEvaluate", "Lcom/tme/karaoke/lib_earback/c;", "Lcom/tme/karaoke/lib_earback/c;", "()Lcom/tme/karaoke/lib_earback/c;", "setAudioDeviceInfo", "(Lcom/tme/karaoke/lib_earback/c;)V", "audioDeviceInfo", "<init>", "(Lcom/tme/karaoke/lib_earback/EarBackType;Ljava/lang/Object;Lcom/tme/karaoke/lib_earback/EarBackState;Lcom/tme/karaoke/lib_earback/EarBackUserWill;ZLjava/util/concurrent/atomic/AtomicBoolean;Lcom/tme/karaoke/lib_earback/c;)V", "lib_earback_release"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tme.karaoke.lib_earback.b, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class EarBackWorkState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private EarBackType earBackType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Object earBackImpl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private EarBackState earBackStatus;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private EarBackUserWill earBackUserWill;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean earBackIsCanControlInApp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private AtomicBoolean earBackHadEvaluate;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private EarbackAudioDeviceInfo audioDeviceInfo;

    public EarBackWorkState() {
        this(null, null, null, null, false, null, null, 127, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final EarbackAudioDeviceInfo getAudioDeviceInfo() {
        return this.audioDeviceInfo;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Object getEarBackImpl() {
        return this.earBackImpl;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getEarBackIsCanControlInApp() {
        return this.earBackIsCanControlInApp;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final EarBackState getEarBackStatus() {
        return this.earBackStatus;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final EarBackType getEarBackType() {
        return this.earBackType;
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        if (this != other) {
            if (other instanceof EarBackWorkState) {
                EarBackWorkState earBackWorkState = (EarBackWorkState) other;
                if (Intrinsics.areEqual(this.earBackType, earBackWorkState.earBackType) && Intrinsics.areEqual(this.earBackImpl, earBackWorkState.earBackImpl) && Intrinsics.areEqual(this.earBackStatus, earBackWorkState.earBackStatus) && Intrinsics.areEqual(this.earBackUserWill, earBackWorkState.earBackUserWill)) {
                    if (this.earBackIsCanControlInApp == earBackWorkState.earBackIsCanControlInApp) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16 || !Intrinsics.areEqual(this.earBackHadEvaluate, earBackWorkState.earBackHadEvaluate) || !Intrinsics.areEqual(this.audioDeviceInfo, earBackWorkState.audioDeviceInfo)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final EarBackUserWill getEarBackUserWill() {
        return this.earBackUserWill;
    }

    public final void g(@Nullable Object obj) {
        this.earBackImpl = obj;
    }

    public final void h(boolean z16) {
        this.earBackIsCanControlInApp = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        EarBackType earBackType = this.earBackType;
        int i26 = 0;
        if (earBackType != null) {
            i3 = earBackType.hashCode();
        } else {
            i3 = 0;
        }
        int i27 = i3 * 31;
        Object obj = this.earBackImpl;
        if (obj != null) {
            i16 = obj.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        EarBackState earBackState = this.earBackStatus;
        if (earBackState != null) {
            i17 = earBackState.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        EarBackUserWill earBackUserWill = this.earBackUserWill;
        if (earBackUserWill != null) {
            i18 = earBackUserWill.hashCode();
        } else {
            i18 = 0;
        }
        int i36 = (i29 + i18) * 31;
        boolean z16 = this.earBackIsCanControlInApp;
        int i37 = z16;
        if (z16 != 0) {
            i37 = 1;
        }
        int i38 = (i36 + i37) * 31;
        AtomicBoolean atomicBoolean = this.earBackHadEvaluate;
        if (atomicBoolean != null) {
            i19 = atomicBoolean.hashCode();
        } else {
            i19 = 0;
        }
        int i39 = (i38 + i19) * 31;
        EarbackAudioDeviceInfo earbackAudioDeviceInfo = this.audioDeviceInfo;
        if (earbackAudioDeviceInfo != null) {
            i26 = earbackAudioDeviceInfo.hashCode();
        }
        return i39 + i26;
    }

    public final void i(@NotNull EarBackState earBackState) {
        Intrinsics.checkParameterIsNotNull(earBackState, "<set-?>");
        this.earBackStatus = earBackState;
    }

    public final void j(@NotNull EarBackType earBackType) {
        Intrinsics.checkParameterIsNotNull(earBackType, "<set-?>");
        this.earBackType = earBackType;
    }

    public final void k(@NotNull EarBackUserWill earBackUserWill) {
        Intrinsics.checkParameterIsNotNull(earBackUserWill, "<set-?>");
        this.earBackUserWill = earBackUserWill;
    }

    @NotNull
    public String toString() {
        return "EarBackWorkState(earBackType=" + this.earBackType + ", earBackImpl=" + this.earBackImpl + ", earBackStatus=" + this.earBackStatus + ", earBackUserWill=" + this.earBackUserWill + ", earBackIsCanControlInApp=" + this.earBackIsCanControlInApp + ", earBackHadEvaluate=" + this.earBackHadEvaluate + ", audioDeviceInfo=" + this.audioDeviceInfo + ")";
    }

    public EarBackWorkState(@NotNull EarBackType earBackType, @Nullable Object obj, @NotNull EarBackState earBackStatus, @NotNull EarBackUserWill earBackUserWill, boolean z16, @NotNull AtomicBoolean earBackHadEvaluate, @NotNull EarbackAudioDeviceInfo audioDeviceInfo) {
        Intrinsics.checkParameterIsNotNull(earBackType, "earBackType");
        Intrinsics.checkParameterIsNotNull(earBackStatus, "earBackStatus");
        Intrinsics.checkParameterIsNotNull(earBackUserWill, "earBackUserWill");
        Intrinsics.checkParameterIsNotNull(earBackHadEvaluate, "earBackHadEvaluate");
        Intrinsics.checkParameterIsNotNull(audioDeviceInfo, "audioDeviceInfo");
        this.earBackType = earBackType;
        this.earBackImpl = obj;
        this.earBackStatus = earBackStatus;
        this.earBackUserWill = earBackUserWill;
        this.earBackIsCanControlInApp = z16;
        this.earBackHadEvaluate = earBackHadEvaluate;
        this.audioDeviceInfo = audioDeviceInfo;
    }

    public /* synthetic */ EarBackWorkState(EarBackType earBackType, Object obj, EarBackState earBackState, EarBackUserWill earBackUserWill, boolean z16, AtomicBoolean atomicBoolean, EarbackAudioDeviceInfo earbackAudioDeviceInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? EarBackType.None : earBackType, (i3 & 2) != 0 ? null : obj, (i3 & 4) != 0 ? EarBackState.UnKnow : earBackState, (i3 & 8) != 0 ? EarBackUserWill.Off : earBackUserWill, (i3 & 16) != 0 ? true : z16, (i3 & 32) != 0 ? new AtomicBoolean(false) : atomicBoolean, (i3 & 64) != 0 ? new EarbackAudioDeviceInfo(null, false, false, 0, false, 31, null) : earbackAudioDeviceInfo);
    }
}
