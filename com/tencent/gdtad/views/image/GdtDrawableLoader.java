package com.tencent.gdtad.views.image;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtDrawableLoader {
    private static final int RETRY_TIMES_MAX = 3;
    private static final String TAG = "GdtDrawableLoader";
    private URLDrawable drawable;
    private long timeoutMillis;
    private URL url;
    private WeakReference<Listener> weakListener;
    private volatile boolean notified = false;
    private long startTimeMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    private int retryTimes = 0;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface Listener {
        void onLoadFailed(URLDrawable uRLDrawable);

        void onLoadSuccessful(URLDrawable uRLDrawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements URLDrawable.URLDrawableListener {
        a() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            GdtDrawableLoader.this.drawable = uRLDrawable;
            GdtLog.i(GdtDrawableLoader.TAG, "onLoadCanceled " + GdtDrawableLoader.this.getUrl());
            GdtDrawableLoader.this.notify(false);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            GdtDrawableLoader.this.drawable = uRLDrawable;
            GdtLog.e(GdtDrawableLoader.TAG, "onLoadFialed " + GdtDrawableLoader.this.getUrl(), th5);
            if (!GdtDrawableLoader.this.retry()) {
                GdtDrawableLoader.this.notify(false);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            GdtDrawableLoader.this.drawable = uRLDrawable;
            GdtLog.i(GdtDrawableLoader.TAG, "onLoadProgressed " + i3 + " " + GdtDrawableLoader.this.getUrl());
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            GdtDrawableLoader.this.drawable = uRLDrawable;
            GdtLog.i(GdtDrawableLoader.TAG, "onLoadSuccessed " + GdtDrawableLoader.this.getUrl());
            GdtDrawableLoader.this.notify(true);
        }
    }

    public GdtDrawableLoader(String str, long j3, WeakReference<Listener> weakReference) {
        this.timeoutMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        try {
            if (!TextUtils.isEmpty(str)) {
                this.url = new URL(str);
                this.timeoutMillis = j3;
                this.weakListener = weakReference;
            }
        } catch (MalformedURLException e16) {
            GdtLog.e(TAG, "GdtDrawableLoader error " + str, e16);
        }
    }

    @NonNull
    private URLDrawable.URLDrawableListener createListener() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String getUrl() {
        URLDrawable uRLDrawable = this.drawable;
        if (uRLDrawable != null && uRLDrawable.getURL() != null) {
            return this.drawable.getURL().toString();
        }
        if (isValid()) {
            return this.url.toString();
        }
        return null;
    }

    private boolean isValid() {
        if (this.url != null && this.timeoutMillis > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notify(boolean z16) {
        Listener listener;
        WeakReference<Listener> weakReference = this.weakListener;
        if (weakReference != null) {
            listener = weakReference.get();
        } else {
            listener = null;
        }
        if (!this.notified && listener != null) {
            GdtLog.i(TAG, "notify " + z16 + " " + getUrl());
            this.notified = true;
            if (z16) {
                listener.onLoadSuccessful(this.drawable);
            } else {
                listener.onLoadFailed(this.drawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean retry() {
        if (isValid() && this.drawable != null && this.retryTimes < 3) {
            GdtLog.i(TAG, "retry " + getUrl());
            this.retryTimes = this.retryTimes + 1;
            this.drawable.restartDownload();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        URLDrawable uRLDrawable;
        if (isValid() && (uRLDrawable = this.drawable) != null) {
            boolean z16 = true;
            boolean z17 = false;
            if (uRLDrawable.getStatus() == 0) {
                GdtLog.i(TAG, "drawable status is loading " + getUrl());
                if (!this.drawable.isDownloadStarted()) {
                    this.drawable.startDownload(true);
                }
            } else if (this.drawable.getStatus() == 4) {
                GdtLog.i(TAG, "drawable status is file downloaded " + getUrl());
            } else {
                if (this.drawable.getStatus() == 1) {
                    GdtLog.i(TAG, "drawable status is successed " + getUrl());
                    notify(true);
                } else if (this.drawable.getStatus() == 2) {
                    GdtLog.e(TAG, "drawable status is failed " + getUrl());
                    if (!retry()) {
                        notify(false);
                    }
                } else if (this.drawable.getStatus() == 3) {
                    GdtLog.e(TAG, "drawable status is cancled " + getUrl());
                    notify(false);
                } else {
                    GdtLog.e(TAG, "drawable status is " + this.drawable.getStatus() + " " + getUrl());
                }
                z16 = false;
            }
            if (z16 && System.currentTimeMillis() - this.startTimeMillis >= this.timeoutMillis) {
                notify(false);
            } else {
                z17 = z16;
            }
            if (z17 && !this.notified) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.gdtad.views.image.GdtDrawableLoader.2
                    @Override // java.lang.Runnable
                    public void run() {
                        GdtDrawableLoader.this.update();
                    }
                }, 100L);
                return;
            }
            return;
        }
        GdtLog.i(TAG, "update error " + getUrl());
    }

    public URLDrawable getDrawable() {
        return this.drawable;
    }

    public void load() {
        if (!isValid()) {
            GdtLog.e(TAG, "load error");
            return;
        }
        if (this.startTimeMillis != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            QLog.e(TAG, 2, "load already");
            return;
        }
        GdtLog.i(TAG, "load " + getUrl());
        this.startTimeMillis = System.currentTimeMillis();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        obtain.mUseMemoryCache = true;
        URLDrawable drawable = URLDrawable.getDrawable(this.url, obtain);
        this.drawable = drawable;
        if (drawable == null) {
            GdtLog.e(TAG, "load error " + getUrl());
            return;
        }
        drawable.setURLDrawableListener(createListener());
        update();
    }
}
