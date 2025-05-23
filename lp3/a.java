package lp3;

import android.util.Log;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.ReqHead;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistant.common.jce.StatItem;
import com.tencent.tmassistant.common.jce.StatReportRequest;
import com.tencent.tmassistant.common.jce.StatReportResponse;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a extends mp3.a {

    /* renamed from: i, reason: collision with root package name */
    protected InterfaceC10743a f415352i = null;

    /* compiled from: P */
    /* renamed from: lp3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC10743a {
        void onStatReportFinish(int i3, StatReportRequest statReportRequest, StatReportResponse statReportResponse, int i16);
    }

    public int b(ArrayList<StatItem> arrayList) {
        StatReportRequest statReportRequest = new StatReportRequest();
        statReportRequest.data = arrayList;
        return a(statReportRequest);
    }

    public void c(InterfaceC10743a interfaceC10743a) {
        this.f415352i = interfaceC10743a;
    }

    @Override // com.tencent.tmassistantbase.network.PostHttpRequest
    protected void onFinished(byte[] bArr, byte[] bArr2, int i3) {
        int i16;
        byte[] bArr3;
        ReqHead reqHead;
        Log.i("StatReportHttpRequest", "errorCode: " + i3);
        Response unpackPackage = ProtocolPackage.unpackPackage(bArr2);
        Request unpackRequestPackage = ProtocolPackage.unpackRequestPackage(bArr);
        if (unpackRequestPackage != null && (reqHead = unpackRequestPackage.head) != null) {
            i16 = reqHead.requestId;
        } else {
            i16 = 0;
        }
        if (bArr2 == null && this.f415352i != null) {
            Log.i("StatReportHttpRequest", "response is null");
            this.f415352i.onStatReportFinish(i16, null, null, i3);
            return;
        }
        InterfaceC10743a interfaceC10743a = this.f415352i;
        if (interfaceC10743a != null) {
            if (unpackPackage != null && (bArr3 = unpackPackage.body) != null) {
                JceStruct unpageageJceResponse = ProtocolPackage.unpageageJceResponse(bArr3, (Class<? extends JceStruct>) StatReportResponse.class);
                if (unpageageJceResponse != null) {
                    if (i3 == 0) {
                        if (unpageageJceResponse instanceof StatReportResponse) {
                            StatReportResponse statReportResponse = (StatReportResponse) unpageageJceResponse;
                            int i17 = statReportResponse.ret;
                            if (i17 == 0) {
                                this.f415352i.onStatReportFinish(i16, null, statReportResponse, 0);
                            } else {
                                this.f415352i.onStatReportFinish(i16, null, statReportResponse, i17);
                            }
                        }
                    } else {
                        this.f415352i.onStatReportFinish(i16, null, null, i3);
                    }
                } else {
                    this.f415352i.onStatReportFinish(i16, null, null, i3);
                }
            } else {
                interfaceC10743a.onStatReportFinish(i16, null, null, i3);
            }
        }
        Log.i("StatReportHttpRequest", "exit");
    }
}
