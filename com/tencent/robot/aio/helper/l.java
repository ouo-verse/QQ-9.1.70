package com.tencent.robot.aio.helper;

import android.text.TextUtils;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.aio.helper.cw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u001a\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR&\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a0\u001e0\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/robot/aio/helper/l;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "b", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "c", "", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mContext", "com/tencent/robot/aio/helper/l$b", "e", "Lcom/tencent/robot/aio/helper/l$b;", "mAction", "Lkotlin/Pair;", "f", "Ljava/util/List;", "mMessageList", "<init>", "()V", tl.h.F, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes25.dex */
public final class l implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> mMessageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/helper/l$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent msgIntent) {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            l.this.b(msgIntent);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public l() {
        List<Pair<String, b>> listOf;
        b bVar = new b();
        this.mAction = bVar;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(TuplesKt.to(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.OnReceiveMsgs.class)), bVar));
        this.mMessageList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(MsgIntent msgIntent) {
        if (msgIntent instanceof AIOMsgListEvent.OnReceiveMsgs) {
            c(((AIOMsgListEvent.OnReceiveMsgs) msgIntent).a());
        }
    }

    private final void c(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        Object first;
        String str;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        ArrayList arrayList = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        String j3 = aVar.g().r().c().j();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = msgList.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) next;
            Intrinsics.checkNotNull(aVar2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar2;
            if (!TextUtils.equals(aIOMsgItem.getMsgRecord().peerUid, j3) || aIOMsgItem.getMsgRecord().msgType == 1) {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(next);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            com.tencent.aio.data.msglist.a aVar3 = (com.tencent.aio.data.msglist.a) first;
            if (!(aVar3 instanceof AIOMsgItem)) {
                return;
            }
            if (com.tencent.qqnt.aio.msg.d.M((AIOMsgItem) aVar3)) {
                str = "1";
            } else if (aVar3 instanceof com.tencent.mobileqq.aio.msg.i) {
                str = "2";
            } else {
                str = "3";
            }
            l24.e.f413735a.i("robot_msg_receive", str);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350666q1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "RobotMsgReportHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[0];
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.mContext = param.a();
        l24.e.f413735a.g();
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = this.mContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            aVar.e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        l24.e.f413735a.h();
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = this.mContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            aVar.e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}
