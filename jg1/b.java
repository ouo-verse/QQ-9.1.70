package jg1;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.client.auth.GuildClientAuthDialogParams;
import com.tencent.mobileqq.guild.client.auth.GuildClientAuthorizationDialogFragment;
import com.tencent.mobileqq.guild.client.manage.GuildClientManageFragment;
import com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectAccountDialogFragment;
import com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectAccountDialogParams;
import com.tencent.mobileqq.guild.util.bx;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.dc;
import com.tencent.mobileqq.qqguildsdk.data.dd;
import com.tencent.mobileqq.qqguildsdk.data.dy;
import com.tencent.mobileqq.qqguildsdk.data.ej;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import vh2.be;
import vh2.bf;
import vh2.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements be {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f409888a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildClientParams f409889b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f409890c;

        a(QBaseActivity qBaseActivity, GuildClientParams guildClientParams, Fragment fragment) {
            this.f409888a = qBaseActivity;
            this.f409889b = guildClientParams;
            this.f409890c = fragment;
        }

        @Override // vh2.be
        public void a(int i3, String str, String str2, int i16, boolean z16, dy dyVar, ej ejVar) {
            if (i3 != 0) {
                QBaseActivity qBaseActivity = this.f409888a;
                ch.r1(qBaseActivity, i3, qBaseActivity.getString(R.string.f142420jb), null);
                QLog.e("Guild.client.GuildClientAuthorizationHelper", 1, String.format("getAppAuthorizationInfo network error, errorCode: %d, errorMessage: %s", Integer.valueOf(i3), str));
                return;
            }
            QLog.i("Guild.client.GuildClientAuthorizationHelper", 1, "getAppAuthorizationInfo success");
            if (!bx.a(str2) && !z16 && dyVar != null) {
                GuildClientAuthorizationDialogFragment.zh(this.f409888a, this.f409890c, new GuildClientAuthDialogParams(this.f409889b).a(dyVar.a()).b(dyVar.b()).c());
            } else if (ejVar != null && !TextUtils.isEmpty(ejVar.getRoleId()) && ejVar.getIsBind()) {
                b.b(this.f409888a, this.f409890c, this.f409889b, true);
            } else {
                b.h(this.f409888a, this.f409890c, this.f409889b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: jg1.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C10587b implements bf {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildClientParams f409891a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f409892b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f409893c;

        C10587b(GuildClientParams guildClientParams, QBaseActivity qBaseActivity, Fragment fragment) {
            this.f409891a = guildClientParams;
            this.f409892b = qBaseActivity;
            this.f409893c = fragment;
        }

        @Override // vh2.bf
        public void a(int i3, String str, String str2, List<ej> list, String str3, String str4, int i16, dd ddVar, ArrayList<dc> arrayList) {
            QLog.i("Guild.client.GuildClientAuthorizationHelper", 1, "requestClientAccountList | result: " + i3 + " | errMsg: " + str + " | resultType: " + i16);
            if (i3 == 0) {
                if (i16 != 2) {
                    b.f(list, str3, str4, this.f409892b, this.f409893c, this.f409891a);
                    return;
                } else {
                    ng1.b.b(ddVar, this.f409891a, arrayList);
                    return;
                }
            }
            QBaseActivity qBaseActivity = this.f409892b;
            ch.r1(qBaseActivity, i3, qBaseActivity.getString(R.string.f142420jb), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f409894a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f409895b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GuildClientParams f409896c;

        c(QBaseActivity qBaseActivity, Fragment fragment, GuildClientParams guildClientParams) {
            this.f409894a = qBaseActivity;
            this.f409895b = fragment;
            this.f409896c = guildClientParams;
        }

        @Override // vh2.d
        public void a(int i3, String str, String str2, String str3, int i16) {
            if (i3 != 0) {
                QBaseActivity qBaseActivity = this.f409894a;
                ch.r1(qBaseActivity, i3, qBaseActivity.getString(R.string.f142420jb), null);
                QLog.e("Guild.client.GuildClientAuthorizationHelper", 1, String.format("requestBindClientAccount network error, errorCode: %d, errorMessage: %s", Integer.valueOf(i3), str));
            } else {
                QLog.i("Guild.client.GuildClientAuthorizationHelper", 1, "requestBindClientAccount success");
                QBaseActivity qBaseActivity2 = this.f409894a;
                ch.u1(qBaseActivity2, qBaseActivity2.getString(R.string.f142430jc));
                b.b(this.f409894a, this.f409895b, this.f409896c, true);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
    
        if (r0 != 6) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(QBaseActivity qBaseActivity, Fragment fragment, GuildClientParams guildClientParams, boolean z16) {
        QLog.i("Guild.client.GuildClientAuthorizationHelper", 1, "handleBindSuccess sceneType: " + guildClientParams.Z());
        int Z = guildClientParams.Z();
        if (Z != 0) {
            if (Z != 1) {
                if (Z != 3) {
                    if (Z != 4) {
                        if (Z == 5) {
                            kg1.a.g(qBaseActivity, guildClientParams.V());
                        }
                    } else {
                        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).sendClientAuthSuccessToArk(guildClientParams.r(), guildClientParams.s());
                    }
                } else {
                    kg1.a.d(qBaseActivity, guildClientParams);
                }
            }
            GuildClientManageFragment.Nh(qBaseActivity, guildClientParams, 2);
        } else {
            i(fragment, guildClientParams);
        }
        if (z16) {
            j();
        }
    }

    public static void c(QBaseActivity qBaseActivity, Fragment fragment, GuildClientParams guildClientParams) {
        QLog.i("Guild.client.GuildClientAuthorizationHelper", 1, "handleClientAuthorization params: " + guildClientParams.toString());
        if (guildClientParams.Z() != 1 && d()) {
            QLog.i("Guild.client.GuildClientAuthorizationHelper", 1, "handleClientAuthorization cacheValid");
            b(qBaseActivity, fragment, guildClientParams, false);
        } else {
            ((IGPSService) qBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).getAppAuthorizationInfo(guildClientParams.z(), 1, new a(qBaseActivity, guildClientParams, fragment));
        }
    }

    private static boolean d() {
        if (e(System.currentTimeMillis() - ch.f235508a) < 5) {
            return true;
        }
        return false;
    }

    private static long e(long j3) {
        return (j3 / 1000) / 60;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(List<ej> list, String str, String str2, QBaseActivity qBaseActivity, Fragment fragment, GuildClientParams guildClientParams) {
        QLog.i("Guild.client.GuildClientAuthorizationHelper", 1, "requestClientAccountList success");
        if (list.isEmpty()) {
            ch.f1(str2);
        } else if (list.size() == 1) {
            g(qBaseActivity, fragment, guildClientParams, list.get(0));
        } else {
            GuildClientSelectAccountDialogFragment.xh(qBaseActivity, fragment, new GuildClientSelectAccountDialogParams(guildClientParams).f(str).b(list).a());
        }
    }

    private static void g(QBaseActivity qBaseActivity, Fragment fragment, GuildClientParams guildClientParams, ej ejVar) {
        ((IGPSService) qBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).bindAppRole(guildClientParams.z(), ejVar.getRoleId(), 1, new c(qBaseActivity, fragment, guildClientParams));
    }

    public static void h(QBaseActivity qBaseActivity, Fragment fragment, GuildClientParams guildClientParams) {
        ((IGPSService) qBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).getAppRoleList(guildClientParams.z(), "", null, new C10587b(guildClientParams, qBaseActivity, fragment));
    }

    private static void i(Fragment fragment, GuildClientParams guildClientParams) {
        Intent intent = new Intent();
        if (fragment != null) {
            fragment.onActivityResult(1, -1, intent);
        }
    }

    public static void j() {
        ch.f235508a = System.currentTimeMillis();
    }
}
