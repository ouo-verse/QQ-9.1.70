package com.tencent.luggage.wxa.xd;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static final w f144888a = new w();

    public static final Boolean a(JSONObject dataJsonObj) {
        Intrinsics.checkNotNullParameter(dataJsonObj, "dataJsonObj");
        if (dataJsonObj.has("autoRotation")) {
            return Boolean.valueOf(dataJsonObj.optBoolean("autoRotation", false));
        }
        return null;
    }
}
