package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetTroopMemberListResp extends JceStruct {
    static int cache_result;
    static ArrayList<stTroopMemberInfo> cache_vecTroopMember = new ArrayList<>();
    public long GroupCode;
    public long GroupUin;
    public long NextGetTime;
    public long NextUin;
    public short errorCode;
    public long office_mode;
    public int result;
    public long uin;
    public ArrayList<stTroopMemberInfo> vecTroopMember;

    static {
        cache_vecTroopMember.add(new stTroopMemberInfo());
        cache_result = 0;
    }

    public GetTroopMemberListResp() {
        this.uin = 0L;
        this.GroupCode = 0L;
        this.GroupUin = 0L;
        this.vecTroopMember = null;
        this.NextUin = 0L;
        this.result = 0;
        this.errorCode = (short) 0;
        this.office_mode = 0L;
        this.NextGetTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.GroupCode = jceInputStream.read(this.GroupCode, 1, true);
        this.GroupUin = jceInputStream.read(this.GroupUin, 2, true);
        this.vecTroopMember = (ArrayList) jceInputStream.read((JceInputStream) cache_vecTroopMember, 3, true);
        this.NextUin = jceInputStream.read(this.NextUin, 4, true);
        this.result = jceInputStream.read(this.result, 5, true);
        this.errorCode = jceInputStream.read(this.errorCode, 6, false);
        this.office_mode = jceInputStream.read(this.office_mode, 7, false);
        this.NextGetTime = jceInputStream.read(this.NextGetTime, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.GroupCode, 1);
        jceOutputStream.write(this.GroupUin, 2);
        jceOutputStream.write((Collection) this.vecTroopMember, 3);
        jceOutputStream.write(this.NextUin, 4);
        jceOutputStream.write(this.result, 5);
        jceOutputStream.write(this.errorCode, 6);
        jceOutputStream.write(this.office_mode, 7);
        jceOutputStream.write(this.NextGetTime, 8);
    }

    public GetTroopMemberListResp(long j3, long j16, long j17, ArrayList<stTroopMemberInfo> arrayList, long j18, int i3, short s16, long j19, long j26) {
        this.uin = j3;
        this.GroupCode = j16;
        this.GroupUin = j17;
        this.vecTroopMember = arrayList;
        this.NextUin = j18;
        this.result = i3;
        this.errorCode = s16;
        this.office_mode = j19;
        this.NextGetTime = j26;
    }
}
