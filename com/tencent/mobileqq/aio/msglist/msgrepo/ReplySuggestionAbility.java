package com.tencent.mobileqq.aio.msglist.msgrepo;

import android.os.Bundle;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J \u0010\b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J(\u0010\u0015\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/ReplySuggestionAbility;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "", "Lcom/tencent/aio/data/msglist/a;", "list", "", "forceRemove", ReportConstant.COSTREPORT_PREFIX, "r", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "g", "", "source", "Landroid/os/Bundle;", "extra", "b", "", "i", "J", "lastMsgId", "msgRepo", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ReplySuggestionAbility extends g<BaseMsgRepo> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long lastMsgId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/ReplySuggestionAbility$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.msgrepo.ReplySuggestionAbility$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64249);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplySuggestionAbility(@NotNull BaseMsgRepo msgRepo, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(msgRepo, aioContext, scope);
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgRepo, aioContext, scope);
        }
    }

    private final void o() {
        BuildersKt__Builders_commonKt.launch$default(f(), zs.b.a(Dispatchers.INSTANCE), null, new ReplySuggestionAbility$handleHideReplySuggestionTail$1(this, null), 2, null);
    }

    private final void p() {
        BuildersKt__Builders_commonKt.launch$default(f(), zs.b.a(Dispatchers.INSTANCE), null, new ReplySuggestionAbility$handleOnReplySuggestionTailClick$1(this, null), 2, null);
    }

    private final void q() {
        BuildersKt__Builders_commonKt.launch$default(f(), zs.b.a(Dispatchers.INSTANCE), null, new ReplySuggestionAbility$handleShowReplySuggestionTail$1(this, null), 2, null);
    }

    private final boolean r() {
        int e16 = d().g().r().c().e();
        if (e16 != 1 && e16 != 104 && e16 != 119) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s(List<com.tencent.aio.data.msglist.a> list, boolean forceRemove) {
        boolean z16 = false;
        for (int size = list.size() - 1; -1 < size; size--) {
            com.tencent.aio.data.msglist.a aVar = list.get(size);
            if ((aVar instanceof AIOMsgItem) && (forceRemove || !((AIOMsgItem) aVar).I())) {
                AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar;
                if (aIOMsgItem.a0()) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("IntelligentResponseAbility", 4, "[updateIntelligentResponseFlag]: MsgId is " + aVar.getMsgId());
                    }
                    AIOMsgItem cloneNewInstance = aIOMsgItem.cloneNewInstance();
                    cloneNewInstance.F1(false);
                    Unit unit = Unit.INSTANCE;
                    list.set(size, cloneNewInstance);
                    z16 = true;
                }
            }
        }
        return z16;
    }

    static /* synthetic */ boolean t(ReplySuggestionAbility replySuggestionAbility, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return replySuggestionAbility.s(list, z16);
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void b(@NotNull List<com.tencent.aio.data.msglist.a> list, @NotNull String source, @Nullable Bundle extra) {
        Object last;
        AIOMsgItem aIOMsgItem;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, list, source, extra);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(source, "source");
        super.b(list, source, extra);
        if (!list.isEmpty() && !r()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
            if (last instanceof AIOMsgItem) {
                aIOMsgItem = (AIOMsgItem) last;
            } else {
                aIOMsgItem = null;
            }
            if (aIOMsgItem != null) {
                j3 = aIOMsgItem.getMsgId();
            } else {
                j3 = 0;
            }
            if (this.lastMsgId != j3 || Intrinsics.areEqual(source, "msg_update") || Intrinsics.areEqual(source, "handle_first_page") || Intrinsics.areEqual(source, "remove_fake_loading_msg")) {
                t(this, list, false, 2, null);
            }
            this.lastMsgId = j3;
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void g(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof AssistedChatMsgIntent.ShowReplySuggestionSwitchTailIntent) {
            q();
        } else if (intent instanceof AssistedChatMsgIntent.OnReplySuggestionTailClick) {
            p();
        } else if (intent instanceof AssistedChatMsgIntent.HideReplySuggestionSwitchTailIntent) {
            o();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.ShowReplySuggestionSwitchTailIntent");
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.HideReplySuggestionSwitchTailIntent");
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.OnReplySuggestionTailClick");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new HashSet();
    }
}
