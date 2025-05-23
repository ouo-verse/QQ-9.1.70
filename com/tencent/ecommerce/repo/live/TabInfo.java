package com.tencent.ecommerce.repo.live;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001\u0019BA\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u000e\u0012\u0006\u0010\"\u001a\u00020\u000e\u0012\u0006\u0010$\u001a\u00020\u000e\u0012\b\b\u0002\u0010(\u001a\u00020\u0004\u00a2\u0006\u0004\b)\u0010*B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b)\u0010+B\t\b\u0016\u00a2\u0006\u0004\b)\u0010,J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010$\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001c\u00a8\u0006."}, d2 = {"Lcom/tencent/ecommerce/repo/live/TabInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "d", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "id", "e", "Ljava/lang/String;", "name", "f", "I", "a", "()I", "c", "(I)V", "total", tl.h.F, "Z", "allowEdit", "i", "isAnchored", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "hasSearch", BdhLogUtil.LogTag.Tag_Conn, "getPositionInList", "b", "positionInList", "<init>", "(Lcom/tencent/ecommerce/biz/live/LiveTabId;Ljava/lang/String;IZZZI)V", "(Landroid/os/Parcel;)V", "()V", "CREATOR", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class TabInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private int positionInList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final LiveTabId id;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int total;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean allowEdit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isAnchored;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean hasSearch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/repo/live/TabInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/ecommerce/repo/live/TabInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/ecommerce/repo/live/TabInfo;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.live.TabInfo$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion implements Parcelable.Creator<TabInfo> {
        Companion() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TabInfo createFromParcel(Parcel parcel) {
            return new TabInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TabInfo[] newArray(int size) {
            return new TabInfo[size];
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TabInfo(LiveTabId liveTabId, String str, int i3, boolean z16, boolean z17, boolean z18, int i16) {
        this.id = liveTabId;
        this.name = str;
        this.total = i3;
        this.allowEdit = z16;
        this.isAnchored = z17;
        this.hasSearch = z18;
        this.positionInList = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public final void b(int i3) {
        this.positionInList = i3;
    }

    public final void c(int i3) {
        this.total = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        LiveTabId liveTabId = this.id;
        int hashCode = (liveTabId != null ? liveTabId.hashCode() : 0) * 31;
        String str = this.name;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.total) * 31;
        boolean z16 = this.allowEdit;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        boolean z17 = this.isAnchored;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z18 = this.hasSearch;
        return ((i18 + (z18 ? 1 : z18 ? 1 : 0)) * 31) + this.positionInList;
    }

    public String toString() {
        return "TabInfo(id=" + this.id + ", name=" + this.name + ", total=" + this.total + ", allowEdit=" + this.allowEdit + ", isAnchored=" + this.isAnchored + ", hasSearch=" + this.hasSearch + ", positionInList=" + this.positionInList + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(this.id.getValue());
        parcel.writeString(this.name);
        parcel.writeInt(this.total);
        parcel.writeByte(this.allowEdit ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isAnchored ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.hasSearch ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.positionInList);
    }

    public /* synthetic */ TabInfo(LiveTabId liveTabId, String str, int i3, boolean z16, boolean z17, boolean z18, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(liveTabId, str, i3, z16, z17, z18, (i17 & 64) != 0 ? -1 : i16);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TabInfo(Parcel parcel) {
        this(r3, r0 == null ? "" : r0, parcel.readInt(), parcel.readByte() != r2, parcel.readByte() != r2, parcel.readByte() != r2, parcel.readInt());
        LiveTabId a16 = LiveTabId.INSTANCE.a(parcel.readInt());
        String readString = parcel.readString();
        byte b16 = (byte) 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabInfo)) {
            return false;
        }
        TabInfo tabInfo = (TabInfo) other;
        return Intrinsics.areEqual(this.id, tabInfo.id) && Intrinsics.areEqual(this.name, tabInfo.name) && this.total == tabInfo.total && this.allowEdit == tabInfo.allowEdit && this.isAnchored == tabInfo.isAnchored && this.hasSearch == tabInfo.hasSearch && this.positionInList == tabInfo.positionInList;
    }

    public TabInfo() {
        this(LiveTabId.LIVE_TAB_PRODUCT, "\u6a71\u7a97\u5546\u54c1", 0, false, false, false, 0, 64, null);
    }
}
