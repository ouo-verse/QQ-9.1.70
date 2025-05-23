package com.tencent.luggage.wxa.l6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 104;

    @NotNull
    public static final String NAME = "chooseImage";

    /* renamed from: a, reason: collision with root package name */
    public static final a f133059a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements LuggageActivityHelper.d {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.k6.b f133061b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f133062c;

        public b(com.tencent.luggage.wxa.k6.b bVar, int i3) {
            this.f133061b = bVar;
            this.f133062c = i3;
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public final void a(int i3, Intent intent) {
            c.this.a(this.f133061b, this.f133062c, i3, intent);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.o
    public String ERR_MSG_TAG() {
        return "err_msg";
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.k6.b env, JSONObject data, int i3) {
        Intent a16;
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        JSONArray optJSONArray = data.optJSONArray("sourceType");
        data.optJSONArray("sizeType");
        int optInt = data.optInt("count", 0);
        Context context = env.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) context;
        if (optJSONArray != null && optJSONArray.length() == 1 && Intrinsics.areEqual(optJSONArray.get(0), "camera")) {
            a16 = com.tencent.luggage.wxa.x0.b.a().a(activity);
        } else {
            a16 = com.tencent.luggage.wxa.x0.b.a(activity).a(optInt).a((Context) activity);
        }
        LuggageActivityHelper.FOR(activity).startActivityForResult(a16, new b(env, i3));
    }

    public void a(com.tencent.luggage.wxa.k6.b env, int i3, int i16, Intent intent) {
        Intrinsics.checkNotNullParameter(env, "env");
        List a16 = com.tencent.luggage.wxa.x0.b.a(intent);
        if (a16 == null) {
            w.b("MicroMsg.JsApiChooseImage", "chooseImage onActivityResult get NULL images, resultCode=%d, url=%s", Integer.valueOf(i16), env.h());
            env.a(i3, makeReturnJson("fail cancel"));
            return;
        }
        JSONArray jSONArray = new JSONArray();
        com.tencent.luggage.wxa.m6.b k3 = env.k();
        Iterator it = a16.iterator();
        while (it.hasNext()) {
            String b16 = ((com.tencent.luggage.wxa.f1.b) it.next()).b();
            Intrinsics.checkNotNullExpressionValue(b16, "image.path");
            jSONArray.mo162put(k3.a(b16));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("localIds", jSONArray);
        env.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
    }
}
