package com.tencent.qqnt.emotion.relatedemo;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/NTRelatedEmotionSearchResult;", "", "", "a", "I", "()I", "c", "(I)V", "defaultCount", "", "Lcom/tencent/qqnt/emotion/relatedemo/NTRelatedEmotionSearchResult$SearchResultItem;", "b", "Ljava/util/List;", "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "resultItems", "<init>", "()V", "SearchResultItem", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NTRelatedEmotionSearchResult {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int defaultCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<SearchResultItem> resultItems;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u0000 22\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b.\u0010/B\u0011\b\u0016\u0012\u0006\u00100\u001a\u00020\u0004\u00a2\u0006\u0004\b.\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010*\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b\u0015\u0010)R$\u0010-\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/NTRelatedEmotionSearchResult$SearchResultItem;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "dest", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "md5", "e", "b", "k", "url", "f", "getResourceId", "j", "resourceId", tl.h.F, "I", "getWidth", "()I", "l", "(I)V", "width", "i", "getHeight", "c", "height", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "getImgSize", "()J", "(J)V", "imgSize", BdhLogUtil.LogTag.Tag_Conn, "getImgOther", "imgOther", "<init>", "()V", "in", "(Landroid/os/Parcel;)V", "CREATOR", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class SearchResultItem implements Parcelable {
        static IPatchRedirector $redirector_;

        /* renamed from: CREATOR, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: C, reason: from kotlin metadata */
        @Nullable
        private String imgOther;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String md5;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String url;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String resourceId;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int width;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int height;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private long imgSize;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/NTRelatedEmotionSearchResult$SearchResultItem$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/emotion/relatedemo/NTRelatedEmotionSearchResult$SearchResultItem;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqnt/emotion/relatedemo/NTRelatedEmotionSearchResult$SearchResultItem;", "<init>", "()V", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.emotion.relatedemo.NTRelatedEmotionSearchResult$SearchResultItem$a, reason: from kotlin metadata */
        /* loaded from: classes24.dex */
        public static final class Companion implements Parcelable.Creator<SearchResultItem> {
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
            public SearchResultItem createFromParcel(@NotNull Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (SearchResultItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SearchResultItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SearchResultItem[] newArray(int size) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (SearchResultItem[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
                }
                return new SearchResultItem[size];
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38586);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 19)) {
                redirector.redirect((short) 19);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public SearchResultItem() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Nullable
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.md5;
        }

        @Nullable
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.url;
        }

        public final void c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, i3);
            } else {
                this.height = i3;
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            return 0;
        }

        public final void e(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            } else {
                this.imgOther = str;
            }
        }

        public final void f(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, j3);
            } else {
                this.imgSize = j3;
            }
        }

        public final void g(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                this.md5 = str;
            }
        }

        public final void j(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                this.resourceId = str;
            }
        }

        public final void k(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                this.url = str;
            }
        }

        public final void l(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, i3);
            } else {
                this.width = i3;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel dest, int flags) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, (Object) dest, flags);
                return;
            }
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.md5);
            dest.writeString(this.url);
            dest.writeString(this.resourceId);
            dest.writeInt(this.width);
            dest.writeInt(this.height);
            dest.writeLong(this.imgSize);
            dest.writeString(this.imgOther);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public SearchResultItem(@NotNull Parcel in5) {
            this();
            Intrinsics.checkNotNullParameter(in5, "in");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this, (Object) in5);
                return;
            }
            this.md5 = in5.readString();
            this.url = in5.readString();
            this.resourceId = in5.readString();
            this.width = in5.readInt();
            this.height = in5.readInt();
            this.imgSize = in5.readLong();
            this.imgOther = in5.readString();
        }
    }

    public NTRelatedEmotionSearchResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.defaultCount;
    }

    @Nullable
    public final List<SearchResultItem> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.resultItems;
    }

    public final void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.defaultCount = i3;
        }
    }

    public final void d(@Nullable List<SearchResultItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            this.resultItems = list;
        }
    }
}
