package com.qzone.reborn.groupalbum.reship.manager;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qqnt.kernel.nativeinterface.QuoteToQunAlbumUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001e\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001e\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\u001e\u0010'\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR\u001e\u0010*\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R\u001e\u0010-\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R\u001e\u00100\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011\u00a8\u00063"}, d2 = {"Lcom/qzone/reborn/groupalbum/reship/manager/GroupAblbumReshipUnit;", "Lcom/tencent/component/app/common/SmartParcelable;", "quoteToQunAlbumUnit", "Lcom/tencent/qqnt/kernel/nativeinterface/QuoteToQunAlbumUnit;", "(Lcom/tencent/qqnt/kernel/nativeinterface/QuoteToQunAlbumUnit;)V", "()V", "dittoUin", "", "getDittoUin", "()Ljava/lang/String;", "setDittoUin", "(Ljava/lang/String;)V", "duration", "", "getDuration", "()I", "setDuration", "(I)V", "height", "getHeight", "setHeight", "mediaId", "getMediaId", "setMediaId", "mediaMd5", "getMediaMd5", "setMediaMd5", "mediaName", "getMediaName", "setMediaName", "mediaSize", "", "getMediaSize", "()J", "setMediaSize", "(J)V", "mediaType", "getMediaType", "setMediaType", "sha1", "getSha1", "setSha1", "storeId", "getStoreId", "setStoreId", "uin", "getUin", "setUin", "width", "getWidth", "setWidth", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class GroupAblbumReshipUnit implements SmartParcelable {

    @NeedParcel
    private String dittoUin;

    @NeedParcel
    private int duration;

    @NeedParcel
    private int height;

    @NeedParcel
    private String mediaId;

    @NeedParcel
    private String mediaMd5;

    @NeedParcel
    private String mediaName;

    @NeedParcel
    private long mediaSize;

    @NeedParcel
    private int mediaType;

    @NeedParcel
    private String sha1;

    @NeedParcel
    private int storeId;

    @NeedParcel
    private long uin;

    @NeedParcel
    private int width;

    public GroupAblbumReshipUnit() {
        this.mediaId = "";
        this.mediaMd5 = "";
        this.dittoUin = "";
        this.sha1 = "";
        this.mediaName = "";
    }

    public final String getDittoUin() {
        return this.dittoUin;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getMediaId() {
        return this.mediaId;
    }

    public final String getMediaMd5() {
        return this.mediaMd5;
    }

    public final String getMediaName() {
        return this.mediaName;
    }

    public final long getMediaSize() {
        return this.mediaSize;
    }

    public final int getMediaType() {
        return this.mediaType;
    }

    public final String getSha1() {
        return this.sha1;
    }

    public final int getStoreId() {
        return this.storeId;
    }

    public final long getUin() {
        return this.uin;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setDittoUin(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dittoUin = str;
    }

    public final void setDuration(int i3) {
        this.duration = i3;
    }

    public final void setHeight(int i3) {
        this.height = i3;
    }

    public final void setMediaId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mediaId = str;
    }

    public final void setMediaMd5(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mediaMd5 = str;
    }

    public final void setMediaName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mediaName = str;
    }

    public final void setMediaSize(long j3) {
        this.mediaSize = j3;
    }

    public final void setMediaType(int i3) {
        this.mediaType = i3;
    }

    public final void setSha1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sha1 = str;
    }

    public final void setStoreId(int i3) {
        this.storeId = i3;
    }

    public final void setUin(long j3) {
        this.uin = j3;
    }

    public final void setWidth(int i3) {
        this.width = i3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupAblbumReshipUnit(QuoteToQunAlbumUnit quoteToQunAlbumUnit) {
        this();
        Intrinsics.checkNotNullParameter(quoteToQunAlbumUnit, "quoteToQunAlbumUnit");
        String str = quoteToQunAlbumUnit.mediaId;
        Intrinsics.checkNotNullExpressionValue(str, "quoteToQunAlbumUnit.mediaId");
        this.mediaId = str;
        String str2 = quoteToQunAlbumUnit.mediaMd5;
        Intrinsics.checkNotNullExpressionValue(str2, "quoteToQunAlbumUnit.mediaMd5");
        this.mediaMd5 = str2;
        this.mediaSize = quoteToQunAlbumUnit.mediaSize;
        this.mediaType = quoteToQunAlbumUnit.mediaType;
        this.uin = quoteToQunAlbumUnit.uin;
        String str3 = quoteToQunAlbumUnit.dittoUin;
        Intrinsics.checkNotNullExpressionValue(str3, "quoteToQunAlbumUnit.dittoUin");
        this.dittoUin = str3;
        String str4 = quoteToQunAlbumUnit.sha1;
        Intrinsics.checkNotNullExpressionValue(str4, "quoteToQunAlbumUnit.sha1");
        this.sha1 = str4;
        String str5 = quoteToQunAlbumUnit.mediaName;
        Intrinsics.checkNotNullExpressionValue(str5, "quoteToQunAlbumUnit.mediaName");
        this.mediaName = str5;
        this.storeId = quoteToQunAlbumUnit.storeId;
        this.width = quoteToQunAlbumUnit.width;
        this.height = quoteToQunAlbumUnit.height;
        this.duration = quoteToQunAlbumUnit.duration;
    }
}
