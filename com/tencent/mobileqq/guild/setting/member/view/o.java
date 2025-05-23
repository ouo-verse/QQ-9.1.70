package com.tencent.mobileqq.guild.setting.member.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.client.widget.GuildClientIdentityView;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.setting.member.view.j;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.ac;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.mini.config.AppConst;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserChannelShowState;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.widget.AbsListView;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DebugKt;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class o implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final int V = Utils.n(115.0f, MobileQQ.sMobileQQ.getResources());
    private static final int W = Utils.n(64.0f, MobileQQ.sMobileQQ.getResources());
    public static final int X = ViewUtils.dip2px(40.0f);
    public static final int Y = ViewUtils.dip2px(40.0f);
    public ImageView C;
    public TextView D;
    public ImageView E;
    public ImageView F;
    public TextView G;
    public TextView H;
    public QUICheckBox I;
    public GuildClientIdentityView J;
    public GuildLevelRoleView K;
    public View L;
    public ImageView M;
    public TextView N;
    public TextView P;
    public View Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private j.c U;

    /* renamed from: d, reason: collision with root package name */
    private final AppInterface f234746d;

    /* renamed from: e, reason: collision with root package name */
    private final j.b f234747e;

    /* renamed from: f, reason: collision with root package name */
    private final a f234748f;

    /* renamed from: h, reason: collision with root package name */
    public View f234749h;

    /* renamed from: i, reason: collision with root package name */
    public GuildUserAvatarView f234750i;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f234751m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void a(CompoundButton compoundButton, boolean z16);
    }

    public o(AppInterface appInterface, j.b bVar, a aVar) {
        this.f234746d = appInterface;
        this.f234747e = bVar;
        this.f234748f = aVar;
    }

    private void A(boolean z16, IGProRoleManagementTag iGProRoleManagementTag) {
        ac.d(this.f234746d, this.P, iGProRoleManagementTag, z16);
        if (z16) {
            this.Q.setVisibility(0);
            this.K.setVisibility(8);
        } else {
            this.Q.setVisibility(8);
        }
    }

    private void f(String str, IGProUserInfo iGProUserInfo) {
        int levelRoleId = iGProUserInfo.getLevelRoleId();
        IGProGuildRoleInfo memberLevelRole = ((IGPSService) ch.R0(IGPSService.class)).getMemberLevelRole(str, iGProUserInfo.getTinyId(), levelRoleId + "");
        if (QLog.isDebugVersion()) {
            QLog.i("Guild.userl.QQGuildColorMemberViewHolder", 4, "bindLevelRoleInfo levelRoleId: " + levelRoleId + ", sdkRoleInfo : " + memberLevelRole);
        }
        if (memberLevelRole == null) {
            QLog.w("Guild.userl.QQGuildColorMemberViewHolder", 1, "bindLevelRoleInfo roleInfo == null! ");
            this.K.setVisibility(8);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.i("Guild.userl.QQGuildColorMemberViewHolder", 4, "bindLevelRoleInfo roleInfo : " + memberLevelRole);
        }
        v(memberLevelRole);
    }

    private void h() {
        QUICheckBox qUICheckBox = this.I;
        if (qUICheckBox != null && qUICheckBox.isShown() && this.I.isEnabled()) {
            this.I.setChecked(!r0.isChecked());
        }
    }

    private void j(View view) {
        view.setTag(-3, Integer.valueOf(W));
        this.G.setVisibility(8);
    }

    private boolean k(int i3) {
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    private boolean l(j.c cVar) {
        if (cVar.f234733f.getUserOnlineState() == 1) {
            return true;
        }
        return false;
    }

    private boolean m(j.c cVar) {
        if (cVar.f234733f.getRobotType() == 1) {
            return true;
        }
        return false;
    }

    private boolean n(j.c cVar) {
        if (!cVar.f234736i && cVar.f234733f.getUserType() != 2) {
            if (this.S) {
                return true;
            }
            return this.T;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit o(GuildLevelRoleView.UIData uIData) {
        if (!TextUtils.equals((String) this.K.getTag(), this.U.f234733f.getTinyId())) {
            QLog.d("Guild.userl.QQGuildColorMemberViewHolder", 1, "convertGuildRoleInfoToUIData cancel");
            return null;
        }
        QLog.d("Guild.userl.QQGuildColorMemberViewHolder", 1, "convertGuildRoleInfoToUIData: " + uIData);
        this.K.s(uIData);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p(j.c cVar, View view) {
        Map<String, Object> map;
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_touin", cVar.f234733f.getTinyId());
        PageInfo nearestPageInfoWithPgId = ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).getNearestPageInfoWithPgId(view);
        if (nearestPageInfoWithPgId != null) {
            map = ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).getPageInfoParams(nearestPageInfoWithPgId);
        } else {
            map = null;
        }
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(view, "em_sgrp_svip_medal", "pg_sgrp_member_list", "", "clck", hashMap, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(final j.c cVar, String str, String str2, final View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        view.post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.member.view.m
            @Override // java.lang.Runnable
            public final void run() {
                o.p(j.c.this, view);
            }
        });
        GuildJumpUtil.v(this.E.getContext(), ig1.a.b(str, str2));
        EventCollector.getInstance().onViewClicked(view);
    }

    private void r(View view, j.c cVar) {
        if (this.S) {
            if (cVar.c()) {
                this.G.setText(view.getResources().getString(R.string.f155951iw));
                this.G.setBackgroundColor(AppConst.COMPAT_STATUS_BAR_BACKGROUND_COLOR);
            } else {
                this.G.setText(view.getResources().getString(R.string.f156391k3));
                this.G.setBackgroundColor(-25856);
            }
        }
    }

    private void s(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_otherapp_id", str);
        VideoReport.setElementParams(this.J, hashMap);
    }

    private void t(View view, j.c cVar) {
        if (this.S) {
            if (cVar.f234733f.getUserType() == 2) {
                view.setTag(-3, 0);
            } else if (cVar.f234733f.getRobotType() == 1) {
                j(view);
            } else {
                view.setTag(-3, Integer.valueOf(V + W));
                this.G.setVisibility(0);
            }
        } else if (this.T) {
            if (!cVar.d() && !cVar.f234736i) {
                j(view);
            } else {
                view.setTag(-3, 0);
            }
        } else {
            view.setTag(-3, 0);
        }
        if (cVar.f234736i) {
            view.setTag(-3, 0);
        }
    }

    private void u(j.c cVar, boolean z16) {
        if (this.R) {
            this.I.setVisibility(0);
            boolean n3 = n(cVar);
            this.I.setEnabled(n3);
            this.f234749h.setEnabled(n3);
            if (n3) {
                this.I.setTag(cVar);
                this.I.setOnCheckedChangeListener(this);
                this.I.setChecked(z16);
                return;
            }
            this.I.setOnCheckedChangeListener(null);
            return;
        }
        this.I.setVisibility(8);
        this.f234749h.setEnabled(true);
        this.I.setOnCheckedChangeListener(null);
    }

    private void v(IGProGuildRoleInfo iGProGuildRoleInfo) {
        this.K.setTag(this.U.f234733f.getTinyId());
        GuildLevelRoleView.l(iGProGuildRoleInfo, "Guild.userl.QQGuildColorMemberViewHolder", new Function1() { // from class: com.tencent.mobileqq.guild.setting.member.view.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit o16;
                o16 = o.this.o((GuildLevelRoleView.UIData) obj);
                return o16;
            }
        });
    }

    private void w(long j3) {
        int i3 = (int) j3;
        if (j3 == -16777216 || j3 == 0) {
            i3 = this.D.getContext().getResources().getColor(R.color.guild_skin_content_text);
        }
        this.D.setTextColor(i3);
    }

    private void x(j.c cVar, IGProRoleManagementTag iGProRoleManagementTag) {
        if (iGProRoleManagementTag != null && iGProRoleManagementTag.getColor() != 0) {
            w(GuildUIUtils.f235378a.g(iGProRoleManagementTag.getColor()));
        } else {
            w(cVar.f234729b);
        }
    }

    private void y(j.c cVar) {
        String url = cVar.f234737j.getUrl();
        if (!StringUtil.isEmpty(url)) {
            u.q(url, this.F, true);
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(8);
        }
    }

    private void z(final j.c cVar, final String str, final String str2) {
        byte[] vasPlateData;
        this.E.setVisibility(8);
        if (cVar.f234733f != null && (vasPlateData = this.U.f234733f.getVasPlateData()) != null && vasPlateData.length > 0) {
            if (QLog.isDebugVersion()) {
                QLog.i("Guild.userl.QQGuildColorMemberViewHolder", 4, "plateData is not null," + new String(vasPlateData));
            }
            Drawable c16 = ig1.a.c("", vasPlateData, this.E.getResources());
            if (c16 != null) {
                ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAllPolicy(this.E, "em_sgrp_svip_medal");
                this.E.setVisibility(0);
                this.E.setImageDrawable(c16);
                this.E.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.member.view.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        o.this.q(cVar, str, str2, view);
                    }
                });
            }
        }
    }

    public void d(IGProUserInfo iGProUserInfo) {
        IGProIdentityInfo e16 = GuildClientIdentityView.e(iGProUserInfo);
        if (e16 != null) {
            this.J.a(e16);
        } else {
            this.J.c(iGProUserInfo);
        }
        s(GuildClientIdentityView.d(iGProUserInfo));
    }

    public void e(IGProUserInfo iGProUserInfo) {
        String str;
        boolean z16;
        this.L.setVisibility(8);
        IGProClientPresenceInfo clientPresence = iGProUserInfo.getClientPresence();
        IGProUserChannelShowState userChannelShowState = iGProUserInfo.getBusinessInfo().getUserChannelShowState();
        if (!k(iGProUserInfo.getUserType())) {
            str = com.tencent.mobileqq.guild.setting.mute.c.r(iGProUserInfo.getShutUpExpireTime());
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = userChannelShowState.getStateInfo();
        }
        if (TextUtils.isEmpty(str)) {
            str = ng1.a.a(clientPresence);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.N.setText(str);
        if (com.tencent.mobileqq.guild.setting.mute.c.O(Long.valueOf(iGProUserInfo.getShutUpExpireTime())) && !k(iGProUserInfo.getUserType())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.M.setImageResource(R.drawable.guild_icon_mute_in_member_list);
            this.L.setVisibility(0);
            return;
        }
        this.L.setVisibility(0);
        String stateIcon = userChannelShowState.getStateIcon();
        if (TextUtils.isEmpty(stateIcon)) {
            stateIcon = clientPresence.getSmallIcon();
        }
        if (!TextUtils.isEmpty(stateIcon)) {
            this.M.setVisibility(0);
            this.M.setImageDrawable(URLDrawable.getDrawable(stateIcon, (URLDrawable.URLDrawableOptions) null));
        } else {
            this.M.setVisibility(8);
        }
    }

    public void g(String str, String str2, j.c cVar, boolean z16, boolean z17, boolean z18, boolean z19) {
        String str3;
        this.R = z17;
        this.S = z18;
        this.T = z19;
        this.U = cVar;
        u(cVar, z16);
        t(this.f234749h, cVar);
        r(this.f234749h, cVar);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setStroke(bi.a(0.5f), this.f234751m.getResources().getColorStateList(R.color.qui_common_border_standard));
        this.f234751m.setBackground(gradientDrawable);
        this.f234750i.setAvatarTinyId(str, cVar.f234733f.getTinyId());
        this.D.setText(ch.d0(cVar.f234733f));
        this.D.setTag(cVar);
        this.D.setOnClickListener(this);
        IGProRoleManagementTag roleManagementTag = cVar.f234733f.getRoleManagementTag();
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.userl.QQGuildColorMemberViewHolder", 1, "bind member info, user: " + cVar + ", tag: " + roleManagementTag);
        }
        x(cVar, roleManagementTag);
        z(cVar, str, str2);
        y(cVar);
        d(cVar.f234733f);
        e(cVar.f234733f);
        boolean m3 = m(cVar);
        if (!m3) {
            f(str, cVar.f234733f);
        }
        A(m3, roleManagementTag);
        if (l(cVar)) {
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(8);
        }
        this.G.setTag(cVar);
        this.G.setOnClickListener(this);
        this.H.setTag(cVar);
        this.H.setOnClickListener(this);
        this.f234749h.setTag(R.id.dq8, cVar);
        this.f234749h.setOnClickListener(this);
        this.K.setOnClickListener(this);
        HashMap hashMap = new HashMap();
        if (l(cVar)) {
            str3 = "on";
        } else {
            str3 = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        }
        hashMap.put("sgrp_member_online", str3);
        VideoReport.setElementParams(this.f234749h, hashMap);
        VideoReport.setElementReuseIdentifier(this.f234749h, cVar.f234733f.getTinyId());
        VideoReport.setElementReuseIdentifier(this.J, cVar.f234733f.getTinyId());
    }

    public View i(ViewGroup viewGroup) {
        vp1.ac g16 = vp1.ac.g(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        g16.getRoot().setLayoutParams(new AbsListView.LayoutParams(-1, ViewUtils.dpToPx(56.0f)));
        ConstraintLayout root = g16.getRoot();
        root.setTag(this);
        GuildUserAvatarView guildUserAvatarView = g16.f442156d;
        this.f234750i = guildUserAvatarView;
        guildUserAvatarView.setLogTag("Guild.userl.QQGuildColorMemberViewHolder");
        this.f234750i.setTag(R.id.w0_, Integer.valueOf(X));
        this.f234750i.setTag(R.id.f165436w01, Integer.valueOf(Y));
        this.f234751m = g16.f442155c;
        this.C = g16.f442169q;
        this.D = g16.f442165m;
        this.E = g16.f442167o;
        this.F = g16.f442166n;
        this.G = g16.f442168p;
        this.H = g16.f442164l;
        this.I = g16.f442171s;
        this.P = g16.f442160h;
        this.J = g16.f442163k;
        this.K = g16.f442161i;
        this.L = g16.f442159g;
        this.M = g16.f442157e;
        this.N = g16.f442158f;
        this.Q = g16.f442170r;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        ch.Y0(root, "em_sgrp_member_list_member_click", clickPolicy, exposurePolicy);
        ch.Y0(this.G, "em_sgrp_member_list_member_manage", clickPolicy, exposurePolicy);
        ch.Y0(this.H, "em_sgrp_member_list_member_manage_set", clickPolicy, exposurePolicy);
        GuildClientIdentityView guildClientIdentityView = this.J;
        ClickPolicy clickPolicy2 = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy2 = ExposurePolicy.REPORT_ALL;
        ch.Y0(guildClientIdentityView, "em_sgrp_memberlist_otherapp_identity", clickPolicy2, exposurePolicy2);
        ch.Y0(this.L, "em_sgrp_memberlist_otherapp_status", clickPolicy2, exposurePolicy2);
        this.f234749h = root;
        return root;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        this.f234748f.a(compoundButton, z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j.c cVar;
        IGProUserInfo iGProUserInfo;
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.R) {
            h();
        } else {
            boolean z16 = true;
            int i3 = 1;
            if (view.getId() != R.id.dq8 && view.getId() != R.id.xw7 && view.getId() != R.id.xsl) {
                if (view.getId() == R.id.xw6) {
                    this.f234747e.f((j.c) view.getTag());
                    HashMap hashMap = new HashMap();
                    hashMap.put("sgrp_member_op_result", 3);
                    VideoReport.reportEvent("clck", view, hashMap);
                } else if (view.getId() == R.id.xw_) {
                    j.c cVar2 = (j.c) view.getTag();
                    this.f234747e.g(cVar2, !cVar2.c());
                    HashMap hashMap2 = new HashMap();
                    if (cVar2.f234733f != null) {
                        if (cVar2.c()) {
                            i3 = 2;
                        }
                        hashMap2.put("sgrp_member_op_result", Integer.valueOf(i3));
                        VideoReport.reportEvent("clck", this.f234749h.findViewById(R.id.xw6), hashMap2);
                    }
                } else if (view.getId() == R.id.xvh) {
                    this.f234747e.e();
                }
            } else {
                if (view.getId() == R.id.dq8) {
                    HashMap hashMap3 = new HashMap();
                    cVar = (j.c) view.getTag(R.id.dq8);
                    if (cVar != null && cVar.f234733f != null) {
                        if (l(cVar)) {
                            str = "on";
                        } else {
                            str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                        }
                        hashMap3.put("sgrp_member_online", str);
                    }
                    VideoReport.reportEvent("clck", view, hashMap3);
                } else {
                    View view2 = this.f234749h;
                    if (view2 != null) {
                        VideoReport.reportEvent("clck", view2, new HashMap());
                        cVar = (j.c) view.getTag();
                    } else {
                        cVar = null;
                    }
                }
                if (cVar != null && (iGProUserInfo = cVar.f234733f) != null) {
                    if (iGProUserInfo.getRobotType() != 1) {
                        z16 = false;
                    }
                    this.f234747e.d(cVar.f234733f, z16);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
