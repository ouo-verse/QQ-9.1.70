package com.tencent.mobileqq.wifiphoto.api.impl;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.exportfile.fragment.BaseExportFileFragment;
import com.tencent.mobileqq.exportfile.fragment.ExportFileErrorFragment;
import com.tencent.mobileqq.exportfile.global.QFileBridgeService;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifiphoto.IWifiPhotoTempApi;
import com.tencent.mobileqq.wifiphoto.api.IExportFileService;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.p;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSendFileBridgeRequestCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoPreCheckCallback;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoPreCheckInfo;
import com.tencent.util.LoadingUtil;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wifiphoto/api/impl/ExportFileServiceImpl;", "Lcom/tencent/mobileqq/wifiphoto/api/IExportFileService;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "internalEnterExportFile", "init", "disconnect", "registerAccountCallback", "enterExportFile", "<init>", "()V", "Companion", "a", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ExportFileServiceImpl implements IExportFileService {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static long lastClickTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wifiphoto/api/impl/ExportFileServiceImpl$a;", "", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wifiphoto.api.impl.ExportFileServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24872);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ExportFileServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enterExportFile$lambda$0(Context context, ExportFileServiceImpl this$0, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        if (((IWifiPhotoTempApi) QRoute.api(IWifiPhotoTempApi.class)).isPcLock()) {
            QQToast.makeText(context, "QQ\u5728\u7535\u8111\u4e0a\u5df2\u9501\u5b9a\uff0c\u8bf7\u89e3\u9501\u540e\u91cd\u8bd5", 0).show();
        } else {
            this$0.internalEnterExportFile(context, intent);
        }
    }

    private final void internalEnterExportFile(Context context, final Intent intent) {
        if (QFileBridgeService.f205517a.H()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.api.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    ExportFileServiceImpl.internalEnterExportFile$lambda$1(intent);
                }
            });
            return;
        }
        final Dialog createLoadingDialog = LoadingUtil.createLoadingDialog(context, "", false);
        createLoadingDialog.show();
        final p fileBridgeService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getFileBridgeService();
        if (fileBridgeService == null) {
            return;
        }
        fileBridgeService.preCheck(new IKernelWiFiPhotoPreCheckCallback() { // from class: com.tencent.mobileqq.wifiphoto.api.impl.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoPreCheckCallback
            public final void onResult(WiFiPhotoPreCheckInfo wiFiPhotoPreCheckInfo) {
                ExportFileServiceImpl.internalEnterExportFile$lambda$6(p.this, intent, createLoadingDialog, wiFiPhotoPreCheckInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void internalEnterExportFile$lambda$1(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$intent");
        intent.addFlags(536870912);
        intent.addFlags(268435456);
        intent.putExtra("FRAGMENT_INDEX", "/export_file/browser_file");
        QPublicFragmentActivity.start(BaseApplication.context, intent, BaseExportFileFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void internalEnterExportFile$lambda$6(p service, final Intent intent, final Dialog dialog, WiFiPhotoPreCheckInfo wiFiPhotoPreCheckInfo) {
        boolean z16;
        long longValue;
        boolean z17;
        Intrinsics.checkNotNullParameter(service, "$service");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        int i3 = 1;
        QLog.i("ExportFileServiceImpl", 1, "enterExportFile preCheck: " + wiFiPhotoPreCheckInfo.retCode + ", work: " + wiFiPhotoPreCheckInfo.retStr);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                dialog.dismiss();
            }
        });
        Long retCode = wiFiPhotoPreCheckInfo.getRetCode();
        boolean z18 = false;
        if (retCode != null && retCode.longValue() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String MODEL = DeviceInfoMonitor.getModel();
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            service.sendRequest(MODEL, new IKernelSendFileBridgeRequestCallback() { // from class: com.tencent.mobileqq.wifiphoto.api.impl.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSendFileBridgeRequestCallback
                public final void onResult(int i16, String str) {
                    ExportFileServiceImpl.internalEnterExportFile$lambda$6$lambda$3(i16, str);
                }
            });
            return;
        }
        intent.putExtra("FRAGMENT_INDEX", "/export_file/error");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Long retCode2 = wiFiPhotoPreCheckInfo.getRetCode();
        if (retCode2 == null) {
            longValue = -1;
        } else {
            Intrinsics.checkNotNullExpressionValue(retCode2, "preCheckInfo?.getRetCode() ?: -1");
            longValue = retCode2.longValue();
        }
        linkedHashMap.put(CheckForwardServlet.KEY_ERR_CODE, Long.valueOf(longValue));
        VideoReport.reportEvent("ev_bas_file_exception_reporting", linkedHashMap);
        Long retCode3 = wiFiPhotoPreCheckInfo.getRetCode();
        if (retCode3 != null && retCode3.longValue() == 100003) {
            i3 = 4;
        } else {
            if ((retCode3 != null && retCode3.longValue() == 100008) || (retCode3 != null && retCode3.longValue() == 100010)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                i3 = 6;
            } else {
                if ((retCode3 != null && retCode3.longValue() == 100009) || (retCode3 != null && retCode3.longValue() == 100014)) {
                    z18 = true;
                }
                if (z18) {
                    i3 = 5;
                }
            }
        }
        intent.putExtra(ExportFileErrorFragment.ERROR_TYPE, i3);
        intent.putExtra(ExportFileErrorFragment.ERROR_KEY, wiFiPhotoPreCheckInfo.compatWording);
        intent.addFlags(536870912);
        intent.addFlags(268435456);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                ExportFileServiceImpl.internalEnterExportFile$lambda$6$lambda$5(intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void internalEnterExportFile$lambda$6$lambda$3(int i3, String str) {
        QLog.i("ExportFileServiceImpl", 1, "sendRequest result: " + i3 + ", name: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void internalEnterExportFile$lambda$6$lambda$5(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$intent");
        QPublicFragmentActivity.start(BaseApplication.context, intent, BaseExportFileFragment.class);
    }

    @Override // com.tencent.mobileqq.wifiphoto.api.IExportFileService
    public void disconnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            QFileBridgeService.f205517a.x(10003);
        }
    }

    @Override // com.tencent.mobileqq.wifiphoto.api.IExportFileService
    public void enterExportFile(@NotNull final Context context, @NotNull final Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (System.currentTimeMillis() - lastClickTime <= 800) {
            lastClickTime = System.currentTimeMillis();
        } else {
            lastClickTime = System.currentTimeMillis();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    ExportFileServiceImpl.enterExportFile$lambda$0(context, this, intent);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.wifiphoto.api.IExportFileService
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            QFileBridgeService.f205517a.G();
        }
    }

    @Override // com.tencent.mobileqq.wifiphoto.api.IExportFileService
    public void registerAccountCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            QFileBridgeService.f205517a.K();
        }
    }
}
