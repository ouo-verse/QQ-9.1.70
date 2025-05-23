package com.tencent.mobileqq.selectmember.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/selectmember/api/IForwardMsgApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "captionForwardPreview", "Landroid/view/View;", "caller", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "directForwardMsg", "", "startForwardActivity", "Landroid/content/Context;", "qq-selectmember-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IForwardMsgApi extends QRouteApi {
    @Nullable
    View captionForwardPreview(@NotNull Activity caller, @NotNull Intent intent);

    void directForwardMsg(@NotNull Activity caller, @NotNull Intent intent);

    void startForwardActivity(@NotNull Context caller, @NotNull Intent intent);
}
