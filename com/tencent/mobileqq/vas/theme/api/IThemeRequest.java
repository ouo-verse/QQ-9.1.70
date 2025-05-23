package com.tencent.mobileqq.vas.theme.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/theme/api/IThemeRequest;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "setTheme", "", "reqBundle", "Landroid/os/Bundle;", "callback", "Lkotlin/Function3;", "", "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes20.dex */
public interface IThemeRequest extends QRouteApi {
    void setTheme(@NotNull Bundle reqBundle, @NotNull Function3<? super String, ? super Integer, ? super String, Unit> callback);
}
