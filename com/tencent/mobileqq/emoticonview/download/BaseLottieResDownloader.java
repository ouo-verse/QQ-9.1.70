package com.tencent.mobileqq.emoticonview.download;

import android.content.Context;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottie;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rlottie.AXrLottieDrawable;
import com.tencent.rlottie.a;
import com.tencent.util.UiThreadUtil;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class BaseLottieResDownloader<T> implements IEmoticonLottieResDownloader {
    static IPatchRedirector $redirector_ = null;
    protected static final String TAG = "BaseLottieResDownloader";

    public BaseLottieResDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void addReloadDrawable();

    public abstract void downloadRes();

    public abstract String getCacheKey();

    public abstract String getFilePath();

    public AXrLottieDrawable loadLottie(Context context, String str, int i3, int i16, boolean z16, boolean z17) {
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AXrLottieDrawable) iPatchRedirector.redirect((short) 2, this, context, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        if (z16 && AniStickerLottie.cacheEnabled()) {
            z18 = true;
        } else {
            z18 = false;
        }
        return a.C9743a.b(context, str, i3, i16, z18, z17);
    }

    @Override // com.tencent.mobileqq.emoticonview.download.IEmoticonLottieResDownloader
    public void loadLottieRes(AniStickerHelper.Builder builder, LoadListener loadListener) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) builder, (Object) loadListener);
            return;
        }
        if (checkFileExists()) {
            try {
                BaseApplication context = BaseApplication.getContext();
                String filePath = getFilePath();
                int i3 = builder.viewWidth;
                int i16 = builder.viewHeight;
                if (!builder.showLastFrame) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                runOnMainThread(new Runnable(loadListener, loadLottie(context, filePath, i3, i16, z16, true)) { // from class: com.tencent.mobileqq.emoticonview.download.BaseLottieResDownloader.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ AXrLottieDrawable val$drawable;
                    final /* synthetic */ LoadListener val$listener;

                    {
                        this.val$listener = loadListener;
                        this.val$drawable = r9;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, BaseLottieResDownloader.this, loadListener, r9);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.val$listener.onSuccess(this.val$drawable);
                        }
                    }
                });
                return;
            } catch (Exception e16) {
                runOnMainThread(new Runnable(loadListener, e16) { // from class: com.tencent.mobileqq.emoticonview.download.BaseLottieResDownloader.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Exception val$e;
                    final /* synthetic */ LoadListener val$listener;

                    {
                        this.val$listener = loadListener;
                        this.val$e = e16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, BaseLottieResDownloader.this, loadListener, e16);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.val$listener.onFail(this.val$e);
                        }
                    }
                });
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "lottie file no found.");
        }
        addReloadDrawable();
        onLottieResLoading(loadListener);
    }

    protected void onLottieResLoading(LoadListener loadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) loadListener);
        } else {
            if (loadListener == null) {
                return;
            }
            runOnMainThread(new Runnable(loadListener) { // from class: com.tencent.mobileqq.emoticonview.download.BaseLottieResDownloader.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ LoadListener val$listener;

                {
                    this.val$listener = loadListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseLottieResDownloader.this, (Object) loadListener);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.val$listener.onLottieResLoading(BaseLottieResDownloader.this.getCacheKey());
                    }
                }
            });
        }
    }

    public void runOnMainThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
        } else {
            UiThreadUtil.runOnUiThreadWithCheck(runnable);
        }
    }

    public abstract void setOptions(T t16);
}
