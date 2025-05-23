package ik2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.common.GifUtil;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.operator.IClipSourceOperator;
import com.tencent.tavcut.rendermodel.RenderModel;
import cooperation.qzone.util.GifCoder;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J:\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0002J.\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J \u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J0\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0010J\u001e\u0010#\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0010\u00a8\u0006&"}, d2 = {"Lik2/g;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "Lik2/d;", "clipData", "Landroid/graphics/Point;", "d", "", tl.h.F, "Lcooperation/qzone/util/GifCoder;", "gifEncoder", "Lbe4/b;", "provider", "Lik2/h;", "callback", "", "gifRate", "", "c", "status", "gifExportProgress", "Lik2/e;", "gifFileInfo", "f", "Landroid/graphics/Bitmap;", TtmlNode.ATTR_TTS_ORIGIN, "gifSize", "b", "Landroid/content/Context;", "context", "i", "originPath", "targetPath", "lossy", "e", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f407918a = new g();

    g() {
    }

    private final Bitmap b(Bitmap origin, GifClipData clipData, Point gifSize) {
        int coerceAtMost;
        int coerceAtMost2;
        int width = origin.getWidth();
        int height = origin.getHeight();
        int i3 = gifSize.x;
        int i16 = gifSize.y;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost((int) (clipData.getLeft() * width), width - i3);
        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost((int) (clipData.getTop() * height), height - i16);
        QLog.i("GiftMakeUtil_", 4, "bitmapClip newWidth:" + i3 + ", newHeight:" + i16 + ", x:" + coerceAtMost + ", y:" + coerceAtMost2 + ", oriWidth:" + width + ", oriHeight:" + height);
        Bitmap createBitmap = Bitmap.createBitmap(origin, coerceAtMost, coerceAtMost2, i3, i16);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(origin, x, y, newWidth, newHeight)");
        return createBitmap;
    }

    private final void c(GifCoder gifEncoder, be4.b provider, LocalMediaInfo mediaInfo, h callback, GifClipData clipData, int gifRate) {
        int coerceAtLeast;
        int coerceAtMost;
        String absolutePath;
        String substringBeforeLast$default;
        int coerceAtLeast2;
        int coerceAtMost2;
        int i3;
        long j3;
        int i16;
        int i17;
        Point point;
        GifCoder gifCoder = gifEncoder;
        LocalMediaInfo localMediaInfo = mediaInfo;
        GifClipData gifClipData = clipData;
        Point d16 = d(localMediaInfo, gifClipData);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(gifRate, 10);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 30);
        String h16 = h(localMediaInfo);
        int i18 = 1000 / coerceAtMost;
        QLog.i("GiftMakeUtil_", 2, "buildGif rate:" + coerceAtMost + ", duration:" + localMediaInfo.mDuration + ", timeDelta:" + i18 + ", gifSize:" + d16);
        long currentTimeMillis = System.currentTimeMillis();
        long j16 = (long) i18;
        long j17 = localMediaInfo.mDuration / j16;
        gifCoder.initEncoder(d16.x, d16.y, h16);
        long j18 = j17;
        g(this, callback, 1, 0, null, 8, null);
        long j19 = 0;
        int i19 = 0;
        int i26 = 0;
        while (j19 <= localMediaInfo.mDuration) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Bitmap coverAtTime = provider.getCoverAtTime(j19);
            long j26 = j19 + j16;
            int i27 = i26 + 1;
            if (coverAtTime == null) {
                i3 = i27;
                point = d16;
                i17 = i18;
                j3 = j18;
                i16 = i19;
            } else {
                Bitmap b16 = b(coverAtTime, gifClipData, d16);
                long currentTimeMillis3 = System.currentTimeMillis();
                gifCoder.encodeFrame(b16, i18);
                long j27 = j18;
                coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast((int) (((i27 * 1.0f) / ((float) j27)) * 100.0f), i19);
                coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(coerceAtLeast2, 99);
                i3 = i27;
                j3 = j27;
                i16 = i19;
                g(this, callback, 2, coerceAtMost2, null, 8, null);
                long currentTimeMillis4 = System.currentTimeMillis();
                long j28 = currentTimeMillis4 - currentTimeMillis2;
                long j29 = currentTimeMillis3 - currentTimeMillis2;
                Integer valueOf = Integer.valueOf(coverAtTime.getWidth());
                Integer valueOf2 = Integer.valueOf(coverAtTime.getHeight());
                i17 = i18;
                StringBuilder sb5 = new StringBuilder();
                point = d16;
                sb5.append("buildGif[");
                sb5.append(i3);
                sb5.append("] loopCost:");
                sb5.append(j28);
                sb5.append(", coverCost:");
                sb5.append(j29);
                sb5.append(", encodeFrameCost:");
                sb5.append(currentTimeMillis4 - currentTimeMillis3);
                sb5.append(", totalCost:");
                sb5.append(currentTimeMillis4 - currentTimeMillis);
                sb5.append(", bitmapW:");
                sb5.append(valueOf);
                sb5.append(", bitmapH:");
                sb5.append(valueOf2);
                QLog.i("GiftMakeUtil_", 4, sb5.toString());
            }
            gifCoder = gifEncoder;
            localMediaInfo = mediaInfo;
            gifClipData = clipData;
            i18 = i17;
            i26 = i3;
            d16 = point;
            i19 = i16;
            j19 = j26;
            j18 = j3;
        }
        Point point2 = d16;
        gifEncoder.closeEncoder();
        File file = new File(h16);
        File parentFile = file.getParentFile();
        if (parentFile == null || (absolutePath = parentFile.getAbsolutePath()) == null) {
            absolutePath = BaseApplication.context.getFilesDir().getAbsolutePath();
        }
        String str = File.separator;
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "oriGif.name");
        substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(name, ".", (String) null, 2, (Object) null);
        String e16 = e(h16, absolutePath + str + substringBeforeLast$default + "_final.gif", 70);
        FileUtils.deleteFile(h16);
        f(callback, 3, 100, new GifFileInfo(e16, point2.x, point2.y));
    }

    private final Point d(LocalMediaInfo mediaInfo, GifClipData clipData) {
        return new Point((int) ((clipData.getRight() - clipData.getLeft()) * mediaInfo.mediaWidth), (int) ((clipData.getBottom() - clipData.getTop()) * mediaInfo.mediaHeight));
    }

    private final void f(h callback, int status, int gifExportProgress, GifFileInfo gifFileInfo) {
        if (status != 1) {
            if (status != 3) {
                if (status == 4) {
                    callback.t7();
                    return;
                }
                return;
            } else if (gifFileInfo != null) {
                callback.s2(gifFileInfo);
                return;
            } else {
                callback.t7();
                return;
            }
        }
        callback.t2();
    }

    static /* synthetic */ void g(g gVar, h hVar, int i3, int i16, GifFileInfo gifFileInfo, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        if ((i17 & 8) != 0) {
            gifFileInfo = null;
        }
        gVar.f(hVar, i3, i16, gifFileInfo);
    }

    private final String h(LocalMediaInfo mediaInfo) {
        String absolutePath;
        String substringBeforeLast$default;
        File file = new File(mediaInfo.path);
        File parentFile = file.getParentFile();
        if (parentFile == null || (absolutePath = parentFile.getAbsolutePath()) == null) {
            absolutePath = BaseApplication.context.getFilesDir().getAbsolutePath();
        }
        String str = File.separator;
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "sourceVideoFile.name");
        substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(name, ".", (String) null, 2, (Object) null);
        String str2 = absolutePath + str + substringBeforeLast$default + "_" + System.currentTimeMillis() + QzoneEmotionUtils.SIGN_ICON_URL_END;
        File file2 = new File(str2);
        QLog.i("GiftMakeUtil_", 1, "gifFilePath gifPath:" + str2 + ", exits:" + file2.exists());
        file2.delete();
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(be4.b coverProvider, LocalMediaInfo mediaInfo, h callback, GifClipData clipData, int i3) {
        Intrinsics.checkNotNullParameter(coverProvider, "$coverProvider");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(clipData, "$clipData");
        f407918a.c(new GifCoder(), coverProvider, mediaInfo, callback, clipData, i3);
        coverProvider.release();
    }

    @NotNull
    public final String e(@NotNull String originPath, @NotNull String targetPath, int lossy) {
        Intrinsics.checkNotNullParameter(originPath, "originPath");
        Intrinsics.checkNotNullParameter(targetPath, "targetPath");
        QLog.i("GiftMakeUtil_", 2, "oriGif size:" + new File(originPath).length());
        File file = new File(targetPath);
        if (file.exists()) {
            file.delete();
        }
        long currentTimeMillis = System.currentTimeMillis();
        int compressGif = GifUtil.compressGif(originPath, targetPath, lossy);
        long currentTimeMillis2 = System.currentTimeMillis();
        QLog.i("GiftMakeUtil_", 2, "compressGif size:" + file.length() + ", duration:" + (currentTimeMillis2 - currentTimeMillis) + ", ret:" + compressGif);
        return targetPath;
    }

    public final void i(@NotNull Context context, @NotNull final LocalMediaInfo mediaInfo, @NotNull final h callback, @NotNull final GifClipData clipData, final int gifRate) {
        ArrayList arrayListOf;
        String absolutePath;
        String absolutePath2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(clipData, "clipData");
        QLog.i("GiftMakeUtil_", 4, mediaInfo.toJsonString());
        QLog.i("GiftMakeUtil_", 1, "toGif path:" + mediaInfo.path + ", clipData:" + clipData + ", rate:" + gifRate);
        od4.b bVar = od4.b.f422509e;
        com.tencent.tavcut.session.a h16 = bVar.h();
        RenderModel x16 = bVar.x(null);
        if (x16 == null) {
            QLog.e("GiftMakeUtil_", 4, "toGif renderMode is null 1");
            g(this, callback, 4, 0, null, 12, null);
            return;
        }
        i.f407919a.a(mediaInfo);
        Size size = new Size(Integer.valueOf(mediaInfo.mediaWidth), Integer.valueOf(mediaInfo.mediaHeight), null, 4, null);
        h16.g(x16);
        h16.p(bVar.g(new FrameLayout(context)));
        IClipSourceOperator clipSourceOperator = h16.getClipSourceOperator();
        xd4.d m3 = bVar.m();
        String str = mediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str, "mediaInfo.path");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(m3.b(str, new TimeRange(0L, mediaInfo.mDuration * 1000, null, 4, null)));
        File file = new File(mediaInfo.path);
        clipSourceOperator.g(arrayListOf);
        h16.q(size);
        RenderModel renderModel = h16.getRenderModel();
        if (renderModel == null) {
            QLog.e("GiftMakeUtil_", 4, "toGif renderMode is null 2");
            g(this, callback, 4, 0, null, 12, null);
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && (absolutePath2 = parentFile.getAbsolutePath()) != null) {
            absolutePath = absolutePath2;
        } else {
            absolutePath = context.getFilesDir().getAbsolutePath();
        }
        Intrinsics.checkNotNullExpressionValue(absolutePath, "sourceFile.parentFile?.a\u2026ext.filesDir.absolutePath");
        final be4.b d16 = od4.b.d(bVar, renderModel, size, absolutePath, null, 8, null);
        ThreadManagerV2.excute(new Runnable() { // from class: ik2.f
            @Override // java.lang.Runnable
            public final void run() {
                g.j(be4.b.this, mediaInfo, callback, clipData, gifRate);
            }
        }, 64, null, false);
    }
}
