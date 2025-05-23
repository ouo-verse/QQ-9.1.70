package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.webview.VasWebConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000 12\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b.\u0010/B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b.\u00100J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010*\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b\u0012\u0010$\"\u0004\b)\u0010&R\"\u0010-\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\"\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&\u00a8\u00062"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStShare;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareToQzone;", "d", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareToQzone;", "getQzone", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareToQzone;", "j", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareToQzone;)V", "qzone", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareToArk;", "e", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareToArk;", "a", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareToArk;", "f", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareToArk;)V", "ark", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareOutside;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareOutside;", "b", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareOutside;", "g", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareOutside;)V", VasWebConstants.REPORT_ORIGIN, "", h.F, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "title", "i", "l", "summary", "c", "k", "shareKey", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStShare implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CommonShareToQzone qzone;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private CommonShareToArk ark;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CommonShareOutside outside;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String title;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String summary;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String shareKey;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStShare$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStShare;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonStShare;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonStShare$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonStShare> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonStShare createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonStShare(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonStShare[] newArray(int size) {
            return new CommonStShare[size];
        }

        Companion() {
        }
    }

    public CommonStShare() {
        this.qzone = new CommonShareToQzone();
        this.ark = new CommonShareToArk();
        this.outside = new CommonShareOutside();
        this.title = "";
        this.summary = "";
        this.shareKey = "";
    }

    /* renamed from: a, reason: from getter */
    public final CommonShareToArk getArk() {
        return this.ark;
    }

    /* renamed from: b, reason: from getter */
    public final CommonShareOutside getOutside() {
        return this.outside;
    }

    /* renamed from: c, reason: from getter */
    public final String getShareKey() {
        return this.shareKey;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    public final void f(CommonShareToArk commonShareToArk) {
        Intrinsics.checkNotNullParameter(commonShareToArk, "<set-?>");
        this.ark = commonShareToArk;
    }

    public final void g(CommonShareOutside commonShareOutside) {
        Intrinsics.checkNotNullParameter(commonShareOutside, "<set-?>");
        this.outside = commonShareOutside;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void j(CommonShareToQzone commonShareToQzone) {
        Intrinsics.checkNotNullParameter(commonShareToQzone, "<set-?>");
        this.qzone = commonShareToQzone;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareKey = str;
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.summary = str;
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.qzone, flags);
        parcel.writeParcelable(this.ark, flags);
        parcel.writeParcelable(this.outside, flags);
        parcel.writeString(this.title);
        parcel.writeString(this.summary);
        parcel.writeString(this.shareKey);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonStShare(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        CommonShareToQzone commonShareToQzone = (CommonShareToQzone) parcel.readParcelable(CommonShareToQzone.class.getClassLoader());
        this.qzone = commonShareToQzone == null ? new CommonShareToQzone() : commonShareToQzone;
        CommonShareToArk commonShareToArk = (CommonShareToArk) parcel.readParcelable(CommonShareToArk.class.getClassLoader());
        this.ark = commonShareToArk == null ? new CommonShareToArk() : commonShareToArk;
        CommonShareOutside commonShareOutside = (CommonShareOutside) parcel.readParcelable(CommonShareOutside.class.getClassLoader());
        this.outside = commonShareOutside == null ? new CommonShareOutside() : commonShareOutside;
        String readString = parcel.readString();
        this.title = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.summary = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.shareKey = readString3 != null ? readString3 : "";
    }
}
