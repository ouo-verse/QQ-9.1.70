package com.tencent.mobileqq.minigame.minigamecenter.utils;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.gamecenter.wadl.api.IQQGameDLService;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dq;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.app.api.ProcessConstant;
import nl0.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0012\u001a\u00020\u00022\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0010H\u0016J\u0006\u0010\u0013\u001a\u00020\u0002R\u0017\u0010\u0015\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/minigame/minigamecenter/utils/MiniBoxSystemInstallHelper;", "Lnl0/d;", "", "queryDownloadTask", "initDownloadManager", "", "packageName", "showInstallDialog", "appId", "start", "", "getBusinessId", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "wadlResult", "onWadlStatusChanged", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "wadlResults", "onQueryCallback", "destory", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Lcom/tencent/gamecenter/wadl/api/IQQGameDLService;", "mDownloadService", "Lcom/tencent/gamecenter/wadl/api/IQQGameDLService;", "Ljava/lang/String;", "<init>", "(Landroid/app/Activity;)V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniBoxSystemInstallHelper implements d {
    public static final long LIMIT_PACKAGE_SAVE_TIME = 259200000;
    private static final String TAG = "MiniBoxSystemInstallHel";
    private final Activity activity;
    private String appId;
    private IQQGameDLService mDownloadService;

    public MiniBoxSystemInstallHelper(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.appId = "";
        initDownloadManager();
    }

    private final void initDownloadManager() {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026a, ProcessConstant.MULTI)");
        IQQGameDLService iQQGameDLService = (IQQGameDLService) runtimeService;
        this.mDownloadService = iQQGameDLService;
        if (iQQGameDLService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDownloadService");
            iQQGameDLService = null;
        }
        iQQGameDLService.registerDownloadCallBack(this);
    }

    private final void queryDownloadTask() {
        IQQGameDLService iQQGameDLService = this.mDownloadService;
        if (iQQGameDLService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDownloadService");
            iQQGameDLService = null;
        }
        iQQGameDLService.doQueryAllTask(getBusinessId());
    }

    private final void showInstallDialog(final String packageName) {
        com.tencent.xaction.log.b.a(TAG, 4, "--->showInstallDialog packageName:" + packageName);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.minigame.minigamecenter.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxSystemInstallHelper.showInstallDialog$lambda$3(MiniBoxSystemInstallHelper.this, packageName);
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInstallDialog$lambda$3(final MiniBoxSystemInstallHelper this$0, final String packageName) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(packageName, "$packageName");
        QQCustomDialog a16 = dq.a(this$0.activity, 230, "\u6e29\u99a8\u63d0\u9192", BaseApplication.getContext().getString(R.string.xyt), R.string.xys, R.string.xyu, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.minigamecenter.utils.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MiniBoxSystemInstallHelper.showInstallDialog$lambda$3$lambda$1(MiniBoxSystemInstallHelper.this, packageName, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.minigamecenter.utils.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MiniBoxSystemInstallHelper.showInstallDialog$lambda$3$lambda$2(MiniBoxSystemInstallHelper.this, packageName, dialogInterface, i3);
            }
        });
        a16.setCancelable(false);
        if (this$0.activity.isFinishing()) {
            return;
        }
        a16.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInstallDialog$lambda$3$lambda$1(MiniBoxSystemInstallHelper this$0, String packageName, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(packageName, "$packageName");
        IQQGameDLService iQQGameDLService = this$0.mDownloadService;
        if (iQQGameDLService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDownloadService");
            iQQGameDLService = null;
        }
        iQQGameDLService.doInstallAction(this$0.getBusinessId(), packageName);
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInstallDialog$lambda$3$lambda$2(MiniBoxSystemInstallHelper this$0, String packageName, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(packageName, "$packageName");
        IQQGameDLService iQQGameDLService = this$0.mDownloadService;
        if (iQQGameDLService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDownloadService");
            iQQGameDLService = null;
        }
        iQQGameDLService.deleteDownload(this$0.getBusinessId(), packageName);
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    public final void destory() {
        IQQGameDLService iQQGameDLService = this.mDownloadService;
        if (iQQGameDLService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDownloadService");
            iQQGameDLService = null;
        }
        iQQGameDLService.unRegisterDownloadCallBack(this);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public int getBusinessId() {
        return 3;
    }

    public final void start(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        com.tencent.xaction.log.b.a(TAG, 4, "MiniBoxSystemInstallHelper start,appid" + appId);
        this.appId = appId;
        queryDownloadTask();
    }

    @Override // nl0.d
    public void onQueryCallback(ArrayList<WadlResult> wadlResults) {
        com.tencent.xaction.log.b.a(TAG, 4, "--->onQueryCallback " + (wadlResults != null ? Integer.valueOf(wadlResults.size()) : null));
        if (wadlResults != null) {
            for (WadlResult wadlResult : wadlResults) {
                int i3 = wadlResult.taskStatus;
                if (i3 != 6) {
                    if (i3 == 9) {
                        com.tencent.xaction.log.b.a(TAG, 4, "exceed time,install completed success:" + wadlResult + ".wadlParams.packageName");
                        IQQGameDLService iQQGameDLService = this.mDownloadService;
                        if (iQQGameDLService == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mDownloadService");
                            iQQGameDLService = null;
                        }
                        iQQGameDLService.deleteDownload(getBusinessId(), wadlResult.wadlParams.packageName);
                    }
                } else if (Intrinsics.areEqual(wadlResult.wadlParams.appId, this.appId)) {
                    com.tencent.xaction.log.b.a(TAG, 4, "showInstallDialog");
                    String str = wadlResult.wadlParams.packageName;
                    Intrinsics.checkNotNullExpressionValue(str, "it.wadlParams.packageName");
                    showInstallDialog(str);
                } else if (System.currentTimeMillis() - wadlResult.createTime > 259200000) {
                    com.tencent.xaction.log.b.a(TAG, 4, "exceed time,delete pakcage:" + wadlResult + ".wadlParams.packageName");
                    IQQGameDLService iQQGameDLService2 = this.mDownloadService;
                    if (iQQGameDLService2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDownloadService");
                        iQQGameDLService2 = null;
                    }
                    iQQGameDLService2.deleteDownload(getBusinessId(), wadlResult.wadlParams.packageName);
                }
            }
        }
    }

    @Override // nl0.d
    public void onWadlStatusChanged(WadlResult wadlResult) {
    }
}
