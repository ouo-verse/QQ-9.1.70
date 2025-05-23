package mqq.manager.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.service.protocol.serverconfig.ProxyIpChannel;
import com.tencent.msf.service.protocol.serverconfig.ProxyIpInfo;
import com.tencent.msf.service.protocol.serverconfig.ProxyIpList;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.IProxyIpService;

/* loaded from: classes28.dex */
public class ProxyIpServiceImpl implements IProxyIpService {
    private static final int MSG_NOTIFY_PROXY_IP_CHANGED = 10000;
    private static final String SP_KEY_PROXYIP = "_key_proxyip_";
    private static final String TAG = "ProxyIpServiceImpl";
    private AppRuntime mApp;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: mqq.manager.impl.ProxyIpServiceImpl.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 10000) {
                ProxyIpServiceImpl.this.mApp.onProxyIpChanged();
            }
        }
    };
    private MsfStore mMsfStore;
    private ArrayList<ProxyIpList> mProxyIpCache;

    @Override // mqq.manager.IProxyIpService
    public List<IProxyIpService.ProxyIp> getProxyIp(int i3) {
        if (!isMobileNetWork(this.mApp.getApplication())) {
            QLog.d(TAG, 1, "Load local proxy ip failed, uin:" + MsfSdkUtils.getShortUin(this.mApp.getAccount()) + " type: " + i3 + " reason: not mobile network!");
            return null;
        }
        ArrayList<ProxyIpList> arrayList = this.mProxyIpCache;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<ProxyIpList> it = this.mProxyIpCache.iterator();
            while (it.hasNext()) {
                ProxyIpList next = it.next();
                if (next != null && next.uService_type == i3) {
                    ArrayList<ProxyIpInfo> arrayList2 = next.vIplist;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        ArrayList arrayList3 = new ArrayList();
                        Iterator<ProxyIpInfo> it5 = next.vIplist.iterator();
                        while (it5.hasNext()) {
                            ProxyIpInfo next2 = it5.next();
                            IProxyIpService.ProxyIp proxyIp = new IProxyIpService.ProxyIp();
                            proxyIp.type = next2.uType;
                            proxyIp.f417211ip = StringUtils.getIpAddrFromInt(next2.uIp);
                            proxyIp.port = next2.uPort;
                            arrayList3.add(proxyIp);
                        }
                        QLog.d(TAG, 1, "Load local proxy ip succ, uin: " + MsfSdkUtils.getShortUin(this.mApp.getAccount()) + " type: " + i3 + " iplist: " + arrayList3.toString());
                        return arrayList3;
                    }
                    QLog.d(TAG, 1, "Load local proxy ip failed, uin: " + MsfSdkUtils.getShortUin(this.mApp.getAccount()) + " type: " + i3 + " reason: ip list is null!");
                    return null;
                }
            }
        }
        QLog.d(TAG, 1, "Load local proxy ip failed, uin: " + MsfSdkUtils.getShortUin(this.mApp.getAccount()) + " type: " + i3 + " reason: ip cache is null!");
        return null;
    }

    public boolean isMobileNetWork(Context context) {
        try {
            return isMobileNetworkInfo(((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo());
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isMobileNetworkInfo(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return false;
        }
        if (NetworkMonitor.getType(networkInfo) != 0 && 50 != NetworkMonitor.getType(networkInfo)) {
            return false;
        }
        return true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = appRuntime;
        MsfStore msfStore = new MsfStore();
        this.mMsfStore = msfStore;
        msfStore.init(BaseApplication.getContext());
        reloadCache(this.mApp.getAccount(), true);
    }

    @Override // mqq.manager.IProxyIpService
    public void reloadCache(String str, boolean z16) {
        if (!TextUtils.isEmpty(str) && str.equals(this.mApp.getAccount())) {
            String str2 = SP_KEY_PROXYIP + this.mApp.getAccount();
            try {
                MsfStore.getNativeConfigStore().loadConfig(this.mApp.getApplication(), false);
                String config = MsfStore.getNativeConfigStore().getConfig(str2);
                if (!TextUtils.isEmpty(config)) {
                    JceInputStream jceInputStream = new JceInputStream(HexUtil.hexStr2Bytes(config));
                    ProxyIpChannel proxyIpChannel = new ProxyIpChannel();
                    proxyIpChannel.readFrom(jceInputStream);
                    ArrayList<ProxyIpList> arrayList = proxyIpChannel.vProxy_iplists;
                    if (arrayList != null && arrayList.size() > 0) {
                        this.mProxyIpCache = proxyIpChannel.vProxy_iplists;
                    } else {
                        QLog.d(TAG, 1, "Load local proxy ip failed, uin: " + MsfSdkUtils.getShortUin(str) + " Parsed proxy ip is empty");
                    }
                } else {
                    this.mProxyIpCache = null;
                    QLog.d(TAG, 1, "Load local proxy ip failed, uin: " + MsfSdkUtils.getShortUin(str) + " config is empty");
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                QLog.d(TAG, 1, "Load local proxy ip failed, uin: " + MsfSdkUtils.getShortUin(str) + " " + th5.getMessage());
            }
            this.mHandler.sendEmptyMessageDelayed(10000, 100L);
            return;
        }
        QLog.d(TAG, 1, "Load local proxy ip failed: uin is mismatch with app account");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
