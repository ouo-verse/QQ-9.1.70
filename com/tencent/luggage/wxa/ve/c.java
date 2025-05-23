package com.tencent.luggage.wxa.ve;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 72;
    public static final String NAME = "chooseContact";

    /* renamed from: a, reason: collision with root package name */
    public final d f143397a = new d();

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        String replaceAll = str.replaceAll("\\D", "");
        if (replaceAll.startsWith("86")) {
            return replaceAll.substring(2);
        }
        return replaceAll;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        this.f143397a.invoke(dVar, jSONObject, i3);
    }
}
