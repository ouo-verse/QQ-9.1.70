package com.tencent.timi.game.room.impl.tgpa;

import android.text.TextUtils;
import com.tencent.timi.game.room.impl.d;
import com.tencent.timi.game.tgpa.TGPAUtil;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.w;
import eh4.a;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonUserGameData;
import trpc.yes.common.YoloRoomOuterClass$YoloSmobaUserGameData;
import trpc.yes.common.YoloRoomOuterClass$YoloUserGameData;

/* loaded from: classes26.dex */
public class YoloRoomTGPALogic {

    /* renamed from: a, reason: collision with root package name */
    private String f379256a;

    /* renamed from: b, reason: collision with root package name */
    private String f379257b;

    /* renamed from: c, reason: collision with root package name */
    private float f379258c;

    /* renamed from: d, reason: collision with root package name */
    private float f379259d;

    /* renamed from: e, reason: collision with root package name */
    TGPAUtil.a f379260e = new TGPAUtil.a() { // from class: com.tencent.timi.game.room.impl.tgpa.YoloRoomTGPALogic.1

        /* renamed from: com.tencent.timi.game.room.impl.tgpa.YoloRoomTGPALogic$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes26.dex */
        class RunnableC99671 implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                d.g().x(false, YoloRoomTGPALogic.k(0, -1));
            }
        }

        @Override // com.tencent.timi.game.tgpa.TGPAUtil.a
        public void a(int i3, final float f16) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        l.i("YoloRoomTGPALogic", "onResourceUpdateProgress " + i3 + " - " + f16 + ", hasRoomExist = " + d.g().m());
                        return;
                    }
                    return;
                }
                if (YoloRoomTGPALogic.this.f379259d != f16) {
                    YoloRoomTGPALogic.this.f379259d = f16;
                    boolean m3 = d.g().m();
                    l.i("YoloRoomTGPALogic", "onResourceUpdateProgress " + i3 + " - " + f16 + ", hasRoomExist = " + m3);
                    if (m3) {
                        w.c(new Runnable() { // from class: com.tencent.timi.game.room.impl.tgpa.YoloRoomTGPALogic.1.4
                            @Override // java.lang.Runnable
                            public void run() {
                                int i16;
                                d g16 = d.g();
                                float f17 = f16;
                                if (f17 >= 100.0f) {
                                    i16 = 0;
                                } else {
                                    i16 = 1;
                                }
                                g16.x(false, YoloRoomTGPALogic.k(i16, (int) f17));
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            if (YoloRoomTGPALogic.this.f379258c != f16) {
                YoloRoomTGPALogic.this.f379258c = f16;
                boolean m16 = d.g().m();
                l.i("YoloRoomTGPALogic", "onResourceUpdateProgress " + i3 + " - " + f16 + ", hasRoomExist = " + m16);
                if (m16) {
                    w.c(new Runnable() { // from class: com.tencent.timi.game.room.impl.tgpa.YoloRoomTGPALogic.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            int i16;
                            d g16 = d.g();
                            float f17 = f16;
                            if (f17 >= 100.0f) {
                                i16 = 0;
                            } else {
                                i16 = 1;
                            }
                            g16.x(false, YoloRoomTGPALogic.k(i16, (int) f17));
                        }
                    });
                }
            }
        }

        @Override // com.tencent.timi.game.tgpa.TGPAUtil.a
        public void b(String str) {
            l.i("YoloRoomTGPALogic", "onReceiveResourceVersion - " + str);
            if (!TextUtils.isEmpty(str) && !str.equals(YoloRoomTGPALogic.this.f379257b)) {
                YoloRoomTGPALogic.this.f379257b = str;
                YoloRoomTGPALogic.this.n();
            }
            if (d.g().m()) {
                w.c(new Runnable() { // from class: com.tencent.timi.game.room.impl.tgpa.YoloRoomTGPALogic.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        d.g().x(false, YoloRoomTGPALogic.k(0, -1));
                    }
                });
            }
        }

        @Override // com.tencent.timi.game.tgpa.TGPAUtil.a
        public void c(int i3) {
            l.i("YoloRoomTGPALogic", "onGameSceneChanged " + i3);
            if (102 == i3 && d.g().m()) {
                d.g().r();
            }
        }

        @Override // com.tencent.timi.game.tgpa.TGPAUtil.a
        public void d(String str) {
            l.i("YoloRoomTGPALogic", "onReceiveGameVersion - " + str);
            if (!TextUtils.isEmpty(str) && !str.equals(YoloRoomTGPALogic.this.f379256a)) {
                YoloRoomTGPALogic.this.f379256a = str;
                YoloRoomTGPALogic.this.n();
            }
        }

        @Override // com.tencent.timi.game.tgpa.TGPAUtil.a
        public void e(boolean z16) {
            l.i("YoloRoomTGPALogic", "onGameVoiceSwitch - " + z16);
            w.c(new Runnable() { // from class: com.tencent.timi.game.room.impl.tgpa.YoloRoomTGPALogic.1.5
                @Override // java.lang.Runnable
                public void run() {
                    if (d.g().m()) {
                        d.g().q();
                    }
                }
            });
        }

        @Override // com.tencent.timi.game.tgpa.TGPAUtil.a
        public void f(String str, Object obj) {
            l.i("YoloRoomTGPALogic", "onReceiveCustomData " + str + " - " + obj);
        }
    };

    public YoloRoomTGPALogic() {
        l.i("YoloRoomTGPALogic", "YoloRoomTGPALogic ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static YoloRoomOuterClass$YoloUserGameData k(int i3, int i16) {
        YoloRoomOuterClass$YoloSmobaUserGameData yoloRoomOuterClass$YoloSmobaUserGameData = new YoloRoomOuterClass$YoloSmobaUserGameData();
        YoloRoomOuterClass$YoloCommonUserGameData yoloRoomOuterClass$YoloCommonUserGameData = new YoloRoomOuterClass$YoloCommonUserGameData();
        if (i3 >= 0) {
            yoloRoomOuterClass$YoloSmobaUserGameData.update_status.set(i3);
            yoloRoomOuterClass$YoloCommonUserGameData.update_status.set(i3);
        }
        if (i16 >= 0) {
            yoloRoomOuterClass$YoloSmobaUserGameData.update_process.set(i16);
            yoloRoomOuterClass$YoloCommonUserGameData.update_process.set(i16);
        }
        YoloRoomOuterClass$YoloUserGameData yoloRoomOuterClass$YoloUserGameData = new YoloRoomOuterClass$YoloUserGameData();
        yoloRoomOuterClass$YoloUserGameData.user_smoba_game_data.set(yoloRoomOuterClass$YoloSmobaUserGameData);
        yoloRoomOuterClass$YoloUserGameData.user_common_game_data.set(yoloRoomOuterClass$YoloCommonUserGameData);
        return yoloRoomOuterClass$YoloUserGameData;
    }

    public static void m(String str) {
        l.i("YoloRoomTGPALogic", "ensureStartTgpaService - " + str);
        TGPAUtil.e(a.b(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        l.i("YoloRoomTGPALogic", "notifyServerUpdateTGPASmobaVersion");
    }

    public void l() {
        l.i("YoloRoomTGPALogic", "destroy");
    }

    public void o() {
        l.i("YoloRoomTGPALogic", "onEnterRoom");
        TGPAUtil.a();
        TGPAUtil.e(a.b(), true);
        TGPAUtil.d(this.f379260e);
    }

    public void p() {
        l.i("YoloRoomTGPALogic", "onExitRoom");
        TGPAUtil.f(a.b());
        TGPAUtil.g(this.f379260e);
    }
}
