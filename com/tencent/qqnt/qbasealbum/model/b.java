package com.tencent.qqnt.qbasealbum.model;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0017\u0012\b\b\u0002\u0010$\u001a\u00020\u001e\u0012\b\b\u0002\u0010'\u001a\u00020\u0004\u0012\b\b\u0002\u0010)\u001a\u00020\u0004\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b3\u00104J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\t\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0018\u0010!\"\u0004\b\"\u0010#R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\n\u001a\u0004\b\u001f\u0010\f\"\u0004\b&\u0010\u000eR\"\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b%\u0010\f\"\u0004\b(\u0010\u000eR$\u0010/\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R(\u00102\u001a\u0004\u0018\u00010\u00022\b\u00100\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0013\"\u0004\b1\u0010\u0015\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getInnerId", "()I", "setInnerId", "(I)V", "innerId", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "name", "", "c", "J", "()J", h.F, "(J)V", "coverDate", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "d", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "j", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "mCoverInfo", "e", "k", "mMediaFileCount", "l", "mVideoFileCount", "g", "Ljava/lang/Long;", "()Ljava/lang/Long;", DomainData.DOMAIN_NAME, "(Ljava/lang/Long;)V", "realAlbumID", "value", "i", "id", "<init>", "(ILjava/lang/String;JLcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;IILjava/lang/Long;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int innerId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long coverDate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LocalMediaInfo mCoverInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mMediaFileCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mVideoFileCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long realAlbumID;

    public b() {
        this(0, null, 0L, null, 0, 0, null, 127, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) {
            return;
        }
        iPatchRedirector.redirect((short) 30, (Object) this);
    }

    public final long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.coverDate;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return String.valueOf(this.innerId);
    }

    @NotNull
    public final LocalMediaInfo c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mCoverInfo;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.mMediaFileCount;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.mVideoFileCount;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (this.innerId == bVar.innerId && Intrinsics.areEqual(this.name, bVar.name) && this.coverDate == bVar.coverDate && Intrinsics.areEqual(this.mCoverInfo, bVar.mCoverInfo) && this.mMediaFileCount == bVar.mMediaFileCount && this.mVideoFileCount == bVar.mVideoFileCount && Intrinsics.areEqual(this.realAlbumID, bVar.realAlbumID)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.name;
    }

    @Nullable
    public final Long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Long) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.realAlbumID;
    }

    public final void h(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.coverDate = j3;
        }
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        int i3 = this.innerId * 31;
        String str = this.name;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int a16 = (((((((((i3 + hashCode) * 31) + androidx.fragment.app.a.a(this.coverDate)) * 31) + this.mCoverInfo.hashCode()) * 31) + this.mMediaFileCount) * 31) + this.mVideoFileCount) * 31;
        Long l3 = this.realAlbumID;
        if (l3 != null) {
            i16 = l3.hashCode();
        }
        return a16 + i16;
    }

    public final void i(@Nullable String str) {
        int parseInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        a aVar = a.f361348a;
        if (!Intrinsics.areEqual(str, aVar.a()) && !Intrinsics.areEqual(str, aVar.b())) {
            if (str != null) {
                parseInt = str.hashCode();
            } else {
                parseInt = 0;
            }
        } else {
            parseInt = Integer.parseInt(str);
        }
        this.innerId = parseInt;
    }

    public final void j(@NotNull LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) localMediaInfo);
        } else {
            Intrinsics.checkNotNullParameter(localMediaInfo, "<set-?>");
            this.mCoverInfo = localMediaInfo;
        }
    }

    public final void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.mMediaFileCount = i3;
        }
    }

    public final void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.mVideoFileCount = i3;
        }
    }

    public final void m(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.name = str;
        }
    }

    public final void n(@Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) l3);
        } else {
            this.realAlbumID = l3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return "QQAlbumInfo(innerId=" + this.innerId + ", name=" + this.name + ", coverDate=" + this.coverDate + ", mCoverInfo=" + this.mCoverInfo + ", mMediaFileCount=" + this.mMediaFileCount + ", mVideoFileCount=" + this.mVideoFileCount + ", realAlbumID=" + this.realAlbumID + ")";
    }

    public b(int i3, @Nullable String str, long j3, @NotNull LocalMediaInfo mCoverInfo, int i16, int i17, @Nullable Long l3) {
        Intrinsics.checkNotNullParameter(mCoverInfo, "mCoverInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Long.valueOf(j3), mCoverInfo, Integer.valueOf(i16), Integer.valueOf(i17), l3);
            return;
        }
        this.innerId = i3;
        this.name = str;
        this.coverDate = j3;
        this.mCoverInfo = mCoverInfo;
        this.mMediaFileCount = i16;
        this.mVideoFileCount = i17;
        this.realAlbumID = l3;
    }

    public /* synthetic */ b(int i3, String str, long j3, LocalMediaInfo localMediaInfo, int i16, int i17, Long l3, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? null : str, (i18 & 4) != 0 ? 0L : j3, (i18 & 8) != 0 ? new LocalMediaInfo(false, 1, null) : localMediaInfo, (i18 & 16) != 0 ? 0 : i16, (i18 & 32) != 0 ? 0 : i17, (i18 & 64) != 0 ? null : l3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Long.valueOf(j3), localMediaInfo, Integer.valueOf(i16), Integer.valueOf(i17), l3, Integer.valueOf(i18), defaultConstructorMarker);
    }
}
