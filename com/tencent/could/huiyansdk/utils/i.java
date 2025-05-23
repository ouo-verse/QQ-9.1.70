package com.tencent.could.huiyansdk.utils;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.could.component.common.ai.log.AiLog;
import com.tencent.could.component.common.ai.net.IJsonDataListener;
import com.tencent.could.huiyansdk.api.HuiYanAuthImp;
import com.tencent.could.huiyansdk.api.HuiYanSdk;
import com.tencent.could.huiyansdk.entity.LiveTypeResult;
import com.tencent.could.huiyansdk.entity.TuringResultCacheEntity;
import com.tencent.could.huiyansdk.enums.HuiYanPublicEvent;
import com.tencent.could.huiyansdk.manager.d;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.operate.HuiYanOperateBody;
import com.tencent.could.huiyansdk.operate.c;
import com.tencent.could.huiyansdk.turing.f;
import com.tencent.could.huiyansdk.utils.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class i implements IJsonDataListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Gson f100305a;

    public i(Gson gson) {
        this.f100305a = gson;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) gson);
        }
    }

    @Override // com.tencent.could.component.common.ai.net.IJsonDataListener
    public void onFailed(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        k.a.f100197a.a(1, "HuiYanSenderHelper", "get live type, errmsg: " + str);
        e.b("onFail: " + str);
        e.a();
    }

    @Override // com.tencent.could.component.common.ai.net.IJsonDataListener
    public void onSuccess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        com.tencent.could.huiyansdk.manager.k kVar = k.a.f100197a;
        kVar.a(2, "HuiYanSenderHelper", "get live type! on success: " + str);
        LiveTypeResult liveTypeResult = (LiveTypeResult) this.f100305a.fromJson(str, LiveTypeResult.class);
        if (liveTypeResult == null) {
            e.a();
            kVar.a(2, "HuiYanSenderHelper", "get live type request, result is null!");
            e.b("result == null");
            return;
        }
        if (liveTypeResult.getErrorCode() == 0) {
            try {
                d.b.f100161a.a("AuthCheckStage", "GetLiveTypeSuccess", "");
                com.tencent.could.huiyansdk.operate.c cVar = c.b.f100258a;
                cVar.a("GetLiveTypeDateUseTime", 2, false, "");
                HuiYanOperateBody huiYanOperateBody = cVar.f100252a;
                if (huiYanOperateBody != null) {
                    huiYanOperateBody.updateInfo("GetLiveTypeData", 1, 1L, System.currentTimeMillis());
                }
                String a16 = e.a(liveTypeResult);
                cVar.a("LocalCheckUseTime", 1, false, "");
                com.tencent.could.huiyansdk.turing.f fVar = f.a.f100288a;
                boolean isNeedVideo = liveTypeResult.isNeedVideo();
                TuringResultCacheEntity turingResultCacheEntity = fVar.f100277f;
                if (turingResultCacheEntity != null) {
                    turingResultCacheEntity.setNeedFrameCheck(isNeedVideo);
                }
                fVar.a(liveTypeResult.getExtraParams());
                HuiYanAuthImp.getInstance().setTuringActiveParam(liveTypeResult.getExtraParams());
                HuiYanAuthImp.getInstance().sendPublicEvent(HuiYanPublicEvent.START_CHECK);
                HuiYanSdk.startNextStepByLight(a16);
                String encryptPubKey = liveTypeResult.getEncryptPubKey();
                if (TextUtils.isEmpty(encryptPubKey)) {
                    return;
                }
                HuiYanAuthImp.getInstance().setPubKey(encryptPubKey);
                return;
            } catch (JSONException e16) {
                l lVar = l.a.f100309a;
                String str2 = "createLiveResultString error: " + e16.getLocalizedMessage();
                if (lVar.f100307a) {
                    AiLog.error("HuiYanSenderHelper", str2);
                }
                e.b("exception :" + e16.getLocalizedMessage());
                e.a();
                return;
            }
        }
        e.b(liveTypeResult.getErrorMsg());
        HuiYanSdk.showErrorDialog(liveTypeResult.getErrorCode(), liveTypeResult.getErrorMsg());
    }
}
