package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.f;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.videocut.utils.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj2.CommonConfig;
import rj2.a;
import tl.h;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0002\u0014FB\u0007\u00a2\u0006\u0004\bE\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0002J\u000f\u0010\u0007\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u000f\u001a\u00020\u00042\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rJ\u001b\u0010\u0011\u001a\u00020\u00042\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\rH\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0018\u001a\u00020\u0004H\u0007J\u0006\u0010\u0019\u001a\u00020\u0015J\u0019\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020 J\u0006\u0010&\u001a\u00020%J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0007R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010.R\u0017\u00104\u001a\u0002008\u0006\u00a2\u0006\f\n\u0004\b\u000f\u00101\u001a\u0004\b2\u00103R\u001e\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00106R\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u00108R\u0016\u0010:\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00108R\u0014\u0010<\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010;R\u0016\u0010>\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010=R\u0014\u0010@\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010?R\u0018\u0010C\u001a\u00060AR\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010BR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010D\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "Lrj2/a$c;", "", "b", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "k", "()V", "position", "", "caller", DomainData.DOMAIN_NAME, "Lpj2/a;", "timelineViewController", "c", "controller", "d", "(Lpj2/a;)V", HippyTKDListViewAdapter.X, "a", "Lqj2/a;", DownloadInfo.spKey_Config, "o", "l", "f", "Landroid/view/MotionEvent;", "ev", ReportConstant.COSTREPORT_PREFIX, "(Landroid/view/MotionEvent;)V", "Ltj2/a;", "g", "", "endTimeUs", "r", "minClipDuration", "p", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/PanelEventHandler;", "i", "", NodeProps.VISIBLE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/TimelinePanel;", "view", "e", "Lqj2/a;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/TimelinePanel;", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "Lrj2/a;", "Lrj2/a;", "j", "()Lrj2/a;", "scaleCalculator", "", "Ljava/util/List;", "childViewModelList", "I", "currentScrollX", "presetX", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/PanelEventHandler;", "panelEventHandler", "Z", "isUserTouching", "Ltj2/a;", "flingHelper", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/TimelinePanelViewController$ScrollRunnable;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/TimelinePanelViewController$ScrollRunnable;", "scrollRunnable", "J", "<init>", "ScrollRunnable", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class TimelinePanelViewController implements a.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CommonConfig config = new CommonConfig(null, null, null, null, 15, null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TimelinePanel panel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final rj2.a scaleCalculator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<pj2.a<?>> childViewModelList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int currentScrollX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int presetX;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PanelEventHandler panelEventHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isUserTouching;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final tj2.a flingHelper;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ScrollRunnable scrollRunnable;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long minClipDuration;

    public TimelinePanelViewController() {
        rj2.a aVar = new rj2.a();
        aVar.a(this);
        this.scaleCalculator = aVar;
        this.childViewModelList = new ArrayList();
        this.presetX = -1;
        this.panelEventHandler = new PanelEventHandler();
        this.flingHelper = new tj2.a();
        this.scrollRunnable = new ScrollRunnable();
        l();
    }

    @Override // rj2.a.c
    public void a(int x16) {
        n(x16, this);
    }

    @Override // rj2.a.c
    /* renamed from: b, reason: from getter */
    public int getCurrentScrollX() {
        return this.currentScrollX;
    }

    public final void c(@NotNull pj2.a<?> timelineViewController) {
        Intrinsics.checkNotNullParameter(timelineViewController, "timelineViewController");
        this.childViewModelList.add(timelineViewController);
        timelineViewController.o(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
    @RequiresApi(21)
    public final void d(@NotNull pj2.a<?> controller) {
        TimelinePanel timelinePanel;
        Intrinsics.checkNotNullParameter(controller, "controller");
        ?? m3 = controller.m();
        if (m3 != 0 && (timelinePanel = this.panel) != 0) {
            timelinePanel.B0(m3);
        }
    }

    @RequiresApi(21)
    public final void e(@NotNull TimelinePanel view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.panel = view;
        view.C0(this);
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final CommonConfig getConfig() {
        return this.config;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final tj2.a getFlingHelper() {
        return this.flingHelper;
    }

    public final int h() {
        Object obj;
        Iterator<T> it = this.childViewModelList.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                int c16 = ((pj2.a) next).c();
                do {
                    Object next2 = it.next();
                    int c17 = ((pj2.a) next2).c();
                    if (c16 < c17) {
                        next = next2;
                        c16 = c17;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        pj2.a aVar = (pj2.a) obj;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final PanelEventHandler getPanelEventHandler() {
        return this.panelEventHandler;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final rj2.a getScaleCalculator() {
        return this.scaleCalculator;
    }

    public final void k() {
        HashSet hashSetOf;
        hashSetOf = SetsKt__SetsKt.hashSetOf(Integer.valueOf(this.currentScrollX));
        Iterator<T> it = this.childViewModelList.iterator();
        while (it.hasNext()) {
            hashSetOf.addAll(((pj2.a) it.next()).b());
        }
        Iterator<T> it5 = this.childViewModelList.iterator();
        while (it5.hasNext()) {
            ((pj2.a) it5.next()).e(hashSetOf);
        }
    }

    @RequiresApi(21)
    public final void l() {
        rj2.a aVar = this.scaleCalculator;
        e eVar = e.f384236a;
        aVar.p(eVar.a(this.config.getTimeBarConfig().getMaxSpace()));
        aVar.q(eVar.a(this.config.getTimeBarConfig().getMinSpace()));
        this.flingHelper.a(this.config.getScrollConfig().getFlingFactor());
        Iterator<T> it = this.childViewModelList.iterator();
        while (it.hasNext()) {
            ((pj2.a) it.next()).n();
        }
    }

    public final void m() {
        int h16 = h();
        Iterator<T> it = this.childViewModelList.iterator();
        while (it.hasNext()) {
            ((pj2.a) it.next()).a(h16);
        }
    }

    public final void n(int position, @Nullable Object caller) {
        boolean z16;
        if (this.currentScrollX == position) {
            return;
        }
        this.currentScrollX = position;
        k();
        List<pj2.a<?>> list = this.childViewModelList;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((pj2.a) next) == caller) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((pj2.a) it5.next()).d(this.currentScrollX);
        }
        PanelEventHandler panelEventHandler = this.panelEventHandler;
        long e16 = this.scaleCalculator.e();
        if (caller == this) {
            z16 = false;
        }
        panelEventHandler.a(new f(e16, z16));
    }

    public final void o(@NotNull CommonConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    public final void p(long minClipDuration) {
        this.minClipDuration = minClipDuration;
    }

    public final void q(boolean visible) {
        View view;
        int i3;
        TimelinePanel timelinePanel = this.panel;
        if (timelinePanel != null) {
            view = timelinePanel.E0();
        } else {
            view = null;
        }
        if (view != null) {
            if (visible) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            view.setVisibility(i3);
        }
    }

    public final void r(long endTimeUs) {
        if (this.scaleCalculator.getEndTimeUs() == endTimeUs) {
            return;
        }
        this.scaleCalculator.o(endTimeUs);
        Iterator<T> it = this.childViewModelList.iterator();
        while (it.hasNext()) {
            ((pj2.a) it.next()).n();
        }
    }

    public final void s(@Nullable MotionEvent ev5) {
        Integer num;
        if (ev5 != null) {
            num = Integer.valueOf(ev5.getActionMasked());
        } else {
            num = null;
        }
        boolean z16 = true;
        if (num != null && num.intValue() == 0) {
            this.flingHelper.c();
            this.isUserTouching = true;
            return;
        }
        if ((num == null || num.intValue() != 3) && (num == null || num.intValue() != 1)) {
            z16 = false;
        }
        if (z16) {
            this.isUserTouching = false;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/TimelinePanelViewController$ScrollRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/TimelinePanelViewController;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public final class ScrollRunnable implements Runnable {
        public ScrollRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
