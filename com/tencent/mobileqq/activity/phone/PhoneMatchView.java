package com.tencent.mobileqq.activity.phone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.config.a;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.phonecontact.util.PhoneContactUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes10.dex */
public class PhoneMatchView extends BaseActivityView implements View.OnClickListener, Handler.Callback {
    static IPatchRedirector $redirector_;
    private Button N;
    com.tencent.mobileqq.phonecontact.observer.b P;
    private Handler Q;

    public PhoneMatchView(Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
        } else {
            this.Q = new WeakReferenceHandler(Looper.getMainLooper(), this);
            m(R.layout.f168021p7, true);
        }
    }

    private void y() {
        if (!NetworkUtil.isNetSupport(getContext())) {
            r(R.string.cjm);
            return;
        }
        PermissionChecker.e(this.f183718i, new Runnable() { // from class: com.tencent.mobileqq.activity.phone.PhoneMatchView.1
            static IPatchRedirector $redirector_;

            /* renamed from: com.tencent.mobileqq.activity.phone.PhoneMatchView$1$a */
            /* loaded from: classes10.dex */
            class a extends com.tencent.mobileqq.phonecontact.observer.b {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // com.tencent.mobileqq.phonecontact.observer.b
                protected void onUpdateContact(boolean z16, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                    } else {
                        PhoneMatchView.this.z(z16, i3, "onUpdateContact");
                    }
                }

                @Override // com.tencent.mobileqq.phonecontact.observer.b
                protected void onUpdateContactNotBind(boolean z16, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                    } else {
                        PhoneMatchView.this.z(z16, i3, "onUpdateContactNotBind");
                    }
                }

                @Override // com.tencent.mobileqq.phonecontact.observer.b
                protected void onUploadContact(boolean z16, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                    } else {
                        PhoneMatchView.this.z(z16, i3, "onUploadContact");
                    }
                }

                @Override // com.tencent.mobileqq.phonecontact.observer.b
                protected void onUploadContactNotBind(boolean z16, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                    } else {
                        PhoneMatchView.this.z(z16, i3, "onUploadContactNotBind");
                    }
                }
            }

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneMatchView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                PhoneMatchView.this.q(R.string.hex, 1000L, true);
                PhoneMatchView.this.Q.sendEmptyMessageDelayed(0, 15000L);
                PhoneMatchView phoneMatchView = PhoneMatchView.this;
                if (phoneMatchView.P == null) {
                    phoneMatchView.P = new a();
                    PhoneMatchView phoneMatchView2 = PhoneMatchView.this;
                    phoneMatchView2.f183714d.registObserver(phoneMatchView2.P);
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.phone.PhoneMatchView.1.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        IPhoneContactService iPhoneContactService = (IPhoneContactService) PhoneMatchView.this.f183714d.getRuntimeService(IPhoneContactService.class, "");
                        iPhoneContactService.uploadOrUpdateContact();
                        iPhoneContactService.setNeedUploadResultTip(true);
                    }
                }, 16, null, false);
            }
        }, new DenyRunnable(this.f183718i, new DenyRunnable.a(this.f183714d)));
    }

    @Override // com.tencent.mobileqq.activity.phone.BaseActivityView
    public void g(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.g(i3, i16, intent);
        if (i3 == 1 && i16 != 0) {
            if (i16 == 2) {
                Intent intent2 = new Intent(getContext(), (Class<?>) BindNumberActivity.class);
                intent2.putExtra("kNeedUnbind", true);
                t(intent2);
                return;
            }
            t(new Intent(getContext(), (Class<?>) PhoneLaunchActivity.class));
            return;
        }
        if (i3 == 9999) {
            if (QLog.isColorLevel()) {
                QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
            }
            if (((IPhoneContactService) this.f183714d.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true) && (getContext() instanceof Activity)) {
                Activity activity = (Activity) getContext();
                ContactBindedActivity.U2(this.f183714d, -1, 2, null);
                activity.setResult(-1);
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.phone.BaseActivityView
    public void h(Intent intent, PhoneInnerFrame phoneInnerFrame) {
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) phoneInnerFrame);
            return;
        }
        super.h(intent, phoneInnerFrame);
        com.tencent.mobileqq.newfriend.config.a loadNewFriendContactGuideConfig = ((INewFriendApi) QRoute.api(INewFriendApi.class)).loadNewFriendContactGuideConfig();
        if (PermissionChecker.h().g()) {
            a.C8157a c8157a = loadNewFriendContactGuideConfig.f254000d;
            str = c8157a.f254005a;
            str2 = c8157a.f254006b;
            str3 = c8157a.f254007c;
        } else {
            a.C8157a c8157a2 = loadNewFriendContactGuideConfig.f253999c;
            str = c8157a2.f254005a;
            str2 = c8157a2.f254006b;
            str3 = c8157a2.f254007c;
        }
        ((TextView) c(R.id.b85)).setText(str);
        ((TextView) c(R.id.f164891b84)).setText(str2);
        Button button = (Button) c(R.id.f164889b82);
        this.N = button;
        button.setOnClickListener(this);
        this.N.setText(str3);
        View c16 = c(R.id.e2a);
        if (c16 != null && "1000".equals(ThemeUtil.curThemeId)) {
            c16.setBackgroundResource(R.drawable.f160540jm);
        } else if (c16 != null) {
            c16.setBackgroundResource(R.drawable.bg_texture);
        }
        PhoneContactUtils.b(this.f183714d, getResources(), (ImageView) c(R.id.f164890b83));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 0) {
            int selfBindState = ((IPhoneContactService) this.f183714d.getRuntimeService(IPhoneContactService.class, "")).getSelfBindState();
            if (selfBindState != 2 && selfBindState != 4 && selfBindState != 9 && selfBindState != 8) {
                z(false, -1, "MSG_TIME_OUT");
            } else {
                z(true, 0, "MSG_TIME_OUT");
            }
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else if (view == this.N) {
            y();
        } else {
            u(new Intent(getContext(), (Class<?>) SettingActivity2.class), 1);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.phone.BaseActivityView
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onStart();
        this.I.setText(HardCodeUtil.qqStr(R.string.p2z));
        int i3 = this.f183719m;
        if (i3 == 2) {
            this.H.setVisibility(4);
            this.H.setText(R.string.f171163ct0);
        } else if (i3 == 3) {
            this.H.setVisibility(8);
        } else {
            this.H.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.phone.BaseActivityView
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.phonecontact.observer.b bVar = this.P;
        if (bVar != null) {
            this.f183714d.unRegistObserver(bVar);
            this.P = null;
        }
        super.onStop();
    }

    public void z(boolean z16, int i3, String str) {
        String qqStr;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PhoneMatchView", 2, String.format("onUploadResult [%s, %s, %s]", Boolean.valueOf(z16), Integer.valueOf(i3), str));
        }
        this.Q.removeMessages(0);
        com.tencent.mobileqq.phonecontact.observer.b bVar = this.P;
        if (bVar != null) {
            this.f183714d.unRegistObserver(bVar);
            this.P = null;
        }
        a();
        if (z16) {
            t(new Intent(getContext(), (Class<?>) ContactListView.class));
        }
        if (z16) {
            qqStr = HardCodeUtil.qqStr(R.string.f172283p31);
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.f172284p32);
        }
        BaseApplication context = BaseApplication.getContext();
        if (z16) {
            i16 = 2;
        }
        QQToast.makeText(context, i16, qqStr, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }
}
