package com.tencent.mobileqq.qqlive.anchor.live.gift;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.room.g;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mt3.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001\rB\u0007\u00a2\u0006\u0004\b\"\u0010#J;\u0010\r\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bJ\u0006\u0010\u000e\u001a\u00020\nJ\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R;\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/gift/a;", "Lcom/tencent/mobileqq/qqlive/callback/gift/ReceiveGiftMessageListener;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "roomId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "Lkotlin/ParameterName;", "name", "msg", "", "Lcom/tencent/mobileqq/qqlive/anchor/live/gift/GiftPushMessageReceiver;", "receiver", "a", "b", "giftMessage", "onGiftMessageReceive", "", "code", "", "onError", "Lfp4/c;", "msgInfo", "onPush", "d", "Lkotlin/jvm/functions/Function1;", "Lcom/tencent/mobileqq/qqlive/sail/room/f;", "e", "Lcom/tencent/mobileqq/qqlive/sail/room/f;", "getRoom", "()Lcom/tencent/mobileqq/qqlive/sail/room/f;", "setRoom", "(Lcom/tencent/mobileqq/qqlive/sail/room/f;)V", "room", "<init>", "()V", "f", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a implements ReceiveGiftMessageListener, g {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super GiftMessage, Unit> receiver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f room;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/gift/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.live.gift.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19039);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(long roomId, @Nullable Function1<? super GiftMessage, Unit> receiver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(roomId), receiver);
            return;
        }
        this.receiver = receiver;
        f y16 = c.f272176a.y(roomId, 0);
        this.room = y16;
        if (y16 != null) {
            y16.p(167, this);
        }
        f fVar = this.room;
        if (fVar != null) {
            fVar.p(235, this);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.receiver = null;
        f fVar = this.room;
        if (fVar != null) {
            fVar.e(this);
        }
        this.room = null;
    }

    @Override // com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener
    public void onError(int code, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, code, (Object) msg2);
            return;
        }
        AegisLogger.INSTANCE.w("Open_Live|AnchorGiftPushMgr", "onError", "code=" + code + ", msg=" + msg2);
    }

    @Override // com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener
    public void onGiftMessageReceive(@Nullable GiftMessage giftMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) giftMessage);
            return;
        }
        Function1<? super GiftMessage, Unit> function1 = this.receiver;
        if (function1 != null) {
            function1.invoke(giftMessage);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        e m3 = com.tencent.mobileqq.qqlive.sail.push.a.m(msgInfo);
        if (m3 != null) {
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.d("Open_Live|AnchorGiftPushMgr", "onPush", "receive gift, name=" + m3.f417552c + ", num=" + m3.f417553d);
            }
            GiftMessage giftMessage = new GiftMessage();
            giftMessage.giftID = m3.f417551b;
            giftMessage.giftNum = m3.f417553d;
            giftMessage.giftType = m3.f417550a;
            giftMessage.materialID = m3.f417556g;
            giftMessage.sender = m3.f417554e;
            giftMessage.senderNick = m3.f417555f;
            giftMessage.effectLevel = m3.f417557h;
            giftMessage.giftName = m3.f417552c;
            giftMessage.senderHead = m3.f417558i;
            giftMessage.receiverNick = m3.f417559j;
            giftMessage.receiverHead = m3.f417560k;
            giftMessage.comboSeq = m3.f417561l;
            giftMessage.allComboCnt = m3.f417562m;
            giftMessage.comboOver = m3.f417563n;
            giftMessage.liveExtMsg = m3.f417564o;
            giftMessage.receiver = m3.f417565p;
            giftMessage.giftPrice = m3.f417566q;
            giftMessage.batchSendCnt = m3.f417567r;
            Function1<? super GiftMessage, Unit> function1 = this.receiver;
            if (function1 != null) {
                function1.invoke(giftMessage);
            }
        }
    }
}
