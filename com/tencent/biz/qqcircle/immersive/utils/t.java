package com.tencent.biz.qqcircle.immersive.utils;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudRead$StTemplateInfo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class t {
    public static String a(String str, String str2, String str3, String str4, String str5, FeedCloudRead$StTemplateInfo feedCloudRead$StTemplateInfo) {
        StringBuilder sb5 = new StringBuilder(str);
        if (!TextUtils.isEmpty(str2)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("mediapath");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(str2);
        }
        if (!TextUtils.isEmpty(str5)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("lib_template_id");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(str5);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("local_template_path");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(str4);
            sb5.append(File.separator);
            sb5.append(TemplateBean.TEMPLATE_JSON);
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = b(feedCloudRead$StTemplateInfo);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("key_template_asset");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(str3);
        }
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("pick_template_media_holder_count");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(1);
        return sb5.toString();
    }

    public static String b(FeedCloudRead$StTemplateInfo feedCloudRead$StTemplateInfo) {
        JSONObject jSONObject = new JSONObject();
        if (feedCloudRead$StTemplateInfo != null) {
            try {
                jSONObject.put("nickName", feedCloudRead$StTemplateInfo.nickWord.get());
                jSONObject.put("locationLabel", feedCloudRead$StTemplateInfo.locationMapWord.get());
                jSONObject.put("describeLabel", feedCloudRead$StTemplateInfo.descMapWord.get());
                jSONObject.put("ageLabel", feedCloudRead$StTemplateInfo.ageMapWord.get());
                jSONObject.put("constellationLabel", feedCloudRead$StTemplateInfo.starMapWord.get());
                jSONObject.put("settlementTimeLabel", feedCloudRead$StTemplateInfo.timeMapWord.get());
                jSONObject.put("dayLabel", feedCloudRead$StTemplateInfo.dayLabelWord.get());
                jSONObject.put("monthLabel", feedCloudRead$StTemplateInfo.monthLabelWord.get());
                jSONObject.put("gender", feedCloudRead$StTemplateInfo.genderMapWord.get());
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        } else {
            Log.e("QFSDataConvertUtils", "getTemplateAssetParamsJson templateInfo is null");
        }
        return jSONObject.toString();
    }

    public static String c(PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField, String str) {
        PBStringField pBStringField;
        if (pBRepeatMessageField == null) {
            return "";
        }
        for (int i3 = 0; i3 < pBRepeatMessageField.size(); i3++) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = pBRepeatMessageField.get(i3);
            if (feedCloudCommon$Entry != null && (pBStringField = feedCloudCommon$Entry.key) != null && feedCloudCommon$Entry.value != null && TextUtils.equals(pBStringField.get(), str)) {
                return feedCloudCommon$Entry.value.get();
            }
        }
        return "";
    }
}
