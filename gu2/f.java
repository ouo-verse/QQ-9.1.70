package gu2;

import com.tencent.hippy.qq.api.IHippyAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f extends hv2.g {
    @Override // hv2.g
    public HippyImageLoader a() {
        return ((IHippyAdapter) QRoute.api(IHippyAdapter.class)).createImageLoader();
    }
}
