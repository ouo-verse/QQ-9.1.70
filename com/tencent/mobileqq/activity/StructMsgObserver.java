package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes9.dex */
public class StructMsgObserver implements Observer {
    static IPatchRedirector $redirector_;

    public StructMsgObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) observable, obj);
            return;
        }
        if (!WebAccelerator.f177626l) {
            return;
        }
        if (obj instanceof MessageForStructing) {
            MessageForStructing messageForStructing = (MessageForStructing) obj;
            AbsStructMsg absStructMsg = messageForStructing.structingMsg;
            if (!messageForStructing.isSend() && WebAccelerator.r(absStructMsg)) {
                ThreadManagerV2.post(new Runnable(absStructMsg.mMsgUrl, absStructMsg.uinType, absStructMsg.currentAccountUin, absStructMsg.uin) { // from class: com.tencent.mobileqq.activity.StructMsgObserver.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f177142d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f177143e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f177144f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ String f177145h;

                    {
                        this.f177142d = r6;
                        this.f177143e = r7;
                        this.f177144f = r8;
                        this.f177145h = r9;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, StructMsgObserver.this, r6, Integer.valueOf(r7), r8, r9);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            WebAccelerator.j().c(this.f177142d, this.f177143e, this.f177144f, this.f177145h);
                        }
                    }
                }, 5, null, false);
                return;
            }
            return;
        }
        if (obj instanceof MessageForText) {
            MessageForText messageForText = (MessageForText) obj;
            if (!messageForText.isSend() && !TextUtils.isEmpty(messageForText.f203106msg)) {
                String h16 = WebAccelerator.h(messageForText.f203106msg);
                if (!TextUtils.isEmpty(h16)) {
                    String str = messageForText.frienduin;
                    ThreadManagerV2.post(new Runnable(h16, messageForText.istroop, messageForText.selfuin, str) { // from class: com.tencent.mobileqq.activity.StructMsgObserver.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f177146d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ int f177147e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ String f177148f;

                        /* renamed from: h, reason: collision with root package name */
                        final /* synthetic */ String f177149h;

                        {
                            this.f177146d = h16;
                            this.f177147e = r7;
                            this.f177148f = r8;
                            this.f177149h = str;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, StructMsgObserver.this, h16, Integer.valueOf(r7), r8, str);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                WebAccelerator.j().c(this.f177146d, this.f177147e, this.f177148f, this.f177149h);
                            }
                        }
                    }, 5, null, false);
                }
            }
        }
    }
}
