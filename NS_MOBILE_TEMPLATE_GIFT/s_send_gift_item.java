package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_send_gift_item extends JceStruct {
    static Map<String, String> cache_mapExt;
    public int arch;
    public String clientIp;
    public String content;
    public s_gift_card giftCard;
    public long giftItemId;
    public int giftType;
    public boolean isBack;
    public boolean isPrivate;
    public boolean isTiming;
    public Map<String, String> mapExt;
    public ArrayList<Long> receiver;
    public int recv_source;
    public String s_back_id;
    public String sendTime;
    public String url;
    static s_gift_card cache_giftCard = new s_gift_card();
    static ArrayList<Long> cache_receiver = new ArrayList<>();

    static {
        cache_receiver.add(0L);
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public s_send_gift_item() {
        this.giftCard = null;
        this.giftType = 0;
        this.receiver = null;
        this.giftItemId = 0L;
        this.content = "";
        this.isBack = true;
        this.isPrivate = true;
        this.url = "";
        this.isTiming = true;
        this.sendTime = "";
        this.arch = 0;
        this.s_back_id = "";
        this.clientIp = "";
        this.recv_source = 0;
        this.mapExt = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.giftCard = (s_gift_card) jceInputStream.read((JceStruct) cache_giftCard, 0, false);
        this.giftType = jceInputStream.read(this.giftType, 1, true);
        this.receiver = (ArrayList) jceInputStream.read((JceInputStream) cache_receiver, 2, true);
        this.giftItemId = jceInputStream.read(this.giftItemId, 3, true);
        this.content = jceInputStream.readString(4, false);
        this.isBack = jceInputStream.read(this.isBack, 5, false);
        this.isPrivate = jceInputStream.read(this.isPrivate, 6, false);
        this.url = jceInputStream.readString(7, false);
        this.isTiming = jceInputStream.read(this.isTiming, 8, false);
        this.sendTime = jceInputStream.readString(9, false);
        this.arch = jceInputStream.read(this.arch, 10, false);
        this.s_back_id = jceInputStream.readString(11, false);
        this.clientIp = jceInputStream.readString(12, false);
        this.recv_source = jceInputStream.read(this.recv_source, 13, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_gift_card s_gift_cardVar = this.giftCard;
        if (s_gift_cardVar != null) {
            jceOutputStream.write((JceStruct) s_gift_cardVar, 0);
        }
        jceOutputStream.write(this.giftType, 1);
        jceOutputStream.write((Collection) this.receiver, 2);
        jceOutputStream.write(this.giftItemId, 3);
        String str = this.content;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.isBack, 5);
        jceOutputStream.write(this.isPrivate, 6);
        String str2 = this.url;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
        jceOutputStream.write(this.isTiming, 8);
        String str3 = this.sendTime;
        if (str3 != null) {
            jceOutputStream.write(str3, 9);
        }
        jceOutputStream.write(this.arch, 10);
        String str4 = this.s_back_id;
        if (str4 != null) {
            jceOutputStream.write(str4, 11);
        }
        String str5 = this.clientIp;
        if (str5 != null) {
            jceOutputStream.write(str5, 12);
        }
        jceOutputStream.write(this.recv_source, 13);
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 14);
        }
    }

    public s_send_gift_item(s_gift_card s_gift_cardVar, int i3, ArrayList<Long> arrayList, long j3, String str, boolean z16, boolean z17, String str2, boolean z18, String str3, int i16, String str4, String str5, int i17, Map<String, String> map) {
        this.giftCard = s_gift_cardVar;
        this.giftType = i3;
        this.receiver = arrayList;
        this.giftItemId = j3;
        this.content = str;
        this.isBack = z16;
        this.isPrivate = z17;
        this.url = str2;
        this.isTiming = z18;
        this.sendTime = str3;
        this.arch = i16;
        this.s_back_id = str4;
        this.clientIp = str5;
        this.recv_source = i17;
        this.mapExt = map;
    }
}
