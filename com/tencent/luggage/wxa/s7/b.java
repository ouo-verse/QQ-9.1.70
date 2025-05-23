package com.tencent.luggage.wxa.s7;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import com.tencent.luggage.crash.WxaCrashUploaderService;
import com.tencent.luggage.wxa.aa.h;
import com.tencent.luggage.wxa.q7.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.x7.f;
import com.tencent.nativecrash.NativeCrash;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import oicq.wlogin_sdk.tools.util;
import org.apache.commons.io.FileUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements NativeCrash.c, NativeCrash.a, com.tencent.luggage.wxa.s7.a {

    /* renamed from: a, reason: collision with root package name */
    public static final b f140101a = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        public static final a f140102a = new a();

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(Pair pair, Pair pair2) {
            int intValue = ((Number) pair2.second).intValue();
            Object obj = pair.second;
            Intrinsics.checkNotNullExpressionValue(obj, "o1.second");
            return intValue - ((Number) obj).intValue();
        }
    }

    public final void a() {
        File file = new File(h0.f137983c);
        String format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.ENGLISH).format(new Date());
        e.f140120a.a(this);
        File file2 = new File(file, format + util.base64_pad_url + System.currentTimeMillis());
        h.b("wechatcrash", NativeCrash.class.getClassLoader());
        NativeCrash.a(file2.getAbsolutePath(), 1871, 2048, true);
        NativeCrash.c();
        NativeCrash.a("sdk_version: 4.0.0");
        NativeCrash.a("is_released: true");
        NativeCrash.a("rev: ff21ec7a35922aa90e584b2bb63d1a39c25df3b8");
        NativeCrash.a((NativeCrash.c) this);
        NativeCrash.a((NativeCrash.a) this);
    }

    public final c b(int i3, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder(2048);
        FileReader fileReader = new FileReader(str);
        try {
            CharBuffer allocate = CharBuffer.allocate(2048);
            while (fileReader.read(allocate) > 0) {
                allocate.flip();
                sb5.append((CharSequence) allocate);
                allocate.clear();
            }
            sb5.append('\n');
            CloseableKt.closeFinally(fileReader, null);
            Matcher matcher = Pattern.compile("\nClient Version: (0x[0-9A-Fa-f]{4,8})\n").matcher(sb5);
            if (i3 != 0) {
                sb5.append("\n !!! DUMPER EXITED UNEXPECTEDLY WITH STATUS: ");
                sb5.append(i3);
                sb5.append(" !!!\n");
            }
            w.d("Luggage.WxaCrashHandler", "generateCrashReport startTime:%s interTime:%s", Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(str2));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (Intrinsics.areEqual(readLine, "[File Descriptors]")) {
                            f140101a.a(bufferedReader, sb5);
                        } else {
                            sb5.append(readLine);
                            sb5.append('\n');
                        }
                    } finally {
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedReader, null);
            } catch (IOException e16) {
                sb5.append("Cannot read full dump file: ");
                sb5.append(e16);
                sb5.append('\n');
            }
            d dVar = d.NATIVE;
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
            c cVar = new c(dVar, sb6);
            if (matcher.find()) {
                cVar.a(w0.f(matcher.group(1)));
            }
            w.d("Luggage.WxaCrashHandler", "generateCrashReport startTime:%s interTime:%s", Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return cVar;
        } finally {
        }
    }

    @Override // com.tencent.nativecrash.NativeCrash.c
    public boolean a(int i3, String shortDumpFile, String fullDumpFile) {
        Intrinsics.checkNotNullParameter(shortDumpFile, "shortDumpFile");
        Intrinsics.checkNotNullParameter(fullDumpFile, "fullDumpFile");
        w.d("Luggage.WxaCrashHandler", "onCrashDumped: ");
        c b16 = b(i3, shortDumpFile, fullDumpFile);
        String str = h0.f137983c + b16.b() + ".txt";
        d dVar = d.NATIVE;
        h0.a(0, dVar.name(), "", b16.a());
        h0.a(dVar.name(), b16.a(), str);
        a(str);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r7, " -> ", 0, false, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(BufferedReader bufferedReader, StringBuilder sb5) {
        String readLine;
        boolean startsWith$default;
        int indexOf$default;
        ArrayList arrayList = new ArrayList();
        while (true) {
            readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            Intrinsics.checkNotNull(readLine);
            if ((readLine.length() == 0) || indexOf$default <= 0) {
                break;
            }
            String substring = readLine.substring(indexOf$default + 4);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            arrayList.add(substring);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        CollectionsKt__MutableCollectionsJVMKt.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Object obj = arrayList.get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "pathList[0]");
        String str = (String) obj;
        int size = arrayList.size();
        int i3 = 1;
        for (int i16 = 1; i16 < size; i16++) {
            Object obj2 = arrayList.get(i16);
            Intrinsics.checkNotNullExpressionValue(obj2, "pathList[i]");
            String str2 = (String) obj2;
            if (Intrinsics.areEqual(str2, str)) {
                i3++;
            } else {
                arrayList2.add(Pair.create(str, Integer.valueOf(i3)));
                str = str2;
                i3 = 1;
            }
        }
        arrayList2.add(Pair.create(str, Integer.valueOf(i3)));
        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList2, a.f140102a);
        sb5.append("[File Descriptors]\n");
        if (readLine != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(readLine, "Total: ", false, 2, null);
            if (startsWith$default) {
                sb5.append(readLine);
                sb5.append('\n');
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            sb5.append('(');
            Object obj3 = pair.second;
            Intrinsics.checkNotNullExpressionValue(obj3, "c.second");
            sb5.append(((Number) obj3).intValue());
            sb5.append(") ");
            sb5.append((String) pair.first);
            sb5.append('\n');
        }
        sb5.append('\n');
    }

    @Override // com.tencent.nativecrash.NativeCrash.a
    public boolean a(int i3, String dumpFile) {
        Intrinsics.checkNotNullParameter(dumpFile, "dumpFile");
        StringBuilder sb5 = new StringBuilder("");
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "getMainLooper().thread.stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(stackTraceElement);
            sb6.append('\n');
            sb5.append(sb6.toString());
        }
        d dVar = d.ANR;
        String sb7 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "stackTrace.toString()");
        c cVar = new c(dVar, sb7);
        String readFileToString = FileUtils.readFileToString(new File(dumpFile), Charset.defaultCharset());
        Intrinsics.checkNotNullExpressionValue(readFileToString, "readFileToString(File(du\u2026Charset.defaultCharset())");
        c cVar2 = new c(dVar, readFileToString);
        String str = h0.f137983c + "_anr_" + cVar2.b() + ".txt";
        h0.a(0, dVar.name(), "", cVar.a());
        h0.a(dVar.name(), cVar2.a(), str);
        a(str);
        w.b("Luggage.WxaCrashHandler", "onANRDumped, [%s]", cVar.toString());
        return false;
    }

    @Override // com.tencent.luggage.wxa.s7.a
    public void a(Thread thread, Throwable exception) {
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(exception, "exception");
        w.a("Luggage.WxaCrashHandler", exception, "thread [%s]", thread);
        d dVar = d.JVM_CRASH;
        String stackTraceString = Log.getStackTraceString(exception);
        Intrinsics.checkNotNullExpressionValue(stackTraceString, "getStackTraceString(exception)");
        c cVar = new c(dVar, stackTraceString);
        String str = h0.f137983c + cVar.b() + ".txt";
        h0.a(0, dVar.name(), exception.getMessage(), cVar.a());
        h0.a(dVar.name(), cVar.a(), str);
        a(str);
    }

    public final void a(String str) {
        Context c16 = z.c();
        String valueOf = String.valueOf(f.f144620c.c());
        Intent intent = new Intent(c16, (Class<?>) WxaCrashUploaderService.class);
        intent.putExtra("KEY_CRASH_LOG_PATH", str);
        intent.putExtra("KEY_CRASH_UIN", valueOf);
        intent.putExtra("KEY_CRASH_PRODUCT_ID", 6601);
        intent.putExtra("KEY_CLIENT_VERSION", 603979777);
        c16.startService(intent);
    }
}
