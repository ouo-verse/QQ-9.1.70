package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RegisterHttpShortConnectionResp extends JceStruct {
    static ArrayList<RegisterHttpShortConnectionBusiPack> cache_vBusiPacks;
    static byte[] cache_vCookies;
    static byte[] cache_vSig;
    public byte bReloadSvrlist;
    public long uInterval;
    public ArrayList<RegisterHttpShortConnectionBusiPack> vBusiPacks;
    public byte[] vCookies;
    public byte[] vSig;

    public RegisterHttpShortConnectionResp() {
        this.vCookies = null;
        this.vBusiPacks = null;
        this.uInterval = 0L;
        this.vSig = null;
        this.bReloadSvrlist = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vCookies == null) {
            cache_vCookies = r0;
            byte[] bArr = {0};
        }
        this.vCookies = jceInputStream.read(cache_vCookies, 0, true);
        if (cache_vBusiPacks == null) {
            cache_vBusiPacks = new ArrayList<>();
            cache_vBusiPacks.add(new RegisterHttpShortConnectionBusiPack());
        }
        this.vBusiPacks = (ArrayList) jceInputStream.read((JceInputStream) cache_vBusiPacks, 1, true);
        this.uInterval = jceInputStream.read(this.uInterval, 2, false);
        if (cache_vSig == null) {
            cache_vSig = r0;
            byte[] bArr2 = {0};
        }
        this.vSig = jceInputStream.read(cache_vSig, 3, false);
        this.bReloadSvrlist = jceInputStream.read(this.bReloadSvrlist, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vCookies, 0);
        jceOutputStream.write((Collection) this.vBusiPacks, 1);
        jceOutputStream.write(this.uInterval, 2);
        byte[] bArr = this.vSig;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
        jceOutputStream.write(this.bReloadSvrlist, 4);
    }

    public RegisterHttpShortConnectionResp(byte[] bArr, ArrayList<RegisterHttpShortConnectionBusiPack> arrayList, long j3, byte[] bArr2, byte b16) {
        this.vCookies = bArr;
        this.vBusiPacks = arrayList;
        this.uInterval = j3;
        this.vSig = bArr2;
        this.bReloadSvrlist = b16;
    }
}
