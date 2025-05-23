package com.tencent.mobileqq.zplan.meme.animation2D;

import android.graphics.Bitmap;
import android.system.ErrnoException;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.service.ZPlanEngineQualityReporter;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.MODE;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FileTreeWalk;
import kotlin.io.FilesKt__FileTreeWalkKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001@B\t\b\u0002\u00a2\u0006\u0004\b>\u0010?J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002Jx\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00142\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\"\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u0002H\u0002JV\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00162\u0006\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u0010H\u0002J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010&\u001a\u00020\u0016H\u0002J*\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010&\u001a\u00020\u00162\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001b0(H\u0002J\u000e\u0010,\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020+J \u00100\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020+2\u0006\u0010-\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u00010.JH\u00104\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00162\b\b\u0002\u0010\u0011\u001a\u00020\u0010R\u001d\u0010:\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001b\u0010=\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00107\u001a\u0004\b;\u0010<\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/animation2D/Anim2DEncoderHelper;", "", "", "errCode", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "l", "bgCount", "fgCount", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "fgFiles", "bgFiles", "i", "Landroid/graphics/Bitmap;", "avatarBitmap", "", "radius", "encodeWidth", "encodeHeight", "Lkotlin/Pair;", "j", "", "retPath", "", "data", "length", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "width", "height", "picPath", "tmpPath", "frameCount", "frameRate", "estimateCompressRate", "Lcom/tencent/mobileqq/zplan/meme/animation2D/e;", "e", "filename", "o", "Lkotlin/Function1;", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zplan/meme/animation2D/c;", "g", "needEncodeCover", "Lcom/tencent/mobileqq/zplan/meme/animation2D/Anim2DEncoderHelper$a;", "encodeListener", h.F, "id", "pngPath", "cacheDir", "c", "Lzx4/d;", "b", "Lkotlin/Lazy;", "k", "()Lzx4/d;", "configProxy", DomainData.DOMAIN_NAME, "()I", "LIMIT_FRAME_COUNT", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class Anim2DEncoderHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final Anim2DEncoderHelper f333888a = new Anim2DEncoderHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy configProxy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy LIMIT_FRAME_COUNT;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/animation2D/Anim2DEncoderHelper$a;", "", "", "code", "", "b", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
        void a(int code);

        void b(int code);
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f333891a;

        static {
            int[] iArr = new int[MODE.values().length];
            try {
                iArr[MODE.SHARPP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MODE.GIF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f333891a = iArr;
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<zx4.d>() { // from class: com.tencent.mobileqq.zplan.meme.animation2D.Anim2DEncoderHelper$configProxy$2
            @Override // kotlin.jvm.functions.Function0
            public final zx4.d invoke() {
                return (zx4.d) mx4.a.f417748a.a(zx4.d.class);
            }
        });
        configProxy = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.zplan.meme.animation2D.Anim2DEncoderHelper$LIMIT_FRAME_COUNT$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                zx4.d k3;
                k3 = Anim2DEncoderHelper.f333888a.k();
                return Integer.valueOf(k3 != null ? k3.l() : 1);
            }
        });
        LIMIT_FRAME_COUNT = lazy2;
    }

    Anim2DEncoderHelper() {
    }

    private final e e(MODE mode, int width, int height, String picPath, String tmpPath, int frameCount, int frameRate, float estimateCompressRate) {
        int i3 = b.f333891a[mode.ordinal()];
        boolean z16 = true;
        if (i3 == 1) {
            return new Anim2DSharppEncoder(width, height, frameCount, frameRate, estimateCompressRate);
        }
        if (i3 != 2) {
            QLog.e("Anim2DEncoderHelper", 1, mode + " not support");
            return null;
        }
        if (!(tmpPath == null || tmpPath.length() == 0)) {
            if (picPath != null && picPath.length() != 0) {
                z16 = false;
            }
            if (!z16) {
                return new Anim2DGifEncoder(frameCount, frameRate, tmpPath, picPath);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Bitmap bitmap, Anim2DRecordData data, a aVar, Map reportMap) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        int i3 = -18002;
        if (bitmap != null) {
            String coverPath = data.getCoverPath();
            if (!(coverPath == null || coverPath.length() == 0)) {
                try {
                    d dVar = d.f333935a;
                    String coverPath2 = data.getCoverPath();
                    Intrinsics.checkNotNull(coverPath2);
                    d.g(dVar, bitmap, 0, coverPath2, 2, null);
                    bitmap.recycle();
                    i3 = 0;
                } catch (Exception e16) {
                    QLog.e("Anim2DEncoderHelper", 1, "encodeCoverPNG saveBitmapFileAsPNG error", e16);
                    reportMap.put("zplan_emoticon_2d_error_code", "-18019");
                    ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", reportMap);
                    Unit unit = Unit.INSTANCE;
                } finally {
                    bitmap.recycle();
                }
                if (aVar != null) {
                    aVar.b(i3);
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b(-18002);
        }
        if (bitmap != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zx4.d k() {
        return (zx4.d) configProxy.getValue();
    }

    private final int l(int errCode, MODE mode) {
        MODE mode2 = MODE.SHARPP;
        if (mode == mode2 && errCode == -18011) {
            return -18011;
        }
        if (mode == MODE.GIF && errCode == -18012) {
            return -18012;
        }
        return mode == mode2 ? -18004 : -18014;
    }

    private final Sequence<File> m(String filename, Function1<? super File, Boolean> p16) {
        FileTreeWalk walk$default;
        Sequence<File> filter;
        walk$default = FilesKt__FileTreeWalkKt.walk$default(new File(filename), null, 1, null);
        filter = SequencesKt___SequencesKt.filter(walk$default, p16);
        return filter;
    }

    private final int n() {
        return ((Number) LIMIT_FRAME_COUNT.getValue()).intValue();
    }

    private final Sequence<File> o(String filename) {
        Sequence<File> sortedWith;
        Sequence<File> m3 = m(filename, new Function1<File, Boolean>() { // from class: com.tencent.mobileqq.zplan.meme.animation2D.Anim2DEncoderHelper$getResourceFiles$files$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File it) {
                String extension;
                Intrinsics.checkNotNullParameter(it, "it");
                extension = FilesKt__UtilsKt.getExtension(it);
                return Boolean.valueOf(Intrinsics.areEqual(extension, "png"));
            }
        });
        final Anim2DEncoderHelper$getResourceFiles$files$2 anim2DEncoderHelper$getResourceFiles$files$2 = new Function2<File, File, Integer>() { // from class: com.tencent.mobileqq.zplan.meme.animation2D.Anim2DEncoderHelper$getResourceFiles$files$2
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(File file, File file2) {
                int indexOf$default;
                int indexOf$default2;
                int i3 = 0;
                try {
                    String name = file.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "o1.name");
                    String name2 = file.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "o1.name");
                    indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) name2, ".", 0, false, 6, (Object) null);
                    String substring = name.substring(0, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    int parseInt = Integer.parseInt(substring);
                    String name3 = file2.getName();
                    Intrinsics.checkNotNullExpressionValue(name3, "o2.name");
                    String name4 = file2.getName();
                    Intrinsics.checkNotNullExpressionValue(name4, "o2.name");
                    indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) name4, ".", 0, false, 6, (Object) null);
                    String substring2 = name3.substring(0, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    i3 = parseInt - Integer.parseInt(substring2);
                } catch (Throwable unused) {
                }
                return Integer.valueOf(i3);
            }
        };
        sortedWith = SequencesKt___SequencesKt.sortedWith(m3, new Comparator() { // from class: com.tencent.mobileqq.zplan.meme.animation2D.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int p16;
                p16 = Anim2DEncoderHelper.p(Function2.this, obj, obj2);
                return p16;
            }
        });
        return sortedWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    private final boolean q(String retPath, byte[] data, int length) {
        if (TextUtils.isEmpty(retPath) || data == null || length == 0) {
            return false;
        }
        try {
            com.tencent.zplan.common.utils.c.f385288a.c(retPath);
            FileOutputStream fileOutputStream = new FileOutputStream(retPath);
            try {
                fileOutputStream.write(data, 0, length);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
                return true;
            } finally {
            }
        } catch (Throwable th5) {
            QLog.e("Anim2DEncoderHelper", 1, "savePath to " + retPath + " exception", th5);
            return false;
        }
    }

    public final int g(Anim2DRecordData data) {
        int i3;
        int i16;
        boolean z16;
        int count;
        int count2;
        Intrinsics.checkNotNullParameter(data, "data");
        long currentTimeMillis = System.currentTimeMillis();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_emoticon_2d_id", String.valueOf(data.getId()));
        linkedHashMap.put("zplan_emoticon_2d_width", String.valueOf(data.getWidth()));
        linkedHashMap.put("zplan_emoticon_2d_height", String.valueOf(data.getHeight()));
        linkedHashMap.put("zplan_emoticon_2d_cache", "0");
        MODE mode = MODE.FRAME;
        linkedHashMap.put("zplan_emoticon_2d_encode_mode", mode.toString());
        if (data.getCoverPath() == null) {
            linkedHashMap.put("zplan_emoticon_2d_error_code", "-18002");
            ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
            return -18002;
        }
        String coverPath = data.getCoverPath();
        Intrinsics.checkNotNull(coverPath);
        if (new File(coverPath).exists()) {
            linkedHashMap.put("zplan_emoticon_2d_error_code", "0");
            linkedHashMap.put("zplan_emoticon_2d_cache", "1");
            linkedHashMap.put("zplan_emoticon_2d_cost", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
            ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
            return 0;
        }
        if (!new File(data.getAvatarPath()).exists()) {
            linkedHashMap.put("zplan_emoticon_2d_error_code", "-18007");
            ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
            return -18007;
        }
        String fgResDir = data.getFgResDir();
        Sequence<File> o16 = fgResDir != null ? f333888a.o(fgResDir) : null;
        String bgResDir = data.getBgResDir();
        Sequence<File> o17 = bgResDir != null ? f333888a.o(bgResDir) : null;
        if (o16 != null) {
            count2 = SequencesKt___SequencesKt.count(o16);
            i3 = count2;
        } else {
            i3 = 0;
        }
        if (o17 != null) {
            count = SequencesKt___SequencesKt.count(o17);
            i16 = count;
        } else {
            i16 = 0;
        }
        if (i3 == 0 && i16 == 0) {
            linkedHashMap.put("zplan_emoticon_2d_error_code", "-18001");
            ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
            return -18001;
        }
        d dVar = d.f333935a;
        Bitmap b16 = dVar.b(data.getAvatarPath());
        if (b16 == null) {
            QLog.e("Anim2DEncoderHelper", 1, "encodeCoverPNG avatarBitmap is null, return -18008");
            linkedHashMap.put("zplan_emoticon_2d_error_code", "-18008");
            ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
            return -18008;
        }
        Pair<Integer, Bitmap> j3 = j(i16, i3, o16, o17, 0, b16, data.getRadius(), mode, data.getEncodeWidth(), data.getEncodeHeight());
        int intValue = j3.component1().intValue();
        Bitmap component2 = j3.component2();
        if (intValue != 0) {
            QLog.e("Anim2DEncoderHelper", 1, "encodeCoverPNG frameBitmp is null, return " + intValue);
            linkedHashMap.put("zplan_emoticon_2d_error_code", String.valueOf(intValue));
            ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
            b16.recycle();
            if (component2 != null) {
                component2.recycle();
            }
            return intValue;
        }
        if (component2 != null) {
            try {
                String coverPath2 = data.getCoverPath();
                Intrinsics.checkNotNull(coverPath2);
                z16 = d.g(dVar, component2, 0, coverPath2, 2, null);
            } catch (ErrnoException e16) {
                QLog.e("Anim2DEncoderHelper", 1, "encodeCoverPNG saveBitmapFileAsPNG error", e16);
                linkedHashMap.put("zplan_emoticon_2d_error_code", "-18019");
                ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                component2.recycle();
                b16.recycle();
                return -18019;
            }
        } else {
            z16 = false;
        }
        b16.recycle();
        if (component2 != null) {
            component2.recycle();
        }
        if (!z16) {
            linkedHashMap.put("zplan_emoticon_2d_error_code", "-18002");
            ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
            return -18002;
        }
        linkedHashMap.put("zplan_emoticon_2d_error_code", "0");
        linkedHashMap.put("zplan_emoticon_2d_cost", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
        ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int h(final Anim2DRecordData data, boolean needEncodeCover, final a encodeListener) {
        boolean z16;
        String picPath;
        int i3;
        long j3;
        String str;
        Bitmap bitmap;
        long currentTimeMillis;
        int i16;
        int i17;
        int intValue;
        Bitmap component2;
        Sequence<File> sequence;
        boolean z17;
        Sequence<File> sequence2;
        e eVar;
        final Bitmap bitmap2;
        int count;
        Intrinsics.checkNotNullParameter(data, "data");
        long currentTimeMillis2 = System.currentTimeMillis();
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_emoticon_2d_id", String.valueOf(data.getId()));
        linkedHashMap.put("zplan_emoticon_2d_width", String.valueOf(data.getWidth()));
        linkedHashMap.put("zplan_emoticon_2d_height", String.valueOf(data.getHeight()));
        linkedHashMap.put("zplan_emoticon_2d_cache", "0");
        linkedHashMap.put("zplan_emoticon_2d_encode_mode", data.getMode().toString());
        if (data.getPicPath() == null) {
            linkedHashMap.put("zplan_emoticon_2d_error_code", "-18003");
            ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
            if (encodeListener != null) {
                encodeListener.b(-18003);
                Unit unit = Unit.INSTANCE;
            }
            if (encodeListener != null) {
                encodeListener.a(-18003);
                Unit unit2 = Unit.INSTANCE;
            }
            return -18003;
        }
        if (data.getCoverPath() != null) {
            if (needEncodeCover) {
                String coverPath = data.getCoverPath();
                Intrinsics.checkNotNull(coverPath);
                if (new File(coverPath).exists()) {
                    if (encodeListener != null) {
                        encodeListener.b(0);
                        Unit unit3 = Unit.INSTANCE;
                    }
                }
            }
            z16 = needEncodeCover;
            picPath = data.getPicPath();
            Intrinsics.checkNotNull(picPath);
            if (!new File(picPath).exists()) {
                linkedHashMap.put("zplan_emoticon_2d_error_code", "0");
                linkedHashMap.put("zplan_emoticon_2d_cache", "1");
                linkedHashMap.put("zplan_emoticon_2d_cost", String.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                if (encodeListener != null) {
                    encodeListener.a(0);
                    Unit unit4 = Unit.INSTANCE;
                }
                return 0;
            }
            if (!new File(data.getAvatarPath()).exists()) {
                linkedHashMap.put("zplan_emoticon_2d_error_code", "-18007");
                ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                if (encodeListener != null) {
                    encodeListener.b(-18007);
                    Unit unit5 = Unit.INSTANCE;
                }
                if (encodeListener != null) {
                    encodeListener.a(-18007);
                    Unit unit6 = Unit.INSTANCE;
                }
                return -18007;
            }
            String fgResDir = data.getFgResDir();
            Sequence<File> o16 = fgResDir != null ? f333888a.o(fgResDir) : null;
            String bgResDir = data.getBgResDir();
            Sequence<File> o17 = bgResDir != null ? f333888a.o(bgResDir) : null;
            int count2 = o16 != null ? SequencesKt___SequencesKt.count(o16) : 0;
            if (o17 != null) {
                count = SequencesKt___SequencesKt.count(o17);
                i3 = count;
            } else {
                i3 = 0;
            }
            if (count2 == 0 && i3 == 0) {
                linkedHashMap.put("zplan_emoticon_2d_error_code", "-18001");
                ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                if (encodeListener != null) {
                    encodeListener.b(-18001);
                    Unit unit7 = Unit.INSTANCE;
                }
                if (encodeListener != null) {
                    encodeListener.a(-18001);
                    Unit unit8 = Unit.INSTANCE;
                }
                return -18001;
            }
            linkedHashMap.put("zplan_emoticon_2d_bg_count", String.valueOf(i3));
            linkedHashMap.put("zplan_emoticon_2d_fg_count", String.valueOf(count2));
            int max = Math.max(count2, i3);
            int i18 = count2;
            linkedHashMap.put("zplan_emoticon_2d_frame_count", String.valueOf(max));
            float estimateCompressRatePercent = max > n() ? Meme.f385754h.k().getSharpPConfig().getEstimateCompressRatePercent() / 100 : 1.0f;
            if (data.getMode() == MODE.GIF) {
                j3 = currentTimeMillis2;
                str = data.getCacheDir() + File.separator + "gif_" + data.getId();
            } else {
                j3 = currentTimeMillis2;
                str = null;
            }
            e e16 = e(data.getMode(), data.getWidth(), data.getHeight(), data.getPicPath(), str, max, data.getFrameRate() == 0 ? 33 : 1000 / data.getFrameRate(), estimateCompressRatePercent);
            if (e16 == null) {
                linkedHashMap.put("zplan_emoticon_2d_error_code", "-18017");
                ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                if (encodeListener != null) {
                    encodeListener.b(-18017);
                    Unit unit9 = Unit.INSTANCE;
                }
                if (encodeListener != null) {
                    encodeListener.a(-18017);
                    Unit unit10 = Unit.INSTANCE;
                }
                return -18017;
            }
            Bitmap b16 = d.f333935a.b(data.getAvatarPath());
            boolean z18 = true;
            if (b16 == null) {
                QLog.e("Anim2DEncoderHelper", 1, "encodeSharpp avatarBitmap is null, return -18008");
                linkedHashMap.put("zplan_emoticon_2d_error_code", "-18008");
                ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                if (encodeListener != null) {
                    encodeListener.b(-18008);
                    Unit unit11 = Unit.INSTANCE;
                }
                if (encodeListener != null) {
                    encodeListener.a(-18008);
                    Unit unit12 = Unit.INSTANCE;
                }
                return -18008;
            }
            long j16 = 0;
            int i19 = 0;
            int i26 = 0;
            while (i19 < max) {
                try {
                    currentTimeMillis = System.currentTimeMillis();
                    i16 = max;
                    i17 = i18;
                    Pair<Integer, Bitmap> j17 = j(i3, i17, o16, o17, i19, b16, data.getRadius(), data.getMode(), data.getEncodeWidth(), data.getEncodeHeight());
                    intValue = j17.component1().intValue();
                    component2 = j17.component2();
                } catch (Exception e17) {
                    e = e17;
                    bitmap = b16;
                } catch (Throwable th5) {
                    th = th5;
                    bitmap = b16;
                    bitmap.recycle();
                    throw th;
                }
                if (intValue != 0) {
                    QLog.e("Anim2DEncoderHelper", 1, "encodeSharpp frameBitmp is null, return " + intValue);
                    linkedHashMap.put("zplan_emoticon_2d_error_code", String.valueOf(intValue));
                    ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                    if (i19 == 0 && z16 && encodeListener != null) {
                        encodeListener.b(intValue);
                        Unit unit13 = Unit.INSTANCE;
                    }
                    if (encodeListener != null) {
                        encodeListener.a(intValue);
                        Unit unit14 = Unit.INSTANCE;
                    }
                    b16.recycle();
                    Unit unit15 = Unit.INSTANCE;
                    if (component2 != null) {
                        component2.recycle();
                    }
                    b16.recycle();
                    return intValue;
                }
                if (i19 == 0 && z16) {
                    if (component2 != null) {
                        sequence = o16;
                        bitmap2 = component2.copy(component2.getConfig(), false);
                    } else {
                        sequence = o16;
                        bitmap2 = null;
                    }
                    z17 = z16;
                    sequence2 = o17;
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.animation2D.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            Anim2DEncoderHelper.i(bitmap2, data, encodeListener, linkedHashMap);
                        }
                    }, 16, null, true);
                } else {
                    sequence = o16;
                    z17 = z16;
                    sequence2 = o17;
                }
                if (component2 != null) {
                    Pair<Long, Integer> a16 = e16.a(component2, i26);
                    int i27 = i26;
                    long longValue = a16.component1().longValue();
                    int intValue2 = a16.component2().intValue();
                    component2.recycle();
                    if (intValue2 == 0 && longValue > 0) {
                        eVar = e16;
                        bitmap = b16;
                        j16 += longValue;
                        i26 = i27 + 1;
                        try {
                            try {
                                QLog.i("Anim2DEncoderHelper", 1, "end frame encode, cost: " + (System.currentTimeMillis() - currentTimeMillis));
                                Unit unit16 = Unit.INSTANCE;
                            } catch (Throwable th6) {
                                th = th6;
                                bitmap.recycle();
                                throw th;
                            }
                        } catch (Exception e18) {
                            e = e18;
                        }
                    } else {
                        bitmap = b16;
                        QLog.e("Anim2DEncoderHelper", 1, "frame encode failed, length: " + longValue + ", errCode: " + intValue2);
                        int l3 = f333888a.l(intValue2, data.getMode());
                        linkedHashMap.put("zplan_emoticon_2d_error_code", String.valueOf(l3));
                        ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                        if (encodeListener != null) {
                            encodeListener.a(l3);
                            Unit unit17 = Unit.INSTANCE;
                        }
                        bitmap.recycle();
                        return l3;
                    }
                    e = e18;
                    QLog.e("Anim2DEncoderHelper", 1, "frame encode exception, " + e);
                    linkedHashMap.put("zplan_emoticon_2d_error_code", "-18005");
                    ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                    if (encodeListener != null) {
                        encodeListener.a(-18005);
                        Unit unit18 = Unit.INSTANCE;
                    }
                    bitmap.recycle();
                    return -18005;
                }
                eVar = e16;
                bitmap = b16;
                i19++;
                b16 = bitmap;
                e16 = eVar;
                o16 = sequence;
                z16 = z17;
                i18 = i17;
                max = i16;
                z18 = true;
                o17 = sequence2;
            }
            e eVar2 = e16;
            int i28 = max;
            long j18 = j16;
            b16.recycle();
            try {
                try {
                    if (i26 == i28) {
                        try {
                            int c16 = eVar2.c();
                            int i29 = b.f333891a[data.getMode().ordinal()];
                            if (i29 == 1) {
                                String picPath2 = data.getPicPath();
                                Intrinsics.checkNotNull(picPath2);
                                if (!q(picPath2, eVar2.d(), (int) j18)) {
                                    linkedHashMap.put("zplan_emoticon_2d_error_code", "-18003");
                                    ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                                    if (encodeListener != null) {
                                        encodeListener.a(-18003);
                                        Unit unit19 = Unit.INSTANCE;
                                    }
                                    eVar2.b();
                                    return -18003;
                                }
                                Unit unit20 = Unit.INSTANCE;
                            } else {
                                if (i29 != 2) {
                                    QLog.i("Anim2DEncoderHelper", 1, data.getMode() + " not support.");
                                    linkedHashMap.put("zplan_emoticon_2d_error_code", "-18015");
                                    ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                                    if (encodeListener != null) {
                                        encodeListener.a(-18015);
                                        Unit unit21 = Unit.INSTANCE;
                                    }
                                    eVar2.b();
                                    return -18015;
                                }
                                if (c16 < 0) {
                                    linkedHashMap.put("zplan_emoticon_2d_error_code", String.valueOf(c16));
                                    ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                                    if (encodeListener != null) {
                                        encodeListener.a(c16);
                                        Unit unit22 = Unit.INSTANCE;
                                    }
                                    eVar2.b();
                                    return c16;
                                }
                                Unit unit23 = Unit.INSTANCE;
                            }
                            eVar2.b();
                            linkedHashMap.put("zplan_emoticon_2d_error_code", "0");
                            linkedHashMap.put("zplan_emoticon_2d_cost", String.valueOf(System.currentTimeMillis() - j3));
                            ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                            if (encodeListener != null) {
                                encodeListener.a(0);
                            }
                            return 0;
                        } catch (Exception e19) {
                            e = e19;
                            QLog.e("Anim2DEncoderHelper", 1, "endEncode exception, " + e);
                            int i36 = data.getMode() == MODE.GIF ? -18014 : -18004;
                            linkedHashMap.put("zplan_emoticon_2d_error_code", String.valueOf(i36));
                            ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                            if (encodeListener != null) {
                                encodeListener.a(i36);
                                Unit unit24 = Unit.INSTANCE;
                            }
                            eVar2.b();
                            return i36;
                        } catch (Throwable th7) {
                            th = th7;
                            eVar2.b();
                            throw th;
                        }
                    }
                    QLog.i("Anim2DEncoderHelper", 1, "frame count error, curFrame: " + i26 + ", allFrameCount: " + i28 + ", data: " + data);
                    linkedHashMap.put("zplan_emoticon_2d_error_code", "-18016");
                    ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                    if (encodeListener != null) {
                        encodeListener.a(-18016);
                        Unit unit25 = Unit.INSTANCE;
                    }
                    eVar2.b();
                    return -18016;
                } catch (Exception e26) {
                    e = e26;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } else if (encodeListener != null) {
            encodeListener.b(-18002);
            Unit unit26 = Unit.INSTANCE;
        }
        z16 = false;
        picPath = data.getPicPath();
        Intrinsics.checkNotNull(picPath);
        if (!new File(picPath).exists()) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0130, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x012d, code lost:
    
        if (r4 == null) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0112 A[Catch: all -> 0x0131, TryCatch #0 {all -> 0x0131, blocks: (B:29:0x00f5, B:31:0x0112, B:36:0x011e), top: B:28:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011e A[Catch: all -> 0x0131, TRY_LEAVE, TryCatch #0 {all -> 0x0131, blocks: (B:29:0x00f5, B:31:0x0112, B:36:0x011e), top: B:28:0x00f5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Pair<Integer, Bitmap> j(int bgCount, int fgCount, Sequence<? extends File> fgFiles, Sequence<? extends File> bgFiles, int i3, Bitmap avatarBitmap, float radius, MODE mode, int encodeWidth, int encodeHeight) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Pair<Integer, Bitmap> pair;
        Pair<Integer, Bitmap> pair2;
        Object elementAt;
        Object elementAt2;
        Bitmap bitmap3;
        Object elementAt3;
        Object elementAt4;
        zx4.d k3;
        try {
            boolean f16 = (b.f333891a[mode.ordinal()] != 2 || (k3 = k()) == null) ? false : k3.f();
            if (bgCount == 0 && fgCount > 0) {
                d dVar = d.f333935a;
                Intrinsics.checkNotNull(fgFiles);
                elementAt4 = SequencesKt___SequencesKt.elementAt(fgFiles, i3);
                String path = ((File) elementAt4).getPath();
                Intrinsics.checkNotNullExpressionValue(path, "fgFiles!!.elementAt(i).path");
                bitmap = dVar.b(path);
                if (bitmap != null) {
                    try {
                        bitmap3 = dVar.e(null, avatarBitmap, bitmap, radius, f16, encodeWidth, encodeHeight);
                    } catch (Throwable th5) {
                        th = th5;
                        bitmap2 = null;
                        QLog.e("Anim2DEncoderHelper", 1, "getFrameBitmap exception, " + th);
                        if (!(th instanceof OutOfMemoryError)) {
                        }
                        pair2 = pair;
                        if (bitmap != null) {
                        }
                    }
                } else {
                    bitmap3 = null;
                }
                bitmap2 = null;
            } else if (bgCount > 0 && fgCount == 0) {
                d dVar2 = d.f333935a;
                Intrinsics.checkNotNull(bgFiles);
                elementAt3 = SequencesKt___SequencesKt.elementAt(bgFiles, i3);
                String path2 = ((File) elementAt3).getPath();
                Intrinsics.checkNotNullExpressionValue(path2, "bgFiles!!.elementAt(i).path");
                Bitmap b16 = dVar2.b(path2);
                if (b16 != null) {
                    try {
                        bitmap3 = dVar2.e(b16, avatarBitmap, null, radius, f16, encodeWidth, encodeHeight);
                    } catch (Throwable th6) {
                        th = th6;
                        bitmap2 = b16;
                        bitmap = null;
                        QLog.e("Anim2DEncoderHelper", 1, "getFrameBitmap exception, " + th);
                        if (!(th instanceof OutOfMemoryError)) {
                            pair = new Pair<>(-18010, null);
                        } else {
                            pair = new Pair<>(-18009, null);
                        }
                        pair2 = pair;
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                    }
                } else {
                    bitmap3 = null;
                }
                bitmap2 = b16;
                bitmap = null;
            } else {
                d dVar3 = d.f333935a;
                Intrinsics.checkNotNull(bgFiles);
                elementAt = SequencesKt___SequencesKt.elementAt(bgFiles, i3 % bgCount);
                String path3 = ((File) elementAt).getPath();
                Intrinsics.checkNotNullExpressionValue(path3, "bgFiles!!.elementAt(i % bgCount).path");
                bitmap2 = dVar3.b(path3);
                try {
                    Intrinsics.checkNotNull(fgFiles);
                    elementAt2 = SequencesKt___SequencesKt.elementAt(fgFiles, i3 % fgCount);
                    String path4 = ((File) elementAt2).getPath();
                    Intrinsics.checkNotNullExpressionValue(path4, "fgFiles!!.elementAt(i % fgCount).path");
                    bitmap = dVar3.b(path4);
                    if (bitmap2 == null || bitmap == null) {
                        bitmap3 = null;
                    } else {
                        try {
                            bitmap3 = dVar3.e(bitmap2, avatarBitmap, bitmap, radius, f16, encodeWidth, encodeHeight);
                        } catch (Throwable th7) {
                            th = th7;
                            try {
                                QLog.e("Anim2DEncoderHelper", 1, "getFrameBitmap exception, " + th);
                                if (!(th instanceof OutOfMemoryError)) {
                                }
                                pair2 = pair;
                                if (bitmap != null) {
                                }
                            } finally {
                                if (bitmap != null) {
                                    bitmap.recycle();
                                }
                                if (bitmap2 != null) {
                                    bitmap2.recycle();
                                }
                            }
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                    bitmap = null;
                    QLog.e("Anim2DEncoderHelper", 1, "getFrameBitmap exception, " + th);
                    if (!(th instanceof OutOfMemoryError)) {
                    }
                    pair2 = pair;
                    if (bitmap != null) {
                    }
                }
            }
            pair2 = new Pair<>(Integer.valueOf(bitmap3 == null ? -18009 : 0), bitmap3);
        } catch (Throwable th9) {
            th = th9;
            bitmap = null;
            bitmap2 = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0207  */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.tencent.zplan.engine.service.ZPlanEngineQualityReporter] */
    /* JADX WARN: Type inference failed for: r1v18, types: [com.tencent.zplan.meme.action.MODE] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int c(int id5, int width, int height, MODE mode, String pngPath, String retPath, String cacheDir, float radius) {
        ?? r16;
        ?? r26;
        LinkedHashMap linkedHashMap;
        String str;
        e f16;
        Pair<Long, Integer> pair;
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(pngPath, "pngPath");
        Intrinsics.checkNotNullParameter(retPath, "retPath");
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        long currentTimeMillis = System.currentTimeMillis();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("zplan_emoticon_2d_id", String.valueOf(id5));
        linkedHashMap2.put("zplan_emoticon_2d_width", String.valueOf(width));
        linkedHashMap2.put("zplan_emoticon_2d_height", String.valueOf(height));
        linkedHashMap2.put("zplan_emoticon_2d_cache", "0");
        linkedHashMap2.put("zplan_emoticon_2d_encode_mode", mode.toString());
        if (!new File(pngPath).exists()) {
            linkedHashMap2.put("zplan_emoticon_2d_error_code", "-18006");
            ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap2);
            return -18006;
        }
        linkedHashMap2.put("zplan_emoticon_2d_bg_count", "0");
        linkedHashMap2.put("zplan_emoticon_2d_fg_count", "0");
        linkedHashMap2.put("zplan_emoticon_2d_frame_count", "1");
        try {
            if (mode == MODE.GIF) {
                str = cacheDir + File.separator + "gif_" + id5;
            } else {
                str = null;
            }
            r16 = mode;
            r26 = width;
            linkedHashMap = linkedHashMap2;
            try {
                f16 = f(this, r16, r26, height, retPath, str, 1, 0, 1.0f, 64, null);
            } catch (Exception unused) {
                r16 = "zplan_emoticon_2d_error_code";
            }
        } catch (Exception unused2) {
            r16 = "zplan_emoticon_2d_error_code";
            r26 = "zplan_emoticon_2d";
            linkedHashMap = linkedHashMap2;
        }
        try {
            if (f16 == null) {
                r16 = "zplan_emoticon_2d_error_code";
                try {
                    linkedHashMap.put(r16, "-18017");
                    ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                    return -18017;
                } catch (Exception unused3) {
                    r26 = "zplan_emoticon_2d";
                    if (mode != MODE.GIF) {
                    }
                    linkedHashMap.put(r16, String.valueOf(r0));
                    ZPlanEngineQualityReporter.f385585b.b(r26, linkedHashMap);
                    return r0;
                }
            }
            int[] iArr = b.f333891a;
            int i3 = iArr[mode.ordinal()];
            if (i3 == 1) {
                d dVar = d.f333935a;
                Bitmap b16 = dVar.b(pngPath);
                if (b16 == null) {
                    QLog.e("Anim2DEncoderHelper", 1, "PNGToPic avatarBitmap is null, return");
                    linkedHashMap.put("zplan_emoticon_2d_error_code", "-18008");
                    ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                    return -18008;
                }
                Bitmap d16 = d.d(dVar, b16, radius, false, 4, null);
                Pair<Long, Integer> a16 = f16.a(d16, 0);
                b16.recycle();
                d16.recycle();
                pair = a16;
            } else if (i3 != 2) {
                pair = new Pair<>(0L, -18015);
            } else {
                pair = f16.encode(pngPath);
            }
            long longValue = pair.component1().longValue();
            int intValue = pair.component2().intValue();
            if (intValue == 0 && longValue > 0) {
                long j3 = longValue + 0;
                int c16 = f16.c();
                int i16 = iArr[mode.ordinal()];
                if (i16 != 1) {
                    if (i16 != 2) {
                        QLog.i("Anim2DEncoderHelper", 1, mode + " not support.");
                        linkedHashMap.put("zplan_emoticon_2d_error_code", "-18015");
                        ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                        return -18015;
                    }
                    if (c16 < 0) {
                        linkedHashMap.put("zplan_emoticon_2d_error_code", String.valueOf(c16));
                        ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                        return c16;
                    }
                } else if (!q(retPath, f16.d(), (int) j3)) {
                    linkedHashMap.put("zplan_emoticon_2d_error_code", "-18003");
                    ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                    return -18003;
                }
                f16.b();
                linkedHashMap.put("zplan_emoticon_2d_error_code", "0");
                linkedHashMap.put("zplan_emoticon_2d_cost", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
                return 0;
            }
            int l3 = l(intValue, mode);
            linkedHashMap.put("zplan_emoticon_2d_error_code", String.valueOf(l3));
            ZPlanEngineQualityReporter.f385585b.b("zplan_emoticon_2d", linkedHashMap);
            return l3;
        } catch (Exception unused4) {
            int i17 = mode != MODE.GIF ? -18014 : -18004;
            linkedHashMap.put(r16, String.valueOf(i17));
            ZPlanEngineQualityReporter.f385585b.b(r26, linkedHashMap);
            return i17;
        }
    }

    static /* synthetic */ e f(Anim2DEncoderHelper anim2DEncoderHelper, MODE mode, int i3, int i16, String str, String str2, int i17, int i18, float f16, int i19, Object obj) {
        return anim2DEncoderHelper.e(mode, i3, i16, (i19 & 8) != 0 ? null : str, (i19 & 16) != 0 ? null : str2, i17, (i19 & 64) != 0 ? 33 : i18, (i19 & 128) != 0 ? Meme.f385754h.k().getSharpPConfig().getEstimateCompressRatePercent() / 100 : f16);
    }
}
