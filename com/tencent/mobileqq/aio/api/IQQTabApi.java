package com.tencent.mobileqq.aio.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\bJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/api/IQQTabApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "", "needReport", "Lcom/tencent/mobileqq/aio/api/IQQTabApi$a;", "getExpEntity", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IQQTabApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/aio/api/IQQTabApi$a;", "", "", "experimentGroupId", "", "isExperiment", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface a {
        boolean isExperiment(@NotNull String experimentGroupId);
    }

    @NotNull
    a getExpEntity(@NotNull String expName, boolean needReport);
}
