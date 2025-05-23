package com.tencent.biz.richframework.video.rfw.player.monitor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWJsonBinder {
    private static RFWJsonBinder jsonBinder;
    private Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().setLongSerializationPolicy(LongSerializationPolicy.STRING).create();

    RFWJsonBinder() {
    }

    public static RFWJsonBinder getInstance() {
        if (jsonBinder == null) {
            jsonBinder = new RFWJsonBinder();
        }
        return jsonBinder;
    }

    public String toJson(Object obj) {
        return this.gson.toJson(obj);
    }
}
