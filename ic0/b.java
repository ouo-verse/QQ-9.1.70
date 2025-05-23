package ic0;

import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.proto.TEdgeCommon$MapEntry;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    public static List<QFSEdgeItem> a(List<EdgeItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            EdgeItem edgeItem = list.get(i3);
            if (edgeItem instanceof QFSEdgeItem) {
                arrayList.add((QFSEdgeItem) edgeItem);
            }
        }
        return arrayList;
    }

    public static List<e30.b> b(List<EdgeItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            for (EdgeItem edgeItem : list) {
                if (edgeItem instanceof QFSEdgeItem) {
                    QFSEdgeItem qFSEdgeItem = (QFSEdgeItem) edgeItem;
                    if (qFSEdgeItem.getFeedBlockData() != null) {
                        arrayList.add(qFSEdgeItem.getFeedBlockData());
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<EdgeItem> c(List<e30.b> list, int i3) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            for (e30.b bVar : list) {
                if (bVar.g() != null) {
                    QFSEdgeItem qFSEdgeItem = new QFSEdgeItem(bVar, i3);
                    qFSEdgeItem.setFeedBlockData(bVar);
                    qFSEdgeItem.setTimeStamp(System.currentTimeMillis());
                    arrayList.add(qFSEdgeItem);
                }
            }
        }
        return arrayList;
    }

    public static TEdgeCommon$MapEntry d(String str, String str2) {
        TEdgeCommon$MapEntry tEdgeCommon$MapEntry = new TEdgeCommon$MapEntry();
        PBStringField pBStringField = tEdgeCommon$MapEntry.key;
        if (str == null) {
            str = "";
        }
        pBStringField.set(str);
        PBStringField pBStringField2 = tEdgeCommon$MapEntry.value;
        if (str2 == null) {
            str2 = "";
        }
        pBStringField2.set(str2);
        return tEdgeCommon$MapEntry;
    }
}
