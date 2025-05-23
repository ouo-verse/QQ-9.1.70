package com.tencent.mobileqq.aio.msglist.msgrepo;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.data.DataBufferUtils;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u001f\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u001e\u0010\u000e\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J(\u0010\u0011\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/a;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "", "chatType", "", "o", "", "Lcom/tencent/aio/data/msglist/a;", "list", "", "p", "", "source", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/os/Bundle;", "extra", "b", "k", "i", "Ljava/lang/Boolean;", "chainSwitch", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "lastChainMsgSeq", BdhLogUtil.LogTag.Tag_Conn, "lastChainSurpriseMsgSeq", "D", "Z", "lastChainMsgSeqChanged", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", "lastChainMsgSeqMMKVKey", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "msgRepo", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "E", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a extends g<BaseMsgRepo> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long lastChainSurpriseMsgSeq;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean lastChainMsgSeqChanged;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean chainSwitch;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long lastChainMsgSeq;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/a$a;", "", "", "CHAIN_SWITCH_FREESIA_CONFIG_ID", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.msgrepo.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64127);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull AIOMsgRepo msgRepo, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(msgRepo, aioContext, scope);
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgRepo, aioContext, scope);
        }
    }

    private final String n() {
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        if (su3.c.a(g16) > 0) {
            AIOParam g17 = d().g();
            Intrinsics.checkNotNullExpressionValue(g17, "aioContext.aioParam");
            return "chain_sticker_seq_" + su3.c.a(g17);
        }
        return "chain_sticker_seq_" + d().g().r().c().j();
    }

    private final boolean o(int chatType) {
        if (chatType == 2 || chatType == 1) {
            return true;
        }
        return false;
    }

    private final void p(List<com.tencent.aio.data.msglist.a> list) {
        boolean z16;
        int i3;
        Object last;
        String str;
        boolean z17;
        boolean z18;
        ListIterator<com.tencent.aio.data.msglist.a> listIterator = list.listIterator(list.size());
        while (true) {
            z16 = false;
            if (listIterator.hasPrevious()) {
                com.tencent.aio.data.msglist.a previous = listIterator.previous();
                if ((previous instanceof com.tencent.mobileqq.aio.msg.e) && o(((com.tencent.mobileqq.aio.msg.e) previous).p0())) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    i3 = listIterator.nextIndex();
                    break;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        int i16 = 0;
        for (Object obj : list) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj;
            if (aVar instanceof com.tencent.mobileqq.aio.msg.e) {
                if (i16 < i3) {
                    com.tencent.mobileqq.aio.msg.e eVar = (com.tencent.mobileqq.aio.msg.e) aVar;
                    if (eVar.I2()) {
                        AIOMsgItem cloneNewInstance = eVar.cloneNewInstance();
                        Intrinsics.checkNotNull(cloneNewInstance, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.ChainAniStickerMsgItem");
                        com.tencent.mobileqq.aio.msg.e eVar2 = (com.tencent.mobileqq.aio.msg.e) cloneNewInstance;
                        eVar2.M2(z16);
                        if (QLog.isDevelopLevel()) {
                            QLog.i("ChainAniStickerAbility", 4, "[updateChainShowIcon]: showChainIcon false, msgId is " + eVar2.getMsgId() + " hash is " + eVar2.hashCode());
                        }
                        Unit unit = Unit.INSTANCE;
                        list.set(i16, eVar2);
                    }
                }
                if (i16 == i3) {
                    com.tencent.mobileqq.aio.msg.e eVar3 = (com.tencent.mobileqq.aio.msg.e) aVar;
                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
                    eVar3.L2(((com.tencent.aio.data.msglist.a) last).getMsgSeq());
                    if (!QLog.isDevelopLevel()) {
                        str = "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.ChainAniStickerMsgItem";
                    } else {
                        str = "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.ChainAniStickerMsgItem";
                        QLog.d("ChainAniStickerAbility", 2, "[updateChainShowIcon] lastChainIndex=" + i3, ", lastChainMsgSeq=" + this.lastChainMsgSeq + ", lastMsgSeq=" + eVar3.getLastMsgSeq(), ", msgChatType=" + eVar3.p0());
                    }
                    if (!eVar3.I2()) {
                        if (this.lastChainMsgSeq <= 0) {
                            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
                            this.lastChainMsgSeq = from.decodeLong(n(), 0L);
                        }
                        long j3 = eVar3.getMsgRecord().msgSeq;
                        if (j3 < this.lastChainMsgSeq) {
                            return;
                        }
                        if (j3 > i3) {
                            this.lastChainMsgSeq = j3;
                            z17 = true;
                            this.lastChainMsgSeqChanged = true;
                        } else {
                            z17 = true;
                        }
                        AIOMsgItem cloneNewInstance2 = eVar3.cloneNewInstance();
                        Intrinsics.checkNotNull(cloneNewInstance2, str);
                        com.tencent.mobileqq.aio.msg.e eVar4 = (com.tencent.mobileqq.aio.msg.e) cloneNewInstance2;
                        eVar4.M2(z17);
                        if (QLog.isDevelopLevel()) {
                            QLog.i("ChainAniStickerAbility", 4, "[updateChainShowIcon]: showChainIcon true, msgId=" + eVar4.getMsgId() + ", msgSeq=" + eVar4.getMsgSeq() + ", hashCode=" + aVar.hashCode());
                        }
                        Unit unit2 = Unit.INSTANCE;
                        list.set(i16, eVar4);
                        i16 = i17;
                        z16 = false;
                    }
                }
            }
            i16 = i17;
            z16 = false;
        }
    }

    private final void q(List<com.tencent.aio.data.msglist.a> list, String source) {
        Object obj = null;
        for (Object obj2 : list) {
            if (obj2 instanceof com.tencent.mobileqq.aio.msg.e) {
                if (Intrinsics.areEqual(source, "send_msg")) {
                    com.tencent.mobileqq.aio.msg.e eVar = (com.tencent.mobileqq.aio.msg.e) obj2;
                    if (eVar.getMsgRecord().msgSeq > this.lastChainSurpriseMsgSeq) {
                        eVar.K2(true);
                    }
                } else if (!TextUtils.isEmpty(((com.tencent.mobileqq.aio.msg.e) obj2).t2())) {
                    com.tencent.mobileqq.aio.msg.e eVar2 = (com.tencent.mobileqq.aio.msg.e) obj;
                    if (eVar2 != null) {
                        eVar2.D2();
                    }
                    obj = obj2;
                }
            }
        }
        com.tencent.mobileqq.aio.msg.e eVar3 = (com.tencent.mobileqq.aio.msg.e) obj;
        if (eVar3 != null) {
            eVar3.K2(true);
            this.lastChainSurpriseMsgSeq = eVar3.getMsgRecord().msgSeq;
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void b(@NotNull List<com.tencent.aio.data.msglist.a> list, @NotNull String source, @Nullable Bundle extra) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, list, source, extra);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(source, "source");
        if (!o(d().g().r().c().e())) {
            return;
        }
        if (this.chainSwitch == null) {
            this.chainSwitch = Boolean.valueOf(FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("101797", AIOUtil.f194084a.t()));
            if (QLog.isColorLevel()) {
                QLog.d("ChainAniStickerAbility", 2, "[beforeNotifyMsgChange]: chainSwitch=" + this.chainSwitch);
            }
        }
        if (!Intrinsics.areEqual(this.chainSwitch, Boolean.TRUE)) {
            return;
        }
        if (!source.equals("get_last_db") && !source.equals("handle_first_page") && !source.equals("send_msg") && !source.equals("receive_msg") && !source.equals("msg_update") && !source.equals("delete_msg") && !source.equals(DataBufferUtils.NEXT_PAGE)) {
            if (QLog.isDevelopLevel()) {
                QLog.i("ChainAniStickerAbility", 4, "[beforeNotifyMsgChange]: other source=" + source);
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("ChainAniStickerAbility", 4, "[beforeNotifyMsgChange]: from is " + source);
        }
        p(list);
        if (source.equals("get_last_db") || source.equals("handle_first_page") || source.equals("send_msg") || source.equals("receive_msg") || source.equals("msg_update")) {
            q(list, source);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.k();
        if (this.lastChainMsgSeqChanged) {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            from.encodeLong(n(), this.lastChainMsgSeq);
            this.lastChainMsgSeqChanged = false;
        }
    }
}
