package com.tencent.could.huiyansdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.widget.TextView;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes5.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public HandlerThread f100313a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Handler f100314b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f100315c;

    /* renamed from: d, reason: collision with root package name */
    public String f100316d;

    /* renamed from: e, reason: collision with root package name */
    public Queue<String> f100317e;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f100316d = "";
        LinkedList linkedList = new LinkedList();
        this.f100317e = linkedList;
        linkedList.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        this.f100315c.setText(str);
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            if (this.f100316d.equals(str)) {
                return;
            }
            this.f100316d = str;
            this.f100315c.setText(str);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f100314b == null) {
            return;
        }
        try {
            Message obtainMessage = this.f100314b.obtainMessage();
            obtainMessage.what = 1;
            this.f100314b.sendMessageDelayed(obtainMessage, 1000L);
        } catch (Exception e16) {
            k.a.f100197a.a(2, "ShowTipsHelper", "failed to send wait extra tips event" + e16.getLocalizedMessage());
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.f100315c != null && this.f100317e.size() > 0) {
            final String poll = this.f100317e.poll();
            this.f100315c.post(new Runnable() { // from class: com.tencent.could.huiyansdk.utils.v
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.b(poll);
                }
            });
        }
    }
}
