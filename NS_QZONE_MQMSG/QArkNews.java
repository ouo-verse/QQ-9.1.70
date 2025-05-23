package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QArkNews extends JceStruct {
    public String content;
    public String img_url;
    public String jump_url;
    public String title;
    public int type;
    public String type_content;
    public long utime;

    public QArkNews() {
        this.type = 0;
        this.img_url = "";
        this.content = "";
        this.utime = 0L;
        this.jump_url = "";
        this.type_content = "";
        this.title = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        this.img_url = jceInputStream.readString(1, true);
        this.content = jceInputStream.readString(2, true);
        this.utime = jceInputStream.read(this.utime, 3, true);
        this.jump_url = jceInputStream.readString(4, true);
        this.type_content = jceInputStream.readString(5, true);
        this.title = jceInputStream.readString(6, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.img_url, 1);
        jceOutputStream.write(this.content, 2);
        jceOutputStream.write(this.utime, 3);
        jceOutputStream.write(this.jump_url, 4);
        jceOutputStream.write(this.type_content, 5);
        jceOutputStream.write(this.title, 6);
    }

    public QArkNews(int i3, String str, String str2, long j3, String str3, String str4, String str5) {
        this.type = i3;
        this.img_url = str;
        this.content = str2;
        this.utime = j3;
        this.jump_url = str3;
        this.type_content = str4;
        this.title = str5;
    }
}
