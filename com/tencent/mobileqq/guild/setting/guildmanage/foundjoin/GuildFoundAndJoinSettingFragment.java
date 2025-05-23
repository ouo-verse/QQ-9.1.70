package com.tencent.mobileqq.guild.setting.guildmanage.foundjoin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.StringRes;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.main.viewmodel.base.BaseChannelViewModel;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.GuildSecondaryAuthorityViewModel;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildFoundAndJoinSettingFragment extends QQGuildTokenTitleBarFragment {
    private IDynamicParams T = new a();
    private IDynamicParams U = new b();
    private IDynamicParams V = new c();
    private IDynamicParams W = new d();
    private String X;
    private boolean Y;
    private l Z;

    /* renamed from: a0, reason: collision with root package name */
    private GuildSecondaryAuthorityViewModel f233829a0;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public enum SwitchType {
        QR_CODE,
        GUILD_ALLOW_RECOMMENDED,
        SEARCH_GUILD_NUMBER,
        SEARCH_GUILD_NAME
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements IDynamicParams {
        a() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            int i3;
            HashMap hashMap = new HashMap();
            if (Boolean.TRUE.equals(GuildFoundAndJoinSettingFragment.this.Z.b2().getValue())) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            hashMap.put("sgrp_switch_condition", Integer.valueOf(i3));
            return hashMap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements IDynamicParams {
        b() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            int i3;
            HashMap hashMap = new HashMap();
            if (Boolean.TRUE.equals(GuildFoundAndJoinSettingFragment.this.Z.c2().getValue())) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            hashMap.put("sgrp_switch_condition", Integer.valueOf(i3));
            return hashMap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c implements IDynamicParams {
        c() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            int i3;
            HashMap hashMap = new HashMap();
            if (Boolean.TRUE.equals(GuildFoundAndJoinSettingFragment.this.Z.f2().getValue())) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            hashMap.put("sgrp_switch_condition", Integer.valueOf(i3));
            return hashMap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d implements IDynamicParams {
        d() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            int i3;
            HashMap hashMap = new HashMap();
            if (Boolean.TRUE.equals(GuildFoundAndJoinSettingFragment.this.Z.a2().getValue())) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            hashMap.put("sgrp_switch_condition", Integer.valueOf(i3));
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f233834a;

        static {
            int[] iArr = new int[SwitchType.values().length];
            f233834a = iArr;
            try {
                iArr[SwitchType.QR_CODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f233834a[SwitchType.GUILD_ALLOW_RECOMMENDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f233834a[SwitchType.SEARCH_GUILD_NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f233834a[SwitchType.SEARCH_GUILD_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private boolean Lh() {
        if (!ch.m0(this.X)) {
            ch.f1(HardCodeUtil.qqStr(R.string.f140840f2));
            return false;
        }
        return true;
    }

    public static Intent Mh(String str, boolean z16) {
        Intent intent = new Intent();
        intent.putExtra("extra_guild_id", str);
        intent.putExtra("extra_key_is_creator", z16);
        return intent;
    }

    private Group[] Nh(QUIListItemAdapter qUIListItemAdapter) {
        return new Group[]{new Group(getString(R.string.f145980sy), Wh(qUIListItemAdapter), ai(qUIListItemAdapter), Zh(qUIListItemAdapter), Xh(qUIListItemAdapter))};
    }

    private void Oh() {
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) this.P.findViewById(R.id.i4m);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter();
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        qUIListItemAdapter.t0(Nh(qUIListItemAdapter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ph(cf1.b bVar) {
        String str;
        if (bVar == null) {
            return;
        }
        if (bVar.f30775b == 0 && ch.p(bVar.f30776c)) {
            ch.u1(getContext(), bVar.f30774a);
            return;
        }
        if (TextUtils.isEmpty(bVar.f30774a)) {
            str = HardCodeUtil.qqStr(R.string.f155831ik);
        } else {
            str = bVar.f30774a;
        }
        SecurityTipHelperKt.J(bVar.f30776c, getContext(), bVar.f30775b, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qh(tz1.a aVar, QUIListItemAdapter qUIListItemAdapter, SwitchType switchType, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (!u.a().b() && Lh()) {
            int i3 = e.f233834a[switchType.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            this.Z.p2(z16);
                        }
                    } else {
                        this.Z.o2(z16);
                    }
                } else {
                    this.Z.m2(z16);
                }
            } else {
                this.Z.n2(z16);
            }
        } else {
            aVar.O().f(!z16);
            qUIListItemAdapter.l0(aVar);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Rh(String str, IDynamicParams iDynamicParams, View view) {
        VideoReport.setElementIdNotBizReady(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setEventDynamicParams(view, iDynamicParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Th(tz1.a aVar, final String str, Boolean bool) {
        if (bool.booleanValue()) {
            aVar.O().b(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.g
                @Override // com.tencent.mobileqq.widget.listitem.g
                public final void M(View view) {
                    VideoReport.setElementId(view, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Uh(tz1.a aVar, QUIListItemAdapter qUIListItemAdapter, Boolean bool) {
        aVar.O().f(bool.booleanValue());
        qUIListItemAdapter.l0(aVar);
    }

    private x<x.b.d, x.c.f> Wh(QUIListItemAdapter qUIListItemAdapter) {
        tz1.a<x.b.d> ei5 = ei(R.string.f152491_j);
        ci(ei5, qUIListItemAdapter, SwitchType.QR_CODE);
        di(ei5, qUIListItemAdapter, this.Z.f2(), "em_sgrp_qr_code", this.V);
        return ei5;
    }

    private x Xh(QUIListItemAdapter qUIListItemAdapter) {
        tz1.a<x.b.d> ei5 = ei(R.string.f152831ag);
        ci(ei5, qUIListItemAdapter, SwitchType.GUILD_ALLOW_RECOMMENDED);
        di(ei5, qUIListItemAdapter, this.Z.a2(), "em_sgrp_recommend_switch", this.W);
        return ei5;
    }

    private void Yh() {
        Intent intent = getActivity().getIntent();
        this.X = intent.getStringExtra("extra_guild_id");
        this.Y = intent.getBooleanExtra("extra_key_is_creator", false);
        QLog.d("Guild.mnr.GuildFoundAndJoinSettingFragment", 1, "resolveIntent guildId=" + this.X + "isCreator=" + this.Y);
    }

    private x Zh(QUIListItemAdapter qUIListItemAdapter) {
        tz1.a<x.b.d> ei5 = ei(R.string.f155471hl);
        ci(ei5, qUIListItemAdapter, SwitchType.SEARCH_GUILD_NAME);
        di(ei5, qUIListItemAdapter, this.Z.b2(), "em_sgrp_name_switch", this.T);
        return ei5;
    }

    private tz1.a<x.b.d> ai(QUIListItemAdapter qUIListItemAdapter) {
        tz1.a<x.b.d> ei5 = ei(R.string.f155461hk);
        ci(ei5, qUIListItemAdapter, SwitchType.SEARCH_GUILD_NUMBER);
        di(ei5, qUIListItemAdapter, this.Z.c2(), "em_sgrp_code_switch", this.U);
        if (!bs.l()) {
            qUIListItemAdapter.m0(ei5, false);
        }
        return ei5;
    }

    private void bi() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.P, "pg_sgrp_find_setting");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("sgrp_channel_id", this.X);
        hashMap.put("sgrp_user_type", Integer.valueOf(v.c(this.X)));
        VideoReport.setPageParams(this.P, new PageParams(hashMap));
    }

    private void di(final tz1.a<x.b.d> aVar, final QUIListItemAdapter qUIListItemAdapter, LiveData<Boolean> liveData, final String str, final IDynamicParams iDynamicParams) {
        aVar.O().b(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.c
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildFoundAndJoinSettingFragment.Rh(str, iDynamicParams, view);
            }
        });
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(this.Z.Z1(), new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFoundAndJoinSettingFragment.Th(tz1.a.this, str, (Boolean) obj);
            }
        });
        mediatorLiveData.addSource(liveData, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFoundAndJoinSettingFragment.Uh(tz1.a.this, qUIListItemAdapter, (Boolean) obj);
            }
        });
        aVar.O().g(true);
        mediatorLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFoundAndJoinSettingFragment.Vh((Boolean) obj);
            }
        });
    }

    private tz1.a<x.b.d> ei(@StringRes int i3) {
        return new tz1.a<>(new x.b.d(getString(i3)), new x.c.f(false, null));
    }

    private void initViewModel() {
        l lVar = (l) com.tencent.mobileqq.mvvm.h.b(this, l.K).get(l.class);
        this.Z = lVar;
        lVar.h2(this.X);
        GuildSecondaryAuthorityViewModel guildSecondaryAuthorityViewModel = (GuildSecondaryAuthorityViewModel) BaseChannelViewModel.sViewModelFactory.create(GuildSecondaryAuthorityViewModel.class);
        this.f233829a0 = guildSecondaryAuthorityViewModel;
        guildSecondaryAuthorityViewModel.init(this.X, "GuildFoundAndJoinSettingFragment");
        this.Z.e2().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFoundAndJoinSettingFragment.this.Ph((cf1.b) obj);
            }
        });
    }

    public void ci(final tz1.a<x.b.d> aVar, final QUIListItemAdapter qUIListItemAdapter, final SwitchType switchType) {
        aVar.O().h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildFoundAndJoinSettingFragment.this.Qh(aVar, qUIListItemAdapter, switchType, compoundButton, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        rh();
        Yh();
        this.E.setText(getString(R.string.f14897111));
        initViewModel();
        Oh();
        bi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f36;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.Z.removeObserver();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.Z.addObserver();
        this.Z.U1();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        this.J.a();
        this.J.setBackgroundResource(R.drawable.lvj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Vh(Boolean bool) {
    }
}
