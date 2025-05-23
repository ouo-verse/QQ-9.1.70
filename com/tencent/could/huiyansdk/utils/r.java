package com.tencent.could.huiyansdk.utils;

import android.os.CountDownTimer;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.entity.CompareResult;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class r extends CountDownTimer {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f100322a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(s sVar, long j3, long j16) {
        super(j3, j16);
        this.f100322a = sVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sVar, Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.could.huiyansdk.callback.f fVar = this.f100322a.f100324b;
        if (fVar != null) {
            com.tencent.could.huiyansdk.fragments.b bVar = (com.tencent.could.huiyansdk.fragments.b) fVar;
            CompareResult compareResult = new CompareResult();
            if (bVar.f100086a.f100058m) {
                compareResult.setErrorCode(222);
                compareResult.setErrorMsg(bVar.f100086a.c().getString(R.string.txy_local_check_out_time));
                k.a.f100197a.a(2, "AuthingFragment", "action time out!");
            } else {
                compareResult.setErrorCode(223);
                compareResult.setErrorMsg(bVar.f100086a.c().getString(R.string.txy_prepare_out_time));
                k.a.f100197a.a(2, "AuthingFragment", "prepare time out!");
            }
            HuiYanSdkImp.getInstance().sendBuriedPointInfo("AuthCheckStage", "AuthLocalFail", "timeOut code: " + compareResult.getErrorCode());
            bVar.f100086a.a((Object) compareResult);
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
            return;
        }
        k.a.f100197a.a(1, "TimeOutHelper", "on tick: " + j3);
        int i3 = (int) ((j3 + 1000) / 1000);
        com.tencent.could.huiyansdk.callback.f fVar = this.f100322a.f100324b;
        if (fVar != null) {
            ((com.tencent.could.huiyansdk.fragments.b) fVar).a(i3);
        }
    }
}
