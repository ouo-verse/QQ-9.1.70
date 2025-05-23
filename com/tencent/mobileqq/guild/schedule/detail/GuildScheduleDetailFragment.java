package com.tencent.mobileqq.guild.schedule.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.manager.GuildOpenRecordManager;
import com.tencent.mobileqq.guild.report.GuildChannelReportManager;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleUser;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProOtherJumpAddress;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.text.Charsets;
import yz1.q;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildScheduleDetailFragment extends QQGuildTokenTitleBarFragment implements View.OnClickListener, p {
    private m A0;
    private View B0;
    private ImageView C0;
    private LinearLayout T;
    private TextView U;
    private TextView V;
    private ImageView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f233138a0;

    /* renamed from: b0, reason: collision with root package name */
    private ConstraintLayout f233139b0;

    /* renamed from: c0, reason: collision with root package name */
    private View f233140c0;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f233141d0;

    /* renamed from: e0, reason: collision with root package name */
    private LinearLayout f233142e0;

    /* renamed from: f0, reason: collision with root package name */
    private RoundRectImageView f233143f0;

    /* renamed from: g0, reason: collision with root package name */
    private QUIButton f233144g0;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f233145h0;

    /* renamed from: i0, reason: collision with root package name */
    private TextView f233146i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f233147j0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f233148k0;

    /* renamed from: l0, reason: collision with root package name */
    private LinearLayout f233149l0;

    /* renamed from: m0, reason: collision with root package name */
    private LinearLayout f233150m0;

    /* renamed from: n0, reason: collision with root package name */
    private TextView f233151n0;

    /* renamed from: o0, reason: collision with root package name */
    private ImageView f233152o0;

    /* renamed from: p0, reason: collision with root package name */
    private ImageView f233153p0;

    /* renamed from: q0, reason: collision with root package name */
    private GuildUserAvatarView f233154q0;

    /* renamed from: r0, reason: collision with root package name */
    private TextView f233155r0;

    /* renamed from: s0, reason: collision with root package name */
    private QUIButton f233156s0;

    /* renamed from: t0, reason: collision with root package name */
    private AppInterface f233157t0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f233159v0;

    /* renamed from: x0, reason: collision with root package name */
    private int f233161x0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f233158u0 = false;

    /* renamed from: w0, reason: collision with root package name */
    private int f233160w0 = 0;

    /* renamed from: y0, reason: collision with root package name */
    private Boolean f233162y0 = Boolean.FALSE;

    /* renamed from: z0, reason: collision with root package name */
    private Boolean f233163z0 = Boolean.TRUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GuildScheduleDetailFragment.this.A0 != null) {
                GuildScheduleDetailFragment.this.A0.j0(GuildScheduleDetailFragment.this.N);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GuildScheduleDetailFragment.this.A0 != null) {
                GuildScheduleDetailFragment.this.A0.l0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements IDynamicParams {
        c() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            return GuildScheduleDetailFragment.this.Nh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GuildScheduleDetailFragment.this.A0 != null) {
                GuildScheduleDetailFragment.this.A0.l0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e implements IDynamicParams {
        e() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            return GuildScheduleDetailFragment.this.Nh();
        }
    }

    public GuildScheduleDetailFragment() {
        Logger.f235387a.a("Guild.sch.GuildScheduleDetailFragment", new Function0() { // from class: com.tencent.mobileqq.guild.schedule.detail.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String Wh;
                Wh = GuildScheduleDetailFragment.Wh();
                return Wh;
            }
        });
    }

    private int Mh() {
        return getResources().getColor(R.color.f157782z8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> Nh() {
        String str;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sgrp_channel_id", this.A0.B());
        if (((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).getCurrentUserType(this.A0.B()) != null) {
            str = ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).getCurrentUserType(this.A0.B());
        } else {
            str = "";
        }
        hashMap.put("sgrp_user_type", str);
        hashMap.put(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, Integer.valueOf(GuildSharePageSource.SCHEDULE_DETAIL.ordinal()));
        return hashMap;
    }

    private void Oh(String str) {
        final IGProGuildInfo L = ch.L(str);
        if (L == null) {
            return;
        }
        if (L.isMember()) {
            this.f233144g0.setText("\u53bb\u9891\u9053");
        } else {
            this.f233144g0.setText("\u52a0\u5165\u9891\u9053");
        }
        u.q(L.getAvatarUrl(100), this.f233143f0, true);
        this.f233143f0.setCornerRadiusAndMode(QQGuildUIUtil.f(6.0f), 1);
        this.f233145h0.setText(L.getGuildName());
        if (!TextUtils.isEmpty(L.getProfile())) {
            this.f233146i0.setVisibility(0);
            this.f233146i0.setText(((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(L.getProfile(), 20));
        } else {
            this.f233146i0.setVisibility(8);
        }
        final List<IGProMedalInfo> e16 = q.f451648a.e(L.getMedalInfoList());
        if (e16.isEmpty()) {
            return;
        }
        this.f233145h0.post(new Runnable() { // from class: com.tencent.mobileqq.guild.schedule.detail.GuildScheduleDetailFragment.6
            @Override // java.lang.Runnable
            public void run() {
                GuildMedalUtils.f235347a.v(L.getGuildName(), e16, GuildScheduleDetailFragment.this.f233145h0, new ArrayList<>(), R.color.qui_button_bg_primary_default, null);
            }
        });
    }

    private void Ph() {
        if (this.f233155r0 == null) {
            View inflate = ((ViewStub) this.P.findViewById(R.id.wy9)).inflate();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) inflate.getLayoutParams();
            layoutParams.height = ViewUtils.getScreenHeight() - getTitleBarView().getHeight();
            inflate.setLayoutParams(layoutParams);
            this.f233155r0 = (TextView) this.P.findViewById(R.id.wy_);
        }
        View view = this.B0;
        if (view != null) {
            view.setVisibility(8);
        } else {
            this.P.findViewById(R.id.f165612wy2).setVisibility(8);
        }
    }

    private void Qh() {
        if (this.f233158u0) {
            wh(R.drawable.qui_more, new a());
            ImageView imageView = (ImageView) getTitleBarView().findViewById(R.id.dsn);
            this.C0 = imageView;
            imageView.setImageResource(R.drawable.qui_share_light);
            this.C0.setVisibility(0);
            this.C0.setOnClickListener(new b());
            ei(this.G, "em_sgrp_delete", null);
            ei(this.C0, "em_sgrp_share", new c());
            return;
        }
        wh(R.drawable.qui_share_light, new d());
        ei(this.G, "em_sgrp_share", new e());
    }

    private boolean Rh(GuildScheduleChannelInfo guildScheduleChannelInfo) {
        if (guildScheduleChannelInfo.isPrivate() && !guildScheduleChannelInfo.isHasJoin()) {
            return true;
        }
        return false;
    }

    private boolean Sh(GProOtherJumpAddress gProOtherJumpAddress) {
        if (gProOtherJumpAddress == null || gProOtherJumpAddress.addressType == 0) {
            return false;
        }
        return true;
    }

    private boolean Th(GuildScheduleChannelInfo guildScheduleChannelInfo) {
        if (guildScheduleChannelInfo == null) {
            return false;
        }
        if (guildScheduleChannelInfo.getGuildId() == 0 && guildScheduleChannelInfo.getChannelId() == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String Uh() {
        return "doOnCreateView";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String Vh() {
        return "finish page";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String Wh() {
        return "GuildScheduleDetailFragment create";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String Yh() {
        return "onResume";
    }

    public static Intent ai(Context context, GuildScheduleInfo guildScheduleInfo, String str, String str2, String str3, JumpGuildParam jumpGuildParam) {
        return m.c0(context, guildScheduleInfo, str, str2, str3, jumpGuildParam);
    }

    public static void bi(Context context, String str, JumpGuildParam jumpGuildParam) {
        o02.a.f(4);
        Intent c06 = m.c0(context, null, jumpGuildParam.getGuildId(), jumpGuildParam.getChannelId(), str, jumpGuildParam);
        QLog.d("Guild.sch.GuildScheduleDetailFragment", 1, "open scheduleId ", str, " jumpGuildParam:", jumpGuildParam);
        GuildSplitViewUtils.f235370a.o(context, c06, GuildScheduleDetailFragment.class, LaunchMode.standard);
    }

    private void ci(int i3) {
        ImageView imageView = this.f233153p0;
        imageView.setImageDrawable(GuildUIUtils.w(imageView.getContext(), i3, Integer.valueOf(R.color.qui_common_text_primary)));
    }

    private void di(GuildScheduleInfo guildScheduleInfo) {
        if (!this.f233163z0.booleanValue()) {
            this.f233149l0.setVisibility(8);
            return;
        }
        GuildScheduleChannelInfo channelInfo = guildScheduleInfo.getChannelInfo();
        GProOtherJumpAddress otherJumpAddress = guildScheduleInfo.getOtherJumpAddress();
        if (!Th(channelInfo) && !Sh(otherJumpAddress)) {
            this.f233149l0.setVisibility(8);
            return;
        }
        this.f233149l0.setVisibility(0);
        if (!Th(channelInfo) && Sh(otherJumpAddress)) {
            int i3 = otherJumpAddress.addressType;
            if (i3 == 1) {
                this.f233152o0.setVisibility(0);
                this.f233151n0.setText("\u5e16\u5b50: " + otherJumpAddress.feedAbstract);
                return;
            }
            if (i3 == 2) {
                this.f233152o0.setVisibility(8);
                this.f233151n0.setText(otherJumpAddress.address);
                return;
            }
            return;
        }
        if (Th(channelInfo) && !Rh(channelInfo)) {
            this.f233153p0.setVisibility(0);
            ci(yo1.c.f450725a.c(channelInfo));
            this.f233151n0.setText(channelInfo.getChannelName());
            this.f233152o0.setVisibility(0);
            return;
        }
        this.f233149l0.setVisibility(8);
    }

    private void ei(View view, String str, IDynamicParams iDynamicParams) {
        VideoReport.setElementId(view, str);
        VideoReport.setEventDynamicParams(view, iDynamicParams);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    private void fi() {
        if (this.f233162y0.booleanValue()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_acceptance_status", Integer.valueOf(this.A0.G()));
        hashMap.put("sgrp_event_status", Integer.valueOf(this.A0.I()));
        hashMap.put("sgrp_creator_status", Integer.valueOf(this.A0.H()));
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("sgrp_channel_id", this.A0.B());
        hashMap.put("sgrp_user_type", Integer.valueOf(this.A0.J()));
        hashMap.put("sgrp_sub_channel_id", this.A0.A());
        if (this.A0.C() != null) {
            hashMap.put("sgrp_schedular_id", Long.valueOf(this.A0.C().getScheduleId()));
        }
        w.a(hashMap);
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        if (getActivity() != null && getActivity().getIntent() != null) {
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setOpenGuildSourceParams((Bundle) getActivity().getIntent().getParcelableExtra("GuildAppReportSourceInfo"), hashMap);
        }
        if (getActivity() != null) {
            VideoReport.addToDetectionWhitelist(getActivity());
        }
        VideoReport.setPageId(this.N, "pg_sgrp_event_information");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.N, this.A0.B(), hashMap);
        this.f233162y0 = Boolean.TRUE;
    }

    private void gi(GuildScheduleInfo guildScheduleInfo) {
        boolean z16;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        long startTimeMs = guildScheduleInfo.getStartTimeMs();
        long endTimeMs = guildScheduleInfo.getEndTimeMs();
        if (serverTimeMillis < startTimeMs) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f233159v0 = z16;
        if (endTimeMs < serverTimeMillis) {
            this.f233161x0 = 3;
            hi("\u5df2\u8fc7\u671f", R.color.qui_common_text_secondary_light, R.drawable.guild_background_text_secondary);
        } else if (serverTimeMillis > startTimeMs && serverTimeMillis < endTimeMs) {
            this.f233161x0 = 2;
            hi("\u6d3b\u52a8\u4e2d", R.color.qui_common_brand_standard, R.drawable.guild_background_round_brand_standard);
        } else if (z16) {
            this.f233161x0 = 1;
            this.V.setVisibility(8);
            this.U.setVisibility(8);
        } else {
            this.U.setVisibility(8);
            this.V.setVisibility(8);
        }
        ji(guildScheduleInfo);
    }

    private void hi(String str, int i3, int i16) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" ");
        sb5.append(" ");
        sb5.append(str);
        sb5.append(" ");
        sb5.append(this.A0.z());
        SpannableString spannableString = new SpannableString(sb5.toString());
        Drawable drawable = this.Z.getContext().getResources().getDrawable(i16);
        drawable.setBounds(0, 0, ViewUtils.dpToPx(8.0f), ViewUtils.dpToPx(8.0f));
        spannableString.setSpan(new yo1.a(drawable), 0, 1, 33);
        spannableString.setSpan(new yo1.b(4.0f), 1, 2, 33);
        Context context = this.Z.getContext();
        spannableString.setSpan(new ForegroundColorSpan(QQGuildUIUtil.i(context, i3)), 2, str.length() + 2, 33);
        spannableString.setSpan(new yo1.b(8.0f), str.length() + 2, str.length() + 3, 33);
        spannableString.setSpan(new ForegroundColorSpan(QQGuildUIUtil.i(context, R.color.qui_common_text_primary)), str.length() + 4, sb5.length(), 33);
        this.Z.setText(spannableString);
    }

    public static void ii(QPublicBaseFragment qPublicBaseFragment, Context context, String str, JumpGuildParam jumpGuildParam, int i3) {
        o02.a.f(4);
        GuildSplitViewUtils.f235370a.q(context, qPublicBaseFragment, m.c0(context, null, jumpGuildParam.getGuildId(), jumpGuildParam.getChannelId(), str, jumpGuildParam), GuildScheduleDetailFragment.class, i3);
    }

    private void initData() {
        AppInterface l3 = ch.l();
        this.f233157t0 = l3;
        m mVar = new m(l3, this);
        this.A0 = mVar;
        mVar.O(getActivity(), this);
    }

    private void initReport() {
        ei(this.f233149l0, "em_sgrp_address", null);
        ei(this.T, "em_sgrp_organizer", null);
        ei(this.f233142e0, "em_sgrp_info_region", null);
        ei(this.f233144g0, "em_sgrp_info_region_join", null);
    }

    @Override // com.tencent.mobileqq.guild.schedule.detail.p
    public void Ba() {
        Oh(this.A0.B());
    }

    @Override // com.tencent.mobileqq.guild.schedule.detail.p
    public void D6(String str) {
        fi();
        Ph();
        this.f233155r0.setText(str);
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        QLog.e("Guild.sch.GuildScheduleDetailFragment", 1, "showFailView failed. Result = " + str);
    }

    @Override // com.tencent.mobileqq.guild.schedule.detail.p
    public void D9(GuildScheduleInfo guildScheduleInfo, int i3, boolean z16) {
        LinearLayout linearLayout = this.f233150m0;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        fi();
        if (!isAdded()) {
            QLog.e("Guild.sch.GuildScheduleDetailFragment", 1, "setView but fragment isAdded false");
            return;
        }
        this.f233158u0 = this.A0.R();
        Qh();
        this.Y.setText(guildScheduleInfo.getTitle());
        this.Z.setText(this.A0.z());
        gi(guildScheduleInfo);
        GuildScheduleUser creator = guildScheduleInfo.getCreator();
        if (creator != null) {
            this.A0.h0(this.W, creator.getAvatar(), 23);
            this.X.setText(((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(creator.getNick(), 20));
        }
        String content = guildScheduleInfo.getContent();
        LinearLayout linearLayout2 = (LinearLayout) this.P.findViewById(R.id.wy5);
        View findViewById = this.P.findViewById(R.id.f165614wy4);
        if (!TextUtils.isEmpty(content)) {
            linearLayout2.setVisibility(0);
            findViewById.setVisibility(0);
            this.f233138a0.setMovementMethod(LinkMovementMethod.getInstance());
            this.f233138a0.setText(ty1.c.a(getContext(), content, Mh()));
        } else {
            linearLayout2.setVisibility(8);
            findViewById.setVisibility(8);
        }
        Oh(this.A0.B());
        di(guildScheduleInfo);
        Ed();
    }

    @Override // com.tencent.mobileqq.guild.schedule.detail.p
    public void Ed() {
        QLog.i("Guild.sch.GuildScheduleDetailFragment", 1, "[hideJoinChannelLayout]" + this.A0.M());
        if (this.A0.M() && !GuildOpenRecordManager.g(this.A0.B())) {
            QLog.i("Guild.sch.GuildScheduleDetailFragment", 1, "[setMemberBottomView] has same guild");
            this.f233142e0.setVisibility(8);
            this.f233141d0.setVisibility(8);
            this.f233140c0.setVisibility(8);
        } else {
            this.f233142e0.setVisibility(0);
            this.f233141d0.setVisibility(0);
            this.f233140c0.setVisibility(0);
        }
        if (this.A0.M()) {
            this.f233144g0.setText("\u53bb\u9891\u9053");
        } else {
            this.f233144g0.setText("\u52a0\u5165\u9891\u9053");
        }
    }

    @Override // com.tencent.mobileqq.guild.schedule.detail.p
    public void Na(Boolean bool) {
        this.f233163z0 = bool;
        if (bool.booleanValue()) {
            this.f233149l0.setVisibility(0);
        } else {
            this.f233149l0.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.guild.schedule.detail.p
    public void Ua(List<IGProGuildLabel> list) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < list.size(); i3++) {
            sb5.append(new String(list.get(i3).getLabelName(), Charsets.UTF_8));
            if (i3 < list.size() - 1) {
                sb5.append("\u00b7");
            }
        }
        this.f233147j0.setText(sb5.toString());
    }

    @Override // com.tencent.mobileqq.guild.schedule.detail.p
    public void V2(GuildScheduleInfo guildScheduleInfo, int i3, boolean z16) {
        gi(guildScheduleInfo);
    }

    @Override // com.tencent.mobileqq.guild.schedule.detail.p
    public void bf() {
        if (this.f233154q0 != null) {
            this.f233154q0.setAvatarTinyId(this.A0.B(), ((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Logger.f235387a.a("Guild.sch.GuildScheduleDetailFragment", new Function0() { // from class: com.tencent.mobileqq.guild.schedule.detail.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String Uh;
                Uh = GuildScheduleDetailFragment.Uh();
                return Uh;
            }
        });
        setTitle("\u65e5\u7a0b\u8be6\u60c5");
        rh();
        this.B0 = this.P.findViewById(R.id.f165613wy3);
        this.f233150m0 = (LinearLayout) this.P.findViewById(R.id.u8o);
        this.U = (TextView) this.P.findViewById(R.id.wyk);
        this.V = (TextView) this.P.findViewById(R.id.wyi);
        ImageView imageView = (ImageView) this.P.findViewById(R.id.wxx);
        this.W = imageView;
        imageView.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.P.findViewById(R.id.wxo);
        this.T = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView = (TextView) this.P.findViewById(R.id.wyf);
        this.X = textView;
        textView.setOnClickListener(this);
        this.Y = (TextView) this.P.findViewById(R.id.wye);
        this.Z = (TextView) this.P.findViewById(R.id.wyl);
        this.f233138a0 = (TextView) this.P.findViewById(R.id.wy6);
        this.f233140c0 = this.P.findViewById(R.id.wjj);
        this.f233141d0 = (TextView) this.P.findViewById(R.id.x2d);
        LinearLayout linearLayout2 = (LinearLayout) this.P.findViewById(R.id.wjm);
        this.f233142e0 = linearLayout2;
        linearLayout2.setOnClickListener(this);
        this.f233143f0 = (RoundRectImageView) this.P.findViewById(R.id.f165437w02);
        QUIButton qUIButton = (QUIButton) this.P.findViewById(R.id.wkv);
        this.f233144g0 = qUIButton;
        qUIButton.setOnClickListener(this);
        this.f233145h0 = (TextView) this.P.findViewById(R.id.wrw);
        this.f233147j0 = (TextView) this.P.findViewById(R.id.wl9);
        this.f233146i0 = (TextView) this.P.findViewById(R.id.wty);
        this.f233156s0 = (QUIButton) this.P.findViewById(R.id.f80024ac);
        this.f233139b0 = (ConstraintLayout) this.P.findViewById(R.id.f80034ad);
        this.f233156s0.setOnClickListener(this);
        View findViewById = this.P.findViewById(R.id.iql);
        findViewById.setBackground(GuildUIUtils.f235378a.i(findViewById.getContext().getResources().getColor(R.color.qui_common_bg_bottom_light), findViewById.getContext().getResources().getColor(R.color.ajr), 255));
        this.f233148k0 = (TextView) this.P.findViewById(R.id.wyh);
        LinearLayout linearLayout3 = (LinearLayout) this.P.findViewById(R.id.wxz);
        this.f233149l0 = linearLayout3;
        linearLayout3.setOnClickListener(this);
        this.f233151n0 = (TextView) this.P.findViewById(R.id.f165610wy0);
        this.f233152o0 = (ImageView) this.P.findViewById(R.id.wxy);
        this.f233153p0 = (ImageView) this.P.findViewById(R.id.f79874_y);
        if (QQTheme.isVasTheme()) {
            this.C.setBackground(GuildUIUtils.w(this.f233153p0.getContext(), R.drawable.guild_audio_top_back_left_btn, Integer.valueOf(R.color.qui_common_text_primary)));
            TextView textView2 = this.E;
            textView2.setTextColor(textView2.getContext().getResources().getColor(R.color.qui_common_text_primary));
        }
        initData();
        initReport();
        Qh();
        vh1.k.INSTANCE.b(this.A0.B(), "GuildScheduleDetailFragment");
        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
        guildSplitViewUtils.B(this.N);
        guildSplitViewUtils.A(getActivity(), this.N, R.drawable.qui_common_bg_bottom_light_bg);
    }

    @Override // com.tencent.mobileqq.guild.schedule.detail.p
    public void fb(GuildScheduleInfo guildScheduleInfo) {
        Logger.f235387a.a("Guild.sch.GuildScheduleDetailFragment", new Function0() { // from class: com.tencent.mobileqq.guild.schedule.detail.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String Vh;
                Vh = GuildScheduleDetailFragment.Vh();
                return Vh;
            }
        });
        if (getActivity() != null && !getActivity().isFinishing()) {
            Intent intent = new Intent();
            intent.putExtra("success_schedule_info", guildScheduleInfo);
            GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
            if (guildSplitViewUtils.n(getContext())) {
                getActivity().getSupportFragmentManager().setFragmentResult(String.valueOf(100), intent.getExtras());
            } else {
                getActivity().setResult(-1, intent);
            }
            guildSplitViewUtils.t(getActivity(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f77;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        JumpGuildParam jumpGuildParam = (JumpGuildParam) activity.getIntent().getExtras().getSerializable("join_guild_param");
        if (jumpGuildParam != null && jumpGuildParam.extras.getBoolean("jumpGuildFromLoadingPage", false)) {
            activity.overridePendingTransition(R.anim.l_, R.anim.l_);
        } else {
            activity.overridePendingTransition(R.anim.f154625ox, R.anim.f154626oy);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return true;
    }

    public void ji(GuildScheduleInfo guildScheduleInfo) {
        this.f233160w0 = guildScheduleInfo.getInviteStatus();
        if (this.f233161x0 == 2) {
            this.f233139b0.setVisibility(0);
            this.f233156s0.setText("\u7acb\u5373\u53c2\u52a0");
            this.f233156s0.setType(0);
            if (Sh(guildScheduleInfo.getOtherJumpAddress()) && !Th(guildScheduleInfo.getChannelInfo()) && guildScheduleInfo.getOtherJumpAddress().addressType == 2) {
                this.f233139b0.setVisibility(8);
            }
            if (!Sh(guildScheduleInfo.getOtherJumpAddress()) && !Th(guildScheduleInfo.getChannelInfo())) {
                this.f233139b0.setVisibility(8);
            }
            ei(this.f233156s0, "em_sgrp_join_event", null);
            return;
        }
        this.f233139b0.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.f235370a.t(getActivity(), false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!com.tencent.mobileqq.guild.util.o.c("Guild.sch.GuildScheduleDetailFragment")) {
            int id5 = view.getId();
            if (id5 != R.id.wxx && id5 != R.id.wyf && id5 != R.id.wxo) {
                if (id5 == R.id.f80024ac) {
                    if (!this.A0.M()) {
                        this.A0.V(getQBaseActivity());
                    } else if (this.f233161x0 == 2) {
                        this.A0.f0(view, getQBaseActivity());
                    }
                } else if (id5 == R.id.wkv) {
                    if (this.A0.M()) {
                        this.A0.L();
                    } else {
                        this.A0.U(false);
                    }
                } else if (id5 == R.id.wjm) {
                    this.A0.L();
                } else if (id5 == R.id.wxz) {
                    this.A0.f0(view, getQBaseActivity());
                }
            } else if (!this.A0.M()) {
                this.A0.V(getQBaseActivity());
            } else {
                this.A0.g0();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Logger.f235387a.a("Guild.sch.GuildScheduleDetailFragment", new Function0() { // from class: com.tencent.mobileqq.guild.schedule.detail.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String str;
                str = MosaicConstants$JsFunction.FUNC_ON_DESTROY;
                return str;
            }
        });
        this.A0.e0();
        GuildChannelReportManager.f231987a.g(GuildChannelReportManager.PageType.CHANNEL_PAGE_SCHEDULE_DETAIL);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (GuildSplitViewUtils.f235370a.n(getContext())) {
            this.f233155r0 = null;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Logger.f235387a.a("Guild.sch.GuildScheduleDetailFragment", new Function0() { // from class: com.tencent.mobileqq.guild.schedule.detail.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String Yh;
                Yh = GuildScheduleDetailFragment.Yh();
                return Yh;
            }
        });
        GuildChannelReportManager.f231987a.e(GuildChannelReportManager.PageType.CHANNEL_PAGE_SCHEDULE_DETAIL, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Logger.f235387a.a("Guild.sch.GuildScheduleDetailFragment", new Function0() { // from class: com.tencent.mobileqq.guild.schedule.detail.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String str;
                str = DKHippyEvent.EVENT_STOP;
                return str;
            }
        });
        GuildChannelReportManager.f231987a.f(GuildChannelReportManager.PageType.CHANNEL_PAGE_SCHEDULE_DETAIL, null);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        super.rh();
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.J;
        if (guildDefaultThemeNavBarCommon != null) {
            guildDefaultThemeNavBarCommon.a();
            this.J.setBackgroundResource(R.drawable.lvj);
        }
    }

    @Override // com.tencent.mobileqq.guild.schedule.detail.p
    public void x7(Boolean bool) {
        this.f233158u0 = bool.booleanValue();
        Qh();
    }
}
