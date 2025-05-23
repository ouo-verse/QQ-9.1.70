package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class SvcResponsePullGroupMsgSeq extends JceStruct {
    static ArrayList<GroupInfo> cache_vGroupInfo;
    public byte cReplyCode;
    public String strResult;
    public ArrayList<GroupInfo> vGroupInfo;
    public short wGroupNum;

    public SvcResponsePullGroupMsgSeq() {
        this.cReplyCode = (byte) 0;
        this.strResult = "";
        this.wGroupNum = (short) 0;
        this.vGroupInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cReplyCode = jceInputStream.read(this.cReplyCode, 0, true);
        this.strResult = jceInputStream.readString(1, true);
        this.wGroupNum = jceInputStream.read(this.wGroupNum, 2, true);
        if (cache_vGroupInfo == null) {
            cache_vGroupInfo = new ArrayList<>();
            cache_vGroupInfo.add(new GroupInfo());
        }
        this.vGroupInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vGroupInfo, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cReplyCode, 0);
        jceOutputStream.write(this.strResult, 1);
        jceOutputStream.write(this.wGroupNum, 2);
        jceOutputStream.write((Collection) this.vGroupInfo, 3);
    }

    public SvcResponsePullGroupMsgSeq(byte b16, String str, short s16, ArrayList<GroupInfo> arrayList) {
        this.cReplyCode = b16;
        this.strResult = str;
        this.wGroupNum = s16;
        this.vGroupInfo = arrayList;
    }
}
