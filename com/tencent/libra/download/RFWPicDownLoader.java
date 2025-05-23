package com.tencent.libra.download;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.libra.download.ILibraDownloader;
import com.tencent.libra.download.RFWAbsPicDW;
import com.tencent.libra.request.Option;
import com.tencent.libra.strategy.ILibraBaseStrategy;
import com.tencent.libra.util.LibraLogUtil;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class RFWPicDownLoader implements ILibraDownloader {
    private static final long MAX_WAIT_TIME = 30000;
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("RFWPicDownLoader");

    @NonNull
    private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, ILibraDownloader.PicDownLoadListener>> mDownLoadListeners = new ConcurrentHashMap<>();

    @NonNull
    private final RFWOkHttpDW mOkHttpDW;
    private final LibraNetworkStateObserveWrapper networkStateObserveWrapper;
    private final LightQuicDownloaderWrapper quicDownloaderWrapper;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements RFWAbsPicDW.ICallBackListener {
        a() {
        }

        @Override // com.tencent.libra.download.RFWAbsPicDW.ICallBackListener
        public void callBack(Option option, boolean z16, int i3) {
            RFWPicDownLoader.this.callBackResult(option, z16, i3);
        }
    }

    public RFWPicDownLoader(@NonNull ILibraBaseStrategy iLibraBaseStrategy) {
        this.mOkHttpDW = new RFWOkHttpDW(iLibraBaseStrategy);
        this.quicDownloaderWrapper = new LightQuicDownloaderWrapper(iLibraBaseStrategy);
        this.networkStateObserveWrapper = new LibraNetworkStateObserveWrapper(iLibraBaseStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackResult(Option option, boolean z16, int i3) {
        ConcurrentHashMap<Integer, ILibraDownloader.PicDownLoadListener> concurrentHashMap;
        if (option != null && (concurrentHashMap = this.mDownLoadListeners.get(option.getLocalPath())) != null) {
            Iterator<Integer> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                ILibraDownloader.PicDownLoadListener remove = concurrentHashMap.remove(it.next());
                if (remove != null) {
                    remove.mOption.setResultBitMap(option.getResultBitMap());
                    remove.onResult(z16, i3);
                }
            }
            LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, option, "[callBackResult]:", Boolean.valueOf(z16), ",call back size:", Integer.valueOf(concurrentHashMap.size()), ",resultCode = ", Integer.valueOf(i3));
        }
    }

    private long getMaxWaitTime(Option option, ConcurrentHashMap<Integer, ILibraDownloader.PicDownLoadListener> concurrentHashMap) {
        Option option2;
        long j3 = 0;
        if (option != null && concurrentHashMap != null && concurrentHashMap.size() > 0) {
            long longValue = option.mDownLoadStartTime.longValue();
            Iterator<Integer> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                ILibraDownloader.PicDownLoadListener picDownLoadListener = concurrentHashMap.get(it.next());
                if (picDownLoadListener != null && (option2 = picDownLoadListener.mOption) != null) {
                    long longValue2 = longValue - option2.mDownLoadStartTime.longValue();
                    LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, option, "[getMaxWaitTime] old seq = ", Integer.valueOf(picDownLoadListener.mOption.getSeq()), " compute WaitTime:", Long.valueOf(longValue2));
                    if (longValue2 > j3) {
                        j3 = longValue2;
                    }
                }
            }
        }
        return j3;
    }

    private synchronized boolean putLoadListenerIfAbsent(Option option, ILibraDownloader.PicDownLoadListener picDownLoadListener) {
        boolean z16;
        ConcurrentHashMap<Integer, ILibraDownloader.PicDownLoadListener> concurrentHashMap = this.mDownLoadListeners.get(option.getLocalPath());
        z16 = true;
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        } else if (concurrentHashMap.size() != 0) {
            z16 = false;
        }
        concurrentHashMap.put(Integer.valueOf(picDownLoadListener.hashCode()), picDownLoadListener);
        this.mDownLoadListeners.put(option.getLocalPath(), concurrentHashMap);
        return z16;
    }

    private void toDownLoad(Option option, ILibraDownloader.PicDownLoadListener picDownLoadListener, boolean z16) {
        if (z16 || putLoadListenerIfAbsent(option, picDownLoadListener)) {
            toDownLoad(option, new a());
        }
    }

    @Override // com.tencent.libra.download.ILibraDownloader
    public boolean canDownload(Option option) {
        return true;
    }

    @Override // com.tencent.libra.download.ILibraDownloader
    public void cancel(Option option) {
        this.quicDownloaderWrapper.g(option);
        cancel(option, false);
    }

    @Override // com.tencent.libra.download.ILibraDownloader
    public void downLoad(Option option, ILibraDownloader.PicDownLoadListener picDownLoadListener) {
        if (option != null && picDownLoadListener != null) {
            if (this.quicDownloaderWrapper.h(option, picDownLoadListener, this)) {
                return;
            }
            this.networkStateObserveWrapper.b();
            ConcurrentHashMap<Integer, ILibraDownloader.PicDownLoadListener> concurrentHashMap = this.mDownLoadListeners.get(option.getLocalPath());
            if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                long maxWaitTime = getMaxWaitTime(option, concurrentHashMap);
                if (maxWaitTime > 30000) {
                    LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, option, "[downLoad] over max wait time direct to download waitTime:", Long.valueOf(maxWaitTime));
                    cancel(option, true);
                    toDownLoad(option, picDownLoadListener, true);
                    return;
                }
                concurrentHashMap.put(Integer.valueOf(picDownLoadListener.hashCode()), picDownLoadListener);
                LibraLogUtil libraLogUtil = LibraLogUtil.INSTANCE;
                String str = TAG;
                libraLogUtil.i(str, RFWLog.USR, option, "[downLoad] is on Downloading");
                if (concurrentHashMap.size() == 1) {
                    if (RFWFileUtils.fileExists(option.getLocalPath())) {
                        callBackResult(option, true, 0);
                        libraLogUtil.i(str, RFWLog.USR, option, "[downLoad] lost callback  return success");
                        return;
                    } else {
                        cancel(option, true);
                        toDownLoad(option, picDownLoadListener, true);
                        libraLogUtil.i(str, RFWLog.USR, option, "[downLoad] lost callback  reDownload");
                        return;
                    }
                }
                return;
            }
            toDownLoad(option, picDownLoadListener, false);
            return;
        }
        RFWLog.i(TAG, RFWLog.USR, "illegal args");
    }

    @Override // com.tencent.libra.download.ILibraDownloader
    public boolean needDownloadOnWorkThread() {
        return true;
    }

    public void release() {
        this.mDownLoadListeners.clear();
        this.mOkHttpDW.release();
        this.quicDownloaderWrapper.i();
        this.networkStateObserveWrapper.c();
    }

    private void cancel(Option option, boolean z16) {
        if (!z16) {
            callBackResult(option, false, 4);
        }
        this.mOkHttpDW.cancel(option);
    }

    public void toDownLoad(Option option, RFWAbsPicDW.ICallBackListener iCallBackListener) {
        this.mOkHttpDW.handlerDownLoad(option, iCallBackListener);
    }
}
