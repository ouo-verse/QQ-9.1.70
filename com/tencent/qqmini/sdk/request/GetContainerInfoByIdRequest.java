package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.CONTAINER_INTERFACE$GetMiniAppConfigRsp;
import NS_MINI_INTERFACE.CONTAINER_INTERFACE$SubPkgInfo;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StAppBasicInfo;
import NS_MINI_INTERFACE.INTERFACE$StSubPkgInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.transfile.CarrierImgDownloader;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetContainerInfoByIdRequest extends ProtoBufRequest {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f348330a;

    public GetContainerInfoByIdRequest(String str, int i3, int i16, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        this.f348330a = jSONObject;
        try {
            jSONObject.put("appid", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("modelType", 1);
            jSONObject2.put(WadlProxyConsts.SCENE_ID, 1);
            this.f348330a.put("commonInfo", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("cookies", "");
            jSONObject3.put(MosaicConstants$JsProperty.PROP_ENV, "");
            jSONObject3.put(Constants.Service.CONFIG_NAME_SPACE, "");
            this.f348330a.put(ITroopAnnouncementHelperApi.CONTROL_INFO, jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("brand", "");
            jSONObject4.put("model", "");
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("type", 0);
            jSONObject5.put("version", "");
            jSONObject4.put("os", jSONObject5);
            this.f348330a.put("deviceInfo", jSONObject4);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put(CarrierImgDownloader.PROTOCAL_CARRIER_IMG, 0);
            jSONObject6.put("city", "");
            jSONObject6.put(QCircleSchemeAttr.Polymerize.LAT, 0);
            jSONObject6.put("lon", 0);
            jSONObject6.put("province", "");
            this.f348330a.put(ITVKPlayerEventListener.KEY_USER_INFO, jSONObject6);
        } catch (Exception e16) {
            QMLog.d(com.tencent.mobileqq.mini.servlet.GetContainerInfoByIdRequest.TAG, "GetAppInfoByIdRequest Exception:" + e16);
        }
    }

    private void a(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo, CONTAINER_INTERFACE$GetMiniAppConfigRsp cONTAINER_INTERFACE$GetMiniAppConfigRsp) {
        String str = cONTAINER_INTERFACE$GetMiniAppConfigRsp.pkg_info.main_pkg_info.version.get();
        String str2 = cONTAINER_INTERFACE$GetMiniAppConfigRsp.pkg_info.main_pkg_info.version_id.get();
        String str3 = cONTAINER_INTERFACE$GetMiniAppConfigRsp.pkg_info.main_pkg_info.down_load_url.get();
        int i3 = cONTAINER_INTERFACE$GetMiniAppConfigRsp.pkg_info.main_pkg_info.version_update_time.get();
        iNTERFACE$StApiAppInfo.appJson.set(cONTAINER_INTERFACE$GetMiniAppConfigRsp.pkg_info.app_json.get());
        iNTERFACE$StApiAppInfo.version.set(str);
        iNTERFACE$StApiAppInfo.versionId.set(str2);
        iNTERFACE$StApiAppInfo.donwLoadUrl.set(str3);
        INTERFACE$StAppBasicInfo iNTERFACE$StAppBasicInfo = iNTERFACE$StApiAppInfo.basicInfo;
        if (iNTERFACE$StAppBasicInfo != null) {
            iNTERFACE$StAppBasicInfo.versionUpdateTime.set(i3);
        }
        ArrayList arrayList = new ArrayList();
        List<CONTAINER_INTERFACE$SubPkgInfo> list = cONTAINER_INTERFACE$GetMiniAppConfigRsp.pkg_info.sub_pkgs.get();
        if (list != null && list.size() > 0) {
            for (CONTAINER_INTERFACE$SubPkgInfo cONTAINER_INTERFACE$SubPkgInfo : list) {
                INTERFACE$StSubPkgInfo iNTERFACE$StSubPkgInfo = new INTERFACE$StSubPkgInfo();
                iNTERFACE$StSubPkgInfo.subPkgName.set(cONTAINER_INTERFACE$SubPkgInfo.sub_pkg_name.get());
                iNTERFACE$StSubPkgInfo.version.set(cONTAINER_INTERFACE$SubPkgInfo.version.get());
                iNTERFACE$StSubPkgInfo.versionId.set(cONTAINER_INTERFACE$SubPkgInfo.version_id.get());
                iNTERFACE$StSubPkgInfo.independent.set(cONTAINER_INTERFACE$SubPkgInfo.independent.get());
                iNTERFACE$StSubPkgInfo.mainPackVersion.set(cONTAINER_INTERFACE$SubPkgInfo.main_pack_version.get());
                iNTERFACE$StSubPkgInfo.dowLoadUrl.set(cONTAINER_INTERFACE$SubPkgInfo.down_load_url.get());
                iNTERFACE$StSubPkgInfo.file_size.set(cONTAINER_INTERFACE$SubPkgInfo.file_size.get());
                iNTERFACE$StSubPkgInfo.version_type.set(cONTAINER_INTERFACE$SubPkgInfo.sub_version_type.get());
                arrayList.add(iNTERFACE$StSubPkgInfo);
            }
            iNTERFACE$StApiAppInfo.subPkgs.set(arrayList);
        }
    }

    private void savaMiniAppInfo(final MiniAppInfo miniAppInfo) {
        if (!ProcessUtil.isMainProcess(AppLoaderFactory.g().getContext())) {
            return;
        }
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.request.GetContainerInfoByIdRequest.1
            @Override // java.lang.Runnable
            public void run() {
                ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).notifyMiniAppInfo(0, miniAppInfo);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] encode() {
        return getBusiBuf();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.f348330a.toString().getBytes();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetContainerAppInfoById";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public String getCmdString() {
        return "GetContainerAppInfoById";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_container_app_info";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) throws Exception {
        try {
            JSONObject optJSONObject = new JSONObject(new String(bArr)).optJSONObject("appInfo");
            MiniAppInfo createMiniAppInfo = MiniAppInfo.createMiniAppInfo(optJSONObject);
            createMiniAppInfo.firstPath = this.f348330a.optString("firstPath");
            jSONObject.put("mini_app_info_data", createMiniAppInfo);
            jSONObject.put(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_JSON, optJSONObject);
            if (createMiniAppInfo.verType == 3) {
                savaMiniAppInfo(createMiniAppInfo);
            }
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(com.tencent.mobileqq.mini.servlet.GetContainerInfoByIdRequest.TAG, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr) {
        try {
            CONTAINER_INTERFACE$GetMiniAppConfigRsp cONTAINER_INTERFACE$GetMiniAppConfigRsp = new CONTAINER_INTERFACE$GetMiniAppConfigRsp();
            cONTAINER_INTERFACE$GetMiniAppConfigRsp.mergeFrom(bArr);
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
            iNTERFACE$StApiAppInfo.mergeFrom(cONTAINER_INTERFACE$GetMiniAppConfigRsp.ext_info.get().toByteArray());
            a(iNTERFACE$StApiAppInfo, cONTAINER_INTERFACE$GetMiniAppConfigRsp);
            MiniAppInfo from = MiniAppInfo.from(iNTERFACE$StApiAppInfo);
            if (iNTERFACE$StApiAppInfo.type.get() == 3) {
                savaMiniAppInfo(from);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mini_app_info_data", from);
            jSONObject.put(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_PB, iNTERFACE$StApiAppInfo.toByteArray());
            return jSONObject;
        } catch (Exception e16) {
            e16.printStackTrace();
            return super.getResponse(bArr);
        }
    }
}
