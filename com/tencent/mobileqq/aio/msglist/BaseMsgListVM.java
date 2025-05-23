package com.tencent.mobileqq.aio.msglist;

import android.content.Context;
import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import at.b;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.input.edit.a;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b*\u0001\u001e\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0017J\b\u0010\u001d\u001a\u00020\u0006H\u0017R \u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R4\u0010&\u001a\"\u0012\u001e\u0012\u001c\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001e0\"0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R!\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/BaseMsgListVM;", "Lat/b;", "I", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "", "P", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/mobileqq/aio/msglist/z$a;", "N", "Lcom/tencent/mobileqq/aio/input/edit/a$a;", "K", "Lcom/tencent/aio/data/msglist/a;", "msg", "O", "", "Lcom/tencent/mobileqq/aio/msglist/childvm/c;", "L", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/mobileqq/aio/msglist/BaseMsgListVM$a", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/msglist/BaseMsgListVM$a;", "mActionR", "Lkotlin/Pair;", "", "D", "Ljava/util/List;", "messageRList", "E", "Lkotlin/Lazy;", "M", "()Ljava/util/List;", "mChildVMList", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class BaseMsgListVM<I extends at.b, S extends MsgListUiState> extends MsgListVMWrapper<I, S> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final a mActionR;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, a>> messageRList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mChildVMList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/BaseMsgListVM$a", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseMsgListVM<I, S> f190434d;

        a(BaseMsgListVM<I, S> baseMsgListVM) {
            this.f190434d = baseMsgListVM;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseMsgListVM);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mvi.base.route.k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return this.f190434d.I(i3);
        }
    }

    public BaseMsgListVM() {
        List<Pair<String, a>> listOf;
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        a aVar = new a(this);
        this.mActionR = aVar;
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.GetIsTempChat.class).getQualifiedName(), aVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.GetAIORichMediaMsgListEvent.class)), aVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.GetAioDisplayList.class)), aVar)});
        this.messageRList = listOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends com.tencent.mobileqq.aio.msglist.childvm.c>>(this) { // from class: com.tencent.mobileqq.aio.msglist.BaseMsgListVM$mChildVMList$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ BaseMsgListVM<I, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends com.tencent.mobileqq.aio.msglist.childvm.c> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? this.this$0.L() : (List) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mChildVMList = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k I(MsgIntent i3) {
        if (i3 instanceof AIOMsgListEvent.GetIsTempChat) {
            return new z.f(P());
        }
        if (i3 instanceof AIOMsgListEvent.GetAIORichMediaMsgListEvent) {
            return N(((AIOMsgListEvent.GetAIORichMediaMsgListEvent) i3).a());
        }
        if (i3 instanceof AIOMsgListEvent.GetAioDisplayList) {
            return K();
        }
        return z.k.f192765a;
    }

    private final a.C7263a K() {
        AIOMsgItem aIOMsgItem;
        Long l3;
        AIOMsgItem aIOMsgItem2;
        MsgRecord msgRecord;
        MsgRecord msgRecord2;
        List<com.tencent.aio.data.msglist.a> l16 = l();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (com.tencent.aio.data.msglist.a aVar : l16) {
            boolean z16 = aVar instanceof AIOMsgItem;
            Long l17 = null;
            if (z16) {
                aIOMsgItem = (AIOMsgItem) aVar;
            } else {
                aIOMsgItem = null;
            }
            if (aIOMsgItem != null && (msgRecord2 = aIOMsgItem.getMsgRecord()) != null) {
                l3 = Long.valueOf(msgRecord2.msgId);
            } else {
                l3 = null;
            }
            String valueOf = String.valueOf(l3);
            if (z16) {
                aIOMsgItem2 = (AIOMsgItem) aVar;
            } else {
                aIOMsgItem2 = null;
            }
            if (aIOMsgItem2 != null && (msgRecord = aIOMsgItem2.getMsgRecord()) != null) {
                l17 = Long.valueOf(msgRecord.senderUin);
            }
            linkedHashMap.put(valueOf, String.valueOf(l17));
        }
        return new a.C7263a(linkedHashMap);
    }

    private final List<com.tencent.mobileqq.aio.msglist.childvm.c> M() {
        return (List) this.mChildVMList.getValue();
    }

    private final z.a N(MsgRecord msgRecord) {
        AIOMsgItem aIOMsgItem;
        AIOMsgItem aIOMsgItem2;
        List<com.tencent.aio.data.msglist.a> l3 = l();
        ArrayList<com.tencent.aio.data.msglist.a> arrayList = new ArrayList();
        for (Object obj : l3) {
            if (O((com.tencent.aio.data.msglist.a) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            MsgRecord msgRecord2 = null;
            if (!it.hasNext()) {
                break;
            }
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) it.next();
            if (aVar instanceof AIOMsgItem) {
                aIOMsgItem2 = (AIOMsgItem) aVar;
            } else {
                aIOMsgItem2 = null;
            }
            if (aIOMsgItem2 != null) {
                msgRecord2 = aIOMsgItem2.getMsgRecord();
            }
            if (msgRecord2 != null) {
                arrayList2.add(msgRecord2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (com.tencent.aio.data.msglist.a aVar2 : arrayList) {
            if (aVar2 instanceof AIOMsgItem) {
                aIOMsgItem = (AIOMsgItem) aVar2;
            } else {
                aIOMsgItem = null;
            }
            if (aIOMsgItem != null) {
                arrayList3.add(aIOMsgItem);
            }
        }
        return new z.a(arrayList2, arrayList3);
    }

    private final boolean O(com.tencent.aio.data.msglist.a msg2) {
        if (msg2.getViewType() != 4 && msg2.getViewType() != 5 && msg2.getViewType() != 11 && msg2.getViewType() != 10 && msg2.getViewType() != 8 && msg2.getViewType() != 9 && msg2.getViewType() != 2 && msg2.getViewType() != 3 && msg2.getViewType() != 23 && msg2.getViewType() != 24 && msg2.getViewType() != 70) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean P() {
        int e16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e();
        if (e16 >= 99 && e16 <= 200) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Q() {
        Iterator<T> it = this.messageRList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().j((String) pair.getFirst(), (com.tencent.mvi.base.route.b) pair.getSecond());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void R() {
        com.tencent.mvi.base.route.j e16;
        Iterator<T> it = this.messageRList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
            if (aVar != null && (e16 = aVar.e()) != null) {
                e16.a((String) pair.getFirst());
            }
        }
    }

    @NotNull
    public List<com.tencent.mobileqq.aio.msglist.childvm.c> L() {
        List<com.tencent.mobileqq.aio.msglist.childvm.c> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.aio.base.mvvm.b
    @CallSuper
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        Q();
        Iterator<T> it = M().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.aio.msglist.childvm.c) it.next()).e();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    @CallSuper
    public void onDestroy() {
        Fragment c16;
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        R();
        Iterator<T> it = M().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.aio.msglist.childvm.c) it.next()).onDestroy();
        }
        com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar != null && (c16 = aVar.c()) != null && (context = c16.getContext()) != null) {
            com.tencent.qqnt.rich.i.f362001a.c(context);
        }
    }
}
