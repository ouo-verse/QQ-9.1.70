package com.tencent.aelight.camera.ae.util;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import com.tencent.aelight.camera.ae.data.AEArkMsgMeta;
import com.tencent.aelight.camera.ae.data.AEMaterialArkInfo;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.light.utils.GsonUtils;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015JL\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0002\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/aelight/camera/ae/util/a;", "", "", "mediaType", "mediaDownLoadUrl", "coverDownLoadUrl", "", "width", "height", "widgetId", "arkScore", "Lcom/tencent/aelight/camera/ae/data/AEMaterialArkInfo;", "materialArkInfo", "a", "Landroid/content/Context;", "context", "mediaLocalPath", "Landroid/graphics/Point;", "b", "c", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f65756a = new a();

    a() {
    }

    public final String a(String mediaType, String mediaDownLoadUrl, String coverDownLoadUrl, int width, int height, String widgetId, String arkScore, AEMaterialArkInfo materialArkInfo) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(mediaDownLoadUrl, "mediaDownLoadUrl");
        Intrinsics.checkNotNullParameter(coverDownLoadUrl, "coverDownLoadUrl");
        Intrinsics.checkNotNullParameter(materialArkInfo, "materialArkInfo");
        AEArkMsgMeta.Inner inner = new AEArkMsgMeta.Inner();
        inner.contentType = mediaType;
        inner.contentUrl = mediaDownLoadUrl;
        inner.widgetId = widgetId;
        inner.userImageUrl = coverDownLoadUrl;
        inner.contentWidth = width;
        inner.contentHeight = height;
        inner.score = arkScore;
        inner.coverImageUrl = materialArkInfo.getCoverImageUrl();
        inner.title = materialArkInfo.getTitle();
        inner.shareMsg = materialArkInfo.getShareMsg();
        AEArkMsgMeta aEArkMsgMeta = new AEArkMsgMeta();
        aEArkMsgMeta.meta = inner;
        return GsonUtils.obj2Json(aEArkMsgMeta);
    }

    public final Point b(Context context, String mediaLocalPath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaLocalPath, "mediaLocalPath");
        Point bitmapSize = BitmapUtils.getBitmapSize(context, mediaLocalPath);
        Intrinsics.checkNotNullExpressionValue(bitmapSize, "getBitmapSize(context, mediaLocalPath)");
        return bitmapSize;
    }

    public final Point c(String mediaLocalPath) {
        Intrinsics.checkNotNullParameter(mediaLocalPath, "mediaLocalPath");
        Point point = new Point();
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(mediaLocalPath);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
            Intrinsics.checkNotNull(extractMetadata);
            point.x = Integer.parseInt(extractMetadata);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            Intrinsics.checkNotNull(extractMetadata2);
            point.y = Integer.parseInt(extractMetadata2);
        } catch (Exception e16) {
            ms.a.d("AEArkMsgHelper", "get media metadata fail:", e16);
        }
        return point;
    }
}
