package com.tencent.mobileqq.zplan.smallhome;

import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.utils.n;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanCloseLoadingViewEvent;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanUEScaleEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import k74.i;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0005J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\u000eH\u0016J\u0006\u0010\u0012\u001a\u00020\u0011R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/ZPlanUEActivityHelper;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "showing", "", "r", "t", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "k", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "", "j", "Lmqq/util/WeakReference;", "d", "Lmqq/util/WeakReference;", "ueActivityWeakReference", "e", "Ljava/lang/String;", "nativeIdCache", "<init>", "()V", "f", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanUEActivityHelper implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static final Lazy<ZPlanUEActivityHelper> f335633h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WeakReference<FragmentActivity> ueActivityWeakReference;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile String nativeIdCache = "";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/ZPlanUEActivityHelper$a;", "", "Lcom/tencent/mobileqq/zplan/smallhome/ZPlanUEActivityHelper;", "INSTANCE$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zplan/smallhome/ZPlanUEActivityHelper;", "INSTANCE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.smallhome.ZPlanUEActivityHelper$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanUEActivityHelper a() {
            return (ZPlanUEActivityHelper) ZPlanUEActivityHelper.f335633h.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<ZPlanUEActivityHelper> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanUEActivityHelper>() { // from class: com.tencent.mobileqq.zplan.smallhome.ZPlanUEActivityHelper$Companion$INSTANCE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanUEActivityHelper invoke() {
                return new ZPlanUEActivityHelper();
            }
        });
        f335633h = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(FragmentActivity fragmentActivity) {
        fragmentActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(SimpleBaseEvent simpleBaseEvent) {
        i.Companion companion = k74.i.INSTANCE;
        ZPlanUEScaleEvent zPlanUEScaleEvent = (ZPlanUEScaleEvent) simpleBaseEvent;
        ((ic3.a) companion.a(ic3.a.class)).modExit(zPlanUEScaleEvent.getMapId());
        ((com.tencent.mobileqq.zootopia.ipc.d) companion.a(com.tencent.mobileqq.zootopia.ipc.d.class)).onModExit(zPlanUEScaleEvent.getMapId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n() {
        ((ok3.b) k74.i.INSTANCE.a(ok3.b.class)).releaseKeeping();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ZPlanUEActivityHelper this$0, SimpleBaseEvent simpleBaseEvent, FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String j3 = this$0.j();
        if ((j3.length() > 0) && Intrinsics.areEqual(j3, ((ZPlanUEScaleEvent) simpleBaseEvent).getNativeId())) {
            fragmentActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p() {
        ((ok3.b) k74.i.INSTANCE.a(ok3.b.class)).releaseKeeping();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q() {
        ((ok3.b) k74.i.INSTANCE.a(ok3.b.class)).releaseKeeping();
    }

    private final void r(final boolean showing) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.smallhome.g
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanUEActivityHelper.s(showing);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(boolean z16) {
        ((com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class)).setIsFloat(z16);
    }

    private final void t(final boolean showing) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.smallhome.h
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanUEActivityHelper.u(showing);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(boolean z16) {
        ((com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class)).setIsShowUE(z16);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ZPlanUEScaleEvent.class);
        arrayList.add(ZPlanCloseLoadingViewEvent.class);
        return arrayList;
    }

    public final String j() {
        String str = this.nativeIdCache;
        if (str == null || str.length() == 0) {
            WeakReference<FragmentActivity> weakReference = this.ueActivityWeakReference;
            this.nativeIdCache = String.valueOf(weakReference != null ? weakReference.get() : null);
        }
        QLog.d("ZPlanUEActivityHelper", 1, "getCurrentNativeId, nativeId: " + this.nativeIdCache);
        return this.nativeIdCache;
    }

    public final void k(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.d("ZPlanUEActivityHelper", 1, "onCreate");
        t(true);
        r(false);
        SimpleEventBus.getInstance().registerReceiver(this);
        this.ueActivityWeakReference = new WeakReference<>(activity);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent event) {
        if (event instanceof ZPlanUEScaleEvent) {
            WeakReference<FragmentActivity> weakReference = this.ueActivityWeakReference;
            final FragmentActivity fragmentActivity = weakReference != null ? weakReference.get() : null;
            ZPlanUEScaleEvent zPlanUEScaleEvent = (ZPlanUEScaleEvent) event;
            QLog.d("ZPlanUEActivityHelper", 1, "onReceiveEvent, event: " + zPlanUEScaleEvent.getMapId() + ", " + zPlanUEScaleEvent.getType() + ", " + zPlanUEScaleEvent.getNativeId());
            int type = zPlanUEScaleEvent.getType();
            if (type != 0) {
                if (type == 1) {
                    if (fragmentActivity != null) {
                        fragmentActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.smallhome.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                ZPlanUEActivityHelper.o(ZPlanUEActivityHelper.this, event, fragmentActivity);
                            }
                        });
                    }
                    n.Companion.c(n.INSTANCE, "UEActivity", false, 7, 2, null);
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.smallhome.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            ZPlanUEActivityHelper.p();
                        }
                    }, 16, null, true);
                    return;
                }
                if (type != 2 && type != 4) {
                    return;
                }
            }
            if (zPlanUEScaleEvent.getType() != 4) {
                r(false);
            }
            i.f335703a.d(zPlanUEScaleEvent.getMapId());
            if (fragmentActivity != null) {
                fragmentActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.smallhome.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanUEActivityHelper.l(FragmentActivity.this);
                    }
                });
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.smallhome.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanUEActivityHelper.m(SimpleBaseEvent.this);
                    }
                }, 16, null, true);
                n.Companion.c(n.INSTANCE, "UEActivity", false, 7, 2, null);
            }
            SimpleEventBus.getInstance().unRegisterReceiver(this);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.smallhome.c
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanUEActivityHelper.n();
                }
            }, 16, null, true);
            return;
        }
        if (event instanceof ZPlanCloseLoadingViewEvent) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.smallhome.f
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanUEActivityHelper.q();
                }
            }, 16, null, true);
        }
    }

    public final void onDestroy() {
        QLog.d("ZPlanUEActivityHelper", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.nativeIdCache = "";
        this.ueActivityWeakReference = null;
        t(false);
    }
}
