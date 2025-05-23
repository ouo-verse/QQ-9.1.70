package com.tencent.mobileqq.filemanager.fileviewer.api;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.onlineprint.g;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/filemanager/fileviewer/api/IPrintForQQLiteApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "entity", "Lcom/tencent/mobileqq/filemanager/fileviewer/onlineprint/g;", "bean", "Landroid/view/View$OnClickListener;", "clickListener", "", "isDisabledOnlinePrint", "", "showPrintDialog", "qqfile-filebrowser-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IPrintForQQLiteApi extends QRouteApi {
    void showPrintDialog(@NotNull Activity activity, @NotNull FileManagerEntity entity, @NotNull g bean, @NotNull View.OnClickListener clickListener, boolean isDisabledOnlinePrint);
}
