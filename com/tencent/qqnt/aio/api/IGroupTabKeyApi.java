package com.tencent.qqnt.aio.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/aio/api/IGroupTabKeyApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getGroupTabKeys", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IGroupTabKeyApi extends QRouteApi {
    @NotNull
    ArrayList<String> getGroupTabKeys();
}
