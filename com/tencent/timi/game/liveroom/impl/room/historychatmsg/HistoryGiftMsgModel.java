package com.tencent.timi.game.liveroom.impl.room.historychatmsg;

import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.historychatmsg.HistoryGiftMsgModel;
import com.tencent.timi.game.sso.request.QQLiveGetGiftRecordRequest;
import d55.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u0012\u0016B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0004R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/HistoryGiftMsgModel;", "", "", "programId", "", "f", "Ld55/c;", "response", "g", "Ld55/l;", "giftInfo", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "e", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/HistoryGiftMsgModel$b;", "callback", h.F, "i", "", "a", "Ljava/util/List;", "chatMsgList", "", "b", "comboSeqList", "c", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/HistoryGiftMsgModel$b;", "<init>", "()V", "d", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class HistoryGiftMsgModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GiftMessage> chatMsgList = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Long> comboSeqList = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/HistoryGiftMsgModel$b;", "", "", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "historyList", "", "historyComboSeqList", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a(@NotNull List<? extends GiftMessage> historyList, @NotNull List<Long> historyComboSeqList);
    }

    private final GiftMessage e(l giftInfo) {
        GiftMessage giftMessage = new GiftMessage();
        giftMessage.giftID = giftInfo.f393098a;
        giftMessage.giftNum = giftInfo.f393100c;
        giftMessage.giftPrice = giftInfo.f393102e;
        giftMessage.giftName = giftInfo.f393099b;
        giftMessage.comboSeq = giftInfo.f393113p;
        giftMessage.comboOver = true;
        giftMessage.allComboCnt = giftInfo.f393101d;
        giftMessage.batchSendCnt = giftInfo.f393108k;
        giftMessage.materialID = (int) giftInfo.f393111n;
        giftMessage.sender = giftInfo.f393104g;
        giftMessage.senderHead = giftInfo.f393106i;
        giftMessage.senderNick = giftInfo.f393105h;
        return giftMessage;
    }

    private final void f(String programId) {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveGetGiftRecordRequest(programId), new Function1<QQLiveResponse<d55.c>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.historychatmsg.HistoryGiftMsgModel$fetchHistoryGiftMsgList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<d55.c> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<d55.c> rsp) {
                HistoryGiftMsgModel.b bVar;
                List<? extends GiftMessage> list;
                List<Long> list2;
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                AegisLogger.INSTANCE.i("Audience|HistoryGiftMsgModel", "fetchHistoryGiftMsgList", "isSuccess=" + rsp.isSuccess() + ", retCode=" + rsp.getRetCode() + ", errMsg=" + rsp.getErrMsg());
                d55.c rsp2 = rsp.getRsp();
                if (!rsp.isFailed() && rsp2 != null) {
                    l[] lVarArr = rsp2.f393064d;
                    boolean z16 = true;
                    if (lVarArr != null) {
                        if (!(lVarArr.length == 0)) {
                            z16 = false;
                        }
                    }
                    if (!z16) {
                        HistoryGiftMsgModel.this.g(rsp2);
                        return;
                    }
                }
                bVar = HistoryGiftMsgModel.this.callback;
                if (bVar != null) {
                    list = HistoryGiftMsgModel.this.chatMsgList;
                    list2 = HistoryGiftMsgModel.this.comboSeqList;
                    bVar.a(list, list2);
                }
                HistoryGiftMsgModel.this.g(rsp2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(d55.c response) {
        Integer num;
        l[] lVarArr;
        this.chatMsgList.clear();
        this.comboSeqList.clear();
        if (response != null && (lVarArr = response.f393064d) != null) {
            for (l it : lVarArr) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                GiftMessage e16 = e(it);
                this.chatMsgList.add(e16);
                this.comboSeqList.add(Long.valueOf(e16.comboSeq));
            }
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        int size = this.chatMsgList.size();
        if (response != null) {
            num = Integer.valueOf(response.f393061a);
        } else {
            num = null;
        }
        companion.i("Audience|HistoryGiftMsgModel", "msgSize:" + size + ", sentGiftCnt:" + num);
        b bVar = this.callback;
        if (bVar != null) {
            bVar.a(this.chatMsgList, this.comboSeqList);
        }
    }

    public final void h(@NotNull String programId, @NotNull b callback) {
        Intrinsics.checkNotNullParameter(programId, "programId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        f(programId);
    }

    public final void i() {
        this.chatMsgList.clear();
        this.comboSeqList.clear();
    }
}
