package com.tencent.mobileqq.wink.api;

import android.content.Context;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH&J.\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u0007H&J,\u0010\u000f\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u000bH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IQQWinkLaunchReporter;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "reportBeforeStart", "", "context", "Landroid/content/Context;", "clientTraceId", "", IProfileCardConst.KEY_FROM_TYPE, "", "isNewIndex", "", "choiceIndex", "reportOnClick", "schemaUrl", "reportOnClickBroken", "errCode", "intercept", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IQQWinkLaunchReporter extends QRouteApi {
    void reportBeforeStart(@Nullable Context context, @NotNull String clientTraceId, int fromType, boolean isNewIndex, int choiceIndex);

    void reportOnClick(@Nullable Context context, @Nullable String clientTraceId, int fromType, @NotNull String schemaUrl);

    void reportOnClickBroken(@Nullable String clientTraceId, int fromType, @NotNull String errCode, boolean intercept);
}
