package jg1;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.client.auth.GuildClientAuthDialogParams;
import com.tencent.mobileqq.guild.profile.profilecard.main.l;
import com.tencent.mobileqq.guild.util.bx;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.dc;
import com.tencent.mobileqq.qqguildsdk.data.dd;
import com.tencent.mobileqq.qqguildsdk.data.ej;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import vh2.bf;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    public static ViewModelProvider.Factory F = new d();
    private final cn<l> C;
    private AppInterface D;
    private GuildClientAuthDialogParams E;

    /* renamed from: i, reason: collision with root package name */
    private final cn<Object[]> f409883i;

    /* renamed from: m, reason: collision with root package name */
    private final cn<Object[]> f409884m;

    /* compiled from: P */
    /* renamed from: jg1.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class C10586a implements vh2.a {
        C10586a() {
        }

        @Override // vh2.a
        public void a(int i3, String str, String str2) {
            if (i3 != 0) {
                a.this.C.postValue(l.e(i3, str));
                QLog.e("Guild.client.GuildClientAuthorizationViewModel", 1, String.format("appAuthorization network error, errorCode: %d, errorMessage: %s", Integer.valueOf(i3), str));
            } else {
                QLog.i("Guild.client.GuildClientAuthorizationViewModel", 1, "requestClientAuthorization success\uff1a");
                bx.n(str2);
                a.this.a2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements bf {
        b() {
        }

        @Override // vh2.bf
        public void a(int i3, String str, String str2, List<ej> list, String str3, String str4, int i16, dd ddVar, ArrayList<dc> arrayList) {
            QLog.i("Guild.client.GuildClientAuthorizationViewModel", 1, "requestClientAccountList | result: " + i3 + " | errMsg: " + str + " | resultType: " + i16);
            if (i3 == 0) {
                if (i16 != 2) {
                    a.this.X1(list, str3, str4);
                    return;
                } else {
                    a.this.f409884m.postValue(new Object[]{ddVar, a.this.E.g(), arrayList});
                    return;
                }
            }
            a.this.C.postValue(l.e(i3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements vh2.d {
        c() {
        }

        @Override // vh2.d
        public void a(int i3, String str, String str2, String str3, int i16) {
            if (i3 != 0) {
                a.this.C.postValue(l.e(i3, str));
                QLog.e("Guild.client.GuildClientAuthorizationViewModel", 1, String.format("bindAppRole network error, errorCode: %d, errorMessage: %s", Integer.valueOf(i3), str));
            } else {
                QLog.i("Guild.client.GuildClientAuthorizationViewModel", 1, "requestBindClientRole success\uff1a");
                a.this.C.postValue(l.e(0, ""));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements ViewModelProvider.Factory {
        d() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new a(new wy1.a());
        }
    }

    public a(wy1.a aVar) {
        super(aVar);
        this.f409884m = new cn<>();
        this.f409883i = new cn<>();
        this.C = new cn<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X1(List<ej> list, String str, String str2) {
        QLog.d("Guild.client.GuildClientAuthorizationViewModel", 1, "requestClientRoleList success\uff1a");
        if (list.isEmpty()) {
            if (!TextUtils.isEmpty(str2)) {
                this.C.postValue(l.e(-952354, str2));
            }
        } else if (list.size() == 1) {
            Z1(list.get(0));
        } else {
            this.f409883i.postValue(new Object[]{str, list});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a2() {
        ((IGPSService) this.D.getRuntimeService(IGPSService.class, "")).getAppRoleList(R1(), "", null, new b());
    }

    public int Q1() {
        return this.E.g().Z();
    }

    public String R1() {
        return this.E.g().z();
    }

    public GuildClientAuthDialogParams S1() {
        return this.E;
    }

    public cn<Object[]> T1() {
        return this.f409883i;
    }

    public cn<Object[]> U1() {
        return this.f409884m;
    }

    @MainThread
    public void W1(AppInterface appInterface, GuildClientAuthDialogParams guildClientAuthDialogParams) {
        this.D = appInterface;
        this.E = guildClientAuthDialogParams;
    }

    public void Z1(ej ejVar) {
        ((IGPSService) this.D.getRuntimeService(IGPSService.class, "")).bindAppRole(R1(), ejVar.getRoleId(), 1, new c());
    }

    public void b2() {
        ((IGPSService) this.D.getRuntimeService(IGPSService.class, "")).appAuthorization(R1(), new C10586a());
    }

    public String getGuildId() {
        return this.E.g().G();
    }

    public cn<l> getToastLiveEvent() {
        return this.C;
    }
}
