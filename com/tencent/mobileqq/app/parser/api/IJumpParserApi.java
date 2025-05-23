package com.tencent.mobileqq.app.parser.api;

import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/app/parser/api/IJumpParserApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/parser/av;", "getQZonePushParser", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IJumpParserApi extends QRouteApi {
    @NotNull
    Class<? extends av> getQZonePushParser();
}
