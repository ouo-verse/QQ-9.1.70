package com.tencent.aelight.camera.ae.data;

import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaAdditionalPackage;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.device.DeviceUtils;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.light.DeviceSupportUtil;
import org.light.device.OfflineConfig;
import xq.c;

/* loaded from: classes32.dex */
public class AEMaterialConfigParser {

    /* renamed from: a, reason: collision with root package name */
    private static final String f63514a = "AEMaterialConfigParser";

    /* renamed from: b, reason: collision with root package name */
    public static int f63515b = 4;

    /* loaded from: classes32.dex */
    public static class AEMaterialConfigParseException extends Exception {
        public AEMaterialConfigParseException(String str) {
            super(str);
        }
    }

    private static Integer a(Map<String, String> map, String str) {
        try {
            String str2 = map.get(str);
            if (str2 != null) {
                return Integer.valueOf(Integer.parseInt(str2));
            }
            return null;
        } catch (Throwable th5) {
            QLog.d(f63514a, 4, "parse " + str + " fail:" + th5.getMessage());
            return null;
        }
    }

    public static void b(List<MetaCategory> list, List<AEMaterialCategory> list2) {
        if (list == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (MetaCategory metaCategory : list) {
            AEMaterialCategory aEMaterialCategory = new AEMaterialCategory();
            aEMaterialCategory.f69047h = metaCategory.name;
            try {
                aEMaterialCategory.f69045e = Integer.parseInt(metaCategory.f30532id);
            } catch (Exception unused) {
                ms.a.c(f63514a, "categoryid is not integer " + metaCategory.f30532id);
            }
            ArrayList<MetaCategory> arrayList = metaCategory.subCategories;
            if (arrayList != null && arrayList.size() > 0) {
                aEMaterialCategory.D = metaCategory.subCategories;
            }
            Map<String, String> map = metaCategory.dynamicFields;
            if (map != null && map.containsKey("isShowMaterial")) {
                aEMaterialCategory.C = "true".equalsIgnoreCase(metaCategory.dynamicFields.get("isShowMaterial"));
            }
            aEMaterialCategory.f69044d = new ArrayList();
            Iterator<MetaMaterial> it = metaCategory.materials.iterator();
            while (it.hasNext()) {
                MetaMaterial next = it.next();
                if (!next.f30533id.contains(AECameraConstants.FILAMENT_MATERIAL_PREFIX) || AEMaterialManager.G0()) {
                    if (!next.f30533id.contains(AECameraConstants.HAIRCOLOR_MATERIAL_PREFIX) || (DeviceUtils.hasDeviceNormal(BaseApplication.getContext()) && AEMaterialManager.H0())) {
                        if (hashMap.containsKey(next.f30533id) && hashMap.get(next.f30533id) != null) {
                            aEMaterialCategory.f69044d.add((AEMaterialMetaData) hashMap.get(next.f30533id));
                        } else {
                            AEMaterialMetaData aEMaterialMetaData = new AEMaterialMetaData();
                            aEMaterialMetaData.iconurl = next.thumbUrl;
                            aEMaterialMetaData.md5 = next.packageMd5;
                            Map<String, String> map2 = next.additionalFields;
                            if (map2 != null) {
                                try {
                                    aEMaterialMetaData.kind = Integer.parseInt(map2.get("kind"));
                                } catch (Throwable unused2) {
                                }
                                try {
                                    aEMaterialMetaData.displayType = Integer.parseInt(map2.get("displayType"));
                                } catch (Throwable unused3) {
                                }
                                aEMaterialMetaData.cameraTitle = map2.get(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE);
                                aEMaterialMetaData.cameraScheme = map2.get(PeakConstants.KEY_QQ_CAMERA_SCHEME);
                                aEMaterialMetaData.playShowCoverImg = map2.get("playshow_cover_img");
                                aEMaterialMetaData.playShowDisplayText = map2.get("playshow_display_text");
                                aEMaterialMetaData.takeSameName = map2.get("takeSameName");
                                aEMaterialMetaData.minimumDeviceLevel = map2.get("minimum_device_level");
                                aEMaterialMetaData.orderFemale = map2.get("orderForFemale");
                                aEMaterialMetaData.shieldDevices = map2.get("shield_devices");
                                aEMaterialMetaData.recommendReason = map2.get("recommend_reason");
                                aEMaterialMetaData.cosmeticName = map2.get("cosmetic_name");
                                aEMaterialMetaData.arkInfoJson = map2.get("ark_info_json");
                                aEMaterialMetaData.activityHidden = map2.get("activity_hidden");
                                aEMaterialMetaData.activityType = a(map2, "activity_type");
                                aEMaterialMetaData.yuhengRuleId = a(map2, QQWinkConstants.KEY_MATE_YUHENG_RULE_ID);
                                aEMaterialMetaData.yuhengActivityId = a(map2, QQWinkConstants.KEY_MATE_YUHENG_ACTIVITY_ID);
                                aEMaterialMetaData.yuhengTaskId = a(map2, QQWinkConstants.KEY_MATE_YUHENG_TASK_ID);
                                aEMaterialMetaData.activityUIStyleString = map2.get("activity_ui_style");
                                String str = map2.get("cosmetic_sliding_value");
                                try {
                                    if (TextUtils.isEmpty(str)) {
                                        aEMaterialMetaData.cosmeticSlidingValue = 100;
                                    } else {
                                        aEMaterialMetaData.cosmeticSlidingValue = Integer.valueOf(str).intValue();
                                    }
                                    if (!TextUtils.isEmpty(map2.get("showCircleTakeSame"))) {
                                        aEMaterialMetaData.showCircleTakeSame = Integer.valueOf(map2.get("showCircleTakeSame")).intValue();
                                    } else {
                                        aEMaterialMetaData.showCircleTakeSame = 0;
                                    }
                                } catch (Throwable unused4) {
                                }
                                aEMaterialMetaData.showEntry = map2.get("showEntry");
                                aEMaterialMetaData.isZplanMaterial = map2.get("isZplan");
                                aEMaterialMetaData.zplanRenderType = map2.get("zplanRenderType");
                                aEMaterialMetaData.isSupportChangeSuit = Objects.equals(map2.get("supportChangeSuit"), "1");
                                aEMaterialMetaData.aigcMaterial = Boolean.valueOf(Objects.equals(map2.get("supportAIGC"), "1"));
                                aEMaterialMetaData.challengeTopic = map2.get(QCircleScheme.AttrQQPublish.CHALLENGE_TAG);
                                aEMaterialMetaData.guidePic = map2.get("guidePic");
                                String str2 = map2.get("mask");
                                if (!TextUtils.isEmpty(str2)) {
                                    aEMaterialMetaData.mask = new ArrayList<>(Arrays.asList(str2.split(",")));
                                }
                            }
                            String str3 = map2 != null ? map2.get("topic") : null;
                            if (!TextUtils.isEmpty(str3)) {
                                aEMaterialMetaData.topic = str3;
                            }
                            String str4 = map2 != null ? map2.get("publish_text") : null;
                            if (!TextUtils.isEmpty(str4)) {
                                aEMaterialMetaData.content = str4;
                            }
                            aEMaterialMetaData.f69050id = next.f30533id;
                            if ("1".equals(aEMaterialMetaData.isZplanMaterial) && "1".equals(aEMaterialMetaData.zplanRenderType)) {
                                c.f448345a.addZplanFilamentMaterialMap(aEMaterialMetaData.f69050id);
                                if (!DeviceSupportUtil.isAbilityDeviceSupport("ai.face3d")) {
                                    QLog.d(f63514a, 4, "Filament is not enable, can not show material id: " + aEMaterialMetaData.f69050id);
                                }
                            }
                            boolean e16 = e(aEMaterialMetaData);
                            aEMaterialMetaData.showStatus = e16;
                            if (!e16) {
                                QLog.d(f63514a, 4, "can not show material id :" + aEMaterialMetaData.f69050id);
                            } else {
                                c(aEMaterialMetaData, next);
                                if (!TextUtils.isEmpty(aEMaterialMetaData.resurl)) {
                                    aEMaterialMetaData.name = next.f30533id;
                                    aEMaterialCategory.f69044d.add(aEMaterialMetaData);
                                    hashMap.put(next.f30533id, aEMaterialMetaData);
                                }
                                aEMaterialMetaData.showName = next.showName;
                            }
                        }
                    }
                }
            }
            list2.add(aEMaterialCategory);
        }
    }

    private static void c(AEMaterialMetaData aEMaterialMetaData, MetaMaterial metaMaterial) {
        MetaAdditionalPackage metaAdditionalPackage = metaMaterial.additionalPackage;
        if (metaAdditionalPackage == null) {
            aEMaterialMetaData.resurl = metaMaterial.packageUrl;
            aEMaterialMetaData.md5 = metaMaterial.packageMd5;
        } else if (TextUtils.isEmpty(metaAdditionalPackage.superLowPackageUrl) && TextUtils.isEmpty(metaMaterial.additionalPackage.lowPackageUrl) && TextUtils.isEmpty(metaMaterial.additionalPackage.midPackageUrl) && TextUtils.isEmpty(metaMaterial.additionalPackage.highPackageUrl)) {
            aEMaterialMetaData.resurl = metaMaterial.packageUrl;
            aEMaterialMetaData.md5 = metaMaterial.packageMd5;
        } else {
            MetaAdditionalPackage metaAdditionalPackage2 = metaMaterial.additionalPackage;
            String[] strArr = {metaAdditionalPackage2.superLowPackageUrl, metaAdditionalPackage2.lowPackageUrl, metaAdditionalPackage2.midPackageUrl, metaAdditionalPackage2.highPackageUrl, metaMaterial.packageUrl};
            String[] strArr2 = {metaAdditionalPackage2.superLowPackageMd5, metaAdditionalPackage2.lowPackageMd5, metaAdditionalPackage2.midPackageMd5, metaAdditionalPackage2.highPackageMd5, metaMaterial.packageMd5};
            int phonePerfLevel = OfflineConfig.getPhonePerfLevel(BaseApplication.getContext()) - 1;
            if (!TextUtils.isEmpty(strArr[phonePerfLevel])) {
                aEMaterialMetaData.resurl = strArr[phonePerfLevel];
                aEMaterialMetaData.md5 = strArr2[phonePerfLevel];
            } else {
                aEMaterialMetaData.resurl = null;
                aEMaterialMetaData.md5 = null;
            }
        }
        String str = metaMaterial.packageUrl;
        if (str == null || str.equals(aEMaterialMetaData.resurl)) {
            return;
        }
        aEMaterialMetaData.isDowngrade = true;
        ms.a.a(f63514a, "[parseDowngradeInfo][material_downgrade] \u964d\u7ea7\u5b8c\u6210 : " + aEMaterialMetaData.resurl);
    }

    public static ArrayList<AEMaterialCategory> d(String str) throws AEMaterialConfigParseException {
        ArrayList<MetaCategory> arrayList;
        ArrayList<AEMaterialCategory> arrayList2 = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList2;
        }
        try {
            GetCategoryMaterialRsp getCategoryMaterialRsp = (GetCategoryMaterialRsp) new Gson().fromJson(str, GetCategoryMaterialRsp.class);
            if (getCategoryMaterialRsp != null && (arrayList = getCategoryMaterialRsp.Categories) != null) {
                b(arrayList, arrayList2);
            }
            return arrayList2;
        } catch (Exception e16) {
            QLog.d(f63514a, 4, "###  parseMaterialListFromConfig exception = " + e16.getMessage());
            throw new AEMaterialConfigParseException("parseMaterialListFromConfig error");
        }
    }

    private static boolean e(AEMaterialMetaData aEMaterialMetaData) {
        if (aEMaterialMetaData == null) {
            return true;
        }
        if (dr.c.a(aEMaterialMetaData.minimumDeviceLevel) > dr.c.b()) {
            ms.a.a(f63514a, "can not show level :" + aEMaterialMetaData.minimumDeviceLevel);
            return false;
        }
        if (aEMaterialMetaData.shieldDevices != null) {
            String c16 = dr.c.c();
            ms.a.a(f63514a, "can not show curModel :" + c16);
            if (aEMaterialMetaData.shieldDevices.contains(c16)) {
                return false;
            }
        }
        return true;
    }
}
