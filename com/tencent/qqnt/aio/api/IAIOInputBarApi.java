package com.tencent.qqnt.aio.api;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J2\u0010\t\u001a$\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0004j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAIOInputBarApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "host", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "getSendBtnCompactVB", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOInputBarApi extends QRouteApi {
    @NotNull
    com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> getSendBtnCompactVB(@NotNull com.tencent.mobileqq.aio.input.adorn.b host);
}
