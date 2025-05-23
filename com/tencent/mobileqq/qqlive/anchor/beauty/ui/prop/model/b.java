package com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.model;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveGetPropListRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.util.ArrayList;
import org.light.LightVersionInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final IAegisLogApi f270523a;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
        void a(c cVar);

        void b(int i3, String str);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55138);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f270523a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(int i3, String str, a aVar) {
        if (aVar != null) {
            aVar.b(i3, str);
        }
    }

    private void c(kq4.c cVar, a aVar) {
        try {
            c cVar2 = new c();
            cVar2.f270524a = new ArrayList();
            int i3 = 0;
            while (true) {
                kq4.a[] aVarArr = cVar.f412875a;
                if (i3 >= aVarArr.length) {
                    break;
                }
                kq4.a aVar2 = aVarArr[i3];
                if (aVar2 != null) {
                    cVar2.f270524a.add(aVar2);
                }
                i3++;
            }
            if (aVar != null) {
                aVar.a(cVar2);
            }
        } catch (Exception e16) {
            f270523a.e("FetchLivePropListModel", "InvalidProtocolBufferNanoException e = " + e16.getMessage());
            if (aVar != null) {
                aVar.b(-1, "InvalidProtocolBufferNanoException");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(a aVar, QQLiveResponse qQLiveResponse) {
        f270523a.i("FetchLivePropListModel", "[requestLivePropList]errCode=" + qQLiveResponse.getRetCode() + ", msg=" + qQLiveResponse.getErrMsg());
        if (qQLiveResponse.isFailed() || qQLiveResponse.getRsp() == null) {
            b((int) qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg(), aVar);
        }
        c((kq4.c) qQLiveResponse.getRsp(), aVar);
    }

    public void e(final a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        String str = LightVersionInfo.VERSION_NAME;
        if (!TextUtils.isEmpty(LightVersionInfo.VERSION_NAME)) {
            String[] split = LightVersionInfo.VERSION_NAME.split("\\.");
            if (split.length > 3) {
                str = split[0] + "." + split[1] + "." + split[2];
            }
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetPropListRequest(str), new ILiveNetRequest.Callback() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.model.a
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                b.this.d(aVar, qQLiveResponse);
            }
        });
    }
}
