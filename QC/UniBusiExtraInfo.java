package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniBusiExtraInfo extends JceStruct {
    public String faceHashId;
    public String headurl;
    public int isOnShelf;
    public String mallname;
    public String mallurl;
    public long sourceId;
    public String strxyjson;

    public UniBusiExtraInfo() {
        this.isOnShelf = 0;
        this.strxyjson = "";
        this.mallurl = "";
        this.mallname = "";
        this.faceHashId = "";
        this.headurl = "";
        this.sourceId = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.isOnShelf = jceInputStream.read(this.isOnShelf, 1, false);
        this.strxyjson = jceInputStream.readString(2, false);
        this.mallurl = jceInputStream.readString(3, false);
        this.mallname = jceInputStream.readString(4, false);
        this.faceHashId = jceInputStream.readString(5, false);
        this.headurl = jceInputStream.readString(6, false);
        this.sourceId = jceInputStream.read(this.sourceId, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.isOnShelf, 1);
        String str = this.strxyjson;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.mallurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.mallname;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.faceHashId;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        String str5 = this.headurl;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        jceOutputStream.write(this.sourceId, 7);
    }

    public UniBusiExtraInfo(int i3, String str, String str2, String str3, String str4, String str5, long j3) {
        this.isOnShelf = i3;
        this.strxyjson = str;
        this.mallurl = str2;
        this.mallname = str3;
        this.faceHashId = str4;
        this.headurl = str5;
        this.sourceId = j3;
    }
}
