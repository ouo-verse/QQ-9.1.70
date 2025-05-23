package j30;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.guild.media.qcircle.k;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QCircle/Inject_QCircleLayerFeedOuterItemView.yml", version = 1)
    private static HashMap<String, Class<? extends d>> f409188a;

    static {
        HashMap<String, Class<? extends d>> hashMap = new HashMap<>();
        f409188a = hashMap;
        hashMap.put("10002", k.class);
        f409188a.put(HippyQQConstants.HIPPY_CHANNEL, k.class);
    }

    public static boolean a(int i3) {
        return f409188a.containsKey(String.valueOf(i3));
    }

    public static d b(int i3) {
        Class<? extends d> cls = f409188a.get(String.valueOf(i3));
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (Throwable th5) {
                QLog.e("QFSLayerFeedOuterInjectItemViewFactory", 1, "createItemView reflect error: feedType=" + i3 + ", itemViewClass=" + cls + "\nerror: " + th5);
            }
        }
        QLog.e("QFSLayerFeedOuterInjectItemViewFactory", 1, "createItemView return null feedType=" + i3);
        return null;
    }
}
