package com.tencent.view;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.baseutils.log.LogUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class FilterEngineFactory {
    static IPatchRedirector $redirector_;
    private static volatile FilterEngineFactory sIntance;
    private Handler handler;
    private FilterContext mFilterContext;
    private HandlerThread mGlThread;
    private String mThreadOwner;

    FilterEngineFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mFilterContext = null;
            initGlThread();
        }
    }

    public static void destroyInstance() {
        if (sIntance != null) {
            LogUtils.d("FilterEngine", "destroyInstance()");
            sIntance.destroy();
        }
    }

    public static FilterEngineFactory getInstance() {
        if (sIntance == null) {
            synchronized (FilterEngineFactory.class) {
                if (sIntance == null) {
                    sIntance = new FilterEngineFactory();
                }
            }
        }
        return sIntance;
    }

    private void initGlThread() {
        Runnable runnable = new Runnable() { // from class: com.tencent.view.FilterEngineFactory.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FilterEngineFactory.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                FilterEngineFactory.this.mFilterContext = new FilterContext();
                FilterEngineFactory.this.mFilterContext.usecurruntContext();
                FilterEngineFactory.this.mThreadOwner = Thread.currentThread().getName();
            }
        };
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("FILTER_ENGINE_FACTORY");
        this.mGlThread = baseHandlerThread;
        baseHandlerThread.start();
        Handler handler = new Handler(this.mGlThread.getLooper());
        this.handler = handler;
        handler.post(runnable);
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            queue(new Runnable() { // from class: com.tencent.view.FilterEngineFactory.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FilterEngineFactory.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (FilterEngineFactory.this.mFilterContext != null) {
                        FilterEngineFactory.this.mFilterContext.destroyEgl();
                        FilterEngineFactory.this.mFilterContext = null;
                    }
                    if (FilterEngineFactory.this.mGlThread != null && FilterEngineFactory.this.mGlThread.isAlive()) {
                        if (ApiHelper.hasJellyBeanMR2()) {
                            FilterEngineFactory.this.mGlThread.quitSafely();
                        } else {
                            FilterEngineFactory.this.mGlThread.quit();
                        }
                        FilterEngineFactory.this.mGlThread = null;
                        LogUtils.d("FilterEngine", "mGlThread = null");
                    }
                    FilterEngineFactory unused = FilterEngineFactory.sIntance = null;
                }
            });
        }
    }

    public Looper getLooper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Looper) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HandlerThread handlerThread = this.mGlThread;
        if (handlerThread == null) {
            return null;
        }
        return handlerThread.getLooper();
    }

    public void queue(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
        } else {
            this.handler.post(runnable);
        }
    }

    public boolean usecurruntContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        FilterContext filterContext = this.mFilterContext;
        if (filterContext != null) {
            return filterContext.usecurruntContext();
        }
        return false;
    }
}
