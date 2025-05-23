package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 22\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b/\u00100B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b/\u00101J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0011\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "name", "e", "f", "o", PhotoCategorySinglePicInfo.SLOC, "b", "l", "lloc", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicSpecUrlEntry;", h.F, "Ljava/util/List;", "()Ljava/util/List;", DomainData.DOMAIN_NAME, "(Ljava/util/List;)V", "photoUrl", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicUrl;", "i", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicUrl;", "a", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicUrl;", "j", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicUrl;)V", "defaultUrl", "", "Z", "g", "()Z", "k", "(Z)V", NodeProps.CUSTOM_PROP_ISGIF, "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStImage implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String name;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String sloc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String lloc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private List<CommonStPicSpecUrlEntry> photoUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CommonStPicUrl defaultUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isGif;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonStImage$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonStImage> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonStImage createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonStImage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonStImage[] newArray(int size) {
            return new CommonStImage[size];
        }

        Companion() {
        }
    }

    public CommonStImage() {
        this.name = "";
        this.sloc = "";
        this.lloc = "";
        this.photoUrl = new ArrayList();
        this.defaultUrl = new CommonStPicUrl();
    }

    /* renamed from: a, reason: from getter */
    public final CommonStPicUrl getDefaultUrl() {
        return this.defaultUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getLloc() {
        return this.lloc;
    }

    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final List<CommonStPicSpecUrlEntry> e() {
        return this.photoUrl;
    }

    /* renamed from: f, reason: from getter */
    public final String getSloc() {
        return this.sloc;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsGif() {
        return this.isGif;
    }

    public final void j(CommonStPicUrl commonStPicUrl) {
        Intrinsics.checkNotNullParameter(commonStPicUrl, "<set-?>");
        this.defaultUrl = commonStPicUrl;
    }

    public final void k(boolean z16) {
        this.isGif = z16;
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lloc = str;
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void n(List<CommonStPicSpecUrlEntry> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.photoUrl = list;
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sloc = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.sloc);
        parcel.writeString(this.lloc);
        parcel.writeTypedList(this.photoUrl);
        parcel.writeParcelable(this.defaultUrl, flags);
        parcel.writeByte(this.isGif ? (byte) 1 : (byte) 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonStImage(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.name = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.sloc = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.lloc = readString3 != null ? readString3 : "";
        ArrayList createTypedArrayList = parcel.createTypedArrayList(CommonStPicSpecUrlEntry.INSTANCE);
        this.photoUrl = createTypedArrayList == null ? new ArrayList() : createTypedArrayList;
        CommonStPicUrl commonStPicUrl = (CommonStPicUrl) parcel.readParcelable(CommonStPicUrl.class.getClassLoader());
        this.defaultUrl = commonStPicUrl == null ? new CommonStPicUrl() : commonStPicUrl;
        this.isGif = parcel.readByte() != 0;
    }
}
