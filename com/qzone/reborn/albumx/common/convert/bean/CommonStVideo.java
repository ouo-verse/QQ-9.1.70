package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 92\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b6\u00107B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b6\u00108J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u0016\u0010\u001aR(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0011\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStVideo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "id", "e", "b", "k", "url", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "f", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "a", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;)V", "cover", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicSpecUrlEntry;", h.F, "Ljava/util/List;", "()Ljava/util/List;", "setVideoUrl", "(Ljava/util/List;)V", AppConstants.Key.KEY_QZONE_VIDEO_URL, "i", "I", "getWidth", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "width", "getHeight", "g", "height", "", BdhLogUtil.LogTag.Tag_Conn, "J", "c", "()J", "l", "(J)V", QFSEdgeItem.KEY_VIDEO_TIME, "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStVideo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private long videoTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String id;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String url;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CommonStImage cover;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private List<CommonStPicSpecUrlEntry> videoUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int width;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int height;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStVideo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStVideo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonStVideo;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonStVideo$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonStVideo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonStVideo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonStVideo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonStVideo[] newArray(int size) {
            return new CommonStVideo[size];
        }

        Companion() {
        }
    }

    public CommonStVideo() {
        this.id = "";
        this.url = "";
        this.cover = new CommonStImage();
        this.videoUrl = new ArrayList();
    }

    /* renamed from: a, reason: from getter */
    public final CommonStImage getCover() {
        return this.cover;
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

    public final List<CommonStPicSpecUrlEntry> e() {
        return this.videoUrl;
    }

    public final void f(CommonStImage commonStImage) {
        Intrinsics.checkNotNullParameter(commonStImage, "<set-?>");
        this.cover = commonStImage;
    }

    public final void g(int i3) {
        this.height = i3;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getId() {
        return this.id;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final void l(long j3) {
        this.videoTime = j3;
    }

    public final void m(int i3) {
        this.width = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.url);
        parcel.writeParcelable(this.cover, flags);
        parcel.writeTypedList(this.videoUrl);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeLong(this.videoTime);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonStVideo(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.id = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.url = readString2 != null ? readString2 : "";
        CommonStImage commonStImage = (CommonStImage) parcel.readParcelable(CommonStImage.class.getClassLoader());
        this.cover = commonStImage == null ? new CommonStImage() : commonStImage;
        ArrayList createTypedArrayList = parcel.createTypedArrayList(CommonStPicSpecUrlEntry.INSTANCE);
        this.videoUrl = createTypedArrayList == null ? new ArrayList() : createTypedArrayList;
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.videoTime = parcel.readLong();
    }
}
