package cooperation.qzone.gift;

import NS_MOBILE_TEMPLATE_GIFT.template_gift_get_send_status_rsp;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.b;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneCheckSendGiftServlet extends MSFServlet {
    public static final int CMD_ID_CHECK_SEND_GIFT = 110;
    public static final String PARAM_FRINED_LIST = "friendList";
    public static final String PARAM_OWN_UIN = "ownUin";
    public static final String PARAM_REQ_TYPE = "param_req_type";
    public static final String TAG = "QZoneCheckSendGiftServlet";
    public static final int TIMEOUT = 10000;

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        Long valueOf = Long.valueOf(intent.getLongExtra(PARAM_OWN_UIN, 0L));
        long[] longArrayExtra = intent.getLongArrayExtra(PARAM_FRINED_LIST);
        ArrayList arrayList = new ArrayList();
        if (longArrayExtra != null && longArrayExtra.length > 0) {
            for (long j3 : longArrayExtra) {
                arrayList.add(Long.valueOf(j3));
            }
        } else {
            QLog.i(TAG, 1, "the friendList is null or it's length is zero");
        }
        QZoneCheckSendGiftRequest qZoneCheckSendGiftRequest = new QZoneCheckSendGiftRequest(valueOf.longValue(), new ArrayList(arrayList), null);
        byte[] encode = qZoneCheckSendGiftRequest.encode();
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setTimeout(10000L);
        packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + qZoneCheckSendGiftRequest.uniKey());
        packet.putSendData(encode);
        QLog.i(TAG, 1, "onSend success.");
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null || !fromServiceMsg.isSuccess()) {
            if (fromServiceMsg == null) {
                QLog.e(TAG, 1, "onReceive fail, fromServiceMsg == null");
                return;
            }
            QLog.e(TAG, 1, "onReceive fail, the resultCode is " + fromServiceMsg.getResultCode());
            return;
        }
        template_gift_get_send_status_rsp onResponse = QZoneCheckSendGiftRequest.onResponse(fromServiceMsg.getWupBuffer());
        if (onResponse != null) {
            long j3 = onResponse.uin;
            Map<Long, Integer> map = onResponse.map_birth_friend_list_state;
            ActivateFriendsManager activateFriendsManager = (ActivateFriendsManager) getAppRuntime().getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
            if (activateFriendsManager != null) {
                activateFriendsManager.H(j3, map, 2);
            }
            notifyObserver(intent, 110, true, null, b.class);
            QLog.i(TAG, 1, "onReceive success, friendMap size =" + map.size());
            return;
        }
        QLog.i(TAG, 1, "onReceive response == null.");
    }

    public static void sendMsgToQzone(QQAppInterface qQAppInterface, long j3, long[] jArr) {
        if (jArr == null || jArr.length == 0) {
            return;
        }
        NewIntent newIntent = new NewIntent(qQAppInterface.getApplication(), QZoneCheckSendGiftServlet.class);
        newIntent.putExtra(PARAM_REQ_TYPE, 110);
        newIntent.putExtra(PARAM_OWN_UIN, j3);
        newIntent.putExtra(PARAM_FRINED_LIST, jArr);
        qQAppInterface.startServlet(newIntent);
    }
}
