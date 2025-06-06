package com.tencent.mobileqq.popanim.api;

import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/popanim/api/IVasApngIPCModuleApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isLoaded", "", "load", "", "adapter", "Lcom/tencent/image/URLDrawableHandler$Adapter;", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IVasApngIPCModuleApi extends QRouteApi {
    boolean isLoaded();

    void load(@NotNull URLDrawableHandler.Adapter adapter);
}
