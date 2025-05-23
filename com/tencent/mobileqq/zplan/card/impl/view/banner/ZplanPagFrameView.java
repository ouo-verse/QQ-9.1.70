package com.tencent.mobileqq.zplan.card.impl.view.banner;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 d2\u00020\u0001:\u0007efghij0B\u0011\b\u0016\u0012\u0006\u0010\\\u001a\u00020[\u00a2\u0006\u0004\b]\u0010^B\u0019\b\u0016\u0012\u0006\u0010\\\u001a\u00020[\u0012\u0006\u0010`\u001a\u00020_\u00a2\u0006\u0004\b]\u0010aB!\b\u0016\u0012\u0006\u0010\\\u001a\u00020[\u0012\u0006\u0010`\u001a\u00020_\u0012\u0006\u0010b\u001a\u00020\u0006\u00a2\u0006\u0004\b]\u0010cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u0015H\u0002J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010&\u001a\u00020\u0002J\b\u0010'\u001a\u00020\u0002H\u0014J\b\u0010(\u001a\u00020\u0002H\u0014J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010*\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010+\u001a\u00020\u0015H\u0016J\u0006\u0010,\u001a\u00020\u0006J\u000e\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-R\u0014\u00102\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001f\u00108\u001a\u000603R\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001f\u0010=\u001a\u000609R\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<R\u001b\u0010@\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00105\u001a\u0004\b>\u0010?R!\u0010D\u001a\b\u0012\u0004\u0012\u00020-0A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u00105\u001a\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u00101R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010FR\u0016\u0010H\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010GR\u0016\u0010I\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u00101R&\u0010N\u001a\u0012\u0012\u0004\u0012\u00020K0Jj\b\u0012\u0004\u0012\u00020K`L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010MR\"\u0010P\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010G\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010U\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010G\u001a\u0004\bU\u0010Q\"\u0004\bV\u0010SR\u0016\u0010W\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010 R\u0016\u0010Z\u001a\u00020X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010Y\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView;", "Landroid/widget/FrameLayout;", "", "u", "D", "E", "", "index", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$Direct;", QzoneZipCacheHelper.DIR, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "direct", "", "rate", "k", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$d;", "adapter", "y", "Landroid/view/MotionEvent;", "event", "t", "", "B", "ev", ReportConstant.COSTREPORT_PREFIX, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "j", "nextIndex", "curIndex", "i", UserInfo.SEX_FEMALE, "w", "setAdapter", com.tencent.luggage.wxa.c8.c.G, BdhLogUtil.LogTag.Tag_Conn, "setCurrentIndexOutSide", "setSkipAutoLoop", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "onTouchEvent", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "performClick", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$c;", "listener", tl.h.F, "d", "I", "TOUCH_SLOP", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$AutoLoopTask;", "e", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$AutoLoopTask;", "loopTask", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$HideViewTask;", "f", "l", "()Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$HideViewTask;", "hideViewRunnable", "r", "()I", "viewWidth", "", "p", "()Ljava/util/List;", "pageChangeListener", "currentIndex", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$d;", "Z", "shouldSkipAutoLoop", "moveToNext", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "viewPool", "G", "isAutoLoop", "()Z", "setAutoLoop", "(Z)V", "H", "isInfiniteLooper", "setInfiniteLooper", "startX", "", "J", "actionDownTime", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributes", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defRes", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "AutoLoopTask", "a", "Direct", "HideViewTask", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanPagFrameView extends FrameLayout {
    private static final int L = ViewUtils.dpToPx(20.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private d adapter;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean shouldSkipAutoLoop;

    /* renamed from: E, reason: from kotlin metadata */
    private int moveToNext;

    /* renamed from: F, reason: from kotlin metadata */
    private ArrayList<View> viewPool;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isAutoLoop;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isInfiniteLooper;

    /* renamed from: I, reason: from kotlin metadata */
    private float startX;

    /* renamed from: J, reason: from kotlin metadata */
    private long actionDownTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int TOUCH_SLOP;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy loopTask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy hideViewRunnable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy pageChangeListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int currentIndex;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\t\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$AutoLoopTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "reference", "viewZplan", "<init>", "(Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView;Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class AutoLoopTask implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZplanPagFrameView> reference;
        final /* synthetic */ ZplanPagFrameView this$0;

        public AutoLoopTask(ZplanPagFrameView zplanPagFrameView, ZplanPagFrameView viewZplan) {
            Intrinsics.checkNotNullParameter(viewZplan, "viewZplan");
            this.this$0 = zplanPagFrameView;
            this.reference = new WeakReference<>(viewZplan);
        }

        @Override // java.lang.Runnable
        public void run() {
            ZplanPagFrameView zplanPagFrameView = this.reference.get();
            if (zplanPagFrameView != null) {
                ZplanPagFrameView zplanPagFrameView2 = this.this$0;
                if (!zplanPagFrameView.shouldSkipAutoLoop) {
                    if (!zplanPagFrameView2.x()) {
                        QLog.d("Pagragment", 1, "not need handle in loop");
                        return;
                    } else {
                        ZplanPagFrameView.A(zplanPagFrameView, (zplanPagFrameView.currentIndex + 1) % zplanPagFrameView2.m(), null, 2, null);
                        zplanPagFrameView.postDelayed(zplanPagFrameView.n(), 5000L);
                        return;
                    }
                }
                QLog.d("Pagragment", 1, "run: skip autoPlay as handle action");
                zplanPagFrameView2.shouldSkipAutoLoop = false;
                zplanPagFrameView.postDelayed(zplanPagFrameView.n(), 5000L);
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$Direct;", "", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum Direct {
        LEFT,
        RIGHT
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$HideViewTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "d", "Ljava/lang/ref/WeakReference;", "getView", "()Ljava/lang/ref/WeakReference;", "a", "(Ljava/lang/ref/WeakReference;)V", "view", "<init>", "(Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class HideViewTask implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private WeakReference<View> view;

        public HideViewTask() {
        }

        public final void a(WeakReference<View> weakReference) {
            this.view = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<View> weakReference = this.view;
            QLog.d("Pagragment", 1, "hide view " + (weakReference != null ? weakReference.get() : null));
            WeakReference<View> weakReference2 = this.view;
            View view = weakReference2 != null ? weakReference2.get() : null;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\u0006H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$d;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "c", "", com.tencent.luggage.wxa.c8.c.G, "view", "", "b", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static abstract class d {
        public abstract int a();

        public abstract void b(int pos, View view);

        public abstract View c(ViewGroup parent);
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f332142a;

        static {
            int[] iArr = new int[Direct.values().length];
            try {
                iArr[Direct.RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Direct.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f332142a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanPagFrameView(Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(context, "context");
        this.TOUCH_SLOP = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AutoLoopTask>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView$loopTask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanPagFrameView.AutoLoopTask invoke() {
                ZplanPagFrameView zplanPagFrameView = ZplanPagFrameView.this;
                return new ZplanPagFrameView.AutoLoopTask(zplanPagFrameView, zplanPagFrameView);
            }
        });
        this.loopTask = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<HideViewTask>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView$hideViewRunnable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanPagFrameView.HideViewTask invoke() {
                return new ZplanPagFrameView.HideViewTask();
            }
        });
        this.hideViewRunnable = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView$viewWidth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ZplanPagFrameView.this.getMeasuredWidth());
            }
        });
        this.viewWidth = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(ZplanPagFrameView$pageChangeListener$2.INSTANCE);
        this.pageChangeListener = lazy4;
        this.currentIndex = -1;
        this.moveToNext = -1;
        this.viewPool = new ArrayList<>();
        this.isAutoLoop = true;
        this.isInfiniteLooper = true;
        this.startX = -1.0f;
    }

    private final boolean B(MotionEvent event) {
        float x16 = event.getX() - this.startX;
        if (!x()) {
            QLog.d("Pagragment", 1, "not need handle");
            return false;
        }
        if (Math.abs(x16) >= this.TOUCH_SLOP) {
            return true;
        }
        QLog.d("Pagragment", 1, "handlerMoveAction: skip handle as too close ");
        return false;
    }

    private final void D() {
        if (this.isAutoLoop) {
            removeCallbacks(n());
            postDelayed(n(), 5000L);
        }
    }

    private final void E() {
        if (this.isAutoLoop) {
            removeCallbacks(n());
        }
    }

    private final void F(final int index) {
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.h
            @Override // java.lang.Runnable
            public final void run() {
                ZplanPagFrameView.G(ZplanPagFrameView.this, index);
            }
        }, 60L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(ZplanPagFrameView this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.viewPool.get(i3).bringToFront();
    }

    private final void i(int nextIndex, int curIndex) {
        int m3 = m();
        for (int i3 = 0; i3 < m3; i3++) {
            if (i3 != nextIndex && i3 != curIndex) {
                this.viewPool.get(i3).setVisibility(8);
            } else {
                d dVar = this.adapter;
                if (dVar != null) {
                    View view = this.viewPool.get(i3);
                    Intrinsics.checkNotNullExpressionValue(view, "viewPool[i]");
                    dVar.b(i3, view);
                }
                this.viewPool.get(i3).setVisibility(0);
            }
        }
    }

    private final boolean j(Direct dir, int index) {
        if (this.isInfiniteLooper) {
            return true;
        }
        if (dir == Direct.RIGHT && index == 0) {
            return false;
        }
        return (dir == Direct.LEFT && index == m() - 1) ? false : true;
    }

    private final HideViewTask l() {
        return (HideViewTask) this.hideViewRunnable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AutoLoopTask n() {
        return (AutoLoopTask) this.loopTask.getValue();
    }

    private final int o(Direct dir) {
        if (e.f332142a[dir.ordinal()] == 1) {
            return ((this.currentIndex + m()) - 1) % m();
        }
        return (this.currentIndex + 1) % m();
    }

    private final List<c> p() {
        return (List) this.pageChangeListener.getValue();
    }

    private final int q(Direct dir) {
        if (e.f332142a[dir.ordinal()] == 2) {
            return ((this.currentIndex + m()) - 1) % m();
        }
        return (this.currentIndex + 1) % m();
    }

    private final int r() {
        return ((Number) this.viewWidth.getValue()).intValue();
    }

    private final void s(MotionEvent ev5) {
        Direct direct;
        float coerceAtMost;
        float x16 = ev5.getX() - this.startX;
        if (x16 < 0.0f) {
            direct = Direct.LEFT;
        } else {
            direct = Direct.RIGHT;
        }
        Direct direct2 = direct;
        float abs = Math.abs(x16) / r();
        this.moveToNext = -1;
        if (!x()) {
            QLog.d("Pagragment", 1, "not need handle");
            return;
        }
        this.shouldSkipAutoLoop = true;
        QLog.d("Pagragment", 1, "handle Up Action  " + x16 + " ");
        removeCallbacks(l());
        if (j(direct2, this.currentIndex)) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(1.0f, abs);
            double d16 = coerceAtMost * 0.5d;
            float f16 = (float) (0.5d + d16);
            float f17 = (float) d16;
            if (Math.abs(x16) < this.TOUCH_SLOP) {
                int q16 = q(direct2);
                i(this.currentIndex, q16);
                KeyEvent.Callback callback = this.viewPool.get(this.currentIndex);
                Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.IPagAnimListener");
                ((b) callback).setPagProgress(direct2, 0.5f, 0.5f, false);
                KeyEvent.Callback callback2 = this.viewPool.get(q16);
                Intrinsics.checkNotNull(callback2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.IPagAnimListener");
                b.a.a((b) callback2, direct2, 1.0f, f16, false, 8, null);
                l().a(new WeakReference<>(this.viewPool.get(q16)));
                postDelayed(l(), 1500L);
                F(this.currentIndex);
                return;
            }
            int o16 = o(direct2);
            if (w()) {
                z(o16, direct2);
                return;
            }
            i(o16, this.currentIndex);
            KeyEvent.Callback callback3 = this.viewPool.get(o16);
            Intrinsics.checkNotNull(callback3, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.IPagAnimListener");
            ((b) callback3).a(direct2, 0.5f, f17);
            KeyEvent.Callback callback4 = this.viewPool.get(this.currentIndex);
            Intrinsics.checkNotNull(callback4, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.IPagAnimListener");
            ((b) callback4).a(direct2, 1.0f, f16);
            l().a(new WeakReference<>(this.viewPool.get(this.currentIndex)));
            postDelayed(l(), 1500L);
            F(o16);
            Iterator<T> it = p().iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(o16, this.viewPool.get(o16));
            }
            this.currentIndex = o16;
            return;
        }
        QLog.d("Pagragment", 1, "can`t scroll action up " + direct2 + " " + this.currentIndex);
        int q17 = q(direct2);
        KeyEvent.Callback callback5 = this.viewPool.get(this.currentIndex);
        Intrinsics.checkNotNull(callback5, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.IPagAnimListener");
        ((b) callback5).setPagProgress(direct2, 0.5f, 0.5f, false);
        l().a(new WeakReference<>(this.viewPool.get(q17)));
        postDelayed(l(), 1500L);
        F(this.currentIndex);
    }

    private final void t(MotionEvent event) {
        Direct direct;
        if (B(event)) {
            float x16 = event.getX() - this.startX;
            this.shouldSkipAutoLoop = true;
            if (w()) {
                QLog.d("Pagragment", 1, "fling ==>  ");
                return;
            }
            if (x16 < 0.0f) {
                direct = Direct.LEFT;
            } else {
                direct = Direct.RIGHT;
            }
            float abs = Math.abs(x16) / r();
            if (!j(direct, this.currentIndex)) {
                QLog.d("Pagragment", 1, "can`t scroll " + direct + " " + this.currentIndex);
                return;
            }
            k(direct, abs);
            QLog.d("Pagragment", 1, "handleMove: width : " + r() + " " + abs + "   : " + direct + " " + x16);
        }
    }

    private final void u() {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.g
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean v3;
                v3 = ZplanPagFrameView.v(ZplanPagFrameView.this);
                return v3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v(ZplanPagFrameView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("Pagragment", 1, "init data before");
        int m3 = this$0.m();
        for (int i3 = 0; i3 < m3; i3++) {
            d dVar = this$0.adapter;
            if (dVar != null) {
                View view = this$0.viewPool.get(i3);
                Intrinsics.checkNotNullExpressionValue(view, "viewPool[i]");
                dVar.b(i3, view);
            }
        }
        int i16 = this$0.currentIndex;
        if (i16 == 0) {
            this$0.C(i16);
        }
        return false;
    }

    private final boolean w() {
        long currentTimeMillis = System.currentTimeMillis() - this.actionDownTime;
        QLog.d("Pagragment", 1, "isFling: " + currentTimeMillis);
        return currentTimeMillis < 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean x() {
        return m() > 1;
    }

    private final void y(d adapter) {
        this.adapter = adapter;
        this.currentIndex = -1;
        removeAllViews();
        this.viewPool.clear();
        int m3 = m();
        for (int i3 = 0; i3 < m3; i3++) {
            View c16 = adapter.c(this);
            addView(c16);
            this.viewPool.add(c16);
        }
        Iterator<T> it = p().iterator();
        while (it.hasNext()) {
            ((c) it.next()).b(m(), 0);
        }
        A(this, 0, null, 2, null);
    }

    private final void z(int index, Direct dir) {
        if (index >= 0 && index < m()) {
            int i3 = this.currentIndex;
            if (i3 == index) {
                QLog.d("Pagragment", 1, "skip set " + index);
                return;
            }
            if (dir == null) {
                if (i3 >= index && (index != 0 || i3 != m() - 1)) {
                    dir = Direct.RIGHT;
                } else {
                    dir = Direct.LEFT;
                }
            }
            QLog.d("Pagragment", 1, "setCurrentItem: direct " + dir + " " + this.currentIndex + ProgressTracer.SEPARATOR + index);
            if (this.adapter == null) {
                return;
            }
            int i16 = this.currentIndex;
            if (i16 == -1) {
                i16 = (index + 1) % m();
            }
            removeCallbacks(l());
            i(index, i16);
            if (this.currentIndex == -1) {
                KeyEvent.Callback callback = this.viewPool.get(index);
                Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.IPagAnimListener");
                ((b) callback).a(dir, 0.5f, 0.99f);
            } else {
                KeyEvent.Callback callback2 = this.viewPool.get(index);
                Intrinsics.checkNotNull(callback2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.IPagAnimListener");
                ((b) callback2).a(dir, 0.5f, 0.0f);
            }
            F(index);
            if (i16 != index && this.currentIndex != -1) {
                KeyEvent.Callback callback3 = this.viewPool.get(i16);
                Intrinsics.checkNotNull(callback3, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.IPagAnimListener");
                ((b) callback3).a(dir, 1.0f, 0.5f);
                l().a(new WeakReference<>(this.viewPool.get(i16)));
                postDelayed(l(), 1500L);
            }
            Iterator<T> it = p().iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(index, this.viewPool.get(index));
            }
            this.currentIndex = index;
            this.moveToNext = -1;
            return;
        }
        QLog.e("Pagragment", 1, "error happen, as index is invalid " + index + "  " + m());
    }

    public final void C(int pos) {
        if (this.currentIndex >= 0 && m() >= 1) {
            int i3 = this.currentIndex;
            if (pos != i3) {
                QLog.e("Pagragment", 1, " pos is " + pos + " but currentIndex " + i3);
                return;
            }
            QLog.d("Pagragment", 1, "show current Pag Anim " + i3);
            KeyEvent.Callback callback = this.viewPool.get(this.currentIndex);
            Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView.IPagAnimListener");
            ((b) callback).a(Direct.RIGHT, 0.5f, 0.99f);
            return;
        }
        QLog.e("Pagragment", 1, " invalid params " + this.currentIndex + " , " + m());
    }

    public final void h(c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        p().add(listener);
    }

    public final int m() {
        d dVar = this.adapter;
        if (dVar != null) {
            return dVar.a();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        D();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        E();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
    
        if (r0 != 3) goto L13;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int action = ev5.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (B(ev5)) {
                        return true;
                    }
                }
                QLog.d("Pagragment", 1, "dispatchTouchEvent: " + ev5.getAction());
                return super.onInterceptTouchEvent(ev5);
            }
            return false;
        }
        QLog.d("Pagragment", 1, "onTouchEvent: down " + ev5.getX() + APLogFileUtil.SEPARATOR_LOG + ev5.getXPrecision());
        this.startX = ev5.getX();
        this.shouldSkipAutoLoop = true;
        this.actionDownTime = System.currentTimeMillis();
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        QLog.d("Pagragment", 1, "onTouchEvent: " + event.getAction());
        int action = event.getAction();
        if (action == 1) {
            s(event);
            performClick();
            return true;
        }
        if (action != 2) {
            if (action == 3) {
                s(event);
                QLog.d("Pagragment", 1, "onTouchEvent: cancel");
            }
            return super.onTouchEvent(event);
        }
        t(event);
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public final void setAdapter(d adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        y(adapter);
        QLog.d("Pagragment", 1, "setAdapter\uff1a " + m());
        D();
        u();
        requestLayout();
    }

    public final void setAutoLoop(boolean z16) {
        this.isAutoLoop = z16;
    }

    public final void setInfiniteLooper(boolean z16) {
        this.isInfiniteLooper = z16;
    }

    public final void setCurrentIndexOutSide(int index) {
        this.shouldSkipAutoLoop = true;
        A(this, index, null, 2, null);
    }

    public final void setSkipAutoLoop() {
        this.shouldSkipAutoLoop = true;
    }

    private final void k(Direct direct, float rate) {
        float coerceAtMost;
        int o16 = o(direct);
        if (this.moveToNext != o16) {
            i(o16, this.currentIndex);
        }
        this.moveToNext = o16;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(1.0f, rate);
        double d16 = coerceAtMost * 0.5d;
        float f16 = (float) (0.5d + d16);
        float f17 = (float) d16;
        KeyEvent.Callback callback = this.viewPool.get(o16);
        b bVar = callback instanceof b ? (b) callback : null;
        if (bVar != null) {
            b.a.a(bVar, direct, 0.5f, f17, false, 8, null);
        }
        KeyEvent.Callback callback2 = this.viewPool.get(this.currentIndex);
        b bVar2 = callback2 instanceof b ? (b) callback2 : null;
        if (bVar2 != null) {
            b.a.a(bVar2, direct, 1.0f, f16, false, 8, null);
        }
        F(o16);
        Iterator<T> it = p().iterator();
        while (it.hasNext()) {
            ((c) it.next()).c(this.currentIndex, rate);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J*\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$b;", "", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$Direct;", "direct", "", "duration", "progress", "", "a", "", "hideDownloadBut", "setPagProgress", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void a(Direct direct, float duration, float progress);

        void setPagProgress(Direct direct, float duration, float progress, boolean hideDownloadBut);

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public static final class a {
            public static /* synthetic */ void a(b bVar, Direct direct, float f16, float f17, boolean z16, int i3, Object obj) {
                if (obj == null) {
                    if ((i3 & 8) != 0) {
                        z16 = true;
                    }
                    bVar.setPagProgress(direct, f16, f17, z16);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPagProgress");
            }
        }
    }

    static /* synthetic */ void A(ZplanPagFrameView zplanPagFrameView, int i3, Direct direct, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            direct = null;
        }
        zplanPagFrameView.z(i3, direct);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanPagFrameView(Context context, AttributeSet attributes) {
        super(context, attributes);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.TOUCH_SLOP = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AutoLoopTask>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView$loopTask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanPagFrameView.AutoLoopTask invoke() {
                ZplanPagFrameView zplanPagFrameView = ZplanPagFrameView.this;
                return new ZplanPagFrameView.AutoLoopTask(zplanPagFrameView, zplanPagFrameView);
            }
        });
        this.loopTask = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<HideViewTask>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView$hideViewRunnable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanPagFrameView.HideViewTask invoke() {
                return new ZplanPagFrameView.HideViewTask();
            }
        });
        this.hideViewRunnable = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView$viewWidth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ZplanPagFrameView.this.getMeasuredWidth());
            }
        });
        this.viewWidth = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(ZplanPagFrameView$pageChangeListener$2.INSTANCE);
        this.pageChangeListener = lazy4;
        this.currentIndex = -1;
        this.moveToNext = -1;
        this.viewPool = new ArrayList<>();
        this.isAutoLoop = true;
        this.isInfiniteLooper = true;
        this.startX = -1.0f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanPagFrameView(Context context, AttributeSet attributes, int i3) {
        super(context, attributes, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.TOUCH_SLOP = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AutoLoopTask>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView$loopTask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanPagFrameView.AutoLoopTask invoke() {
                ZplanPagFrameView zplanPagFrameView = ZplanPagFrameView.this;
                return new ZplanPagFrameView.AutoLoopTask(zplanPagFrameView, zplanPagFrameView);
            }
        });
        this.loopTask = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<HideViewTask>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView$hideViewRunnable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanPagFrameView.HideViewTask invoke() {
                return new ZplanPagFrameView.HideViewTask();
            }
        });
        this.hideViewRunnable = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagFrameView$viewWidth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ZplanPagFrameView.this.getMeasuredWidth());
            }
        });
        this.viewWidth = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(ZplanPagFrameView$pageChangeListener$2.INSTANCE);
        this.pageChangeListener = lazy4;
        this.currentIndex = -1;
        this.moveToNext = -1;
        this.viewPool = new ArrayList<>();
        this.isAutoLoop = true;
        this.isInfiniteLooper = true;
        this.startX = -1.0f;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagFrameView$c;", "", "", "count", "selectPos", "", "b", "position", "", "positionOffset", "c", "Landroid/view/View;", "view", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface c {
        void a(int position, View view);

        void b(int count, int selectPos);

        void c(int position, float positionOffset);

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public static final class a {
            public static void a(c cVar, int i3, int i16) {
            }

            public static void b(c cVar, int i3, float f16) {
            }
        }
    }
}
