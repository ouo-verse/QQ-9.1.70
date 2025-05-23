package com.tencent.mobileqq.vas.api;

import android.app.Activity;
import android.net.Uri;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&JB\u0010\f\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\t\u0018\u00010\u0012H&J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IDiyCardBgUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "enterSnapshot", "Landroid/net/Uri;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestCode", "", "jumpToCropForResult", "", "imagePath", "", "setCustomStyleAndBg", "filePath", "url", "styleId", "", "callback", "Lkotlin/Function1;", "", "uploadBackgroundToUps", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes20.dex */
public interface IDiyCardBgUtils extends QRouteApi {
    @Nullable
    Uri enterSnapshot(@Nullable Activity activity, int requestCode);

    void jumpToCropForResult(@NotNull Activity activity, int requestCode, @NotNull String imagePath);

    void setCustomStyleAndBg(@Nullable Activity activity, @NotNull String filePath, @NotNull String url, long styleId, @Nullable Function1<Object, Unit> callback);

    @Nullable
    Object uploadBackgroundToUps(@NotNull String str, @NotNull Continuation<? super String> continuation);
}
