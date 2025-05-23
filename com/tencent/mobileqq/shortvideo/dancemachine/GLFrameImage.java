package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.richmedia.FileUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GLFrameImage extends GLImageView {
    public static final int ANIMATION_MODE_RESTART = 1;
    public static final int ANIMATION_MODE_REVERSE = 0;
    public static final int LOAD_ONE_ALL = 0;
    public static final int LOAD_ONE_USED = 1;
    private static HashMap<String, GLImage> mFrameImages = new HashMap<>();
    private ArrayList<String> mAnimationFrames;
    private int mCurrentFrameIndex;
    private int mFrameAnimationMode;
    private float mFrameDuration;
    private boolean mHasAnimationStarted;
    private boolean mHasInitedImage;
    protected boolean mIsBoyFilterPrivateRes;
    private int mLoadTextureMode;
    private boolean mNeedTemporaryRelease;
    private boolean mReversedPlay;
    private long mStartMsTime;

    public GLFrameImage(GLViewContext gLViewContext, String str) {
        super(gLViewContext, str);
        this.mLoadTextureMode = 0;
        this.mAnimationFrames = new ArrayList<>();
        this.mHasInitedImage = false;
        this.mFrameAnimationMode = 1;
        this.mReversedPlay = false;
        this.mNeedTemporaryRelease = true;
        this.mIsBoyFilterPrivateRes = false;
    }

    public static void clearTextureCache() {
        Iterator<String> it = mFrameImages.keySet().iterator();
        while (it.hasNext()) {
            GLImage gLImage = mFrameImages.get(it.next());
            if (gLImage != null) {
                gLImage.release();
            }
        }
        mFrameImages.clear();
        DanceLog.printFrameQueue("GLFrameImage", "clearTextureCache");
    }

    public static GLImage getImageByPath(String str, boolean z16, boolean z17) {
        GLImage gLImage = mFrameImages.get(str);
        if (gLImage == null) {
            gLImage = new GLImage(z16, z17);
            gLImage.loadTextureSync(str);
            mFrameImages.put(str, gLImage);
        }
        DanceLog.printFrameQueue("GLFrameImage", "getImageByPath");
        return gLImage;
    }

    public static void oncePreloadBoyFilterPrivateResource() {
        DanceLog.printFrameQueue("GLFrameImage", "oncePreloadBoyFilterPrivateResource[begin]");
        Map<String, ResourceManager.Posture> allBoyPosture = ResourceManager.getInstance().getAllBoyPosture();
        Set<String> keySet = allBoyPosture.keySet();
        if (keySet.size() <= 0) {
            return;
        }
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {
            ResourceManager.Posture posture = allBoyPosture.get(it.next());
            List<String> list = posture.danceCartoon;
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                HashMap<String, GLImage> hashMap = new HashMap<>();
                Bitmap bitmap = null;
                for (String str : posture.danceCartoon) {
                    if (bitmap == null && arrayList.size() > 0) {
                        bitmap = (Bitmap) arrayList.get(0);
                    }
                    Bitmap loadBitmapFromNative = FileUtils.loadBitmapFromNative(str, false, bitmap);
                    if (loadBitmapFromNative == null) {
                        if (bitmap != null) {
                            arrayList.remove(bitmap);
                            bitmap.recycle();
                            loadBitmapFromNative = FileUtils.loadBitmapFromNative(str, false);
                            bitmap = null;
                        } else {
                            DanceLog.printFrameQueue("GLFrameImage", "oncePreloadBoyFilterPrivateResource error");
                        }
                    }
                    if (loadBitmapFromNative != null) {
                        GLImage gLImage = new GLImage(true, true);
                        gLImage.loadTextureSync(loadBitmapFromNative, false);
                        hashMap.put(str, gLImage);
                        if (bitmap == null) {
                            arrayList.add(loadBitmapFromNative);
                        } else {
                            loadBitmapFromNative.recycle();
                        }
                    }
                }
                if (bitmap != null) {
                    bitmap.recycle();
                    arrayList.remove(bitmap);
                }
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    ((Bitmap) it5.next()).recycle();
                }
                arrayList.clear();
                TrAsyncTextureLoad.getInstance().notifyGLThreadUpdateTextureCache(hashMap);
            }
        }
        DanceLog.printFrameQueue("GLFrameImage", "oncePreloadBoyFilterPrivateResource[end]");
    }

    private static void printTextureCache() {
        DanceLog.printFrameQueue("GLFrameImage", "printTextureCache[Begin]......................");
        Set<String> keySet = mFrameImages.keySet();
        DanceLog.printFrameQueue("GLFrameImage", "printTextureCache size=" + keySet.size());
        for (String str : keySet) {
            GLImage gLImage = mFrameImages.get(str);
            if (gLImage != null) {
                DanceLog.printFrameQueue("GLFrameImage", "printTextureCache path=" + str + " texture=" + gLImage.getTexture() + " enableRelease=" + gLImage.isEnableTemporaryRelease() + " isBoy=" + gLImage.isBoyFilterTexture());
            } else {
                DanceLog.printFrameQueue("GLFrameImage", "printTextureCache path=" + str + " Released[noValue]");
            }
        }
        DanceLog.printFrameQueue("GLFrameImage", "printTextureCache[End]......................");
    }

    private static void reloadReleaseDanceStageTexture() {
        DanceLog.printFrameQueue("GLFrameImage", "reloadReleaseDanceStageTexture[begin]");
        Set<String> keySet = mFrameImages.keySet();
        for (String str : keySet) {
            if (mFrameImages.get(str) == null) {
                GLImage gLImage = new GLImage(true);
                gLImage.loadTextureSync(str);
                mFrameImages.put(str, gLImage);
            }
        }
        DanceLog.printFrameQueue("GLFrameImage", "reloadReleaseDanceStageTexture[end] loadedSize=" + keySet.size());
    }

    public static void reloadTextureCache() {
        DanceLog.printFrameQueue("GLFrameImage", "reloadTextureCache[begin]");
        TrAsyncTextureLoad.getInstance().processInterrupt();
        printTextureCache();
        temporaryReleaseTextureCacheParam(false);
        reloadReleaseDanceStageTexture();
        printTextureCache();
        DanceLog.printFrameQueue("GLFrameImage", "reloadTextureCache[end]");
    }

    public static void temporaryReleaseTextureCache() {
        temporaryReleaseTextureCacheParam(true);
    }

    private static void temporaryReleaseTextureCacheParam(boolean z16) {
        ArrayList arrayList = new ArrayList(50);
        for (String str : mFrameImages.keySet()) {
            GLImage gLImage = mFrameImages.get(str);
            if (gLImage != null) {
                if (gLImage.isEnableTemporaryRelease()) {
                    if (gLImage.isBoyFilterTexture()) {
                        gLImage.release();
                        mFrameImages.put(str, null);
                        arrayList.add(str);
                    } else if (z16) {
                        gLImage.release();
                        mFrameImages.put(str, null);
                    }
                }
            } else {
                DanceLog.printFrameQueue("GLFrameImage", "temporaryReleaseTextureCache[Error] image=null key=" + str);
            }
        }
        DanceLog.printFrameQueue("GLFrameImage", "temporaryReleaseTextureCache[clear boyFilter] size=" + arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            mFrameImages.remove((String) it.next());
        }
        DanceLog.printFrameQueue("GLFrameImage", "temporaryReleaseTextureCache boyFilterName=" + ResourceManager.getInstance().getLittleBoyFilterRootPath());
        printTextureCache();
    }

    public static void updateGLFrameImageCache(HashMap<String, GLImage> hashMap) {
        if (hashMap.size() > 0) {
            for (String str : hashMap.keySet()) {
                GLImage gLImage = hashMap.get(str);
                GLImage gLImage2 = mFrameImages.get(str);
                if (gLImage2 == null) {
                    mFrameImages.put(str, gLImage);
                } else {
                    DanceLog.printFrameQueue("GLFrameImage", "updateGLFrameImageCache[Error]newImage=" + gLImage + " oldImage=" + gLImage2 + str);
                    if (gLImage != null) {
                        gLImage.release();
                    }
                }
            }
            hashMap.clear();
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GLImageView, com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void clearStatus() {
        super.clearStatus();
        this.mHasAnimationStarted = false;
        this.mReversedPlay = false;
        this.mCurrentFrameIndex = 0;
        this.mStartMsTime = 0L;
        this.mAnimationFrames.clear();
        this.mLoadTextureMode = 0;
        this.mHasInitedImage = false;
        this.mFrameDuration = 0.0f;
        this.mFrameAnimationMode = 1;
    }

    public int getAnimationCurrentIndex() {
        if (this.mHasAnimationStarted) {
            int uptimeMillis = (int) (((float) (SystemClock.uptimeMillis() - this.mStartMsTime)) / this.mFrameDuration);
            this.mCurrentFrameIndex = uptimeMillis;
            int i3 = this.mFrameAnimationMode;
            if (i3 == 1) {
                if (uptimeMillis >= this.mAnimationFrames.size()) {
                    this.mStartMsTime = SystemClock.uptimeMillis();
                    this.mCurrentFrameIndex = 0;
                }
            } else if (i3 == 0) {
                if (this.mReversedPlay) {
                    int size = (this.mAnimationFrames.size() - 2) - this.mCurrentFrameIndex;
                    this.mCurrentFrameIndex = size;
                    if (size <= 0) {
                        this.mReversedPlay = false;
                        this.mStartMsTime = SystemClock.uptimeMillis();
                        this.mCurrentFrameIndex = 0;
                    }
                } else if (uptimeMillis >= this.mAnimationFrames.size()) {
                    this.mStartMsTime = SystemClock.uptimeMillis();
                    int size2 = this.mAnimationFrames.size() - 2;
                    this.mCurrentFrameIndex = size2;
                    if (size2 > 0) {
                        this.mReversedPlay = true;
                    } else {
                        this.mReversedPlay = false;
                        this.mCurrentFrameIndex = 0;
                    }
                }
            }
        }
        return this.mCurrentFrameIndex;
    }

    public GLImage getImageByIndex(int i3) {
        String str = this.mAnimationFrames.get(i3);
        int i16 = this.mLoadTextureMode;
        if ((i16 == 1 || i16 == 0) && mFrameImages.get(str) == null) {
            GLImage gLImage = new GLImage(this.mNeedTemporaryRelease, this.mIsBoyFilterPrivateRes);
            gLImage.loadTextureSync(str);
            mFrameImages.put(str, gLImage);
        }
        DanceLog.printFrameQueue("GLFrameImage", "getImageByIndex");
        return mFrameImages.get(str);
    }

    public GLImage getImageSize() {
        if (this.mAnimationFrames.size() > 0) {
            return mFrameImages.get(this.mAnimationFrames.get(0));
        }
        DanceLog.printFrameQueue("GLFrameImage", "getImageSize");
        return null;
    }

    public void initAnimationFrame() {
        String str;
        if (!this.mHasInitedImage) {
            int i3 = this.mLoadTextureMode;
            if (i3 == 0) {
                Iterator<String> it = this.mAnimationFrames.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null && !next.equals("") && mFrameImages.get(next) == null) {
                        GLImage gLImage = new GLImage(this.mNeedTemporaryRelease, this.mIsBoyFilterPrivateRes);
                        gLImage.loadTextureSync(next);
                        mFrameImages.put(next, gLImage);
                    }
                }
            } else if (i3 == 1 && (str = this.mAnimationFrames.get(0)) != null && !str.equals("") && mFrameImages.get(str) == null) {
                GLImage gLImage2 = new GLImage(this.mNeedTemporaryRelease, this.mIsBoyFilterPrivateRes);
                gLImage2.loadTextureSync(str);
                mFrameImages.put(str, gLImage2);
            }
            this.mHasInitedImage = true;
        }
        DanceLog.printFrameQueue("GLFrameImage", "initAnimationFrame");
    }

    public void setAnimationFrames(List<String> list) {
        this.mAnimationFrames.clear();
        this.mAnimationFrames.addAll(list);
    }

    public void setAnimationPlayMode(int i3) {
        this.mFrameAnimationMode = i3;
    }

    public final void setCurrentImage(int i3) {
        String str = this.mAnimationFrames.get(i3);
        int i16 = this.mLoadTextureMode;
        if (i16 == 0) {
            GLImage gLImage = mFrameImages.get(str);
            if (gLImage == null) {
                if (str != null && !str.equals("")) {
                    GLImage gLImage2 = new GLImage(this.mNeedTemporaryRelease, this.mIsBoyFilterPrivateRes);
                    gLImage2.loadTextureSync(str);
                    mFrameImages.put(str, gLImage2);
                    this.mCurrentTexture = gLImage2.getTexture();
                }
            } else {
                this.mCurrentTexture = gLImage.getTexture();
            }
        } else if (i16 == 1) {
            GLImage gLImage3 = mFrameImages.get(str);
            if (gLImage3 == null) {
                if (str != null && !str.equals("")) {
                    GLImage gLImage4 = new GLImage(this.mNeedTemporaryRelease, this.mIsBoyFilterPrivateRes);
                    gLImage4.loadTextureSync(str);
                    mFrameImages.put(str, gLImage4);
                    this.mCurrentTexture = gLImage4.getTexture();
                }
            } else {
                this.mCurrentTexture = gLImage3.getTexture();
            }
        }
        DanceLog.printFrameQueue("GLFrameImage", "setCurrentImage");
    }

    public void setFrameDuration(float f16) {
        this.mFrameDuration = f16;
    }

    public void setLoadTextureMode(int i3) {
        this.mLoadTextureMode = i3;
    }

    public void setTemporaryRelease(boolean z16) {
        this.mNeedTemporaryRelease = z16;
    }

    public void startFrameAnimation() {
        if (!this.mHasAnimationStarted) {
            this.mStartMsTime = SystemClock.uptimeMillis();
            this.mCurrentFrameIndex = 0;
            this.mHasAnimationStarted = true;
        }
    }
}
