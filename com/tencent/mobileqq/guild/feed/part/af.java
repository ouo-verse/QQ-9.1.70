package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.event.GuildJoinSuccessEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedThemeChangeEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.GuildGuestBottomLayout;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import vh2.bv;

/* compiled from: P */
/* loaded from: classes13.dex */
public class af extends f {

    /* renamed from: h, reason: collision with root package name */
    private GuildGuestBottomLayout f222499h;

    /* renamed from: i, reason: collision with root package name */
    private or1.b f222500i = null;

    private void F9() {
        if (this.f222499h == null) {
            return;
        }
        GuildFeedMainInitBean x95 = x9();
        if (x95.isMember()) {
            this.f222499h.setVisibility(8);
            return;
        }
        GuildMainFrameUtils.k(x95.getGuildId(), new Function1() { // from class: com.tencent.mobileqq.guild.feed.part.ab
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit N9;
                N9 = af.this.N9((IGProGuildInfo) obj);
                return N9;
            }
        });
        this.f222499h.setJoinButtonClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.part.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                af.this.O9(view);
            }
        });
        this.f222499h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.part.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                af.P9(view);
            }
        });
        if (x95.getBusinessType() == 15 || x95.getBusinessType() == 14) {
            this.f222499h.b();
        }
    }

    private boolean G9(IGProSecurityResult iGProSecurityResult) {
        if (iGProSecurityResult != null && iGProSecurityResult.get$actionCode() != 0) {
            return false;
        }
        return true;
    }

    private void H9() {
        or1.b bVar = this.f222500i;
        if (bVar != null) {
            bVar.a();
            this.f222500i = null;
        }
    }

    private String I9(int i3) {
        switch (i3) {
            case 22006:
                return HardCodeUtil.qqStr(R.string.f147070vw);
            case 22007:
                return HardCodeUtil.qqStr(R.string.f147030vs);
            case 22008:
                return HardCodeUtil.qqStr(R.string.f147010vq);
            case 22009:
            case 22010:
                return HardCodeUtil.qqStr(R.string.f147020vr);
            default:
                return HardCodeUtil.qqStr(R.string.f138610_1);
        }
    }

    private void J9(int i3, String str, IGProSecurityResult iGProSecurityResult) {
        if (i3 != 0) {
            com.tencent.mobileqq.guild.util.security.b.c(getContext(), i3, str, I9(i3));
        } else {
            if (!G9(iGProSecurityResult)) {
                SecurityTipHelperKt.H(getContext(), iGProSecurityResult, HardCodeUtil.qqStr(R.string.f138610_1));
                return;
            }
            this.f222499h.setVisibility(8);
            H9();
            SimpleEventBus.getInstance().dispatchEvent(new GuildJoinSuccessEvent(x9().getChannelId()));
        }
    }

    private void K9() {
        if (this.f222499h != null) {
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.f222499h.a(), "em_sgrp_forum_join", null);
        }
    }

    private void L9() {
        H9();
        GuildFeedMainInitBean x95 = x9();
        String guildId = x95.getGuildId();
        JumpGuildParam jumpGuildParam = new JumpGuildParam(guildId, x95.getChannelId(), x95.getJoinInfoParam());
        jumpGuildParam.extras.putInt(JumpGuildParam.EXTRA_KEY_OPEN_FROM, x95.getOpenFrom());
        this.f222500i = new or1.b(null, "feed_" + guildId, jumpGuildParam);
    }

    private void M9() {
        GuildFeedMainInitBean x95 = x9();
        IQQGuildService iQQGuildService = (IQQGuildService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).appInterface().getRuntimeService(IQQGuildService.class, "");
        if (x95 == null) {
            return;
        }
        JumpGuildParam jumpGuildParam = new JumpGuildParam(x95.getGuildId(), x95.getChannelId(), x95.getJoinInfoParam());
        if (x95.getJoinInfoParam() != null && !TextUtils.isEmpty(x95.getJoinInfoParam().getMainSource())) {
            jumpGuildParam.setMainAndSubSource(x95.getJoinInfoParam().getMainSource(), x95.getJoinInfoParam().getSubSource());
        }
        iQQGuildService.addGuild(getContext(), jumpGuildParam, "GuildFeedGuestBottomPart", new bv() { // from class: com.tencent.mobileqq.guild.feed.part.ae
            @Override // vh2.bv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                af.this.Q9(i3, str, iGProSecurityResult, iGProJoinGuildResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit N9(IGProGuildInfo iGProGuildInfo) {
        boolean z16;
        if (iGProGuildInfo == null) {
            QLog.e("GuildFeedGuestBottomPart", 1, "tryFetchGuestGuildInfo is null!");
            return Unit.INSTANCE;
        }
        if (iGProGuildInfo.isVisibleForVisitor() && iGProGuildInfo.isInteractiveForVisitor()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("GuildFeedGuestBottomPart", 1, "[bindData] fetchGuildInfoAnyway " + z16);
        if (!iGProGuildInfo.isMember() && !z16) {
            this.f222499h.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        M9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q9(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        J9(i3, str, iGProSecurityResult);
    }

    private void R9(View view) {
        if (view == null) {
            return;
        }
        if (QQTheme.isNowThemeIsNight()) {
            view.setBackgroundColor(getContext().getResources().getColor(R.color.bnr));
        } else {
            view.setBackgroundColor(getContext().getResources().getColor(R.color.bns));
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(GuildFeedThemeChangeEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (x9() != null && !x9().isMember()) {
            this.f222499h = (GuildGuestBottomLayout) view.findViewById(R.id.w9q);
            K9();
            F9();
            L9();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.f, com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        H9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        or1.b bVar = this.f222500i;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        or1.b bVar = this.f222500i;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFeedThemeChangeEvent) {
            R9(this.f222499h);
        }
        super.onReceiveEvent(simpleBaseEvent);
    }
}
