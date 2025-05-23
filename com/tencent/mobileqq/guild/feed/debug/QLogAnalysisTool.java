package com.tencent.mobileqq.guild.feed.debug;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001-\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u001e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010 R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/debug/QLogAnalysisTool;", "", "", "tag", "msg", "", "f", "Landroid/content/Context;", "ctx", "logMsg", "k", "wantedStr", "Ljava/util/regex/Pattern;", "i", "appContext", "timeStr", "", "mode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lcom/tencent/mobileqq/guild/feed/debug/k;", "b", "Ljava/util/Map;", "logs", "Ljava/util/concurrent/Semaphore;", "c", "Ljava/util/concurrent/Semaphore;", "semaphore", "d", "I", "mMode", "e", "Ljava/util/regex/Pattern;", "GuildPattern", "GProPattern", "Landroid/os/Handler;", "g", "Landroid/os/Handler;", "handler", tl.h.F, "Landroid/content/Context;", "j", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "com/tencent/mobileqq/guild/feed/debug/QLogAnalysisTool$b", "Lcom/tencent/mobileqq/guild/feed/debug/QLogAnalysisTool$b;", "logCallback", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "calculateRunnable", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class QLogAnalysisTool {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QLogAnalysisTool f218418a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, LogInfo> logs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Semaphore semaphore;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int mMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Pattern GuildPattern;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Pattern GProPattern;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler handler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static Context appContext;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b logCallback;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Runnable calculateRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/debug/QLogAnalysisTool$a", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            String string = msg2.getData().getString("LOG_KEY");
            if (string != null) {
                QLogAnalysisTool qLogAnalysisTool = QLogAnalysisTool.f218418a;
                qLogAnalysisTool.k(qLogAnalysisTool.j(), string);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/debug/QLogAnalysisTool$b", "Lcom/tencent/qphone/base/util/QLog$ILogCallback;", "", "tag", "msg", "", "onWriteLog", "", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements QLog.ILogCallback {
        b() {
        }

        @Override // com.tencent.qphone.base.util.QLog.ILogCallback
        public void onWriteLog(@NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLogAnalysisTool.f218418a.f(tag, msg2);
        }

        @Override // com.tencent.qphone.base.util.QLog.ILogCallback
        public void onWriteLog(@NotNull String tag, @NotNull byte[] msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLogAnalysisTool.f218418a.f(tag, msg2.toString());
        }
    }

    static {
        QLogAnalysisTool qLogAnalysisTool = new QLogAnalysisTool();
        f218418a = qLogAnalysisTool;
        logs = new HashMap();
        semaphore = new Semaphore(1);
        GuildPattern = qLogAnalysisTool.i("GUILD");
        GProPattern = qLogAnalysisTool.i("GPRO");
        handler = new a();
        logCallback = new b();
        calculateRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.debug.l
            @Override // java.lang.Runnable
            public final void run() {
                QLogAnalysisTool.g();
            }
        };
    }

    QLogAnalysisTool() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(String tag, String msg2) {
        int i3 = mMode;
        if (i3 != 0) {
            if (i3 != 1) {
                return;
            }
            tag = tag + msg2;
        }
        Map<String, LogInfo> map = logs;
        LogInfo logInfo = map.get(tag);
        if (logInfo != null) {
            logInfo.c(logInfo.getTimes() + 1);
            logInfo.d(logInfo.getTotalLength() + msg2.length());
        } else {
            map.put(tag, new LogInfo(1L, msg2.length()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        semaphore.acquire();
        QLog.removeLogCallback(logCallback);
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        final QLogAnalysisTool$calculateRunnable$1$queue$1 qLogAnalysisTool$calculateRunnable$1$queue$1 = new Function2<Pair<? extends String, ? extends LogInfo>, Pair<? extends String, ? extends LogInfo>, Integer>() { // from class: com.tencent.mobileqq.guild.feed.debug.QLogAnalysisTool$calculateRunnable$1$queue$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(Pair<? extends String, ? extends LogInfo> pair, Pair<? extends String, ? extends LogInfo> pair2) {
                return invoke2((Pair<String, LogInfo>) pair, (Pair<String, LogInfo>) pair2);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Integer invoke2(Pair<String, LogInfo> pair, Pair<String, LogInfo> pair2) {
                long times = pair.getSecond().getTimes() - pair2.getSecond().getTimes();
                return Integer.valueOf(times == 0 ? 0 : times > 0 ? 1 : -1);
            }
        };
        PriorityQueue priorityQueue = new PriorityQueue(new Comparator() { // from class: com.tencent.mobileqq.guild.feed.debug.n
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int h16;
                h16 = QLogAnalysisTool.h(Function2.this, obj, obj2);
                return h16;
            }
        });
        Iterator<T> it = logs.entrySet().iterator();
        long j3 = 0;
        long j16 = 0;
        long j17 = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (((LogInfo) entry.getValue()).getTimes() > 5) {
                priorityQueue.offer(new Pair(entry.getKey(), entry.getValue()));
            }
            while (priorityQueue.size() > 20) {
                priorityQueue.poll();
            }
            j3 += ((LogInfo) entry.getValue()).getTimes();
            if (GuildPattern.matcher((CharSequence) entry.getKey()).find()) {
                j16 += ((LogInfo) entry.getValue()).getTimes();
            }
            if (GProPattern.matcher((CharSequence) entry.getKey()).find()) {
                j17 += ((LogInfo) entry.getValue()).getTimes();
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("summary:\n totalTimes:" + j3 + ", totalGuildTimes:" + j16 + ", totalGProTimes:" + j17);
        while (priorityQueue.size() > 0) {
            Pair pair = (Pair) priorityQueue.poll();
            if (pair != null) {
                sb5.insert(0, '\n');
                long totalLength = ((LogInfo) pair.getSecond()).getTotalLength() / ((LogInfo) pair.getSecond()).getTimes();
                sb5.insert(0, "[tag:" + pair.getFirst() + ", times:" + ((LogInfo) pair.getSecond()).getTimes() + ", averageLen:" + totalLength + "]");
            }
        }
        Message obtain = Message.obtain();
        obtain.setData(new Bundle());
        obtain.getData().putString("LOG_KEY", sb5.toString());
        handler.sendMessage(obtain);
        semaphore.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    private final Pattern i(String wantedStr) {
        Pattern compile = Pattern.compile(wantedStr, 2);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(wantedStr, Pattern.CASE_INSENSITIVE)");
        return compile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Context ctx, String logMsg) {
        try {
            Object systemService = ctx.getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText(null, logMsg));
            QQToast.makeText(ctx, "\u5df2\u590d\u5236\u9ad8\u9891\u65e5\u5fd7\u4fe1\u606f", 0).show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QLogAnalysisTool", 4, "showMessage failed, exception: " + e16);
            }
        }
        View decorView = QBaseActivity.sTopActivity.getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) decorView;
        if (viewGroup instanceof FrameLayout) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
            TextView textView = (TextView) viewGroup.findViewById(R.id.w3e);
            if (textView == null) {
                textView = new TextView(viewGroup.getContext());
            }
            textView.setId(R.id.w3e);
            textView.setTextColor(-1);
            textView.setBackgroundColor(-1442840576);
            textView.setTextIsSelectable(true);
            viewGroup.addView(textView, layoutParams);
            textView.setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.mobileqq.guild.feed.debug.m
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                    boolean l3;
                    l3 = QLogAnalysisTool.l(view, i3, keyEvent);
                    return l3;
                }
            });
            textView.setText(logMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(View view, int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            View decorView = QBaseActivity.sTopActivity.getWindow().getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) decorView;
            View findViewById = viewGroup.findViewById(R.id.w3e);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
                return true;
            }
            return true;
        }
        return true;
    }

    @NotNull
    public final Context j() {
        Context context = appContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
        return null;
    }

    public final void m(@NotNull Context appContext2, @NotNull String timeStr, int mode) {
        Intrinsics.checkNotNullParameter(appContext2, "appContext");
        Intrinsics.checkNotNullParameter(timeStr, "timeStr");
    }
}
