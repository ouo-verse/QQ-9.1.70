package com.tencent.qmethod.monitor.base.util;

import com.tencent.qmethod.pandoraex.core.o;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qmethod/monitor/base/util/c;", "", "Ljava/io/InputStream;", "inputStream", "", "bufferSize", "", "a", "Ljava/io/InputStreamReader;", "inputStreamReader", "b", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f343533a = new c();

    c() {
    }

    @JvmStatic
    @NotNull
    public static final String a(@NotNull InputStream inputStream, int bufferSize) {
        Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
        return b(new InputStreamReader(inputStream), bufferSize);
    }

    @JvmStatic
    @NotNull
    public static final String b(@NotNull InputStreamReader inputStreamReader, int bufferSize) {
        Intrinsics.checkParameterIsNotNull(inputStreamReader, "inputStreamReader");
        StringBuffer stringBuffer = new StringBuffer(1024);
        try {
            Iterator<T> it = TextStreamsKt.readLines(new BufferedReader(inputStreamReader, bufferSize)).iterator();
            while (it.hasNext()) {
                stringBuffer.append((String) it.next());
                stringBuffer.append("\n");
            }
        } catch (Throwable th5) {
            o.d("CommonFileUtil", "readStream", th5);
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "sb.toString()");
        return stringBuffer2;
    }
}
