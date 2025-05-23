package com.tencent.timi.game.component.gamecore.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.timi.game.component.gamecore.impl.config.GameConfigInfoEntity;
import com.tencent.timi.game.component.gamecore.impl.config.GameConfigManager;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.scheme.tools.SchemeUtil;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements ag4.h {

    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.component.gamecore.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class DialogInterfaceOnClickListenerC9925a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ag4.f f376732d;

        DialogInterfaceOnClickListenerC9925a(ag4.f fVar) {
            this.f376732d = fVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ag4.f fVar = this.f376732d;
            if (fVar != null) {
                fVar.onCancelClick();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ag4.f f376734d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f376735e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f376736f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f376737h;

        b(ag4.f fVar, Activity activity, String str, String str2) {
            this.f376734d = fVar;
            this.f376735e = activity;
            this.f376736f = str;
            this.f376737h = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ag4.f fVar = this.f376734d;
            if (fVar != null) {
                fVar.a();
            }
            if (!SchemeUtil.a(this.f376735e, this.f376736f)) {
                l.e("GameConfigServiceImpl", "isGameInstalled  gotoSysBrowser error");
                com.tencent.timi.game.ui.widget.f.c("\u8bf7\u524d\u5f80\u624b\u673a\u5e94\u7528\u5546\u5e97\u4e0b\u8f7d " + this.f376737h);
            }
        }
    }

    private static String N3(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str;
    }

    private static void Q3(com.tencent.timi.game.ui.widget.e eVar, int i3) {
        String str;
        YoloRoomOuterClass$YoloRoomInfo j06 = ((fm4.g) mm4.b.b(fm4.g.class)).j0(5);
        if (j06 != null) {
            ConcurrentHashMap<String, String> L = YoloRoomUtil.L(j06);
            boolean D = ((fm4.g) mm4.b.b(fm4.g.class)).K0(j06.room_id.get()).D();
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I0 != null) {
                I0.m0().b(eVar);
            } else {
                ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
                if (D) {
                    str = "pg_sgrp_smoba_cpdd";
                } else {
                    str = "pg_kl_smoba_cpdd";
                }
                bVar.G2(eVar, str);
            }
            if (D) {
                ((ug4.b) mm4.b.b(ug4.b.class)).a(eVar.getPositiveButton(), false, "", "em_yes_download_win_confirm", L);
                ((ug4.b) mm4.b.b(ug4.b.class)).a(eVar.getNegativeButton(), false, "", "em_yes_download_win_cancel", L);
            } else {
                ((ug4.b) mm4.b.b(ug4.b.class)).a(eVar.getPositiveButton(), false, "", "em_yes_download_win_confirm", L);
                ((ug4.b) mm4.b.b(ug4.b.class)).a(eVar.getNegativeButton(), false, "", "em_yes_download_win_cancel", L);
            }
        }
    }

    @Override // ag4.h
    public List<Integer> C1() {
        return new ArrayList(GameConfigManager.j().h().values());
    }

    @Override // ag4.h
    public boolean D(int i3) {
        return P3(o1(i3));
    }

    @Override // ag4.h
    public int J(int i3) {
        Integer num = GameConfigManager.j().h().get(Integer.valueOf(i3));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // ag4.h
    public void N1(int i3, YesGameInfoOuterClass$GameConfigInfo yesGameInfoOuterClass$GameConfigInfo) {
        GameConfigManager.j().n(i3, yesGameInfoOuterClass$GameConfigInfo);
    }

    public String O3(YesGameInfoOuterClass$GameConfigInfo yesGameInfoOuterClass$GameConfigInfo) {
        if (yesGameInfoOuterClass$GameConfigInfo != null) {
            return yesGameInfoOuterClass$GameConfigInfo.game_name.get();
        }
        return "";
    }

    public boolean P3(int i3) {
        return GameConfigManager.j().h().containsKey(Integer.valueOf(i3));
    }

    @Override // ag4.h
    public String X0(int i3) {
        return O3(l1(i3));
    }

    @Override // ag4.h
    public void e2() {
        GameConfigManager.j().g();
    }

    @Override // ag4.h
    public HashMap<Integer, Integer> h1() {
        return GameConfigManager.j().h();
    }

    @Override // ag4.h
    public void initRegisterDatabaseModelClass() {
        YesDataBaseHelper.l(new GameConfigInfoEntity(), null);
    }

    @Override // ag4.h
    public void j() {
        GameConfigManager.d();
    }

    @Override // ag4.h
    @NotNull
    public YesGameInfoOuterClass$GameConfigInfo l1(int i3) {
        return GameConfigManager.j().i(i3);
    }

    @Override // ag4.h
    public int o1(int i3) {
        for (Map.Entry<Integer, Integer> entry : GameConfigManager.j().h().entrySet()) {
            if (entry.getValue().intValue() == i3) {
                return entry.getKey().intValue();
            }
        }
        return 0;
    }

    @Override // ag4.h
    public boolean v2(Activity activity, int i3, boolean z16, boolean z17, String str, String str2, String str3, ag4.f fVar) {
        String str4;
        boolean z18;
        String str5;
        YesGameInfoOuterClass$GameConfigInfo l16 = l1(i3);
        String str6 = l16.game_name.get();
        if (TextUtils.isEmpty(str)) {
            str4 = "\u6e38\u620f";
        } else {
            str4 = str;
        }
        String N3 = N3(str6, str4);
        String N32 = N3(l16.game_adr_scheme.get(), str2);
        String N33 = N3(l16.game_download_url.get(), str3);
        if (!TextUtils.isEmpty(N3) && !SchemeUtil.b(N32)) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (z18) {
            return true;
        }
        if (z16) {
            l.i("GameConfigServiceImpl", "isGameInstalled showDialog " + i3 + " - " + N3 + " - " + N33);
            e.a aVar = new e.a(activity);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u672a\u5b89\u88c5");
            sb5.append(N3);
            e.a q16 = aVar.q(sb5.toString());
            if (z17) {
                str5 = "\u68c0\u6d4b\u5230\u4f60\u672a\u4e0b\u8f7d" + N3 + "\uff0c\u65e0\u6cd5\u8fdb\u5165\u6e38\u620f\u5f00\u64ad";
            } else {
                str5 = "\u9700\u8981\u5148\u5b89\u88c5" + N3 + "\uff0c\u624d\u80fd\u4e00\u8d77\u5f00\u9ed1\u54e6";
            }
            com.tencent.timi.game.ui.widget.e c16 = q16.j(str5).p("\u53bb\u4e0b\u8f7d").o(new b(fVar, activity, N33, N3)).n("\u665a\u70b9\u518d\u8bf4").m(new DialogInterfaceOnClickListenerC9925a(fVar)).c();
            Q3(c16, i3);
            c16.show();
            if (fVar != null) {
                fVar.b();
            }
        }
        return false;
    }

    @Override // ag4.h
    public void w1(com.tencent.timi.game.utils.i iVar) {
        GameConfigManager.j().k(iVar);
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}
