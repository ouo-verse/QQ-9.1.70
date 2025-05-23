package com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools;

import android.content.Context;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.luggage.wxa.c5.e;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.z;
import com.tencent.luggage.wxa.db.a;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ei.p;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.r4.d;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.magicbrush.MBRuntime;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0017J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J,\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/menu/devtools/SecondaryMenuDelegate_GameCpuProfiler;", "Lcom/tencent/luggage/wxa/vi/b;", "Lcom/tencent/luggage/wxa/m4/b;", "Landroid/content/Context;", "context", "pageView", "", "appId", "", "c", "a", "", "b", "Lcom/tencent/luggage/wxa/c5/e;", "runtime", "Lcom/tencent/magicbrush/b;", "Lcom/tencent/luggage/wxa/ei/p;", "executable", "Lcom/tencent/magicbrush/MBRuntime;", "mbRuntime", "path", "dumpFileName", "content", "Z", "isProfiling", "<init>", "()V", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class SecondaryMenuDelegate_GameCpuProfiler implements com.tencent.luggage.wxa.vi.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean isProfiling;

    /* loaded from: classes8.dex */
    public static final class b implements ValueCallback {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f140778b;

        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f140779a;

            public a(Context context) {
                this.f140779a = context;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(this.f140779a, "start cpu profiling...", 1).show();
                w.d("MiroMsg.GameCpuProfile", "start cpu profiling...");
            }
        }

        public b(Context context) {
            this.f140778b = context;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceiveValue(String str) {
            c0.a(new a(this.f140778b));
            SecondaryMenuDelegate_GameCpuProfiler.this.isProfiling = true;
        }
    }

    /* loaded from: classes8.dex */
    public static final class c implements ValueCallback {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f140781b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f140782c;

        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f140783a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f140784b;

            public a(Context context, String str) {
                this.f140783a = context;
                this.f140784b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(this.f140783a, this.f140784b + " exported.", 1).show();
                w.d("MiroMsg.GameCpuProfile", this.f140784b + " exported.");
            }
        }

        /* loaded from: classes8.dex */
        public static final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f140785a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f140786b;

            public b(Context context, String str) {
                this.f140785a = context;
                this.f140786b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(this.f140785a, this.f140786b + " export failed!", 1).show();
                w.b("MiroMsg.GameCpuProfile", this.f140786b + " export failed!");
            }
        }

        public c(String str, Context context) {
            this.f140781b = str;
            this.f140782c = context;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceiveValue(String s16) {
            SecondaryMenuDelegate_GameCpuProfiler secondaryMenuDelegate_GameCpuProfiler = SecondaryMenuDelegate_GameCpuProfiler.this;
            String str = this.f140781b;
            Intrinsics.checkNotNullExpressionValue(s16, "s");
            if (secondaryMenuDelegate_GameCpuProfiler.a(str, s16)) {
                c0.a(new a(this.f140782c, com.tencent.luggage.wxa.db.a.f124168a + "appbrand/trace/" + this.f140781b));
                SecondaryMenuDelegate_GameCpuProfiler.this.isProfiling = false;
                return;
            }
            c0.a(new b(this.f140782c, this.f140781b));
        }
    }

    @Override // com.tencent.luggage.wxa.vi.b
    public void b(Context context, com.tencent.luggage.wxa.m4.b pageView, String appId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(appId, "appId");
        e runtime = pageView.getRuntime();
        if (runtime == null || runtime.h0() == null) {
            return;
        }
        com.tencent.magicbrush.b a16 = a(runtime);
        if (a16 == null) {
            w.f("MiroMsg.GameCpuProfile", "hy: not magicbrush env");
        }
        if (this.isProfiling) {
            long currentTimeMillis = System.currentTimeMillis();
            j jsRuntime = runtime.h0().getJsRuntime();
            Intrinsics.checkNotNullExpressionValue(jsRuntime, "runtime.service.jsRuntime");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("CPU_%s_%d.cpuprofile", Arrays.copyOf(new Object[]{appId, Long.valueOf(currentTimeMillis)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            a(jsRuntime, a16, context, format);
            return;
        }
        v vVar = new v(a.f124168a + "appbrand/trace/");
        if (!vVar.e()) {
            vVar.w();
        }
        j jsRuntime2 = runtime.h0().getJsRuntime();
        Intrinsics.checkNotNullExpressionValue(jsRuntime2, "runtime.service.jsRuntime");
        a(jsRuntime2, a16, context);
    }

    @Override // com.tencent.luggage.wxa.vi.b
    public boolean c(Context context, com.tencent.luggage.wxa.m4.b pageView, String appId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(appId, "appId");
        return a(pageView.getRuntime()) != null;
    }

    @Override // com.tencent.luggage.wxa.vi.b
    public String a(Context context, com.tencent.luggage.wxa.m4.b pageView, String appId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(appId, "appId");
        return this.isProfiling ? "Stop CPU Profile" : "Start CPU Profile";
    }

    public final com.tencent.magicbrush.b a(e runtime) {
        l h06 = runtime != null ? runtime.h0() : null;
        Intrinsics.checkNotNull(h06, "null cannot be cast to non-null type com.tencent.luggage.sdk.jsapi.component.service.AppBrandServiceLU");
        com.tencent.luggage.wxa.w1.b bVar = (com.tencent.luggage.wxa.w1.b) ((d) h06).h(com.tencent.luggage.wxa.w1.b.class);
        if (bVar != null) {
            return bVar.n();
        }
        return null;
    }

    public final void a(p executable, MBRuntime mbRuntime, Context context) {
        executable.evaluateJavascript(";var __debug_v8_cpu_profiler = (function(profiler) {if (typeof profiler === 'undefined') { profiler = new NativeGlobal.CpuProfiler();} profiler.startProfiling(); return profiler;})(__debug_v8_cpu_profiler);", new b(context));
    }

    public final void a(p executable, MBRuntime mbRuntime, Context context, String path) {
        executable.evaluateJavascript(";(function(profiler) {return JSON.stringify(profiler.stopProfiling());})(__debug_v8_cpu_profiler);", new c(path, context));
    }

    public final boolean a(String dumpFileName, String content) {
        Exception e16;
        Throwable th5;
        z zVar;
        if (!com.tencent.luggage.wxa.aa.b.a()) {
            w.b("MiroMsg.GameCpuProfile", "dumpToFile error, SDCard is unavailable.");
            return false;
        }
        z zVar2 = null;
        try {
            try {
                v vVar = new v(a.f124168a + "appbrand/trace/");
                if (!vVar.e()) {
                    vVar.w();
                }
                zVar = new z(new v(vVar, dumpFileName), false);
                try {
                    zVar.write(content);
                    try {
                        zVar.close();
                    } catch (Exception e17) {
                        w.b("MiroMsg.GameCpuProfile", "close file error: " + e17);
                    }
                    return true;
                } catch (Exception e18) {
                    e16 = e18;
                    zVar2 = zVar;
                    w.b("MiroMsg.GameCpuProfile", "dump file error: " + e16);
                    if (zVar2 == null) {
                        return false;
                    }
                    try {
                        zVar2.close();
                        return false;
                    } catch (Exception e19) {
                        w.b("MiroMsg.GameCpuProfile", "close file error: " + e19);
                        return false;
                    }
                } catch (Throwable th6) {
                    th5 = th6;
                    if (zVar != null) {
                        try {
                            zVar.close();
                        } catch (Exception e26) {
                            w.b("MiroMsg.GameCpuProfile", "close file error: " + e26);
                        }
                    }
                    throw th5;
                }
            } catch (Exception e27) {
                e16 = e27;
            }
        } catch (Throwable th7) {
            th5 = th7;
            zVar = null;
        }
    }
}
