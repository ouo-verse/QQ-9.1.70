package com.tencent.mobileqq.guild.client.connect;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.mvvm.c;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.di;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vh2.bi;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends c<wy1.a> {
    static ViewModelProvider.Factory H = new C7692b();
    private final MutableLiveData<Boolean> C;
    private final MutableLiveData<Boolean> D;
    private AppInterface E;
    private byte[] F;
    private String G;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<List<GuildClientParams>> f215383i;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<Boolean> f215384m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements bi {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f215385a;

        a(byte[] bArr) {
            this.f215385a = bArr;
        }

        @Override // vh2.bi
        public void onGetClientAccount(int i3, String str, byte[] bArr, boolean z16, ArrayList<di> arrayList) {
            boolean z17 = false;
            if (i3 != 0) {
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(i3);
                objArr[1] = str;
                if (this.f215385a.length == 0) {
                    z17 = true;
                }
                objArr[2] = Boolean.valueOf(z17);
                QLog.e("Guild.client.GuildClientConnectViewModel", 1, String.format("requestClientList network error, errorCode: %d, errorMessage: %s, isRefresh: %b", objArr));
                return;
            }
            QLog.d("Guild.client.GuildClientConnectViewModel", 1, "requestClientList success");
            b.this.F = bArr;
            b.this.f215384m.setValue(Boolean.valueOf(z16));
            List R1 = b.this.R1(arrayList);
            MutableLiveData mutableLiveData = b.this.D;
            if (this.f215385a.length == 0) {
                z17 = true;
            }
            mutableLiveData.setValue(Boolean.valueOf(z17));
            b.this.f215383i.setValue(R1);
            b.this.C.setValue(Boolean.FALSE);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.client.connect.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class C7692b implements ViewModelProvider.Factory {
        C7692b() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new b(new wy1.a());
        }
    }

    public b(wy1.a aVar) {
        super(aVar);
        this.F = new byte[0];
        this.G = "";
        this.f215383i = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.f215384m = mutableLiveData;
        mutableLiveData.setValue(Boolean.FALSE);
        this.C = new MutableLiveData<>();
        this.D = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<GuildClientParams> R1(ArrayList<di> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<di> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new GuildClientParams(it.next()).e0(this.G).e());
        }
        return arrayList2;
    }

    public MutableLiveData<List<GuildClientParams>> S1() {
        return this.f215383i;
    }

    public MutableLiveData<Boolean> T1() {
        return this.f215384m;
    }

    public MutableLiveData<Boolean> U1() {
        return this.C;
    }

    public MutableLiveData<Boolean> W1() {
        return this.D;
    }

    @MainThread
    public void X1(AppInterface appInterface, String str) {
        this.E = appInterface;
        this.G = str;
        a2();
    }

    public void Z1() {
        c2(this.F);
    }

    public void a2() {
        c2(new byte[0]);
    }

    public void b2(String str) {
        ((IGPSService) this.E.getRuntimeService(IGPSService.class, "")).refreshGuildUserProfileInfo(str, ((IGPSService) this.E.getRuntimeService(IGPSService.class, "")).getSelfTinyId());
    }

    public void c2(byte[] bArr) {
        this.C.setValue(Boolean.TRUE);
        ((IGPSService) this.E.getRuntimeService(IGPSService.class, "")).getBindClientService(1, "", bArr, new a(bArr));
    }

    public String getGuildId() {
        return this.G;
    }
}
