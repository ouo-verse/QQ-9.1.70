package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BigDataChannel extends JceStruct {
    static byte[] cache_sBigdata_key_session;
    static byte[] cache_sBigdata_sig_session;
    static ArrayList<BigDataIpList> cache_vBigdata_iplists;
    static byte[] cache_vBigdata_pb_buf;
    public int iConnect_flag;
    public byte[] sBigdata_key_session;
    public byte[] sBigdata_sig_session;
    public long uSig_Uin;
    public ArrayList<BigDataIpList> vBigdata_iplists;
    public byte[] vBigdata_pb_buf;

    public BigDataChannel() {
        this.vBigdata_iplists = null;
        this.sBigdata_sig_session = null;
        this.sBigdata_key_session = null;
        this.uSig_Uin = 0L;
        this.iConnect_flag = 1;
        this.vBigdata_pb_buf = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vBigdata_iplists == null) {
            cache_vBigdata_iplists = new ArrayList<>();
            cache_vBigdata_iplists.add(new BigDataIpList());
        }
        this.vBigdata_iplists = (ArrayList) jceInputStream.read((JceInputStream) cache_vBigdata_iplists, 0, true);
        if (cache_sBigdata_sig_session == null) {
            cache_sBigdata_sig_session = r0;
            byte[] bArr = {0};
        }
        this.sBigdata_sig_session = jceInputStream.read(cache_sBigdata_sig_session, 1, false);
        if (cache_sBigdata_key_session == null) {
            cache_sBigdata_key_session = r0;
            byte[] bArr2 = {0};
        }
        this.sBigdata_key_session = jceInputStream.read(cache_sBigdata_key_session, 2, false);
        this.uSig_Uin = jceInputStream.read(this.uSig_Uin, 3, false);
        this.iConnect_flag = jceInputStream.read(this.iConnect_flag, 4, false);
        if (cache_vBigdata_pb_buf == null) {
            cache_vBigdata_pb_buf = r0;
            byte[] bArr3 = {0};
        }
        this.vBigdata_pb_buf = jceInputStream.read(cache_vBigdata_pb_buf, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vBigdata_iplists, 0);
        byte[] bArr = this.sBigdata_sig_session;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        byte[] bArr2 = this.sBigdata_key_session;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 2);
        }
        jceOutputStream.write(this.uSig_Uin, 3);
        jceOutputStream.write(this.iConnect_flag, 4);
        byte[] bArr3 = this.vBigdata_pb_buf;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 5);
        }
    }

    public BigDataChannel(ArrayList<BigDataIpList> arrayList, byte[] bArr, byte[] bArr2, long j3, int i3, byte[] bArr3) {
        this.vBigdata_iplists = arrayList;
        this.sBigdata_sig_session = bArr;
        this.sBigdata_key_session = bArr2;
        this.uSig_Uin = j3;
        this.iConnect_flag = i3;
        this.vBigdata_pb_buf = bArr3;
    }
}
