package com.tencent.mobileqq.wink.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IWinkProfileThemeHelp;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "intentOrBundle", "", "addUseProfileThemeFlag", "Landroid/content/Context;", "context", "", "isWinkIndexAct", "Lh93/a;", "getWinkProfileTheme", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWinkProfileThemeHelp extends QRouteApi {
    void addUseProfileThemeFlag(@NotNull Object intentOrBundle);

    @NotNull
    h93.a getWinkProfileTheme(@NotNull Context context, boolean isWinkIndexAct);
}
