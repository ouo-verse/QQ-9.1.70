package com.tencent.qmethod.monitor.debug.question;

import android.os.Handler;
import android.widget.Toast;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.base.util.AppInfo;
import com.tencent.qmethod.monitor.base.util.f;
import com.tencent.qmethod.pandoraex.api.u;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0019\u0010\t\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001fR*\u0010'\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00048\u0000@@X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/qmethod/monitor/debug/question/QuestionCollect;", "", "", "j", "", "f", "Lcom/tencent/qmethod/pandoraex/api/u;", "reportStrategy", "i", "d", "(Lcom/tencent/qmethod/pandoraex/api/u;)V", "g", "e", "()V", "", "a", "J", "lastDumpTime", "", "", "Lcom/tencent/qmethod/monitor/debug/question/a;", "b", "Ljava/util/Map;", "questionMap", "c", "Ljava/lang/String;", "processName", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mainProcessListenRunnable", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "value", "Z", "getShowToast$qmethod_privacy_monitor_tencentBuglyRelease", "()Z", h.F, "(Z)V", UIJsPlugin.EVENT_SHOW_TOAST, "<init>", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class QuestionCollect {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static long lastDumpTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, QuestionInfo> questionMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String processName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Runnable mainProcessListenRunnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Handler handler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean showToast;

    /* renamed from: g, reason: collision with root package name */
    public static final QuestionCollect f343597g;

    static {
        QuestionCollect questionCollect = new QuestionCollect();
        f343597g = questionCollect;
        lastDumpTime = System.currentTimeMillis();
        questionMap = new LinkedHashMap();
        processName = AppInfo.INSTANCE.c(com.tencent.qmethod.monitor.a.f343451h.g().getContext());
        mainProcessListenRunnable = new Runnable() { // from class: com.tencent.qmethod.monitor.debug.question.QuestionCollect$mainProcessListenRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                long j3;
                long b16 = f.b("mainCallOther");
                if (b16 != 0) {
                    QuestionCollect questionCollect2 = QuestionCollect.f343597g;
                    j3 = QuestionCollect.lastDumpTime;
                    if (j3 < b16) {
                        QuestionCollect.lastDumpTime = System.currentTimeMillis();
                        questionCollect2.e();
                    }
                }
                QuestionCollect questionCollect3 = QuestionCollect.f343597g;
                questionCollect3.h(f.a("mainToastOpen"));
                questionCollect3.j();
            }
        };
        handler = new Handler(ThreadManager.f343506c.b());
        questionCollect.j();
    }

    QuestionCollect() {
    }

    private final boolean f() {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(processName);
        if ((!isBlank) && Intrinsics.areEqual(processName, com.tencent.qmethod.monitor.a.f343451h.g().getContext().getPackageName())) {
            return true;
        }
        return false;
    }

    private final void i(u reportStrategy) {
        if (showToast && !Intrinsics.areEqual("normal", reportStrategy.f343967d)) {
            Toast.makeText(com.tencent.qmethod.monitor.a.f343451h.g().getContext(), "\u7591\u4f3c\u654f\u611fAPI\u95ee\u9898: api:" + reportStrategy.f343965b + ",\u573a\u666f:" + reportStrategy.f343967d + ",\u7b56\u7565:" + reportStrategy.f343968e + ",\u8fdb\u7a0b:" + reportStrategy.f343979p + ",\u8be6\u7ec6\u4fe1\u606f\u8bf7\u901a\u8fc7\u65e5\u5fd7\u67e5\u770b", 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        if (!f()) {
            handler.postDelayed(mainProcessListenRunnable, 10000L);
        }
    }

    public final void d(@Nullable u reportStrategy) {
        if (reportStrategy != null) {
            Map<String, QuestionInfo> map = questionMap;
            if (map.containsKey(b.a(reportStrategy))) {
                QuestionInfo questionInfo = map.get(b.a(reportStrategy));
                if (questionInfo != null) {
                    questionInfo.a(reportStrategy);
                }
            } else {
                map.put(b.a(reportStrategy), new QuestionInfo(reportStrategy));
            }
            f343597g.i(reportStrategy);
        }
    }

    public final void e() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("processName", processName);
        Iterator<T> it = questionMap.values().iterator();
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            i16 += ((QuestionInfo) it.next()).e();
        }
        jSONObject.put("questionCount", i16);
        Iterator<T> it5 = questionMap.values().iterator();
        while (it5.hasNext()) {
            i3 += ((QuestionInfo) it5.next()).f();
        }
        jSONObject.put("reportCount", i3);
        JSONArray jSONArray = new JSONArray();
        Iterator<Map.Entry<String, QuestionInfo>> it6 = questionMap.entrySet().iterator();
        while (it6.hasNext()) {
            jSONArray.mo162put(it6.next().getValue().d());
        }
        jSONObject.put("apis", jSONArray);
        o.a("QuestionCollect", jSONObject.toString());
        if (f()) {
            f.f("mainCallOther", System.currentTimeMillis());
        }
    }

    public final void g(@NotNull u reportStrategy) {
        Intrinsics.checkParameterIsNotNull(reportStrategy, "reportStrategy");
        QuestionInfo questionInfo = questionMap.get(b.a(reportStrategy));
        if (questionInfo != null) {
            questionInfo.h(reportStrategy);
        }
    }

    public final void h(boolean z16) {
        showToast = z16;
        if (f()) {
            f.e("mainToastOpen", z16);
        }
    }
}
