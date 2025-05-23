package com.tencent.filament.zplan.avatar;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.avatar.model.ZPlanCommonGltfFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanDressUpFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanDressUpFAssetInfo;
import com.tencent.filament.zplan.avatar.model.ZPlanFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanFAssetInfo;
import com.tencent.filament.zplan.avatar.model.ZPlanMakeUpFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanMakeUpFAssetInfo;
import com.tencent.filament.zplan.avatar.model.ZPlanPinchFaceModel;
import com.tencent.filament.zplan.avatar.model.ZPlanUgcFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanUgcFAssetInfo;
import com.tencent.filament.zplanservice.download.ZPlanAvatarFileDownloadDescriptor;
import com.tencent.filament.zplanservice.download.ZPlanAvatarInterfaceResult;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a1\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\n\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u001aA\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u000e2\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u001a\u001a\u00020\u0000H\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001e"}, d2 = {"Lorg/json/JSONObject;", "avatarPbJson", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "avatarResourceResult", "", "aiBodyDriveJsonPath", "Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "a", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "e", "ugcMapJSONObject", "", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarFileDownloadDescriptor;", "allFiles", "", "Lcom/tencent/filament/zplan/avatar/model/ZPlanUgcFAsset;", "d", "(Lorg/json/JSONObject;[Lcom/tencent/filament/zplanservice/download/ZPlanAvatarFileDownloadDescriptor;)Ljava/util/Map;", "Lorg/json/JSONArray;", "controlPoints", "", "Lcom/tencent/filament/zplan/avatar/model/ZPlanPinchFaceModel;", "b", "slotGltfMapObject", "slotTextureMapObject", "all_files", "avatarCharacter", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAsset;", "c", "(Lorg/json/JSONObject;Lorg/json/JSONObject;[Lcom/tencent/filament/zplanservice/download/ZPlanAvatarFileDownloadDescriptor;Lorg/json/JSONObject;)Ljava/util/Map;", "zplan-android_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class f {
    @NotNull
    public static final ReloadAvatarResourceModel a(@NotNull JSONObject avatarPbJson, @NotNull ZPlanAvatarInterfaceResult avatarResourceResult, @NotNull String aiBodyDriveJsonPath) throws JSONException {
        Intrinsics.checkNotNullParameter(avatarPbJson, "avatarPbJson");
        Intrinsics.checkNotNullParameter(avatarResourceResult, "avatarResourceResult");
        Intrinsics.checkNotNullParameter(aiBodyDriveJsonPath, "aiBodyDriveJsonPath");
        JSONObject jSONObject = new JSONObject(avatarResourceResult.getResult());
        JSONObject jSONObject2 = jSONObject.getJSONObject("dressUpInfo").getJSONObject("slotGltfMap");
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "cppAvatarJson.getJSONObj\u2026JSONObject(\"slotGltfMap\")");
        JSONObject jSONObject3 = jSONObject.getJSONObject("makeUpInfo").getJSONObject("slotMakeupTextureMap");
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "cppAvatarJson.getJSONObj\u2026t(\"slotMakeupTextureMap\")");
        Map<String, ZPlanFAsset> c16 = c(jSONObject2, jSONObject3, avatarResourceResult.getAllFiles(), avatarPbJson);
        JSONArray jSONArray = jSONObject.getJSONObject("pinchFace").getJSONObject("userData").getJSONArray("control_points");
        Intrinsics.checkNotNullExpressionValue(jSONArray, "cppAvatarJson.getJSONObj\u2026ONArray(\"control_points\")");
        List<ZPlanPinchFaceModel> b16 = b(jSONArray);
        JSONObject jSONObject4 = jSONObject.getJSONObject("ugcResMap");
        Intrinsics.checkNotNullExpressionValue(jSONObject4, "cppAvatarJson.getJSONObject(\"ugcResMap\")");
        Map<String, ZPlanUgcFAsset> d16 = d(jSONObject4, avatarResourceResult.getAllFiles());
        String string = jSONObject.getJSONObject("pinchFace").getString("configJsonPath");
        EnumUserGender e16 = e(avatarPbJson);
        double d17 = jSONObject.getDouble("pantsLength");
        double d18 = jSONObject.getDouble("shoesHeight");
        String string2 = jSONObject.getString("bodyTypeConfigPath");
        Intrinsics.checkNotNullExpressionValue(string2, "cppAvatarJson.getString(\"bodyTypeConfigPath\")");
        return new ReloadAvatarResourceModel(c16, string, b16, null, e16, d17, d18, string2, aiBodyDriveJsonPath, d16);
    }

    private static final List<ZPlanPinchFaceModel> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            arrayList.add(new ZPlanPinchFaceModel(jSONObject.optLong("groupID"), jSONObject.optDouble(com.tencent.luggage.wxa.c8.c.G)));
        }
        return arrayList;
    }

    private static final Map<String, ZPlanFAsset> c(JSONObject jSONObject, JSONObject jSONObject2, ZPlanAvatarFileDownloadDescriptor[] zPlanAvatarFileDownloadDescriptorArr, JSONObject jSONObject3) {
        int i3;
        int lastIndexOf$default;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        ZPlanCommonGltfFAsset zPlanCommonGltfFAsset;
        ZPlanAvatarFileDownloadDescriptor[] zPlanAvatarFileDownloadDescriptorArr2 = zPlanAvatarFileDownloadDescriptorArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "slotGltfMapObject.keys()");
        while (true) {
            i3 = 0;
            if (!keys.hasNext()) {
                break;
            }
            String slot = (String) keys.next();
            Object obj = jSONObject.get(slot);
            int length = zPlanAvatarFileDownloadDescriptorArr2.length;
            int i16 = 0;
            while (true) {
                if (i16 < length) {
                    ZPlanAvatarFileDownloadDescriptor zPlanAvatarFileDownloadDescriptor = zPlanAvatarFileDownloadDescriptorArr2[i16];
                    if (!(!Intrinsics.areEqual(zPlanAvatarFileDownloadDescriptor.getLocalSavePath(), obj))) {
                        String url = zPlanAvatarFileDownloadDescriptor.getUrl();
                        JSONObject optJSONObject = jSONObject3.optJSONObject("avatar_info");
                        if (optJSONObject != null && (optJSONArray2 = optJSONObject.optJSONArray("slot_arr")) != null) {
                            int length2 = optJSONArray2.length();
                            long j3 = 0;
                            long j16 = 0;
                            while (i3 < length2) {
                                JSONObject jSONObject4 = optJSONArray2.getJSONObject(i3);
                                if (!(!Intrinsics.areEqual(String.valueOf(jSONObject4.optLong(MiniAppReportManager2.KEY_SLOT_ID)), slot))) {
                                    j3 = jSONObject4.optLong(MiniAppReportManager2.KEY_SLOT_ID);
                                    j16 = jSONObject4.optLong("item_id");
                                }
                                i3++;
                            }
                            if (j16 != 0) {
                                zPlanCommonGltfFAsset = new ZPlanDressUpFAsset(new ZPlanDressUpFAssetInfo(j3, j16, url), (String) obj);
                            } else {
                                Intrinsics.checkNotNullExpressionValue(slot, "slot");
                                zPlanCommonGltfFAsset = new ZPlanCommonGltfFAsset(new ZPlanFAssetInfo(slot, url), (String) obj);
                            }
                            linkedHashMap.put(zPlanCommonGltfFAsset.getAssetInfo().getSlot(), zPlanCommonGltfFAsset);
                        }
                    }
                    i16++;
                }
            }
        }
        Iterator keys2 = jSONObject2.keys();
        Intrinsics.checkNotNullExpressionValue(keys2, "slotTextureMapObject.keys()");
        while (keys2.hasNext()) {
            JSONObject optJSONObject2 = jSONObject2.optJSONObject((String) keys2.next());
            if (optJSONObject2 != null) {
                String pngPath = optJSONObject2.optString("pngPath");
                Intrinsics.checkNotNullExpressionValue(pngPath, "pngPath");
                lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) pngPath, '/', 0, false, 6, (Object) null);
                if (pngPath != null) {
                    String substring = pngPath.substring(i3, lastIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    int length3 = zPlanAvatarFileDownloadDescriptorArr2.length;
                    int i17 = i3;
                    while (i17 < length3) {
                        ZPlanAvatarFileDownloadDescriptor zPlanAvatarFileDownloadDescriptor2 = zPlanAvatarFileDownloadDescriptorArr2[i17];
                        if (!(!Intrinsics.areEqual(zPlanAvatarFileDownloadDescriptor2.getLocalSavePath(), substring))) {
                            String url2 = zPlanAvatarFileDownloadDescriptor2.getUrl();
                            JSONObject optJSONObject3 = jSONObject3.optJSONObject("makeup_info");
                            if (optJSONObject3 != null && (optJSONArray = optJSONObject3.optJSONArray("slot_arr")) != null) {
                                int length4 = optJSONArray.length();
                                int i18 = i3;
                                while (true) {
                                    if (i18 < length4) {
                                        JSONObject jSONObject5 = optJSONArray.getJSONObject(i18);
                                        if (!Intrinsics.areEqual(String.valueOf(jSONObject5.optLong(MiniAppReportManager2.KEY_SLOT_ID)), r4)) {
                                            i18++;
                                        } else {
                                            ZPlanMakeUpFAsset zPlanMakeUpFAsset = new ZPlanMakeUpFAsset(new ZPlanMakeUpFAssetInfo(jSONObject5.optLong(MiniAppReportManager2.KEY_SLOT_ID), jSONObject5.optLong("item_id"), url2), substring);
                                            linkedHashMap.put(zPlanMakeUpFAsset.getAssetInfo().getSlot(), zPlanMakeUpFAsset);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        i17++;
                        zPlanAvatarFileDownloadDescriptorArr2 = zPlanAvatarFileDownloadDescriptorArr;
                        i3 = 0;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            zPlanAvatarFileDownloadDescriptorArr2 = zPlanAvatarFileDownloadDescriptorArr;
        }
        return linkedHashMap;
    }

    private static final Map<String, ZPlanUgcFAsset> d(JSONObject jSONObject, ZPlanAvatarFileDownloadDescriptor[] zPlanAvatarFileDownloadDescriptorArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "ugcMapJSONObject.keys()");
        while (keys.hasNext()) {
            String slot = (String) keys.next();
            String optString = jSONObject.optString(slot);
            int length = zPlanAvatarFileDownloadDescriptorArr.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    ZPlanAvatarFileDownloadDescriptor zPlanAvatarFileDownloadDescriptor = zPlanAvatarFileDownloadDescriptorArr[i3];
                    if (Intrinsics.areEqual(zPlanAvatarFileDownloadDescriptor.getLocalSavePath(), optString)) {
                        Intrinsics.checkNotNullExpressionValue(slot, "slot");
                        linkedHashMap.put(slot, new ZPlanUgcFAsset(new ZPlanUgcFAssetInfo(Integer.parseInt(slot), 0L, zPlanAvatarFileDownloadDescriptor.getUrl(), false, 8, null), optString));
                        break;
                    }
                    i3++;
                }
            }
        }
        return linkedHashMap;
    }

    private static final EnumUserGender e(JSONObject jSONObject) {
        EnumUserGender a16 = EnumUserGender.INSTANCE.a(jSONObject.optInt("gender"));
        if (a16 == EnumUserGender.GENDER_UNINIT) {
            return EnumUserGender.GENDER_FEMALE;
        }
        return a16;
    }
}
