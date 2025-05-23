package com.tencent.mobileqq.guild.schedule.detail;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildRoleGroupApi;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.discover.event.ScheduleStateEvent;
import com.tencent.mobileqq.guild.home.fragments.ban.GuildVisitorExceptionFragment;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.GuildShareUrlParam;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.ap;
import com.tencent.mobileqq.guild.schedule.detail.m;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.dt;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBatchGetGuildLabelInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelOpenStateResultInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSwitchInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.ag;
import com.tencent.mobileqq.qqguildsdk.data.genc.di;
import com.tencent.mobileqq.qqguildsdk.data.genc.dp;
import com.tencent.mobileqq.qqguildsdk.data.genc.eb;
import com.tencent.mobileqq.qqguildsdk.data.genc.ec;
import com.tencent.mobileqq.qqguildsdk.data.genc.r;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import vh2.bt;
import vh2.bv;
import vh2.ch;
import wh2.Cdo;
import wh2.be;
import wh2.w;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes14.dex */
public class m implements bt {

    /* renamed from: a, reason: collision with root package name */
    private final AppInterface f233184a;

    /* renamed from: b, reason: collision with root package name */
    private final p f233185b;

    /* renamed from: c, reason: collision with root package name */
    private String f233186c;

    /* renamed from: d, reason: collision with root package name */
    private String f233187d;

    /* renamed from: e, reason: collision with root package name */
    private String f233188e;

    /* renamed from: f, reason: collision with root package name */
    private long f233189f;

    /* renamed from: g, reason: collision with root package name */
    private String f233190g;

    /* renamed from: h, reason: collision with root package name */
    private GuildScheduleInfo f233191h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private JumpGuildParam f233192i;

    /* renamed from: j, reason: collision with root package name */
    private IGProGuildInfo f233193j;

    /* renamed from: k, reason: collision with root package name */
    private IGProChannelInfo f233194k;

    /* renamed from: l, reason: collision with root package name */
    private WeakReference<Activity> f233195l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f233196m = true;

