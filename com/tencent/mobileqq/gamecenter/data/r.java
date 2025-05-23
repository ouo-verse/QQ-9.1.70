package com.tencent.mobileqq.gamecenter.data;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mobileqq.gamecenter.data.q;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$BattlepassBottom;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$BattlepassProgress;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$BattlepassTask;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$BattlepassWidget;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$CloudGame;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$Gift;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$MessageNotice;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$NewWidget;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQWidgetSvr$PromotionAd;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class r {
    public static synchronized boolean a(q qVar) {
        String json;
        synchronized (r.class) {
            if (qVar != null) {
                try {
                    json = new Gson().toJson(qVar);
                } catch (Throwable th5) {
                    QLog.e("GCWidget.WidgetInfoHelper", 1, th5, new Object[0]);
                    return false;
                }
            } else {
                json = "";
            }
            QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeString("gamecenter_appwidget_widget_info", json);
        }
        return true;
    }

    public static synchronized void b() {
        synchronized (r.class) {
            try {
                QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeString("gamecenter_appwidget_widget_info", "");
                QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeLong("game_center_widget_net_pull_ts_v2", -1L);
            } catch (Throwable th5) {
                QLog.e("GCWidget.WidgetInfoHelper", 1, th5, new Object[0]);
            }
        }
    }

    public static long c() {
        return QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeLong("game_center_widget_net_pull_ts_v2", -1L);
    }

    public static synchronized q d(boolean z16) {
        synchronized (r.class) {
            String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeString("gamecenter_appwidget_widget_info", "");
            if (z16) {
                QLog.i("GCWidget.WidgetInfoHelper", 2, "[getCacheWidgetInfo] widgetJson:" + decodeString);
            }
            q qVar = null;
            if (TextUtils.isEmpty(decodeString)) {
                return null;
            }
            try {
                qVar = (q) new Gson().fromJson(decodeString, q.class);
            } catch (Throwable th5) {
                QLog.e("GCWidget.WidgetInfoHelper", 1, th5, new Object[0]);
            }
            return qVar;
        }
    }

    public static synchronized void e(long j3) {
        synchronized (r.class) {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            QLog.i("GCWidget.WidgetInfoHelper", 1, "[updateNextPullTsV2], nextPullTs:" + j3 + ",curTimestamp:" + serverTimeMillis);
            if (j3 <= 0 || j3 * 1000 < serverTimeMillis) {
                j3 = (serverTimeMillis + 86400000) / 1000;
                QLog.w("GCWidget.WidgetInfoHelper", 1, "nextPullTs is invalid.");
            }
            QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeLong("game_center_widget_net_pull_ts_v2", j3);
        }
    }

    public static synchronized q f(QQWidgetSvr$NewWidget qQWidgetSvr$NewWidget) {
        synchronized (r.class) {
            if (qQWidgetSvr$NewWidget != null) {
                try {
                    q qVar = new q();
                    q.j jVar = new q.j();
                    jVar.b(0);
                    qVar.L(jVar);
                    QQWidgetSvr$PromotionAd qQWidgetSvr$PromotionAd = qQWidgetSvr$NewWidget.promotion_id.get();
                    if (qQWidgetSvr$PromotionAd != null) {
                        q.i iVar = new q.i();
                        iVar.j(qQWidgetSvr$PromotionAd.pic.get());
                        iVar.i(qQWidgetSvr$PromotionAd.jump_url.get());
                        iVar.k(qQWidgetSvr$PromotionAd.type.get());
                        iVar.f(qQWidgetSvr$PromotionAd.appid.get());
                        iVar.g(qQWidgetSvr$PromotionAd.f213228id.get());
                        qVar.J(iVar);
                    }
                    QQWidgetSvr$Gift qQWidgetSvr$Gift = qQWidgetSvr$NewWidget.gifts.get();
                    if (qQWidgetSvr$Gift != null) {
                        q.g gVar = new q.g();
                        gVar.j(qQWidgetSvr$Gift.icon.get());
                        gVar.i(qQWidgetSvr$Gift.count.get());
                        gVar.l(qQWidgetSvr$Gift.jump_url.get());
                        gVar.h(qQWidgetSvr$Gift.appid.get());
                        gVar.m(qQWidgetSvr$Gift.text.get());
                        gVar.n(qQWidgetSvr$Gift.url_type.get());
                        qVar.H(gVar);
                    }
                    QQWidgetSvr$CloudGame qQWidgetSvr$CloudGame = qQWidgetSvr$NewWidget.cloud_game.get();
                    if (qQWidgetSvr$CloudGame != null) {
                        q.e eVar = new q.e();
                        eVar.f(qQWidgetSvr$CloudGame.appid.get());
                        eVar.i(qQWidgetSvr$CloudGame.jump_url.get());
                        eVar.g(qQWidgetSvr$CloudGame.icon.get());
                        eVar.j(qQWidgetSvr$CloudGame.text.get());
                        qVar.G(eVar);
                    }
                    QQWidgetSvr$MessageNotice qQWidgetSvr$MessageNotice = qQWidgetSvr$NewWidget.notice.get();
                    if (qQWidgetSvr$MessageNotice != null) {
                        q.h hVar = new q.h();
                        hVar.f(qQWidgetSvr$MessageNotice.f213227msg.get());
                        hVar.g(qQWidgetSvr$MessageNotice.unique_id.get());
                        hVar.e(qQWidgetSvr$MessageNotice.jump_url.get());
                        hVar.d(qQWidgetSvr$MessageNotice.f213226id.get());
                        qVar.I(hVar);
                    }
                    return qVar;
                } catch (Throwable th5) {
                    QLog.e("GCWidget.WidgetInfoHelper", 1, th5, new Object[0]);
                }
            }
            QLog.i("GCWidget.WidgetInfoHelper", 1, "[updateWidgetInfo] failed");
            return null;
        }
    }

    public static synchronized q g(QQWidgetSvr$BattlepassWidget qQWidgetSvr$BattlepassWidget) {
        synchronized (r.class) {
            if (qQWidgetSvr$BattlepassWidget == null) {
                return null;
            }
            try {
                q qVar = new q();
                q.j jVar = new q.j();
                jVar.b(1);
                qVar.L(jVar);
                q.d dVar = new q.d();
                dVar.d(qQWidgetSvr$BattlepassWidget.status.get());
                dVar.c(qQWidgetSvr$BattlepassWidget.jump_url.get());
                qVar.K(dVar);
                QQWidgetSvr$BattlepassTask qQWidgetSvr$BattlepassTask = qQWidgetSvr$BattlepassWidget.task.get();
                if (qQWidgetSvr$BattlepassTask != null) {
                    q.c cVar = new q.c();
                    cVar.f(qQWidgetSvr$BattlepassTask.current_exp.get());
                    cVar.g(qQWidgetSvr$BattlepassTask.desc.get());
                    cVar.i(qQWidgetSvr$BattlepassTask.task_name.get());
                    cVar.h(qQWidgetSvr$BattlepassTask.exp_item.get());
                    cVar.j(qQWidgetSvr$BattlepassTask.total_exp.get());
                    qVar.E(cVar);
                }
                QQWidgetSvr$BattlepassProgress qQWidgetSvr$BattlepassProgress = qQWidgetSvr$BattlepassWidget.progress.get();
                if (qQWidgetSvr$BattlepassProgress != null) {
                    q.b bVar = new q.b();
                    bVar.j(qQWidgetSvr$BattlepassProgress.progress.get());
                    bVar.g(qQWidgetSvr$BattlepassProgress.level.get());
                    bVar.i(qQWidgetSvr$BattlepassProgress.icon.get());
                    bVar.f(qQWidgetSvr$BattlepassProgress.is_advanced.get());
                    qVar.D(bVar);
                }
                QQWidgetSvr$BattlepassBottom qQWidgetSvr$BattlepassBottom = qQWidgetSvr$BattlepassWidget.bottom.get();
                if (qQWidgetSvr$BattlepassBottom != null) {
                    q.a aVar = new q.a();
                    aVar.f(qQWidgetSvr$BattlepassBottom.desc.get());
                    aVar.g(qQWidgetSvr$BattlepassBottom.exp_item.get());
                    aVar.h(qQWidgetSvr$BattlepassBottom.icon.get());
                    aVar.j(qQWidgetSvr$BattlepassBottom.prize_name_level.get());
                    qVar.F(aVar);
                }
                QLog.i("GCWidget.WidgetInfoHelper", 1, "[updateWidgetInfoV3] success");
                return qVar;
            } catch (Throwable th5) {
                QLog.e("GCWidget.WidgetInfoHelper", 1, "[updateWidgetInfoV3], th:", th5);
                QLog.i("GCWidget.WidgetInfoHelper", 1, "[updateWidgetInfoV3] failed");
                return null;
            }
        }
    }
}
