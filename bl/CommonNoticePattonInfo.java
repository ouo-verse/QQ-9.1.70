package bl;

import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0003\t\u000b\u0012B/\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0017\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001c\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\t\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lbl/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "f", "(I)V", "pattonType", "Lbl/c$b;", "Lbl/c$b;", "c", "()Lbl/c$b;", "g", "(Lbl/c$b;)V", "plainTxt", "Lbl/c$a;", "Lbl/c$a;", "()Lbl/c$a;", "e", "(Lbl/c$a;)V", "lefttxtRightPic", "d", "Z", "()Z", tl.h.F, "(Z)V", "isVideoContent", "<init>", "(ILbl/c$b;Lbl/c$a;Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bl.c, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class CommonNoticePattonInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int pattonType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private CommonPlainTxtInfo plainTxt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private CommonLeftTxtRightPicInfo lefttxtRightPic;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isVideoContent;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u000b\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lbl/c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lbl/h;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "setTxtInfo", "(Ljava/util/List;)V", "txtInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "setPicInfo", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;)V", "picInfo", "<init>", "(Ljava/util/List;Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bl.c$a, reason: from toString */
    /* loaded from: classes39.dex */
    public static final /* data */ class CommonLeftTxtRightPicInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private List<CommonStRichMsg> txtInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private CommonStImage picInfo;

        public CommonLeftTxtRightPicInfo() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* renamed from: a, reason: from getter */
        public final CommonStImage getPicInfo() {
            return this.picInfo;
        }

        public final List<CommonStRichMsg> b() {
            return this.txtInfo;
        }

        public int hashCode() {
            return (this.txtInfo.hashCode() * 31) + this.picInfo.hashCode();
        }

        public String toString() {
            return "CommonLeftTxtRightPicInfo(txtInfo=" + this.txtInfo + ", picInfo=" + this.picInfo + ")";
        }

        public CommonLeftTxtRightPicInfo(List<CommonStRichMsg> txtInfo, CommonStImage picInfo) {
            Intrinsics.checkNotNullParameter(txtInfo, "txtInfo");
            Intrinsics.checkNotNullParameter(picInfo, "picInfo");
            this.txtInfo = txtInfo;
            this.picInfo = picInfo;
        }

        public /* synthetic */ CommonLeftTxtRightPicInfo(List list, CommonStImage commonStImage, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? new CommonStImage() : commonStImage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommonLeftTxtRightPicInfo)) {
                return false;
            }
            CommonLeftTxtRightPicInfo commonLeftTxtRightPicInfo = (CommonLeftTxtRightPicInfo) other;
            return Intrinsics.areEqual(this.txtInfo, commonLeftTxtRightPicInfo.txtInfo) && Intrinsics.areEqual(this.picInfo, commonLeftTxtRightPicInfo.picInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lbl/c$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lbl/h;", "a", "Ljava/util/List;", "()Ljava/util/List;", "setTxtInfo", "(Ljava/util/List;)V", "txtInfo", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bl.c$b, reason: from toString */
    /* loaded from: classes39.dex */
    public static final /* data */ class CommonPlainTxtInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private List<CommonStRichMsg> txtInfo;

        public CommonPlainTxtInfo() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final List<CommonStRichMsg> a() {
            return this.txtInfo;
        }

        public int hashCode() {
            return this.txtInfo.hashCode();
        }

        public String toString() {
            return "CommonPlainTxtInfo(txtInfo=" + this.txtInfo + ")";
        }

        public CommonPlainTxtInfo(List<CommonStRichMsg> txtInfo) {
            Intrinsics.checkNotNullParameter(txtInfo, "txtInfo");
            this.txtInfo = txtInfo;
        }

        public /* synthetic */ CommonPlainTxtInfo(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new ArrayList() : list);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CommonPlainTxtInfo) && Intrinsics.areEqual(this.txtInfo, ((CommonPlainTxtInfo) other).txtInfo);
        }
    }

    public CommonNoticePattonInfo() {
        this(0, null, null, false, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final CommonLeftTxtRightPicInfo getLefttxtRightPic() {
        return this.lefttxtRightPic;
    }

    /* renamed from: b, reason: from getter */
    public final int getPattonType() {
        return this.pattonType;
    }

    /* renamed from: c, reason: from getter */
    public final CommonPlainTxtInfo getPlainTxt() {
        return this.plainTxt;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsVideoContent() {
        return this.isVideoContent;
    }

    public final void e(CommonLeftTxtRightPicInfo commonLeftTxtRightPicInfo) {
        Intrinsics.checkNotNullParameter(commonLeftTxtRightPicInfo, "<set-?>");
        this.lefttxtRightPic = commonLeftTxtRightPicInfo;
    }

    public final void f(int i3) {
        this.pattonType = i3;
    }

    public final void g(CommonPlainTxtInfo commonPlainTxtInfo) {
        Intrinsics.checkNotNullParameter(commonPlainTxtInfo, "<set-?>");
        this.plainTxt = commonPlainTxtInfo;
    }

    public final void h(boolean z16) {
        this.isVideoContent = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.pattonType * 31) + this.plainTxt.hashCode()) * 31) + this.lefttxtRightPic.hashCode()) * 31;
        boolean z16 = this.isVideoContent;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public String toString() {
        return "CommonNoticePattonInfo(pattonType=" + this.pattonType + ", plainTxt=" + this.plainTxt + ", lefttxtRightPic=" + this.lefttxtRightPic + ", isVideoContent=" + this.isVideoContent + ")";
    }

    public CommonNoticePattonInfo(int i3, CommonPlainTxtInfo plainTxt, CommonLeftTxtRightPicInfo lefttxtRightPic, boolean z16) {
        Intrinsics.checkNotNullParameter(plainTxt, "plainTxt");
        Intrinsics.checkNotNullParameter(lefttxtRightPic, "lefttxtRightPic");
        this.pattonType = i3;
        this.plainTxt = plainTxt;
        this.lefttxtRightPic = lefttxtRightPic;
        this.isVideoContent = z16;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonNoticePattonInfo)) {
            return false;
        }
        CommonNoticePattonInfo commonNoticePattonInfo = (CommonNoticePattonInfo) other;
        return this.pattonType == commonNoticePattonInfo.pattonType && Intrinsics.areEqual(this.plainTxt, commonNoticePattonInfo.plainTxt) && Intrinsics.areEqual(this.lefttxtRightPic, commonNoticePattonInfo.lefttxtRightPic) && this.isVideoContent == commonNoticePattonInfo.isVideoContent;
    }

    public /* synthetic */ CommonNoticePattonInfo(int i3, CommonPlainTxtInfo commonPlainTxtInfo, CommonLeftTxtRightPicInfo commonLeftTxtRightPicInfo, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? new CommonPlainTxtInfo(null, 1, 0 == true ? 1 : 0) : commonPlainTxtInfo, (i16 & 4) != 0 ? new CommonLeftTxtRightPicInfo(0 == true ? 1 : 0, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0) : commonLeftTxtRightPicInfo, (i16 & 8) != 0 ? false : z16);
    }
}
