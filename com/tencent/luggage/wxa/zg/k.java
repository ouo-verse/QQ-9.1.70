package com.tencent.luggage.wxa.zg;

import android.content.Context;
import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.l0.g;
import com.tencent.luggage.wxa.l0.q;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.z.b;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import cooperation.qzone.util.PerfTracer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.bh.a f146686a = new com.tencent.luggage.wxa.bh.a();

    /* renamed from: b, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.o.c f146687b = new com.tencent.luggage.wxa.o.c();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements com.tencent.luggage.wxa.jq.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function f146688a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f146689b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f146690c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f146691d;

        public a(Function function, int i3, String str, int i16) {
            this.f146688a = function;
            this.f146689b = i3;
            this.f146690c = str;
            this.f146691d = i16;
        }

        @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return "MicroMsg.SameLayer.ExoMediaPlayerUtils";
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f146688a.apply(k.b(this.f146689b, this.f146690c, this.f146691d));
        }
    }

    public static boolean b(Context context) {
        return h0.k(context);
    }

    public static g.a a(Context context) {
        com.tencent.luggage.wxa.bh.a aVar = f146686a;
        return new com.tencent.luggage.wxa.l0.m(context, aVar, a(aVar, com.tencent.luggage.wxa.xg.k.a(context)));
    }

    public static String b(int i3, String str, int i16) {
        String str2;
        String[] strArr;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - (i16 * 1000);
        int i17 = Calendar.getInstance().get(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault());
        String str3 = "^\\d\\d-\\d\\d\\s\\d\\d:.*";
        int i18 = 0;
        if (str == null) {
            str2 = "getLogcatContent exception2";
            strArr = new String[]{"logcat", LogCmdOptions.DUMP, "-v", PerfTracer.THREADTIME_TAG};
        } else {
            str2 = "getLogcatContent exception2";
            strArr = new String[]{"logcat", LogCmdOptions.DUMP, "-v", PerfTracer.THREADTIME_TAG, "-s", str};
        }
        StringBuilder sb5 = new StringBuilder();
        Process process = null;
        try {
            process = RuntimeMonitor.exec(Runtime.getRuntime(), strArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            boolean z16 = false;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.matches(str3)) {
                    BufferedReader bufferedReader2 = bufferedReader;
                    String str4 = str3;
                    String substring = readLine.substring(i18, 18);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(i17);
                    sb6.append("-");
                    int i19 = i17;
                    sb6.append(substring.substring(0, 18));
                    long time = simpleDateFormat.parse(sb6.toString()).getTime();
                    if (time > currentTimeMillis) {
                        break;
                    }
                    if (time > j3) {
                        if (!z16) {
                            sb5.append(">>>>>> start logcat log <<<<<<\n");
                            z16 = true;
                        }
                        sb5.append(readLine);
                        sb5.append("\n");
                    }
                    if (i3 > 0 && sb5.length() > i3) {
                        sb5.delete(0, sb5.length() - i3);
                    }
                    bufferedReader = bufferedReader2;
                    str3 = str4;
                    i17 = i19;
                    i18 = 0;
                }
            }
            sb5.append(">>>>>> end logcat log <<<<<<");
            String sb7 = sb5.toString();
            try {
                process.getOutputStream().close();
            } catch (IOException e16) {
                w.a("MicroMsg.SameLayer.ExoMediaPlayerUtils", e16, "getLogcatContent exception1", new Object[0]);
            }
            try {
                process.getInputStream().close();
            } catch (Exception e17) {
                w.a("MicroMsg.SameLayer.ExoMediaPlayerUtils", e17, str2, new Object[0]);
            }
            try {
                process.getErrorStream().close();
            } catch (IOException e18) {
                w.a("MicroMsg.SameLayer.ExoMediaPlayerUtils", e18, "getLogcatContent exception3", new Object[0]);
            }
            return sb7;
        } catch (Throwable th5) {
            String str5 = str2;
            try {
                sb5.append("\n[error:" + th5.toString() + "]");
                String sb8 = sb5.toString();
                if (process != null) {
                    try {
                        process.getOutputStream().close();
                    } catch (IOException e19) {
                        w.a("MicroMsg.SameLayer.ExoMediaPlayerUtils", e19, "getLogcatContent exception1", new Object[0]);
                    }
                    try {
                        process.getInputStream().close();
                    } catch (Exception e26) {
                        w.a("MicroMsg.SameLayer.ExoMediaPlayerUtils", e26, str5, new Object[0]);
                    }
                    try {
                        process.getErrorStream().close();
                    } catch (IOException e27) {
                        w.a("MicroMsg.SameLayer.ExoMediaPlayerUtils", e27, "getLogcatContent exception3", new Object[0]);
                    }
                }
                return sb8;
            } finally {
            }
        }
    }

    public static g.a a(Context context, Map map) {
        com.tencent.luggage.wxa.bh.a aVar = f146686a;
        return new com.tencent.luggage.wxa.l0.m(context, aVar, a(aVar, com.tencent.luggage.wxa.xg.k.a(context), map));
    }

    public static q.b a(com.tencent.luggage.wxa.bh.a aVar, String str) {
        return new b(str, aVar, 8000, 8000, true);
    }

    public static q.b a(com.tencent.luggage.wxa.bh.a aVar, String str, Map map) {
        b bVar = new b(str, aVar, 8000, 8000, true);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                w.d("MicroMsg.SameLayer.ExoMediaPlayerUtils", "buildDefaultHttpDataSourceFactory, header: %s: %s", entry.getKey(), entry.getValue());
                bVar.a((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return bVar;
    }

    public static void a(Function function) {
        a(0, null, 10, function);
    }

    public static void a(int i3, String str, int i16, Function function) {
        if (!c0.b()) {
            function.apply(b(i3, str, i16));
        } else {
            com.tencent.luggage.wxa.zp.h.f146825d.execute(new a(function, i3, str, i16));
        }
    }

    public static com.tencent.luggage.wxa.bh.a a() {
        return f146686a;
    }

    public static String a(Throwable th5) {
        if (th5 == null) {
            return String.valueOf((char[]) null);
        }
        if (th5 instanceof b.a) {
            b.a aVar = (b.a) th5;
            return "DecoderInitializationException{message='" + aVar.getLocalizedMessage() + "', mimeType='" + aVar.f146158a + "', secureDecoderRequired=" + aVar.f146159b + ", decoderName='" + aVar.f146160c + "', diagnosticInfo='" + aVar.f146161d + "'}";
        }
        return th5.toString();
    }

    public static String a(com.tencent.luggage.wxa.o.c cVar) {
        if (cVar == null) {
            return String.valueOf((char[]) null);
        }
        return "DecoderCounters{decoderInitCount=" + cVar.f135948a + ", decoderReleaseCount=" + cVar.f135949b + ", inputBufferCount=" + cVar.f135950c + ", renderedOutputBufferCount=" + cVar.f135951d + ", skippedOutputBufferCount=" + cVar.f135952e + ", droppedOutputBufferCount=" + cVar.f135953f + ", maxConsecutiveDroppedOutputBufferCount=" + cVar.f135954g + '}';
    }
}
