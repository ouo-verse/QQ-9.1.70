package dn3;

import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.now.linkpkanchorplay.sso.request.GetLinkConfRequest;
import com.tencent.now.linkpkanchorplay.sso.request.SetLinkConfRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import dn3.c;
import g55.ab;
import g55.x;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a(ab abVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(a aVar, QQLiveResponse qQLiveResponse) {
        x xVar = (x) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && xVar != null) {
            AegisLogger.i("PK_Biz|PKSettingDataModel", "requestConfig success, rsp=" + xVar);
            aVar.a(xVar.f401402a);
            return;
        }
        AegisLogger.e("PK_Biz|PKSettingDataModel", "requestConfig", "error, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
        aVar.a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(QQLiveResponse qQLiveResponse) {
        if (qQLiveResponse.isFailed()) {
            AegisLogger.e("PK_Biz|PKSettingDataModel", "requestSetting", "error, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
            return;
        }
        AegisLogger.i("PK_Biz|PKSettingDataModel", "requestSetting success");
    }

    public void f(final a aVar) {
        if (aVar == null) {
            AegisLogger.i("PK_Biz|PKSettingDataModel", "requestConfig fail, callback is null");
            return;
        }
        AegisLogger.i("PK_Biz|PKSettingDataModel", "requestConfig");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new GetLinkConfRequest(), new ILiveNetRequest.Callback() { // from class: dn3.a
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                c.d(c.a.this, qQLiveResponse);
            }
        });
    }

    public void g(ab abVar) {
        AegisLogger.i("PK_Biz|PKSettingDataModel", "requestSetting setting=" + abVar);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new SetLinkConfRequest(abVar), new ILiveNetRequest.Callback() { // from class: dn3.b
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                c.e(qQLiveResponse);
            }
        });
    }

    public void c() {
    }
}
