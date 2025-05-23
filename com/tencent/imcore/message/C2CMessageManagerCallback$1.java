package com.tencent.imcore.message;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
class C2CMessageManagerCallback$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C2CMessageManager f116376d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ aj f116377e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f116378f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ String f116379h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ IMessageFacade f116380i;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ Context f116381m;
    final /* synthetic */ h this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f116376d.U(this.f116377e);
        List<MessageRecord> l3 = this.f116376d.y(this.f116378f).l(this.f116379h, this.f116378f);
        if (l3 != null) {
            int i3 = 0;
            long j3 = l3.get(0).uniseq;
            ArrayList<MessageRecord> arrayList = new ArrayList<>();
            int a16 = b61.a.a() - l3.size();
            this.f116376d.U0(this.f116379h, this.f116378f, j3, a16, this.f116377e, arrayList);
            if (arrayList.size() > a16) {
                i3 = arrayList.size() - a16;
            }
            while (i3 < arrayList.size()) {
                ChatMessage chatMessage = (ChatMessage) arrayList.get(i3);
                if (ad.z(chatMessage)) {
                    i3++;
                } else {
                    long j16 = chatMessage.msgUid;
                    throw null;
                }
            }
        }
        this.f116380i.getFacadeHandler().post(new Runnable() { // from class: com.tencent.imcore.message.C2CMessageManagerCallback$1.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CMessageManagerCallback$1.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QQToast.makeText(C2CMessageManagerCallback$1.this.f116381m, R.string.etv, 0).show(((BaseActivity) C2CMessageManagerCallback$1.this.f116381m).getTitleBarHeight());
                }
            }
        });
        this.f116380i.getFacadeHandler().post(new Runnable() { // from class: com.tencent.imcore.message.C2CMessageManagerCallback$1.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CMessageManagerCallback$1.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                Map<String, Boolean> refreshActionMap = C2CMessageManagerCallback$1.this.f116380i.getRefreshActionMap();
                C2CMessageManagerCallback$1 c2CMessageManagerCallback$1 = C2CMessageManagerCallback$1.this;
                if (refreshActionMap.containsKey(ao.f(c2CMessageManagerCallback$1.f116379h, c2CMessageManagerCallback$1.f116378f))) {
                    Map<String, Boolean> refreshActionMap2 = C2CMessageManagerCallback$1.this.f116380i.getRefreshActionMap();
                    C2CMessageManagerCallback$1 c2CMessageManagerCallback$12 = C2CMessageManagerCallback$1.this;
                    refreshActionMap2.remove(ao.f(c2CMessageManagerCallback$12.f116379h, c2CMessageManagerCallback$12.f116378f));
                }
            }
        });
    }
}
