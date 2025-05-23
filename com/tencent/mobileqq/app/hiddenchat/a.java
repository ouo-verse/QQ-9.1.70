package com.tencent.mobileqq.app.hiddenchat;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.nthiddenchat.NTHiddenChatFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.hiddenchat.IHiddenChatApi;
import com.tencent.qqnt.chats.data.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f195706d;

    /* renamed from: e, reason: collision with root package name */
    SharedPreferences f195707e;

    /* renamed from: f, reason: collision with root package name */
    AtomicBoolean f195708f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.hiddenchat.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class DialogInterfaceOnClickListenerC7381a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f195709d;

        DialogInterfaceOnClickListenerC7381a(Activity activity) {
            this.f195709d = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) activity);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("back_for_hidden_chat", true);
            NTHiddenChatFragment.rh(this.f195709d, 3, intent);
            ReportController.o(a.this.f195706d, "dc00898", "", "", "0X800A34A", "0X800A34A", 0, 0, "0", "0", "", "");
        }
    }

    public a(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f195708f = new AtomicBoolean(false);
        this.f195706d = qQAppInterface;
        this.f195707e = b.a(qQAppInterface.getApp(), qQAppInterface.getCurrentUin());
    }

    public static a c(QQAppInterface qQAppInterface) {
        return (a) qQAppInterface.getManager(QQManagerFactory.HIDDENCHAT_MANAGER);
    }

    void a(d dVar) {
        ArrayList<d> arrayList = new ArrayList<>();
        arrayList.add(dVar);
        ((IHiddenChatApi) QRoute.api(IHiddenChatApi.class)).delHiddenChat(this.f195706d.getCurrentUin(), arrayList);
    }

    void b() {
        QLog.d(LogTag.TAG_HIDDEN_CHAT, 1, "doInitAllHidden");
        b.b(this.f195706d.getCurrentUin(), this.f195706d.getApplicationContext());
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (!this.f195708f.get()) {
            b();
            this.f195708f.set(true);
        }
    }

    void e(d dVar) {
        ArrayList<d> arrayList = new ArrayList<>();
        arrayList.add(dVar);
        ((IHiddenChatApi) QRoute.api(IHiddenChatApi.class)).setHiddenChat(this.f195706d.getCurrentUin(), arrayList);
    }

    public void f(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        SharedPreferences sharedPreferences = this.f195706d.getApp().getSharedPreferences(this.f195706d.getCurrentAccountUin(), 0);
        if (!sharedPreferences.getBoolean("FirstSetHidden", false)) {
            sharedPreferences.edit().putBoolean("FirstSetHidden", true).commit();
            DialogUtil.createCustomDialog(activity, 230, activity.getString(R.string.iwl), activity.getString(R.string.iwj), activity.getString(R.string.hkf), activity.getString(R.string.iwk), new DialogInterfaceOnClickListenerC7381a(activity), new DialogUtil.DialogOnClickAdapter()).show();
            ReportController.o(this.f195706d, "dc00898", "", "", "0X800A349", "0X800A349", 0, 0, "0", "0", "", "");
        }
    }

    public void g(String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        d k3 = com.tencent.mobileqq.app.nthiddenchat.b.k(str, z16, i3);
        if (z16) {
            e(k3);
        } else {
            a(k3);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
