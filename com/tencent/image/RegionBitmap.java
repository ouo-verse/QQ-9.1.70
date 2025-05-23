package com.tencent.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.api.ILog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class RegionBitmap {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_RECYCLE_REGION_BITMAP = 2;
    private static final int MSG_UPDATE_DECODE_REGION = 1;
    private static final String TAG = "RegionBitmap";
    private WeakReference<OnUpdateCallback> mCallback;
    private long mCurrentTaskTime;
    private RegionDrawDataList mDataList;
    private Object mDataLock;
    private Rect mDecodeRect;
    private RegionBitmapBlockHelper mHelper;
    private String mImagePath;
    private BitmapRegionDecoder mRegionDecoder;
    private int mSample;
    private Rect mTmp;
    private WorkHandler mWorkHandler;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class DrawData {
        static IPatchRedirector $redirector_;
        public Bitmap mBitmap;
        public int mDecodeSample;
        public Rect mDrawRect;

        public DrawData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mDecodeSample = 0;
            }
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
            }
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return ((DrawData) obj).mDrawRect.equals(this.mDrawRect);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface OnUpdateCallback {
        void regionRefreshed();
    }

    public RegionBitmap(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.mDecodeRect = new Rect();
        this.mTmp = new Rect();
        this.mDataLock = new Object();
        this.mDataList = new RegionDrawDataList();
        if (this.mWorkHandler == null) {
            this.mWorkHandler = new WorkHandler(URLDrawable.depImp.mThreadManager.getFileThread().getLooper());
        }
        this.mImagePath = str;
    }

    public static Rect decodeToRegion(int i3, int i16, Rect rect) {
        if (rect == null) {
            return null;
        }
        return new Rect((rect.left * i16) / i3, (rect.top * i16) / i3, (rect.right * i16) / i3, (rect.bottom * i16) / i3);
    }

    public static Rect regionToDecode(int i3, int i16, Rect rect) {
        if (rect == null) {
            return null;
        }
        return new Rect((rect.left * i3) / i16, (rect.top * i3) / i16, (rect.right * i3) / i16, (rect.bottom * i3) / i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint) {
        synchronized (this.mDataLock) {
            RegionDrawDataList regionDrawDataList = this.mDataList;
            if (regionDrawDataList != null && !regionDrawDataList.isEmpty()) {
                Iterator<DrawData> it = this.mDataList.iterator();
                while (it.hasNext()) {
                    DrawData next = it.next();
                    Bitmap bitmap = next.mBitmap;
                    if (bitmap != null) {
                        canvas.drawBitmap(bitmap, (Rect) null, next.mDrawRect, paint);
                    }
                }
            }
        }
    }

    public void recycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (!this.mWorkHandler.hasMessages(2)) {
            this.mWorkHandler.sendEmptyMessage(2);
        }
    }

    public void setOnUpdateCallback(OnUpdateCallback onUpdateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) onUpdateCallback);
        } else {
            this.mCallback = new WeakReference<>(onUpdateCallback);
        }
    }

    public void updateRegionBitmap(RegionDrawableData regionDrawableData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) regionDrawableData);
            return;
        }
        if (this.mWorkHandler.hasMessages(1)) {
            this.mWorkHandler.removeMessages(1);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mCurrentTaskTime = uptimeMillis;
        regionDrawableData.mTaskTime = uptimeMillis;
        WorkHandler workHandler = this.mWorkHandler;
        workHandler.sendMessage(workHandler.obtainMessage(1, regionDrawableData));
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    final class WorkHandler extends Handler {
        static IPatchRedirector $redirector_;

        public WorkHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) RegionBitmap.this);
        }

        private void decode(RegionDrawableData regionDrawableData, DrawData drawData, int i3) {
            OnUpdateCallback onUpdateCallback;
            OnUpdateCallback onUpdateCallback2;
            OnUpdateCallback onUpdateCallback3;
            OnUpdateCallback onUpdateCallback4;
            OnUpdateCallback onUpdateCallback5;
            SystemClock.uptimeMillis();
            Rect rect = new Rect();
            rect.set(RegionBitmap.regionToDecode(regionDrawableData.mSourceDensity, regionDrawableData.mTargetDensity, drawData.mDrawRect));
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i3;
            try {
                try {
                    try {
                        Bitmap decodeRegion = RegionBitmap.this.mRegionDecoder.decodeRegion(rect, options);
                        drawData.mBitmap = decodeRegion;
                        drawData.mDecodeSample = options.inSampleSize;
                        if (decodeRegion != null && !decodeRegion.isRecycled() && (onUpdateCallback5 = (OnUpdateCallback) RegionBitmap.this.mCallback.get()) != null) {
                            onUpdateCallback5.regionRefreshed();
                        }
                        if (!URLDrawable.depImp.mLog.isColorLevel() || decodeRegion != null) {
                            return;
                        }
                    } catch (IllegalArgumentException e16) {
                        drawData.mBitmap = null;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(RegionBitmap.this.mRegionDecoder.getWidth());
                        sb5.append(HippyTKDListViewAdapter.X);
                        sb5.append(RegionBitmap.this.mRegionDecoder.getHeight());
                        sb5.append("\n");
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.w("RegionDrawable", 1, e16);
                        }
                        Bitmap bitmap = drawData.mBitmap;
                        drawData.mDecodeSample = options.inSampleSize;
                        if (bitmap != null && !bitmap.isRecycled() && (onUpdateCallback2 = (OnUpdateCallback) RegionBitmap.this.mCallback.get()) != null) {
                            onUpdateCallback2.regionRefreshed();
                        }
                        if (!URLDrawable.depImp.mLog.isColorLevel() || bitmap != null) {
                            return;
                        }
                    } catch (OutOfMemoryError unused) {
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.i("RegionDrawable", 2, "decodeRegion OOM" + options.inSampleSize);
                        }
                        try {
                            System.gc();
                            options.inSampleSize <<= 1;
                            drawData.mBitmap = RegionBitmap.this.mRegionDecoder.decodeRegion(rect, options);
                        } catch (Exception e17) {
                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                URLDrawable.depImp.mLog.w("RegionDrawable", 1, e17);
                            }
                        }
                        Bitmap bitmap2 = drawData.mBitmap;
                        drawData.mDecodeSample = options.inSampleSize;
                        if (bitmap2 != null && !bitmap2.isRecycled() && (onUpdateCallback = (OnUpdateCallback) RegionBitmap.this.mCallback.get()) != null) {
                            onUpdateCallback.regionRefreshed();
                        }
                        if (!URLDrawable.depImp.mLog.isColorLevel() || bitmap2 != null) {
                            return;
                        }
                    }
                } catch (RuntimeException e18) {
                    drawData.mBitmap = null;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(RegionBitmap.this.mRegionDecoder.getWidth());
                    sb6.append(HippyTKDListViewAdapter.X);
                    sb6.append(RegionBitmap.this.mRegionDecoder.getHeight());
                    sb6.append("\n");
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.w("RegionDrawable", 1, e18);
                    }
                    Bitmap bitmap3 = drawData.mBitmap;
                    drawData.mDecodeSample = options.inSampleSize;
                    if (bitmap3 != null && !bitmap3.isRecycled() && (onUpdateCallback3 = (OnUpdateCallback) RegionBitmap.this.mCallback.get()) != null) {
                        onUpdateCallback3.regionRefreshed();
                    }
                    if (!URLDrawable.depImp.mLog.isColorLevel() || bitmap3 != null) {
                        return;
                    }
                }
                URLDrawable.depImp.mLog.i("RegionDrawable", 2, "Decode region failure...");
            } catch (Throwable th5) {
                Bitmap bitmap4 = drawData.mBitmap;
                drawData.mDecodeSample = options.inSampleSize;
                if (bitmap4 != null && !bitmap4.isRecycled() && (onUpdateCallback4 = (OnUpdateCallback) RegionBitmap.this.mCallback.get()) != null) {
                    onUpdateCallback4.regionRefreshed();
                }
                if (URLDrawable.depImp.mLog.isColorLevel() && bitmap4 == null) {
                    URLDrawable.depImp.mLog.i("RegionDrawable", 2, "Decode region failure...");
                }
                throw th5;
            }
        }

        private void initRegionDecoder() {
            if (RegionBitmap.this.mRegionDecoder == null || RegionBitmap.this.mRegionDecoder.isRecycled()) {
                if (!TextUtils.isEmpty(RegionBitmap.this.mImagePath)) {
                    try {
                        try {
                            RegionBitmap regionBitmap = RegionBitmap.this;
                            regionBitmap.mRegionDecoder = BitmapRegionDecoder.newInstance(regionBitmap.mImagePath, true);
                            if (URLDrawable.depImp.mLog.isColorLevel() && RegionBitmap.this.mRegionDecoder != null) {
                                URLDrawable.depImp.mLog.i("RegionDrawable", 2, "origin size " + RegionBitmap.this.mRegionDecoder.getWidth() + HippyTKDListViewAdapter.X + RegionBitmap.this.mRegionDecoder.getHeight());
                            }
                        } catch (FileNotFoundException unused) {
                            RegionBitmap.this.mRegionDecoder = BitmapRegionDecoder.newInstance(Uri.parse(RegionBitmap.this.mImagePath).getPath(), true);
                        } catch (Exception e16) {
                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                URLDrawable.depImp.mLog.e(RegionBitmap.TAG, 2, "Init BitmapRegionDecoder failure", e16);
                            }
                            RegionBitmap.this.mRegionDecoder = null;
                        }
                    } catch (Exception e17) {
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.e(RegionBitmap.TAG, 2, "Init BitmapRegionDecoder failure", e17);
                        }
                        RegionBitmap.this.mRegionDecoder = null;
                    }
                    if (RegionBitmap.this.mRegionDecoder == null && URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.e(RegionBitmap.TAG, 2, "BitmapRegionDecoder object is null");
                        return;
                    }
                    return;
                }
                throw new RuntimeException("Image path is null");
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            RegionDrawableData regionDrawableData;
            int calcSample;
            Rect rect;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2 && RegionBitmap.this.mRegionDecoder != null && !RegionBitmap.this.mRegionDecoder.isRecycled()) {
                    RegionBitmap.this.mRegionDecoder.recycle();
                    RegionBitmap.this.mRegionDecoder = null;
                    return;
                }
                return;
            }
            initRegionDecoder();
            if (RegionBitmap.this.mRegionDecoder == null || !RegionDrawableData.class.isInstance(message.obj) || (calcSample = (regionDrawableData = (RegionDrawableData) message.obj).calcSample()) == 0) {
                return;
            }
            int i16 = 0;
            if (RegionBitmap.this.mHelper == null) {
                RegionBitmap.this.mHelper = new RegionBitmapBlockHelper(new Rect(0, 0, RegionBitmap.this.mRegionDecoder.getWidth(), RegionBitmap.this.mRegionDecoder.getHeight()), regionDrawableData.mSourceDensity, regionDrawableData.mTargetDensity);
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            Rect regionToDecode = RegionBitmap.regionToDecode(regionDrawableData.mSourceDensity, regionDrawableData.mTargetDensity, regionDrawableData.mShowArea);
            LinkedList<DrawData> drawDatas = RegionBitmap.this.mHelper.getDrawDatas(regionDrawableData, calcSample);
            RegionDrawDataList regionDrawDataList = new RegionDrawDataList();
            Iterator<DrawData> it = drawDatas.iterator();
            while (it.hasNext()) {
                DrawData next = it.next();
                DrawData regionData = RegionBitmap.this.mDataList.getRegionData(next);
                if (regionData == null) {
                    regionDrawDataList.add(next);
                    i16++;
                } else {
                    regionDrawDataList.add(regionData);
                }
            }
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            synchronized (RegionBitmap.this.mDataLock) {
                RegionBitmap.this.mDataList = regionDrawDataList;
            }
            long uptimeMillis3 = SystemClock.uptimeMillis();
            Iterator<DrawData> it5 = RegionBitmap.this.mDataList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                DrawData next2 = it5.next();
                if (calcSample != next2.mDecodeSample || next2.mBitmap == null || (rect = next2.mDrawRect) == null || rect.isEmpty()) {
                    if (RegionBitmap.this.mCurrentTaskTime != regionDrawableData.mTaskTime) {
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.e(RegionBitmap.TAG, 2, "decode cancel");
                        }
                    } else {
                        decode(regionDrawableData, next2, calcSample);
                    }
                }
            }
            RegionBitmap.this.mSample = calcSample;
            RegionBitmap.this.mDecodeRect.set(regionToDecode);
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.i("RegionDrawable", 2, "\u9009\u53d6\u6709\u6548\u5757:cost " + uptimeMillis2);
                URLDrawable.depImp.mLog.i("RegionDrawable", 2, "\u89e3\u6790\u6709\u6548\u5757:cost " + (SystemClock.uptimeMillis() - uptimeMillis3));
                URLDrawable.depImp.mLog.i("RegionDrawable", 2, "\u5206\u5757\uff1a" + RegionBitmap.this.mDataList.size());
                URLDrawable.depImp.mLog.i("RegionDrawable", 2, "new block " + i16 + ", old block not decode " + i16 + ",old block decode " + i16);
                ILog iLog = URLDrawable.depImp.mLog;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("decode rect ");
                sb5.append(regionToDecode);
                sb5.append(" sample ");
                sb5.append(calcSample);
                iLog.i("RegionDrawable", 2, sb5.toString());
            }
        }

        public WorkHandler(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) RegionBitmap.this, (Object) looper);
        }
    }
}
