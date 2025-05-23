package com.tencent.could.huiyansdk.turing;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.could.component.common.ai.utils.TwoTuple;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.base.HuiYanBaseCallBack;
import com.tencent.could.huiyansdk.common.a;
import com.tencent.could.huiyansdk.entity.TuringResultCacheEntity;
import com.tencent.could.huiyansdk.enums.AuthState;
import com.tencent.could.huiyansdk.manager.c;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.utils.CommonUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f100270a;

    public d(f fVar) {
        this.f100270a = fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
        }
    }

    public void a(long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f100270a.f100287p = true;
            if (bArr != null) {
                k.a.f100197a.a(1, "TuringSdkHelper", "return code: " + j3 + ", bytes len: " + bArr.length);
            } else {
                k.a.f100197a.a(1, "TuringSdkHelper", "return code: " + j3 + ", bytes is null");
            }
            this.f100270a.d();
            f.c(this.f100270a, false);
            TuringResultCacheEntity turingResultCacheEntity = this.f100270a.f100277f;
            if (j3 != 0) {
                TwoTuple calculateTuringErrorCode = CommonUtils.calculateTuringErrorCode(j3);
                String str = "Turing retCode: " + j3 + " stage:" + calculateTuringErrorCode.getFirst() + " errCode:" + calculateTuringErrorCode.getSecond();
                this.f100270a.getClass();
                HuiYanSdkImp.getInstance().sendBuriedPointInfo("AuthCheckStage", "GetTuringTokenError", str);
                HuiYanBaseCallBack huiYanBaseCallBack = HuiYanBaseApi.b.f100031a.f100028b;
                if (huiYanBaseCallBack != null) {
                    huiYanBaseCallBack.onOperateTimeEvent("GetTuringTokenUseTime", 2, true, str);
                }
                k.a.f100197a.a(2, "TuringSdkHelper", str);
                TuringResultCacheEntity turingResultCacheEntity2 = this.f100270a.f100277f;
                if (turingResultCacheEntity2 != null) {
                    turingResultCacheEntity2.setTuringEnvErrorStr(str);
                }
                f.b(this.f100270a);
                return;
            }
            HuiYanBaseCallBack huiYanBaseCallBack2 = HuiYanBaseApi.b.f100031a.f100028b;
            if (huiYanBaseCallBack2 != null) {
                huiYanBaseCallBack2.onOperateTimeEvent("GetTuringTokenUseTime", 2, false, "");
            }
            String encodeToString = Base64.encodeToString(bArr, 2);
            TuringResultCacheEntity turingResultCacheEntity3 = this.f100270a.f100277f;
            if (turingResultCacheEntity3 != null) {
                turingResultCacheEntity3.setTuringResultDate(encodeToString);
                k kVar = k.a.f100197a;
                kVar.a(1, "TuringSdkHelper", "turing result cache is not null");
                kVar.a(1, "TuringSdkHelper", "turing result data: " + TextUtils.isEmpty(encodeToString));
            } else {
                k.a.f100197a.a(2, "TuringSdkHelper", "turing result cache is null");
            }
            if (this.f100270a.f100283l) {
                k.a.f100197a.a(2, "TuringSdkHelper", "on get device token has timeout!");
                return;
            }
            if (a.C1019a.f100038a.f100034c && !TextUtils.isEmpty(encodeToString)) {
                HuiYanSdkImp.getInstance().doOnTuringFaceDataSuccess(encodeToString);
                c.b.f100154a.a(AuthState.START_GET_LIVE_TYPE, (Object) null);
            }
            f.b(this.f100270a);
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), bArr);
    }
}
