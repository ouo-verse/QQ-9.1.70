package com.tencent.mobileqq.ark.share;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/ark/share/IShareArkViewApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createShareArkView", "Landroid/view/View;", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "getTemplateInfoByBundle", "", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IShareArkViewApi extends QRouteApi {
    @NotNull
    View createShareArkView(@NotNull Context context, @NotNull Bundle bundle);

    @NotNull
    Object getTemplateInfoByBundle(@NotNull Bundle bundle);
}
