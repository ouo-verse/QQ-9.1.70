package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 )2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b&\u0010'B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b&\u0010(J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0014\"\u0004\b\u0011\u0010\u0016\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLike;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "id", "e", "I", "getCount", "()I", "b", "(I)V", "count", "f", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "status", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", h.F, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "a", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "setPostUser", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;)V", "postUser", "i", "getOwnerStatus", "ownerStatus", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStLike implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String id;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int count;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int status;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private CommonStUser postUser;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int ownerStatus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLike$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLike;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLike;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonStLike$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonStLike> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonStLike createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonStLike(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonStLike[] newArray(int size) {
            return new CommonStLike[size];
        }

        Companion() {
        }
    }

    public CommonStLike() {
        this.id = "";
        this.postUser = new CommonStUser();
    }

    /* renamed from: a, reason: from getter */
    public final CommonStUser getPostUser() {
        return this.postUser;
    }

    public final void b(int i3) {
        this.count = i3;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e(int i3) {
        this.ownerStatus = i3;
    }

    public final void f(int i3) {
        this.status = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeInt(this.count);
        parcel.writeInt(this.status);
        parcel.writeParcelable(this.postUser, flags);
        parcel.writeInt(this.ownerStatus);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonStLike(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.id = readString == null ? "" : readString;
        this.count = parcel.readInt();
        this.status = parcel.readInt();
        CommonStUser commonStUser = (CommonStUser) parcel.readParcelable(CommonStUser.class.getClassLoader());
        this.postUser = commonStUser == null ? new CommonStUser() : commonStUser;
        this.ownerStatus = parcel.readInt();
    }
}
