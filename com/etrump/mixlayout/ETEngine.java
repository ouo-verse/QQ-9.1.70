package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.etrump.mixlayout.api.IETDecoration;
import com.etrump.mixlayout.api.IETEngine;
import com.etrump.mixlayout.api.IETFont;
import com.etrump.mixlayout.api.IETFontAdapter;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ETEngine implements IETEngine {
    private static final int BITMAP_INDEX_BACK = 0;
    private static final int BITMAP_INDEX_FORE = 1;
    private static final int ETRUMP_FONT_SIZE_MINIMUM = 24;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_CROCHET = 8;
    public static final int STYLE_REGULAR = 0;
    public static final int STYLE_SHADOW = 128;
    private static final int S_MEM_POOL_SIZE = 1048576;
    public static final String TAG = "ETEngine";
    public static AtomicBoolean isSOLoaded = new AtomicBoolean(false);
    private static final boolean sFixBugs136319009 = com.tencent.mobileqq.vas.toggle.c.f310992a.a("vas_bugfix_136319009", true);
    private static ETEngine sInstance;
    private static ETEngine sInstanceAnimation;
    private static ETEngine sInstanceDiyAddon;
    private static ETEngine sInstanceRP;
    private static ETEngine sInstanceSpace;
    private final boolean mEnableCallbackDrawing = true;
    private boolean mInitialized = false;
    private long mNativeFontManagerHandle = 0;
    public AtomicBoolean isEngineInited = new AtomicBoolean(false);
    public AtomicBoolean isEngineReady = new AtomicBoolean(false);
    public HashMap<Long, WeakReference<IETDecoration>> mDescriptorMap = new HashMap<>();
    private Paint mPaint = null;
    private Canvas mCanvas = null;
    private Bitmap[] mBitmaps = null;
    private Paint mBitmapPaint = null;

    public static synchronized ETEngine getInstance() {
        ETEngine eTEngine;
        synchronized (ETEngine.class) {
            if (sInstance == null) {
                sInstance = new ETEngine();
            }
            eTEngine = sInstance;
        }
        return eTEngine;
    }

    public static synchronized ETEngine getInstanceForAnimation() {
        ETEngine eTEngine;
        synchronized (ETEngine.class) {
            if (sInstanceAnimation == null) {
                sInstanceAnimation = new ETEngine();
            }
            eTEngine = sInstanceAnimation;
        }
        return eTEngine;
    }

    public static ETEngine getInstanceForDiyPendant() {
        if (sInstanceDiyAddon == null) {
            sInstanceDiyAddon = new ETEngine();
        }
        return sInstanceDiyAddon;
    }

    public static ETEngine getInstanceForRedPacket() {
        if (sInstanceRP == null) {
            sInstanceRP = new ETEngine();
        }
        return sInstanceRP;
    }

    public static synchronized ETEngine getInstanceForSpace() {
        ETEngine eTEngine;
        synchronized (ETEngine.class) {
            if (sInstanceSpace == null) {
                sInstanceSpace = new ETEngine();
            }
            eTEngine = sInstanceSpace;
        }
        return eTEngine;
    }

    private static boolean isMeizu() {
        String str = Build.BRAND;
        if (!str.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU) && !str.equals("meizu")) {
            return false;
        }
        return true;
    }

    public static native boolean native_ftf2ttf(String str, String str2);

    public static native int native_getFontType(String str);

    public static native boolean native_quickCheck(String str, String str2);

    @Override // com.etrump.mixlayout.api.IETEngine
    public void callbackDrawBitmap(Bitmap bitmap, Bitmap bitmap2, Matrix matrix, float f16, float f17, float f18) {
        if (this.mCanvas == null) {
            this.mCanvas = new Canvas();
        }
        if (this.mBitmapPaint == null) {
            this.mBitmapPaint = new Paint(1);
        }
        this.mBitmapPaint.setAlpha((int) (f18 * 255.0f));
        this.mCanvas.setBitmap(bitmap);
        this.mCanvas.translate(f16, f17);
        this.mCanvas.drawBitmap(bitmap2, matrix, this.mBitmapPaint);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public Bitmap createBitmap(int i3, int i16, int i17) {
        if (this.mBitmaps == null) {
            this.mBitmaps = r0;
            Bitmap[] bitmapArr = {null, null};
        }
        if (i17 > 1) {
            return null;
        }
        Bitmap bitmap = this.mBitmaps[i17];
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        } else {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width < i3 || height < i16) {
                if (width >= i3) {
                    i3 = width;
                }
                if (height >= i16) {
                    i16 = height;
                }
                bitmap.recycle();
                bitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            }
        }
        this.mBitmaps[i17] = bitmap;
        return bitmap;
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public byte[] getPicture(String str) {
        String dIYFontImage = IETFontAdapter.INSTANCE.getInstance().getDIYFontImage(str);
        if (!TextUtils.isEmpty(dIYFontImage)) {
            return Base64.decode(dIYFontImage, 0);
        }
        return ETDIYConfig.f(new File("/data/data/com.tencent.mobileqq/files/diy_fonts" + File.separator + str + ".png"));
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean initEngine(int i3, int i16) throws Exception {
        if (!isSOLoaded.get()) {
            return false;
        }
        if (native_initEngine(i3, i16, true)) {
            return true;
        }
        throw new Exception("init engine fail");
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean isEnableCallbackDrawing() {
        return true;
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeCloneBitmap(Bitmap bitmap, Bitmap bitmap2) {
        return native_cloneBitmap(bitmap, bitmap2);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public long nativeCloneNativeSubstitutionConfig(long j3) {
        return native_CloneNativeSubstitutionConfig(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativeColorDisableEffects(IETFont iETFont, boolean z16, boolean z17, boolean z18) {
        native_colorDisableEffects((ETFont) iETFont, z16, z17, z18);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeContainComplexScript(String str) {
        return native_containComplexScript(str);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public long nativeCreateNativeSubstitutionConfig(IETFont iETFont, byte[] bArr) {
        return native_CreateNativeSubstitutionConfig((ETFont) iETFont, bArr);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public long nativeDecorationCreateDescriptor(String str, ETSegment[] eTSegmentArr, int i3, int i16, int i17, int i18, boolean z16, int i19, IETFont iETFont) {
        return native_decorationCreateDescriptor(str, eTSegmentArr, i3, i16, i17, i18, z16, i19, (ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativeDecorationDeleteDescriptor(long j3) {
        native_decorationDeleteDescriptor(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativeDecorationDrawBackground(long j3, int i3, IETFont iETFont, Bitmap bitmap) {
        native_decorationDrawBackground(j3, i3, (ETFont) iETFont, bitmap);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativeDecorationDrawForeground(long j3, int i3, IETFont iETFont, Bitmap bitmap) {
        native_decorationDrawForeground(j3, i3, (ETFont) iETFont, bitmap);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeDecorationDrawScene(long j3, int i3, IETFont iETFont, Object[] objArr, Bitmap bitmap, int i16, int i17) {
        return native_decorationDrawScene(j3, i3, (ETFont) iETFont, objArr, bitmap, i16, i17);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeDecorationDrawText(long j3, int i3, int i16, int i17, IETFont iETFont, Bitmap bitmap, int i18, int i19) {
        return native_decorationDrawText(j3, i3, i16, i17, (ETFont) iETFont, bitmap, i18, i19);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeDecorationDrawTextOnAnimatingEnd(long j3, IETFont iETFont) {
        return native_decorationDrawTextOnAnimatingEnd(j3, (ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public long nativeDecorationGetDescriptor(IETFont iETFont, String str, int i3, int i16) {
        return native_decorationGetDescriptor((ETFont) iETFont, str, i3, i16);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeDecorationGetFrameDelay(long j3, int i3) {
        return native_decorationGetFrameDelay(j3, i3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeDecorationGetFrameNum(long j3) {
        return native_decorationGetFrameNum(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeDecorationGetTemplateID(IETFont iETFont, int i3, int i16, int i17) {
        return native_decorationGetTemplateID((ETFont) iETFont, i3, i16, i17);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeDecorationGetTempletIndex(long j3) {
        return native_decorationGetTempletIndex(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeDecorationGetType(long j3) {
        return native_decorationGetType(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativeDeleteNativeSubstitutionConfig(long j3) {
        native_DeleteNativeSubstitutionConfig(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public long nativeDiyFontCreateNativeConfig(IETFont iETFont, byte[] bArr) {
        return native_diyFontCreateNativeConfig((ETFont) iETFont, bArr);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativeDiyFontDeleteNativeConfig(long j3) {
        native_diyFontDeleteNativeConfig(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativeDiyFontDrawChar(int i3, IETFont iETFont, Bitmap bitmap, int i16, int i17, int i18, int i19, boolean z16) {
        native_diyFontDrawChar(i3, (ETFont) iETFont, bitmap, i16, i17, i18, i19, z16);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativeDiyFontDrawGlyph(int i3, IETFont iETFont, Bitmap bitmap, int i16, int i17, int i18, int i19, float f16, float f17, float f18, float f19, float f26, float f27, boolean z16) {
        native_diyFontDrawGlyph(i3, (ETFont) iETFont, bitmap, i16, i17, i18, i19, f16, f17, f18, f19, f26, f27, z16);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int[] nativeDiyFontGetAccessoryList(IETFont iETFont) {
        return native_diyFontGetAccessoryList((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeDiyFontGetCharIndex(int i3, IETFont iETFont) {
        return native_diyFontGetCharIndex(i3, (ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeDiyFontGetColorStyleCount(IETFont iETFont) {
        return native_diyFontGetColorStyleCount((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeDiyFontGetCurrentColorStyle(IETFont iETFont) {
        return native_diyFontGetCurrentColorStyle((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeDiyFontGetCurrentThemeStyle(IETFont iETFont) {
        return native_diyFontGetCurrentThemeStyle((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeDiyFontGetGlyphBound(int i3, IETFont iETFont, float f16, float f17, float f18, float f19, float f26, float f27, Rect rect) {
        return native_diyFontGetGlyphBound(i3, (ETFont) iETFont, f16, f17, f18, f19, f26, f27, rect);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeDiyFontGetSdkVersion() {
        return native_diyFontGetSdkVersion();
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeDiyFontGetThemeStyleCount(IETFont iETFont) {
        return native_diyFontGetThemeStyleCount((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeDiyFontGetUPEM(IETFont iETFont) {
        return native_diyFontGetUPEM((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeDiyFontGetVersion(IETFont iETFont) {
        return native_diyFontGetVersion((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeDiyFontIsDIYFont(IETFont iETFont) {
        return native_diyFontIsDIYFont((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativeDoneEngine() {
        native_doneEngine();
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeDrawBackground(String str, int i3, Bitmap bitmap, int i16, int i17, IETFont iETFont) {
        return native_drawBackground(str, i3, bitmap, i16, i17, (ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeDrawInRect(String str, Bitmap bitmap, IETFont iETFont) {
        return native_drawInRect(str, bitmap, (ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeDrawText(String str, Bitmap bitmap, int i3, int i16, IETFont iETFont) {
        return native_drawText(str, bitmap, i3, i16, (ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public long nativeEmoticonCreateDescriptor(String str, ETSegment[] eTSegmentArr, int i3, IETFont iETFont, int i16) {
        return native_emoticonCreateDescriptor(str, eTSegmentArr, i3, (ETFont) iETFont, i16);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public EMImage nativeEmoticonCreateImage(String str, int i3, IETFont iETFont) {
        return native_emoticonCreateImage(str, i3, (ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativeEmoticonDeleteDescriptor(long j3) {
        native_emoticonDeleteDescriptor(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativeEmoticonDrawFrame(long j3, int i3, IETFont iETFont, Bitmap bitmap) {
        native_emoticonDrawFrame(j3, i3, (ETFont) iETFont, bitmap);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeEmoticonGetFrameDelay(long j3, int i3) {
        return native_emoticonGetFrameDelay(j3, i3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeEmoticonGetFrameNum(long j3) {
        return native_emoticonGetFrameNum(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeEmoticonGetHeight(long j3) {
        return native_emoticonGetHeight(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeEmoticonGetHeightByIndex(int i3, IETFont iETFont) {
        return native_emoticonGetHeightByIndex(i3, (ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeEmoticonGetWidth(long j3) {
        return native_emoticonGetWidth(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeEmoticonGetWidthByIndex(int i3, IETFont iETFont) {
        return native_emoticonGetWidthByIndex(i3, (ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int[] nativeEmoticonRetrieveCollection(String str, int i3, IETFont iETFont) {
        return native_emoticonRetrieveCollection(str, i3, (ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeFtf2ttf(String str, String str2) {
        return native_ftf2ttf(str, str2);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeGetFontCategory(IETFont iETFont) {
        return native_getFontCategory((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeGetFontMetrics(Paint.FontMetrics fontMetrics, IETFont iETFont) {
        return native_getFontMetrics(fontMetrics, (ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeGetFontType(String str) {
        return native_getFontType(str);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeGetHorizontalMarginThreshold(IETFont iETFont, int i3) {
        return native_getHorizontalMarginThreshold((ETFont) iETFont, i3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public Rect nativeGetMargins(long j3) {
        return native_getMargins(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeGetTextColor(IETFont iETFont) {
        return native_getTextColor((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeGetTextWidths(String str, IETFont iETFont, Paint paint, int[] iArr) {
        return native_getTextWidths(str, (ETFont) iETFont, paint, iArr);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeGetVariantStyleComboCount(IETFont iETFont) {
        return native_getVariantStyleComboCount((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeInitEngine(int i3, int i16, boolean z16) {
        return native_initEngine(i3, i16, z16);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeIsColorVariantFont(IETFont iETFont) {
        return native_isColorVariantFont((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeIsDecorationFont(IETFont iETFont) {
        return native_isDecorationFont((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeIsFontLoaded(int i3) {
        return native_isFontLoaded(i3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeIsHiboomFont(IETFont iETFont) {
        return native_isHiboomFont((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeIsPaintableChar(char c16, IETFont iETFont) {
        return native_isPaintableChar(c16, (ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeLoadFont(String str, int i3, boolean z16) {
        return native_loadFont(str, i3, z16);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeMatchTextStyle(IETFont iETFont, String str) {
        return native_matchTextStyle((ETFont) iETFont, str);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeMeasure(String str, int i3, int i16, IETFont iETFont, Rect rect) {
        return native_measure(str, i3, i16, (ETFont) iETFont, rect);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativePrintTrace() {
        native_printTrace();
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeQuickCheck(String str, String str2) {
        return native_quickCheck(str, str2);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativeResetEngine() {
        native_resetEngine();
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeSetPersistentFont(IETFont iETFont) {
        return native_setPersistentFont((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public long nativeSpaceDecorationCreateDescriptor(String str, ETSegment[] eTSegmentArr, int i3, int i16, Point point, int i17, Point[] pointArr, int i18, boolean z16, int i19, boolean z17, IETFont iETFont) {
        return native_space_decorationCreateDescriptor(str, eTSegmentArr, i3, i16, point, i17, pointArr, i18, z16, i19, z17, (ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativeSpaceDecorationDeleteDescriptor(long j3) {
        native_space_decorationDeleteDescriptor(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativeSpaceDecorationDrawBackground(long j3, int i3, IETFont iETFont, Bitmap bitmap, int i16, int i17) {
        native_space_decorationDrawBackground(j3, i3, (ETFont) iETFont, bitmap, i16, i17);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeSpaceDecorationDrawScene(long j3, int i3, IETFont iETFont, Object[] objArr, Bitmap bitmap, int i16, int i17) {
        return native_space_decorationDrawScene(j3, i3, (ETFont) iETFont, objArr, bitmap, i16, i17);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeSpaceDecorationGetFrameDelay(long j3, int i3) {
        return native_space_decorationGetFrameDelay(j3, i3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeSpaceDecorationGetFrameNum(long j3) {
        return native_space_decorationGetFrameNum(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativeSpaceDrawText(String str, Canvas canvas, Bitmap bitmap, int i3, int i16, IETFont iETFont, Paint paint) {
        native_spaceDrawText(str, canvas, bitmap, i3, i16, (ETFont) iETFont, paint);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeSpaceGetFontType(IETFont iETFont) {
        return native_space_getFontType((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeSpaceGetHorizontalMarginThreshold(IETFont iETFont, int i3) {
        return native_space_getHorizontalMarginThreshold((ETFont) iETFont, i3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public Rect nativeSpaceGetMargins(long j3) {
        return native_space_getMargins(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeSpaceGetTextWidths(String str, int i3, int i16, IETFont iETFont, Paint paint, int[] iArr) {
        return native_spaceGetTextWidths(str, i3, i16, (ETFont) iETFont, paint, iArr);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeSpaceIsDecorationFont(IETFont iETFont) {
        return native_space_isDecorationFont((ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeSpaceMeasureText(String str, int i3, int i16, IETFont iETFont, Paint paint) {
        return native_spaceMeasureText(str, i3, i16, (ETFont) iETFont, paint);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public boolean nativeTextLayoutHasPreLine(long j3) {
        return native_textLayoutHasPreLine(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeTextLayoutLineHeight(long j3, int i3) {
        return native_textLayoutLineHeight(j3, i3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeTextLayoutLineRangeFrom(long j3, int i3) {
        return native_textLayoutLineRangeFrom(j3, i3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeTextLayoutLineRangeTo(long j3, int i3) {
        return native_textLayoutLineRangeTo(j3, i3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeTextLayoutLineTotal(long j3) {
        return native_textLayoutLineTotal(j3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int nativeTextLayoutLineWidth(long j3, int i3) {
        return native_textLayoutLineWidth(j3, i3);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public long nativeTextLayoutLock(String str, int i3, int i16, int i17, int i18, IETFont iETFont) {
        return native_textLayoutLock(str, i3, i16, i17, i18, (ETFont) iETFont);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void nativeTextLayoutUnlock(long j3) {
        native_textLayoutUnlock(j3);
    }

    public native long native_CloneNativeSubstitutionConfig(long j3);

    public native long native_CreateNativeSubstitutionConfig(ETFont eTFont, byte[] bArr);

    public native void native_DeleteNativeSubstitutionConfig(long j3);

    public native boolean native_cloneBitmap(Bitmap bitmap, Bitmap bitmap2);

    public native void native_colorDisableEffects(ETFont eTFont, boolean z16, boolean z17, boolean z18);

    public native boolean native_containComplexScript(String str);

    public native long native_decorationCreateDescriptor(String str, ETSegment[] eTSegmentArr, int i3, int i16, int i17, int i18, boolean z16, int i19, ETFont eTFont);

    public native void native_decorationDeleteDescriptor(long j3);

    public native void native_decorationDrawBackground(long j3, int i3, ETFont eTFont, Bitmap bitmap);

    public native void native_decorationDrawForeground(long j3, int i3, ETFont eTFont, Bitmap bitmap);

    public native boolean native_decorationDrawScene(long j3, int i3, ETFont eTFont, Object[] objArr, Bitmap bitmap, int i16, int i17);

    public native boolean native_decorationDrawText(long j3, int i3, int i16, int i17, ETFont eTFont, Bitmap bitmap, int i18, int i19);

    public native boolean native_decorationDrawTextOnAnimatingEnd(long j3, ETFont eTFont);

    public native long native_decorationGetDescriptor(ETFont eTFont, String str, int i3, int i16);

    public native int native_decorationGetFrameDelay(long j3, int i3);

    public native int native_decorationGetFrameNum(long j3);

    public native int native_decorationGetTemplateID(ETFont eTFont, int i3, int i16, int i17);

    public native int native_decorationGetTempletIndex(long j3);

    public native int native_decorationGetType(long j3);

    public native long native_diyFontCreateNativeConfig(ETFont eTFont, byte[] bArr);

    public native void native_diyFontDeleteNativeConfig(long j3);

    public native void native_diyFontDrawChar(int i3, ETFont eTFont, Bitmap bitmap, int i16, int i17, int i18, int i19, boolean z16);

    public native void native_diyFontDrawGlyph(int i3, ETFont eTFont, Bitmap bitmap, int i16, int i17, int i18, int i19, float f16, float f17, float f18, float f19, float f26, float f27, boolean z16);

    public native int[] native_diyFontGetAccessoryList(ETFont eTFont);

    public native int native_diyFontGetCharIndex(int i3, ETFont eTFont);

    public native int native_diyFontGetColorStyleCount(ETFont eTFont);

    public native int native_diyFontGetCurrentColorStyle(ETFont eTFont);

    public native int native_diyFontGetCurrentThemeStyle(ETFont eTFont);

    public native boolean native_diyFontGetGlyphBound(int i3, ETFont eTFont, float f16, float f17, float f18, float f19, float f26, float f27, Rect rect);

    public native int native_diyFontGetSdkVersion();

    public native int native_diyFontGetThemeStyleCount(ETFont eTFont);

    public native int native_diyFontGetUPEM(ETFont eTFont);

    public native int native_diyFontGetVersion(ETFont eTFont);

    public native boolean native_diyFontIsDIYFont(ETFont eTFont);

    public native void native_doneEngine();

    public native boolean native_drawBackground(String str, int i3, Bitmap bitmap, int i16, int i17, ETFont eTFont);

    public native boolean native_drawInRect(String str, Bitmap bitmap, ETFont eTFont);

    public native boolean native_drawText(String str, Bitmap bitmap, int i3, int i16, ETFont eTFont);

    public native long native_emoticonCreateDescriptor(String str, ETSegment[] eTSegmentArr, int i3, ETFont eTFont, int i16);

    public native EMImage native_emoticonCreateImage(String str, int i3, ETFont eTFont);

    public native void native_emoticonDeleteDescriptor(long j3);

    public native void native_emoticonDrawFrame(long j3, int i3, ETFont eTFont, Bitmap bitmap);

    public native int native_emoticonGetFrameDelay(long j3, int i3);

    public native int native_emoticonGetFrameNum(long j3);

    public native int native_emoticonGetHeight(long j3);

    public native int native_emoticonGetHeightByIndex(int i3, ETFont eTFont);

    public native int native_emoticonGetWidth(long j3);

    public native int native_emoticonGetWidthByIndex(int i3, ETFont eTFont);

    public native int[] native_emoticonRetrieveCollection(String str, int i3, ETFont eTFont);

    public native int native_getFontCategory(ETFont eTFont);

    public native boolean native_getFontMetrics(Paint.FontMetrics fontMetrics, ETFont eTFont);

    public native int native_getHorizontalMarginThreshold(ETFont eTFont, int i3);

    public native Rect native_getMargins(long j3);

    public native int native_getTextColor(ETFont eTFont);

    public native boolean native_getTextWidths(String str, ETFont eTFont, Paint paint, int[] iArr);

    public native int native_getVariantStyleComboCount(ETFont eTFont);

    public native boolean native_initEngine(int i3, int i16, boolean z16);

    public native boolean native_isColorVariantFont(ETFont eTFont);

    public native boolean native_isDecorationFont(ETFont eTFont);

    public native boolean native_isFontLoaded(int i3);

    public native boolean native_isHiboomFont(ETFont eTFont);

    public native boolean native_isPaintableChar(char c16, ETFont eTFont);

    public native boolean native_loadFont(String str, int i3, boolean z16);

    public native int native_matchTextStyle(ETFont eTFont, String str);

    public native boolean native_measure(String str, int i3, int i16, ETFont eTFont, Rect rect);

    public native void native_printTrace();

    public native void native_resetEngine();

    public native boolean native_setPersistentFont(ETFont eTFont);

    public native void native_spaceDrawText(String str, Canvas canvas, Bitmap bitmap, int i3, int i16, ETFont eTFont, Paint paint);

    public native int native_spaceGetTextWidths(String str, int i3, int i16, ETFont eTFont, Paint paint, int[] iArr);

    public native int native_spaceMeasureText(String str, int i3, int i16, ETFont eTFont, Paint paint);

    public native long native_space_decorationCreateDescriptor(String str, ETSegment[] eTSegmentArr, int i3, int i16, Point point, int i17, Point[] pointArr, int i18, boolean z16, int i19, boolean z17, ETFont eTFont);

    public native void native_space_decorationDeleteDescriptor(long j3);

    public native void native_space_decorationDrawBackground(long j3, int i3, ETFont eTFont, Bitmap bitmap, int i16, int i17);

    public native boolean native_space_decorationDrawScene(long j3, int i3, ETFont eTFont, Object[] objArr, Bitmap bitmap, int i16, int i17);

    public native int native_space_decorationGetFrameDelay(long j3, int i3);

    public native int native_space_decorationGetFrameNum(long j3);

    public native int native_space_getFontType(ETFont eTFont);

    public native int native_space_getHorizontalMarginThreshold(ETFont eTFont, int i3);

    public native Rect native_space_getMargins(long j3);

    public native boolean native_space_isDecorationFont(ETFont eTFont);

    public native boolean native_textLayoutHasPreLine(long j3);

    public native int native_textLayoutLineHeight(long j3, int i3);

    public native int native_textLayoutLineRangeFrom(long j3, int i3);

    public native int native_textLayoutLineRangeTo(long j3, int i3);

    public native int native_textLayoutLineTotal(long j3);

    public native int native_textLayoutLineWidth(long j3, int i3);

    public native long native_textLayoutLock(String str, int i3, int i16, int i17, int i18, ETFont eTFont);

    public native void native_textLayoutUnlock(long j3);

    @Override // com.etrump.mixlayout.api.IETEngine
    public void onAIODestroy() {
        this.mCanvas = null;
        Bitmap[] bitmapArr = this.mBitmaps;
        if (bitmapArr != null) {
            for (int length = bitmapArr.length - 1; length >= 0; length--) {
                Bitmap bitmap = this.mBitmaps[length];
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
        }
        this.mBitmaps = null;
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void printLog(String str) {
        Log.e(TAG, str);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void spaceCallbackDrawText(String str, Canvas canvas, int i3, int i16, int i17, Paint paint, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38) {
        Paint paint2 = new Paint();
        paint2.setColor(i19);
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        float f16 = i18;
        paint2.setTextSize(f16);
        if ((i26 & 128) > 0) {
            paint2.setShadowLayer(i36, i28, i29, i27);
        }
        if ((i26 & 1) > 0) {
            paint2.setFakeBoldText(true);
        }
        float f17 = i3;
        float abs = Math.abs(i17) + i16;
        canvas.drawText(str, f17, abs, paint2);
        if ((i26 & 8) > 0) {
            Paint paint3 = new Paint(1);
            paint3.setStyle(Paint.Style.STROKE);
            paint3.setColor(i37);
            paint3.setStrokeWidth(i38 / 2.0f);
            paint3.setTextSize(f16);
            canvas.drawText(str, f17, abs, paint3);
        }
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int spaceCallbackGetTextWidths(String str, Paint paint, int[] iArr, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29) {
        Paint paint2 = new Paint();
        paint2.setTextSize(i3);
        if ((i17 & 128) > 0) {
            paint2.setShadowLayer(i27, i19, i26, i18);
        }
        if ((i17 & 8) > 0) {
            paint2.setStrokeWidth(i29);
        }
        int textWidths = paint2.getTextWidths(str, new float[iArr.length]);
        for (int i36 = 0; i36 < textWidths; i36++) {
            iArr[i36] = (int) Math.ceil(r4[i36]);
        }
        return textWidths;
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int spaceCallbackMeasureText(String str, Paint paint, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29) {
        Paint paint2 = new Paint();
        paint2.setTextSize(i3);
        if ((i17 & 128) > 0) {
            paint2.setShadowLayer(i27, i19, i26, i18);
        }
        if ((i17 & 8) > 0) {
            paint2.setStrokeWidth(i29);
        }
        return (int) Math.ceil(paint2.measureText(str));
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public void sysDrawText(String str, int i3, int i16, int i17, Bitmap bitmap, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38) {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        if (this.mCanvas == null) {
            this.mCanvas = new Canvas();
        }
        this.mCanvas.setBitmap(bitmap);
        int abs = Math.abs(i26);
        this.mPaint.reset();
        this.mPaint.setColor(i16);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        float f16 = i3;
        this.mPaint.setTextSize(f16);
        int i39 = i17 & 128;
        if (i39 <= 0 || (i17 & 8) <= 0) {
            if ((i17 & 8) > 0) {
                Paint paint = new Paint(1);
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(i37);
                paint.setStrokeWidth(i38 / 2.0f);
                paint.setTextSize(f16);
                this.mCanvas.drawText(str, i18, i19 + abs, paint);
            }
            if (i39 > 0) {
                this.mPaint.setShadowLayer(i36 != 0 ? i36 : 0.01f, i28, i29, i27);
            }
        } else {
            this.mPaint.setShadowLayer(i36 != 0 ? i36 : 0.01f, i28, i29, i27);
            float f17 = i18;
            float f18 = i19 + abs;
            this.mCanvas.drawText(str, f17, f18, this.mPaint);
            Paint paint2 = new Paint(1);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setColor(i37);
            paint2.setStrokeWidth(i38 / 2.0f);
            paint2.setTextSize(f16);
            this.mCanvas.drawText(str, f17, f18, paint2);
            this.mPaint.clearShadowLayer();
        }
        this.mCanvas.drawText(str, i18, i19 + abs, this.mPaint);
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int sysFontHeight(String str, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        float f16 = i3;
        this.mPaint.setTextSize(f16);
        if ((i16 & 128) > 0) {
            this.mPaint.setShadowLayer(i26, i18, i19, i17);
        }
        if (sFixBugs136319009) {
            try {
                if (isMeizu() && str.length() == 1) {
                    QLog.i(TAG, 1, "sysFontHeight text:" + str);
                    return 0;
                }
            } catch (Exception unused) {
                QLog.i(TAG, 1, "sysFontHeight text:" + str);
            }
        }
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        float f17 = fontMetrics.bottom - fontMetrics.top;
        if ((i16 & 8) > 0) {
            Paint paint = new Paint(1);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(i27);
            paint.setStrokeWidth(i28);
            paint.setTextSize(f16);
            Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
            float f18 = fontMetrics2.bottom - fontMetrics2.top;
            if (f17 <= f18) {
                f17 = f18;
            }
        }
        return (int) f17;
    }

    @Override // com.etrump.mixlayout.api.IETEngine
    public int sysMeasureText(String str, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        float f16 = i3;
        this.mPaint.setTextSize(f16);
        if ((i16 & 128) > 0) {
            this.mPaint.setShadowLayer(i26, i18, i19, i17);
        }
        if (TextUtils.isEmpty(str) || i3 <= 0) {
            return 0;
        }
        if (sFixBugs136319009) {
            try {
                if (isMeizu() && str.length() == 1) {
                    QLog.i(TAG, 1, "sysMeasureText text:" + str);
                    return 0;
                }
            } catch (Exception unused) {
                QLog.i(TAG, 1, "sysMeasureText text:" + str);
            }
        }
        float measureText = this.mPaint.measureText(str);
        if ((i16 & 8) > 0) {
            Paint paint = new Paint(1);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(i27);
            paint.setStrokeWidth(i28);
            paint.setTextSize(f16);
            float measureText2 = paint.measureText(str);
            if (measureText <= measureText2) {
                measureText = measureText2;
            }
        }
        return (int) measureText;
    }
}
