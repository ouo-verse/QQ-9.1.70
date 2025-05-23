package com.tencent.mobileqq.zplan.bubble;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.be;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.bubble.ZPlanAvatarBubbleController;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import yi3.ZPlanInformationBubbleInfo;
import yi3.ZPlanMiniHomeGuidanceBubbleInfo;
import yi3.ZPlanOperateBubbleInfo;
import yi3.ZPlanStatusBubbleInfo;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\n\u0018\u0000 42\u00020\u0001:\u0001$B)\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010'\u001a\u00020\u000f\u0012\u0006\u0010(\u001a\u00020\u000f\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b2\u00103J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f*\u00020\bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0012\u0010!\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010&R\u0014\u0010(\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010&R\u0016\u0010*\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010)R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00150+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010,R\u0016\u0010/\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/zplan/bubble/ZPlanAvatarBubbleController;", "Lcom/tencent/mobileqq/zplan/bubble/b;", "", "uin", "", "source", "", "r", "Lyi3/e;", "bubbleInfo", ReportConstant.COSTREPORT_PREFIX, "u", "Lcom/tencent/mobileqq/zplan/bubble/c;", "o", "text", "", "showExpire", "f", "c", "g", "e", "Lcom/tencent/mobileqq/zplan/bubble/l;", "controller", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "y", "d", "Lcom/tencent/mobileqq/zplan/bubble/a;", "callback", "b", "Landroid/view/MotionEvent;", "event", "onTouch", "Landroid/widget/FrameLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "a", "Landroid/widget/FrameLayout;", "I", "parentWidthPx", "parentHeightPx", "Ljava/lang/String;", "externalEntrance", "", "Ljava/util/Map;", "bubbleViewControllers", "Z", "isTouched", "Lcom/tencent/mobileqq/zplan/bubble/a;", "mNotShowCallback", "<init>", "(Landroid/widget/FrameLayout;IILjava/lang/String;)V", tl.h.F, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAvatarBubbleController implements com.tencent.mobileqq.zplan.bubble.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final FrameLayout parent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int parentWidthPx;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int parentHeightPx;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String externalEntrance;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, l> bubbleViewControllers;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isTouched;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private a mNotShowCallback;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R%\u0010\f\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zplan/bubble/ZPlanAvatarBubbleController$b", "Lnk3/e;", "Lyi3/e;", "bubbleInfo", "", "a", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/bubble/ZPlanAvatarBubbleController;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "getThisRef", "()Lmqq/util/WeakReference;", "thisRef", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements nk3.e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZPlanAvatarBubbleController> thisRef;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f331989b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f331990c;

        b(ZPlanAvatarBubbleController zPlanAvatarBubbleController, long j3, String str) {
            this.f331989b = j3;
            this.f331990c = str;
            this.thisRef = new WeakReference<>(zPlanAvatarBubbleController);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ZPlanAvatarBubbleController zPlanAvatarBubbleController = this$0.thisRef.get();
            if (zPlanAvatarBubbleController != null) {
                zPlanAvatarBubbleController.s(new ZPlanMiniHomeGuidanceBubbleInfo(0, 1, null));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(b this$0) {
            a aVar;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ZPlanAvatarBubbleController zPlanAvatarBubbleController = this$0.thisRef.get();
            if (zPlanAvatarBubbleController == null || (aVar = zPlanAvatarBubbleController.mNotShowCallback) == null) {
                return;
            }
            aVar.showOnlineStatusBubble();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(b this$0, yi3.e eVar) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ZPlanAvatarBubbleController zPlanAvatarBubbleController = this$0.thisRef.get();
            if (zPlanAvatarBubbleController != null) {
                zPlanAvatarBubbleController.s(eVar);
            }
        }

        @Override // nk3.e
        public void a(final yi3.e bubbleInfo) {
            if (bubbleInfo == null) {
                QLog.i("ZPlanBubbleController", 1, "bubbleInfo == null");
                if (ZPlanMiniHomeGuidanceBubbleViewController.INSTANCE.a(this.f331989b, this.f331990c)) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.bubble.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            ZPlanAvatarBubbleController.b.e(ZPlanAvatarBubbleController.b.this);
                        }
                    });
                    return;
                } else {
                    if (be.k()) {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.bubble.h
                            @Override // java.lang.Runnable
                            public final void run() {
                                ZPlanAvatarBubbleController.b.f(ZPlanAvatarBubbleController.b.this);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            QLog.i("ZPlanBubbleController", 1, bubbleInfo.toString());
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.bubble.i
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanAvatarBubbleController.b.g(ZPlanAvatarBubbleController.b.this, bubbleInfo);
                }
            });
        }
    }

    public ZPlanAvatarBubbleController(FrameLayout parent, int i3, int i16, String str) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.parent = parent;
        this.parentWidthPx = i3;
        this.parentHeightPx = i16;
        this.externalEntrance = str;
        this.bubbleViewControllers = new LinkedHashMap();
    }

    private final c<?> o(yi3.e eVar) {
        int i3 = this.parent.getResources().getDisplayMetrics().widthPixels;
        Integer e16 = ni3.a.f420201a.e();
        if (e16 == null) {
            QLog.e("ZPlanBubbleController", 1, "heightPx \u975e\u53ef\u671f\u7c7b\u578b");
            return null;
        }
        if (eVar instanceof ZPlanOperateBubbleInfo) {
            return new p(this.parent, i3, e16.intValue(), (ZPlanOperateBubbleInfo) eVar);
        }
        if (eVar instanceof ZPlanStatusBubbleInfo) {
            return new q(this.parent, i3, e16.intValue(), (ZPlanStatusBubbleInfo) eVar);
        }
        if (eVar instanceof ZPlanInformationBubbleInfo) {
            return new m(this.parent, i3, e16.intValue(), (ZPlanInformationBubbleInfo) eVar);
        }
        if (eVar instanceof ZPlanMiniHomeGuidanceBubbleInfo) {
            return new ZPlanMiniHomeGuidanceBubbleViewController(this.parent, i3, e16.intValue(), (ZPlanMiniHomeGuidanceBubbleInfo) eVar);
        }
        QLog.e("ZPlanBubbleController", 1, "bubbleInfo \u975e\u53ef\u671f\u7c7b\u578b");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ZPlanAvatarBubbleController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l lVar = this$0.bubbleViewControllers.get(-1);
        if (lVar != null) {
            lVar.n();
        }
    }

    private final void r(long uin, String source) {
        com.tencent.mobileqq.zplan.servlet.h.f335407a.e(uin, new b(this, uin, source));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(yi3.e bubbleInfo) {
        Map<Integer, l> map = this.bubbleViewControllers;
        Integer valueOf = Integer.valueOf(bubbleInfo.getType());
        l lVar = map.get(valueOf);
        if (lVar == null) {
            c<?> o16 = o(bubbleInfo);
            if (o16 == null) {
                return;
            }
            Context context = this.parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            l lVar2 = new l(context, o16, this.externalEntrance);
            lVar2.v(new Function1<l, Unit>() { // from class: com.tencent.mobileqq.zplan.bubble.ZPlanAvatarBubbleController$show$controller$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(l lVar3) {
                    invoke2(lVar3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(l it) {
                    Map map2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    map2 = ZPlanAvatarBubbleController.this.bubbleViewControllers;
                    map2.remove(Integer.valueOf(it.k().getType()));
                    ZPlanAvatarBubbleController.this.u();
                }
            });
            map.put(valueOf, lVar2);
            lVar = lVar2;
        }
        l lVar3 = lVar;
        lVar3.m();
        lVar3.u(bubbleInfo);
        u();
        a aVar = this.mNotShowCallback;
        if (aVar != null) {
            aVar.hiddeOnlineStatusBubble();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ZPlanAvatarBubbleController this$0, int i3, String text) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(text, "$text");
        this$0.s(new ZPlanInformationBubbleInfo(-1L, i3, text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        Object obj;
        Iterator<T> it = this.bubbleViewControllers.entrySet().iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int intValue = ((Number) ((Map.Entry) next).getKey()).intValue();
                do {
                    Object next2 = it.next();
                    int intValue2 = ((Number) ((Map.Entry) next2).getKey()).intValue();
                    if (intValue > intValue2) {
                        next = next2;
                        intValue = intValue2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            return;
        }
        ((l) entry.getValue()).w();
        for (Map.Entry<Integer, l> entry2 : this.bubbleViewControllers.entrySet()) {
            int intValue3 = entry2.getKey().intValue();
            l value = entry2.getValue();
            if (intValue3 != ((Number) entry.getKey()).intValue()) {
                value.m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(ZPlanAvatarBubbleController this$0, FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<l> it = this$0.bubbleViewControllers.values().iterator();
        while (it.hasNext()) {
            it.next().x(frameLayout);
        }
    }

    @Override // com.tencent.mobileqq.zplan.bubble.b
    public void b(a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mNotShowCallback = callback;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.b
    public void c() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.bubble.f
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarBubbleController.p(ZPlanAvatarBubbleController.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.bubble.b
    public boolean d(int x16, int y16) {
        Collection<l> values = this.bubbleViewControllers.values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = values.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            l lVar = (l) next;
            if (lVar.s() && lVar.l().contains(x16, y16)) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                if (q((l) it5.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.b
    public void e() {
        Iterator<Map.Entry<Integer, l>> it = this.bubbleViewControllers.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().n();
        }
    }

    @Override // com.tencent.mobileqq.zplan.bubble.b
    public void f(final String text, final int showExpire) {
        Intrinsics.checkNotNullParameter(text, "text");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.bubble.e
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarBubbleController.t(ZPlanAvatarBubbleController.this, showExpire, text);
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.bubble.b
    public void g(long uin) {
        if (ZPlanFeatureSwitch.f369852a.k()) {
            r(uin, this.externalEntrance);
        }
    }

    public final boolean q(l controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        controller.t();
        return true;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.b
    public void a(final FrameLayout parent) {
        if (parent == null) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.bubble.d
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarBubbleController.v(ZPlanAvatarBubbleController.this, parent);
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.bubble.b
    public boolean onTouch(MotionEvent event) {
        boolean z16;
        if (event == null) {
            return false;
        }
        Collection<l> values = this.bubbleViewControllers.values();
        if (!(values instanceof Collection) || !values.isEmpty()) {
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                if (((l) it.next()).l().contains((int) event.getX(), (int) event.getY())) {
                    z16 = false;
                    break;
                }
            }
        }
        z16 = true;
        if (z16) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            this.isTouched = true;
            return false;
        }
        if (action != 1) {
            if (action != 3) {
                return false;
            }
            this.isTouched = false;
            return false;
        }
        if (!this.isTouched) {
            return false;
        }
        this.isTouched = false;
        return d((int) event.getX(), (int) event.getY());
    }
}
