package com.tencent.mobileqq.activity.home.chats.biz;

import android.app.Activity;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BrowserBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ComicBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ContactBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.DonDisturbBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.GameBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.GeneralBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MissedCallBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MsgBackupBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NotificationGuideBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.PushBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SecurePhoneChangeNotifyBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SetPwdBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VerifyPhoneBannerProcessor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.identity.IAccountApi;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.os.MqqHandler;

/* loaded from: classes10.dex */
public class BannerPart extends d {
    static IPatchRedirector $redirector_;

    public BannerPart(com.tencent.mobileqq.activity.home.chats.callbcak.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    private void na() {
        BannerManager Y9 = Y9();
        if (Y9 != null && ga()) {
            Y9.D(MissedCallBannerProcessor.f185230d, 2000);
        }
        if (Y9 != null) {
            Message obtain = Message.obtain();
            obtain.what = 2000;
            obtain.getData().putBoolean("rightNow", false);
            Y9.G(ContactBannerProcessor.f185204f, obtain);
            Y9.E(PushBannerProcessor.f185251i, 2000, 5000L);
        }
        if (Y9 != null) {
            Y9.D(SetPwdBannerProcessor.f185270e, 3000);
            Y9.E(SecurePhoneChangeNotifyBannerProcessor.f185269d, 3000, 1000L);
        }
        ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).refreshOnlineStatusDNDBanner();
    }

    private void oa() {
        BannerManager Y9 = Y9();
        if (Y9 != null) {
            Y9.x();
        }
    }

    private void pa() {
        BannerManager Y9 = Y9();
        if (Y9 != null) {
            Y9.y();
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void C9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            super.C9();
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.BannerPart.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BannerPart.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    BannerManager Y9 = BannerPart.this.Y9();
                    if (Y9 != null) {
                        Y9.B(BannerPart.this.ja());
                        Y9.A(-1, null);
                    }
                }
            }, 500L);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void I9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        BannerManager Y9 = Y9();
        if (Y9 != null) {
            Y9.D(VerifyPhoneBannerProcessor.f185283i, 3000);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void J9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            na();
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void O9(@NonNull RecyclerView recyclerView, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) recyclerView, i3);
            return;
        }
        BannerManager Y9 = Y9();
        if (Y9 != null) {
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Y9.z(z16);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void T9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        BannerManager Y9 = Y9();
        if (Y9 == null) {
            return;
        }
        Y9.D(PushBannerProcessor.f185251i, 2000);
        Y9.D(SetPwdBannerProcessor.f185270e, 3000);
        Y9.D(NotificationGuideBannerProcessor.f185237d, 3000);
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d
    public String ea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "BannerPart";
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public boolean handleMessage(@NonNull Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).booleanValue();
        }
        BannerManager Y9 = Y9();
        MqqHandler ca5 = ca();
        if (Y9 == null || ca5 == null) {
            return false;
        }
        switch (message.what) {
            case 1053:
                ma();
                return true;
            case 1077:
                ((IAccountApi) QRoute.api(IAccountApi.class)).onAccountLoginOrSwitch();
                return true;
            case Conversation.MSG_COMIC_BAR_SHOW /* 1134039 */:
                if (ca5.hasMessages(Conversation.MSG_COMIC_BAR_HIDE)) {
                    ca5.removeMessages(Conversation.MSG_COMIC_BAR_HIDE);
                }
                Y9.O(ComicBannerProcessor.f185203d, 2, message);
                return true;
            case Conversation.MSG_COMIC_BAR_HIDE /* 1134040 */:
                Y9.O(ComicBannerProcessor.f185203d, 0, message);
                return true;
            case Conversation.MSG_BROWSER_BAR_SHOW /* 1134041 */:
                if (ca5.hasMessages(Conversation.MSG_BROWSER_BAR_HIDE)) {
                    ca5.removeMessages(Conversation.MSG_BROWSER_BAR_HIDE);
                }
                Y9.O(BrowserBannerProcessor.f185202d, 2, message);
                return true;
            case Conversation.MSG_BROWSER_BAR_HIDE /* 1134042 */:
                Y9.O(BrowserBannerProcessor.f185202d, 0, null);
                return true;
            case Conversation.MSG_GAME_BAR_SHOW /* 1134049 */:
                if (ca5.hasMessages(Conversation.MSG_GAME_BAR_HIDE)) {
                    ca5.removeMessages(Conversation.MSG_GAME_BAR_HIDE);
                }
                Y9.G(GameBannerProcessor.f185210d, Message.obtain(message));
                return true;
            case Conversation.MSG_GAME_BAR_HIDE /* 1134050 */:
                Y9.O(GameBannerProcessor.f185210d, 0, message);
                return true;
            case Conversation.MSG_WIFISECURITY_BAR /* 1134063 */:
                if (QLog.isColorLevel()) {
                    QLog.d("BannerPart", 2, "handler msg MSG_WIFISECURITY_BAR, msg.obj: " + message.obj);
                }
                return true;
            case Conversation.MSG_DON_DISTURB_MSG /* 1134065 */:
                Y9.O(DonDisturbBannerProcessor.f185208d, message.arg1, message);
                return true;
            case Conversation.MSG_MSG_MEMROY_BAR_SHOW /* 1134066 */:
                if (ca5.hasMessages(Conversation.MSG_MSG_MEMROY_BAR_SHOW)) {
                    ca5.removeMessages(Conversation.MSG_MSG_MEMROY_BAR_SHOW);
                }
                Y9.O(MsgBackupBannerProcessor.f185232d, 2, message);
                return true;
            case Conversation.MSG_MSG_MEMROY_BAR_HIDE /* 1134067 */:
                if (ca5.hasMessages(Conversation.MSG_MSG_MEMROY_BAR_HIDE)) {
                    ca5.removeMessages(Conversation.MSG_MSG_MEMROY_BAR_HIDE);
                }
                Y9.O(MsgBackupBannerProcessor.f185232d, 0, message);
                return true;
            case Conversation.MSG_SHOW_GENERAL_BANNER /* 1134200 */:
                Y9.G(GeneralBannerProcessor.f185218f, Message.obtain(message));
                return true;
            case Conversation.MSG_HIDE_GENERAL_BANNER /* 1134201 */:
                if (QLog.isColorLevel()) {
                    QLog.d("Q.recent.banner", 2, "MSG_HIDE_GENERAL_BANNER with: " + message);
                }
                Y9.G(GeneralBannerProcessor.f185218f, Message.obtain(message));
                return true;
            default:
                return false;
        }
    }

    public void ma() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a, mqq.app.IAccountCallback
    public void onAccountChanged(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
            return;
        }
        BannerManager Y9 = Y9();
        if (Y9 != null) {
            Y9.u();
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a, mqq.app.IAccountCallback
    public void onLogout(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) logoutReason);
            return;
        }
        BannerManager Y9 = Y9();
        if (Y9 != null) {
            Y9.O(PushBannerProcessor.f185251i, 0, null);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        BannerManager Y9 = Y9();
        if (Y9 != null) {
            Y9.w(X9());
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
        } else {
            super.onPartPause(activity);
            oa();
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
        } else {
            super.onPartResume(activity);
            pa();
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        BannerManager Y9 = Y9();
        if (Y9 != null) {
            Y9.A(-1, null);
        }
    }
}
