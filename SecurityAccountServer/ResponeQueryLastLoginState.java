package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResponeQueryLastLoginState extends JceStruct {
    static ArrayList<LastLoginInfo> cache_lastLoginList;
    public long interval;
    public ArrayList<LastLoginInfo> lastLoginList;
    public long lastUsedFlag;
    public String mobileNo;
    public String nationCode;
    public long nextFlag;
    public long timeStamp;

    public ResponeQueryLastLoginState() {
        this.nextFlag = 0L;
        this.timeStamp = 0L;
        this.interval = 0L;
        this.lastLoginList = null;
        this.nationCode = "";
        this.mobileNo = "";
        this.lastUsedFlag = 1L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nextFlag = jceInputStream.read(this.nextFlag, 0, true);
        this.timeStamp = jceInputStream.read(this.timeStamp, 1, true);
        this.interval = jceInputStream.read(this.interval, 2, true);
        if (cache_lastLoginList == null) {
            cache_lastLoginList = new ArrayList<>();
            cache_lastLoginList.add(new LastLoginInfo());
        }
        this.lastLoginList = (ArrayList) jceInputStream.read((JceInputStream) cache_lastLoginList, 3, true);
        this.nationCode = jceInputStream.readString(4, true);
        this.mobileNo = jceInputStream.readString(5, true);
        this.lastUsedFlag = jceInputStream.read(this.lastUsedFlag, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nextFlag, 0);
        jceOutputStream.write(this.timeStamp, 1);
        jceOutputStream.write(this.interval, 2);
        jceOutputStream.write((Collection) this.lastLoginList, 3);
        jceOutputStream.write(this.nationCode, 4);
        jceOutputStream.write(this.mobileNo, 5);
        jceOutputStream.write(this.lastUsedFlag, 6);
    }

    public ResponeQueryLastLoginState(long j3, long j16, long j17, ArrayList<LastLoginInfo> arrayList, String str, String str2, long j18) {
        this.nextFlag = j3;
        this.timeStamp = j16;
        this.interval = j17;
        this.lastLoginList = arrayList;
        this.nationCode = str;
        this.mobileNo = str2;
        this.lastUsedFlag = j18;
    }
}
