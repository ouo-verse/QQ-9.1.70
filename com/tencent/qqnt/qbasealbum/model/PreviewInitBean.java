package com.tencent.qqnt.qbasealbum.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\n\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0002\u000e\u001cBI\b\u0002\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001f\u0010 B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R2\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R'\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/PreviewInitBean;", "Lcom/tencent/qqnt/qbasealbum/model/InitBean;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "f", "(Ljava/util/ArrayList;)V", "allMedia", "e", "I", "c", "()I", "previewPos", "selectMedias", "", h.F, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "business", "<init>", "(Ljava/util/ArrayList;ILjava/util/ArrayList;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class PreviewInitBean implements InitBean {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<LocalMediaInfo> allMedia;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int previewPos;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<LocalMediaInfo> selectMedias;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String business;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002R2\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R2\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR\"\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u0014\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/PreviewInitBean$a;", "", "Lcom/tencent/qqnt/qbasealbum/model/PreviewInitBean;", "a", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getAllMedia", "()Ljava/util/ArrayList;", "b", "(Ljava/util/ArrayList;)V", "allMedia", "", "I", "getPreviewPos", "()I", "d", "(I)V", "previewPos", "c", "getSelectMedias", "e", "selectMedias", "", "Ljava/lang/String;", "getBusiness", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "business", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ArrayList<LocalMediaInfo> allMedia;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int previewPos;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ArrayList<LocalMediaInfo> selectMedias;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String business;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.allMedia = new ArrayList<>();
            this.selectMedias = new ArrayList<>();
            this.business = "PREVIEW";
        }

        @NotNull
        public final PreviewInitBean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (PreviewInitBean) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return new PreviewInitBean(this.allMedia, this.previewPos, this.selectMedias, this.business, null);
        }

        public final void b(@NotNull ArrayList<LocalMediaInfo> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList);
            } else {
                Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
                this.allMedia = arrayList;
            }
        }

        public final void c(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.business = str;
            }
        }

        public final void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.previewPos = i3;
            }
        }

        public final void e(@NotNull ArrayList<LocalMediaInfo> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) arrayList);
            } else {
                Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
                this.selectMedias = arrayList;
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/PreviewInitBean$b;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/qbasealbum/model/PreviewInitBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqnt/qbasealbum/model/PreviewInitBean;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.model.PreviewInitBean$b, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion implements Parcelable.Creator<PreviewInitBean> {
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
        public PreviewInitBean createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PreviewInitBean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PreviewInitBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PreviewInitBean[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (PreviewInitBean[]) iPatchRedirector.redirect((short) 4, (Object) this, size);
            }
            return new PreviewInitBean[size];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41804);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ PreviewInitBean(ArrayList arrayList, int i3, ArrayList arrayList2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, i3, arrayList2, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, this, arrayList, Integer.valueOf(i3), arrayList2, str, defaultConstructorMarker);
    }

    @NotNull
    public final ArrayList<LocalMediaInfo> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.allMedia;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.business;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.previewPos;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 0;
    }

    @NotNull
    public final ArrayList<LocalMediaInfo> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.selectMedias;
    }

    public final void f(@NotNull ArrayList<LocalMediaInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList);
        } else {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.allMedia = arrayList;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeTypedList(this.allMedia);
        parcel.writeInt(this.previewPos);
        parcel.writeTypedList(this.selectMedias);
        parcel.writeString(this.business);
    }

    PreviewInitBean(ArrayList<LocalMediaInfo> arrayList, int i3, ArrayList<LocalMediaInfo> arrayList2, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, arrayList, Integer.valueOf(i3), arrayList2, str);
            return;
        }
        this.allMedia = arrayList;
        this.previewPos = i3;
        this.selectMedias = arrayList2;
        this.business = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PreviewInitBean(@NotNull Parcel parcel) {
        this(r1, r3, r0, r2);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Parcelable.Creator<LocalMediaInfo> creator = LocalMediaInfo.CREATOR;
        ArrayList createTypedArrayList = parcel.createTypedArrayList(creator);
        Intrinsics.checkNotNull(createTypedArrayList, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.qqnt.qbasealbum.model.LocalMediaInfo>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.qqnt.qbasealbum.model.LocalMediaInfo> }");
        int readInt = parcel.readInt();
        ArrayList createTypedArrayList2 = parcel.createTypedArrayList(creator);
        Intrinsics.checkNotNull(createTypedArrayList2, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.qqnt.qbasealbum.model.LocalMediaInfo>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.qqnt.qbasealbum.model.LocalMediaInfo> }");
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) parcel);
    }
}
