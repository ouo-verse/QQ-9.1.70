package com.tencent.luggage.wxa.bf;

import android.util.ArrayMap;
import com.tencent.luggage.wxa.uk.x;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.net.URL;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class u extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = -2;

    @NotNull
    public static final String NAME = "loadLibFiles";

    /* renamed from: a, reason: collision with root package name */
    public static final a f122578a = new a(null);

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
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONArray f122579a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.rc.q f122580b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ei.j f122581c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.v f122582d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f122583e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ u f122584f;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements x.e {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayMap f122585a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f122586b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.e5.c f122587c;

            public a(ArrayMap arrayMap, String str, com.tencent.luggage.wxa.e5.c cVar) {
                this.f122585a = arrayMap;
                this.f122586b = str;
                this.f122587c = cVar;
            }

            @Override // com.tencent.luggage.wxa.uk.x.e
            public void a(String str) {
                this.f122585a.put(this.f122586b, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                this.f122587c.a();
            }

            @Override // com.tencent.luggage.wxa.uk.x.e
            public void b(String str) {
                boolean z16;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                String str2 = "fail";
                if (!z16) {
                    str2 = "fail" + TokenParser.SP + str;
                }
                this.f122585a.put(this.f122586b, str2);
                this.f122587c.a();
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bf.u$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6055b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayMap f122588a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.kj.v f122589b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f122590c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ u f122591d;

            public RunnableC6055b(ArrayMap arrayMap, com.tencent.luggage.wxa.kj.v vVar, int i3, u uVar) {
                this.f122588a = arrayMap;
                this.f122589b = vVar;
                this.f122590c = i3;
                this.f122591d = uVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : this.f122588a.entrySet()) {
                    jSONObject.put((String) entry.getKey(), (String) entry.getValue());
                }
                this.f122589b.a(this.f122590c, this.f122591d.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, jSONObject));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(JSONArray jSONArray, com.tencent.luggage.wxa.rc.q qVar, com.tencent.luggage.wxa.ei.j jVar, com.tencent.luggage.wxa.kj.v vVar, int i3, u uVar) {
            super(1);
            this.f122579a = jSONArray;
            this.f122580b = qVar;
            this.f122581c = jVar;
            this.f122582d = vVar;
            this.f122583e = i3;
            this.f122584f = uVar;
        }

        public final void a(Object obj) {
            String str;
            boolean z16;
            ArrayMap arrayMap = new ArrayMap(this.f122579a.length());
            com.tencent.luggage.wxa.e5.c cVar = new com.tencent.luggage.wxa.e5.c(new RunnableC6055b(arrayMap, this.f122582d, this.f122583e, this.f122584f), this.f122579a.length());
            if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            boolean z17 = false;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String g16 = this.f122580b.g(str);
                if (g16 == null || g16.length() == 0) {
                    z17 = true;
                }
                if (z17) {
                    arrayMap.put(str, "file not exists");
                    cVar.a();
                    return;
                } else {
                    com.tencent.luggage.wxa.uk.x.a(this.f122581c, new URL("https", com.tencent.luggage.wxa.tn.y0.a(R.string.f159111rf), str), g16, new a(arrayMap, str, cVar));
                    return;
                }
            }
            cVar.a();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.kj.v vVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.ei.j jsRuntime;
        Unit unit;
        JSONArray optJSONArray;
        if (vVar == null || (jsRuntime = vVar.getJsRuntime()) == null) {
            return;
        }
        com.tencent.luggage.wxa.rc.q i16 = vVar.i();
        if (i16 == null) {
            vVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
            return;
        }
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("paths")) != null) {
            com.tencent.luggage.wxa.e5.f.a(optJSONArray, new b(optJSONArray, i16, jsRuntime, vVar, i3, this));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            vVar.a(i3, makeReturnJson("fail:invalid data"));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }
}
