package com.tencent.mobileqq.qqlive.room.multichat.view.seat;

import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.room.avchatroom.ILiveAudiencePlayerLiveTypeSwitcher;
import com.tencent.mobileqq.qqlive.room.multichat.store.d;
import com.tencent.mobileqq.qqlive.room.multichat.store.e;
import com.tencent.mobileqq.qqlive.room.multichat.view.seat.MultiAvChatEmptySeatView;
import com.tencent.mobileqq.qqlive.room.multichat.view.seat.MultiAvChatUserInfoView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final IAegisLogApi f271841a;

    /* renamed from: b, reason: collision with root package name */
    private MultiAvChatEmptySeatView f271842b;

    /* renamed from: c, reason: collision with root package name */
    private FrameLayout f271843c;

    /* renamed from: d, reason: collision with root package name */
    private MultiAvChatAudioSeatView f271844d;

    /* renamed from: e, reason: collision with root package name */
    private MultiAvChatUserInfoView f271845e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f271846f;

    /* renamed from: g, reason: collision with root package name */
    private int f271847g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.room.multichat.store.b f271848h;

    /* renamed from: i, reason: collision with root package name */
    private int f271849i;

    /* renamed from: j, reason: collision with root package name */
    private Runnable f271850j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MultiAvChatSeatView multiAvChatSeatView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) multiAvChatSeatView);
            return;
        }
        this.f271841a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.f271847g = -1;
        this.f271848h = new com.tencent.mobileqq.qqlive.room.multichat.store.b();
        this.f271850j = new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.seat.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.g();
            }
        };
        this.f271842b = multiAvChatSeatView.c();
        this.f271843c = multiAvChatSeatView.g();
        this.f271844d = multiAvChatSeatView.b();
        this.f271845e = multiAvChatSeatView.f();
        this.f271846f = multiAvChatSeatView.d();
    }

    private void b() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.f271850j, 1000L);
    }

    private d e(@NonNull e eVar) {
        return eVar.a(c());
    }

    private boolean f(@NonNull e eVar) {
        if (eVar.a(c()) == null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        if (this.f271849i > 3) {
            this.f271841a.e("MultiChatViewModel", "\u8b66\u544a! check2UpdateUserSeatInfo \u5ea7\u4f4d\u53f7 " + this.f271847g + " \u8d85\u8fc7\u6700\u5927\u6b21\u6570\uff0c\u5ea7\u4f4d\u4fe1\u606f\u8fd8\u6ca1\u6709");
            return;
        }
        if (!f(this.f271848h.a())) {
            this.f271849i++;
            b();
            this.f271841a.e("MultiChatViewModel", "\u8b66\u544a! check2UpdateUserSeatInfo \u5ea7\u4f4d\u53f7 " + this.f271847g + " \u8fd8\u672a\u83b7\u53d6\u5230\u5ea7\u4f4d\u4fe1\u606f\uff0c\u5c1d\u8bd5\u6b21\u6570 " + this.f271849i);
            return;
        }
        l(e(this.f271848h.a()));
    }

    private void l(@NonNull d dVar) {
        MultiAvChatUserInfoView.UserType userType;
        MultiAvChatUserInfoView multiAvChatUserInfoView = this.f271845e;
        String str = dVar.f271674f + "";
        if (dVar.f271681m) {
            userType = MultiAvChatUserInfoView.UserType.GOLD_TYPE;
        } else {
            userType = MultiAvChatUserInfoView.UserType.NORMAL_TYPE;
        }
        multiAvChatUserInfoView.setGiftScore(str, userType);
        this.f271845e.setNickName(dVar.f271673e);
        this.f271844d.setHeadUrl(dVar.f271672d);
        k(dVar.f271675g);
        this.f271841a.i("MultiChatViewModel", "\u63d0\u793a!updateUserInfoContainer \u5ea7\u4f4d\u53f7 " + this.f271847g + " \u66f4\u65b0\u5ea7\u4f4d\u7528\u6237\u4fe1\u606f\uff0c" + dVar);
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f271847g;
    }

    public com.tencent.mobileqq.qqlive.room.multichat.store.b d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.qqlive.room.multichat.store.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f271848h;
    }

    public void h(ILiveAudiencePlayerLiveTypeSwitcher.PlayerLiveType playerLiveType) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) playerLiveType);
            return;
        }
        if (playerLiveType == ILiveAudiencePlayerLiveTypeSwitcher.PlayerLiveType.LIVE_NORMAL) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.f271842b.e(z16);
    }

    public void i(ILiveAudiencePlayerLiveTypeSwitcher.PlayerLiveType playerLiveType) {
        MultiAvChatEmptySeatView.EmptySeatType emptySeatType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) playerLiveType);
            return;
        }
        if (playerLiveType == ILiveAudiencePlayerLiveTypeSwitcher.PlayerLiveType.LIVE_NORMAL) {
            emptySeatType = MultiAvChatEmptySeatView.EmptySeatType.Apply;
        } else {
            emptySeatType = MultiAvChatEmptySeatView.EmptySeatType.Invite;
        }
        this.f271842b.setSeatType(emptySeatType);
    }

    public void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else {
            this.f271842b.setSeatName(str);
        }
    }

    public void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f271846f.setVisibility(4);
        } else {
            this.f271846f.setVisibility(0);
        }
        this.f271846f.setText(str);
        j(str);
    }
}
