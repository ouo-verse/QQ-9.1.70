package com.tencent.mobileqq.guild.setting.member.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.repository.h;
import com.tencent.mobileqq.guild.rolegroup.model.data.GuildTarget;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleToMemberListModel;
import com.tencent.mobileqq.guild.rolegroup.model.data.f;
import com.tencent.mobileqq.guild.rolegroup.model.puller.GuildMemberPuller;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.setting.member.fragments.GuildMemberListFragment;
import com.tencent.mobileqq.guild.setting.member.view.j;
import com.tencent.mobileqq.guild.setting.member.viewmodel.GuildRoleMemberListViewModel;
import com.tencent.mobileqq.guild.setting.mute.c;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.fm;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import vh2.cd;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRoleMemberListViewModel extends ef1.b implements GuildMemberPuller.b {
    private final IGProGuildInfo C;
    private final GuildMemberPuller D;
    private final r E;
    private RoleToMemberListModel F;
    private ArrayList<j.c> G = new ArrayList<>();
    private final MediatorLiveData<List<j.c>> H;
    private final MutableLiveData<Integer> I;
    private final cn<cf1.b> J;
    private final MutableLiveData<Integer> K;
    private final cn<List<String>> L;
    private com.tencent.mobileqq.guild.avatar.a M;
    private boolean N;
    private boolean P;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes14.dex */
    public @interface LoadState {
        public static final int END = 3;
        public static final int HAS_MORE = 2;
        public static final int IDLE = 0;
        public static final int LOADING = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f234771a;

        static {
            int[] iArr = new int[GuildMemberPuller.PullStep.values().length];
            f234771a = iArr;
            try {
                iArr[GuildMemberPuller.PullStep.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f234771a[GuildMemberPuller.PullStep.HAS_MORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f234771a[GuildMemberPuller.PullStep.PULL_ENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f234772a = 0;

        b() {
        }

        void b(RoleToMemberListModel roleToMemberListModel) {
            RoleGroupModel roleGroupModel = roleToMemberListModel.h().get(String.valueOf(2));
            if (roleGroupModel != null) {
                this.f234772a = roleGroupModel.getColor();
            }
        }
    }

    public GuildRoleMemberListViewModel(IGProGuildInfo iGProGuildInfo, String str, r rVar, Boolean bool) {
        MediatorLiveData<List<j.c>> mediatorLiveData = new MediatorLiveData<>();
        this.H = mediatorLiveData;
        this.I = new MutableLiveData<>(0);
        this.J = new cn<>();
        this.K = new MutableLiveData<>(0);
        this.L = new cn<>();
        this.N = true;
        this.P = false;
        this.C = iGProGuildInfo;
        this.E = rVar;
        this.D = new GuildMemberPuller(iGProGuildInfo.getGuildID(), str, new WeakReference(this));
        this.F = new RoleToMemberListModel(iGProGuildInfo.getGuildID());
        mediatorLiveData.addSource(c.K(), new Observer() { // from class: e02.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRoleMemberListViewModel.this.f2((String) obj);
            }
        });
        this.P = bool.booleanValue();
    }

    private List<j.c> R1(RoleToMemberListModel roleToMemberListModel, int i3) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        String selfTinyId = ((IGPSService) ch.S0(IGPSService.class, "")).getSelfTinyId();
        b bVar = new b();
        bVar.b(roleToMemberListModel);
        for (f fVar : roleToMemberListModel.g().values()) {
            RoleGroupModel role = fVar.getRole();
            int size = arrayList.size();
            int i16 = 0;
            for (IGProUserInfo iGProUserInfo : fVar.d()) {
                if (!hashSet.contains(iGProUserInfo.getTinyId())) {
                    arrayList.add(new j.c(iGProUserInfo, role, Boolean.valueOf(TextUtils.equals(selfTinyId, iGProUserInfo.getTinyId())), bVar.f234772a));
                    hashSet.add(iGProUserInfo.getTinyId());
                    i16++;
                }
            }
            if (i16 > 0) {
                arrayList.add(size, new j.c(role, i16));
            }
        }
        if (i3 == 3 && arrayList.size() > 0) {
            arrayList.add(new j.c(3));
        }
        return arrayList;
    }

    private int U1() {
        MutableLiveData<Integer> mutableLiveData = this.I;
        if (mutableLiveData != null) {
            return mutableLiveData.getValue().intValue();
        }
        return 0;
    }

    @NonNull
    private h<Boolean> Z1(final String str, final List<String> list, final List<String> list2) {
        return new h() { // from class: e02.g
            @Override // com.tencent.mobileqq.guild.base.repository.h
            public final void a(ri1.a aVar, Object obj) {
                GuildRoleMemberListViewModel.this.a2(list, list2, str, aVar, (Boolean) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a2(List list, List list2, String str, ri1.a aVar, Boolean bool) {
        if (aVar.d() && bool != null && bool.booleanValue()) {
            l2(list, list2, aVar);
            h2(new GuildMemberListFragment.PendingAction(str, false));
            return;
        }
        QLog.e("Guild.userl.GuildRoleMemberListViewModel", 1, "Failed modifyRole: " + aVar.toString());
        l2(list, list2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b2(String str, boolean z16, ri1.a aVar, List list) {
        if (!aVar.d()) {
            QLog.e("Guild.userl.GuildRoleMemberListViewModel", 1, "Failed fetchMemberRoles after modifyRoles, error: " + aVar);
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((RoleGroupModel) it.next()).getRoleType() == 6) {
                int i3 = this.F.i();
                this.F.k(Collections.singletonList(str));
                this.G = new ArrayList<>(R1(this.F, U1()));
                MutableLiveData<Integer> mutableLiveData = this.K;
                mutableLiveData.setValue(Integer.valueOf((mutableLiveData.getValue().intValue() + this.F.i()) - i3));
                this.H.setValue(this.G);
                this.L.setValue(Collections.singletonList(str));
                QLog.e("Guild.userl.GuildRoleMemberListViewModel", 1, "user is a visitor, error: " + aVar);
                return;
            }
        }
        if (z16) {
            QLog.d("Guild.userl.GuildRoleMemberListViewModel", 1, "robot no role");
            return;
        }
        this.F.n(str, list);
        ArrayList<j.c> arrayList = new ArrayList<>(R1(this.F, U1()));
        this.G = arrayList;
        this.H.setValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c2(Function1 function1, List list, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        ri1.a e16 = ri1.a.e(i3, str, iGProSecurityResult);
        if (!e16.d()) {
            function1.invoke(e16);
            return;
        }
        int i16 = this.F.i();
        boolean k3 = this.F.k(list);
        this.L.setValue(list);
        if (k3) {
            this.G = new ArrayList<>(R1(this.F, U1()));
            MutableLiveData<Integer> mutableLiveData = this.K;
            mutableLiveData.setValue(Integer.valueOf((mutableLiveData.getValue().intValue() + this.F.i()) - i16));
            this.H.setValue(this.G);
        }
        function1.invoke(e16);
    }

    private void e2(@NonNull GuildMemberPuller.PullStep pullStep) {
        this.H.postValue(this.G);
        n2(pullStep);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f2(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.userl.GuildRoleMemberListViewModel", 2, "onUserMuteStateChange: ", str);
        }
        if (this.F.m(str, c.H(this.C.getGuildID(), str))) {
            this.H.postValue(this.G);
        }
    }

    private void g2(List<String> list) {
        this.M.g(this.C.getGuildID(), list.subList(0, com.tencent.mobileqq.guild.avatar.a.d(list)));
    }

    private void h2(GuildMemberListFragment.PendingAction pendingAction) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.userl.GuildRoleMemberListViewModel", 2, "refreshRoles, pendingAction: " + pendingAction + " stack:" + QLog.getStackTraceString(new Exception()));
        }
        final String tinyId = pendingAction.getTinyId();
        final boolean isRobot = pendingAction.isRobot();
        this.E.n(GuildTarget.d(this.C.getGuildID(), this.D.getChannelId()), tinyId, new h() { // from class: e02.e
            @Override // com.tencent.mobileqq.guild.base.repository.h
            public final void a(ri1.a aVar, Object obj) {
                GuildRoleMemberListViewModel.this.b2(tinyId, isRobot, aVar, (List) obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l2(List<String> list, List<String> list2, ri1.a aVar) {
        Integer num;
        IGProSecurityResult iGProSecurityResult = null;
        if (list.size() == 1 && list.contains("2")) {
            if (aVar.d()) {
                ch.d1(2, R.string.f156071j8);
            } else {
                num = Integer.valueOf(R.string.f156381k2);
                if (list2.size() == 1 && list2.contains("2")) {
                    if (!aVar.d()) {
                        ch.d1(2, R.string.f156511ke);
                    } else {
                        num = Integer.valueOf(R.string.f156501kd);
                    }
                }
                if (aVar.d() && num != null) {
                    Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
                    Object obj = aVar.f431479c;
                    if (obj instanceof IGProSecurityResult) {
                        iGProSecurityResult = (IGProSecurityResult) obj;
                    }
                    SecurityTipHelperKt.B(applicationContext, aVar.f431477a, aVar.f431478b, iGProSecurityResult, applicationContext.getString(num.intValue()));
                    return;
                }
            }
        }
        num = null;
        if (list2.size() == 1) {
            if (!aVar.d()) {
            }
        }
        if (aVar.d()) {
        }
    }

    private void n2(GuildMemberPuller.PullStep pullStep) {
        int i3 = a.f234771a[pullStep.ordinal()];
        if (i3 != 2) {
            if (i3 == 3) {
                this.I.setValue(3);
                return;
            }
            return;
        }
        this.I.setValue(2);
    }

    public LiveData<Integer> S1() {
        return this.I;
    }

    public LiveData<List<j.c>> T1() {
        return this.H;
    }

    public cn<List<String>> W1() {
        return this.L;
    }

    public MutableLiveData<Integer> X1() {
        return this.K;
    }

    public void d2(String str, List<String> list, List<String> list2) {
        this.E.l(GuildTarget.e(this.C.getGuildID()), str, list, list2, Z1(str, list, list2));
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.puller.GuildMemberPuller.b
    public void h1(@NonNull ri1.a aVar, @NonNull GuildMemberPuller.PullStep pullStep, RoleToMemberListModel roleToMemberListModel, int i3) {
        int i16;
        if (!aVar.d()) {
            QLog.e("Guild.userl.GuildRoleMemberListViewModel", 1, "Failed pulling guildMembers, error: " + aVar.toString());
            this.J.setValue(new cf1.b(aVar.f431477a, aVar.f431478b, null));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Guild.userl.GuildRoleMemberListViewModel", 2, "pulling guildMembers succ");
        }
        this.K.setValue(Integer.valueOf(i3));
        this.F = roleToMemberListModel;
        if (pullStep == GuildMemberPuller.PullStep.PULL_ENDING) {
            i16 = 3;
        } else {
            i16 = 0;
        }
        ArrayList<j.c> arrayList = new ArrayList<>(R1(roleToMemberListModel, i16));
        this.G = arrayList;
        if (this.N && this.M != null) {
            this.N = false;
            g2(j.c.b(arrayList));
        }
        e2(pullStep);
    }

    public void i2(GuildMemberListFragment.PendingAction pendingAction) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.userl.GuildRoleMemberListViewModel", 2, "refreshUser, stack:" + QLog.getStackTraceString(new Exception()));
        }
        h2(pendingAction);
    }

    public void j2(final List<String> list, boolean z16, int i3, final Function1<ri1.a, Unit> function1) {
        ((IGPSService) ch.R0(IGPSService.class)).kickGuildUsers(this.C.getGuildID(), list, z16, new fm.a().c(i3).b(), new cd() { // from class: e02.f
            @Override // vh2.cd
            public final void a(int i16, String str, IGProSecurityResult iGProSecurityResult) {
                GuildRoleMemberListViewModel.this.c2(function1, list, i16, str, iGProSecurityResult);
            }
        });
    }

    public void k2(com.tencent.mobileqq.guild.avatar.a aVar) {
        this.M = aVar;
    }

    @UiThread
    public void loadMore() {
        int intValue = this.I.getValue().intValue();
        if (intValue != 1 && intValue != 3) {
            this.D.f(this.P);
            this.I.setValue(1);
        }
    }

    public cn<cf1.b> m2() {
        return this.J;
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(String str) {
        super.onAccountChanged(str);
        this.D.e();
    }

    @UiThread
    public void refresh() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.userl.GuildRoleMemberListViewModel", 2, "refresh, stack:" + QLog.getStackTraceString(new Exception()));
        }
        this.D.h();
        this.I.setValue(0);
        this.D.f(this.P);
        this.I.setValue(1);
    }
}
