package com.tencent.could.huiyansdk.turing;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.callback.g;
import com.tencent.could.huiyansdk.common.a;
import com.tencent.could.huiyansdk.entity.CompareResult;
import com.tencent.could.huiyansdk.entity.TuringResultCacheEntity;
import com.tencent.could.huiyansdk.enums.AuthState;
import com.tencent.could.huiyansdk.manager.c;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends Handler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f100271a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, Looper looper) {
        super(looper);
        this.f100271a = fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar, (Object) looper);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            return;
        }
        if (this.f100271a.f100274c) {
            k.a.f100197a.a(2, "TuringSdkHelper", "isEndPreView is true do not need set camera data");
            return;
        }
        int i3 = message.what;
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 5) {
                    k.a.f100197a.a(2, "TuringSdkHelper", "error event");
                    return;
                }
                k.a.f100197a.a(1, "TuringSdkHelper", "turing face timeout " + this.f100271a.f100272a);
                TuringResultCacheEntity turingResultCacheEntity = this.f100271a.f100277f;
                if (turingResultCacheEntity != null) {
                    turingResultCacheEntity.setTuringEnvErrorStr("EnvRiskData timeout with: " + this.f100271a.f100272a + " ms");
                }
                this.f100271a.f100283l = true;
                if (a.C1019a.f100038a.f100034c) {
                    HuiYanSdkImp.getInstance().doOnTuringFaceDataSuccess("");
                    c.b.f100154a.a(AuthState.START_GET_LIVE_TYPE, (Object) null);
                }
                f.b(this.f100271a);
                f.c(this.f100271a, true);
                return;
            }
            k kVar = k.a.f100197a;
            kVar.a(1, "TuringSdkHelper", "wait frame image check is time out");
            f fVar = this.f100271a;
            fVar.getClass();
            kVar.a(1, "TuringSdkHelper", "remove compare check all listener");
            g gVar = fVar.f100280i;
            if (gVar == null) {
                kVar.a(1, "TuringSdkHelper", "do not need waiting turing!");
                return;
            }
            ((c.a) gVar).a();
            fVar.f100280i = null;
            if (fVar.f100285n != null) {
                fVar.f100285n.removeMessages(4);
                return;
            }
            return;
        }
        this.f100271a.getClass();
        CompareResult compareResult = new CompareResult();
        compareResult.setErrorCode(213);
        Context resContext = HuiYanSdkImp.getInstance().getResContext();
        if (resContext == null) {
            str = resContext.getResources().getString(R.string.txy_check_get_frame_error);
        } else {
            str = "\u6444\u50cf\u5934\u83b7\u53d6\u6570\u636e\u5931\u8d25\uff0c\u8bf7\u8fd4\u56de\u91cd\u8bd5\uff01";
        }
        compareResult.setErrorMsg(str);
        k.a.f100197a.a(2, "TuringSdkHelper", "event call for first frame time out!!!");
        c.b.f100154a.a(AuthState.AUTH_ERROR_DIALOG, compareResult);
    }
}
