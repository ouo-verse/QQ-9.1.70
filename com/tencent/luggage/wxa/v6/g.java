package com.tencent.luggage.wxa.v6;

import android.content.Context;
import com.tencent.luggage.wxa.q7.i;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends com.tencent.luggage.wxa.v3.h {

    @Deprecated
    public static final int CTRL_INDEX = 406;

    @Deprecated
    @NotNull
    public static final String NAME = "private_openUrl";

    /* renamed from: a, reason: collision with root package name */
    public static final a f143287a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
    
        if (r4.optBoolean("openBySDKEmbedder") == true) goto L7;
     */
    @Override // com.tencent.luggage.wxa.v3.h, com.tencent.luggage.wxa.xd.a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        boolean z16;
        Context context;
        if (jSONObject != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            String optString = jSONObject.optString("url");
            if (optString == null) {
                optString = "";
            }
            i iVar = i.f137989a;
            if (dVar != null) {
                context = dVar.getContext();
            } else {
                context = null;
            }
            iVar.openUrl(com.tencent.luggage.wxa.bo.a.a(context), optString);
            if (dVar != null) {
                dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
                return;
            }
            return;
        }
        super.invoke(dVar, jSONObject, i3);
    }
}
