package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SimpleKuolieRoomInfo extends JceStruct {
    static Map<String, String> cache_extendInfo;
    static BackgroundColor cache_roomColor = new BackgroundColor();
    public String backgroundPicUrl;
    public String coverurl;
    public Map<String, String> extendInfo;
    public long favTime;
    public int isFav;
    public String logo;
    public String nickname;
    public long onlineNum;
    public String owner;
    public BackgroundColor roomColor;
    public String roomID;
    public String roomName;
    public int roomStatus;

    static {
        HashMap hashMap = new HashMap();
        cache_extendInfo = hashMap;
        hashMap.put("", "");
    }

    public SimpleKuolieRoomInfo() {
        this.roomID = "";
        this.roomName = "";
        this.owner = "";
        this.nickname = "";
        this.logo = "";
        this.coverurl = "";
        this.backgroundPicUrl = "";
        this.onlineNum = 0L;
        this.isFav = 0;
        this.favTime = 0L;
        this.roomStatus = 0;
        this.roomColor = null;
        this.extendInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.roomID = jceInputStream.readString(0, false);
        this.roomName = jceInputStream.readString(1, false);
        this.owner = jceInputStream.readString(2, false);
        this.nickname = jceInputStream.readString(3, false);
        this.logo = jceInputStream.readString(4, false);
        this.coverurl = jceInputStream.readString(5, false);
        this.backgroundPicUrl = jceInputStream.readString(6, false);
        this.onlineNum = jceInputStream.read(this.onlineNum, 7, false);
        this.isFav = jceInputStream.read(this.isFav, 8, false);
        this.favTime = jceInputStream.read(this.favTime, 9, false);
        this.roomStatus = jceInputStream.read(this.roomStatus, 10, false);
        this.roomColor = (BackgroundColor) jceInputStream.read((JceStruct) cache_roomColor, 11, false);
        this.extendInfo = (Map) jceInputStream.read((JceInputStream) cache_extendInfo, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.roomID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.roomName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.owner;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.nickname;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.logo;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.coverurl;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
        String str7 = this.backgroundPicUrl;
        if (str7 != null) {
            jceOutputStream.write(str7, 6);
        }
        jceOutputStream.write(this.onlineNum, 7);
        jceOutputStream.write(this.isFav, 8);
        jceOutputStream.write(this.favTime, 9);
        jceOutputStream.write(this.roomStatus, 10);
        BackgroundColor backgroundColor = this.roomColor;
        if (backgroundColor != null) {
            jceOutputStream.write((JceStruct) backgroundColor, 11);
        }
        Map<String, String> map = this.extendInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 12);
        }
    }

    public SimpleKuolieRoomInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j3, int i3, long j16, int i16, BackgroundColor backgroundColor, Map<String, String> map) {
        this.roomID = str;
        this.roomName = str2;
        this.owner = str3;
        this.nickname = str4;
        this.logo = str5;
        this.coverurl = str6;
        this.backgroundPicUrl = str7;
        this.onlineNum = j3;
        this.isFav = i3;
        this.favTime = j16;
        this.roomStatus = i16;
        this.roomColor = backgroundColor;
        this.extendInfo = map;
    }
}
