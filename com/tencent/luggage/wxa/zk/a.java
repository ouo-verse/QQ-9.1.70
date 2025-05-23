package com.tencent.luggage.wxa.zk;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f146730a;

    static {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("User-Agent", "user_agent"), TuplesKt.to("Cookie", "cookies"), TuplesKt.to("Referer", ISchemeApi.KEY_REFERER));
        f146730a = mapOf;
    }

    public static final int a(ITPPlayer iTPPlayer) {
        Intrinsics.checkNotNullParameter(iTPPlayer, "<this>");
        long durationMs = iTPPlayer.getDurationMs();
        if (0 < durationMs) {
            return (int) ((iTPPlayer.getPlayableDurationMs() * 100) / durationMs);
        }
        return 0;
    }

    public static final void a(ITPPlayer iTPPlayer, String url, Map headers) {
        Object obj;
        boolean equals;
        Intrinsics.checkNotNullParameter(iTPPlayer, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        w.a("MicroMsg.AppBrand.ThumbPlayerExt", "setDataSourceWorkaround, url: " + url + ", headers: " + headers);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : headers.entrySet()) {
            String str = (String) entry.getKey();
            Iterator it = f146730a.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                equals = StringsKt__StringsJVMKt.equals(str, (String) ((Map.Entry) obj).getKey(), true);
                if (equals) {
                    break;
                }
            }
            Map.Entry entry2 = (Map.Entry) obj;
            if (entry2 != null) {
                w.a("MicroMsg.AppBrand.ThumbPlayerExt", "setDataSourceWorkaround, " + ((String) entry2.getValue()) + MsgSummary.STR_COLON + ((String) entry.getValue()));
                if (((String) linkedHashMap.put(entry2.getValue(), entry.getValue())) == null) {
                }
            }
            w.a("MicroMsg.AppBrand.ThumbPlayerExt", "setDataSourceWorkaround, " + ((String) entry.getKey()) + MsgSummary.STR_COLON + ((String) entry.getValue()));
        }
        w.a("MicroMsg.AppBrand.ThumbPlayerExt", "setDataSourceWorkaround, headersSet: " + linkedHashMap);
        iTPPlayer.setDataSource(url, linkedHashMap);
    }

    public static final String a() {
        String str;
        int indexOf$default;
        int i3;
        String processName = z.i();
        if (!(processName == null || processName.length() == 0)) {
            Intrinsics.checkNotNullExpressionValue(processName, "processName");
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) processName, ':', 0, false, 6, (Object) null);
            if (indexOf$default >= 0 && (i3 = indexOf$default + 1) <= processName.length()) {
                str = processName.substring(i3);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                w.a("MicroMsg.AppBrand.ThumbPlayerExt", "getSimpleProcessName, simpleProcessName: " + str);
                return str;
            }
        }
        str = "main";
        w.a("MicroMsg.AppBrand.ThumbPlayerExt", "getSimpleProcessName, simpleProcessName: " + str);
        return str;
    }
}
