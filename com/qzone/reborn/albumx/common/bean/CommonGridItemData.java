package com.qzone.reborn.albumx.common.bean;

import com.qzone.reborn.albumx.common.convert.bean.CommonBatchInfoBanner;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001#B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r\u00a2\u0006\u0004\b!\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010R\"\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010 \u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\u0003\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "", "Lcom/qzone/reborn/albumx/common/bean/a;", "a", "Lcom/qzone/reborn/albumx/common/bean/a;", "b", "()Lcom/qzone/reborn/albumx/common/bean/a;", "batchBean", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData$ItemType;", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData$ItemType;", "d", "()Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData$ItemType;", "itemType", "", "c", "I", "()I", "batchPos", "e", "mediaPos", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "f", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", tl.h.F, "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;)V", "picMedia", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfoBanner;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfoBanner;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfoBanner;", "g", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfoBanner;)V", "banner", "<init>", "(Lcom/qzone/reborn/albumx/common/bean/a;Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData$ItemType;II)V", "ItemType", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonGridItemData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a batchBean;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ItemType itemType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int batchPos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int mediaPos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public CommonStMedia picMedia;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public CommonBatchInfoBanner banner;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData$ItemType;", "", "(Ljava/lang/String;I)V", "HEAD_SECTION_ITEM", "PIC_SECTION_ITEM", "BANNER_SECTION_ITEM", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public enum ItemType {
        HEAD_SECTION_ITEM,
        PIC_SECTION_ITEM,
        BANNER_SECTION_ITEM
    }

    public CommonGridItemData(a batchBean, ItemType itemType, int i3, int i16) {
        Intrinsics.checkNotNullParameter(batchBean, "batchBean");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        this.batchBean = batchBean;
        this.itemType = itemType;
        this.batchPos = i3;
        this.mediaPos = i16;
    }

    public final CommonBatchInfoBanner a() {
        CommonBatchInfoBanner commonBatchInfoBanner = this.banner;
        if (commonBatchInfoBanner != null) {
            return commonBatchInfoBanner;
        }
        Intrinsics.throwUninitializedPropertyAccessException("banner");
        return null;
    }

    /* renamed from: b, reason: from getter */
    public final a getBatchBean() {
        return this.batchBean;
    }

    /* renamed from: c, reason: from getter */
    public final int getBatchPos() {
        return this.batchPos;
    }

    /* renamed from: d, reason: from getter */
    public final ItemType getItemType() {
        return this.itemType;
    }

    /* renamed from: e, reason: from getter */
    public final int getMediaPos() {
        return this.mediaPos;
    }

    public final CommonStMedia f() {
        CommonStMedia commonStMedia = this.picMedia;
        if (commonStMedia != null) {
            return commonStMedia;
        }
        Intrinsics.throwUninitializedPropertyAccessException("picMedia");
        return null;
    }

    public final void g(CommonBatchInfoBanner commonBatchInfoBanner) {
        Intrinsics.checkNotNullParameter(commonBatchInfoBanner, "<set-?>");
        this.banner = commonBatchInfoBanner;
    }

    public final void h(CommonStMedia commonStMedia) {
        Intrinsics.checkNotNullParameter(commonStMedia, "<set-?>");
        this.picMedia = commonStMedia;
    }
}
