package com.tencent.component.media.image.region;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class RegionBitmapDecoder {
    private static final int MSG_UPDATE_DECODE_REGION = 1;
    private static final String TAG = "RegionBitmapDecoder";
    private WeakReference<OnUpdateCallback> mCallback;
    private long mCurrentTime;
    private Matrix mExifMatrix;
    private RegionBitmapBlockHelper mHelper;
    private String mImagePath;
    private int mOrgImageWidth;
    private int mOrgimageHeight;
    private BitmapRegionDecoder mRegionDecoder;
    private WorkHandler mWorkHandler;
    private Rect mTmp = new Rect();
    private Object mDataLock = new Object();
    private HashMap<Rect, DrawData> mDataList = new HashMap<>();
    private int mRotation = -1;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class DrawData {
        public Bitmap mBitmap;
        public int mDecodeSample;
        public Rect mOrgRect;
        public Rect mShowRect;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return ((DrawData) obj).mShowRect.equals(this.mShowRect);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnUpdateCallback {
        void regionRefreshed();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    final class WorkHandler extends Handler {
        public WorkHandler(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Code restructure failed: missing block: B:61:0x0118, code lost:
        
            com.tencent.component.media.utils.ImageManagerLog.i(com.tencent.component.media.image.region.RegionBitmapDecoder.TAG, "stop decode ");
         */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            RegionDrawableData regionDrawableData;
            int calcSample;
            Rect rect;
            boolean z16 = true;
            if (message.what == 1) {
                RegionBitmapDecoder.this.initRegionDecoder();
                int i3 = 0;
                if (RegionBitmapDecoder.this.mRegionDecoder != null && RegionBitmapDecoder.this.mOrgImageWidth != 0 && RegionBitmapDecoder.this.mOrgimageHeight != 0) {
                    if (RegionDrawableData.class.isInstance(message.obj) && (calcSample = (regionDrawableData = (RegionDrawableData) message.obj).calcSample()) != 0) {
                        RegionBitmapDecoder.this.caclShowArea(regionDrawableData);
                        if (RegionBitmapDecoder.this.mHelper == null) {
                            RegionBitmapDecoder.this.mHelper = new RegionBitmapBlockHelper(new Rect(0, 0, RegionBitmapDecoder.this.mOrgImageWidth, RegionBitmapDecoder.this.mOrgimageHeight));
                        }
                        long uptimeMillis = SystemClock.uptimeMillis();
                        LinkedList<DrawData> drawDatas = RegionBitmapDecoder.this.mHelper.getDrawDatas(new Rect(regionDrawableData.mShowArea), calcSample);
                        HashMap hashMap = new HashMap();
                        if (drawDatas == null) {
                            return;
                        }
                        Iterator<DrawData> it = drawDatas.iterator();
                        int i16 = 0;
                        int i17 = 0;
                        while (it.hasNext()) {
                            DrawData next = it.next();
                            DrawData drawData = (DrawData) RegionBitmapDecoder.this.mDataList.get(next.mShowRect);
                            if (drawData == null) {
                                next.mOrgRect = RegionBitmapDecoder.this.rotateRect(new Rect(next.mShowRect));
                                hashMap.put(next.mShowRect, next);
                                i17++;
                            } else {
                                hashMap.put(drawData.mShowRect, drawData);
                                i16++;
                            }
                        }
                        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                        synchronized (RegionBitmapDecoder.this.mDataLock) {
                            RegionBitmapDecoder.this.mDataList = hashMap;
                        }
                        long uptimeMillis3 = SystemClock.uptimeMillis();
                        try {
                            Iterator it5 = RegionBitmapDecoder.this.mDataList.entrySet().iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    break;
                                }
                                DrawData drawData2 = (DrawData) ((Map.Entry) it5.next()).getValue();
                                if (calcSample != drawData2.mDecodeSample || drawData2.mBitmap == null || (rect = drawData2.mOrgRect) == null || rect.isEmpty()) {
                                    if (RegionBitmapDecoder.this.mCurrentTime != regionDrawableData.mTaskTime) {
                                        break;
                                    }
                                    RegionBitmapDecoder.this.decode(drawData2, calcSample);
                                    i3++;
                                }
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                        if (SystemClock.uptimeMillis() - uptimeMillis3 != 0) {
                            ImageManagerLog.i(RegionBitmapDecoder.TAG, "\u9009\u53d6\u6709\u6548\u5757:cost " + uptimeMillis2);
                            ImageManagerLog.i(RegionBitmapDecoder.TAG, "\u89e3\u6790\u6709\u6548\u5757:cost " + (SystemClock.uptimeMillis() - uptimeMillis3));
                            ImageManagerLog.i(RegionBitmapDecoder.TAG, "\u5206\u5757\uff1a" + RegionBitmapDecoder.this.mDataList.size());
                            ImageManagerLog.i(RegionBitmapDecoder.TAG, "invalidSize\uff1a" + i17 + " reUseSize :" + i16 + " refreshDecodeSize: " + i3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(" initRegionDecoder:  mRegionDecoder = null ? :  ");
                if (RegionBitmapDecoder.this.mRegionDecoder != null) {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append(" mOrgImageWidth = ");
                sb5.append(RegionBitmapDecoder.this.mOrgImageWidth);
                sb5.append(" orgImageHeight = ");
                sb5.append(RegionBitmapDecoder.this.mOrgimageHeight);
                ImageManagerLog.i(RegionBitmapDecoder.TAG, sb5.toString());
            }
        }
    }

    public RegionBitmapDecoder(String str) {
        if (this.mWorkHandler == null) {
            this.mWorkHandler = new WorkHandler(ImageManagerEnv.g().getFileThreadLooper());
        }
        this.mImagePath = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caclShowArea(RegionDrawableData regionDrawableData) {
        Rect rect = new Rect(regionDrawableData.mShowArea);
        int width = rect.width();
        int height = rect.height();
        int screenWidth = ImageManagerEnv.g().getScreenWidth();
        int screenHeight = ImageManagerEnv.g().getScreenHeight();
        int i3 = 0;
        if (height <= screenHeight && width >= screenWidth) {
            int abs = Math.abs(rect.left);
            int i16 = screenWidth + abs;
            int i17 = this.mOrgImageWidth;
            float f16 = width;
            int i18 = (int) ((i17 * (abs / f16)) + 0.5f);
            int i19 = (int) ((i17 * (i16 / f16)) + 0.5f);
            if (i18 < 0) {
                i18 = 0;
            }
            if (i19 <= i17) {
                i17 = i19;
            }
            regionDrawableData.mShowArea.set(i18, 0, i17, this.mOrgimageHeight);
            return;
        }
        int abs2 = Math.abs(rect.left);
        int i26 = screenWidth + abs2;
        int abs3 = Math.abs(rect.top);
        int i27 = screenHeight + abs3;
        int i28 = this.mOrgImageWidth;
        float f17 = width;
        int i29 = (int) ((i28 * (abs2 / f17)) + 0.5f);
        int i36 = (int) ((i28 * (i26 / f17)) + 0.5f);
        int i37 = (int) ((i28 * (abs3 / f17)) + 0.5f);
        int i38 = (int) ((i28 * (i27 / f17)) + 0.5f);
        if (i29 < 0) {
            i29 = 0;
        }
        if (i36 <= i28) {
            i28 = i36;
        }
        if (i37 >= 0) {
            i3 = i37;
        }
        int i39 = this.mOrgimageHeight;
        if (i38 > i39) {
            i38 = i39;
        }
        regionDrawableData.mShowArea.set(i29, i3, i28, i38);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x024a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decode(DrawData drawData, int i3) {
        long uptimeMillis;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        OnUpdateCallback onUpdateCallback;
        String str;
        String str2;
        OnUpdateCallback onUpdateCallback2;
        OnUpdateCallback onUpdateCallback3;
        Bitmap bitmap;
        OnUpdateCallback onUpdateCallback4;
        Bitmap decodeRegion;
        OnUpdateCallback onUpdateCallback5;
        BitmapRegionDecoder bitmapRegionDecoder = this.mRegionDecoder;
        if (bitmapRegionDecoder != null && !bitmapRegionDecoder.isRecycled()) {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            this.mTmp.set(drawData.mOrgRect);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i3;
            try {
                try {
                    try {
                        decodeRegion = this.mRegionDecoder.decodeRegion(this.mTmp, options);
                        drawData.mBitmap = decodeRegion;
                        drawData.mDecodeSample = options.inSampleSize;
                        if (decodeRegion != null && !decodeRegion.isRecycled() && (onUpdateCallback5 = this.mCallback.get()) != null) {
                            onUpdateCallback5.regionRefreshed();
                        }
                    } catch (IllegalArgumentException unused) {
                        drawData.mBitmap = null;
                        StringBuilder sb8 = new StringBuilder("IllegalArgumentException: ");
                        if (this.mRegionDecoder == null) {
                            str = " blockSize = ";
                        } else {
                            StringBuilder sb9 = new StringBuilder();
                            str = " blockSize = ";
                            try {
                                sb9.append(this.mRegionDecoder.getWidth());
                                sb9.append(" x ");
                                sb9.append(this.mRegionDecoder.getHeight());
                                sb9.append(" current Rect = ");
                                sb9.append(this.mTmp);
                                sb8.append(sb9.toString());
                            } catch (Throwable th5) {
                                th = th5;
                                str2 = str;
                                bitmap = drawData.mBitmap;
                                drawData.mDecodeSample = options.inSampleSize;
                                if (bitmap != null && !bitmap.isRecycled() && (onUpdateCallback4 = this.mCallback.get()) != null) {
                                    onUpdateCallback4.regionRefreshed();
                                }
                                if (bitmap != null) {
                                    ImageManagerLog.e(TAG, "Decode region failure bitmap = null with temp = " + this.mTmp);
                                } else {
                                    long uptimeMillis3 = SystemClock.uptimeMillis() - uptimeMillis2;
                                    StringBuilder sb10 = new StringBuilder();
                                    sb10.append("piece decode cost " + uptimeMillis3 + ", sample " + options.inSampleSize + " temp = " + this.mTmp + str2 + this.mTmp.width());
                                    ImageManagerLog.i(TAG, sb10.toString());
                                }
                                throw th;
                            }
                        }
                        ImageManagerLog.e("RegionDrawable", sb8.toString());
                        Bitmap bitmap2 = drawData.mBitmap;
                        drawData.mDecodeSample = options.inSampleSize;
                        if (bitmap2 != null && !bitmap2.isRecycled() && (onUpdateCallback2 = this.mCallback.get()) != null) {
                            onUpdateCallback2.regionRefreshed();
                        }
                        if (bitmap2 == null) {
                            sb7 = new StringBuilder();
                        } else {
                            long uptimeMillis4 = SystemClock.uptimeMillis() - uptimeMillis2;
                            sb5 = new StringBuilder();
                            sb6 = new StringBuilder();
                            sb6.append("piece decode cost ");
                            sb6.append(uptimeMillis4);
                            sb6.append(", sample ");
                            sb6.append(options.inSampleSize);
                            sb6.append(" temp = ");
                            sb6.append(this.mTmp);
                            sb6.append(str);
                        }
                    } catch (RuntimeException unused2) {
                        drawData.mBitmap = null;
                        StringBuilder sb11 = new StringBuilder("RuntimeException : ");
                        if (this.mRegionDecoder != null) {
                            sb11.append(this.mRegionDecoder.getWidth() + " x " + this.mRegionDecoder.getHeight() + " current Rect = " + this.mTmp);
                        }
                        ImageManagerLog.e(TAG, sb11.toString());
                        Bitmap bitmap3 = drawData.mBitmap;
                        drawData.mDecodeSample = options.inSampleSize;
                        if (bitmap3 != null && !bitmap3.isRecycled() && (onUpdateCallback = this.mCallback.get()) != null) {
                            onUpdateCallback.regionRefreshed();
                        }
                        if (bitmap3 == null) {
                            sb7 = new StringBuilder();
                        } else {
                            uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                            sb5 = new StringBuilder();
                            sb6 = new StringBuilder();
                        }
                    }
                } catch (OutOfMemoryError unused3) {
                    ImageManagerLog.e("RegionDrawable", "decodeRegion OOM decode down");
                    options.inSampleSize <<= 1;
                    BitmapRegionDecoder bitmapRegionDecoder2 = this.mRegionDecoder;
                    if (bitmapRegionDecoder2 != null) {
                        drawData.mBitmap = bitmapRegionDecoder2.decodeRegion(this.mTmp, options);
                    }
                    Bitmap bitmap4 = drawData.mBitmap;
                    drawData.mDecodeSample = options.inSampleSize;
                    if (bitmap4 != null && !bitmap4.isRecycled() && (onUpdateCallback3 = this.mCallback.get()) != null) {
                        onUpdateCallback3.regionRefreshed();
                    }
                    if (bitmap4 == null) {
                        sb7 = new StringBuilder();
                    } else {
                        uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                        sb5 = new StringBuilder();
                        sb6 = new StringBuilder();
                    }
                }
                if (decodeRegion == null) {
                    sb7 = new StringBuilder();
                    sb7.append("Decode region failure bitmap = null with temp = ");
                    sb7.append(this.mTmp);
                    ImageManagerLog.e(TAG, sb7.toString());
                    return;
                }
                uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                sb5 = new StringBuilder();
                sb6 = new StringBuilder();
                sb6.append("piece decode cost ");
                sb6.append(uptimeMillis);
                sb6.append(", sample ");
                sb6.append(options.inSampleSize);
                sb6.append(" temp = ");
                sb6.append(this.mTmp);
                sb6.append(" blockSize = ");
                sb6.append(this.mTmp.width());
                sb5.append(sb6.toString());
                ImageManagerLog.i(TAG, sb5.toString());
                return;
            } catch (Throwable th6) {
                th = th6;
                str2 = " blockSize = ";
                bitmap = drawData.mBitmap;
                drawData.mDecodeSample = options.inSampleSize;
                if (bitmap != null) {
                    onUpdateCallback4.regionRefreshed();
                }
                if (bitmap != null) {
                }
                throw th;
            }
        }
        ImageManagerLog.i(TAG, "decode with RegionDecode null or recycle ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRegionDecoder() {
        BitmapRegionDecoder bitmapRegionDecoder = this.mRegionDecoder;
        if (bitmapRegionDecoder == null || bitmapRegionDecoder.isRecycled()) {
            if (!TextUtils.isEmpty(this.mImagePath)) {
                try {
                    this.mRegionDecoder = BitmapRegionDecoder.newInstance(this.mImagePath, true);
                } catch (FileNotFoundException e16) {
                    e16.printStackTrace();
                    ImageManagerLog.e(TAG, "Init BitmapRegionDecoder failure FileNotFoundException");
                    try {
                        this.mRegionDecoder = BitmapRegionDecoder.newInstance(Uri.parse(this.mImagePath).getPath(), true);
                    } catch (Exception unused) {
                        ImageManagerLog.e(TAG, "Init BitmapRegionDecoder failure exception");
                        this.mRegionDecoder = null;
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                    ImageManagerLog.e(TAG, "Init BitmapRegionDecoder failure exception , is SharpP = " + SharpPUtils.isSharpP(new File(this.mImagePath)));
                    this.mRegionDecoder = null;
                }
                BitmapRegionDecoder bitmapRegionDecoder2 = this.mRegionDecoder;
                if (bitmapRegionDecoder2 != null) {
                    this.mOrgImageWidth = bitmapRegionDecoder2.getWidth();
                    this.mOrgimageHeight = this.mRegionDecoder.getHeight();
                    processImageSize();
                    ImageManagerLog.i(TAG, "origin image size " + this.mRegionDecoder.getWidth() + HippyTKDListViewAdapter.X + this.mRegionDecoder.getHeight() + " mRotation = " + this.mRotation);
                }
                if (this.mRegionDecoder == null) {
                    ImageManagerLog.e(TAG, "BitmapRegionDecoder object is null");
                    return;
                }
                return;
            }
            throw new RuntimeException("Image path is null");
        }
    }

    private void processImageSize() {
        boolean z16;
        int i3;
        int i16;
        if (this.mOrgImageWidth != 0 && this.mOrgimageHeight != 0 && !TextUtils.isEmpty(this.mImagePath)) {
            if (this.mRotation == -1) {
                this.mRotation = RegionImageUtil.getRotation(this.mImagePath);
            }
            int i17 = this.mRotation;
            if ((i17 > 45 && i17 < 135) || (i17 > 225 && i17 < 315)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                i3 = this.mOrgImageWidth;
            } else {
                i3 = this.mOrgimageHeight;
            }
            if (!z16) {
                i16 = this.mOrgimageHeight;
            } else {
                i16 = this.mOrgImageWidth;
            }
            this.mOrgImageWidth = i3;
            this.mOrgimageHeight = i16;
        }
    }

    private void recycleRegionBitmap() {
        Bitmap bitmap;
        Iterator<Map.Entry<Rect, DrawData>> it = this.mDataList.entrySet().iterator();
        while (it.hasNext()) {
            DrawData value = it.next().getValue();
            if (value != null && (bitmap = value.mBitmap) != null) {
                bitmap.recycle();
                value.mBitmap = null;
            }
        }
        this.mDataList.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect rotateRect(Rect rect) {
        if (this.mOrgImageWidth != 0 && this.mOrgimageHeight != 0) {
            if (this.mRotation == -1) {
                this.mRotation = RegionImageUtil.getRotation(this.mImagePath);
            }
            ImageManagerLog.w(TAG, "rotateRect mRotation = " + this.mRotation);
            if (this.mExifMatrix == null) {
                Matrix matrix = new Matrix();
                this.mExifMatrix = matrix;
                int i3 = this.mRotation;
                if (i3 != -270) {
                    if (i3 != -180) {
                        if (i3 != -90) {
                            if (i3 != 90) {
                                if (i3 != 180) {
                                    if (i3 != 270) {
                                        ImageManagerLog.e(TAG, "rotateRect mRotation = " + this.mRotation);
                                    }
                                }
                            }
                        }
                        matrix.postRotate(90.0f);
                        this.mExifMatrix.postTranslate(this.mOrgimageHeight, 0.0f);
                    }
                    matrix.postRotate(180.0f);
                    this.mExifMatrix.postTranslate(this.mOrgImageWidth, this.mOrgimageHeight);
                }
                matrix.postRotate(-90.0f);
                this.mExifMatrix.postTranslate(0.0f, this.mOrgImageWidth);
            }
            if (this.mExifMatrix != null) {
                RectF rectF = new RectF(rect);
                this.mExifMatrix.mapRect(rectF);
                rectF.round(rect);
            }
        }
        return rect;
    }

    public void draw(Canvas canvas, Paint paint) {
        synchronized (this.mDataLock) {
            HashMap<Rect, DrawData> hashMap = this.mDataList;
            if (hashMap != null && !hashMap.isEmpty()) {
                Iterator<Map.Entry<Rect, DrawData>> it = this.mDataList.entrySet().iterator();
                while (it.hasNext()) {
                    DrawData value = it.next().getValue();
                    Bitmap bitmap = value.mBitmap;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        canvas.drawBitmap(value.mBitmap, (Rect) null, value.mOrgRect, paint);
                    }
                }
            }
        }
    }

    public void recycle() {
        synchronized (this.mDataLock) {
            BitmapRegionDecoder bitmapRegionDecoder = this.mRegionDecoder;
            if (bitmapRegionDecoder != null && !bitmapRegionDecoder.isRecycled()) {
                ImageManagerLog.i(TAG, "mRegionDecoder recycle");
                this.mRegionDecoder.recycle();
                this.mRegionDecoder = null;
            }
            recycleRegionBitmap();
        }
    }

    public void setOnUpdateCallback(OnUpdateCallback onUpdateCallback) {
        this.mCallback = new WeakReference<>(onUpdateCallback);
    }

    public void updateRegionBitmap(RegionDrawableData regionDrawableData) {
        if (regionDrawableData == null) {
            return;
        }
        if (this.mWorkHandler.hasMessages(1)) {
            this.mWorkHandler.removeMessages(1);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mCurrentTime = currentTimeMillis;
        regionDrawableData.mTaskTime = currentTimeMillis;
        WorkHandler workHandler = this.mWorkHandler;
        workHandler.sendMessage(workHandler.obtainMessage(1, regionDrawableData));
    }
}
