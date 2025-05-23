package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStFeedCellVisitor;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "d", "I", "a", "()I", "e", "(I)V", "viewNum", "b", "f", "visitorNum", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "Ljava/util/List;", "c", "()Ljava/util/List;", "setVisitors", "(Ljava/util/List;)V", "visitors", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStFeedCellVisitor implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int viewNum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int visitorNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<CommonStUser> visitors;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStFeedCellVisitor$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStFeedCellVisitor;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonStFeedCellVisitor;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonStFeedCellVisitor$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonStFeedCellVisitor> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonStFeedCellVisitor createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonStFeedCellVisitor(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonStFeedCellVisitor[] newArray(int size) {
            return new CommonStFeedCellVisitor[size];
        }

        Companion() {
        }
    }

    public CommonStFeedCellVisitor() {
        this.visitors = new ArrayList();
    }

    /* renamed from: a, reason: from getter */
    public final int getViewNum() {
        return this.viewNum;
    }

    /* renamed from: b, reason: from getter */
    public final int getVisitorNum() {
        return this.visitorNum;
    }

    public final List<CommonStUser> c() {
        return this.visitors;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e(int i3) {
        this.viewNum = i3;
    }

    public final void f(int i3) {
        this.visitorNum = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.viewNum);
        parcel.writeInt(this.visitorNum);
        parcel.writeTypedList(this.visitors);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonStFeedCellVisitor(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.viewNum = parcel.readInt();
        this.visitorNum = parcel.readInt();
        ArrayList createTypedArrayList = parcel.createTypedArrayList(CommonStUser.INSTANCE);
        this.visitors = createTypedArrayList == null ? new ArrayList() : createTypedArrayList;
    }
}
