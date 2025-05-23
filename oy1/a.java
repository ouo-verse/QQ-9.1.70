package oy1;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.schedule.list.GuildScheduleListFragment;
import com.tencent.mobileqq.guild.schedule.list.k;
import com.tencent.mobileqq.guild.share.m;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.widget.ClickType;
import com.tencent.mobileqq.guild.widget.GuildAIOTitleBar;
import com.tencent.mobileqq.guild.widget.GuildRightIconLayout;
import com.tencent.mobileqq.guild.widget.IconType;
import com.tencent.mobileqq.guild.widget.TitleBarTheme;
import com.tencent.mobileqq.guild.widget.ah;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a implements ah {

    /* renamed from: d, reason: collision with root package name */
    private GuildAIOTitleBar f424495d;

    /* renamed from: e, reason: collision with root package name */
    private final AppInterface f424496e;

    /* renamed from: f, reason: collision with root package name */
    private final QBaseActivity f424497f;

    /* renamed from: h, reason: collision with root package name */
    private final k f424498h;

    /* renamed from: i, reason: collision with root package name */
    private final GuildScheduleListFragment.i f424499i;

    /* renamed from: m, reason: collision with root package name */
    private final GPServiceObserver f424500m;

    /* compiled from: P */
    /* renamed from: oy1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C10969a extends GPServiceObserver {
        C10969a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(IGProGuildInfo iGProGuildInfo, int i3) {
            if (iGProGuildInfo != null && TextUtils.equals(iGProGuildInfo.getGuildID(), a.this.f424498h.z())) {
                a.this.n();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(String str, String str2, boolean z16) {
            if (TextUtils.equals(str, a.this.f424498h.z()) && TextUtils.equals(((IGPSService) a.this.h(IGPSService.class)).getSelfTinyId(), str2)) {
                a.this.n();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(String str) {
            if (!TextUtils.equals(a.this.f424498h.w(), str)) {
                return;
            }
            super.onChannelInfoUpdated(str);
            a.this.p();
        }
    }

    public a(View view, GuildScheduleListFragment.i iVar, k kVar) {
        C10969a c10969a = new C10969a();
        this.f424500m = c10969a;
        this.f424498h = kVar;
        QBaseActivity hostActivity = iVar.getHostActivity();
        this.f424497f = hostActivity;
        this.f424496e = f(hostActivity);
        this.f424499i = iVar;
        sq0.a.f434200a.c(view);
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + ImmersiveUtils.getStatusBarHeight(hostActivity), view.getPaddingRight(), view.getPaddingBottom());
        GuildAIOTitleBar guildAIOTitleBar = (GuildAIOTitleBar) view.findViewById(R.id.f80104ak);
        this.f424495d = guildAIOTitleBar;
        guildAIOTitleBar.setTheme(TitleBarTheme.TITLE_BAR_STYLE_01);
        this.f424495d.setLeftIconType(IconType.BACK);
        this.f424495d.setTitleBarClickListener(this);
        view.addOnAttachStateChangeListener(new b());
        ((IGPSService) h(IGPSService.class)).addObserver(c10969a);
    }

    private AppInterface f(QBaseActivity qBaseActivity) {
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        if (appRuntime instanceof AppInterface) {
            return (AppInterface) appRuntime;
        }
        return null;
    }

    private IGProChannelInfo g() {
        return ((IGPSService) h(IGPSService.class)).getChannelInfo(this.f424498h.w());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends IRuntimeService> T h(Class<T> cls) {
        return (T) this.f424496e.getRuntimeService(cls, "");
    }

    private void i() {
        String z16 = this.f424498h.z();
        String w3 = this.f424498h.w();
        IGPSService iGPSService = (IGPSService) h(IGPSService.class);
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(z16);
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(w3);
        if (guildInfo != null && channelInfo != null) {
            new m(this.f424497f, guildInfo, channelInfo, GuildSharePageSource.CHANNEL_DETAIL_SCHEDULE).z();
        } else {
            QLog.e("Guild.sch.GuildScheduleListTitleBarHelper", 1, "handleClickShareIcon ", z16, "-", w3, " info get error");
        }
    }

    private void j() {
        GuildRightIconLayout E0 = this.f424495d.E0(IconType.SHARE);
        bt.a(E0, "em_sgrp_subchannel_top_invite");
        VideoReport.traversePage(E0);
    }

    private boolean l() {
        return ((IGPSService) h(IGPSService.class)).isGuest(this.f424498h.z());
    }

    private void m() {
        String z16 = this.f424498h.z();
        IGProGuildInfo guildInfo = ((IGPSService) h(IGPSService.class)).getGuildInfo(z16);
        if (guildInfo == null) {
            return;
        }
        String avatarUrl = guildInfo.getAvatarUrl(100);
        this.f424495d.setGuildAvatarDrawable(((IQQGuildAvatarApi) h(IQQGuildAvatarApi.class)).getAvatarDrawable(avatarUrl, 2, false, z16 + "Guild.sch.GuildScheduleListTitleBarHelper"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(IconType.SHARE);
        if (!l()) {
            arrayList.add(IconType.THREE_LINES_SETTING);
        }
        this.f424495d.setRightIcons(arrayList);
        j();
    }

    private void o() {
        if (!((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).showNavigateTitle(this.f424498h.z())) {
            return;
        }
        String A = this.f424498h.A();
        if (TextUtils.isEmpty(A)) {
            this.f424495d.setGuildNavigateVisibility(false);
            this.f424495d.setGuildName("");
        } else {
            this.f424495d.setGuildNavigateVisibility(true);
            this.f424495d.setGuildName(A);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        IGProChannelInfo g16 = g();
        if (g16 == null) {
            return;
        }
        this.f424495d.setChannelName(g16.getChannelName());
    }

    public void k() {
        p();
        o();
        m();
        n();
    }

    @Override // com.tencent.mobileqq.guild.widget.ah
    public void u2(ClickType clickType, View view) {
        QBaseActivity qBaseActivity;
        if (FastClickUtils.isFastDoubleClick("Guild.sch.GuildScheduleListTitleBarHelper onClick")) {
            QLog.w("Guild.sch.GuildScheduleListTitleBarHelper", 1, "onClick isFastDoubleClick");
            return;
        }
        if (clickType == ClickType.BACK) {
            this.f424499i.b();
            return;
        }
        if (clickType == ClickType.SHOW_GUILD_DIALOG) {
            if (((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).showNavigateTitle(this.f424498h.z()) && (qBaseActivity = this.f424497f) != null && !qBaseActivity.isFinishing()) {
                GuildJumpUtil.n(this.f424497f, new JumpGuildParam(this.f424498h.z(), ""));
                this.f424498h.b0(true);
                return;
            }
            return;
        }
        if (clickType == ClickType.THREE_LINES_SETTING) {
            this.f424499i.a();
        } else if (clickType == ClickType.SHARE) {
            i();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ((IGPSService) a.this.h(IGPSService.class)).deleteObserver(a.this.f424500m);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }
}
