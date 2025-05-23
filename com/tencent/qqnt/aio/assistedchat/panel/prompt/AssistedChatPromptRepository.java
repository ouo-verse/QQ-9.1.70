package com.tencent.qqnt.aio.assistedchat.panel.prompt;

import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$GetPromptListRsp;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$PromptInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/prompt/AssistedChatPromptRepository;", "", "Lcom/tencent/aio/data/AIOContact;", "aioContact", "", "Lcom/tencent/qqnt/aio/assistedchat/model/a;", "e", "(Lcom/tencent/aio/data/AIOContact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "d", "a", "Lcom/tencent/aio/data/AIOContact;", "", "b", "Ljava/util/List;", "prompts", "<init>", "(Lcom/tencent/aio/data/AIOContact;)V", "c", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatPromptRepository {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOContact aioContact;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.aio.assistedchat.model.a> prompts;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/prompt/AssistedChatPromptRepository$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.panel.prompt.AssistedChatPromptRepository$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59433);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AssistedChatPromptRepository(@NotNull AIOContact aioContact) {
        Intrinsics.checkNotNullParameter(aioContact, "aioContact");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContact);
        } else {
            this.aioContact = aioContact;
            this.prompts = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e(AIOContact aIOContact, Continuation<? super List<com.tencent.qqnt.aio.assistedchat.model.a>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        List emptyList;
        if (!AppNetConnInfo.isNetSupport()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        com.tencent.qqnt.aio.assistedchat.request.a.f349425a.a(aIOContact.e(), aIOContact.j(), new Function3<Integer, String, AssistedChatPB$GetPromptListRsp, Unit>(cancellableContinuationImpl) { // from class: com.tencent.qqnt.aio.assistedchat.panel.prompt.AssistedChatPromptRepository$requestPromptList$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ CancellableContinuation<List<com.tencent.qqnt.aio.assistedchat.model.a>> $continuation;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
                this.$continuation = cancellableContinuationImpl;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuationImpl);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, AssistedChatPB$GetPromptListRsp assistedChatPB$GetPromptListRsp) {
                invoke(num.intValue(), str, assistedChatPB$GetPromptListRsp);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @Nullable String str, @Nullable AssistedChatPB$GetPromptListRsp assistedChatPB$GetPromptListRsp) {
                List<com.tencent.qqnt.aio.assistedchat.model.a> emptyList2;
                List<com.tencent.qqnt.aio.assistedchat.model.a> emptyList3;
                int collectionSizeOrDefault;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, assistedChatPB$GetPromptListRsp);
                    return;
                }
                QLog.i("AssistedChatPromptRepository", 1, "requestPromptList response code=" + i3 + " msg=" + str + " rsp=" + assistedChatPB$GetPromptListRsp);
                if (i3 == 0 && assistedChatPB$GetPromptListRsp != null) {
                    int i16 = assistedChatPB$GetPromptListRsp.rsp_head.ret_code.get();
                    String str2 = assistedChatPB$GetPromptListRsp.rsp_head.ret_msg.get();
                    if (i16 != 0) {
                        QLog.i("AssistedChatPromptRepository", 1, "requestPromptList ret_code=" + i16 + " ret_msg=" + str2);
                        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                    } else {
                        List<AssistedChatPB$PromptInfo> list = assistedChatPB$GetPromptListRsp.infos.get();
                        Intrinsics.checkNotNullExpressionValue(list, "rsp.infos.get()");
                        List<AssistedChatPB$PromptInfo> list2 = list;
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                        emptyList3 = new ArrayList<>(collectionSizeOrDefault);
                        for (AssistedChatPB$PromptInfo it : list2) {
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            emptyList3.add(com.tencent.qqnt.aio.assistedchat.protocolbuffer.a.a(it));
                        }
                    }
                    this.$continuation.resume(emptyList3, AnonymousClass1.INSTANCE);
                    return;
                }
                CancellableContinuation<List<com.tencent.qqnt.aio.assistedchat.model.a>> cancellableContinuation = this.$continuation;
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                cancellableContinuation.resume(emptyList2, AnonymousClass2.INSTANCE);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @NotNull
    public final Flow<List<com.tencent.qqnt.aio.assistedchat.model.a>> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Flow) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return FlowKt.flow(new AssistedChatPromptRepository$getPromptListFlow$1(this, null));
    }
}
