package com.tencent.tmediacodec.pools;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.ThreadManager;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class CodecWrapperManager implements CodecWrapperTransformation {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "CodecWrapperManager";
    private final CodecWrapperPool mKeepCodecPool;
    private final CodecWrapperPool mRunningCodecPool;

    public CodecWrapperManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        CodecWrapperPool codecWrapperPool = new CodecWrapperPool(2, "keep");
        this.mKeepCodecPool = codecWrapperPool;
        this.mRunningCodecPool = new CodecWrapperPool(Integer.MAX_VALUE, "running");
        codecWrapperPool.setActionCallback(new PoolActionCallback() { // from class: com.tencent.tmediacodec.pools.CodecWrapperManager.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CodecWrapperManager.this);
                }
            }

            @Override // com.tencent.tmediacodec.pools.PoolActionCallback
            public void onErase(@NonNull ReuseCodecWrapper reuseCodecWrapper) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) reuseCodecWrapper);
                    return;
                }
                if (LogUtils.isLogEnable()) {
                    LogUtils.d("CodecWrapperManager", "onErase codecWrapper:" + reuseCodecWrapper);
                }
                reuseCodecWrapper.recycle();
            }
        });
    }

    @Override // com.tencent.tmediacodec.pools.CodecWrapperTransformation
    public void clearAndReleaseAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (LogUtils.isLogEnable()) {
            LogUtils.i("CodecWrapperManager", "clearAndReleaseAll");
        }
        this.mRunningCodecPool.clear();
        this.mKeepCodecPool.clear();
    }

    public void clearAndReleaseKeepPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mKeepCodecPool.clear();
        }
    }

    @NonNull
    public final String getDumpInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "runningPool:" + this.mRunningCodecPool + " keepPool:" + this.mKeepCodecPool;
    }

    public boolean isKeepPoolFull() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.mKeepCodecPool.isFull();
    }

    @Override // com.tencent.tmediacodec.pools.CodecWrapperTransformation
    @Nullable
    public ReuseCodecWrapper obtainCodecWrapper(@NonNull FormatWrapper formatWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ReuseCodecWrapper) iPatchRedirector.redirect((short) 4, (Object) this, (Object) formatWrapper);
        }
        ReuseCodecWrapper obtain = this.mKeepCodecPool.obtain(formatWrapper);
        if (LogUtils.isLogEnable()) {
            LogUtils.d("CodecWrapperManager", "obtainCodecWrapper codecWrapper:" + obtain);
        }
        return obtain;
    }

    @Override // com.tencent.tmediacodec.pools.CodecWrapperTransformation
    public void removeFromRunning(@NonNull ReuseCodecWrapper reuseCodecWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) reuseCodecWrapper);
            return;
        }
        if (LogUtils.isLogEnable()) {
            LogUtils.d("CodecWrapperManager", "removeFromRunning codecWrapper:" + reuseCodecWrapper);
        }
        this.mRunningCodecPool.remove(reuseCodecWrapper);
    }

    @Override // com.tencent.tmediacodec.pools.CodecWrapperTransformation
    public void transToRunning(@NonNull ReuseCodecWrapper reuseCodecWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) reuseCodecWrapper);
            return;
        }
        if (LogUtils.isLogEnable()) {
            LogUtils.d("CodecWrapperManager", "transToRunning codecWrapper:" + reuseCodecWrapper);
        }
        this.mKeepCodecPool.remove(reuseCodecWrapper);
        this.mRunningCodecPool.put(reuseCodecWrapper);
        ThreadManager.postOnSubThread(new Runnable(reuseCodecWrapper) { // from class: com.tencent.tmediacodec.pools.CodecWrapperManager.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ReuseCodecWrapper val$codecWrapper;

            {
                this.val$codecWrapper = reuseCodecWrapper;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CodecWrapperManager.this, (Object) reuseCodecWrapper);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                CodecCallback callback = this.val$codecWrapper.getCallback();
                if (callback != null) {
                    callback.onTransToRunningPool();
                }
            }
        });
    }

    @Override // com.tencent.tmediacodec.pools.CodecWrapperTransformation
    public void transTokeep(@NonNull ReuseCodecWrapper reuseCodecWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) reuseCodecWrapper);
            return;
        }
        if (LogUtils.isLogEnable()) {
            LogUtils.d("CodecWrapperManager", "transTokeep codecWrapper:" + reuseCodecWrapper);
        }
        this.mRunningCodecPool.remove(reuseCodecWrapper);
        this.mKeepCodecPool.put(reuseCodecWrapper);
        CodecCallback callback = reuseCodecWrapper.getCallback();
        if (callback != null) {
            callback.onTransToKeepPool();
        }
    }
}
