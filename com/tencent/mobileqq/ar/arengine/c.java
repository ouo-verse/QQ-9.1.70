package com.tencent.mobileqq.ar.arengine;

import android.annotation.TargetApi;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ARRelationShip;
import com.tencent.mobileqq.ar.model.ArAwardInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    @TargetApi(9)
    public static ArCloudConfigInfo a(String str) {
        boolean z16;
        boolean z17;
        int i3;
        int i16;
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                ArCloudConfigInfo arCloudConfigInfo = new ArCloudConfigInfo();
                if (jSONObject.has("BusinessId")) {
                    arCloudConfigInfo.f197698d = Integer.parseInt(jSONObject.getString("BusinessId"));
                }
                if (jSONObject.has("SDKVersion")) {
                    arCloudConfigInfo.f197699e = jSONObject.getString("SDKVersion");
                }
                if (jSONObject.has("CloseCache")) {
                    arCloudConfigInfo.f197700f = jSONObject.getInt("CloseCache");
                }
                if (jSONObject.has("Type")) {
                    arCloudConfigInfo.f197702i = jSONObject.getInt("Type");
                }
                if (jSONObject.has("TrackMode")) {
                    int i17 = jSONObject.getInt("TrackMode");
                    arCloudConfigInfo.f197701h = i17;
                    if (i17 == 4) {
                        i3 = 1;
                        arCloudConfigInfo.f197701h = 1;
                    } else {
                        i3 = 1;
                    }
                    if (arCloudConfigInfo.f197701h == i3) {
                        SensorManager sensorManager = (SensorManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
                        if (com.tencent.mobileqq.ar.ARRenderModel.r.e()) {
                            i16 = 15;
                        } else {
                            i16 = 11;
                        }
                        List<Sensor> sensorList = SensorMonitor.getSensorList(sensorManager, i16);
                        Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 4);
                        if (sensorList.size() > 0 && defaultSensor != null && !DeviceInfoMonitor.getModel().equalsIgnoreCase("GT-I9500")) {
                            arCloudConfigInfo.f197701h = 1;
                        } else {
                            arCloudConfigInfo.f197701h = 2;
                            QLog.i("AREngine_MarkerJsonParser", 1, "no support sensor or GT-I9500. make trackmode 1 to 2");
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("ar_model", DeviceInfoMonitor.getModel());
                            hashMap.put("ar_type", "1");
                            hashMap.put("ar_reason", "1");
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidARException", true, 0L, 0L, hashMap, "", true);
                        }
                    }
                    if (arCloudConfigInfo.f197702i == 8) {
                        arCloudConfigInfo.f197701h = 2;
                    }
                }
                if (jSONObject.has("PicId")) {
                    arCloudConfigInfo.f197703m = jSONObject.getString("PicId");
                }
                if (jSONObject.has("LotterySet")) {
                    arCloudConfigInfo.C = jSONObject.getInt("LotterySet");
                }
                if (jSONObject.has("Award")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("Award");
                    ArAwardInfo arAwardInfo = new ArAwardInfo();
                    if (jSONObject2.has("AwardDistance")) {
                        arAwardInfo.f198399d = jSONObject.getInt("AwardDistance");
                    }
                    if (jSONObject2.has("BusinessBanner")) {
                        arAwardInfo.f198400e = jSONObject.getString("BusinessBanner");
                    }
                    if (jSONObject2.has("BusinessLogo")) {
                        arAwardInfo.f198401f = jSONObject.getString("BusinessLogo");
                    }
                    if (jSONObject2.has("BusinessName")) {
                        arAwardInfo.D = jSONObject.getString("BusinessName");
                    }
                    if (jSONObject2.has("BusinessWishing")) {
                        arAwardInfo.f198403i = jSONObject.getString("BusinessWishing");
                    }
                    if (jSONObject2.has("NotPlayModel")) {
                        if (jSONObject.getInt("NotPlayModel") == 1) {
                            arAwardInfo.f198404m = 0;
                        } else {
                            arAwardInfo.f198404m = 1;
                        }
                    }
                    arCloudConfigInfo.G = arAwardInfo;
                }
                if (jSONObject.has("Feature")) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("Feature");
                    ArFeatureInfo arFeatureInfo = new ArFeatureInfo();
                    if (jSONObject3.has("FeatureMD5")) {
                        arFeatureInfo.f198409d = jSONObject3.getString("FeatureMD5");
                    }
                    if (jSONObject3.has("FeatureSize")) {
                        arFeatureInfo.f198410e = jSONObject3.getLong("FeatureSize");
                    }
                    if (jSONObject3.has("FeatureUrl")) {
                        arFeatureInfo.f198411f = jSONObject3.getString("FeatureUrl");
                    }
                    arCloudConfigInfo.E = arFeatureInfo;
                }
                if (jSONObject.has("ModelResource")) {
                    JSONObject jSONObject4 = jSONObject.getJSONObject("ModelResource");
                    ArModelResource arModelResource = new ArModelResource();
                    if (jSONObject4.has("ModelResourceSize")) {
                        arModelResource.f198420d = jSONObject4.getLong("ModelResourceSize");
                    }
                    if (jSONObject4.has("ModelResourceMD5")) {
                        arModelResource.f198421e = jSONObject4.getString("ModelResourceMD5");
                    }
                    if (jSONObject4.has("ModelResourceUrl")) {
                        arModelResource.f198422f = jSONObject4.getString("ModelResourceUrl");
                    }
                    if (jSONObject4.has("ModelResourceBgMusic")) {
                        arModelResource.f198423h = jSONObject4.getString("ModelResourceBgMusic");
                    }
                    if (jSONObject4.has("ModelConfigFile")) {
                        arModelResource.f198424i = jSONObject4.getString("ModelConfigFile");
                    }
                    if (jSONObject4.has("ModelRepeatTimes")) {
                        arModelResource.f198425m = jSONObject4.getInt("ModelRepeatTimes");
                    }
                    if (jSONObject4.has("ModelLayout")) {
                        arModelResource.C = jSONObject4.getString("ModelLayout");
                    }
                    arCloudConfigInfo.F = arModelResource;
                }
                if (jSONObject.has(GdtLog.WEB_TAG)) {
                    JSONObject jSONObject5 = jSONObject.getJSONObject(GdtLog.WEB_TAG);
                    ArWebInfo arWebInfo = new ArWebInfo();
                    if (jSONObject5.has("IsUrlAutoJump")) {
                        if (jSONObject5.getInt("IsUrlAutoJump") == 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        arWebInfo.f198432d = z17;
                    }
                    if (jSONObject5.has("IsUrlTransparent")) {
                        if (jSONObject5.getInt("IsUrlTransparent") == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        arWebInfo.f198433e = z16;
                    }
                    if (jSONObject5.has("WebJumpUrl")) {
                        arWebInfo.f198434f = jSONObject5.getString("WebJumpUrl");
                    }
                    if (jSONObject5.has("HtmlOfflineBid")) {
                        arWebInfo.f198435h = jSONObject5.getString("HtmlOfflineBid");
                    }
                    arCloudConfigInfo.H = arWebInfo;
                }
                if (jSONObject.has("VideoResource")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("VideoResource");
                    ArrayList<ArVideoResourceInfo> arrayList = new ArrayList<>();
                    for (int i18 = 0; i18 < jSONArray.length(); i18++) {
                        JSONObject jSONObject6 = jSONArray.getJSONObject(i18);
                        ArVideoResourceInfo arVideoResourceInfo = new ArVideoResourceInfo();
                        if (jSONObject6.has("VideoConnectType")) {
                            arVideoResourceInfo.f198426d = jSONObject6.getInt("VideoConnectType");
                        }
                        if (jSONObject6.has("VideoKeyingConfig")) {
                            arVideoResourceInfo.f198428f = jSONObject6.getString("VideoKeyingConfig");
                        }
                        if (jSONObject6.has("VideoSize")) {
                            arVideoResourceInfo.f198427e = jSONObject6.getLong("VideoSize");
                        }
                        if (jSONObject6.has("VideoLayout")) {
                            arVideoResourceInfo.f198429h = jSONObject6.getString("VideoLayout");
                        }
                        if (jSONObject6.has("VideoMD5")) {
                            arVideoResourceInfo.f198430i = jSONObject6.getString("VideoMD5");
                        }
                        if (jSONObject6.has("VideoRepeatTimes")) {
                            arVideoResourceInfo.f198431m = jSONObject6.getInt("VideoRepeatTimes");
                        }
                        if (jSONObject6.has("VideoTrackMode")) {
                            arVideoResourceInfo.C = jSONObject6.getInt("VideoTrackMode");
                        }
                        if (jSONObject6.has("VideoType")) {
                            arVideoResourceInfo.D = jSONObject6.getInt("VideoType");
                        }
                        if (jSONObject6.has("VideoUrl")) {
                            arVideoResourceInfo.E = jSONObject6.getString("VideoUrl");
                        }
                        arrayList.add(arVideoResourceInfo);
                    }
                    arCloudConfigInfo.D = arrayList;
                }
                if (jSONObject.has("IsRelationShip")) {
                    arCloudConfigInfo.I = jSONObject.getInt("IsRelationShip");
                }
                if (jSONObject.has("traversing360")) {
                    arCloudConfigInfo.M = com.tencent.mobileqq.ar.ARPromotion.c.a(jSONObject.getJSONObject("traversing360"));
                }
                if (jSONObject.has("ARRelationShip")) {
                    JSONObject jSONObject7 = jSONObject.getJSONObject("ARRelationShip");
                    ARRelationShip aRRelationShip = new ARRelationShip();
                    if (jSONObject7.has("TaskId")) {
                        arCloudConfigInfo.f197700f = 1;
                        arCloudConfigInfo.f197702i = 7;
                        aRRelationShip.f198393d = jSONObject7.getString("TaskId");
                    }
                    if (jSONObject7.has("ARRelationShipResourceUrl")) {
                        aRRelationShip.f198394e = jSONObject7.getString("ARRelationShipResourceUrl");
                    }
                    if (jSONObject7.has("ARRelationShipResourceMd5")) {
                        aRRelationShip.f198395f = jSONObject7.getString("ARRelationShipResourceMd5");
                    }
                    if (jSONObject7.has("AIOMsgImageUrl")) {
                        aRRelationShip.H = jSONObject7.getString("AIOMsgImageUrl");
                    }
                    if (jSONObject7.has("AIOMsgJumpUrl")) {
                        aRRelationShip.G = jSONObject7.getString("AIOMsgJumpUrl");
                    }
                    if (jSONObject7.has("AIOMsgSummary")) {
                        aRRelationShip.F = jSONObject7.getString("AIOMsgSummary");
                    }
                    if (jSONObject7.has("AIOMsgTitle")) {
                        aRRelationShip.E = jSONObject7.getString("AIOMsgTitle");
                    }
                    if (jSONObject7.has("ARRelationShipResourceSize")) {
                        aRRelationShip.D = jSONObject7.getLong("ARRelationShipResourceSize");
                    }
                    if (jSONObject7.has("GuideWebPageUrl")) {
                        aRRelationShip.C = jSONObject7.getString("GuideWebPageUrl");
                    }
                    if (jSONObject7.has("SendMsgSuccessUrl")) {
                        aRRelationShip.f198398m = jSONObject7.getString("SendMsgSuccessUrl");
                    }
                    if (jSONObject7.has("ShareTopicUrl")) {
                        aRRelationShip.f198397i = jSONObject7.getString("ShareTopicUrl");
                    }
                    if (jSONObject7.has("CardDefaultText")) {
                        aRRelationShip.I = jSONObject7.getString("CardDefaultText");
                    }
                    if (jSONObject7.has("StarUin")) {
                        aRRelationShip.J = jSONObject7.getString("StarUin");
                    }
                    if (jSONObject7.has("StarNickName")) {
                        aRRelationShip.K = jSONObject7.getString("StarNickName");
                    }
                    arCloudConfigInfo.J = aRRelationShip;
                }
                if (jSONObject.has("LbsActivity")) {
                    JSONObject jSONObject8 = jSONObject.getJSONObject("LbsActivity");
                    ArLBSActivity arLBSActivity = new ArLBSActivity();
                    if (jSONObject8.has("ActivityName")) {
                        arLBSActivity.f198414d = jSONObject8.getString("ActivityName");
                    }
                    if (jSONObject8.has("Logo")) {
                        arLBSActivity.f198415e = jSONObject8.getString("Logo");
                    }
                    if (jSONObject8.has("MapBackground")) {
                        arLBSActivity.f198416f = jSONObject8.getString("MapBackground");
                    }
                    if (jSONObject8.has("PrizeImage")) {
                        arLBSActivity.f198417h = jSONObject8.getString("PrizeImage");
                    }
                    if (jSONObject8.has("PrizeName")) {
                        arLBSActivity.f198418i = jSONObject8.getString("PrizeName");
                    }
                    if (jSONObject8.has("TipsForOutsideLBSLocation")) {
                        arLBSActivity.f198419m = jSONObject8.getString("TipsForOutsideLBSLocation");
                    }
                    if (jSONObject8.has("TipsTitleForNoLBSLocation")) {
                        arLBSActivity.C = jSONObject8.getString("TipsTitleForNoLBSLocation");
                    }
                    if (jSONObject8.has("TipsContentForNoLBSLocation")) {
                        arLBSActivity.D = jSONObject8.getString("TipsContentForNoLBSLocation");
                    }
                    arCloudConfigInfo.L = arLBSActivity;
                }
                return arCloudConfigInfo;
            } catch (JSONException e16) {
                QLog.i("AREngine_MarkerJsonParser", 1, "parseCloudInfo parse json failed. error msg = " + e16.getMessage());
            }
        }
        return null;
    }
}
