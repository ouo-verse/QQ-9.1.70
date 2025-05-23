package com.tencent.biz.richframework.video;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneIpConfigApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class RFWVideoDirectIPHelper {
    private static volatile RFWVideoDirectIPHelper sQFSDirectIpHelper;

    /* loaded from: classes5.dex */
    private static class IpBean {

        /* renamed from: ip, reason: collision with root package name */
        private String f95500ip;
        private String port;

        public String getIp() {
            return this.f95500ip;
        }

        public String getPort() {
            return this.port;
        }
    }

    protected RFWVideoDirectIPHelper() {
    }

    public static RFWVideoDirectIPHelper getInstance() {
        if (sQFSDirectIpHelper == null) {
            synchronized (RFWVideoDirectIPHelper.class) {
                if (sQFSDirectIpHelper == null) {
                    sQFSDirectIpHelper = new RFWVideoDirectIPHelper();
                }
            }
        }
        return sQFSDirectIpHelper;
    }

    private List<IpBean> getIpBeanList(String str, String str2) {
        try {
            return (List) ((Map) new Gson().fromJson(str, new TypeToken<Map<String, List<IpBean>>>() { // from class: com.tencent.biz.richframework.video.RFWVideoDirectIPHelper.1
            }.getType())).get(str2);
        } catch (Exception e16) {
            QLog.e("RFWVideoDirectIPHelper", 1, "exception is " + e16);
            return null;
        }
    }

    public List<String> getIpList(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String videoIpDirectConfigString = ((IQZoneIpConfigApi) QRoute.api(IQZoneIpConfigApi.class)).getVideoIpDirectConfigString(str, z16);
        if (TextUtils.isEmpty(videoIpDirectConfigString)) {
            return null;
        }
        QLog.i("RFWVideoDirectIPHelper", 1, "is https is " + z16 + ", ip json string is " + videoIpDirectConfigString);
        List<IpBean> ipBeanList = getIpBeanList(videoIpDirectConfigString, str);
        if (ipBeanList != null && ipBeanList.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (IpBean ipBean : ipBeanList) {
                arrayList.add(String.format("%s:%s", ipBean.getIp(), ipBean.getPort()));
            }
            return arrayList;
        }
        QLog.d("RFWVideoDirectIPHelper", 1, "get ip list failed, host = " + str);
        return null;
    }
}
