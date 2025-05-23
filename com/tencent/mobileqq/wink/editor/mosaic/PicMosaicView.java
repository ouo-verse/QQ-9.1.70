package com.tencent.mobileqq.wink.editor.mosaic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.mosaic.model.MosaicLinePath;
import com.tencent.mobileqq.wink.mosaic.model.PointAction;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 h2\u00020\u0001:\u0001\rB\u001d\b\u0007\u0012\u0006\u0010c\u001a\u00020b\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010d\u00a2\u0006\u0004\bf\u0010gJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J)\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J(\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u0012\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0018\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010H\u0014J\u000e\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000bJ\u0012\u0010&\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0019J\u000e\u0010+\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020)J\u001e\u0010.\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bJ\u0014\u00100\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0015J\b\u00101\u001a\u0004\u0018\u00010\u0019J\b\u00102\u001a\u00020\u0004H\u0014J\u0006\u00103\u001a\u00020\u000eJ\u0006\u00104\u001a\u00020\u000eJ\u0016\u00107\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u0010R\u0016\u0010$\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00108R\u0016\u00109\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010;R\u0018\u0010'\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010=R(\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00060?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR(\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010@\u001a\u0004\bG\u0010B\"\u0004\bH\u0010DR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR$\u0010U\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0016\u00106\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010VR\u0016\u00105\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010VR\u0016\u0010Y\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010VR\u0016\u0010Z\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010VR\u0018\u0010]\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u00108R\u0016\u0010a\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u00108\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/mosaic/PicMosaicView;", "Landroid/widget/ImageView;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "c", "Lcom/tencent/mobileqq/wink/mosaic/model/MosaicLinePath;", "desc", "d", tl.h.F, "l", "", "factor", "a", "", "j", "", "f", "Landroid/graphics/Bitmap$CompressFormat;", "format", CustomImageProps.QUALITY, "", "path", "b", "(Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Ljava/lang/Boolean;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "p", "i", "missionID", WadlProxyConsts.PARAM_FILENAME, "e", DomainData.DOMAIN_NAME, "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "baseScale", "setBaseScale", "onDraw", "originBitmap", "setOriginBitmap", "Landroid/view/MotionEvent;", "event", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "currentScale", "maxScale", "r", "business", "o", "g", NodeProps.ON_DETACHED_FROM_WINDOW, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "bitmapViewWidth", "bitmapViewHeight", "setMeasureWidthAndHeight", UserInfo.SEX_FEMALE, "strokeMosaicWidth", "Landroid/graphics/BitmapShader;", "Landroid/graphics/BitmapShader;", "mosaicShader", "Landroid/graphics/Bitmap;", "mosaicBitmap", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getUnDoPathList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setUnDoPathList", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "unDoPathList", BdhLogUtil.LogTag.Tag_Conn, "getReDoPathList", "setReDoPathList", "reDoPathList", "Landroid/graphics/Paint;", "D", "Landroid/graphics/Paint;", "mLinePaint", "Lq83/a;", "E", "Lq83/a;", "getMosaicPaintUpdateCallback", "()Lq83/a;", "setMosaicPaintUpdateCallback", "(Lq83/a;)V", "mosaicPaintUpdateCallback", "I", "G", "H", "mDownX", "mDownY", "J", "Lcom/tencent/mobileqq/wink/mosaic/model/MosaicLinePath;", "mCurPath", "K", "mLastX", "L", "mLastY", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "N", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PicMosaicView extends ImageView {
    private static int P;
    private static int Q;
    private static int R;
    private static float S;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private CopyOnWriteArrayList<MosaicLinePath> reDoPathList;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Paint mLinePaint;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private q83.a mosaicPaintUpdateCallback;

    /* renamed from: F, reason: from kotlin metadata */
    private int bitmapViewHeight;

    /* renamed from: G, reason: from kotlin metadata */
    private int bitmapViewWidth;

    /* renamed from: H, reason: from kotlin metadata */
    private int mDownX;

    /* renamed from: I, reason: from kotlin metadata */
    private int mDownY;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private MosaicLinePath mCurPath;

    /* renamed from: K, reason: from kotlin metadata */
    private float mLastX;

    /* renamed from: L, reason: from kotlin metadata */
    private float mLastY;

    @NotNull
    public Map<Integer, View> M;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float baseScale;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float strokeMosaicWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BitmapShader mosaicShader;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap originBitmap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap mosaicBitmap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CopyOnWriteArrayList<MosaicLinePath> unDoPathList;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PicMosaicView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final float a(float factor) {
        return (P + ((Q - r0) * factor)) * 3.2f;
    }

    private final Boolean b(Bitmap.CompressFormat format, int quality, String path) {
        Integer num;
        Bitmap bitmap = this.originBitmap;
        if (bitmap != null) {
            Integer num2 = null;
            if (bitmap != null) {
                num = Integer.valueOf(bitmap.getWidth());
            } else {
                num = null;
            }
            if (num != null) {
                Bitmap bitmap2 = this.originBitmap;
                if (bitmap2 != null) {
                    num2 = Integer.valueOf(bitmap2.getHeight());
                }
                if (num2 != null) {
                    Bitmap bitmap3 = this.originBitmap;
                    Intrinsics.checkNotNull(bitmap3);
                    int width = bitmap3.getWidth();
                    Bitmap bitmap4 = this.originBitmap;
                    Intrinsics.checkNotNull(bitmap4);
                    Bitmap mosaicBitmap = Bitmap.createBitmap(width, bitmap4.getHeight(), Bitmap.Config.ARGB_8888);
                    c(new Canvas(mosaicBitmap));
                    Intrinsics.checkNotNullExpressionValue(mosaicBitmap, "mosaicBitmap");
                    return Boolean.valueOf(p(path, mosaicBitmap, format, quality));
                }
            }
        }
        return Boolean.FALSE;
    }

    private final void c(Canvas canvas) {
        Iterator<MosaicLinePath> it = this.unDoPathList.iterator();
        while (it.hasNext()) {
            MosaicLinePath desc = it.next();
            if (canvas != null) {
                canvas.save();
                Intrinsics.checkNotNullExpressionValue(desc, "desc");
                d(canvas, desc);
                canvas.restore();
            }
        }
    }

    private final void d(Canvas canvas, MosaicLinePath desc) {
        if (this.mosaicShader == null) {
            h();
        }
        Paint paint = this.mLinePaint;
        if (paint != null) {
            paint.setXfermode(null);
        }
        BitmapShader bitmapShader = this.mosaicShader;
        if (bitmapShader != null) {
            Paint paint2 = this.mLinePaint;
            if (paint2 != null) {
                paint2.setShader(bitmapShader);
            }
            Paint paint3 = this.mLinePaint;
            if (paint3 != null) {
                paint3.setStrokeWidth(desc.lineWidth);
            }
        }
        if (this.mLinePaint != null) {
            Path path = desc.path;
            Intrinsics.checkNotNull(path);
            Paint paint4 = this.mLinePaint;
            Intrinsics.checkNotNull(paint4);
            canvas.drawPath(path, paint4);
        }
    }

    private final String e(String missionID, String fileName) {
        w53.b.f("PicMosaicView", "genExportFilePath... fileName:" + fileName);
        String str = u53.b.f438373d;
        String str2 = File.separator;
        String str3 = str + str2 + missionID;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str3 + str2 + "output_" + missionID + "_" + fileName + ".png";
    }

    private final int f() {
        return Objects.hashCode(this.unDoPathList) + (Objects.hashCode(this.reDoPathList) * 2);
    }

    private final void h() {
        Bitmap bitmap;
        int coerceAtMost;
        if (this.mosaicShader == null && (bitmap = this.originBitmap) != null) {
            Intrinsics.checkNotNull(bitmap);
            if (!bitmap.isRecycled()) {
                Bitmap bitmap2 = this.originBitmap;
                Intrinsics.checkNotNull(bitmap2);
                int width = bitmap2.getWidth();
                Bitmap bitmap3 = this.originBitmap;
                Intrinsics.checkNotNull(bitmap3);
                Rect rect = new Rect(0, 0, width, bitmap3.getHeight());
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(rect.width(), rect.height());
                int i3 = 8;
                if (coerceAtMost / 8 < 28) {
                    i3 = 2;
                }
                double d16 = i3;
                int a16 = com.tencent.av.doodle.e.a((float) ((rect.width() * 1.0d) / d16));
                int a17 = com.tencent.av.doodle.e.a((float) ((rect.height() * 1.0d) / d16));
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(a16, a17, Bitmap.Config.RGB_565);
                    if (createBitmap != null) {
                        RectF rectF = new RectF(0.0f, 0.0f, a16, a17);
                        Canvas canvas = new Canvas(createBitmap);
                        Bitmap bitmap4 = this.originBitmap;
                        Intrinsics.checkNotNull(bitmap4);
                        canvas.drawBitmap(bitmap4, (Rect) null, rectF, (Paint) null);
                        w53.b.f("PicMosaicView", "initMosaicPicMode. drawRect:" + rect + " -> dst:" + rectF + " reSizeRate:" + i3);
                        int min = Math.min(createBitmap.getWidth(), createBitmap.getHeight()) / 28;
                        if (min == 0) {
                            min = 1;
                        }
                        x63.b.a(createBitmap, min);
                        Bitmap createBitmap2 = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.RGB_565);
                        this.mosaicBitmap = createBitmap2;
                        if (createBitmap2 == null) {
                            createBitmap.recycle();
                            w53.b.c("PicMosaicView", "failed to create mosaic bitmap");
                            return;
                        }
                        Bitmap bitmap5 = this.mosaicBitmap;
                        Intrinsics.checkNotNull(bitmap5);
                        Canvas canvas2 = new Canvas(bitmap5);
                        Matrix matrix = new Matrix();
                        float f16 = i3;
                        matrix.postScale(f16, f16);
                        canvas2.drawBitmap(createBitmap, matrix, null);
                        createBitmap.recycle();
                        Bitmap bitmap6 = this.mosaicBitmap;
                        Intrinsics.checkNotNull(bitmap6);
                        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                        this.mosaicShader = new BitmapShader(bitmap6, tileMode, tileMode);
                    }
                } catch (IllegalArgumentException e16) {
                    w53.b.d("PicMosaicView", "initMosaicPicMode.", e16);
                } catch (OutOfMemoryError e17) {
                    w53.b.d("PicMosaicView", "initMosaicPicMode.", e17);
                }
            }
        }
    }

    private final boolean i(String path) {
        if (TextUtils.isEmpty(path)) {
            return true;
        }
        File file = new File(path);
        if (!file.exists() || file.length() <= 0) {
            return true;
        }
        return false;
    }

    private final boolean j() {
        if (Objects.hashCode(this.unDoPathList) + (Objects.hashCode(this.reDoPathList) * 2) != 3) {
            return true;
        }
        return false;
    }

    private final void l() {
        if (!this.unDoPathList.contains(this.mCurPath)) {
            CopyOnWriteArrayList<MosaicLinePath> copyOnWriteArrayList = this.unDoPathList;
            MosaicLinePath mosaicLinePath = this.mCurPath;
            Intrinsics.checkNotNull(mosaicLinePath);
            copyOnWriteArrayList.add(mosaicLinePath);
            this.reDoPathList.clear();
        }
        q83.a aVar = this.mosaicPaintUpdateCallback;
        if (aVar != null) {
            aVar.y4(this.unDoPathList.size(), this.reDoPathList.size());
        }
    }

    private final void n() {
        Bitmap bitmap = this.originBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.originBitmap = null;
        Bitmap bitmap2 = this.mosaicBitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        this.mosaicBitmap = null;
        this.mosaicShader = null;
    }

    private final boolean p(String path, Bitmap bitmap, Bitmap.CompressFormat format, int quality) {
        FileOutputStream fileOutputStream;
        File file = new File(path);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException e16) {
                    e = e16;
                } catch (IOException e17) {
                    e = e17;
                }
                try {
                    bitmap.compress(format, quality, fileOutputStream);
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (IOException e18) {
                        e18.printStackTrace();
                        return true;
                    }
                } catch (FileNotFoundException e19) {
                    e = e19;
                    fileOutputStream2 = fileOutputStream;
                    e.printStackTrace();
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                        return false;
                    }
                    return false;
                } catch (IOException e26) {
                    e = e26;
                    fileOutputStream2 = fileOutputStream;
                    e.printStackTrace();
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                        return false;
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e28) {
                e28.printStackTrace();
                return false;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Nullable
    public final Bitmap g() {
        Integer num;
        Integer num2;
        if (j()) {
            Bitmap bitmap = this.originBitmap;
            if (bitmap != null) {
                if (bitmap != null) {
                    num = Integer.valueOf(bitmap.getWidth());
                } else {
                    num = null;
                }
                if (num != null) {
                    Bitmap bitmap2 = this.originBitmap;
                    if (bitmap2 != null) {
                        num2 = Integer.valueOf(bitmap2.getHeight());
                    } else {
                        num2 = null;
                    }
                    if (num2 != null) {
                        Bitmap bitmap3 = this.originBitmap;
                        Intrinsics.checkNotNull(bitmap3);
                        int width = bitmap3.getWidth();
                        Bitmap bitmap4 = this.originBitmap;
                        Intrinsics.checkNotNull(bitmap4);
                        Bitmap createBitmap = Bitmap.createBitmap(width, bitmap4.getHeight(), Bitmap.Config.ARGB_8888);
                        c(new Canvas(createBitmap));
                        return createBitmap;
                    }
                }
            }
            w53.b.f("PicMosaicView", "getMosaicBitmap... error");
            return null;
        }
        w53.b.f("PicMosaicView", "getMosaicBitmap... isNeedSave:false");
        return null;
    }

    public final boolean k() {
        if (!this.reDoPathList.isEmpty()) {
            CopyOnWriteArrayList<MosaicLinePath> copyOnWriteArrayList = this.reDoPathList;
            MosaicLinePath remove = copyOnWriteArrayList.remove(copyOnWriteArrayList.size() - 1);
            Intrinsics.checkNotNullExpressionValue(remove, "reDoPathList.removeAt(reDoPathList.size - 1)");
            this.unDoPathList.add(remove);
            q83.a aVar = this.mosaicPaintUpdateCallback;
            if (aVar == null) {
                return true;
            }
            aVar.y4(this.unDoPathList.size(), this.reDoPathList.size());
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
    
        if (r4 != 3) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m(@NotNull MotionEvent event) {
        int roundToInt;
        int roundToInt2;
        int roundToInt3;
        int roundToInt4;
        Intrinsics.checkNotNullParameter(event, "event");
        float x16 = event.getX();
        float y16 = event.getY();
        roundToInt = MathKt__MathJVMKt.roundToInt(event.getX());
        roundToInt2 = MathKt__MathJVMKt.roundToInt(event.getY());
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            roundToInt3 = MathKt__MathJVMKt.roundToInt(x16);
            this.mDownX = roundToInt3;
            roundToInt4 = MathKt__MathJVMKt.roundToInt(y16);
            this.mDownY = roundToInt4;
            this.mLastX = x16;
            this.mLastY = y16;
            MosaicLinePath mosaicLinePath = new MosaicLinePath();
            mosaicLinePath.lineWidth = this.strokeMosaicWidth;
            Path path = mosaicLinePath.path;
            Intrinsics.checkNotNull(path);
            path.reset();
            Path path2 = mosaicLinePath.path;
            Intrinsics.checkNotNull(path2);
            path2.moveTo(x16, y16);
            Path path3 = mosaicLinePath.path;
            Intrinsics.checkNotNull(path3);
            float f16 = 1;
            float f17 = x16 + f16;
            float f18 = f16 + y16;
            path3.lineTo(f17, f18);
            ArrayList<PointAction> arrayList = mosaicLinePath.mTouchPoints;
            Intrinsics.checkNotNull(arrayList);
            arrayList.add(new PointAction(PointAction.MOVETO, x16, y16));
            ArrayList<PointAction> arrayList2 = mosaicLinePath.mTouchPoints;
            Intrinsics.checkNotNull(arrayList2);
            arrayList2.add(new PointAction(PointAction.LINETO, f17, f18));
            this.mCurPath = mosaicLinePath;
        } else {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.mCurPath != null && ((Math.abs(roundToInt - this.mDownX) >= 3 || Math.abs(roundToInt2 - this.mDownY) >= 3) && event.getEventTime() - event.getDownTime() > 100)) {
                        l();
                        float f19 = 2;
                        float f26 = (this.mLastX + x16) / f19;
                        float f27 = (this.mLastY + y16) / f19;
                        MosaicLinePath mosaicLinePath2 = this.mCurPath;
                        if (mosaicLinePath2 != null) {
                            Path path4 = mosaicLinePath2.path;
                            Intrinsics.checkNotNull(path4);
                            path4.quadTo(this.mLastX, this.mLastY, f26, f27);
                            ArrayList<PointAction> arrayList3 = mosaicLinePath2.mTouchPoints;
                            Intrinsics.checkNotNull(arrayList3);
                            arrayList3.add(new PointAction(PointAction.QUADTO, this.mLastX, this.mLastY, f26, f27));
                        }
                        this.mLastX = x16;
                        this.mLastY = y16;
                        invalidate();
                    }
                }
            }
            if (this.mCurPath != null) {
                this.mCurPath = null;
            }
        }
        return true;
    }

    @Nullable
    public final String o(@Nullable String business) {
        boolean z16;
        if (!j()) {
            return null;
        }
        int f16 = f();
        if (business == null) {
            business = WinkContext.INSTANCE.d().getMissionId();
        }
        String e16 = e(business, String.valueOf(f16));
        if (i(e16)) {
            w53.b.f("PicMosaicView", "saveMosaicBitmap... path:" + e16);
            Boolean b16 = b(Bitmap.CompressFormat.PNG, 100, e16);
            if (b16 != null) {
                z16 = b16.booleanValue();
            } else {
                z16 = false;
            }
            if (!z16) {
                return null;
            }
        } else {
            w53.b.f("PicMosaicView", "saveMosaicBitmap... no save old path:" + e16);
        }
        return e16;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w53.b.a("PicMosaicView", "onDetachedFromWindow...");
        n();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (RuntimeException e16) {
            setImageDrawable(null);
            super.onDraw(canvas);
            w53.b.b("PicMosaicView", "onDraw... err: ", e16);
        }
        c(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i3;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int i16 = this.bitmapViewWidth;
        if (i16 != 0 && (i3 = this.bitmapViewHeight) != 0) {
            setMeasuredDimension(i16, i3);
        } else {
            setMeasuredDimension(size, size2);
        }
    }

    public final boolean q() {
        if ((!this.unDoPathList.isEmpty()) && this.reDoPathList.size() < 30) {
            CopyOnWriteArrayList<MosaicLinePath> copyOnWriteArrayList = this.unDoPathList;
            MosaicLinePath remove = copyOnWriteArrayList.remove(copyOnWriteArrayList.size() - 1);
            Intrinsics.checkNotNullExpressionValue(remove, "unDoPathList.removeAt(unDoPathList.size - 1)");
            this.reDoPathList.add(remove);
            q83.a aVar = this.mosaicPaintUpdateCallback;
            if (aVar == null) {
                return true;
            }
            aVar.y4(this.unDoPathList.size(), this.reDoPathList.size());
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0017, code lost:
    
        if (r5 < 0.01f) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r(float baseScale, float currentScale, float maxScale) {
        float f16;
        Paint paint;
        float f17 = maxScale - baseScale;
        float f18 = 0.0f;
        if (f17 <= 0.0f) {
            return;
        }
        float f19 = maxScale - currentScale;
        float f26 = -0.01f;
        if (f19 >= -0.01f) {
            f26 = 0.01f;
        }
        f19 = f26;
        if (f19 > 0.0f) {
            f16 = S;
        } else {
            if (f19 < 0.0f) {
                f16 = S;
                f19 = -f19;
            }
            float a16 = a(f18);
            paint = this.mLinePaint;
            if (paint != null) {
                paint.setStrokeWidth(a16);
            }
            this.strokeMosaicWidth = a16;
        }
        f18 = f16 * (f19 / f17);
        float a162 = a(f18);
        paint = this.mLinePaint;
        if (paint != null) {
        }
        this.strokeMosaicWidth = a162;
    }

    public final void setBaseScale(float baseScale) {
        this.baseScale = baseScale;
    }

    public final void setMeasureWidthAndHeight(int bitmapViewWidth, int bitmapViewHeight) {
        this.bitmapViewWidth = bitmapViewWidth;
        this.bitmapViewHeight = bitmapViewHeight;
    }

    public final void setMosaicPaintUpdateCallback(@Nullable q83.a aVar) {
        this.mosaicPaintUpdateCallback = aVar;
    }

    public final void setOriginBitmap(@NotNull Bitmap originBitmap) {
        Intrinsics.checkNotNullParameter(originBitmap, "originBitmap");
        n();
        this.originBitmap = originBitmap;
        h();
    }

    public final void setReDoPathList(@NotNull CopyOnWriteArrayList<MosaicLinePath> copyOnWriteArrayList) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        this.reDoPathList = copyOnWriteArrayList;
    }

    public final void setUnDoPathList(@NotNull CopyOnWriteArrayList<MosaicLinePath> copyOnWriteArrayList) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        this.unDoPathList = copyOnWriteArrayList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PicMosaicView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.M = new LinkedHashMap();
        this.unDoPathList = new CopyOnWriteArrayList<>();
        this.reDoPathList = new CopyOnWriteArrayList<>();
        this.mDownX = -1;
        this.mDownY = -1;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.mLinePaint = paint;
        P = ViewUtils.dip2px(3.0f);
        Q = ViewUtils.dip2px(32.0f);
        int dip2px = ViewUtils.dip2px(5.0f);
        R = dip2px;
        S = (dip2px * 1.0f) / (Q - P);
    }

    public /* synthetic */ PicMosaicView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
