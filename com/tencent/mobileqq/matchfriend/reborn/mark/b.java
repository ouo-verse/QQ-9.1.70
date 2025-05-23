package com.tencent.mobileqq.matchfriend.reborn.mark;

import android.os.Looper;
import com.tencent.aio.stranger.api.IStrangerBackgroundApi;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerForegroundApi;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.j;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0019\u0018\u0000 \f2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0002J\u0016\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001aR&\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00190\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/mark/b;", "", "", "g", h.F, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "c", "Lcom/tencent/mobileqq/aio/event/AIOMsgListEvent$InputLayoutChange;", "d", "Lcom/tencent/aio/api/runtime/a;", "context", "e", "f", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "model", "", "immediate", "i", "a", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "b", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "currentInteractiveMarkModel", "com/tencent/mobileqq/matchfriend/reborn/mark/b$b", "Lcom/tencent/mobileqq/matchfriend/reborn/mark/b$b;", "action", "", "Lkotlin/Pair;", "", "Ljava/util/List;", TabPreloadItem.TAB_NAME_MESSAGE, "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private QQStrangerInteractiveMarkModel currentInteractiveMarkModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final C8015b action;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<Pair<String, C8015b>> msgList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/mark/b$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.mark.b$b, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public static final class C8015b implements com.tencent.mvi.base.route.a {
        C8015b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            b.this.c(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public b() {
        List<Pair<String, C8015b>> listOf;
        C8015b c8015b = new C8015b();
        this.action = c8015b;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(TuplesKt.to(j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.InputLayoutChange.class)), c8015b));
        this.msgList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(MsgIntent intent) {
        if (intent instanceof AIOMsgListEvent.InputLayoutChange) {
            d((AIOMsgListEvent.InputLayoutChange) intent);
        }
    }

    private final void d(AIOMsgListEvent.InputLayoutChange intent) {
        ((IStrangerBackgroundApi) QRoute.api(IStrangerBackgroundApi.class)).notifyInputLayoutChange(intent.b(), intent.d(), intent.c(), intent.a());
    }

    private final void g() {
        com.tencent.mvi.base.route.j e16;
        Iterator<T> it = this.msgList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar != null && (e16 = aVar.e()) != null) {
                e16.d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
            }
        }
    }

    private final void h() {
        com.tencent.mvi.base.route.j e16;
        Iterator<T> it = this.msgList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar != null && (e16 = aVar.e()) != null) {
                e16.b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(b this$0, QQStrangerInteractiveMarkModel model, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(model, "$model");
        if (Intrinsics.areEqual(this$0.currentInteractiveMarkModel, model)) {
            if (QLog.isColorLevel()) {
                QLog.i("QQStrangerInteractiveMarkBusiness", 2, "updateMarkModel model equals return");
                return;
            }
            return;
        }
        QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel = this$0.currentInteractiveMarkModel;
        if (qQStrangerInteractiveMarkModel == null) {
            if (model.level >= 1) {
                QRouteApi api = QRoute.api(IQQStrangerForegroundApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IQQStrangerForegroundApi::class.java)");
                IQQStrangerForegroundApi.a.a((IQQStrangerForegroundApi) api, model, null, 2, null);
            }
            com.tencent.aio.stranger.api.a h16 = c.h(model);
            if (h16 != null) {
                ((IStrangerBackgroundApi) QRoute.api(IStrangerBackgroundApi.class)).setNextMutualModel(h16, z16);
            }
        } else if (qQStrangerInteractiveMarkModel != null) {
            long j3 = model.level;
            long j16 = qQStrangerInteractiveMarkModel.level;
            if (j3 > j16 && j16 >= 1) {
                ((IQQStrangerForegroundApi) QRoute.api(IQQStrangerForegroundApi.class)).showGainMutualMarkAnimatorView(model);
            }
            long j17 = model.level;
            long j18 = qQStrangerInteractiveMarkModel.level;
            if (j17 > j18 && j18 == 0) {
                long min = Math.min(5L, model.count);
                ((IStrangerBackgroundApi) QRoute.api(IStrangerBackgroundApi.class)).setNextMutualModel(new com.tencent.aio.stranger.api.a(min, model.level, com.tencent.mobileqq.matchfriend.reborn.mark.config.b.f245190a.d(model.getResBaseUrl(), model.subtype, min), model), z16);
            } else {
                com.tencent.aio.stranger.api.a h17 = c.h(model);
                if (h17 != null) {
                    ((IStrangerBackgroundApi) QRoute.api(IStrangerBackgroundApi.class)).setNextMutualModel(h17, z16);
                }
            }
        }
        this$0.currentInteractiveMarkModel = model;
    }

    public final void e(com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (QLog.isColorLevel()) {
            QLog.i("QQStrangerInteractiveMarkBusiness", 2, "onCreate");
        }
        ((IQQStrangerForegroundApi) QRoute.api(IQQStrangerForegroundApi.class)).onCreate(context);
        ((IStrangerBackgroundApi) QRoute.api(IStrangerBackgroundApi.class)).onCreate(context);
        this.aioContext = context;
        g();
        com.tencent.mobileqq.matchfriend.aio.utils.c cVar = com.tencent.mobileqq.matchfriend.aio.utils.c.f243986a;
        cVar.d(cVar.c(context));
    }

    public final void f() {
        h();
        if (QLog.isColorLevel()) {
            QLog.i("QQStrangerInteractiveMarkBusiness", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        ((IStrangerBackgroundApi) QRoute.api(IStrangerBackgroundApi.class)).onDestroy();
        ((IQQStrangerForegroundApi) QRoute.api(IQQStrangerForegroundApi.class)).onDestroy();
        this.aioContext = null;
        this.currentInteractiveMarkModel = null;
    }

    public final void i(final QQStrangerInteractiveMarkModel model, final boolean immediate) {
        Intrinsics.checkNotNullParameter(model, "model");
        QLog.i("QQStrangerInteractiveMarkBusiness", 1, "updateMarkModel current model: " + this.currentInteractiveMarkModel + ", newModel: " + model + ", immediate: " + immediate);
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.mark.a
            @Override // java.lang.Runnable
            public final void run() {
                b.j(b.this, model, immediate);
            }
        };
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        } else {
            runnable.run();
        }
    }
}
