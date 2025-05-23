package com.tencent.luggage.wxa.l6;

import android.graphics.Color;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 182;

    @NotNull
    public static final String NAME = "setNavigationBarColor";

    /* renamed from: a, reason: collision with root package name */
    public static final a f133095a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final String f133096b = "MicroMsg.JsApiSetNavigationBarColor";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.o
    public String ERR_MSG_TAG() {
        return "err_msg";
    }

    public final String a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        if (com.tencent.luggage.wxa.lo.i.g()) {
            return jSONObject.optString(MiniAppConst.MENU_STYLE_DARK);
        }
        return jSONObject.optString(MiniAppConst.MENU_STYLE_LIGHT);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0074 A[Catch: Exception -> 0x0098, TryCatch #0 {Exception -> 0x0098, blocks: (B:13:0x005f, B:15:0x0068, B:20:0x0074, B:25:0x0085, B:27:0x008e), top: B:12:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void invoke(com.tencent.luggage.wxa.k6.b env, JSONObject data, int i3) {
        boolean z16;
        int i16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        env.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
        if (Intrinsics.areEqual("1", data.optString("actionCode"))) {
            env.u();
            return;
        }
        try {
            String a16 = a(data.optJSONObject("wxcolor"));
            if (w0.c(a16)) {
                a16 = data.optString("color");
            }
            w.d(f133096b, "setNavigationBarColor color = " + a16);
            int parseColor = Color.parseColor(a16) | (-16777216);
            try {
                String optString = data.optString(com.tencent.luggage.wxa.c8.c.f123400v);
                if (optString != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(optString);
                    if (!isBlank) {
                        z16 = false;
                        if (z16) {
                            i16 = 100;
                            int a17 = (int) (w0.a(optString, 1.0f) * 100);
                            if (a17 >= 0 && a17 <= 100) {
                                i16 = a17;
                            }
                            String optString2 = data.optString("titleAlphaAdjustment");
                            if (optString2 != null) {
                                StringsKt__StringsJVMKt.isBlank(optString2);
                            }
                        } else {
                            i16 = 255;
                        }
                        env.a(parseColor, i16);
                    }
                }
                z16 = true;
                if (z16) {
                }
                env.a(parseColor, i16);
            } catch (Exception e16) {
                w.b(f133096b, e16.getMessage());
                env.u();
            }
        } catch (Exception e17) {
            w.b(f133096b, e17.getMessage());
            env.u();
        }
    }
}
