package com.tencent.luggage.wxa.wg;

import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.mg.j;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.AppConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = -2;

    @NotNull
    public static final String NAME = "preDownloadVideoResource";

    /* renamed from: a, reason: collision with root package name */
    public static final a f144245a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            if (dVar != null) {
                dVar.a(i3, makeReturnJson("fail:miss params"));
            }
            w.f("MicroMsg.JsApiPreDownloadVideoResource", "data is null");
            return;
        }
        String optString = jSONObject.optString(AppConstants.Key.KEY_QZONE_VIDEO_URL);
        int optInt = jSONObject.optInt("downloadRatio", 100);
        w.d("MicroMsg.JsApiPreDownloadVideoResource", "preDownloadVideoResource videoUrl:%s downloadRatio:%d", optString, Integer.valueOf(optInt));
        if (w0.c(optString)) {
            w.f("MicroMsg.JsApiPreDownloadVideoResource", "videoUrl is null");
            if (dVar != null) {
                dVar.a(i3, makeReturnJson("fail:videoUrl is empty"));
                return;
            }
            return;
        }
        if (optInt <= 0) {
            if (dVar != null) {
                dVar.a(i3, makeReturnJson("fail:downloadRatio is invalid"));
            }
        } else {
            com.tencent.luggage.wxa.k0.d.a(g.a(j.class));
            if (dVar != null) {
                dVar.a(i3, makeReturnJson("fail:service not found"));
            }
        }
    }
}
