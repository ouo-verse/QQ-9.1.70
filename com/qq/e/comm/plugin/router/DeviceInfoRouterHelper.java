package com.qq.e.comm.plugin.router;

import android.content.Context;
import android.util.Pair;
import com.qq.e.comm.plugin.e.c;
import com.qq.e.comm.plugin.e.d;
import com.qq.e.comm.plugin.ipc.C2SMethod;
import com.qq.e.comm.plugin.ipc.IPCClass;
import com.qq.e.comm.plugin.ipc.business.BusinessAction;
import com.qq.e.comm.plugin.ipc.business.BusinessModuleName;
import com.qq.e.comm.plugin.ipc.business.BusinessParamsKey;
import com.qq.e.comm.plugin.ipc.business.BusinessResultKey;
import com.qq.e.comm.plugin.router.PublicApi;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DeviceInfoRouterHelper {
    static DeviceInfoPresenter presenter = new DeviceInfoPresenter();

    /* compiled from: P */
    @IPCClass
    /* loaded from: classes3.dex */
    private static class DeviceInfoPresenter extends BasePresenter implements PublicApi.DeviceInfoApi {
        DeviceInfoPresenter() {
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
        @C2SMethod(action = BusinessAction.ACTION_GET_DEVICE_INFO, module = BusinessModuleName.IPC_MODULE_DEVICE_INFO, params = {BusinessParamsKey.KEY_GET_DEVICE_INFO_POS_TYPE, BusinessParamsKey.KEY_GET_DEVICE_INFO_DEVICE_PARAMS}, results = {BusinessResultKey.KEY_GET_DEVICE_INFO})
        public JSONObject get(int i3, c cVar) throws JSONException {
            return d.f39354a.b(i3, cVar);
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
        @C2SMethod(action = BusinessAction.ACTION_GET_ANDROIDID, module = BusinessModuleName.IPC_MODULE_DEVICE_INFO, results = {BusinessResultKey.KEY_GET_ANDROIDID})
        public String getAndroidId() {
            return com.qq.e.comm.plugin.e.a.d.a().b(115, false);
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
        @C2SMethod(action = BusinessAction.ACTION_GET_BUILD_MODEL, module = BusinessModuleName.IPC_MODULE_DEVICE_INFO, results = {BusinessResultKey.KEY_GET_BUILD_MODEL})
        public String getBuildModel() {
            return com.qq.e.comm.plugin.e.a.d.a().b(117, false);
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
        @C2SMethod(action = BusinessAction.ACTION_GET_CARRIER, module = BusinessModuleName.IPC_MODULE_DEVICE_INFO, results = {BusinessResultKey.KEY_GET_CARRIER})
        public int getCarrier() {
            return com.qq.e.comm.plugin.e.a.d.a().a(305, false, 0);
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
        @C2SMethod(action = BusinessAction.ACTION_GET_DEVICE_ID, module = BusinessModuleName.IPC_MODULE_DEVICE_INFO, results = {BusinessResultKey.KEY_GET_DEVICE_ID})
        public String getDeviceId() {
            return com.qq.e.comm.plugin.e.a.d.a().b(110, false);
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
        @C2SMethod(action = BusinessAction.ACTION_GET_HASH_DEVICE_ID, module = BusinessModuleName.IPC_MODULE_DEVICE_INFO, results = {BusinessResultKey.KEY_GET_HASH_DEVICE_ID})
        public String getHashDeviceId() {
            return com.qq.e.comm.plugin.e.a.d.a().b(110, true);
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
        @C2SMethod(action = BusinessAction.ACTION_GET_HEIGHT_AND_WIDTH, module = BusinessModuleName.IPC_MODULE_DEVICE_INFO, results = {BusinessResultKey.KEY_GET_HEIGHT, BusinessResultKey.KEY_GET_WIDTH})
        public Pair<Integer, Integer> getHeightAndWidth() {
            return com.qq.e.comm.plugin.e.a.d.a().c(119, false);
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
        @C2SMethod(action = BusinessAction.ACTION_GET_IMEI, module = BusinessModuleName.IPC_MODULE_DEVICE_INFO, results = {BusinessResultKey.KEY_GET_IMEI})
        public String getImei() {
            return com.qq.e.comm.plugin.e.a.d.a().b(101, true);
        }

        @Override // com.qq.e.comm.plugin.router.BasePresenter
        public Map<Class<? extends ModuleApi>, ModuleApi> getModuleApi() {
            HashMap hashMap = new HashMap();
            hashMap.put(PublicApi.DeviceInfoApi.class, this);
            return hashMap;
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
        @C2SMethod(action = BusinessAction.ACTION_GET_NETWORK_TYPE, module = BusinessModuleName.IPC_MODULE_DEVICE_INFO, results = {BusinessResultKey.KEY_GET_NETWORK_TYPE})
        public int getNetWorkType() {
            return com.qq.e.comm.plugin.e.a.d.a().a(312, false, 0);
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
        @C2SMethod(action = BusinessAction.ACTION_GET_ONLY_CACHE, module = BusinessModuleName.IPC_MODULE_DEVICE_INFO, params = {BusinessParamsKey.KEY_GET_DEVICE_INFO_POS_TYPE, BusinessParamsKey.KEY_GET_DEVICE_INFO_DEVICE_PARAMS}, results = {BusinessResultKey.KEY_GET_ONLY_CACHE})
        public JSONObject getOnlyCache(int i3, c cVar) throws JSONException {
            return d.f39354a.a(i3, cVar);
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
        @C2SMethod(action = BusinessAction.ACTION_GET_OS_VERSION, module = BusinessModuleName.IPC_MODULE_DEVICE_INFO, results = {BusinessResultKey.KEY_GET_OS_VERSION})
        public String getOsVersion() {
            return com.qq.e.comm.plugin.e.a.d.a().b(403, false);
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
        @C2SMethod(action = BusinessAction.ACTION_GET_QIMEI36, module = BusinessModuleName.IPC_MODULE_DEVICE_INFO, results = {BusinessResultKey.KEY_GET_QIMEI36})
        public String getQImei36() {
            return com.qq.e.comm.plugin.e.a.d.a().b(701, false);
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
        @C2SMethod(action = BusinessAction.ACTION_GET_TAID_AND_OAIDTICKET, module = BusinessModuleName.IPC_MODULE_DEVICE_INFO, results = {BusinessResultKey.KEY_GET_TAID, BusinessResultKey.KEY_GET_OAIDTICKET})
        public Pair<String, String> getTaidAndOaidTicket() {
            return new Pair<>(com.qq.e.comm.plugin.e.a.d.a().b(2, false), com.qq.e.comm.plugin.e.a.d.a().b(1, false));
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi, com.qq.e.comm.plugin.router.PublicApi.VelenApi
        public void init(Context context) {
            d.f39354a.a(context);
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
        public void reset() {
            d.f39354a.a();
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
        public void updateAppStatus(String str) {
        }
    }
}
