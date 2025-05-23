package com.tencent.richframework.preload.activity;

import com.tencent.biz.richframework.layoutinflater.RFWInflateType;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/richframework/preload/activity/PredictLayoutLoadStrategy;", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutLoaderStrategy;", "()V", "getInflateMode", "Lcom/tencent/biz/richframework/layoutinflater/RFWInflateType;", "argus-preload_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class PredictLayoutLoadStrategy implements RFWLayoutLoaderStrategy {
    @Override // com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy
    @NotNull
    public RFWInflateType getInflateMode() {
        return RFWInflateType.ASYNC_LAYOUT_INFLATER_UI_FIRST;
    }
}
