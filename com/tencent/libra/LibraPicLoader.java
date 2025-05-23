package com.tencent.libra;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.richframework.collection.RFWComparableWeakRef;
import com.tencent.biz.richframework.compat.RFWNinePatchUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWAppUtil;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.RFWStringBuilderUtils;
import com.tencent.biz.richframework.util.RFWUrlUtils;
import com.tencent.libra.base.bitmap.NativeBitmapHelper;
import com.tencent.libra.base.model.Model;
import com.tencent.libra.cache.BitmapPool;
import com.tencent.libra.cache.EngineResource;
import com.tencent.libra.cache.Key;
import com.tencent.libra.cache.LibraModelKey;
import com.tencent.libra.cache.Resource;
import com.tencent.libra.decode.LibraBaseDecodeTask;
import com.tencent.libra.decode.LibraPicDecodeTaskFactory;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.ILibraDownloader;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.download.LibraPicDownLoadTask;
import com.tencent.libra.download.RFWPicDownLoader;
import com.tencent.libra.drawable.LibraBitmapDrawable;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.LibraRequestContext;
import com.tencent.libra.request.LifecycleRequestManagerRetriever;
import com.tencent.libra.request.Option;
import com.tencent.libra.request.RequestManager;
import com.tencent.libra.request.SingleRequest;
import com.tencent.libra.request.size.SizeDeterminer;
import com.tencent.libra.request.size.SizeReadyCallback;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.strategy.ILibraBaseStrategy;
import com.tencent.libra.strategy.ILibraLibraryStrategy;
import com.tencent.libra.strategy.LibraMergeStrategy;
import com.tencent.libra.thread.LibraThreadExecutor;
import com.tencent.libra.trace.LibraTraceUtil;
import com.tencent.libra.util.LibraImageUtil;
import com.tencent.libra.util.LibraLogUtil;
import com.tencent.libra.util.RFWSpUtil;
import com.tencent.mobileqq.R;
import com.tencent.oskplayer.cache.FileDataSink;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class LibraPicLoader implements IPicLoader {
    private static final int DEFAULT_CACHE_TIME = 259200000;
    public static final String PIC_LOCAL_PATH_END_SUFFIX = "suf";
    public static final String TAG = "LibraPicLoader";
    public static Drawable sDefaultFailedDrawable;
    public static Drawable sDefaultLoadingDrawable;
    private final String mBusinessName;
    private final LibraCacheManager mCacheManager;
    private final Map<LibraRequestKey, Set<LibraRequestContext>> mDecodeListeners;
    private final Map<LibraRequestKey, LibraBaseDecodeTask> mDecodeTasks;
    private final RFWPicDownLoader mDefaultDownLoader;
    private final Map<Key, Set<LibraRequestContext>> mDownloadListeners;
    private final String mDownloadRootPath;
    private final Map<Key, LibraPicDownLoadTask> mDownloadTasks;

    @NonNull
    private final List<r01.a<?>> mExtraDecoders;
    private final List<ILibraDownloader> mExtraDownloaders;
    private ILoaderResultListener mGlobalLoaderResultListener;

    @NonNull
    private final ILibraBaseStrategy mLibraBaseStrategy;
    private final List<SizeDeterminer> mPendingSizeDeterminerList = new ArrayList();
    private final IResourceDrawableFactory mResourceDrawableFactory;
    private final Handler mUIHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class SizeReadyCallbackWrapper implements SizeReadyCallback {
        private final WeakReference<LibraPicLoader> mLibraPicLoaderRef;
        private final WeakReference<IPicLoadStateListener> mListener;
        private final WeakReference<Option> mOption;
        private final WeakReference<SizeDeterminer> mSizeDeterminer;

        public SizeReadyCallbackWrapper(LibraPicLoader libraPicLoader, SizeDeterminer sizeDeterminer, Option option, IPicLoadStateListener iPicLoadStateListener) {
            this.mLibraPicLoaderRef = new WeakReference<>(libraPicLoader);
            this.mSizeDeterminer = new WeakReference<>(sizeDeterminer);
            this.mOption = new WeakReference<>(option);
            this.mListener = new WeakReference<>(iPicLoadStateListener);
        }

        @Override // com.tencent.libra.request.size.SizeReadyCallback
        public void onSizeReady(int i3, int i16) {
            LibraPicLoader libraPicLoader = this.mLibraPicLoaderRef.get();
            Option option = this.mOption.get();
            if (libraPicLoader != null && option != null) {
                libraPicLoader.mPendingSizeDeterminerList.remove(this.mSizeDeterminer.get());
                libraPicLoader.handleOnGetViewSize(i3, i16, option, this.mListener.get());
            } else {
                RFWLog.d("LibraPicLoader", RFWLog.USR, "[onSizeReady] mLibraPicLoaderRef=", libraPicLoader, ", mOption=", option);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class b implements IPicLoadStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Option f118578d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IPicLoadStateListener f118579e;

        b(Option option, IPicLoadStateListener iPicLoadStateListener) {
            this.f118578d = option;
            this.f118579e = iPicLoadStateListener;
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState.isFinish()) {
                this.f118578d.setNeedShowFailedDrawable(false);
                this.f118578d.setNeedShowLoadingDrawable(false);
                LibraPicLoader.this.startLoadInner(this.f118578d, this.f118579e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LibraPicLoader(ILibraLibraryStrategy iLibraLibraryStrategy) {
        LibraMergeStrategy libraMergeStrategy = new LibraMergeStrategy(iLibraLibraryStrategy, LibraPicLoaderFactory.getGlobalPicLoadStrategy());
        this.mResourceDrawableFactory = libraMergeStrategy.getDrawableFactory();
        String businessName = iLibraLibraryStrategy.getBusinessName();
        this.mBusinessName = businessName;
        this.mDownloadTasks = new ConcurrentHashMap();
        this.mDownloadListeners = new ConcurrentHashMap();
        this.mDecodeTasks = new ConcurrentHashMap();
        this.mDecodeListeners = new ConcurrentHashMap();
        this.mExtraDecoders = libraMergeStrategy.getCustomDecoder();
        this.mUIHandler = new Handler(Looper.getMainLooper());
        LibraThreadExecutor.g().setTaskExecutorAndLooper(libraMergeStrategy.getTaskExecutor());
        this.mCacheManager = new LibraCacheManager(libraMergeStrategy.getCustomCache(), libraMergeStrategy.isSupportActiveResources().booleanValue());
        setGlobalLoaderResultListener(libraMergeStrategy.getGlobalResultListener());
        this.mExtraDownloaders = iLibraLibraryStrategy.getCustomDownloaders();
        this.mLibraBaseStrategy = libraMergeStrategy;
        this.mDownloadRootPath = generateDownloadRootPath(businessName);
        this.mDefaultDownLoader = new RFWPicDownLoader(iLibraLibraryStrategy);
        doAfterInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bindRequestOptionWithView(Option option, IPicLoadStateListener iPicLoadStateListener) {
        View targetView = option.getTargetView();
        LifecycleOwner lifecycleOwner = option.getLifecycleOwner();
        if (lifecycleOwner != null) {
            LifecycleRequestManagerRetriever.g().getOrCreate(lifecycleOwner.getLifecycle()).track(new SingleRequest(option, new WeakReference(iPicLoadStateListener), this));
            return true;
        }
        if (targetView == null) {
            return true;
        }
        try {
            targetView.setTag(R.id.yhv, iPicLoadStateListener);
            Object tag = targetView.getTag(R.id.yhw);
            if (tag instanceof SingleRequest) {
                SingleRequest singleRequest = (SingleRequest) tag;
                if (Objects.equals(singleRequest.getOption(), option)) {
                    return true;
                }
                RequestManager hostRequestManager = singleRequest.getHostRequestManager();
                if (hostRequestManager != null) {
                    hostRequestManager.unTrack(singleRequest);
                } else {
                    singleRequest.clear();
                }
            }
            SingleRequest singleRequest2 = new SingleRequest(option, new WeakReference(iPicLoadStateListener), this);
            RequestManager orCreate = LifecycleRequestManagerRetriever.g().getOrCreate(targetView);
            if (orCreate != null) {
                singleRequest2.setRequestManagerWrf(new RFWComparableWeakRef(orCreate));
                LibraLogUtil.INSTANCE.i("LibraPicLoader", RFWLog.USR, singleRequest2.getOption(), "track:", Integer.valueOf(orCreate.hashCode()));
                orCreate.track(singleRequest2);
            }
            targetView.setTag(R.id.yhw, singleRequest2);
            if (!targetView.isAttachedToWindow()) {
                tryRebindRequestManager(targetView);
            }
            return true;
        } catch (IndexOutOfBoundsException e16) {
            RFWLog.fatal("LibraPicLoader", RFWLog.USR, e16);
            return false;
        }
    }

    private Drawable bitmapTransferDrawable(Bitmap bitmap) {
        if (bitmap == null) {
            return new BitmapDrawable(RFWApplication.getApplication().getResources());
        }
        if (NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk())) {
            return RFWNinePatchUtils.getNinePatchDrawable(bitmap);
        }
        return new LibraBitmapDrawable(RFWApplication.getApplication().getResources(), bitmap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void callBackByCache(@NonNull Option option, IPicLoadStateListener iPicLoadStateListener, EngineResource<?> engineResource, boolean z16) {
        option.setResource(engineResource);
        engineResource.acquire();
        com.tencent.libra.util.a.f118813a.v(option, engineResource.getExtraData());
        option.mLoadType = 0;
        Object obj = engineResource.get();
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            option.setResultBitMap(bitmap);
            showBitmap(option, bitmap, true);
        } else if (obj instanceof Drawable) {
            Drawable drawable = (Drawable) obj;
            if (drawable instanceof Animatable) {
                option.setAnimatable((Animatable) drawable);
            }
            showDrawable(option, drawable, true);
        }
        LibraLogUtil.INSTANCE.i("LibraPicLoader", RFWLog.USR, option, "[callBackByCache] isFinish=", Boolean.valueOf(z16));
        if (z16) {
            dispatchStateChange(iPicLoadStateListener, LoadState.STATE_SUCCESS, option);
        }
        recycleOption(option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canFillRequestWidthAndHeight(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || layoutParams.width == -2 || layoutParams.height == -2) {
            return false;
        }
        return true;
    }

    private void dispatchDecodeTask(Option option, IPicLoadStateListener iPicLoadStateListener) {
        if (!isTaskValid(option, "[dispatchDecodeTask]")) {
            return;
        }
        dispatchStateChange(iPicLoadStateListener, LoadState.STATE_DECODING, option);
        LibraRequestKey requestKey = getRequestKey(option);
        synchronized (getDecodeLock(requestKey)) {
            Set<LibraRequestContext> decodeRequestSet = getDecodeRequestSet(requestKey);
            LibraBaseDecodeTask libraBaseDecodeTask = this.mDecodeTasks.get(requestKey);
            option.mDecodeStartTime = Long.valueOf(System.currentTimeMillis());
            if (libraBaseDecodeTask == null) {
                try {
                    LibraBaseDecodeTask decodeTask = LibraPicDecodeTaskFactory.getDecodeTask(new LoadContext(option, this), requestKey, this.mExtraDecoders);
                    decodeRequestSet.add(new LibraRequestContext(option, iPicLoadStateListener));
                    this.mDecodeTasks.put(requestKey, decodeTask);
                    LibraThreadExecutor.g().execDecodeTask(decodeTask);
                } catch (Exception e16) {
                    LibraLogUtil.INSTANCE.e("LibraPicLoader", RFWLog.USR, option, "[dispatchDecodeTask] createDecodeTask error, file not found", e16);
                    dispatchStateChange(iPicLoadStateListener, LoadState.STATE_DECODE_FAILED, option);
                }
            } else {
                decodeRequestSet.add(new LibraRequestContext(option, iPicLoadStateListener));
                LibraLogUtil.INSTANCE.i("LibraPicLoader", RFWLog.USR, option, "[dispatchDecodeTask] preDecodeTask exist merge request seq:", Integer.valueOf(libraBaseDecodeTask.mOption.getSeq()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchDownloadSuccessState(IPicLoadStateListener iPicLoadStateListener, @NonNull Option option) {
        dispatchStateChange(iPicLoadStateListener, LoadState.STATE_DOWNLOAD_SUCCESS, option);
        if (option.getTargetView() != null || option.isPreDecode()) {
            decodeFile(option, iPicLoadStateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void dispatchDownloadTask(ILibraDownloader iLibraDownloader, @NonNull Option option, IPicLoadStateListener iPicLoadStateListener) {
        if (!isTaskValid(option, "[dispatchDownloadTask]")) {
            return;
        }
        dispatchStateChange(iPicLoadStateListener, LoadState.STATE_DOWNLOADING, option);
        option.setTmpFilePath(getTempFilePath(option));
        Key pathKey = getPathKey(option);
        synchronized (getDownloadLock(pathKey)) {
            getDownloadRequestSet(pathKey).add(new LibraRequestContext(option, iPicLoadStateListener));
            LibraPicDownLoadTask libraPicDownLoadTask = this.mDownloadTasks.get(pathKey);
            option.mDownLoadStartTime = Long.valueOf(System.currentTimeMillis());
            if (libraPicDownLoadTask == null) {
                LibraPicDownLoadTask libraPicDownLoadTask2 = new LibraPicDownLoadTask(new LoadContext(option, this), iLibraDownloader);
                this.mDownloadTasks.put(pathKey, libraPicDownLoadTask2);
                if (iLibraDownloader.needDownloadOnWorkThread()) {
                    LibraThreadExecutor.g().execDownloadTask(libraPicDownLoadTask2);
                } else {
                    libraPicDownLoadTask2.run();
                }
            } else {
                LibraLogUtil.INSTANCE.i("LibraPicLoader", RFWLog.USR, option, "[dispatchDownloadTask] exist merge request:", Integer.valueOf(libraPicDownLoadTask.mOption.getSeq()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchStateChange(final IPicLoadStateListener iPicLoadStateListener, final LoadState loadState, final Option option) {
        LibraTraceUtil.f118803a.a(this.mBusinessName, loadState, option);
        if (iPicLoadStateListener == null) {
            return;
        }
        runInMainThread(new Runnable() { // from class: com.tencent.libra.LibraPicLoader.9
            @Override // java.lang.Runnable
            public void run() {
                if (!LibraPicLoader.this.isTaskValid(option, "[dispatchStateChange]")) {
                    return;
                }
                iPicLoadStateListener.onStateChange(loadState, option);
            }
        });
    }

    private void doAfterInit() {
        LibraThreadExecutor.g().execDecodeTask(new Runnable() { // from class: com.tencent.libra.LibraPicLoader.1
            @Override // java.lang.Runnable
            public void run() {
                RFWFileUtils.createFileIfNotExits(LibraPicLoader.this.getDownloadRootPath() + ".nomedia");
                RFWFileUtils.createFileIfNotExits(LibraPicLoader.this.getDownloadTmpRootPath() + ".nomedia");
                NativeBitmapHelper.f118624b.d();
            }
        });
    }

    private void downloadInner(@NonNull final Option option, final IPicLoadStateListener iPicLoadStateListener) {
        LibraThreadExecutor.g().execDecodeTask(new Runnable() { // from class: com.tencent.libra.LibraPicLoader.8
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                if (LibraPicLoader.this.tryLoadLocalSmallBitmap(option)) {
                    LibraPicLoader.this.dispatchDownloadSuccessState(iPicLoadStateListener, option);
                    return;
                }
                String picLocalPath = LibraPicLoader.this.getPicLocalPath(option);
                Model<?> model = option.getModel();
                if ((model != null && !model.g()) || RFWFileUtils.fileExistsWithBlackCheck(picLocalPath)) {
                    Option option2 = option;
                    option2.mLoadType = 1;
                    LibraPicLoader.this.dispatchDownloadSuccessState(iPicLoadStateListener, option2);
                    return;
                }
                if (RFWFileUtils.isPrivateFilePath(picLocalPath) && RFWFileUtils.deleteFileIfBlank(picLocalPath)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    LibraLogUtil libraLogUtil = LibraLogUtil.INSTANCE;
                    int i3 = RFWLog.USR;
                    Option option3 = option;
                    libraLogUtil.i("LibraPicLoader", i3, option3, "[download] isBlankFile:", option3.getLocalPath());
                }
                ILibraDownloader targetDownloader = LibraPicLoader.this.getTargetDownloader(option);
                if (targetDownloader instanceof RFWPicDownLoader) {
                    if (RFWFileUtils.isLocalPath(option.getUrl())) {
                        LibraPicLoader.this.dispatchStateChange(iPicLoadStateListener, LoadState.STATE_URL_ILLEGAL, option);
                        return;
                    } else {
                        if (!RFWUrlUtils.isValidUrl(option.getUrl())) {
                            LibraPicLoader.this.dispatchStateChange(iPicLoadStateListener, LoadState.STATE_URL_ILLEGAL, option);
                            return;
                        }
                        Option option4 = option;
                        option4.mLoadType = 2;
                        LibraPicLoader.this.dispatchDownloadTask(targetDownloader, option4, iPicLoadStateListener);
                        return;
                    }
                }
                Option option5 = option;
                option5.mLoadType = 2;
                LibraPicLoader.this.dispatchDownloadTask(targetDownloader, option5, iPicLoadStateListener);
            }
        });
    }

    public static String encodeKey(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    private EngineResource<Bitmap> findFromGroupKeyMemoryCache(Option option) {
        EngineResource cacheFromGroupKey = this.mCacheManager.getCacheFromGroupKey(option);
        if (cacheFromGroupKey != null && (cacheFromGroupKey.get() instanceof Bitmap) && !((Bitmap) cacheFromGroupKey.get()).isRecycled()) {
            return cacheFromGroupKey;
        }
        return null;
    }

    private EngineResource<?> findFromMemoryCache(Option option) {
        EngineResource<?> cache = this.mCacheManager.getCache(getRequestKey(option));
        if (cache != null) {
            Class<?> resourceClass = cache.getResourceClass();
            if (Bitmap.class.isAssignableFrom(resourceClass) && !((Bitmap) cache.get()).isRecycled()) {
                return cache;
            }
            if (Drawable.class.isAssignableFrom(resourceClass)) {
                return cache;
            }
            return null;
        }
        return null;
    }

    private String generateDownloadRootPath(String str) {
        StringBuilder sb5 = new StringBuilder();
        File privateFilePath = LibraPicLoaderFactory.getPrivateFilePath();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(str);
        String str2 = File.separator;
        sb6.append(str2);
        sb6.append("download");
        sb5.append(new File(privateFilePath, sb6.toString()).getAbsolutePath());
        sb5.append(str2);
        return sb5.toString();
    }

    private Object getDecodeLock(LibraRequestKey libraRequestKey) {
        return String.valueOf(libraRequestKey.hashCode()).intern();
    }

    private Set<LibraRequestContext> getDecodeRequestSet(LibraRequestKey libraRequestKey) {
        Set<LibraRequestContext> set = this.mDecodeListeners.get(libraRequestKey);
        if (set == null) {
            HashSet hashSet = new HashSet();
            this.mDecodeListeners.put(libraRequestKey, hashSet);
            return hashSet;
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object getDownloadLock(Key key) {
        return String.valueOf(key.hashCode()).intern();
    }

    private Set<LibraRequestContext> getDownloadRequestSet(Key key) {
        Set<LibraRequestContext> set = this.mDownloadListeners.get(key);
        if (set == null) {
            HashSet hashSet = new HashSet();
            this.mDownloadListeners.put(key, hashSet);
            return hashSet;
        }
        return set;
    }

    @NonNull
    private String getEncodeString(Option option) {
        String str;
        String url = option.getUrl();
        String str2 = "";
        if (TextUtils.isEmpty(url)) {
            return "";
        }
        if (option.needFilterUrl()) {
            str = this.mLibraBaseStrategy.getUniKeyFromUrl(url);
        } else {
            str = url;
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = encodeKey(str);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = encodeKey(url);
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        return url;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Key getPathKey(Option option) {
        return getRequestKey(option).getPathKey();
    }

    private Drawable getResourceColorToDrawable(@ColorInt int i3) {
        return new ColorDrawable(i3);
    }

    private Drawable getResourceIdToDrawable(@DrawableRes int i3) {
        Drawable drawable;
        IResourceDrawableFactory iResourceDrawableFactory = this.mResourceDrawableFactory;
        if (iResourceDrawableFactory != null && (drawable = iResourceDrawableFactory.getDrawable(i3)) != null) {
            return drawable;
        }
        try {
            return ResourcesCompat.getDrawable(RFWApplication.getApplication().getResources(), i3, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ILibraDownloader getTargetDownloader(Option option) {
        List<ILibraDownloader> list = this.mExtraDownloaders;
        if (list != null) {
            for (ILibraDownloader iLibraDownloader : list) {
                if (iLibraDownloader.canDownload(option)) {
                    return iLibraDownloader;
                }
            }
        }
        return this.mDefaultDownLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void handleGetViewSize(@NonNull Option option, IPicLoadStateListener iPicLoadStateListener) {
        SizeDeterminer sizeDeterminer = new SizeDeterminer(option.getTargetView());
        this.mPendingSizeDeterminerList.add(sizeDeterminer);
        sizeDeterminer.getSize(new SizeReadyCallbackWrapper(this, sizeDeterminer, option, iPicLoadStateListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void handleOnGetViewSize(int i3, int i16, @NonNull Option option, IPicLoadStateListener iPicLoadStateListener) {
        option.setRequestWidth(i3);
        option.setRequestHeight(i16);
        handleOption(option, iPicLoadStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void handleOption(final Option option, final IPicLoadStateListener iPicLoadStateListener) {
        EngineResource<?> findFromMemoryCache = findFromMemoryCache(option);
        if (findFromMemoryCache != null) {
            callBackByCache(option, iPicLoadStateListener, findFromMemoryCache, true);
            return;
        }
        EngineResource<?> findFromGroupKeyMemoryCache = findFromGroupKeyMemoryCache(option);
        if (findFromGroupKeyMemoryCache == null) {
            initThumbOption(option);
            if (option.getThumbnailOption() != null) {
                findFromGroupKeyMemoryCache = findFromMemoryCache(option.getThumbnailOption());
            }
        }
        if (findFromGroupKeyMemoryCache != null) {
            option.setNeedShowLoadingDrawable(false);
            option.setNeedShowFailedDrawable(false);
            callBackByCache(option, iPicLoadStateListener, findFromGroupKeyMemoryCache, false);
        }
        if (findFromGroupKeyMemoryCache == null && option.getThumbnailOption() != null) {
            LibraThreadExecutor.g().execDecodeTask(new Runnable() { // from class: com.tencent.libra.LibraPicLoader.6
                @Override // java.lang.Runnable
                public void run() {
                    if (RFWFileUtils.fileExists(option.getLocalPath()) || !RFWFileUtils.fileExists(option.getThumbnailOption().getLocalPath())) {
                        LibraPicLoader.this.startLoadInner(option, iPicLoadStateListener);
                    } else {
                        LibraPicLoader.this.loadThumbOption(option, iPicLoadStateListener);
                    }
                }
            });
        } else {
            startLoadInner(option, iPicLoadStateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initOption(Option option) {
        getPicLocalPath(option);
        if (RFWUrlUtils.isNinePatchUrl(option.getUrl())) {
            option.setIsNinePatch(true);
        }
        if (option.isNinePatch() && option.getInDensity() == 0) {
            option.setInDensity(160);
        }
        if (option.mStartTime == null) {
            option.mStartTime = Long.valueOf(System.currentTimeMillis());
        }
        if (option.getThumbnailOption() != null) {
            initOption(option.getThumbnailOption());
        }
    }

    private void initThumbOption(Option option) {
        if (option.getThumbnailOption() == null) {
            return;
        }
        Option thumbnailOption = option.getThumbnailOption();
        thumbnailOption.setTargetView(option.getTargetView());
        if (thumbnailOption.getRequestHeight() == 0 || thumbnailOption.getRequestWidth() == 0) {
            thumbnailOption.setRequestWidth(option.getRequestWidth());
            thumbnailOption.setRequestHeight(option.getRequestHeight());
        }
        thumbnailOption.setNeedShowFailedDrawable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelDownload$0(Option option) {
        LibraLogUtil.INSTANCE.i("LibraPicLoader", RFWLog.USR, option, "[cancel]");
        Key pathKey = getPathKey(option);
        synchronized (getDownloadLock(pathKey)) {
            Set<LibraRequestContext> set = this.mDownloadListeners.get(pathKey);
            if (set == null) {
                return;
            }
            Iterator<LibraRequestContext> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                LibraRequestContext next = it.next();
                if (next.getOption() == option) {
                    it.remove();
                    dispatchStateChange(next.getPicLoadStateListener(), LoadState.STATE_CANCEL, option);
                    break;
                }
            }
            if (set.isEmpty()) {
                this.mDownloadListeners.remove(pathKey);
                LibraPicDownLoadTask libraPicDownLoadTask = this.mDownloadTasks.get(pathKey);
                if (libraPicDownLoadTask != null) {
                    Option option2 = libraPicDownLoadTask.mOption;
                    getTargetDownloader(option2).cancel(option2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadThumbOption(Option option, IPicLoadStateListener iPicLoadStateListener) {
        startLoadInner(option.getThumbnailOption(), new b(option, iPicLoadStateListener));
    }

    private void recycleOption(final Option option) {
        runInMainThread(new Runnable() { // from class: com.tencent.libra.LibraPicLoader.10
            @Override // java.lang.Runnable
            public void run() {
                LibraRecyclerManager.getInstance().addToRecyclePool(option);
            }
        });
    }

    private void runInMainThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.mUIHandler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInMain(Option option, Drawable drawable, boolean z16) {
        boolean z17;
        if (option == null) {
            return;
        }
        Option parentOption = option.getParentOption();
        if (parentOption != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            parentOption = option;
        }
        if (isValid(parentOption)) {
            parentOption.getTargetView().setImageDrawable(drawable);
            LibraLogUtil.INSTANCE.i("LibraPicLoader", RFWLog.USR, option, "[showInMain] showThumb:", Boolean.valueOf(z17), ", cost=", Long.valueOf(System.currentTimeMillis() - parentOption.mStartTime.longValue()));
            if (z16) {
                onLoadResult(parentOption, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadInner(Option option, IPicLoadStateListener iPicLoadStateListener) {
        if (option.needShowLoadingDrawable()) {
            showDrawable(option, getLoadingDrawable(option), false);
        }
        downloadInner(option, iPicLoadStateListener);
    }

    private Bitmap transformBitmap(Option option, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getNinePatchChunk() == null && option.isNinePatch()) {
            return RFWNinePatchUtils.getCompiledNinePatchBitmap(bitmap, false);
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryLoadLocalSmallBitmap(Option option) {
        if (com.tencent.libra.util.a.f118813a.l(option)) {
            String localSmallBitmapPath = getLocalSmallBitmapPath(option, Math.min(option.getRequestWidth(), option.getRequestHeight()));
            if (RFWFileUtils.fileExistsWithBlackCheck(localSmallBitmapPath)) {
                option.mLoadType = 3;
                option.setLocalPath(localSmallBitmapPath);
                option.setModel(null);
                return true;
            }
            return false;
        }
        return false;
    }

    private void tryRebindRequestManager(View view) {
        view.addOnAttachStateChangeListener(new a(view));
    }

    private void trySaveSmallBitmap2Local(Bitmap bitmap, Option option) {
        if (bitmap != null && option.mLoadType != 3 && com.tencent.libra.util.a.f118813a.l(option)) {
            RFWSaveUtil.saveBitmapAsJpg(bitmap, getLocalSmallBitmapPath(option, Math.min(bitmap.getWidth(), bitmap.getHeight())));
        }
    }

    public void afterDecode(Option option, long j3, Object obj) {
        boolean z16;
        Object obj2 = obj;
        boolean z17 = obj2 instanceof BitmapDrawable;
        Object obj3 = obj2;
        if (z17) {
            obj3 = ((BitmapDrawable) obj2).getBitmap();
        }
        boolean z18 = obj3 instanceof Bitmap;
        Object obj4 = obj3;
        if (z18) {
            Bitmap transformBitmap = transformBitmap(option, (Bitmap) obj3);
            trySaveSmallBitmap2Local(transformBitmap, option);
            obj4 = transformBitmap;
        }
        LibraRequestKey requestKey = getRequestKey(option);
        EngineResource<?> addToCache = this.mCacheManager.addToCache(requestKey, option.getGroupKey(), obj4, option);
        synchronized (getDecodeLock(requestKey)) {
            Set<LibraRequestContext> decodeRequestSet = getDecodeRequestSet(requestKey);
            if (decodeRequestSet.size() == 0) {
                LibraLogUtil.INSTANCE.e("LibraPicLoader", RFWLog.USR, option, "[afterDecode] can't find any decodeListener");
            }
            for (LibraRequestContext libraRequestContext : decodeRequestSet) {
                Option option2 = libraRequestContext.getOption();
                IPicLoadStateListener picLoadStateListener = libraRequestContext.getPicLoadStateListener();
                LibraLogUtil.INSTANCE.i("LibraPicLoader", RFWLog.USR, option2, "[afterDecode] decode cost:", Long.valueOf(System.currentTimeMillis() - j3), " decode by ", getClass().getSimpleName());
                if (obj4 == null) {
                    dispatchStateChange(picLoadStateListener, LoadState.STATE_DECODE_FAILED, libraRequestContext.getOption());
                    onDecodeResult(option2, 1);
                    onLoadResult(option2, 1);
                    showDrawable(option2, getFailDrawable(option2), true);
                    z16 = true;
                } else {
                    com.tencent.libra.util.a.f118813a.v(option2, option.getExtraData());
                    Resource<?> resource = option2.getResource();
                    if (resource instanceof EngineResource) {
                        ((EngineResource) resource).release();
                    }
                    option2.setResource(addToCache);
                    if (addToCache != null) {
                        addToCache.acquire();
                    }
                    if (obj4 instanceof Bitmap) {
                        option2.setResultBitMap((Bitmap) obj4);
                        showBitmap(option2, (Bitmap) obj4, true);
                    } else if (obj4 instanceof Animatable) {
                        option2.setAnimatable((Animatable) obj4);
                        showDrawable(option2, (Drawable) obj4, true);
                    } else if (obj4 instanceof Drawable) {
                        z16 = true;
                        showDrawable(option2, (Drawable) obj4, true);
                        dispatchStateChange(picLoadStateListener, LoadState.STATE_SUCCESS, libraRequestContext.getOption());
                        onDecodeResult(option2, 0);
                    }
                    z16 = true;
                    dispatchStateChange(picLoadStateListener, LoadState.STATE_SUCCESS, libraRequestContext.getOption());
                    onDecodeResult(option2, 0);
                }
                recycleOption(option2);
            }
            decodeRequestSet.clear();
            this.mDecodeTasks.remove(requestKey);
            this.mDecodeListeners.remove(requestKey);
        }
    }

    public void afterDownload(Option option, long j3, boolean z16, int i3) {
        ILoaderResultListener iLoaderResultListener = this.mGlobalLoaderResultListener;
        if (iLoaderResultListener != null) {
            iLoaderResultListener.onDownloadResult(option, i3);
        }
        Key pathKey = getPathKey(option);
        synchronized (getDownloadLock(pathKey)) {
            Set<LibraRequestContext> downloadRequestSet = getDownloadRequestSet(pathKey);
            if (downloadRequestSet.size() == 0) {
                LibraLogUtil.INSTANCE.e("LibraPicLoader", RFWLog.USR, option, "[afterDownload] can't find any downloadListener");
            }
            for (LibraRequestContext libraRequestContext : downloadRequestSet) {
                Option option2 = libraRequestContext.getOption();
                option2.setLocalPath(option.getLocalPath());
                IPicLoadStateListener picLoadStateListener = libraRequestContext.getPicLoadStateListener();
                if (z16) {
                    dispatchDownloadSuccessState(picLoadStateListener, option2);
                } else {
                    option2.setErrorCode(i3);
                    showDrawable(option2, getFailDrawable(libraRequestContext.getOption()), false);
                    dispatchStateChange(picLoadStateListener, LoadState.STATE_DOWNLOAD_FAILED, option2);
                }
            }
            this.mDownloadTasks.remove(pathKey);
            this.mDownloadListeners.remove(pathKey);
            downloadRequestSet.clear();
        }
    }

    @Override // com.tencent.libra.IPicLoader
    public void cancelDownload(@NonNull final Option option) {
        LibraThreadExecutor.g().execDecodeTask(new Runnable() { // from class: com.tencent.libra.i
            @Override // java.lang.Runnable
            public final void run() {
                LibraPicLoader.this.lambda$cancelDownload$0(option);
            }
        });
    }

    public void decodeFile(@NonNull Option option, IPicLoadStateListener iPicLoadStateListener) {
        dispatchDecodeTask(option, iPicLoadStateListener);
    }

    @Override // com.tencent.libra.IPicLoader
    public void deleteSdCacheIfNeed() {
        LibraThreadExecutor.g().execDecodeTask(new Runnable() { // from class: com.tencent.libra.LibraPicLoader.11
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                String lastDeleteCacheTime = RFWSpUtil.getLastDeleteCacheTime(RFWApplication.getApplication());
                if (!TextUtils.isEmpty(lastDeleteCacheTime)) {
                    if (currentTimeMillis - Long.parseLong(lastDeleteCacheTime) >= 259200000) {
                        RFWFileUtils.deleteFile(LibraPicLoader.this.getDownloadRootPath());
                        RFWFileUtils.createFileIfNotExits(LibraPicLoader.this.getDownloadRootPath() + ".nomedia");
                        RFWFileUtils.createFileIfNotExits(LibraPicLoader.this.getBusinessDownloadRootPath() + ".nomedia");
                        RFWSpUtil.setDeleteCacheTime(RFWApplication.getApplication(), String.valueOf(currentTimeMillis));
                        return;
                    }
                    return;
                }
                RFWSpUtil.setDeleteCacheTime(RFWApplication.getApplication(), String.valueOf(currentTimeMillis));
            }
        });
    }

    public void dispatchCancelDecodeState(Option option) {
        LibraRequestKey requestKey = getRequestKey(option);
        synchronized (getDecodeLock(requestKey)) {
            Set<LibraRequestContext> remove = this.mDecodeListeners.remove(requestKey);
            if (remove == null) {
                return;
            }
            for (LibraRequestContext libraRequestContext : remove) {
                dispatchStateChange(libraRequestContext.getPicLoadStateListener(), LoadState.STATE_CANCEL, libraRequestContext.getOption());
            }
        }
    }

    @Override // com.tencent.libra.IPicLoader
    public void download(@NonNull Option option, IPicLoadStateListener iPicLoadStateListener) {
        option.setPredecode(false);
        downloadInner(option, iPicLoadStateListener);
    }

    @Nullable
    public BitmapPool getBitmapPool(Option option) {
        LibraCacheManager libraCacheManager;
        if (!com.tencent.libra.util.a.f118813a.c(option) || Build.VERSION.SDK_INT < 24 || (libraCacheManager = this.mCacheManager) == null) {
            return null;
        }
        return libraCacheManager.getBitmapPool();
    }

    public String getBusinessDownloadRootPath() {
        return getBusinessDownloadRootPath(this.mBusinessName);
    }

    @Override // com.tencent.libra.IPicLoader
    public String getDownloadCommonRootPath() {
        return getDownloadCommonRootPath(this.mBusinessName);
    }

    @Override // com.tencent.libra.IPicLoader
    public String getDownloadRootPath() {
        return getDownloadRootPath(this.mBusinessName);
    }

    @Override // com.tencent.libra.IPicLoader
    public String getDownloadTmpRootPath() {
        return getBusinessDownloadRootPath() + "pic_tmp" + File.separator;
    }

    public Drawable getFailDrawable(Option option) {
        if (option == null || !option.isNeedShowFailedDrawable()) {
            return null;
        }
        Drawable failedDrawable = option.getFailedDrawable();
        if (failedDrawable != null) {
            return failedDrawable;
        }
        int failedDrawableId = option.getFailedDrawableId();
        int failedDrawableColor = option.getFailedDrawableColor();
        if (failedDrawableId != -1) {
            failedDrawable = getResourceIdToDrawable(failedDrawableId);
        } else if (failedDrawableColor != -1) {
            failedDrawable = getResourceColorToDrawable(failedDrawableColor);
        }
        if (failedDrawable == null) {
            if (sDefaultFailedDrawable == null) {
                sDefaultFailedDrawable = ResourcesCompat.getDrawable(RFWApplication.getApplication().getResources(), R.drawable.ojc, null);
            }
            return sDefaultFailedDrawable;
        }
        return failedDrawable;
    }

    public Drawable getLoadingDrawable(Option option) {
        if (option == null) {
            return null;
        }
        Drawable loadingDrawable = option.getLoadingDrawable();
        if (loadingDrawable != null) {
            return loadingDrawable;
        }
        int loadingDrawableId = option.getLoadingDrawableId();
        int loadingDrawableColor = option.getLoadingDrawableColor();
        if (loadingDrawableId != -1) {
            loadingDrawable = getResourceIdToDrawable(loadingDrawableId);
        } else if (loadingDrawableColor != -1) {
            loadingDrawable = getResourceColorToDrawable(loadingDrawableColor);
        }
        if (loadingDrawable == null) {
            if (sDefaultLoadingDrawable == null) {
                sDefaultLoadingDrawable = ResourcesCompat.getDrawable(RFWApplication.getApplication().getResources(), R.drawable.f160904jv2, null);
            }
            return sDefaultLoadingDrawable;
        }
        return loadingDrawable;
    }

    public String getLocalSmallBitmapPath(Option option, int i3) {
        String downloadCommonRootPath;
        String localPath = option.getLocalPath();
        String encodeKey = encodeKey(localPath);
        String fileExtension = LibraImageUtil.getFileExtension(localPath);
        if (option.enableAutoDeleteLocalCache()) {
            downloadCommonRootPath = getDownloadRootPath();
        } else {
            downloadCommonRootPath = getDownloadCommonRootPath();
        }
        return RFWStringBuilderUtils.getString(downloadCommonRootPath, RFWAppUtil.INSTANCE.getANDROID_ID(), File.separator, encodeKey, "_", Integer.valueOf(i3), fileExtension);
    }

    @Override // com.tencent.libra.IPicLoader
    public String getPicLocalPath(Option option) {
        String downloadCommonRootPath;
        String string;
        Model<?> model = option.getModel();
        if (model != null) {
            string = model.f();
        } else if (RFWFileUtils.isLocalPath(option.getUrl())) {
            string = option.getUrl();
        } else if (!TextUtils.isEmpty(option.getLocalPath())) {
            string = option.getLocalPath();
        } else {
            String encodeString = getEncodeString(option);
            String a16 = com.tencent.libra.util.a.f118813a.a(option);
            if (TextUtils.isEmpty(a16)) {
                a16 = this.mBusinessName;
            }
            if (option.enableAutoDeleteLocalCache()) {
                downloadCommonRootPath = getDownloadRootPath(a16);
            } else {
                downloadCommonRootPath = getDownloadCommonRootPath(a16);
            }
            String fileExtensionFromUrl = RFWFileUtils.getFileExtensionFromUrl(option.getUrl());
            if (TextUtils.isEmpty(fileExtensionFromUrl)) {
                fileExtensionFromUrl = PIC_LOCAL_PATH_END_SUFFIX;
            }
            string = RFWStringBuilderUtils.getString(downloadCommonRootPath, encodeString, ".", fileExtensionFromUrl);
        }
        option.setLocalPath(string);
        return string;
    }

    @Override // com.tencent.libra.IPicLoader
    @NonNull
    public LibraRequestKey getRequestKey(Option option) {
        if (option.getCacheKey() != null) {
            return option.getCacheKey();
        }
        Key pathKey = option.getPathKey();
        if (pathKey == null) {
            Model<?> model = option.getModel();
            if (model != null) {
                pathKey = new LibraModelKey(model);
            } else {
                pathKey = new LibraDownloadKey(option.getLocalPath());
            }
            option.setPathKey(pathKey);
        }
        LibraRequestKey build = new LibraRequestKey.Builder(pathKey).setExplicitSize(option.isExplicitSize()).setRequestWith(option.getRequestWidth()).setRequestHeight(option.getRequestHeight()).setRegionScaleType(option.getRegionScaleType()).setNinePatch(option.isNinePatch()).build();
        option.setCacheKey(build);
        return build;
    }

    public String getTempFilePath(Option option) {
        if (option == null) {
            return "";
        }
        return getDownloadTmpRootPath() + (encodeKey(option.getLocalPath()) + option.getSeq()) + FileDataSink.TEMP_FILE;
    }

    public void handleCancelDownload(final Option option, final IPicLoadStateListener iPicLoadStateListener) {
        LibraThreadExecutor.g().execDecodeTask(new Runnable() { // from class: com.tencent.libra.LibraPicLoader.4
            @Override // java.lang.Runnable
            public void run() {
                if (RFWConfig.getConfigValue("enable_pic_loader_clear_download_listener", true)) {
                    Key pathKey = LibraPicLoader.this.getPathKey(option);
                    synchronized (LibraPicLoader.this.getDownloadLock(pathKey)) {
                        Set set = (Set) LibraPicLoader.this.mDownloadListeners.get(pathKey);
                        if (set == null) {
                            return;
                        }
                        Iterator it = set.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            LibraRequestContext libraRequestContext = (LibraRequestContext) it.next();
                            if (libraRequestContext.getOption() == option && libraRequestContext.getPicLoadStateListener() == iPicLoadStateListener) {
                                it.remove();
                                LibraPicLoader.this.dispatchStateChange(iPicLoadStateListener, LoadState.STATE_CANCEL, option);
                                break;
                            }
                        }
                        if (set.isEmpty()) {
                            LibraPicLoader.this.mDownloadListeners.remove(pathKey);
                        }
                    }
                }
            }
        });
    }

    @Override // com.tencent.libra.IPicLoader
    public boolean hasCache(Option option) {
        if (this.mCacheManager.getCache(getRequestKey(option)) != null) {
            return true;
        }
        return false;
    }

    public boolean isTaskValid(@NonNull Option option, @NonNull String str) {
        if (!option.isCleared() || !option.isEnablePicLoaderClearLogic()) {
            return true;
        }
        LibraLogUtil.INSTANCE.i("LibraPicLoader", RFWLog.USR, option, str, " isTaskValid return: option is cleared");
        return false;
    }

    public boolean isValid(@NonNull Option option) {
        if (!option.isCleared() && option.getTargetView() != null) {
            return true;
        }
        LibraLogUtil.INSTANCE.i("LibraPicLoader", RFWLog.USR, option, "[isValid] false");
        return false;
    }

    @Override // com.tencent.libra.IPicLoader
    public void loadImage(@NonNull final Option option, final IPicLoadStateListener iPicLoadStateListener) {
        runInMainThread(new Runnable() { // from class: com.tencent.libra.LibraPicLoader.5
            @Override // java.lang.Runnable
            public void run() {
                LibraTraceUtil.f118803a.a(LibraPicLoader.this.mBusinessName, LoadState.STATE_PREPARE, option);
                if (!LibraPicLoader.this.bindRequestOptionWithView(option, iPicLoadStateListener)) {
                    LibraPicLoader.this.dispatchStateChange(iPicLoadStateListener, LoadState.STATE_CANCEL, option);
                    return;
                }
                LibraPicLoader.this.initOption(option);
                int requestWidth = option.getRequestWidth();
                int requestHeight = option.getRequestHeight();
                if (option.getTargetView() == null || ((requestWidth > 0 && requestHeight > 0) || !LibraPicLoader.this.canFillRequestWidthAndHeight(option.getTargetView()))) {
                    LibraPicLoader.this.handleOption(option, iPicLoadStateListener);
                } else if (option.getTargetView().getWidth() <= 0 || option.getTargetView().getHeight() <= 0) {
                    LibraPicLoader.this.handleGetViewSize(option, iPicLoadStateListener);
                } else {
                    LibraPicLoader.this.handleOnGetViewSize(option.getTargetView().getWidth(), option.getTargetView().getHeight(), option, iPicLoadStateListener);
                }
            }
        });
    }

    public void onDecodeResult(Option option, int i3) {
        ILoaderResultListener iLoaderResultListener = this.mGlobalLoaderResultListener;
        if (iLoaderResultListener != null) {
            iLoaderResultListener.onDecodeResult(option, i3);
        }
    }

    public void onLoadResult(Option option, int i3) {
        ILoaderResultListener iLoaderResultListener = this.mGlobalLoaderResultListener;
        if (iLoaderResultListener != null) {
            iLoaderResultListener.onLoadResult(option, i3);
        }
    }

    @Override // com.tencent.libra.IPicLoader
    public void release() {
        for (LibraPicDownLoadTask libraPicDownLoadTask : this.mDownloadTasks.values()) {
            libraPicDownLoadTask.cancel();
            LibraThreadExecutor.g().removeDownloadTask(libraPicDownLoadTask);
        }
        for (LibraBaseDecodeTask libraBaseDecodeTask : this.mDecodeTasks.values()) {
            libraBaseDecodeTask.cancel();
            LibraThreadExecutor.g().removeDecodeTask(libraBaseDecodeTask);
        }
        this.mDownloadTasks.clear();
        this.mDownloadListeners.clear();
        this.mDecodeTasks.clear();
        this.mDecodeListeners.clear();
        this.mPendingSizeDeterminerList.clear();
        this.mDefaultDownLoader.release();
        this.mCacheManager.releaseCache();
        RFWLog.i("LibraPicLoader", RFWLog.USR, "[release] business:" + this.mBusinessName);
    }

    @Override // com.tencent.libra.IPicLoader
    public void removeCache(Option option) {
        if (option == null) {
            RFWLog.d("LibraPicLoader", RFWLog.USR, "[removeCache] option should not be null.");
        } else {
            this.mCacheManager.removeLruCache(getRequestKey(option), option.getGroupKey());
        }
    }

    public void setGlobalLoaderResultListener(ILoaderResultListener iLoaderResultListener) {
        this.mGlobalLoaderResultListener = iLoaderResultListener;
    }

    public void showBitmap(Option option, Bitmap bitmap, boolean z16) {
        if (bitmap != null && !bitmap.isRecycled()) {
            ImageView targetView = option.getTargetView();
            if (targetView != null) {
                Drawable drawable = targetView.getDrawable();
                if ((drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == bitmap) {
                    LibraLogUtil.INSTANCE.i("LibraPicLoader", RFWLog.USR, option, "[showBitmap] return: bitmap is already show on targetView, cost=", Long.valueOf(System.currentTimeMillis() - option.mStartTime.longValue()));
                    return;
                }
            }
            showDrawable(option, bitmapTransferDrawable(bitmap), z16);
            return;
        }
        LibraLogUtil.INSTANCE.i("LibraPicLoader", RFWLog.USR, option, "[showBitmap] return: bitmap is null or recycled");
    }

    public void showDrawable(@NonNull final Option option, final Drawable drawable, final boolean z16) {
        if (drawable != null) {
            runInMainThread(new Runnable() { // from class: com.tencent.libra.LibraPicLoader.2
                @Override // java.lang.Runnable
                public void run() {
                    LibraPicLoader.this.showInMain(option, drawable, z16);
                }
            });
        }
    }

    public String getBusinessDownloadRootPath(String str) {
        if (TextUtils.equals(this.mBusinessName, str)) {
            return this.mDownloadRootPath;
        }
        return generateDownloadRootPath(str);
    }

    public String getDownloadCommonRootPath(String str) {
        return getBusinessDownloadRootPath(str) + "pic_common" + File.separator;
    }

    public String getDownloadRootPath(String str) {
        return getBusinessDownloadRootPath(str) + "pic" + File.separator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f118576d;

        a(View view) {
            this.f118576d = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NonNull View view) {
            this.f118576d.removeOnAttachStateChangeListener(this);
            RequestManager orCreate = LifecycleRequestManagerRetriever.g().getOrCreate(this.f118576d);
            Object tag = this.f118576d.getTag(R.id.yhw);
            if (tag instanceof SingleRequest) {
                SingleRequest singleRequest = (SingleRequest) tag;
                if (singleRequest.isCleared()) {
                    LibraLogUtil.INSTANCE.i("LibraPicLoader", RFWLog.USR, singleRequest.getOption(), "isClear no need rebind requestManager");
                    return;
                }
                RequestManager hostRequestManager = singleRequest.getHostRequestManager();
                if (hostRequestManager != orCreate) {
                    if (hostRequestManager != null) {
                        hostRequestManager.unTrackWithoutClear(singleRequest);
                        LibraLogUtil.INSTANCE.i("LibraPicLoader", RFWLog.USR, singleRequest.getOption(), "unTrackPreQuestManager:", Integer.valueOf(hostRequestManager.hashCode()));
                    }
                    if (orCreate != null) {
                        singleRequest.setRequestManagerWrf(new RFWComparableWeakRef(orCreate));
                        orCreate.track(singleRequest);
                        LibraLogUtil.INSTANCE.i("LibraPicLoader", RFWLog.USR, singleRequest.getOption(), "trackNewRequestManager:", Integer.valueOf(orCreate.hashCode()));
                    }
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NonNull View view) {
        }
    }
}
