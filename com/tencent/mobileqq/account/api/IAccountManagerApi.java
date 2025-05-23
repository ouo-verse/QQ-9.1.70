package com.tencent.mobileqq.account.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/account/api/IAccountManagerApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "startAccountManagerFragment", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "qqaccount-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes9.dex */
public interface IAccountManagerApi extends QRouteApi {
    void startAccountManagerFragment(@Nullable Context context, @Nullable Intent intent);
}
