package com.tencent.luggage.wxa.xd;

import com.tencent.mobileqq.app.face.FaceConstant;
import java.io.StringReader;
import kotlin.Unit;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class z0 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 65;

    @NotNull
    public static final String NAME = "systemLog";

    /* renamed from: a, reason: collision with root package name */
    public static final a f144897a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f144898b = new ThreadLocal();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f144899a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.f144899a = str;
        }

        public final void a(String line) {
            Intrinsics.checkNotNullParameter(line, "line");
            com.tencent.luggage.wxa.tn.w.d("AppBrandLog", this.f144899a + TokenParser.SP + line);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.INSTANCE;
        }
    }

    public final String b(d dVar) {
        String str;
        if (dVar instanceof com.tencent.luggage.wxa.ic.l) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Service{appId:");
            com.tencent.luggage.wxa.ic.l lVar = (com.tencent.luggage.wxa.ic.l) dVar;
            sb5.append(lVar.getAppId());
            sb5.append(",id:");
            sb5.append(lVar.getComponentId());
            sb5.append('}');
            str = sb5.toString();
        } else if (dVar instanceof com.tencent.luggage.wxa.kj.v) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Page{appId:");
            com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) dVar;
            sb6.append(vVar.getAppId());
            sb6.append(",id:");
            sb6.append(vVar.getComponentId());
            sb6.append('}');
            str = sb6.toString();
        } else {
            str = "";
        }
        return str + " print:";
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(d service, JSONObject data, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(data, "data");
        String optString = data.optString("message");
        if (optString != null && optString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        try {
            ThreadLocal threadLocal = f144898b;
            String str = (String) threadLocal.get();
            if (str == null) {
                str = b(service);
                threadLocal.set(str);
            }
            TextStreamsKt.forEachLine(new StringReader(optString), new b(str));
            service.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        } catch (OutOfMemoryError unused) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSystemLog", "oom");
        }
    }
}
