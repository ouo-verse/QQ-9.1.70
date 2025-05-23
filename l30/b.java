package l30;

import com.tencent.biz.richframework.layoutinflater.RFWInflateType;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b implements RFWLayoutLoaderStrategy {
    @Override // com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy
    public RFWInflateType getInflateMode() {
        return RFWInflateType.ASYNC_LAYOUT_INFLATER_UI_FIRST;
    }
}
