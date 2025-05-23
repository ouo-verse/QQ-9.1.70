package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetKuolieFriendRecomRsp extends JceStruct {
    static CommonInfo cache_commInfo = new CommonInfo();
    static SimpleKuolieRoomInfo cache_roomInfo = new SimpleKuolieRoomInfo();
    static ArrayList<User> cache_userList = new ArrayList<>();
    public CommonInfo commInfo;
    public SimpleKuolieRoomInfo roomInfo;
    public ArrayList<User> userList;

    static {
        cache_userList.add(new User());
    }

    public GetKuolieFriendRecomRsp() {
        this.commInfo = null;
        this.roomInfo = null;
        this.userList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.commInfo = (CommonInfo) jceInputStream.read((JceStruct) cache_commInfo, 0, false);
        this.roomInfo = (SimpleKuolieRoomInfo) jceInputStream.read((JceStruct) cache_roomInfo, 1, false);
        this.userList = (ArrayList) jceInputStream.read((JceInputStream) cache_userList, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommonInfo commonInfo = this.commInfo;
        if (commonInfo != null) {
            jceOutputStream.write((JceStruct) commonInfo, 0);
        }
        SimpleKuolieRoomInfo simpleKuolieRoomInfo = this.roomInfo;
        if (simpleKuolieRoomInfo != null) {
            jceOutputStream.write((JceStruct) simpleKuolieRoomInfo, 1);
        }
        ArrayList<User> arrayList = this.userList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public GetKuolieFriendRecomRsp(CommonInfo commonInfo, SimpleKuolieRoomInfo simpleKuolieRoomInfo, ArrayList<User> arrayList) {
        this.commInfo = commonInfo;
        this.roomInfo = simpleKuolieRoomInfo;
        this.userList = arrayList;
    }
}
