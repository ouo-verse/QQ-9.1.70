package cooperation.vip.manager;

import GIFT_MALL_PROTOCOL.DouFuInfo;
import GIFT_MALL_PROTOCOL.doufu_piece_rsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.q;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import mqq.app.NewIntent;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class BirthDayNoticeManager {

    /* renamed from: a, reason: collision with root package name */
    private static a f391242a = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a extends QZoneObserver {

        /* renamed from: d, reason: collision with root package name */
        public WeakReference<QQAppInterface> f391247d;

        a() {
        }

        @Override // com.tencent.mobileqq.observer.QZoneObserver
        protected void b(boolean z16, Bundle bundle) {
            WeakReference<QQAppInterface> weakReference = this.f391247d;
            if (weakReference == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("UndealCount.QZoneObserver", 2, "onGetBirthDayNoticeData appRef==null");
                    return;
                }
                return;
            }
            QQAppInterface qQAppInterface = weakReference.get();
            if (qQAppInterface == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("UndealCount.QZoneObserver", 2, "onGetBirthDayNoticeData app == null ");
                    return;
                }
                return;
            }
            Serializable serializable = bundle.getSerializable("data");
            if (z16 && serializable != null && (serializable instanceof doufu_piece_rsp)) {
                Iterator<DouFuInfo> it = ((doufu_piece_rsp) serializable).doufu.iterator();
                while (it.hasNext()) {
                    BirthDayNoticeManager.c(qQAppInterface, it.next());
                }
            }
            qQAppInterface.unRegistObserver(BirthDayNoticeManager.f391242a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final QQAppInterface qQAppInterface, final DouFuInfo douFuInfo) {
        final JSONObject d16 = d(douFuInfo);
        final long token = FeedsManager.getToken(String.valueOf(douFuInfo.uin));
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: cooperation.vip.manager.BirthDayNoticeManager.1
            @Override // java.lang.Runnable
            public void run() {
                String valueOf = String.valueOf(DouFuInfo.this.uin);
                if (BirthDayNoticeManager.e(qQAppInterface, valueOf)) {
                    long i06 = qQAppInterface.getMsgCache().i0(valueOf);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (Math.abs(i06 - currentTimeMillis) > 432000000) {
                        q qVar = (q) qQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
                        BeancurdMsg beancurdMsg = new BeancurdMsg();
                        beancurdMsg.buffer = d16.toString();
                        beancurdMsg.busiid = 6;
                        beancurdMsg.frienduin = String.valueOf(valueOf);
                        beancurdMsg.isNeedDelHistory = true;
                        beancurdMsg.ispush = false;
                        beancurdMsg.startTime = com.tencent.mobileqq.service.message.e.K0();
                        beancurdMsg.validTime = 432000L;
                        beancurdMsg.token = token;
                        if (QLog.isColorLevel()) {
                            QLog.i("BirthDayNoticeManager", 2, "addBirthDayFeedMessage receiveBeancurd:" + String.valueOf(beancurdMsg));
                        }
                        qVar.l(beancurdMsg);
                        qQAppInterface.getMsgCache().J1(String.valueOf(valueOf), currentTimeMillis);
                    }
                }
            }
        });
    }

    private static JSONObject d(DouFuInfo douFuInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("friendUin", douFuInfo.uin);
            jSONObject.put("background", douFuInfo.background);
            jSONObject.put("time", douFuInfo.birthday);
            jSONObject.put(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_BLESSING, douFuInfo.blessing);
            jSONObject.put(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, douFuInfo.doufu_link);
            jSONObject.put("icon", douFuInfo.icon);
        } catch (Exception e16) {
            QLog.e("BirthDayNoticeManager", 1, "error convert to json " + e16);
            MonitorManager.f().h(19, 4, "convert to json error " + e16, false);
        }
        return jSONObject;
    }

    public static boolean e(QQAppInterface qQAppInterface, String str) {
        if (com.tencent.mobileqq.mutualmark.c.h(qQAppInterface, str, 5L, false) == null && com.tencent.mobileqq.mutualmark.c.h(qQAppInterface, str, 12L, false) == null && com.tencent.mobileqq.mutualmark.c.e(qQAppInterface, str, false) == null) {
            return false;
        }
        return true;
    }

    public static void f(QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        long j3;
        String str = sessionInfo.f179557e;
        Set<String> j06 = qQAppInterface.getMsgCache().j0();
        if (j06 != null && j06.contains(str) && e(qQAppInterface, sessionInfo.f179557e)) {
            long h06 = qQAppInterface.getMsgCache().h0();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - h06 >= 86400) {
                QLog.i("BirthDayNoticeManager", 2, "requestBirthDayNotice ");
                NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), com.tencent.mobileqq.servlet.c.class);
                try {
                    j3 = Long.parseLong(qQAppInterface.getCurrentAccountUin());
                } catch (Exception e16) {
                    QLog.e("BirthDayNoticeManager", 1, "get uin error " + e16);
                    j3 = 0;
                }
                newIntent.putExtra("selfuin", j3);
                f391242a.f391247d = new WeakReference<>(qQAppInterface);
                qQAppInterface.registObserver(f391242a);
                qQAppInterface.startServlet(newIntent);
                qQAppInterface.getMsgCache().I1(currentTimeMillis);
            }
        }
    }
}
