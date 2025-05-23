package com.tencent.mobileqq.qqexpand.utils;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH&J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/IEntryExtendForbiddenUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDialogMessage", "Landroid/text/SpannableStringBuilder;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "tip", "", "isForbidForever", "", "remainingTime", "", "isForbidden", "isNeedShowDiaLog", "context", "Landroid/content/Context;", "app", "Lmqq/app/AppRuntime;", "isNetSupport", "notifyFaceRealNameVerified", "", "showDialog", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IEntryExtendForbiddenUtils extends QRouteApi {
    @Nullable
    SpannableStringBuilder getDialogMessage(@Nullable Activity activity, @Nullable String tip, boolean isForbidForever, long remainingTime, boolean isForbidden);

    boolean isNeedShowDiaLog(@NotNull Context context, @NotNull AppRuntime app);

    boolean isNetSupport(@NotNull Context context);

    void notifyFaceRealNameVerified(@NotNull AppRuntime app);

    void showDialog(@NotNull Activity activity, @NotNull AppRuntime app);
}
