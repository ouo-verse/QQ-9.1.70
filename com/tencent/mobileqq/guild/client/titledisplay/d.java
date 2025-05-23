package com.tencent.mobileqq.guild.client.titledisplay;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.profile.profilecard.main.l;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.da;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import vh2.bk;
import vh2.cv;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    static ViewModelProvider.Factory J = new c();
    private final cn<l> C;
    private final MutableLiveData<Boolean> D;
    private final MutableLiveData<Boolean> E;
    private AppInterface F;
    private String G;
    private String H;
    private byte[] I;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<List<da>> f215475i;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<da> f215476m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements bk {
        a() {
        }

        @Override // vh2.bk
        public void a(int i3, String str, int i16, List<da> list, boolean z16, byte[] bArr) {
            if (i3 == 0 && list != null) {
                QLog.d("GuildClientTitleDisplaySettingViewModel", 1, "requestClientInfoList success");
                d.this.D.setValue(Boolean.valueOf(z16));
                d.this.I = bArr;
                if (!list.isEmpty()) {
                    List list2 = (List) d.this.f215475i.getValue();
                    list2.addAll(list);
                    d.this.f215475i.setValue(list2);
                    MutableLiveData mutableLiveData = d.this.f215476m;
                    d dVar = d.this;
                    mutableLiveData.setValue(dVar.U1(dVar.H));
                }
                d.this.E.setValue(Boolean.FALSE);
                return;
            }
            d.this.C.setValue(l.e(-952356, str));
            QLog.e("GuildClientTitleDisplaySettingViewModel", 1, String.format("requestClientInfoList network error, errorCode: %d, errorMessage: %s", Integer.valueOf(i3), str));
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements cv {
        b() {
        }

        @Override // vh2.cv
        public void a(int i3, String str, String str2, String str3) {
            if (i3 != 0) {
                d.this.C.setValue(l.e(-952358, str));
                QLog.e("GuildClientTitleDisplaySettingViewModel", 1, String.format("requestClientInfoList network error, errorCode: %d, errorMessage: %s", Integer.valueOf(i3), str));
            } else {
                QLog.d("GuildClientTitleDisplaySettingViewModel", 1, "requestSetGuildClient success");
                d.this.H = str3;
            }
            MutableLiveData mutableLiveData = d.this.f215476m;
            d dVar = d.this;
            mutableLiveData.setValue(dVar.U1(dVar.H));
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements ViewModelProvider.Factory {
        c() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new d(new wy1.a());
        }
    }

    public d(wy1.a aVar) {
        super(aVar);
        this.I = new byte[0];
        MutableLiveData<List<da>> mutableLiveData = new MutableLiveData<>();
        this.f215475i = mutableLiveData;
        mutableLiveData.setValue(new ArrayList());
        this.f215476m = new MutableLiveData<>();
        this.C = new cn<>();
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this.D = mutableLiveData2;
        Boolean bool = Boolean.FALSE;
        mutableLiveData2.setValue(bool);
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this.E = mutableLiveData3;
        mutableLiveData3.setValue(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public da U1(String str) {
        List<da> value = this.f215475i.getValue();
        if (value != null && !value.isEmpty()) {
            for (da daVar : value) {
                if (daVar.getClientId().equals(str)) {
                    return daVar;
                }
            }
        }
        return null;
    }

    public MutableLiveData<List<da>> W1() {
        return this.f215475i;
    }

    public MutableLiveData<Boolean> X1() {
        return this.D;
    }

    public MutableLiveData<Boolean> Z1() {
        return this.E;
    }

    public MutableLiveData<da> a2() {
        return this.f215476m;
    }

    public cn<l> b2() {
        return this.C;
    }

    @MainThread
    public void c2(AppInterface appInterface, String str) {
        this.F = appInterface;
        this.G = str;
        this.H = ((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).getGuildInfo(str).getClientId();
        d2();
    }

    public void d2() {
        this.E.setValue(Boolean.TRUE);
        ((IGPSService) this.F.getRuntimeService(IGPSService.class, "")).getClientInfoList(2, this.I, new a());
    }

    public void e2(String str) {
        ((IGPSService) this.F.getRuntimeService(IGPSService.class, "")).setGuildClientId(this.G, str, new b());
    }

    public String getGuildId() {
        return this.G;
    }
}
