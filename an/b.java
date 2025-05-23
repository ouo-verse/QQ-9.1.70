package an;

import com.qzone.reborn.base.n;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class b extends n {
    /* JADX INFO: Access modifiers changed from: protected */
    public void M1(String str, boolean z16, BaseRequest baseRequest, long j3, String str2, boolean z17) {
        QLog.i(getLogTag(), 1, str + " responseLog onReceive: dispatch isSuccess:" + z16 + " | traceId:" + baseRequest.getTraceId() + " | seqId:" + baseRequest.getCurrentSeq() + " | cmdName:" + baseRequest.getCmdName() + " | retCode:" + j3 + " | retMessage:" + str2 + " | isLoadMore:" + z17);
    }
}
