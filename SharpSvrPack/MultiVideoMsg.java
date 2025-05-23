package SharpSvrPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MultiVideoMsg extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<Long> cache_to_uin;
    static byte[] cache_video_buff;
    public short csCmd;
    public long from_uin;
    public long msg_dataflag;
    public long msg_seq;
    public long msg_time;
    public long msg_type;
    public long msg_uid;
    public short subCmd;
    public ArrayList<Long> to_uin;
    public byte type;
    public byte ver;
    public byte[] video_buff;

    public MultiVideoMsg() {
        this.ver = (byte) 0;
        this.type = (byte) 0;
        this.csCmd = (short) 0;
        this.from_uin = 0L;
        this.to_uin = null;
        this.video_buff = null;
        this.subCmd = (short) 0;
        this.msg_uid = 0L;
        this.msg_seq = 0L;
        this.msg_type = 0L;
        this.msg_time = 0L;
        this.msg_dataflag = 0L;
    }

    public String className() {
        return "SharpSvrPack.MultiVideoMsg";
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
        jceDisplayer.display(this.ver, "ver");
        jceDisplayer.display(this.type, "type");
        jceDisplayer.display(this.csCmd, "csCmd");
        jceDisplayer.display(this.from_uin, ShortVideoConstants.FROM_UIN);
        jceDisplayer.display((Collection) this.to_uin, "to_uin");
        jceDisplayer.display(this.video_buff, "video_buff");
        jceDisplayer.display(this.subCmd, "subCmd");
        jceDisplayer.display(this.msg_uid, "msg_uid");
        jceDisplayer.display(this.msg_seq, "msg_seq");
        jceDisplayer.display(this.msg_type, QQHealthReportApiImpl.MSG_TYPE_KEY);
        jceDisplayer.display(this.msg_time, ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME);
        jceDisplayer.display(this.msg_dataflag, "msg_dataflag");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.ver, true);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple(this.csCmd, true);
        jceDisplayer.displaySimple(this.from_uin, true);
        jceDisplayer.displaySimple((Collection) this.to_uin, true);
        jceDisplayer.displaySimple(this.video_buff, true);
        jceDisplayer.displaySimple(this.subCmd, true);
        jceDisplayer.displaySimple(this.msg_uid, true);
        jceDisplayer.displaySimple(this.msg_seq, true);
        jceDisplayer.displaySimple(this.msg_type, true);
        jceDisplayer.displaySimple(this.msg_time, true);
        jceDisplayer.displaySimple(this.msg_dataflag, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        MultiVideoMsg multiVideoMsg = (MultiVideoMsg) obj;
        if (!JceUtil.equals(this.ver, multiVideoMsg.ver) || !JceUtil.equals(this.type, multiVideoMsg.type) || !JceUtil.equals(this.csCmd, multiVideoMsg.csCmd) || !JceUtil.equals(this.from_uin, multiVideoMsg.from_uin) || !JceUtil.equals(this.to_uin, multiVideoMsg.to_uin) || !JceUtil.equals(this.video_buff, multiVideoMsg.video_buff) || !JceUtil.equals(this.subCmd, multiVideoMsg.subCmd) || !JceUtil.equals(this.msg_uid, multiVideoMsg.msg_uid) || !JceUtil.equals(this.msg_seq, multiVideoMsg.msg_seq) || !JceUtil.equals(this.msg_type, multiVideoMsg.msg_type) || !JceUtil.equals(this.msg_time, multiVideoMsg.msg_time) || !JceUtil.equals(this.msg_dataflag, multiVideoMsg.msg_dataflag)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "SharpSvrPack.MultiVideoMsg";
    }

    public short getCsCmd() {
        return this.csCmd;
    }

    public long getFrom_uin() {
        return this.from_uin;
    }

    public long getMsg_dataflag() {
        return this.msg_dataflag;
    }

    public long getMsg_seq() {
        return this.msg_seq;
    }

    public long getMsg_time() {
        return this.msg_time;
    }

    public long getMsg_type() {
        return this.msg_type;
    }

    public long getMsg_uid() {
        return this.msg_uid;
    }

    public short getSubCmd() {
        return this.subCmd;
    }

    public ArrayList<Long> getTo_uin() {
        return this.to_uin;
    }

    public byte getType() {
        return this.type;
    }

    public byte getVer() {
        return this.ver;
    }

    public byte[] getVideo_buff() {
        return this.video_buff;
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
        this.ver = jceInputStream.read(this.ver, 0, true);
        this.type = jceInputStream.read(this.type, 1, true);
        this.csCmd = jceInputStream.read(this.csCmd, 2, true);
        this.from_uin = jceInputStream.read(this.from_uin, 3, true);
        if (cache_to_uin == null) {
            cache_to_uin = new ArrayList<>();
            cache_to_uin.add(0L);
        }
        this.to_uin = (ArrayList) jceInputStream.read((JceInputStream) cache_to_uin, 4, true);
        if (cache_video_buff == null) {
            cache_video_buff = r0;
            byte[] bArr = {0};
        }
        this.video_buff = jceInputStream.read(cache_video_buff, 5, true);
        this.subCmd = jceInputStream.read(this.subCmd, 6, true);
        this.msg_uid = jceInputStream.read(this.msg_uid, 7, true);
        this.msg_seq = jceInputStream.read(this.msg_seq, 8, true);
        this.msg_type = jceInputStream.read(this.msg_type, 9, true);
        this.msg_time = jceInputStream.read(this.msg_time, 10, true);
        this.msg_dataflag = jceInputStream.read(this.msg_dataflag, 11, false);
    }

    public void setCsCmd(short s16) {
        this.csCmd = s16;
    }

    public void setFrom_uin(long j3) {
        this.from_uin = j3;
    }

    public void setMsg_dataflag(long j3) {
        this.msg_dataflag = j3;
    }

    public void setMsg_seq(long j3) {
        this.msg_seq = j3;
    }

    public void setMsg_time(long j3) {
        this.msg_time = j3;
    }

    public void setMsg_type(long j3) {
        this.msg_type = j3;
    }

    public void setMsg_uid(long j3) {
        this.msg_uid = j3;
    }

    public void setSubCmd(short s16) {
        this.subCmd = s16;
    }

    public void setTo_uin(ArrayList<Long> arrayList) {
        this.to_uin = arrayList;
    }

    public void setType(byte b16) {
        this.type = b16;
    }

    public void setVer(byte b16) {
        this.ver = b16;
    }

    public void setVideo_buff(byte[] bArr) {
        this.video_buff = bArr;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ver, 0);
        jceOutputStream.write(this.type, 1);
        jceOutputStream.write(this.csCmd, 2);
        jceOutputStream.write(this.from_uin, 3);
        jceOutputStream.write((Collection) this.to_uin, 4);
        jceOutputStream.write(this.video_buff, 5);
        jceOutputStream.write(this.subCmd, 6);
        jceOutputStream.write(this.msg_uid, 7);
        jceOutputStream.write(this.msg_seq, 8);
        jceOutputStream.write(this.msg_type, 9);
        jceOutputStream.write(this.msg_time, 10);
        jceOutputStream.write(this.msg_dataflag, 11);
    }

    public MultiVideoMsg(byte b16, byte b17, short s16, long j3, ArrayList<Long> arrayList, byte[] bArr, short s17, long j16, long j17, long j18, long j19, long j26) {
        this.ver = b16;
        this.type = b17;
        this.csCmd = s16;
        this.from_uin = j3;
        this.to_uin = arrayList;
        this.video_buff = bArr;
        this.subCmd = s17;
        this.msg_uid = j16;
        this.msg_seq = j17;
        this.msg_type = j18;
        this.msg_time = j19;
        this.msg_dataflag = j26;
    }
}
