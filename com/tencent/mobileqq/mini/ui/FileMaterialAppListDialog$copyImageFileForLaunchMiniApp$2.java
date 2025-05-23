package com.tencent.mobileqq.mini.ui;

import NS_MINI_FILE_MATERIAL.MiniAppFileMaterial$AppMaterialInfo;
import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qqmini.sdk.launcher.model.FileMaterialInfo;
import com.tencent.util.LoadingUtil;
import java.io.File;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/mini/ui/FileMaterialAppListDialog$copyImageFileForLaunchMiniApp$2", "Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;", "onAdded", "", "onPostRun", "onPreRun", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class FileMaterialAppListDialog$copyImageFileForLaunchMiniApp$2 implements ThreadExcutor.IThreadListener {
    final /* synthetic */ MiniAppFileMaterial$AppMaterialInfo $data;
    final /* synthetic */ FileMaterialAppListDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileMaterialAppListDialog$copyImageFileForLaunchMiniApp$2(FileMaterialAppListDialog fileMaterialAppListDialog, MiniAppFileMaterial$AppMaterialInfo miniAppFileMaterial$AppMaterialInfo) {
        this.this$0 = fileMaterialAppListDialog;
        this.$data = miniAppFileMaterial$AppMaterialInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPostRun$lambda$1(FileMaterialAppListDialog this$0, MiniAppFileMaterial$AppMaterialInfo data) {
        String str;
        String str2;
        String str3;
        File file;
        Activity activity;
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        str = this$0.mRealMimeType;
        str2 = this$0.mDescFileName;
        str3 = this$0.mDescFilePath;
        file = this$0.mFile;
        FileMaterialInfo fileMaterialInfo = new FileMaterialInfo(str, str2, str3, file.length());
        activity = this$0.mActivity;
        MiniAppLauncher.launchMiniAppByIdWithFile(activity, data.appid.get(), data.path.get(), data.f24954vt.get(), 1173, Collections.singletonList(fileMaterialInfo));
        dialog = this$0.mWaitDialog;
        if (dialog != null) {
            dialog2 = this$0.mWaitDialog;
            Intrinsics.checkNotNull(dialog2);
            if (dialog2.isShowing()) {
                dialog3 = this$0.mWaitDialog;
                Intrinsics.checkNotNull(dialog3);
                dialog3.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPreRun$lambda$0(FileMaterialAppListDialog this$0) {
        Activity activity;
        Dialog dialog;
        Dialog dialog2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        activity = this$0.mActivity;
        this$0.mWaitDialog = LoadingUtil.showLoadingDialogTipsRight(activity, false, true);
        dialog = this$0.mWaitDialog;
        Intrinsics.checkNotNull(dialog);
        View findViewById = dialog.findViewById(R.id.yt9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mWaitDialog!!.findViewBy\u2026qq.qqui.R.id.loading_tip)");
        ((TextView) findViewById).setText(R.string.xxq);
        dialog2 = this$0.mWaitDialog;
        Intrinsics.checkNotNull(dialog2);
        dialog2.show();
    }

    @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
    public void onPostRun() {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final FileMaterialAppListDialog fileMaterialAppListDialog = this.this$0;
        final MiniAppFileMaterial$AppMaterialInfo miniAppFileMaterial$AppMaterialInfo = this.$data;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.mini.ui.e
            @Override // java.lang.Runnable
            public final void run() {
                FileMaterialAppListDialog$copyImageFileForLaunchMiniApp$2.onPostRun$lambda$1(FileMaterialAppListDialog.this, miniAppFileMaterial$AppMaterialInfo);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
    public void onPreRun() {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final FileMaterialAppListDialog fileMaterialAppListDialog = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.mini.ui.f
            @Override // java.lang.Runnable
            public final void run() {
                FileMaterialAppListDialog$copyImageFileForLaunchMiniApp$2.onPreRun$lambda$0(FileMaterialAppListDialog.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
    public void onAdded() {
    }
}
