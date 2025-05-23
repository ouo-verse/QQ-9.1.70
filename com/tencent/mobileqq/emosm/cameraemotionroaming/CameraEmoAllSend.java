package com.tencent.mobileqq.emosm.cameraemotionroaming;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.control.EmoAsyncStep;
import com.tencent.mobileqq.emosm.control.EmoLinearGroup;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend;
import com.tencent.mobileqq.emosm.r;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CameraEmoAllSend extends EmoLinearGroup implements kb1.b {
    public static boolean R = false;
    public static boolean S = false;
    private List<CustomEmotionBase> K;
    private boolean L = false;
    private int M;
    private int N;
    private int P;
    private int Q;

    @Override // kb1.b
    public void a(EmoAsyncStep emoAsyncStep, int i3) {
        if (this.L && (emoAsyncStep instanceof FavEmoSingleSend) && ((FavEmoSingleSend) emoAsyncStep).P) {
            this.N++;
        }
    }

    @Override // com.tencent.mobileqq.emosm.control.EmoLinearGroup, com.tencent.mobileqq.emosm.control.EmoAsyncStep
    protected int e() {
        if (!this.K.isEmpty()) {
            Iterator<CustomEmotionBase> it = this.K.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CustomEmotionBase next = it.next();
                if (this.f204258e == 8) {
                    if (QLog.isColorLevel()) {
                        QLog.d("CameraEmoAllSend", 1, "doStep interrupted, index:", Integer.valueOf(this.K.indexOf(next)));
                    }
                } else {
                    EmoAsyncStep o16 = o(next);
                    if (o16 != null) {
                        o16.run();
                    }
                }
            }
            if (this.L) {
                p(this.M, this.K.size(), this.N, this.P, this.Q);
                return 7;
            }
            return 7;
        }
        return 7;
    }

    @Override // com.tencent.mobileqq.emosm.control.EmoStepGroup, com.tencent.mobileqq.emosm.control.EmoAsyncStep
    public void f() {
        List<CustomEmotionBase> list = (List) this.E[0];
        this.K = list;
        if (!list.isEmpty()) {
            if (this.K.get(0) instanceof CameraEmotionData) {
                R = false;
            } else if (this.K.get(0) instanceof CustomEmotionData) {
                S = false;
                this.L = true;
                this.M = ((Integer) this.E[1]).intValue();
                this.P = ((Integer) this.E[2]).intValue();
                this.Q = ((Integer) this.E[3]).intValue();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("CameraEmoAllSend", 1, "onCreate, size:", Integer.valueOf(this.K.size()));
        }
    }

    public EmoAsyncStep o(CustomEmotionBase customEmotionBase) {
        if (customEmotionBase instanceof CameraEmotionData) {
            return new CameraEmoSingleSend((CameraEmotionData) customEmotionBase, false);
        }
        if (customEmotionBase instanceof CustomEmotionData) {
            FavEmoSingleSend favEmoSingleSend = new FavEmoSingleSend((CustomEmotionData) customEmotionBase, false);
            favEmoSingleSend.f204257d = this;
            return favEmoSingleSend;
        }
        return null;
    }

    public void p(int i3, int i16, int i17, int i18, int i19) {
        int i26;
        r rVar = (r) ((BaseQQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(FavEmoRoamingHandler.f194632e);
        if (i17 >= i16 && (i18 <= 0 || i19 <= 0)) {
            if (i18 > 0) {
                if (i18 == i3) {
                    i26 = 1;
                } else {
                    i26 = 2;
                }
            } else if (i19 > 0) {
                if (i19 == i3) {
                    i26 = 3;
                } else {
                    i26 = 4;
                }
            } else {
                i26 = 0;
            }
        } else if (i17 == 0) {
            i26 = 5;
        } else {
            i26 = 6;
        }
        rVar.notifyUI(2, false, Integer.valueOf(i26));
    }
}
