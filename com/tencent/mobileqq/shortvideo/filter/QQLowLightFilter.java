package com.tencent.mobileqq.shortvideo.filter;

import android.graphics.Bitmap;
import com.tencent.av.video.effect.denoise.DenoiseRender;
import com.tencent.av.video.effect.lowlight.LowLightRender;
import com.tencent.av.video.effect.lowlight.LowLightTools;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQLowLightFilter extends QQBaseFilter {
    private static final int DEFAULT_FBO = -1;
    private static int ResExist = 0;
    private static int ResFailed = 0;
    private static int ResGenerating = 0;
    private static int ResUncheck = 0;
    private static final String TAG = "QQLowLightFilter";
    private static boolean enableNightMode;
    public static String lowLightDir;
    public static String lowLightPath;
    public static int mLowLightResStatus;
    private boolean bwork;
    private int lastHeight;
    private int lastWidth;
    private DenoiseRender mDenoiseRender;
    private LowLightRender mLowLightRender;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(SdkContext.getInstance().getResources().getLowLightResource().getLowLightDir());
        sb5.append("capture_qsvf");
        String str = File.separator;
        sb5.append(str);
        sb5.append("lowlight");
        lowLightDir = sb5.toString();
        lowLightPath = lowLightDir + str + "LowLight.png";
        mLowLightResStatus = 0;
        ResExist = 2;
        ResGenerating = 1;
        ResFailed = -1;
        ResUncheck = 0;
        enableNightMode = false;
    }

    public QQLowLightFilter(QQFilterRenderManager qQFilterRenderManager) {
        super(10, qQFilterRenderManager);
        this.mLowLightRender = null;
        this.mDenoiseRender = null;
        this.bwork = false;
        this.lastWidth = 0;
        this.lastHeight = 0;
    }

    private static void CheckLowLightRes() {
        if (!new File(lowLightPath).exists()) {
            mLowLightResStatus = ResGenerating;
            new BaseThread(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.filter.QQLowLightFilter.1
                @Override // java.lang.Runnable
                public void run() {
                    QQLowLightFilter.generateLowlightRes();
                }
            }, "ShortVideoEffect_LowLightThread").start();
        } else {
            mLowLightResStatus = ResExist;
        }
    }

    public static boolean bResCheckedFailed() {
        if (mLowLightResStatus == ResFailed) {
            return true;
        }
        return false;
    }

    public static boolean bResReady() {
        if (mLowLightResStatus == ResUncheck) {
            CheckLowLightRes();
        }
        if (mLowLightResStatus == ResExist) {
            return true;
        }
        return false;
    }

    private void destroyRender() {
        LowLightRender lowLightRender = this.mLowLightRender;
        if (lowLightRender != null) {
            lowLightRender.destroy();
            this.mLowLightRender = null;
        }
        DenoiseRender denoiseRender = this.mDenoiseRender;
        if (denoiseRender != null) {
            denoiseRender.destroy();
            this.mDenoiseRender = null;
        }
    }

    public static void enableNightMode(boolean z16) {
        enableNightMode = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void generateLowlightRes() {
        File file = new File(lowLightPath);
        if (file.exists()) {
            file.delete();
        } else {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
        }
        Bitmap lowLightImage = LowLightTools.getLowLightImage(3.0f, 0.88f, 0.96f, 1.22f, false);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            lowLightImage.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (Exception e16) {
            SLog.w(TAG, "LowLightTools saveBitmap:" + e16);
        }
        if (!file.exists()) {
            mLowLightResStatus = ResFailed;
        } else {
            mLowLightResStatus = ResExist;
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public boolean isFilterWork() {
        return this.bwork;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        DenoiseRender denoiseRender;
        if (this.mLowLightRender == null) {
            if (bResReady()) {
                this.mLowLightRender = new LowLightRender(SdkContext.getInstance().getApplication(), lowLightDir);
                if (SLog.isEnable()) {
                    SLog.d("lowlightRender_time", "\u5c0f\u592a\u9633\u8017\u65f6 create with res");
                }
            } else if (bResCheckedFailed()) {
                this.mLowLightRender = new LowLightRender(SdkContext.getInstance().getApplication());
                if (SLog.isEnable()) {
                    SLog.d("lowlightRender_time", "\u5c0f\u592a\u9633\u8017\u65f6 create without res");
                }
            } else if (SLog.isEnable()) {
                SLog.d("lowlightRender_time", "\u5c0f\u592a\u9633\u8017\u65f6 create wait");
            }
        }
        if (this.mDenoiseRender == null) {
            DenoiseRender denoiseRender2 = new DenoiseRender(SdkContext.getInstance().getApplication());
            this.mDenoiseRender = denoiseRender2;
            denoiseRender2.setUpdateRate(15.0f);
        }
        this.lastWidth = getQQFilterRenderManager().getFilterWidth();
        this.lastHeight = getQQFilterRenderManager().getFilterHeight();
        if (enableNightMode && this.mLowLightRender != null) {
            if (SdkContext.getInstance().getDpcSwitcher().isDeNoiseSwitchOpen() && (denoiseRender = this.mDenoiseRender) != null) {
                this.mInputTextureID = denoiseRender.process(this.mInputTextureID, -1, this.lastWidth, this.lastHeight).getTextureId();
                QQFilterLogManager.setFilterStatus("QQDeNoiseFilter", true);
            } else {
                QQFilterLogManager.setFilterStatus("QQDeNoiseFilter", false);
            }
            this.mOutputTextureID = this.mLowLightRender.process(this.mInputTextureID, -1, this.lastWidth, this.lastHeight).getTextureId();
            QQFilterLogManager.setFilterStatus(TAG, true);
            this.bwork = true;
            return;
        }
        this.mOutputTextureID = this.mInputTextureID;
        QQFilterLogManager.setFilterStatus(TAG, false);
        this.bwork = false;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceChange(int i3, int i16) {
        int i17 = this.lastHeight;
        if (i17 != i3 || i17 != i16) {
            destroyRender();
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        destroyRender();
    }
}
