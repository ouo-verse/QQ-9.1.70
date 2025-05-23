package com.tencent.mobileqq.app;

import MQQ.GetRoamToastRsp;
import QC.AioBubbleRecom$GetAioRecommendRsp;
import QC.FaceRsp;
import QC.SetFontBubbleRsp;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes11.dex */
public class SVIPObserver implements BusinessObserver {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SVIPObserver";

    public SVIPObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void onAuthHiBoom(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), obj);
        }
    }

    public void onBubbleChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    public void onChangeSimpleModeNamePlateSwitch(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        }
    }

    public void onDefaultCardRsp(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), obj);
        }
    }

    public void onFontBubblePaySuccess(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) bundle);
        }
    }

    public void onFriendCloneAuth(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), obj);
        }
    }

    public void onGetBigTroopExpiredInfo(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), obj);
        }
    }

    public void onGetBubbleRecommend(boolean z16, AioBubbleRecom$GetAioRecommendRsp aioBubbleRecom$GetAioRecommendRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), aioBubbleRecom$GetAioRecommendRsp);
        }
    }

    public void onGetColorNickData(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), obj);
        }
    }

    public void onGetFontRecommend(boolean z16, AioBubbleRecom$GetAioRecommendRsp aioBubbleRecom$GetAioRecommendRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), aioBubbleRecom$GetAioRecommendRsp);
        }
    }

    public void onGetRoamToast(boolean z16, GetRoamToastRsp getRoamToastRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), getRoamToastRsp);
        }
    }

    public void onGetRoamType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, i3);
        }
    }

    public void onSetFace(boolean z16, FaceRsp faceRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), faceRsp);
        }
    }

    public void onSetFontBubble(boolean z16, SetFontBubbleRsp setFontBubbleRsp, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), setFontBubbleRsp, Integer.valueOf(i3));
        }
    }

    public void onSetHiBoom(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), obj);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 116) {
            switch (i3) {
                case 100:
                    onVipStatusChanged();
                    return;
                case 101:
                    if (obj instanceof Integer) {
                        onBubbleChanged(((Integer) obj).intValue());
                        return;
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "NOTIFY_TYPE_SVIP_BUBBLE_CHANGE param error");
                            return;
                        }
                        return;
                    }
                case 102:
                    onAuthHiBoom(z16, obj);
                    return;
                case 103:
                    onSetHiBoom(z16, obj);
                    return;
                case 104:
                    onFriendCloneAuth(z16, obj);
                    return;
                case 105:
                    onGetColorNickData(z16, obj);
                    return;
                default:
                    onUpdateContinue1(i3, z16, obj);
                    return;
            }
        }
        onYellowVipStatusChanged();
    }

    public void onUpdateContinue1(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        AioBubbleRecom$GetAioRecommendRsp aioBubbleRecom$GetAioRecommendRsp = null;
        switch (i3) {
            case 106:
                onDefaultCardRsp(z16, obj);
                return;
            case 107:
                if (obj != null) {
                    aioBubbleRecom$GetAioRecommendRsp = (AioBubbleRecom$GetAioRecommendRsp) obj;
                }
                onGetFontRecommend(z16, aioBubbleRecom$GetAioRecommendRsp);
                return;
            case 108:
                if (obj != null) {
                    aioBubbleRecom$GetAioRecommendRsp = (AioBubbleRecom$GetAioRecommendRsp) obj;
                }
                onGetBubbleRecommend(z16, aioBubbleRecom$GetAioRecommendRsp);
                return;
            case 109:
                Object[] objArr = (Object[]) obj;
                onSetFontBubble(z16, (SetFontBubbleRsp) objArr[0], ((Integer) objArr[1]).intValue());
                return;
            case 110:
                onFontBubblePaySuccess((Bundle) obj);
                return;
            case 111:
                onGetRoamToast(z16, (GetRoamToastRsp) obj);
                return;
            case 112:
                onSetFace(z16, (FaceRsp) obj);
                return;
            case 113:
                onGetBigTroopExpiredInfo(z16, obj);
                return;
            case 114:
                Object[] objArr2 = (Object[]) obj;
                onGetRoamType((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                return;
            case 115:
                onChangeSimpleModeNamePlateSwitch(z16);
                return;
            default:
                return;
        }
    }

    public void onVipStatusChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public void onYellowVipStatusChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
