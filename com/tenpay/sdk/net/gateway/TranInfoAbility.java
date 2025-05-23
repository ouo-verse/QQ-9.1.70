package com.tenpay.sdk.net.gateway;

import com.tenpay.sdk.net.gateway.data.TransInfoOutput;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import pl2.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tenpay/sdk/net/gateway/TranInfoAbility;", "Lpl2/g;", "Lcom/tenpay/sdk/net/gateway/data/TransInfoOutput;", "transInfoOutput", "", "handleTranInfo", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public interface TranInfoAbility extends g {
    void handleTranInfo(@Nullable TransInfoOutput transInfoOutput);
}
