package com.tencent.mobileqq.springhb.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.entry.model.BaseActivityData;
import com.tencent.mobileqq.springhb.entry.model.OnGrabActivityData;
import com.tencent.mobileqq.springhb.entry.worker.d;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements BusinessObserver {
    static IPatchRedirector $redirector_;
    private int[] C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private final d f289463d;

    /* renamed from: e, reason: collision with root package name */
    long f289464e;

    /* renamed from: f, reason: collision with root package name */
    long f289465f;

    /* renamed from: h, reason: collision with root package name */
    long f289466h;

    /* renamed from: i, reason: collision with root package name */
    long f289467i;

    /* renamed from: m, reason: collision with root package name */
    private final Handler f289468m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.springhb.network.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class C8608a implements Handler.Callback {
        static IPatchRedirector $redirector_;

        C8608a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d("SpringHbObserver", 2, "handleMessage ,msg.what =  " + message.what);
            }
            if (message.what == 1) {
                QLog.d("SpringHbObserver", 2, "handleMessage MSG_GRAB_FAKE_EVENT 11");
                a.this.f289463d.k().v0(false, HardCodeUtil.qqStr(R.string.paz), null);
            }
            return false;
        }
    }

    public a(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
            return;
        }
        this.f289464e = -1L;
        this.f289465f = -1L;
        this.f289466h = -1L;
        this.f289467i = 2500L;
        this.f289468m = new Handler(Looper.getMainLooper(), new C8608a());
        this.C = new int[]{10};
        this.D = 0;
        this.f289463d = dVar;
    }

    private long b() {
        return this.f289463d.n().I();
    }

    private boolean d(int i3) {
        boolean z16 = true;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpringHbObserver", 2, "isValidAwardType type = " + i3 + ",result = " + z16);
        }
        return z16;
    }

    public void c(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, i3);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f289465f = -1L;
        this.f289464e = -1L;
        this.f289466h = -1L;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpringHbObserver", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.f289468m.removeCallbacksAndMessages(null);
    }

    public void g(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpringHbObserver", 2, "reportBrushLotteryRequestResult result = " + j3 + ",awardType = " + str);
        }
        HashMap hashMap = new HashMap();
        BaseActivityData j16 = this.f289463d.j();
        if (j16 != null) {
            String str2 = j16.f289093id;
            int i3 = j16.promotionId;
            hashMap.put("active_id", str2);
            hashMap.put("jackpot_id", i3 + "");
            hashMap.put("ext1", str);
            if (QLog.isColorLevel()) {
                QLog.d("SpringHbObserver", 2, "reportBrushLotteryRequestResult activityID = " + str2 + "\uff0cpromotionId = " + i3 + ",awardType = " + str);
            }
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            QLog.d("SpringHbObserver", 2, "updateLastGrabHongbaoRequestTime");
            this.f289464e = b();
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        boolean z17;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpringHbObserver", 2, "onReceive, " + i3 + ", " + z16 + ", " + bundle);
        }
        if (i3 != 1) {
            return;
        }
        int i16 = bundle.getInt("k_id", -1);
        int i17 = bundle.getInt("key_award_id", -1);
        int i18 = bundle.getInt("key_award_type", -1);
        int i19 = bundle.getInt("k_money", -1);
        int i26 = bundle.getInt("key_promotion_id", -1);
        String string = bundle.getString("key_url");
        long j16 = bundle.getLong("key_report_ret_code");
        g(j16, String.valueOf(i18));
        this.f289465f = b();
        if (QLog.isColorLevel()) {
            QLog.d("SpringHbObserver", 2, "onReceive cmd = CMD_RESULT isSuccess = " + z16 + ",awardType = " + i18 + ", lastGrabHongBaoResponseTime = " + this.f289465f + ", portId = " + i16 + ", retCodeForReport = " + j16 + ", packUrl = " + string + ", showType = -1, money = " + i19 + ", awardId = " + i17 + ", promotionId = " + i26);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpringHbObserver", 2, "isSuccess = " + z16 + " isValidAwardType(awardType) = " + d(i18));
        }
        if (this.f289468m.hasMessages(1)) {
            this.f289468m.removeMessages(1);
        }
        if (z16 && d(i18)) {
            z17 = true;
        } else {
            z17 = false;
        }
        String string2 = MobileQQ.sMobileQQ.getResources().getString(R.string.f199564pr);
        BaseActivityData j17 = this.f289463d.j();
        if (j17 instanceof OnGrabActivityData) {
            j3 = (((OnGrabActivityData) j17).playDuration * 1000) - this.f289463d.n().O(j17.f289093id).leftCountDownDuration;
        } else {
            QLog.d("SpringHbObserver", 1, "onReceive grab hongbao result exception , curActivityData = " + j17);
            j3 = -1;
        }
        bundle.putLong("key_current_brush_progress_ms", j3);
        this.f289463d.k().v0(z17, string2, bundle);
    }
}
