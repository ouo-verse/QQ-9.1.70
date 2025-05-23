package com.tencent.robot.write.vb.delegate;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.robot.aio.input.RobotWriteMsgIntent;
import com.tencent.robot.write.vb.c;
import com.tencent.robot.write.vb.delegate.WriteListUIState;
import com.tencent.robot.write.vb.delegate.a;
import e74.CallbackData;
import e74.RequireData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import m24.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001-\u0018\u0000 \r*\b\b\u0000\u0010\u0002*\u00020\u00012$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0003j\b\u0012\u0004\u0012\u00028\u0000`\u0007:\u00015B\u000f\u0012\u0006\u0010*\u001a\u00020\u0006\u00a2\u0006\u0004\b4\u0010)J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u001aH\u0002J\u0012\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u001cH\u0016J\u001f\u0010!\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u001fH\u0016\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\nH\u0016R\"\u0010*\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R\u0016\u0010,\u001a\u00028\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010+R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010.R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u000201008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/robot/write/vb/delegate/b;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/robot/write/vb/delegate/a;", "Lcom/tencent/robot/write/vb/delegate/WriteListUIState;", "Lcom/tencent/robot/write/vb/c;", "Lcom/tencent/robot/write/vb/IWriteListVMDelegate;", "Lcom/tencent/robot/write/vb/delegate/a$f;", "intent", "", "l", "Lcom/tencent/robot/write/vb/delegate/a$c;", "i", "Lcom/tencent/robot/write/vb/delegate/a$e;", "k", "", "position", "j", "f", "Lcom/tencent/robot/write/vb/delegate/a$b;", "g", DomainData.DOMAIN_NAME, "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "e", "Lcom/tencent/robot/aio/input/RobotWriteMsgIntent$SubmitListMsgIntent;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Class;", "d0", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "b", "(Lcom/tencent/mvi/api/runtime/b;Z)V", h.F, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/robot/write/vb/c;", "()Lcom/tencent/robot/write/vb/c;", "o", "(Lcom/tencent/robot/write/vb/c;)V", "mHost", "Lcom/tencent/mvi/api/runtime/b;", "mContext", "com/tencent/robot/write/vb/delegate/b$b", "Lcom/tencent/robot/write/vb/delegate/b$b;", "mAction", "Ljava/util/TreeMap;", "Le74/c;", "Ljava/util/TreeMap;", "mRequireDataMap", "<init>", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b<C extends com.tencent.mvi.api.runtime.b> implements e<a, WriteListUIState, C, c> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private C mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C9789b mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TreeMap<Integer, RequireData> mRequireDataMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/write/vb/delegate/b$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.write.vb.delegate.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C9789b implements com.tencent.mvi.base.route.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b<C> f368763d;

        C9789b(b<C> bVar) {
            this.f368763d = bVar;
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            this.f368763d.e(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public b(@NotNull c mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        this.mAction = new C9789b(this);
        this.mRequireDataMap = new TreeMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(MsgIntent event) {
        if (event instanceof RobotWriteMsgIntent.SubmitListMsgIntent) {
            m((RobotWriteMsgIntent.SubmitListMsgIntent) event);
        }
    }

    private final void f() {
        this.mRequireDataMap.clear();
        n();
    }

    private final void g(a.GetAnchorViewIntent intent) {
        b.GeAnchorViewMsgResult geAnchorViewMsgResult;
        C c16 = this.mContext;
        View view = null;
        if (c16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            c16 = null;
        }
        k k3 = c16.e().k(RobotWriteMsgIntent.GetAnchorViewMsgIntent.f367159d);
        if (k3 instanceof b.GeAnchorViewMsgResult) {
            geAnchorViewMsgResult = (b.GeAnchorViewMsgResult) k3;
        } else {
            geAnchorViewMsgResult = null;
        }
        if (geAnchorViewMsgResult != null) {
            view = geAnchorViewMsgResult.getAnchorView();
        }
        intent.b(view);
    }

    private final void i(a.OnRequireListItemSelected intent) {
        this.mRequireDataMap.put(Integer.valueOf(intent.getPosition()), intent.getRequireData());
        n();
    }

    private final void j(int position) {
        this.mRequireDataMap.remove(Integer.valueOf(position));
        n();
    }

    private final void k(a.OnRequireListItemsSelected intent) {
        Iterator<T> it = intent.a().iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            this.mRequireDataMap.put(pair.getFirst(), pair.getSecond());
        }
        n();
    }

    private final void l(a.OnTypeListItemClick intent) {
        ArrayList arrayList;
        ArrayList arrayList2;
        String template = intent.getTemplate();
        C c16 = null;
        if (template != null) {
            arrayList = CollectionsKt__CollectionsKt.arrayListOf(template);
        } else {
            arrayList = null;
        }
        HashMap<String, String> a16 = intent.a();
        if (a16 != null) {
            arrayList2 = CollectionsKt__CollectionsKt.arrayListOf(a16);
        } else {
            arrayList2 = null;
        }
        C c17 = this.mContext;
        if (c17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            c16 = c17;
        }
        c16.e().h(new RobotWriteMsgIntent.UpdateRobotWriteData(1, arrayList, intent.getPlaceholder(), arrayList2));
    }

    private final void m(RobotWriteMsgIntent.SubmitListMsgIntent event) {
        p(new WriteListUIState.SubmitListUIState(event.getDrawData()));
    }

    private final void n() {
        HashMap hashMap;
        Collection<RequireData> values = this.mRequireDataMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "mRequireDataMap.values");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (RequireData requireData : values) {
            arrayList.add(requireData.getTemplate());
            List<CallbackData> a16 = requireData.a();
            if (a16 != null) {
                hashMap = new HashMap();
                for (CallbackData callbackData : a16) {
                    Pair pair = TuplesKt.to(callbackData.getKey(), callbackData.getValue());
                    hashMap.put(pair.getFirst(), pair.getSecond());
                }
            } else {
                hashMap = new HashMap();
            }
            arrayList2.add(hashMap);
        }
        C c16 = this.mContext;
        if (c16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            c16 = null;
        }
        c16.e().h(new RobotWriteMsgIntent.UpdateRobotWriteData(2, arrayList, "", arrayList2));
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull a aVar) {
        e.a.a(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void b(@NotNull C context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        context.e().d(Reflection.getOrCreateKotlinClass(RobotWriteMsgIntent.SubmitListMsgIntent.class).getQualifiedName(), this.mAction);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: d, reason: from getter */
    public c getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.e
    @Nullable
    public Class<? extends a> d0() {
        return a.class;
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.OnTypeListItemClick) {
            l((a.OnTypeListItemClick) intent);
            return;
        }
        if (intent instanceof a.OnRequireListItemSelected) {
            i((a.OnRequireListItemSelected) intent);
            return;
        }
        if (intent instanceof a.OnRequireListItemUnSelected) {
            j(((a.OnRequireListItemUnSelected) intent).getPosition());
            return;
        }
        if (intent instanceof a.OnRequireListItemsSelected) {
            k((a.OnRequireListItemsSelected) intent);
        } else if (intent instanceof a.C9788a) {
            f();
        } else if (intent instanceof a.GetAnchorViewIntent) {
            g((a.GetAnchorViewIntent) intent);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.mHost = cVar;
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        C c16 = this.mContext;
        if (c16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            c16 = null;
        }
        c16.e().b(Reflection.getOrCreateKotlinClass(RobotWriteMsgIntent.SubmitListMsgIntent.class).getQualifiedName(), this.mAction);
    }

    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void p(@NotNull WriteListUIState writeListUIState) {
        e.a.b(this, writeListUIState);
    }
}
