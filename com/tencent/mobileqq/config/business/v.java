package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class v implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public String f202840d = "";

    /* renamed from: e, reason: collision with root package name */
    private boolean f202841e = true;

    public boolean a() {
        return this.f202841e;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f202840d = str;
        try {
            this.f202841e = new JSONObject(str).optBoolean("isNeedLoadMsgFromDeepSleep", this.f202841e);
        } catch (Exception e16) {
            QLog.d("MSFConfigBean", 1, "MSFConfigBean parse error->" + e16);
        }
    }
}
