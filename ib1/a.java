package ib1;

import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0000\u001a\u0006\u0010\u0003\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"", "c", "b", "a", "qqshop-feature-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class a {
    public static final int a() {
        return ((int) (b() * 0.56f)) + ViewUtils.dip2px(134.0f);
    }

    public static final int b() {
        return c() - ViewUtils.dip2px(30.0f);
    }

    public static final int c() {
        int fixedWidth = ((IHippySetting) QRoute.api(IHippySetting.class)).getFixedWidth(HippyQQConstants.ModuleName.QQ_SHOP);
        if (fixedWidth > 0) {
            return fixedWidth;
        }
        return MobileQQ.sMobileQQ.getResources().getDisplayMetrics().widthPixels;
    }
}