    /* renamed from: n, reason: collision with root package name */
    private final GPServiceObserver f233197n = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements be {
        b() {
        }

        @Override // wh2.be
        public void a(int i3, String str, IGProChannelOpenStateResultInfo iGProChannelOpenStateResultInfo) {
            boolean z16;
            int i16;
            Iterator<IGProSwitchInfo> it = iGProChannelOpenStateResultInfo.getSwitchInfoList().iterator();
            while (true) {
                z16 = false;
                if (it.hasNext()) {
                    IGProSwitchInfo next = it.next();
                    if (next.getSwitchType() == 18) {
                        i16 = next.getSwitchState();
                        break;
                    }
                } else {
                    i16 = 0;
                    break;
                }
            }
            if (i16 != 2) {
                z16 = true;
            }
            Boolean valueOf = Boolean.valueOf(z16);
            QLog.e("Guild.sch.GuildScheduleDetailPresenter", 1, "fetchSpecifiedTypeChannelsOpenState " + i3 + "errMsg" + m.this.f233186c + valueOf);
            m.this.f233185b.Na(valueOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c extends GPServiceObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            if (!m.this.P()) {
                return;
            }
            m.this.N();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(IGProGuildInfo iGProGuildInfo, int i3) {
            if (iGProGuildInfo != null && TextUtils.equals(iGProGuildInfo.getGuildID(), m.this.B())) {
                QLog.e("Guild.sch.GuildScheduleDetailPresenter", 1, "onAddGuildWithInfo: guildId[" + m.this.B() + "]");
                m.this.w(new Runnable() { // from class: com.tencent.mobileqq.guild.schedule.detail.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.c.this.e();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(String str, String str2, boolean z16) {
            super.onAdminChanged(str, str2, z16);
            if (TextUtils.equals(str, m.this.f233186c)) {
                m.this.b0();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(String str, int i3) {
            super.onBeKickFromGuild(str, i3);
            m.this.y(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(String str) {
            super.onDeleteGuild(str);
            m.this.y(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(String str) {
            super.onDestoryGuild(str);
            m.this.y(str);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onEditSchedule(String str, String str2, GuildScheduleInfo guildScheduleInfo, int i3) {
            if (guildScheduleInfo != null && TextUtils.equals(str, m.this.B()) && TextUtils.equals(str2, m.this.A()) && m.this.P() && i3 == 2) {
                m mVar = m.this;
                mVar.n0(guildScheduleInfo, 0, mVar.M());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(String str, dx dxVar) {
            super.onGuildPermissionChanged(str, dxVar);
            if (TextUtils.equals(str, m.this.f233186c)) {
                m.this.b0();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildUserAvatarUrlUpdate(String str, String str2) {
            super.onGuildUserAvatarUrlUpdate(str, str2);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                QLog.e("Guild.sch.GuildScheduleDetailPresenter", 1, "onGuildUserAvatarUrlUpdate: tinyId[" + str2 + "]");
                m.this.f233185b.bf();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(String str) {
            super.onRemoveGuild(str);
            m.this.y(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements ch {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f233201a;

        d(Runnable runnable) {
            this.f233201a = runnable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // vh2.ch
        public void a(int i3, String str, GuildScheduleInfo guildScheduleInfo, int i16, boolean z16) {
            Activity activity;
            QLog.i("Guild.sch.GuildScheduleDetailPresenter", 1, String.format(Locale.getDefault(), "fetch ScheduleInfo result:%d,errMsg:%s,hasJoin:%s", Integer.valueOf(i3), str, Boolean.valueOf(z16)));
            if (!m.this.P()) {
                return;
            }
            if (i3 == 0) {
                m mVar = m.this;
                mVar.n0(guildScheduleInfo, i16, mVar.M());
                Runnable runnable = this.f233201a;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            if (i3 == 3000003 && (activity = (Activity) m.this.f233195l.get()) != null && m.this.f233192i != null) {
                GuildVisitorExceptionFragment.vh(activity, m.this.f233192i, 3, null);
                GuildSplitViewUtils.f235370a.t(activity, false);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                QLog.e("Guild.sch.GuildScheduleDetailPresenter", 1, "Search schedule failed. Result = " + i3);
                str = "\u67e5\u8be2\u65e5\u7a0b\u8be6\u60c5\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5";
            }
            m.this.f233185b.D6(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e implements wh2.e {
        e() {
        }

        @Override // wh2.e
        public void a(int i3, String str, IGProBatchGetGuildLabelInfoRsp iGProBatchGetGuildLabelInfoRsp) {
            QLog.d("Guild.sch.GuildScheduleDetailPresenter", 1, "batchGetGuildLabelInfo, result=$result, errMsg=$errMsg");
            IGProGuildLabelInfo E = m.this.E(iGProBatchGetGuildLabelInfoRsp.getList());
            if (E != null) {
                m.this.f233185b.Ua(E.getLabels());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map f233204d;

        f(Map map) {
            this.f233204d = map;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            m.this.u();
            this.f233204d.put("sgrp_btn_type", 1);
            QQCustomDialog qQCustomDialog = (QQCustomDialog) dialogInterface;
            VideoReport.setElementId(qQCustomDialog.getRootView(), "em_sgrp_delete_pop");
            VideoReport.reportEvent("clck", qQCustomDialog.getRootView(), this.f233204d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map f233206d;

        g(Map map) {
            this.f233206d = map;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f233206d.put("sgrp_btn_type", 2);
            QQCustomDialog qQCustomDialog = (QQCustomDialog) dialogInterface;
            VideoReport.setElementId(qQCustomDialog.getRootView(), "em_sgrp_delete_pop");
            VideoReport.reportEvent("clck", qQCustomDialog.getRootView(), this.f233206d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class h implements Cdo {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f233208a;

        h(int i3) {
            this.f233208a = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(String str) {
            QQToast.makeText(MobileQQ.sMobileQQ, str, 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            m.this.f233185b.V2(m.this.f233191h, 0, true);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // wh2.Cdo
        public void onModifyInviteStatus(int i3, final String str) {
            if (!m.this.P()) {
                return;
            }
            if (i3 != 0) {
                if (TextUtils.isEmpty(str)) {
                    str = "\u64cd\u4f5c\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5";
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.schedule.detail.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.h.c(str);
                    }
                });
                return;
            }
            if (this.f233208a == 1) {
                com.tencent.mobileqq.guild.util.ch.u1((Context) m.this.f233195l.get(), "\u5df2\u9884\u7ea6\uff0c\u65e5\u7a0b\u5f00\u59cb\u65f6\u5c06\u901a\u77e5\u4f60");
            }
            m.this.f233191h.updateInviteStatus(this.f233208a);
            if (this.f233208a == 1) {
                m.this.f233191h.increaseAcceptNums();
            } else {
                m.this.f233191h.reduceAcceptedNums();
            }
            SimpleEventBus.getInstance().dispatchEvent(new ScheduleStateEvent(m.this.f233191h.getScheduleId(), this.f233208a));
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.schedule.detail.o
                @Override // java.lang.Runnable
                public final void run() {
                    m.h.this.d();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class i implements w {
        i() {
        }

        @Override // wh2.w
        public void a(int i3, String str, IGProScheduleInfo iGProScheduleInfo) {
            QLog.i("Guild.sch.GuildScheduleDetailPresenter", 1, String.format(Locale.getDefault(), "delSchedule result:%d,errMsg:%s", Integer.valueOf(i3), str));
            if (!m.this.P()) {
                return;
            }
            if (i3 == 0) {
                aa.h("\u5220\u9664\u6210\u529f!");
                m.this.f233185b.fb(m.this.f233191h);
            } else {
                QQToast.makeText(MobileQQ.sMobileQQ, "\u5220\u9664\u65e5\u7a0b\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", 0).show();
            }
        }
    }

    public m(AppInterface appInterface, p pVar) {
        this.f233184a = appInterface;
        this.f233185b = pVar;
    }

    private void D(Fragment fragment) {
        Bundle g16 = GuildSplitViewUtils.f235370a.g(fragment);
        this.f233188e = g16.getString(GetGuildJoinUrlServlet.BUNDLE_KEY_URL);
        Serializable serializable = g16.getSerializable("key_guild_schedule_info");
        if (serializable != null) {
            this.f233191h = (GuildScheduleInfo) serializable;
        }
        this.f233186c = g16.getString("guildid");
        this.f233187d = g16.getString("channelid");
        this.f233189f = az.d(g16.getString("schedule_id"), 0L);
        this.f233192i = (JumpGuildParam) g16.getSerializable("join_guild_param");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IGProGuildLabelInfo E(ArrayList<IGProGuildLabelInfo> arrayList) {
        Iterator<IGProGuildLabelInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            IGProGuildLabelInfo next = it.next();
            if (next.getGuildId() == Long.valueOf(this.f233186c).longValue()) {
                return next;
            }
        }
        return null;
    }

    private IGPSService K() {
        return (IGPSService) this.f233184a.getRuntimeService(IGPSService.class, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P() {
        WeakReference<Activity> weakReference = this.f233195l;
        if (weakReference != null && weakReference.get() != null && !this.f233195l.get().isFinishing()) {
            return true;
        }
        return false;
    }

    private boolean S(long j3, long j16) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        return simpleDateFormat.format(new Date(j3)).equals(simpleDateFormat.format(new Date(j16)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W() {
        this.f233185b.Ed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(boolean z16) {
        if (!P()) {
            return;
        }
        if (z16) {
            r();
        }
        N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(final boolean z16, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        if (!P()) {
            return;
        }
        QLog.i("Guild.sch.GuildScheduleDetailPresenter", 1, "[joinChannel] isAcceptSchedule:" + z16 + ",result:" + i3 + ",errMsg:" + str + ",security:" + iGProSecurityResult);
        if (com.tencent.mobileqq.guild.channel.joinchannel.h.d(i3, iGProSecurityResult)) {
            w(new Runnable() { // from class: com.tencent.mobileqq.guild.schedule.detail.k
                @Override // java.lang.Runnable
                public final void run() {
                    m.this.X(z16);
                }
            });
        } else {
            com.tencent.mobileqq.guild.channel.joinchannel.h.c(BaseApplication.getContext(), i3, str, iGProSecurityResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(View view, ActionSheet actionSheet, View view2, int i3) {
        if (com.tencent.mobileqq.guild.util.o.a(view2)) {
            return;
        }
        t(view);
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(GuildScheduleInfo guildScheduleInfo, int i3, boolean z16) {
        this.f233191h = guildScheduleInfo;
        if (guildScheduleInfo != null) {
            this.f233185b.D9(guildScheduleInfo, i3, z16);
        }
    }

    public static Intent c0(Context context, GuildScheduleInfo guildScheduleInfo, String str, String str2, String str3, JumpGuildParam jumpGuildParam) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (guildScheduleInfo != null) {
            bundle.putSerializable("key_guild_schedule_info", guildScheduleInfo);
        }
        bundle.putString("guildid", str);
        bundle.putString("channelid", str2);
        bundle.putString("schedule_id", str3);
        if (jumpGuildParam != null) {
            bundle.putSerializable("join_guild_param", jumpGuildParam);
        }
        intent.putExtras(bundle);
        return intent;
    }

    private void d0(int i3) {
        QLog.i("Guild.sch.GuildScheduleDetailPresenter", 1, String.format(Locale.getDefault(), "modifyScheduleInviteStatus:%d, guildId:%s, channelId:%s, scheduleId:%s", Integer.valueOf(i3), this.f233186c, this.f233187d, Long.valueOf(this.f233189f)));
        di diVar = new di();
        diVar.j(this.f233189f);
        diVar.h(StringUtils.toLong(this.f233186c));
        diVar.g(StringUtils.toLong(this.f233187d));
        diVar.i(i3);
        diVar.f(11);
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.R0(IGPSService.class)).modifyScheduleInviteStatusV2(diVar, new h(i3));
    }

    private void i0(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    private void k0() {
        if (this.f233195l.get() == null) {
            return;
        }
        IGProChannelInfo iGProChannelInfo = this.f233194k;
        if (iGProChannelInfo != null && this.f233193j != null && this.f233191h != null) {
            sy1.a.e(this.f233195l.get(), this.f233193j, this.f233194k, this.f233191h, false, null);
        } else {
            QLog.e("Guild.sch.GuildScheduleDetailPresenter", 1, String.format("showFullAbilityShareDialog not valid, guild:%s, channel:%s, schedule:%s", this.f233193j, iGProChannelInfo, this.f233191h));
        }
    }

    private void m0() {
        if (this.f233193j == null) {
            this.f233193j = K().getGuildInfo(this.f233186c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(final GuildScheduleInfo guildScheduleInfo, final int i3, final boolean z16) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.schedule.detail.g
            @Override // java.lang.Runnable
            public final void run() {
                m.this.a0(guildScheduleInfo, i3, z16);
            }
        });
    }

    private String s(long j3, String str) {
        return new SimpleDateFormat(str).format(new Date(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        QLog.i("Guild.sch.GuildScheduleDetailPresenter", 1, String.format(Locale.getDefault(), "delSchedule guildId:%s, channelId:%s, scheduleId:%s", this.f233186c, this.f233187d, Long.valueOf(this.f233189f)));
        ag agVar = new ag();
        agVar.i(StringUtils.toLong(this.f233186c));
        agVar.g(StringUtils.toLong(this.f233187d));
        agVar.f(11);
        agVar.h(1);
        ec ecVar = new ec();
        ecVar.t(this.f233191h.getScheduleId());
        ecVar.v(this.f233191h.getTitle());
        ecVar.q(this.f233191h.getContent());
        ecVar.u(this.f233191h.getStartTimeMs());
        ecVar.r(this.f233191h.getEndTimeMs());
        if (this.f233191h.getChannelInfo() != null) {
            eb ebVar = new eb();
            ebVar.g(this.f233191h.getChannelInfo().getChannelId());
            ebVar.l(this.f233191h.getChannelInfo().getType());
            ebVar.i(this.f233191h.getChannelInfo().getGuildId());
            ebVar.h(this.f233191h.getChannelInfo().getChannelName());
            ecVar.p(ebVar);
        }
        if (this.f233191h.getOtherJumpAddress() != null) {
            dp dpVar = new dp();
            dpVar.d(this.f233191h.getOtherJumpAddress().address);
            dpVar.e(this.f233191h.getOtherJumpAddress().addressType);
            ecVar.s(dpVar);
        }
        agVar.j(ecVar);
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.R0(IGPSService.class)).editScheduleV2(agVar, new i());
    }

    private void v() {
        r rVar = new r();
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(this.f233186c));
        rVar.c(arrayList);
        K().batchGetGuildLabelInfo(rVar, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Runnable runnable) {
        QLog.i("Guild.sch.GuildScheduleDetailPresenter", 1, String.format("fetch ScheduleInfo guildId:%s,channelId:%s,scheduleId:%s", this.f233186c, this.f233187d, Long.valueOf(this.f233189f)));
        K().getScheduleDetail(this.f233186c, this.f233187d, String.valueOf(this.f233189f), new d(runnable));
    }

    private void x() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(18);
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.R0(IGPSService.class)).fetchSpecifiedTypeChannelsOpenState(Long.valueOf(this.f233186c).longValue(), arrayList, 0, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str) {
        if (TextUtils.equals(str, this.f233186c) && com.tencent.mobileqq.guild.util.ch.L(str) == null) {
            QLog.e("Guild.sch.GuildScheduleDetailPresenter", 1, "guildInfo is null, finish self");
            Activity activity = this.f233195l.get();
            if (activity != null) {
                GuildSplitViewUtils.f235370a.t(activity, false);
            }
        }
    }

    public String A() {
        return this.f233187d;
    }

    public String B() {
        return this.f233186c;
    }

    public GuildScheduleInfo C() {
        return this.f233191h;
    }

    public long F() {
        return this.f233191h.reminderTimeMs() / 60000;
    }

    public int G() {
        GuildScheduleInfo guildScheduleInfo = this.f233191h;
        if (guildScheduleInfo == null) {
            return -1;
        }
        return guildScheduleInfo.getInviteStatus();
    }

    public int H() {
        if (this.f233191h == null) {
            return -1;
        }
        if (Q()) {
            return 1;
        }
        return 0;
    }

    public int I() {
        boolean z16;
        if (this.f233191h == null) {
            return -1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long startTimeMs = this.f233191h.getStartTimeMs();
        long endTimeMs = this.f233191h.getEndTimeMs();
        if ((F() * 60000) + currentTimeMillis > startTimeMs) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (endTimeMs < currentTimeMillis) {
            return 4;
        }
        if (currentTimeMillis > startTimeMs && currentTimeMillis < endTimeMs) {
            return 3;
        }
        if (!z16) {
            return 1;
        }
        return 2;
    }

    public int J() {
        IGProGuildInfo iGProGuildInfo = this.f233193j;
        if (iGProGuildInfo == null) {
            return v.b(-1);
        }
        return v.b(iGProGuildInfo.getUserType());
    }

    public void L() {
        JumpGuildParam jumpGuildParam = new JumpGuildParam(this.f233186c, "");
        if (this.f233192i != null) {
            jumpGuildParam.setJoinInfoParam(new JumpGuildParam.JoinInfoParam(this.f233192i.getJoinSignature(), this.f233192i.getMainSource(), this.f233192i.getSubSource()));
            jumpGuildParam.extras = this.f233192i.getExtras();
        }
        GuildJumpUtil.n(this.f233195l.get(), jumpGuildParam);
    }

    public boolean M() {
        return !com.tencent.mobileqq.guild.util.ch.j0(this.f233186c);
    }

    public void N() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.schedule.detail.i
            @Override // java.lang.Runnable
            public final void run() {
                m.this.W();
            }
        });
    }

    public void O(Activity activity, Fragment fragment) {
        this.f233190g = ((IGPSService) this.f233184a.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        ((IGPSService) this.f233184a.getRuntimeService(IGPSService.class, "")).addObserver(this.f233197n);
        ((IGPSService) this.f233184a.getRuntimeService(IGPSService.class, "")).addGuildStateListener(this);
        this.f233195l = new WeakReference<>(activity);
        D(fragment);
        this.f233193j = K().getGuildInfo(this.f233186c);
        this.f233194k = K().getChannelInfo(this.f233187d);
        v();
        GuildScheduleInfo guildScheduleInfo = this.f233191h;
        if (guildScheduleInfo != null) {
            this.f233185b.D9(guildScheduleInfo, 0, M());
        }
        w(null);
        x();
    }

    public boolean Q() {
        GuildScheduleInfo guildScheduleInfo = this.f233191h;
        if (guildScheduleInfo == null) {
            QLog.e("Guild.sch.GuildScheduleDetailPresenter", 1, "isCreator? but mGuildScheduleInfo == null");
            return false;
        }
        return TextUtils.equals(this.f233190g, String.valueOf(guildScheduleInfo.getCreator().getTinyId()));
    }

    public boolean R() {
        String str = this.f233186c;
        if (str == null) {
            QLog.e("Guild.sch.GuildScheduleDetailPresenter", 1, "isGuildAdminOrCreator? but mGuildId == null");
            return false;
        }
        return com.tencent.mobileqq.guild.util.ch.m0(str);
    }

    public void T(final boolean z16) {
        if (!P()) {
            QQToast.makeText(MobileQQ.sMobileQQ, "\u52a0\u5165\u9891\u9053\u5931\u8d25, activity\u65e0\u6548, \u8bf7\u9000\u51fa\u91cd\u8bd5", 0).show();
            return;
        }
        JumpGuildParam jumpGuildParam = this.f233192i;
        if (jumpGuildParam != null && !TextUtils.isEmpty(jumpGuildParam.getJoinSignature())) {
            this.f233192i.getJoinInfoParam().setPageEntranceId(7);
            ((IQQGuildService) this.f233184a.getRuntimeService(IQQGuildService.class, "")).addGuild(this.f233195l.get(), this.f233192i, "Guild.sch.GuildScheduleDetailPresenter", new bv() { // from class: com.tencent.mobileqq.guild.schedule.detail.h
                @Override // vh2.bv
                public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                    m.this.Y(z16, i3, str, iGProSecurityResult, iGProJoinGuildResult);
                }
            });
        } else {
            QQToast.makeText(MobileQQ.sMobileQQ, "\u52a0\u5165\u9891\u9053\u5931\u8d25, sign\u65e0\u6548, \u8bf7\u9000\u51fa\u91cd\u8bd5", 0).show();
        }
    }

    public void U(boolean z16) {
        if (!P()) {
            QQToast.makeText(MobileQQ.sMobileQQ, "\u52a0\u5165\u9891\u9053\u5931\u8d25, activity\u65e0\u6548, \u8bf7\u9000\u51fa\u91cd\u8bd5", 0).show();
        } else {
            T(z16);
        }
    }

    public void V(QBaseActivity qBaseActivity) {
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && this.f233192i != null) {
            JumpGuildParam jumpGuildParam = new JumpGuildParam(this.f233186c, "");
            jumpGuildParam.setJoinInfoParam(this.f233192i.getJoinInfoParam());
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).openJoinInvitationDialog(qBaseActivity, jumpGuildParam);
            return;
        }
        QQToast.makeText(MobileQQ.sMobileQQ, "\u52a0\u5165\u9891\u9053\u5931\u8d25, activity\u65e0\u6548, \u8bf7\u9000\u51fa\u91cd\u8bd5", 0).show();
    }

    @Override // vh2.bt
    public void a(dt dtVar) {
        p pVar = this.f233185b;
        if (pVar != null) {
            pVar.Ba();
        }
    }

    public void b0() {
        this.f233185b.x7(Boolean.valueOf(com.tencent.mobileqq.guild.util.ch.m0(this.f233186c)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e0() {
        ((IGPSService) this.f233184a.getRuntimeService(IGPSService.class, "")).deleteObserver(this.f233197n);
        ((IGPSService) this.f233184a.getRuntimeService(IGPSService.class, "")).removeGuildStateListener(this);
    }

    public void f0(View view, QBaseActivity qBaseActivity) {
        boolean z16;
        GuildScheduleInfo guildScheduleInfo = this.f233191h;
        if (guildScheduleInfo != null && guildScheduleInfo.getChannelInfo() != null) {
            IGProChannelInfo channelInfo = K().getChannelInfo(String.valueOf(this.f233191h.getChannelInfo().getChannelId()));
            if (this.f233191h.getChannelInfo().isValidChannelInfo() && channelInfo == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!M() && (!((IGuildRoleGroupApi) QRoute.api(IGuildRoleGroupApi.class)).getVisibleForVisitor(this.f233193j) || z16)) {
                V(qBaseActivity);
                return;
            }
            GuildScheduleInfo guildScheduleInfo2 = this.f233191h;
            if (guildScheduleInfo2 != null && guildScheduleInfo2.getChannelInfo() != null && this.f233191h.getChannelInfo().isValidChannelInfo()) {
                JumpGuildParam jumpGuildParam = new JumpGuildParam(this.f233186c, String.valueOf(this.f233191h.getChannelInfo().getChannelId()));
                if (z16) {
                    DialogUtil.createCustomDialog(this.f233195l.get(), 230, (String) null, "\u8be5\u5185\u5bb9\u6682\u4e0d\u652f\u6301\u67e5\u770b\uff0c\u53bb\u5176\u4ed6\u5730\u65b9\u901b\u901b\u5427\u3002", (String) null, "\u786e\u5b9a", new a(), (DialogInterface.OnClickListener) null).show();
                    return;
                }
                JumpGuildParam jumpGuildParam2 = this.f233192i;
                if (jumpGuildParam2 != null) {
                    jumpGuildParam.setJoinInfoParam(jumpGuildParam2.getJoinInfoParam());
                }
                GuildJumpUtil.n(this.f233195l.get(), jumpGuildParam);
                return;
            }
            GuildScheduleInfo guildScheduleInfo3 = this.f233191h;
            if (guildScheduleInfo3 != null && guildScheduleInfo3.getOtherJumpAddress() != null && this.f233191h.getOtherJumpAddress().addressType == 1) {
                String address = this.f233191h.getOtherJumpAddress().getAddress();
                if (!address.startsWith("http")) {
                    Matcher matcher = Pattern.compile("https?://pd\\.qq\\.com/s\\S+").matcher(address);
                    if (matcher.find()) {
                        address = matcher.group();
                    }
                }
                GuildShareUrlParam guildShareUrlParam = new GuildShareUrlParam(address);
                guildShareUrlParam.a().putInt("businessType", 16);
                GuildJumpUtil.m(view.getContext(), guildShareUrlParam);
            }
        }
    }

    public void g0() {
        GuildScheduleInfo guildScheduleInfo;
        WeakReference<Activity> weakReference = this.f233195l;
        if (weakReference != null && weakReference.get() != null && (guildScheduleInfo = this.f233191h) != null && guildScheduleInfo.getCreator() != null) {
            GuildProfileData guildProfileData = new GuildProfileData(this.f233186c, "", String.valueOf(this.f233191h.getCreator().getTinyId()), 0, 5);
            guildProfileData.getGuildBaseProfileData().r(this.f233187d);
            GuildProfileCard.Lh(this.f233195l.get(), guildProfileData);
        }
    }

    public void h0(ImageView imageView, String str, int i3) {
        int f16 = QQGuildUIUtil.f(i3);
        imageView.setImageDrawable(((IQQGuildAvatarApi) this.f233184a.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(str, f16, f16, (String) null));
    }

    public void j0(final View view) {
        WeakReference<Activity> weakReference = this.f233195l;
        if (weakReference != null && weakReference.get() != null) {
            final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.f233195l.get(), null);
            actionSheet.addButton(R.string.f143030kz, 3);
            actionSheet.addCancelButton(R.string.f140850f3);
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.schedule.detail.j
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view2, int i3) {
                    m.this.Z(view, actionSheet, view2, i3);
                }
            });
            actionSheet.setOnDismissListener(new ap(actionSheet));
            actionSheet.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l0() {
        if (QQGuildUIUtil.v() || this.f233191h == null) {
            return;
        }
        m0();
        if (this.f233194k == null) {
            this.f233194k = K().getChannelInfo(this.f233187d);
        }
        k0();
    }

    public void r() {
        d0(1);
    }

    public void t(View view) {
        WeakReference<Activity> weakReference = this.f233195l;
        if (weakReference != null && weakReference.get() != null) {
            HashMap hashMap = new HashMap();
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f233195l.get(), 230, (String) null, "\u786e\u5b9a\u5220\u9664\u65e5\u7a0b\u6d3b\u52a8\u4e48\uff1f\u5220\u9664\u540e\u4e0d\u53ef\u6062\u590d", R.string.f140850f3, R.string.f142570jq, new f(hashMap), new g(hashMap));
            createCustomDialog.show();
            VideoReport.setLogicParent(createCustomDialog.getRootView(), view);
            i0(createCustomDialog.getRootView(), "em_sgrp_delete_pop");
        }
    }

    public String z() {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        long startTimeMs = this.f233191h.getStartTimeMs();
        long endTimeMs = this.f233191h.getEndTimeMs();
        Calendar.getInstance().setTimeInMillis(serverTimeMillis);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(startTimeMs);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(endTimeMs);
        int i3 = calendar.get(5);
        StringBuilder sb5 = new StringBuilder();
        if (S(startTimeMs, serverTimeMillis)) {
            sb5.append("\u4eca\u5929 ");
            sb5.append(s(startTimeMs, DateUtil.DATE_FORMAT_HOUR));
            sb5.append(" - ");
        } else {
            sb5.append(s(startTimeMs, "MM\u6708dd\u65e5 E HH:mm - "));
        }
        if (i3 == calendar2.get(5)) {
            sb5.append(s(endTimeMs, DateUtil.DATE_FORMAT_HOUR));
        } else {
            sb5.append(s(endTimeMs, "MM\u6708dd\u65e5 E HH:mm"));
        }
        return sb5.toString();
    }
}
