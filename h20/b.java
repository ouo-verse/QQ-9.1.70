package h20;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleReport$SingleDcData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {
    public static QQCircleReport$SingleDcData a(byte[] bArr) {
        try {
            QQCircleReport$SingleDcData qQCircleReport$SingleDcData = new QQCircleReport$SingleDcData();
            qQCircleReport$SingleDcData.mergeFrom(bArr);
            return qQCircleReport$SingleDcData;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static List<QQCircleReport$SingleDcData> b(List<byte[]> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<byte[]> it = list.iterator();
        while (it.hasNext()) {
            QQCircleReport$SingleDcData a16 = a(it.next());
            if (a16 != null) {
                arrayList.add(a16);
            }
        }
        return arrayList;
    }
}
