package com.tencent.mobileqq.guild.setting.guildmanage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.channel.manage.feedsquare.GuildChannelManageFragment;
import com.tencent.mobileqq.guild.config.z;
import com.tencent.mobileqq.guild.feed.api.IGuildJumpUtilApi;
import com.tencent.mobileqq.guild.main.announcement.GuildAnnounceViewModel;
import com.tencent.mobileqq.guild.main.viewmodel.base.BaseChannelViewModel;
import com.tencent.mobileqq.guild.profile.profilecard.guildowneroperation.GuildOwnerOperationTipCard;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildOpenBindPermissionUtils;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.PermissionSwitchStatus;
import com.tencent.mobileqq.guild.rolegroup.fragments.GuildRoleListFragment;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.GuildSecondaryAuthorityViewModel;
import com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.blacklist.GuildBlackListOrRiskFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmData;
import com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog;
import com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.GuildApplicationManageFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.more.QQGuildManageMoreFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.v;
import com.tencent.mobileqq.guild.setting.member.fragments.GuildMemberListFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.URLUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import vh2.cc;
import vh2.cd;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildManageFragment extends QQGuildTokenTitleBarFragment implements View.OnClickListener {
    private g02.g T;
    private GuildSecondaryAuthorityViewModel U;
    private GuildAnnounceViewModel V;
    private u W;
    private IGProGuildInfo X;
    private GuildOwnerOperationTipCard Y;

    /* renamed from: b0, reason: collision with root package name */
    private uz1.b f233630b0;

    /* renamed from: c0, reason: collision with root package name */
    private com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.l f233631c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f233632d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f233633e0;

    /* renamed from: i0, reason: collision with root package name */
    private v f233637i0;

    /* renamed from: k0, reason: collision with root package name */
    Group f233639k0;

    /* renamed from: l0, reason: collision with root package name */
    View f233640l0;
    private int Z = 0;

    /* renamed from: a0, reason: collision with root package name */
    private int f233629a0 = 1;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f233634f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    private final HashMap<String, ?> f233635g0 = new HashMap<>();

    /* renamed from: h0, reason: collision with root package name */
    private final IQQGuildRouterApi f233636h0 = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);

    /* renamed from: j0, reason: collision with root package name */
    private final RecyclerView.OnScrollListener f233638j0 = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements cd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f233641a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ cc f233642b;

        a(long j3, cc ccVar) {
            this.f233641a = j3;
            this.f233642b = ccVar;
        }

        @Override // vh2.cd
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            ri1.a e16 = ri1.a.e(i3, str, iGProSecurityResult);
            if (e16.d()) {
                QQGuildManageFragment.this.hl(this.f233641a);
                com.tencent.mobileqq.guild.setting.mute.c.X(QQGuildManageFragment.this.f233632d0, this.f233641a, "setGuildShutUp");
                QLog.i("Guild.mnr.QQGuildInfoFragment", 1, "[setGuildShutUp] success, muteTime = " + this.f233641a);
            } else {
                if (e16.f431477a != -200) {
                    ch.d1(1, R.string.f155831ik);
                } else {
                    ch.e1(1, e16.f431478b);
                }
                QLog.e("Guild.mnr.QQGuildInfoFragment", 1, "[setGuildShutUp] error, failed result: " + i3 + ", errMsg: " + str + ", security = " + iGProSecurityResult + ", muteTime = " + this.f233641a);
            }
            cc ccVar = this.f233642b;
            if (ccVar != null) {
                ccVar.onResult(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements com.tencent.mobileqq.widget.listitem.g {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.listitem.g
        public void M(View view) {
            VideoReport.setElementReuseIdentifier(view, "em_sgrp_owner_transfer");
            ch.Y0(view, "em_sgrp_owner_transfer", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d extends com.tencent.mobileqq.widget.listitem.u {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.listitem.w
        protected View H(ViewGroup viewGroup) {
            return new View(viewGroup.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QUIListItemAdapter f233647d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ x f233648e;

        e(QUIListItemAdapter qUIListItemAdapter, x xVar) {
            this.f233647d = qUIListItemAdapter;
            this.f233648e = xVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            QQGuildManageFragment.this.Nj(z16, this.f233647d, this.f233648e);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f implements com.tencent.mobileqq.widget.listitem.g {
        f() {
        }

        @Override // com.tencent.mobileqq.widget.listitem.g
        public void M(@NonNull View view) {
            float f16;
            QQGuildManageFragment.this.f233640l0 = view;
            View findViewById = view.findViewById(R.id.f66283a8);
            if (findViewById != null) {
                if (Boolean.TRUE.equals(QQGuildManageFragment.this.U.getShowForbiddenWords().getValue())) {
                    f16 = 1.0f;
                } else {
                    f16 = 0.7f;
                }
                findViewById.setAlpha(f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class g extends com.tencent.mobileqq.widget.listitem.u {
        g() {
        }

        @Override // com.tencent.mobileqq.widget.listitem.w
        @NonNull
        protected View H(@NonNull ViewGroup viewGroup) {
            TextView textView = new TextView(viewGroup.getContext());
            Resources resources = QQGuildManageFragment.this.getResources();
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, resources.getDimensionPixelOffset(R.dimen.dar)));
            textView.setGravity(17);
            textView.setTextColor(resources.getColorStateList(R.color.bu9));
            textView.setTextSize(1, 16);
            textView.setText(QQGuildManageFragment.this.getString(R.string.f156031j4));
            return textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class i implements v.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f233653a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ x f233654b;

        i(x xVar, x xVar2) {
            this.f233653a = xVar;
            this.f233654b = xVar2;
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.v.d
        @NonNull
        public Group[] a() {
            return new Group[]{QQGuildManageFragment.this.tj(R.string.f1491011d, this.f233653a, this.f233654b)};
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class j implements v.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f233656a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ x f233657b;

        j(x xVar, x xVar2) {
            this.f233656a = xVar;
            this.f233657b = xVar2;
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.v.d
        @NonNull
        public Group[] a() {
            return new Group[]{QQGuildManageFragment.this.tj(R.string.f1490711a, this.f233656a, this.f233657b)};
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface k<T> {
        T execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aj(View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.X.getUserType() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Zk();
        } else {
            VideoReport.reportEvent("clck", view, this.f233635g0);
            GuildAgainConfirmDialog.INSTANCE.a(requireActivity().getSupportFragmentManager(), new GuildAgainConfirmData("\u89e3\u6563\u201c" + this.X.getGuildName() + "\u201d", "\u89e3\u6563\u540e\u5c06\u79fb\u9664\u6240\u6709\u6210\u5458\u3001\u6e05\u7a7a\u76f8\u5173\u5185\u5bb9\u4e0e\u8bbe\u7f6e\u3001\u89e3\u9664\u5e7f\u544a\u7b7e\u7ea6\u72b6\u6001\uff0c\u4e14\u65e0\u6cd5\u6062\u590d\u3002\u8bf7\u8c28\u614e\u64cd\u4f5c\uff01", "\u89e3\u6563\u9891\u9053", "\u89e3\u6563\u5e76\u6e05\u7a7a\u9891\u9053", 1, "\u53d6\u6d88"), new h());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ak(tz1.b bVar, QUIListItemAdapter qUIListItemAdapter, Boolean bool) {
        bVar.V(!bool.booleanValue());
        qUIListItemAdapter.l0(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        VideoReport.reportEvent("clck", view, new HashMap());
        if (Boolean.FALSE.equals(this.W.h2().getValue())) {
            com.tencent.mobileqq.guild.util.qqui.g.f(0, "\u6682\u65e0\u8bbe\u7f6e\u6743\u9650\uff0c\u53ef\u8054\u7cfb\u9891\u9053\u4e3b\u7533\u8bf7");
        } else if (getActivity() != null) {
            GuildChannelManageFragment.INSTANCE.a(getActivity(), this.f233632d0, 1);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bk(tz1.b bVar, QUIListItemAdapter qUIListItemAdapter, Integer num) {
        if (num != null) {
            bVar.O().h(this.f233631c0.d2(num.intValue()));
            qUIListItemAdapter.l0(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v()) {
            HashMap hashMap = new HashMap();
            Integer value = this.W.d2().getValue();
            if (value == null) {
                value = 0;
            }
            hashMap.put("sgrp_add_apply_category_num", value);
            VideoReport.reportEvent("clck", view, hashMap);
            if (Boolean.FALSE.equals(this.W.h2().getValue())) {
                com.tencent.mobileqq.guild.util.qqui.g.f(0, "\u6682\u65e0\u8bbe\u7f6e\u6743\u9650\uff0c\u53ef\u8054\u7cfb\u9891\u9053\u4e3b\u7533\u8bf7");
            } else if (getActivity() != null) {
                GuildApplicationManageFragment.INSTANCE.f(getActivity(), this.f233632d0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ck(View view) {
        VideoReport.setElementReuseIdentifier(view, "em_sgrp_channel_set_join_setting");
        ch.Y0(view, "em_sgrp_channel_set_join_setting", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dj(View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!Pj()) {
            if (Boolean.FALSE.equals(this.U.getShowGuildJoinMode().getValue())) {
                al();
            } else {
                IQQGuildRouterApi iQQGuildRouterApi = this.f233636h0;
                Context context = getContext();
                String str = this.f233632d0;
                if (this.X.getUserType() == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                iQQGuildRouterApi.openGuildFoundAndJoinSetting(context, str, z16);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ tz1.b Dk(final QUIListItemAdapter qUIListItemAdapter) {
        final tz1.b<x.b.d> il5 = il(R.string.f1490611_, new View.OnClickListener() { // from class: cz1.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.wj(view);
            }
        }, null);
        this.U.getShowGuildJoinMode().observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.Ak(tz1.b.this, qUIListItemAdapter, (Boolean) obj);
            }
        });
        this.f233631c0.X1().observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.this.Bk(il5, qUIListItemAdapter, (Integer) obj);
            }
        });
        il5.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: cz1.x
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                QQGuildManageFragment.Ck(view);
            }
        });
        return il5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ej(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (Boolean.FALSE.equals(this.U.getShowRoleGroupManage().getValue())) {
            al();
        } else {
            QPublicFragmentActivity.start(getContext(), GuildRoleListFragment.Sh(this.X.getGuildID()), GuildRoleListFragment.class);
            VideoReport.reportEvent("clck", view, this.f233635g0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ek(tz1.b bVar, QUIListItemAdapter qUIListItemAdapter, Boolean bool) {
        if (bool.booleanValue()) {
            bVar.V(false);
        } else {
            bVar.V(true);
        }
        qUIListItemAdapter.l0(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!Pj() && !QQGuildUIUtil.v()) {
            if (Boolean.FALSE.equals(this.U.getShowForbiddenWords().getValue())) {
                al();
            } else {
                this.f233636h0.openMuteAllSetting(getActivity(), this.f233632d0);
                VideoReport.reportEvent("clck", view, this.f233635g0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fk(tz1.b bVar, QUIListItemAdapter qUIListItemAdapter, Boolean bool) {
        String string;
        if (bool.booleanValue()) {
            string = getString(R.string.f1491111e);
        } else {
            string = getString(R.string.f1491211f);
        }
        bVar.O().h(string);
        qUIListItemAdapter.l0(bVar);
    }

    private void Gj(View view, String str, boolean z16) {
        if (Boolean.FALSE.equals(this.U.getShowManageLog().getValue())) {
            al();
        } else {
            Hj(view, str, z16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Gk(View view) {
        VideoReport.setElementReuseIdentifier(view, "em_sgrp_visitor_view_switch");
        ch.Y0(view, "em_sgrp_visitor_view_switch", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_NONE);
    }

    private void Hj(View view, String str, boolean z16, boolean z17) {
        String str2;
        String valueOf;
        VideoReport.reportEvent("clck", view, this.f233635g0);
        IGProGuildInfo iGProGuildInfo = this.X;
        if (iGProGuildInfo == null) {
            QLog.w("Guild.mnr.QQGuildInfoFragment", 1, "mGuildInfo is null.");
            return;
        }
        if (z17) {
            str2 = WadlProxyConsts.CHANNEL;
        } else {
            str2 = "guildId";
        }
        if (z16) {
            valueOf = String.valueOf(iGProGuildInfo.getUserType());
        } else {
            valueOf = String.valueOf(com.tencent.mobileqq.guild.data.v.b(iGProGuildInfo.getUserType()));
        }
        String addParameter = URLUtil.addParameter(URLUtil.addParameter(URLUtil.addParameter(str, str2, this.f233632d0), "channelName", this.X.getGuildName()), MessageRoamJsPlugin.USERTYPE, valueOf);
        if (QLog.isColorLevel()) {
            QLog.i("Guild.mnr.QQGuildInfoFragment", 2, "handleStartH5Click:" + addParameter);
        }
        ch.j1(getActivity(), addParameter, this.f233632d0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ tz1.b Hk(final QUIListItemAdapter qUIListItemAdapter) {
        final tz1.b<x.b.d> il5 = il(R.string.f1491011d, new View.OnClickListener() { // from class: cz1.au
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.yj(view);
            }
        }, null);
        this.U.getIsGuildAdminOrCreator().observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.av
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.Ek(tz1.b.this, qUIListItemAdapter, (Boolean) obj);
            }
        });
        this.f233630b0.R1().observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.aw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.this.Fk(il5, qUIListItemAdapter, (Boolean) obj);
            }
        });
        il5.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: cz1.ax
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                QQGuildManageFragment.Gk(view);
            }
        });
        return il5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ij(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v()) {
            cl("em_sgrp_owner_transfer", view, new HashMap());
            IGProGuildInfo iGProGuildInfo = this.X;
            if (iGProGuildInfo != null) {
                GuildMemberListFragment.Fi(this, iGProGuildInfo, "", 10000);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ik(tz1.b bVar, QUIListItemAdapter qUIListItemAdapter, Boolean bool) {
        if (bool.booleanValue()) {
            bVar.V(false);
        } else {
            bVar.V(true);
        }
        qUIListItemAdapter.l0(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v()) {
            if (Boolean.FALSE.equals(this.U.isEnableFeedBatchManage().getValue())) {
                al();
            } else {
                ((IGuildJumpUtilApi) QRoute.api(IGuildJumpUtilApi.class)).openGuildBatchManagePage(view.getContext(), this.f233632d0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jk(tz1.b bVar, QUIListItemAdapter qUIListItemAdapter, Boolean bool) {
        String string;
        if (bool.booleanValue()) {
            string = getString(R.string.f1491111e);
        } else {
            string = getString(R.string.f1491211f);
        }
        bVar.O().h(string);
        qUIListItemAdapter.l0(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v()) {
            if (Boolean.FALSE.equals(this.W.g2().getValue())) {
                al();
            } else {
                this.f233636h0.openSpeakRuleSetting(view.getContext(), this.f233632d0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Kk(View view) {
        VideoReport.setElementReuseIdentifier(view, "em_sgrp_join_forum_interaction_switch");
        ch.Y0(view, "em_sgrp_join_forum_interaction_switch", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!Pj() && !QQGuildUIUtil.v()) {
            GuildBlackListOrRiskFragment.Gh(view.getContext(), this.f233632d0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ tz1.b Lk(final QUIListItemAdapter qUIListItemAdapter) {
        final tz1.b<x.b.d> il5 = il(R.string.f1490711a, new View.OnClickListener() { // from class: cz1.ay
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.xj(view);
            }
        }, null);
        this.U.getIsGuildAdminOrCreator().observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.az
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.Ik(tz1.b.this, qUIListItemAdapter, (Boolean) obj);
            }
        });
        this.f233630b0.Q1().observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.ba
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.this.Jk(il5, qUIListItemAdapter, (Boolean) obj);
            }
        });
        il5.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: cz1.bb
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                QQGuildManageFragment.Kk(view);
            }
        });
        return il5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v()) {
            if (Boolean.FALSE.equals(this.W.i2().getValue())) {
                al();
            } else {
                this.f233636h0.openPrivateLetterThresholdManageFragment(view.getContext(), this.f233632d0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mk(tz1.b bVar, QUIListItemAdapter qUIListItemAdapter, PermissionSwitchStatus permissionSwitchStatus) {
        int i3;
        x.c.g O = bVar.O();
        if (permissionSwitchStatus == PermissionSwitchStatus.TYPE_ALL) {
            i3 = R.string.f154431es;
        } else {
            i3 = R.string.f14904118;
        }
        O.h(getString(i3));
        qUIListItemAdapter.l0(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nj(boolean z16, QUIListItemAdapter qUIListItemAdapter, x<x.b.d, x.c.f> xVar) {
        int i3;
        if (Boolean.FALSE.equals(this.U.getShowForbiddenWords().getValue())) {
            sk(com.tencent.mobileqq.guild.setting.mute.c.s(this.f233632d0).getValue(), qUIListItemAdapter, xVar);
            al();
            return;
        }
        if (z16) {
            fl(0, 0, 10, null);
        } else {
            fl(0, 0, 0, null);
        }
        if (this.f233640l0 != null) {
            HashMap hashMap = new HashMap();
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            hashMap.put("sgrp_switch_condition", Integer.valueOf(i3));
            cl("em_sgrp_all_member_prohibition", this.f233640l0, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Nk(View view) {
        VideoReport.setElementReuseIdentifier(view, "em_sgrp_publish_forum");
        ch.Y0(view, "em_sgrp_publish_forum", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v()) {
            if (!ch.m0(this.f233632d0)) {
                al();
            } else {
                QQGuildManageMoreFragment.INSTANCE.a(getActivity(), this.f233632d0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ tz1.b Ok(final QUIListItemAdapter qUIListItemAdapter) {
        final tz1.b<x.b.d> il5 = il(R.string.f1490811b, new View.OnClickListener() { // from class: cz1.al
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.zj(view);
            }
        }, null);
        il5.V(!ch.m0(this.f233632d0));
        this.W.j2().observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.am
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.this.Mk(il5, qUIListItemAdapter, (PermissionSwitchStatus) obj);
            }
        });
        il5.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: cz1.an
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                QQGuildManageFragment.Nk(view);
            }
        });
        return il5;
    }

    private boolean Pj() {
        if (this.X == null) {
            QLog.w("Guild.mnr.QQGuildInfoFragment", 2, "mGuildInfo is null.");
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Pk(View view) {
        VideoReport.setElementReuseIdentifier(view, "em_sgrp_visitor_interaction");
        ch.Y0(view, "em_sgrp_visitor_interaction", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_NONE);
    }

    private void Qj(String str) {
        this.Z = requireActivity().getIntent().getIntExtra("guild_owner_operation_dialog_type", 0);
        this.f233629a0 = requireActivity().getIntent().getIntExtra(IProfileCardConst.KEY_FROM_TYPE, 1);
        if (this.Z == 1) {
            nj();
            GuildOwnerOperationTipCard guildOwnerOperationTipCard = new GuildOwnerOperationTipCard(str, 1);
            this.Y = guildOwnerOperationTipCard;
            com.tencent.mobileqq.guild.base.extension.d.a(guildOwnerOperationTipCard, getChildFragmentManager(), "Guild.profile.GuildOwnerOperationTipCard");
        }
        QLog.d("Guild.mnr.QQGuildInfoFragment", 1, "initOperationDialogTig mDialogType=", Integer.valueOf(this.Z), " mFromType=", Integer.valueOf(this.f233629a0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.tencent.mobileqq.widget.listitem.a Qk(QUIListItemAdapter qUIListItemAdapter) {
        com.tencent.mobileqq.widget.listitem.a kj5 = kj(qUIListItemAdapter, R.string.f1490911c, new View.OnClickListener() { // from class: cz1.aj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.Mj(view);
            }
        }, null, this.W.i2(), null);
        kj5.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: cz1.ak
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                QQGuildManageFragment.Pk(view);
            }
        });
        return kj5;
    }

    private void Rj() {
        RecyclerView recyclerView = (RecyclerView) this.P.findViewById(R.id.i4m);
        recyclerView.addOnScrollListener(this.f233638j0);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter();
        recyclerView.setAdapter(qUIListItemAdapter);
        qUIListItemAdapter.t0(lj(qUIListItemAdapter));
        qUIListItemAdapter.notifyDataSetChanged();
        qw1.b.o(com.tencent.mobileqq.guild.util.report.b.b(this), recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Rk(x xVar, View view, boolean z16) {
        this.f233630b0.W1(1, true);
        v vVar = this.f233637i0;
        if (vVar != null) {
            vVar.X(0, xVar);
            this.f233637i0.W();
            this.f233637i0.Q();
        }
    }

    private void Sj() {
        setTitle(getString(R.string.f156151jf));
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.D.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Sk(x xVar, View view, boolean z16) {
        this.f233630b0.W1(1, false);
        v vVar = this.f233637i0;
        if (vVar != null) {
            vVar.X(0, xVar);
            this.f233637i0.W();
            this.f233637i0.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Tj(View view) {
        VideoReport.setElementReuseIdentifier(view, "em_sgrp_channel_set_dismiss_group");
        ch.Y0(view, "em_sgrp_channel_set_dismiss_group", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Tk(x xVar, View view, boolean z16) {
        this.f233630b0.W1(5, true);
        v vVar = this.f233637i0;
        if (vVar != null) {
            vVar.X(0, xVar);
            this.f233637i0.W();
            this.f233637i0.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean Uj(IGProGuildInfo iGProGuildInfo) {
        boolean z16;
        if (iGProGuildInfo.getUserType() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Uk(x xVar, View view, boolean z16) {
        this.f233630b0.W1(5, false);
        v vVar = this.f233637i0;
        if (vVar != null) {
            vVar.X(0, xVar);
            this.f233637i0.W();
            this.f233637i0.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Vj(tz1.b bVar, QUIListItemAdapter qUIListItemAdapter, Boolean bool) {
        bVar.V(!bool.booleanValue());
        qUIListItemAdapter.l0(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Vk(com.tencent.mobileqq.guild.profile.profilecard.main.l lVar) {
        if (TextUtils.isEmpty(lVar.c())) {
            return;
        }
        if (lVar.d()) {
            ch.e1(2, lVar.c());
        } else {
            SecurityTipHelperKt.A(getContext(), lVar.a(), lVar.c(), lVar.b());
            bt.c(this.P, "em_sgrp_dismiss_group_fail_toast", new HashMap(), ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_NONE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Wj(tz1.b bVar, String str) {
        bVar.U(new x.c.g(str, true, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Wk(Boolean bool) {
        onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Xj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Gj(view, "https://qun.qq.com/pro/manage/index?_wv=16777219&_nav_titleclr=03081A&_nav_txtclr=03081A", false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Xk(String str, View view) {
        VideoReport.setElementReuseIdentifier(view, str);
        ch.Y0(view, str, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Yj(tz1.b bVar, QUIListItemAdapter qUIListItemAdapter, Boolean bool) {
        bVar.V(!bool.booleanValue());
        qUIListItemAdapter.l0(bVar);
    }

    public static void Yk(Context context, IGProGuildInfo iGProGuildInfo, int i3, int i16) {
        Intent jj5 = jj(iGProGuildInfo, i3, i16);
        if (!(context instanceof Activity)) {
            jj5.addFlags(268435456);
        }
        jj5.putExtra("_extra_param_report_task", com.tencent.mobileqq.guild.util.report.b.a("guild_setting"));
        QPublicFragmentActivity.b.b(context, jj5, QPublicFragmentActivity.class, QQGuildManageFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean Zj(IGProGuildInfo iGProGuildInfo) {
        boolean z16;
        if (iGProGuildInfo.getUserType() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    private void Zk() {
        ch.f1(HardCodeUtil.qqStr(R.string.f15160185));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ x ak(QUIListItemAdapter qUIListItemAdapter) {
        x xVar = new x(new x.b.d(getString(R.string.f156491kc)), new x.c.g("", true, false));
        xVar.x(new View.OnClickListener() { // from class: cz1.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.Ij(view);
            }
        });
        xVar.w(new c());
        xVar.l(getViewLifecycleOwner(), qUIListItemAdapter).f(this.W.a2(), new Function1() { // from class: cz1.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Boolean Zj;
                Zj = QQGuildManageFragment.Zj((IGProGuildInfo) obj);
                return Zj;
            }
        });
        return xVar;
    }

    private void al() {
        ch.f1(HardCodeUtil.qqStr(R.string.f140840f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ tz1.b bk(final QUIListItemAdapter qUIListItemAdapter) {
        final tz1.b<x.b.d> il5 = il(R.string.f156131jd, new View.OnClickListener() { // from class: cz1.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.Xj(view);
            }
        }, "em_sgrp_log");
        this.U.getShowManageLog().observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.Yj(tz1.b.this, qUIListItemAdapter, (Boolean) obj);
            }
        });
        return il5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(@Nullable IGProGuildInfo iGProGuildInfo) {
        if (iGProGuildInfo == null) {
            return;
        }
        this.X = iGProGuildInfo;
        if (this.T == null) {
            initViewModel();
            Rj();
        }
        if (QLog.isColorLevel()) {
            QLog.i("Guild.mnr.QQGuildInfoFragment", 2, "refreshData GuildId: " + iGProGuildInfo.getGuildID());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void ck(tz1.b bVar, QUIListItemAdapter qUIListItemAdapter, Boolean bool) {
        bVar.V(!bool.booleanValue());
        qUIListItemAdapter.l0(bVar);
    }

    private void cl(String str, View view, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        VideoReport.reportEvent("clck", view, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ tz1.b dk(final QUIListItemAdapter qUIListItemAdapter) {
        final tz1.b<x.b.d> il5 = il(R.string.f156141je, new View.OnClickListener() { // from class: cz1.bg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.Ej(view);
            }
        }, "em_sgrp_channel_set_identity");
        boolean gl5 = gl();
        il5.V(!gl5);
        if (gl5) {
            this.U.getShowRoleGroupManage().observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQGuildManageFragment.ck(tz1.b.this, qUIListItemAdapter, (Boolean) obj);
                }
            });
        }
        return il5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ek(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        vj(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void el(IGPSService iGPSService, long j3, cc ccVar) {
        iGPSService.setGuildShutUp(this.f233632d0, j3, new a(j3, ccVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void fk(tz1.b bVar, QUIListItemAdapter qUIListItemAdapter, Boolean bool) {
        bVar.V(!bool.booleanValue());
        qUIListItemAdapter.l0(bVar);
    }

    private void fl(int i3, int i16, int i17, @Nullable cc ccVar) {
        long A = com.tencent.mobileqq.guild.setting.mute.c.A(i3, i16, i17);
        if (getAppInterface() != null) {
            el((IGPSService) getAppInterface().getRuntimeService(IGPSService.class, ""), A, ccVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ tz1.b gk(final QUIListItemAdapter qUIListItemAdapter) {
        final tz1.b<x.b.d> il5 = il(R.string.f155931iu, new View.OnClickListener() { // from class: cz1.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.ek(view);
            }
        }, "em_sgrp_blacklist");
        il5.l(getViewLifecycleOwner(), qUIListItemAdapter).g(gl());
        this.U.getShowBlackListMember().observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.fk(tz1.b.this, qUIListItemAdapter, (Boolean) obj);
            }
        });
        return il5;
    }

    private boolean gl() {
        if (this.Z != 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.tencent.mobileqq.widget.listitem.a hk(QUIListItemAdapter qUIListItemAdapter) {
        boolean z16;
        com.tencent.mobileqq.widget.listitem.a<?> kj5 = kj(qUIListItemAdapter, R.string.f14903117, new View.OnClickListener() { // from class: cz1.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.Lj(view);
            }
        }, null, null, null);
        if (z.d() && this.f233633e0 == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        qUIListItemAdapter.m0(kj5, z16);
        return kj5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hl(long j3) {
        int i3;
        if (j3 == 0) {
            i3 = R.string.f142490ji;
        } else {
            i3 = R.string.f155841il;
        }
        QQToast.makeText(BaseApplication.getContext(), 2, i3, 0).show();
    }

    private com.tencent.mobileqq.widget.listitem.a<?> ij(QUIListItemAdapter qUIListItemAdapter) {
        return new g().w(new com.tencent.mobileqq.widget.listitem.g() { // from class: cz1.l
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                QQGuildManageFragment.Tj(view);
            }
        }).x(new View.OnClickListener() { // from class: cz1.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.Aj(view);
            }
        }).l(getViewLifecycleOwner(), qUIListItemAdapter).f(this.W.a2(), new Function1() { // from class: cz1.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Boolean Uj;
                Uj = QQGuildManageFragment.Uj((IGProGuildInfo) obj);
                return Uj;
            }
        }).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ tz1.b ik() {
        tz1.b<x.b.d> il5 = il(R.string.f155531hr, new View.OnClickListener() { // from class: cz1.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.Oj(view);
            }
        }, null);
        il5.V(!ch.m0(this.f233632d0));
        return il5;
    }

    private tz1.b<x.b.d> il(@StringRes int i3, View.OnClickListener onClickListener, final String str) {
        tz1.b<x.b.d> bVar = new tz1.b<>(new x.b.d(getString(i3)), new x.c.g("", true, false), false);
        bVar.x(onClickListener);
        if (str != null) {
            bVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: cz1.ab
                @Override // com.tencent.mobileqq.widget.listitem.g
                public final void M(View view) {
                    QQGuildManageFragment.Xk(str, view);
                }
            });
        }
        return bVar;
    }

    private void initViewModel() {
        g02.g gVar = (g02.g) g02.g.R.create(g02.g.class);
        this.T = gVar;
        gVar.c2(this.X);
        this.T.l2().observe(this, new Observer() { // from class: cz1.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.this.Vk((com.tencent.mobileqq.guild.profile.profilecard.main.l) obj);
            }
        });
        this.T.W1().observe(this, new Observer() { // from class: cz1.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.this.Wk((Boolean) obj);
            }
        });
        GuildSecondaryAuthorityViewModel guildSecondaryAuthorityViewModel = (GuildSecondaryAuthorityViewModel) BaseChannelViewModel.sViewModelFactory.create(GuildSecondaryAuthorityViewModel.class);
        this.U = guildSecondaryAuthorityViewModel;
        guildSecondaryAuthorityViewModel.init(this.X, "QQGuildManageFragment");
        GuildAnnounceViewModel guildAnnounceViewModel = (GuildAnnounceViewModel) com.tencent.mobileqq.mvvm.h.b(this, BaseChannelViewModel.sViewModelFactory).get(GuildAnnounceViewModel.class);
        this.V = guildAnnounceViewModel;
        guildAnnounceViewModel.getAnnouncement(this.X);
    }

    public static Intent jj(IGProGuildInfo iGProGuildInfo, int i3, int i16) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_guild_guild_info", iGProGuildInfo);
        intent.putExtra("guild_owner_operation_dialog_type", i3);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, i16);
        intent.putExtras(bundle);
        intent.putExtra("_extra_param_report_task", com.tencent.mobileqq.guild.util.report.b.a("guild_setting"));
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void jk(View view) {
        VideoReport.setElementReuseIdentifier(view, "em_sgrp_batch_manage");
        ch.Y0(view, "em_sgrp_batch_manage", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: jl, reason: merged with bridge method [inline-methods] */
    public void sk(Long l3, QUIListItemAdapter qUIListItemAdapter, x<x.b.d, x.c.f> xVar) {
        xVar.O().f(!TextUtils.isEmpty(com.tencent.mobileqq.guild.setting.mute.c.G(l3)));
        qUIListItemAdapter.l0(xVar);
    }

    private com.tencent.mobileqq.widget.listitem.a kj(final QUIListItemAdapter qUIListItemAdapter, @StringRes int i3, View.OnClickListener onClickListener, String str, LiveData<Boolean> liveData, LiveData<String> liveData2) {
        final tz1.b<x.b.d> il5 = il(i3, onClickListener, str);
        if (liveData != null) {
            liveData.observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.ah
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQGuildManageFragment.Vj(tz1.b.this, qUIListItemAdapter, (Boolean) obj);
                }
            });
        }
        if (liveData2 != null) {
            liveData2.observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.ai
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQGuildManageFragment.Wj(tz1.b.this, (String) obj);
                }
            });
        }
        return il5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.tencent.mobileqq.widget.listitem.a kk(QUIListItemAdapter qUIListItemAdapter) {
        com.tencent.mobileqq.widget.listitem.a kj5 = kj(qUIListItemAdapter, R.string.f1489010u, new View.OnClickListener() { // from class: cz1.as
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.Jj(view);
            }
        }, null, this.U.isEnableFeedBatchManage(), null);
        kj5.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: cz1.at
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                QQGuildManageFragment.jk(view);
            }
        });
        return kj5;
    }

    private Group[] lj(final QUIListItemAdapter qUIListItemAdapter) {
        Group.Companion companion = Group.INSTANCE;
        return new Group[]{companion.b((com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.o
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                tz1.b bk5;
                bk5 = QQGuildManageFragment.this.bk(qUIListItemAdapter);
                return bk5;
            }
        })), qj(qUIListItemAdapter), sj(qUIListItemAdapter), rj(qUIListItemAdapter), pj(qUIListItemAdapter), tj(R.string.f156171jh, (com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.p
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                tz1.b dk5;
                dk5 = QQGuildManageFragment.this.dk(qUIListItemAdapter);
                return dk5;
            }
        }), (com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.q
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                tz1.b gk5;
                gk5 = QQGuildManageFragment.this.gk(qUIListItemAdapter);
                return gk5;
            }
        }), (com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.r
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                com.tencent.mobileqq.widget.listitem.a hk5;
                hk5 = QQGuildManageFragment.this.hk(qUIListItemAdapter);
                return hk5;
            }
        })), companion.b((com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.s
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                tz1.b ik5;
                ik5 = QQGuildManageFragment.this.ik();
                return ik5;
            }
        })), companion.b((com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.t
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                x ak5;
                ak5 = QQGuildManageFragment.this.ak(qUIListItemAdapter);
                return ak5;
            }
        })), new Group(ij(qUIListItemAdapter).l(getViewLifecycleOwner(), qUIListItemAdapter).g(gl()).d()), companion.d(new d())};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lk(View view) {
        VideoReport.setElementReuseIdentifier(view, "em_sgrp_batch_manage_auto");
        ch.Y0(view, "em_sgrp_batch_manage_auto", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj() {
        if (Pj()) {
            return;
        }
        this.T.U1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.tencent.mobileqq.widget.listitem.a mk(QUIListItemAdapter qUIListItemAdapter) {
        com.tencent.mobileqq.widget.listitem.a kj5 = kj(qUIListItemAdapter, R.string.f1489110v, new View.OnClickListener() { // from class: cz1.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.Kj(view);
            }
        }, null, this.W.g2(), null);
        kj5.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: cz1.t
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                QQGuildManageFragment.lk(view);
            }
        });
        return kj5;
    }

    private void nj() {
        GuildOwnerOperationTipCard guildOwnerOperationTipCard = this.Y;
        if (guildOwnerOperationTipCard != null) {
            guildOwnerOperationTipCard.dismissAllowingStateLoss();
            this.Y = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void nk(tz1.b bVar, QUIListItemAdapter qUIListItemAdapter, Boolean bool) {
        bVar.V(!bool.booleanValue());
        qUIListItemAdapter.l0(bVar);
    }

    private <T> T oj(k<T> kVar) {
        return kVar.execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ tz1.b ok(final QUIListItemAdapter qUIListItemAdapter) {
        final tz1.b<x.b.d> il5 = il(R.string.f14898112, new View.OnClickListener() { // from class: cz1.aq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.Cj(view);
            }
        }, "em_sgrp_apply_category");
        this.W.h2().observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.ar
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.nk(tz1.b.this, qUIListItemAdapter, (Boolean) obj);
            }
        });
        return il5;
    }

    private Group pj(final QUIListItemAdapter qUIListItemAdapter) {
        return tj(R.string.f1488910t, (com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.c
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                com.tencent.mobileqq.widget.listitem.a kk5;
                kk5 = QQGuildManageFragment.this.kk(qUIListItemAdapter);
                return kk5;
            }
        }), (com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.d
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                com.tencent.mobileqq.widget.listitem.a mk5;
                mk5 = QQGuildManageFragment.this.mk(qUIListItemAdapter);
                return mk5;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void pk(tz1.b bVar, QUIListItemAdapter qUIListItemAdapter, Boolean bool) {
        bVar.V(!bool.booleanValue());
        qUIListItemAdapter.l0(bVar);
    }

    private Group qj(final QUIListItemAdapter qUIListItemAdapter) {
        Group e16 = Group.INSTANCE.e(uj(qUIListItemAdapter), (com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.e
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                tz1.b ok5;
                ok5 = QQGuildManageFragment.this.ok(qUIListItemAdapter);
                return ok5;
            }
        }), (com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.f
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                tz1.b qk5;
                qk5 = QQGuildManageFragment.this.qk(qUIListItemAdapter);
                return qk5;
            }
        }));
        this.f233639k0 = e16;
        return e16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ tz1.b qk(final QUIListItemAdapter qUIListItemAdapter) {
        final tz1.b<x.b.d> il5 = il(R.string.f14896110, new View.OnClickListener() { // from class: cz1.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.Bj(view);
            }
        }, "em_sgrp_section_manage");
        this.W.h2().observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.ag
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.pk(tz1.b.this, qUIListItemAdapter, (Boolean) obj);
            }
        });
        return il5;
    }

    private Group rj(final QUIListItemAdapter qUIListItemAdapter) {
        return Group.INSTANCE.b((com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.m
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                x tk5;
                tk5 = QQGuildManageFragment.this.tk(qUIListItemAdapter);
                return tk5;
            }
        }), (com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.n
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                tz1.b wk5;
                wk5 = QQGuildManageFragment.this.wk(qUIListItemAdapter);
                return wk5;
            }
        }));
    }

    private Group sj(final QUIListItemAdapter qUIListItemAdapter) {
        return tj(R.string.f226396o8, (com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.g
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                tz1.b zk5;
                zk5 = QQGuildManageFragment.this.zk(qUIListItemAdapter);
                return zk5;
            }
        }), (com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.h
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                tz1.b Dk;
                Dk = QQGuildManageFragment.this.Dk(qUIListItemAdapter);
                return Dk;
            }
        }), (com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.i
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                tz1.b Hk;
                Hk = QQGuildManageFragment.this.Hk(qUIListItemAdapter);
                return Hk;
            }
        }), (com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.j
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                tz1.b Lk;
                Lk = QQGuildManageFragment.this.Lk(qUIListItemAdapter);
                return Lk;
            }
        }), (com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.k
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                tz1.b Ok;
                Ok = QQGuildManageFragment.this.Ok(qUIListItemAdapter);
                return Ok;
            }
        }), (com.tencent.mobileqq.widget.listitem.a) oj(new k() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.l
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment.k
            public final Object execute() {
                com.tencent.mobileqq.widget.listitem.a Qk;
                Qk = QQGuildManageFragment.this.Qk(qUIListItemAdapter);
                return Qk;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Group tj(@StringRes int i3, com.tencent.mobileqq.widget.listitem.a<?>... aVarArr) {
        return new Group(getString(i3), aVarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ x tk(final QUIListItemAdapter qUIListItemAdapter) {
        final x xVar = new x(new x.b.d(getString(R.string.f1491411h)), new x.c.f(false, null));
        ((x.c.f) xVar.O()).h(new e(qUIListItemAdapter, xVar));
        if (gl()) {
            this.U.getShowForbiddenWords().observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.ao
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QUIListItemAdapter.this.l0(xVar);
                }
            });
        }
        com.tencent.mobileqq.guild.setting.mute.c.s(this.f233632d0).observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.ap
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.this.sk(qUIListItemAdapter, xVar, (Long) obj);
            }
        });
        xVar.w(new f());
        return xVar;
    }

    private Group.b uj(QUIListItemAdapter qUIListItemAdapter) {
        Group.b bVar = new Group.b(getString(R.string.f1487910j), true);
        bVar.l(getViewLifecycleOwner(), qUIListItemAdapter);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void uk(tz1.b bVar, QUIListItemAdapter qUIListItemAdapter, Boolean bool) {
        bVar.V(!bool.booleanValue());
        qUIListItemAdapter.l0(bVar);
    }

    private void vj(View view) {
        if (Pj() || QQGuildUIUtil.v()) {
            return;
        }
        if (Boolean.FALSE.equals(this.U.getShowBlackListMember().getValue())) {
            al();
        } else {
            GuildBlackListOrRiskFragment.Fh(view.getContext(), this.f233632d0);
            VideoReport.reportEvent("clck", view, this.f233635g0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vk(QUIListItemAdapter qUIListItemAdapter, tz1.b bVar, Long l3) {
        String G = com.tencent.mobileqq.guild.setting.mute.c.G(l3);
        qUIListItemAdapter.m0(bVar, !TextUtils.isEmpty(G));
        bVar.O().h(getString(R.string.f1506515k, G));
        qUIListItemAdapter.l0(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!com.tencent.mobileqq.guild.util.o.a(view) && !Pj()) {
            if (Boolean.FALSE.equals(this.U.getShowGuildJoinMode().getValue())) {
                al();
            } else {
                ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildJoinSetting(getContext(), this.f233632d0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ tz1.b wk(final QUIListItemAdapter qUIListItemAdapter) {
        final tz1.b bVar = new tz1.b(new x.b.C8996b("\u7981\u8a00\u65f6\u957f", R.drawable.qui_list_symbol), new x.c.g("", true, false), false);
        bVar.x(new View.OnClickListener() { // from class: cz1.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.Fj(view);
            }
        });
        this.U.getShowForbiddenWords().observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.uk(tz1.b.this, qUIListItemAdapter, (Boolean) obj);
            }
        });
        com.tencent.mobileqq.guild.setting.mute.c.s(this.f233632d0).observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.this.vk(qUIListItemAdapter, bVar, (Long) obj);
            }
        });
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!com.tencent.mobileqq.guild.util.o.a(view) && !Pj()) {
            if (Boolean.FALSE.equals(this.U.getIsGuildAdminOrCreator().getValue())) {
                al();
            } else {
                Context context = getContext();
                if (context != null) {
                    boolean equals = Boolean.TRUE.equals(this.f233630b0.Q1().getValue());
                    final x xVar = new x(new x.b.d(context.getString(R.string.f1491111e)), new x.c.i(equals, null));
                    ((x.c.i) xVar.O()).e(new com.tencent.mobileqq.widget.listitem.h() { // from class: cz1.bc
                        @Override // com.tencent.mobileqq.widget.listitem.h
                        public final void a(View view2, boolean z16) {
                            QQGuildManageFragment.this.Rk(xVar, view2, z16);
                        }
                    });
                    final x xVar2 = new x(new x.b.d(context.getString(R.string.f1491211f)), new x.c.i(!equals, null));
                    ((x.c.i) xVar2.O()).e(new com.tencent.mobileqq.widget.listitem.h() { // from class: cz1.bd
                        @Override // com.tencent.mobileqq.widget.listitem.h
                        public final void a(View view2, boolean z16) {
                            QQGuildManageFragment.this.Sk(xVar2, view2, z16);
                        }
                    });
                    j jVar = new j(xVar, xVar2);
                    v vVar = this.f233637i0;
                    if (vVar != null) {
                        vVar.Q();
                    }
                    v vVar2 = new v(context, jVar);
                    this.f233637i0 = vVar2;
                    vVar2.show();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void xk(tz1.b bVar, QUIListItemAdapter qUIListItemAdapter, Boolean bool) {
        bVar.V(!bool.booleanValue());
        qUIListItemAdapter.l0(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!com.tencent.mobileqq.guild.util.o.a(view) && !Pj()) {
            if (Boolean.FALSE.equals(this.U.getIsGuildAdminOrCreator().getValue())) {
                al();
            } else {
                Context context = getContext();
                if (context != null) {
                    boolean equals = Boolean.TRUE.equals(this.f233630b0.R1().getValue());
                    final x xVar = new x(new x.b.d(context.getString(R.string.f1491111e)), new x.c.i(equals, null));
                    ((x.c.i) xVar.O()).e(new com.tencent.mobileqq.widget.listitem.h() { // from class: cz1.be
                        @Override // com.tencent.mobileqq.widget.listitem.h
                        public final void a(View view2, boolean z16) {
                            QQGuildManageFragment.this.Tk(xVar, view2, z16);
                        }
                    });
                    final x xVar2 = new x(new x.b.d(context.getString(R.string.f1491211f)), new x.c.i(!equals, null));
                    ((x.c.i) xVar2.O()).e(new com.tencent.mobileqq.widget.listitem.h() { // from class: cz1.bf
                        @Override // com.tencent.mobileqq.widget.listitem.h
                        public final void a(View view2, boolean z16) {
                            QQGuildManageFragment.this.Uk(xVar2, view2, z16);
                        }
                    });
                    i iVar = new i(xVar, xVar2);
                    v vVar = this.f233637i0;
                    if (vVar != null) {
                        vVar.Q();
                    }
                    v vVar2 = new v(context, iVar);
                    this.f233637i0 = vVar2;
                    vVar2.show();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yk(View view) {
        ch.U0(view, "em_sgrp_find_way", new HashMap(this.f233635g0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!com.tencent.mobileqq.guild.util.o.a(view) && !Pj()) {
            if (Boolean.FALSE.equals(this.U.getIsGuildAdminOrCreator().getValue())) {
                al();
            } else {
                GuildOpenBindPermissionUtils.y(this.f233632d0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ tz1.b zk(final QUIListItemAdapter qUIListItemAdapter) {
        final tz1.b<x.b.d> il5 = il(R.string.f14897111, new View.OnClickListener() { // from class: cz1.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageFragment.this.Dj(view);
            }
        }, null);
        this.U.getIsGuildAdminOrCreator().observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.ad
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.xk(tz1.b.this, qUIListItemAdapter, (Boolean) obj);
            }
        });
        il5.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: cz1.ae
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                QQGuildManageFragment.this.yk(view);
            }
        });
        return il5;
    }

    void dl() {
        IGProGuildInfo value = this.W.a2().getValue();
        if (value == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.N, "pg_sgrp_channel_set");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_pg_source", Integer.valueOf(this.f233629a0));
        new GuildDTReportApiImpl().setGuildPageParams(this.N, value.getGuildID(), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        rh();
        Sj();
        this.W = (u) com.tencent.mobileqq.mvvm.h.b(this, u.P).get(u.class);
        this.f233632d0 = ((IGProGuildInfo) requireActivity().getIntent().getExtras().getSerializable("extra_guild_guild_info")).getGuildID();
        this.f233633e0 = ((IGProGuildInfo) requireActivity().getIntent().getExtras().getSerializable("extra_guild_guild_info")).getUserType();
        this.W.e2(this.f233632d0);
        Qj(this.f233632d0);
        this.W.a2().observe(getViewLifecycleOwner(), new Observer() { // from class: cz1.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageFragment.this.bl((IGProGuildInfo) obj);
            }
        });
        uz1.b a16 = uz1.b.INSTANCE.a(requireActivity());
        this.f233630b0 = a16;
        a16.T1(this.f233632d0);
        com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.l lVar = (com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.l) com.tencent.mobileqq.mvvm.h.b(this, com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.l.K).get(com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.l.class);
        this.f233631c0 = lVar;
        lVar.h2(this.f233632d0);
        dl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f36;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 10000 && i16 == -1) {
            ch.u1(BaseApplication.getContext(), "\u8f6c\u8ba9\u6210\u529f");
            onBackEvent();
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        nj();
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v() && (view == this.C || view == this.D)) {
            getActivity().finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        FragmentActivity activity;
        super.onResume();
        if (((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(this.f233632d0) == null && (activity = getActivity()) != null && !activity.isFinishing()) {
            getActivity().finish();
        }
        this.f233631c0.U1();
        this.W.Z1();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        super.rh();
        this.J.a();
        this.J.setBackgroundResource(R.drawable.lvj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class h implements GuildAgainConfirmDialog.b {
        h() {
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog.b
        public void b(View view) {
            QQGuildManageFragment.this.mj();
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog.b
        public void c(View view, View view2) {
            VideoReport.setLogicParent(view, ((QQGuildCustomTitleBarFragment) QQGuildManageFragment.this).P);
            VideoReport.setLogicParent(view2, ((QQGuildCustomTitleBarFragment) QQGuildManageFragment.this).P);
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_btn_type", 1);
            ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
            EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
            bt.c(view, "em_sgrp_channel_set_dismiss_group_pop", hashMap, clickPolicy, exposurePolicy, endExposurePolicy);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("sgrp_btn_type", 2);
            bt.c(view2, "em_sgrp_channel_set_dismiss_group_pop", hashMap2, clickPolicy, exposurePolicy, endExposurePolicy);
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog.b
        public void d(View view) {
            VideoReport.setLogicParent(view, ((QQGuildCustomTitleBarFragment) QQGuildManageFragment.this).P);
            bt.c(view, "em_sgrp_dismiss_group_second_btn", Collections.emptyMap(), ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_NONE);
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog.b
        public void a(View view) {
        }
    }
}
