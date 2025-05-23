package com.tencent.hippykotlin.demo.pages.vas_base.krequest;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.UriKt;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class URL {

    /* renamed from: protocol, reason: collision with root package name */
    public String f114309protocol = "";
    public String hostname = "";
    public String pathname = "";
    public String hash = "";
    public String port = "";
    public final Map<String, String> searchParams = new LinkedHashMap();

    public URL(String str) {
        parseUrl(str);
    }

    public final String getHost() {
        if (!Intrinsics.areEqual(this.port, "")) {
            return this.hostname + ':' + this.port;
        }
        return this.hostname;
    }

    public final String getHref() {
        return getOrigin() + this.pathname + getSearch() + this.hash;
    }

    public final String getOrigin() {
        return this.f114309protocol + QzoneWebViewOfflinePlugin.STR_DEVIDER + getHost();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    public final String getSearch() {
        String joinToString$default;
        if (this.searchParams.isEmpty()) {
            return "";
        }
        StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('?');
        ?? r16 = this.searchParams;
        ArrayList arrayList = new ArrayList(r16.size());
        for (Map.Entry entry : r16.entrySet()) {
            arrayList.add(((String) entry.getKey()) + '=' + UriKt.encodeURIComponent((String) entry.getValue()));
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ContainerUtils.FIELD_DELIMITER, null, null, 0, null, null, 62, null);
        m3.append(joinToString$default);
        return m3.toString();
    }

    public final String toString() {
        String trimIndent;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\n            URL {\n                href: \"");
        m3.append(getHref());
        m3.append("\",\n                origin: \"");
        m3.append(getOrigin());
        m3.append("\",\n                protocol: \"");
        m3.append(this.f114309protocol);
        m3.append("\",\n                host: \"");
        m3.append(getHost());
        m3.append("\",\n                hostname: \"");
        m3.append(this.hostname);
        m3.append("\",\n                port: \"");
        m3.append(this.port);
        m3.append("\",\n                pathname: \"");
        m3.append(this.pathname);
        m3.append("\",\n                search: \"");
        m3.append(getSearch());
        m3.append("\",\n                searchParams: \"");
        m3.append(this.searchParams);
        m3.append("\",\n                hash: \"");
        m3.append(this.hash);
        m3.append("\"\n            }\n            ");
        trimIndent = StringsKt__IndentKt.trimIndent(m3.toString());
        return trimIndent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Object] */
    public final void parseUrl(String str) {
        List split$default;
        Object first;
        ?? last;
        List split$default2;
        Object first2;
        List split$default3;
        Object first3;
        List split$default4;
        Object first4;
        int lastIndex;
        Object obj;
        List drop;
        String joinToString$default;
        int lastIndex2;
        T t16;
        List split$default5;
        Object first5;
        String replace$default;
        List<String> split$default6;
        int collectionSizeOrDefault;
        Object orNull;
        List split$default7;
        String substring;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{QzoneWebViewOfflinePlugin.STR_DEVIDER}, false, 0, 6, (Object) null);
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default);
        this.f114309protocol = (String) first;
        last = CollectionsKt___CollectionsKt.last((List<? extends ??>) split$default);
        objectRef.element = last;
        split$default2 = StringsKt__StringsKt.split$default((CharSequence) last, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default2);
        split$default3 = StringsKt__StringsKt.split$default((CharSequence) first2, new String[]{"/"}, false, 0, 6, (Object) null);
        first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default3);
        split$default4 = StringsKt__StringsKt.split$default((CharSequence) first3, new String[]{":"}, false, 0, 6, (Object) null);
        first4 = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default4);
        String str2 = (String) first4;
        if (str2.length() > 0) {
            this.hostname = str2;
        }
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(split$default4);
        if (1 > lastIndex) {
            obj = "";
        } else {
            obj = split$default4.get(1);
        }
        this.port = (String) obj;
        StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('/');
        drop = CollectionsKt___CollectionsKt.drop(split$default3, 1);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(drop, "/", null, null, 0, null, null, 62, null);
        m3.append(joinToString$default);
        this.pathname = m3.toString();
        lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(split$default2);
        if (1 > lastIndex2) {
            t16 = "";
        } else {
            t16 = split$default2.get(1);
        }
        objectRef.element = t16;
        if (((CharSequence) t16).length() == 0) {
            return;
        }
        split$default5 = StringsKt__StringsKt.split$default((CharSequence) objectRef.element, new String[]{"#"}, false, 0, 6, (Object) null);
        StringBuilder m16 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('?');
        first5 = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default5);
        m16.append((String) first5);
        replace$default = StringsKt__StringsJVMKt.replace$default(m16.toString(), QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, "", false, 4, (Object) null);
        split$default6 = StringsKt__StringsKt.split$default((CharSequence) replace$default, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(split$default6, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str3 : split$default6) {
            split$default7 = StringsKt__StringsKt.split$default((CharSequence) str3, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
            String str4 = (String) split$default7.get(0);
            int length = str4.length() + 1;
            if (length > str3.length()) {
                substring = "";
            } else {
                substring = str3.substring(length);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            }
            arrayList.add(new Pair(str4, substring));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            this.searchParams.put(pair.getFirst(), UriKt.decodeURIComponent((String) pair.getSecond()));
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(split$default5, 1);
        String str5 = (String) orNull;
        if (str5 != null) {
            this.hash = '#' + str5;
        }
    }
}
