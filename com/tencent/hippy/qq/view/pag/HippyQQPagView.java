package com.tencent.hippy.qq.view.pag;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.hippy.qq.obj.PerformanceData;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGText;
import org.libpag.PAGView;

/* loaded from: classes7.dex */
public class HippyQQPagView extends VasPagView implements HippyViewBase {
    private static final int MSG_REQUEST_PLAY = 1;
    private static final int MSG_REQUEST_STOP = 2;
    private static final double ONE_SECOND_US = 1000000.0d;
    private static final int RET_CODE_FILE_DOWNLOAD_FAILED = -3;
    private static final int RET_CODE_PAG_UNREADY = -2;
    private static final int RET_CODE_PARAMS_ERROR = -1;
    private static final String TAG = "HippyQQPagView";
    private Handler.Callback mHandlerCallback;
    private boolean mHasRequestPlay;
    private boolean mHasRequestStop;
    private int mHeightMeasureSpec;
    private File mImageCacheDir;
    private boolean mIsAutoPlay;
    private boolean mIsPagLibLoaded;
    private boolean mIsResourceReady;
    private int mLayoutBottom;
    private int mLayoutLeft;
    private int mLayoutRight;
    private int mLayoutTop;
    Function1<View, Unit> mLoadPagLibListener;
    private PAGFile mPagFile;
    private String mPagFilePath;
    private final PerformanceData mPerformanceData;
    private PAGView.PAGViewListener mPlayListener;
    private int mRepeatCount;
    private int mScaleMode;
    private String mSrc;
    private Handler mUiHandler;
    private int mWidthMeasureSpec;

    /* loaded from: classes7.dex */
    public interface EventName {
        public static final String ON_LOAD_END = "onLoadEnd";
        public static final String ON_LOAD_ERROR = "onLoadError";
        public static final String ON_LOAD_START = "onLoadStart";
        public static final String ON_PLAY_END = "onPlayEnd";
        public static final String ON_PLAY_REPEAT = "onPlayRepeat";
        public static final String ON_PLAY_START = "onPlayStart";
    }

    /* loaded from: classes7.dex */
    public interface FunctionName {
        public static final String FLUSH = "flush";
        public static final String GET_DURATION = "duration";
        public static final String GET_PROGRESS = "getProgress";
        public static final String PERFORMANCE_DATA_INFO = "performanceDataInfo";
        public static final String PLAY = "play";
        public static final String REPLACE_IMAGE = "replaceImage";
        public static final String REPLACE_TEXT = "replaceText";
        public static final String SET_PROGRESS = "setProgress";
        public static final String STOP = "stop";
    }

