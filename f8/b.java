package f8;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.personalize.phonetail.protocol.QZoneSetUserTailRequest;
import cooperation.qzone.remote.logic.RemoteHandleConst;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements IQZoneServiceListener {
    public void a(String str, String str2, int i3, int i16, Handler handler) {
        QZoneTask qZoneTask = new QZoneTask(new QZoneSetUserTailRequest(str, str2, i3), handler, this, 0);
        qZoneTask.addParameter(RemoteHandleConst.WEBPLUGIN_SERVICE_REQUEST_ID, Integer.valueOf(i16));
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        QZoneRequest qZoneRequest;
        if (qZoneTask == null || qZoneTask.getHandler() == null || (qZoneRequest = qZoneTask.mRequest) == null || qZoneRequest.rsp == null) {
            return;
        }
        Integer num = (Integer) qZoneTask.getParameter(RemoteHandleConst.WEBPLUGIN_SERVICE_REQUEST_ID);
        Handler handler = qZoneTask.getHandler();
        Bundle bundle = new Bundle();
        Message obtainMessage = handler.obtainMessage(num.intValue());
        if (obtainMessage != null) {
            bundle.putLong(RemoteHandleConst.PARAM_REQUEST_CODE, 1L);
            obtainMessage.obj = bundle;
            handler.sendMessage(obtainMessage);
        }
    }
}
