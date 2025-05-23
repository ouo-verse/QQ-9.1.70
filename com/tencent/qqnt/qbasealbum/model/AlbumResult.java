package com.tencent.qqnt.qbasealbum.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 32\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b0\u00101B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b0\u00102J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010'\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b&\u0010\u0017RB\u0010/\u001a\"\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010(j\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u0001`)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/AlbumResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "d", "Ljava/util/List;", "e", "()Ljava/util/List;", "o", "(Ljava/util/List;)V", "selectList", "", "Z", "b", "()Z", "l", "(Z)V", "needSend", "f", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isQualityRaw", "", h.F, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "commentText", "i", "k", "isFlashPic", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "c", "()Ljava/util/HashMap;", DomainData.DOMAIN_NAME, "(Ljava/util/HashMap;)V", "replaceMap", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AlbumResult implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<LocalMediaInfo> selectList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needSend;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isQualityRaw;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String commentText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isFlashPic;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HashMap<String, String> replaceMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/AlbumResult$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/qbasealbum/model/AlbumResult;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqnt/qbasealbum/model/AlbumResult;", "", "ALBUM_RESULT", "Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.model.AlbumResult$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion implements Parcelable.Creator<AlbumResult> {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AlbumResult createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AlbumResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AlbumResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AlbumResult[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AlbumResult[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new AlbumResult[size];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41611);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AlbumResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.needSend = true;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.commentText;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.needSend;
    }

    @Nullable
    public final HashMap<String, String> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (HashMap) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.replaceMap;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return 0;
    }

    @Nullable
    public final List<LocalMediaInfo> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.selectList;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.isFlashPic;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isQualityRaw;
    }

    public final void j(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.commentText = str;
        }
    }

    public final void k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.isFlashPic = z16;
        }
    }

    public final void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.needSend = z16;
        }
    }

    public final void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.isQualityRaw = z16;
        }
    }

    public final void n(@Nullable HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) hashMap);
        } else {
            this.replaceMap = hashMap;
        }
    }

    public final void o(@Nullable List<LocalMediaInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        } else {
            this.selectList = list;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeTypedList(this.selectList);
        parcel.writeByte(this.needSend ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isQualityRaw ? (byte) 1 : (byte) 0);
        parcel.writeString(this.commentText);
        parcel.writeByte(this.isFlashPic ? (byte) 1 : (byte) 0);
        parcel.writeSerializable(this.replaceMap);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AlbumResult(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) parcel);
            return;
        }
        ArrayList createTypedArrayList = parcel.createTypedArrayList(LocalMediaInfo.CREATOR);
        this.selectList = createTypedArrayList != null ? CollectionsKt___CollectionsKt.toList(createTypedArrayList) : null;
        this.needSend = parcel.readByte() != 0;
        this.isQualityRaw = parcel.readByte() != 0;
        this.commentText = parcel.readString();
        this.isFlashPic = parcel.readByte() != 0;
        Serializable readSerializable = parcel.readSerializable();
        this.replaceMap = readSerializable instanceof HashMap ? (HashMap) readSerializable : null;
    }
}