    public HippyQQPagView(Context context) {
        super(context);
        this.mScaleMode = 2;
        this.mPerformanceData = new PerformanceData();
        this.mHandlerCallback = new Handler.Callback() { // from class: com.tencent.hippy.qq.view.pag.a
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean lambda$new$0;
                lambda$new$0 = HippyQQPagView.this.lambda$new$0(message);
                return lambda$new$0;
            }
        };
        this.mPlayListener = new PAGView.PAGViewListener() { // from class: com.tencent.hippy.qq.view.pag.HippyQQPagView.3
            private int mRepeatCount = 0;

            @Override // org.libpag.PAGView.PAGViewListener
            public void onAnimationEnd(PAGView pAGView) {
                HippyQQPagView.this.sendEvent(EventName.ON_PLAY_END, new HippyMap());
            }

            @Override // org.libpag.PAGView.PAGViewListener
            public void onAnimationRepeat(PAGView pAGView) {
                this.mRepeatCount++;
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushInt("repeatCount", this.mRepeatCount);
                HippyQQPagView.this.sendEvent(EventName.ON_PLAY_REPEAT, hippyMap);
            }

            @Override // org.libpag.PAGView.PAGViewListener
            public void onAnimationStart(PAGView pAGView) {
                this.mRepeatCount = 0;
                HippyQQPagView.this.sendEvent(EventName.ON_PLAY_START, new HippyMap());
            }

            @Override // org.libpag.PAGView.PAGViewListener
            public void onAnimationCancel(PAGView pAGView) {
            }

            @Override // org.libpag.PAGView.PAGViewListener
            public void onAnimationUpdate(PAGView pAGView) {
            }
        };
        this.mLoadPagLibListener = new Function1<View, Unit>() { // from class: com.tencent.hippy.qq.view.pag.HippyQQPagView.4
            private boolean updatePAGView(PAGView pAGView) {
                if (QLog.isDebugVersion()) {
                    QLog.d(HippyQQPagView.TAG, 2, "load Pag so success.");
                }
                HippyQQPagView.this.mIsPagLibLoaded = true;
                pAGView.removeListener(HippyQQPagView.this.mPlayListener);
                pAGView.addListener(HippyQQPagView.this.mPlayListener);
                HippyQQPagView.this.onResourceReady();
                return true;
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(View view) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, 0);
                    view.setLayoutParams(layoutParams);
                }
                if (view instanceof PAGView) {
                    if (updatePAGView((PAGView) view)) {
                        return Unit.INSTANCE;
                    }
                } else {
                    layoutParams.width = 0;
                }
                return Unit.INSTANCE;
            }
        };
        generateImageCacheDir();
        this.mUiHandler = new Handler(Looper.getMainLooper(), this.mHandlerCallback);
        api().setStateChangeListener(this.mLoadPagLibListener);
        api().build();
    }

    private void callbackToJs(Promise promise, int i3, String str) {
        if (promise == null) {
            return;
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("retCode", i3);
        hippyMap.pushString("errMsg", str);
        promise.resolve(hippyMap);
    }

    private void downloadFile(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final File file = new File(this.mImageCacheDir, Utils.Crc64String(str));
        if (file.exists()) {
            onDownloadFinished(str, file);
        } else {
            ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1).startDownload(new g(str, file), new f() { // from class: com.tencent.hippy.qq.view.pag.HippyQQPagView.2
                @Override // com.tencent.mobileqq.vip.f
                public void onDone(g gVar) {
                    super.onDone(gVar);
                    if (QLog.isDebugVersion()) {
                        QLog.d(HippyQQPagView.TAG, 2, "downloadPagFile done, url:", str, " exists:", Boolean.valueOf(file.exists()));
                    }
                    HippyQQPagView.this.mPerformanceData.recordDownLoadEndTime();
                    HippyQQPagView.this.onDownloadFinished(str, file);
                }

                @Override // com.tencent.mobileqq.vip.f
                public boolean onStart(g gVar) {
                    HippyQQPagView.this.mPerformanceData.recordDownLoadStartTime();
                    return super.onStart(gVar);
                }
            }, null);
        }
    }

    private void generateImageCacheDir() {
        File cacheDir;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            cacheDir = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
        } else {
            cacheDir = MobileQQ.sMobileQQ.getCacheDir();
        }
        this.mImageCacheDir = new File(cacheDir, AppConstants.PATH_URLDRAWABLE_DISKCACHE);
    }

    private boolean getBooleanFromHippyMap(HippyMap hippyMap, String str, boolean z16) {
        if (hippyMap.containsKey(str)) {
            return hippyMap.getBoolean(str);
        }
        return z16;
    }

    private double getDoubleFromHippyMap(HippyMap hippyMap, String str, double d16) {
        if (hippyMap.containsKey(str)) {
            return hippyMap.getDouble(str);
        }
        return d16;
    }

    private int getIntFromHippyMap(HippyMap hippyMap, String str, int i3) {
        if (hippyMap.containsKey(str)) {
            return hippyMap.getInt(str);
        }
        return i3;
    }

    private PAGView getPagView() {
        View currentView = api().getCurrentView();
        if (currentView instanceof PAGView) {
            return (PAGView) currentView;
        }
        return null;
    }

    private String getStringFromHippyMap(HippyMap hippyMap, String str, String str2) {
        if (hippyMap.containsKey(str)) {
            return hippyMap.getString(str);
        }
        return str2;
    }

    private void handlePerformanceDataInfo(Promise promise) {
        if (promise != null) {
            promise.resolve(this.mPerformanceData.getData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 == 2) {
                stop();
                return false;
            }
            return false;
        }
        play();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadFinished(String str, File file) {
        if (!str.equals(this.mSrc)) {
            return;
        }
        if (!file.exists()) {
            onLoadError(-1, "Download failed");
            return;
        }
        this.mPagFilePath = file.getAbsolutePath();
        if (this.mIsPagLibLoaded) {
            onResourceReady();
        }
    }

    private void onLoadError(int i3, String str) {
        this.mPerformanceData.recordDataLoadEndTime();
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("errorCode", i3);
        hippyMap.pushString("errorMsg", str);
        sendEvent(EventName.ON_LOAD_ERROR, hippyMap);
    }

    private void onLoadSuccess(PAGFile pAGFile) {
        this.mPerformanceData.recordDataLoadEndTime();
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushDouble("duration", pAGFile.duration() / 1000000.0d);
        hippyMap.pushInt("width", pAGFile.width());
        hippyMap.pushInt("height", pAGFile.height());
        sendEvent(EventName.ON_LOAD_END, hippyMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReplaceImageDownloaded(int i3, File file, Promise promise) {
        if (!file.exists()) {
            callbackToJs(promise, -3, "download failed.");
            return;
        }
        if (this.mIsPagLibLoaded && this.mPagFile != null) {
            this.mPagFile.replaceImage(i3, PAGImage.FromPath(file.getAbsolutePath()));
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("retCode", 0);
            hippyMap.pushInt("index", i3);
            if (promise != null) {
                promise.resolve(hippyMap);
                return;
            }
            return;
        }
        callbackToJs(promise, -2, "PAG is unready.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResourceReady() {
        if (getPagView() == null || TextUtils.isEmpty(this.mPagFilePath)) {
            return;
        }
        PAGFile Load = PagViewMonitor.Load(this.mPagFilePath);
        if (Load == null) {
            onLoadError(-1, "Decode Pag failed");
            return;
        }
        this.mIsResourceReady = true;
        this.mPagFile = Load;
        onLoadSuccess(Load);
        if (!this.mHasRequestStop) {
            if (this.mIsAutoPlay || this.mHasRequestPlay) {
                this.mUiHandler.removeMessages(1);
                this.mUiHandler.sendEmptyMessage(1);
            }
        }
    }

    private void play() {
        PAGView pagView;
        if (this.mPagFile == null || (pagView = getPagView()) == null) {
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "real play, isPlaying:", Boolean.valueOf(pagView.isPlaying()));
        }
        if (pagView.isPlaying()) {
            pagView.stop();
        }
        pagView.setComposition(this.mPagFile);
        pagView.setRepeatCount(this.mRepeatCount);
        pagView.setScaleMode(this.mScaleMode);
        pagView.play();
        relayoutChildViews();
    }

    private void relayoutChildViews() {
        PAGView pagView = getPagView();
        if (pagView != null && pagView.getWidth() == 0 && pagView.getHeight() == 0) {
            measure(this.mWidthMeasureSpec, this.mHeightMeasureSpec);
            layout(this.mLayoutLeft, this.mLayoutTop, this.mLayoutRight, this.mLayoutBottom);
        }
    }

    private void requestPlay() {
        this.mHasRequestPlay = true;
        this.mHasRequestStop = false;
        if (this.mIsResourceReady) {
            this.mUiHandler.removeMessages(1);
            this.mUiHandler.sendEmptyMessage(1);
        }
    }

    private void requestStop() {
        this.mHasRequestPlay = false;
        this.mHasRequestStop = true;
        this.mUiHandler.removeMessages(2);
        this.mUiHandler.sendEmptyMessage(2);
    }

    private void stop() {
        PAGView pagView = getPagView();
        if (pagView != null && pagView.isPlaying()) {
            if (QLog.isDebugVersion()) {
                QLog.d(TAG, 2, "real stop.");
            }
            pagView.stop();
        }
    }

    public void dispatchFunction(String str, HippyArray hippyArray, Promise promise) {
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "dispatchFunction functionName:", str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("play".equals(str)) {
            requestPlay();
            return;
        }
        if ("stop".equals(str)) {
            requestStop();
            return;
        }
        if ("performanceDataInfo".equals(str)) {
            handlePerformanceDataInfo(promise);
            return;
        }
        if (FunctionName.SET_PROGRESS.equals(str)) {
            setProgress(hippyArray.getDouble(0));
            return;
        }
        if (FunctionName.GET_PROGRESS.equals(str)) {
            getProgress(promise);
            return;
        }
        if ("duration".equals(str)) {
            getDuration(promise);
            return;
        }
        if (FunctionName.FLUSH.equals(str)) {
            flush();
        } else if (FunctionName.REPLACE_IMAGE.equals(str)) {
            replaceImage(hippyArray.getInt(0), hippyArray.getString(1), promise);
        } else if (FunctionName.REPLACE_TEXT.equals(str)) {
            replaceText(hippyArray.getMap(0), promise);
        }
    }

    public void flush() {
        PAGView pagView = getPagView();
        if (this.mIsPagLibLoaded && pagView != null) {
            pagView.flush();
        }
    }

    public void getDuration(Promise promise) {
        PAGView pagView = getPagView();
        if (this.mIsPagLibLoaded && pagView != null) {
            promise.resolve(Long.valueOf(pagView.duration()));
        } else {
            promise.resolve(0L);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return null;
    }

    public void getProgress(Promise promise) {
        PAGView pagView = getPagView();
        if (this.mIsPagLibLoaded && pagView != null) {
            promise.resolve(Double.valueOf(pagView.getProgress()));
        } else {
            promise.resolve(Double.valueOf(0.0d));
        }
    }

    public void onAfterUpdateProps() {
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "onAfterUpdateProps mIsAutoPlay:", Boolean.valueOf(this.mIsAutoPlay), " mRepeatCount:", Integer.valueOf(this.mRepeatCount), " mPagDownloadUrl:", this.mSrc);
        }
        this.mPerformanceData.recordDataLoadStartTime();
        sendEvent(EventName.ON_LOAD_START, new HippyMap());
        downloadFile(this.mSrc);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.mLayoutLeft = i3;
        this.mLayoutTop = i16;
        this.mLayoutRight = i17;
        this.mLayoutBottom = i18;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.mWidthMeasureSpec = i3;
        this.mHeightMeasureSpec = i16;
    }

    public void onViewDestroy() {
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "onViewDestroy");
        }
        this.mUiHandler.removeMessages(1);
        this.mUiHandler.removeMessages(2);
        stop();
    }

    public void replaceImage(final int i3, final String str, final Promise promise) {
        if (TextUtils.isEmpty(str)) {
            callbackToJs(promise, -1, "url is empty.");
            return;
        }
        final File file = new File(this.mImageCacheDir, Utils.Crc64String(str));
        if (file.exists()) {
            onReplaceImageDownloaded(i3, file, promise);
        } else {
            ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1).startDownload(new g(str, file), new f() { // from class: com.tencent.hippy.qq.view.pag.HippyQQPagView.1
                @Override // com.tencent.mobileqq.vip.f
                public void onDone(g gVar) {
                    super.onDone(gVar);
                    if (QLog.isDebugVersion()) {
                        QLog.d(HippyQQPagView.TAG, 2, "replaceImage download, url:", str, " exists:", Boolean.valueOf(file.exists()));
                    }
                    HippyQQPagView.this.onReplaceImageDownloaded(i3, file, promise);
                }
            }, null);
        }
    }

    public void replaceText(HippyMap hippyMap, Promise promise) {
        if (hippyMap == null) {
            callbackToJs(promise, -1, "can't get params.");
            return;
        }
        if (this.mIsPagLibLoaded && this.mPagFile != null) {
            int i3 = hippyMap.getInt("index");
            PAGText textData = this.mPagFile.getTextData(i3);
            if (textData == null) {
                callbackToJs(promise, -2, "can't get PAGText of index:" + i3);
                return;
            }
            textData.text = getStringFromHippyMap(hippyMap, "text", textData.text);
            textData.fontFamily = getStringFromHippyMap(hippyMap, "fontFamily", textData.fontFamily);
            textData.fontStyle = getStringFromHippyMap(hippyMap, "fontStyle", textData.fontStyle);
            textData.fontSize = (float) getDoubleFromHippyMap(hippyMap, "fontSize", textData.fontSize);
            textData.fauxBold = getBooleanFromHippyMap(hippyMap, "fauxBold", textData.fauxBold);
            textData.fauxItalic = getBooleanFromHippyMap(hippyMap, "fauxItalic", textData.fauxItalic);
            textData.leading = (float) getDoubleFromHippyMap(hippyMap, "leading", textData.leading);
            textData.tracking = (float) getDoubleFromHippyMap(hippyMap, "tracking", textData.tracking);
            textData.justification = getIntFromHippyMap(hippyMap, "justification", textData.justification);
            textData.applyFill = getBooleanFromHippyMap(hippyMap, "applyFill", textData.applyFill);
            textData.fillColor = getIntFromHippyMap(hippyMap, "fillColor", textData.fillColor);
            textData.applyStroke = getBooleanFromHippyMap(hippyMap, "applyStroke", textData.applyStroke);
            textData.strokeColor = getIntFromHippyMap(hippyMap, "strokeColor", textData.strokeColor);
            textData.strokeWidth = (float) getDoubleFromHippyMap(hippyMap, "strokeWidth", textData.strokeWidth);
            textData.strokeOverFill = getBooleanFromHippyMap(hippyMap, "strokeOverFill", textData.strokeOverFill);
            textData.backgroundColor = getIntFromHippyMap(hippyMap, "backgroundColor", textData.backgroundColor);
            textData.backgroundAlpha = getIntFromHippyMap(hippyMap, "backgroundAlpha", textData.backgroundAlpha);
            this.mPagFile.replaceText(i3, textData);
            HippyMap hippyMap2 = new HippyMap();
            hippyMap2.pushInt("retCode", 0);
            hippyMap2.pushInt("index", i3);
            if (promise != null) {
                promise.resolve(hippyMap2);
                return;
            }
            return;
        }
        callbackToJs(promise, -2, "PAG is unready.");
    }

    public void sendEvent(String str, HippyMap hippyMap) {
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "sendEvent name:", str, " data:", hippyMap);
        }
        new HippyViewEvent(str).send(this, hippyMap);
    }

    public void setAutoPlay(boolean z16) {
        this.mIsAutoPlay = z16;
    }

    public void setProgress(double d16) {
        if (d16 < 0.0d) {
            return;
        }
        PAGView pagView = getPagView();
        if (this.mIsPagLibLoaded && pagView != null) {
            pagView.setProgress(d16);
        }
    }

    public void setRepeatCount(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        this.mRepeatCount = i3;
    }

    public void setScaleMode(int i3) {
        this.mScaleMode = i3;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
    }
}
