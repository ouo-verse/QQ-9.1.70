package hc0;

import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.qqcircle.rerank.util.QFSRankEdgeReportHelper;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tedger.outapi.delegate.ITEdgeRSSDKComponentDelegate;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e implements ITEdgeRSSDKComponentDelegate {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, Boolean> f404690a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(String str, ITEdgeRSSDKComponentDelegate.a aVar, int i3, LoadExtResult loadExtResult) {
        boolean z16;
        boolean z17;
        Object[] objArr = new Object[6];
        boolean z18 = false;
        objArr[0] = "receive loadSO rsp,key:";
        objArr[1] = str;
        objArr[2] = ",retCode:";
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = ",load result:";
        if (loadExtResult != null && loadExtResult.isSucc()) {
            z16 = true;
        } else {
            z16 = false;
        }
        objArr[5] = Boolean.valueOf(z16);
        QLog.d("TEDGEQFS_QFSEdgeRSComponentDelegate", 1, objArr);
        if (i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && loadExtResult != null && loadExtResult.isSucc()) {
            QLog.d("TEDGEQFS_QFSEdgeRSComponentDelegate", 1, "load so finish, ver:" + loadExtResult.getVer() + ",isSucceed:" + z17);
            HashMap<String, Boolean> hashMap = this.f404690a;
            if (z17 && loadExtResult.isSucc()) {
                z18 = true;
            }
            hashMap.put(str, Boolean.valueOf(z18));
            aVar.complete();
            return;
        }
        aVar.complete();
    }

    @Override // com.tencent.tedger.outapi.delegate.ITEdgeRSSDKComponentDelegate
    public long a() {
        return QCircleDeviceInfoUtils.getSystemTotalMemory();
    }

    @Override // com.tencent.tedger.outapi.delegate.ITEdgeRSSDKComponentDelegate
    public ITEdgeRSSDKComponentDelegate.DeviceLevel b() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_rerank_use_qfs_devices_high_level_judge", true)) {
            int videoDeviceLevel = QCircleVideoDeviceInfoUtils.getVideoDeviceLevel();
            if (videoDeviceLevel != 3 && videoDeviceLevel != 4) {
                return ITEdgeRSSDKComponentDelegate.DeviceLevel.LOW_LEVEL;
            }
            return ITEdgeRSSDKComponentDelegate.DeviceLevel.HIGH_LEVEL;
        }
        return ITEdgeRSSDKComponentDelegate.DeviceLevel.UNKNOWN;
    }

    @Override // com.tencent.tedger.outapi.delegate.ITEdgeRSSDKComponentDelegate
    public void c(Map<String, Object> map) {
        QFSRankEdgeReportHelper.h(map);
    }

    @Override // com.tencent.tedger.outapi.delegate.ITEdgeRSSDKComponentDelegate
    public void d(final String str, final ITEdgeRSSDKComponentDelegate.a aVar) {
        QCirclePluginInitHelper.getInstance().loadSoByName(str, new OnLoadListener() { // from class: hc0.d
            @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
            public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                e.this.j(str, aVar, i3, loadExtResult);
            }
        });
    }

    @Override // com.tencent.tedger.outapi.delegate.ITEdgeRSSDKComponentDelegate
    public Map<String, String> e(String str) {
        Map<String, String> c16 = ic0.a.c(str);
        if (c16 != null) {
            QLog.e("TEDGEQFS_QFSEdgeRSComponentDelegate", 1, "[getLayerConfig] configMap:" + c16);
        } else {
            QLog.e("TEDGEQFS_QFSEdgeRSComponentDelegate", 1, "[getLayerConfig] error keys:" + str + ",configMap:" + c16);
        }
        return c16;
    }

    @Override // com.tencent.tedger.outapi.delegate.ITEdgeRSSDKComponentDelegate
    public boolean f(String str) {
        QLog.d("TEDGEQFS_QFSEdgeRSComponentDelegate", 1, "isSOLoaded key:", str, ",result:", this.f404690a.get(str));
        if (!this.f404690a.containsKey(str)) {
            return false;
        }
        return this.f404690a.get(str).booleanValue();
    }

    @Override // com.tencent.tedger.outapi.delegate.ITEdgeRSSDKComponentDelegate
    public com.tencent.rdelivery.reshub.api.i g() {
        return ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance();
    }

    @Override // com.tencent.tedger.outapi.delegate.ITEdgeRSSDKComponentDelegate
    public int h() {
        return QCircleDeviceInfoUtils.getNumberOfCores();
    }
}
