package j30;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QCircle/Inject_QCircleLayerFeedOuterInjectData.yml", version = 1)
    private static HashMap<String, Class<? extends b>> f409187a;

    static {
        HashMap<String, Class<? extends b>> hashMap = new HashMap<>();
        f409187a = hashMap;
        hashMap.put(HippyQQConstants.HIPPY_CHANNEL, l60.b.class);
    }

    public static List<b> a(c cVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Class<? extends b>> entry : f409187a.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    b newInstance = entry.getValue().newInstance();
                    newInstance.b(cVar);
                    arrayList.add(newInstance);
                } catch (Throwable th5) {
                    QLog.e("QFSLayerFeedOuterInjectDataFactory", 1, "createOuterInjectData reflect error: \u4e1a\u52a1ID=" + entry.getKey() + ", class=" + entry.getValue() + "\nerror: " + th5);
                }
            }
        }
        return arrayList;
    }
}
