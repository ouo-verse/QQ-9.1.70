package com.tencent.mobileqq.aio.shop.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/aio/shop/api/IShopAIOApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getMsgPageCount", "", "getQQShopIs2Tab", "", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes11.dex */
public interface IShopAIOApi extends QRouteApi {
    int getMsgPageCount();

    boolean getQQShopIs2Tab();
}
