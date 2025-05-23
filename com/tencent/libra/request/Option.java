package com.tencent.libra.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.file.FileType;
import com.tencent.biz.richframework.util.RFWStringBuilderUtils;
import com.tencent.libra.base.model.Model;
import com.tencent.libra.cache.EngineResource;
import com.tencent.libra.cache.Key;
import com.tencent.libra.cache.Resource;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.util.LibraConfigUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.haoliyou.JefsClass;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Option implements Request {
    public static final int DEF_NONE_ID_VALUE = -1;
    public static final int LOAD_FROM_CACHE = 0;
    public static final int LOAD_FROM_LOCAL_SMALL_BITMAP = 3;
    public static final int LOAD_FROM_NET = 2;
    public static final int LOAD_FROM_SDCARD = 1;
    private static final int MAX_RECYCLED = 20;
    public static final int MAX_RETRY_COUNT = 3;
    public static final int NORMAL_DECODE = 0;
    public static final int PIC_TYPE_AVATAR = 3;
    public static final int PIC_TYPE_DEFAULT = 0;
    public static final int PIC_TYPE_JPG = 4;
    public static final int PIC_TYPE_NINE_PATCH = 2;
    public static final int PIC_TYPE_PNG = 5;
    public static final int PIC_TYPE_SHARE_P = 1;
    public static final int PIC_TYPE_WEBP = 6;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_PRELOAD = 1;
    public static final int REGION_DECODE = 1;
    public static final AtomicInteger sNextSeq = new AtomicInteger(10000);
    private static final Object sRecyclerLock = new Object();
    private static Option sRecyclerTop;
    private static int sRecyclerUsed;

    @Deprecated
    private Animatable mAnimatable;
    private LibraRequestKey mCacheKey;
    public Long mDecodeStartTime;
    public Long mDownLoadStartTime;
    private Boolean mEnablePicLoaderClearLogic;
    private Boolean mEnablePicLoaderDrawableCache;
    private int mErrorCode;
    private Map<String, Object> mExtraData;
    private Drawable mFailedDrawable;
    private int mFailedDrawableColor;
    private FileType mFileType;
    private LibraGroupKey mGroupKey;
    private WeakReference<LifecycleOwner> mHostLifecycleOwner;
    private int mInDensity;
    private boolean mIsFromPreLoad;
    private boolean mIsNinePatch;
    private Drawable mLoadingDrawable;
    private int mLoadingDrawableColor;
    private String mLocalPath;
    private Model<?> mModel;
    protected Option mNextRecycledOption;
    protected Option mParentOption;
    private Key mPathKey;
    private int mPicType;
    private List<Class<? extends r01.a<?>>> mPreferDecoder;
    protected boolean mRecycled;
    private int mRegionHeight;
    private int mRegionWidth;
    private int mRequestHeight;
    private int mRequestLeft;
    private int mRequestTop;
    private int mRequestWidth;
    private Resource<?> mResource;

    @Deprecated
    private Bitmap mResultBitMap;
    private int mRetryCount;
    public Long mStartTime;

    @GuardedBy("mRequestLock")
    private Status mStatus;
    private WeakReference<ImageView> mTargetView;
    protected Option mThumbnailOption;
    private String mTmpFilePath;
    private String mUrl;
    private final Object mRequestLock = new Object();
    public int mLoadType = 2;
    private boolean mIsPreDecode = true;
    private boolean mEnableAutoDeleteLocalCache = true;
    private int mPriority = 0;
    private boolean mNeedFilterUrl = true;
    private int mDecodeMode = 0;
    private ImageView.ScaleType mRegionScaleType = null;
    private DecodeFormat mDecodeFormat = DecodeFormat.DEFAULT;
    private boolean mAllowHardwareDecode = true;
    private boolean mEnableRotate = true;
    private int mRotationDegree = 0;
    private int mLoadingDrawableId = -1;
    private int mFailedDrawableId = -1;
    private int mSizeZoomMultiple = 1;
    private SizeFormat mSizeFormat = SizeFormat.GE;
    private boolean mIsSupportRecycler = false;
    private boolean mSupportReuseOption = false;
    private boolean mNeedShowLoadingDrawable = true;
    private boolean mNeedShowFailedDrawable = false;
    private int mSeq = sNextSeq.getAndIncrement();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    @Deprecated
    public Option() {
        resetLoadingAndFailedRes();
        resetDecodeParams();
    }

    public static Option getDefaultOptions(ImageView imageView) {
        Option obtain = obtain();
        obtain.mLoadingDrawable = RFWApplication.getApplication().getResources().getDrawable(R.drawable.f160904jv2);
        obtain.mFailedDrawable = RFWApplication.getApplication().getResources().getDrawable(R.drawable.ojc);
        if (imageView != null && imageView.getLayoutParams() != null) {
            obtain.mRequestWidth = imageView.getLayoutParams().width;
            obtain.mRequestHeight = imageView.getLayoutParams().height;
        }
        return obtain;
    }

    public static String getUrlHost(String str) {
        try {
            return Uri.parse(str).getHost();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static Option obtain() {
        synchronized (sRecyclerLock) {
            Option option = sRecyclerTop;
            if (option == null) {
                return new Option();
            }
            sRecyclerTop = option.mNextRecycledOption;
            sRecyclerUsed--;
            option.mNextRecycledOption = null;
            option.prepareForReuse();
            return option;
        }
    }

    public static Option obtainDownloadOption() {
        Option obtain = obtain();
        obtain.setPredecode(false);
        return obtain;
    }

    private void reset() {
        this.mUrl = null;
        this.mTmpFilePath = null;
        this.mLocalPath = null;
        this.mCacheKey = null;
        this.mTargetView = null;
        this.mResultBitMap = null;
        this.mAnimatable = null;
        this.mStartTime = null;
        this.mDownLoadStartTime = null;
        this.mDecodeStartTime = null;
        this.mIsFromPreLoad = false;
        this.mNeedFilterUrl = true;
        this.mPriority = 0;
        this.mEnableAutoDeleteLocalCache = true;
        this.mExtraData = null;
        this.mEnablePicLoaderClearLogic = null;
        this.mEnablePicLoaderDrawableCache = null;
        this.mHostLifecycleOwner = null;
        resetDecodeParams();
        resetLoadingAndFailedRes();
    }

    private void resetLoadingAndFailedRes() {
        this.mLoadingDrawableId = -1;
        this.mFailedDrawableId = -1;
        this.mLoadingDrawableColor = -1;
        this.mFailedDrawableColor = -1;
        this.mLoadingDrawable = null;
        this.mFailedDrawable = null;
    }

    @Override // com.tencent.libra.request.Request
    public /* synthetic */ void begin() {
        d.a(this);
    }

    @Override // com.tencent.libra.request.Request
    public void clear() {
        synchronized (this.mRequestLock) {
            Status status = this.mStatus;
            Status status2 = Status.CLEARED;
            if (status == status2) {
                return;
            }
            setTargetView(null);
            setLifecycleOwner(null);
            Resource<?> resource = this.mResource;
            if (resource != null) {
                this.mResource = null;
            } else {
                resource = null;
            }
            Animatable animatable = this.mAnimatable;
            if (animatable != null) {
                animatable.stop();
                this.mAnimatable = null;
            }
            this.mStatus = status2;
            if (resource instanceof EngineResource) {
                ((EngineResource) resource).release();
            }
        }
    }

    public boolean continueRetry() {
        if (this.mRetryCount < 3) {
            return true;
        }
        return false;
    }

    public Option disableHardwareDecode() {
        this.mAllowHardwareDecode = false;
        return this;
    }

    public Option disableRotate() {
        this.mEnableRotate = false;
        return this;
    }

    public boolean enableAutoDeleteLocalCache() {
        return this.mEnableAutoDeleteLocalCache;
    }

    public Animatable getAnimatable() {
        return this.mAnimatable;
    }

    public LibraRequestKey getCacheKey() {
        return this.mCacheKey;
    }

    public DecodeFormat getDecodeFormat() {
        return this.mDecodeFormat;
    }

    public int getDecodeMode() {
        return this.mDecodeMode;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    @NonNull
    public synchronized Map<String, Object> getExtraData() {
        if (this.mExtraData == null) {
            this.mExtraData = new ConcurrentHashMap();
        }
        return this.mExtraData;
    }

    public Drawable getFailedDrawable() {
        return this.mFailedDrawable;
    }

    public int getFailedDrawableColor() {
        return this.mFailedDrawableColor;
    }

    public int getFailedDrawableId() {
        return this.mFailedDrawableId;
    }

    public FileType getFileType() {
        return this.mFileType;
    }

    public LibraGroupKey getGroupKey() {
        return this.mGroupKey;
    }

    public int getInDensity() {
        return this.mInDensity;
    }

    public LifecycleOwner getLifecycleOwner() {
        WeakReference<LifecycleOwner> weakReference = this.mHostLifecycleOwner;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Drawable getLoadingDrawable() {
        return this.mLoadingDrawable;
    }

    public int getLoadingDrawableColor() {
        return this.mLoadingDrawableColor;
    }

    public int getLoadingDrawableId() {
        return this.mLoadingDrawableId;
    }

    public String getLocalPath() {
        return this.mLocalPath;
    }

    public Model<?> getModel() {
        return this.mModel;
    }

    public Option getParentOption() {
        return this.mParentOption;
    }

    public Key getPathKey() {
        return this.mPathKey;
    }

    public int getPicType() {
        return this.mPicType;
    }

    public final List<Class<? extends r01.a<?>>> getPreferDecoder() {
        return this.mPreferDecoder;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getRegionHeight() {
        return this.mRegionHeight;
    }

    public ImageView.ScaleType getRegionScaleType() {
        return this.mRegionScaleType;
    }

    public int getRegionWidth() {
        return this.mRegionWidth;
    }

    public int getRequestHeight() {
        return this.mRequestHeight;
    }

    public int getRequestLeft() {
        return this.mRequestLeft;
    }

    public int getRequestTop() {
        return this.mRequestTop;
    }

    public int getRequestWidth() {
        return this.mRequestWidth;
    }

    public Resource<?> getResource() {
        return this.mResource;
    }

    public Bitmap getResultBitMap() {
        return this.mResultBitMap;
    }

    public int getRetryCount() {
        return this.mRetryCount;
    }

    public int getRotationDegree() {
        return this.mRotationDegree;
    }

    public int getSeq() {
        return this.mSeq;
    }

    public SizeFormat getSizeFormat() {
        return this.mSizeFormat;
    }

    public int getSizeZoomMultiple() {
        return this.mSizeZoomMultiple;
    }

    public ImageView getTargetView() {
        WeakReference<ImageView> weakReference = this.mTargetView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Option getThumbnailOption() {
        return this.mThumbnailOption;
    }

    public String getTmpFilePath() {
        return this.mTmpFilePath;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isAllowHardwareDecode() {
        ImageView targetView = getTargetView();
        if (targetView != null) {
            if (this.mAllowHardwareDecode && targetView.getLayerType() != 1) {
                return true;
            }
            return false;
        }
        return this.mAllowHardwareDecode;
    }

    public boolean isAllowRotate() {
        return this.mEnableRotate;
    }

    @Override // com.tencent.libra.request.Request
    public /* synthetic */ boolean isAnyResourceSet() {
        return d.b(this);
    }

    @Override // com.tencent.libra.request.Request
    public boolean isCleared() {
        if (this.mStatus == Status.CLEARED) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.libra.request.Request
    public /* synthetic */ boolean isComplete() {
        return d.c(this);
    }

    public boolean isEnablePicLoaderClearLogic() {
        if (this.mEnablePicLoaderClearLogic == null) {
            this.mEnablePicLoaderClearLogic = Boolean.valueOf(LibraConfigUtil.INSTANCE.enablePicLoaderClearLogic());
        }
        return this.mEnablePicLoaderClearLogic.booleanValue();
    }

    public boolean isEnablePicLoaderDrawableCache() {
        if (this.mEnablePicLoaderDrawableCache == null) {
            this.mEnablePicLoaderDrawableCache = Boolean.valueOf(LibraConfigUtil.INSTANCE.enablePicLoaderDrawableCache());
        }
        return this.mEnablePicLoaderDrawableCache.booleanValue();
    }

    @Override // com.tencent.libra.request.Request
    public /* synthetic */ boolean isEquivalentTo(Request request) {
        return d.d(this, request);
    }

    public boolean isExplicitSize() {
        if (this.mSizeFormat == SizeFormat.OVERRIDE) {
            return true;
        }
        return false;
    }

    public boolean isFromPreload() {
        return this.mIsFromPreLoad;
    }

    public boolean isNeedShowFailedDrawable() {
        return this.mNeedShowFailedDrawable;
    }

    public boolean isNinePatch() {
        return this.mIsNinePatch;
    }

    public boolean isPreDecode() {
        return this.mIsPreDecode;
    }

    @Override // com.tencent.libra.request.Request
    public /* synthetic */ boolean isRunning() {
        return d.e(this);
    }

    public boolean isSupportRecycler() {
        return this.mIsSupportRecycler;
    }

    public boolean isSupportReuse() {
        if (!this.mIsSupportRecycler && this.mSupportReuseOption) {
            return true;
        }
        return false;
    }

    public boolean needFilterUrl() {
        return this.mNeedFilterUrl;
    }

    public boolean needShowLoadingDrawable() {
        return this.mNeedShowLoadingDrawable;
    }

    @Override // com.tencent.libra.request.Request
    public /* synthetic */ void pause() {
        d.f(this);
    }

    protected synchronized void prepareForReuse() {
        reset();
        this.mRecycled = false;
        this.mSeq = sNextSeq.getAndIncrement();
    }

    public void recycle() {
        if (!isSupportReuse() || this.mRecycled) {
            return;
        }
        this.mRecycled = true;
        synchronized (sRecyclerLock) {
            int i3 = sRecyclerUsed;
            if (i3 < 20) {
                sRecyclerUsed = i3 + 1;
                this.mNextRecycledOption = sRecyclerTop;
                sRecyclerTop = this;
            }
        }
    }

    public void releaseResource() {
        Resource<?> resource = this.mResource;
        if (resource instanceof EngineResource) {
            ((EngineResource) resource).release();
        }
        this.mResource = null;
        this.mResultBitMap = null;
        this.mAnimatable = null;
    }

    protected void resetDecodeParams() {
        this.mDecodeFormat = DecodeFormat.DEFAULT;
        this.mInDensity = 0;
        this.mIsNinePatch = false;
        this.mDecodeMode = 0;
        this.mSizeZoomMultiple = 0;
        this.mRequestHeight = 0;
        this.mRequestWidth = 0;
        this.mRegionWidth = 0;
        this.mRegionHeight = 0;
        this.mRequestTop = 0;
        this.mRequestLeft = 0;
    }

    public Option setAnimatable(Animatable animatable) {
        this.mAnimatable = animatable;
        return this;
    }

    public Option setCacheKey(LibraRequestKey libraRequestKey) {
        this.mCacheKey = libraRequestKey;
        return this;
    }

    public Option setDecodeMode(int i3) {
        this.mDecodeMode = i3;
        return this;
    }

    public Option setEnableAutoDeleteLocalCache(boolean z16) {
        this.mEnableAutoDeleteLocalCache = z16;
        return this;
    }

    public Option setErrorCode(int i3) {
        this.mErrorCode = i3;
        return this;
    }

    public Option setExtraData(Map<String, Object> map) {
        if (map != null) {
            getExtraData().putAll(map);
        }
        return this;
    }

    public Option setFailDrawable(Drawable drawable) {
        this.mFailedDrawable = drawable;
        return this;
    }

    public void setFailedDrawable(Drawable drawable) {
        this.mFailedDrawable = drawable;
    }

    public Option setFailedDrawableColor(@ColorInt int i3) {
        this.mFailedDrawableColor = i3;
        return this;
    }

    public Option setFailedDrawableId(int i3) {
        this.mFailedDrawableId = i3;
        return this;
    }

    public Option setFileType(FileType fileType) {
        this.mFileType = fileType;
        return this;
    }

    public Option setFromPreLoad(boolean z16) {
        this.mIsFromPreLoad = z16;
        return this;
    }

    public Option setGroupKey(LibraGroupKey libraGroupKey) {
        this.mGroupKey = libraGroupKey;
        return this;
    }

    public Option setInDensity(int i3) {
        this.mInDensity = i3;
        return this;
    }

    public Option setIsNinePatch(boolean z16) {
        this.mIsNinePatch = z16;
        return this;
    }

    public Option setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            this.mHostLifecycleOwner = new WeakReference<>(lifecycleOwner);
        } else {
            this.mHostLifecycleOwner = null;
        }
        return this;
    }

    public Option setLoadingDrawable(Drawable drawable) {
        this.mLoadingDrawable = drawable;
        return this;
    }

    public Option setLoadingDrawableColor(@ColorInt int i3) {
        this.mLoadingDrawableColor = i3;
        return this;
    }

    public Option setLoadingDrawableId(int i3) {
        this.mLoadingDrawableId = i3;
        return this;
    }

    public Option setLocalPath(String str) {
        this.mLocalPath = str;
        return this;
    }

    public Option setModel(Model<?> model) {
        this.mModel = model;
        return this;
    }

    public Option setNeedFilterUrl(boolean z16) {
        this.mNeedFilterUrl = z16;
        return this;
    }

    public Option setNeedShowFailedDrawable(boolean z16) {
        this.mNeedShowFailedDrawable = z16;
        return this;
    }

    public Option setNeedShowLoadingDrawable(boolean z16) {
        this.mNeedShowLoadingDrawable = z16;
        return this;
    }

    public Option setPathKey(Key key) {
        this.mPathKey = key;
        return this;
    }

    public Option setPicType(int i3) {
        this.mPicType = i3;
        return this;
    }

    public Option setPredecode(boolean z16) {
        this.mIsPreDecode = z16;
        return this;
    }

    public Option setPreferDecodeFormat(DecodeFormat decodeFormat) {
        this.mDecodeFormat = decodeFormat;
        return this;
    }

    @SafeVarargs
    public final <T extends r01.a<?>> Option setPreferDecoder(@NonNull Class<T>... clsArr) {
        ArrayList arrayList = new ArrayList();
        this.mPreferDecoder = arrayList;
        arrayList.addAll(Arrays.asList(clsArr));
        return this;
    }

    public Option setPriority(int i3) {
        this.mPriority = i3;
        return this;
    }

    public Option setRegionHeight(int i3) {
        this.mRegionHeight = i3;
        return this;
    }

    public Option setRegionScaleType(ImageView.ScaleType scaleType) {
        this.mRegionScaleType = scaleType;
        return this;
    }

    public Option setRegionWidth(int i3) {
        this.mRegionWidth = i3;
        return this;
    }

    public Option setRequestHeight(int i3) {
        this.mRequestHeight = i3;
        return this;
    }

    public Option setRequestLeft(int i3) {
        this.mRequestLeft = i3;
        return this;
    }

    public Option setRequestTop(int i3) {
        this.mRequestTop = i3;
        return this;
    }

    public Option setRequestWidth(int i3) {
        this.mRequestWidth = i3;
        return this;
    }

    public void setResource(Resource<?> resource) {
        this.mResource = resource;
    }

    @Deprecated
    public Option setResultBitMap(Bitmap bitmap) {
        this.mResultBitMap = bitmap;
        return this;
    }

    public Option setReuseOption(boolean z16) {
        this.mSupportReuseOption = z16;
        return this;
    }

    public Option setRotationDegree(int i3) {
        this.mRotationDegree = i3;
        return this;
    }

    public Option setSizeFormat(SizeFormat sizeFormat) {
        this.mSizeFormat = sizeFormat;
        return this;
    }

    public void setSizeZoomMultiple(int i3) {
        this.mSizeZoomMultiple = i3;
    }

    public Option setSupportRecycler(boolean z16) {
        this.mIsSupportRecycler = z16;
        return this;
    }

    public Option setTargetView(ImageView imageView) {
        if (imageView != null) {
            this.mTargetView = new WeakReference<>(imageView);
        } else {
            this.mTargetView = null;
        }
        return this;
    }

    public Option setThumbnailOption(Option option) {
        this.mThumbnailOption = option;
        option.mParentOption = this;
        return this;
    }

    public Option setTmpFilePath(String str) {
        this.mTmpFilePath = str;
        return this;
    }

    public Option setUrl(String str) {
        this.mUrl = str;
        return this;
    }

    public String toString() {
        StringBuilder obtain = RFWStringBuilderUtils.obtain();
        obtain.append("Option{seq=");
        obtain.append(this.mSeq);
        ImageView targetView = getTargetView();
        if (targetView != null) {
            obtain.append(",view=");
            obtain.append(targetView.getClass().getName());
            obtain.append(",viewHash=");
            obtain.append(targetView.hashCode());
        } else {
            obtain.append(",view=null");
        }
        obtain.append(JefsClass.INDEX_URL);
        obtain.append(this.mUrl);
        obtain.append(",model=");
        obtain.append(this.mModel);
        obtain.append(",requestWidth=");
        obtain.append(this.mRequestWidth);
        obtain.append(",requestHeight=");
        obtain.append(this.mRequestHeight);
        obtain.append(",loadType=");
        obtain.append(this.mLoadType);
        obtain.append(",decodeFormat=");
        obtain.append(this.mDecodeFormat);
        obtain.append(",cacheKey=");
        obtain.append(this.mCacheKey);
        obtain.append("}");
        return obtain.toString();
    }

    public Option updateRetryCount() {
        this.mRetryCount++;
        return this;
    }
}
