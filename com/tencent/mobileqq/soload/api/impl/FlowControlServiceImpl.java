package com.tencent.mobileqq.soload.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.soload.api.IFlowControlService;
import com.tencent.mobileqq.soload.entity.ResourceLimit$HippyDownLoadAllowReq;
import com.tencent.mobileqq.soload.entity.ResourceLimit$HippyDownLoadAllowRsp;
import com.tencent.mobileqq.soload.entity.ResourceLimit$SoDownLoadAllowReq;
import com.tencent.mobileqq.soload.entity.ResourceLimit$SoDownLoadAllowRsp;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ4\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J4\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J4\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/soload/api/impl/FlowControlServiceImpl;", "Lcom/tencent/mobileqq/soload/api/IFlowControlService;", "", "url", "Lcom/tencent/mobileqq/soload/api/IFlowControlService$OnFlowControlListener;", "ls", "cmd", "", "data", "Lmqq/observer/BusinessObserver;", "observer", "", "reqFlowControl", "Landroid/os/Bundle;", "bundle", "", "isSuccess", "", "startTime", "processSoFlowCallback", "processHippyFlowCallback", "checkCanReqFlowControl", "getLimitTimeKey", "getHost", "reqSoFlowControl", "reqHippyFlowControl", "<init>", "()V", "Companion", "a", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class FlowControlServiceImpl implements IFlowControlService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int REPORT_TYPE_HIPPY = 1;
    private static final int REPORT_TYPE_SO = 0;

    @NotNull
    private static final String TAG = "SoLoadWidget.SoFlowControlService";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/soload/api/impl/FlowControlServiceImpl$a;", "", "", "REPORT_TYPE_HIPPY", "I", "REPORT_TYPE_SO", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.soload.api.impl.FlowControlServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20471);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlowControlServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean checkCanReqFlowControl(String url) {
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        com.tencent.mobileqq.soload.util.g gVar = com.tencent.mobileqq.soload.util.g.f288698a;
        Intrinsics.checkNotNull(url);
        long a16 = gVar.a(getLimitTimeKey(url));
        if (a16 > 0 && a16 > NetConnInfoCenter.getServerTimeMillis()) {
            QLog.e(TAG, 1, "[startDownload] is in limited time,just return,nextTime:" + a16 + ",url:" + url);
            return false;
        }
        if (a16 != 0) {
            gVar.c(getLimitTimeKey(url));
        }
        return true;
    }

    private final String getHost(String url) {
        try {
            String host = new URL(url).getHost();
            Intrinsics.checkNotNullExpressionValue(host, "URL(url).host");
            return host;
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return "";
        }
    }

    private final String getLimitTimeKey(String url) {
        return "key_limit_res_time_" + getHost(url);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void processHippyFlowCallback(Bundle bundle, boolean isSuccess, long startTime, IFlowControlService.OnFlowControlListener ls5, String url) {
        boolean z16;
        byte[] byteArray = bundle.getByteArray("data");
        int i3 = bundle.getInt(WadlProxyConsts.EXTRA_RESULT_CODE);
        long currentTimeMillis = System.currentTimeMillis() - startTime;
        int i16 = 1000;
        if (i3 == 1000 && isSuccess && byteArray != null) {
            if (byteArray.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                ResourceLimit$HippyDownLoadAllowRsp resourceLimit$HippyDownLoadAllowRsp = new ResourceLimit$HippyDownLoadAllowRsp();
                try {
                    resourceLimit$HippyDownLoadAllowRsp.mergeFrom(byteArray);
                    boolean z17 = resourceLimit$HippyDownLoadAllowRsp.success.get();
                    long j3 = resourceLimit$HippyDownLoadAllowRsp.next_time.get();
                    QLog.d(TAG, 2, "[processHippyFlowCallback] success:" + z17 + ",nextTime:" + j3 + ",cost:" + currentTimeMillis);
                    if (z17) {
                        if (ls5 != null) {
                            ls5.onSuccess(1000);
                        }
                    } else {
                        if (ls5 != null) {
                            i16 = -1000;
                            ls5.onLimited(-1000, j3);
                        }
                        if (j3 > 0) {
                            com.tencent.mobileqq.soload.util.g gVar = com.tencent.mobileqq.soload.util.g.f288698a;
                            Intrinsics.checkNotNull(url);
                            gVar.d(getLimitTimeKey(url), j3);
                        }
                    }
                    if (url == null) {
                        com.tencent.mobileqq.soload.util.h.j(url, i16, currentTimeMillis, 1);
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, th5, new Object[0]);
                    if (ls5 != null) {
                        ls5.onSuccess(1002);
                        return;
                    }
                    return;
                }
            }
        }
        QLog.d(TAG, 1, "[processHippyFlowCallback] failed,resultCode:" + i3);
        if (ls5 != null) {
            i16 = 1001;
            ls5.onSuccess(1001);
        }
        if (url == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void processSoFlowCallback(Bundle bundle, boolean isSuccess, long startTime, IFlowControlService.OnFlowControlListener ls5, String url) {
        boolean z16;
        byte[] byteArray = bundle.getByteArray("data");
        int i3 = bundle.getInt(WadlProxyConsts.EXTRA_RESULT_CODE);
        long currentTimeMillis = System.currentTimeMillis() - startTime;
        int i16 = 1000;
        if (i3 == 1000 && isSuccess && byteArray != null) {
            if (byteArray.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                ResourceLimit$SoDownLoadAllowRsp resourceLimit$SoDownLoadAllowRsp = new ResourceLimit$SoDownLoadAllowRsp();
                try {
                    resourceLimit$SoDownLoadAllowRsp.mergeFrom(byteArray);
                    boolean z17 = resourceLimit$SoDownLoadAllowRsp.success.get();
                    long j3 = resourceLimit$SoDownLoadAllowRsp.next_time.get();
                    QLog.d(TAG, 2, "[processSoFlowCallback] success:" + z17 + ",nextTime:" + j3 + ",cost:" + currentTimeMillis);
                    if (z17) {
                        if (ls5 != null) {
                            ls5.onSuccess(1000);
                        }
                    } else {
                        if (ls5 != null) {
                            i16 = -1000;
                            ls5.onLimited(-1000, j3);
                        }
                        if (j3 > 0) {
                            com.tencent.mobileqq.soload.util.g gVar = com.tencent.mobileqq.soload.util.g.f288698a;
                            Intrinsics.checkNotNull(url);
                            gVar.d(getLimitTimeKey(url), j3);
                        }
                    }
                    if (url == null) {
                        com.tencent.mobileqq.soload.util.h.j(url, i16, currentTimeMillis, 0);
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, th5, new Object[0]);
                    if (ls5 != null) {
                        ls5.onSuccess(1002);
                        return;
                    }
                    return;
                }
            }
        }
        QLog.d(TAG, 1, "[processSoFlowCallback] failed,resultCode:" + i3);
        if (ls5 != null) {
            i16 = 1001;
            ls5.onSuccess(1001);
        }
        if (url == null) {
        }
    }

    private final void reqFlowControl(String url, IFlowControlService.OnFlowControlListener ls5, String cmd, byte[] data, BusinessObserver observer) {
        if (!checkCanReqFlowControl(url)) {
            if (ls5 != null) {
                ls5.onLimited(-1001, 0L);
                return;
            }
            return;
        }
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, com.tencent.mobileqq.soload.request.a.class);
        newIntent.putExtra("cmd", cmd);
        newIntent.putExtra("data", fh.b(data));
        newIntent.setObserver(observer);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            peekAppRuntime.startServlet(newIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reqHippyFlowControl$lambda$5$lambda$4$lambda$3(FlowControlServiceImpl this$0, long j3, IFlowControlService.OnFlowControlListener onFlowControlListener, String str, int i3, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(bundle, "bundle");
        this$0.processHippyFlowCallback(bundle, z16, j3, onFlowControlListener, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reqSoFlowControl$lambda$2$lambda$1$lambda$0(FlowControlServiceImpl this$0, long j3, IFlowControlService.OnFlowControlListener onFlowControlListener, String str, int i3, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(bundle, "bundle");
        this$0.processSoFlowCallback(bundle, z16, j3, onFlowControlListener, str);
    }

    @Override // com.tencent.mobileqq.soload.api.IFlowControlService
    public void reqHippyFlowControl(@Nullable final String url, @Nullable final IFlowControlService.OnFlowControlListener ls5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) url, (Object) ls5);
            return;
        }
        if (url != null) {
            ResourceLimit$HippyDownLoadAllowReq resourceLimit$HippyDownLoadAllowReq = new ResourceLimit$HippyDownLoadAllowReq();
            resourceLimit$HippyDownLoadAllowReq.resource_url.set(url);
            final long currentTimeMillis = System.currentTimeMillis();
            byte[] byteArray = resourceLimit$HippyDownLoadAllowReq.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray()");
            reqFlowControl(url, ls5, "trpc.gamecenter.resource_limit.ResourceLimit.SsoHippyDownLoadAllow", byteArray, new BusinessObserver() { // from class: com.tencent.mobileqq.soload.api.impl.c
                @Override // mqq.observer.BusinessObserver
                public final void onReceive(int i3, boolean z16, Bundle bundle) {
                    FlowControlServiceImpl.reqHippyFlowControl$lambda$5$lambda$4$lambda$3(FlowControlServiceImpl.this, currentTimeMillis, ls5, url, i3, z16, bundle);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.soload.api.IFlowControlService
    public void reqSoFlowControl(@Nullable final String url, @Nullable final IFlowControlService.OnFlowControlListener ls5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) url, (Object) ls5);
            return;
        }
        if (url != null) {
            ResourceLimit$SoDownLoadAllowReq resourceLimit$SoDownLoadAllowReq = new ResourceLimit$SoDownLoadAllowReq();
            resourceLimit$SoDownLoadAllowReq.resource_url.set(url);
            final long currentTimeMillis = System.currentTimeMillis();
            byte[] byteArray = resourceLimit$SoDownLoadAllowReq.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray()");
            reqFlowControl(url, ls5, "trpc.gamecenter.resource_limit.ResourceLimit.SsoSoDownLoadAllow", byteArray, new BusinessObserver() { // from class: com.tencent.mobileqq.soload.api.impl.b
                @Override // mqq.observer.BusinessObserver
                public final void onReceive(int i3, boolean z16, Bundle bundle) {
                    FlowControlServiceImpl.reqSoFlowControl$lambda$2$lambda$1$lambda$0(FlowControlServiceImpl.this, currentTimeMillis, ls5, url, i3, z16, bundle);
                }
            });
        }
    }
}
