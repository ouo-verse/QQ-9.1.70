package com.tencent.mobileqq.qqlive.api.timi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/timi/ITimiAnchor;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAnchorRecordType", "", "insertJumpDestination", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "intent", "openTimiAnchorActivity", "", "qq-live-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface ITimiAnchor extends QRouteApi {
    int getAnchorRecordType();

    @NotNull
    Intent insertJumpDestination(@NotNull Context context, @NotNull Intent intent);

    void openTimiAnchorActivity(@NotNull Context context, @NotNull Intent intent);
}
