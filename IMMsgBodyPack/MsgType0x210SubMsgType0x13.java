package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MsgType0x210SubMsgType0x13 extends JceStruct {
    static byte[] cache_bytes_buf;
    public byte[] bytes_buf;
    public long uint32_dst_app_id;
    public long uint32_dst_inst_id;
    public long uint32_index;
    public long uint32_size;
    public long uint32_src_app_id;
    public long uint32_src_inst_id;
    public long uint32_type;
    public long uint64_dst_uin;
    public long uint64_sessionid;

    public MsgType0x210SubMsgType0x13() {
        this.uint32_src_app_id = 0L;
        this.uint32_src_inst_id = 0L;
        this.uint32_dst_app_id = 0L;
        this.uint32_dst_inst_id = 0L;
        this.uint64_dst_uin = 0L;
        this.uint64_sessionid = 0L;
        this.uint32_size = 0L;
        this.uint32_index = 0L;
        this.uint32_type = 0L;
        this.bytes_buf = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uint32_src_app_id = jceInputStream.read(this.uint32_src_app_id, 0, false);
        this.uint32_src_inst_id = jceInputStream.read(this.uint32_src_inst_id, 1, false);
        this.uint32_dst_app_id = jceInputStream.read(this.uint32_dst_app_id, 2, false);
        this.uint32_dst_inst_id = jceInputStream.read(this.uint32_dst_inst_id, 3, false);
        this.uint64_dst_uin = jceInputStream.read(this.uint64_dst_uin, 4, false);
        this.uint64_sessionid = jceInputStream.read(this.uint64_sessionid, 5, false);
        this.uint32_size = jceInputStream.read(this.uint32_size, 6, false);
        this.uint32_index = jceInputStream.read(this.uint32_index, 7, false);
        this.uint32_type = jceInputStream.read(this.uint32_type, 8, false);
        if (cache_bytes_buf == null) {
            cache_bytes_buf = r0;
            byte[] bArr = {0};
        }
        this.bytes_buf = jceInputStream.read(cache_bytes_buf, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uint32_src_app_id, 0);
        jceOutputStream.write(this.uint32_src_inst_id, 1);
        jceOutputStream.write(this.uint32_dst_app_id, 2);
        jceOutputStream.write(this.uint32_dst_inst_id, 3);
        jceOutputStream.write(this.uint64_dst_uin, 4);
        jceOutputStream.write(this.uint64_sessionid, 5);
        jceOutputStream.write(this.uint32_size, 6);
        jceOutputStream.write(this.uint32_index, 7);
        jceOutputStream.write(this.uint32_type, 8);
        byte[] bArr = this.bytes_buf;
        if (bArr != null) {
            jceOutputStream.write(bArr, 9);
        }
    }

    public MsgType0x210SubMsgType0x13(long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28, long j29, byte[] bArr) {
        this.uint32_src_app_id = j3;
        this.uint32_src_inst_id = j16;
        this.uint32_dst_app_id = j17;
        this.uint32_dst_inst_id = j18;
        this.uint64_dst_uin = j19;
        this.uint64_sessionid = j26;
        this.uint32_size = j27;
        this.uint32_index = j28;
        this.uint32_type = j29;
        this.bytes_buf = bArr;
    }
}
