package com.tencent.mobileqq.guild.schedule.create;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.schedule.create.GuildScheduleCreateFragment;
import com.tencent.mobileqq.guild.schedule.create.n;
import com.tencent.mobileqq.guild.schedule.create.timepicker.GuildScheduleIphonePickerView;
import com.tencent.mobileqq.guild.schedule.create.timepicker.b;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.util.InputMethodUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildScheduleCreateFragment extends QQGuildTitleBarFragment implements View.OnClickListener {

    /* renamed from: m0, reason: collision with root package name */
    public static String f233053m0 = "Guild.sch.GuildScheduleCreateFragment";
    private com.tencent.mobileqq.guild.schedule.create.n T;
    private CharacterCountEditText U;
    private View V;
    private View W;
    private CharacterCountEditText X;
    private TextView Y;
    private View Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f233054a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f233055b0;

    /* renamed from: c0, reason: collision with root package name */
    private View f233056c0;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f233057d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f233058e0;

    /* renamed from: f0, reason: collision with root package name */
    private View f233059f0;

    /* renamed from: g0, reason: collision with root package name */
    private TextView f233060g0;

    /* renamed from: h0, reason: collision with root package name */
    private ImageView f233061h0;

    /* renamed from: i0, reason: collision with root package name */
    private View f233062i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f233063j0;

    /* renamed from: k0, reason: collision with root package name */
    private com.tencent.mobileqq.guild.schedule.create.timepicker.b f233064k0;

    /* renamed from: l0, reason: collision with root package name */
    private com.tencent.mobileqq.guild.schedule.create.timepicker.b f233065l0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements n.f {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String c(String str, int i3) {
            return "\u65e5\u7a0b\u521b\u5efa\u7f16\u8f91\u5931\u8d25" + str + i3;
        }

        @Override // com.tencent.mobileqq.guild.schedule.create.n.f
        public void a(boolean z16, final int i3, final String str, GuildScheduleInfo guildScheduleInfo) {
            boolean z17;
            Logger logger = Logger.f235387a;
            if (i3 != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            logger.f(z17, GuildScheduleCreateFragment.f233053m0, new Function0() { // from class: com.tencent.mobileqq.guild.schedule.create.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String c16;
                    c16 = GuildScheduleCreateFragment.a.c(str, i3);
                    return c16;
                }
            });
            ty1.a.b("gpro_quality#event#schedule_channel_publish", "schedule_publish_result", ty1.a.e("schedule_publish_result_code", String.valueOf(i3), "schedule_publish_result_msg", str));
            ty1.a.f("gpro_quality#event#schedule_channel_publish", "ret", String.valueOf(i3));
            ty1.a.f("gpro_quality#event#schedule_channel_publish", "msg", str);
            if (z16) {
                if (i3 == 0) {
                    aa.h("\u65e5\u7a0b\u521b\u5efa\u6210\u529f!");
                    GuildScheduleCreateFragment.this.si();
                } else {
                    aa.e(str);
                }
            } else if (i3 == 0) {
                aa.h("\u65e5\u7a0b\u7f16\u8f91\u6210\u529f!");
                GuildScheduleCreateFragment.this.si();
            } else {
                aa.e(str);
            }
            if (i3 == 4000 || i3 == 40001) {
                GuildScheduleCreateFragment.this.xi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements b.c {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.schedule.create.timepicker.b.c
        public void a(int i3, int i16, int i17) {
            long g16 = com.tencent.mobileqq.guild.schedule.create.timepicker.a.g(GuildScheduleCreateFragment.this.f233064k0, i3, i16, i17);
            ty1.a.b("gpro_quality#event#schedule_channel_publish", "schedule_publish_start_time_picked", ty1.a.e("schedule_publish_desc", String.valueOf(g16)));
            if (!com.tencent.mobileqq.guild.schedule.create.m.g(g16)) {
                aa.g("\u65e5\u7a0b\u9009\u62e9\u65f6\u95f4\u5c0f\u4e8e\u5f53\u524d\u65f6\u95f4, \u8bf7\u91cd\u65b0\u9009\u62e9!");
                return;
            }
            GuildScheduleCreateFragment.this.f233064k0.m();
            GuildScheduleCreateFragment.this.T.p2(g16);
            Long value = GuildScheduleCreateFragment.this.T.a2().getValue();
            if (value != null && com.tencent.mobileqq.guild.schedule.create.m.f(g16, value.longValue()) != 0) {
                GuildScheduleCreateFragment.this.T.l2(g16 + 3600000);
            }
            GuildScheduleCreateFragment.this.T.j2(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements b.c {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.schedule.create.timepicker.b.c
        public void a(int i3, int i16, int i17) {
            long g16 = com.tencent.mobileqq.guild.schedule.create.timepicker.a.g(GuildScheduleCreateFragment.this.f233065l0, i3, i16, i17);
            ty1.a.b("gpro_quality#event#schedule_channel_publish", "schedule_publish_end_time_picked", ty1.a.e("schedule_publish_end_time", String.valueOf(g16)));
            GuildScheduleCreateFragment.this.f233065l0.m();
            GuildScheduleCreateFragment.this.T.l2(g16);
            GuildScheduleCreateFragment.this.T.j2(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f implements b.e {
        f() {
        }

        @Override // com.tencent.mobileqq.guild.schedule.create.timepicker.b.e
        public void onItemSelected(int i3, int i16) {
            Long value;
            GuildScheduleIphonePickerView.h n3 = GuildScheduleCreateFragment.this.f233065l0.n();
            if ((n3 instanceof com.tencent.mobileqq.guild.schedule.create.timepicker.a) && (value = GuildScheduleCreateFragment.this.T.e2().getValue()) != null && GuildScheduleCreateFragment.this.f233065l0.o() <= value.longValue()) {
                com.tencent.mobileqq.guild.schedule.create.timepicker.a.i(GuildScheduleCreateFragment.this.f233065l0, (com.tencent.mobileqq.guild.schedule.create.timepicker.a) n3, value.longValue() + 60000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class g implements IDynamicParams {
        g() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_subchannel_type", Integer.valueOf(GuildScheduleCreateFragment.this.T.getChannelType()));
            hashMap.put("sgrp_sub_appchannel_appid", Long.valueOf(GuildScheduleCreateFragment.this.T.getAppId()));
            hashMap.put("sgrp_notice_time", GuildScheduleCreateFragment.this.T.W1());
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class j implements View.OnFocusChangeListener {
        j() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (z16) {
                GuildScheduleCreateFragment.this.Y.setVisibility(0);
            } else {
                GuildScheduleCreateFragment.this.Y.setVisibility(8);
                ty1.a.b("gpro_quality#event#schedule_channel_publish", "schedule_publish_desc", ty1.a.e("schedule_publish_desc", GuildScheduleCreateFragment.this.X.getText().toString()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            InputMethodUtil.hide(GuildScheduleCreateFragment.this.getActivity());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GuildScheduleCreateFragment.this.vi();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.d(GuildScheduleCreateFragment.f233053m0, 2000L)) {
                ty1.a.a("gpro_quality#event#schedule_channel_publish", "schedule_publish_complete");
                GuildScheduleCreateFragment.this.Vh();
                InputMethodUtil.hide(GuildScheduleCreateFragment.this.getActivity());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void Ai() {
        ty1.a.a("gpro_quality#event#schedule_channel_publish", "schedule_publish_st_channel");
        this.T.r2(this);
    }

    private void Bi() {
        ty1.a.a("gpro_quality#event#schedule_channel_publish", "schedule_publish_start_time");
        if (this.f233064k0.n() instanceof com.tencent.mobileqq.guild.schedule.create.timepicker.a) {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            Long value = this.T.e2().getValue();
            if (value == null) {
                value = Long.valueOf(serverTimeMillis);
            }
            com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar = this.f233064k0;
            com.tencent.mobileqq.guild.schedule.create.timepicker.a.i(bVar, (com.tencent.mobileqq.guild.schedule.create.timepicker.a) bVar.n(), value.longValue());
        }
        this.f233064k0.t();
    }

    private void Wh() {
        this.T.n2("");
    }

    private void Xh(View view) {
        Object parent = this.P.getParent();
        if (parent instanceof View) {
            ((View) parent).setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        }
        this.U = (CharacterCountEditText) view.findViewById(R.id.ux_);
        this.V = view.findViewById(R.id.f165934y44);
        this.W = view.findViewById(R.id.f75573zb);
        this.X = (CharacterCountEditText) view.findViewById(R.id.ux9);
        this.Y = (TextView) view.findViewById(R.id.f108486d9);
        this.Z = view.findViewById(R.id.f75613zf);
        this.f233054a0 = (TextView) view.findViewById(R.id.f108606dk);
        this.f233055b0 = (TextView) view.findViewById(R.id.f108586di);
        this.f233056c0 = view.findViewById(R.id.f75583zc);
        this.f233057d0 = (TextView) view.findViewById(R.id.f108516db);
        this.f233058e0 = (TextView) view.findViewById(R.id.f108496d_);
        this.f233059f0 = view.findViewById(R.id.f75603ze);
        this.f233060g0 = (TextView) view.findViewById(R.id.f108546de);
        this.f233061h0 = (ImageView) view.findViewById(R.id.f108576dh);
        this.f233062i0 = view.findViewById(R.id.f75593zd);
        this.f233063j0 = (TextView) view.findViewById(R.id.f108556df);
        this.U.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.f233056c0.setOnClickListener(this);
        this.f233059f0.setOnClickListener(this);
        this.f233062i0.setOnClickListener(this);
    }

    private void Yh(Bundle bundle, boolean z16) {
        GuildClientParams guildClientParams = (GuildClientParams) bundle.getParcelable("params");
        long j3 = bundle.getLong("create_time_ms", 0L);
        if (guildClientParams != null && j3 != 0) {
            this.T.f2(guildClientParams.G(), guildClientParams.u(), 0L, z16);
            Pair<Long, Long> a16 = com.tencent.mobileqq.guild.schedule.create.m.a(j3);
            long longValue = ((Long) a16.first).longValue();
            long longValue2 = ((Long) a16.second).longValue();
            this.T.p2(longValue);
            this.T.l2(longValue2);
            this.T.n2("");
            return;
        }
        QLog.i(f233053m0, 1, String.format(Locale.getDefault(), "initCreateViewModel error, params=%s, createTimeMs=%s", guildClientParams, Long.valueOf(j3)));
    }

    private void Zh() {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        Long value = this.T.e2().getValue();
        if (value == null) {
            value = Long.valueOf(serverTimeMillis);
        }
        com.tencent.mobileqq.guild.schedule.create.timepicker.b a16 = com.tencent.mobileqq.guild.schedule.create.timepicker.a.a(getContext(), serverTimeMillis, value.longValue());
        this.f233064k0 = a16;
        a16.p(new b());
        this.f233064k0.q(new c());
        Long value2 = this.T.a2().getValue();
        if (value2 == null) {
            value2 = Long.valueOf(serverTimeMillis);
        }
        com.tencent.mobileqq.guild.schedule.create.timepicker.b a17 = com.tencent.mobileqq.guild.schedule.create.timepicker.a.a(getContext(), serverTimeMillis, value2.longValue());
        this.f233065l0 = a17;
        a17.p(new d());
        this.f233065l0.q(new e());
        this.f233065l0.r(new f());
    }

    private void ai(Bundle bundle, boolean z16) {
        String string = bundle.getString("guild_id", "");
        String string2 = bundle.getString("channel_id", "");
        GuildScheduleInfo guildScheduleInfo = (GuildScheduleInfo) bundle.getSerializable("schedule_info");
        if (guildScheduleInfo != null && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            this.T.f2(string, string2, guildScheduleInfo.getScheduleId(), z16);
            this.T.n2(guildScheduleInfo.getTitle());
            this.T.k2(guildScheduleInfo.getContent());
            this.T.p2(guildScheduleInfo.getStartTimeMs());
            this.T.l2(guildScheduleInfo.getEndTimeMs());
            this.T.o2(guildScheduleInfo.getReminderTimeType());
            this.T.m2(guildScheduleInfo.getChannelInfo());
            this.U.post(new Runnable() { // from class: com.tencent.mobileqq.guild.schedule.create.GuildScheduleCreateFragment.6
                @Override // java.lang.Runnable
                public void run() {
                    GuildScheduleCreateFragment.this.U.setSelection(GuildScheduleCreateFragment.this.U.getText().length());
                }
            });
            return;
        }
        QLog.i(f233053m0, 1, String.format(Locale.getDefault(), "initEditViewModel error, guildId=%s, channelId=%s, params=%s", string, string2, guildScheduleInfo));
    }

    private void bi(int i3) {
        if (i3 == 1) {
            setTitle("\u521b\u5efa\u65e5\u7a0b");
        } else {
            setTitle("\u7f16\u8f91\u65e5\u7a0b");
        }
        setLeftButton(R.string.f140850f3, new m());
        setRightButtonEnable(false);
        setRightButton(R.string.f143340lt, new n());
        this.D.setTextColor(AppCompatResources.getColorStateList(this.E.getContext(), R.color.guild_bar_btn_black));
        this.F.setTextColor(AppCompatResources.getColorStateList(this.E.getContext(), R.color.guild_bar_btn_black));
        TextView textView = this.E;
        textView.setTextColor(AppCompatResources.getColorStateList(textView.getContext(), R.color.guild_skin_audio_empty_hint));
        cn.g(AppCompatResources.getColorStateList(this.E.getContext(), R.color.guild_bar_btn_black));
    }

    private void ci(View view, int i3) {
        this.N.setOnClickListener(new l());
        bi(i3);
        Xh(view);
    }

    private void di(int i3) {
        Bundle arguments = getArguments();
        if (i3 == 1) {
            Yh(arguments, true);
        } else if (i3 == 2) {
            ai(arguments, false);
        }
    }

    @RequiresApi(api = 21)
    private void ei() {
        com.tencent.mobileqq.guild.schedule.create.n nVar = (com.tencent.mobileqq.guild.schedule.create.n) new ViewModelProvider(this, new n.e(getAppInterface())).get(com.tencent.mobileqq.guild.schedule.create.n.class);
        this.T = nVar;
        nVar.c2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.schedule.create.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildScheduleCreateFragment.this.fi((String) obj);
            }
        });
        this.T.Z1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.schedule.create.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildScheduleCreateFragment.this.gi((String) obj);
            }
        });
        this.T.e2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.schedule.create.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildScheduleCreateFragment.this.hi((Long) obj);
            }
        });
        this.T.a2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.schedule.create.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildScheduleCreateFragment.this.ii((Long) obj);
            }
        });
        this.T.d2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.schedule.create.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildScheduleCreateFragment.this.ji((Integer) obj);
            }
        });
        this.T.b2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.schedule.create.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildScheduleCreateFragment.this.ki((GuildScheduleChannelInfo) obj);
            }
        });
        this.T.X1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.schedule.create.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildScheduleCreateFragment.this.li((Boolean) obj);
            }
        });
        Zh();
        this.U.setLimitCount(20);
        this.U.addTextChangedListener(new h());
        this.X.setLimitCount(500);
        this.X.setCountChangeListener(new i());
        this.X.setOnFocusChangeListener(new j());
        this.X.addTextChangedListener(new k());
        this.V.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void fi(String str) {
        if (!TextUtils.equals(this.U.getText(), str)) {
            this.U.setText(str);
        }
        qi(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gi(String str) {
        if (TextUtils.equals(this.X.getText(), str)) {
            return;
        }
        this.X.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hi(Long l3) {
        this.f233054a0.setText(com.tencent.mobileqq.guild.schedule.create.m.e(l3.longValue()));
        this.f233055b0.setText(com.tencent.mobileqq.guild.schedule.create.m.d(l3.longValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ii(Long l3) {
        this.f233057d0.setText(com.tencent.mobileqq.guild.schedule.create.m.e(l3.longValue()));
        this.f233058e0.setText(com.tencent.mobileqq.guild.schedule.create.m.d(l3.longValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ji(Integer num) {
        this.f233060g0.setText(com.tencent.mobileqq.guild.schedule.create.m.c(num.intValue()));
        if (this.T.g2()) {
            this.f233061h0.setVisibility(0);
        } else {
            ((RelativeLayout.LayoutParams) this.f233060g0.getLayoutParams()).setMarginEnd(Utils.n(16.0f, getResources()));
            this.f233061h0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ki(GuildScheduleChannelInfo guildScheduleChannelInfo) {
        if (guildScheduleChannelInfo.isValidChannelInfo()) {
            this.f233063j0.setText(guildScheduleChannelInfo.getChannelName());
        } else {
            this.f233063j0.setText("\u4e0d\u8df3\u8f6c");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void li(Boolean bool) {
        setRightButtonEnable(bool.booleanValue());
        VideoReport.traverseExposure();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void mi(DialogInterface dialogInterface, int i3) {
        si();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ni(DialogInterface dialogInterface, int i3) {
        this.T.Q1();
    }

    private static Intent pi(GuildClientParams guildClientParams, long j3) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("type", 1);
        bundle.putParcelable("params", guildClientParams);
        bundle.putLong("create_time_ms", j3);
        intent.putExtras(bundle);
        return intent;
    }

    private void qi(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.V.setVisibility(0);
        } else {
            this.V.setVisibility(8);
        }
    }

    private void ri(Bundle bundle) {
        String string;
        String string2;
        if (bundle.containsKey("params")) {
            GuildClientParams guildClientParams = (GuildClientParams) bundle.getParcelable("params");
            string = guildClientParams.G();
            string2 = guildClientParams.u();
        } else {
            string = bundle.getString("guild_id");
            string2 = bundle.getString("channel_id");
        }
        ty1.a.b("gpro_quality#event#schedule_channel_publish", "schedule_publish_create", ty1.a.e("guild_id", string, "channel_id", string2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void si() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private void ti() {
        VideoReport.setElementId(this.F, "em_sgrp_auditset_done");
        VideoReport.setEventDynamicParams(this.F, new g());
        VideoReport.setElementClickPolicy(this.F, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(this.F, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.F, EndExposurePolicy.REPORT_ALL);
    }

    private void ui() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.N, "pg_sgrp_create_event");
        HashMap hashMap = new HashMap();
        w.a(hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(this.N, this.T.getChannelInfo(), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vi() {
        ty1.a.a("gpro_quality#event#schedule_channel_publish", "schedule_publish_cancel");
        if (this.T.h2()) {
            DialogUtil.createCustomDialog(getActivity(), 230, (String) null, "\u786e\u5b9a\u653e\u5f03\u7f16\u8f91\u65e5\u7a0b\uff1f\n(\u9000\u51fa\u540e\u4e0d\u4fdd\u7559\u8349\u7a3f)", "\u7ee7\u7eed\u7f16\u8f91", "\u9000\u51fa", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.schedule.create.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildScheduleCreateFragment.this.mi(dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.schedule.create.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildScheduleCreateFragment.this.ni(dialogInterface, i3);
                }
            }).show();
        } else {
            si();
        }
    }

    public static void wi(Context context, GuildClientParams guildClientParams, long j3) {
        QLog.i(f233053m0, 1, "[showCreateFragment] ");
        Intent pi5 = pi(guildClientParams, j3);
        ty1.a.h("gpro_quality#event#schedule_channel_publish", ty1.a.e("schedule_publish_is_edit", "false"));
        QPublicFragmentActivity.start(context, pi5, GuildScheduleCreateFragment.class);
    }

    private void yi() {
        ty1.a.a("gpro_quality#event#schedule_channel_publish", "schedule_publish_end_time");
        if (this.f233065l0.n() instanceof com.tencent.mobileqq.guild.schedule.create.timepicker.a) {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            Long value = this.T.a2().getValue();
            if (value == null) {
                value = Long.valueOf(serverTimeMillis);
            }
            com.tencent.mobileqq.guild.schedule.create.timepicker.b bVar = this.f233065l0;
            com.tencent.mobileqq.guild.schedule.create.timepicker.a.i(bVar, (com.tencent.mobileqq.guild.schedule.create.timepicker.a) bVar.n(), value.longValue());
        }
        this.f233065l0.t();
    }

    private void zi() {
        if (!this.T.g2()) {
            QLog.i(f233053m0, 1, "edit mode, can't select reminder type");
        } else {
            ty1.a.a("gpro_quality#event#schedule_channel_publish", "schedule_publish_notice");
            this.T.q2(this);
        }
    }

    public void Vh() {
        if (((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).isNeedInterceptLink(this.T.getGuildId(), this.T.U1()) && (((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).containLink(this.U.getText().toString()) || ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).containLink(this.X.getText().toString()))) {
            ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptLinkSendToast();
        } else {
            this.T.S1(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    @RequiresApi(api = 21)
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        int i3 = arguments.getInt("type", 0);
        ci(this.P, i3);
        ei();
        di(i3);
        ui();
        ti();
        ri(arguments);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4 && keyEvent.getAction() == 0) {
            this.T.O1();
            if (this.T.R1(2)) {
                vi();
                return true;
            }
            return false;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168173f70;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.X.clearFocus();
        if (view.getId() == R.id.f165934y44) {
            Wh();
        } else if (view.getId() == R.id.f75613zf) {
            Bi();
        } else if (view.getId() == R.id.f75583zc) {
            yi();
        } else if (view.getId() == R.id.f75603ze) {
            zi();
        } else if (view.getId() == R.id.f75593zd) {
            Ai();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        if (getActivity() != null && getActivity().isFinishing()) {
            ty1.a.d("gpro_quality#event#schedule_channel_publish");
        }
        super.onPause();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        QLog.i(f233053m0, 1, "[onPostThemeChanged] ");
        com.tencent.mobileqq.guild.theme.c.a(this.D);
        com.tencent.mobileqq.guild.theme.c.a(this.F);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = this.F;
        if (textView != null) {
            textView.setTextColor(AppCompatResources.getColorStateList(textView.getContext(), R.color.qui_common_text_primary));
        }
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.J;
        if (guildDefaultThemeNavBarCommon != null) {
            guildDefaultThemeNavBarCommon.setLeftTextColor(AppCompatResources.getColorStateList(guildDefaultThemeNavBarCommon.getContext(), R.color.qui_common_text_primary));
            this.J.f().setBackground(GuildUIUtils.w(this.J.getContext(), R.drawable.guild_back_left, Integer.valueOf(R.color.qui_common_icon_primary)));
            GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon2 = this.J;
            guildDefaultThemeNavBarCommon2.setTitleColor(AppCompatResources.getColorStateList(guildDefaultThemeNavBarCommon2.getContext(), R.color.qui_common_text_primary));
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return R.color.qui_common_fill_light_primary;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int qh() {
        return R.drawable.qui_common_fill_light_primary_bg;
    }

    void xi() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230, (String) null, getString(R.string.f155151gq), "", getString(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.schedule.create.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildScheduleCreateFragment.oi(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        ViewGroup rootView = createCustomDialog.getRootView();
        VideoReport.setPageId(rootView, "pg_sgrp_create_event");
        HashMap hashMap = new HashMap();
        w.a(hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(rootView, this.T.getChannelInfo(), hashMap);
        View findViewById = rootView.findViewById(R.id.dialogRightBtn);
        VideoReport.setElementId(findViewById, "em_sgrp_create_limit");
        VideoReport.setElementClickPolicy(findViewById, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(findViewById, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(findViewById, EndExposurePolicy.REPORT_ALL);
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements b.d {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.schedule.create.timepicker.b.d
        public void onDismiss() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e implements b.d {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.schedule.create.timepicker.b.d
        public void onDismiss() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class h implements TextWatcher {
        h() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (!TextUtils.equals(charSequence.toString(), GuildScheduleCreateFragment.this.T.c2().getValue())) {
                GuildScheduleCreateFragment.this.T.j2(true);
            }
            GuildScheduleCreateFragment.this.T.n2(charSequence.toString());
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class i implements CharacterCountEditText.c {
        i() {
        }

        @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
        public void s7(cb.b bVar) {
            GuildScheduleCreateFragment.this.Y.setText(String.format("%s/%s", Integer.valueOf(bVar.a()), 500));
        }

        @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
        public void Bf(cb.b bVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class k implements TextWatcher {
        k() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (!TextUtils.equals(charSequence.toString(), GuildScheduleCreateFragment.this.T.Z1().getValue())) {
                GuildScheduleCreateFragment.this.T.j2(true);
            }
            GuildScheduleCreateFragment.this.T.k2(charSequence.toString());
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void oi(DialogInterface dialogInterface, int i3) {
    }
}
