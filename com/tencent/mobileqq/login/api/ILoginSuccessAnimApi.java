package com.tencent.mobileqq.login.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import e72.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J$\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000bH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/login/api/ILoginSuccessAnimApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Le72/b;", "callback", "", "startLoginAnim", "", "fadeInDuration", "startSplashAnim", "", "isInSplashAnim", "isRunning", "setSplashAnimState", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes15.dex */
public interface ILoginSuccessAnimApi extends QRouteApi {
    boolean isInSplashAnim();

    void setSplashAnimState(boolean isRunning);

    void startLoginAnim(@NotNull Activity activity, @Nullable b callback);

    void startSplashAnim(@NotNull Activity activity, long fadeInDuration, @Nullable b callback);
}
