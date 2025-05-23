package Sound;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UploadReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static byte[] cache_data;
    static byte[] cache_key_value;
    public int appid;
    public long client_ip;
    public byte[] data;
    public int format;
    public long key_type;
    public byte[] key_value;
    public long server_ip;
    public long uin;
    public int voice_length;

    public UploadReq() {
        this.uin = 0L;
        this.format = 0;
        this.appid = 0;
        this.data = null;
        this.voice_length = 0;
        this.client_ip = 0L;
        this.server_ip = 0L;
        this.key_type = 0L;
        this.key_value = null;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.uin, "uin");
        jceDisplayer.display(this.format, "format");
        jceDisplayer.display(this.appid, "appid");
        jceDisplayer.display(this.data, "data");
        jceDisplayer.display(this.voice_length, "voice_length");
        jceDisplayer.display(this.client_ip, "client_ip");
        jceDisplayer.display(this.server_ip, "server_ip");
        jceDisplayer.display(this.key_type, "key_type");
        jceDisplayer.display(this.key_value, "key_value");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        UploadReq uploadReq = (UploadReq) obj;
        if (!JceUtil.equals(this.uin, uploadReq.uin) || !JceUtil.equals(this.format, uploadReq.format) || !JceUtil.equals(this.appid, uploadReq.appid) || !JceUtil.equals(this.data, uploadReq.data) || !JceUtil.equals(this.voice_length, uploadReq.voice_length) || !JceUtil.equals(this.client_ip, uploadReq.client_ip) || !JceUtil.equals(this.server_ip, uploadReq.server_ip) || !JceUtil.equals(this.key_type, uploadReq.key_type) || !JceUtil.equals(this.key_value, uploadReq.key_value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.format = jceInputStream.read(this.format, 1, true);
        this.appid = jceInputStream.read(this.appid, 2, true);
        if (cache_data == null) {
            cache_data = r0;
            byte[] bArr = {0};
        }
        this.data = jceInputStream.read(cache_data, 3, true);
        this.voice_length = jceInputStream.read(this.voice_length, 4, true);
        this.client_ip = jceInputStream.read(this.client_ip, 5, false);
        this.server_ip = jceInputStream.read(this.server_ip, 6, false);
        this.key_type = jceInputStream.read(this.key_type, 7, false);
        if (cache_key_value == null) {
            cache_key_value = r0;
            byte[] bArr2 = {0};
        }
        this.key_value = jceInputStream.read(cache_key_value, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.format, 1);
        jceOutputStream.write(this.appid, 2);
        jceOutputStream.write(this.data, 3);
        jceOutputStream.write(this.voice_length, 4);
        jceOutputStream.write(this.client_ip, 5);
        jceOutputStream.write(this.server_ip, 6);
        jceOutputStream.write(this.key_type, 7);
        byte[] bArr = this.key_value;
        if (bArr != null) {
            jceOutputStream.write(bArr, 8);
        }
    }

    public UploadReq(long j3, int i3, int i16, byte[] bArr, int i17, long j16, long j17, long j18, byte[] bArr2) {
        this.uin = j3;
        this.format = i3;
        this.appid = i16;
        this.data = bArr;
        this.voice_length = i17;
        this.client_ip = j16;
        this.server_ip = j17;
        this.key_type = j18;
        this.key_value = bArr2;
    }
}
