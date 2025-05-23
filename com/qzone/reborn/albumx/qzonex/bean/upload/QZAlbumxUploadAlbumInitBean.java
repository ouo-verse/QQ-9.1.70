package com.qzone.reborn.albumx.qzonex.bean.upload;

import android.os.Parcel;
import android.os.Parcelable;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.qzonex.base.QZAlbumxInitBean;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001d\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0001JB7\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u00a2\u0006\u0004\bF\u0010GB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\bF\u0010HJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0010\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010#R*\u0010(\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00105\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u0015\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R$\u00107\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\f\u001a\u0004\b8\u0010\u000e\"\u0004\b9\u0010:R$\u0010;\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\f\u001a\u0004\b<\u0010\u000e\"\u0004\b=\u0010:R\"\u0010>\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u0015\u001a\u0004\b>\u0010\u0016\"\u0004\b?\u0010\u0018R$\u0010@\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010\f\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010:R$\u0010C\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010\f\u001a\u0004\bD\u0010\u000e\"\u0004\bE\u0010:\u00a8\u0006K"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "Lcom/qzone/reborn/albumx/qzonex/base/QZAlbumxInitBean;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "uin", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "albumType", "I", "getAlbumType", "()I", "", "isLaunchSelectPhotoPage", "Z", "()Z", "setLaunchSelectPhotoPage", "(Z)V", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "getAlbumInfo", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "setAlbumInfo", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;)V", IProfileCardConst.KEY_FROM_TYPE, "getFromType", "setFromType", "(I)V", "requestCode", "getRequestCode", "setRequestCode", "", "selectImageList", "Ljava/util/List;", "getSelectImageList", "()Ljava/util/List;", "setSelectImageList", "(Ljava/util/List;)V", "", "launchTime", "J", "getLaunchTime", "()J", "setLaunchTime", "(J)V", "isHideAddBtn", "setHideAddBtn", "photoRepairTaskId", "getPhotoRepairTaskId", "setPhotoRepairTaskId", "(Ljava/lang/String;)V", "photoRepairSrUrl", "getPhotoRepairSrUrl", "setPhotoRepairSrUrl", "isPhotoRepairByOpr", "setPhotoRepairByOpr", "classifyId", "getClassifyId", "setClassifyId", "tianShuAdId", "getTianShuAdId", "setTianShuAdId", "<init>", "(Ljava/lang/String;IZLcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;I)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxUploadAlbumInitBean extends QZAlbumxInitBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CommonAlbumInfo albumInfo;
    private final int albumType;
    private String classifyId;
    private int fromType;
    private boolean isHideAddBtn;
    private boolean isLaunchSelectPhotoPage;
    private boolean isPhotoRepairByOpr;
    private long launchTime;
    private String photoRepairSrUrl;
    private String photoRepairTaskId;
    private int requestCode;
    private List<String> selectImageList;
    private String tianShuAdId;
    private final String uin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<QZAlbumxUploadAlbumInitBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QZAlbumxUploadAlbumInitBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QZAlbumxUploadAlbumInitBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZAlbumxUploadAlbumInitBean[] newArray(int size) {
            return new QZAlbumxUploadAlbumInitBean[size];
        }

        Companion() {
        }
    }

    public /* synthetic */ QZAlbumxUploadAlbumInitBean(String str, int i3, boolean z16, CommonAlbumInfo commonAlbumInfo, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i17 & 4) != 0 ? true : z16, (i17 & 8) != 0 ? null : commonAlbumInfo, (i17 & 16) != 0 ? 0 : i16);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final CommonAlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    public final int getAlbumType() {
        return this.albumType;
    }

    public final String getClassifyId() {
        return this.classifyId;
    }

    public final int getFromType() {
        return this.fromType;
    }

    @Override // com.qzone.reborn.albumx.qzonex.base.QZAlbumxInitBean
    public long getLaunchTime() {
        return this.launchTime;
    }

    public final String getPhotoRepairSrUrl() {
        return this.photoRepairSrUrl;
    }

    public final String getPhotoRepairTaskId() {
        return this.photoRepairTaskId;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final List<String> getSelectImageList() {
        return this.selectImageList;
    }

    public final String getTianShuAdId() {
        return this.tianShuAdId;
    }

    @Override // com.qzone.reborn.albumx.qzonex.base.QZAlbumxInitBean
    public String getUin() {
        return this.uin;
    }

    /* renamed from: isHideAddBtn, reason: from getter */
    public final boolean getIsHideAddBtn() {
        return this.isHideAddBtn;
    }

    /* renamed from: isLaunchSelectPhotoPage, reason: from getter */
    public final boolean getIsLaunchSelectPhotoPage() {
        return this.isLaunchSelectPhotoPage;
    }

    /* renamed from: isPhotoRepairByOpr, reason: from getter */
    public final boolean getIsPhotoRepairByOpr() {
        return this.isPhotoRepairByOpr;
    }

    public final void setAlbumInfo(CommonAlbumInfo commonAlbumInfo) {
        this.albumInfo = commonAlbumInfo;
    }

    public final void setClassifyId(String str) {
        this.classifyId = str;
    }

    public final void setFromType(int i3) {
        this.fromType = i3;
    }

    public final void setHideAddBtn(boolean z16) {
        this.isHideAddBtn = z16;
    }

    public final void setLaunchSelectPhotoPage(boolean z16) {
        this.isLaunchSelectPhotoPage = z16;
    }

    @Override // com.qzone.reborn.albumx.qzonex.base.QZAlbumxInitBean
    public void setLaunchTime(long j3) {
        this.launchTime = j3;
    }

    public final void setPhotoRepairByOpr(boolean z16) {
        this.isPhotoRepairByOpr = z16;
    }

    public final void setPhotoRepairSrUrl(String str) {
        this.photoRepairSrUrl = str;
    }

    public final void setPhotoRepairTaskId(String str) {
        this.photoRepairTaskId = str;
    }

    public final void setRequestCode(int i3) {
        this.requestCode = i3;
    }

    public final void setSelectImageList(List<String> list) {
        this.selectImageList = list;
    }

    public final void setTianShuAdId(String str) {
        this.tianShuAdId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getUin());
        parcel.writeInt(this.albumType);
        parcel.writeByte(this.isLaunchSelectPhotoPage ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.albumInfo, flags);
        parcel.writeInt(this.fromType);
        parcel.writeInt(this.requestCode);
        parcel.writeStringList(this.selectImageList);
        parcel.writeLong(getLaunchTime());
        parcel.writeByte(this.isHideAddBtn ? (byte) 1 : (byte) 0);
        parcel.writeString(this.photoRepairTaskId);
        parcel.writeString(this.photoRepairSrUrl);
        parcel.writeByte(this.isPhotoRepairByOpr ? (byte) 1 : (byte) 0);
        parcel.writeString(this.classifyId);
        parcel.writeString(this.tianShuAdId);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZAlbumxUploadAlbumInitBean(String uin, int i3, boolean z16, CommonAlbumInfo commonAlbumInfo, int i16) {
        super(uin);
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.albumType = i3;
        this.isLaunchSelectPhotoPage = z16;
        this.albumInfo = commonAlbumInfo;
        this.fromType = i16;
        this.requestCode = -1;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QZAlbumxUploadAlbumInitBean(Parcel parcel) {
        this(r0 == null ? "" : r0, parcel.readInt(), parcel.readByte() != 0, (CommonAlbumInfo) parcel.readParcelable(CommonAlbumInfo.class.getClassLoader()), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.requestCode = parcel.readInt();
        this.selectImageList = parcel.createStringArrayList();
        setLaunchTime(parcel.readLong());
        this.isHideAddBtn = parcel.readByte() != 0;
        this.photoRepairTaskId = parcel.readString();
        this.photoRepairSrUrl = parcel.readString();
        this.isPhotoRepairByOpr = parcel.readByte() != 0;
        this.classifyId = parcel.readString();
        this.tianShuAdId = parcel.readString();
    }
}
