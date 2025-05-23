package com.tenpay.realname.api.impl;

import com.tencent.mobileqq.qwallet.utils.g;
import com.tenpay.realname.RealNameSource;
import com.tenpay.realname.api.IRealNameSourceReportApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tenpay/realname/api/impl/RealNameSourceReportApiImpl;", "Lcom/tenpay/realname/api/IRealNameSourceReportApi;", "()V", "getCurrentNameSource", "Lcom/tenpay/realname/RealNameSource;", "setCurrentNameSource", "", RealNameSource.EXTRA_KEY_SOURCE, "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class RealNameSourceReportApiImpl implements IRealNameSourceReportApi {

    @NotNull
    private static final String KEY_CURRENT_PAY_SOURCE = "current_pay_source";

    @Override // com.tenpay.realname.api.IRealNameSourceReportApi
    @Nullable
    public RealNameSource getCurrentNameSource() {
        RealNameSource realNameSource = (RealNameSource) g.h(KEY_CURRENT_PAY_SOURCE, RealNameSource.class, new RealNameSource("0"));
        g.s(KEY_CURRENT_PAY_SOURCE);
        return realNameSource;
    }

    @Override // com.tenpay.realname.api.IRealNameSourceReportApi
    public void setCurrentNameSource(@Nullable RealNameSource realNameSource) {
        if (realNameSource != null) {
            g.p(KEY_CURRENT_PAY_SOURCE, realNameSource);
        } else {
            g.s(KEY_CURRENT_PAY_SOURCE);
        }
    }
}
