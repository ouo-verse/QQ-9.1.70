package com.tencent.ecommerce.biz.wallet;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&\u00a2\u0006\u0002\u0010\tJ/\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007H&\u00a2\u0006\u0002\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/wallet/WalletRequestListener;", "", "onFail", "", "resCode", "", "result", "", "", "(Ljava/lang/Integer;Ljava/util/Map;)V", "onSucc", "", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface WalletRequestListener {
    void onFail(@Nullable Integer resCode, @Nullable Map<String, String> result);

    void onSucc(@Nullable Integer resCode, @Nullable Map<String, Boolean> result);
}
