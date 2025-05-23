package fm3;

import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.now.linkpkanchorplay.sso.request.InviteResponseRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import cooperation.qqcircle.report.QCircleLpReportDc05507;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f399869a = "";

    /* renamed from: b, reason: collision with root package name */
    private e55.a f399870b;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a(int i3, int i16, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(int i3, a aVar, QQLiveResponse qQLiveResponse) {
        if (qQLiveResponse.isFailed()) {
            AegisLogger.e("PK_Biz|AcceptInviteDataModel", "sendRequest", "fail, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg() + ", op=" + i3 + ", inviteId=" + this.f399869a);
            aVar.a(i3, -1, qQLiveResponse.getErrMsg());
            return;
        }
        AegisLogger.i("PK_Biz|AcceptInviteDataModel", "sendRequest", "success, op=" + i3 + ", inviteId=" + this.f399869a);
        aVar.a(i3, 0, "");
    }

    private void g(final int i3, final a aVar) {
        AegisLogger.i("PK_Biz|AcceptInviteDataModel", "sendRequest, op=" + i3 + ", inviteId=" + this.f399869a + ", from=" + c());
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new InviteResponseRequest(this.f399869a, i3), new ILiveNetRequest.Callback() { // from class: fm3.a
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                b.this.d(i3, aVar, qQLiveResponse);
            }
        });
    }

    public void b() {
        AegisLogger.i("PK_Biz|AcceptInviteDataModel", QCircleLpReportDc05507.KEY_CLEAR);
        this.f399870b = null;
    }

    public e55.a c() {
        return this.f399870b;
    }

    public void e(a aVar) {
        g(2, aVar);
    }

    public void f(int i3, a aVar) {
        g(i3, aVar);
    }

    public void h(String str, e55.a aVar) {
        AegisLogger.i("PK_Biz|AcceptInviteDataModel", "setAnchorInfo, inviteId=" + str + ", anchorInfo=" + c());
        this.f399869a = str;
        this.f399870b = aVar;
    }
}
