package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\"\u0010#B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b \u0010\u0010\u00a8\u0006&"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonEntry;", "d", "Ljava/util/List;", "c", "()Ljava/util/List;", "setMapInfo", "(Ljava/util/List;)V", ThirdPartyMiniApiImpl.KEY_MAP_INFO, "", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "attachInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonBytesEntry;", "b", "setMapBytesInfo", "mapBytesInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUserAccountEntry;", h.F, "setMapUserAccount", "mapUserAccount", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStCommonExt implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<CommonEntry> mapInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String attachInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<CommonBytesEntry> mapBytesInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private List<CommonStUserAccountEntry> mapUserAccount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonStCommonExt$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonStCommonExt> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonStCommonExt createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonStCommonExt(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonStCommonExt[] newArray(int size) {
            return new CommonStCommonExt[size];
        }

        Companion() {
        }
    }

    public CommonStCommonExt() {
        this.mapInfo = new ArrayList();
        this.attachInfo = "";
        this.mapBytesInfo = new ArrayList();
        this.mapUserAccount = new ArrayList();
    }

    /* renamed from: a, reason: from getter */
    public final String getAttachInfo() {
        return this.attachInfo;
    }

    public final List<CommonBytesEntry> b() {
        return this.mapBytesInfo;
    }

    public final List<CommonEntry> c() {
        return this.mapInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final List<CommonStUserAccountEntry> e() {
        return this.mapUserAccount;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attachInfo = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeTypedList(this.mapInfo);
        parcel.writeString(this.attachInfo);
        parcel.writeTypedList(this.mapBytesInfo);
        parcel.writeTypedList(this.mapUserAccount);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonStCommonExt(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        ArrayList createTypedArrayList = parcel.createTypedArrayList(CommonEntry.INSTANCE);
        this.mapInfo = createTypedArrayList == null ? new ArrayList() : createTypedArrayList;
        String readString = parcel.readString();
        this.attachInfo = readString == null ? "" : readString;
        ArrayList createTypedArrayList2 = parcel.createTypedArrayList(CommonBytesEntry.INSTANCE);
        this.mapBytesInfo = createTypedArrayList2 == null ? new ArrayList() : createTypedArrayList2;
        ArrayList createTypedArrayList3 = parcel.createTypedArrayList(CommonStUserAccountEntry.INSTANCE);
        this.mapUserAccount = createTypedArrayList3 == null ? new ArrayList() : createTypedArrayList3;
    }
}
