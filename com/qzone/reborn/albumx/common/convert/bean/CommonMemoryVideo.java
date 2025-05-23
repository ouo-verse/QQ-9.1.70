package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u0000 .2\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b+\u0010,B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\f\u001a\u0004\b\"\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\f\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\f\u001a\u0004\b(\u0010\u000e\"\u0004\b)\u0010\u0010\u00a8\u0006/"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonMemoryVideo;", "Landroid/os/Parcelable;", "", "toString", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "templateId", "e", "getVideoId", "l", "videoId", "f", "a", "coverUrl", "", h.F, "Z", "getViewed", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "viewed", "i", "b", WadlProxyConsts.KEY_JUMP_URL, "getTitle", "k", "title", BdhLogUtil.LogTag.Tag_Conn, "getSubTitle", "g", QQWinkConstants.TAB_SUBTITLE, "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonMemoryVideo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private String subTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String templateId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String videoId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String coverUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean viewed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String jumpUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String title;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonMemoryVideo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMemoryVideo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonMemoryVideo;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonMemoryVideo$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonMemoryVideo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonMemoryVideo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonMemoryVideo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonMemoryVideo[] newArray(int size) {
            return new CommonMemoryVideo[size];
        }

        Companion() {
        }
    }

    public CommonMemoryVideo() {
        this.templateId = "";
        this.videoId = "";
        this.coverUrl = "";
        this.jumpUrl = "";
        this.title = "";
        this.subTitle = "";
    }

    /* renamed from: a, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: c, reason: from getter */
    public final String getTemplateId() {
        return this.templateId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverUrl = str;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpUrl = str;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitle = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.templateId = str;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoId = str;
    }

    public final void m(boolean z16) {
        this.viewed = z16;
    }

    public String toString() {
        return "CommonMemoryVideo(templateId:" + this.templateId + "| videoId:" + this.videoId + "| coverUrl:" + this.coverUrl + "| viewed:" + this.viewed + "| jumpUrl:" + this.jumpUrl + "| title:" + this.title + "| subTitle:" + this.subTitle + "| )";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.templateId);
        parcel.writeString(this.videoId);
        parcel.writeString(this.coverUrl);
        parcel.writeInt(this.viewed ? 1 : 0);
        parcel.writeString(this.jumpUrl);
        parcel.writeString(this.title);
        parcel.writeString(this.subTitle);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonMemoryVideo(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.templateId = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.videoId = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.coverUrl = readString3 == null ? "" : readString3;
        this.viewed = parcel.readInt() == 1;
        String readString4 = parcel.readString();
        this.jumpUrl = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.title = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        this.subTitle = readString6 != null ? readString6 : "";
    }
}
