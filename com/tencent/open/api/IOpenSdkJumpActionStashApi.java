package com.tencent.open.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/open/api/IOpenSdkJumpActionStashApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "passThroughParams", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "targetIntent", "Landroid/content/Intent;", "recordJumpAction", "intent", "restoreHandleJumpAction", "opensdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IOpenSdkJumpActionStashApi extends QRouteApi {
    void passThroughParams(@Nullable Activity activity, @Nullable Intent targetIntent);

    void recordJumpAction(@Nullable Intent intent);

    void restoreHandleJumpAction(@Nullable Activity activity);
}
