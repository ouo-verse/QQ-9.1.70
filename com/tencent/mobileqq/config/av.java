package com.tencent.mobileqq.config;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class av {

    /* renamed from: a, reason: collision with root package name */
    public int f202341a;

    public static av a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new av();
        }
        av avVar = new av();
        try {
            avVar.f202341a = new JSONObject(str).optInt("enable", 0);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return avVar;
    }

    @NonNull
    public String toString() {
        return "switch = " + this.f202341a;
    }
}
