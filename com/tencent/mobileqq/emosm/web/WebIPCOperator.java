package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.t;
import com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class WebIPCOperator {

    /* renamed from: h, reason: collision with root package name */
    private static WebIPCOperator f204549h;

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<t> f204550a = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private Handler f204552c = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    EmojiIPCAlarmer f204553d = null;

    /* renamed from: e, reason: collision with root package name */
    private int f204554e = 0;

    /* renamed from: f, reason: collision with root package name */
    private Vector<a> f204555f = new Vector<>();

    /* renamed from: g, reason: collision with root package name */
    private EmojiIPCAlarmer.a f204556g = new EmojiIPCAlarmer.a() { // from class: com.tencent.mobileqq.emosm.web.WebIPCOperator.5
        @Override // com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer.a
        public void onTimeOut(int i3) {
            final a o16 = WebIPCOperator.this.o(i3);
            if (o16 != null) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "on req timeout seq: " + i3);
                }
                Bundle bundle = new Bundle();
                WebIPCOperator.this.s(bundle, 1001);
                o16.f204565b.putBundle("response", bundle);
                WebIPCOperator.this.p(new Runnable() { // from class: com.tencent.mobileqq.emosm.web.WebIPCOperator.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WebIPCOperator.this.f(o16.f204565b);
                    }
                });
            }
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private Client f204551b = new Client();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f204564a;

        /* renamed from: b, reason: collision with root package name */
        Bundle f204565b;

        /* renamed from: c, reason: collision with root package name */
        Runnable f204566c;

        public a(int i3, Bundle bundle) {
            this.f204564a = i3;
            bundle.putInt("seq", i3);
            this.f204565b = bundle;
        }
    }

    WebIPCOperator() {
    }

    private void b() {
        if (this.f204553d == null) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "alarm init");
            }
            EmojiIPCAlarmer emojiIPCAlarmer = new EmojiIPCAlarmer(this.f204556g);
            this.f204553d = emojiIPCAlarmer;
            emojiIPCAlarmer.b();
        }
    }

    private void c() {
        if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchBindToClient suc");
        }
        Iterator<t> it = this.f204550a.iterator();
        while (it.hasNext()) {
            it.next().onBindedToClient();
        }
    }

    private void d() {
        if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchBindToClient suc");
        }
        Iterator<t> it = this.f204550a.iterator();
        while (it.hasNext()) {
            it.next().onDisconnectWithService();
        }
    }

    private void e(Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchPushMsg suc");
        }
        Iterator<t> it = this.f204550a.iterator();
        while (it.hasNext()) {
            it.next().onPushMsg(bundle);
        }
    }

    public static WebIPCOperator h() {
        if (f204549h == null) {
            synchronized (WebIPCOperator.class) {
                if (f204549h == null) {
                    f204549h = new WebIPCOperator();
                }
            }
        }
        return f204549h;
    }

    public a a(Bundle bundle) {
        a aVar;
        synchronized (this.f204555f) {
            int i3 = this.f204554e;
            this.f204554e = i3 + 1;
            aVar = new a(i3, bundle);
            b();
            if (QLog.isColorLevel()) {
                QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "add to req queue seq: " + aVar.f204564a);
            }
            aVar.f204566c = this.f204553d.a(aVar.f204564a, 30000L);
            this.f204555f.add(aVar);
        }
        return aVar;
    }

    void f(Bundle bundle) {
        String string = bundle.getString("cmd");
        int i3 = bundle.getInt("failcode");
        if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchResp suc: " + string + ", retCode: " + i3);
        }
        Iterator<t> it = this.f204550a.iterator();
        while (it.hasNext()) {
            it.next().onResponse(bundle);
        }
    }

    public Client g() {
        return this.f204551b;
    }

    public boolean i() {
        Client client = this.f204551b;
        if (client != null) {
            return client.isClientBinded();
        }
        return false;
    }

    public void j() {
        c();
    }

    public void k() {
        d();
    }

    public void l(Bundle bundle) {
        e(bundle);
    }

    public void m(final Bundle bundle) {
        if (bundle != null) {
            int i3 = bundle.getInt("seq");
            a o16 = o(i3);
            if (QLog.isColorLevel()) {
                QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchResp seq:" + i3);
            }
            if (o16 != null) {
                s(bundle, 1000);
                p(new Runnable() { // from class: com.tencent.mobileqq.emosm.web.WebIPCOperator.3
                    @Override // java.lang.Runnable
                    public void run() {
                        WebIPCOperator.this.f(bundle);
                    }
                });
                return;
            }
            String string = bundle.getString("cmd");
            if (string != null) {
                if (string.equals("startDownloadEmoji") || string.equals("stopdownload") || string.equals("openEquipmentLock") || string.equals("card_setSummaryCard") || string.equals("card_getVipInfo") || string.equals("closeWeb") || string.equals("setMobileResult") || string.equals("setWaitingResponse") || string.equals("openEmojiMall") || string.equals("openProfileCard") || string.equals("close_version") || string.equals("openEmojiDetail") || string.equals("openFontSetting") || string.equals("startDownloadColorRing") || string.equals("stopDownloadColorRing") || string.equals("funcall_download") || string.equals("funcall_set") || string.equals("getA2") || string.equals("openDevLock") || string.equals("ipc_funnypic_add") || string.equals("ipc_video_isinstalled") || string.equals("ipc_video_install_plugin") || string.equals("gamecenter_delaydownload") || string.equals("emojiStickerRecall") || string.equals("ipc_cmd_get_team_work_url")) {
                    s(bundle, 1000);
                    p(new Runnable() { // from class: com.tencent.mobileqq.emosm.web.WebIPCOperator.4
                        @Override // java.lang.Runnable
                        public void run() {
                            WebIPCOperator.this.f(bundle);
                        }
                    });
                }
            }
        }
    }

    public void n(t tVar) {
        if (tVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "RegisterObserver key:" + tVar.key);
        }
        if (!this.f204550a.contains(tVar)) {
            this.f204550a.add(tVar);
        }
    }

    public a o(int i3) {
        synchronized (this.f204555f) {
            Iterator<a> it = this.f204555f.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.f204564a == i3) {
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "remove req queue seq:" + i3);
                    }
                    this.f204553d.c(next.f204566c);
                    this.f204555f.remove(next);
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "after remove req queue size:" + this.f204555f.size());
                    }
                    return next;
                }
            }
            return null;
        }
    }

    void p(Runnable runnable) {
        if (runnable != null) {
            this.f204552c.post(runnable);
        }
    }

    public void q(Bundle bundle) {
        if (bundle == null) {
            QLog.e("Q.emoji.web.EmoWebIPCOperator", 1, "error:reqbundle is null.");
            return;
        }
        a a16 = a(bundle);
        if (a16 != null) {
            Client client = this.f204551b;
            if (client == null || !client.onReqToServer(a16.f204565b)) {
                final a o16 = o(bundle.getInt("seq"));
                if (QLog.isColorLevel()) {
                    QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "sendServiceIpcReq unbind fail seq:" + this.f204554e);
                }
                if (o16 != null) {
                    Bundle bundle2 = new Bundle();
                    s(bundle2, 1002);
                    o16.f204565b.putBundle("response", bundle2);
                    p(new Runnable() { // from class: com.tencent.mobileqq.emosm.web.WebIPCOperator.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WebIPCOperator.this.f(o16.f204565b);
                        }
                    });
                }
            }
        }
    }

    public void r(final Bundle bundle) {
        if (bundle != null) {
            Client client = this.f204551b;
            if (client == null || !client.onReqToServer(bundle)) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "sendServiceIpcReq unbind fail seq:" + this.f204554e);
                }
                Bundle bundle2 = new Bundle();
                s(bundle2, 1002);
                bundle.putBundle("response", bundle2);
                p(new Runnable() { // from class: com.tencent.mobileqq.emosm.web.WebIPCOperator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        WebIPCOperator.this.f(bundle);
                    }
                });
            }
        }
    }

    void s(Bundle bundle, int i3) {
        if (bundle != null) {
            bundle.putInt("failcode", i3);
        }
    }

    public void t(t tVar) {
        if (tVar != null) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "unRegisterObserver key:" + tVar.key);
            }
            if (this.f204550a.contains(tVar)) {
                this.f204550a.remove(tVar);
            }
        }
    }
}
