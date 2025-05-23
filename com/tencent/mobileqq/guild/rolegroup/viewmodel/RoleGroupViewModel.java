package com.tencent.mobileqq.guild.rolegroup.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a;
import com.tencent.mobileqq.guild.rolegroup.model.ModifyRolePermissionType;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.FetchRoleGroupParam;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.PermissionForRoleRepository;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import ux1.g;
import vh2.ar;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RoleGroupViewModel extends ef1.b {
    private String C;
    private String D;
    private int E;
    private RoleGroupModel F;
    private RoleGroupModel G;
    private boolean J;
    private boolean K;
    private String[] H = null;
    private RoleGroupUserUIData[] I = null;
    private final MutableLiveData<List<a.b>> L = new MutableLiveData<>();
    private final MutableLiveData<List<g.b>> M = new MutableLiveData<>();
    private final MutableLiveData<Integer> N = new MutableLiveData<>(0);
    private final MutableLiveData<Integer> P = new MutableLiveData<>(0);
    private final MutableLiveData<Boolean> Q = new MutableLiveData<>(Boolean.FALSE);
    private final MutableLiveData<List<String>> R = new MutableLiveData<>(Collections.EMPTY_LIST);
    private List<IGProUserInfo> S = new ArrayList();
    private int T = 0;
    private ModifyRolePermissionType U = ModifyRolePermissionType.UNCHANGED;
    private final ar V = new ar() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.i
        @Override // vh2.ar
        public final void a(int i3, String str, int i16, boolean z16, List list) {
            RoleGroupViewModel.this.q2(i3, str, i16, z16, list);
        }
    };
    private final com.tencent.mobileqq.guild.base.repository.h<RoleGroupModel> W = new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.j
        @Override // com.tencent.mobileqq.guild.base.repository.h
        public final void a(ri1.a aVar, Object obj) {
            RoleGroupViewModel.this.r2(aVar, (RoleGroupModel) obj);
        }
    };
    private final com.tencent.mobileqq.guild.base.repository.h<RoleGroupModel> X = new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.k
        @Override // com.tencent.mobileqq.guild.base.repository.h
        public final void a(ri1.a aVar, Object obj) {
            RoleGroupViewModel.this.s2(aVar, (RoleGroupModel) obj);
        }
    };
    private final com.tencent.mobileqq.guild.base.repository.h<Boolean> Y = new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.l
        @Override // com.tencent.mobileqq.guild.base.repository.h
        public final void a(ri1.a aVar, Object obj) {
            RoleGroupViewModel.this.t2(aVar, (Boolean) obj);
        }
    };
    private final com.tencent.mobileqq.guild.base.repository.h<Boolean> Z = new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.m
        @Override // com.tencent.mobileqq.guild.base.repository.h
        public final void a(ri1.a aVar, Object obj) {
            RoleGroupViewModel.this.u2(aVar, (Boolean) obj);
        }
    };

    /* renamed from: a0, reason: collision with root package name */
    private final com.tencent.mobileqq.guild.base.repository.h<Boolean> f232859a0 = new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.n
        @Override // com.tencent.mobileqq.guild.base.repository.h
        public final void a(ri1.a aVar, Object obj) {
            RoleGroupViewModel.this.v2(aVar, (Boolean) obj);
        }
    };

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes14.dex */
    public @interface PageState {
        public static final int END = 4;
        public static final int LOADING = 0;
        public static final int NORMAL = 1;
        public static final int RELOADED = 3;
        public static final int RELOADING = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements com.tencent.mobileqq.guild.base.repository.h<List<IGProCategoryChannelInfoList>> {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ri1.a aVar, List<IGProCategoryChannelInfoList> list) {
            if (!aVar.d()) {
                QLog.e("Guild.rg.RoleGroupViewModel", 1, "fetchChannelList error!", aVar);
                return;
            }
            QLog.i("Guild.rg.RoleGroupViewModel", 1, "fetchChannelList " + list.toString());
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                ArrayList<IGProChannel> channelInfoList = list.get(i3).getChannelInfoList();
                for (int i16 = 0; i16 < channelInfoList.size(); i16++) {
                    arrayList.add(String.valueOf(channelInfoList.get(i16).getChannelId()));
                }
            }
            RoleGroupViewModel.this.R.setValue(arrayList);
        }
    }

    public RoleGroupViewModel(String str, String str2, int i3) {
        QLog.i("Guild.rg.RoleGroupViewModel", 1, "init guildId:" + str + " , roleId:" + str2 + " , openType:" + i3);
        this.C = str;
        this.D = str2;
        this.E = i3;
        a2();
        b2();
        Z1();
    }

    private boolean n2() {
        return TextUtils.isEmpty(this.F.getName().trim());
    }

    private boolean p2() {
        if (this.F.getRolePermission().i().size() != this.G.getRolePermission().i().size()) {
            return true;
        }
        Iterator<Integer> it = this.F.getRolePermission().i().iterator();
        while (it.hasNext()) {
            if (!this.G.getRolePermission().i().contains(Integer.valueOf(it.next().intValue()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q2(int i3, String str, int i16, boolean z16, List list) {
        if (i3 != 0) {
            QLog.e("Guild.rg.RoleGroupViewModel", 1, "Failed fetchMemberListCallback, error: " + str);
            QQToastUtil.showQQToast(1, str);
            this.N.setValue(4);
            return;
        }
        this.P.setValue(Integer.valueOf(i16));
        this.S = list;
        this.L.setValue(tx1.b.c(this.C, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2(ri1.a aVar, RoleGroupModel roleGroupModel) {
        if (aVar.d() && roleGroupModel != null) {
            QLog.d("Guild.rg.RoleGroupViewModel", 1, "fetchRoleGroupCallback openType:", Integer.valueOf(this.E));
            int i3 = this.E;
            if (i3 == 0) {
                this.F.E(roleGroupModel.getChannelPermission());
                this.F.getRolePermission().u(roleGroupModel.getRolePermission().g());
                this.F.getRolePermission().v(roleGroupModel.getRolePermission().h());
            } else if (i3 == 2) {
                this.F = roleGroupModel;
            } else {
                QLog.w("Guild.rg.RoleGroupViewModel", 1, "Unknown openType" + this.E);
                this.N.setValue(4);
                return;
            }
            if (roleGroupModel.getLvRole() != null) {
                this.F.I(roleGroupModel.getLvRole().getManageTagPendingColor());
                this.F.G(roleGroupModel.getLvRole().getDisplayTagName());
            }
            this.G = RoleGroupModel.b(this.F);
            this.T = this.F.getRolePermission().i().size();
            this.Q.setValue(Boolean.valueOf(this.F.getIsLevelRole()));
            this.M.setValue(com.tencent.mobileqq.guild.rolegroup.model.data.b.e(this.F));
            this.L.setValue(tx1.b.c(this.C, this.S));
            this.N.setValue(1);
            return;
        }
        QLog.e("Guild.rg.RoleGroupViewModel", 1, "Failed fetchRoleGroupCallback, error: " + aVar + " result:" + roleGroupModel);
        QQToastUtil.showQQToast(1, aVar.f431478b);
        this.N.setValue(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s2(ri1.a aVar, RoleGroupModel roleGroupModel) {
        if (aVar.d() && roleGroupModel != null) {
            RoleGroupModel roleGroupModel2 = this.F;
            if (roleGroupModel2 != null) {
                roleGroupModel2.E(roleGroupModel.getChannelPermission());
            }
            this.N.setValue(3);
            return;
        }
        QLog.e("Guild.rg.RoleGroupViewModel", 1, "Failed fetchPermissionsCallback, error: " + aVar + " result:" + roleGroupModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2(ri1.a aVar, Boolean bool) {
        this.K = false;
        if (aVar.d() && !Boolean.FALSE.equals(bool)) {
            QQToastUtil.showQQToast(2, R.string.f146160tf);
            this.J = true;
            this.N.setValue(4);
            return;
        }
        QLog.e("Guild.rg.RoleGroupViewModel", 1, "Failed createRoleGroupCallback, error: " + aVar + " result:" + bool);
        QQToastUtil.showQQToast(1, cb.d(aVar.f431478b, QQGuildUIUtil.r(R.string.f146230tm)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u2(ri1.a aVar, Boolean bool) {
        if (aVar.d() && !Boolean.FALSE.equals(bool)) {
            QQToastUtil.showQQToast(2, R.string.f146370u0);
            this.N.setValue(4);
            return;
        }
        QLog.e("Guild.rg.RoleGroupViewModel", 1, "Failed deleteRoleGroupCallback, error: " + aVar + " result:" + bool);
        QQToastUtil.showQQToast(1, cb.d(aVar.f431478b, QQGuildUIUtil.r(R.string.f146250to)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v2(ri1.a aVar, Boolean bool) {
        int i3;
        this.K = false;
        if (aVar.d() && !Boolean.FALSE.equals(bool)) {
            QQToastUtil.showQQToast(2, R.string.f155101gl);
            MutableLiveData<Integer> mutableLiveData = this.N;
            if (this.U == ModifyRolePermissionType.NO_PERMISSION) {
                i3 = 3;
            } else {
                i3 = 4;
            }
            mutableLiveData.setValue(Integer.valueOf(i3));
            return;
        }
        QLog.e("Guild.rg.RoleGroupViewModel", 1, "Failed updateRoleGroupCallback, error: " + aVar + " result:" + bool);
        QQToastUtil.showQQToast(1, cb.d(aVar.f431478b, QQGuildUIUtil.r(R.string.f146440u7)));
    }

    public void A2() {
        if (!this.K) {
            if (this.N.getValue() == null || this.N.getValue().intValue() != 4) {
                if (!NetworkUtil.isNetworkAvailable()) {
                    QQToastUtil.showQQToast(1, R.string.f1514417p);
                } else if (!this.F.getIsLevelRole() && n2()) {
                    QQToastUtil.showQQToast(1, R.string.f158111oq);
                } else {
                    this.K = true;
                    com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p().a(this.C, this.D, this.F, this.f232859a0);
                }
            }
        }
    }

    public boolean U1() {
        if (!this.F.getIsLevelRole() && TextUtils.isEmpty(this.F.getName().trim())) {
            return false;
        }
        if (this.F.A(this.G) && !p2()) {
            return false;
        }
        return true;
    }

    public void W1() {
        if (!this.K) {
            if (this.N.getValue() == null || this.N.getValue().intValue() != 4) {
                if (!NetworkUtil.isNetworkAvailable()) {
                    QQToastUtil.showQQToast(1, R.string.f1514417p);
                } else if (n2()) {
                    QQToastUtil.showQQToast(1, R.string.f138730_c);
                } else {
                    this.K = true;
                    com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p().i(this.C, this.F, this.Y);
                }
            }
        }
    }

    public void X1() {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToast(1, R.string.f146250to);
        } else {
            com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p().o(this.C, this.D, this.Z);
        }
    }

    public void Z1() {
        QLog.i("Guild.rg.RoleGroupViewModel", 1, "fetchChannelList()");
        PermissionForRoleRepository.f(this.C, new a());
    }

    public void a2() {
        if (this.E == 0) {
            this.L.setValue(new ArrayList());
            this.P.setValue(0);
        } else {
            ((IGPSService) ch.R0(IGPSService.class)).fetchRoleMemberList(this.C, this.D, 15, true, this.V);
        }
    }

    public void b2() {
        if (this.E == 0) {
            this.D = String.valueOf(1);
            this.F = RoleGroupModel.D();
        }
        com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p().g(new FetchRoleGroupParam(this.C, this.D, true, 120), this.W);
    }

    public RoleGroupUserUIData[] c2() {
        return this.I;
    }

    public String[] d2() {
        return this.H;
    }

    public MutableLiveData<Boolean> e2() {
        return this.Q;
    }

    public MutableLiveData<Integer> f2() {
        return this.P;
    }

    public RoleGroupModel g2() {
        return this.F;
    }

    public MutableLiveData<Integer> getPageState() {
        return this.N;
    }

    public int h2() {
        return this.T;
    }

    public RoleGroupModel i2() {
        return this.G;
    }

    public MutableLiveData<List<g.b>> j2() {
        return this.M;
    }

    public MutableLiveData<List<a.b>> k2() {
        return this.L;
    }

    public int l2() {
        return this.F.getRolePermission().i().size();
    }

    public boolean m2() {
        if (this.N.getValue().intValue() == 0) {
            return true;
        }
        return false;
    }

    public boolean o2() {
        return this.J;
    }

    public LiveData<List<String>> w2() {
        return this.R;
    }

    public void x2() {
        QLog.i("Guild.rg.RoleGroupViewModel", 1, "reloadPermissions");
        this.N.setValue(2);
        com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p().g(new FetchRoleGroupParam(this.C, this.D, true, 119), this.X);
    }

    public void y2(ModifyRolePermissionType modifyRolePermissionType) {
        this.U = modifyRolePermissionType;
    }

    public void z2(String[] strArr, RoleGroupUserUIData[] roleGroupUserUIDataArr) {
        this.H = strArr;
        this.I = roleGroupUserUIDataArr;
        if (strArr == null) {
            this.H = new String[0];
            this.I = new RoleGroupUserUIData[0];
        }
        this.F.M(Arrays.asList(this.H));
        this.F.L(this.H.length);
        this.L.setValue(tx1.b.g(this.C, this.I));
        this.P.setValue(Integer.valueOf(this.I.length));
    }
}
