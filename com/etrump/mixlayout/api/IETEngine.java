package com.etrump.mixlayout.api;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import com.etrump.mixlayout.EMImage;
import com.etrump.mixlayout.ETSegment;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IETEngine {
    void callbackDrawBitmap(Bitmap bitmap, Bitmap bitmap2, Matrix matrix, float f16, float f17, float f18);

    Bitmap createBitmap(int i3, int i16, int i17);

    byte[] getPicture(String str);

    boolean initEngine(int i3, int i16) throws Exception;

    boolean isEnableCallbackDrawing();

    boolean nativeCloneBitmap(Bitmap bitmap, Bitmap bitmap2);

    long nativeCloneNativeSubstitutionConfig(long j3);

    void nativeColorDisableEffects(IETFont iETFont, boolean z16, boolean z17, boolean z18);

    boolean nativeContainComplexScript(String str);

    long nativeCreateNativeSubstitutionConfig(IETFont iETFont, byte[] bArr);

    long nativeDecorationCreateDescriptor(String str, ETSegment[] eTSegmentArr, int i3, int i16, int i17, int i18, boolean z16, int i19, IETFont iETFont);

    void nativeDecorationDeleteDescriptor(long j3);

    void nativeDecorationDrawBackground(long j3, int i3, IETFont iETFont, Bitmap bitmap);

    void nativeDecorationDrawForeground(long j3, int i3, IETFont iETFont, Bitmap bitmap);

    boolean nativeDecorationDrawScene(long j3, int i3, IETFont iETFont, Object[] objArr, Bitmap bitmap, int i16, int i17);

    boolean nativeDecorationDrawText(long j3, int i3, int i16, int i17, IETFont iETFont, Bitmap bitmap, int i18, int i19);

    boolean nativeDecorationDrawTextOnAnimatingEnd(long j3, IETFont iETFont);

    long nativeDecorationGetDescriptor(IETFont iETFont, String str, int i3, int i16);

    int nativeDecorationGetFrameDelay(long j3, int i3);

    int nativeDecorationGetFrameNum(long j3);

    int nativeDecorationGetTemplateID(IETFont iETFont, int i3, int i16, int i17);

    int nativeDecorationGetTempletIndex(long j3);

    int nativeDecorationGetType(long j3);

    void nativeDeleteNativeSubstitutionConfig(long j3);

    long nativeDiyFontCreateNativeConfig(IETFont iETFont, byte[] bArr);

    void nativeDiyFontDeleteNativeConfig(long j3);

    void nativeDiyFontDrawChar(int i3, IETFont iETFont, Bitmap bitmap, int i16, int i17, int i18, int i19, boolean z16);

    void nativeDiyFontDrawGlyph(int i3, IETFont iETFont, Bitmap bitmap, int i16, int i17, int i18, int i19, float f16, float f17, float f18, float f19, float f26, float f27, boolean z16);

    int[] nativeDiyFontGetAccessoryList(IETFont iETFont);

    int nativeDiyFontGetCharIndex(int i3, IETFont iETFont);

    int nativeDiyFontGetColorStyleCount(IETFont iETFont);

    int nativeDiyFontGetCurrentColorStyle(IETFont iETFont);

    int nativeDiyFontGetCurrentThemeStyle(IETFont iETFont);

    boolean nativeDiyFontGetGlyphBound(int i3, IETFont iETFont, float f16, float f17, float f18, float f19, float f26, float f27, Rect rect);

    int nativeDiyFontGetSdkVersion();

    int nativeDiyFontGetThemeStyleCount(IETFont iETFont);

    int nativeDiyFontGetUPEM(IETFont iETFont);

    int nativeDiyFontGetVersion(IETFont iETFont);

    boolean nativeDiyFontIsDIYFont(IETFont iETFont);

    void nativeDoneEngine();

    boolean nativeDrawBackground(String str, int i3, Bitmap bitmap, int i16, int i17, IETFont iETFont);

    boolean nativeDrawInRect(String str, Bitmap bitmap, IETFont iETFont);

    boolean nativeDrawText(String str, Bitmap bitmap, int i3, int i16, IETFont iETFont);

    long nativeEmoticonCreateDescriptor(String str, ETSegment[] eTSegmentArr, int i3, IETFont iETFont, int i16);

    EMImage nativeEmoticonCreateImage(String str, int i3, IETFont iETFont);

    void nativeEmoticonDeleteDescriptor(long j3);

    void nativeEmoticonDrawFrame(long j3, int i3, IETFont iETFont, Bitmap bitmap);

    int nativeEmoticonGetFrameDelay(long j3, int i3);

    int nativeEmoticonGetFrameNum(long j3);

    int nativeEmoticonGetHeight(long j3);

    int nativeEmoticonGetHeightByIndex(int i3, IETFont iETFont);

    int nativeEmoticonGetWidth(long j3);

    int nativeEmoticonGetWidthByIndex(int i3, IETFont iETFont);

    int[] nativeEmoticonRetrieveCollection(String str, int i3, IETFont iETFont);

    boolean nativeFtf2ttf(String str, String str2);

    int nativeGetFontCategory(IETFont iETFont);

    boolean nativeGetFontMetrics(Paint.FontMetrics fontMetrics, IETFont iETFont);

    int nativeGetFontType(String str);

    int nativeGetHorizontalMarginThreshold(IETFont iETFont, int i3);

    Rect nativeGetMargins(long j3);

    int nativeGetTextColor(IETFont iETFont);

    boolean nativeGetTextWidths(String str, IETFont iETFont, Paint paint, int[] iArr);

    int nativeGetVariantStyleComboCount(IETFont iETFont);

    boolean nativeInitEngine(int i3, int i16, boolean z16);

    boolean nativeIsColorVariantFont(IETFont iETFont);

    boolean nativeIsDecorationFont(IETFont iETFont);

    boolean nativeIsFontLoaded(int i3);

    boolean nativeIsHiboomFont(IETFont iETFont);

    boolean nativeIsPaintableChar(char c16, IETFont iETFont);

    boolean nativeLoadFont(String str, int i3, boolean z16);

    int nativeMatchTextStyle(IETFont iETFont, String str);

    boolean nativeMeasure(String str, int i3, int i16, IETFont iETFont, Rect rect);

    void nativePrintTrace();

    boolean nativeQuickCheck(String str, String str2);

    void nativeResetEngine();

    boolean nativeSetPersistentFont(IETFont iETFont);

    long nativeSpaceDecorationCreateDescriptor(String str, ETSegment[] eTSegmentArr, int i3, int i16, Point point, int i17, Point[] pointArr, int i18, boolean z16, int i19, boolean z17, IETFont iETFont);

    void nativeSpaceDecorationDeleteDescriptor(long j3);

    void nativeSpaceDecorationDrawBackground(long j3, int i3, IETFont iETFont, Bitmap bitmap, int i16, int i17);

    boolean nativeSpaceDecorationDrawScene(long j3, int i3, IETFont iETFont, Object[] objArr, Bitmap bitmap, int i16, int i17);

    int nativeSpaceDecorationGetFrameDelay(long j3, int i3);

    int nativeSpaceDecorationGetFrameNum(long j3);

    void nativeSpaceDrawText(String str, Canvas canvas, Bitmap bitmap, int i3, int i16, IETFont iETFont, Paint paint);

    int nativeSpaceGetFontType(IETFont iETFont);

    int nativeSpaceGetHorizontalMarginThreshold(IETFont iETFont, int i3);

    Rect nativeSpaceGetMargins(long j3);

    int nativeSpaceGetTextWidths(String str, int i3, int i16, IETFont iETFont, Paint paint, int[] iArr);

    boolean nativeSpaceIsDecorationFont(IETFont iETFont);

    int nativeSpaceMeasureText(String str, int i3, int i16, IETFont iETFont, Paint paint);

    boolean nativeTextLayoutHasPreLine(long j3);

    int nativeTextLayoutLineHeight(long j3, int i3);

    int nativeTextLayoutLineRangeFrom(long j3, int i3);

    int nativeTextLayoutLineRangeTo(long j3, int i3);

    int nativeTextLayoutLineTotal(long j3);

    int nativeTextLayoutLineWidth(long j3, int i3);

    long nativeTextLayoutLock(String str, int i3, int i16, int i17, int i18, IETFont iETFont);

    void nativeTextLayoutUnlock(long j3);

    void onAIODestroy();

    void printLog(String str);

    void spaceCallbackDrawText(String str, Canvas canvas, int i3, int i16, int i17, Paint paint, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38);

    int spaceCallbackGetTextWidths(String str, Paint paint, int[] iArr, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29);

    int spaceCallbackMeasureText(String str, Paint paint, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29);

    void sysDrawText(String str, int i3, int i16, int i17, Bitmap bitmap, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38);

    int sysFontHeight(String str, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28);

    int sysMeasureText(String str, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28);
}
