package com.tencent.rmonitor.common.util;

import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/rmonitor/common/util/StackUtil;", "", "<init>", "()V", "b", "a", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public class StackUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final ArrayList<String> f365519a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u001f\u0010\u000b\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000fj\b\u0012\u0004\u0012\u00020\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/rmonitor/common/util/StackUtil$a;", "", "", "a", "b", "", "throwable", "c", "", "Ljava/lang/StackTraceElement;", "arr", "d", "([Ljava/lang/StackTraceElement;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "WHITE_PACKAGE", "Ljava/util/ArrayList;", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.common.util.StackUtil$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @NotNull
        public final String a() {
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            String name = currentThread.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "Thread.currentThread().name");
            return name;
        }

        @JvmStatic
        @NotNull
        public final String b() {
            try {
                return c(new Throwable());
            } catch (Throwable th5) {
                Logger.f365497g.b("RMonitor_common_util_FakeUtil", "getThrowableStack ex ", th5);
                return "";
            }
        }

        @JvmStatic
        @NotNull
        public final String c(@Nullable Throwable throwable) {
            if (throwable == null) {
                return "";
            }
            return d(throwable.getStackTrace());
        }

        @JvmStatic
        @NotNull
        public final String d(@Nullable StackTraceElement[] arr) {
            boolean z16;
            boolean contains$default;
            boolean z17;
            if (arr != null) {
                if (arr.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    ArrayList arrayList = new ArrayList(arr.length);
                    int length = arr.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        String className = arr[i3].getClassName();
                        ArrayList<String> arrayList2 = StackUtil.f365519a;
                        if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                            for (String str : arrayList2) {
                                Intrinsics.checkExpressionValueIsNotNull(className, "className");
                                contains$default = StringsKt__StringsKt.contains$default((CharSequence) className, (CharSequence) str, false, 2, (Object) null);
                                if (contains$default) {
                                    z17 = true;
                                    break;
                                }
                            }
                        }
                        z17 = false;
                        if (!z17) {
                            arrayList.add(arr[i3]);
                        }
                    }
                    StringBuffer stringBuffer = new StringBuffer(arrayList.size());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        stringBuffer.append((StackTraceElement) it.next());
                        stringBuffer.append('\n');
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "sb.toString()");
                    return stringBuffer2;
                }
                return "";
            }
            return "";
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ArrayList<String> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("libcore.io", "com.tencent.rmonitor.io", "java.io", "dalvik.system", "android.os");
        f365519a = arrayListOf;
    }

    @JvmStatic
    @NotNull
    public static final String getCurrentThreadName() {
        return INSTANCE.a();
    }

    @JvmStatic
    @NotNull
    public static final String getThrowableStack() {
        return INSTANCE.b();
    }
}
