package com.tencent.mobileqq.guild.client.selectclient;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetUnbindClientInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vh2.bj;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    static ViewModelProvider.Factory G = new C7698b();
    private final MutableLiveData<Boolean> C;
    private AppInterface D;
    private byte[] E;
    private String F;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<List<c>> f215454i;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<Boolean> f215455m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements bj {
        a() {
        }

        @Override // vh2.bj
        public void onGetClientAccount(int i3, String str, byte[] bArr, boolean z16, ArrayList<GProGetUnbindClientInfo> arrayList) {
            if (i3 != 0) {
                QLog.e("GuildSelectClientListViewModel", 1, String.format("getConnectedClientList network error, errorCode: %d, errorMessage: %s", Integer.valueOf(i3), str));
                return;
            }
            QLog.d("GuildSelectClientListViewModel", 1, "requestClientList success");
            b.this.f215455m.setValue(Boolean.valueOf(z16));
            b.this.E = bArr;
            b.this.f215454i.setValue(b.this.Q1(arrayList));
            b.this.C.setValue(Boolean.FALSE);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.client.selectclient.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class C7698b implements ViewModelProvider.Factory {
        C7698b() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new b(new wy1.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private GuildClientParams f215457a;

        /* renamed from: b, reason: collision with root package name */
        private int f215458b;

        /* renamed from: c, reason: collision with root package name */
        private String f215459c;

        public c(GuildClientParams guildClientParams, int i3, String str) {
            this.f215457a = guildClientParams;
            this.f215458b = i3;
            this.f215459c = str;
        }

        public GuildClientParams a() {
            return this.f215457a;
        }

        public int b() {
            return this.f215458b;
        }

        public String c() {
            return this.f215459c;
        }
    }

    public b(wy1.a aVar) {
        super(aVar);
        this.E = new byte[0];
        this.F = "";
        this.f215454i = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.f215455m = mutableLiveData;
        Boolean bool = Boolean.FALSE;
        mutableLiveData.setValue(bool);
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this.C = mutableLiveData2;
        mutableLiveData2.setValue(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<c> Q1(ArrayList<GProGetUnbindClientInfo> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<GProGetUnbindClientInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            GProGetUnbindClientInfo next = it.next();
            arrayList2.add(new c(new GuildClientParams(next).e0(this.F).l0(1).e(), next.getOpenType(), next.getOpenUrl()));
        }
        return arrayList2;
    }

    public MutableLiveData<List<c>> R1() {
        return this.f215454i;
    }

    public MutableLiveData<Boolean> S1() {
        return this.f215455m;
    }

    public MutableLiveData<Boolean> T1() {
        return this.C;
    }

    public void U1(AppInterface appInterface, String str) {
        this.D = appInterface;
        this.F = str;
        W1();
    }

    public void W1() {
        this.C.setValue(Boolean.TRUE);
        ((IGPSService) this.D.getRuntimeService(IGPSService.class, "")).getUnBindClientServiceV2(this.E, new a());
    }

    public String getGuildId() {
        return this.F;
    }
}
