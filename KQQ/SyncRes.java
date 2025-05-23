package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SyncRes extends JceStruct {
    static SyncReqCookie cache_cookie;
    static ArrayList<InfoItem> cache_vecResPkg;
    public SyncReqCookie cookie;
    public byte result;
    public ArrayList<InfoItem> vecResPkg;

    public SyncRes() {
        this.result = (byte) 0;
        this.vecResPkg = null;
        this.cookie = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 0, true);
        if (cache_vecResPkg == null) {
            cache_vecResPkg = new ArrayList<>();
            cache_vecResPkg.add(new InfoItem());
        }
        this.vecResPkg = (ArrayList) jceInputStream.read((JceInputStream) cache_vecResPkg, 1, true);
        if (cache_cookie == null) {
            cache_cookie = new SyncReqCookie();
        }
        this.cookie = (SyncReqCookie) jceInputStream.read((JceStruct) cache_cookie, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.result, 0);
        jceOutputStream.write((Collection) this.vecResPkg, 1);
        SyncReqCookie syncReqCookie = this.cookie;
        if (syncReqCookie != null) {
            jceOutputStream.write((JceStruct) syncReqCookie, 2);
        }
    }

    public SyncRes(byte b16, ArrayList<InfoItem> arrayList, SyncReqCookie syncReqCookie) {
        this.result = b16;
        this.vecResPkg = arrayList;
        this.cookie = syncReqCookie;
    }
}
