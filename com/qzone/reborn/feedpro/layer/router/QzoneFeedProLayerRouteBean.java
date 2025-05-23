package com.qzone.reborn.feedpro.layer.router;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o9.a;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0016\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001OB\u0007\u00a2\u0006\u0004\bK\u0010LB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\bK\u0010MJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016R2\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\u001aR\"\u0010*\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\"\u0010.\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\"\u00101\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR\"\u00104\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u0016\u001a\u0004\b3\u0010\u0018\"\u0004\b\r\u0010\u001aR\"\u00108\u001a\u0002058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010?\u001a\u0002058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u00107\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R\"\u0010C\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010\u001d\u001a\u0004\bA\u0010\u001f\"\u0004\bB\u0010!R\"\u0010G\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010\u001d\u001a\u0004\bE\u0010\u001f\"\u0004\bF\u0010!R\"\u0010J\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010\u0016\u001a\u0004\bI\u0010\u0018\"\u0004\b\u0015\u0010\u001a\u00a8\u0006P"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerRouteBean;", "Lo9/a;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/util/ArrayList;", "y", "(Ljava/util/ArrayList;)V", "extraInfoBeanList", "", "D", "Ljava/lang/String;", "getRightAttachInfo", "()Ljava/lang/String;", "setRightAttachInfo", "(Ljava/lang/String;)V", "rightAttachInfo", "E", "I", "getRightBoundIndex", "()I", "setRightBoundIndex", "(I)V", "rightBoundIndex", UserInfo.SEX_FEMALE, "p", HippyTKDListViewAdapter.X, "contextHashCode", "G", "r", "setFeedId", "feedId", "H", "t", "setUfKey", "ufKey", "u", "setUgcId", "ugcId", "J", ReportConstant.COSTREPORT_PREFIX, "likeKey", "", "K", "Z", "isAlbumFeed", "()Z", "w", "(Z)V", "L", "getFeedLikeStatus", "B", "feedLikeStatus", "M", "getFeedLikeNum", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "feedLikeNum", "N", "getFeedCommentNum", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "feedCommentNum", "P", "v", "uploadUser", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QzoneFeedProLayerRouteBean extends a implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private ArrayList<QzoneFeedProLayerExtraInfoBean> extraInfoBeanList;

    /* renamed from: D, reason: from kotlin metadata */
    private String rightAttachInfo;

    /* renamed from: E, reason: from kotlin metadata */
    private int rightBoundIndex;

    /* renamed from: F, reason: from kotlin metadata */
    private String contextHashCode;

    /* renamed from: G, reason: from kotlin metadata */
    private String feedId;

    /* renamed from: H, reason: from kotlin metadata */
    private String ufKey;

    /* renamed from: I, reason: from kotlin metadata */
    private String ugcId;

    /* renamed from: J, reason: from kotlin metadata */
    private String likeKey;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isAlbumFeed;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean feedLikeStatus;

    /* renamed from: M, reason: from kotlin metadata */
    private int feedLikeNum;

    /* renamed from: N, reason: from kotlin metadata */
    private int feedCommentNum;

    /* renamed from: P, reason: from kotlin metadata */
    private String uploadUser;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerRouteBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerRouteBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerRouteBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerRouteBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<QzoneFeedProLayerRouteBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QzoneFeedProLayerRouteBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QzoneFeedProLayerRouteBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QzoneFeedProLayerRouteBean[] newArray(int size) {
            return new QzoneFeedProLayerRouteBean[size];
        }

        Companion() {
        }
    }

    public QzoneFeedProLayerRouteBean() {
        this.extraInfoBeanList = new ArrayList<>();
        this.rightAttachInfo = "";
        this.contextHashCode = "";
        this.feedId = "";
        this.ufKey = "";
        this.ugcId = "";
        this.likeKey = "";
        this.uploadUser = "";
    }

    public final void A(int i3) {
        this.feedLikeNum = i3;
    }

    public final void B(boolean z16) {
        this.feedLikeStatus = z16;
    }

    public final void C(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.likeKey = str;
    }

    public final void D(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uploadUser = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: p, reason: from getter */
    public final String getContextHashCode() {
        return this.contextHashCode;
    }

    public final ArrayList<QzoneFeedProLayerExtraInfoBean> q() {
        return this.extraInfoBeanList;
    }

    /* renamed from: r, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: s, reason: from getter */
    public final String getLikeKey() {
        return this.likeKey;
    }

    /* renamed from: t, reason: from getter */
    public final String getUfKey() {
        return this.ufKey;
    }

    /* renamed from: u, reason: from getter */
    public final String getUgcId() {
        return this.ugcId;
    }

    /* renamed from: v, reason: from getter */
    public final String getUploadUser() {
        return this.uploadUser;
    }

    public final void w(boolean z16) {
        this.isAlbumFeed = z16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeTypedList(this.extraInfoBeanList);
        parcel.writeString(this.rightAttachInfo);
        parcel.writeInt(this.rightBoundIndex);
        parcel.writeString(this.contextHashCode);
        parcel.writeString(this.feedId);
        parcel.writeString(this.ufKey);
        parcel.writeString(this.ugcId);
        parcel.writeString(this.likeKey);
        parcel.writeByte(this.isAlbumFeed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.feedLikeStatus ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.feedLikeNum);
        parcel.writeInt(this.feedCommentNum);
        parcel.writeString(this.uploadUser);
    }

    public final void x(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.contextHashCode = str;
    }

    public final void y(ArrayList<QzoneFeedProLayerExtraInfoBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.extraInfoBeanList = arrayList;
    }

    public final void z(int i3) {
        this.feedCommentNum = i3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProLayerRouteBean(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        ArrayList<QzoneFeedProLayerExtraInfoBean> createTypedArrayList = parcel.createTypedArrayList(QzoneFeedProLayerExtraInfoBean.INSTANCE);
        this.extraInfoBeanList = createTypedArrayList == null ? new ArrayList<>() : createTypedArrayList;
        String readString = parcel.readString();
        this.rightAttachInfo = readString == null ? "" : readString;
        this.rightBoundIndex = parcel.readInt();
        String readString2 = parcel.readString();
        this.contextHashCode = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.feedId = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.ufKey = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.ugcId = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        this.likeKey = readString6 == null ? "" : readString6;
        this.isAlbumFeed = parcel.readByte() != 0;
        this.feedLikeStatus = parcel.readByte() != 0;
        this.feedLikeNum = parcel.readInt();
        this.feedCommentNum = parcel.readInt();
        String readString7 = parcel.readString();
        this.uploadUser = readString7 != null ? readString7 : "";
    }
}
