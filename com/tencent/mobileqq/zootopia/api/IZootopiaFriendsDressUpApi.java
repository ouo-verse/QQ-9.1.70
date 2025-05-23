package com.tencent.mobileqq.zootopia.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0003H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/IZootopiaFriendsDressUpApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getFilamentEnable", "", "openSingleFriendDressUp", "", "context", "Landroid/content/Context;", "friendUin", "", "pageSource", "", "setFilamentEnable", "enable", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes21.dex */
public interface IZootopiaFriendsDressUpApi extends QRouteApi {
    boolean getFilamentEnable();

    void openSingleFriendDressUp(@NotNull Context context, long friendUin, int pageSource);

    void setFilamentEnable(boolean enable);
}
