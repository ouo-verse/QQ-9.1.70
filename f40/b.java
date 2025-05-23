package f40;

import com.tencent.biz.qqcircle.immersive.manager.e;
import com.tencent.biz.richframework.order.IOrderElement;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public final class b {
    public static boolean a(IOrderElement iOrderElement) {
        int priority;
        List<IOrderElement> historyActivatedElementList = e.a().getHistoryActivatedElementList(iOrderElement);
        if (historyActivatedElementList == null) {
            return false;
        }
        for (int i3 = 0; i3 < historyActivatedElementList.size(); i3++) {
            IOrderElement iOrderElement2 = historyActivatedElementList.get(i3);
            if (iOrderElement2 != null && iOrderElement2 != iOrderElement && ((priority = iOrderElement2.getPriority()) == 101 || priority == 102 || priority == 103)) {
                return true;
            }
        }
        return false;
    }
}
