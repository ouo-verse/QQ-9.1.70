package com.tencent.ecommerce.biz.detail.repo.shop.data;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0000H\u0002\u001a\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0002\u001a\f\u0010\b\u001a\u00020\u0003*\u00020\u0000H\u0002\u001a\f\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0002\u001a\f\u0010\n\u001a\u00020\u0000*\u00020\u0000H\u0002\u001a\f\u0010\u000b\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\f\u0010\f\u001a\u00020\u0006*\u00020\u0000H\u0002\u001a\f\u0010\r\u001a\u00020\u0006*\u00020\u0000H\u0002\u001a\f\u0010\u000e\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\f\u0010\u000f\u001a\u00020\u0003*\u00020\u0000H\u0002\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0000*\u00020\u0000H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0000*\u00020\u0000H\u0002\u00a8\u0006\u0012"}, d2 = {"Lorg/json/JSONObject;", "Lorg/json/JSONArray;", ReportConstant.COSTREPORT_PREFIX, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "p", "v", "y", "w", HippyTKDListViewAdapter.X, "o", "u", "r", "t", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class l {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int A(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(TabPreloadItem.TAB_NAME_DYNAMIC);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        return optJSONObject.optInt("stock_nums", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("active_sku");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        if (!optJSONObject.has("live_limit")) {
            return 0;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("live_limit");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        return optJSONObject2.optInt("user_daily_limit", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray o(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("preview_pics");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        if (optJSONArray.length() > 0) {
            return optJSONArray;
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("carousel_pictures");
        return optJSONArray2 != null ? optJSONArray2 : new JSONArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject p(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("price");
        return optJSONObject != null ? optJSONObject : new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(TabPreloadItem.TAB_NAME_DYNAMIC);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        if (!optJSONObject.has("buy_limit")) {
            return 0;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("buy_limit");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        return optJSONObject2.optInt("user_daily_limit", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject r(JSONObject jSONObject) {
        return jSONObject.optJSONObject("active_sku");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray s(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("sku_infos");
        return optJSONArray != null ? optJSONArray : new JSONArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject t(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(IndividuationUrlHelper.UrlId.PENDANT_HOME);
        return optJSONObject != null ? optJSONObject : new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int u(JSONObject jSONObject) {
        return jSONObject.optInt("status", 1);
    }

    private static final JSONObject v(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("spec_info");
        return optJSONObject != null ? optJSONObject : new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String w(JSONObject jSONObject) {
        String optString = jSONObject.optString("name");
        return optString != null ? optString : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String x(JSONObject jSONObject) {
        String optString = jSONObject.optString("value");
        return optString != null ? optString : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray y(JSONObject jSONObject) {
        JSONArray optJSONArray = v(jSONObject).optJSONArray("items");
        return optJSONArray != null ? optJSONArray : new JSONArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String z(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(TabPreloadItem.TAB_NAME_DYNAMIC);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        return optJSONObject.optString("stock", "0");
    }
}
