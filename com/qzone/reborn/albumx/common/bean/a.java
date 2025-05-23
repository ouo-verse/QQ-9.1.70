package com.qzone.reborn.albumx.common.bean;

import com.qzone.reborn.albumx.common.convert.bean.CommonBatchInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonBatchInfoBanner;
import com.qzone.reborn.albumx.common.convert.bean.CommonStCommonExt;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010#R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0003\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0014\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0013\u0010\u000eR$\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u0010\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/a;", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfo;", "a", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfo;", "d", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfo;", "batchInfo", "", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "timeId", "c", "g", "albumId", tl.h.F, AEEditorConstants.ALBUMNAME, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "e", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "j", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;)V", "commonExt", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfoBanner;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfoBanner;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfoBanner;", "i", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfoBanner;)V", "bannerInfo", "<init>", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfo;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CommonBatchInfo batchInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String timeId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String albumId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String albumName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private CommonStCommonExt commonExt;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CommonBatchInfoBanner bannerInfo;

    public a(CommonBatchInfo batchInfo) {
        Intrinsics.checkNotNullParameter(batchInfo, "batchInfo");
        this.batchInfo = batchInfo;
        this.timeId = "";
        this.albumId = "";
        this.albumName = "";
        this.bannerInfo = new CommonBatchInfoBanner();
    }

    /* renamed from: a, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: b, reason: from getter */
    public final String getAlbumName() {
        return this.albumName;
    }

    /* renamed from: c, reason: from getter */
    public final CommonBatchInfoBanner getBannerInfo() {
        return this.bannerInfo;
    }

    /* renamed from: d, reason: from getter */
    public final CommonBatchInfo getBatchInfo() {
        return this.batchInfo;
    }

    /* renamed from: e, reason: from getter */
    public final CommonStCommonExt getCommonExt() {
        return this.commonExt;
    }

    /* renamed from: f, reason: from getter */
    public final String getTimeId() {
        return this.timeId;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumName = str;
    }

    public final void i(CommonBatchInfoBanner commonBatchInfoBanner) {
        Intrinsics.checkNotNullParameter(commonBatchInfoBanner, "<set-?>");
        this.bannerInfo = commonBatchInfoBanner;
    }

    public final void j(CommonStCommonExt commonStCommonExt) {
        this.commonExt = commonStCommonExt;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeId = str;
    }
}
