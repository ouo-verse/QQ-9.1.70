package com.tencent.qqmini.sdk.monitor.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager;
import com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ou3.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001\tB\u000f\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\n\u001a\u00020\u0003J\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ0\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0014R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0014\u0010!\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR\u0014\u0010#\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0014\u0010%\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001cR\u0014\u0010'\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u001cR\u0014\u0010)\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\u001c\u00a8\u0006/"}, d2 = {"Lcom/tencent/qqmini/sdk/monitor/ui/MiniGameMonitorView;", "Landroid/widget/FrameLayout;", "Landroid/os/Handler$Callback;", "", "c", "Landroid/os/Message;", "msg", "", "handleMessage", "a", "b", "", "fps", "", "drawCallCount", "d", "changed", "", "left", "top", "right", "bottom", "onLayout", "Landroid/os/Handler;", "Landroid/os/Handler;", "uiHandler", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "startCostTv", "f", "pkgDownloadTv", h.F, "fpsTv", "i", "jankTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "memoryUsageRateTv", BdhLogUtil.LogTag.Tag_Conn, "nativePssTv", "D", "graphicsTv", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class MiniGameMonitorView extends FrameLayout implements Handler.Callback {

    /* renamed from: C, reason: from kotlin metadata */
    private final TextView nativePssTv;

    /* renamed from: D, reason: from kotlin metadata */
    private final TextView graphicsTv;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Handler uiHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView startCostTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final TextView pkgDownloadTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final TextView fpsTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final TextView jankTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final TextView memoryUsageRateTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniGameMonitorView(@NotNull Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.uiHandler = new Handler(Looper.getMainLooper(), this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.mini_sdk_popup_monitor_layout, this);
        View findViewById = inflate.findViewById(R.id.monitor_switch_page);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "contentView.findViewById\u2026R.id.monitor_switch_page)");
        ((TextView) findViewById).setVisibility(8);
        View findViewById2 = inflate.findViewById(R.id.monitor_start_time);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "contentView.findViewById(R.id.monitor_start_time)");
        this.startCostTv = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.monitor_download_package);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "contentView.findViewById\u2026monitor_download_package)");
        this.pkgDownloadTv = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.monitor_fps);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "contentView.findViewById(R.id.monitor_fps)");
        this.fpsTv = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.monitor_drawcall);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "contentView.findViewById(R.id.monitor_drawcall)");
        TextView textView = (TextView) findViewById5;
        this.jankTv = textView;
        textView.setVisibility(0);
        View findViewById6 = inflate.findViewById(R.id.monitor_cpu_rate);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "contentView.findViewById\u2026w>(R.id.monitor_cpu_rate)");
        findViewById6.setVisibility(8);
        View findViewById7 = inflate.findViewById(R.id.monitor_cpu_usage);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "contentView.findViewById\u2026>(R.id.monitor_cpu_usage)");
        findViewById7.setVisibility(8);
        View findViewById8 = inflate.findViewById(R.id.monitor_db_cache);
        Intrinsics.checkExpressionValueIsNotNull(findViewById8, "contentView.findViewById(R.id.monitor_db_cache)");
        this.memoryUsageRateTv = (TextView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.monitor_native_pss);
        Intrinsics.checkExpressionValueIsNotNull(findViewById9, "contentView.findViewById(R.id.monitor_native_pss)");
        this.nativePssTv = (TextView) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.monitor_graphics);
        Intrinsics.checkExpressionValueIsNotNull(findViewById10, "contentView.findViewById(R.id.monitor_graphics)");
        this.graphicsTv = (TextView) findViewById10;
    }

    private final void c() {
        this.startCostTv.setText("\u542f\u52a8\u8017\u65f6\uff1a" + MiniGamePerformanceStatics.sLaunchCost + "ms");
        this.pkgDownloadTv.setText("\u5305\u4e0b\u8f7d\u8017\u65f6\uff1a" + MiniGamePerformanceStatics.sPkgDownloadCost + "ms");
        MiniGamePerformanceStatics miniGamePerformanceStatics = MiniGamePerformanceStatics.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(miniGamePerformanceStatics, "MiniGamePerformanceStatics.getInstance()");
        a jankStatistics = miniGamePerformanceStatics.getJankStatistics();
        Intrinsics.checkExpressionValueIsNotNull(jankStatistics, "MiniGamePerformanceStati\u2026Instance().jankStatistics");
        this.jankTv.setText("jankCount\uff1a" + jankStatistics.getJankCount() + "; bigJankCount\uff1a" + jankStatistics.getBigJankCount());
        TextView textView = this.memoryUsageRateTv;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u5185\u5b58\u4f7f\u7528\u7387\uff1a");
        TaskMonitorManager g16 = TaskMonitorManager.g();
        Intrinsics.checkExpressionValueIsNotNull(g16, "TaskMonitorManager.g()");
        sb5.append(g16.getMemeryUsage());
        sb5.append('%');
        textView.setText(sb5.toString());
        int[] memoryStatics = TaskMonitorManager.getMemoryStatics();
        this.nativePssTv.setText("NativePss\uff1a" + (memoryStatics[1] / 1024) + "MB");
        this.graphicsTv.setText("Graphics\uff1a" + (memoryStatics[2] / 1024) + "MB");
    }

    public final void a() {
        this.uiHandler.removeMessages(12852);
        this.uiHandler.sendEmptyMessage(12852);
    }

    public final void b() {
        this.uiHandler.removeMessages(12852);
    }

    public final void d(float fps, long drawCallCount) {
        this.fpsTv.setText("FPS\uff1a" + ((int) fps) + "; drawCall\uff1a" + drawCallCount);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        if (msg2.what == 12852) {
            c();
            this.uiHandler.sendEmptyMessageDelayed(12852, 3000L);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        bringToFront();
    }
}
