package hg4;

import ag4.i;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.scheme.tools.SchemeUtil;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.utils.l;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameAuthOuterClass$AgreeGameAuthRsp;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameRoleListRsp;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAbsInfo;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f404890a = false;

    /* renamed from: b, reason: collision with root package name */
    private static com.tencent.timi.game.ui.widget.e f404891b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f404892d;

        b(int i3) {
            this.f404892d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ((ag4.i) mm4.b.b(ag4.i.class)).Q2(this.f404892d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements SchemeUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ lf4.a f404893a;

        c(lf4.a aVar) {
            this.f404893a = aVar;
        }

        @Override // com.tencent.timi.game.scheme.tools.SchemeUtil.c
        public void onResult(int i3) {
            lf4.a aVar = this.f404893a;
            if (aVar != null) {
                if (i3 == 2) {
                    aVar.onSuccess();
                    return;
                }
                if (i3 == -1) {
                    aVar.onUserCancel();
                } else if (i3 == -2) {
                    aVar.a();
                } else if (i3 == -3) {
                    aVar.onFailed();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements i.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ag4.d f404894a;

        e(ag4.d dVar) {
            this.f404894a = dVar;
        }

        @Override // ag4.i.c
        public void c() {
            d.s("showAuthHintDialog - onDialogShow");
        }

        @Override // ag4.i.a
        public void d(int i3, @Nullable String str) {
            d.s("showAuthHintDialog - authFailed, " + i3 + " - " + str);
            ag4.d dVar = this.f404894a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u6388\u6743\u5931\u8d25\uff0c");
            sb5.append(str);
            d.e(dVar, sb5.toString());
        }

        @Override // ag4.i.a
        public void f() {
            d.s("showAuthHintDialog - authCancel");
            d.e(this.f404894a, "\u6388\u6743\u53d6\u6d88");
        }

        @Override // ag4.i.a
        public void g(@NotNull GameAuthOuterClass$AgreeGameAuthRsp gameAuthOuterClass$AgreeGameAuthRsp) {
            d.s("showAuthHintDialog - authSucceed");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements i.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ag4.d f404895a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f404896b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f404897c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ag4.e f404898d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f404899e;

        f(ag4.d dVar, int i3, Activity activity, ag4.e eVar, boolean z16) {
            this.f404895a = dVar;
            this.f404896b = i3;
            this.f404897c = activity;
            this.f404898d = eVar;
            this.f404899e = z16;
        }

        @Override // ag4.i.d
        public void a(@NotNull YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp) {
            d.s("showAuthHintDialog - bindSucceed");
            d.h(this.f404896b, this.f404897c, this.f404898d, this.f404899e, this.f404895a);
        }

        @Override // ag4.i.d
        public void b() {
            d.s("showAuthHintDialog - bindCancel");
            d.e(this.f404895a, "\u7ed1\u5b9a\u8d26\u53f7\u53d6\u6d88");
        }

        @Override // ag4.i.c
        public void c() {
            d.s("showAuthHintDialog - onDialogShow");
        }

        @Override // ag4.i.d
        public void e(int i3, @Nullable String str) {
            d.s("showAuthHintDialog - bindFailed, " + i3 + " - " + str);
            ag4.d dVar = this.f404895a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u7ed1\u5b9a\u8d26\u53f7\u5931\u8d25\uff0c");
            sb5.append(str);
            d.e(dVar, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class g implements DialogInterface.OnDismissListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            d.f404891b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class h implements DialogInterface.OnClickListener {
        final /* synthetic */ boolean C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f404900d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f404901e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ag4.d f404902f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f404903h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f404904i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ ag4.e f404905m;

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements i.d {
            a() {
            }

            @Override // ag4.i.d
            public void a(@NotNull YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp) {
                h hVar = h.this;
                if (hVar.f404904i) {
                    d.h(hVar.f404900d, hVar.f404901e, hVar.f404905m, hVar.C, hVar.f404902f);
                }
            }

            @Override // ag4.i.d
            public void b() {
                l.e("SmobaUtil", "checkIsGangupAvaliable - " + h.this.f404902f + ", showChangeAccountTipsDialog#bindCancel");
                h hVar = h.this;
                d.e(hVar.f404902f, hVar.f404903h);
            }

            @Override // ag4.i.c
            public void c() {
                l.i("SmobaUtil", "checkIsGangupAvaliable - onDialogShow");
            }

            @Override // ag4.i.d
            public void e(int i3, @Nullable String str) {
                l.e("SmobaUtil", "checkIsGangupAvaliable - " + h.this.f404902f + ", showChangeAccountTipsDialog#bindFailed - " + i3 + " - " + str);
                h hVar = h.this;
                d.e(hVar.f404902f, hVar.f404903h);
            }
        }

        h(int i3, Activity activity, ag4.d dVar, String str, boolean z16, ag4.e eVar, boolean z17) {
            this.f404900d = i3;
            this.f404901e = activity;
            this.f404902f = dVar;
            this.f404903h = str;
            this.f404904i = z16;
            this.f404905m = eVar;
            this.C = z17;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ((ag4.i) mm4.b.b(ag4.i.class)).J1(this.f404900d, (QBaseActivity) this.f404901e, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class i implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ag4.d f404907d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f404908e;

        i(ag4.d dVar, String str) {
            this.f404907d = dVar;
            this.f404908e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            d.e(this.f404907d, this.f404908e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class k implements DialogInterface.OnClickListener {
        k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            l.i("SmobaUtil", "showSeeOthersDialog-openExpandHall");
            d.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(ag4.d dVar, String str) {
        l.e("SmobaUtil", "checkIsGangupAvaliable - " + dVar + ", onCheckFail = " + str);
        if (dVar != null) {
            dVar.a(str);
        }
    }

    public static boolean f(int i3, List<Integer> list) {
        List<YesGameInfoOuterClass$YesGameRoleAbsInfo> list2;
        LiveData<YesGameInfoOuterClass$GetUserGameRoleListRsp> D2 = ((ag4.i) mm4.b.b(ag4.i.class)).D2(i3);
        if (D2 != null && D2.getValue() != null && D2.getValue().role_list != null && (list2 = D2.getValue().role_list.get()) != null && list2.size() > 0) {
            for (int i16 = 0; i16 < list2.size(); i16++) {
                YesGameInfoOuterClass$YesGameRoleAbsInfo yesGameInfoOuterClass$YesGameRoleAbsInfo = list2.get(i16);
                if (yesGameInfoOuterClass$YesGameRoleAbsInfo != null && ((pm4.a) mm4.b.b(pm4.a.class)).U0(yesGameInfoOuterClass$YesGameRoleAbsInfo.area.get()) && list.contains(Integer.valueOf(((pm4.a) mm4.b.b(pm4.a.class)).u0(yesGameInfoOuterClass$YesGameRoleAbsInfo.disp_grade_level.get())))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean g(int i3, boolean z16) {
        List<YesGameInfoOuterClass$YesGameRoleAbsInfo> list;
        LiveData<YesGameInfoOuterClass$GetUserGameRoleListRsp> D2 = ((ag4.i) mm4.b.b(ag4.i.class)).D2(i3);
        if (D2 != null && D2.getValue() != null && D2.getValue().role_list != null && (list = D2.getValue().role_list.get()) != null && list.size() > 0) {
            for (int i16 = 0; i16 < list.size(); i16++) {
                YesGameInfoOuterClass$YesGameRoleAbsInfo yesGameInfoOuterClass$YesGameRoleAbsInfo = list.get(i16);
                if (yesGameInfoOuterClass$YesGameRoleAbsInfo != null && ((pm4.a) mm4.b.b(pm4.a.class)).U0(yesGameInfoOuterClass$YesGameRoleAbsInfo.area.get()) && (z16 || yesGameInfoOuterClass$YesGameRoleAbsInfo.role_level.get() >= 6)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean h(int i3, Activity activity, @NonNull ag4.e eVar, boolean z16, ag4.d dVar) {
        boolean z17;
        boolean z18;
        String str;
        if (f404890a) {
            j(dVar);
            return true;
        }
        s("checkIsGangupAvaliable - yesGameId_" + i3 + " - " + dVar + ", " + z16 + ", checkFrom = " + eVar.f26060a + ", isCreate = " + eVar.f26061b);
        if (i3 == 101) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!((ag4.h) mm4.b.b(ag4.h.class)).v2(activity, i3, !z16, false, "", "", "", new C10436d())) {
            e(dVar, "\u6e38\u620f\u672a\u5b89\u88c5");
            return false;
        }
        LiveData<GameAuthOuterClass$GetGameAuthRsp> G0 = ((ag4.i) mm4.b.b(ag4.i.class)).G0(i3);
        if (!l(G0)) {
            QBaseActivity b16 = vf4.a.b();
            if (b16 != null && G0 != null && G0.getValue() != null) {
                ((ag4.i) mm4.b.b(ag4.i.class)).o3(i3, b16, G0.getValue().auth_desc.get(), Boolean.TRUE, new e(dVar), new f(dVar, i3, activity, eVar, z16));
            } else {
                r("checkIsGangupAvaliable  error, topActivity = " + b16 + ", smobaAuthInfoLiveData = " + G0);
                com.tencent.timi.game.ui.widget.f.c("\u8bf7\u5148\u7ed1\u5b9a\u4f60\u7684\u9ed8\u8ba4\u6e38\u620f\u8d26\u53f7");
                e(dVar, "\u8bf7\u5148\u7ed1\u5b9a\u4f60\u7684\u9ed8\u8ba4\u6e38\u620f\u8d26\u53f7");
            }
            return false;
        }
        int i16 = eVar.f26060a;
        if (i16 != 2 && i16 != 3) {
            z18 = false;
        } else {
            z18 = true;
        }
        LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> B2 = ((ag4.i) mm4.b.b(ag4.i.class)).B2(i3);
        if (B2 != null && B2.getValue() != null) {
            YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo = B2.getValue().role_info;
            int i17 = yesGameInfoOuterClass$YesGameRoleInfo.area.get();
            int i18 = yesGameInfoOuterClass$YesGameRoleInfo.partition.get();
            int i19 = yesGameInfoOuterClass$YesGameRoleInfo.role_level.get();
            int i26 = yesGameInfoOuterClass$YesGameRoleInfo.yes_platid.get();
            if (i17 > 0 && i18 > 0) {
                if (z17 && !i(i3, activity, eVar, z16, dVar, B2, yesGameInfoOuterClass$YesGameRoleInfo, z18, i17, i18, i19, i26)) {
                    return false;
                }
                j(dVar);
                return true;
            }
            if (!z16) {
                v(i3, activity, "\u8d26\u53f7\u5c1a\u672a\u521b\u5efa\u6e38\u620f\u89d2\u8272", "\u8bf7\u5148\u5230\u6e38\u620f\u4e2d\u521b\u5efa\u6e38\u620f\u89d2\u8272\uff0c\u518d\u56de\u6765\u8bd5\u8bd5\u5427", "\u542f\u52a8\u6e38\u620f");
            }
            e(dVar, "\u8d26\u53f7\u5c1a\u672a\u521b\u5efa\u6e38\u620f\u89d2\u8272");
            return false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u8bf7\u5148\u5173\u8054\u6e38\u620f\u8d26\u53f7\uff0c\u624d\u80fd");
        if (eVar.f26061b) {
            str = "\u521b\u5efa";
        } else {
            str = "\u52a0\u5165";
        }
        sb5.append(str);
        sb5.append("\u8f66\u961f\u5662");
        u(true, i3, activity, "\u5c1a\u672a\u5173\u8054\u6e38\u620f\u89d2\u8272", sb5.toString(), "\u5173\u8054\u8d26\u53f7", eVar, z16, dVar, true);
        return false;
    }

    private static boolean i(int i3, Activity activity, @NonNull ag4.e eVar, boolean z16, ag4.d dVar, LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> liveData, YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo, boolean z17, int i16, int i17, int i18, int i19) {
        boolean z18;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z19;
        List<Integer> list;
        YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo2;
        if (eVar.f26060a == 3) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (((pm4.a) mm4.b.b(pm4.a.class)).U0(i16) && (z18 || i18 >= 6)) {
            int i26 = eVar.f26063d;
            if (i26 != 1 && i26 != 2) {
                z19 = false;
            } else {
                z19 = true;
            }
            if (z19 && (yesGameInfoOuterClass$YesGameRoleInfo2 = liveData.getValue().role_info) != null && yesGameInfoOuterClass$YesGameRoleInfo2.hero_count.has() && yesGameInfoOuterClass$YesGameRoleInfo2.hero_count.get() < 1) {
                if (!z16) {
                    if (z17) {
                        com.tencent.timi.game.ui.widget.f.c("\u6e38\u620f\u8d26\u53f7\u82f1\u96c4\u6570\u4e0d\u6ee11\u4e2a\uff0c\u65e0\u6cd5\u53c2\u4e0e\u6392\u4f4d\u8d5b\uff0c\u8bd5\u8bd5\u5176\u4ed6\u5339\u914d\u8d5b\u7684\u8f66\u961f\u5427");
                    } else {
                        w(activity, "\u82f1\u96c4\u6570\u91cf\u4e0d\u6ee1\u8db3\u6392\u4f4d\u8d5b\u8981\u6c42", "\u6e38\u620f\u8d26\u53f7\u82f1\u96c4\u6570\u4e0d\u6ee11\u4e2a\uff0c\u65e0\u6cd5\u53c2\u4e0e\u6392\u4f4d\u8d5b\uff0c\u8bd5\u8bd5\u5176\u4ed6\u5339\u914d\u8d5b\u7684\u8f66\u961f\u5427", "\u53bb\u770b\u770b");
                    }
                }
                e(dVar, "\u82f1\u96c4\u6570\u91cf\u4e0d\u6ee1\u8db3\u6392\u4f4d\u8d5b\u8981\u6c42");
                return false;
            }
            if (!eVar.f26061b && (list = eVar.f26064e) != null && list.size() > 0) {
                int u06 = ((pm4.a) mm4.b.b(pm4.a.class)).u0(yesGameInfoOuterClass$YesGameRoleInfo.disp_grade_level.get());
                if (u06 > 0 && !eVar.f26064e.contains(Integer.valueOf(u06))) {
                    if (!z16) {
                        if (f(i3, eVar.f26064e)) {
                            u(false, i3, activity, "\u6bb5\u4f4d\u4e0d\u5339\u914d", "\u5f53\u524d\u6e38\u620f\u8d26\u53f7\u6bb5\u4f4d\u4e0d\u7b26\u5408\u8f66\u961f\u8981\u6c42\u5662\uff0c\u8bf7\u5207\u6362\u8d26\u53f7\u540e\u518d\u52a0\u5165\u8f66\u961f\u5427", "\u5207\u6362\u8d26\u53f7", eVar, z16, dVar, true);
                        } else {
                            if (z17) {
                                com.tencent.timi.game.ui.widget.f.c("\u4f60\u7684\u6e38\u620f\u6bb5\u4f4d\u4e0d\u6ee1\u8db3\u8f66\u961f\u9700\u6c42");
                            } else {
                                w(activity, "\u6bb5\u4f4d\u4e0d\u5339\u914d", "\u4f60\u7684\u6e38\u620f\u6bb5\u4f4d\u4e0d\u6ee1\u8db3\u8f66\u961f\u9700\u6c42\u5462\uff0c\u6211\u4eec\u4e3a\u4f60\u63a8\u8350\u4e86\u5176\u4ed6\u8f66\u961f\u5662", "\u53bb\u770b\u770b");
                            }
                            e(dVar, "\u6bb5\u4f4d\u4e0d\u5339\u914d");
                        }
                    }
                    return false;
                }
            }
            return true;
        }
        if (!z16) {
            String str5 = "\u9ed8\u8ba4\u6e38\u620f\u8d26\u53f7\u4e0d\u662f\u5b89\u5353\u533a\u7684";
            if (!g(i3, z18)) {
                if (!z18 && i18 < 6 && ((pm4.a) mm4.b.b(pm4.a.class)).U0(i16)) {
                    s("checkIsGangupAvaliable - level limit");
                    str4 = "\u6e38\u620f\u8d26\u53f7\u4e0d\u6ee16\u7ea7\uff0c\u65e0\u6cd5\u4e00\u8d77\u5f00\u9ed1\u54e6\u3002\u5148\u53bb\u6e38\u620f\u4e2d\u63d0\u5347\u7b49\u7ea7\uff0c\u7a0d\u7b49\u4e00\u4f1a\u513f\u5c31\u751f\u6548\u4e86\u3002";
                    str5 = "\u6e38\u620f\u8d26\u53f7\u7b49\u7ea7\u4e0d\u8db36\u7ea7";
                } else if (!((pm4.a) mm4.b.b(pm4.a.class)).U0(i16)) {
                    s("checkIsGangupAvaliable - not android");
                    str4 = "\u4f60\u6ca1\u6709\u7b26\u5408\u6761\u4ef6\u7684\u5b89\u5353\u533a\u6e38\u620f\u8d26\u53f7\uff0c\u8bf7\u5148\u5230\u6e38\u620f\u4e2d\u521b\u5efa\u5427";
                } else {
                    str5 = "\u65e0\u6cd5\u6210\u529f\u64cd\u4f5c\uff0c\u539f\u56e0\u662f\uff1a";
                    str4 = "(1) \u4f60\u5f53\u524d\u6e38\u620f\u8d26\u53f7\u662f\u82f9\u679c\u533a\n(2) \u4f60\u5f53\u524d\u6e38\u620f\u8d26\u53f7\u4e0d\u6ee16\u7ea7";
                }
                v(i3, activity, str5, str4, "\u542f\u52a8\u6e38\u620f");
                e(dVar, str5);
                return false;
            }
            if (z18) {
                s("checkIsGangupAvaliable - onekeylive do not need switch account!");
                return true;
            }
            if (!((pm4.a) mm4.b.b(pm4.a.class)).U0(i16)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u8bf7\u5207\u6362\u4e3a\u5b89\u5353\u7cfb\u7edf\u7684\u6e38\u620f\u8d26\u53f7\uff0c\u624d\u80fd");
                if (eVar.f26061b) {
                    str3 = "\u521b\u5efa";
                } else {
                    str3 = "\u52a0\u5165";
                }
                sb5.append(str3);
                sb5.append("\u8f66\u961f\u5662");
                String sb6 = sb5.toString();
                s("checkIsGangupAvaliable - wrong gamePlatform");
                str = sb6;
                str2 = "\u9ed8\u8ba4\u6e38\u620f\u8d26\u53f7\u4e0d\u662f\u5b89\u5353\u533a\u7684";
            } else {
                s("checkIsGangupAvaliable - level too low");
                str = "\u9ed8\u8ba4\u7684\u6e38\u620f\u8d26\u53f7\u4e0d\u6ee16\u7ea7\uff0c\u65e0\u6cd5\u4e00\u8d77\u5f00\u9ed1\u54e6\u3002\u8bf7\u5148\u5207\u6362\u6e38\u620f\u8d26\u53f7\u518d\u4e00\u8d77\u5f00\u9ed1\u5427";
                str2 = "\u6e38\u620f\u8d26\u53f7\u7b49\u7ea7\u4e0d\u8db36\u7ea7";
            }
            u(false, i3, activity, str2, str, "\u5207\u6362\u8d26\u53f7", eVar, z16, dVar, true);
        }
        return false;
    }

    private static void j(ag4.d dVar) {
        l.i("SmobaUtil", "checkIsGangupAvaliable - " + dVar + ", onSuccess");
        if (dVar != null) {
            dVar.onSuccess();
        }
    }

    private static void k() {
        com.tencent.timi.game.ui.widget.e eVar = f404891b;
        if (eVar != null && eVar.isShowing()) {
            f404891b.dismiss();
            f404891b = null;
        }
    }

    private static boolean l(LiveData<GameAuthOuterClass$GetGameAuthRsp> liveData) {
        if (liveData != null && liveData.getValue() != null && liveData.getValue().is_auth.get()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
        Context b16 = vf4.a.b();
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        l.i("SmobaUtil", "jumpToTeamList-openExpandHall topActivity - " + b16 + ", curHall = " + I0);
        if (I0 != null) {
            I0.Kc();
            return;
        }
        ExpandHallLaunchParam expandHallLaunchParam = new ExpandHallLaunchParam();
        expandHallLaunchParam.G = true;
        gh4.f fVar = (gh4.f) mm4.b.b(gh4.f.class);
        if (b16 == null) {
            b16 = eh4.a.b();
        }
        fVar.openExpandHall(b16, expandHallLaunchParam);
    }

    public static boolean n(int i3) {
        return o(i3, vf4.a.b());
    }

    public static boolean o(int i3, Activity activity) {
        return p(i3, activity, null);
    }

    public static boolean p(int i3, Activity activity, lf4.a aVar) {
        String c16 = om4.a.c();
        if (!((ag4.h) mm4.b.b(ag4.h.class)).v2(activity, i3, true, false, "", "", "", null)) {
            if (aVar != null) {
                aVar.b();
                return false;
            }
            return false;
        }
        String str = ((ag4.h) mm4.b.b(ag4.h.class)).l1(i3).game_adr_scheme.get();
        if (!TextUtils.isEmpty(str)) {
            c16 = str;
        }
        boolean c17 = nm4.a.c(c16 + "?launchtype=cymini", activity, new c(aVar));
        t(i3);
        return c17;
    }

    public static boolean q(int i3, String str, Activity activity) {
        if (!((ag4.h) mm4.b.b(ag4.h.class)).v2(activity, i3, true, false, "", "", "", null)) {
            return false;
        }
        return nm4.a.a(str);
    }

    private static void r(String str) {
        l.c("SmobaUtil", 1, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(String str) {
        l.h("SmobaUtil", 1, str);
    }

    private static void t(int i3) {
        l.h("TgGameUtil", 1, "reportGameLaunch - " + i3);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("yes_game_id", String.valueOf(i3));
        YoloRoomOuterClass$YoloRoomInfo j06 = ((fm4.g) mm4.b.b(fm4.g.class)).j0(5);
        if (j06 != null) {
            concurrentHashMap.put("yes_ref_room_id", String.valueOf(j06.room_id.get()));
            concurrentHashMap.put("yes_ref_room_type", String.valueOf(5));
            YoloRoomUtil.t(concurrentHashMap, ((fm4.g) mm4.b.b(fm4.g.class)).K0(j06.room_id.get()).G());
        }
        ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("ev_yes_game_launch_success", concurrentHashMap);
    }

    public static void u(boolean z16, int i3, Activity activity, String str, String str2, String str3, @NonNull ag4.e eVar, boolean z17, ag4.d dVar, boolean z18) {
        k();
        h hVar = new h(i3, activity, dVar, str, z18, eVar, z17);
        if (z16) {
            hVar.onClick(null, 0);
            return;
        }
        com.tencent.timi.game.ui.widget.e c16 = new e.a(activity).q(str).j(str2).p(str3).o(hVar).n("\u665a\u70b9\u518d\u8bf4").m(new i(dVar, str)).f(false).c();
        x(c16);
        c16.show();
    }

    public static void v(int i3, Activity activity, String str, String str2, String str3) {
        k();
        com.tencent.timi.game.ui.widget.e c16 = new e.a(activity).q(str).j(str2).p(str3).o(new b(i3)).n("\u665a\u70b9\u518d\u8bf4").m(new a()).c();
        x(c16);
        c16.show();
    }

    private static void w(Activity activity, String str, String str2, String str3) {
        k();
        com.tencent.timi.game.ui.widget.e c16 = new e.a(activity).q(str).j(str2).p(str3).o(new k()).n("\u665a\u70b9\u518d\u8bf4").m(new j()).c();
        x(c16);
        c16.show();
    }

    private static void x(com.tencent.timi.game.ui.widget.e eVar) {
        f404891b = eVar;
        if (eVar != null) {
            eVar.setOnDismissListener(new g());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: hg4.d$d, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C10436d implements ag4.f {
        C10436d() {
        }

        @Override // ag4.f
        public void a() {
        }

        @Override // ag4.f
        public void b() {
        }

        @Override // ag4.f
        public void onCancelClick() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class j implements DialogInterface.OnClickListener {
        j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
