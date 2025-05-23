package NS_QZONE_MQMSG;

import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NewMQMsg extends JceStruct {
    static ArrayList<single_feed> cache_all_feeds_data;
    static Map<String, String> cache_mpExtent;
    static PostBar cache_postGuide;
    static UserPersonalData cache_userPersonalData;
    public ArrayList<single_feed> all_feeds_data;
    public BottomCell bottomCell;
    public String content;
    public int isNewStyle;
    public String jumpUrlToDetail;
    public Map<String, String> mpExtent;
    public MsgBody msgBody;
    public MsgInteractData msgInteractData;
    public long msgSize;
    public int msgType;
    public String nick;
    public PostBar postGuide;
    public String promot;
    public long pushTime;
    public String reportValue;
    public String title;
    public String userAvatar;
    public UserPersonalData userPersonalData;
    static MsgBody cache_msgBody = new MsgBody();
    static MsgInteractData cache_msgInteractData = new MsgInteractData();
    static BottomCell cache_bottomCell = new BottomCell();

    static {
        HashMap hashMap = new HashMap();
        cache_mpExtent = hashMap;
        hashMap.put("", "");
        cache_userPersonalData = new UserPersonalData();
        cache_all_feeds_data = new ArrayList<>();
        cache_all_feeds_data.add(new single_feed());
        cache_postGuide = new PostBar();
    }

    public NewMQMsg() {
        this.msgType = 0;
        this.title = "";
        this.pushTime = 0L;
        this.userAvatar = "";
        this.nick = "";
        this.promot = "";
        this.msgBody = null;
        this.msgInteractData = null;
        this.jumpUrlToDetail = "";
        this.bottomCell = null;
        this.mpExtent = null;
        this.userPersonalData = null;
        this.all_feeds_data = null;
        this.reportValue = "";
        this.content = "";
        this.msgSize = 0L;
        this.isNewStyle = 0;
        this.postGuide = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.msgType = jceInputStream.read(this.msgType, 0, false);
        this.title = jceInputStream.readString(1, false);
        this.pushTime = jceInputStream.read(this.pushTime, 2, false);
        this.userAvatar = jceInputStream.readString(3, false);
        this.nick = jceInputStream.readString(4, false);
        this.promot = jceInputStream.readString(5, false);
        this.msgBody = (MsgBody) jceInputStream.read((JceStruct) cache_msgBody, 6, false);
        this.msgInteractData = (MsgInteractData) jceInputStream.read((JceStruct) cache_msgInteractData, 7, false);
        this.jumpUrlToDetail = jceInputStream.readString(8, false);
        this.bottomCell = (BottomCell) jceInputStream.read((JceStruct) cache_bottomCell, 9, false);
        this.mpExtent = (Map) jceInputStream.read((JceInputStream) cache_mpExtent, 10, false);
        this.userPersonalData = (UserPersonalData) jceInputStream.read((JceStruct) cache_userPersonalData, 11, false);
        this.all_feeds_data = (ArrayList) jceInputStream.read((JceInputStream) cache_all_feeds_data, 12, false);
        this.reportValue = jceInputStream.readString(13, false);
        this.content = jceInputStream.readString(14, false);
        this.msgSize = jceInputStream.read(this.msgSize, 15, false);
        this.isNewStyle = jceInputStream.read(this.isNewStyle, 16, false);
        this.postGuide = (PostBar) jceInputStream.read((JceStruct) cache_postGuide, 17, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.msgType, 0);
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.pushTime, 2);
        String str2 = this.userAvatar;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.nick;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.promot;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        MsgBody msgBody = this.msgBody;
        if (msgBody != null) {
            jceOutputStream.write((JceStruct) msgBody, 6);
        }
        MsgInteractData msgInteractData = this.msgInteractData;
        if (msgInteractData != null) {
            jceOutputStream.write((JceStruct) msgInteractData, 7);
        }
        String str5 = this.jumpUrlToDetail;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        BottomCell bottomCell = this.bottomCell;
        if (bottomCell != null) {
            jceOutputStream.write((JceStruct) bottomCell, 9);
        }
        Map<String, String> map = this.mpExtent;
        if (map != null) {
            jceOutputStream.write((Map) map, 10);
        }
        UserPersonalData userPersonalData = this.userPersonalData;
        if (userPersonalData != null) {
            jceOutputStream.write((JceStruct) userPersonalData, 11);
        }
        ArrayList<single_feed> arrayList = this.all_feeds_data;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 12);
        }
        String str6 = this.reportValue;
        if (str6 != null) {
            jceOutputStream.write(str6, 13);
        }
        String str7 = this.content;
        if (str7 != null) {
            jceOutputStream.write(str7, 14);
        }
        jceOutputStream.write(this.msgSize, 15);
        jceOutputStream.write(this.isNewStyle, 16);
        PostBar postBar = this.postGuide;
        if (postBar != null) {
            jceOutputStream.write((JceStruct) postBar, 17);
        }
    }

    public NewMQMsg(int i3, String str, long j3, String str2, String str3, String str4, MsgBody msgBody, MsgInteractData msgInteractData, String str5, BottomCell bottomCell, Map<String, String> map, UserPersonalData userPersonalData, ArrayList<single_feed> arrayList, String str6, String str7, long j16, int i16, PostBar postBar) {
        this.msgType = i3;
        this.title = str;
        this.pushTime = j3;
        this.userAvatar = str2;
        this.nick = str3;
        this.promot = str4;
        this.msgBody = msgBody;
        this.msgInteractData = msgInteractData;
        this.jumpUrlToDetail = str5;
        this.bottomCell = bottomCell;
        this.mpExtent = map;
        this.userPersonalData = userPersonalData;
        this.all_feeds_data = arrayList;
        this.reportValue = str6;
        this.content = str7;
        this.msgSize = j16;
        this.isNewStyle = i16;
        this.postGuide = postBar;
    }
}
