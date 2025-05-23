package com.tencent.ad.tangram.views.form;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.views.form.textbox.AdFormItemTextBoxData;
import com.tencent.ad.tangram.views.xijing.AdTextData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdFormDataBuilder {
    private static final String TAG = "AdFormDataBuilder";

    @Nullable
    public static AdFormData build(Context context, @NonNull JSONObject jSONObject, int i3) {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdLog.e(TAG, "getFormComponent error");
            return null;
        }
        AdFormData adFormData = new AdFormData();
        try {
            adFormData.formId = jSONObject.getLong("formId");
            adFormData.padding = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 60);
            adFormData.backgroundColor = getColor(jSONObject.getString("backgroundColor"), 0);
            JSONObject jSONObject2 = jSONObject.getJSONObject("title");
            if (jSONObject2.getBoolean(NodeProps.VISIBLE)) {
                AdTextData adTextData = new AdTextData();
                adFormData.title = adTextData;
                adTextData.text = jSONObject2.getString("text");
                adFormData.title.color = getColor(jSONObject2.getString("fontColor"), 0);
                adFormData.title.size = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject2.getInt("fontSize"));
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("submitButton");
            adFormData.button.text.text = jSONObject3.getString("text");
            adFormData.button.text.color = getColor(jSONObject3.getString("fontColor"), 0);
            adFormData.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 40);
            adFormData.button.borderCornerRadius = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 6);
            adFormData.button.backgroundColor = getColor(jSONObject3.getString("backgroundColor"), 0);
            adFormData.buttonHeight = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 124);
            adFormData.table.borderCornerRadius = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 6);
            adFormData.table.borderWidth = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 3);
            adFormData.table.borderColor = getColor("#EAEAEB", 0);
            adFormData.table.borderColorError = getColor("#FE6C6C", 0);
            JSONArray jSONArray = jSONObject.getJSONArray("items");
            if (jSONArray.length() <= 0) {
                AdLog.e(TAG, "getFormComponent error");
                return null;
            }
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                if (!adFormData.table.addItem(getFormItem(context, jSONArray.getJSONObject(i16), i3))) {
                    AdLog.e(TAG, "getFormComponent error");
                }
            }
            return adFormData;
        } catch (JSONException e16) {
            AdLog.e(TAG, "getFormComponent", e16);
            return null;
        }
    }

    private static int getColor(String str, int i3) {
        try {
            return Color.parseColor(str);
        } catch (Throwable th5) {
            AdLog.e(TAG, "getColor error", th5);
            return i3;
        }
    }

    @Nullable
    private static AdFormItemData getFormItem(Context context, @NonNull JSONObject jSONObject, int i3) {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdLog.e(TAG, "getFormItem error");
            return null;
        }
        try {
            int i16 = jSONObject.getInt("type");
            if (i16 != 0) {
                AdLog.e(TAG, "getFormItem error");
                return null;
            }
            return getFormItemTextBox(context, jSONObject, i3, i16);
        } catch (JSONException e16) {
            AdLog.e(TAG, "getFormItem", e16);
            return null;
        }
    }

    @Nullable
    private static AdFormItemTextBoxData getFormItemTextBox(Context context, @NonNull JSONObject jSONObject, int i3, int i16) {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdLog.e(TAG, "getFormItemTextBox error");
            return null;
        }
        AdFormItemTextBoxData adFormItemTextBoxData = new AdFormItemTextBoxData();
        if (!initFormItem(context, jSONObject, i3, adFormItemTextBoxData, i16)) {
            AdLog.e(TAG, "getFormItemTextBox error");
            return null;
        }
        adFormItemTextBoxData.regexType = jSONObject.optInt("regexType", Integer.MIN_VALUE);
        adFormItemTextBoxData.content.color = getColor("#333333", 0);
        adFormItemTextBoxData.content.size = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 40);
        adFormItemTextBoxData.content.lengthMax = jSONObject.optInt("maxLength", Integer.MIN_VALUE);
        return adFormItemTextBoxData;
    }

    private static boolean initFormItem(Context context, @NonNull JSONObject jSONObject, int i3, @Nullable AdFormItemData adFormItemData, int i16) {
        if (!AdJSONUtil.isJSONObjectNull(jSONObject) && adFormItemData != null) {
            try {
                if (jSONObject.getInt("type") != i16) {
                    AdLog.e(TAG, "initFormItem type error");
                    return false;
                }
                adFormItemData.paddingTop = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 60);
                adFormItemData.paddingBottom = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 60);
                adFormItemData.backgroundColor = getColor("#FDFEFF", 0);
                adFormItemData.required = jSONObject.getBoolean("require");
                adFormItemData.title.text = jSONObject.getString("name");
                adFormItemData.title.color = getColor("#333333", 0);
                adFormItemData.title.size = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 40);
                adFormItemData.titlePaddingLeft = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 60);
                adFormItemData.titlePaddingRight = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 15);
                adFormItemData.contentPaddingLeft = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 15);
                adFormItemData.contentPaddingRight = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 60);
                if (jSONObject.has("placeholder")) {
                    AdTextData adTextData = new AdTextData();
                    adFormItemData.placeholder = adTextData;
                    adTextData.text = jSONObject.optString("placeholder");
                    adFormItemData.placeholder.color = getColor("#B9BDC2", 0);
                    adFormItemData.placeholder.size = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 40);
                    return true;
                }
                return true;
            } catch (JSONException e16) {
                AdLog.e(TAG, "initFormItem", e16);
                return false;
            }
        }
        AdLog.e(TAG, "initFormItem error");
        return false;
    }
}
