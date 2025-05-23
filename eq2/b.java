package eq2;

import KQQ.InfoItem;
import KQQ.PluginInfo;
import KQQ.ReqGetPluginSettings;
import KQQ.RespGetPluginSettings;
import KQQ.SyncReq;
import KQQ.SyncRes;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import java.util.ArrayList;
import java.util.List;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    public static List<PluginInfo> a(byte[] bArr) {
        ArrayList<InfoItem> arrayList;
        byte[] bArr2;
        if (bArr == null) {
            return null;
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(bArr);
            SyncRes syncRes = (SyncRes) uniPacket.get("SyncRes");
            if (syncRes != null && syncRes.result == 0 && (arrayList = syncRes.vecResPkg) != null && arrayList.size() > 0 && (bArr2 = arrayList.get(0).vecValue) != null) {
                JceInputStream jceInputStream = new JceInputStream(bArr2);
                jceInputStream.setServerEncoding("utf-8");
                RespGetPluginSettings respGetPluginSettings = new RespGetPluginSettings();
                respGetPluginSettings.readFrom(jceInputStream);
                ArrayList<PluginInfo> arrayList2 = respGetPluginSettings.PluginInfoList;
                if (arrayList2 != null) {
                    return arrayList2;
                }
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static void b(Packet packet, List<Long> list) {
        SyncReq syncReq = new SyncReq();
        ArrayList<InfoItem> arrayList = new ArrayList<>();
        InfoItem infoItem = new InfoItem();
        infoItem.cOperType = (byte) 1;
        infoItem.qwServiceId = 22L;
        infoItem.qwTimeStamp = 0L;
        infoItem.vecValue = c(list);
        arrayList.add(infoItem);
        syncReq.vecReqPkg = arrayList;
        packet.setSSOCommand("ProfileService.SyncReq");
        packet.setServantName("ProfileService");
        packet.setFuncName("SyncReq");
        packet.addRequestPacket("SyncReq", syncReq);
    }

    public static byte[] c(List<Long> list) {
        ReqGetPluginSettings reqGetPluginSettings = new ReqGetPluginSettings();
        ArrayList<Long> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        } else {
            arrayList.add(489L);
        }
        reqGetPluginSettings.PluginList = arrayList;
        JceOutputStream jceOutputStream = new JceOutputStream();
        reqGetPluginSettings.writeTo(jceOutputStream);
        return jceOutputStream.toByteArray();
    }
}
