package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GroupInfo extends JceStruct {
    public int friend_count;
    public byte groupId;
    public String groupname;
    public int online_friend_count;
    public byte seqid;
    public int sqqOnLine_count;

    public GroupInfo() {
        this.groupId = (byte) 0;
        this.groupname = "";
        this.friend_count = 0;
        this.online_friend_count = 0;
        this.seqid = (byte) 0;
        this.sqqOnLine_count = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.groupId = jceInputStream.read(this.groupId, 0, true);
        this.groupname = jceInputStream.readString(1, true);
        this.friend_count = jceInputStream.read(this.friend_count, 2, true);
        this.online_friend_count = jceInputStream.read(this.online_friend_count, 3, true);
        this.seqid = jceInputStream.read(this.seqid, 4, false);
        this.sqqOnLine_count = jceInputStream.read(this.sqqOnLine_count, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.groupId, 0);
        jceOutputStream.write(this.groupname, 1);
        jceOutputStream.write(this.friend_count, 2);
        jceOutputStream.write(this.online_friend_count, 3);
        jceOutputStream.write(this.seqid, 4);
        jceOutputStream.write(this.sqqOnLine_count, 5);
    }

    public GroupInfo(byte b16, String str, int i3, int i16, byte b17, int i17) {
        this.groupId = b16;
        this.groupname = str;
        this.friend_count = i3;
        this.online_friend_count = i16;
        this.seqid = b17;
        this.sqqOnLine_count = i17;
    }
}
