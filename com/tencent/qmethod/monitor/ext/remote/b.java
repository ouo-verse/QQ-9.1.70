package com.tencent.qmethod.monitor.ext.remote;

import com.tencent.qmethod.pandoraex.monitor.DexMonitor;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J&\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/remote/b;", "", "", "", "c", "obj", "Ljava/lang/Class;", "cl", "field", "d", "a", "path", "", "b", "e", "Lkotlin/text/Regex;", "Lkotlin/text/Regex;", "regex", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f343675b = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Regex regex = new Regex("(((zip|dex){1} file)|(directory)){1} \"(\\S+)\"");

    b() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
    
        if (r3 != false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0037 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0015 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<String> a() {
        boolean z16;
        boolean isBlank;
        boolean isBlank2;
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<String, String> concurrentHashMap = DexMonitor.map;
        Intrinsics.checkExpressionValueIsNotNull(concurrentHashMap, "DexMonitor.map");
        for (Map.Entry<String, String> entry : concurrentHashMap.entrySet()) {
            String key = entry.getKey();
            boolean z17 = false;
            if (key != null) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(key);
                if (!isBlank2) {
                    z16 = false;
                    if (!z16) {
                        String value = entry.getValue();
                        if (value != null) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(value);
                        }
                        z17 = true;
                        if (!z17) {
                            b bVar = f343675b;
                            String key2 = entry.getKey();
                            Intrinsics.checkExpressionValueIsNotNull(key2, "it.key");
                            if (!bVar.b(key2) && new File(entry.getKey()).exists()) {
                                arrayList.add(entry.getKey() + "||" + entry.getValue());
                            }
                        }
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        return arrayList;
    }

    private final boolean b(String path) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, "/system/", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(path, "/system_ext/", false, 2, null);
            if (!startsWith$default2) {
                startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(path, "/data/app/", false, 2, null);
                if (!startsWith$default3) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<String> c() {
        String str;
        String str2;
        boolean z16;
        boolean isBlank;
        boolean isBlank2;
        ArrayList arrayList = new ArrayList();
        ClassLoader pathClassLoader = com.tencent.qmethod.monitor.a.f343451h.g().getContext().getClassLoader();
        Intrinsics.checkExpressionValueIsNotNull(pathClassLoader, "pathClassLoader");
        Class<?> cls = Class.forName("dalvik.system.BaseDexClassLoader");
        Intrinsics.checkExpressionValueIsNotNull(cls, "Class.forName(\"dalvik.system.BaseDexClassLoader\")");
        for (MatchResult matchResult : Regex.findAll$default(regex, String.valueOf(d(pathClassLoader, cls, "pathList")), 0, 2, null)) {
            MatchGroup matchGroup = matchResult.getGroups().get(5);
            if (matchGroup != null) {
                str = matchGroup.getValue();
            } else {
                str = null;
            }
            MatchGroup matchGroup2 = matchResult.getGroups().get(4);
            if (matchGroup2 == null) {
                matchGroup2 = matchResult.getGroups().get(3);
            }
            if (matchGroup2 != null) {
                str2 = matchGroup2.getValue();
            } else {
                str2 = null;
            }
            boolean z17 = true;
            if (str != null) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank2) {
                    z16 = false;
                    if (!z16) {
                        if (str2 != null) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                            if (!isBlank) {
                                z17 = false;
                            }
                        }
                        if (!z17 && !f343675b.b(str) && new File(str).exists()) {
                            arrayList.add(str + "||" + str2);
                        }
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        return arrayList;
    }

    private final Object d(Object obj, Class<?> cl5, String field) {
        Field localField = cl5.getDeclaredField(field);
        Intrinsics.checkExpressionValueIsNotNull(localField, "localField");
        localField.setAccessible(true);
        return localField.get(obj);
    }

    @NotNull
    public final List<String> e() {
        ArrayList arrayList = new ArrayList();
        b bVar = f343675b;
        arrayList.addAll(bVar.c());
        arrayList.addAll(bVar.a());
        return arrayList;
    }
}
