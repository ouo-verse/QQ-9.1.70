package ic0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.utils.k;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static String a() {
        Map<String, String> d16 = k.d("tedgers2_global_config_0714");
        boolean f16 = k.f(d16);
        QLog.d("TEDGEQFS_EdgeRSConfig", 1, "[initTEdgeRSConfigExp] haveExpData: " + f16 + ",expAssignment:" + k.b("tedgers2_global_config_0714") + ",expName:" + k.c("tedgers2_global_config_0714"));
        if (f16 && d16.containsKey(DownloadInfo.spKey_Config)) {
            return d16.get(DownloadInfo.spKey_Config);
        }
        return null;
    }

    private static String b(String str) {
        Map<String, String> d16 = k.d(str);
        if (!k.f(d16)) {
            QLog.e("TEDGEQFS_EdgeRSConfig", 1, "getLayerConfig layerCode:" + str + ",expParamsMap is null");
            return null;
        }
        return d16.get(DownloadInfo.spKey_Config);
    }

    public static Map<String, String> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List asList = Arrays.asList(str.split("\\|"));
        if (asList.isEmpty()) {
            QLog.d("TEDGEQFS_EdgeRSConfig", 1, "[getLayerConfigMap] configLayerList is null");
            return null;
        }
        QLog.d("TEDGEQFS_EdgeRSConfig", 1, "[getLayerConfigMap] layerConfig:" + str);
        return d(asList);
    }

    private static Map<String, String> d(@NonNull List<String> list) {
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str = list.get(i3);
            if (!TextUtils.isEmpty(str)) {
                String b16 = b(str);
                if (TextUtils.isEmpty(b16)) {
                    QLog.w("TEDGEQFS_EdgeRSConfig", 1, "getLayerConfigMap load config error,layerName:" + str);
                } else {
                    k.j(k.c(str));
                }
                hashMap.put(str, b16);
            }
        }
        return hashMap;
    }
}
