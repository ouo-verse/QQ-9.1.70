package com.tencent.mobileqq.troop.troopownertask.api.impl;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopownertask.g;
import com.tencent.protofile.QunOwnerTaskSvrPB$CommonMsg;
import com.tencent.protofile.QunOwnerTaskSvrPB$GetMsgRsp;
import com.tencent.protofile.QunOwnerTaskSvrPB$TaskMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00017B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001bH\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\u0012\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J$\u0010*\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030(0'j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030(`)H\u0016R\u0016\u0010-\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/troop/troopownertask/api/impl/TroopOwnerTaskHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/troopownertask/api/impl/TroopOwnerTaskRefreshDataEvent;", "", "p", "k", "", "e", "j", "", "groupUin", "o", "Lcom/tencent/protofile/QunOwnerTaskSvrPB$GetMsgRsp;", "rsp", h.F, "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "Lcom/tencent/protofile/QunOwnerTaskSvrPB$CommonMsg;", "msgRsp", "g", "Lcom/tencent/protofile/QunOwnerTaskSvrPB$TaskMsg;", "taskRsp", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/aio/data/AIOContact;", "f", "Lcom/tencent/aio/data/AIOContact;", "aioContact", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes19.dex */
public final class TroopOwnerTaskHelper implements com.tencent.aio.main.businesshelper.h, SimpleEventReceiver<TroopOwnerTaskRefreshDataEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b helperParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AIOContact aioContact;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopownertask/api/impl/TroopOwnerTaskHelper$a;", "", "", "DEFAULT_EXPIRE_TIME_OFFSET", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopownertask.api.impl.TroopOwnerTaskHelper$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60037);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopOwnerTaskHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean e() {
        g gVar = g.f301003a;
        AIOContact aIOContact = this.aioContact;
        AIOContact aIOContact2 = null;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            aIOContact = null;
        }
        if (!gVar.d(aIOContact.j())) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopOwnerTaskHelper", 2, "needUseCacheForNotify false, because not troop owner.");
            }
            return false;
        }
        TroopOwnerTaskCacheRepo troopOwnerTaskCacheRepo = TroopOwnerTaskCacheRepo.f300970a;
        AIOContact aIOContact3 = this.aioContact;
        if (aIOContact3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContact");
        } else {
            aIOContact2 = aIOContact3;
        }
        if (!troopOwnerTaskCacheRepo.b(aIOContact2.j())) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopOwnerTaskHelper", 2, "needUseCacheForNotify true");
            return true;
        }
        return true;
    }

    private final void g(PBRepeatMessageField<QunOwnerTaskSvrPB$CommonMsg> msgRsp) {
        ArrayList arrayList = new ArrayList();
        int size = msgRsp.size();
        for (int i3 = 0; i3 < size; i3++) {
            QunOwnerTaskSvrPB$CommonMsg qunOwnerTaskSvrPB$CommonMsg = msgRsp.get(i3);
            String str = qunOwnerTaskSvrPB$CommonMsg.task_id.get();
            Intrinsics.checkNotNullExpressionValue(str, "msgPB.task_id.get()");
            String str2 = qunOwnerTaskSvrPB$CommonMsg.sub_task_id.get();
            Intrinsics.checkNotNullExpressionValue(str2, "msgPB.sub_task_id.get()");
            String str3 = qunOwnerTaskSvrPB$CommonMsg.title.get();
            Intrinsics.checkNotNullExpressionValue(str3, "msgPB.title.get()");
            String str4 = qunOwnerTaskSvrPB$CommonMsg.content.get();
            Intrinsics.checkNotNullExpressionValue(str4, "msgPB.content.get()");
            long j3 = qunOwnerTaskSvrPB$CommonMsg.publish_time.get();
            String str5 = qunOwnerTaskSvrPB$CommonMsg.jump_url.get();
            Intrinsics.checkNotNullExpressionValue(str5, "msgPB.jump_url.get()");
            a aVar = new a(str, str2, str3, str4, j3, str5);
            if (QLog.isColorLevel()) {
                QLog.d("TroopOwnerTaskHelper", 2, "handleMsgRsp: msg=" + aVar);
            }
            arrayList.add(aVar);
        }
        TroopOwnerTaskCacheRepo troopOwnerTaskCacheRepo = TroopOwnerTaskCacheRepo.f300970a;
        AIOContact aIOContact = this.aioContact;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            aIOContact = null;
        }
        troopOwnerTaskCacheRepo.p(aIOContact.j(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(QunOwnerTaskSvrPB$GetMsgRsp rsp) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("TroopOwnerTaskHelper", 2, "handleRsp: task_num=" + rsp.task_msg.task_num.get() + ", msgNum=" + rsp.common_msgs.size() + ", expire_time=" + rsp.expire_time.get());
        }
        if (rsp.expire_time.get() > 0) {
            i3 = rsp.expire_time.get();
        } else {
            i3 = 300;
        }
        long serverTime = NetConnInfoCenter.getServerTime() + i3;
        TroopOwnerTaskCacheRepo troopOwnerTaskCacheRepo = TroopOwnerTaskCacheRepo.f300970a;
        AIOContact aIOContact = this.aioContact;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            aIOContact = null;
        }
        troopOwnerTaskCacheRepo.o(aIOContact.j(), serverTime);
        QunOwnerTaskSvrPB$TaskMsg qunOwnerTaskSvrPB$TaskMsg = rsp.task_msg;
        Intrinsics.checkNotNullExpressionValue(qunOwnerTaskSvrPB$TaskMsg, "rsp.task_msg");
        i(qunOwnerTaskSvrPB$TaskMsg);
        PBRepeatMessageField<QunOwnerTaskSvrPB$CommonMsg> pBRepeatMessageField = rsp.common_msgs;
        Intrinsics.checkNotNullExpressionValue(pBRepeatMessageField, "rsp.common_msgs");
        g(pBRepeatMessageField);
        m();
    }

    private final void i(QunOwnerTaskSvrPB$TaskMsg taskRsp) {
        if (QLog.isColorLevel()) {
            QLog.i("TroopOwnerTaskHelper", 2, "handleTaskRsp onSuccess task_num:" + taskRsp.task_num.get() + ", latest_task_time:" + taskRsp.latest_task_time.get() + " jump_url:" + taskRsp.jump_url.get());
        }
        AIOContact aIOContact = this.aioContact;
        AIOContact aIOContact2 = null;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            aIOContact = null;
        }
        String j3 = aIOContact.j();
        int i3 = taskRsp.task_num.get();
        int i16 = taskRsp.latest_task_time.get();
        String str = taskRsp.jump_url.get();
        Intrinsics.checkNotNullExpressionValue(str, "taskRsp.jump_url.get()");
        int i17 = taskRsp.total_task_num.get();
        String str2 = taskRsp.task_report_info.get();
        Intrinsics.checkNotNullExpressionValue(str2, "taskRsp.task_report_info.get()");
        b bVar = new b(j3, i3, i16, str, i17, str2);
        TroopOwnerTaskCacheRepo troopOwnerTaskCacheRepo = TroopOwnerTaskCacheRepo.f300970a;
        AIOContact aIOContact3 = this.aioContact;
        if (aIOContact3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContact");
        } else {
            aIOContact2 = aIOContact3;
        }
        troopOwnerTaskCacheRepo.q(aIOContact2.j(), bVar);
    }

    private final boolean j() {
        g gVar = g.f301003a;
        AIOContact aIOContact = this.aioContact;
        AIOContact aIOContact2 = null;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            aIOContact = null;
        }
        if (!gVar.d(aIOContact.j())) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopOwnerTaskHelper", 2, "needRequestTask false, because not troop owner.");
            }
            return false;
        }
        TroopOwnerTaskCacheRepo troopOwnerTaskCacheRepo = TroopOwnerTaskCacheRepo.f300970a;
        AIOContact aIOContact3 = this.aioContact;
        if (aIOContact3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContact");
        } else {
            aIOContact2 = aIOContact3;
        }
        long k3 = troopOwnerTaskCacheRepo.k(aIOContact2.j());
        if (k3 <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopOwnerTaskHelper", 2, "needRequestTask true, not find expireTimeKey.");
            }
            return true;
        }
        if (k3 > 0 && NetConnInfoCenter.getServerTime() > k3) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopOwnerTaskHelper", 2, "needRequestTask true, beyond expiration time.");
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopOwnerTaskHelper", 2, "needRequestTask false, not first and not beyond expiration time. expireTime=" + k3);
        }
        return false;
    }

    private final void k() {
        m();
    }

    private final void m() {
        AIOContact aIOContact = this.aioContact;
        AIOContact aIOContact2 = null;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            aIOContact = null;
        }
        String j3 = aIOContact.j();
        TroopOwnerTaskCacheRepo troopOwnerTaskCacheRepo = TroopOwnerTaskCacheRepo.f300970a;
        AIOContact aIOContact3 = this.aioContact;
        if (aIOContact3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            aIOContact3 = null;
        }
        b n3 = troopOwnerTaskCacheRepo.n(aIOContact3.j());
        AIOContact aIOContact4 = this.aioContact;
        if (aIOContact4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContact");
        } else {
            aIOContact2 = aIOContact4;
        }
        final TroopOwnerTaskRefreshUIEvent troopOwnerTaskRefreshUIEvent = new TroopOwnerTaskRefreshUIEvent(j3, n3, troopOwnerTaskCacheRepo.h(aIOContact2.j()));
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopownertask.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                TroopOwnerTaskHelper.n(TroopOwnerTaskRefreshUIEvent.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(TroopOwnerTaskRefreshUIEvent event) {
        Intrinsics.checkNotNullParameter(event, "$event");
        SimpleEventBus.getInstance().dispatchEvent(event);
    }

    private final void o(long groupUin) {
        e.f300991a.b(groupUin, new Function2<Boolean, QunOwnerTaskSvrPB$GetMsgRsp, Unit>() { // from class: com.tencent.mobileqq.troop.troopownertask.api.impl.TroopOwnerTaskHelper$requestTask$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopOwnerTaskHelper.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, QunOwnerTaskSvrPB$GetMsgRsp qunOwnerTaskSvrPB$GetMsgRsp) {
                invoke(bool.booleanValue(), qunOwnerTaskSvrPB$GetMsgRsp);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable QunOwnerTaskSvrPB$GetMsgRsp qunOwnerTaskSvrPB$GetMsgRsp) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), qunOwnerTaskSvrPB$GetMsgRsp);
                } else {
                    if (!z16 || qunOwnerTaskSvrPB$GetMsgRsp == null) {
                        return;
                    }
                    TroopOwnerTaskHelper.this.h(qunOwnerTaskSvrPB$GetMsgRsp);
                }
            }
        });
    }

    private final void p() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.troopownertask.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                TroopOwnerTaskHelper.q(TroopOwnerTaskHelper.this);
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(TroopOwnerTaskHelper this$0) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.j()) {
            AIOContact aIOContact = this$0.aioContact;
            if (aIOContact == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContact");
                aIOContact = null;
            }
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(aIOContact.j());
            if (longOrNull != null) {
                this$0.o(longOrNull.longValue());
                return;
            }
            return;
        }
        if (this$0.e()) {
            this$0.k();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<TroopOwnerTaskRefreshDataEvent>> getEventClass() {
        ArrayList<Class<TroopOwnerTaskRefreshDataEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TroopOwnerTaskRefreshDataEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return cw.f350660o1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "TroopOwnerTaskHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new int[]{0, 4, 3, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        this.helperParam = param;
        this.aioContext = param.a();
        this.aioContact = param.a().g().r().c();
        if (QLog.isColorLevel()) {
            AIOContact aIOContact = this.aioContact;
            AIOContact aIOContact2 = null;
            if (aIOContact == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContact");
                aIOContact = null;
            }
            String j3 = aIOContact.j();
            AIOContact aIOContact3 = this.aioContact;
            if (aIOContact3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            } else {
                aIOContact2 = aIOContact3;
            }
            QLog.d("TroopOwnerTaskHelper", 2, "onCreate peerUid:" + j3 + ", type=" + aIOContact2.e());
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        h.a.b(this);
        if (QLog.isColorLevel()) {
            AIOContact aIOContact = this.aioContact;
            AIOContact aIOContact2 = null;
            if (aIOContact == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContact");
                aIOContact = null;
            }
            String j3 = aIOContact.j();
            AIOContact aIOContact3 = this.aioContact;
            if (aIOContact3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            } else {
                aIOContact2 = aIOContact3;
            }
            QLog.d("TroopOwnerTaskHelper", 2, "onDestroy peerUid:" + j3 + ", type=" + aIOContact2.e());
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, state);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopOwnerTaskHelper", 2, "onMoveToState state:" + state);
        }
        if (!g.f301003a.g()) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopOwnerTaskHelper", 2, "onMoveToState: not enable");
            }
        } else if (state != 3) {
            if (state == 12) {
                SimpleEventBus.getInstance().unRegisterReceiver(this);
            }
        } else {
            SimpleEventBus.getInstance().registerReceiver(this);
            p();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        TroopOwnerTaskRefreshDataEvent troopOwnerTaskRefreshDataEvent;
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) event);
            return;
        }
        AIOContact aIOContact = null;
        if (event instanceof TroopOwnerTaskRefreshDataEvent) {
            troopOwnerTaskRefreshDataEvent = (TroopOwnerTaskRefreshDataEvent) event;
        } else {
            troopOwnerTaskRefreshDataEvent = null;
        }
        if (troopOwnerTaskRefreshDataEvent != null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopOwnerTaskHelper", 2, "onReceiveEvent: TroopOwnerTaskRefreshEvent");
            }
            TroopOwnerTaskCacheRepo troopOwnerTaskCacheRepo = TroopOwnerTaskCacheRepo.f300970a;
            AIOContact aIOContact2 = this.aioContact;
            if (aIOContact2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContact");
                aIOContact2 = null;
            }
            troopOwnerTaskCacheRepo.g(aIOContact2.j());
            troopOwnerTaskCacheRepo.f();
            AIOContact aIOContact3 = this.aioContact;
            if (aIOContact3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            } else {
                aIOContact = aIOContact3;
            }
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(aIOContact.j());
            if (longOrNull != null) {
                o(longOrNull.longValue());
            }
        }
    }
}
