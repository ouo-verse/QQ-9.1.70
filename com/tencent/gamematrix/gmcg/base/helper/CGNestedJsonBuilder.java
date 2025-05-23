package com.tencent.gamematrix.gmcg.base.helper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGNestedJsonBuilder {
    private JSONObject mRoot;

    public CGNestedJsonBuilder() {
        this(new JSONObject());
    }

    public JSONObject build() {
        return this.mRoot;
    }

    public CGNestedJsonBuilder put(String str, @Nullable Boolean bool) {
        if (bool == null) {
            return this;
        }
        try {
            this.mRoot.put(str, bool);
        } catch (JSONException unused) {
            CGLog.e(CGStringUtil.format("CGNestedJsonBuilder.put(%s, %b) error", str, bool));
        }
        return this;
    }

    public CGNestedJsonBuilder wrapUp(String str, boolean z16) {
        Object obj;
        if (this.mRoot.length() <= 0) {
            return this;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (z16) {
                obj = this.mRoot.toString();
            } else {
                obj = this.mRoot;
            }
            jSONObject.put(str, obj);
            this.mRoot = jSONObject;
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return this;
    }

    public CGNestedJsonBuilder(@NonNull JSONObject jSONObject) {
        this.mRoot = jSONObject;
    }

    public CGNestedJsonBuilder put(String str, @Nullable Integer num) {
        if (num == null) {
            return this;
        }
        try {
            this.mRoot.put(str, num);
        } catch (JSONException unused) {
            CGLog.e(CGStringUtil.format("CGNestedJsonBuilder.put(%s, %d) error", str, num));
        }
        return this;
    }

    public CGNestedJsonBuilder put(String str, @Nullable Long l3) {
        if (l3 == null) {
            return this;
        }
        try {
            this.mRoot.put(str, l3);
        } catch (JSONException unused) {
            CGLog.e(CGStringUtil.format("CGNestedJsonBuilder.put(%s, %d) error", str, l3));
        }
        return this;
    }

    public CGNestedJsonBuilder put(String str, @Nullable Object obj) {
        if (obj == null) {
            return this;
        }
        try {
            this.mRoot.put(str, obj);
        } catch (JSONException unused) {
            CGLog.e(CGStringUtil.format("CGNestedJsonBuilder.put(%s, %s) error", str, obj));
        }
        return this;
    }
}
