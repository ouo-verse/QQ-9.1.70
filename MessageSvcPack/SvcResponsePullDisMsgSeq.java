package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class SvcResponsePullDisMsgSeq extends JceStruct {
    static ArrayList<stConfNumInfo> cache_vConfNumInfo;
    public byte cReplyCode;
    public String strResult;
    public ArrayList<stConfNumInfo> vConfNumInfo;

    public SvcResponsePullDisMsgSeq() {
        this.cReplyCode = (byte) 0;
        this.strResult = "";
        this.vConfNumInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cReplyCode = jceInputStream.read(this.cReplyCode, 0, true);
        this.strResult = jceInputStream.readString(1, true);
        if (cache_vConfNumInfo == null) {
            cache_vConfNumInfo = new ArrayList<>();
            cache_vConfNumInfo.add(new stConfNumInfo());
        }
        this.vConfNumInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vConfNumInfo, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cReplyCode, 0);
        jceOutputStream.write(this.strResult, 1);
        jceOutputStream.write((Collection) this.vConfNumInfo, 2);
    }

    public SvcResponsePullDisMsgSeq(byte b16, String str, ArrayList<stConfNumInfo> arrayList) {
        this.cReplyCode = b16;
        this.strResult = str;
        this.vConfNumInfo = arrayList;
    }
}
