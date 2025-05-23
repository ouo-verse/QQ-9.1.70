package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MusicInfo extends JceStruct {
    public int type;
    public String xalbumpic_url;
    public boolean xexpire;
    public long xqusic_id;
    public String xqusic_mid;
    public int xsinger_id;
    public String xsinger_name;
    public String xsong_name;
    public String xsong_url;

    public MusicInfo() {
        this.xqusic_mid = "";
        this.xsong_name = "";
        this.xsinger_name = "";
        this.xexpire = true;
        this.xsong_url = "";
        this.xalbumpic_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.xqusic_mid = jceInputStream.readString(0, false);
        this.xqusic_id = jceInputStream.read(this.xqusic_id, 1, false);
        this.xsong_name = jceInputStream.readString(2, false);
        this.xsinger_id = jceInputStream.read(this.xsinger_id, 3, false);
        this.xsinger_name = jceInputStream.readString(4, false);
        this.xexpire = jceInputStream.read(this.xexpire, 5, false);
        this.xsong_url = jceInputStream.readString(6, false);
        this.type = jceInputStream.read(this.type, 7, false);
        this.xalbumpic_url = jceInputStream.readString(8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.xqusic_mid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.xqusic_id, 1);
        String str2 = this.xsong_name;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.xsinger_id, 3);
        String str3 = this.xsinger_name;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        jceOutputStream.write(this.xexpire, 5);
        String str4 = this.xsong_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        jceOutputStream.write(this.type, 7);
        String str5 = this.xalbumpic_url;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
    }

    public MusicInfo(String str, long j3, String str2, int i3, String str3, boolean z16, String str4, int i16, String str5) {
        this.xqusic_mid = str;
        this.xqusic_id = j3;
        this.xsong_name = str2;
        this.xsinger_id = i3;
        this.xsinger_name = str3;
        this.xexpire = z16;
        this.xsong_url = str4;
        this.type = i16;
        this.xalbumpic_url = str5;
    }
}
