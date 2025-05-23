package com.tencent.qqnt.aio.api;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001JB\u0010\u000b\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u0007j\u0006\u0012\u0002\b\u0003`\n0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J@\u0010\u0010\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\rj\u0002`\u000f0\u00042\u0006\u0010\u0003\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J6\u0010\u0012\u001a \u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u0007j\u0006\u0012\u0002\b\u0003`\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0005H&J4\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\rj\u0002`\u000f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0005H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/api/IInputBarAdornSuiteApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "host", "", "", "delegateIdList", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "getVBDelegateList", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "getVMDelegateList", "delegateId", "getVBDelegate", "getVMDelegate", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IInputBarAdornSuiteApi extends QRouteApi {
    @NotNull
    com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ?> getVBDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.b host, int delegateId);

    @NotNull
    List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ?>> getVBDelegateList(@NotNull com.tencent.mobileqq.aio.input.adorn.b host, @NotNull List<Integer> delegateIdList);

    @NotNull
    com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c> getVMDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.c host, int delegateId);

    @NotNull
    List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> getVMDelegateList(@NotNull com.tencent.mobileqq.aio.input.adorn.c host, @NotNull List<Integer> delegateIdList);
}
