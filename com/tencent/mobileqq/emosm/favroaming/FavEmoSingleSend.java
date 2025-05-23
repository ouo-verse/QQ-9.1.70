package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.control.EmoAsyncStep;
import com.tencent.mobileqq.emosm.r;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.MobileQQ;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FavEmoSingleSend extends EmoAsyncStep implements ad {
    private final Object G = new Object();
    private boolean H;
    private CustomEmotionData I;
    private IFavroamingManagerService J;
    private IFavroamingDBManagerService K;
    private r L;
    private TransferRequest M;
    private Timer N;
    public boolean P;

    public FavEmoSingleSend(CustomEmotionData customEmotionData, boolean z16) {
        this.H = z16;
        this.I = customEmotionData;
        n();
    }

    @Override // com.tencent.mobileqq.emosm.control.EmoAsyncStep
    protected int e() {
        QLog.d("FavEmoSingleSend", 1, "doStep, isResend: ", Boolean.valueOf(this.H), " ", this.I);
        TransferRequest syncUpload = this.J.syncUpload(this.I, this);
        this.M = syncUpload;
        if (syncUpload == null) {
            QLog.d("FavEmoSingleSend", 1, "doStep, network not support");
            o("failed", 0, 3, 0);
            return 7;
        }
        BaseTimer baseTimer = new BaseTimer();
        this.N = baseTimer;
        baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                QLog.e("FavEmoSingleSend", 1, "doStep, upload not complete");
                ((ITransFileController) ((BaseQQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getRuntimeService(ITransFileController.class)).stop(FavEmoSingleSend.this.M);
                FavEmoSingleSend.this.o("failed", 0, 4, 0);
                synchronized (FavEmoSingleSend.this.G) {
                    FavEmoSingleSend.this.G.notify();
                }
            }
        }, 30000L);
        synchronized (this.G) {
            try {
                this.G.wait(40000L);
            } catch (Exception unused) {
            }
        }
        this.N.cancel();
        return 7;
    }

    @Override // com.tencent.mobileqq.pic.ad
    public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
        return null;
    }

    public void n() {
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.J = (IFavroamingManagerService) baseQQAppInterface.getRuntimeService(IFavroamingManagerService.class);
        this.K = (IFavroamingDBManagerService) baseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
        this.L = (r) baseQQAppInterface.getBusinessHandler(FavEmoRoamingHandler.f194632e);
    }

    public void o(String str, int i3, int i16, int i17) {
        boolean z16;
        if (str == "isUpdate") {
            z16 = true;
        } else {
            z16 = false;
        }
        this.P = z16;
        CustomEmotionData customEmotionData = this.I;
        customEmotionData.RomaingType = str;
        this.K.updateCustomEmotion(customEmotionData);
        this.K.trimCache();
        this.L.notifyUI(2, true, Integer.valueOf(i3));
        g.a(this.P, i16, i17);
    }

    @Override // com.tencent.mobileqq.pic.ad
    public void q(ad.a aVar) {
        int i3 = 0;
        if (QLog.isColorLevel()) {
            QLog.d("FavEmoSingleSend", 2, "uploadCameraEmoList, ", aVar);
        }
        int i16 = aVar.f258597a;
        if (i16 == 0) {
            QLog.e("FavEmoSingleSend", 1, "uploadCameraEmoList success");
            o("isUpdate", 0, 0, 0);
            EmoticonOperateReport.reportFavAddEmotionEvent(null, 3, aVar.f258603g, null);
        } else if (-1 == i16) {
            QLog.e("FavEmoSingleSend", 1, "uploadCameraEmoList fail,  ret:", Integer.valueOf(aVar.f258598b));
            int i17 = aVar.f258598b;
            int i18 = 7;
            if (400010 == i17) {
                i3 = 7;
                i18 = 6;
            } else if (400011 == i17) {
                i3 = 8;
            } else {
                i18 = 5;
            }
            o("failed", i3, i18, i17);
        }
        synchronized (this.G) {
            this.G.notify();
        }
    }

    @Override // com.tencent.mobileqq.pic.ad
    public void r(ad.a aVar) {
    }
}
