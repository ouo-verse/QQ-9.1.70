package com.tencent.open.agent.auth.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import hp3.c;
import java.util.List;
import kotlin.Metadata;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\u0004H&J\"\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/open/agent/auth/api/IOpenAuthGameCenterPageReporter;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "reportPageShow", "reportBackClick", "reportConfirmClick", "reportRefuseClick", "reportBackDialogShow", "reportBackDialogConfirmClick", "reportBackDialogCancelClick", "", "Lhp3/c;", "gameAuthItemList", "recordGameAuthItemList", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {ProcessConstant.OPEN_SDK})
/* loaded from: classes22.dex */
public interface IOpenAuthGameCenterPageReporter extends QRouteApi {
    void recordGameAuthItemList(@Nullable Activity activity, @Nullable List<c> gameAuthItemList);

    void reportBackClick();

    void reportBackDialogCancelClick();

    void reportBackDialogConfirmClick();

    void reportBackDialogShow();

    void reportConfirmClick();

    void reportPageShow(@Nullable Activity activity);

    void reportRefuseClick();
}
