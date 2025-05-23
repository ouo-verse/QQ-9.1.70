package com.tencent.mobileqq.vas.dynamicDrawable.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder;
import com.tencent.cachedrawable.dynamicdrawable.logcat.a;
import com.tencent.libavif.AvifDecoder;
import com.tencent.libavif.AvifImage;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.dynamicDrawable.decoder.AVIFFileDecoder;
import com.tencent.mobileqq.vas.image.f;
import com.tencent.mobileqq.vas.image.j;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u00106\u001a\u00020\u0004\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J,\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u001c\u0010\u0014\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0004R\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001fR\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010%R\u0016\u0010(\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\"R\u0016\u0010*\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\"R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/vas/dynamicDrawable/decoder/AVIFFileDecoder;", "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "path", "k", "Ljava/io/File;", "file", "Lcom/tencent/libavif/AvifDecoder;", "l", "Landroid/content/Context;", "context", "", "originalWidth", "originalHeight", "Lkotlin/Pair;", "i", "Lkotlin/Function1;", "block", "e", "index", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder$a;", "c", "b", "a", "finalize", "Ljava/lang/String;", "mFilePath", "Lcom/tencent/libavif/AvifDecoder;", "mAvifDecoder", "d", "I", "mFrameCount", "", "J", "mInvalidateTimeMs", "f", "mWidth", "g", "mHeight", "Ljava/nio/channels/FileChannel;", h.F, "Ljava/nio/channels/FileChannel;", "mChannel", "Ljava/nio/MappedByteBuffer;", "Ljava/nio/MappedByteBuffer;", "mBuffer", "", "j", "Ljava/lang/Object;", "mLock", "filePath", "<init>", "(Ljava/lang/String;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class AVIFFileDecoder extends AbsFileDecoder {

    /* renamed from: l, reason: collision with root package name */
    private static final boolean f309020l = ar.INSTANCE.b("shouyouye", "2025-02-07", "vas_bugfix_137631363_AVIF").isEnable(true);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mFilePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AvifDecoder mAvifDecoder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mFrameCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mInvalidateTimeMs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mWidth;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int mHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FileChannel mChannel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MappedByteBuffer mBuffer;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object mLock;

    public AVIFFileDecoder(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.mFilePath = filePath;
        this.mLock = new Object();
    }

    private final Pair<Integer, Integer> i(Context context, int originalWidth, int originalHeight) {
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i3 = point.x;
        int i16 = point.y;
        if (originalWidth <= i3 && originalHeight <= i16) {
            return new Pair<>(Integer.valueOf(originalWidth), Integer.valueOf(originalHeight));
        }
        float f16 = originalWidth;
        float f17 = originalHeight;
        float min = Math.min(i3 / f16, i16 / f17);
        return new Pair<>(Integer.valueOf((int) (f16 * min)), Integer.valueOf((int) (f17 * min)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 block, AVIFFileDecoder this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            block.invoke(this$0);
        }
    }

    private final void k(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        this.mAvifDecoder = l(file);
    }

    private final AvifDecoder l(File file) {
        MappedByteBuffer map;
        try {
            FileChannel channel = new FileInputStream(file).getChannel();
            this.mChannel = channel;
            if (channel != null) {
                try {
                    map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                } catch (Exception e16) {
                    a.f99049a.c("AVIFFileDecoder", "initDecoder filepath : " + this.mFilePath, e16);
                    return null;
                }
            } else {
                map = null;
            }
            this.mBuffer = map;
            try {
                AvifDecoder e17 = AvifDecoder.e(map);
                if (e17 == null) {
                    return null;
                }
                return e17;
            } catch (Throwable th5) {
                a.f99049a.c("AVIFFileDecoder", "initDecoder filepath : " + this.mFilePath, th5);
                return null;
            }
        } catch (Exception e18) {
            a.f99049a.c("AVIFFileDecoder", "initDecoder filepath : " + this.mFilePath, e18);
            return null;
        }
    }

    private final void m() {
        if (!f.f309589a.b()) {
            f.f309589a.c(new j.a() { // from class: t03.e
                @Override // com.tencent.mobileqq.vas.image.j.a
                public final void onResult(boolean z16) {
                    AVIFFileDecoder.n(AVIFFileDecoder.this, z16);
                }
            });
            return;
        }
        if (new File(this.mFilePath).exists()) {
            try {
                k(this.mFilePath);
                synchronized (this.mLock) {
                    AvifDecoder avifDecoder = this.mAvifDecoder;
                    if (avifDecoder != null) {
                        Intrinsics.checkNotNull(avifDecoder);
                        if (avifDecoder.n() == 0) {
                            AvifDecoder avifDecoder2 = this.mAvifDecoder;
                            Intrinsics.checkNotNull(avifDecoder2);
                            AvifImage g16 = avifDecoder2.g();
                            Intrinsics.checkNotNullExpressionValue(g16, "mAvifDecoder!!.image");
                            this.mWidth = g16.h();
                            this.mHeight = g16.g();
                            if (f309020l) {
                                BaseApplication context = BaseApplication.context;
                                Intrinsics.checkNotNullExpressionValue(context, "context");
                                Pair<Integer, Integer> i3 = i(context, this.mWidth, this.mHeight);
                                AvifDecoder avifDecoder3 = this.mAvifDecoder;
                                Intrinsics.checkNotNull(avifDecoder3);
                                avifDecoder3.q(i3.getFirst().intValue(), i3.getSecond().intValue());
                                this.mWidth = i3.getFirst().intValue();
                                this.mHeight = i3.getSecond().intValue();
                            }
                            AvifDecoder avifDecoder4 = this.mAvifDecoder;
                            Intrinsics.checkNotNull(avifDecoder4);
                            this.mInvalidateTimeMs = avifDecoder4.i();
                            AvifDecoder avifDecoder5 = this.mAvifDecoder;
                            Intrinsics.checkNotNull(avifDecoder5);
                            this.mFrameCount = avifDecoder5.h();
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e16) {
                a.f99049a.c("AVIFFileDecoder", "initAvifDecoder error : mFilePath : " + this.mFilePath, e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AVIFFileDecoder this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            this$0.m();
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    /* renamed from: b, reason: from getter */
    public int getMFrameCount() {
        return this.mFrameCount;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    @Nullable
    public AbsFileDecoder.a c(int index, @Nullable Bitmap bitmap) {
        Bitmap d16;
        Bitmap d17;
        synchronized (this.mLock) {
            if (this.mAvifDecoder == null) {
                m();
            }
            AvifDecoder avifDecoder = this.mAvifDecoder;
            if (avifDecoder != null) {
                if (avifDecoder.j() > index) {
                    avifDecoder.p();
                }
                if (avifDecoder.j() == index) {
                    AvifImage g16 = avifDecoder.g();
                    Intrinsics.checkNotNullExpressionValue(g16, "it.image");
                    if (bitmap != null) {
                        d17 = g16.c(bitmap, true);
                    } else {
                        d17 = g16.d(true);
                    }
                    Intrinsics.checkNotNullExpressionValue(d17, "if (bitmap != null) {\n  \u2026ue)\n                    }");
                    return new AbsFileDecoder.a(d17, g16.f());
                }
                while (avifDecoder.n() == 0) {
                    if (avifDecoder.j() == index) {
                        AvifImage g17 = avifDecoder.g();
                        Intrinsics.checkNotNullExpressionValue(g17, "it.image");
                        if (bitmap != null) {
                            d16 = g17.c(bitmap, true);
                        } else {
                            d16 = g17.d(true);
                        }
                        Intrinsics.checkNotNullExpressionValue(d16, "if (bitmap != null) {\n  \u2026                        }");
                        return new AbsFileDecoder.a(d16, g17.f());
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            return null;
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    public void e(@NotNull final Function1<? super AbsFileDecoder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (!f.f309589a.b()) {
            f.f309589a.c(new j.a() { // from class: t03.d
                @Override // com.tencent.mobileqq.vas.image.j.a
                public final void onResult(boolean z16) {
                    AVIFFileDecoder.j(Function1.this, this, z16);
                }
            });
        } else {
            block.invoke(this);
        }
    }

    protected final void finalize() {
        try {
            FileChannel fileChannel = this.mChannel;
            if (fileChannel != null) {
                fileChannel.close();
            }
            MappedByteBuffer mappedByteBuffer = this.mBuffer;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.clear();
            }
        } catch (Exception e16) {
            a.f99049a.c("AVIFFileDecoder", "", e16);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    public void a() {
    }
}
