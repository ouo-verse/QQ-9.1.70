package com.tencent.upload.network.route;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.NetworkState;
import com.tencent.upload.network.route.IUploadRouteStrategy;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.StringUtils;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ServerRouteTable {
    static IPatchRedirector $redirector_ = null;
    public static final String IPLIST_TAG = "[iplist] ServerRouteTable";
    private static final String TAG = "ServerRouteTable";
    public final Const.BusinessType businessType;
    public final Const.ConnectType connectType;
    private UploadRoute defBakHostRoute;
    private UploadRoute defHostRoute;
    private final IRouteIPProvider ipProvider;
    public int sessionSize;
    public final Const.FileType supportFileType;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class PriorityPolicy {
        private static final /* synthetic */ PriorityPolicy[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final PriorityPolicy IPV4_FIRST;
        public static final PriorityPolicy IPV4_ONLY;
        public static final PriorityPolicy IPV6_FIRST;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11633);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            PriorityPolicy priorityPolicy = new PriorityPolicy("IPV6_FIRST", 0);
            IPV6_FIRST = priorityPolicy;
            PriorityPolicy priorityPolicy2 = new PriorityPolicy("IPV4_FIRST", 1);
            IPV4_FIRST = priorityPolicy2;
            PriorityPolicy priorityPolicy3 = new PriorityPolicy("IPV4_ONLY", 2);
            IPV4_ONLY = priorityPolicy3;
            $VALUES = new PriorityPolicy[]{priorityPolicy, priorityPolicy2, priorityPolicy3};
        }

        PriorityPolicy(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static PriorityPolicy valueOf(String str) {
            return (PriorityPolicy) Enum.valueOf(PriorityPolicy.class, str);
        }

        public static PriorityPolicy[] values() {
            return (PriorityPolicy[]) $VALUES.clone();
        }
    }

    public ServerRouteTable(Const.FileType fileType, Const.BusinessType businessType, Const.ConnectType connectType, IRouteIPProvider iRouteIPProvider) {
        this(fileType, businessType, connectType, iRouteIPProvider, null, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, fileType, businessType, connectType, iRouteIPProvider);
    }

    private final UploadRoute getBackupRoute() {
        UploadRoute jsonToUploadRoute;
        String bakIps = this.ipProvider.getBakIps();
        if (TextUtils.isEmpty(bakIps)) {
            UploadLog.e(TAG, "getBackupRoute return null!!");
            return null;
        }
        int currentOperatorCategory = UploadConfiguration.getCurrentOperatorCategory();
        if (currentOperatorCategory == 4) {
            int wifiOperatorCategory = UploadConfiguration.getWifiOperatorCategory();
            UploadLog.i(IPLIST_TAG, "getBackupRoute: currentOperatorCategory:" + currentOperatorCategory + " wifiOperatorCategory:" + wifiOperatorCategory + " " + bakIps);
            jsonToUploadRoute = jsonToUploadRoute(bakIps, wifiOperatorCategory, 2);
        } else {
            UploadLog.i(IPLIST_TAG, "getBackupRoute: currentOperatorCategory:" + currentOperatorCategory + " " + bakIps);
            jsonToUploadRoute = jsonToUploadRoute(bakIps, currentOperatorCategory, 2);
        }
        if (jsonToUploadRoute == null) {
            UploadLog.w(IPLIST_TAG, "getBackupRoute return null!!");
            return null;
        }
        jsonToUploadRoute.setRouteCategory(IUploadRouteStrategy.RouteCategoryType.BACKUP);
        UploadLog.i(IPLIST_TAG, "getBackupRoute: " + jsonToUploadRoute.toString());
        return jsonToUploadRoute;
    }

    private final UploadRoute getHostRoute() {
        String hostUrl = this.ipProvider.getHostUrl();
        if (TextUtils.isEmpty(hostUrl)) {
            UploadLog.w(IPLIST_TAG, "getHostRoute return null!!");
            return null;
        }
        UploadRoute uploadRoute = new UploadRoute(hostUrl, 80, IUploadRouteStrategy.RouteCategoryType.HOST);
        UploadLog.i(IPLIST_TAG, "getHostRoute: " + uploadRoute.toString());
        return uploadRoute;
    }

    private final UploadRoute getOptimumRoute() {
        IRouteIPProvider iRouteIPProvider = this.ipProvider;
        if (iRouteIPProvider == null) {
            return null;
        }
        String optIps = iRouteIPProvider.getOptIps();
        if (TextUtils.isEmpty(optIps)) {
            return null;
        }
        int currentOperatorCategory = UploadConfiguration.getCurrentOperatorCategory();
        UploadLog.i(IPLIST_TAG, "getOptimumRoute: currentOperatorCategory:" + currentOperatorCategory + " OptimumJsonString:" + optIps);
        UploadRoute jsonToUploadRoute = jsonToUploadRoute(optIps, currentOperatorCategory, 0);
        if (jsonToUploadRoute == null) {
            UploadLog.w(IPLIST_TAG, "getOptimumRoute: return null!!");
            return null;
        }
        jsonToUploadRoute.setRouteCategory(IUploadRouteStrategy.RouteCategoryType.OPTIMUM);
        UploadLog.i(IPLIST_TAG, "getOptimumRoute: " + jsonToUploadRoute.toString());
        return jsonToUploadRoute;
    }

    private List<UploadRoute> getV4UploadRoutes() {
        ArrayList arrayList = new ArrayList();
        UploadRoute optimumRoute = getOptimumRoute();
        if (optimumRoute != null) {
            arrayList.add(optimumRoute);
        }
        UploadRoute hostRoute = getHostRoute();
        if (hostRoute != null) {
            arrayList.add(hostRoute);
        }
        UploadRoute backupRoute = getBackupRoute();
        if (backupRoute != null && (optimumRoute == null || !optimumRoute.getIp().equals(backupRoute.getIp()) || !StringUtils.isIpv4String(optimumRoute.getIp()))) {
            arrayList.add(backupRoute);
        }
        if (arrayList.size() == 0) {
            UploadLog.e(TAG, "no routes...");
            UploadRoute uploadRoute = this.defHostRoute;
            if (uploadRoute != null) {
                arrayList.add(uploadRoute);
            }
            UploadRoute uploadRoute2 = this.defBakHostRoute;
            if (uploadRoute2 != null) {
                arrayList.add(uploadRoute2);
            }
        }
        return arrayList;
    }

    private final UploadRoute getV6HostRoute() {
        String v6HostUrl = this.ipProvider.getV6HostUrl();
        if (TextUtils.isEmpty(v6HostUrl)) {
            UploadLog.w(IPLIST_TAG, "getHostRoute:" + this + " return null!!");
            return null;
        }
        UploadRoute uploadRoute = new UploadRoute(v6HostUrl, 80, IUploadRouteStrategy.RouteCategoryType.HOST);
        UploadLog.i(IPLIST_TAG, "getHostRoute:" + this + " " + uploadRoute.toString());
        return uploadRoute;
    }

    private final UploadRoute getV6OptimumRoute() {
        IRouteIPProvider iRouteIPProvider = this.ipProvider;
        if (iRouteIPProvider == null) {
            return null;
        }
        String v6OptIps = iRouteIPProvider.getV6OptIps();
        if (TextUtils.isEmpty(v6OptIps)) {
            return null;
        }
        int currentOperatorCategory = UploadConfiguration.getCurrentOperatorCategory();
        UploadLog.i(IPLIST_TAG, "getV6OptimumRoute: currentOperatorCategory:" + currentOperatorCategory + " OptimumJsonString:" + v6OptIps);
        UploadRoute jsonToUploadRoute = jsonToUploadRoute(v6OptIps, currentOperatorCategory, 1);
        if (jsonToUploadRoute == null) {
            UploadLog.w(IPLIST_TAG, "getV6OptimumRoute: return null!!");
            return null;
        }
        jsonToUploadRoute.setRouteCategory(IUploadRouteStrategy.RouteCategoryType.OPTIMUM);
        UploadLog.i(IPLIST_TAG, "getV6OptimumRoute: " + jsonToUploadRoute.toString());
        return jsonToUploadRoute;
    }

    private List<UploadRoute> getV6UploadRoutes() {
        ArrayList arrayList = new ArrayList();
        UploadRoute v6OptimumRoute = getV6OptimumRoute();
        if (v6OptimumRoute != null) {
            arrayList.add(v6OptimumRoute);
        }
        UploadRoute v6HostRoute = getV6HostRoute();
        if (v6HostRoute != null) {
            arrayList.add(v6HostRoute);
        }
        return arrayList;
    }

    private static final UploadRoute jsonToUploadRoute(String str, int i3, int i16) {
        if (str != null && str.length() >= 1) {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("ips");
                int length = jSONArray.length();
                UploadRoute uploadRoute = null;
                for (int i17 = 0; i17 < length; i17++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i17);
                    int parseInt = Integer.parseInt(jSONObject.getString("apn"));
                    if (i3 == parseInt) {
                        if (!StringUtils.isIpv4String(jSONObject.getString("ip")) && !StringUtils.isIpv6String(jSONObject.getString("ip"))) {
                            return null;
                        }
                        return new UploadRoute(jSONObject.getString("ip"), jSONObject.getInt("port"), IUploadRouteStrategy.RouteCategoryType.OPTIMUM);
                    }
                    if (i16 == parseInt && uploadRoute == null) {
                        uploadRoute = new UploadRoute(jSONObject.getString("ip"), jSONObject.getInt("port"), IUploadRouteStrategy.RouteCategoryType.OPTIMUM);
                    }
                }
                return uploadRoute;
            } catch (Exception e16) {
                UploadLog.w(TAG, e16.toString());
            }
        }
        return null;
    }

    public String getSessionPoolKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.businessType + "-" + this.connectType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<UploadRoute> getUploadRoutes() {
        int networkStackTypeInner = NetworkState.getNetworkStackTypeInner();
        UploadLog.d(TAG, "getUploadRoutes stackType:" + networkStackTypeInner + " policy:" + this.ipProvider.getPriorityPolicy());
        ArrayList arrayList = new ArrayList();
        if (this.ipProvider.getPriorityPolicy() == PriorityPolicy.IPV4_FIRST) {
            if (networkStackTypeInner != 2) {
                arrayList.addAll(getV4UploadRoutes());
            }
            if (networkStackTypeInner == 2 || networkStackTypeInner == 3) {
                arrayList.addAll(getV6UploadRoutes());
            }
        } else if (this.ipProvider.getPriorityPolicy() == PriorityPolicy.IPV4_ONLY) {
            if (networkStackTypeInner != 2) {
                arrayList.addAll(getV4UploadRoutes());
            } else {
                UploadLog.w(TAG, "stackType:" + networkStackTypeInner + " only can load ipv6");
                arrayList.addAll(getV6UploadRoutes());
            }
        } else {
            if (networkStackTypeInner == 2 || networkStackTypeInner == 3) {
                arrayList.addAll(getV6UploadRoutes());
            }
            if (networkStackTypeInner != 2) {
                arrayList.addAll(getV4UploadRoutes());
            }
        }
        return arrayList;
    }

    public final String getV6HostString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        IRouteIPProvider iRouteIPProvider = this.ipProvider;
        if (iRouteIPProvider == null) {
            return null;
        }
        String v6HostUrl = iRouteIPProvider.getV6HostUrl();
        if (v6HostUrl == null) {
            UploadLog.w(TAG, "host == null!!!");
            return null;
        }
        return v6HostUrl;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer("ServerRouteTable{");
        stringBuffer.append("supportFileType=");
        stringBuffer.append(this.supportFileType);
        stringBuffer.append(", businessType=");
        stringBuffer.append(this.businessType);
        stringBuffer.append(", connectType=");
        stringBuffer.append(this.connectType);
        stringBuffer.append(", sessionSize=");
        stringBuffer.append(this.sessionSize);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public ServerRouteTable(Const.FileType fileType, Const.BusinessType businessType, Const.ConnectType connectType, IRouteIPProvider iRouteIPProvider, String str, String str2) {
        this(fileType, businessType, connectType, iRouteIPProvider, str, str2, 2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, fileType, businessType, connectType, iRouteIPProvider, str, str2);
    }

    public ServerRouteTable(Const.FileType fileType, Const.BusinessType businessType, Const.ConnectType connectType, IRouteIPProvider iRouteIPProvider, int i3) {
        this(fileType, businessType, connectType, iRouteIPProvider, null, null, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, fileType, businessType, connectType, iRouteIPProvider, Integer.valueOf(i3));
    }

    public ServerRouteTable(Const.FileType fileType, Const.BusinessType businessType, Const.ConnectType connectType, IRouteIPProvider iRouteIPProvider, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, fileType, businessType, connectType, iRouteIPProvider, str, str2, Integer.valueOf(i3));
            return;
        }
        this.sessionSize = 2;
        this.supportFileType = fileType;
        this.businessType = businessType;
        this.connectType = connectType;
        this.ipProvider = iRouteIPProvider;
        if (!TextUtils.isEmpty(str)) {
            this.defHostRoute = new UploadRoute(str, 80, IUploadRouteStrategy.RouteCategoryType.HOST);
        } else {
            this.defHostRoute = null;
        }
        if (!TextUtils.isEmpty(str)) {
            this.defBakHostRoute = new UploadRoute(str2, 80, IUploadRouteStrategy.RouteCategoryType.BACKUP);
        } else {
            this.defBakHostRoute = null;
        }
        this.sessionSize = i3;
    }
}
