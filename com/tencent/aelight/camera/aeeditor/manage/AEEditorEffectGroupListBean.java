package com.tencent.aelight.camera.aeeditor.manage;

import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.qcircle.weseevideo.model.template.movie.AIAbilityModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEEditorEffectGroupListBean implements Serializable {
    public static final String TAG = "AEEditorEffectGroupListBean";
    public String version = "";
    public List<AEEditorEffectGroupItem> effectGroups = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class AEEditorEffectGroupItem implements Serializable {
        public String effectGroupID = "";
        public String effectGroupName = "";
        public List<AEEditorEffectItem> effects = new ArrayList();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class AEEditorEffectItem implements Serializable {
        public static final int STYLIZE_TYPE_COMIC = 1;
        public static final int STYLIZE_TYPE_PAINTING = 2;
        private int uploadMaxSize;
        private String effectID = "";
        private String effectName = "";
        private String thumbURL = "";
        private int hideApplyAll = 0;
        private int hideAlphaBar = 0;
        private int disableForImage = 0;
        private int disableForVideo = 0;
        private int imageShowLevel = 0;
        private int videoShowLevel = 0;
        private String effectType = "client";
        private int netStylizeType = 0;
        private int preDownload = 0;
        private String resourceMD5 = "";
        private String resourceURL = "";

        public int getDisableForImage() {
            return this.disableForImage;
        }

        public int getDisableForVideo() {
            return this.disableForVideo;
        }

        public String getEffectID() {
            return this.effectID;
        }

        public String getEffectName() {
            return this.effectName;
        }

        public String getEffectType() {
            return this.effectType;
        }

        public int getHideAlphaBar() {
            return this.hideAlphaBar;
        }

        public int getHideApplyAll() {
            return this.hideApplyAll;
        }

        public int getImageShowLevel() {
            return this.imageShowLevel;
        }

        public int getPreDownload() {
            return this.preDownload;
        }

        public String getResourceMD5() {
            return this.resourceMD5;
        }

        public String getResourceURL() {
            return this.resourceURL;
        }

        public int getStylizeType() {
            return this.netStylizeType;
        }

        public String getThumbURL() {
            return this.thumbURL;
        }

        public int getUploadMaxSize() {
            return this.uploadMaxSize;
        }

        public int getVideoShowLevel() {
            return this.videoShowLevel;
        }

        public void setHideApplyAll(int i3) {
            this.hideApplyAll = i3;
        }
    }

    public static AEEditorEffectGroupListBean parse(String str) {
        AEEditorEffectGroupListBean aEEditorEffectGroupListBean = new AEEditorEffectGroupListBean();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                aEEditorEffectGroupListBean.version = jSONObject.optString("version");
                b(aEEditorEffectGroupListBean.effectGroups, jSONObject.optJSONArray("effectGroups"));
            } catch (Exception e16) {
                ms.a.c(TAG, e16.toString());
            }
        }
        return aEEditorEffectGroupListBean;
    }

    public static AEEditorEffectItem parseEffectList(MetaMaterial metaMaterial) {
        AEEditorEffectItem aEEditorEffectItem = new AEEditorEffectItem();
        aEEditorEffectItem.effectID = metaMaterial.f30533id;
        aEEditorEffectItem.thumbURL = metaMaterial.thumbUrl;
        if (!TextUtils.isEmpty(metaMaterial.additionalFields.get("name"))) {
            aEEditorEffectItem.effectName = metaMaterial.additionalFields.get("name");
        }
        if (!TextUtils.isEmpty(metaMaterial.additionalFields.get("hideApplyAll"))) {
            aEEditorEffectItem.hideApplyAll = Integer.parseInt(metaMaterial.additionalFields.get("hideApplyAll"));
        }
        if (!TextUtils.isEmpty(metaMaterial.additionalFields.get("hideAlphaBar"))) {
            aEEditorEffectItem.hideAlphaBar = Integer.parseInt(metaMaterial.additionalFields.get("hideAlphaBar"));
        }
        if (!TextUtils.isEmpty(metaMaterial.additionalFields.get("disableForImage"))) {
            aEEditorEffectItem.disableForImage = Integer.parseInt(metaMaterial.additionalFields.get("disableForImage"));
        }
        if (!TextUtils.isEmpty(metaMaterial.additionalFields.get("disableForVideo"))) {
            aEEditorEffectItem.disableForVideo = Integer.parseInt(metaMaterial.additionalFields.get("disableForVideo"));
        }
        if (!TextUtils.isEmpty(metaMaterial.additionalFields.get("imageShowLevel"))) {
            aEEditorEffectItem.imageShowLevel = Integer.parseInt(metaMaterial.additionalFields.get("imageShowLevel"));
        }
        if (!TextUtils.isEmpty(metaMaterial.additionalFields.get("videoShowLevel"))) {
            aEEditorEffectItem.videoShowLevel = Integer.parseInt(metaMaterial.additionalFields.get("videoShowLevel"));
        }
        if (!TextUtils.isEmpty(metaMaterial.additionalFields.get(AIAbilityModel.AI_KEY))) {
            aEEditorEffectItem.effectType = metaMaterial.additionalFields.get(AIAbilityModel.AI_KEY);
        }
        if (!TextUtils.isEmpty(metaMaterial.additionalFields.get("netStylizeType"))) {
            aEEditorEffectItem.netStylizeType = Integer.parseInt(metaMaterial.additionalFields.get("netStylizeType"));
        }
        if (!TextUtils.isEmpty(metaMaterial.additionalFields.get("preDownload"))) {
            aEEditorEffectItem.preDownload = Integer.parseInt(metaMaterial.additionalFields.get("preDownload"));
        }
        if (!TextUtils.isEmpty(metaMaterial.additionalFields.get("uploadMaxSize"))) {
            aEEditorEffectItem.uploadMaxSize = Integer.parseInt(metaMaterial.additionalFields.get("uploadMaxSize"));
        }
        aEEditorEffectItem.resourceMD5 = metaMaterial.packageMd5;
        aEEditorEffectItem.resourceURL = metaMaterial.packageUrl;
        return aEEditorEffectItem;
    }

    private static void a(List<AEEditorEffectItem> list, JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                AEEditorEffectItem aEEditorEffectItem = new AEEditorEffectItem();
                aEEditorEffectItem.effectID = optJSONObject.optString("effectID");
                aEEditorEffectItem.effectName = optJSONObject.optString("effectName");
                aEEditorEffectItem.thumbURL = optJSONObject.optString("thumbURL");
                aEEditorEffectItem.hideApplyAll = optJSONObject.optInt("hideApplyAll");
                aEEditorEffectItem.hideAlphaBar = optJSONObject.optInt("hideAlphaBar");
                aEEditorEffectItem.disableForImage = optJSONObject.optInt("disableForImage");
                aEEditorEffectItem.disableForVideo = optJSONObject.optInt("disableForVideo");
                aEEditorEffectItem.imageShowLevel = optJSONObject.optInt("imageShowLevel");
                aEEditorEffectItem.videoShowLevel = optJSONObject.optInt("videoShowLevel");
                aEEditorEffectItem.effectType = optJSONObject.optString(AIAbilityModel.AI_KEY);
                aEEditorEffectItem.netStylizeType = optJSONObject.optInt("netStylizeType");
                aEEditorEffectItem.preDownload = optJSONObject.optInt("preDownload");
                aEEditorEffectItem.resourceMD5 = optJSONObject.optString("resourceMD5");
                aEEditorEffectItem.resourceURL = optJSONObject.optString("resourceURL");
                aEEditorEffectItem.uploadMaxSize = optJSONObject.optInt("uploadMaxSize");
                list.add(aEEditorEffectItem);
            }
            return;
        }
        ms.a.c(TAG, "effect list is empty.");
    }

    private static void b(List<AEEditorEffectGroupItem> list, JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                AEEditorEffectGroupItem aEEditorEffectGroupItem = new AEEditorEffectGroupItem();
                aEEditorEffectGroupItem.effectGroupID = optJSONObject.optString("effectGroupID");
                aEEditorEffectGroupItem.effectGroupName = optJSONObject.optString("effectGroupName");
                a(aEEditorEffectGroupItem.effects, optJSONObject.optJSONArray(JsonUtils.KEY_EFFECTS));
                list.add(aEEditorEffectGroupItem);
            }
            return;
        }
        ms.a.c(TAG, "group list empty.");
    }
}
