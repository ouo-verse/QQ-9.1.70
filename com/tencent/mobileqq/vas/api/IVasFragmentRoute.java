package com.tencent.mobileqq.vas.api;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH&J\"\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasFragmentRoute;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "insertAvatarPendantInfo", "", "intent", "Landroid/content/Intent;", "pathList", "Ljava/util/ArrayList;", "", "openAvatarPendantShop", "context", "Landroid/app/Activity;", "from", "shareView", "Landroid/view/View;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasFragmentRoute extends QRouteApi {
    void insertAvatarPendantInfo(@NotNull Intent intent, @NotNull ArrayList<String> pathList);

    void openAvatarPendantShop(@NotNull Activity context, @NotNull String from);

    void openAvatarPendantShop(@NotNull Activity context, @NotNull String from, @Nullable View shareView);
}
