package com.tencent.mobileqq.aio.qwallet.api.impl;

import com.tencent.mobileqq.aio.qwallet.api.IQWalletAIOApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import kotlin.Metadata;
import sk2.QWalletHbCommonConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/aio/qwallet/api/impl/QWalletAIOApiImpl;", "Lcom/tencent/mobileqq/aio/qwallet/api/IQWalletAIOApi;", "()V", "isHbMsgMultiSelect", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class QWalletAIOApiImpl implements IQWalletAIOApi {
    @Override // com.tencent.mobileqq.aio.qwallet.api.IQWalletAIOApi
    public boolean isHbMsgMultiSelect() {
        return !((QWalletHbCommonConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_HB_COMMON_CONFIG, new QWalletHbCommonConfig(null, null, false, false, 15, null))).getHbHideSelect();
    }
}
