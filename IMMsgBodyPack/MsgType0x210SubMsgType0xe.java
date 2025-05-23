package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MsgType0x210SubMsgType0xe extends JceStruct {
    public String str_msg;
    public long uint32_code;
    public long uint32_dst_app_id;
    public long uint32_dst_inst_id;
    public long uint32_operate;
    public long uint32_seq;
    public long uint32_src_app_id;
    public long uint32_src_inst_id;
    public long uint64_dst_uin;
    public long uint64_sessionid;

    public MsgType0x210SubMsgType0xe() {
        this.uint32_src_app_id = 0L;
        this.uint32_src_inst_id = 0L;
        this.uint32_dst_app_id = 0L;
        this.uint32_dst_inst_id = 0L;
        this.uint64_dst_uin = 0L;
        this.uint64_sessionid = 0L;
        this.uint32_operate = 0L;
        this.uint32_seq = 0L;
        this.uint32_code = 0L;
        this.str_msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uint32_src_app_id = jceInputStream.read(this.uint32_src_app_id, 0, false);
        this.uint32_src_inst_id = jceInputStream.read(this.uint32_src_inst_id, 1, false);
        this.uint32_dst_app_id = jceInputStream.read(this.uint32_dst_app_id, 2, false);
        this.uint32_dst_inst_id = jceInputStream.read(this.uint32_dst_inst_id, 3, false);
        this.uint64_dst_uin = jceInputStream.read(this.uint64_dst_uin, 4, false);
        this.uint64_sessionid = jceInputStream.read(this.uint64_sessionid, 5, false);
        this.uint32_operate = jceInputStream.read(this.uint32_operate, 6, false);
        this.uint32_seq = jceInputStream.read(this.uint32_seq, 7, false);
        this.uint32_code = jceInputStream.read(this.uint32_code, 8, false);
        this.str_msg = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uint32_src_app_id, 0);
        jceOutputStream.write(this.uint32_src_inst_id, 1);
        jceOutputStream.write(this.uint32_dst_app_id, 2);
        jceOutputStream.write(this.uint32_dst_inst_id, 3);
        jceOutputStream.write(this.uint64_dst_uin, 4);
        jceOutputStream.write(this.uint64_sessionid, 5);
        jceOutputStream.write(this.uint32_operate, 6);
        jceOutputStream.write(this.uint32_seq, 7);
        jceOutputStream.write(this.uint32_code, 8);
        String str = this.str_msg;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
    }

    public MsgType0x210SubMsgType0xe(long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28, long j29, String str) {
        this.uint32_src_app_id = j3;
        this.uint32_src_inst_id = j16;
        this.uint32_dst_app_id = j17;
        this.uint32_dst_inst_id = j18;
        this.uint64_dst_uin = j19;
        this.uint64_sessionid = j26;
        this.uint32_operate = j27;
        this.uint32_seq = j28;
        this.uint32_code = j29;
        this.str_msg = str;
    }
}
