package com.tencent.mobileqq.qqlive.sail.model.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001\u0012BM\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b+\u0010,J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016JO\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\fH\u00c6\u0001J\t\u0010\u0013\u001a\u00020\nH\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010\u001fR\u0017\u0010\u000f\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#R\u0017\u0010\u0010\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u001e\u001a\u0004\b \u0010\u001fR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b)\u0010!\u001a\u0004\b*\u0010#\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/common/RoomCoverInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "posterNum", "", "poster16v9", "", "posterTime16v9", QAdVrReport.ElementID.AD_POSTER, "posterTime", "poster3v4", "posterTime3v4", "a", "toString", "hashCode", "", "other", "", "equals", "d", "I", "getPosterNum", "()I", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "f", "J", "j", "()J", h.F, "c", "i", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, BdhLogUtil.LogTag.Tag_Conn, "k", "<init>", "(ILjava/lang/String;JLjava/lang/String;JLjava/lang/String;J)V", "CREATOR", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class RoomCoverInfo implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final long posterTime3v4;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int posterNum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String poster16v9;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long posterTime16v9;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String poster;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final long posterTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String poster3v4;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/common/RoomCoverInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qqlive/sail/model/common/RoomCoverInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/qqlive/sail/model/common/RoomCoverInfo;", "c", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.model.common.RoomCoverInfo$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion implements Parcelable.Creator<RoomCoverInfo> {
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
        public RoomCoverInfo createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RoomCoverInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RoomCoverInfo[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (RoomCoverInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new RoomCoverInfo[size];
        }

        @NotNull
        public final RoomCoverInfo c(@NotNull Parcel parcel) {
            String str;
            String str2;
            String str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (RoomCoverInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            if (readString == null) {
                str = "";
            } else {
                str = readString;
            }
            long readLong = parcel.readLong();
            String readString2 = parcel.readString();
            if (readString2 == null) {
                str2 = "";
            } else {
                str2 = readString2;
            }
            long readLong2 = parcel.readLong();
            String readString3 = parcel.readString();
            if (readString3 == null) {
                str3 = "";
            } else {
                str3 = readString3;
            }
            return new RoomCoverInfo(readInt, str, readLong, str2, readLong2, str3, parcel.readLong());
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30869);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RoomCoverInfo() {
        this(0, null, 0L, null, 0L, null, 0L, 127, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            return;
        }
        iPatchRedirector.redirect((short) 23, (Object) this);
    }

    public static /* synthetic */ RoomCoverInfo b(RoomCoverInfo roomCoverInfo, int i3, String str, long j3, String str2, long j16, String str3, long j17, int i16, Object obj) {
        int i17;
        String str4;
        long j18;
        String str5;
        long j19;
        String str6;
        long j26;
        if ((i16 & 1) != 0) {
            i17 = roomCoverInfo.posterNum;
        } else {
            i17 = i3;
        }
        if ((i16 & 2) != 0) {
            str4 = roomCoverInfo.poster16v9;
        } else {
            str4 = str;
        }
        if ((i16 & 4) != 0) {
            j18 = roomCoverInfo.posterTime16v9;
        } else {
            j18 = j3;
        }
        if ((i16 & 8) != 0) {
            str5 = roomCoverInfo.poster;
        } else {
            str5 = str2;
        }
        if ((i16 & 16) != 0) {
            j19 = roomCoverInfo.posterTime;
        } else {
            j19 = j16;
        }
        if ((i16 & 32) != 0) {
            str6 = roomCoverInfo.poster3v4;
        } else {
            str6 = str3;
        }
        if ((i16 & 64) != 0) {
            j26 = roomCoverInfo.posterTime3v4;
        } else {
            j26 = j17;
        }
        return roomCoverInfo.a(i17, str4, j18, str5, j19, str6, j26);
    }

    @NotNull
    public final RoomCoverInfo a(int posterNum, @NotNull String poster16v9, long posterTime16v9, @NotNull String poster, long posterTime, @NotNull String poster3v4, long posterTime3v4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (RoomCoverInfo) iPatchRedirector.redirect((short) 19, this, Integer.valueOf(posterNum), poster16v9, Long.valueOf(posterTime16v9), poster, Long.valueOf(posterTime), poster3v4, Long.valueOf(posterTime3v4));
        }
        Intrinsics.checkNotNullParameter(poster16v9, "poster16v9");
        Intrinsics.checkNotNullParameter(poster, "poster");
        Intrinsics.checkNotNullParameter(poster3v4, "poster3v4");
        return new RoomCoverInfo(posterNum, poster16v9, posterTime16v9, poster, posterTime, poster3v4, posterTime3v4);
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.poster;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return 0;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.poster16v9;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomCoverInfo)) {
            return false;
        }
        RoomCoverInfo roomCoverInfo = (RoomCoverInfo) other;
        if (this.posterNum == roomCoverInfo.posterNum && Intrinsics.areEqual(this.poster16v9, roomCoverInfo.poster16v9) && this.posterTime16v9 == roomCoverInfo.posterTime16v9 && Intrinsics.areEqual(this.poster, roomCoverInfo.poster) && this.posterTime == roomCoverInfo.posterTime && Intrinsics.areEqual(this.poster3v4, roomCoverInfo.poster3v4) && this.posterTime3v4 == roomCoverInfo.posterTime3v4) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.poster3v4;
    }

    public final long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.posterTime;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return (((((((((((this.posterNum * 31) + this.poster16v9.hashCode()) * 31) + a.a(this.posterTime16v9)) * 31) + this.poster.hashCode()) * 31) + a.a(this.posterTime)) * 31) + this.poster3v4.hashCode()) * 31) + a.a(this.posterTime3v4);
    }

    public final long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.posterTime16v9;
    }

    public final long k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.posterTime3v4;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return "RoomCoverInfo(posterNum=" + this.posterNum + ", poster16v9=" + this.poster16v9 + ", posterTime16v9=" + this.posterTime16v9 + ", poster=" + this.poster + ", posterTime=" + this.posterTime + ", poster3v4=" + this.poster3v4 + ", posterTime3v4=" + this.posterTime3v4 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.posterNum);
        parcel.writeString(this.poster16v9);
        parcel.writeLong(this.posterTime16v9);
        parcel.writeString(this.poster);
        parcel.writeLong(this.posterTime);
        parcel.writeString(this.poster3v4);
        parcel.writeLong(this.posterTime3v4);
    }

    public RoomCoverInfo(int i3, @NotNull String poster16v9, long j3, @NotNull String poster, long j16, @NotNull String poster3v4, long j17) {
        Intrinsics.checkNotNullParameter(poster16v9, "poster16v9");
        Intrinsics.checkNotNullParameter(poster, "poster");
        Intrinsics.checkNotNullParameter(poster3v4, "poster3v4");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), poster16v9, Long.valueOf(j3), poster, Long.valueOf(j16), poster3v4, Long.valueOf(j17));
            return;
        }
        this.posterNum = i3;
        this.poster16v9 = poster16v9;
        this.posterTime16v9 = j3;
        this.poster = poster;
        this.posterTime = j16;
        this.poster3v4 = poster3v4;
        this.posterTime3v4 = j17;
    }

    public /* synthetic */ RoomCoverInfo(int i3, String str, long j3, String str2, long j16, String str3, long j17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? 0L : j3, (i16 & 8) != 0 ? "" : str2, (i16 & 16) != 0 ? 0L : j16, (i16 & 32) != 0 ? "" : str3, (i16 & 64) != 0 ? 0L : j17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Long.valueOf(j3), str2, Long.valueOf(j16), str3, Long.valueOf(j17), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
