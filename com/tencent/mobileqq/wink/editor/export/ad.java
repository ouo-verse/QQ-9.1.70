package com.tencent.mobileqq.wink.editor.export;

import com.google.gson.JsonObject;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.tav.core.AssetExtension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0088\u0001\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u001a&\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014\u001a\u0016\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/model/WinkExportParams;", "winkExportParams", "", "eventId", "", "retCode", "desc", "ext1", "ext2", "ext3", "ext4", "ext5", "ext6", "Lcom/google/gson/JsonObject;", "attachInfo", "", "b", "", AssetExtension.SCENE_EXPORT, "hitCache", "", "type", "from", "a", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "winkEditDataWrapper", "d", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ad {
    @NotNull
    public static final JsonObject a(boolean z16, boolean z17, int i3, int i16) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(AssetExtension.SCENE_EXPORT, String.valueOf(z16));
        jsonObject.addProperty("hitcache", String.valueOf(z17));
        jsonObject.addProperty("type", String.valueOf(i3));
        jsonObject.addProperty("from", String.valueOf(i16));
        return jsonObject;
    }

    public static final void b(@Nullable WinkExportParams winkExportParams, @Nullable String str, long j3, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable JsonObject jsonObject) {
        boolean z16;
        if (winkExportParams != null) {
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (jsonObject == null) {
                    jsonObject = new JsonObject();
                }
                jsonObject.addProperty("process", Integer.valueOf(MobileQQ.sProcessId));
                jsonObject.addProperty("id", String.valueOf(winkExportParams.K));
                jsonObject.addProperty("mission_id", winkExportParams.E);
                z93.c f16 = Wink.INSTANCE.f();
                if (f16 == null) {
                    return;
                }
                WinkPublishQualityReportData reportData = new WinkPublishQualityReportData.Builder().eventId(str).traceId(winkExportParams.F.toString()).retCode(String.valueOf(j3)).desc(String.valueOf(str2)).ext1(String.valueOf(str3)).ext2(String.valueOf(str4)).ext3(String.valueOf(str5)).ext4(String.valueOf(str6)).ext5(String.valueOf(str7)).ext6(String.valueOf(str8)).attachInfo(jsonObject.toString()).getReportData();
                String str9 = winkExportParams.D;
                Intrinsics.checkNotNullExpressionValue(str9, "winkExportParams.mBusinessName");
                f16.b(reportData, str9);
            }
        }
    }

    public static /* synthetic */ void c(WinkExportParams winkExportParams, String str, long j3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, JsonObject jsonObject, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            winkExportParams = null;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            j3 = 0;
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        if ((i3 & 16) != 0) {
            str3 = null;
        }
        if ((i3 & 32) != 0) {
            str4 = "";
        }
        if ((i3 & 64) != 0) {
            str5 = "";
        }
        if ((i3 & 128) != 0) {
            str6 = "";
        }
        if ((i3 & 256) != 0) {
            str7 = "";
        }
        if ((i3 & 512) != 0) {
            str8 = "";
        }
        if ((i3 & 1024) != 0) {
            jsonObject = null;
        }
        b(winkExportParams, str, j3, str2, str3, str4, str5, str6, str7, str8, jsonObject);
    }

    @NotNull
    public static final JsonObject d(@NotNull LocalMediaInfo localMediaInfo, @NotNull WinkEditDataWrapper winkEditDataWrapper) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "winkEditDataWrapper");
        JsonObject jsonObject = new JsonObject();
        try {
            if (QAlbumUtil.getMediaType(localMediaInfo) == 1) {
                jsonObject.addProperty("MediaType", localMediaInfo.mMimeType);
                jsonObject.addProperty("width", String.valueOf(localMediaInfo.mediaWidth));
                jsonObject.addProperty("height", String.valueOf(localMediaInfo.mediaHeight));
                jsonObject.addProperty(BasicAnimation.KeyPath.ROTATION, String.valueOf(localMediaInfo.rotation));
                jsonObject.addProperty("bitrate", String.valueOf(localMediaInfo.mediaBitrate));
                jsonObject.addProperty("framerate", String.valueOf(j.x(localMediaInfo.path)));
                jsonObject.addProperty("duration", String.valueOf(localMediaInfo.mDuration));
                jsonObject.addProperty(MediaDBValues.FILESIZE, String.valueOf(localMediaInfo.fileSize));
                jsonObject.addProperty("hdrOpen", String.valueOf(WinkExportUtils.H(winkEditDataWrapper)));
                jsonObject.addProperty("sharpenOpen", String.valueOf(WinkExportUtils.L(winkEditDataWrapper)));
            } else {
                jsonObject.addProperty("MediaType", localMediaInfo.mMimeType);
                jsonObject.addProperty("width", String.valueOf(localMediaInfo.mediaWidth));
                jsonObject.addProperty("height", String.valueOf(localMediaInfo.mediaHeight));
                jsonObject.addProperty(MediaDBValues.FILESIZE, String.valueOf(localMediaInfo.fileSize));
            }
        } catch (Exception e16) {
            w53.b.e("generateMediaInfo", e16);
        }
        return jsonObject;
    }
}
