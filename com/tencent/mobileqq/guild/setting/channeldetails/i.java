package com.tencent.mobileqq.guild.setting.channeldetails;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private String f233363a;

    /* renamed from: b, reason: collision with root package name */
    private String f233364b;

    /* renamed from: c, reason: collision with root package name */
    private QQGuildChannelDetailFragment f233365c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f233366d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f233367e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f233368f = false;

    /* renamed from: g, reason: collision with root package name */
    private Long f233369g = 0L;

    /* renamed from: h, reason: collision with root package name */
    private final GPServiceObserver f233370h = new a();

    /* renamed from: i, reason: collision with root package name */
    private rr1.a f233371i = new b();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(String str, String str2, boolean z16) {
            if (i.this.m()) {
                QLog.i("Guild.MF.End.QQGuildChannelDetailRefresher", 1, "onAdminChanged isInvaild error");
                return;
            }
            if (i.this.f233363a.equals(str)) {
                QLog.i("Guild.MF.End.QQGuildChannelDetailRefresher", 1, "onAdminChanged need refresh guildId = " + str);
                i.this.f233366d = true;
                i.this.f233367e = true;
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChannelAdminChange(String str, String str2, int i3, List<String> list) {
            if (i.this.m()) {
                QLog.i("Guild.MF.End.QQGuildChannelDetailRefresher", 1, "onChannelAdminChange isInvaild error");
                return;
            }
            if (i.this.f233363a.equals(str) && i.this.f233364b.equals(str2)) {
                QLog.i("Guild.MF.End.QQGuildChannelDetailRefresher", 1, "onChannelAdminChange need refresh guildId = " + str);
                i.this.f233366d = true;
                i.this.f233367e = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(String str) {
            if (i.this.m()) {
                QLog.i("Guild.MF.End.QQGuildChannelDetailRefresher", 1, "onChannelInfoUpdated isInvaild error");
            } else if (i.this.f233364b.equals(str)) {
                QLog.i("Guild.MF.End.QQGuildChannelDetailRefresher", 1, "onChannelInfoUpdated");
                i.this.f233366d = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelVisibleChanged(String str, String str2, int i3, int i16) {
            if (i.this.m()) {
                QLog.i("Guild.MF.End.QQGuildChannelDetailRefresher", 1, "onChannelVisibleChanged isInvaild error");
            } else if (i.this.f233363a.equals(str) && i.this.f233364b.equals(str2)) {
                QLog.i("Guild.MF.End.QQGuildChannelDetailRefresher", 1, "onChannelVisibleChanged");
                i.this.f233366d = true;
                i.this.f233367e = true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends rr1.a {
        b() {
        }

        @Override // rr1.a
        public void c(rr1.i iVar) {
            if (iVar.f() == 1 && iVar.a() == 1 && iVar.d() == 2) {
                QLog.i("AbsGestureListener", 1, "mNeedRefreshHeader = " + i.this.f233366d + " mNeedRefreshMemberList = " + i.this.f233367e + " mLastRefreshMemberListTime" + i.this.f233369g);
                if (i.this.f233366d) {
                    i.this.o();
                    i.this.f233366d = false;
                }
                if (i.this.f233367e) {
                    i.this.p();
                    i.this.f233367e = false;
                    return;
                } else {
                    if (i.this.f233369g.longValue() + 60 < NetConnInfoCenter.getServerTime()) {
                        i.this.p();
                        return;
                    }
                    return;
                }
            }
            if (iVar.f() == 3 && iVar.c() == 2) {
                i.this.f233365c.hi();
            } else if (iVar.f() == 3 && iVar.a() == 2 && iVar.c() == 1) {
                i.this.f233365c.Yh();
            }
        }
    }

    public i(QQGuildChannelDetailFragment qQGuildChannelDetailFragment) {
        this.f233365c = qQGuildChannelDetailFragment;
        l();
    }

    private void l() {
        this.f233364b = this.f233365c.getChannelId();
        this.f233363a = ((IGPSService) this.f233365c.getAppInterface().getRuntimeService(IGPSService.class, "")).getGuildIdOf(this.f233364b);
        boolean isGuildTabSelected = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected();
        this.f233368f = isGuildTabSelected;
        if (isGuildTabSelected) {
            GuildMainFrameManager.a(this.f233371i);
        }
        ((IGPSService) this.f233365c.getAppInterface().getRuntimeService(IGPSService.class, "")).addObserver(this.f233370h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        QQGuildChannelDetailFragment qQGuildChannelDetailFragment = this.f233365c;
        if (qQGuildChannelDetailFragment != null && qQGuildChannelDetailFragment.isAdded() && !this.f233365c.isDetached() && !TextUtils.isEmpty(this.f233363a) && !TextUtils.isEmpty(this.f233364b)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (m()) {
            QLog.i("Guild.MF.End.QQGuildChannelDetailRefresher", 1, "refreshHeader isInvaild error");
            return;
        }
        IGPSService iGPSService = (IGPSService) this.f233365c.getAppInterface().getRuntimeService(IGPSService.class, "");
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(this.f233363a);
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(this.f233364b);
        if (guildInfo != null && channelInfo != null) {
            this.f233365c.Zh(guildInfo, channelInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (m()) {
            QLog.i("Guild.MF.End.QQGuildChannelDetailRefresher", 1, "refreshMemberList isInvaild error");
            return;
        }
        IGPSService iGPSService = (IGPSService) this.f233365c.getAppInterface().getRuntimeService(IGPSService.class, "");
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(this.f233363a);
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(this.f233364b);
        QLog.i("Guild.MF.End.QQGuildChannelDetailRefresher", 1, "refreshMemberList guildInfo\uff1a" + guildInfo + "channelInfo" + channelInfo);
        if (guildInfo != null && channelInfo != null) {
            this.f233365c.ai(guildInfo, channelInfo);
        }
    }

    public void n() {
        QLog.i("Guild.MF.End.QQGuildChannelDetailRefresher", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        ((IGPSService) ch.R0(IGPSService.class)).deleteObserver(this.f233370h);
        if (this.f233368f) {
            GuildMainFrameManager.l(this.f233371i);
        }
        this.f233365c = null;
    }

    public void q() {
        this.f233369g = Long.valueOf(NetConnInfoCenter.getServerTime());
        QLog.i("Guild.MF.End.QQGuildChannelDetailRefresher", 1, "updateRefreshMemberListTime " + this.f233369g);
    }
}
