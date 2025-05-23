package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AuthCodeRsp extends JceStruct {
    static ArrayList<AuthCodeItem> cache_items = new ArrayList<>();
    public ArrayList<AuthCodeItem> items = null;
    public long iNextReqTime = 0;

    static {
        cache_items.add(new AuthCodeItem());
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.items = (ArrayList) jceInputStream.read((JceInputStream) cache_items, 0, false);
        this.iNextReqTime = jceInputStream.read(this.iNextReqTime, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<AuthCodeItem> arrayList = this.items;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.iNextReqTime, 1);
    }
}
