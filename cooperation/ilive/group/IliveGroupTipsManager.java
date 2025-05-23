package cooperation.ilive.group;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import java.util.HashMap;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x857.TroopTips0x857$QQVaLiveNotifyMsg;

/* compiled from: P */
/* loaded from: classes28.dex */
public class IliveGroupTipsManager implements Manager {

    /* renamed from: h, reason: collision with root package name */
    public static String f390132h = "source_push";

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f390133d;

    /* renamed from: e, reason: collision with root package name */
    private IliveGroupObserver f390134e;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<Long, Boolean> f390135f = new HashMap<>();

    public IliveGroupTipsManager(QQAppInterface qQAppInterface) {
        this.f390133d = qQAppInterface;
    }

    private void c(final long j3, final boolean z16, final String str) {
        long j16;
        if (this.f390134e == null) {
            return;
        }
        if (z16) {
            j16 = 3000;
        } else {
            j16 = 0;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: cooperation.ilive.group.IliveGroupTipsManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (IliveGroupTipsManager.this.f390134e == null) {
                    QLog.d("IliveGroupTipsManager", 1, "onGroupPushHandle isLive = " + z16 + " exit page");
                    return;
                }
                if (z16) {
                    IliveGroupTipsManager.this.d(str, String.valueOf(j3), IliveGroupTipsManager.f390132h);
                } else {
                    IliveGroupTipsManager.this.f390134e.b();
                }
            }
        }, j16);
    }

    public void b(TroopTips0x857$QQVaLiveNotifyMsg troopTips0x857$QQVaLiveNotifyMsg, long j3) {
        String str;
        if (troopTips0x857$QQVaLiveNotifyMsg == null) {
            return;
        }
        boolean z16 = false;
        if (troopTips0x857$QQVaLiveNotifyMsg.notify_type.has() && troopTips0x857$QQVaLiveNotifyMsg.notify_type.get() == 1) {
            z16 = true;
        }
        if (troopTips0x857$QQVaLiveNotifyMsg.bytes_uid.has()) {
            str = troopTips0x857$QQVaLiveNotifyMsg.bytes_uid.get().toStringUtf8();
        } else {
            str = "";
        }
        QLog.d("IliveGroupTipsManager", 1, "handlePushLiveData isLive = " + z16 + " puid = " + str + " troopUin = " + j3);
        this.f390135f.put(Long.valueOf(j3), Boolean.valueOf(z16));
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).updateTroopLive(String.valueOf(j3), z16);
        if (this.f390134e != null) {
            c(j3, z16, str);
        }
    }

    public void d(String str, String str2, String str3) {
        ((IliveCommonHandler) this.f390133d.getBusinessHandler(BusinessHandlerFactory.ILIVE_COMMON_HANDLER)).E2(str, str2, str3);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        QQAppInterface qQAppInterface;
        IliveGroupObserver iliveGroupObserver = this.f390134e;
        if (iliveGroupObserver != null && (qQAppInterface = this.f390133d) != null) {
            qQAppInterface.removeObserver(iliveGroupObserver);
        }
    }
}
