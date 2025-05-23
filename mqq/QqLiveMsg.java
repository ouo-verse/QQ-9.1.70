package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QqLiveMsg extends JceStruct {
    public String ShopPicUrl;
    public String ShopText;
    public String anchorUrl;
    public String anchorUrlMd5;
    public int isPreload;
    public int isShopEntrance;
    public String plus_text;
    public String recomm_room_schema;
    public String recomm_roomid;
    public String viewerUrl;
    public String viewerUrlMd5;

    public QqLiveMsg() {
        this.anchorUrl = "";
        this.anchorUrlMd5 = "";
        this.viewerUrl = "";
        this.viewerUrlMd5 = "";
        this.isPreload = 0;
        this.isShopEntrance = 0;
        this.ShopText = "";
        this.ShopPicUrl = "";
        this.plus_text = "";
        this.recomm_roomid = "";
        this.recomm_room_schema = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.anchorUrl = jceInputStream.readString(0, false);
        this.anchorUrlMd5 = jceInputStream.readString(1, false);
        this.viewerUrl = jceInputStream.readString(2, false);
        this.viewerUrlMd5 = jceInputStream.readString(3, false);
        this.isPreload = jceInputStream.read(this.isPreload, 4, false);
        this.isShopEntrance = jceInputStream.read(this.isShopEntrance, 5, false);
        this.ShopText = jceInputStream.readString(6, false);
        this.ShopPicUrl = jceInputStream.readString(7, false);
        this.plus_text = jceInputStream.readString(8, false);
        this.recomm_roomid = jceInputStream.readString(9, false);
        this.recomm_room_schema = jceInputStream.readString(10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.anchorUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.anchorUrlMd5;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.viewerUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.viewerUrlMd5;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        jceOutputStream.write(this.isPreload, 4);
        jceOutputStream.write(this.isShopEntrance, 5);
        String str5 = this.ShopText;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        String str6 = this.ShopPicUrl;
        if (str6 != null) {
            jceOutputStream.write(str6, 7);
        }
        String str7 = this.plus_text;
        if (str7 != null) {
            jceOutputStream.write(str7, 8);
        }
        String str8 = this.recomm_roomid;
        if (str8 != null) {
            jceOutputStream.write(str8, 9);
        }
        String str9 = this.recomm_room_schema;
        if (str9 != null) {
            jceOutputStream.write(str9, 10);
        }
    }

    public QqLiveMsg(String str, String str2, String str3, String str4, int i3, int i16, String str5, String str6, String str7, String str8, String str9) {
        this.anchorUrl = str;
        this.anchorUrlMd5 = str2;
        this.viewerUrl = str3;
        this.viewerUrlMd5 = str4;
        this.isPreload = i3;
        this.isShopEntrance = i16;
        this.ShopText = str5;
        this.ShopPicUrl = str6;
        this.plus_text = str7;
        this.recomm_roomid = str8;
        this.recomm_room_schema = str9;
    }
}
