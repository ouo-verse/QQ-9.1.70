package cooperation.qzone.patch;

import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.plugin.PluginIntent;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* loaded from: classes38.dex */
public class QzoneUpdatePatchServlet extends MSFServlet {
    private static final String TAG = "qz_patch";
    private static final int TIMEOUT = 60000;

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        ArrayList<UPDATE_INFO> arrayList;
        ArrayList<UPDATE_INFO> arrayList2;
        if (intent instanceof PluginIntent) {
            PluginIntent pluginIntent = (PluginIntent) intent;
            arrayList = pluginIntent.update_infos;
            arrayList2 = pluginIntent.module_update_infos;
        } else {
            arrayList = null;
            arrayList2 = null;
        }
        QZonePatchRequest qZonePatchRequest = new QZonePatchRequest(getAppRuntime().getLongAccountUin(), arrayList, arrayList2);
        byte[] encode = qZonePatchRequest.encode();
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setTimeout(60000L);
        packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + qZonePatchRequest.uniKey());
        packet.putSendData(encode);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        PluginIntent.OnResultListner resultListner;
        if (intent == null || !(intent instanceof PluginIntent) || (resultListner = ((PluginIntent) intent).getResultListner()) == null) {
            return;
        }
        resultListner.onRecieve(intent, fromServiceMsg);
    }
}
