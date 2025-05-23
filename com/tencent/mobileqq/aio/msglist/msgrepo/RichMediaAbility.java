package com.tencent.mobileqq.aio.msglist.msgrepo;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R0\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0003`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/RichMediaAbility;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", "", "t", "v", "u", "r", "Lcom/tencent/mobileqq/aio/msg/service/AIOMsgServiceWithContext;", "aioMsgService", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lcom/tencent/aio/data/msglist/a;", "msgItemList", "c", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "i", "Ljava/util/HashMap;", "transNotifyInfoMap", "msgRepo", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RichMediaAbility extends g<BaseMsgRepo> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, FileTransNotifyInfo> transNotifyInfoMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/RichMediaAbility$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.msgrepo.RichMediaAbility$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64254);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichMediaAbility(@NotNull BaseMsgRepo msgRepo, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(msgRepo, aioContext, scope);
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgRepo, aioContext, scope);
        } else {
            this.transNotifyInfoMap = new HashMap<>();
        }
    }

    private final void r(final FileTransNotifyInfo fileInfo) {
        this.transNotifyInfoMap.put(Long.valueOf(fileInfo.msgId), fileInfo);
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.l
            @Override // java.lang.Runnable
            public final void run() {
                RichMediaAbility.s(RichMediaAbility.this, fileInfo);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(RichMediaAbility this$0, FileTransNotifyInfo fileInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fileInfo, "$fileInfo");
        new h(this$0.e()).c(fileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(FileTransNotifyInfo fileInfo) {
        r(fileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(FileTransNotifyInfo fileInfo) {
        r(fileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(FileTransNotifyInfo fileInfo) {
        QLog.d("AIOMsgRepo RichMediaAbility", 1, "onRichMediaUploadComplete fileInfo: " + fileInfo);
        r(fileInfo);
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void c(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItemList);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItemList, "msgItemList");
        ArrayList<AIOMsgItem> arrayList = new ArrayList();
        for (Object obj : msgItemList) {
            if (obj instanceof AIOMsgItem) {
                arrayList.add(obj);
            }
        }
        for (AIOMsgItem aIOMsgItem : arrayList) {
            FileTransNotifyInfo fileTransNotifyInfo = this.transNotifyInfoMap.get(Long.valueOf(aIOMsgItem.getMsgId()));
            if (fileTransNotifyInfo != null) {
                aIOMsgItem.setFileTransNotifyInfo(fileTransNotifyInfo);
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void m(@NotNull AIOMsgServiceWithContext aioMsgService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioMsgService);
            return;
        }
        Intrinsics.checkNotNullParameter(aioMsgService, "aioMsgService");
        AIOMsgService aIOMsgService = AIOMsgService.f190196a;
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(aIOMsgService.s(), new RichMediaAbility$registerNotification$1(this, null)), Dispatchers.getIO()), f());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(aIOMsgService.u(), new RichMediaAbility$registerNotification$2(this, null)), Dispatchers.getIO()), f());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(aIOMsgService.t(), new RichMediaAbility$registerNotification$3(this, null)), Dispatchers.getIO()), f());
    }
}
