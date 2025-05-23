package com.tencent.mobileqq.transfile.api.impl;

import android.os.SystemClock;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/transfile/api/impl/HttpEngineServiceImpl;", "Lcom/tencent/mobileqq/transfile/api/IHttpEngineService;", "Lcom/tencent/mobileqq/transfile/api/impl/BaseNtHttpAdapter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cancelReq", "", "req", "Lcom/tencent/mobileqq/transfile/NetReq;", "onCreate", "appRuntime", "Lmqq/app/AppRuntime;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "sendReq", "sendReqSync", "Lcom/tencent/mobileqq/transfile/NetResp;", "Transfile_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class HttpEngineServiceImpl extends BaseNtHttpAdapter implements IHttpEngineService {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String TAG;

    public HttpEngineServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "NTHttp.AdapterImpl";
        }
    }

    @Override // com.tencent.mobileqq.transfile.api.impl.BaseNtHttpAdapter, com.tencent.mobileqq.transfile.api.IHttpEngineService
    public void cancelReq(@Nullable NetReq req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) req);
        } else {
            super.cancelReq(req);
        }
    }

    @Override // com.tencent.mobileqq.transfile.api.impl.BaseNtHttpAdapter
    @NotNull
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.TAG;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        } else {
            QLog.i(getTAG(), 1, "onCreate");
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.api.impl.BaseNtHttpAdapter, com.tencent.mobileqq.transfile.api.IHttpEngineService
    public void sendReq(@NotNull NetReq req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) req);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        req.taskStartTime = SystemClock.uptimeMillis();
        super.sendReq(req);
    }

    @Override // com.tencent.mobileqq.transfile.api.IHttpEngineService
    @NotNull
    public NetResp sendReqSync(@NotNull NetReq req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (NetResp) iPatchRedirector.redirect((short) 5, (Object) this, (Object) req);
        }
        Intrinsics.checkNotNullParameter(req, "req");
        req.taskStartTime = SystemClock.uptimeMillis();
        HttpNetReq httpNetReq = (HttpNetReq) req;
        b buildTask = buildTask(httpNetReq);
        return fillResult(buildTask, ((IHttpService) QRoute.api(IHttpService.class)).syncExecute(buildTask), httpNetReq);
    }
}
