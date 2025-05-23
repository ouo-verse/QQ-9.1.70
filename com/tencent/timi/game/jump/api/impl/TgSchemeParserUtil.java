package com.tencent.timi.game.jump.api.impl;

import ag4.i;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.w;
import java.util.HashMap;
import java.util.List;
import trpc.yes.common.GameAuthOuterClass$AgreeGameAuthRsp;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;

/* loaded from: classes26.dex */
public class TgSchemeParserUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class b implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f377204a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ nf4.b f377205b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f377206c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes26.dex */
        public class a implements IResultListener<Boolean> {
            a() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Boolean bool) {
                com.tencent.timi.game.utils.l.h("TgSchemeParserUtil", 1, "checkSmobaGameOpenIdEqual ensureGameAuthStatus - " + bool);
                b bVar = b.this;
                TgSchemeParserUtil.i(true, bVar.f377204a, bVar.f377205b);
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
                String str2;
                com.tencent.timi.game.utils.l.c("TgSchemeParserUtil", 1, "checkSmobaGameOpenIdEqual ensureGameAuthStatus - " + i3 + " - " + str);
                if (i3 != -12301) {
                    if (TextUtils.isEmpty(str)) {
                        str2 = "\u6388\u6743\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                    } else {
                        str2 = str;
                    }
                    com.tencent.timi.game.ui.widget.f.c(str2);
                }
                TgSchemeParserUtil.g(b.this.f377205b, i3, str);
            }
        }

        b(String str, nf4.b bVar, boolean z16) {
            this.f377204a = str;
            this.f377205b = bVar;
            this.f377206c = z16;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(IUserInfo iUserInfo) {
            String str;
            if (iUserInfo != null && iUserInfo.l() != null) {
                str = iUserInfo.l().smoba_openid.get();
            } else {
                str = "";
            }
            com.tencent.timi.game.utils.l.h("TgSchemeParserUtil", 1, "checkSmobaGameOpenIdEqual getUserInfoFromDBOrNet - " + str);
            if (this.f377204a.equals(str)) {
                TgSchemeParserUtil.h(this.f377205b);
            } else if (!TextUtils.isEmpty(str) || this.f377206c) {
                TgSchemeParserUtil.n();
                TgSchemeParserUtil.g(this.f377205b, -123401, "openid not equal");
            } else {
                TgSchemeParserUtil.k(101, new a());
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            com.tencent.timi.game.utils.l.c("TgSchemeParserUtil", 1, "checkSmobaGameOpenIdEqual getUserInfoFromDBOrNet - onError: " + i3 + " - " + str);
            TgSchemeParserUtil.h(this.f377205b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f377212d;

        e(QBaseActivity qBaseActivity) {
            this.f377212d = qBaseActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            try {
                this.f377212d.startActivity(new Intent(this.f377212d, Class.forName("com.tencent.mobileqq.activity.AccountManageActivity")));
            } catch (Exception e16) {
                com.tencent.timi.game.utils.l.d("TgSchemeParserUtil", 1, "checkSmobaGameOpenIdEqual jump - launch exception", e16);
                com.tencent.timi.game.ui.widget.f.c("\u8bf7\u9000\u51faQQ\u91cd\u65b0\u767b\u5f55");
            }
        }
    }

    public static void f(Context context, String str, final nf4.a<Boolean> aVar) {
        com.tencent.timi.game.utils.l.h("TgSchemeParserUtil" + str, 1, "bringAppToFront, curTopActivity = " + vf4.a.b());
        Intent l3 = l(context, context.getPackageName());
        if (l3 != null) {
            context.startActivity(l3);
            w.c(new Runnable() { // from class: com.tencent.timi.game.jump.api.impl.TgSchemeParserUtil.6
                @Override // java.lang.Runnable
                public void run() {
                    nf4.a aVar2 = nf4.a.this;
                    if (aVar2 != null) {
                        aVar2.onSuccess(Boolean.TRUE);
                    }
                }
            });
        } else if (aVar != null) {
            aVar.onSuccess(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(nf4.b bVar, int i3, String str) {
        if (bVar != null) {
            bVar.onFailed(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(nf4.b bVar) {
        if (bVar != null) {
            bVar.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(boolean z16, String str, nf4.b bVar) {
        com.tencent.timi.game.utils.l.h("TgSchemeParserUtil", 1, "checkSmobaGameOpenIdEqual- " + str);
        if (TextUtils.isEmpty(str)) {
            h(bVar);
        } else {
            ((bo4.d) mm4.b.b(bo4.d.class)).I3(((ll4.a) mm4.b.b(ll4.a.class)).E(), new b(str, bVar, z16));
        }
    }

    public static int j(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Exception e16) {
                com.tencent.timi.game.utils.l.d("TgSchemeParserUtil", 1, "convertStringToInt error - " + str, e16);
                return i3;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(int i3, IResultListener<Boolean> iResultListener) {
        com.tencent.timi.game.utils.l.h("TgSchemeParserUtil", 1, "ensureGameAuthStatus " + i3);
        ((ag4.i) mm4.b.b(ag4.i.class)).J2(i3, new c(i3, iResultListener));
    }

    public static Intent l(Context context, String str) {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.setPackage(str);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(context.getPackageManager(), intent, 0);
        if (queryIntentActivities.size() <= 0) {
            return null;
        }
        String str2 = queryIntentActivities.get(0).activityInfo.applicationInfo.packageName;
        String str3 = queryIntentActivities.get(0).activityInfo.name;
        Intent intent2 = new Intent("android.intent.action.MAIN");
        intent2.setComponent(new ComponentName(str2, str3));
        intent2.addCategory("android.intent.category.LAUNCHER");
        intent2.addFlags(270532608);
        return intent2;
    }

    public static void m(Context context, HashMap<String, String> hashMap, String str, nf4.a<Boolean> aVar) {
        f(context, str, new a(hashMap, str, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        QBaseActivity b16 = vf4.a.b();
        com.tencent.timi.game.utils.l.c("TgSchemeParserUtil", 1, "checkSmobaGameOpenIdEqual showAccountNotEqualDialog - " + b16);
        if (b16 != null && !b16.isFinishing()) {
            new e.a(b16).j("\u5f53\u524d\u767b\u5f55\u6e38\u620f\u7684QQ\u8d26\u53f7\u4e0e\u5f00\u64adQQ\u8d26\u53f7\u4e0d\u4e00\u81f4\uff0c\u8bf7\u9000\u51faQQ\u91cd\u65b0\u767b\u5f55\u3002").p("\u5207\u6362\u8d26\u53f7").o(new e(b16)).n("\u5173\u95ed").m(new d()).c().show();
        } else {
            com.tencent.timi.game.ui.widget.f.c("\u5f53\u524d\u767b\u5f55\u6e38\u620fQQ\u8d26\u53f7\u4e0e\u5f00\u64adQQ\u8d26\u53f7\u4e0d\u4e00\u81f4\uff0c\u8bf7\u9000\u51faQQ\u91cd\u65b0\u767b\u5f55");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class c implements i.b<GameAuthOuterClass$GetGameAuthRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f377208a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IResultListener f377209b;

        c(int i3, IResultListener iResultListener) {
            this.f377208a = i3;
            this.f377209b = iResultListener;
        }

        @Override // ag4.i.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void i(boolean z16, int i3, String str, GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp) {
            com.tencent.timi.game.utils.l.h("TgSchemeParserUtil", 1, "ensureGameAuthStatus " + this.f377208a + ", requestGameAuthInfoFromDbOrServer - " + z16 + ", " + i3 + ", " + str);
            if (z16) {
                if (gameAuthOuterClass$GetGameAuthRsp.is_auth.get()) {
                    IResultListener iResultListener = this.f377209b;
                    if (iResultListener != null) {
                        iResultListener.onSuccess(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                QBaseActivity b16 = vf4.a.b();
                com.tencent.timi.game.utils.l.h("TgSchemeParserUtil", 1, "ensureGameAuthStatus " + this.f377208a + ", showAuthHintDialog - " + b16);
                if (b16 != null && !b16.isFinishing()) {
                    ((ag4.i) mm4.b.b(ag4.i.class)).o3(this.f377208a, b16, gameAuthOuterClass$GetGameAuthRsp.auth_desc.get(), Boolean.TRUE, new a(), new b());
                    return;
                }
                IResultListener iResultListener2 = this.f377209b;
                if (iResultListener2 != null) {
                    iResultListener2.onError(-12302, "Activity\u4e3a\u7a7a");
                    return;
                }
                return;
            }
            IResultListener iResultListener3 = this.f377209b;
            if (iResultListener3 != null) {
                iResultListener3.onError(i3, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes26.dex */
        public class a implements i.a {
            a() {
            }

            @Override // ag4.i.a
            public void d(int i3, String str) {
                com.tencent.timi.game.utils.l.c("TgSchemeParserUtil", 1, "ensureGameAuthStatus " + c.this.f377208a + ", authFailed - " + i3 + ", " + str);
                IResultListener iResultListener = c.this.f377209b;
                if (iResultListener != null) {
                    iResultListener.onError(i3, "\u6388\u6743\u5931\u8d25, " + str);
                }
            }

            @Override // ag4.i.a
            public void f() {
                com.tencent.timi.game.utils.l.c("TgSchemeParserUtil", 1, "ensureGameAuthStatus " + c.this.f377208a + ", authCancel - ");
                IResultListener iResultListener = c.this.f377209b;
                if (iResultListener != null) {
                    iResultListener.onError(-12301, "\u6388\u6743\u53d6\u6d88");
                }
            }

            @Override // ag4.i.a
            public void g(GameAuthOuterClass$AgreeGameAuthRsp gameAuthOuterClass$AgreeGameAuthRsp) {
                com.tencent.timi.game.utils.l.h("TgSchemeParserUtil", 1, "ensureGameAuthStatus " + c.this.f377208a + ", authSucceed - ");
            }

            @Override // ag4.i.c
            public void c() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes26.dex */
        public class b implements i.d {
            b() {
            }

            @Override // ag4.i.d
            public void a(YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp) {
                com.tencent.timi.game.utils.l.h("TgSchemeParserUtil", 1, "ensureGameAuthStatus " + c.this.f377208a + ", SelectGameAccountCallback - selectSucceed");
                IResultListener iResultListener = c.this.f377209b;
                if (iResultListener != null) {
                    iResultListener.onSuccess(Boolean.TRUE);
                }
            }

            @Override // ag4.i.d
            public void b() {
                com.tencent.timi.game.utils.l.c("TgSchemeParserUtil", 1, "ensureGameAuthStatus " + c.this.f377208a + ", SelectGameAccountCallback - selectCancel");
                IResultListener iResultListener = c.this.f377209b;
                if (iResultListener != null) {
                    iResultListener.onSuccess(Boolean.TRUE);
                }
            }

            @Override // ag4.i.d
            public void e(int i3, String str) {
                com.tencent.timi.game.utils.l.c("TgSchemeParserUtil", 1, "ensureGameAuthStatus " + c.this.f377208a + ", SelectGameAccountCallback - selectFailed, " + i3 + ", " + str);
                IResultListener iResultListener = c.this.f377209b;
                if (iResultListener != null) {
                    iResultListener.onSuccess(Boolean.TRUE);
                }
            }

            @Override // ag4.i.c
            public void c() {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class a implements nf4.a<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f377198a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f377199b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ nf4.a f377200c;

        a(HashMap hashMap, String str, nf4.a aVar) {
            this.f377198a = hashMap;
            this.f377199b = str;
            this.f377200c = aVar;
        }

        @Override // nf4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Boolean bool) {
            String str = (String) this.f377198a.get("game_openid");
            com.tencent.timi.game.utils.l.h("TgSchemeParserUtil" + this.f377199b, 1, "bringAppToFront, onSuccess, gameOpenId = " + str);
            ((hi4.b) mm4.b.b(hi4.b.class)).d3(new C9928a(str));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.tencent.timi.game.jump.api.impl.TgSchemeParserUtil$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public class C9928a implements hi4.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f377201a;

            C9928a(String str) {
                this.f377201a = str;
            }

            @Override // hi4.a
            public void a(boolean z16) {
                com.tencent.timi.game.utils.l.h("TgSchemeParserUtil" + a.this.f377199b, 1, "handleAction- onInitFinish - " + z16);
                TgSchemeParserUtil.i(false, this.f377201a, new C9929a());
            }

            /* renamed from: com.tencent.timi.game.jump.api.impl.TgSchemeParserUtil$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes26.dex */
            class C9929a implements nf4.b {
                C9929a() {
                }

                @Override // nf4.b
                public void onSuccess() {
                    com.tencent.timi.game.utils.l.h("TgSchemeParserUtil" + a.this.f377199b, 1, "final callback handleAction");
                    nf4.a aVar = a.this.f377200c;
                    if (aVar != null) {
                        aVar.onSuccess(Boolean.TRUE);
                    }
                }

                @Override // nf4.b
                public void onFailed(int i3, @Nullable String str) {
                }
            }
        }

        @Override // nf4.a
        public void onError(int i3, String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
