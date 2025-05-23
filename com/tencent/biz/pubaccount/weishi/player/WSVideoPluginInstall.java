package com.tencent.biz.pubaccount.weishi.player;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.weishi.player.wrapper.g;
import com.tencent.biz.pubaccount.weishi.player.wrapper.m;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class WSVideoPluginInstall {

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f81092e;

    /* renamed from: a, reason: collision with root package name */
    private b f81093a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f81095c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f81096d = new Handler(new a());

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.player.wrapper.g f81094b = m.d().c();

    /* loaded from: classes32.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 0) {
                WSVideoPluginInstall.this.f81095c = false;
                WSVideoPluginInstall.this.f81096d.removeMessages(0);
                if (WSVideoPluginInstall.this.f81093a != null) {
                    WSVideoPluginInstall.this.f81093a.a(true);
                }
            } else if (i3 == 1) {
                WSVideoPluginInstall.this.f81095c = false;
                WSVideoPluginInstall.this.f81096d.removeMessages(1);
                if (WSVideoPluginInstall.this.f81093a != null) {
                    WSVideoPluginInstall.this.f81093a.a(false);
                }
            } else if (i3 == 2) {
                WSVideoPluginInstall.this.f81095c = true;
            }
            return true;
        }
    }

    /* loaded from: classes32.dex */
    public interface b {
        void a(boolean z16);
    }

    /* loaded from: classes32.dex */
    private static class c implements g.a {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f81098a;

        c(Handler handler) {
            this.f81098a = handler;
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.g.a
        public void a(int i3) {
            x.f("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][onInstalledFailed] errorCode:" + i3);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version", AppSetting.f99551k);
                jSONObject.put("error_code", i3);
            } catch (Exception e16) {
                x.f("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][onInstalledFailed] JSONException: " + e16.getLocalizedMessage());
            }
            Handler handler = this.f81098a;
            if (handler != null) {
                handler.sendEmptyMessage(1);
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.g.a
        public void b() {
            x.f("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][onInstalledSuccess]");
            try {
                new JSONObject().put("version", AppSetting.f99551k);
            } catch (JSONException e16) {
                x.f("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][onInstalledSuccess] JSONException: " + e16.getLocalizedMessage());
            }
            Handler handler = this.f81098a;
            if (handler != null) {
                handler.sendEmptyMessage(0);
            }
        }
    }

    public WSVideoPluginInstall() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSVideoPluginInstall.1
            @Override // java.lang.Runnable
            public void run() {
                WSVideoPluginInstall.this.h();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f81094b.d();
        synchronized (this) {
            if (!f81092e) {
                this.f81094b.a(BaseApplication.getContext());
                x.c("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][initVideoSDK] finish!");
                f81092e = true;
            }
        }
    }

    public void i() {
        boolean j3 = j();
        x.j("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][installPlugin] isPluginInstalled:" + j3 + ", mIsInstalling:" + this.f81095c);
        if (j3 || this.f81095c) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSVideoPluginInstall.2
            @Override // java.lang.Runnable
            public void run() {
                x.j("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][installPlugin] start install video sdk in subThread. mIsInitialized:" + WSVideoPluginInstall.f81092e);
                if (!WSVideoPluginInstall.f81092e) {
                    WSVideoPluginInstall.this.h();
                }
                try {
                    WSVideoPluginInstall.this.f81094b.c(BaseApplication.getContext(), new c(WSVideoPluginInstall.this.f81096d));
                } catch (Exception e16) {
                    x.f("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][installPlugin] ERROR e:" + e16.getMessage());
                }
            }
        }, 8, null, true);
    }

    public boolean j() {
        return this.f81094b.b(BaseApplication.getContext());
    }

    public void k(b bVar) {
        this.f81093a = bVar;
    }

    public void g() {
        this.f81093a = null;
        this.f81096d.removeCallbacksAndMessages(null);
    }
}
