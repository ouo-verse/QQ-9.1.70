package com.tencent.qqnt.aio.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J:\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/api/IHorizontalMiniAIOApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getHorizontalMiniaioFragment", "Ljava/lang/Class;", "isForeGround", "", "navigateToHorizontalMiniaio", "", "context", "Landroid/content/Context;", "chatType", "", "uid", "", "nick", "extra", "Landroid/os/Bundle;", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IHorizontalMiniAIOApi extends QRouteApi {
    @NotNull
    Class<?> getHorizontalMiniaioFragment();

    boolean isForeGround();

    void navigateToHorizontalMiniaio(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, @Nullable Bundle extra);
}
