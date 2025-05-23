package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetKuolieRecomListRsp extends JceStruct {
    static Map<String, String> cache_dc_report;
    static DefaultInfo cache_info;
    public CommonInfo commInfo;
    public Map<String, String> dc_report;
    public int favNum;
    public DefaultInfo info;
    public ArrayList<SimpleKuolieRoomInfo> roomList;
    public String userId;
    public SimpleKuolieRoomInfo userRoom;
    static CommonInfo cache_commInfo = new CommonInfo();
    static SimpleKuolieRoomInfo cache_userRoom = new SimpleKuolieRoomInfo();
    static ArrayList<SimpleKuolieRoomInfo> cache_roomList = new ArrayList<>();

    static {
        cache_roomList.add(new SimpleKuolieRoomInfo());
        cache_info = new DefaultInfo();
        HashMap hashMap = new HashMap();
        cache_dc_report = hashMap;
        hashMap.put("", "");
    }

    public GetKuolieRecomListRsp() {
        this.commInfo = null;
        this.userId = "";
        this.favNum = 0;
        this.userRoom = null;
        this.roomList = null;
        this.info = null;
        this.dc_report = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.commInfo = (CommonInfo) jceInputStream.read((JceStruct) cache_commInfo, 0, false);
        this.userId = jceInputStream.readString(1, false);
        this.favNum = jceInputStream.read(this.favNum, 2, false);
        this.userRoom = (SimpleKuolieRoomInfo) jceInputStream.read((JceStruct) cache_userRoom, 3, false);
        this.roomList = (ArrayList) jceInputStream.read((JceInputStream) cache_roomList, 4, false);
        this.info = (DefaultInfo) jceInputStream.read((JceStruct) cache_info, 5, false);
        this.dc_report = (Map) jceInputStream.read((JceInputStream) cache_dc_report, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommonInfo commonInfo = this.commInfo;
        if (commonInfo != null) {
            jceOutputStream.write((JceStruct) commonInfo, 0);
        }
        String str = this.userId;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.favNum, 2);
        SimpleKuolieRoomInfo simpleKuolieRoomInfo = this.userRoom;
        if (simpleKuolieRoomInfo != null) {
            jceOutputStream.write((JceStruct) simpleKuolieRoomInfo, 3);
        }
        ArrayList<SimpleKuolieRoomInfo> arrayList = this.roomList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        DefaultInfo defaultInfo = this.info;
        if (defaultInfo != null) {
            jceOutputStream.write((JceStruct) defaultInfo, 5);
        }
        Map<String, String> map = this.dc_report;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
    }

    public GetKuolieRecomListRsp(CommonInfo commonInfo, String str, int i3, SimpleKuolieRoomInfo simpleKuolieRoomInfo, ArrayList<SimpleKuolieRoomInfo> arrayList, DefaultInfo defaultInfo, Map<String, String> map) {
        this.commInfo = commonInfo;
        this.userId = str;
        this.favNum = i3;
        this.userRoom = simpleKuolieRoomInfo;
        this.roomList = arrayList;
        this.info = defaultInfo;
        this.dc_report = map;
    }
}
