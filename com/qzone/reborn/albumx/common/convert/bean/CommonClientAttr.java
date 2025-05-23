package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonClientAttr;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "d", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "b", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "e", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;)V", QCircleAlphaUserReporter.KEY_USER, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonUinAttr;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonUinAttr;", "a", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonUinAttr;", "c", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonUinAttr;)V", "attr", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonClientAttr implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CommonStUser user;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private CommonUinAttr attr;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonClientAttr$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonClientAttr;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonClientAttr;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonClientAttr$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonClientAttr> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonClientAttr createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonClientAttr(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonClientAttr[] newArray(int size) {
            return new CommonClientAttr[size];
        }

        Companion() {
        }
    }

    public CommonClientAttr() {
        this.user = new CommonStUser();
        this.attr = new CommonUinAttr();
    }

    /* renamed from: a, reason: from getter */
    public final CommonUinAttr getAttr() {
        return this.attr;
    }

    /* renamed from: b, reason: from getter */
    public final CommonStUser getUser() {
        return this.user;
    }

    public final void c(CommonUinAttr commonUinAttr) {
        Intrinsics.checkNotNullParameter(commonUinAttr, "<set-?>");
        this.attr = commonUinAttr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e(CommonStUser commonStUser) {
        Intrinsics.checkNotNullParameter(commonStUser, "<set-?>");
        this.user = commonStUser;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.user, flags);
        parcel.writeParcelable(this.attr, flags);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonClientAttr(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        CommonStUser commonStUser = (CommonStUser) parcel.readParcelable(CommonStUser.class.getClassLoader());
        this.user = commonStUser == null ? new CommonStUser() : commonStUser;
        CommonUinAttr commonUinAttr = (CommonUinAttr) parcel.readParcelable(CommonUinAttr.class.getClassLoader());
        this.attr = commonUinAttr == null ? new CommonUinAttr() : commonUinAttr;
    }
}
