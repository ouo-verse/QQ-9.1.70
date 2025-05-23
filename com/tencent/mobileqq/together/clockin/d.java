package com.tencent.mobileqq.together.clockin;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.util.WeakReference;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7$SignInStatusBase;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7$SignInStatusDoneInfo;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7$SignInStatusNotInfo;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7$SignInStatusYesterdayFirst;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7$StSignInStatusRsp;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7$StSignInWriteRsp;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private Context f293355a;

    /* renamed from: b, reason: collision with root package name */
    private FrameLayout f293356b;

    /* renamed from: c, reason: collision with root package name */
    private c f293357c;

    /* renamed from: d, reason: collision with root package name */
    private NoClockInView f293358d;

    /* renamed from: e, reason: collision with root package name */
    private HasClockView f293359e;

    /* renamed from: f, reason: collision with root package name */
    private f f293360f;

    /* renamed from: g, reason: collision with root package name */
    private RelativeLayout f293361g;

    /* renamed from: h, reason: collision with root package name */
    private LottieAnimationView f293362h;

    /* renamed from: j, reason: collision with root package name */
    private int f293364j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.mobileqq.together.clockin.b f293365k = new a();

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.mobileqq.troop.clockin.api.b f293366l = new b(this);

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.together.clockin.a f293363i = new com.tencent.mobileqq.together.clockin.a();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements com.tencent.mobileqq.together.clockin.b {
        a() {
        }

        @Override // com.tencent.mobileqq.together.clockin.b
        public void a() {
            d.this.f();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class b extends com.tencent.mobileqq.troop.clockin.api.b {

        /* renamed from: h, reason: collision with root package name */
        private WeakReference<d> f293368h;

        public b(d dVar) {
            this.f293368h = new WeakReference<>(dVar);
        }

        @Override // com.tencent.mobileqq.troop.clockin.api.b
        protected void a(boolean z16, String str, String str2, Object obj, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("ClockInViewHelper", 2, "onGetClockInStatus isSucc = " + z16 + ", troopUin = " + str + ", memberUin = " + str2);
            }
            if (this.f293368h.get() != null) {
                this.f293368h.get().h(z16, str, str2, obj, i3);
            }
        }

        @Override // com.tencent.mobileqq.troop.clockin.api.b
        protected void b(boolean z16, String str, String str2, Object obj) {
            if (QLog.isColorLevel()) {
                QLog.d("ClockInViewHelper", 2, "onSetClockInStatus isSucc = " + z16 + ", troopUin = " + str + ", memberUin = " + str2);
            }
            if (this.f293368h.get() != null) {
                this.f293368h.get().g(z16, str, str2, obj);
            }
        }
    }

    public d(QQAppInterface qQAppInterface, Context context, c cVar, FrameLayout frameLayout, RelativeLayout relativeLayout, LottieAnimationView lottieAnimationView, int i3) {
        c cVar2;
        this.f293364j = 1;
        this.f293355a = context;
        this.f293356b = frameLayout;
        this.f293357c = cVar;
        this.f293361g = relativeLayout;
        this.f293362h = lottieAnimationView;
        this.f293364j = i3;
        if (TroopUtils.f() != null) {
            TroopUtils.f().addObserver(this.f293366l);
            com.tencent.mobileqq.troop.clockin.api.a aVar = (com.tencent.mobileqq.troop.clockin.api.a) TroopUtils.f().getBusinessHandler(BusinessHandlerFactory.TROOP_CLOCKIN_HANDLER);
            if (aVar != null && (cVar2 = this.f293357c) != null && !TextUtils.isEmpty(cVar2.f293338a)) {
                aVar.B2(this.f293357c.f293338a, TroopUtils.f().getCurrentAccountUin(), 2);
            }
        }
    }

    private boolean d() {
        if (TroopUtils.f() != null && this.f293355a != null && this.f293356b != null && this.f293357c != null && this.f293361g != null && this.f293362h != null && this.f293363i != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.tencent.mobileqq.troop.clockin.api.a aVar;
        c cVar;
        View findViewById;
        if (QLog.isColorLevel()) {
            QLog.d("ClockInViewHelper", 2, "handleClockInBtnClick");
        }
        FrameLayout frameLayout = this.f293356b;
        if (frameLayout != null && (findViewById = frameLayout.findViewById(R.id.ef9)) != null) {
            findViewById.setVisibility(8);
        }
        if (TroopUtils.f() != null && (aVar = (com.tencent.mobileqq.troop.clockin.api.a) TroopUtils.f().getBusinessHandler(BusinessHandlerFactory.TROOP_CLOCKIN_HANDLER)) != null && (cVar = this.f293357c) != null && !TextUtils.isEmpty(cVar.f293338a)) {
            aVar.s0(this.f293357c.f293338a, TroopUtils.f().getCurrentAccountUin());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("op_via", "1");
        c cVar2 = this.f293357c;
        if (cVar2 != null && !TextUtils.isEmpty(cVar2.f293338a)) {
            hashMap.put("qq_group_num", this.f293357c.f293338a);
        }
        if (TroopUtils.f() != null && !TextUtils.isEmpty(TroopUtils.f().getCurrentAccountUin())) {
            hashMap.put("A8", TroopUtils.f().getCurrentAccountUin());
        }
        ClockReportUtil.a("click#aio_front_panel", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z16, String str, String str2, Object obj) {
        Context context;
        if (this.f293357c != null && TroopUtils.f() != null) {
            if (obj != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(this.f293357c.f293338a) && str2.equals(TroopUtils.f().getCurrentAccountUin())) {
                if (!z16 && (context = this.f293355a) != null) {
                    QQToast.makeText(context, 1, HardCodeUtil.qqStr(R.string.f2058556q), 0).show();
                    return;
                }
                if (obj instanceof oidb_0xeb7$StSignInWriteRsp) {
                    oidb_0xeb7$StSignInWriteRsp oidb_0xeb7_stsigninwritersp = (oidb_0xeb7$StSignInWriteRsp) obj;
                    oidb_0xeb7$SignInStatusDoneInfo oidb_0xeb7_signinstatusdoneinfo = oidb_0xeb7_stsigninwritersp.doneInfo.get();
                    c cVar = this.f293357c;
                    cVar.f293339b = true;
                    if (oidb_0xeb7_signinstatusdoneinfo != null) {
                        cVar.f293348k = oidb_0xeb7_signinstatusdoneinfo.leftTitleWrod.get();
                        this.f293357c.f293351n = oidb_0xeb7_signinstatusdoneinfo.rightDescWord.get();
                        this.f293357c.f293352o = oidb_0xeb7_signinstatusdoneinfo.recordUrl.get();
                        List<String> list = oidb_0xeb7_signinstatusdoneinfo.belowPortraitWords.get();
                        if (list != null && list.size() > 1) {
                            this.f293357c.f293350m = list.get(0);
                            if (!TextUtils.isEmpty(list.get(1))) {
                                this.f293357c.f293349l = Long.valueOf(list.get(1)).longValue();
                            }
                        }
                    }
                    if (oidb_0xeb7_stsigninwritersp.groupScore.has()) {
                        this.f293357c.f293353p = oidb_0xeb7_stsigninwritersp.groupScore.get().scoreUrl.get();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ClockInViewHelper", 2, "handleClockResp play anim ANIM_NOCLOCKIN_ROTATE_START");
                    }
                    com.tencent.mobileqq.together.clockin.a aVar = this.f293363i;
                    if (aVar != null) {
                        aVar.b(1);
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ClockInViewHelper", 2, "handleClockResp data not match");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ClockInViewHelper", 2, "handleClockResp data || app null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z16, String str, String str2, Object obj, int i3) {
        if (this.f293357c != null && TroopUtils.f() != null) {
            if (obj != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(this.f293357c.f293338a) && str2.equals(TroopUtils.f().getCurrentAccountUin()) && i3 == 2) {
                if (!z16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ClockInViewHelper", 2, "handleGetClockDataRsp data isSuccess false");
                        FrameLayout frameLayout = this.f293356b;
                        if (frameLayout != null) {
                            frameLayout.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (obj instanceof oidb_0xeb7$StSignInStatusRsp) {
                    o((oidb_0xeb7$StSignInStatusRsp) obj);
                    l();
                    FrameLayout frameLayout2 = this.f293356b;
                    if (frameLayout2 != null) {
                        frameLayout2.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ClockInViewHelper", 2, "handleGetClockDataRsp data not match");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ClockInViewHelper", 2, "handleGetClockDataRsp data || app null");
        }
    }

    private void i() {
        if (this.f293359e == null) {
            this.f293359e = new HasClockView(this.f293355a, TroopUtils.f(), this.f293356b, this.f293357c, this.f293365k, this.f293363i);
        }
    }

    private void j() {
        if (this.f293360f == null) {
            this.f293360f = new f(this.f293362h, this.f293361g, this.f293355a, this.f293363i, this.f293357c);
        }
    }

    private void k() {
        if (this.f293358d == null) {
            this.f293358d = new NoClockInView(this.f293355a, TroopUtils.f(), this.f293356b, this.f293357c, this.f293365k, this.f293363i);
        }
    }

    private void o(oidb_0xeb7$StSignInStatusRsp oidb_0xeb7_stsigninstatusrsp) {
        oidb_0xeb7$SignInStatusYesterdayFirst oidb_0xeb7_signinstatusyesterdayfirst;
        oidb_0xeb7$SignInStatusNotInfo oidb_0xeb7_signinstatusnotinfo;
        oidb_0xeb7$SignInStatusDoneInfo oidb_0xeb7_signinstatusdoneinfo;
        boolean z16;
        oidb_0xeb7$SignInStatusBase oidb_0xeb7_signinstatusbase = oidb_0xeb7_stsigninstatusrsp.base.get();
        this.f293357c.f293344g = oidb_0xeb7_stsigninstatusrsp.mantleUrl.get();
        this.f293357c.f293354q = oidb_0xeb7_stsigninstatusrsp.backgroundUrl.get();
        if (oidb_0xeb7_signinstatusbase != null) {
            c cVar = this.f293357c;
            if (oidb_0xeb7_signinstatusbase.status.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            cVar.f293339b = z16;
        }
        c cVar2 = this.f293357c;
        if (cVar2.f293339b) {
            cVar2.f293340c = false;
            if (this.f293364j == 1) {
                HashMap hashMap = new HashMap();
                hashMap.put("op_via", "2");
                hashMap.put("A8", TroopUtils.f().getCurrentAccountUin());
                hashMap.put("qq_group_num", this.f293357c.f293338a);
                ClockReportUtil.a("click#aio_icon", hashMap);
            }
            if (oidb_0xeb7_stsigninstatusrsp.doneInfo.has() && (oidb_0xeb7_signinstatusdoneinfo = oidb_0xeb7_stsigninstatusrsp.doneInfo.get()) != null) {
                this.f293357c.f293348k = oidb_0xeb7_signinstatusdoneinfo.leftTitleWrod.get();
                this.f293357c.f293351n = oidb_0xeb7_signinstatusdoneinfo.rightDescWord.get();
                List<String> list = oidb_0xeb7_signinstatusdoneinfo.belowPortraitWords.get();
                if (list.size() > 1) {
                    this.f293357c.f293350m = list.get(0);
                    this.f293357c.f293349l = Long.parseLong(list.get(1));
                }
                this.f293357c.f293352o = oidb_0xeb7_signinstatusdoneinfo.recordUrl.get();
                return;
            }
            return;
        }
        if (this.f293364j == 1) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("op_via", "1");
            hashMap2.put("A8", TroopUtils.f().getCurrentAccountUin());
            hashMap2.put("qq_group_num", this.f293357c.f293338a);
            ClockReportUtil.a("click#aio_icon", hashMap2);
        }
        if (oidb_0xeb7_stsigninstatusrsp.notInfo.has() && (oidb_0xeb7_signinstatusnotinfo = oidb_0xeb7_stsigninstatusrsp.notInfo.get()) != null) {
            this.f293357c.f293347j = oidb_0xeb7_signinstatusnotinfo.buttonWord.get();
            this.f293357c.f293345h = oidb_0xeb7_signinstatusnotinfo.signDescWordLeft.get();
            this.f293357c.f293346i = oidb_0xeb7_signinstatusnotinfo.signDescWordRight.get();
        }
        if (oidb_0xeb7_stsigninstatusrsp.yesterday.has() && (oidb_0xeb7_signinstatusyesterdayfirst = oidb_0xeb7_stsigninstatusrsp.yesterday.get()) != null) {
            this.f293357c.f293341d = oidb_0xeb7_signinstatusyesterdayfirst.yesterdayFirstUid.get();
            this.f293357c.f293343f = oidb_0xeb7_signinstatusyesterdayfirst.yesterdayNick.get();
            this.f293357c.f293342e = oidb_0xeb7_signinstatusyesterdayfirst.yesterdayWord.get();
        }
    }

    public void e() {
        NoClockInView noClockInView = this.f293358d;
        if (noClockInView != null) {
            noClockInView.g();
            this.f293358d = null;
        }
        HasClockView hasClockView = this.f293359e;
        if (hasClockView != null) {
            hasClockView.m();
            this.f293359e = null;
        }
        f fVar = this.f293360f;
        if (fVar != null) {
            fVar.d();
        }
        this.f293365k = null;
        com.tencent.mobileqq.together.clockin.a aVar = this.f293363i;
        if (aVar != null) {
            aVar.deleteObservers();
        }
        if (this.f293366l != null) {
            TroopUtils.f().removeObserver(this.f293366l);
        }
    }

    public void l() {
        if (!d()) {
            if (QLog.isColorLevel()) {
                QLog.d("ClockInViewHelper", 2, "checkData flase");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ClockInViewHelper", 2, "mClockInData : isHasClock = " + this.f293357c.f293339b);
        }
        if (this.f293357c.f293339b) {
            i();
            this.f293359e.r(0);
            return;
        }
        k();
        i();
        j();
        this.f293358d.k(0);
        this.f293359e.r(4);
        this.f293360f.f(8);
    }

    public boolean m() {
        c cVar = this.f293357c;
        if (cVar != null && cVar.f293339b) {
            return true;
        }
        return false;
    }

    public boolean n() {
        com.tencent.mobileqq.together.clockin.a aVar = this.f293363i;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }
}
