package com.tencent.mobileqq.shortvideo.facedancegame;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceDetectTask;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.ttpic.openapi.util.RetrieveDataManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes18.dex */
public class GestureDetectManager {
    public static final String GestureSoName = "libAVGesture4Android.so";
    private static final String TAG = "GestureDetectManager";
    private static GestureDetectManager instance = new GestureDetectManager();
    boolean bSoLoaded = false;
    boolean bModelLoaded = false;

    public static boolean copyFileFromAssets(String str, String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(Environment.getExternalStorageDirectory(), str));
            File file = new File(str2);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    fileInputStream.close();
                    return true;
                }
            }
        } catch (IOException e16) {
            e16.printStackTrace();
            Log.e("MainActivity", "[copyFileFromAssets] IOException " + e16.toString());
            return false;
        }
    }

    public static GestureDetectManager getInstance() {
        return instance;
    }

    private boolean innerLoadModel() {
        if (!this.bSoLoaded) {
            return false;
        }
        try {
            String gameModelPath = SdkContext.getInstance().getResources().geteGestureGameResource().getGameModelPath();
            AVGestureWrapper.setFilePath(gameModelPath, gameModelPath, "");
            AVGestureWrapper.setGlobalConfigFile(gameModelPath);
            AVGestureWrapper.setAVGestureReport(new AVGestureWrapper.AVUploadReport() { // from class: com.tencent.mobileqq.shortvideo.facedancegame.GestureDetectManager.1
                @Override // com.tencent.av.avgesture.AVGestureWrapper.AVUploadReport
                public void avGestureUploadReport(String str, String str2) {
                    SdkContext.getInstance().getReporter().reportToCompass("dc00898", "", str, str, 0, 0, "", "", str2, "");
                }
            });
            AVGestureWrapper.setShouldUpload(false);
            SLog.d(TAG, String.format("loadSo suc, [%s]", AVGestureWrapper.getVersionInfo()));
        } catch (Exception e16) {
            SLog.e(TAG, String.format("loadSo suc, but setCnnModelPath Exception[%s]", e16.getClass().getName()), e16);
        }
        return false;
    }

    private boolean innerLoadSo() {
        try {
            if (!SdkContext.getInstance().getResources().getGestureResource().isGestureEnable()) {
                return false;
            }
            System.load(SdkContext.getInstance().getResources().getGestureResource().getSoPathDir() + GestureSoName);
            return true;
        } catch (Throwable th5) {
            SLog.e(TAG, String.format("System.load Exception[%s]", th5.getClass().getName()), th5);
            return false;
        }
    }

    public boolean LoadSDK() {
        boolean z16 = true;
        if (this.bSoLoaded && this.bModelLoaded) {
            return true;
        }
        synchronized (GestureSoName) {
            if (!this.bSoLoaded) {
                this.bSoLoaded = innerLoadSo();
            }
            if (!this.bModelLoaded) {
                this.bModelLoaded = innerLoadModel();
            }
        }
        if (!this.bSoLoaded || !this.bModelLoaded) {
            z16 = false;
        }
        if (z16) {
            GestureMgrRecognize.getInstance().setModelLoadStatus(2);
        }
        return z16;
    }

    public void ResetModel() {
        this.bModelLoaded = false;
    }

    public void doGestureDetectWithCallBack(int i3, int i16, int i17, IGestureDetectCallBack iGestureDetectCallBack) {
        if (SdkContext.getInstance().getResources().geteGestureGameResource().isGestureGameEnable()) {
            doGestureDetectWithCallBack(RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, i3, i16, i17), i16, i17, iGestureDetectCallBack);
        }
    }

    public void doGestureDetectWithCallBack(final byte[] bArr, final int i3, final int i16, final IGestureDetectCallBack iGestureDetectCallBack) {
        BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.facedancegame.GestureDetectManager.2
            @Override // java.lang.Runnable
            public void run() {
                long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                AVGestureWrapper aVGestureWrapper = new AVGestureWrapper();
                boolean doCalc = aVGestureWrapper.doCalc(bArr, i3, i16, 0, 0, true);
                FaceDanceDetectTask.logTimeInfo("AVGestureWrapper.doCalc", elapsedRealtimeNanos, SystemClock.elapsedRealtimeNanos());
                if (iGestureDetectCallBack != null) {
                    FaceDanceDetectTask.GestureDetectTaskResult gestureDetectTaskResult = new FaceDanceDetectTask.GestureDetectTaskResult();
                    gestureDetectTaskResult.vaild = doCalc;
                    if (doCalc) {
                        gestureDetectTaskResult.type = aVGestureWrapper.getGestureType();
                    }
                    iGestureDetectCallBack.gestureDetectEnd(gestureDetectTaskResult);
                }
            }
        });
        baseThread.setPriority(10);
        baseThread.start();
    }
}
