package com.qzone.reborn.albumx.common.viewmodel;

import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\t\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u000f\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/albumx/common/viewmodel/n;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "isSucceed", "Lcom/qzone/reborn/albumx/common/viewmodel/EditAlbumType;", "b", "Lcom/qzone/reborn/albumx/common/viewmodel/EditAlbumType;", "c", "()Lcom/qzone/reborn/albumx/common/viewmodel/EditAlbumType;", "type", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "<init>", "(ZLcom/qzone/reborn/albumx/common/viewmodel/EditAlbumType;Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.qzone.reborn.albumx.common.viewmodel.n, reason: from toString */
/* loaded from: classes37.dex */
public final /* data */ class EditAlbumResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSucceed;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final EditAlbumType type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final CommonAlbumInfo albumInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String errMsg;

    public EditAlbumResult(boolean z16, EditAlbumType type, CommonAlbumInfo albumInfo, String errMsg) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.isSucceed = z16;
        this.type = type;
        this.albumInfo = albumInfo;
        this.errMsg = errMsg;
    }

    /* renamed from: a, reason: from getter */
    public final CommonAlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    /* renamed from: b, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    /* renamed from: c, reason: from getter */
    public final EditAlbumType getType() {
        return this.type;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsSucceed() {
        return this.isSucceed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.isSucceed;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((r06 * 31) + this.type.hashCode()) * 31) + this.albumInfo.hashCode()) * 31) + this.errMsg.hashCode();
    }

    public String toString() {
        return "EditAlbumResult(isSucceed=" + this.isSucceed + ", type=" + this.type + ", albumInfo=" + this.albumInfo + ", errMsg=" + this.errMsg + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EditAlbumResult)) {
            return false;
        }
        EditAlbumResult editAlbumResult = (EditAlbumResult) other;
        return this.isSucceed == editAlbumResult.isSucceed && this.type == editAlbumResult.type && Intrinsics.areEqual(this.albumInfo, editAlbumResult.albumInfo) && Intrinsics.areEqual(this.errMsg, editAlbumResult.errMsg);
    }

    public /* synthetic */ EditAlbumResult(boolean z16, EditAlbumType editAlbumType, CommonAlbumInfo commonAlbumInfo, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, editAlbumType, commonAlbumInfo, (i3 & 8) != 0 ? "" : str);
    }
}
