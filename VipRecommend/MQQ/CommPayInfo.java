package VipRecommend.MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class CommPayInfo extends JceStruct {
    static ArrayList<PayParam> cache_payParams;
    static RecParam cache_recParam;
    public ArrayList<PayParam> payParams;
    public RecParam recParam;

    public CommPayInfo() {
        this.payParams = null;
        this.recParam = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_payParams == null) {
            cache_payParams = new ArrayList<>();
            cache_payParams.add(new PayParam());
        }
        this.payParams = (ArrayList) jceInputStream.read((JceInputStream) cache_payParams, 1, true);
        if (cache_recParam == null) {
            cache_recParam = new RecParam();
        }
        this.recParam = (RecParam) jceInputStream.read((JceStruct) cache_recParam, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.payParams, 1);
        jceOutputStream.write((JceStruct) this.recParam, 2);
    }

    public CommPayInfo(ArrayList<PayParam> arrayList, RecParam recParam) {
        this.payParams = arrayList;
        this.recParam = recParam;
    }
}
