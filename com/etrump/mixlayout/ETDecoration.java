package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import com.etrump.mixlayout.api.IETDecoration;
import com.etrump.mixlayout.api.IETEngine;
import com.etrump.mixlayout.api.IETFont;
import com.etrump.mixlayout.api.IETFontAdapter;
import com.etrump.mixlayout.api.IETSegment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ETDecoration implements IETDecoration {
    public static final int DECORATION_SCENE = 2;
    public static final int DECORATION_TEMPLATE = 1;
    private int mFrameDelay;
    private long mNativeDescriptorHandle = 0;
    private int mFrameNum = 0;
    private ETEngine mEngine = null;
    private String mText = null;
    public int mFrameIndex = -1;
    private Object[] mSpans = null;
    public Rect mMargins = null;

    ETDecoration() {
    }

    public static int callbackCharWidth(int i3, float f16, boolean z16, float f17, float f18, float f19, boolean z17, float f26) {
        StringBuilder sb5 = new StringBuilder("");
        sb5.appendCodePoint(i3);
        String sb6 = sb5.toString();
        Paint paint = new Paint();
        paint.reset();
        paint.setTextSize(f16);
        if (z16) {
            paint.setShadowLayer(f19, f17, f18, -16777216);
        }
        float measureText = paint.measureText(sb6);
        if (z17) {
            Paint paint2 = new Paint(1);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setColor(-16776961);
            paint2.setStrokeWidth(f26);
            paint2.setTextSize(f16);
            float measureText2 = paint2.measureText(sb6);
            if (measureText <= measureText2) {
                measureText = measureText2;
            }
        }
        return (int) measureText;
    }

    public static void callbackDrawImage(Object[] objArr, int i3, Canvas canvas, Matrix matrix, float f16, float f17, float f18, float f19, float f26, boolean z16, int i16) {
        if (canvas != null && objArr != null && i3 >= 0 && i3 < objArr.length) {
            canvas.save();
            canvas.setMatrix(matrix);
            Object obj = objArr[i3];
            if (obj != null) {
                Paint paint = new Paint(1);
                paint.setTextSize(f19);
                paint.setColor(i16);
                paint.setAlpha((int) (f26 * 255.0f));
                drawImage(canvas, f17, f18, obj, paint);
            }
            canvas.restore();
        }
    }

    public static void callbackDrawText(int i3, Canvas canvas, Matrix matrix, float f16, float f17, float f18, float f19, float f26, boolean z16, int i16, boolean z17, int i17, float f27, float f28, float f29, boolean z18, int i18, float f36) {
        int i19;
        float f37;
        float f38;
        if (canvas == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder("");
        sb5.appendCodePoint(i3);
        String sb6 = sb5.toString();
        Paint paint = new Paint();
        paint.reset();
        paint.setColor(i16);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setTextSize(f19);
        int i26 = (int) (255.0f * f26);
        paint.setAlpha(i26);
        if (!z16) {
            paint.setStyle(Paint.Style.STROKE);
        }
        canvas.save();
        canvas.setMatrix(matrix);
        if (z17 && z16) {
            float f39 = 0.0f == f29 ? 0.1f : f29;
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            fArr[2] = 0.0f;
            fArr[5] = 0.0f;
            Matrix matrix2 = new Matrix();
            matrix2.setValues(fArr);
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                float[] fArr2 = new float[2];
                matrix3.mapPoints(fArr2, new float[]{f27, f28});
                f37 = fArr2[0];
                f38 = fArr2[1];
                i19 = i17;
            } else {
                i19 = i17;
                f37 = f27;
                f38 = f28;
            }
            paint.setShadowLayer(f39, f37, f38, i19);
        }
        if (z18) {
            Paint paint2 = new Paint(1);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setColor(i18);
            paint2.setStrokeWidth(f36);
            paint2.setTextSize(f19);
            paint2.setAlpha(i26);
            canvas.drawText(sb6, 0.0f, f16, paint2);
        }
        canvas.drawText(sb6, f17, f18 + f16, paint);
        canvas.restore();
    }

    private static void checkDescriptorList(ETEngine eTEngine) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Long, WeakReference<IETDecoration>> entry : eTEngine.mDescriptorMap.entrySet()) {
            if (entry.getValue().get() == null) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Long l3 = (Long) it.next();
            if (l3.longValue() != 0) {
                eTEngine.native_decorationDeleteDescriptor(l3.longValue());
            }
            eTEngine.mDescriptorMap.remove(l3);
        }
    }

    private static ETSegment[] convertToETSegmentArray(IETSegment[] iETSegmentArr) {
        if (iETSegmentArr == null) {
            return null;
        }
        int length = iETSegmentArr.length;
        ETSegment[] eTSegmentArr = new ETSegment[length];
        for (int i3 = 0; i3 < length; i3++) {
            eTSegmentArr[i3] = (ETSegment) iETSegmentArr[i3];
        }
        return eTSegmentArr;
    }

    public static IETDecoration createDecoration(IETEngine iETEngine, String str, int i3, int i16, int i17, int i18, IETSegment[] iETSegmentArr, Object[] objArr, boolean z16, int i19, IETFont iETFont, boolean z17) {
        ETEngine eTEngine = (ETEngine) iETEngine;
        if (eTEngine != null && str != null && iETFont != null && iETSegmentArr != null && i3 > 0 && i16 > 0 && i18 > 0) {
            long native_decorationCreateDescriptor = eTEngine.native_decorationCreateDescriptor(str, convertToETSegmentArray(iETSegmentArr), i3, i16, i17, i18, z16, i19, (ETFont) iETFont);
            if (native_decorationCreateDescriptor != 0) {
                int native_decorationGetFrameNum = eTEngine.native_decorationGetFrameNum(native_decorationCreateDescriptor);
                if (native_decorationGetFrameNum == 0) {
                    eTEngine.native_decorationDeleteDescriptor(native_decorationCreateDescriptor);
                    return null;
                }
                ETDecoration eTDecoration = new ETDecoration();
                eTDecoration.mNativeDescriptorHandle = native_decorationCreateDescriptor;
                int native_decorationGetFrameDelay = eTEngine.native_decorationGetFrameDelay(native_decorationCreateDescriptor, 0);
                if (native_decorationGetFrameDelay < 50) {
                    native_decorationGetFrameDelay = 50;
                }
                eTDecoration.mFrameDelay = native_decorationGetFrameDelay;
                eTDecoration.mFrameNum = native_decorationGetFrameNum;
                eTDecoration.mText = str;
                eTDecoration.mEngine = eTEngine;
                eTDecoration.mSpans = objArr;
                eTDecoration.mMargins = eTEngine.native_getMargins(native_decorationCreateDescriptor);
                if (z17) {
                    checkDescriptorList(eTEngine);
                    eTEngine.mDescriptorMap.put(Long.valueOf(native_decorationCreateDescriptor), new WeakReference<>(eTDecoration));
                }
                return eTDecoration;
            }
        }
        return null;
    }

    public static IETDecoration createDecorationSpace(IETEngine iETEngine, String str, int i3, int i16, Point point, int i17, Point[] pointArr, int i18, IETSegment[] iETSegmentArr, Object[] objArr, boolean z16, int i19, boolean z17, IETFont iETFont, boolean z18) {
        ETEngine eTEngine = (ETEngine) iETEngine;
        if (eTEngine != null && str != null && iETFont != null && i3 > 0 && i16 > 0 && i18 > 0) {
            ETFont eTFont = (ETFont) iETFont;
            eTEngine.native_isColorVariantFont(eTFont);
            long native_space_decorationCreateDescriptor = eTEngine.native_space_decorationCreateDescriptor(str, convertToETSegmentArray(iETSegmentArr), i3, i16, point, i17, pointArr, i18, z16, i19, z17, eTFont);
            if (native_space_decorationCreateDescriptor != 0) {
                int native_space_decorationGetFrameNum = eTEngine.native_space_decorationGetFrameNum(native_space_decorationCreateDescriptor);
                if (native_space_decorationGetFrameNum == 0) {
                    eTEngine.native_space_decorationDeleteDescriptor(native_space_decorationCreateDescriptor);
                    return null;
                }
                ETDecoration eTDecoration = new ETDecoration();
                eTDecoration.mNativeDescriptorHandle = native_space_decorationCreateDescriptor;
                int native_space_decorationGetFrameDelay = eTEngine.native_space_decorationGetFrameDelay(native_space_decorationCreateDescriptor, 0);
                if (native_space_decorationGetFrameDelay < 50) {
                    native_space_decorationGetFrameDelay = 50;
                }
                eTDecoration.mFrameDelay = native_space_decorationGetFrameDelay;
                eTDecoration.mFrameNum = native_space_decorationGetFrameNum;
                eTDecoration.mText = str;
                eTDecoration.mEngine = eTEngine;
                eTDecoration.mSpans = objArr;
                eTDecoration.mMargins = eTEngine.native_space_getMargins(native_space_decorationCreateDescriptor);
                if (z18) {
                    checkDescriptorList(eTEngine);
                }
                return eTDecoration;
            }
        }
        return null;
    }

    private static void drawImage(Canvas canvas, float f16, float f17, Object obj, Paint paint) {
        IETFontAdapter.INSTANCE.getInstance().drawImage(canvas, f16, f17, obj, paint);
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public int currentFrameIndex() {
        int i3 = this.mFrameIndex;
        if (i3 < 0 || i3 >= this.mFrameNum) {
            return this.mFrameNum - 1;
        }
        return i3;
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public void deleteDescriptor() {
        long j3 = this.mNativeDescriptorHandle;
        if (0 != j3) {
            this.mEngine.mDescriptorMap.remove(Long.valueOf(j3));
            this.mEngine.native_decorationDeleteDescriptor(this.mNativeDescriptorHandle);
            this.mNativeDescriptorHandle = 0L;
        }
    }

    void deleteDescriptorSpace() {
        long j3 = this.mNativeDescriptorHandle;
        if (0 != j3) {
            this.mEngine.native_space_decorationDeleteDescriptor(j3);
            this.mNativeDescriptorHandle = 0L;
        }
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public void drawBackground(Bitmap bitmap, IETFont iETFont) {
        int currentFrameIndex = currentFrameIndex();
        ETEngine eTEngine = this.mEngine;
        if (eTEngine != null) {
            long j3 = this.mNativeDescriptorHandle;
            if (0 != j3 && currentFrameIndex >= 0 && currentFrameIndex < this.mFrameNum) {
                eTEngine.native_decorationDrawBackground(j3, currentFrameIndex, (ETFont) iETFont, bitmap);
            }
        }
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public void drawBackgroundSpace(Bitmap bitmap, IETFont iETFont, int i3, int i16) {
        int currentFrameIndex = currentFrameIndex();
        ETEngine eTEngine = this.mEngine;
        if (eTEngine != null) {
            long j3 = this.mNativeDescriptorHandle;
            if (0 != j3 && currentFrameIndex >= 0 && currentFrameIndex < this.mFrameNum) {
                eTEngine.native_space_decorationDrawBackground(j3, currentFrameIndex, (ETFont) iETFont, bitmap, i3, i16);
            }
        }
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public void drawForeground(Bitmap bitmap, IETFont iETFont) {
        int currentFrameIndex = currentFrameIndex();
        ETEngine eTEngine = this.mEngine;
        if (eTEngine != null) {
            long j3 = this.mNativeDescriptorHandle;
            if (0 != j3 && currentFrameIndex >= 0 && currentFrameIndex < this.mFrameNum) {
                eTEngine.native_decorationDrawForeground(j3, currentFrameIndex, (ETFont) iETFont, bitmap);
            }
        }
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public void drawFrameText(int i3, int i16, Bitmap bitmap, int i17, int i18, IETFont iETFont) {
        int currentFrameIndex = currentFrameIndex();
        ETEngine eTEngine = this.mEngine;
        if (eTEngine != null) {
            long j3 = this.mNativeDescriptorHandle;
            if (0 != j3 && currentFrameIndex >= 0 && currentFrameIndex < this.mFrameNum) {
                eTEngine.native_decorationDrawText(j3, currentFrameIndex, i3, i16, (ETFont) iETFont, bitmap, i17, i18);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawScene(Bitmap bitmap, int i3, int i16, IETFont iETFont) {
        int currentFrameIndex = currentFrameIndex();
        ETEngine eTEngine = this.mEngine;
        if (eTEngine != null) {
            long j3 = this.mNativeDescriptorHandle;
            if (0 != j3 && currentFrameIndex >= 0 && currentFrameIndex < this.mFrameNum) {
                eTEngine.native_decorationDrawScene(j3, currentFrameIndex, (ETFont) iETFont, this.mSpans, bitmap, i3, i16);
            }
        }
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public void drawSceneSpace(Bitmap bitmap, int i3, int i16, IETFont iETFont) {
        int currentFrameIndex = currentFrameIndex();
        ETEngine eTEngine = this.mEngine;
        if (eTEngine != null) {
            long j3 = this.mNativeDescriptorHandle;
            if (0 != j3 && currentFrameIndex >= 0 && currentFrameIndex < this.mFrameNum) {
                eTEngine.native_space_decorationDrawScene(j3, currentFrameIndex, (ETFont) iETFont, this.mSpans, bitmap, i3, i16);
            }
        }
    }

    public int getDecorationType() {
        ETEngine eTEngine = this.mEngine;
        if (eTEngine != null) {
            return eTEngine.native_decorationGetType(this.mNativeDescriptorHandle);
        }
        return 0;
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public int getFrameDelay() {
        return this.mFrameDelay;
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public int getFrameNum() {
        return this.mFrameNum;
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public Rect getMargins() {
        return this.mMargins;
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public String getText() {
        return this.mText;
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public void gotoFrame(int i3) {
        if (i3 >= 0 && i3 < this.mFrameNum) {
            this.mFrameIndex = i3;
        }
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public void gotoLastFrame() {
        this.mFrameIndex = -1;
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public boolean isLastFrame() {
        int i3 = this.mFrameIndex;
        if (i3 >= 0 && i3 < this.mFrameNum) {
            return false;
        }
        return true;
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public boolean nextFrame() {
        int i3 = this.mFrameIndex + 1;
        this.mFrameIndex = i3;
        if (i3 < this.mFrameNum) {
            return true;
        }
        this.mFrameIndex = -1;
        return false;
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public void setNativeDescriptorHandle(long j3) {
        this.mNativeDescriptorHandle = j3;
    }

    @Override // com.etrump.mixlayout.api.IETDecoration
    public void deleteDescriptor(IETEngine iETEngine) {
        long j3 = this.mNativeDescriptorHandle;
        if (j3 == 0 || iETEngine == null) {
            return;
        }
        iETEngine.nativeDecorationDeleteDescriptor(j3);
        this.mNativeDescriptorHandle = 0L;
    }
}
