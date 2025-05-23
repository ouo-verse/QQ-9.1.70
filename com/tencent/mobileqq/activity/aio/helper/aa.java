package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.input.edit.a;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.event.QFSClearTroopRedDotEvent;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\b*\u0001(\b\u0007\u0018\u0000 -2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u001c\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a0\u0019j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a`\u001bH\u0016R\u0016\u0010\u001f\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/helper/aa;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mobileqq/qcircle/api/event/QFSClearTroopRedDotEvent;", "event", "", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "o", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Ljava/lang/String;", "mTroopUin", "Lcom/tencent/aio/api/runtime/a;", "e", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "", "f", "Z", "mInited", "com/tencent/mobileqq/activity/aio/helper/aa$b", "Lcom/tencent/mobileqq/activity/aio/helper/aa$b;", "mAction", "<init>", "()V", "i", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class aa implements com.tencent.aio.main.businesshelper.h, SimpleEventReceiver<SimpleBaseEvent>, com.tencent.mvi.base.route.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String mTroopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mInited;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/activity/aio/helper/aa$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof AIOMsgListEvent.MsgCountChange) {
                aa.this.j();
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    private final void h(final QFSClearTroopRedDotEvent event) {
        final a.C7263a c7263a;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        if (!Intrinsics.areEqual(aVar.g().r().c().j(), event.getTroopId())) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar2 = null;
        }
        com.tencent.mvi.base.route.k k3 = aVar2.e().k(AIOMsgListEvent.GetAioDisplayList.f188297d);
        if (k3 instanceof a.C7263a) {
            c7263a = (a.C7263a) k3;
        } else {
            c7263a = null;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.x
            @Override // java.lang.Runnable
            public final void run() {
                aa.i(a.C7263a.this, event);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(a.C7263a c7263a, QFSClearTroopRedDotEvent event) {
        Intrinsics.checkNotNullParameter(event, "$event");
        if (c7263a != null && c7263a.a() != null) {
            AIOTroopQcircleRedDotManager.u().p(event.getTroopId(), event.getSenderUin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        final a.C7263a c7263a;
        if (!this.mInited) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.k k3 = aVar.e().k(AIOMsgListEvent.GetAioDisplayList.f188297d);
        if (k3 instanceof a.C7263a) {
            c7263a = (a.C7263a) k3;
        } else {
            c7263a = null;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.z
            @Override // java.lang.Runnable
            public final void run() {
                aa.k(a.C7263a.this, this);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(a.C7263a c7263a, aa this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (c7263a != null && AIOTroopQcircleRedDotManager.v()) {
            AIOTroopQcircleRedDotManager u16 = AIOTroopQcircleRedDotManager.u();
            com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            u16.s(aVar.g().r().c().j(), c7263a.a());
        }
    }

    private final void m() {
        final a.C7263a c7263a;
        Integer num;
        Map<String, String> a16;
        this.mInited = true;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.k k3 = aVar.e().k(AIOMsgListEvent.GetAioDisplayList.f188297d);
        if (k3 instanceof a.C7263a) {
            c7263a = (a.C7263a) k3;
        } else {
            c7263a = null;
        }
        if (c7263a != null && (a16 = c7263a.a()) != null) {
            num = Integer.valueOf(a16.size());
        } else {
            num = null;
        }
        QLog.i("QCircleTroopRedDotHelper", 1, "onLifeCycleDelayLoad " + num);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.y
            @Override // java.lang.Runnable
            public final void run() {
                aa.n(a.C7263a.this, this);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(a.C7263a c7263a, aa this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (c7263a != null && c7263a.a() != null && AIOTroopQcircleRedDotManager.v()) {
            AIOTroopQcircleRedDotManager u16 = AIOTroopQcircleRedDotManager.u();
            com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            u16.q(aVar.g().r().c().j(), c7263a.a());
        }
    }

    private final void o() {
        this.mInited = false;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().i(this, this.mAction);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.w
            @Override // java.lang.Runnable
            public final void run() {
                aa.p(aa.this);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(aa this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AIOTroopQcircleRedDotManager u16 = AIOTroopQcircleRedDotManager.u();
        String str = this$0.mTroopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            str = null;
        }
        u16.o(str);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSClearTroopRedDotEvent.class);
        return arrayList;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.V0;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MsgCountChange");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "QCircleTroopRedDotHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{4, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        this.mTroopUin = a16.g().r().c().j();
        param.a().e().f(this, this.mAction);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 4) {
            if (state == 12) {
                o();
                return;
            }
            return;
        }
        m();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSClearTroopRedDotEvent) {
            h((QFSClearTroopRedDotEvent) simpleBaseEvent);
        }
    }
}
