package com.tencent.mobileqq.qqlive.room.prepare;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRealNameAuthCallback;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRoomSettingCallback;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveSetRoomSettingCallback;
import com.tencent.mobileqq.qqlive.callback.game.IQQLiveGameListCallback;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class g extends com.tencent.mobileqq.mvvm.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private IQQLiveSDK f271946a;

    /* renamed from: b, reason: collision with root package name */
    SharedPreferences f271947b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f271948c;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements IQQLiveGameListCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f271949a;

        a(c cVar) {
            this.f271949a = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this, (Object) cVar);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.game.IQQLiveGameListCallback
        public void onError(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            } else {
                this.f271949a.onFailed(i3, str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.game.IQQLiveGameListCallback
        public void onSuccess(ArrayList<QQLiveAnchorRoomGameInfo> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<QQLiveAnchorRoomGameInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                QQLiveAnchorRoomGameInfo next = it.next();
                com.tencent.mobileqq.qqlive.room.prepare.a aVar = new com.tencent.mobileqq.qqlive.room.prepare.a();
                aVar.c(next.f271211id);
                aVar.e(next.name);
                aVar.d(next.icon);
                aVar.f(next.secondTagId);
                arrayList2.add(aVar);
            }
            this.f271949a.a(arrayList2);
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f271948c = false;
            n();
        }
    }

    public void j(int i3, IQQLiveGetRealNameAuthCallback iQQLiveGetRealNameAuthCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) iQQLiveGetRealNameAuthCallback);
            return;
        }
        IQQLiveSDK iQQLiveSDK = this.f271946a;
        if (iQQLiveSDK != null) {
            iQQLiveSDK.getQQLiveVerifyModule().getRealNameAuthState(i3, iQQLiveGetRealNameAuthCallback);
        }
    }

    public void k(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
            return;
        }
        IQQLiveSDK iQQLiveSDK = this.f271946a;
        if (iQQLiveSDK != null) {
            iQQLiveSDK.getGameListService().getGameList(new a(cVar));
        }
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f271948c;
    }

    public void m(long j3, IQQLiveGetRoomSettingCallback iQQLiveGetRoomSettingCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), iQQLiveGetRoomSettingCallback);
        } else {
            this.f271946a.getAnchorModule().getRoomSetting(j3, iQQLiveGetRoomSettingCallback);
        }
    }

    protected void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f271946a = com.tencent.mobileqq.qqlive.base.sdk.a.c(null);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.f271947b = waitAppRuntime.getApplicationContext().getSharedPreferences("QQLivePrepare" + waitAppRuntime.getCurrentUin(), 0);
    }

    public void o(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.f271948c = z16;
        }
    }

    public void p(long j3, boolean z16, IQQLiveSetRoomSettingCallback iQQLiveSetRoomSettingCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), Boolean.valueOf(z16), iQQLiveSetRoomSettingCallback);
        } else {
            this.f271946a.getAnchorModule().setRoomSetting(j3, z16, iQQLiveSetRoomSettingCallback);
        }
    }
}
