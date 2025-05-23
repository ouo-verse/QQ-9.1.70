package com.qzone.reborn.feedpro.utils;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0010\u0010\b\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0010\u0010\t\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feed", "", "f", "", "b", "a", "e", "c", "d", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class m {
    public static final String b(CommonFeed commonFeed) {
        if ((commonFeed != null ? commonFeed.getCellCommon() : null) == null) {
            String string = BaseApplication.getContext().getString(R.string.gey);
            Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026zone_feed_delete_default)");
            return string;
        }
        if (!CommonFeedExtKt.isAlbumFeed(commonFeed) && c(commonFeed)) {
            String string2 = BaseApplication.getContext().getString(R.string.gf8);
            Intrinsics.checkNotNullExpressionValue(string2, "getContext().getString(R\u2026.qzone_feed_delete_video)");
            return string2;
        }
        if (CommonFeedExtKt.isBlogFeedAll(commonFeed)) {
            String a16 = com.qzone.util.l.a(R.string.gez);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_feed_delete_diary)");
            return a16;
        }
        if (CommonFeedExtKt.isAlbumFeed(commonFeed)) {
            if (e(commonFeed)) {
                String a17 = com.qzone.util.l.a(R.string.gf9);
                Intrinsics.checkNotNullExpressionValue(a17, "{\n            HardCodeUt\u2026ete_video_feed)\n        }");
                return a17;
            }
            if (xd.c.v(commonFeed)) {
                String a18 = com.qzone.util.l.a(R.string.f173005gf1);
                Intrinsics.checkNotNullExpressionValue(a18, "{\n            HardCodeUt\u2026lete_mix_batch)\n        }");
                return a18;
            }
            String a19 = com.qzone.util.l.a(R.string.f173007gf3);
            Intrinsics.checkNotNullExpressionValue(a19, "{\n            HardCodeUt\u2026te_photo_batch)\n        }");
            return a19;
        }
        if (CommonFeedExtKt.isShuoShuoFeed(commonFeed)) {
            String a26 = com.qzone.util.l.a(R.string.gf7);
            Intrinsics.checkNotNullExpressionValue(a26, "qqStr(R.string.qzone_feed_delete_shuoshuo)");
            return a26;
        }
        if (CommonFeedExtKt.isShareFeed(commonFeed)) {
            String a27 = com.qzone.util.l.a(R.string.gf6);
            Intrinsics.checkNotNullExpressionValue(a27, "qqStr(R.string.qzone_feed_delete_share)");
            return a27;
        }
        String a28 = com.qzone.util.l.a(R.string.gey);
        Intrinsics.checkNotNullExpressionValue(a28, "qqStr(R.string.qzone_feed_delete_default)");
        return a28;
    }

    public static final boolean f(CommonFeed commonFeed) {
        if ((commonFeed != null ? commonFeed.getCellCommon() : null) == null) {
            return false;
        }
        if (commonFeed != null && CommonFeedExtKt.isForwardFeed(commonFeed)) {
            return false;
        }
        if (commonFeed != null && CommonFeedExtKt.isShareFeed(commonFeed)) {
            return false;
        }
        if (commonFeed != null && xd.c.m(commonFeed)) {
            return false;
        }
        if (commonFeed != null && CommonFeedExtKt.isBlogFeedAll(commonFeed)) {
            return false;
        }
        if (commonFeed != null && CommonFeedExtKt.isAlbumFeed(commonFeed)) {
            return true;
        }
        String a16 = a(commonFeed);
        return !(a16 == null || a16.length() == 0);
    }

    public static final String a(CommonFeed commonFeed) {
        CommonCellMedia cellMedia;
        List<CommonMedia> mediaItems;
        boolean z16 = false;
        if (commonFeed != null && (cellMedia = commonFeed.getCellMedia()) != null && (mediaItems = cellMedia.getMediaItems()) != null && mediaItems.isEmpty()) {
            z16 = true;
        }
        if (!z16 && e(commonFeed)) {
            String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DEL_MEDIA_FILE_DIALOG_ONLY_VIDEO_MSG, QzoneConfig.DEFAULT_DEL_MEDIA_FILE_DIALOG_ONLY_VIDEO_MSG);
            Intrinsics.checkNotNullExpressionValue(config, "getInstance()\n          \u2026Y_VIDEO_MSG\n            )");
            return config;
        }
        if (d(commonFeed)) {
            String config2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DEL_MEDIA_FILE_DIALOG_ONLY_PIC_MSG, QzoneConfig.DEFAULT_DEL_MEDIA_FILE_DIALOG_ONLY_PIC_MSG);
            Intrinsics.checkNotNullExpressionValue(config2, "getInstance()\n          \u2026NLY_PIC_MSG\n            )");
            return config2;
        }
        if (xd.c.v(commonFeed)) {
            String config3 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DEL_MEDIA_FILE_DIALOG_MIX_VIDEO_PIC_MSG, QzoneConfig.DEFAULT_DEL_MEDIA_FILE_DIALOG_MIX_VIDEO_PIC_MSG);
            Intrinsics.checkNotNullExpressionValue(config3, "getInstance()\n          \u2026DEO_PIC_MSG\n            )");
            return config3;
        }
        return "";
    }

    public static final boolean c(CommonFeed commonFeed) {
        CommonCellMedia cellMedia;
        if (commonFeed == null || (cellMedia = commonFeed.getCellMedia()) == null || cellMedia.getMediaItems().isEmpty()) {
            return false;
        }
        Iterator<T> it = cellMedia.getMediaItems().iterator();
        while (it.hasNext()) {
            if (xd.c.z((CommonMedia) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static final boolean d(CommonFeed commonFeed) {
        CommonCellMedia cellMedia;
        if (commonFeed == null || (cellMedia = commonFeed.getCellMedia()) == null || cellMedia.getMediaItems().isEmpty()) {
            return false;
        }
        Iterator<T> it = cellMedia.getMediaItems().iterator();
        while (it.hasNext()) {
            if (!xd.c.s((CommonMedia) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final boolean e(CommonFeed commonFeed) {
        CommonCellMedia cellMedia;
        if (commonFeed == null || (cellMedia = commonFeed.getCellMedia()) == null || cellMedia.getMediaItems().isEmpty()) {
            return false;
        }
        Iterator<T> it = cellMedia.getMediaItems().iterator();
        while (it.hasNext()) {
            if (!xd.c.z((CommonMedia) it.next())) {
                return false;
            }
        }
        return true;
    }
}
