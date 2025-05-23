package com.tencent.biz.pubaccount.accountdetail.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/pubaccount/accountdetail/api/IPublicAccountDataCardApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "startPublicAccountDataCardPage", "", "context", "Landroid/content/Context;", "params", "Landroid/content/Intent;", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountDataCardApi extends QRouteApi {
    void startPublicAccountDataCardPage(@NotNull Context context, @Nullable Intent params);
}
