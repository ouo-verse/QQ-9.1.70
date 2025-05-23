package fj;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qzone.model.ForwardMediaInfo;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"Lcooperation/qzone/model/ForwardMediaInfo;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "c", "a", "b", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {
    private static final LocalMediaInfo a(ForwardMediaInfo forwardMediaInfo) {
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.mMimeType = "image";
        localMediaInfo.mMediaType = 0;
        localMediaInfo.fileSize = forwardMediaInfo.fileSize;
        localMediaInfo.path = forwardMediaInfo.filePath;
        localMediaInfo.mediaWidth = forwardMediaInfo.picWidth;
        localMediaInfo.mediaHeight = forwardMediaInfo.picHeight;
        localMediaInfo.addedDate = forwardMediaInfo.msgTime;
        localMediaInfo.thumbSize = forwardMediaInfo.thumbSize;
        localMediaInfo.thumbWidth = forwardMediaInfo.thumbWidth;
        localMediaInfo.thumbHeight = forwardMediaInfo.thumbHeight;
        localMediaInfo.thumbnailPath = b.f399446a.d(forwardMediaInfo.thumbPath);
        HashMap<String, Serializable> hashMap = new HashMap<>();
        localMediaInfo.extData = hashMap;
        Intrinsics.checkNotNullExpressionValue(hashMap, "localMediaInfo.extData");
        hashMap.put("extFileUUID", forwardMediaInfo.fileUuid);
        HashMap<String, Serializable> hashMap2 = localMediaInfo.extData;
        Intrinsics.checkNotNullExpressionValue(hashMap2, "localMediaInfo.extData");
        hashMap2.put("extFileMd5", forwardMediaInfo.fileMd5);
        HashMap<String, Serializable> hashMap3 = localMediaInfo.extData;
        Intrinsics.checkNotNullExpressionValue(hashMap3, "localMediaInfo.extData");
        hashMap3.put("extImageMd5", forwardMediaInfo.md5HexStr);
        HashMap<String, Serializable> hashMap4 = localMediaInfo.extData;
        Intrinsics.checkNotNullExpressionValue(hashMap4, "localMediaInfo.extData");
        hashMap4.put("uin", Long.valueOf(forwardMediaInfo.uin));
        HashMap<String, Serializable> hashMap5 = localMediaInfo.extData;
        Intrinsics.checkNotNullExpressionValue(hashMap5, "localMediaInfo.extData");
        hashMap5.put("dittoUin", forwardMediaInfo.dittoUin);
        HashMap<String, Serializable> hashMap6 = localMediaInfo.extData;
        Intrinsics.checkNotNullExpressionValue(hashMap6, "localMediaInfo.extData");
        hashMap6.put("storeID", Integer.valueOf(forwardMediaInfo.storeID));
        return localMediaInfo;
    }

    public static final LocalMediaInfo b(ForwardMediaInfo forwardMediaInfo) {
        Intrinsics.checkNotNullParameter(forwardMediaInfo, "<this>");
        int i3 = forwardMediaInfo.mediaType;
        if (i3 == 1 || i3 == 3) {
            return a(forwardMediaInfo);
        }
        if (i3 == 2 || i3 == 4) {
            return c(forwardMediaInfo);
        }
        return null;
    }

    private static final LocalMediaInfo c(ForwardMediaInfo forwardMediaInfo) {
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.mMimeType = "video";
        localMediaInfo.mMediaType = 1;
        localMediaInfo.fileSize = forwardMediaInfo.fileSize;
        localMediaInfo.path = forwardMediaInfo.filePath;
        int i3 = forwardMediaInfo.thumbWidth;
        localMediaInfo.mediaWidth = i3;
        int i16 = forwardMediaInfo.thumbHeight;
        localMediaInfo.mediaHeight = i16;
        localMediaInfo.addedDate = forwardMediaInfo.msgTime;
        localMediaInfo.mDuration = forwardMediaInfo.fileTime * 1000;
        localMediaInfo.thumbSize = forwardMediaInfo.thumbSize;
        localMediaInfo.thumbWidth = i3;
        localMediaInfo.thumbHeight = i16;
        localMediaInfo.thumbnailPath = b.f399446a.d(forwardMediaInfo.thumbPath);
        HashMap<String, Serializable> hashMap = new HashMap<>();
        localMediaInfo.extData = hashMap;
        Intrinsics.checkNotNullExpressionValue(hashMap, "localMediaInfo.extData");
        hashMap.put("extFileUUID", forwardMediaInfo.fileUuid);
        HashMap<String, Serializable> hashMap2 = localMediaInfo.extData;
        Intrinsics.checkNotNullExpressionValue(hashMap2, "localMediaInfo.extData");
        hashMap2.put("extFileMd5", forwardMediaInfo.fileMd5);
        HashMap<String, Serializable> hashMap3 = localMediaInfo.extData;
        Intrinsics.checkNotNullExpressionValue(hashMap3, "localMediaInfo.extData");
        hashMap3.put("extVideoMd5", forwardMediaInfo.videoMd5);
        HashMap<String, Serializable> hashMap4 = localMediaInfo.extData;
        Intrinsics.checkNotNullExpressionValue(hashMap4, "localMediaInfo.extData");
        hashMap4.put("uin", Long.valueOf(forwardMediaInfo.uin));
        HashMap<String, Serializable> hashMap5 = localMediaInfo.extData;
        Intrinsics.checkNotNullExpressionValue(hashMap5, "localMediaInfo.extData");
        hashMap5.put("dittoUin", forwardMediaInfo.dittoUin);
        HashMap<String, Serializable> hashMap6 = localMediaInfo.extData;
        Intrinsics.checkNotNullExpressionValue(hashMap6, "localMediaInfo.extData");
        hashMap6.put("storeID", Integer.valueOf(forwardMediaInfo.storeID));
        return localMediaInfo;
    }
}
