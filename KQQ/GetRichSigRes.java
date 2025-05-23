package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetRichSigRes extends JceStruct {
    static ArrayList<ResRichSigInfo> cache_vstSigInfo;
    public byte cResult;
    public ArrayList<ResRichSigInfo> vstSigInfo;

    public GetRichSigRes() {
        this.cResult = (byte) -1;
        this.vstSigInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cResult = jceInputStream.read(this.cResult, 1, true);
        if (cache_vstSigInfo == null) {
            cache_vstSigInfo = new ArrayList<>();
            cache_vstSigInfo.add(new ResRichSigInfo());
        }
        this.vstSigInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vstSigInfo, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cResult, 1);
        ArrayList<ResRichSigInfo> arrayList = this.vstSigInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public GetRichSigRes(byte b16, ArrayList<ResRichSigInfo> arrayList) {
        this.cResult = b16;
        this.vstSigInfo = arrayList;
    }
}
