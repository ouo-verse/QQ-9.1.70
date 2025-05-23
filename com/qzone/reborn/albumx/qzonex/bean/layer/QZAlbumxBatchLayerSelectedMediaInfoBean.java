package com.qzone.reborn.albumx.qzonex.bean.layer;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u0000 *2\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b'\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010&\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b%\u0010\u000f\u00a8\u0006+"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxBatchLayerSelectedMediaInfoBean;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Z", "f", "()Z", "l", "(Z)V", BaseProfileQZoneComponent.KEY_IS_VIDEO, "", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "lloc", "b", "k", "url", "", h.F, "J", "c", "()J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(J)V", QFSEdgeItem.KEY_VIDEO_TIME, "i", "j", "isSelected", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxBatchLayerSelectedMediaInfoBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isVideo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String lloc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String url;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long videoTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isSelected;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxBatchLayerSelectedMediaInfoBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxBatchLayerSelectedMediaInfoBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxBatchLayerSelectedMediaInfoBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxBatchLayerSelectedMediaInfoBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<QZAlbumxBatchLayerSelectedMediaInfoBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QZAlbumxBatchLayerSelectedMediaInfoBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QZAlbumxBatchLayerSelectedMediaInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZAlbumxBatchLayerSelectedMediaInfoBean[] newArray(int size) {
            return new QZAlbumxBatchLayerSelectedMediaInfoBean[size];
        }

        Companion() {
        }
    }

    public QZAlbumxBatchLayerSelectedMediaInfoBean() {
        this.lloc = "";
        this.url = "";
    }

    /* renamed from: a, reason: from getter */
    public final String getLloc() {
        return this.lloc;
    }

    /* renamed from: b, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: c, reason: from getter */
    public final long getVideoTime() {
        return this.videoTime;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lloc = str;
    }

    public final void j(boolean z16) {
        this.isSelected = z16;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final void l(boolean z16) {
        this.isVideo = z16;
    }

    public final void m(long j3) {
        this.videoTime = j3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByte(this.isVideo ? (byte) 1 : (byte) 0);
        parcel.writeString(this.lloc);
        parcel.writeString(this.url);
        parcel.writeLong(this.videoTime);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZAlbumxBatchLayerSelectedMediaInfoBean(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.isVideo = parcel.readByte() != 0;
        String readString = parcel.readString();
        this.lloc = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.url = readString2 != null ? readString2 : "";
        this.videoTime = parcel.readLong();
    }
}
