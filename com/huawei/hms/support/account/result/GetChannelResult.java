package com.huawei.hms.support.account.result;

import android.text.TextUtils;
import com.huawei.hms.support.feature.result.AbstractAuthResult;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GetChannelResult extends AbstractAuthResult {
    private String description;
    private String icon;

    public GetChannelResult fromJson(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        JSONObject jSONObject = new JSONObject(str);
        this.description = jSONObject.getString("description");
        this.icon = jSONObject.getString("icon");
        jsonToSuper(jSONObject);
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String toJson() throws JSONException {
        return toJsonObject().toString();
    }

    protected JSONObject toJsonObject() throws JSONException {
        return superToJson();
    }
}
