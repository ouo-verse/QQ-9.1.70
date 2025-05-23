package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AuthCodeReq extends JceStruct {
    static ArrayList<Long> cache_apps = new ArrayList<>();
    public long uin = 0;
    public String skey = "";
    public ArrayList<Long> apps = null;

    static {
        cache_apps.add(0L);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.skey = jceInputStream.readString(1, false);
        this.apps = (ArrayList) jceInputStream.read((JceInputStream) cache_apps, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.skey;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<Long> arrayList = this.apps;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }
}
