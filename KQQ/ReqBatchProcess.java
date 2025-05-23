package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class ReqBatchProcess extends JceStruct {
    static ArrayList<BatchRequest> cache_batch_request_list;
    public ArrayList<BatchRequest> batch_request_list;

    public ReqBatchProcess() {
        this.batch_request_list = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_batch_request_list == null) {
            cache_batch_request_list = new ArrayList<>();
            cache_batch_request_list.add(new BatchRequest());
        }
        this.batch_request_list = (ArrayList) jceInputStream.read((JceInputStream) cache_batch_request_list, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<BatchRequest> arrayList = this.batch_request_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public ReqBatchProcess(ArrayList<BatchRequest> arrayList) {
        this.batch_request_list = arrayList;
    }
}
