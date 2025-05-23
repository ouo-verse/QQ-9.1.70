package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class RespBatchProcess extends JceStruct {
    static ArrayList<BatchResponse> cache_batch_response_list;
    public ArrayList<BatchResponse> batch_response_list;

    public RespBatchProcess() {
        this.batch_response_list = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_batch_response_list == null) {
            cache_batch_response_list = new ArrayList<>();
            cache_batch_response_list.add(new BatchResponse());
        }
        this.batch_response_list = (ArrayList) jceInputStream.read((JceInputStream) cache_batch_response_list, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<BatchResponse> arrayList = this.batch_response_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public RespBatchProcess(ArrayList<BatchResponse> arrayList) {
        this.batch_response_list = arrayList;
    }
}
