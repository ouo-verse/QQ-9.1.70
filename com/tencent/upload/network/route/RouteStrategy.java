package com.tencent.upload.network.route;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.NetworkState;
import com.tencent.upload.network.route.IUploadRouteStrategy;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RouteStrategy implements IUploadRouteStrategy {
    static IPatchRedirector $redirector_;
    protected final String TAG;

    @Deprecated
    protected boolean mCausedByApnChanged;
    protected List<Integer> mPorts;
    protected Iterator<Integer> mPortsIterator;
    protected RecentRouteRecord mRecentRouteRecord;
    protected List<UploadRoute> mRoutes;
    protected Iterator<UploadRoute> mRoutesIterator;
    private ServerRouteTable mServerRouteTable;
    private int mStackType;
    protected String mUsedApn;

    @Deprecated
    protected List<UsedRouteInfo> mUsedRouteInfos;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class UsedRouteInfo {
        static IPatchRedirector $redirector_;
        public final int routeFailureCode;
        public final UploadRoute usedRoute;

        public UsedRouteInfo(UploadRoute uploadRoute, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uploadRoute, i3);
            } else {
                this.usedRoute = uploadRoute;
                this.routeFailureCode = i3;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return String.format("[%1$s, %2$s]", this.usedRoute.toString(), Const.FailureCode.print(this.routeFailureCode));
        }
    }

    public RouteStrategy(ServerRouteTable serverRouteTable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) serverRouteTable);
            return;
        }
        String str = "RouteStrategy[" + hashCode() + "]";
        this.TAG = str;
        UploadLog.d(str, "create RouteStrategy...");
        this.mCausedByApnChanged = false;
        this.mUsedRouteInfos = new ArrayList();
        this.mServerRouteTable = serverRouteTable;
    }

    private void doInitParams() {
        this.mRoutes = getServerRouteTable().getUploadRoutes();
        this.mStackType = NetworkState.getNetworkStackTypeInner();
        List<UploadRoute> list = this.mRoutes;
        if (list != null && list.size() != 0) {
            List<Integer> uploadRoutePorts = RouteFactory.getUploadRoutePorts();
            this.mPorts = uploadRoutePorts;
            if (uploadRoutePorts != null && uploadRoutePorts.size() != 0) {
                this.mRoutesIterator = this.mRoutes.iterator();
                this.mPortsIterator = this.mPorts.iterator();
                StringBuffer stringBuffer = new StringBuffer(this.mRoutes.size());
                Iterator<UploadRoute> it = this.mRoutes.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next().toString() + " ");
                }
                UploadLog.d("[iplist] " + this.TAG, " doInitParams, all Route List:" + stringBuffer.toString() + ", all Port List:" + this.mPorts.toString());
                return;
            }
            throw new RuntimeException(this.TAG + " doInitParams, getUploadRoutePorts illegal");
        }
        throw new RuntimeException(this.TAG + " doInitParams, getUploadRoutes illegal");
    }

    private UploadRoute getAvailableRoute() {
        if (this.mRoutesIterator.hasNext() && this.mPortsIterator.hasNext()) {
            UploadRoute next = this.mRoutesIterator.next();
            next.setPort(this.mPortsIterator.next().intValue());
            UploadRoute recentRoute = getRecentRoute();
            if (recentRoute != null && recentRoute.isDuplicate(next)) {
                UploadLog.d(this.TAG, " getAvailableRoute isDuplicate with recent, matchNextRouteFormRouteTable:" + next.toString());
                return matchNextRouteFormRouteTable(next);
            }
            UploadLog.d(this.TAG, " getAvailableRoute return:" + next.toString());
            return next;
        }
        UploadLog.d(this.TAG, " getAvailableRoute return null");
        return null;
    }

    private UploadRoute getRecentRoute() {
        UploadRoute recentRoute;
        RecentRouteRecord recentRouteRecord = this.mRecentRouteRecord;
        if (recentRouteRecord == null || (recentRoute = recentRouteRecord.getRecentRoute()) == null) {
            return null;
        }
        UploadLog.d(this.TAG, " getRecentRoute: " + recentRoute.toString());
        return recentRoute;
    }

    private void loadRecentRouteRecord() {
        String recentRouteApnKey = UploadConfiguration.getRecentRouteApnKey();
        if (recentRouteApnKey == null) {
            UploadLog.d(this.TAG, " loadRecentRouteRecord, unknown key");
            if ("true".equals(UploadGlobalConfig.getConfig().loadAsString(Const.SwitchConfigKey.QQCIRCLE_UPLOAD_NOT_USE_WIFI_BSSID, "true"))) {
                this.mRecentRouteRecord = null;
                return;
            }
            return;
        }
        UploadLog.d(this.TAG, " loadRecentRouteRecord, recentApnKey:" + recentRouteApnKey);
        this.mRecentRouteRecord = new RecentRouteRecordStorage(getServerRouteTable()).getData(recentRouteApnKey);
    }

    private UploadRoute matchNextRouteFormRouteTable(UploadRoute uploadRoute) {
        UploadRoute uploadRoute2 = null;
        if (uploadRoute == null) {
            if (this.mRoutesIterator.hasNext()) {
                uploadRoute2 = this.mRoutesIterator.next();
            }
            UploadLog.d(this.TAG, "matchNextRouteFormRouteTable: lastRoute == null now = " + uploadRoute2);
            return uploadRoute2;
        }
        UploadRoute m286clone = uploadRoute.m286clone();
        UploadLog.d(this.TAG, "matchNextRouteFormRouteTable: currentRoute:" + m286clone);
        if (this.mPortsIterator.hasNext()) {
            m286clone.setPort(this.mPortsIterator.next().intValue());
            UploadLog.d(this.TAG, "matchNextRouteFormRouteTable: to next port" + m286clone);
            uploadRoute2 = m286clone;
        } else if (this.mRoutesIterator.hasNext()) {
            Iterator<Integer> it = this.mPorts.iterator();
            this.mPortsIterator = it;
            if (it.hasNext()) {
                uploadRoute2 = this.mRoutesIterator.next().m286clone();
                uploadRoute2.setPort(this.mPortsIterator.next().intValue());
                UploadLog.d(this.TAG, "matchNextRouteFormRouteTable: to next ip" + uploadRoute2);
            } else {
                UploadLog.w(this.TAG, "matchNextRouteFormRouteTable: to next ip, but no port. exception");
            }
        } else {
            UploadLog.d(this.TAG, "matchNextRouteFormRouteTable: finish, return null");
        }
        UploadRoute recentRoute = getRecentRoute();
        if (recentRoute != null && recentRoute.isDuplicate(uploadRoute2)) {
            UploadLog.d(this.TAG, "matchNextRouteFormRouteTable: isDuplicate with recent" + uploadRoute2.toString());
            return matchNextRouteFormRouteTable(uploadRoute2);
        }
        return uploadRoute2;
    }

    @Override // com.tencent.upload.network.route.IUploadRouteStrategy
    public ServerRouteTable getServerRouteTable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ServerRouteTable) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mServerRouteTable;
    }

    @Override // com.tencent.upload.network.route.IUploadRouteStrategy
    public boolean isApnChanged() {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        String str = this.mUsedApn;
        if (str == null) {
            if (UploadConfiguration.getCurrentApn() == null) {
                UploadLog.d(this.TAG, "isApnChanged... mUsedApn == null currentApn == null");
                return false;
            }
            UploadLog.d(this.TAG, "isApnChanged... mUsedApn == null currentApn:" + UploadConfiguration.getCurrentApn());
            return true;
        }
        if (str.compareToIgnoreCase(UploadConfiguration.getCurrentApn()) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (NetworkState.getNetworkStackTypeInner() != this.mStackType) {
            z17 = true;
        } else {
            z17 = false;
        }
        String str2 = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isApnChanged... mUsedApn:");
        sb5.append(this.mUsedApn);
        sb5.append(" currentApn:");
        sb5.append(UploadConfiguration.getCurrentApn());
        sb5.append(" mStackType:");
        sb5.append(this.mStackType);
        sb5.append(" currentStackType:");
        sb5.append(NetworkState.getNetworkStackTypeInner());
        sb5.append(" result:");
        if (!z16 && !z17) {
            z18 = false;
        } else {
            z18 = true;
        }
        sb5.append(z18);
        UploadLog.d(str2, sb5.toString());
        if (z16 || z17) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.upload.network.route.IUploadRouteStrategy
    public boolean isApnChangedForNext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.mUsedApn == null) {
            if (UploadConfiguration.getCurrentApn() == null) {
                UploadLog.d(this.TAG, "isApnChangedForNext... mUsedApn == null currentApn == null");
                return false;
            }
            UploadLog.d(this.TAG, "isApnChangedForNext... mUsedApn == null currentApn:" + UploadConfiguration.getCurrentApn());
            return true;
        }
        boolean isSwitchOn = UploadGlobalConfig.getConfig().isSwitchOn(Const.SwitchConfigKey.QQCIRCLE_ENABLE_NEW_CHANGE_STACKTYPE);
        UploadLog.d(this.TAG, "isApnChangedForNext... mUsedApn:" + this.mUsedApn + " currentApn:" + UploadConfiguration.getCurrentApn() + " mStackType:" + this.mStackType + " currentStackType:" + NetworkState.getNetworkStackTypeInner() + " useNewStrategy:" + isSwitchOn);
        if (isSwitchOn) {
            int networkStackTypeInner = NetworkState.getNetworkStackTypeInner();
            if (this.mStackType == networkStackTypeInner || networkStackTypeInner == 3) {
                return false;
            }
            return true;
        }
        if (this.mUsedApn.compareToIgnoreCase(UploadConfiguration.getCurrentApn()) == 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c6, code lost:
    
        if (r8 != 6) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fc  */
    @Override // com.tencent.upload.network.route.IUploadRouteStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UploadRoute next(UploadRoute uploadRoute, int i3) {
        String uploadRoute2;
        UploadRoute availableRoute;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (UploadRoute) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uploadRoute, i3);
        }
        UploadRoute uploadRoute3 = null;
        if (uploadRoute == null) {
            UploadLog.d(this.TAG, " next: null, route == null");
            return null;
        }
        this.mUsedRouteInfos.add(new UsedRouteInfo(uploadRoute.m286clone(), i3));
        boolean isNetworkAvailable = UploadConfiguration.isNetworkAvailable();
        this.mCausedByApnChanged = !isNetworkAvailable;
        if (!isNetworkAvailable) {
            UploadLog.d(this.TAG, " next: null, !isNetworkAvailable");
            return null;
        }
        boolean isApnChangedForNext = isApnChangedForNext();
        this.mCausedByApnChanged = isApnChangedForNext;
        if (isApnChangedForNext) {
            UploadLog.d(this.TAG, " next: null, isApnChanged:" + isApnChangedForNext);
            return null;
        }
        if (i3 != 4 && uploadRoute.getRouteCategory() == IUploadRouteStrategy.RouteCategoryType.RECENT && (availableRoute = getAvailableRoute()) != null) {
            UploadLog.d(this.TAG, " next: return" + availableRoute);
            return availableRoute;
        }
        boolean isWapSetting = UploadConfiguration.isWapSetting();
        UploadLog.d(this.TAG, " next start: " + Const.FailureCode.print(i3) + " failureCode:" + i3 + " wap:" + isWapSetting);
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                }
            } else {
                while (this.mPortsIterator.hasNext()) {
                    this.mPortsIterator.next();
                }
                uploadRoute3 = matchNextRouteFormRouteTable(uploadRoute);
                if (uploadRoute3 != null) {
                    uploadRoute3.setRouteCategory(uploadRoute.getRouteCategory());
                }
            }
            String str = this.TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" next return: ");
            if (uploadRoute3 != null) {
                uploadRoute2 = "null";
            } else {
                uploadRoute2 = uploadRoute3.toString();
            }
            sb5.append(uploadRoute2);
            UploadLog.d(str, sb5.toString());
            if (uploadRoute3 != null) {
                uploadRoute3.setNewStrategy(UploadGlobalConfig.getConfig().isSwitchOn(Const.SwitchConfigKey.QQCIRCLE_ENABLE_NEW_CHANGE_STACKTYPE) ? 1 : 0);
            }
            return uploadRoute3;
        }
        uploadRoute3 = matchNextRouteFormRouteTable(uploadRoute);
        String str2 = this.TAG;
        StringBuilder sb52 = new StringBuilder();
        sb52.append(" next return: ");
        if (uploadRoute3 != null) {
        }
        sb52.append(uploadRoute2);
        UploadLog.d(str2, sb52.toString());
        if (uploadRoute3 != null) {
        }
        return uploadRoute3;
    }

    @Override // com.tencent.upload.network.route.IUploadRouteStrategy
    public UploadRoute reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (UploadRoute) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        UploadLog.d(this.TAG, "reset");
        this.mCausedByApnChanged = false;
        doInitParams();
        if (isApnChanged()) {
            this.mUsedApn = UploadConfiguration.getCurrentApn();
            loadRecentRouteRecord();
        }
        UploadRoute recentRoute = getRecentRoute();
        if (recentRoute != null) {
            UploadLog.d(this.TAG, " reset, return recentRoute: " + recentRoute.toString());
            return recentRoute;
        }
        UploadRoute availableRoute = getAvailableRoute();
        if (availableRoute != null) {
            UploadLog.d(this.TAG, " reset, return firstRoute:" + availableRoute);
            return availableRoute;
        }
        UploadLog.d(this.TAG, " reset, return null");
        return null;
    }

    @Override // com.tencent.upload.network.route.IUploadRouteStrategy
    public boolean save(UploadRoute uploadRoute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) uploadRoute)).booleanValue();
        }
        String recentRouteApnKey = UploadConfiguration.getRecentRouteApnKey();
        if (recentRouteApnKey == null) {
            UploadLog.d(this.TAG, "save, unknown key");
            return false;
        }
        if (recentRouteApnKey.length() > 0) {
            if (!uploadRoute.getIp().endsWith(".com")) {
                this.mRecentRouteRecord = UploadConfiguration.saveAsRecentIp(getServerRouteTable(), recentRouteApnKey, uploadRoute);
                UploadLog.d(this.TAG, " save: as recent:" + uploadRoute + " recentApnKey:" + recentRouteApnKey);
            }
            return true;
        }
        UploadLog.d(this.TAG, " save: apnKey isNullOrEmpty");
        return true;
    }
}
