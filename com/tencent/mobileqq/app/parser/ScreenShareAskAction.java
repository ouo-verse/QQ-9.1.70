package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.ui.ai;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ScreenShareAskAction extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;
    private Activity Q;
    private QQAppInterface R;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements ai.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseActivity f196435a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a61.c f196436b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f196437c;

        a(BaseActivity baseActivity, a61.c cVar, String str) {
            this.f196435a = baseActivity;
            this.f196436b = cVar;
            this.f196437c = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ScreenShareAskAction.this, baseActivity, cVar, str);
            }
        }

        @Override // com.tencent.av.ui.ai.e
        public void onConfirm() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                PlusPanelUtils.h(ScreenShareAskAction.this.R, this.f196435a, this.f196436b.f25589n, true, "AIOShareScreen", null);
                ReportController.o(null, "dc00898", "", "", "0X800B8A6", "0X800B8A6", 0, 0, this.f196437c, "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements ai.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f196439a;

        b(String str) {
            this.f196439a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScreenShareAskAction.this, (Object) str);
            }
        }

        @Override // com.tencent.av.ui.ai.d
        public void onClick() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800B8A7", "0X800B8A7", 0, 0, this.f196439a, "", "", "");
            }
        }
    }

    public ScreenShareAskAction(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        } else {
            this.Q = null;
            this.R = qQAppInterface;
        }
    }

    public void G(BaseActivity baseActivity, String str) {
        a61.c qh5;
        SessionInfo sessionInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) baseActivity, (Object) str);
            return;
        }
        ChatFragment chatFragment = baseActivity.getChatFragment();
        if (chatFragment != null && chatFragment.qh() != null && (sessionInfo = (qh5 = chatFragment.qh()).f25589n) != null) {
            com.tencent.av.ui.ai aiVar = new com.tencent.av.ui.ai(baseActivity, qh5.f25589n.f179563i, FaceDrawable.getFaceDrawable(this.R, 1, sessionInfo.f179557e), new a(baseActivity, qh5, str));
            aiVar.S(new b(str));
            aiVar.show();
            ReportController.o(null, "dc00898", "", "", "0X800B8A5", "0X800B8A5", 0, 0, str, "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        try {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.app.parser.ScreenShareAskAction.1
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.app.parser.ScreenShareAskAction$1$a */
                /* loaded from: classes11.dex */
                class a implements DialogInterface.OnClickListener {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                        } else {
                            dialogInterface.dismiss();
                        }
                    }
                }

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScreenShareAskAction.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    long j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ScreenShareAskAction screenShareAskAction = ScreenShareAskAction.this;
                    BaseActivity baseActivity = (BaseActivity) screenShareAskAction.f307437b;
                    String str = screenShareAskAction.f307441f.get("requestUin");
                    String str2 = ScreenShareAskAction.this.f307441f.get("expireDate");
                    if (str2 != null) {
                        j3 = Long.parseLong(str2);
                    } else {
                        j3 = 0;
                    }
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (QLog.isDevelopLevel()) {
                        QLog.i("ScreenShareAskAction", 1, "doAction requestUin: " + str + "curuin: " + ScreenShareAskAction.this.R.getCurrentAccountUin() + " expireDate: " + j3 + "nowDate: " + currentTimeMillis);
                    }
                    if (currentTimeMillis > j3) {
                        QQToast.makeText(ScreenShareAskAction.this.f307437b, 1, R.string.f224146i5, 1).show();
                    } else if (str.equals(ScreenShareAskAction.this.R.getCurrentAccountUin())) {
                        String string = baseActivity.getString(R.string.f224196i_);
                        String string2 = baseActivity.getString(R.string.f224186i9);
                        DialogUtil.createCustomDialog(baseActivity, 230, (String) null, string, string2, string2, new a(), (DialogInterface.OnClickListener) null).show();
                    } else {
                        ScreenShareAskAction.this.G(baseActivity, str);
                    }
                    ReportController.o(null, "dc00898", "", str, "0X800B8A4", "0X800B8A4", 0, 0, str, "", "", "");
                }
            });
        } catch (Exception e16) {
            QLog.e("ScreenShareAskAction", 1, "doAction error: " + e16.getMessage());
            i("ScreenShareAskAction");
        }
        return true;
    }
}
