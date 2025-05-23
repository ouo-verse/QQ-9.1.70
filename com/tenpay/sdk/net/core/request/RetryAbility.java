package com.tenpay.sdk.net.core.request;

import com.tencent.qphone.base.BaseConstants;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH&\u00a8\u0006\t"}, d2 = {"Lcom/tenpay/sdk/net/core/request/RetryAbility;", "", "forbidEcdhAes", "", "getCmd", "", TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, BaseConstants.ATTR_KET_EXTRA_MAP, "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public interface RetryAbility {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void retry$default(RetryAbility retryAbility, Map map, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    map = null;
                }
                retryAbility.retry(map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: retry");
        }
    }

    void forbidEcdhAes();

    @NotNull
    String getCmd();

    void retry(@Nullable Map<String, String> extraMap);
}
