package com.tencent.mobileqq.exportfile.global;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qui.toast.QUIBottomToast;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.exportfile.fragment.BaseExportFileFragment;
import com.tencent.mobileqq.exportfile.fragment.ExportFileErrorFragment;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wifiphoto.api.IExportFileApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeAuthenticationType;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeClientState;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeDownloadState;
import com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetFileCallback;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoConnectionType;
import com.tencent.qqnt.kernel.nativeinterface.ah;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u000f\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001a\u0010\u0013\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u001c\u0010\u0015\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010\u001d\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u001f"}, d2 = {"com/tencent/mobileqq/exportfile/global/QFileBridgeService$listener$1", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelFileBridgeClientListener;", "onAuthenticationSuccess", "", "connType", "Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeAuthenticationType;", "onConnected", "Lcom/tencent/qqnt/kernel/nativeinterface/WiFiPhotoConnectionType;", "onDisconnected", "error", "", "onFileDownloadComplete", "fileId", "", "localFilePath", "onFileDownloadProgress", "current", "", "total", "onFileDownloadSpeed", "speed", "onFileDownloadStateChange", "state", "Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeDownloadState;", "onNeedHostSetPassword", "onNeedShowDownloadCompleteToast", "onNeedUserInputPassword", "onStateChange", "Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeClientState;", "onThumbDownloadComplete", "thumbFilePath", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class QFileBridgeService$listener$1 implements IKernelFileBridgeClientListener {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QFileBridgeService$listener$1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j() {
        QFileBridgeService.f205517a.J(true);
        BannerManager.l().K(com.tencent.mobileqq.banner.d.f200257j, 2);
        Intent intent = new Intent();
        intent.addFlags(536870912);
        intent.addFlags(268435456);
        intent.putExtra("FRAGMENT_INDEX", "/export_file/browser_file");
        QPublicFragmentActivity.start(BaseApplication.context, intent, BaseExportFileFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(int i3) {
        Activity topActivity;
        QFileBridgeService qFileBridgeService = QFileBridgeService.f205517a;
        qFileBridgeService.J(false);
        if (i3 != 10003 && i3 != 100107 && i3 != 100004 && (topActivity = Foreground.getTopActivity()) != null) {
            qFileBridgeService.Q(topActivity, i3);
        }
        BannerManager.l().N(com.tencent.mobileqq.banner.d.f200257j, 0, R.string.zw4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$intent");
        QPublicFragmentActivity.start(BaseApplication.context, intent, BaseExportFileFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m() {
        final Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            QUIBottomToast.Companion.b(QUIBottomToast.INSTANCE, topActivity, 2, topActivity.getString(R.string.zwq), "\u53bb\u67e5\u770b", new View.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.global.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFileBridgeService$listener$1.n(topActivity, view);
                }
            }, 0, 32, null).n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Activity activity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(activity, "$activity");
        ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).openMyFile(activity);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$intent");
        QPublicFragmentActivity.start(BaseApplication.context, intent, BaseExportFileFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p() {
        BannerManager.l().N(com.tencent.mobileqq.banner.d.f200257j, 2, R.string.zwr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q() {
        BannerManager.l().N(com.tencent.mobileqq.banner.d.f200257j, 2, R.string.zw4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(String str, int i3, String str2) {
        FileManagerEntity fileManagerEntity;
        if (i3 == 0) {
            IExportFileApi iExportFileApi = (IExportFileApi) QRoute.api(IExportFileApi.class);
            Intrinsics.checkNotNull(str2);
            Object queryFileEntityByPath = iExportFileApi.queryFileEntityByPath(str2);
            if (queryFileEntityByPath instanceof FileManagerEntity) {
                fileManagerEntity = (FileManagerEntity) queryFileEntityByPath;
            } else {
                fileManagerEntity = null;
            }
            if (fileManagerEntity != null) {
                fileManagerEntity.strThumbPath = str;
                ((IExportFileApi) QRoute.api(IExportFileApi.class)).updateFileEntity(fileManagerEntity);
            }
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
    public void onAuthenticationSuccess(@NotNull FileBridgeAuthenticationType connType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) connType);
            return;
        }
        Intrinsics.checkNotNullParameter(connType, "connType");
        QLog.i("QFileBridgeService", 1, "onAuthenticationSuccess");
        QFileBridgeService.loginType = connType;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
    public void onConnected(@Nullable WiFiPhotoConnectionType connType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) connType);
            return;
        }
        QFileBridgeService qFileBridgeService = QFileBridgeService.f205517a;
        qFileBridgeService.P(false);
        qFileBridgeService.O(false);
        QLog.i("QFileBridgeService", 1, "onConnected connType: " + connType);
        QFileBridgeService.isBackgroundDisconnect = false;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.exportfile.global.i
            @Override // java.lang.Runnable
            public final void run() {
                QFileBridgeService$listener$1.j();
            }
        });
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new QFileBridgeService$listener$1$onConnected$2(connType, null), 3, null);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
    public void onDisconnected(final int error) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, error);
            return;
        }
        QLog.i("QFileBridgeService", 1, "onDisconnected error: " + error);
        if (!GuardManager.sInstance.isApplicationForeground()) {
            QFileBridgeService.isBackgroundDisconnect = true;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.exportfile.global.j
            @Override // java.lang.Runnable
            public final void run() {
                QFileBridgeService$listener$1.k(error);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new QFileBridgeService$listener$1$onDisconnected$2(error, null), 3, null);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
    public void onFileDownloadComplete(@Nullable String fileId, int error, @Nullable String localFilePath) {
        FileManagerEntity fileManagerEntity;
        CopyOnWriteArrayList<Function1> copyOnWriteArrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, fileId, Integer.valueOf(error), localFilePath);
            return;
        }
        QLog.d("QFileBridgeService", 1, "onFileDownloadComplete fileId: " + fileId + ",error: " + error + ",localFilePath: " + localFilePath);
        if (!TextUtils.isEmpty(localFilePath) && !TextUtils.isEmpty(fileId)) {
            IExportFileApi iExportFileApi = (IExportFileApi) QRoute.api(IExportFileApi.class);
            Intrinsics.checkNotNull(localFilePath);
            Object insertFileToFM = iExportFileApi.insertFileToFM(localFilePath);
            if (insertFileToFM instanceof FileManagerEntity) {
                fileManagerEntity = (FileManagerEntity) insertFileToFM;
            } else {
                fileManagerEntity = null;
            }
            copyOnWriteArrayList = QFileBridgeService.onDownloadFinishListenerList;
            for (Function1 function1 : copyOnWriteArrayList) {
                Intrinsics.checkNotNull(fileId);
                function1.invoke(new o(fileId, localFilePath, error, fileManagerEntity));
            }
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
    public void onFileDownloadProgress(@Nullable String fileId, long current, long total) {
        CopyOnWriteArrayList<Function1> copyOnWriteArrayList;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, fileId, Long.valueOf(current), Long.valueOf(total));
            return;
        }
        QLog.d("QFileBridgeService", 1, "onFileDownloadProgress fileId: " + fileId + ",current: " + current + ",total: " + total);
        if (!TextUtils.isEmpty(fileId)) {
            copyOnWriteArrayList = QFileBridgeService.onDownloadProgressListenerList;
            for (Function1 function1 : copyOnWriteArrayList) {
                if (fileId == null) {
                    str = "";
                } else {
                    str = fileId;
                }
                function1.invoke(new p(str, current, total));
            }
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
    public void onFileDownloadSpeed(@Nullable String fileId, long speed) {
        CopyOnWriteArrayList<Function1> copyOnWriteArrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, fileId, Long.valueOf(speed));
            return;
        }
        QLog.d("QFileBridgeService", 1, "onFileDownloadSpeed fileId: " + fileId + ",speed: " + speed);
        if (!TextUtils.isEmpty(fileId)) {
            copyOnWriteArrayList = QFileBridgeService.onDownloadSpeedListenerList;
            for (Function1 function1 : copyOnWriteArrayList) {
                Intrinsics.checkNotNull(fileId);
                function1.invoke(new q(fileId, speed));
            }
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
    public void onFileDownloadStateChange(@Nullable String fileId, @Nullable FileBridgeDownloadState state) {
        CopyOnWriteArrayList<Function1> copyOnWriteArrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) fileId, (Object) state);
            return;
        }
        QLog.d("QFileBridgeService", 1, "onFileDownloadStateChange fileId: " + fileId + ",state: " + state);
        if (!TextUtils.isEmpty(fileId) && state != null) {
            copyOnWriteArrayList = QFileBridgeService.onDownloadStateChangeListenerList;
            for (Function1 function1 : copyOnWriteArrayList) {
                Intrinsics.checkNotNull(fileId);
                function1.invoke(new r(fileId, state));
            }
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
    public void onNeedHostSetPassword() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("QFileBridgeService", 1, "onNeedHostSetPassword");
        final Intent intent = new Intent();
        intent.addFlags(536870912);
        intent.addFlags(268435456);
        intent.putExtra("FRAGMENT_INDEX", "/export_file/error");
        intent.putExtra(ExportFileErrorFragment.ERROR_TYPE, 2);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.exportfile.global.f
            @Override // java.lang.Runnable
            public final void run() {
                QFileBridgeService$listener$1.l(intent);
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
    public void onNeedShowDownloadCompleteToast() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.exportfile.global.g
                @Override // java.lang.Runnable
                public final void run() {
                    QFileBridgeService$listener$1.m();
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
    public void onNeedUserInputPassword() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.i("QFileBridgeService", 1, "onPeerSetPassword");
        final Intent intent = new Intent();
        intent.addFlags(536870912);
        intent.addFlags(268435456);
        intent.putExtra("FRAGMENT_INDEX", "/export_file/input_pwd");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.exportfile.global.m
            @Override // java.lang.Runnable
            public final void run() {
                QFileBridgeService$listener$1.o(intent);
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
    public /* synthetic */ void onReconnecting() {
        ah.k(this);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
    public /* synthetic */ void onSearchFolderForFiles(long j3, int i3, ArrayList arrayList) {
        ah.l(this, j3, i3, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
    public void onStateChange(@Nullable FileBridgeClientState state) {
        Runnable runnable;
        Runnable runnable2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        ah.m(this, state);
        QLog.i("QFileBridgeService", 1, "onStateChange : " + state);
        if (state == FileBridgeClientState.KFILETRANSFERING) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.exportfile.global.k
                @Override // java.lang.Runnable
                public final void run() {
                    QFileBridgeService$listener$1.p();
                }
            });
        }
        if (state == FileBridgeClientState.KCONNECTED) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.exportfile.global.l
                @Override // java.lang.Runnable
                public final void run() {
                    QFileBridgeService$listener$1.q();
                }
            });
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            runnable = QFileBridgeService.timeoutDisconnectTask;
            uIHandlerV2.removeCallbacks(runnable);
            Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
            runnable2 = QFileBridgeService.timeoutDisconnectTask;
            uIHandlerV22.postDelayed(runnable2, 900000L);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener
    public void onThumbDownloadComplete(@Nullable String fileId, int error, @Nullable final String thumbFilePath) {
        CopyOnWriteArrayList<Function1> copyOnWriteArrayList;
        com.tencent.qqnt.kernel.api.p pVar;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, fileId, Integer.valueOf(error), thumbFilePath);
            return;
        }
        QLog.d("QFileBridgeService", 1, "onThumbDownloadComplete fileId: " + fileId + ",error: " + error + ",thumbFilePath: " + thumbFilePath);
        if (!TextUtils.isEmpty(thumbFilePath) && !TextUtils.isEmpty(fileId)) {
            copyOnWriteArrayList = QFileBridgeService.onDownloadThumbnailFinishListenerList;
            for (Function1 function1 : copyOnWriteArrayList) {
                Intrinsics.checkNotNull(fileId);
                if (thumbFilePath == null) {
                    str = "";
                } else {
                    str = thumbFilePath;
                }
                function1.invoke(new o(fileId, str, error, null));
            }
            pVar = QFileBridgeService.service;
            if (pVar != null) {
                pVar.getFileLocalStoragePath(fileId, new IKernelGetFileCallback() { // from class: com.tencent.mobileqq.exportfile.global.h
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetFileCallback
                    public final void onResult(int i3, String str2) {
                        QFileBridgeService$listener$1.r(thumbFilePath, i3, str2);
                    }
                });
            }
        }
    }
}
