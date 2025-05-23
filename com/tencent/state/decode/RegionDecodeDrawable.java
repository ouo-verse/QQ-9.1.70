package com.tencent.state.decode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.common.ViewExtensionsKt;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001OB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\b\b\u0002\u0010$\u001a\u00020%H\u0002J*\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010$\u001a\u00020%H\u0002J\b\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020\"H\u0016J\b\u0010,\u001a\u00020\"H\u0002J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020(H\u0002J\u0010\u00103\u001a\u00020\"2\u0006\u00102\u001a\u00020(H\u0002J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\f052\u0006\u0010)\u001a\u00020(H\u0002J\b\u00106\u001a\u00020\fH\u0002J\b\u00107\u001a\u00020\fH\u0002J\b\u00108\u001a\u00020\fH\u0016J\u0018\u00109\u001a\u00020(2\u0006\u00102\u001a\u00020(2\u0006\u0010:\u001a\u00020\u0010H\u0002J\u0010\u0010;\u001a\u00020(2\u0006\u0010#\u001a\u00020\fH\u0002J\b\u0010<\u001a\u00020\"H\u0002J\u001a\u0010=\u001a\u00020\"2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020?H\u0002J\b\u0010A\u001a\u00020\"H\u0002J\u0010\u0010B\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010C\u001a\u00020\"2\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\fH\u0016J\u0018\u0010F\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0016J\u0018\u0010G\u001a\u00020\"2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\fH\u0016J\u0010\u0010J\u001a\u00020\"2\u0006\u0010K\u001a\u00020\fH\u0016J\u0012\u0010L\u001a\u00020\"2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006P"}, d2 = {"Lcom/tencent/state/decode/RegionDecodeDrawable;", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/state/decode/ILargeImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cacheDecodeSet", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/state/decode/DrawData;", "cachePool", "Lcom/tencent/state/decode/BitmapCachePool;", "column", "", DownloadInfo.spKey_Config, "Lcom/tencent/state/decode/RegionConfig;", "curViewRatio", "", "decodeSet", "decoder", "Landroid/graphics/BitmapRegionDecoder;", "drawDataList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "imageHeight", "imageLoader", "Lcom/tencent/state/decode/ImageLoader;", "imageScale", "imageWidth", "row", "scrolledX", "scrolledY", "tileHeight", "tileWidth", "unDecodeSet", "decodeBitmap", "", "key", "isNeedUpdateScreenData", "", "decodeDrawData", "imageRect", "Landroid/graphics/Rect;", "viewRect", "decodeOffScreenBitmap", "destroy", "destroyDecoder", "draw", PM.CANVAS, "Landroid/graphics/Canvas;", "drawBitmap", "expandViewRect", CanvasView.ACTION_RECT, "fillDrawData", "getImageKeyList", "", "getMapHeight", "getMapWidth", "getOpacity", "getScaleRect", "ratio", "getViewRect", "initData", "initDecoder", "url", "", WadlProxyConsts.PARAM_FILENAME, "initUnDecodeSet", "initialize", "onFling", "finalX", "finalY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "onTranslate", "transX", "transY", "setAlpha", c.f123400v, "setColorFilter", CustomAnimation.KeyPath.COLOR_FILTER, "Landroid/graphics/ColorFilter;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes33.dex */
public final class RegionDecodeDrawable extends Drawable implements ILargeImageView {
    private static final int EXPAND_SIZE = 100;
    private static final String TAG = "RegionDecodeDrawable";
    private final CopyOnWriteArraySet<DrawData> cacheDecodeSet;
    private BitmapCachePool cachePool;
    private int column;
    private RegionConfig config;
    private final Context context;
    private float curViewRatio;
    private CopyOnWriteArraySet<Integer> decodeSet;
    private BitmapRegionDecoder decoder;
    private CopyOnWriteArrayList<DrawData> drawDataList;
    private int imageHeight;
    private final ImageLoader imageLoader;
    private float imageScale;
    private int imageWidth;
    private int row;
    private int scrolledX;
    private int scrolledY;
    private int tileHeight;
    private int tileWidth;
    private CopyOnWriteArraySet<Integer> unDecodeSet;

    public RegionDecodeDrawable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.imageLoader = new ImageLoader();
        this.config = ILargeImageViewKt.defaultRegionConfig(context, "vas_square_map_background.jpg", "", ViewExtensionsKt.calPx(context, g.V0), ViewExtensionsKt.calPx(context, 6360), new Rect());
        this.drawDataList = new CopyOnWriteArrayList<>();
        this.decodeSet = new CopyOnWriteArraySet<>();
        this.unDecodeSet = new CopyOnWriteArraySet<>();
        this.cacheDecodeSet = new CopyOnWriteArraySet<>();
        this.imageScale = 1.0f;
        this.curViewRatio = 1.0f;
    }

    private final void decodeBitmap(int key, boolean isNeedUpdateScreenData) {
        int i3 = this.tileWidth;
        int i16 = this.column;
        int i17 = (key % i16) * i3;
        int i18 = this.tileHeight;
        int i19 = (key / i16) * i18;
        decodeDrawData(key, new Rect(i17, i19, i3 + i17, i18 + i19), getViewRect(key), isNeedUpdateScreenData);
    }

    private final void decodeDrawData(final int key, final Rect imageRect, final Rect viewRect, final boolean isNeedUpdateScreenData) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.state.decode.RegionDecodeDrawable$decodeDrawData$1
            @Override // java.lang.Runnable
            public final void run() {
                BitmapCachePool bitmapCachePool;
                RegionConfig regionConfig;
                BitmapRegionDecoder bitmapRegionDecoder;
                CopyOnWriteArraySet copyOnWriteArraySet;
                CopyOnWriteArraySet copyOnWriteArraySet2;
                CopyOnWriteArraySet copyOnWriteArraySet3;
                CopyOnWriteArraySet copyOnWriteArraySet4;
                CopyOnWriteArrayList copyOnWriteArrayList;
                CopyOnWriteArraySet copyOnWriteArraySet5;
                BitmapFactory.Options options = new BitmapFactory.Options();
                bitmapCachePool = RegionDecodeDrawable.this.cachePool;
                options.inBitmap = bitmapCachePool != null ? bitmapCachePool.obtainTileBitmap(imageRect.width(), imageRect.height()) : null;
                regionConfig = RegionDecodeDrawable.this.config;
                options.inPreferredConfig = regionConfig.getBitmapConfig();
                try {
                    SquareBaseKt.getSquareLog().d("RegionDecodeDrawable", "decodeDrawData " + key);
                    bitmapRegionDecoder = RegionDecodeDrawable.this.decoder;
                    DrawData drawData = new DrawData(key, viewRect, imageRect, bitmapRegionDecoder != null ? bitmapRegionDecoder.decodeRegion(imageRect, options) : null);
                    copyOnWriteArraySet = RegionDecodeDrawable.this.cacheDecodeSet;
                    copyOnWriteArraySet.add(drawData);
                    SquareBaseKt.getSquareLog().d("RegionDecodeDrawable", "decode success: index=" + key);
                    copyOnWriteArraySet2 = RegionDecodeDrawable.this.decodeSet;
                    copyOnWriteArraySet2.remove(Integer.valueOf(key));
                    if (isNeedUpdateScreenData) {
                        copyOnWriteArrayList = RegionDecodeDrawable.this.drawDataList;
                        copyOnWriteArrayList.add(drawData);
                        copyOnWriteArraySet5 = RegionDecodeDrawable.this.decodeSet;
                        if (copyOnWriteArraySet5.isEmpty()) {
                            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.decode.RegionDecodeDrawable$decodeDrawData$1.1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    RegionDecodeDrawable.this.invalidateSelf();
                                }
                            });
                        }
                    } else {
                        RegionDecodeDrawable.this.decodeOffScreenBitmap();
                    }
                    copyOnWriteArraySet3 = RegionDecodeDrawable.this.unDecodeSet;
                    if (copyOnWriteArraySet3.isEmpty()) {
                        copyOnWriteArraySet4 = RegionDecodeDrawable.this.decodeSet;
                        if (copyOnWriteArraySet4.isEmpty()) {
                            RegionDecodeDrawable.this.destroyDecoder();
                        }
                    }
                } catch (Exception e16) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "RegionDecodeDrawable", "decode error: " + imageRect + TokenParser.SP + e16, null, 4, null);
                }
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void decodeOffScreenBitmap() {
        Object firstOrNull;
        if (this.decodeSet.isEmpty() && (!this.unDecodeSet.isEmpty())) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(this.unDecodeSet);
            Integer num = (Integer) firstOrNull;
            if (num != null) {
                int intValue = num.intValue();
                this.decodeSet.add(Integer.valueOf(intValue));
                this.unDecodeSet.remove(Integer.valueOf(intValue));
                decodeBitmap(intValue, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void destroyDecoder() {
        BitmapCachePool bitmapCachePool = this.cachePool;
        if (bitmapCachePool != null) {
            bitmapCachePool.clearPool();
        }
        BitmapRegionDecoder bitmapRegionDecoder = this.decoder;
        if (bitmapRegionDecoder != null) {
            bitmapRegionDecoder.recycle();
        }
        this.decoder = null;
        this.cachePool = null;
    }

    private final void drawBitmap(Canvas canvas) {
        for (DrawData drawData : this.drawDataList) {
            if (drawData.getBitmap() == null) {
                SquareBaseKt.getSquareLog().w(TAG, "drawBitmap index: " + drawData.getKey() + ", but it has no bitmap");
            }
            Bitmap bitmap = drawData.getBitmap();
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, drawData.getViewRect(), (Paint) null);
            }
        }
        decodeOffScreenBitmap();
    }

    private final Rect expandViewRect(Rect rect) {
        int dip = ViewExtensionsKt.dip(this.context, 100);
        int i3 = rect.left - dip;
        int i16 = rect.top - dip;
        int i17 = rect.right + dip;
        int i18 = rect.bottom + dip;
        if (i3 < 0) {
            i3 = 0;
        }
        if (i16 < 0) {
            i16 = 0;
        }
        if (i17 > this.config.getMapWidth()) {
            i17 = this.config.getMapWidth();
        }
        if (i18 > this.config.getMapHeight()) {
            i18 = this.config.getMapHeight();
        }
        return new Rect(i3, i16, i17, i18);
    }

    private final void fillDrawData(Rect rect) {
        Object obj;
        List<Integer> imageKeyList = getImageKeyList(expandViewRect(rect));
        Iterator<T> it = imageKeyList.iterator();
        boolean z16 = false;
        while (true) {
            Object obj2 = null;
            if (!it.hasNext()) {
                break;
            }
            int intValue = ((Number) it.next()).intValue();
            Iterator<T> it5 = this.drawDataList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                if (intValue == ((DrawData) next).getKey()) {
                    obj2 = next;
                    break;
                }
            }
            if (obj2 == null) {
                z16 = true;
            }
        }
        this.drawDataList.clear();
        Iterator<T> it6 = imageKeyList.iterator();
        while (it6.hasNext()) {
            int intValue2 = ((Number) it6.next()).intValue();
            if (intValue2 < this.column * this.row) {
                Iterator<T> it7 = this.cacheDecodeSet.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it7.next();
                        if (((DrawData) obj).getKey() == intValue2) {
                            break;
                        }
                    }
                }
                DrawData drawData = (DrawData) obj;
                if (drawData != null) {
                    this.drawDataList.add(drawData);
                } else if (!this.decodeSet.contains(Integer.valueOf(intValue2))) {
                    this.decodeSet.add(Integer.valueOf(intValue2));
                    this.unDecodeSet.remove(Integer.valueOf(intValue2));
                    decodeBitmap$default(this, intValue2, false, 2, null);
                }
            }
        }
        if (z16) {
            invalidateSelf();
        }
    }

    private final int getMapHeight() {
        return (int) (this.config.getMapHeight() * this.curViewRatio);
    }

    private final int getMapWidth() {
        return (int) (this.config.getMapWidth() * this.curViewRatio);
    }

    private final Rect getScaleRect(Rect rect, float ratio) {
        return new Rect((int) (rect.left * ratio), (int) (rect.top * ratio), (int) (rect.right * ratio), (int) (rect.bottom * ratio));
    }

    private final Rect getViewRect(int key) {
        int i3 = this.tileWidth;
        int i16 = this.column;
        float f16 = this.imageScale;
        float f17 = (key % i16) * i3 * f16;
        float f18 = (key / i16) * r4 * f16;
        return new Rect((int) f17, (int) f18, (int) ((i3 * f16) + f17), (int) ((f16 * this.tileHeight) + f18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initData() {
        BitmapRegionDecoder bitmapRegionDecoder = this.decoder;
        if (bitmapRegionDecoder != null) {
            this.imageWidth = bitmapRegionDecoder.getWidth();
            BitmapRegionDecoder bitmapRegionDecoder2 = this.decoder;
            if (bitmapRegionDecoder2 != null) {
                int height = bitmapRegionDecoder2.getHeight();
                this.imageHeight = height;
                int i3 = this.imageWidth;
                if (i3 != 0 && height != 0) {
                    this.column = (i3 / this.config.getTileWidth()) + (this.imageWidth % this.config.getTileWidth() == 0 ? 0 : 1);
                    int tileHeight = (this.imageHeight / this.config.getTileHeight()) + (this.imageHeight % this.config.getTileHeight() == 0 ? 0 : 1);
                    this.row = tileHeight;
                    int i16 = this.imageWidth;
                    int i17 = this.column;
                    this.tileWidth = (i16 / i17) + (i16 % i17 == 0 ? 0 : 1);
                    int i18 = this.imageHeight;
                    this.tileHeight = (i18 / tileHeight) + (i18 % tileHeight != 0 ? 1 : 0);
                    this.imageScale = Math.max(getMapWidth() / this.imageWidth, getMapHeight() / this.imageHeight);
                    SquareBaseKt.getSquareLog().d(TAG, "imageWidth: " + this.imageWidth + " , imageHeight: " + this.imageHeight + "maxColumn: " + this.column + " maxRow: " + this.row + ", tileWidth " + this.tileWidth + ", tileHeight " + this.tileHeight + TokenParser.SP);
                    initUnDecodeSet();
                    fillDrawData(this.config.getInitRect());
                    return;
                }
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "imageWidth 0 ", null, 4, null);
            }
        }
    }

    private final void initDecoder(String url, String fileName) {
        if (fileName.length() > 0) {
            Resources resources = this.context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            InputStream open = resources.getAssets().open(fileName);
            try {
                this.decoder = BitmapRegionDecoder.newInstance(open, false);
                initData();
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(open, null);
                return;
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    CloseableKt.closeFinally(open, th5);
                    throw th6;
                }
            }
        }
        this.imageLoader.loadImage(url, new Function1<String, Unit>() { // from class: com.tencent.state.decode.RegionDecodeDrawable$initDecoder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                if (str == null) {
                    return;
                }
                RegionDecodeDrawable.this.decoder = BitmapRegionDecoder.newInstance(str, false);
                RegionDecodeDrawable.this.initData();
            }
        });
    }

    private final void initUnDecodeSet() {
        int i3 = this.row * this.column;
        for (int i16 = 0; i16 < i3; i16++) {
            this.unDecodeSet.add(Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.state.decode.ILargeImageView
    public void destroy() {
        destroyDecoder();
        this.drawDataList.clear();
        this.cacheDecodeSet.clear();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        drawBitmap(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.tencent.state.decode.ILargeImageView
    public void initialize(RegionConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.cachePool = new BitmapCachePool(config.getBitmapConfig());
        initDecoder(config.getUrl(), config.getAssetFileName());
    }

    @Override // com.tencent.state.decode.ILargeImageView
    public void onFling(int finalX, int finalY) {
        onScroll(finalX, finalY);
    }

    @Override // com.tencent.state.decode.ILargeImageView
    public void onScroll(int scrolledX, int scrolledY) {
        if (this.imageHeight != 0 && this.imageWidth != 0) {
            this.scrolledX = scrolledX;
            this.scrolledY = scrolledY;
            int i3 = this.config.getInitRect().left + scrolledX;
            int i16 = this.config.getInitRect().top + scrolledY;
            fillDrawData(new Rect(i3, i16, this.config.getInitRect().width() + i3, this.config.getInitRect().height() + i16));
            return;
        }
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "image size 0", null, 4, null);
    }

    @Override // com.tencent.state.decode.ILargeImageView
    public void onTranslate(int transX, int transY) {
        if (this.imageHeight != 0 && this.imageWidth != 0) {
            int i3 = (this.config.getInitRect().left + this.scrolledX) - transX;
            int i16 = (this.config.getInitRect().top + this.scrolledY) - transY;
            fillDrawData(new Rect(i3, i16, this.config.getInitRect().width() + i3, this.config.getInitRect().height() + i16));
            return;
        }
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "image size 0", null, 4, null);
    }

    private final List<Integer> getImageKeyList(Rect viewRect) {
        int i3;
        Rect scaleRect = getScaleRect(viewRect, 1 / this.imageScale);
        ArrayList arrayList = new ArrayList();
        int i16 = scaleRect.top;
        int i17 = this.tileHeight;
        int i18 = i16 / i17;
        int i19 = scaleRect.bottom / i17;
        if (i18 < 0) {
            i18 = 0;
        }
        if (i19 >= this.row) {
            i19--;
        }
        int i26 = scaleRect.left;
        int i27 = this.tileWidth;
        int i28 = i26 / i27;
        int i29 = scaleRect.right / i27;
        if (i28 < 0) {
            i28 = 0;
        }
        int i36 = this.column;
        if (i29 >= i36) {
            i29--;
        }
        int i37 = (i36 * i18) + i28;
        int i38 = (i36 * i19) + i29;
        if (i37 == i38) {
            arrayList.add(Integer.valueOf(i37));
            return arrayList;
        }
        for (int i39 = 0; i39 <= i19 - i18; i39++) {
            int i46 = i29 - i28;
            if (i46 >= 0) {
                while (true) {
                    int i47 = (this.column * i39) + i37 + i3;
                    if (i47 > i38) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "index error " + i37 + " + " + i39 + " + " + this.column + " + " + i47 + " + " + i38, null, 4, null);
                        break;
                    }
                    arrayList.add(Integer.valueOf(i47));
                    i3 = i3 != i46 ? i3 + 1 : 0;
                }
            }
        }
        return arrayList;
    }

    static /* synthetic */ void decodeBitmap$default(RegionDecodeDrawable regionDecodeDrawable, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = true;
        }
        regionDecodeDrawable.decodeBitmap(i3, z16);
    }

    static /* synthetic */ void decodeDrawData$default(RegionDecodeDrawable regionDecodeDrawable, int i3, Rect rect, Rect rect2, boolean z16, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z16 = true;
        }
        regionDecodeDrawable.decodeDrawData(i3, rect, rect2, z16);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
