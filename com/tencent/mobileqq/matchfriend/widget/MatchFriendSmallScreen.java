package com.tencent.mobileqq.matchfriend.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.voicechat.RoomInfo;
import com.tencent.mobileqq.matchfriend.voicechat.VoiceChatController;
import com.tencent.mobileqq.matchfriend.voicechat.api.IVoiceChatApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qav.QavDef$MultiUserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendSmallScreen extends FrameLayout {
    private final com.tencent.mobileqq.matchfriend.voicechat.api.a C;
    private final Handler D;

    /* renamed from: d, reason: collision with root package name */
    private Context f245651d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f245652e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f245653f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f245654h;

    /* renamed from: i, reason: collision with root package name */
    private Timer f245655i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f245656m;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends com.tencent.mobileqq.matchfriend.voicechat.api.a {
        a() {
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void b() {
            super.b();
            MatchFriendSmallScreen.this.u();
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void d(int i3) {
            super.d(i3);
            VoiceChatController.I().D();
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void j(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
            super.j(qavDef$MultiUserInfo);
            RoomInfo E = VoiceChatController.I().E();
            MatchFriendSmallScreen.this.v((E == null || qavDef$MultiUserInfo == null || E.f245598e != qavDef$MultiUserInfo.mUin) ? false : true);
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void l(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16, int i3) {
            super.l(qavDef$MultiUserInfo, z16, i3);
            if (z16) {
                MatchFriendSmallScreen.this.D.sendEmptyMessage(100);
            }
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void o() {
            super.o();
            VoiceChatController.I().D();
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            if (!(MatchFriendSmallScreen.this.f245651d instanceof Activity)) {
                intent.addFlags(268435456);
            }
            MatchFriendSmallScreen.this.o();
            MatchFriendSmallScreen.this.r();
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 100) {
                MatchFriendSmallScreen.this.s(0);
                MatchFriendSmallScreen.this.D.removeMessages(100);
                MatchFriendSmallScreen.this.D.removeMessages(101);
                MatchFriendSmallScreen.this.D.sendEmptyMessageDelayed(101, 3000L);
            } else if (i3 == 101) {
                MatchFriendSmallScreen.this.s(8);
                MatchFriendSmallScreen.this.D.removeMessages(100);
                MatchFriendSmallScreen.this.D.removeMessages(101);
            }
            return false;
        }
    }

    public MatchFriendSmallScreen(Context context) {
        super(context);
        this.f245656m = true;
        this.C = new a();
        this.D = new Handler(new c());
        View.inflate(BaseApplication.getContext(), R.layout.cwb, this);
        this.f245652e = (ImageView) findViewById(R.id.ok7);
        this.f245654h = (TextView) findViewById(R.id.oj7);
        this.f245653f = (ImageView) findViewById(R.id.or5);
        this.f245651d = context;
    }

    private void l() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.widget.MatchFriendSmallScreen.4
            @Override // java.lang.Runnable
            public void run() {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable drawable = MatchFriendSmallScreen.this.getContext().getResources().getDrawable(R.drawable.f159738fs0);
                obtain.mUseApngImage = true;
                obtain.mExtraInfo = new Bundle();
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                MatchFriendSmallScreen.this.f245653f.setImageDrawable(URLDrawable.getDrawable("https://downv6.qq.com/extendfriend/flow_voice_ring.png", obtain));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.widget.MatchFriendSmallScreen.8
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.matchfriend.utils.a.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (VoiceChatController.I().E() != null) {
            ((IVoiceChatApi) QRoute.api(IVoiceChatApi.class)).restoreVoiceChatPage(getContext(), VoiceChatController.I().E().f245597d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(final int i3) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.widget.MatchFriendSmallScreen.5
            @Override // java.lang.Runnable
            public void run() {
                MatchFriendSmallScreen.this.f245653f.setVisibility(i3);
            }
        });
    }

    private void t(final String str) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.widget.MatchFriendSmallScreen.7
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), 0, str, 0).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        TimerTask timerTask = new TimerTask() { // from class: com.tencent.mobileqq.matchfriend.widget.MatchFriendSmallScreen.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.widget.MatchFriendSmallScreen.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RoomInfo E = VoiceChatController.I().E();
                        MatchFriendSmallScreen.this.f245654h.setText(com.tencent.mobileqq.matchfriend.voicechat.b.a(E == null ? 0L : System.currentTimeMillis() - E.E));
                    }
                });
            }
        };
        if (this.f245655i == null) {
            this.f245655i = new BaseTimer();
        }
        this.f245655i.schedule(timerTask, 0L, 1000L);
    }

    public void j() {
        VoiceChatController.I().A(this.C);
    }

    public boolean k() {
        return this.f245656m;
    }

    public void m() {
        setOnClickListener(new b());
        l();
        j();
        if (VoiceChatController.I().L()) {
            u();
        }
        if (QLog.isColorLevel()) {
            QLog.d("MatchFriendSmallScreen", 1, "MatchFriendSmallScreen is onCreate success");
        }
    }

    public void n() {
        p();
        q();
    }

    public void p() {
        VoiceChatController.I().S(this.C);
    }

    public void q() {
        this.D.removeCallbacksAndMessages(null);
    }

    public void setShowImmediately(boolean z16) {
        this.f245656m = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z16) {
        if (!z16) {
            t(getResources().getString(R.string.wzj));
            VoiceChatController.I().D();
        }
        o();
    }
}
