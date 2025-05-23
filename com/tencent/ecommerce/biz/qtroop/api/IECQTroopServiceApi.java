package com.tencent.ecommerce.biz.qtroop.api;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import si0.ECTroopInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/qtroop/api/IECQTroopServiceApi;", "", "", "Lsi0/a;", "getTroopList", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECQTroopServiceApi {
    @NotNull
    List<ECTroopInfo> getTroopList();
}
