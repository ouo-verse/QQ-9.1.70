package com.tencent.biz.richframework.video.rfw.player.optionsprocess;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkpublish.api.IUploadApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.Pair;
import com.tribe.async.log.SLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import uq3.c;
import uq3.d;
import uq3.o;

/* loaded from: classes5.dex */
public class RFWPlayerPlayerDirectIPProcess implements IRFWPlayerOptionsProcess {
    public static String DEFAULT_PROCESS_URL_DIRECT_IP = "DEFAULT_PROCESS_URL_DIRECT_IP";
    private QzoneConfig.QzoneConfigChangeListener mConfigChangeListener;
    private final ConcurrentHashMap<String, List<DirectIp>> mIPConfigHashMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, List<DirectIp>> mBackUpIPConfigHashMap = new ConcurrentHashMap<>();

    private DirectIp findIp(RFWPlayerOptions rFWPlayerOptions, ConcurrentHashMap<String, List<DirectIp>> concurrentHashMap, String str) {
        List<DirectIp> list;
        if (!concurrentHashMap.containsKey(str) || (list = concurrentHashMap.get(str)) == null || list.size() <= 0) {
            return null;
        }
        int netWorkStackType = ((IUploadApi) QRoute.api(IUploadApi.class)).getNetWorkStackType();
        RFWLog.d(c(rFWPlayerOptions), RFWLog.USR, "NetWorkStack:" + netWorkStackType);
        if (isDualStack()) {
            return getDirectIp(rFWPlayerOptions, list, true);
        }
        return getDirectIp(rFWPlayerOptions, list, false);
    }

