package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public class TroopGameNotifyUpdateHelper implements com.tencent.aio.main.businesshelper.h {
    public static int C = 1800;

    /* renamed from: m, reason: collision with root package name */
    public static long f178734m = 7200;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f178735d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.aio.api.runtime.a f178736e;

    /* renamed from: h, reason: collision with root package name */
    protected com.tencent.mobileqq.troop.troopgame.api.a f178738h;

    /* renamed from: f, reason: collision with root package name */
    protected String f178737f = "";

    /* renamed from: i, reason: collision with root package name */
    private boolean f178739i = true;

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgs(new Contact(2, str, ""), 0L, 1, true, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.activity.aio.helper.ap
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str2, ArrayList arrayList) {
                TroopGameNotifyUpdateHelper.this.j(i3, str2, arrayList);
            }
        });
    }

    private static String e(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        calendar.setTimeInMillis(j3 * 1000);
        return String.format("%d-%d-%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
    }

    private static int g(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 2) {
            try {
                return (int) ((Integer.parseInt(str.substring(str.length() - 2)) / 100.0d) * C);
            } catch (NumberFormatException e16) {
                QLog.e("TroopGameNotifyUpdateHelper", 1, e16, new Object[0]);
            }
        }
        return 0;
    }

    private static boolean h(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface == null) {
            return false;
        }
        MMKVOptionEntity from = QMMKV.from(qQAppInterface.getApplicationContext(), "common_mmkv_configurations");
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        long decodeLong = from.decodeLong("SP_GAME_NOTIFY_UPDATE_" + currentAccountUin + "_" + str, 0L);
        long serverTime = NetConnInfoCenter.getServerTime();
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameNotifyUpdateHelper", 2, "hasNotifyUpdate, updateTime = " + decodeLong + ", curTime = " + serverTime);
        }
        if (decodeLong < f178734m || decodeLong > serverTime) {
            return false;
        }
        return i(decodeLong, serverTime, currentAccountUin);
    }

    private static boolean i(long j3, long j16, String str) {
        String e16 = e((j16 - f178734m) - g(str));
        String e17 = e((j3 - f178734m) - g(str));
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameNotifyUpdateHelper", 2, "isCurrentDay, compareDay =" + e17 + ", curDay=" + e16);
        }
        return e16.equals(e17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(int i3, String str, ArrayList arrayList) {
        if (!bl.b(arrayList) && this.f178735d != null) {
            boolean z16 = false;
            MsgRecord msgRecord = (MsgRecord) arrayList.get(0);
            if (msgRecord == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopGameNotifyUpdateHelper", 2, "checkSendMsgAfterTenClockToday, lastMsg is null");
                }
            } else {
                z16 = i(msgRecord.getMsgTime(), NetConnInfoCenter.getServerTime(), this.f178735d.getCurrentAccountUin());
            }
            if (z16) {
                k();
            }
        }
    }

    private void k() {
        QQAppInterface qQAppInterface = this.f178735d;
        if (qQAppInterface == null) {
            return;
        }
        if (this.f178738h == null) {
            this.f178738h = (com.tencent.mobileqq.troop.troopgame.api.a) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_GAME_HANDLER);
        }
        com.tencent.mobileqq.troop.troopgame.api.a aVar = this.f178738h;
        if (aVar != null) {
            aVar.A1(this.f178737f);
            long serverTime = NetConnInfoCenter.getServerTime();
            m(this.f178735d, this.f178737f, serverTime);
            if (QLog.isColorLevel()) {
                QLog.d("TroopGameNotifyUpdateHelper", 2, "notifyUpdate, curTime = " + serverTime);
            }
        }
    }

    private static void m(QQAppInterface qQAppInterface, String str, long j3) {
        if (qQAppInterface == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameNotifyUpdateHelper", 2, "setNotifyUpdateTime, troopUin = " + str + ", curTime = " + j3);
        }
        QMMKV.from(qQAppInterface.getApplicationContext(), "common_mmkv_configurations").encodeLong("SP_GAME_NOTIFY_UPDATE_" + qQAppInterface.getCurrentAccountUin() + "_" + str, j3).commitAsync();
    }

    public void c() {
        TroopInfo B;
        com.tencent.aio.api.runtime.a aVar = this.f178736e;
        if (aVar == null || this.f178735d == null || aVar.g() == null || StudyModeManager.t()) {
            return;
        }
        String j3 = this.f178736e.g().r().c().j();
        this.f178737f = j3;
        if (TextUtils.isEmpty(j3) || (B = ((TroopManager) this.f178735d.getManager(QQManagerFactory.TROOP_MANAGER)).B(this.f178737f)) == null || B.isHomeworkTroop() || !B.isTroopGameCardEnabled() || h(this.f178735d, this.f178737f)) {
            return;
        }
        b(this.f178737f);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.D;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NonNull
    public String getTag() {
        return "TroopGameNotifyUpdateHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NonNull
    public int[] interestedIn() {
        return new int[]{3};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NonNull com.tencent.aio.main.businesshelper.b bVar) {
        this.f178739i = true;
        this.f178736e = bVar.a();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            this.f178735d = (QQAppInterface) peekAppRuntime;
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        this.f178735d = null;
        this.f178736e = null;
        this.f178737f = "";
        this.f178738h = null;
        this.f178739i = true;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int i3) {
        if (i3 == 3 && this.f178739i) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.TroopGameNotifyUpdateHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TroopGameNotifyUpdateHelper.this.c();
                    } catch (Exception e16) {
                        QLog.e("TroopGameNotifyUpdateHelper", 1, "checkShouldNotifyUpdate, exception: " + e16.getMessage());
                    }
                }
            }, 64, null, false);
            this.f178739i = false;
        }
    }
}
