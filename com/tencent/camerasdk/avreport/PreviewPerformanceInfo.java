package com.tencent.camerasdk.avreport;

import android.os.Handler;
import android.support.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import org.light.device.LightDeviceUtils;

/* loaded from: classes5.dex */
public class PreviewPerformanceInfo {
    static IPatchRedirector $redirector_ = null;
    public static final int COUNT_PERIOD = 300;
    private static final String TAG = "PreviewPerformanceInfo";
    private static final PreviewPerformanceInfo ourInstance;
    public int counter;
    private Handler mHandler;
    public long memory_sample_count;
    public long render_count;
    public int render_height;
    public int render_width;
    public String sticker_id;
    public long total_memory;
    public long total_render_cost;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12729);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            ourInstance = new PreviewPerformanceInfo();
        }
    }

    public PreviewPerformanceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.counter = 0;
        }
    }

    public static PreviewPerformanceInfo getInstance() {
        return ourInstance;
    }

    public static Long getMicTime() {
        Long valueOf = Long.valueOf(System.currentTimeMillis() * 1000);
        Long valueOf2 = Long.valueOf(System.nanoTime());
        return Long.valueOf(valueOf.longValue() + ((valueOf2.longValue() - ((valueOf2.longValue() / 1000000) * 1000000)) / 1000));
    }

    private void initHandler() {
        if (this.mHandler == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread(TAG);
            baseHandlerThread.start();
            this.mHandler = new Handler(baseHandlerThread.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.counter = 0;
        this.total_render_cost = 0L;
        this.render_count = 0L;
        this.total_memory = 0L;
        this.memory_sample_count = 0L;
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.camerasdk.avreport.PreviewPerformanceInfo.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreviewPerformanceInfo.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        PreviewPerformanceInfo.this.mHandler.getLooper().quit();
                        PreviewPerformanceInfo.this.mHandler = null;
                    }
                }
            });
        }
    }

    public void report() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        initHandler();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.camerasdk.avreport.PreviewPerformanceInfo.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreviewPerformanceInfo.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    PreviewPerformanceInfo previewPerformanceInfo = PreviewPerformanceInfo.this;
                    long j3 = previewPerformanceInfo.render_count;
                    int i16 = 0;
                    if (j3 != 0) {
                        i3 = (int) (previewPerformanceInfo.total_render_cost / j3);
                    } else {
                        i3 = 0;
                    }
                    long j16 = previewPerformanceInfo.memory_sample_count;
                    if (j16 != 0) {
                        i16 = (int) (previewPerformanceInfo.total_memory / j16);
                    }
                    AEKitBean aEKitBean = new AEKitBean(AEKitReportEvent.PREVIEW_PERFORMANCE.value);
                    aEKitBean.ext_int1 = Integer.valueOf(PreviewPerformanceInfo.this.render_width);
                    aEKitBean.ext_int2 = Integer.valueOf(PreviewPerformanceInfo.this.render_height);
                    aEKitBean.ext_int3 = Integer.valueOf(i3);
                    aEKitBean.ext_int4 = Integer.valueOf((int) PreviewPerformanceInfo.this.render_count);
                    aEKitBean.ext_int5 = Integer.valueOf(i16);
                    aEKitBean.ext_str1 = PreviewPerformanceInfo.this.sticker_id;
                    AVReportCenter.getInstance().commit(aEKitBean, Boolean.TRUE);
                    AVRLogUtils.d(PreviewPerformanceInfo.TAG, aEKitBean.toString());
                    PreviewPerformanceInfo.this.resetData();
                }
            });
        }
    }

    public void setResolution(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        initHandler();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable(i3, i16) { // from class: com.tencent.camerasdk.avreport.PreviewPerformanceInfo.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$height;
                final /* synthetic */ int val$width;

                {
                    this.val$width = i3;
                    this.val$height = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PreviewPerformanceInfo.this, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    PreviewPerformanceInfo previewPerformanceInfo = PreviewPerformanceInfo.this;
                    previewPerformanceInfo.render_width = this.val$width;
                    previewPerformanceInfo.render_height = this.val$height;
                }
            });
        }
    }

    public void setStickerID(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        initHandler();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable(str) { // from class: com.tencent.camerasdk.avreport.PreviewPerformanceInfo.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$id;

                {
                    this.val$id = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreviewPerformanceInfo.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    PreviewPerformanceInfo previewPerformanceInfo = PreviewPerformanceInfo.this;
                    previewPerformanceInfo.sticker_id = this.val$id;
                    previewPerformanceInfo.report();
                }
            });
        }
    }

    public void updateInfo(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        initHandler();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable(j3) { // from class: com.tencent.camerasdk.avreport.PreviewPerformanceInfo.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ long val$render_cost;

                {
                    this.val$render_cost = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PreviewPerformanceInfo.this, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                @RequiresApi(api = 19)
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    PreviewPerformanceInfo previewPerformanceInfo = PreviewPerformanceInfo.this;
                    previewPerformanceInfo.total_render_cost += this.val$render_cost;
                    previewPerformanceInfo.render_count++;
                    if (previewPerformanceInfo.counter == 0) {
                        previewPerformanceInfo.total_memory += LightDeviceUtils.getApplicationMemory();
                        PreviewPerformanceInfo previewPerformanceInfo2 = PreviewPerformanceInfo.this;
                        previewPerformanceInfo2.memory_sample_count++;
                        previewPerformanceInfo2.counter = 300;
                    }
                    PreviewPerformanceInfo previewPerformanceInfo3 = PreviewPerformanceInfo.this;
                    previewPerformanceInfo3.counter--;
                }
            });
        }
    }
}
