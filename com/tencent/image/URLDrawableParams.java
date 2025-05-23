package com.tencent.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.image.downloader.IllegalURLDownloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.Executor;

/* loaded from: classes7.dex */
public abstract class URLDrawableParams {
    static IPatchRedirector $redirector_ = null;
    public static final int TASK_TYPE_ASYNC_TASK = 0;
    public static final int TASK_TYPE_SWING_WORKER = 1;
    public boolean mAutoScaleByDensity;
    public Bitmap.Config mConfig;
    int mDeviceDensity;
    private Hashtable<String, ProtocolDownloader> mDownLoaderMap;
    public boolean mFadeInImage;
    HashMap<String, String> mLocalFileMap;
    int mMemoryCacheSize;
    public int mReqHeight;
    public int mReqWidth;
    public Handler mSubHandler;
    public Executor mURLDrawableExecutor;
    public boolean mUseGifAnimation;

    public URLDrawableParams(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mFadeInImage = true;
        this.mUseGifAnimation = true;
        this.mConfig = Bitmap.Config.ARGB_8888;
        this.mAutoScaleByDensity = true;
        this.mDeviceDensity = 160;
        this.mMemoryCacheSize = 5242880;
        this.mLocalFileMap = new HashMap<>();
        this.mDownLoaderMap = new Hashtable<>();
        this.mDeviceDensity = context.getResources().getDisplayMetrics().densityDpi;
        this.mReqWidth = context.getResources().getDisplayMetrics().widthPixels;
        this.mReqHeight = context.getResources().getDisplayMetrics().heightPixels;
    }

    protected abstract ProtocolDownloader doGetDownloader(String str, Object obj);

    protected abstract String doGetLocalFilePath(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ApngSoLoader getApngSoLoader();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Drawable getDefaultLoadingDrawable();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Drawable getDefualtFailedDrawable();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtocolDownloader getDownloader(String str, Object obj) {
        ProtocolDownloader protocolDownloader = this.mDownLoaderMap.get(str);
        if (protocolDownloader == null) {
            ProtocolDownloader doGetDownloader = doGetDownloader(str, obj);
            if (doGetDownloader == null) {
                if ("file".equalsIgnoreCase(str)) {
                    doGetDownloader = new LocaleFileDownloader();
                } else if (IllegalURLDownloader.ILLEGAL_URL.equals(str)) {
                    doGetDownloader = new IllegalURLDownloader();
                }
            }
            protocolDownloader = doGetDownloader;
            if (protocolDownloader != null) {
                this.mDownLoaderMap.put(str, protocolDownloader);
            }
        }
        return protocolDownloader;
    }

    String getLocalFilePath(String str) {
        String str2 = this.mLocalFileMap.get(str);
        if (str2 == null && (str2 = doGetLocalFilePath(str)) != null) {
            this.mLocalFileMap.put(str, str2);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SharpSoLoader getSharpSoLoader();
}
