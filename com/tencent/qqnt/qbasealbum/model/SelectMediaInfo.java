package com.tencent.qqnt.qbasealbum.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001EB}\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\f\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u0012\b\b\u0002\u0010\"\u001a\u00020\f\u0012\b\b\u0002\u0010#\u001a\u00020\f\u0012\b\b\u0002\u0010$\u001a\u00020\u0017\u00a2\u0006\u0004\b@\u0010AB\u0011\b\u0016\u0012\u0006\u0010B\u001a\u00020\u0003\u00a2\u0006\u0004\b@\u0010CJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\t\u0010\u000b\u001a\u00020\nH\u00c6\u0003J\t\u0010\r\u001a\u00020\fH\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\fH\u00c6\u0003J\t\u0010\u0011\u001a\u00020\fH\u00c6\u0003J\t\u0010\u0012\u001a\u00020\fH\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\fH\u00c6\u0003J\t\u0010\u0016\u001a\u00020\fH\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0017H\u00c6\u0003J\u0081\u0001\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\f2\b\b\u0002\u0010$\u001a\u00020\u0017H\u00c6\u0001J\t\u0010&\u001a\u00020\fH\u00d6\u0001J\t\u0010'\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010(H\u00d6\u0003R\u0017\u0010\u0019\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u001a\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\u001b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\b3\u00104R\u0017\u0010\u001c\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\b5\u00104R\u0017\u0010\u001d\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b6\u00101R\u0017\u0010\u001e\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b7\u00101R\u0017\u0010\u001f\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010/\u001a\u0004\b8\u00101R\u0017\u0010 \u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b \u00102\u001a\u0004\b9\u00104R\u0017\u0010!\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b!\u00102\u001a\u0004\b:\u00104R\u0017\u0010\"\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010/\u001a\u0004\b;\u00101R\u0017\u0010#\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b#\u0010/\u001a\u0004\b<\u00101R\u0017\u0010$\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b$\u0010=\u001a\u0004\b>\u0010?\u00a8\u0006F"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/SelectMediaInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "Landroid/os/Parcel;", "dest", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "component1", "", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "", "component12", "pageType", "albumId", "width", "height", "localMediaPath", "qZoneMediaId", "qZoneMediaThumbUrl", "qZoneMediaThumbWidth", "qZoneMediaThumbHeight", "qZoneMediaDownloadUrl", "qZoneMediaSloc", "duration", "copy", "toString", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "getPageType", "()Lcom/tencent/qqnt/qbasealbum/model/PageType;", "Ljava/lang/String;", "getAlbumId", "()Ljava/lang/String;", "I", "getWidth", "()I", "getHeight", "getLocalMediaPath", "getQZoneMediaId", "getQZoneMediaThumbUrl", "getQZoneMediaThumbWidth", "getQZoneMediaThumbHeight", "getQZoneMediaDownloadUrl", "getQZoneMediaSloc", "J", "getDuration", "()J", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/PageType;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;J)V", "parcel", "(Landroid/os/Parcel;)V", "Companion", "b", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class SelectMediaInfo implements Parcelable, Serializable {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<SelectMediaInfo> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private final String albumId;
    private final long duration;
    private final int height;

    @NotNull
    private final String localMediaPath;

    @NotNull
    private final PageType pageType;

    @NotNull
    private final String qZoneMediaDownloadUrl;

    @NotNull
    private final String qZoneMediaId;

    @NotNull
    private final String qZoneMediaSloc;
    private final int qZoneMediaThumbHeight;

    @NotNull
    private final String qZoneMediaThumbUrl;
    private final int qZoneMediaThumbWidth;
    private final int width;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/qbasealbum/model/SelectMediaInfo$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/qbasealbum/model/SelectMediaInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqnt/qbasealbum/model/SelectMediaInfo;", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements Parcelable.Creator<SelectMediaInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SelectMediaInfo createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SelectMediaInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SelectMediaInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SelectMediaInfo[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SelectMediaInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new SelectMediaInfo[size];
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/SelectMediaInfo$b;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "localMediaInfo", "", "albumId", "Lcom/tencent/qqnt/qbasealbum/model/SelectMediaInfo;", "a", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.model.SelectMediaInfo$b, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final SelectMediaInfo a(@NotNull LocalMediaInfo localMediaInfo, @NotNull String albumId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SelectMediaInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) localMediaInfo, (Object) albumId);
            }
            Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
            Intrinsics.checkNotNullParameter(albumId, "albumId");
            PageType g16 = com.tencent.qqnt.qbasealbum.ktx.b.g(localMediaInfo);
            int mediaWidth = localMediaInfo.getMediaWidth();
            int mediaHeight = localMediaInfo.getMediaHeight();
            String path = localMediaInfo.getPath();
            Intrinsics.checkNotNull(path);
            return new SelectMediaInfo(g16, albumId, mediaWidth, mediaHeight, path, null, null, 0, 0, null, null, com.tencent.qqnt.qbasealbum.ktx.b.f(localMediaInfo), 2016, null);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41909);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
        } else {
            INSTANCE = new Companion(null);
            CREATOR = new a();
        }
    }

    public SelectMediaInfo(@NotNull PageType pageType, @NotNull String albumId, int i3, int i16, @NotNull String localMediaPath, @NotNull String qZoneMediaId, @NotNull String qZoneMediaThumbUrl, int i17, int i18, @NotNull String qZoneMediaDownloadUrl, @NotNull String qZoneMediaSloc, long j3) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(localMediaPath, "localMediaPath");
        Intrinsics.checkNotNullParameter(qZoneMediaId, "qZoneMediaId");
        Intrinsics.checkNotNullParameter(qZoneMediaThumbUrl, "qZoneMediaThumbUrl");
        Intrinsics.checkNotNullParameter(qZoneMediaDownloadUrl, "qZoneMediaDownloadUrl");
        Intrinsics.checkNotNullParameter(qZoneMediaSloc, "qZoneMediaSloc");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, pageType, albumId, Integer.valueOf(i3), Integer.valueOf(i16), localMediaPath, qZoneMediaId, qZoneMediaThumbUrl, Integer.valueOf(i17), Integer.valueOf(i18), qZoneMediaDownloadUrl, qZoneMediaSloc, Long.valueOf(j3));
            return;
        }
        this.pageType = pageType;
        this.albumId = albumId;
        this.width = i3;
        this.height = i16;
        this.localMediaPath = localMediaPath;
        this.qZoneMediaId = qZoneMediaId;
        this.qZoneMediaThumbUrl = qZoneMediaThumbUrl;
        this.qZoneMediaThumbWidth = i17;
        this.qZoneMediaThumbHeight = i18;
        this.qZoneMediaDownloadUrl = qZoneMediaDownloadUrl;
        this.qZoneMediaSloc = qZoneMediaSloc;
        this.duration = j3;
    }

    @NotNull
    public final PageType component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (PageType) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.pageType;
    }

    @NotNull
    public final String component10() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.qZoneMediaDownloadUrl;
    }

    @NotNull
    public final String component11() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.qZoneMediaSloc;
    }

    public final long component12() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Long) iPatchRedirector.redirect((short) 29, (Object) this)).longValue();
        }
        return this.duration;
    }

    @NotNull
    public final String component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.albumId;
    }

    public final int component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.width;
    }

    public final int component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.height;
    }

    @NotNull
    public final String component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.localMediaPath;
    }

    @NotNull
    public final String component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.qZoneMediaId;
    }

    @NotNull
    public final String component7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.qZoneMediaThumbUrl;
    }

    public final int component8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return this.qZoneMediaThumbWidth;
    }

    public final int component9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return this.qZoneMediaThumbHeight;
    }

    @NotNull
    public final SelectMediaInfo copy(@NotNull PageType pageType, @NotNull String albumId, int width, int height, @NotNull String localMediaPath, @NotNull String qZoneMediaId, @NotNull String qZoneMediaThumbUrl, int qZoneMediaThumbWidth, int qZoneMediaThumbHeight, @NotNull String qZoneMediaDownloadUrl, @NotNull String qZoneMediaSloc, long duration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (SelectMediaInfo) iPatchRedirector.redirect((short) 30, this, pageType, albumId, Integer.valueOf(width), Integer.valueOf(height), localMediaPath, qZoneMediaId, qZoneMediaThumbUrl, Integer.valueOf(qZoneMediaThumbWidth), Integer.valueOf(qZoneMediaThumbHeight), qZoneMediaDownloadUrl, qZoneMediaSloc, Long.valueOf(duration));
        }
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(localMediaPath, "localMediaPath");
        Intrinsics.checkNotNullParameter(qZoneMediaId, "qZoneMediaId");
        Intrinsics.checkNotNullParameter(qZoneMediaThumbUrl, "qZoneMediaThumbUrl");
        Intrinsics.checkNotNullParameter(qZoneMediaDownloadUrl, "qZoneMediaDownloadUrl");
        Intrinsics.checkNotNullParameter(qZoneMediaSloc, "qZoneMediaSloc");
        return new SelectMediaInfo(pageType, albumId, width, height, localMediaPath, qZoneMediaId, qZoneMediaThumbUrl, qZoneMediaThumbWidth, qZoneMediaThumbHeight, qZoneMediaDownloadUrl, qZoneMediaSloc, duration);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectMediaInfo)) {
            return false;
        }
        SelectMediaInfo selectMediaInfo = (SelectMediaInfo) other;
        if (this.pageType == selectMediaInfo.pageType && Intrinsics.areEqual(this.albumId, selectMediaInfo.albumId) && this.width == selectMediaInfo.width && this.height == selectMediaInfo.height && Intrinsics.areEqual(this.localMediaPath, selectMediaInfo.localMediaPath) && Intrinsics.areEqual(this.qZoneMediaId, selectMediaInfo.qZoneMediaId) && Intrinsics.areEqual(this.qZoneMediaThumbUrl, selectMediaInfo.qZoneMediaThumbUrl) && this.qZoneMediaThumbWidth == selectMediaInfo.qZoneMediaThumbWidth && this.qZoneMediaThumbHeight == selectMediaInfo.qZoneMediaThumbHeight && Intrinsics.areEqual(this.qZoneMediaDownloadUrl, selectMediaInfo.qZoneMediaDownloadUrl) && Intrinsics.areEqual(this.qZoneMediaSloc, selectMediaInfo.qZoneMediaSloc) && this.duration == selectMediaInfo.duration) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAlbumId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.albumId;
    }

    public final long getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.duration;
    }

    public final int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.height;
    }

    @NotNull
    public final String getLocalMediaPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.localMediaPath;
    }

    @NotNull
    public final PageType getPageType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PageType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.pageType;
    }

    @NotNull
    public final String getQZoneMediaDownloadUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.qZoneMediaDownloadUrl;
    }

    @NotNull
    public final String getQZoneMediaId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.qZoneMediaId;
    }

    @NotNull
    public final String getQZoneMediaSloc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.qZoneMediaSloc;
    }

    public final int getQZoneMediaThumbHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.qZoneMediaThumbHeight;
    }

    @NotNull
    public final String getQZoneMediaThumbUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.qZoneMediaThumbUrl;
    }

    public final int getQZoneMediaThumbWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.qZoneMediaThumbWidth;
    }

    public final int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.width;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return (((((((((((((((((((((this.pageType.hashCode() * 31) + this.albumId.hashCode()) * 31) + this.width) * 31) + this.height) * 31) + this.localMediaPath.hashCode()) * 31) + this.qZoneMediaId.hashCode()) * 31) + this.qZoneMediaThumbUrl.hashCode()) * 31) + this.qZoneMediaThumbWidth) * 31) + this.qZoneMediaThumbHeight) * 31) + this.qZoneMediaDownloadUrl.hashCode()) * 31) + this.qZoneMediaSloc.hashCode()) * 31) + androidx.fragment.app.a.a(this.duration);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return "SelectMediaInfo(pageType=" + this.pageType + ", albumId=" + this.albumId + ", width=" + this.width + ", height=" + this.height + ", localMediaPath=" + this.localMediaPath + ", qZoneMediaId=" + this.qZoneMediaId + ", qZoneMediaThumbUrl=" + this.qZoneMediaThumbUrl + ", qZoneMediaThumbWidth=" + this.qZoneMediaThumbWidth + ", qZoneMediaThumbHeight=" + this.qZoneMediaThumbHeight + ", qZoneMediaDownloadUrl=" + this.qZoneMediaDownloadUrl + ", qZoneMediaSloc=" + this.qZoneMediaSloc + ", duration=" + this.duration + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) dest, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.pageType.name());
        dest.writeString(this.albumId);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeString(this.localMediaPath);
        dest.writeString(this.qZoneMediaId);
        dest.writeString(this.qZoneMediaThumbUrl);
        dest.writeInt(this.qZoneMediaThumbWidth);
        dest.writeInt(this.qZoneMediaThumbHeight);
        dest.writeString(this.qZoneMediaDownloadUrl);
        dest.writeString(this.qZoneMediaSloc);
        dest.writeLong(this.duration);
    }

    public /* synthetic */ SelectMediaInfo(PageType pageType, String str, int i3, int i16, String str2, String str3, String str4, int i17, int i18, String str5, String str6, long j3, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(pageType, (i19 & 2) != 0 ? "" : str, (i19 & 4) != 0 ? 0 : i3, (i19 & 8) != 0 ? 0 : i16, (i19 & 16) != 0 ? "" : str2, (i19 & 32) != 0 ? "" : str3, (i19 & 64) != 0 ? "" : str4, (i19 & 128) != 0 ? 0 : i17, (i19 & 256) != 0 ? 0 : i18, (i19 & 512) != 0 ? "" : str5, (i19 & 1024) != 0 ? "" : str6, (i19 & 2048) != 0 ? 0L : j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, pageType, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, str3, str4, Integer.valueOf(i17), Integer.valueOf(i18), str5, str6, Long.valueOf(j3), Integer.valueOf(i19), defaultConstructorMarker);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SelectMediaInfo(@NotNull Parcel parcel) {
        this(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, parcel.readLong());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        PageType valueOf = PageType.valueOf(readString);
        String readString2 = parcel.readString();
        Intrinsics.checkNotNull(readString2);
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        String readString3 = parcel.readString();
        Intrinsics.checkNotNull(readString3);
        String readString4 = parcel.readString();
        Intrinsics.checkNotNull(readString4);
        String readString5 = parcel.readString();
        Intrinsics.checkNotNull(readString5);
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        String readString6 = parcel.readString();
        Intrinsics.checkNotNull(readString6);
        String readString7 = parcel.readString();
        Intrinsics.checkNotNull(readString7);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this, (Object) parcel);
    }
}
