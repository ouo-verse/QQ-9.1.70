package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\u0004"}, d2 = {"", "jsonString", "Lorg/json/JSONObject;", "a", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b {
    @NotNull
    public static final JSONObject a(@Nullable String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            QLog.e("JSONExt", 1, "toSafeJson error, jsonString=" + str);
            return new JSONObject();
        }
    }
}
