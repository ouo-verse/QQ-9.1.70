package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.publish.event.GuildRemoveCapsuleEvent;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.cw;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.troopguild.api.ITroopGuildUnreadCntService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedMessageCapsule extends GuildBaseWidgetView<ij1.g> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private View f224149d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f224150e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f224151f;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f224152h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f224153i;

    /* renamed from: m, reason: collision with root package name */
    private GuildFeedDefaultInitBean f224154m;

    public GuildFeedMessageCapsule(@NonNull Context context, int i3, GuildFeedDefaultInitBean guildFeedDefaultInitBean) {
        super(context, Integer.valueOf(i3));
        n0(this);
        this.f224154m = guildFeedDefaultInitBean;
    }

    private void l0() {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_message_num", Integer.valueOf(m0()));
        com.tencent.mobileqq.guild.feed.report.d.d(this.f224149d, "em_sgrp_forum_msg", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_ALL, hashMap);
    }

    private int m0() {
        GuildFeedDefaultInitBean guildFeedDefaultInitBean = this.f224154m;
        if (guildFeedDefaultInitBean != null && guildFeedDefaultInitBean.getBusinessType() == 7) {
            uo4.f unreadCntInfo = ((ITroopGuildUnreadCntService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopGuildUnreadCntService.class, "")).getUnreadCntInfo(this.f224154m.getTroopUin());
            QLog.d("GuildFeedMessageCapsule", 1, "getUnreadCnt = " + unreadCntInfo.getUnreadCntInfo().getAtmeUnreadCnt().getCnt());
            return unreadCntInfo.getUnreadCntInfo().getAtmeUnreadCnt().getCnt();
        }
        QLog.d("GuildFeedMessageCapsule", 1, "is not troop, return 0 = ");
        return 0;
    }

    private void n0(View view) {
        this.f224149d = view.findViewById(R.id.wbu);
        this.f224150e = (ImageView) view.findViewById(R.id.wa8);
        this.f224151f = (ImageView) view.findViewById(R.id.wa9);
        this.f224152h = (RelativeLayout) view.findViewById(R.id.wab);
        this.f224153i = (TextView) view.findViewById(R.id.wax);
        this.f224149d.setOnClickListener(this);
        setLayoutParams(getPreLoadLayoutParams());
    }

    private void o0(List<String> list) {
        AppRuntime peekAppRuntime;
        if (list == null || list.size() == 0 || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        IGPSService iGPSService = (IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "");
        com.tencent.mobileqq.guild.u.l(this.f224150e, iGPSService.getFullAvatarUrl(new cw("0", list.get(0)), 3), null);
        if (list.size() > 1) {
            com.tencent.mobileqq.guild.u.l(this.f224151f, iGPSService.getFullAvatarUrl(new cw("0", list.get(1)), 3), null);
            this.f224152h.setVisibility(0);
        } else {
            this.f224152h.setVisibility(8);
        }
    }

    private void p0(int i3) {
        if (i3 == 1) {
            this.f224152h.setVisibility(8);
        } else {
            this.f224152h.setVisibility(0);
        }
    }

    private void q0(ij1.g gVar) {
        String str = gVar.n().text;
        QLog.d("GuildFeedMessageCapsule", 1, "updateUnReadMsgText, text = " + str);
        if (!TextUtils.isEmpty(str)) {
            this.f224153i.setText(getContext().getString(R.string.f144410op));
            this.f224149d.setVisibility(0);
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new GuildRemoveCapsuleEvent(this.f224154m.getGuildId()));
            this.f224149d.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.epj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @NonNull
    public FrameLayout.LayoutParams getPreLoadLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(ij1.g gVar, int i3) {
        if (gVar != null && gVar.n() != null) {
            q0(gVar);
            ArrayList<String> a16 = ij1.c.a(gVar.n());
            p0(a16.size());
            o0(a16);
            l0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f224154m != null) {
            GuildFeedLauncher.J(getContext(), this.f224154m.getGuildId(), this.f224154m.getChannelId(), this.f224154m.getTroopUin(), 1);
            SimpleEventBus.getInstance().dispatchEvent(new GuildRemoveCapsuleEvent(this.f224154m.getGuildId()));
        } else {
            QLog.e("GuildFeedMessageCapsule", 1, "launchTroopFeedNoticeActivity error for initBean is null");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
