package com.tencent.mobileqq.wink.utils;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.export.VideoFormatInfo;
import java.io.File;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u001e\u0010\u0006\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0018\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0002J\u001e\u0010\u001b\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0002J\u0016\u0010\u001e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/o;", "", "Landroid/media/MediaMetadataRetriever;", "", "keyCode", "default", "a", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "j", "l", "mediaInfo", "mediaRetriever", "", tl.h.F, "", "", "mediaLocalPaths", "i", "", "d", "_mediaRetriever", "f", "retriever", "g", "Landroid/media/MediaExtractor;", "mediaExtractor", "e", "Landroid/media/MediaFormat;", "format", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "c", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f326724a = new o();

    o() {
    }

    private final int a(MediaMetadataRetriever mediaMetadataRetriever, int i3, int i16) {
        String extractMetadata = mediaMetadataRetriever.extractMetadata(i3);
        if (extractMetadata != null) {
            return Integer.parseInt(extractMetadata);
        }
        return i16;
    }

    static /* synthetic */ int b(o oVar, MediaMetadataRetriever mediaMetadataRetriever, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i16 = 0;
        }
        return oVar.a(mediaMetadataRetriever, i3, i16);
    }

    private final void h(LocalMediaInfo mediaInfo, MediaMetadataRetriever mediaRetriever) {
        g(mediaInfo, mediaRetriever);
        int i3 = mediaInfo.rotation;
        if (i3 == 90 || i3 == 270) {
            int i16 = mediaInfo.mediaHeight;
            int i17 = mediaInfo.mediaWidth;
            mediaInfo.mediaWidth = i16;
            mediaInfo.mediaHeight = i17;
            mediaInfo.rotation = 0;
        }
    }

    private final LocalMediaInfo j(LocalMediaInfo localMediaInfo) {
        LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
        com.tencent.mobileqq.activity.photo.album.j.d(localMediaInfo2, localMediaInfo.path);
        int i3 = localMediaInfo.orientation;
        if (i3 != 90 && i3 != 270) {
            localMediaInfo.mediaWidth = localMediaInfo2.mediaWidth;
            localMediaInfo.mediaHeight = localMediaInfo2.mediaHeight;
        } else {
            localMediaInfo.mediaWidth = localMediaInfo2.mediaHeight;
            localMediaInfo.mediaHeight = localMediaInfo2.mediaWidth;
        }
        return localMediaInfo;
    }

    private final LocalMediaInfo l(LocalMediaInfo localMediaInfo) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaExtractor.setDataSource(localMediaInfo.path);
                mediaMetadataRetriever.setDataSource(localMediaInfo.path);
                e(localMediaInfo, mediaExtractor, mediaMetadataRetriever);
                h(localMediaInfo, mediaMetadataRetriever);
            } catch (Exception e16) {
                w53.b.d("LocalMediaInfoConverter", "[retrieveVideoInfo]", e16);
            }
            try {
                mediaExtractor.release();
                mediaMetadataRetriever.release();
            } catch (Exception unused) {
                return localMediaInfo;
            }
        } catch (Throwable th5) {
            try {
                mediaExtractor.release();
                mediaMetadataRetriever.release();
            } catch (Exception unused2) {
            }
            throw th5;
        }
    }

    @NotNull
    public final LocalMediaInfo c(@NotNull LocalMediaInfo localMediaInfo) {
        boolean z16;
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        ArrayList<String> arrayList = localMediaInfo.mOriginPath;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(localMediaInfo.path);
            localMediaInfo.mOriginPath = arrayListOf;
        }
        return localMediaInfo;
    }

    public final boolean d(@NotNull LocalMediaInfo localMediaInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        try {
            com.tencent.mobileqq.activity.photo.album.j.d(localMediaInfo, localMediaInfo.path);
            int i3 = localMediaInfo.orientation;
            if (i3 == 0) {
                i3 = f.k(localMediaInfo.path);
            }
            if (i3 == 90 || i3 == 270) {
                int i16 = localMediaInfo.mediaWidth;
                localMediaInfo.mediaWidth = localMediaInfo.mediaHeight;
                localMediaInfo.mediaHeight = i16;
            }
            w53.b.f("LocalMediaInfoConverter", "[fillImageInfo] mineType=" + localMediaInfo.mMimeType + ", isImage=" + e93.i.G(localMediaInfo));
            String str = localMediaInfo.mMimeType;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16 || !e93.i.G(localMediaInfo)) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            w53.b.d("LocalMediaInfoConverter", "[fillImageInfo] exception: path=" + localMediaInfo.path + "\n", e16);
            return false;
        }
    }

    public final void e(@NotNull LocalMediaInfo localMediaInfo, @NotNull MediaExtractor mediaExtractor, @NotNull MediaMetadataRetriever mediaRetriever) {
        String str;
        int i3;
        int i16;
        String str2;
        boolean startsWith$default;
        int i17;
        String str3;
        int i18;
        int i19;
        byte[] bArr;
        int i26;
        int i27;
        MediaFormat mediaFormat;
        ByteBuffer byteBuffer;
        int i28;
        ByteBuffer byteBuffer2;
        boolean z16;
        MediaExtractor mediaExtractor2 = mediaExtractor;
        String str4 = "frame-rate";
        String str5 = "hdr-static-info";
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        Intrinsics.checkNotNullParameter(mediaExtractor2, "mediaExtractor");
        Intrinsics.checkNotNullParameter(mediaRetriever, "mediaRetriever");
        try {
            int trackCount = mediaExtractor.getTrackCount();
            int i29 = 0;
            while (i29 < trackCount) {
                MediaFormat trackFormat = mediaExtractor2.getTrackFormat(i29);
                Intrinsics.checkNotNullExpressionValue(trackFormat, "mediaExtractor.getTrackFormat(i)");
                String string = trackFormat.getString("mime");
                if (string != null) {
                    i3 = trackCount;
                    i16 = i29;
                    byte[] bArr2 = null;
                    String str6 = str4;
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(string, "video", false, 2, null);
                    if (startsWith$default) {
                        localMediaInfo.videoMimeType = string;
                        int i36 = Build.VERSION.SDK_INT;
                        if (localMediaInfo.rotation == 0 && trackFormat.containsKey("rotation-degrees")) {
                            localMediaInfo.rotation = trackFormat.getInteger("rotation-degrees");
                        }
                        if (trackFormat.containsKey("bitrate")) {
                            i17 = trackFormat.getInteger("bitrate");
                        } else {
                            i17 = 0;
                        }
                        if (localMediaInfo.mDuration == 0 && trackFormat.containsKey("durationUs")) {
                            str3 = str5;
                            localMediaInfo.mDuration = trackFormat.getLong("durationUs") / 1000;
                        } else {
                            str3 = str5;
                        }
                        if (trackFormat.containsKey("profile")) {
                            i18 = trackFormat.getInteger("profile");
                        } else {
                            i18 = 0;
                        }
                        if (trackFormat.containsKey("level")) {
                            i19 = trackFormat.getInteger("level");
                        } else {
                            i19 = 0;
                        }
                        if (i36 >= 24) {
                            if (trackFormat.containsKey("color-standard")) {
                                i26 = trackFormat.getInteger("color-standard");
                                if (i26 == 6) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                localMediaInfo.isHDRVideo = z16;
                            } else {
                                i26 = 0;
                            }
                            if (trackFormat.containsKey("color-transfer")) {
                                i28 = trackFormat.getInteger("color-transfer");
                            } else {
                                i28 = 0;
                            }
                            String str7 = str3;
                            if (trackFormat.containsKey(str7) && (byteBuffer2 = trackFormat.getByteBuffer(str7)) != null) {
                                bArr = byteBuffer2.array();
                            } else {
                                bArr = null;
                            }
                            i27 = i28;
                        } else {
                            bArr = null;
                            i26 = 0;
                            i27 = 0;
                        }
                        if (i36 >= 29 && trackFormat.containsKey("hdr10-plus-info") && (byteBuffer = trackFormat.getByteBuffer("hdr10-plus-info")) != null) {
                            bArr2 = byteBuffer.array();
                        }
                        byte[] bArr3 = bArr2;
                        if (i17 == 0) {
                            mediaFormat = trackFormat;
                            i17 = b(this, mediaRetriever, 20, 0, 2, null);
                        } else {
                            mediaFormat = trackFormat;
                        }
                        VideoFormatInfo a16 = new VideoFormatInfo.a().b(i26).c(i27).g(i18).f(i19).e(bArr).d(bArr3).a();
                        localMediaInfo.mediaBitrate = i17;
                        e93.i.V(localMediaInfo, a16);
                        if (mediaFormat.containsKey(str6)) {
                            HashMap<String, Serializable> hashMap = localMediaInfo.extData;
                            Intrinsics.checkNotNullExpressionValue(hashMap, "localMediaInfo.extData");
                            hashMap.put(QQWinkConstants.LOCAL_MEDIA_INFO_EXT_FPS, Integer.valueOf(mediaFormat.getInteger(str6)));
                            return;
                        }
                        return;
                    }
                    str2 = str5;
                    str = str6;
                } else {
                    str = str4;
                    i3 = trackCount;
                    i16 = i29;
                    str2 = str5;
                }
                i29 = i16 + 1;
                str4 = str;
                str5 = str2;
                trackCount = i3;
                mediaExtractor2 = mediaExtractor;
            }
        } catch (Exception e16) {
            w53.b.d("LocalMediaInfoConverter", "[fillVideoFormatInfo] exception: path=" + localMediaInfo.path + "\n", e16);
        }
    }

    public final boolean f(@NotNull LocalMediaInfo localMediaInfo, @Nullable MediaMetadataRetriever _mediaRetriever) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        if (_mediaRetriever == null) {
            mediaMetadataRetriever = new MediaMetadataRetriever();
        } else {
            mediaMetadataRetriever = _mediaRetriever;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            try {
                mediaMetadataRetriever.setDataSource(localMediaInfo.path);
                mediaExtractor.setDataSource(localMediaInfo.path);
                localMediaInfo.mMimeType = mediaMetadataRetriever.extractMetadata(12);
                g(localMediaInfo, mediaMetadataRetriever);
                e(localMediaInfo, mediaExtractor, mediaMetadataRetriever);
                if (_mediaRetriever == null) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception unused) {
                        return true;
                    }
                }
                mediaExtractor.release();
                return true;
            } catch (Exception e16) {
                w53.b.d("LocalMediaInfoConverter", "[fillVideoInfo] exception: path=" + localMediaInfo.path + "\n", e16);
                if (_mediaRetriever == null) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception unused2) {
                        return false;
                    }
                }
                mediaExtractor.release();
                return false;
            }
        } catch (Throwable th5) {
            if (_mediaRetriever == null) {
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception unused3) {
                    throw th5;
                }
            }
            mediaExtractor.release();
            throw th5;
        }
    }

    public final void g(@NotNull LocalMediaInfo localMediaInfo, @NotNull MediaMetadataRetriever retriever) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        Intrinsics.checkNotNullParameter(retriever, "retriever");
        try {
            o oVar = f326724a;
            localMediaInfo.mediaHeight = b(oVar, retriever, 19, 0, 2, null);
            localMediaInfo.mediaWidth = b(oVar, retriever, 18, 0, 2, null);
            localMediaInfo.rotation = b(oVar, retriever, 24, 0, 2, null);
        } catch (Exception e16) {
            w53.b.d("LocalMediaInfoConverter", "[fillVideoWidthAndHeight] exception: path=" + localMediaInfo.path + "\n", e16);
        }
    }

    @NotNull
    public final List<LocalMediaInfo> i(@NotNull List<String> mediaLocalPaths) {
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(mediaLocalPaths, "mediaLocalPaths");
        w53.b.f("LocalMediaInfoConverter", "[fromMediaLocalPaths] mediaLocalPaths.size=" + mediaLocalPaths.size());
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : mediaLocalPaths) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            LocalMediaInfo localMediaInfo = null;
            if (!new File(str).exists()) {
                w53.b.c("LocalMediaInfoConverter", "[fromMediaLocalPaths] failed: path=" + str);
            } else {
                LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
                localMediaInfo2.path = str;
                boolean z16 = true;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str);
                localMediaInfo2.mOriginPath = arrayListOf;
                if (QAlbumUtil.getMediaType(str) == 0) {
                    o oVar = f326724a;
                    if (!oVar.d(localMediaInfo2)) {
                        z16 = oVar.f(localMediaInfo2, mediaMetadataRetriever);
                    }
                } else {
                    o oVar2 = f326724a;
                    if (!oVar2.f(localMediaInfo2, mediaMetadataRetriever)) {
                        z16 = oVar2.d(localMediaInfo2);
                    }
                }
                if (!z16) {
                    w53.b.c("LocalMediaInfoConverter", "[fromMediaLocalPaths] failed: index=" + i3 + ", path=" + str);
                } else {
                    w53.b.f("LocalMediaInfoConverter", "[fromMediaLocalPaths] index=" + i3 + ", localMediaInfo=[path:" + str + ", mimeType:" + localMediaInfo2.mMimeType + ", width:" + localMediaInfo2.mediaWidth + ", height:" + localMediaInfo2.mediaHeight + ", rotation:" + localMediaInfo2.rotation + "]");
                    localMediaInfo = localMediaInfo2;
                }
            }
            if (localMediaInfo != null) {
                arrayList.add(localMediaInfo);
            }
            i3 = i16;
        }
        try {
            mediaMetadataRetriever.release();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    @NotNull
    public final LocalMediaInfo k(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        if (e93.i.G(localMediaInfo)) {
            return j(localMediaInfo);
        }
        if (e93.i.I(localMediaInfo)) {
            return l(localMediaInfo);
        }
        return localMediaInfo;
    }

    public final void m(@NotNull LocalMediaInfo localMediaInfo, @NotNull MediaFormat format) {
        int i3;
        int i16;
        int i17;
        byte[] bArr;
        ByteBuffer byteBuffer;
        int i18;
        ByteBuffer byteBuffer2;
        boolean z16;
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        Intrinsics.checkNotNullParameter(format, "format");
        if (format.containsKey("bitrate")) {
            format.getInteger("bitrate");
        }
        if (localMediaInfo.mDuration == 0 && format.containsKey("durationUs")) {
            localMediaInfo.mDuration = format.getLong("durationUs") / 1000;
        }
        int i19 = 0;
        if (format.containsKey("profile")) {
            i3 = format.getInteger("profile");
        } else {
            i3 = 0;
        }
        int i26 = Build.VERSION.SDK_INT;
        if (format.containsKey("level")) {
            i16 = format.getInteger("level");
        } else {
            i16 = 0;
        }
        byte[] bArr2 = null;
        if (i26 >= 24) {
            if (format.containsKey("color-standard")) {
                i18 = format.getInteger("color-standard");
                if (i18 == 6) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                localMediaInfo.isHDRVideo = z16;
            } else {
                i18 = 0;
            }
            if (format.containsKey("color-transfer")) {
                i19 = format.getInteger("color-transfer");
            }
            if (format.containsKey("hdr-static-info") && (byteBuffer2 = format.getByteBuffer("hdr-static-info")) != null) {
                bArr = byteBuffer2.array();
            } else {
                bArr = null;
            }
            int i27 = i18;
            i17 = i19;
            i19 = i27;
        } else {
            i17 = 0;
            bArr = null;
        }
        if (i26 >= 29 && format.containsKey("hdr10-plus-info") && (byteBuffer = format.getByteBuffer("hdr10-plus-info")) != null) {
            bArr2 = byteBuffer.array();
        }
        e93.i.V(localMediaInfo, new VideoFormatInfo.a().b(i19).c(i17).g(i3).f(i16).e(bArr).d(bArr2).a());
    }
}
