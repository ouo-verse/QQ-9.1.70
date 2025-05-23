package com.tencent.mobileqq.qqlive.sail.model.anchor;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001\u0010BC\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016JE\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003R\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000b\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010\u001aR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/anchor/AvConfig;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "openAudio", "cameraMirror", "enableVolumeEvaluation", "streamRecordType", "muteAllUser", "audioVolumeEvaluation", "a", "", "toString", "hashCode", "", "other", "equals", "d", "Z", "j", "()Z", "e", "f", h.F, "I", "k", "()I", "i", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "<init>", "(ZZZIZI)V", "CREATOR", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class AvConfig implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean openAudio;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean cameraMirror;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean enableVolumeEvaluation;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int streamRecordType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean muteAllUser;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int audioVolumeEvaluation;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/anchor/AvConfig$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qqlive/sail/model/anchor/AvConfig;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/qqlive/sail/model/anchor/AvConfig;", "c", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.model.anchor.AvConfig$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion implements Parcelable.Creator<AvConfig> {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AvConfig createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AvConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AvConfig[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AvConfig[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new AvConfig[size];
        }

        @NotNull
        public final AvConfig c(@NotNull Parcel parcel) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (AvConfig) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (parcel.readInt() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (parcel.readInt() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            int readInt = parcel.readInt();
            if (parcel.readInt() > 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            return new AvConfig(z16, z17, z18, readInt, z19, parcel.readInt());
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30805);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AvConfig() {
        this(false, false, false, 0, false, 0, 63, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            return;
        }
        iPatchRedirector.redirect((short) 21, (Object) this);
    }

    public static /* synthetic */ AvConfig b(AvConfig avConfig, boolean z16, boolean z17, boolean z18, int i3, boolean z19, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            z16 = avConfig.openAudio;
        }
        if ((i17 & 2) != 0) {
            z17 = avConfig.cameraMirror;
        }
        boolean z26 = z17;
        if ((i17 & 4) != 0) {
            z18 = avConfig.enableVolumeEvaluation;
        }
        boolean z27 = z18;
        if ((i17 & 8) != 0) {
            i3 = avConfig.streamRecordType;
        }
        int i18 = i3;
        if ((i17 & 16) != 0) {
            z19 = avConfig.muteAllUser;
        }
        boolean z28 = z19;
        if ((i17 & 32) != 0) {
            i16 = avConfig.audioVolumeEvaluation;
        }
        return avConfig.a(z16, z26, z27, i18, z28, i16);
    }

    @NotNull
    public final AvConfig a(boolean openAudio, boolean cameraMirror, boolean enableVolumeEvaluation, int streamRecordType, boolean muteAllUser, int audioVolumeEvaluation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (AvConfig) iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(openAudio), Boolean.valueOf(cameraMirror), Boolean.valueOf(enableVolumeEvaluation), Integer.valueOf(streamRecordType), Boolean.valueOf(muteAllUser), Integer.valueOf(audioVolumeEvaluation));
        }
        return new AvConfig(openAudio, cameraMirror, enableVolumeEvaluation, streamRecordType, muteAllUser, audioVolumeEvaluation);
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.audioVolumeEvaluation;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return 0;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.cameraMirror;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvConfig)) {
            return false;
        }
        AvConfig avConfig = (AvConfig) other;
        if (this.openAudio == avConfig.openAudio && this.cameraMirror == avConfig.cameraMirror && this.enableVolumeEvaluation == avConfig.enableVolumeEvaluation && this.streamRecordType == avConfig.streamRecordType && this.muteAllUser == avConfig.muteAllUser && this.audioVolumeEvaluation == avConfig.audioVolumeEvaluation) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.enableVolumeEvaluation;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.muteAllUser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        boolean z16 = this.openAudio;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.cameraMirror;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        ?? r27 = this.enableVolumeEvaluation;
        int i19 = r27;
        if (r27 != 0) {
            i19 = 1;
        }
        int i26 = (((i18 + i19) * 31) + this.streamRecordType) * 31;
        boolean z17 = this.muteAllUser;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i26 + i3) * 31) + this.audioVolumeEvaluation;
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.openAudio;
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.streamRecordType;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "AvConfig(openAudio=" + this.openAudio + ", cameraMirror=" + this.cameraMirror + ", enableVolumeEvaluation=" + this.enableVolumeEvaluation + ", streamRecordType=" + this.streamRecordType + ", muteAllUser=" + this.muteAllUser + ", audioVolumeEvaluation=" + this.audioVolumeEvaluation + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.openAudio ? 1 : 0);
        parcel.writeInt(this.cameraMirror ? 1 : 0);
        parcel.writeInt(this.enableVolumeEvaluation ? 1 : 0);
        parcel.writeInt(this.streamRecordType);
        parcel.writeInt(this.muteAllUser ? 1 : 0);
        parcel.writeInt(this.audioVolumeEvaluation);
    }

    public AvConfig(boolean z16, boolean z17, boolean z18, int i3, boolean z19, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3), Boolean.valueOf(z19), Integer.valueOf(i16));
            return;
        }
        this.openAudio = z16;
        this.cameraMirror = z17;
        this.enableVolumeEvaluation = z18;
        this.streamRecordType = i3;
        this.muteAllUser = z19;
        this.audioVolumeEvaluation = i16;
    }

    public /* synthetic */ AvConfig(boolean z16, boolean z17, boolean z18, int i3, boolean z19, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? true : z16, (i17 & 2) != 0 ? true : z17, (i17 & 4) != 0 ? false : z18, (i17 & 8) != 0 ? 0 : i3, (i17 & 16) != 0 ? false : z19, (i17 & 32) != 0 ? 200 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3), Boolean.valueOf(z19), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }
}
