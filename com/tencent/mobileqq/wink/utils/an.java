package com.tencent.mobileqq.wink.utils;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.videocut.model.ImageType;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bJ&\u0010\u0013\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ(\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\rJ(\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\rJ\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007R\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/an;", "", "", HippyControllerProps.ARRAY, "target", "", "a", "", "imagePath", "Lcom/tencent/videocut/model/ImageType;", "g", "Ljava/io/File;", "file", "", "i", "", "Lcom/tencent/videocut/model/MediaClip;", "mediaClips", "oldMediaClips", "j", "sourceFilePath", "maxLen", CustomImageProps.QUALITY, "ignoreFileFormat", "d", "needJpg", "b", WadlProxyConsts.PARAM_FILENAME, "f", "path", tl.h.F, "[B", "PNG_SIG", "c", "SIGNATURE_APNG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class an {

    /* renamed from: a */
    @NotNull
    public static final an f326680a = new an();

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final byte[] PNG_SIG = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private static final byte[] SIGNATURE_APNG = {97, 99, 84, 76};

    an() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002b, code lost:
    
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int a(byte[] r95, byte[] target) {
        boolean z16;
        boolean z17;
        if (r95 != null) {
            if (r95.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && target != null) {
                if (target.length == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    int length = (r95.length - target.length) + 1;
                    int i3 = 0;
                    while (i3 < length) {
                        int length2 = target.length;
                        for (int i16 = 0; i16 < length2; i16++) {
                            if (r95[i3 + i16] != target[i16]) {
                                break;
                            }
                        }
                        return i3;
                    }
                }
            }
        }
        return -1;
    }

    public static /* synthetic */ String c(an anVar, String str, int i3, int i16, boolean z16, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            z16 = true;
        }
        return anVar.b(str, i3, i16, z16);
    }

    public static /* synthetic */ String e(an anVar, String str, int i3, int i16, boolean z16, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            z16 = false;
        }
        return anVar.d(str, i3, i16, z16);
    }

    @NotNull
    public final String b(@NotNull String sourceFilePath, int maxLen, int r56, boolean needJpg) {
        Intrinsics.checkNotNullParameter(sourceFilePath, "sourceFilePath");
        if (QAlbumUtil.getMediaType(sourceFilePath) == 0) {
            String h16 = h(sourceFilePath);
            if (h16.equals(".png") && needJpg) {
                h16 = ".jpg";
            }
            String f16 = f(h16);
            if (f.p(sourceFilePath, f16, maxLen, r56)) {
                return f16;
            }
            return sourceFilePath;
        }
        return sourceFilePath;
    }

    @NotNull
    public final String d(@NotNull String sourceFilePath, int maxLen, int r46, boolean ignoreFileFormat) {
        Intrinsics.checkNotNullParameter(sourceFilePath, "sourceFilePath");
        if (!ignoreFileFormat && QAlbumUtil.getMediaType(sourceFilePath) != 0) {
            return sourceFilePath;
        }
        String f16 = f(h(sourceFilePath));
        if (f.p(sourceFilePath, f16, maxLen, r46)) {
            return f16;
        }
        return sourceFilePath;
    }

    @NotNull
    public final String f(@NotNull String r56) {
        Intrinsics.checkNotNullParameter(r56, "fileName");
        String str = u53.e.f438384a + File.separator;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str + System.nanoTime() + r56;
    }

    @NotNull
    public final ImageType g(@NotNull String imagePath) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        int imageType = ((IPicUtil) QRoute.api(IPicUtil.class)).getImageType(imagePath);
        if (imageType != 0) {
            if (imageType != 1001) {
                if (imageType != 2000) {
                    if (imageType != 2001) {
                        return ImageType.COMMON;
                    }
                    return ImageType.APNG;
                }
                return ImageType.GIF;
            }
            if (i(new File(imagePath))) {
                return ImageType.APNG;
            }
            return ImageType.COMMON;
        }
        return ImageType.UNKNOWN;
    }

    @NotNull
    public final String h(@NotNull String path) {
        int lastIndexOf$default;
        Intrinsics.checkNotNullParameter(path, "path");
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) path, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default > 0) {
            String substring = path.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return "";
    }

    public final boolean i(@NotNull File file) throws IOException {
        RandomAccessFile randomAccessFile;
        Intrinsics.checkNotNullParameter(file, "file");
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] bArr = new byte[80];
            int read = randomAccessFile.read(bArr);
            randomAccessFile.close();
            boolean z16 = false;
            if (read < 80) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th6) {
                    w53.b.d("WinkImageUtils", "isApngFile close e:", th6);
                }
                return false;
            }
            int length = PNG_SIG.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (bArr[i3] != PNG_SIG[i3]) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th7) {
                        w53.b.d("WinkImageUtils", "isApngFile close e:", th7);
                    }
                    return false;
                }
            }
            if (a(bArr, SIGNATURE_APNG) > 0) {
                z16 = true;
            }
            try {
                randomAccessFile.close();
            } catch (Throwable th8) {
                w53.b.d("WinkImageUtils", "isApngFile close e:", th8);
            }
            return z16;
        } catch (Throwable th9) {
            th = th9;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (Throwable th10) {
                    w53.b.d("WinkImageUtils", "isApngFile close e:", th10);
                }
            }
            throw th;
        }
    }

    public final boolean j(@Nullable List<? extends MediaClip> mediaClips, @Nullable List<? extends MediaClip> oldMediaClips) {
        String str;
        String str2;
        Long l3;
        if (mediaClips == null && oldMediaClips == null) {
            return false;
        }
        if (mediaClips == null || oldMediaClips == null || mediaClips.size() != oldMediaClips.size()) {
            return true;
        }
        int i3 = 0;
        for (MediaClip mediaClip : mediaClips) {
            int i16 = i3 + 1;
            ResourceModel resourceModel = mediaClip.resource;
            Long l16 = null;
            if (resourceModel != null) {
                str = resourceModel.path;
            } else {
                str = null;
            }
            ResourceModel resourceModel2 = oldMediaClips.get(i3).resource;
            if (resourceModel2 != null) {
                str2 = resourceModel2.path;
            } else {
                str2 = null;
            }
            if (!Intrinsics.areEqual(str, str2)) {
                w53.b.f("WinkEditorFragment", "isClipsChange path change");
                return true;
            }
            ResourceModel resourceModel3 = mediaClip.resource;
            if (resourceModel3 != null) {
                l3 = Long.valueOf(resourceModel3.selectStart);
            } else {
                l3 = null;
            }
            ResourceModel resourceModel4 = oldMediaClips.get(i3).resource;
            if (resourceModel4 != null) {
                l16 = Long.valueOf(resourceModel4.selectStart);
            }
            if (!Intrinsics.areEqual(l3, l16)) {
                w53.b.f("WinkEditorFragment", "isClipsChange selectStart change");
                return true;
            }
            i3 = i16;
        }
        return false;
    }
}
