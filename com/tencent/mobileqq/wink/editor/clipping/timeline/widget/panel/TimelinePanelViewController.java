package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.l;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.videocut.utils.e;
import g63.CommonConfig;
import i63.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0002\u001d_B\u0007\u00a2\u0006\u0004\b^\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0002J\u000f\u0010\n\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u0012\u0010\u0018\u001a\u00020\u00042\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016J\u001b\u0010\u001a\u001a\u00020\u00042\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u001eJ\u0019\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H\u0000\u00a2\u0006\u0004\b%\u0010&J\u0006\u0010(\u001a\u00020'J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u000fJ\u000e\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u000fJ\u0006\u0010.\u001a\u00020-J\u000e\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020/J\u000e\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u000202R\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u00105R\u0018\u00107\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00106R\u0017\u0010<\u001a\u0002088\u0006\u00a2\u0006\f\n\u0004\b\u0006\u00109\u001a\u0004\b:\u0010;R\u001e\u0010@\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\"\u0010I\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\b\u001c\u0010HR\u0016\u0010K\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010BR\u0014\u0010M\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010LR$\u0010P\u001a\u00020/2\u0006\u0010N\u001a\u00020/8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001a\u0010E\u001a\u0004\bO\u0010GR\u0014\u0010R\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010QR\u0018\u0010U\u001a\u00060SR\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010TR\u0016\u0010+\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010VR0\u0010]\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0004\u0018\u00010W8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "Li63/b$c;", "", "position", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "c", "b", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()V", "", "caller", "v", "", "timeUs", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "scaleFactor", "t", "u", "Lf63/a;", "timelineViewController", h.F, "controller", "i", "(Lf63/a;)V", HippyTKDListViewAdapter.X, "a", "Lg63/a;", DownloadInfo.spKey_Config, "w", "r", "k", "Landroid/view/MotionEvent;", "ev", "D", "(Landroid/view/MotionEvent;)V", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper;", "l", "endTimeUs", BdhLogUtil.LogTag.Tag_Conn, "minClipDuration", "y", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEventHandler;", DomainData.DOMAIN_NAME, "", NodeProps.VISIBLE, "B", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanel;", "view", "j", "Lg63/a;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanel;", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "Li63/b;", "Li63/b;", "o", "()Li63/b;", "scaleCalculator", "", "d", "Ljava/util/List;", "childViewModelList", "e", "I", "currentScrollX", "f", "Z", "getForbiddenScale", "()Z", "(Z)V", "forbiddenScale", "g", "presetX", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEventHandler;", "panelEventHandler", "<set-?>", "p", "isUserTouching", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper;", "flingHelper", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController$ScrollRunnable;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController$ScrollRunnable;", "scrollRunnable", "J", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "getOnUserTouchChangeCb", "()Lkotlin/jvm/functions/Function1;", "setOnUserTouchChangeCb", "(Lkotlin/jvm/functions/Function1;)V", "onUserTouchChangeCb", "<init>", "ScrollRunnable", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TimelinePanelViewController implements b.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CommonConfig config = new CommonConfig(null, null, null, null, 15, null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TimelinePanel panel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i63.b scaleCalculator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<f63.a<?>> childViewModelList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int currentScrollX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean forbiddenScale;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int presetX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PanelEventHandler panelEventHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isUserTouching;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FlingHelper flingHelper;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ScrollRunnable scrollRunnable;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long minClipDuration;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Boolean, Unit> onUserTouchChangeCb;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController$ScrollRunnable;", "Ljava/lang/Runnable;", "", "e", "", TencentLocation.RUN_MODE, "", "value", "d", "I", "getDistance", "()I", "f", "(I)V", Element.ELEMENT_NAME_DISTANCE, "scrollXPerFrame", "<init>", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class ScrollRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int distance;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int scrollXPerFrame;

        public ScrollRunnable() {
        }

        private final boolean e() {
            if (this.distance != 0 && this.scrollXPerFrame == 0) {
                return true;
            }
            return false;
        }

        public final void f(int i3) {
            this.distance = i3;
            this.scrollXPerFrame = i3 / 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e()) {
                TimelinePanelViewController timelinePanelViewController = TimelinePanelViewController.this;
                timelinePanelViewController.a(timelinePanelViewController.currentScrollX + this.distance);
                return;
            }
            int i3 = this.distance;
            if (i3 % 2 == (i3 - TimelinePanelViewController.this.currentScrollX) - this.scrollXPerFrame) {
                TimelinePanelViewController timelinePanelViewController2 = TimelinePanelViewController.this;
                timelinePanelViewController2.a(timelinePanelViewController2.currentScrollX + this.scrollXPerFrame + (this.distance % 2));
            } else {
                TimelinePanelViewController timelinePanelViewController3 = TimelinePanelViewController.this;
                timelinePanelViewController3.a(timelinePanelViewController3.currentScrollX + this.scrollXPerFrame);
            }
            if (TimelinePanelViewController.this.currentScrollX > TimelinePanelViewController.this.presetX) {
                TimelinePanelViewController timelinePanelViewController4 = TimelinePanelViewController.this;
                timelinePanelViewController4.currentScrollX = timelinePanelViewController4.presetX;
            } else if (TimelinePanelViewController.this.currentScrollX < TimelinePanelViewController.this.presetX) {
                TimelinePanelViewController.this.A(-1);
            }
        }
    }

    public TimelinePanelViewController() {
        i63.b bVar = new i63.b();
        bVar.a(this);
        this.scaleCalculator = bVar;
        this.childViewModelList = new ArrayList();
        this.presetX = -1;
        this.panelEventHandler = new PanelEventHandler();
        this.flingHelper = new FlingHelper();
        this.scrollRunnable = new ScrollRunnable();
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(int position) {
        TimelinePanel timelinePanel = this.panel;
        if (timelinePanel != null) {
            timelinePanel.removeCallbacks(this.scrollRunnable);
            if (position > 0) {
                this.scrollRunnable.f(position);
            }
            ViewCompat.postOnAnimationDelayed(timelinePanel, this.scrollRunnable, 10L);
        }
    }

    private final void c() {
        TimelinePanel timelinePanel = this.panel;
        if (timelinePanel != null) {
            timelinePanel.removeCallbacks(this.scrollRunnable);
        }
        a(this.presetX);
    }

    public final void B(boolean visible) {
        View view;
        int i3;
        TimelinePanel timelinePanel = this.panel;
        if (timelinePanel != null) {
            view = timelinePanel.F0();
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

    public final void C(long endTimeUs) {
        if (this.scaleCalculator.getEndTimeUs() == endTimeUs) {
            return;
        }
        this.scaleCalculator.r(endTimeUs);
        Iterator<T> it = this.childViewModelList.iterator();
        while (it.hasNext()) {
            ((f63.a) it.next()).o();
        }
    }

    public final void D(@Nullable MotionEvent ev5) {
        Integer num;
        if (ev5 != null) {
            num = Integer.valueOf(ev5.getActionMasked());
        } else {
            num = null;
        }
        boolean z16 = true;
        if (num != null && num.intValue() == 0) {
            this.flingHelper.g();
            this.isUserTouching = true;
            Function1<? super Boolean, Unit> function1 = this.onUserTouchChangeCb;
            if (function1 != null) {
                function1.invoke(true);
                return;
            }
            return;
        }
        if ((num == null || num.intValue() != 3) && (num == null || num.intValue() != 1)) {
            z16 = false;
        }
        if (z16) {
            this.isUserTouching = false;
            Function1<? super Boolean, Unit> function12 = this.onUserTouchChangeCb;
            if (function12 != null) {
                function12.invoke(false);
            }
        }
    }

    @Override // i63.b.c
    public void a(int x16) {
        v(x16, this);
    }

    @Override // i63.b.c
    /* renamed from: b, reason: from getter */
    public int getCurrentScrollX() {
        return this.currentScrollX;
    }

    public final void h(@NotNull f63.a<?> timelineViewController) {
        Intrinsics.checkNotNullParameter(timelineViewController, "timelineViewController");
        this.childViewModelList.add(timelineViewController);
        timelineViewController.p(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
    public final void i(@NotNull f63.a<?> controller) {
        TimelinePanel timelinePanel;
        Intrinsics.checkNotNullParameter(controller, "controller");
        ?? n3 = controller.n();
        if (n3 != 0 && (timelinePanel = this.panel) != 0) {
            timelinePanel.C0(n3);
        }
    }

    public final void j(@NotNull TimelinePanel view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.panel = view;
        view.D0(this);
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final CommonConfig getConfig() {
        return this.config;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final FlingHelper getFlingHelper() {
        return this.flingHelper;
    }

    public final int m() {
        Object obj;
        Iterator<T> it = this.childViewModelList.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                int c16 = ((f63.a) next).c();
                do {
                    Object next2 = it.next();
                    int c17 = ((f63.a) next2).c();
                    if (c16 < c17) {
                        next = next2;
                        c16 = c17;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        f63.a aVar = (f63.a) obj;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final PanelEventHandler getPanelEventHandler() {
        return this.panelEventHandler;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final i63.b getScaleCalculator() {
        return this.scaleCalculator;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getIsUserTouching() {
        return this.isUserTouching;
    }

    public final void q() {
        HashSet hashSetOf;
        hashSetOf = SetsKt__SetsKt.hashSetOf(Integer.valueOf(this.currentScrollX));
        Iterator<T> it = this.childViewModelList.iterator();
        while (it.hasNext()) {
            hashSetOf.addAll(((f63.a) it.next()).b());
        }
        Iterator<T> it5 = this.childViewModelList.iterator();
        while (it5.hasNext()) {
            ((f63.a) it5.next()).e(hashSetOf);
        }
    }

    public final void r() {
        i63.b bVar = this.scaleCalculator;
        e eVar = e.f384236a;
        bVar.s(eVar.a(this.config.getTimeBarConfig().getMaxSpace()));
        bVar.t(eVar.a(this.config.getTimeBarConfig().getMinSpace()));
        this.flingHelper.e(this.config.getScrollConfig().getFlingFactor());
        TimelinePanel timelinePanel = this.panel;
        if (timelinePanel != null) {
            timelinePanel.J0(this.config.getLayoutConfig());
        }
        Iterator<T> it = this.childViewModelList.iterator();
        while (it.hasNext()) {
            ((f63.a) it.next()).o();
        }
    }

    public final void s() {
        int m3 = m();
        Iterator<T> it = this.childViewModelList.iterator();
        while (it.hasNext()) {
            ((f63.a) it.next()).a(m3);
        }
    }

    public final void t(float scaleFactor) {
        if (this.forbiddenScale) {
            return;
        }
        this.scaleCalculator.o(scaleFactor * scaleFactor);
        Iterator<T> it = this.childViewModelList.iterator();
        while (it.hasNext()) {
            ((f63.a) it.next()).f();
        }
        this.panelEventHandler.a(new l());
    }

    public final void u(float scaleFactor) {
        if (this.forbiddenScale) {
            return;
        }
        this.scaleCalculator.p(scaleFactor);
        Iterator<T> it = this.childViewModelList.iterator();
        while (it.hasNext()) {
            ((f63.a) it.next()).f();
        }
        this.panelEventHandler.a(new l());
    }

    public final void v(int position, @Nullable Object caller) {
        boolean z16;
        if (this.currentScrollX == position) {
            return;
        }
        this.currentScrollX = position;
        q();
        List<f63.a<?>> list = this.childViewModelList;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((f63.a) next) == caller) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((f63.a) it5.next()).d(this.currentScrollX);
        }
        PanelEventHandler panelEventHandler = this.panelEventHandler;
        long f16 = this.scaleCalculator.f();
        if (caller == this) {
            z16 = false;
        }
        panelEventHandler.a(new i(f16, z16));
    }

    public final void w(@NotNull CommonConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    public final void x(boolean z16) {
        this.forbiddenScale = z16;
    }

    public final void y(long minClipDuration) {
        this.minClipDuration = minClipDuration;
    }

    public final void z(long timeUs) {
        int y16;
        int i3;
        if (this.isUserTouching || this.flingHelper.d() || (i3 = this.currentScrollX) == (y16 = this.scaleCalculator.y(timeUs))) {
            return;
        }
        if (i3 < this.presetX) {
            c();
            this.currentScrollX = this.presetX;
        }
        this.presetX = y16;
        int i16 = this.currentScrollX;
        if (i16 < y16) {
            A(y16 - i16);
        } else if (i16 > y16) {
            a(y16);
        }
    }
}
