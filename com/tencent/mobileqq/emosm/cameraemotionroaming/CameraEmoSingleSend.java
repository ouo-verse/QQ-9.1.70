package com.tencent.mobileqq.emosm.cameraemotionroaming;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.app.ICameraEmoRoamingHandler;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.control.EmoAsyncStep;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CameraEmoSingleSend extends EmoAsyncStep {
    private final Object G = new Object();
    private boolean H;
    private CameraEmotionData I;
    private ICameraEmotionRoamingDBManagerService J;
    private ICameraEmoRoamingHandler K;
    private ICameraEmoRoamingManagerService L;
    private Timer M;
    private boolean N;
    public boolean P;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements IEmosmService.GIFCreatorCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f204248a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f204249b;

        a(Object obj, long j3) {
            this.f204248a = obj;
            this.f204249b = j3;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService.GIFCreatorCallback
        public void onGifCreateFail() {
            QLog.d("CameraEmoSingleSend", 1, "onGifCreateFail, emoId:", Integer.valueOf(CameraEmoSingleSend.this.I.emoId));
            CameraEmoSingleSend.this.y(false, null);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("sucFlag", "0");
            CameraEmoSingleSend.this.t().collectPerformance(null, "CamEmoCreateGIF", false, System.currentTimeMillis() - this.f204249b, 0L, hashMap, null);
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService.GIFCreatorCallback
        public void onGifCreateSuccess(String str) {
            QLog.d("CameraEmoSingleSend", 1, "onGifCreateSuccess, emoId:", Integer.valueOf(CameraEmoSingleSend.this.I.emoId));
            CameraEmoSingleSend.this.y(true, str);
            ((IEmosmService) QRoute.api(IEmosmService.class)).clearFrameFilesGifCreator(this.f204248a);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("sucFlag", "1");
            CameraEmoSingleSend.this.t().collectPerformance(null, "CamEmoCreateGIF", true, System.currentTimeMillis() - this.f204249b, 0L, hashMap, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements ICameraEmoRoamingManagerService.a {
        b() {
        }

        @Override // com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService.a
        public void a(int i3, CameraEmotionData cameraEmotionData) {
            boolean z16 = false;
            QLog.d("CameraEmoSingleSend", 1, "onAddEmoFinish, result:", Integer.valueOf(i3), " emoId:", Integer.valueOf(cameraEmotionData.emoId), " originalId:", Integer.valueOf(CameraEmoSingleSend.this.I.emoId));
            if (i3 == 0) {
                z16 = true;
            }
            CameraEmoSingleSend.this.x(z16, i3);
            CameraEmoSingleSend.this.w(String.valueOf(i3), 2);
        }
    }

    public CameraEmoSingleSend(CameraEmotionData cameraEmotionData, boolean z16) {
        this.H = z16;
        this.I = cameraEmotionData;
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z16, int i3) {
        String str;
        String str2;
        CameraEmotionData cameraEmotionData = this.I;
        if (z16) {
            str = "normal";
        } else {
            str = "failed";
        }
        cameraEmotionData.RomaingType = str;
        this.J.updateCustomEmotion(cameraEmotionData);
        this.J.trimCache();
        this.K.notifyUI(5, z16, 14);
        HashMap<String, String> hashMap = new HashMap<>();
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("sucFlag", str2);
        hashMap.put("retCode", String.valueOf(i3));
        t().collectPerformance(null, "CamEmoUpload", z16, 0L, 0L, hashMap, null);
        synchronized (this.G) {
            this.G.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z16, String str) {
        if (this.N) {
            QLog.d("CameraEmoSingleSend", 1, "upload return, timer canceled, emoPath:", this.I.emoPath);
            return;
        }
        if (z16) {
            String bytes2HexStr = HexUtil.bytes2HexStr(MD5.getFileMd5(str));
            CameraEmotionData cameraEmotionData = this.I;
            cameraEmotionData.emoPath = str;
            cameraEmotionData.md5 = bytes2HexStr;
            this.J.updateCustomEmotion(cameraEmotionData);
            b bVar = new b();
            if (!v()) {
                QLog.d("CameraEmoSingleSend", 1, "uploadCameraEmo, net not support");
                bVar.a(12, this.I);
                return;
            } else {
                this.L.uploadCameraEmo(this.I, bVar);
                return;
            }
        }
        x(false, 14);
    }

    @Override // com.tencent.mobileqq.emosm.control.EmoAsyncStep
    protected int e() {
        boolean z16;
        boolean z17;
        BaseTimer baseTimer = new BaseTimer();
        this.M = baseTimer;
        baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                QLog.d("CameraEmoSingleSend", 1, "timer cancel, emoPath:", CameraEmoSingleSend.this.I.emoPath);
                CameraEmoSingleSend.this.N = true;
                CameraEmoSingleSend.this.x(false, 12);
            }
        }, 90000L);
        if (this.H) {
            if (this.I.emoOriginalPath != null && new File(this.I.emoOriginalPath).exists()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (this.I.emoPath != null && new File(this.I.emoPath).exists()) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("CameraEmoSingleSend", 1, "resend, hasOriginalFile:", Boolean.valueOf(z17), " hasMergedFile:", Boolean.valueOf(z16));
            if (!z17 && !z16) {
                CameraEmotionData cameraEmotionData = this.I;
                QLog.d("CameraEmoSingleSend", 1, "resend, emoOriginalPath:", cameraEmotionData.emoOriginalPath, " emoPath:", cameraEmotionData.emoPath, " emoId:", Integer.valueOf(cameraEmotionData.emoId));
                CameraEmotionData cameraEmotionData2 = this.I;
                cameraEmotionData2.RomaingType = "failed";
                this.J.updateCustomEmotion(cameraEmotionData2);
                this.K.notifyUI(4, true, null);
                return 7;
            }
            this.J.updateCustomEmotion(this.I);
        } else {
            z16 = false;
        }
        if (this.H && z16) {
            y(true, this.I.emoPath);
        } else if (!TextUtils.isEmpty(this.I.emoPath)) {
            if (new File(this.I.emoPath).exists()) {
                y(true, this.I.emoPath);
            } else {
                QLog.d("CameraEmoSingleSend", 1, "GIF save AIO fail, emoPath not exist, emoPath:", this.I.emoPath);
                return 7;
            }
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            Object s16 = s(this.I.emoOriginalPath);
            ((IEmosmService) QRoute.api(IEmosmService.class)).startGIFCreator(s16, new a(s16, currentTimeMillis));
        }
        if (!this.N && !this.P) {
            synchronized (this.G) {
                try {
                    this.G.wait(120000L);
                } catch (Exception unused) {
                }
            }
            this.M.cancel();
        } else {
            QLog.d("CameraEmoSingleSend", 1, "upload no need wait, timer canceled, emoPath:", this.I.emoPath);
        }
        return 7;
    }

    public BaseQQAppInterface p() {
        return (BaseQQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public Object s(String str) {
        return ((IEmosmService) QRoute.api(IEmosmService.class)).getGIFCreator(str);
    }

    public StatisticCollector t() {
        return StatisticCollector.getInstance(BaseApplication.getContext());
    }

    public void u() {
        BaseQQAppInterface p16 = p();
        if (p16 != null) {
            this.J = (ICameraEmotionRoamingDBManagerService) p16.getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
            this.K = (ICameraEmoRoamingHandler) p16.getBusinessHandler(CameraEmoRoamingHandler.f194459e);
            this.L = (ICameraEmoRoamingManagerService) p16.getRuntimeService(ICameraEmoRoamingManagerService.class);
        }
    }

    public boolean v() {
        return NetworkUtil.isNetSupport(BaseApplication.getContext());
    }

    public void w(String str, int i3) {
        EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus(str, i3);
    }
}
