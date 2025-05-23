package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetBroadCastHbIdiomReq extends JceStruct {
    static ArrayList<String> cache_billnos;
    public long appid;
    public ArrayList<String> billnos;
    public int fromType;
    public int platform;
    public String qqVersion;
    public String sKey;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_billnos = arrayList;
        arrayList.add("");
    }

    public GetBroadCastHbIdiomReq() {
        this.billnos = null;
        this.sKey = "";
        this.appid = 0L;
        this.fromType = 0;
        this.platform = 0;
        this.qqVersion = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.billnos = (ArrayList) jceInputStream.read((JceInputStream) cache_billnos, 0, false);
        this.sKey = jceInputStream.readString(1, false);
        this.appid = jceInputStream.read(this.appid, 2, false);
        this.fromType = jceInputStream.read(this.fromType, 3, false);
        this.platform = jceInputStream.read(this.platform, 4, false);
        this.qqVersion = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.billnos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.sKey;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.appid, 2);
        jceOutputStream.write(this.fromType, 3);
        jceOutputStream.write(this.platform, 4);
        String str2 = this.qqVersion;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
    }

    public GetBroadCastHbIdiomReq(ArrayList<String> arrayList, String str, long j3, int i3, int i16, String str2) {
        this.billnos = arrayList;
        this.sKey = str;
        this.appid = j3;
        this.fromType = i3;
        this.platform = i16;
        this.qqVersion = str2;
    }
}
