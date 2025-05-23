package hn1;

import com.tencent.biz.richframework.layoutinflater.RFWInflateType;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a implements RFWLayoutLoaderStrategy {
    @Override // com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy
    public RFWInflateType getInflateMode() {
        return RFWInflateType.ASYNC_LAYOUT_INFLATER_UI_FIRST;
    }
}
