package cooperation.qzone.share;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import u5.c;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneShareServlet extends MSFServlet {
    private static final String TAG = "QzoneShare.QzoneShareServlet";
    private static final int TIMEOUT = 60000;

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            QLog.e(TAG, 1, "QzoneShareServlet onReceive success.");
        } else {
            QLog.e(TAG, 1, "QzoneShareServlet onReceive fail.");
        }
    }

    private void removeInvalidUrl(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (arrayList.get(i3) == null) {
                arrayList.remove(i3);
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        Bundle extras = intent.getExtras();
        QZoneShareData qZoneShareData = (QZoneShareData) extras.get("sharedata");
        long j3 = qZoneShareData.appid;
        String str = qZoneShareData.appName;
        String str2 = qZoneShareData.mTitle;
        String str3 = qZoneShareData.mSummary;
        String str4 = qZoneShareData.targetUrl;
        String str5 = qZoneShareData.extString;
        ArrayList<String> arrayList = qZoneShareData.mImageUrls;
        removeInvalidUrl(arrayList);
        QzoneShareRequest qzoneShareRequest = new QzoneShareRequest(str, str4, QZoneShareManager.THIRD_PART_SHARE_APPID, extras.getLong("uin"), str2, str3, extras.getString("reason"), arrayList, j3, str5, qZoneShareData.iUrlInfoFrm, qZoneShareData.xcxMapEx, qZoneShareData.qzoneShareInfo);
        byte[] encode = qzoneShareRequest.encode();
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setTimeout(60000L);
        packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + qzoneShareRequest.uniKey());
        packet.putSendData(encode);
        c.R(getAppRuntime().getCurrentUin(), true);
    }
}
