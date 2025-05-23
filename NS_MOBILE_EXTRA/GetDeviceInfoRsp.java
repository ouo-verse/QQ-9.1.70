package NS_MOBILE_EXTRA;

import NS_MOBILE_COMM.yellow_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetDeviceInfoRsp extends JceStruct {
    static yellow_info cache_user_yellow_info;
    static ArrayList<DeviceInfo> cache_vecDeviceInfo;
    public yellow_info user_yellow_info;
    public ArrayList<DeviceInfo> vecDeviceInfo;

    public GetDeviceInfoRsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vecDeviceInfo == null) {
            cache_vecDeviceInfo = new ArrayList<>();
            cache_vecDeviceInfo.add(new DeviceInfo());
        }
        this.vecDeviceInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecDeviceInfo, 0, true);
        if (cache_user_yellow_info == null) {
            cache_user_yellow_info = new yellow_info();
        }
        this.user_yellow_info = (yellow_info) jceInputStream.read((JceStruct) cache_user_yellow_info, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vecDeviceInfo, 0);
        yellow_info yellow_infoVar = this.user_yellow_info;
        if (yellow_infoVar != null) {
            jceOutputStream.write((JceStruct) yellow_infoVar, 1);
        }
    }

    public GetDeviceInfoRsp(ArrayList<DeviceInfo> arrayList, yellow_info yellow_infoVar) {
        this.vecDeviceInfo = arrayList;
        this.user_yellow_info = yellow_infoVar;
    }
}
