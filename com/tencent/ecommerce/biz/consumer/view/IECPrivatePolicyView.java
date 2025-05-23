package com.tencent.ecommerce.biz.consumer.view;

import android.view.View;
import com.tencent.ecommerce.repo.consumer.resp.GameInfo;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/IECPrivatePolicyView;", "", "configUI", "", "gameInfo", "Lcom/tencent/ecommerce/repo/consumer/resp/GameInfo;", "getView", "Landroid/view/View;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECPrivatePolicyView {
    void configUI(GameInfo gameInfo);

    View getView();
}
