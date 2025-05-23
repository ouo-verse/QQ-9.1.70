package com.tencent.qqnt.biz.lightbusiness.lightinteraction;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAMsgReplyProcessor;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgreply/e;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "Lcom/tencent/mobileqq/aio/msg/v;", "replyParam", "", "a", "<init>", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class LIAMsgReplyProcessor implements com.tencent.mobileqq.aio.msglist.holder.component.msgreply.e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAMsgReplyProcessor$a;", "", "", "LIA_OBJECT_TYPE", "Ljava/lang/String;", "LIA_RESOURCE", "<init>", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAMsgReplyProcessor$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29823);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LIAMsgReplyProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgreply.e
    public void a(@NotNull final AIOMsgItem aioMsgItem, @NotNull final v replyParam) {
        final com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.a r16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioMsgItem, (Object) replyParam);
            return;
        }
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        Intrinsics.checkNotNullParameter(replyParam, "replyParam");
        if (aioMsgItem.getMsgRecord().chatType == 1 && (r16 = LIAHelper.f353124a.r(aioMsgItem.getMsgRecord().msgAttrs)) != null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            LIAConfigManager.INSTANCE.a().f(r16.c(), r16.b(), new Function1<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b, Unit>(countDownLatch, aioMsgItem, replyParam, r16) { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAMsgReplyProcessor$processMsgReply$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ AIOMsgItem $aioMsgItem;
                final /* synthetic */ CountDownLatch $countDownLatch;
                final /* synthetic */ com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.a $it;
                final /* synthetic */ v $replyParam;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$countDownLatch = countDownLatch;
                    this.$aioMsgItem = aioMsgItem;
                    this.$replyParam = replyParam;
                    this.$it = r16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, countDownLatch, aioMsgItem, replyParam, r16);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b bVar) {
                    invoke2(bVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b bVar) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bVar);
                        return;
                    }
                    this.$countDownLatch.countDown();
                    if (bVar != null) {
                        AIOMsgItem aIOMsgItem = this.$aioMsgItem;
                        v vVar = this.$replyParam;
                        com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.a aVar = this.$it;
                        aIOMsgItem.U1(bVar.i() != 0);
                        vVar.d(bVar.i());
                        vVar.c("lia_resource", bVar);
                        vVar.c("lia_object_type", Integer.valueOf(aVar.a()));
                    }
                }
            });
            countDownLatch.await();
        }
    }
}
