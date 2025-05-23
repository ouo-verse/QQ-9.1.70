package cooperation.qzone.zipanimate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QzoneMainRuntime;
import com.tencent.component.media.image.IDecoder;
import com.tencent.component.media.image.ImageManager;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasQzoneYellowThread;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class ZipDrawableLoader implements ZipDrawableLoaderInterface {
    public static final String DEFAULT_BUSINESS = "zip_drawable";
    private static final int PRELOAD_FRAME_NUM = 1;
    public static final byte[] inTempStorage = new byte[24576];
    private String mBusiness;
    private WeakReference<Context> mContext;
    private BitmapDrawable mCurrentDrawable;
    private long mCurrentTime;
    private String mDir;
    private ZipFrameLoadedListener mDrawableLoadedListener;
    private ZipLoadedListener mListener;
    private boolean mPreLoadFrame;
    private ZipFirstFrameLoadedListener mZipFirstFrameLoadedListener;
    private String mZipUrl;
    private volatile boolean mIsRunning = false;
    private int mPreloadNum = -1;
    private boolean mRecycleFlag = true;
    private Rect mBounds = null;
    boolean mFirstFrameLoaded = false;
    private CopyOnWriteArrayList<AnimationFrame> mAnimationFrames = new CopyOnWriteArrayList<>();
    private int mCurFrame = -1;
    private int mDecodeFileWidth = -1;
    private int mDecodeFileHeight = -1;
    private float mScale = 1.0f;
    private QzoneZipCacheHelperCallBack mCallback = new QzoneZipCacheHelperCallBack() { // from class: cooperation.qzone.zipanimate.ZipDrawableLoader.2
        @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
        public void onResult(boolean z16) {
            ZipDrawableLoader.this.updateData(z16);
        }

        @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
        public void onResultOfNativeRequest(boolean z16, String str, String str2) {
        }
    };
    private Set<WeakReference<Bitmap>> mReusableBitmaps = Collections.synchronizedSet(new HashSet());

    public ZipDrawableLoader(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int i3, int i16) {
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        int i19 = 1;
        if (i17 > i16 || i18 > i3) {
            int i26 = i17 / 2;
            int i27 = i18 / 2;
            while (i26 / i19 > i16 && i27 / i19 > i3) {
                i19 *= 2;
            }
        }
        return i19;
    }

    private void clearFrames(int i3) {
        int i16 = this.mPreloadNum + i3;
        int size = this.mAnimationFrames.size();
        if (i3 < 0 || i3 >= i16 || i3 >= size) {
            return;
        }
        if (i16 >= size) {
            for (int i17 = i16 % size; i17 < i3; i17++) {
                AnimationFrame animationFrame = this.mAnimationFrames.get(i17);
                BitmapDrawable bitmapDrawable = animationFrame.mBitmapDrawable;
                if (bitmapDrawable != this.mCurrentDrawable) {
                    if (this.mRecycleFlag) {
                        tryReuseBitmapDrawalbe(bitmapDrawable);
                    }
                    animationFrame.mBitmapDrawable = null;
                }
            }
            return;
        }
        for (int i18 = 0; i18 < i3; i18++) {
            AnimationFrame animationFrame2 = this.mAnimationFrames.get(i18);
            BitmapDrawable bitmapDrawable2 = animationFrame2.mBitmapDrawable;
            if (bitmapDrawable2 != this.mCurrentDrawable) {
                if (this.mRecycleFlag) {
                    tryReuseBitmapDrawalbe(bitmapDrawable2);
                }
                animationFrame2.mBitmapDrawable = null;
            }
        }
        while (i16 < size) {
            AnimationFrame animationFrame3 = this.mAnimationFrames.get(i16);
            BitmapDrawable bitmapDrawable3 = animationFrame3.mBitmapDrawable;
            if (bitmapDrawable3 != this.mCurrentDrawable) {
                if (this.mRecycleFlag) {
                    tryReuseBitmapDrawalbe(bitmapDrawable3);
                }
                animationFrame3.mBitmapDrawable = null;
            }
            i16++;
        }
    }

    private void clearList() {
        Iterator<AnimationFrame> it = this.mAnimationFrames.iterator();
        while (it.hasNext()) {
            AnimationFrame next = it.next();
            if (next.mBitmapDrawable != null) {
                next.mBitmapDrawable = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BitmapDrawable decodeBitmap(String str) {
        Bitmap decodeFile;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (BaseApplicationImpl.getApplication().getRuntime() instanceof QzoneMainRuntime) {
                IDecoder decoder = ImageManager.getInstance().getDecoder();
                if (decoder != null) {
                    File file = new File(str);
                    if (file.exists() && !file.isDirectory()) {
                        decodeFile = decoder.decodeBitmap(file, this.mDecodeFileWidth, this.mDecodeFileHeight, getBitmapFromReusableSet());
                    }
                }
                decodeFile = null;
            } else {
                BitmapFactory.Options options = new BitmapFactory.Options();
                int i3 = 1;
                options.inJustDecodeBounds = true;
                byte[] bArr = inTempStorage;
                options.inTempStorage = bArr;
                BitmapFactory.decodeFile(str, options);
                int i16 = this.mDecodeFileHeight;
                if (i16 >= 0 || this.mDecodeFileWidth >= 0) {
                    i3 = calculateInSampleSize(options, this.mDecodeFileWidth, i16);
                }
                options.inJustDecodeBounds = false;
                options.inSampleSize = i3;
                options.inTempStorage = bArr;
                addInBitmapOptions(options);
                decodeFile = SafeBitmapFactory.decodeFile(str, options);
            }
            if (decodeFile != null) {
                decodeFile.setDensity(160);
                return new BitmapDrawable(decodeFile);
            }
        } catch (Exception e16) {
            QZLog.e("ziploader", "decode bitmap exception " + e16);
        } catch (OutOfMemoryError unused) {
            QZLog.e("ziploader", "OutOfMemoryError  ");
        }
        return null;
    }

    private void decodeFrameAsyn(final int i3, final ZipFrameLoadedListener zipFrameLoadedListener) {
        if (i3 > this.mAnimationFrames.size()) {
            return;
        }
        if (this.mAnimationFrames.get(i3).mBitmapDrawable == null) {
            VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: cooperation.qzone.zipanimate.ZipDrawableLoader.3
                @Override // java.lang.Runnable
                public void run() {
                    AnimationFrame animationFrame;
                    BitmapDrawable decodeBitmap;
                    int i16 = i3;
                    if (i16 < ZipDrawableLoader.this.mCurFrame) {
                        i16 += ZipDrawableLoader.this.mAnimationFrames.size();
                    }
                    if (i16 - ZipDrawableLoader.this.mCurFrame <= ZipDrawableLoader.this.mPreloadNum && i3 < ZipDrawableLoader.this.mAnimationFrames.size()) {
                        synchronized (ZipDrawableLoader.this) {
                            animationFrame = i3 < ZipDrawableLoader.this.mAnimationFrames.size() ? (AnimationFrame) ZipDrawableLoader.this.mAnimationFrames.get(i3) : null;
                        }
                        if (animationFrame != null) {
                            if (animationFrame.mBitmapDrawable == null && (decodeBitmap = ZipDrawableLoader.this.decodeBitmap(animationFrame.path)) != null) {
                                int intrinsicWidth = decodeBitmap.getIntrinsicWidth();
                                int intrinsicHeight = decodeBitmap.getIntrinsicHeight();
                                int i17 = (int) (intrinsicWidth * ZipDrawableLoader.this.mScale);
                                int i18 = (int) (intrinsicHeight * ZipDrawableLoader.this.mScale);
                                if (ZipDrawableLoader.this.mBounds != null) {
                                    decodeBitmap.setBounds(ZipDrawableLoader.this.mBounds);
                                } else {
                                    decodeBitmap.setBounds(0, 0, i17, i18);
                                }
                                animationFrame.mBitmapDrawable = decodeBitmap;
                            }
                            ZipFrameLoadedListener zipFrameLoadedListener2 = zipFrameLoadedListener;
                            if (zipFrameLoadedListener2 != null) {
                                zipFrameLoadedListener2.onLoaded(i3, animationFrame.mBitmapDrawable);
                            }
                            ZipDrawableLoader zipDrawableLoader = ZipDrawableLoader.this;
                            if (zipDrawableLoader.mFirstFrameLoaded) {
                                return;
                            }
                            zipDrawableLoader.mFirstFrameLoaded = true;
                            if (zipDrawableLoader.mZipFirstFrameLoadedListener != null) {
                                ZipDrawableLoader.this.mZipFirstFrameLoadedListener.onZipFirstFrameLoaded(animationFrame.mBitmapDrawable);
                            }
                        }
                    }
                }
            });
            return;
        }
        if (zipFrameLoadedListener != null) {
            zipFrameLoadedListener.onLoaded(i3, this.mAnimationFrames.get(i3).mBitmapDrawable);
        }
        if (this.mFirstFrameLoaded) {
            return;
        }
        this.mFirstFrameLoaded = true;
        ZipFirstFrameLoadedListener zipFirstFrameLoadedListener = this.mZipFirstFrameLoadedListener;
        if (zipFirstFrameLoadedListener != null) {
            zipFirstFrameLoadedListener.onZipFirstFrameLoaded(this.mAnimationFrames.get(i3).mBitmapDrawable);
        }
    }

    private synchronized boolean selectDrawable(int i3) {
        safeUpdateCurrentDrawable(this.mAnimationFrames.get(i3));
        clearFrames(this.mCurFrame);
        preloadFrame(this.mAnimationFrames, this.mCurFrame + 1);
        return false;
    }

    protected Bitmap getBitmapFromReusableSet() {
        Set<WeakReference<Bitmap>> set = this.mReusableBitmaps;
        Bitmap bitmap = null;
        if (set != null && !set.isEmpty()) {
            synchronized (this.mReusableBitmaps) {
                Iterator<WeakReference<Bitmap>> it = this.mReusableBitmaps.iterator();
                while (it.hasNext()) {
                    Bitmap bitmap2 = it.next().get();
                    if (bitmap2 != null && bitmap2.isMutable()) {
                        it.remove();
                        bitmap = bitmap2;
                    } else {
                        it.remove();
                    }
                }
            }
        }
        return bitmap;
    }

    @Override // cooperation.qzone.zipanimate.ZipDrawableLoaderInterface
    public int getCurFrameNum() {
        return this.mCurFrame;
    }

    @Override // cooperation.qzone.zipanimate.ZipDrawableLoaderInterface
    public int getFrameCount() {
        return this.mAnimationFrames.size();
    }

    @Override // cooperation.qzone.zipanimate.ZipDrawableLoaderInterface
    public CopyOnWriteArrayList<AnimationFrame> getFrames() {
        return this.mAnimationFrames;
    }

    public String getZipDrawableDirSuffix(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return String.valueOf(str.hashCode());
    }

    @Override // cooperation.qzone.zipanimate.ZipDrawableLoaderInterface
    public synchronized void loadFrame(int i3, ZipFrameLoadedListener zipFrameLoadedListener) {
        if (this.mAnimationFrames.size() <= i3) {
            return;
        }
        decodeFrameAsyn(i3, zipFrameLoadedListener);
        setFrame(i3);
    }

    public synchronized void loadLocalZipData(String str, String str2, String str3, boolean z16) {
        this.mAnimationFrames.clear();
        if (this.mPreloadNum <= 0) {
            this.mPreloadNum = 1;
        }
        this.mPreLoadFrame = z16;
        loadZipData(((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getFolderFileNameList(str, str2, str3), ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath(str, str2) + File.separator + str3);
    }

    @Override // cooperation.qzone.zipanimate.ZipDrawableLoaderInterface
    public synchronized boolean nextFrame() {
        int i3;
        int size;
        i3 = this.mCurFrame + 1;
        size = this.mAnimationFrames.size();
        if (i3 >= size) {
            i3 = 0;
        }
        setFrame(i3);
        return i3 == size - 1;
    }

    public void onBoundsChange(Rect rect) {
        this.mBounds = rect;
        BitmapDrawable bitmapDrawable = this.mCurrentDrawable;
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(rect);
        }
    }

    synchronized void preloadFrame(List<AnimationFrame> list, int i3) {
        if (this.mAnimationFrames.isEmpty()) {
            return;
        }
        for (int i16 = 0; i16 < this.mPreloadNum; i16++) {
            decodeFrameAsyn((i3 + i16) % list.size(), this.mDrawableLoadedListener);
        }
    }

    public void selectFrame(int i3) {
        CopyOnWriteArrayList<AnimationFrame> copyOnWriteArrayList = this.mAnimationFrames;
        if (copyOnWriteArrayList == null || i3 >= copyOnWriteArrayList.size()) {
            return;
        }
        this.mCurFrame = i3;
        safeUpdateCurrentDrawable(this.mAnimationFrames.get(i3));
    }

    @Override // cooperation.qzone.zipanimate.ZipDrawableLoaderInterface
    public synchronized void setDrawableData(String str, int i3, boolean z16) {
        setDrawableData(str, DEFAULT_BUSINESS, getZipDrawableDirSuffix(str), i3, z16);
    }

    public void setDrawableLoadedListener(ZipFrameLoadedListener zipFrameLoadedListener) {
        this.mDrawableLoadedListener = zipFrameLoadedListener;
    }

    @Override // cooperation.qzone.zipanimate.ZipDrawableLoaderInterface
    public synchronized void setFrame(int i3) {
        if (i3 >= this.mAnimationFrames.size()) {
            return;
        }
        this.mCurFrame = i3;
        selectDrawable(i3);
    }

    @Override // cooperation.qzone.zipanimate.ZipDrawableLoaderInterface
    public void setRecycleFlag(boolean z16) {
        this.mRecycleFlag = z16;
    }

    public void setScale(float f16) {
        this.mScale = f16;
    }

    @Override // cooperation.qzone.zipanimate.ZipDrawableLoaderInterface
    public void setSize(int i3, int i16) {
        this.mDecodeFileWidth = i3;
        this.mDecodeFileHeight = i16;
    }

    public void setZipFirstFrameLoadedListener(ZipFirstFrameLoadedListener zipFirstFrameLoadedListener) {
        this.mZipFirstFrameLoadedListener = zipFirstFrameLoadedListener;
    }

    @Override // cooperation.qzone.zipanimate.ZipDrawableLoaderInterface
    public void setZipLoadedListener(ZipLoadedListener zipLoadedListener) {
        this.mListener = zipLoadedListener;
    }

    private void addInBitmapOptions(BitmapFactory.Options options) {
        options.inMutable = true;
        Bitmap bitmapFromReusableSet = getBitmapFromReusableSet();
        if (bitmapFromReusableSet != null) {
            options.inBitmap = bitmapFromReusableSet;
        }
    }

    @Override // cooperation.qzone.zipanimate.ZipDrawableLoaderInterface
    public BitmapDrawable getCurrentDrawable() {
        return this.mCurrentDrawable;
    }

    @Override // cooperation.qzone.zipanimate.ZipDrawableLoaderInterface
    public void release() {
        clearDrawable(false);
        clearList();
        this.mReusableBitmaps.clear();
    }

    private void safeUpdateCurrentDrawable(AnimationFrame animationFrame) {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        if (animationFrame == null || (bitmapDrawable = animationFrame.mBitmapDrawable) == null || (bitmap = bitmapDrawable.getBitmap()) == null) {
            return;
        }
        if (bitmap.isRecycled()) {
            animationFrame.mBitmapDrawable = null;
        }
        BitmapDrawable bitmapDrawable2 = animationFrame.mBitmapDrawable;
        if (bitmapDrawable2 != null) {
            this.mCurrentDrawable = bitmapDrawable2;
        }
    }

    private void tryReuseBitmapDrawalbe(BitmapDrawable bitmapDrawable) {
        if (bitmapDrawable != null) {
            if (this.mReusableBitmaps.size() < this.mPreloadNum) {
                this.mReusableBitmaps.add(new WeakReference<>(bitmapDrawable.getBitmap()));
                return;
            }
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateData(boolean z16) {
        if (z16) {
            loadZipData(((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getFolderFileNameList(this.mBusiness, this.mDir), ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath(this.mBusiness, this.mDir));
            return;
        }
        ZipLoadedListener zipLoadedListener = this.mListener;
        if (zipLoadedListener != null) {
            zipLoadedListener.onZipLoaded(z16);
        }
    }

    @Override // cooperation.qzone.zipanimate.ZipDrawableLoaderInterface
    public synchronized void setDrawableData(String str, String str2, String str3, final int i3, boolean z16) {
        this.mAnimationFrames.clear();
        if (str == null) {
            return;
        }
        if (this.mPreloadNum <= 0) {
            this.mPreloadNum = 1;
        }
        this.mZipUrl = str;
        this.mDir = str3;
        this.mBusiness = str2;
        this.mPreLoadFrame = z16;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: cooperation.qzone.zipanimate.ZipDrawableLoader.1
            @Override // java.lang.Runnable
            public void run() {
                if (((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).checkAndDownLoadFileIfNeeded(null, ZipDrawableLoader.this.mZipUrl, ZipDrawableLoader.this.mBusiness, ZipDrawableLoader.this.mDir, i3, ZipDrawableLoader.this.mCallback)) {
                    ZipDrawableLoader.this.updateData(true);
                }
            }
        });
    }

    @Override // cooperation.qzone.zipanimate.ZipDrawableLoaderInterface
    public void setPreloadNum(int i3) {
        if (i3 > 0) {
            this.mPreloadNum = i3;
        }
    }

    private void clearDrawable(boolean z16) {
        if (z16) {
            return;
        }
        this.mCurrentDrawable = null;
    }

    private void loadZipData(String[] strArr, String str) {
        boolean z16;
        if (strArr == null || strArr.length <= 0) {
            z16 = false;
        } else {
            synchronized (this) {
                this.mAnimationFrames.clear();
                for (String str2 : strArr) {
                    AnimationFrame animationFrame = new AnimationFrame();
                    String str3 = str + File.separator + str2;
                    animationFrame.path = str3;
                    if (str3.endsWith(".jpg") || animationFrame.path.endsWith(".png")) {
                        this.mAnimationFrames.add(animationFrame);
                    }
                }
            }
            z16 = true;
        }
        if (this.mPreLoadFrame) {
            loadFrame(0, this.mDrawableLoadedListener);
        }
        ZipLoadedListener zipLoadedListener = this.mListener;
        if (zipLoadedListener != null) {
            zipLoadedListener.onZipLoaded(z16);
        }
    }

    public synchronized void loadLocalZipData(String str, boolean z16) {
        this.mAnimationFrames.clear();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mPreloadNum <= 0) {
            this.mPreloadNum = 1;
        }
        this.mPreLoadFrame = z16;
        loadZipData(((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getFileList(str), str);
    }
}
