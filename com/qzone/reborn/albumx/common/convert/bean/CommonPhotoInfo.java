package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 &2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b#\u0010$B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonPhotoInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "albumId", "e", "b", "g", AEEditorConstants.ALBUMNAME, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "k", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;)V", "owner", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", h.F, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "c", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "j", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;)V", QAdVrReportParams.ParamKey.MEDIA, "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonPhotoInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String albumId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String albumName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CommonStUser owner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private CommonStMedia media;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonPhotoInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPhotoInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonPhotoInfo;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonPhotoInfo$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonPhotoInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonPhotoInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonPhotoInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonPhotoInfo[] newArray(int size) {
            return new CommonPhotoInfo[size];
        }

        Companion() {
        }
    }

    public CommonPhotoInfo() {
        this.albumId = "";
        this.albumName = "";
        this.owner = new CommonStUser();
        this.media = new CommonStMedia();
    }

    /* renamed from: a, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: b, reason: from getter */
    public final String getAlbumName() {
        return this.albumName;
    }

    /* renamed from: c, reason: from getter */
    public final CommonStMedia getMedia() {
        return this.media;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final CommonStUser getOwner() {
        return this.owner;
    }

    public final void f(String str) {
        this.albumId = str;
    }

    public final void g(String str) {
        this.albumName = str;
    }

    public final void j(CommonStMedia commonStMedia) {
        Intrinsics.checkNotNullParameter(commonStMedia, "<set-?>");
        this.media = commonStMedia;
    }

    public final void k(CommonStUser commonStUser) {
        Intrinsics.checkNotNullParameter(commonStUser, "<set-?>");
        this.owner = commonStUser;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.albumId);
        parcel.writeString(this.albumName);
        parcel.writeParcelable(this.owner, flags);
        parcel.writeParcelable(this.media, flags);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonPhotoInfo(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.albumId = parcel.readString();
        this.albumName = parcel.readString();
        CommonStUser commonStUser = (CommonStUser) parcel.readParcelable(CommonStUser.class.getClassLoader());
        this.owner = commonStUser == null ? new CommonStUser() : commonStUser;
        CommonStMedia commonStMedia = (CommonStMedia) parcel.readParcelable(CommonStMedia.class.getClassLoader());
        this.media = commonStMedia == null ? new CommonStMedia() : commonStMedia;
    }
}
