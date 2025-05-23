package com.tencent.mobileqq.guild.mainframe.centerpanel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.api.theme.QQGuildThemeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.mainframe.centerpanel.MFGestureListIntent;
import com.tencent.mobileqq.guild.mainframe.centerpanel.b;
import com.tencent.mobileqq.guild.mainframe.k;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.qphone.base.util.QLog;
import rr1.i;
import sr1.d;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends gs1.a {
    private or0.a C;

    /* renamed from: e, reason: collision with root package name */
    protected FrameLayout f227315e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.guild.mainframe.centerpanel.b f227316f;

    /* renamed from: h, reason: collision with root package name */
    private AIOContact f227317h;

    /* renamed from: i, reason: collision with root package name */
    protected Handler f227318i;

    /* renamed from: m, reason: collision with root package name */
    private final rr1.a f227319m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.mainframe.centerpanel.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class HandlerC7824a extends Handler {
        HandlerC7824a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 100) {
                QLog.i("Guild.MF.Center.GuildChatCenterPanelController", 1, "handleMessage HANDLE_WHAT_MSG_SHOW_ANIM");
                ((k) a.this).f227466d.Z0().z(1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends rr1.a {
        b() {
        }

        @Override // rr1.a
        public boolean a(int i3, int i16) {
            MFGestureListIntent.RetBoolean retBoolean = new MFGestureListIntent.RetBoolean();
            a.this.f227316f.g(new MFGestureListIntent.BusiInterceptMoveEvent(i3, i16, retBoolean));
            return retBoolean.getRet();
        }

        @Override // rr1.a
        public boolean b(MotionEvent motionEvent) {
            MFGestureListIntent.RetBoolean retBoolean = new MFGestureListIntent.RetBoolean();
            a.this.f227316f.g(new MFGestureListIntent.ChildConsumeTouchEvent(motionEvent, retBoolean));
            return retBoolean.getRet();
        }

        @Override // rr1.a
        public void c(i iVar) {
            a.this.f227316f.g(new MFGestureListIntent.NotifyEvent(iVar));
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c implements or0.a {
        c() {
        }

        @Override // or0.a
        public void onThemeChanged() {
            a.this.f227316f.j();
        }
    }

    public a(com.tencent.mobileqq.guild.mainframe.i iVar) {
        super(iVar);
        this.f227316f = new com.tencent.mobileqq.guild.mainframe.centerpanel.b();
        this.f227317h = new AIOContact(4, "", "", "");
        this.f227318i = new HandlerC7824a(Looper.getMainLooper());
        this.f227319m = new b();
        this.C = new c();
    }

    private int s() {
        GuildMsgListIntent.GetDelayAnimTimeEvent getDelayAnimTimeEvent = new GuildMsgListIntent.GetDelayAnimTimeEvent(0);
        this.f227316f.g(getDelayAnimTimeEvent);
        QLog.i("Guild.MF.Center.GuildChatCenterPanelController", 1, "getDelayAnimTime:" + getDelayAnimTimeEvent.getDelayTime());
        return getDelayAnimTimeEvent.getDelayTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(Intent intent, AIOParam aIOParam) {
        y(intent, s());
    }

    private boolean v(Intent intent) {
        synchronized (this.f227317h) {
            AIOContact aIOContact = new AIOContact(4, intent.getStringExtra("uin"), intent.getStringExtra("guild_id"), "");
            if (!intent.getBooleanExtra("openGuildAioDisableReuse", true) && this.f227317h.equals(aIOContact)) {
                QLog.i("Guild.MF.Center.GuildChatCenterPanelController", 1, "openIntercept newAioContact:" + aIOContact.toString());
                return true;
            }
            this.f227317h = aIOContact;
            QLog.i("Guild.MF.Center.GuildChatCenterPanelController", 1, "lastOpenAioContact:" + this.f227317h.toString());
            return false;
        }
    }

    private void w() {
        synchronized (this.f227317h) {
            this.f227317h = new AIOContact(4, "", "", "");
        }
    }

    private void x(Object obj) {
        Intent intent;
        if (obj instanceof Intent) {
            intent = (Intent) obj;
        } else {
            intent = null;
        }
        if (intent == null) {
            intent = this.f227466d.getActivity().getIntent();
        }
        if (intent != null) {
            String stringExtra = intent.getStringExtra("uin");
            QLog.i("Guild.MF.Center.GuildChatCenterPanelController", 1, "selGuildAndChannel guildId:" + intent.getStringExtra("guild_id") + " channelId:" + stringExtra);
        }
    }

    private void y(Intent intent, int i3) {
        GuildCenterPanelController Z0 = this.f227466d.Z0();
        Bundle bundleExtra = intent.getBundleExtra("goto_guildtab_actionextra");
        if (bundleExtra == null) {
            if (i3 > 0) {
                QLog.i("Guild.MF.Center.GuildChatCenterPanelController", 1, "startOpenAnimation needDelayAnim");
                this.f227318i.sendEmptyMessageDelayed(100, i3);
                return;
            } else {
                Z0.z(1);
                return;
            }
        }
        boolean z16 = bundleExtra.getBoolean("keepOpenPos", false);
        boolean z17 = bundleExtra.getBoolean("openAioWithoutAnimation", false);
        int i16 = bundleExtra.getInt("openAioIn", 1);
        if (!z16) {
            if (z17) {
                Z0.y(i16);
                return;
            } else if (i3 > 0) {
                QLog.i("Guild.MF.Center.GuildChatCenterPanelController", 1, "startOpenAnimation needDelayAnim");
                this.f227318i.sendEmptyMessageDelayed(100, i3);
                return;
            } else {
                Z0.z(1);
                return;
            }
        }
        d N = this.f227466d.N();
        if (N.a()) {
            return;
        }
        boolean l3 = N.l();
        boolean j3 = N.j();
        boolean f16 = N.f();
        if (l3) {
            Z0.y(1);
        } else if (j3) {
            Z0.y(2);
        } else if (f16) {
            Z0.y(0);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void b(boolean z16) {
        QLog.i("Guild.MF.Center.GuildChatCenterPanelController", 1, "onAfterAccountChanged chatFragment is null ? " + this.f227316f);
    }

    @Override // gs1.a
    public int k() {
        return 1;
    }

    @Override // gs1.a
    public void l() {
        this.f227316f.e();
        w();
        this.f227318i.removeMessages(100);
    }

    @Override // gs1.a
    public void m(ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) viewGroup;
        this.f227315e = frameLayout;
        this.f227316f.b(frameLayout, j());
    }

    @Override // gs1.a
    public void n(final Intent intent) {
        boolean z16;
        QLog.e("Guild.MF.Center.GuildChatCenterPanelController", 1, "show chatFragment is null ? " + this.f227316f, new Throwable());
        this.f227318i.removeMessages(100);
        x(intent);
        GuildJumpDebugUtils.a("GUILD_JUMP", "GuildChatCenterPanelController show(): data = ", intent);
        if (intent != null) {
            if (v(intent)) {
                y(intent, 0);
                return;
            }
            String stringExtra = intent.getStringExtra("uin");
            String stringExtra2 = intent.getStringExtra("guild_id");
            int intExtra = intent.getIntExtra("channel_type", 0);
            Bundle bundle = new Bundle();
            if (intent.getBundleExtra(AppConstants.Key.GUILD_EXTRA) != null) {
                bundle.putAll(intent.getBundleExtra(AppConstants.Key.GUILD_EXTRA));
            }
            if (intent.getBundleExtra("goto_guildtab_actionextra") != null) {
                bundle.putAll(intent.getBundleExtra("goto_guildtab_actionextra"));
            }
            int intExtra2 = intent.getIntExtra("openGuildAioFrom", 0);
            if (intExtra2 != 0) {
                bundle.putInt("openGuildAioFrom", intExtra2);
            }
            GuildJumpDebugUtils.a("GUILD_JUMP", "GuildChatCenterPanelController show(): extra = ", bundle);
            if (bundle.getByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f227316f.b(this.f227315e, j());
            this.f227316f.m(new b.ShowParam(stringExtra2, stringExtra, intExtra, z16, bundle), new b.InterfaceC7825b() { // from class: rr1.f
                @Override // com.tencent.mobileqq.guild.mainframe.centerpanel.b.InterfaceC7825b
                public final void a(AIOParam aIOParam) {
                    com.tencent.mobileqq.guild.mainframe.centerpanel.a.this.u(intent, aIOParam);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (this.f227466d.Z0().t() != 1) {
            QLog.i("Guild.MF.Center.GuildChatCenterPanelController", 1, "onActivityResult curShowFrameType not GUILD_CHAT_FRAGMENT");
        } else {
            this.f227316f.h(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public boolean onBackPressed() {
        QLog.i("Guild.MF.Center.GuildChatCenterPanelController", 1, "onBackPressed chatFragment is null ? " + this.f227316f);
        if (this.f227315e != null) {
            if (this.f227466d.Z0().t() == 1 || this.f227466d.Z0().t() == 6) {
                if (this.f227466d.Z0().o()) {
                    this.f227466d.Z0().z(1);
                    return true;
                }
                if (this.f227466d.Z0().q()) {
                    return t();
                }
                return !this.f227466d.Z0().p();
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onBeforeAccountChanged() {
        QLog.i("Guild.MF.Center.GuildChatCenterPanelController", 1, "onBeforeAccountChanged chatFragment is null ? " + this.f227316f);
        w();
        this.f227318i.removeMessages(100);
        if (this.f227316f.f()) {
            this.f227316f.k();
            GuildMainFrameUtils.d(this.f227466d);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onCreate() {
        if (this.f227466d.N() != null) {
            this.f227466d.N().addGestureListener(this.f227319m);
        }
        QQGuildThemeManager.c(this.C);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onDestroy() {
        QLog.i("Guild.MF.Center.GuildChatCenterPanelController", 1, "onDestroy chatFragment is null ? " + this.f227316f);
        if (this.f227466d.N() != null) {
            this.f227466d.N().removeGestureListener(this.f227319m);
        }
        QQGuildThemeManager.d(this.C);
        this.f227316f.k();
        w();
        this.f227318i.removeMessages(100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AIOContact r() {
        return this.f227317h;
    }

    protected boolean t() {
        QLog.i("Guild.MF.Center.GuildChatCenterPanelController", 1, "handleGuildChatFragmentBack chatFragment is null ? " + this.f227316f);
        return this.f227316f.i();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void a(boolean z16) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onResume(boolean z16) {
    }
}
