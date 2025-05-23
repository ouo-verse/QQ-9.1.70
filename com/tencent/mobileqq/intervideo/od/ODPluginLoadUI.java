package com.tencent.mobileqq.intervideo.od;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0006\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0002R\u001c\u0010\u000e\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u001c\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\rR\u001c\u0010\u0013\u001a\n \f*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\n \f*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/intervideo/od/ODPluginLoadUI;", "Landroid/widget/FrameLayout;", "", "d", "e", "setInit", "", "process", "total", "g", "c", "Landroid/view/View;", "kotlin.jvm.PlatformType", "Landroid/view/View;", "leftBtn", "progressLayout", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "progressText", "Landroid/widget/ProgressBar;", tl.h.F, "Landroid/widget/ProgressBar;", "progressBar", "", "i", "D", "hasDownSize", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "startDownTime", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqnearby_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ODPluginLoadUI extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View leftBtn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View progressLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final TextView progressText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ProgressBar progressBar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private double hasDownSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long startDownTime;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ODPluginLoadUI(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("cancel_size", Double.valueOf(this.hasDownSize));
        linkedHashMap.put("cancel_consume_time", Long.valueOf(System.currentTimeMillis() - this.startDownTime));
        VideoReport.reportEvent("group_video_open_cancel", linkedHashMap);
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("group_video_open_cancel", linkedHashMap);
    }

    private final void e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("download_ui_enter", Boolean.TRUE);
        VideoReport.reportEvent("group_video_open_cancel", linkedHashMap);
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("group_video_open_cancel", linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ODPluginLoadUI this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d();
        Context context = this$0.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) context).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ODPluginLoadUI this$0, int i3, int i16) {
        int roundToInt;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        double d16 = i3 * 100.0d;
        double d17 = 1024;
        roundToInt = MathKt__MathJVMKt.roundToInt((d16 / d17) / d17);
        this$0.hasDownSize = roundToInt / 100.0d;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this$0.hasDownSize);
        sb5.append("M/");
        double d18 = i16;
        roundToInt2 = MathKt__MathJVMKt.roundToInt(((d18 * 100.0d) / d17) / d17);
        sb5.append(roundToInt2 / 100.0d);
        sb5.append('M');
        String sb6 = sb5.toString();
        int i17 = (int) (d16 / d18);
        this$0.progressBar.setProgress(i17);
        this$0.progressText.setText(sb6);
        com.tencent.xaction.log.b.a("ODPluginLoadUI", 4, "updateProgress " + i17 + " - " + sb6);
    }

    public final void c() {
        d();
    }

    public final void g(final int process, final int total) {
        post(new Runnable() { // from class: com.tencent.mobileqq.intervideo.od.c
            @Override // java.lang.Runnable
            public final void run() {
                ODPluginLoadUI.h(ODPluginLoadUI.this, process, total);
            }
        });
    }

    public final void setInit() {
        this.leftBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.intervideo.od.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ODPluginLoadUI.f(ODPluginLoadUI.this, view);
            }
        });
        this.progressLayout.setVisibility(0);
        this.progressText.setText("");
        this.progressBar.setProgress(0);
        this.startDownTime = System.currentTimeMillis();
        e();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ODPluginLoadUI(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ODPluginLoadUI(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ODPluginLoadUI(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.f168188p9, this);
        this.leftBtn = findViewById(R.id.d0c);
        this.progressLayout = findViewById(R.id.d0e);
        this.progressText = (TextView) findViewById(R.id.d0f);
        this.progressBar = (ProgressBar) findViewById(R.id.d0g);
    }
}
