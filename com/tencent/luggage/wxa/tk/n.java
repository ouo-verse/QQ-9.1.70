package com.tencent.luggage.wxa.tk;

import android.content.Context;
import android.os.Build;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.u;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class n {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a extends com.tencent.luggage.wxa.h1.b {
        String identity();

        String version();
    }

    public static boolean a() {
        for (String str : Build.SUPPORTED_64_BIT_ABIS) {
            if ("arm64-v8a".equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static String a(Context context, String str, a aVar) {
        String str2;
        com.tencent.luggage.wxa.er.a.b("Luggage.UserAgentUtil, appendUserAgent fail, context is null, stack = " + w0.b(), context != null);
        if (aVar != null) {
            if (str == null) {
                str2 = aVar.identity();
            } else {
                str2 = str + aVar.identity();
            }
            str = str2 + aVar.version();
        }
        String str3 = (str + " NetType/" + h0.a(z.c())) + " Language/" + u.a(z.c());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str3);
        sb5.append(" ABI/");
        sb5.append(a() ? ResourceAttributes.HostArchValues.ARM64 : ResourceAttributes.HostArchValues.ARM32);
        String sb6 = sb5.toString();
        w.d("Luggage.UserAgentUtil", "appendUserAgent, uaStr = " + sb6);
        return sb6.replace('\n', TokenParser.SP);
    }
}
