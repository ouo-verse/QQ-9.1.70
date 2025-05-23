package com.tencent.mobileqq.vas.dynamicDrawable.decoder;

import android.graphics.Bitmap;
import com.qzone.publish.business.model.UploadVideoObject;
import com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder;
import com.tencent.cachedrawable.dynamicdrawable.logcat.a;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.io.File;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t03.c;
import t03.f;
import tl.h;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\u0012\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u001d\u001a\u00020\u00132\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00130\u001bH\u0016R\u0016\u0010\u001f\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/vas/dynamicDrawable/decoder/DynamicFileDecoder;", "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder;", "", "filePath", "i", "Ljava/io/File;", "file", h.F, "", "bytes", "", "k", "l", HippyControllerProps.ARRAY, "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "target", "", "g", "", "a", "b", "index", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder$a;", "c", "Lkotlin/Function1;", "block", "e", "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder;", "realFileDecoder", "<init>", "(Ljava/lang/String;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class DynamicFileDecoder extends AbsFileDecoder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final byte[] f309031d = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final byte[] f309032e = {97, 99, 84, 76};

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AbsFileDecoder realFileDecoder;

    public DynamicFileDecoder(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.realFileDecoder = i(filePath);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002b, code lost:
    
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int g(byte[] array, byte[] target) {
        boolean z16;
        boolean z17;
        if (array != null) {
            if (array.length == 0) {
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
                    int length = (array.length - target.length) + 1;
                    int i3 = 0;
                    while (i3 < length) {
                        int length2 = target.length;
                        for (int i16 = 0; i16 < length2; i16++) {
                            if (array[i3 + i16] != target[i16]) {
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

    private final String h(File file) {
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
                try {
                    byte[] bArr = new byte[80];
                    int read = randomAccessFile2.read(bArr);
                    randomAccessFile2.close();
                    if (m(bArr)) {
                        try {
                            randomAccessFile2.close();
                        } catch (Throwable th5) {
                            a.f99049a.c("DynamicFileDecoder", "close e:", th5);
                        }
                        return "gif";
                    }
                    if (!k(bArr) && !l(bArr)) {
                        if (read < 80) {
                            try {
                                randomAccessFile2.close();
                            } catch (Throwable th6) {
                                a.f99049a.c("DynamicFileDecoder", "close e:", th6);
                            }
                            return UploadVideoObject.VODEO_FORMAT_UNKNOW;
                        }
                        if (j(bArr)) {
                            try {
                                randomAccessFile2.close();
                            } catch (Throwable th7) {
                                a.f99049a.c("DynamicFileDecoder", "close e:", th7);
                            }
                            return "apng";
                        }
                        try {
                            randomAccessFile2.close();
                        } catch (Throwable th8) {
                            a.f99049a.c("DynamicFileDecoder", "close e:", th8);
                        }
                        return UploadVideoObject.VODEO_FORMAT_UNKNOW;
                    }
                    try {
                        randomAccessFile2.close();
                    } catch (Throwable th9) {
                        a.f99049a.c("DynamicFileDecoder", "close e:", th9);
                    }
                    return "avif";
                } catch (Exception e16) {
                    e = e16;
                    randomAccessFile = randomAccessFile2;
                    a.f99049a.c("DynamicFileDecoder", "io exception:", e);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th10) {
                            a.f99049a.c("DynamicFileDecoder", "close e:", th10);
                        }
                    }
                    return UploadVideoObject.VODEO_FORMAT_UNKNOW;
                } catch (Throwable th11) {
                    th = th11;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th12) {
                            a.f99049a.c("DynamicFileDecoder", "close e:", th12);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th13) {
                th = th13;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private final AbsFileDecoder i(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return new f(filePath);
        }
        String h16 = h(file);
        int hashCode = h16.hashCode();
        if (hashCode != 102340) {
            if (hashCode != 3000872) {
                if (hashCode == 3006482 && h16.equals("avif")) {
                    return new AVIFFileDecoder(filePath);
                }
            } else if (h16.equals("apng")) {
                return new c(filePath);
            }
        } else if (h16.equals("gif")) {
            return new t03.h(filePath);
        }
        return new f(filePath);
    }

    private final boolean j(byte[] array) {
        int length = f309031d.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (array[i3] != f309031d[i3]) {
                return false;
            }
        }
        if (g(array, f309032e) <= 0) {
            return false;
        }
        return true;
    }

    private final boolean k(byte[] bytes) {
        if (bytes.length < 12 || bytes[0] != 0 || bytes[4] != 102 || bytes[5] != 116 || bytes[6] != 121 || bytes[7] != 112 || bytes[8] != 97 || bytes[9] != 118 || bytes[10] != 105 || bytes[11] != 102) {
            return false;
        }
        return true;
    }

    private final boolean l(byte[] bytes) {
        if (bytes.length < 12 || bytes[0] != 0 || bytes[4] != 102 || bytes[5] != 116 || bytes[6] != 121 || bytes[7] != 112 || bytes[8] != 97 || bytes[9] != 118 || bytes[10] != 105 || bytes[11] != 115) {
            return false;
        }
        return true;
    }

    private final boolean m(byte[] bytes) {
        if (bytes.length < 3 || bytes[0] != 71 || bytes[1] != 73 || bytes[2] != 70) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    public void a() {
        this.realFileDecoder.a();
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    /* renamed from: b */
    public int getMFrameCount() {
        return this.realFileDecoder.getMFrameCount();
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    @Nullable
    public AbsFileDecoder.a c(int index, @Nullable Bitmap bitmap) {
        return this.realFileDecoder.c(index, bitmap);
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    public void e(@NotNull Function1<? super AbsFileDecoder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.realFileDecoder.e(block);
    }
}
