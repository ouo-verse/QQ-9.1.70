package com.tencent.luggage.wxa.v5;

import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.wxa.f3.e;
import com.tencent.luggage.wxa.xd.f;
import com.tencent.qqmini.miniapp.util.DebugUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends e {

    /* renamed from: b, reason: collision with root package name */
    public static final a f143257b = new a(null);

    @NotNull
    private static final String NAME = "updateGameHTMLWebView";
    private static final int CTRL_INDEX = 1165;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return c.NAME;
        }
    }

    @Override // com.tencent.luggage.wxa.f3.e, com.tencent.luggage.wxa.ee.d
    public boolean a(f fVar, int i3, View view, JSONObject data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        super.a(fVar, i3, view, data);
        String optString = data.optString(DebugUtils.Command.EVALUATE_JAVASCRIPT, "");
        if (!TextUtils.isEmpty(optString)) {
            ((com.tencent.luggage.wxa.f3.a) view).getWebView().evaluateJavascript(optString, null);
            return true;
        }
        return true;
    }
}
