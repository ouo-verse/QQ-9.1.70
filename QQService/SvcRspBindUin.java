package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRspBindUin extends JceStruct {
    static ArrayList<BindUinResult> cache_vecResult;
    public ArrayList<BindUinResult> vecResult;

    public SvcRspBindUin() {
        this.vecResult = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vecResult == null) {
            cache_vecResult = new ArrayList<>();
            cache_vecResult.add(new BindUinResult());
        }
        this.vecResult = (ArrayList) jceInputStream.read((JceInputStream) cache_vecResult, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vecResult, 0);
    }

    public SvcRspBindUin(ArrayList<BindUinResult> arrayList) {
        this.vecResult = arrayList;
    }
}
