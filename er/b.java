package er;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.wink.model.WinkEditorVideoInfo;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import e93.i;
import java.io.File;
import java.util.ArrayList;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {
    public static LocalMediaInfo a(ArrayList<String> arrayList, @Nonnull String str, int i3, int i16, String str2, String str3, String str4) {
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        if (str3 != null) {
            Size imageSize = BitmapUtil.getImageSize(str3);
            localMediaInfo.thumbHeight = imageSize.getHeight();
            localMediaInfo.thumbWidth = imageSize.getWidth();
        } else {
            localMediaInfo.thumbHeight = 0;
            localMediaInfo.thumbWidth = 0;
        }
        if (!StringUtil.isEmpty(str)) {
            localMediaInfo.mediaOriginSize = q.m(str);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            localMediaInfo.mediaOriginBitrate = Long.valueOf(mediaMetadataRetriever.extractMetadata(20)).longValue();
            localMediaInfo.mediaOriginWidth = Integer.valueOf(mediaMetadataRetriever.extractMetadata(18)).intValue();
            localMediaInfo.mediaOriginHeight = Integer.valueOf(mediaMetadataRetriever.extractMetadata(19)).intValue();
        }
        localMediaInfo.path = str2;
        localMediaInfo.mediaHeight = i3;
        localMediaInfo.mediaWidth = i16;
        localMediaInfo.mMimeType = "video/mp4";
        localMediaInfo.addedDate = System.currentTimeMillis();
        localMediaInfo.modifiedDate = System.currentTimeMillis();
        localMediaInfo.thumbnailPath = str3;
        localMediaInfo.mDuration = 0L;
        localMediaInfo.isSystemMeidaStore = false;
        localMediaInfo.isMakeVideo = false;
        localMediaInfo.isVideoReady = false;
        localMediaInfo.missionID = str4;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        localMediaInfo.mOriginPath = arrayList;
        ms.a.a("AELocalMediaInfoUtil", "buildLocalMediaInfoForNotReady: info = " + localMediaInfo.toString());
        return localMediaInfo;
    }

    public static LocalMediaInfo b(WinkEditorVideoInfo winkEditorVideoInfo) {
        LocalMediaInfo c16 = c(winkEditorVideoInfo.missionID, winkEditorVideoInfo.sourcePath, winkEditorVideoInfo.path, winkEditorVideoInfo.thumbPath);
        if (c16 == null) {
            return null;
        }
        c16.materialID = winkEditorVideoInfo.materialID;
        c16.materialName = winkEditorVideoInfo.materialName;
        c16.filterID = winkEditorVideoInfo.filterID;
        c16.scheme = winkEditorVideoInfo.scheme;
        c16.showCircleTakeSame = winkEditorVideoInfo.showCircleTakeSame;
        c16.missionID = winkEditorVideoInfo.missionID;
        c16.mKuolieId = winkEditorVideoInfo.mKuolieId;
        c16.mKuolieCenterX = winkEditorVideoInfo.mKuolieCenterX;
        c16.mKuolieCenterY = winkEditorVideoInfo.mKuolieCenterY;
        c16.mKuolieWidthScale = winkEditorVideoInfo.mKuolieWidthScale;
        c16.mKuolieHeightScale = winkEditorVideoInfo.mKuolieHeightScale;
        c16.mKuolieRotate = winkEditorVideoInfo.mKuolieRotate;
        if (c16.mDuration == 0) {
            c16.mDuration = winkEditorVideoInfo.videoDuration;
        }
        long j3 = c16.mDuration / 1000;
        i.A(c16);
        return c16;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:1|(2:2|3)|(17:(1:6)|9|10|11|12|(1:14)(1:64)|15|16|17|18|(1:(2:20|(1:52)(1:24))(1:54))|38|(1:40)|41|(2:43|(1:45)(1:49))(1:50)|46|47)|68|12|(0)(0)|15|16|17|18|(2:(0)(0)|52)|38|(0)|41|(0)(0)|46|47|(2:(1:57)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0106, code lost:
    
        r7.videoMimeType = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x010c, code lost:
    
        if (r11.containsKey("rotation-degrees") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x010e, code lost:
    
        r7.rotation = r11.getInteger("rotation-degrees");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0118, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 24) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x011e, code lost:
    
        if (r11.containsKey("color-standard") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0120, code lost:
    
        r0 = r11.getInteger("color-standard");
        ms.a.a("AELocalMediaInfoUtil", "colorStandard=" + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x013a, code lost:
    
        if (r0 != 6) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x013c, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x013f, code lost:
    
        r7.isHDRVideo = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x013e, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x014b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014c, code lost:
    
        ms.a.d("AELocalMediaInfoUtil", "get videoMimeType error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0032, code lost:
    
        if (r16.startsWith("multi_video_") == false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0094 A[Catch: Exception -> 0x00aa, TryCatch #2 {Exception -> 0x00aa, blocks: (B:11:0x0036, B:12:0x0060, B:14:0x0094, B:64:0x00a5), top: B:10:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00db A[Catch: all -> 0x0149, Exception -> 0x014b, TryCatch #1 {Exception -> 0x014b, blocks: (B:18:0x00d1, B:20:0x00db, B:22:0x00fd, B:25:0x0106, B:27:0x010e, B:28:0x0114, B:30:0x011a, B:32:0x0120, B:35:0x013f), top: B:17:0x00d1, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0174 A[Catch: Exception -> 0x0196, TryCatch #4 {Exception -> 0x0196, blocks: (B:15:0x00cb, B:38:0x0145, B:41:0x0157, B:43:0x0174, B:45:0x0181, B:46:0x018d, B:49:0x0188, B:50:0x018b, B:59:0x0192, B:60:0x0195, B:67:0x00af, B:18:0x00d1, B:20:0x00db, B:22:0x00fd, B:25:0x0106, B:27:0x010e, B:28:0x0114, B:30:0x011a, B:32:0x0120, B:35:0x013f, B:56:0x014c), top: B:66:0x00af, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x018b A[Catch: Exception -> 0x0196, TryCatch #4 {Exception -> 0x0196, blocks: (B:15:0x00cb, B:38:0x0145, B:41:0x0157, B:43:0x0174, B:45:0x0181, B:46:0x018d, B:49:0x0188, B:50:0x018b, B:59:0x0192, B:60:0x0195, B:67:0x00af, B:18:0x00d1, B:20:0x00db, B:22:0x00fd, B:25:0x0106, B:27:0x010e, B:28:0x0114, B:30:0x011a, B:32:0x0120, B:35:0x013f, B:56:0x014c), top: B:66:0x00af, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0145 A[EDGE_INSN: B:54:0x0145->B:38:0x0145 BREAK  A[LOOP:0: B:19:0x00d9->B:52:0x0142], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a5 A[Catch: Exception -> 0x00aa, TRY_LEAVE, TryCatch #2 {Exception -> 0x00aa, blocks: (B:11:0x0036, B:12:0x0060, B:14:0x0094, B:64:0x00a5), top: B:10:0x0036 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static LocalMediaInfo c(String str, String str2, String str3, String str4) {
        String str5;
        MediaExtractor mediaExtractor;
        int trackCount;
        int i3;
        String str6 = str3;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        try {
        } catch (Exception e16) {
            e = e16;
            str5 = str2;
        }
        try {
            if (!StringUtil.isEmpty(str2)) {
                if (str != null) {
                }
                str5 = str2;
                try {
                    mediaMetadataRetriever.setDataSource(str5);
                    int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                    int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                    long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(20));
                    localMediaInfo.mediaOriginHeight = parseInt;
                    localMediaInfo.mediaOriginWidth = parseInt2;
                    localMediaInfo.mediaOriginBitrate = parseLong;
                    localMediaInfo.mediaOriginSize = q.m(str2);
                    mediaMetadataRetriever2.setDataSource(str6);
                    int parseInt3 = Integer.parseInt(mediaMetadataRetriever2.extractMetadata(19));
                    int parseInt4 = Integer.parseInt(mediaMetadataRetriever2.extractMetadata(18));
                    int parseInt5 = Integer.parseInt(mediaMetadataRetriever2.extractMetadata(9));
                    long parseLong2 = Long.parseLong(mediaMetadataRetriever2.extractMetadata(20));
                    localMediaInfo.mDuration = parseInt5;
                    localMediaInfo.mediaBitrate = parseLong2;
                    localMediaInfo.mediaWidth = parseInt4;
                    localMediaInfo.mediaHeight = parseInt3;
                    if (TextUtils.isEmpty(str4)) {
                        Size imageSize = BitmapUtil.getImageSize(str4);
                        localMediaInfo.thumbHeight = imageSize.getHeight();
                        localMediaInfo.thumbWidth = imageSize.getWidth();
                    } else {
                        localMediaInfo.thumbHeight = 0;
                        localMediaInfo.thumbWidth = 0;
                    }
                } catch (Exception e17) {
                    e = e17;
                    try {
                        e.printStackTrace();
                        ms.a.c("AELocalMediaInfoUtil", "error msg: " + e.getMessage());
                        mediaExtractor = new MediaExtractor();
                        mediaExtractor.setDataSource(str6);
                        trackCount = mediaExtractor.getTrackCount();
                        i3 = 0;
                        while (true) {
                            if (i3 >= trackCount) {
                            }
                            i3++;
                        }
                        if (str6 == null) {
                        }
                        localMediaInfo.path = str6;
                        localMediaInfo.mMimeType = "video/mp4";
                        localMediaInfo.addedDate = System.currentTimeMillis();
                        localMediaInfo.modifiedDate = System.currentTimeMillis();
                        localMediaInfo.thumbnailPath = str4;
                        if (localMediaInfo.path != null) {
                        }
                        localMediaInfo.isSystemMeidaStore = false;
                        localMediaInfo.isMakeVideo = true;
                        return localMediaInfo;
                    } catch (Exception e18) {
                        e18.printStackTrace();
                        ms.a.c("AELocalMediaInfoUtil", "[buildLocalMediaInfoForReady] " + e18.getMessage());
                        return null;
                    }
                }
                mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(str6);
                trackCount = mediaExtractor.getTrackCount();
                i3 = 0;
                while (true) {
                    if (i3 >= trackCount) {
                        break;
                    }
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
                    String string = trackFormat.getString("mime");
                    ms.a.a("AELocalMediaInfoUtil", "mime=" + string);
                    if (string != null && string.startsWith("video")) {
                        break;
                    }
                    i3++;
                }
                if (str6 == null) {
                    str6 = str5;
                }
                localMediaInfo.path = str6;
                localMediaInfo.mMimeType = "video/mp4";
                localMediaInfo.addedDate = System.currentTimeMillis();
                localMediaInfo.modifiedDate = System.currentTimeMillis();
                localMediaInfo.thumbnailPath = str4;
                if (localMediaInfo.path != null) {
                    File file = new File(localMediaInfo.path);
                    if (file.exists()) {
                        localMediaInfo.fileSize = file.length();
                    } else {
                        localMediaInfo.fileSize = 0L;
                    }
                } else {
                    localMediaInfo.fileSize = 0L;
                }
                localMediaInfo.isSystemMeidaStore = false;
                localMediaInfo.isMakeVideo = true;
                return localMediaInfo;
            }
            mediaExtractor.setDataSource(str6);
            trackCount = mediaExtractor.getTrackCount();
            i3 = 0;
            while (true) {
                if (i3 >= trackCount) {
                }
                i3++;
            }
            if (str6 == null) {
            }
            localMediaInfo.path = str6;
            localMediaInfo.mMimeType = "video/mp4";
            localMediaInfo.addedDate = System.currentTimeMillis();
            localMediaInfo.modifiedDate = System.currentTimeMillis();
            localMediaInfo.thumbnailPath = str4;
            if (localMediaInfo.path != null) {
            }
            localMediaInfo.isSystemMeidaStore = false;
            localMediaInfo.isMakeVideo = true;
            return localMediaInfo;
        } finally {
            mediaExtractor.release();
        }
        str5 = str2;
        mediaMetadataRetriever2.setDataSource(str6);
        int parseInt32 = Integer.parseInt(mediaMetadataRetriever2.extractMetadata(19));
        int parseInt42 = Integer.parseInt(mediaMetadataRetriever2.extractMetadata(18));
        int parseInt52 = Integer.parseInt(mediaMetadataRetriever2.extractMetadata(9));
        long parseLong22 = Long.parseLong(mediaMetadataRetriever2.extractMetadata(20));
        localMediaInfo.mDuration = parseInt52;
        localMediaInfo.mediaBitrate = parseLong22;
        localMediaInfo.mediaWidth = parseInt42;
        localMediaInfo.mediaHeight = parseInt32;
        if (TextUtils.isEmpty(str4)) {
        }
        mediaExtractor = new MediaExtractor();
    }
}
