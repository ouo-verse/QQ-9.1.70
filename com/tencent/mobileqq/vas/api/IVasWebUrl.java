package com.tencent.mobileqq.vas.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J7\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasWebUrl;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "key", "getUrl", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "originUrl", "block", "", "gotoLevelPage", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasWebUrl extends QRouteApi {
    @Nullable
    String getUrl(@NotNull String key);

    boolean gotoLevelPage(@NotNull Context context, @Nullable Function1<? super String, String> block);
}
