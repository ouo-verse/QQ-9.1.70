package com.qzone.reborn.intimate.bean.init;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0001(B+\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b$\u0010%B1\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b$\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u0013\u0010#\u001a\u0004\u0018\u00010 8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateUploadAlbumInitBean;", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateInitBean;", "", "spaceId", "Ljava/lang/String;", "getSpaceId", "()Ljava/lang/String;", "setSpaceId", "(Ljava/lang/String;)V", "", "spaceType", "I", "getSpaceType", "()I", "", "isLaunchSelectPhotoPage", "Z", "()Z", "setLaunchSelectPhotoPage", "(Z)V", "", "albumInfoBytes", "[B", "getAlbumInfoBytes", "()[B", "insertSpacePage", "getInsertSpacePage", "setInsertSpacePage", "(I)V", "adId", "getAdId", "setAdId", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "getAlbumInfo", "()Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "albumInfo", "<init>", "(Ljava/lang/String;IZ[B)V", "(Ljava/lang/String;IZLqzone/QZoneBaseAlbumMeta$AlbumInfo;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateUploadAlbumInitBean extends QZoneIntimateInitBean {
    private String adId;
    private final byte[] albumInfoBytes;
    private int insertSpacePage;
    private boolean isLaunchSelectPhotoPage;
    private String spaceId;
    private final int spaceType;

    QZoneIntimateUploadAlbumInitBean(String str, int i3, boolean z16, byte[] bArr) {
        this.spaceId = str;
        this.spaceType = i3;
        this.isLaunchSelectPhotoPage = z16;
        this.albumInfoBytes = bArr;
        this.adId = "";
    }

    public final String getAdId() {
        return this.adId;
    }

    public final QZoneBaseAlbumMeta$AlbumInfo getAlbumInfo() {
        byte[] bArr = this.albumInfoBytes;
        if (bArr == null) {
            return null;
        }
        try {
            return new QZoneBaseAlbumMeta$AlbumInfo().mergeFrom(bArr);
        } catch (Exception e16) {
            RFWLog.fatal("QZoneIntimateUploadAlbumInitBean", RFWLog.USR, e16);
            return null;
        }
    }

    public final byte[] getAlbumInfoBytes() {
        return this.albumInfoBytes;
    }

    public final int getInsertSpacePage() {
        return this.insertSpacePage;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final int getSpaceType() {
        return this.spaceType;
    }

    /* renamed from: isLaunchSelectPhotoPage, reason: from getter */
    public final boolean getIsLaunchSelectPhotoPage() {
        return this.isLaunchSelectPhotoPage;
    }

    public final void setAdId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adId = str;
    }

    public final void setInsertSpacePage(int i3) {
        this.insertSpacePage = i3;
    }

    public final void setLaunchSelectPhotoPage(boolean z16) {
        this.isLaunchSelectPhotoPage = z16;
    }

    public final void setSpaceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceId = str;
    }

    public /* synthetic */ QZoneIntimateUploadAlbumInitBean(String str, int i3, boolean z16, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? -1 : i3, (i16 & 4) != 0 ? true : z16, (i16 & 8) != 0 ? null : qZoneBaseAlbumMeta$AlbumInfo);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneIntimateUploadAlbumInitBean(String spaceId, int i3, boolean z16, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo) {
        this(spaceId, i3, z16, qZoneBaseAlbumMeta$AlbumInfo != null ? qZoneBaseAlbumMeta$AlbumInfo.toByteArray() : null);
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
    }
}
