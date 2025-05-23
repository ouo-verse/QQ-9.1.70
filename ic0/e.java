package ic0;

import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.tedger.outapi.beans.EdgeItem;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {
    public static void a(List<EdgeItem> list, String str, String str2) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            EdgeItem edgeItem = list.get(i3);
            if (edgeItem instanceof QFSEdgeItem) {
                ((QFSEdgeItem) edgeItem).plantRankMark(str, str2);
            }
        }
    }

    public static void b(List<EdgeItem> list, String str) {
        a(list, str, "edgererank=1");
    }
}
