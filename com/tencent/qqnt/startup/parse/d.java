package com.tencent.qqnt.startup.parse;

import com.tencent.mobileqq.app.ThreadLooperPrinter2;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/startup/parse/c;", "configReader", "", "Lcom/tencent/qqnt/startup/parse/a;", "a", "nt_startup_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {
    @NotNull
    public static final List<a> a(@NotNull c configReader) {
        boolean z16;
        List<String> split$default;
        List<a> list;
        boolean z17;
        boolean startsWith$default;
        String removePrefix;
        CharSequence trim;
        boolean startsWith$default2;
        CharSequence trim2;
        List<String> split$default2;
        List<a> emptyList;
        Intrinsics.checkNotNullParameter(configReader, "configReader");
        String readConfigFile = configReader.readConfigFile();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        if (readConfigFile.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) readConfigFile, new char[]{'\n'}, false, 0, 6, (Object) null);
        while (true) {
            a aVar = null;
            for (String str : split$default) {
                if (str.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, ThreadLooperPrinter2.START_PREFIX, false, 2, null);
                    if (startsWith$default) {
                        removePrefix = StringsKt__StringsKt.removePrefix(str, (CharSequence) ThreadLooperPrinter2.START_PREFIX);
                        trim = StringsKt__StringsKt.trim((CharSequence) removePrefix);
                        String obj = trim.toString();
                        Object obj2 = hashMap2.get(obj);
                        if (obj2 == null) {
                            obj2 = new a(obj);
                            hashMap2.put(obj, obj2);
                        }
                        aVar = (a) obj2;
                    } else {
                        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, ThreadLooperPrinter2.STOP_PREFIX, false, 2, null);
                        if (startsWith$default2) {
                            break;
                        }
                        trim2 = StringsKt__StringsKt.trim((CharSequence) str);
                        split$default2 = StringsKt__StringsKt.split$default((CharSequence) trim2.toString(), new String[]{"-->"}, false, 0, 6, (Object) null);
                        if (!split$default2.isEmpty()) {
                            b bVar = null;
                            for (String str2 : split$default2) {
                                Object obj3 = hashMap.get(str2);
                                if (obj3 == null) {
                                    obj3 = new b(str2);
                                    hashMap.put(str2, obj3);
                                }
                                b bVar2 = (b) obj3;
                                if (bVar != null) {
                                    bVar2.a(bVar);
                                }
                                if (aVar != null) {
                                    aVar.a(bVar2);
                                }
                                bVar = bVar2;
                            }
                        }
                    }
                }
            }
            Collection values = hashMap2.values();
            Intrinsics.checkNotNullExpressionValue(values, "stageSet.values");
            list = CollectionsKt___CollectionsKt.toList(values);
            return list;
            hashMap.clear();
        }
    }
}
