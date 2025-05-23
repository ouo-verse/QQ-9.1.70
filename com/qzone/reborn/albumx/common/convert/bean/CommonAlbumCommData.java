package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 02\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b-\u0010.B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b-\u0010/J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR2\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001cj\b\u0012\u0004\u0012\u00020\u0004`\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010,\u001a\b\u0012\u0004\u0012\u00020&0%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b\u0012\u0010)\"\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumCommData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Z", "f", "()Z", "j", "(Z)V", "isMember", "", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "emptyMessage", "b", "k", "normalUpLoad", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", h.F, "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "setRightList", "(Ljava/util/ArrayList;)V", "rightList", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "i", "Ljava/util/List;", "()Ljava/util/List;", "setTimeLineEvents", "(Ljava/util/List;)V", "timeLineEvents", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonAlbumCommData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isMember;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String emptyMessage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean normalUpLoad;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Integer> rightList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List<CommonStTimeLineEvent> timeLineEvents;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumCommData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumCommData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumCommData;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonAlbumCommData$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonAlbumCommData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonAlbumCommData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonAlbumCommData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonAlbumCommData[] newArray(int size) {
            return new CommonAlbumCommData[size];
        }

        Companion() {
        }
    }

    public CommonAlbumCommData() {
        this.emptyMessage = "";
        this.rightList = new ArrayList<>();
        this.timeLineEvents = new ArrayList();
    }

    /* renamed from: a, reason: from getter */
    public final String getEmptyMessage() {
        return this.emptyMessage;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getNormalUpLoad() {
        return this.normalUpLoad;
    }

    public final ArrayList<Integer> c() {
        return this.rightList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final List<CommonStTimeLineEvent> e() {
        return this.timeLineEvents;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsMember() {
        return this.isMember;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.emptyMessage = str;
    }

    public final void j(boolean z16) {
        this.isMember = z16;
    }

    public final void k(boolean z16) {
        this.normalUpLoad = z16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int[] intArray;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByte(this.isMember ? (byte) 1 : (byte) 0);
        parcel.writeString(this.emptyMessage);
        parcel.writeByte(this.normalUpLoad ? (byte) 1 : (byte) 0);
        intArray = CollectionsKt___CollectionsKt.toIntArray(this.rightList);
        parcel.writeIntArray(intArray);
        parcel.writeTypedList(this.timeLineEvents);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonAlbumCommData(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.isMember = parcel.readByte() != 0;
        String readString = parcel.readString();
        this.emptyMessage = readString == null ? "" : readString;
        this.normalUpLoad = parcel.readByte() != 0;
        int[] createIntArray = parcel.createIntArray();
        if (createIntArray != null) {
            for (int i3 : createIntArray) {
                this.rightList.add(Integer.valueOf(i3));
            }
        }
        ArrayList createTypedArrayList = parcel.createTypedArrayList(CommonStTimeLineEvent.INSTANCE);
        this.timeLineEvents = createTypedArrayList == null ? new ArrayList() : createTypedArrayList;
    }
}
