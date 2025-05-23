package com.tencent.guild.aio.component.avatar;

import com.tencent.aio.data.AIOContact;
import com.tencent.guild.aio.component.avatar.GuildAioUserAvatarUIState;
import com.tencent.guild.aio.component.avatar.a;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.bc;
import com.tencent.mobileqq.qqguildsdk.data.bd;
import com.tencent.mobileqq.qqguildsdk.data.bz;
import com.tencent.mobileqq.qqguildsdk.data.ds;
import com.tencent.mobileqq.qqguildsdk.data.dw;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vh2.cp;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/guild/aio/component/avatar/e;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/guild/aio/component/avatar/a;", "Lcom/tencent/guild/aio/component/avatar/GuildAioUserAvatarUIState;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "querySeq", DomainData.DOMAIN_NAME, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "intent", "l", "Lcom/tencent/aio/data/AIOContact;", "d", "Lcom/tencent/aio/data/AIOContact;", "mContact", "e", "J", "mLastJumpSeq", "<init>", "()V", "f", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e extends com.tencent.aio.base.mvvm.b<a, GuildAioUserAvatarUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AIOContact mContact;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mLastJumpSeq = -1;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m() {
        long j3;
        long j16;
        long j17;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GuildMsgListIntent.GetAIOTopMsgEvent.f110410d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListResult.GetAIOTopMsgResult");
        com.tencent.aio.data.msglist.a result = ((i.d) k3).getResult();
        if (result != null) {
            j3 = result.getMsgSeq();
        } else {
            j3 = -1;
        }
        k k16 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GuildMsgListIntent.GetAIOBottomMsgEvent.f110407d);
        Intrinsics.checkNotNull(k16, "null cannot be cast to non-null type com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListResult.GetAIOBottomMsgResult");
        com.tencent.aio.data.msglist.a result2 = ((i.a) k16).getResult();
        if (result2 != null) {
            j16 = result2.getMsgSeq();
        } else {
            j16 = -1;
        }
        long j18 = this.mLastJumpSeq;
        int i3 = 1;
        if (j18 != -1) {
            boolean z16 = false;
            if (j3 - 1 <= j18 && j18 <= j16) {
                z16 = true;
            }
            if (z16) {
                j17 = j18 - 1;
                QLog.i("GuildAioUserAvatarViewModel", 4, "jumpToSelfMsg topSeq=" + j3 + " bottomSeq=" + j16 + " lastJumpSeq=" + j18 + " querySeq=" + j17);
                if (j17 != -1) {
                    if (this.mLastJumpSeq == -1) {
                        i3 = 2;
                    }
                    updateUI(new GuildAioUserAvatarUIState.JumpToSelfMsgState(i3));
                    return;
                }
                n(j17);
                return;
            }
        }
        j17 = j16;
        QLog.i("GuildAioUserAvatarViewModel", 4, "jumpToSelfMsg topSeq=" + j3 + " bottomSeq=" + j16 + " lastJumpSeq=" + j18 + " querySeq=" + j17);
        if (j17 != -1) {
        }
    }

    private final void n(long querySeq) {
        List<String> listOf;
        List<String> listOf2;
        bz.a aVar = new bz.a();
        AIOContact aIOContact = this.mContact;
        AIOContact aIOContact2 = null;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContact");
            aIOContact = null;
        }
        aVar.h(aIOContact.f());
        AIOContact aIOContact3 = this.mContact;
        if (aIOContact3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContact");
            aIOContact3 = null;
        }
        aVar.f(aIOContact3.j());
        aVar.i(1L);
        aVar.g(querySeq);
        bz e16 = aVar.e();
        IGPSService iGPSService = (IGPSService) com.tencent.mobileqq.guild.util.bz.b(IGPSService.class);
        bc.a aVar2 = new bc.a();
        AIOContact aIOContact4 = this.mContact;
        if (aIOContact4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContact");
            aIOContact4 = null;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(aIOContact4.j());
        aVar2.f(listOf);
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(iGPSService.getSelfTinyId());
        aVar2.g(listOf2);
        aVar2.h(e16);
        bc e17 = aVar2.e();
        bd.a aVar3 = new bd.a();
        aVar3.m(iGPSService.getSelfTinyId());
        AIOContact aIOContact5 = this.mContact;
        if (aIOContact5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContact");
        } else {
            aIOContact2 = aIOContact5;
        }
        aVar3.l(aIOContact2.f());
        aVar3.n(0);
        aVar3.i(e17);
        aVar3.j("");
        aVar3.k(1);
        bd h16 = aVar3.h();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildAioUserAvatarViewModel", 2, "searchSelfMsgLowerThanSeqFromServer " + h16);
        }
        iGPSService.searchMsgSeqsFromServer(h16, new cp() { // from class: com.tencent.guild.aio.component.avatar.d
            @Override // vh2.cp
            public final void a(int i3, String str, dw dwVar) {
                e.o(e.this, i3, str, dwVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void o(e this$0, int i3, String str, dw dwVar) {
        boolean z16;
        Object first;
        Object first2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.a d16 = Logger.f235387a.d();
        int i16 = 1;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        d16.i("GuildAioUserAvatarViewModel", 1, "searchSelfMsgFromServer callback ret: " + z16 + " err:" + str + "  rsp: " + dwVar);
        if (i3 == 0 && dwVar != null && !dwVar.a().isEmpty()) {
            List<ds> a16 = dwVar.a();
            Intrinsics.checkNotNullExpressionValue(a16, "rsp.results");
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) a16);
            this$0.updateUI(new GuildAioUserAvatarUIState.JumpToSelfMsgState(((ds) first).getMsgSeq()));
            List<ds> a17 = dwVar.a();
            Intrinsics.checkNotNullExpressionValue(a17, "rsp.results");
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) a17);
            this$0.mLastJumpSeq = ((ds) first2).getMsgSeq();
            return;
        }
        if (this$0.mLastJumpSeq == -1) {
            i16 = 2;
        }
        this$0.updateUI(new GuildAioUserAvatarUIState.JumpToSelfMsgState(i16));
        if (this$0.mLastJumpSeq != -1) {
            ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(new GuildMsgNavigateEvent.GuildNavigateToAIOBottomEvent("GuildAioUserAvatarViewModel"));
        }
        this$0.mLastJumpSeq = -1L;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            m();
            return;
        }
        if (intent instanceof a.C1180a) {
            AIOContact aIOContact = this.mContact;
            if (aIOContact == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContact");
                aIOContact = null;
            }
            updateUI(new GuildAioUserAvatarUIState.UpdateAvatarState(aIOContact.f()));
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        this.mContact = context.g().r().c();
    }
}
