package com.tencent.mobileqq.guild.rolegroup.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.FetchRoleGroupParam;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.List;
import ux1.g;
import vh2.ar;

/* compiled from: P */
/* loaded from: classes14.dex */
public class h extends ef1.b {
    private String C;
    private int D;
    private RoleGroupModel G;
    private final MutableLiveData<List<g.b>> E = new MutableLiveData<>();
    private final MutableLiveData<List<a.b>> F = new MutableLiveData<>();
    private final com.tencent.mobileqq.guild.base.repository.h<RoleGroupModel> H = new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.f
        @Override // com.tencent.mobileqq.guild.base.repository.h
        public final void a(ri1.a aVar, Object obj) {
            h.this.W1(aVar, (RoleGroupModel) obj);
        }
    };

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements ar {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f232905a;

        a(String str) {
            this.f232905a = str;
        }

        @Override // vh2.ar
        public void a(int i3, String str, int i16, boolean z16, List<IGProUserInfo> list) {
            if (i3 != 0) {
                QLog.e("Guild.rg.RoleGroupDescViewModel", 1, "onFetchRoleMemberList Failed to fetch member list:" + str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (IGProUserInfo iGProUserInfo : list) {
                if (iGProUserInfo != null && !iGProUserInfo.getTinyId().equals(this.f232905a)) {
                    arrayList.add(new a.b(2, h.this.C, iGProUserInfo.getTinyId(), iGProUserInfo.getName()));
                }
            }
            h.this.F.setValue(arrayList);
        }
    }

    public h(String str, int i3) {
        this.C = str;
        this.D = i3;
        R1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(ri1.a aVar, RoleGroupModel roleGroupModel) {
        if (aVar.d() && roleGroupModel != null) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.rg.RoleGroupDescViewModel", 2, "fetched roleGroup: " + roleGroupModel);
            }
            this.G = roleGroupModel;
            this.E.setValue(com.tencent.mobileqq.guild.rolegroup.model.data.b.f(roleGroupModel, this.D, GuildDebugUtils.f(this.C)));
            return;
        }
        QLog.e("Guild.rg.RoleGroupDescViewModel", 1, "Failed fetch role group, error: " + aVar + " , result:" + roleGroupModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(boolean z16, int i3, ri1.a aVar, Boolean bool) {
        if (!aVar.d() || Boolean.FALSE.equals(bool)) {
            QLog.e("Guild.rg.RoleGroupDescViewModel", 1, "Failed updateRoleGroup, error: " + aVar + " result:" + bool);
            QQToastUtil.showQQToast(1, cb.d(aVar.f431478b, QQGuildUIUtil.r(R.string.f146440u7)));
            if (z16) {
                this.G.getRolePermission().i().remove(Integer.valueOf(i3));
            } else {
                this.G.getRolePermission().i().add(Integer.valueOf(i3));
            }
            this.E.setValue(com.tencent.mobileqq.guild.rolegroup.model.data.b.f(this.G, this.D, GuildDebugUtils.f(this.C)));
        }
    }

    public void R1() {
        com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p().g(new FetchRoleGroupParam(this.C, String.valueOf(this.D), true, 118), this.H);
    }

    public void S1(int i3, String str) {
        ((IGPSService) ch.S0(IGPSService.class, "")).fetchRoleMemberList(this.C, String.valueOf(this.D), i3, true, new a(str));
    }

    public MutableLiveData<List<a.b>> T1() {
        return this.F;
    }

    public MutableLiveData<List<g.b>> U1() {
        return this.E;
    }

    public void Z1(final int i3, final boolean z16) {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToast(1, R.string.f1514417p);
            this.E.setValue(com.tencent.mobileqq.guild.rolegroup.model.data.b.f(this.G, this.D, GuildDebugUtils.f(this.C)));
        } else {
            if (z16) {
                this.G.getRolePermission().i().add(Integer.valueOf(i3));
            } else {
                this.G.getRolePermission().i().remove(Integer.valueOf(i3));
            }
            com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p().a(this.C, String.valueOf(this.D), this.G, new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.g
                @Override // com.tencent.mobileqq.guild.base.repository.h
                public final void a(ri1.a aVar, Object obj) {
                    h.this.X1(z16, i3, aVar, (Boolean) obj);
                }
            });
        }
    }
}
