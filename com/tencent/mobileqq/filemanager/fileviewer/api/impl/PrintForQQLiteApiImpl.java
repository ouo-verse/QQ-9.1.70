package com.tencent.mobileqq.filemanager.fileviewer.api.impl;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.api.IPrintForQQLiteApi;
import com.tencent.mobileqq.filemanager.fileviewer.onlineprint.FilePrintChooseDialog;
import com.tencent.mobileqq.filemanager.fileviewer.onlineprint.g;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/filemanager/fileviewer/api/impl/PrintForQQLiteApiImpl;", "Lcom/tencent/mobileqq/filemanager/fileviewer/api/IPrintForQQLiteApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "entity", "Lcom/tencent/mobileqq/filemanager/fileviewer/onlineprint/g;", "bean", "Landroid/view/View$OnClickListener;", "clickListener", "", "isDisabledOnlinePrint", "", "showPrintDialog", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class PrintForQQLiteApiImpl implements IPrintForQQLiteApi {
    @Override // com.tencent.mobileqq.filemanager.fileviewer.api.IPrintForQQLiteApi
    public void showPrintDialog(@NotNull Activity activity, @NotNull FileManagerEntity entity, @NotNull g bean, @NotNull View.OnClickListener clickListener, boolean isDisabledOnlinePrint) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(bean, "bean");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        if (activity instanceof FragmentActivity) {
            new FilePrintChooseDialog(activity, entity, bean, clickListener, isDisabledOnlinePrint).show(((FragmentActivity) activity).getSupportFragmentManager(), "");
        }
    }
}
