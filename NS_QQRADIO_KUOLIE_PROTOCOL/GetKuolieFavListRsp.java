package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetKuolieFavListRsp extends JceStruct {
    static CommonInfo cache_commInfo = new CommonInfo();
    static ArrayList<SimpleKuolieRoomInfo> cache_roomList = new ArrayList<>();
    public CommonInfo commInfo;
    public ArrayList<SimpleKuolieRoomInfo> roomList;

    static {
        cache_roomList.add(new SimpleKuolieRoomInfo());
    }

    public GetKuolieFavListRsp() {
        this.commInfo = null;
        this.roomList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.commInfo = (CommonInfo) jceInputStream.read((JceStruct) cache_commInfo, 0, false);
        this.roomList = (ArrayList) jceInputStream.read((JceInputStream) cache_roomList, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommonInfo commonInfo = this.commInfo;
        if (commonInfo != null) {
            jceOutputStream.write((JceStruct) commonInfo, 0);
        }
        ArrayList<SimpleKuolieRoomInfo> arrayList = this.roomList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public GetKuolieFavListRsp(CommonInfo commonInfo, ArrayList<SimpleKuolieRoomInfo> arrayList) {
        this.commInfo = commonInfo;
        this.roomList = arrayList;
    }
}
