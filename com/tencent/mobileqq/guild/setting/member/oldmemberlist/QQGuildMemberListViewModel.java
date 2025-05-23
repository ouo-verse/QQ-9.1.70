package com.tencent.mobileqq.guild.setting.member.oldmemberlist;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.input.at.utils.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.rolegroup.model.data.Permissions;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.s;
import com.tencent.mobileqq.guild.setting.member.fragments.GuildMemberListFragment;
import com.tencent.mobileqq.guild.setting.member.oldmemberlist.QQGuildMemberListViewModel;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.fb;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMemberSearchResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.cl;
import com.tencent.mobileqq.qqguildsdk.data.genc.ex;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberSearchSourceId;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vh2.cd;
import wh2.ec;
import wh2.em;
import wh2.z;
import yz1.q;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildMemberListViewModel extends com.tencent.mobileqq.mvvm.c<wy1.a> {

    /* renamed from: d0, reason: collision with root package name */
    public static ViewModelProvider.Factory f234626d0 = new a();
    protected boolean C;
    protected boolean D;
    protected String E;
    protected boolean F;
    protected boolean G;
    protected final cn<Boolean> H;
    protected final MutableLiveData<List<IGProUserInfo>> I;
    protected final MutableLiveData<Boolean> J;
    protected final MutableLiveData<fb> K;
    protected final MutableLiveData<List<dg1.b>> L;
    protected final MutableLiveData<List<IGProUserInfo>> M;
    protected final MutableLiveData<Boolean> N;
    protected final cn<IGProUserInfo> P;
    protected final cn<IGProUserInfo> Q;
    protected final cn<List<IGProUserInfo>> R;
    protected final cn<List<IGProUserInfo>> S;
    protected final cn<Boolean> T;
    private final MutableLiveData<GuildMemberListFragment.PendingAction> U;
    private final MutableLiveData<Boolean> V;
    private final MutableLiveData<Integer> W;
    protected volatile boolean X;
    protected AppInterface Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private long f234627a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f234628b0;

    /* renamed from: c0, reason: collision with root package name */
    private final GPServiceObserver f234629c0;

    /* renamed from: i, reason: collision with root package name */
    protected volatile boolean f234630i;

    /* renamed from: m, reason: collision with root package name */
    protected IGProGuildInfo f234631m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes14.dex */
    public @interface SearchLoadState {
        public static final int END = 5;
        public static final int FIRST_INIT = 1;
        public static final int FIRST_LOADING = 2;
        public static final int HAS_MORE = 4;
        public static final int IDLE = 0;
        public static final int LOADING = 3;
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements ViewModelProvider.Factory {
        a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new QQGuildMemberListViewModel(new wy1.a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends GPServiceObserver {
        b() {
        }

        private void b(String str, String str2) {
            IGProGuildInfo iGProGuildInfo;
            QLog.i("Guild.userl.QQGuildMemberListViewModel", 1, "handleExitGuild:" + str + str2);
            if (!TextUtils.isEmpty(str2) && (iGProGuildInfo = QQGuildMemberListViewModel.this.f234631m) != null && str2.equals(iGProGuildInfo.getGuildID())) {
                QQGuildMemberListViewModel.this.H.setValue(Boolean.TRUE);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(String str, int i3) {
            b("onBeKickFromGuild", str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(String str) {
            b("onBeKickFromGuild", str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(String str) {
            IGProGuildInfo iGProGuildInfo;
            if (!TextUtils.isEmpty(str) && (iGProGuildInfo = QQGuildMemberListViewModel.this.f234631m) != null && str.equals(iGProGuildInfo.getGuildID())) {
                QQGuildMemberListViewModel.this.f234631m = ch.L(str);
                QQGuildMemberListViewModel qQGuildMemberListViewModel = QQGuildMemberListViewModel.this;
                qQGuildMemberListViewModel.T.postValue(Boolean.valueOf(q.f451648a.d(qQGuildMemberListViewModel.f234631m)));
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onMemberCountUpdate(fb fbVar) {
            QQGuildMemberListViewModel.this.K.setValue(fbVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(String str) {
            b("onRemoveGuild", str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c implements cd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f234633a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IGProUserInfo f234634b;

        c(boolean z16, IGProUserInfo iGProUserInfo) {
            this.f234633a = z16;
            this.f234634b = iGProUserInfo;
        }

        @Override // vh2.cd
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            if (QQGuildMemberListViewModel.this.f234630i) {
                return;
            }
            if (i3 == 0 && ch.p(iGProSecurityResult)) {
                if (this.f234633a) {
                    this.f234634b.setUserType(1);
                    QQGuildMemberListViewModel.this.P.setValue(this.f234634b);
                    ch.f1(BaseApplication.getContext().getString(R.string.f156071j8));
                    return;
                } else {
                    this.f234634b.setUserType(0);
                    QQGuildMemberListViewModel.this.Q.setValue(this.f234634b);
                    ch.f1(BaseApplication.getContext().getString(R.string.f156511ke));
                    return;
                }
            }
            if (this.f234633a) {
                ch.t1(BaseApplication.getContext(), i3, BaseApplication.getContext().getString(R.string.f156381k2), iGProSecurityResult);
            } else {
                ch.t1(BaseApplication.getContext(), i3, BaseApplication.getContext().getString(R.string.f156501kd), iGProSecurityResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements ec {
        d() {
        }

        @Override // wh2.ec
        public void a(int i3, String str, IGProGuildMemberSearchResult iGProGuildMemberSearchResult) {
            if (i3 == 0 && iGProGuildMemberSearchResult != null) {
                QQGuildMemberListViewModel.this.j2(iGProGuildMemberSearchResult);
                return;
            }
            QLog.w("Guild.userl.QQGuildMemberListViewModel", 1, "onSearchGuildMembersBySourceId error, result: " + i3 + "errMsg: " + str);
            QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(R.string.f155011gc), 1).show();
            QQGuildMemberListViewModel.this.j2(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e implements em {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f234637a;

        e(Context context) {
            this.f234637a = context;
        }

        @Override // wh2.em
        public void onResult(int i3, String str) {
            boolean z16 = true;
            if (i3 != 0) {
                QQGuildMemberListViewModel qQGuildMemberListViewModel = QQGuildMemberListViewModel.this;
                qQGuildMemberListViewModel.x2(this.f234637a, qQGuildMemberListViewModel.f2(i3, str));
                QLog.e("Guild.userl.QQGuildMemberListViewModel", 1, "transferGuildOwner is fail" + i3 + "," + str);
            }
            MutableLiveData mutableLiveData = QQGuildMemberListViewModel.this.V;
            if (i3 != 0) {
                z16 = false;
            }
            mutableLiveData.setValue(Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    public QQGuildMemberListViewModel(wy1.a aVar) {
        super(aVar);
        this.U = new MutableLiveData<>();
        this.V = new MutableLiveData<>();
        this.W = new MutableLiveData<>(0);
        this.X = false;
        this.f234628b0 = 1000;
        this.f234629c0 = new b();
        this.H = new cn<>();
        this.I = new MutableLiveData<>();
        this.J = new MutableLiveData<>();
        this.K = new MutableLiveData<>();
        this.L = new MutableLiveData<>();
        this.M = new MutableLiveData<>();
        this.N = new MutableLiveData<>();
        this.P = new cn<>();
        this.Q = new cn<>();
        this.R = new cn<>();
        this.S = new cn<>();
        this.T = new cn<>();
    }

    private void S1() {
        Integer value = this.W.getValue();
        if (value.intValue() == 1) {
            this.W.setValue(2);
        } else if (value.intValue() == 4) {
            this.W.setValue(3);
        } else {
            return;
        }
        cl clVar = new cl();
        clVar.p(GProGuildMemberSearchSourceId.ALL_MEMBER.ordinal());
        clVar.l(g.a(getGuildInfo().getGuildID(), 0L));
        clVar.k(this.f234628b0);
        clVar.m(this.Z);
        clVar.n(this.f234627a0);
        ((IGPSService) this.Y.getRuntimeService(IGPSService.class, "")).searchGuildMembersBySourceId(clVar, new d());
    }

    private void i2(ArrayList<IGProRecommendItem> arrayList) {
        this.L.setValue(dg1.a.d(arrayList));
    }

    private boolean n2() {
        Permissions guildPermission = s.a().getGuildPermission(this.f234631m.getGuildID());
        if (!guildPermission.a(100001) && !guildPermission.a(100002)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2(int i3, String str, ArrayList arrayList) {
        if (i3 != 0) {
            QLog.i("Guild.userl.QQGuildMemberListViewModel", 1, "fetchActiveChannels: result[" + i3 + "] errMsg[" + str + "]");
            return;
        }
        i2(arrayList);
    }

    public boolean N1() {
        return s.a().getGuildPermission(this.f234631m.getGuildID()).a(100002);
    }

    public boolean O1() {
        return this.F;
    }

    public void P1() {
        this.M.setValue(new ArrayList());
        this.W.setValue(0);
    }

    public void Q1(List<String> list) {
        List<IGProUserInfo> value = this.M.getValue();
        if (value == null) {
            return;
        }
        Iterator<IGProUserInfo> it = value.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (list.contains(it.next().getTinyId())) {
                it.remove();
                z16 = true;
            }
        }
        if (z16) {
            this.M.setValue(value);
        }
    }

    public void R1() {
        if (getGuildInfo() == null) {
            return;
        }
        QLog.d("Guild.userl.QQGuildMemberListViewModel", 1, "fetchActiveChannelData:");
        ((IGPSService) this.Y.getRuntimeService(IGPSService.class, "")).fetchActiveChannels(getGuildInfo().getGuildID(), new z() { // from class: b02.c
            @Override // wh2.z
            public final void onFetchActiveChannels(int i3, String str, ArrayList arrayList) {
                QQGuildMemberListViewModel.this.r2(i3, str, arrayList);
            }
        });
    }

    public LiveData<List<dg1.b>> T1() {
        return this.L;
    }

    public MutableLiveData<List<IGProUserInfo>> U1() {
        return this.R;
    }

    public LiveData<Boolean> W1() {
        return this.T;
    }

    public LiveData<Boolean> X1() {
        return this.H;
    }

    public LiveData<Boolean> Z1() {
        return this.N;
    }

    public MutableLiveData<List<IGProUserInfo>> a2() {
        return this.S;
    }

    public LiveData<GuildMemberListFragment.PendingAction> b2() {
        return this.U;
    }

    public LiveData<Integer> c2() {
        return this.W;
    }

    public LiveData<List<IGProUserInfo>> d2() {
        return this.M;
    }

    public MutableLiveData<IGProUserInfo> e2() {
        return this.P;
    }

    public String f2(int i3, String str) {
        switch (i3) {
            case 35008:
                return "\u8be5\u7528\u6237\u5f53\u524d\u8d26\u53f7\u5f02\u5e38\uff0c\u65e0\u6cd5\u8f6c\u8ba9\u3002";
            case 35009:
                return "\u8be5\u7528\u6237\u672a\u6ee1\u8db3\u6210\u5458QQ\u597d\u53cb7\u5929\u7684\u6761\u4ef6\uff0c\u65e0\u6cd5\u8f6c\u8ba9\u3002";
            case 35010:
                return "\u8be5\u7528\u6237\u5f53\u524d\u975e\u9891\u9053\u6210\u5458\uff0c\u65e0\u6cd5\u8f6c\u8ba9\u3002";
            default:
                if (TextUtils.isEmpty(str)) {
                    return "\u8f6c\u8ba9\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5";
                }
                return str;
        }
    }

    public LiveData<Boolean> g2() {
        return this.V;
    }

    public IGProGuildInfo getGuildInfo() {
        return this.f234631m;
    }

    public MutableLiveData<IGProUserInfo> h2() {
        return this.Q;
    }

    protected void j2(IGProGuildMemberSearchResult iGProGuildMemberSearchResult) {
        List<IGProUserInfo> arrayList;
        if (iGProGuildMemberSearchResult != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<IGProUserInfo> members = iGProGuildMemberSearchResult.getMembers();
            if (this.f234627a0 != 0 && this.M.getValue() != null) {
                arrayList2.addAll(this.M.getValue());
            }
            if (this.G) {
                String selfTinyId = ((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId();
                Iterator<IGProUserInfo> it = members.iterator();
                while (it.hasNext()) {
                    IGProUserInfo next = it.next();
                    if (next.getRobotType() != 1 && !next.getTinyId().equals(selfTinyId)) {
                        arrayList2.add(next);
                    }
                }
            } else {
                arrayList2.addAll(members);
            }
            this.f234627a0 = iGProGuildMemberSearchResult.getNextPos();
            this.M.setValue(arrayList2);
            if (iGProGuildMemberSearchResult.getNextPos() != 0 && !iGProGuildMemberSearchResult.getMembers().isEmpty()) {
                this.W.setValue(4);
                return;
            } else {
                this.W.setValue(5);
                return;
            }
        }
        if (this.f234627a0 != 0 && this.M.getValue() != null) {
            arrayList = this.M.getValue();
        } else {
            arrayList = new ArrayList<>();
        }
        this.M.setValue(arrayList);
        if (arrayList.size() > 0) {
            this.W.setValue(4);
        } else {
            this.W.setValue(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k2(IGProUserInfo iGProUserInfo) {
        if (iGProUserInfo != null && this.f234631m != null && this.C) {
            boolean z16 = false;
            if (QLog.isColorLevel()) {
                QLog.d("Guild.userl.QQGuildMemberListViewModel", 2, "onSetOrUnsetAdminClick userInfo:", iGProUserInfo);
            }
            if (iGProUserInfo.getUserType() != 1) {
                z16 = true;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (z16) {
                arrayList.add("2");
            } else {
                arrayList2.add("2");
            }
            ((IGPSService) this.Y.getRuntimeService(IGPSService.class, "")).setMemberRoles(this.f234631m.getGuildID(), iGProUserInfo.getTinyId(), "", "", arrayList, arrayList2, new c(z16, iGProUserInfo));
        }
    }

    public void l2(AppInterface appInterface, IGProGuildInfo iGProGuildInfo, String str) {
        this.Y = appInterface;
        ((wy1.a) this.mRepository).m(appInterface);
        this.f234631m = iGProGuildInfo;
        this.C = ch.v0(iGProGuildInfo);
        this.D = ch.t0(this.f234631m);
        this.F = n2();
        this.E = str;
        ((IGPSService) this.Y.getRuntimeService(IGPSService.class, "")).addObserver(this.f234629c0);
        this.T.postValue(Boolean.valueOf(q.f451648a.d(this.f234631m)));
    }

    public void m2(QBaseActivity qBaseActivity) {
        IGProGuildInfo iGProGuildInfo = this.f234631m;
        if (iGProGuildInfo == null) {
            QLog.e("Guild.userl.QQGuildMemberListViewModel", 1, "inviteFriends failed while guildInfo is null ");
        } else {
            yz1.d.l(qBaseActivity, az.d(iGProGuildInfo.getGuildID(), 0L));
        }
    }

    public boolean o2() {
        if (this.J.getValue() != null && this.J.getValue().booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean p2() {
        return this.C;
    }

    public boolean q2() {
        if (!this.C && !this.D) {
            return false;
        }
        return true;
    }

    public void s2() {
        S1();
    }

    public void t2(QBaseActivity qBaseActivity, String str, boolean z16, GuildProfileCard.e eVar) {
        this.U.setValue(new GuildMemberListFragment.PendingAction(str, z16));
        if (z16) {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openRobotProfileCard(qBaseActivity, this.f234631m.getGuildID(), this.E, str, "", "1", false);
            return;
        }
        GuildProfileData guildProfileData = new GuildProfileData(this.f234631m.getGuildID(), "", str, 0, 1);
        guildProfileData.getGuildBaseProfileData().r(this.E);
        GuildProfileCard.Mh(qBaseActivity, guildProfileData, eVar);
    }

    @MainThread
    public void u2(boolean z16) {
        this.J.setValue(Boolean.valueOf(z16));
    }

    public void v2(boolean z16) {
        this.G = z16;
    }

    @MainThread
    public void w2(boolean z16) {
        this.N.setValue(Boolean.valueOf(z16));
    }

    public void x2(Context context, String str) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, "\u8f6c\u8ba9\u5931\u8d25", str, (String) null, "\u6211\u77e5\u9053\u4e86", new f(), (DialogInterface.OnClickListener) null);
        createCustomDialog.setCanceledOnTouchOutside(true);
        createCustomDialog.show();
    }

    public void y2(String str) {
        if (getGuildInfo() == null) {
            ch.s1(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(R.string.f1501914b));
            return;
        }
        this.W.setValue(1);
        this.Z = str;
        this.f234627a0 = 0L;
        S1();
    }

    public void z2(Context context, IGProUserInfo iGProUserInfo) {
        ex exVar = new ex();
        exVar.c(StringUtils.toLong(getGuildInfo().getGuildID()));
        exVar.d(StringUtils.toLong(iGProUserInfo.getTinyId()));
        ((IGPSService) this.Y.getRuntimeService(IGPSService.class, "")).transferGuildOwner(exVar, new e(context));
    }
}
