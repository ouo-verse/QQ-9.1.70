package com.tencent.mobileqq.guild.feed.util;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.winkpublish.util.PublishVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUploadFileGroupInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUploadFileInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUploadStatus;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007J\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0012\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0011J\u0016\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/az;", "", "", "path", "", "g", "tag", "Lcom/tencent/mobileqq/guild/data/g;", "mediaInfo", tl.h.F, "", "a", "Lkotlin/Pair;", "f", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUploadFileInfo;", "info", "d", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUploadFileGroupInfo;", "c", "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUploadStatus;", "uploadStatus", "b", "Lcom/tencent/qqnt/msg/c;", "Lcom/tencent/qqnt/msg/c;", "sCompressModule", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class az {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final az f223861a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/Guild/Inject_CompressModule.yml", version = 1)
    @Nullable
    private static com.tencent.qqnt.msg.c sCompressModule;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f223863c;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f223864a;

        static {
            int[] iArr = new int[GProUploadStatus.values().length];
            try {
                iArr[GProUploadStatus.KUNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GProUploadStatus.KUPLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GProUploadStatus.KUPLOADSUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GProUploadStatus.KUPLOADPAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[GProUploadStatus.KUPLOADFAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[GProUploadStatus.KUPLOADCANCELED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f223864a = iArr;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f223863c = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.m.class);
        f223861a = new az();
    }

    az() {
    }

    private final int g(String path) {
        if (TextUtils.isEmpty(path)) {
            return 0;
        }
        int readOrientation = JpegExifReader.readOrientation(path);
        if (readOrientation != 3) {
            if (readOrientation != 6) {
                if (readOrientation != 8) {
                    return 0;
                }
                return 270;
            }
            return 90;
        }
        return 180;
    }

    private final String h(String tag, com.tencent.mobileqq.guild.data.g mediaInfo) {
        String stackTraceToString;
        String str;
        try {
            str = PublishVideoUtils.saveBitmapToLocal(ag.f223839a.a(mediaInfo.getMediaWidth(), mediaInfo.getMediaHeight()));
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e(tag, 1, "[tryMakeCoverWithFallbackStrategy] use fallback strategy exception: " + stackTraceToString);
            str = null;
        }
        QLog.d(tag, 1, "[tryMakeCoverWithFallbackStrategy]: use fallback strategy, coverPath=" + str);
        return str;
    }

    public final boolean a(@NotNull com.tencent.mobileqq.guild.data.g mediaInfo) {
        String path;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (sCompressModule == null) {
            QLog.e("GuildMediaUploadUtil", 1, "compress module is null");
            return false;
        }
        if (com.tencent.mobileqq.guild.util.i.f235563a.e(mediaInfo)) {
            QLog.e("GuildMediaUploadUtil", 1, "is not image");
            return false;
        }
        try {
            com.tencent.qqnt.msg.c cVar = sCompressModule;
            if (cVar == null || (path = cVar.b(mediaInfo.getPath())) == null) {
                path = mediaInfo.getPath();
            }
            if (cq.n(path)) {
                mediaInfo.n(path);
                return true;
            }
        } catch (Exception e16) {
            QLog.i("GuildMediaUploadUtil", 1, "compressPic, e = " + e16);
        }
        QLog.d("GuildMediaUploadUtil", 1, "compress failed");
        return false;
    }

    public final int b(@NotNull GProUploadStatus uploadStatus) {
        Intrinsics.checkNotNullParameter(uploadStatus, "uploadStatus");
        int i3 = a.f223864a[uploadStatus.ordinal()];
        if (i3 != 2) {
            if (i3 == 3) {
                return 3;
            }
            if (i3 != 4) {
                if (i3 == 5) {
                    return 2;
                }
                if (i3 == 6) {
                    return 5;
                }
                return -1000;
            }
            return 0;
        }
        return 1;
    }

    @NotNull
    public final String c(@Nullable GProUploadFileGroupInfo info) {
        if (info == null) {
            return "GProUploadFileGroupInfo is null";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GProUploadFileInfo:{");
        sb5.append("fileGroupId = " + info.fileGroupId + ", ");
        sb5.append("uploadStatus = " + info.uploadStatus.ordinal() + ", ");
        sb5.append("totalSize = " + info.totalFileSize + ", ");
        sb5.append("uploadSize = " + info.totalUploadFileSize + ", ");
        sb5.append("errorCode = " + info.errorCode + ", ");
        sb5.append("errorMsg = " + info.errorMsg + ", ");
        sb5.append("childFileIds = {");
        Iterator<String> it = info.childFileIds.iterator();
        while (it.hasNext()) {
            sb5.append(it.next() + ", ");
        }
        sb5.append("}");
        sb5.append("}");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
        return sb6;
    }

    @NotNull
    public final String d(@Nullable GProUploadFileInfo info) {
        if (info == null) {
            return "GProUploadFileInfo is null";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GProUploadFileInfo:{");
        sb5.append(info.fileGroupId + "-" + info.fileId + ", ");
        sb5.append("uploadStatus = " + info.uploadStatus.ordinal() + ", ");
        sb5.append("totalSize = " + info.totalFileSize + ", ");
        sb5.append("uploadSize = " + info.uploadFileSize + ", ");
        sb5.append("svrFileId = " + info.svrFileId.length() + ", ");
        sb5.append("svrUrl = " + info.svrUrl.length() + ", ");
        sb5.append("isOriginal = " + info.isOriginal + ", ");
        sb5.append("fileType = " + info.fileType.ordinal());
        sb5.append("}");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
        return sb6;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[Catch: Exception -> 0x008c, TryCatch #0 {Exception -> 0x008c, blocks: (B:3:0x0010, B:5:0x0017, B:9:0x0026, B:11:0x0035, B:15:0x003a, B:17:0x0044, B:22:0x0050, B:24:0x005e, B:25:0x0062, B:29:0x007a, B:33:0x0083), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0083 A[Catch: Exception -> 0x008c, TRY_LEAVE, TryCatch #0 {Exception -> 0x008c, blocks: (B:3:0x0010, B:5:0x0017, B:9:0x0026, B:11:0x0035, B:15:0x003a, B:17:0x0044, B:22:0x0050, B:24:0x005e, B:25:0x0062, B:29:0x007a, B:33:0x0083), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String e(@NotNull String tag, @NotNull com.tencent.mobileqq.guild.data.g mediaInfo) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        try {
            boolean z18 = false;
            if (mediaInfo.getThumbnailPath() != null) {
                if (mediaInfo.getThumbnailPath().length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17 && new File(mediaInfo.getThumbnailPath()).exists()) {
                    return mediaInfo.getThumbnailPath();
                }
            }
            String videoCover = PublishVideoUtils.getVideoCover(mediaInfo.getPath());
            if (videoCover != null && videoCover.length() != 0) {
                z16 = false;
                if (z16) {
                    PublishVideoUtils.ThumbnailInfo queryVideoThumbs = PublishVideoUtils.queryVideoThumbs(BaseApplication.getContext(), mediaInfo.getId());
                    if (queryVideoThumbs != null) {
                        videoCover = queryVideoThumbs.mCoverUrl;
                    } else {
                        videoCover = null;
                    }
                    QLog.d(tag, 1, "queryFromThumbs coverUrl=" + videoCover);
                    if (videoCover == null) {
                        videoCover = "";
                    }
                }
                if (videoCover.length() == 0) {
                    z18 = true;
                }
                if (z18) {
                    videoCover = h(tag, mediaInfo);
                }
                if (videoCover != null) {
                    return "";
                }
                return videoCover;
            }
            z16 = true;
            if (z16) {
            }
            if (videoCover.length() == 0) {
            }
            if (z18) {
            }
            if (videoCover != null) {
            }
        } catch (Exception e16) {
            QLog.e("GuildMediaUploadUtil", 1, "getVideoCover, e = " + e16);
            return "";
        }
    }

    @NotNull
    public final Pair<Integer, Integer> f(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        boolean z16 = false;
        if (path.length() == 0) {
            z16 = true;
        }
        if (z16) {
            return new Pair<>(0, 0);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(path, options);
        int g16 = g(path);
        if (g16 != 90 && g16 != 270) {
            return new Pair<>(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
        }
        return new Pair<>(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
    }
}
