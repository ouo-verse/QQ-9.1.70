package com.tencent.mobileqq.vas.theme.diy;

import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.core.AssetExtension;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ResSuitData {
    public static final int FROM_LOCAL = 0;
    public static final int FROM_NET = 1;
    public static final int FROM_SHOP = 2;
    static final String TAG = "ThemeDiy.ResSuitData";
    public String appStr;
    public int feeType;
    public int from;

    /* renamed from: id, reason: collision with root package name */
    public String f310909id;
    public String name;
    public int resID;
    public int status;
    public String thumbnail;
    public String typeStr;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class BgSuit extends ResSuitData {
        public String aioImg;
        public boolean isdecoded;
        public String previewImg;
        public ResData resData;

        public BgSuit(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("diyThemeBg");
                    JSONObject jSONObject2 = null;
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        jSONObject2 = jSONArray.getJSONObject(i3);
                        if (jSONObject2.optInt("status", 1) == 1) {
                            break;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(ResSuitData.TAG, 2, "loadResJson bg status: " + jSONObject2.optInt("status") + ", name:" + jSONObject.getString("name"));
                        }
                    }
                    if (jSONObject2 == null) {
                        return;
                    }
                    this.f310909id = jSONObject.optString("id");
                    this.appStr = jSONObject.optString("app");
                    this.typeStr = jSONObject.optString("type");
                    this.name = jSONObject.optString("name");
                    this.feeType = jSONObject2.optInt(VipFunCallConstants.KEY_FEET_TYPE);
                    this.thumbnail = jSONObject2.optString(AssetExtension.SCENE_THUMBNAIL);
                    this.previewImg = jSONObject2.optString("previewImg");
                    this.aioImg = jSONObject2.optString("aioImg");
                    this.isdecoded = true;
                } catch (Exception unused) {
                    QLog.e(ResSuitData.TAG, 1, "theme BgSuit JSONErr name:" + this.name + ", id:" + this.f310909id);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class StyleSuit extends ResSuitData {
        public ArrayList<ResSuitData> bgSuits;
        public String chatFrontImg;
        public boolean isInShop;
        public String msgFrontImg;
        public String setFrontImg;
        ThemeUtil.ThemeInfo themeInfo;
        public int zipSize;
        public String zipUrl;
        public String zipVersion;
    }
}
