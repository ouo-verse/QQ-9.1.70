package com.qzone.reborn.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.reflect.DittoValue;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.mobileqq.R;
import com.tencent.raft.codegenmeta.utils.Constants;
import cooperation.qzone.util.QZLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes37.dex */
public class DittoNativeView extends DittoAreaView {
    public DittoNativeView(Context context) {
        this(context, null);
    }

    private void b(Context context, AttributeSet attributeSet) {
        String a16 = a(context, attributeSet);
        QZLog.d("DittoNativeView", 2, "init jsonStr:" + a16);
        setCanvasArea(DittoUIEngine.g().inflateDittoArea(this, a16, new a(), true));
    }

    public DittoNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    private String a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return "";
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DittoNativeView);
        String string = obtainStyledAttributes.getString(0);
        String string2 = obtainStyledAttributes.getString(2);
        String string3 = obtainStyledAttributes.getString(3);
        String string4 = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.Service.CLASS, string);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", string2);
            jSONObject2.put("width", string3);
            jSONObject2.put("height", string4);
            jSONObject.put("shell", jSONObject2);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements DittoUIEngine.DittoUIEngineInflateListener {
        a() {
        }

        @Override // com.tencent.ditto.shell.DittoUIEngine.DittoUIEngineInflateListener
        public void didInflatedArea(DittoArea dittoArea, String str) {
        }

        @Override // com.tencent.ditto.shell.DittoUIEngine.DittoUIEngineInflateListener
        public void setOutKVCSet(DittoArea dittoArea, Map<String, DittoValue> map) {
        }
    }
}
