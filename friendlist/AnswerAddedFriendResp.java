package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class AnswerAddedFriendResp extends JceStruct {
    static int cache_result;
    public String ErrorString;
    public long adduin;
    public short errorCode;
    public byte myfriendgroupid;
    public int result;
    public long uin;

    public AnswerAddedFriendResp() {
        this.uin = 0L;
        this.adduin = 0L;
        this.myfriendgroupid = (byte) 0;
        this.result = 0;
        this.errorCode = (short) 0;
        this.ErrorString = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.adduin = jceInputStream.read(this.adduin, 1, true);
        this.myfriendgroupid = jceInputStream.read(this.myfriendgroupid, 2, false);
        this.result = jceInputStream.read(this.result, 3, true);
        this.errorCode = jceInputStream.read(this.errorCode, 4, false);
        this.ErrorString = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.adduin, 1);
        jceOutputStream.write(this.myfriendgroupid, 2);
        jceOutputStream.write(this.result, 3);
        jceOutputStream.write(this.errorCode, 4);
        String str = this.ErrorString;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
    }

    public AnswerAddedFriendResp(long j3, long j16, byte b16, int i3, short s16, String str) {
        this.uin = j3;
        this.adduin = j16;
        this.myfriendgroupid = b16;
        this.result = i3;
        this.errorCode = s16;
        this.ErrorString = str;
    }
}