    private void generateDirectIPUrl(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        String realPlayUrl = rFWPlayerOptions.getRealPlayUrl();
        if (TextUtils.isEmpty(realPlayUrl)) {
            RFWLog.d(c(rFWPlayerOptions), RFWLog.USR, "play url is empty");
            iProcessCallBack.onFinish(rFWPlayerOptions, true);
            return;
        }
        Uri parse = Uri.parse(realPlayUrl);
        String host = parse.getHost();
        if (TextUtils.isEmpty(host)) {
            RFWLog.d(c(rFWPlayerOptions), RFWLog.USR, "play url has not host");
            iProcessCallBack.onFinish(rFWPlayerOptions, true);
            return;
        }
        DirectIp directIP = getDirectIP(rFWPlayerOptions, host);
        if (directIP == null) {
            RFWLog.d(c(rFWPlayerOptions), RFWLog.USR, "can not find targetIp");
            iProcessCallBack.onFinish(rFWPlayerOptions, true);
            return;
        }
        String str = parse.getScheme() + QzoneWebViewOfflinePlugin.STR_DEVIDER + directIP.mIp + "/" + host + parse.getPath() + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + parse.getQuery();
        RFWLog.d(c(rFWPlayerOptions), RFWLog.USR, "host:" + host + "| targetIpUrl:" + str);
        if (isDualStack() && !directIP.mIsV6IP) {
            rFWPlayerOptions.setTargetDualStackV4IpUrl(str);
        } else {
            rFWPlayerOptions.setTargetIPURl(str);
        }
        iProcessCallBack.onFinish(rFWPlayerOptions, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void generateDirectIpStrategy(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        if (iProcessCallBack == null) {
            QLog.d(c(rFWPlayerOptions), 1, "[generateDirectIpStrategy] callBack == null.");
            return;
        }
        try {
            if (o.t1()) {
                generateNewConfigDirectIpToBackUpList(rFWPlayerOptions, iProcessCallBack);
            } else {
                generateDirectIPUrl(rFWPlayerOptions, iProcessCallBack);
            }
        } catch (Throwable th5) {
            QLog.w(c(rFWPlayerOptions), 1, "[generateDirectIpStrategy] ex: ", th5);
            iProcessCallBack.onFinish(rFWPlayerOptions, true);
        }
    }

    private void generateNewConfigDirectIpToBackUpList(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        String realPlayUrl = rFWPlayerOptions.getRealPlayUrl();
        if (TextUtils.isEmpty(realPlayUrl)) {
            RFWLog.w(c(rFWPlayerOptions), RFWLog.USR, "[generateNewConfigDirectIpToBackUpList] play url is empty.");
            iProcessCallBack.onFinish(rFWPlayerOptions, true);
            return;
        }
        Uri parse = Uri.parse(realPlayUrl);
        String host = parse.getHost();
        if (host != null && !TextUtils.isEmpty(host)) {
            List<DirectIp> list = this.mIPConfigHashMap.get(host);
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                int size = list.size();
                int h06 = o.h0(2);
                int min = Math.min(size, h06);
                if (min <= 0) {
                    QLog.w(c(rFWPlayerOptions), 1, "[generateNewConfigDirectIpToBackUpList] length < 0, directIpSize: " + size + " | directIpMaxSize: " + h06);
                    iProcessCallBack.onFinish(rFWPlayerOptions, true);
                    return;
                }
                for (int i3 = 0; i3 < min; i3++) {
                    arrayList.add(parse.getScheme() + QzoneWebViewOfflinePlugin.STR_DEVIDER + list.get(i3).mIp + "/" + host + parse.getPath() + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + parse.getQuery());
                }
                rFWPlayerOptions.setDirectIPBackUpList(arrayList);
                iProcessCallBack.onFinish(rFWPlayerOptions, true);
                return;
            }
            iProcessCallBack.onFinish(rFWPlayerOptions, true);
            return;
        }
        RFWLog.w(c(rFWPlayerOptions), RFWLog.USR, "[generateNewConfigDirectIpToBackUpList] play url has not host.");
        iProcessCallBack.onFinish(rFWPlayerOptions, true);
    }

    private synchronized DirectIp getDirectIP(RFWPlayerOptions rFWPlayerOptions, String str) {
        DirectIp findIp = findIp(rFWPlayerOptions, this.mIPConfigHashMap, str);
        if (findIp != null) {
            return findIp;
        }
        return findIp(rFWPlayerOptions, this.mBackUpIPConfigHashMap, str);
    }

    @Nullable
    private DirectIp getDirectIp(RFWPlayerOptions rFWPlayerOptions, List<DirectIp> list, boolean z16) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            DirectIp directIp = list.get(i3);
            if (z16) {
                if (directIp.mIsV6IP) {
                    return getDirectIpV6(rFWPlayerOptions, directIp);
                }
                return getDirectIpV4(rFWPlayerOptions, directIp);
            }
            if (!directIp.mIsV6IP) {
                RFWLog.d(c(rFWPlayerOptions), RFWLog.USR, "find v4:" + directIp.mIp);
                return directIp;
            }
        }
        return null;
    }

    private DirectIp getDirectIpV4(RFWPlayerOptions rFWPlayerOptions, DirectIp directIp) {
        if (!c.o5()) {
            RFWLog.d(c(rFWPlayerOptions), RFWLog.USR, "find v4 not support");
            return null;
        }
        RFWLog.d(c(rFWPlayerOptions), RFWLog.USR, "find v4: " + directIp.mIp);
        return directIp;
    }

    private DirectIp getDirectIpV6(RFWPlayerOptions rFWPlayerOptions, DirectIp directIp) {
        if (!c.p5()) {
            RFWLog.d(c(rFWPlayerOptions), RFWLog.USR, "find v6 not support");
            return null;
        }
        RFWLog.d(c(rFWPlayerOptions), RFWLog.USR, "find v6:" + directIp.mIp);
        return directIp;
    }

    private void init() {
        if (this.mConfigChangeListener == null) {
            this.mConfigChangeListener = new QzoneConfig.QzoneConfigChangeListener() { // from class: com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerPlayerDirectIPProcess.2
                @Override // common.config.service.QzoneConfig.QzoneConfigChangeListener
                public void onConfigChange() {
                    RFWLog.d("QFSPlayerDirectIPProcess", RFWLog.USR, "onConfigChange");
                    RFWPlayerPlayerDirectIPProcess.this.initIpConfig();
                }
            };
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerPlayerDirectIPProcess.3
                @Override // java.lang.Runnable
                public void run() {
                    ((IUploadApi) QRoute.api(IUploadApi.class)).initUpload();
                }
            });
            QzoneConfig.getInstance().addListener(this.mConfigChangeListener);
            initIpConfig();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void initIpConfig() {
        this.mIPConfigHashMap.clear();
        this.mBackUpIPConfigHashMap.clear();
        if (o.t1()) {
            parseNewConfig(d.a(), this.mIPConfigHashMap);
        } else {
            parseIp(c.a1(QzoneConfig.MAIN_KEY_VIDEO_SVRLIST, QzoneConfig.SECONDARY_DOWNLOAD_DIRECT_IP_VIDEO), this.mIPConfigHashMap);
            parseIp(c.a1(QzoneConfig.MAIN_KEY_VIDEO_SVRLIST, QzoneConfig.SECONDARY_DOWNLOAD_BACKUP_IP_VIDEO), this.mBackUpIPConfigHashMap);
        }
    }

    private boolean isDualStack() {
        int netWorkStackType = ((IUploadApi) QRoute.api(IUploadApi.class)).getNetWorkStackType();
        if (netWorkStackType != 2 && netWorkStackType != 3) {
            return false;
        }
        return true;
    }

    private void parseIp(String str, ConcurrentHashMap<String, List<DirectIp>> concurrentHashMap) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (RFWLog.isColorLevel()) {
            RFWLog.d("QFSPlayerDirectIPProcess", RFWLog.CLR, "configIP:" + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                ArrayList arrayList = new ArrayList();
                concurrentHashMap.put(str2, arrayList);
                JSONArray jSONArray = jSONObject.getJSONArray(str2);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList.add(new DirectIp(jSONArray.getJSONObject(i3)));
                }
            }
        } catch (JSONException e16) {
            RFWLog.e("QFSPlayerDirectIPProcess", RFWLog.USR, "parse ip error", e16);
        }
    }

    private void parseNewConfig(Map<String, Pair<List<String>, List<String>>> map, ConcurrentHashMap<String, List<DirectIp>> concurrentHashMap) {
        List<String> list;
        if (map != null && !map.isEmpty()) {
            try {
                Set<String> keySet = map.keySet();
                for (String str : keySet) {
                    Pair<List<String>, List<String>> pair = map.get(str);
                    if (pair != null && (list = pair.first) != null && pair.second != null) {
                        int size = list.size();
                        int size2 = pair.second.size();
                        if (size != size2) {
                            QLog.w("QFSPlayerDirectIPProcess", 1, "[parseNewConfig] host: " + str + " | ipSize: " + size + " | portSize: " + size2 + ",not add to direct ip map.");
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i3 = 0; i3 < size; i3++) {
                            arrayList.add(new DirectIp(pair.first.get(i3), pair.second.get(i3)));
                        }
                        concurrentHashMap.put(str, arrayList);
                    }
                    return;
                }
                QLog.d("QFSPlayerDirectIPProcess", 4, "[parseNewConfig] keys size: " + keySet.size() + " | direct ip size: " + concurrentHashMap.size());
            } catch (Throwable th5) {
                QLog.w("QFSPlayerDirectIPProcess", 1, "[parseNewConfig] ex: ", th5);
            }
        }
    }

    public /* synthetic */ String c(RFWPlayerOptions rFWPlayerOptions) {
        return a.a(this, rFWPlayerOptions);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess
    public String getProcessKey() {
        return DEFAULT_PROCESS_URL_DIRECT_IP;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess
    public synchronized void onProcess(final RFWPlayerOptions rFWPlayerOptions, final RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        if (rFWPlayerOptions != null && iProcessCallBack != null) {
            if (!rFWPlayerOptions.isLocalVideo()) {
                if (!c.m5()) {
                    RFWLog.d(c(rFWPlayerOptions), RFWLog.USR, "not enable direct ip");
                    iProcessCallBack.onFinish(rFWPlayerOptions, true);
                    return;
                }
                init();
                if (!rFWPlayerOptions.enableIpDirect()) {
                    iProcessCallBack.onFinish(rFWPlayerOptions, true);
                } else if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101516", true)) {
                    RFWLog.d(c(rFWPlayerOptions), RFWLog.USR, SLog.LOG_TAG);
                    generateDirectIpStrategy(rFWPlayerOptions, iProcessCallBack);
                } else {
                    RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerPlayerDirectIPProcess.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RFWLog.d(RFWPlayerPlayerDirectIPProcess.this.c(rFWPlayerOptions), RFWLog.USR, "sync");
                            RFWPlayerPlayerDirectIPProcess.this.generateDirectIpStrategy(rFWPlayerOptions, iProcessCallBack);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class DirectIp {
        private String mApn;
        private String mIp;
        private boolean mIsV6IP;
        private String mPort;

        public DirectIp(JSONObject jSONObject) {
            parseValue(jSONObject);
        }

        private boolean isIPV6Address(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return InetAddress.getByName(str) instanceof Inet6Address;
            } catch (Throwable th5) {
                RFWLog.e("QFSPlayerDirectIPProcess", RFWLog.USR, "parseIp error", th5);
                return false;
            }
        }

        private void parseValue(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.mIp = jSONObject.optString("ip");
            this.mPort = jSONObject.optString("port");
            this.mApn = jSONObject.optString("apn");
            this.mIsV6IP = isIPV6Address(this.mIp);
        }

        public DirectIp(String str, String str2) {
            this.mIp = str;
            this.mPort = str2;
            this.mIsV6IP = isIPV6Address(str);
        }
    }
}
