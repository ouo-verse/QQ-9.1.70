package com.tencent.mobileqq.guild.setting.guildmanage.blacklist;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.dr;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlackUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchBlackUserRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.ee;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vh2.cc;
import wh2.am;
import wh2.dz;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildBlacklistViewModel extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    public static ViewModelProvider.Factory L = new b();
    private final MutableLiveData<Boolean> C;
    private final MutableLiveData<List<fz1.b>> D;
    private String E;
    private byte[] F;
    private List<fz1.a> G;
    private List<fz1.b> H;
    private long I;
    private Context J;
    private final oo1.a K;

    /* renamed from: i, reason: collision with root package name */
    private cn<cf1.b> f233707i;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<c> f233708m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes14.dex */
    public @interface State {
        public static final int END = 4;
        public static final int HAS_MORE = 2;
        public static final int IDLE = 0;
        public static final int LOADING = 1;
        public static final int LOAD_EMPTY = 6;
        public static final int LOAD_FAILED = 5;
        public static final int LOAD_MORE = 3;
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends oo1.a {
        a() {
        }

        private void s() {
            GuildBlacklistViewModel.this.m2(1);
            GuildBlacklistViewModel.this.F = new byte[0];
            GuildBlacklistViewModel.this.G.clear();
            GuildBlacklistViewModel.this.q2();
        }

        @Override // oo1.a
        public void m(String str, boolean z16, List<String> list) {
            if (TextUtils.equals(GuildBlacklistViewModel.this.E, str) && z16) {
                s();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // oo1.a
        public void n(String str, List<String> list) {
            if (!TextUtils.equals(GuildBlacklistViewModel.this.E, str)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (fz1.a aVar : GuildBlacklistViewModel.this.G) {
                ArrayList arrayList2 = new ArrayList();
                List<fz1.e> b16 = aVar.b();
                for (fz1.e eVar : b16) {
                    if (list.contains(eVar.c())) {
                        arrayList2.add(eVar);
                    }
                }
                if (arrayList2.size() > 0) {
                    b16.removeAll(arrayList2);
                }
                if (b16.size() == 0) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() > 0) {
                GuildBlacklistViewModel.this.G.removeAll(arrayList);
            }
            c cVar = (c) GuildBlacklistViewModel.this.f233708m.getValue();
            GuildBlacklistViewModel guildBlacklistViewModel = GuildBlacklistViewModel.this;
            List<fz1.b> n26 = guildBlacklistViewModel.n2(guildBlacklistViewModel.G);
            cVar.f233711b = n26;
            if (n26.isEmpty()) {
                cVar.a(6);
            }
            GuildBlacklistViewModel.this.f233708m.setValue(cVar);
        }

        @Override // oo1.a
        public void o(long j3, boolean z16, boolean z17, List<Long> list) {
            if (TextUtils.equals(GuildBlacklistViewModel.this.E, Long.toString(j3)) && z16) {
                s();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements ViewModelProvider.Factory {
        b() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new GuildBlacklistViewModel(new wy1.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public int f233710a = 0;

        /* renamed from: b, reason: collision with root package name */
        public List<fz1.b> f233711b = new ArrayList();

        c() {
        }

        public boolean a(int i3) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.mnr.GuildBlacklistViewModel", 2, "updateState: " + this.f233710a + "\u2014\u2014>" + i3);
            }
            if (this.f233710a != i3) {
                this.f233710a = i3;
                return true;
            }
            return false;
        }

        public String toString() {
            int size;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("BlackListData{state = ");
            sb5.append(this.f233710a);
            sb5.append(", blackList = ");
            List<fz1.b> list = this.f233711b;
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            sb5.append(size);
            sb5.append('}');
            return sb5.toString();
        }
    }

    public GuildBlacklistViewModel(wy1.a aVar) {
        super(aVar);
        this.f233707i = new cn<>();
        this.f233708m = new MutableLiveData<>(new c());
        this.C = new MutableLiveData<>();
        this.D = new MutableLiveData<>();
        this.E = "";
        this.F = new byte[0];
        this.G = new ArrayList();
        this.H = new ArrayList();
        this.K = new a();
    }

    private boolean X1(int i3, String str, List<dr> list, byte[] bArr) {
        QLog.i("Guild.mnr.GuildBlacklistViewModel", 1, c2(i3, str, list, bArr));
        c value = this.f233708m.getValue();
        int i16 = value.f233710a;
        if (i16 != 1 && i16 != 3) {
            return false;
        }
        if (i3 == 0) {
            return true;
        }
        this.f233707i.setValue(new cf1.b(i3, HardCodeUtil.qqStr(R.string.f143210lg)));
        if (value.f233710a == 3) {
            m2(2);
        } else {
            m2(5);
        }
        return false;
    }

    private fz1.a Z1(int i3, List<fz1.a> list) {
        if (list != null && !list.isEmpty()) {
            for (fz1.a aVar : list) {
                if (aVar.a() == i3) {
                    return aVar;
                }
            }
        }
        return null;
    }

    private String c2(int i3, String str, List<dr> list, byte[] bArr) {
        int size;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("currentState: ");
        sb5.append(this.f233708m.getValue().f233710a);
        sb5.append(" result: ");
        sb5.append(i3);
        sb5.append(" errMsg: ");
        sb5.append(str);
        sb5.append(" cookie: ");
        sb5.append(bArr);
        sb5.append(" blackListSize: ");
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        sb5.append(size);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e2, reason: merged with bridge method [inline-methods] */
    public void j2(List<dr> list, byte[] bArr) {
        c value = this.f233708m.getValue();
        if (list != null && !list.isEmpty()) {
            this.F = bArr;
            if (bArr != null && bArr.length != 0) {
                value.a(2);
            } else {
                value.a(4);
            }
            for (dr drVar : list) {
                fz1.a Z1 = Z1(drVar.a(), this.G);
                if (Z1 == null) {
                    fz1.a aVar = new fz1.a(new fz1.c(drVar.a(), drVar.b()), new ArrayList());
                    this.G.add(aVar);
                    Z1 = aVar;
                }
                List<fz1.e> b16 = Z1.b();
                for (dr.a aVar2 : drVar.getMemberList()) {
                    b16.add(new fz1.e(aVar2.c(), aVar2.a(), aVar2.b()));
                }
            }
            value.f233711b = n2(this.G);
            this.f233708m.setValue(value);
            return;
        }
        if (value.f233710a == 1) {
            m2(6);
        } else {
            m2(4);
        }
    }

    private void f2(ArrayList<IGProBlackUserInfo> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<IGProBlackUserInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                IGProBlackUserInfo next = it.next();
                arrayList2.add(new fz1.e(String.valueOf(next.getTinyId()), next.getAvatarUrl(), next.getNickName()));
            }
            this.H.clear();
            this.H.addAll(arrayList2);
            this.D.setValue(arrayList2);
            return;
        }
        QLog.i("Guild.mnr.GuildBlacklistViewModel", 1, "handleSearchResult memberList is empty");
        this.D.setValue(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i2(String str, int i3, String str2) {
        String qqStr;
        if (i3 == 0) {
            qqStr = HardCodeUtil.qqStr(R.string.f152981av);
            p2(str);
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.f152941ar);
        }
        this.f233707i.setValue(new cf1.b(i3, qqStr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(int i3, String str, final ArrayList arrayList, final byte[] bArr) {
        int i16 = this.f233708m.getValue().f233710a;
        if (X1(i3, str, arrayList, bArr)) {
            long nanoTime = (System.nanoTime() / 1000000) - this.I;
            if (nanoTime < 500 && i16 == 1) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildBlacklistViewModel.this.j2(arrayList, bArr);
                    }
                }, 500 - nanoTime);
            } else {
                j2(arrayList, bArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2(int i3, String str, IGProSearchBlackUserRsp iGProSearchBlackUserRsp) {
        if (i3 != 0) {
            QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.f140810ez), 1).show();
            QLog.e("Guild.mnr.GuildBlacklistViewModel", 1, "requestSearchResultList error: " + str);
            return;
        }
        f2(iGProSearchBlackUserRsp.getMemberList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2(int i3) {
        c value = this.f233708m.getValue();
        if (value.a(i3)) {
            this.f233708m.postValue(value);
            if (i3 == 1) {
                this.I = System.nanoTime() / 1000000;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<fz1.b> n2(@NonNull List<fz1.a> list) {
        ArrayList arrayList = new ArrayList();
        for (fz1.a aVar : list) {
            arrayList.add(aVar.c());
            arrayList.addAll(aVar.b());
        }
        return arrayList;
    }

    private void p2(String str) {
        ArrayList arrayList = new ArrayList();
        List<fz1.b> list = this.H;
        if (list != null) {
            for (fz1.b bVar : list) {
                if (bVar.a() == 2 && !str.equals(((fz1.e) bVar).c())) {
                    arrayList.add(bVar);
                }
            }
            this.D.setValue(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2() {
        String obj;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("requestBlackList guildId:");
        sb5.append(this.E);
        sb5.append(" cookie:");
        byte[] bArr = this.F;
        if (bArr == null) {
            obj = null;
        } else {
            obj = bArr.toString();
        }
        sb5.append(obj);
        QLog.i("Guild.mnr.GuildBlacklistViewModel", 1, sb5.toString());
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.f143210lg), 1).show();
        } else {
            ((IGPSService) ch.R0(IGPSService.class)).fetchGuildBlackList(this.E, this.F, new am() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.m
                @Override // wh2.am
                public final void onFetchGuildBlackList(int i3, String str, ArrayList arrayList, byte[] bArr2) {
                    GuildBlacklistViewModel.this.k2(i3, str, arrayList, bArr2);
                }
            });
        }
    }

    public MutableLiveData<c> a2() {
        return this.f233708m;
    }

    public void addObserver() {
        ch.l().addObserver(this.K);
    }

    public LiveData<Boolean> b2() {
        return this.C;
    }

    public LiveData<cf1.b> d2() {
        return this.f233707i;
    }

    @MainThread
    public void g2(Context context, String str) {
        this.J = context;
        this.E = str;
        m2(1);
        q2();
    }

    public LiveData<List<fz1.b>> getSearchResultData() {
        return this.D;
    }

    public boolean h2() {
        if (this.f233708m.getValue().f233710a == 2) {
            return true;
        }
        return false;
    }

    public void loadMore() {
        m2(3);
        q2();
    }

    public void o2(final String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        ((QQGuildHandler) ch.j(QQGuildHandler.class)).X2(this.E, arrayList, new cc() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.o
            @Override // vh2.cc
            public final void onResult(int i3, String str2) {
                GuildBlacklistViewModel.this.i2(str, i3, str2);
            }
        });
    }

    public void r2(String str) {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.f140810ez), 1).show();
            return;
        }
        if (TextUtils.isEmpty(str)) {
            f2(null);
            return;
        }
        ee eeVar = new ee();
        eeVar.j(com.tencent.guild.aio.input.at.utils.g.a(this.E, 0L));
        eeVar.k(str);
        eeVar.l(400);
        eeVar.m(0);
        eeVar.o(0);
        eeVar.n(1);
        ((IGPSService) ch.R0(IGPSService.class)).searchBlackUserFromServer(eeVar, new dz() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.l
            @Override // wh2.dz
            public final void a(int i3, String str2, IGProSearchBlackUserRsp iGProSearchBlackUserRsp) {
                GuildBlacklistViewModel.this.l2(i3, str2, iGProSearchBlackUserRsp);
            }
        });
    }

    public void removeObserver() {
        ch.l().removeObserver(this.K);
    }

    @MainThread
    public void s2(boolean z16) {
        this.C.setValue(Boolean.valueOf(z16));
    }
}
