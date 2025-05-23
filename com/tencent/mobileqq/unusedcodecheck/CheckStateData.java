package com.tencent.mobileqq.unusedcodecheck;

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

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u001f\b\u0080\b\u0018\u0000 52\u00020\u0001:\u0001\u001aB7\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\u0017\u0012\u0006\u0010#\u001a\u00020\u0004\u0012\u0006\u0010*\u001a\u00020\u000e\u0012\u0006\u0010.\u001a\u00020\u0004\u0012\u0006\u00101\u001a\u00020\t\u00a2\u0006\u0004\b2\u00103B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b2\u00104J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b\u0018\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010.\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"R\"\u00101\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u0011\u001a\u0004\b/\u0010\u0013\"\u0004\b0\u0010\u0015\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/CheckStateData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setVersionName", "(Ljava/lang/String;)V", "versionName", "", "e", "J", "a", "()J", "j", "(J)V", "cacheFileLength", "I", "()I", "l", "(I)V", "lookupFailCount", tl.h.F, "Z", "g", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "isReported", "i", "c", "k", "lookupCount", "b", "setCommitID", "commitID", "<init>", "(Ljava/lang/String;JIZILjava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "unusedcode-check_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public final /* data */ class CheckStateData implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String versionName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long cacheFileLength;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int lookupFailCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isReported;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int lookupCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String commitID;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/CheckStateData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/unusedcodecheck/CheckStateData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "d", "(I)[Lcom/tencent/mobileqq/unusedcodecheck/CheckStateData;", "c", "b", "", "CHECK_KEY_PREFIX", "Ljava/lang/String;", "CHECK_STATE_KEY", "<init>", "()V", "unusedcode-check_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.unusedcodecheck.CheckStateData$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion implements Parcelable.Creator<CheckStateData> {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CheckStateData createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (CheckStateData) iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CheckStateData(parcel);
        }

        @NotNull
        public final CheckStateData b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (CheckStateData) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return (CheckStateData) b.f306127n.n().g("unusedcodecheck_mmkv_check_state_data", CheckStateData.class, c());
        }

        @NotNull
        public final CheckStateData c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (CheckStateData) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            b bVar = b.f306127n;
            return new CheckStateData(bVar.f(), 0L, 0, false, 0, bVar.e());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public CheckStateData[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CheckStateData[]) iPatchRedirector.redirect((short) 2, (Object) this, size);
            }
            return new CheckStateData[size];
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7674);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CheckStateData(@NotNull String versionName, long j3, int i3, boolean z16, int i16, @NotNull String commitID) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(commitID, "commitID");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, versionName, Long.valueOf(j3), Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), commitID);
            return;
        }
        this.versionName = versionName;
        this.cacheFileLength = j3;
        this.lookupFailCount = i3;
        this.isReported = z16;
        this.lookupCount = i16;
        this.commitID = commitID;
    }

    public final long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.cacheFileLength;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.commitID;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.lookupCount;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.lookupFailCount;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof CheckStateData) {
                CheckStateData checkStateData = (CheckStateData) other;
                if (!Intrinsics.areEqual(this.versionName, checkStateData.versionName) || this.cacheFileLength != checkStateData.cacheFileLength || this.lookupFailCount != checkStateData.lookupFailCount || this.isReported != checkStateData.isReported || this.lookupCount != checkStateData.lookupCount || !Intrinsics.areEqual(this.commitID, checkStateData.commitID)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.versionName;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.isReported;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        String str = this.versionName;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int a16 = ((((i3 * 31) + androidx.fragment.app.a.a(this.cacheFileLength)) * 31) + this.lookupFailCount) * 31;
        boolean z16 = this.isReported;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (((a16 + i17) * 31) + this.lookupCount) * 31;
        String str2 = this.commitID;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i18 + i16;
    }

    public final void j(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            this.cacheFileLength = j3;
        }
    }

    public final void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.lookupCount = i3;
        }
    }

    public final void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.lookupFailCount = i3;
        }
    }

    public final void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.isReported = z16;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "CheckStateData(versionName='" + this.versionName + "', commitID='" + this.commitID + "', cacheFileLength=" + this.cacheFileLength + ", lookupFailCount=" + this.lookupFailCount + ", isReported=" + this.isReported + ", lookupCount=" + this.lookupCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.versionName);
        parcel.writeLong(this.cacheFileLength);
        parcel.writeInt(this.lookupFailCount);
        parcel.writeByte(this.isReported ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.lookupCount);
        parcel.writeString(this.commitID);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CheckStateData(@NotNull Parcel parcel) {
        this(r3, r4, r6, r7, r8, r9);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString != null ? readString : "";
        Intrinsics.checkNotNullExpressionValue(str, "parcel.readString() ?: \"\"");
        long readLong = parcel.readLong();
        int readInt = parcel.readInt();
        boolean z16 = parcel.readByte() != ((byte) 0);
        int readInt2 = parcel.readInt();
        String readString2 = parcel.readString();
        String str2 = readString2 != null ? readString2 : "";
        Intrinsics.checkNotNullExpressionValue(str2, "parcel.readString() ?: \"\"");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, (Object) this, (Object) parcel);
    }
}
