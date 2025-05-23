package com.tencent.timi.game.liveroom.impl.room.historychatmsg;

import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.historychatmsg.HistoryChatMsgModel;
import com.tencent.timi.game.sso.request.QQLiveGetHistoryWordsRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ur4.h;
import ur4.i;
import ur4.l;
import ur4.q;
import ur4.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0013\u0016B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/HistoryChatMsgModel;", "", "", "roomId", "", "platform", "", "e", "Lur4/h;", "response", "f", "Lur4/a;", "broadCastMsg", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "d", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/HistoryChatMsgModel$b;", "callback", "g", "", "a", "Ljava/util/List;", "chatMsgList", "b", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/HistoryChatMsgModel$b;", "<init>", "()V", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class HistoryChatMsgModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<LiveMessageData> chatMsgList = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/HistoryChatMsgModel$b;", "", "", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "historyList", "", "singleMsgInterval", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a(@NotNull List<? extends LiveMessageData> historyList, int singleMsgInterval);
    }

    private final LiveMessageData d(ur4.a broadCastMsg) {
        LiveMessageData liveMessageData = new LiveMessageData();
        liveMessageData.mMessageType = 1;
        LiveMessageData.SpeakerInfo speakerInfo = new LiveMessageData.SpeakerInfo();
        Intrinsics.checkNotNull(broadCastMsg);
        s sVar = broadCastMsg.f439885a;
        speakerInfo.mSpeakId = sVar.f439954a;
        speakerInfo.mSpeakerName = sVar.f439955b;
        speakerInfo.mLogo = sVar.f439956c;
        speakerInfo.mQunNick = sVar.f439957d;
        speakerInfo.mBusinessUid = sVar.f439958e;
        speakerInfo.mClientType = broadCastMsg.f439887c;
        liveMessageData.mSpeakerInfo = speakerInfo;
        ArrayList<LiveMessageData.MsgElement> arrayList = new ArrayList<>();
        ArrayList<LiveMessageData.ExtData> arrayList2 = new ArrayList<>();
        l[] lVarArr = broadCastMsg.f439886b.f439925a;
        Intrinsics.checkNotNullExpressionValue(lVarArr, "broadCastMsg.msgContent.msgElements");
        for (l lVar : lVarArr) {
            LiveMessageData.MsgElement msgElement = new LiveMessageData.MsgElement();
            LiveMessageData.TextElement textElement = new LiveMessageData.TextElement();
            LiveMessageData.ImageElement imageElement = new LiveMessageData.ImageElement();
            q qVar = lVar.f439930b;
            if (qVar != null) {
                byte[] bArr = qVar.f439951a;
                textElement.mText = bArr;
                try {
                    Intrinsics.checkNotNullExpressionValue(bArr, "msgElement.textElem.text");
                    String str = new String(bArr, Charsets.UTF_16LE);
                    textElement.strText = str;
                    AegisLogger.INSTANCE.i("Audience|HistoryChatMsgModel", "get chat message" + str);
                } catch (UnsupportedEncodingException e16) {
                    AegisLogger.INSTANCE.e("Audience|HistoryChatMsgModel", "get chat message error", "e:" + e16);
                    textElement.strText = "";
                }
            }
            i iVar = lVar.f439931c;
            if (iVar != null) {
                imageElement.mImageUrl = iVar.f439921a;
            }
            msgElement.mElementType = lVar.f439929a;
            msgElement.mHideLogo = lVar.f439932d;
            msgElement.mTextMsg = textElement;
            msgElement.mImageMsg = imageElement;
            arrayList.add(msgElement);
        }
        ur4.c[] cVarArr = broadCastMsg.f439886b.f439926b;
        Intrinsics.checkNotNullExpressionValue(cVarArr, "broadCastMsg.msgContent.extData");
        for (ur4.c cVar : cVarArr) {
            LiveMessageData.ExtData extData = new LiveMessageData.ExtData();
            extData.mId = cVar.f439903a;
            extData.mValue = cVar.f439904b;
            arrayList2.add(extData);
        }
        LiveMessageData.MsgContent msgContent = new LiveMessageData.MsgContent();
        msgContent.mMsgElements = arrayList;
        msgContent.mExtDatas = arrayList2;
        liveMessageData.msgContent = msgContent;
        return liveMessageData;
    }

    private final void e(long roomId, String platform) {
        if (Intrinsics.areEqual("huya", platform)) {
            AegisLogger.INSTANCE.i("Audience|HistoryChatMsgModel", "fetchHistoryChatMsgList", "roomId:" + roomId + " is huya room");
            f(null);
            return;
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveGetHistoryWordsRequest(roomId), new Function1<QQLiveResponse<h>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.historychatmsg.HistoryChatMsgModel$fetchHistoryChatMsgList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<h> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<h> rsp) {
                HistoryChatMsgModel.b bVar;
                List<? extends LiveMessageData> list;
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                AegisLogger.INSTANCE.i("Audience|HistoryChatMsgModel", "fetchHistoryChatMsgList", "isSuccess=" + rsp.isSuccess() + ", retCode=" + rsp.getRetCode() + ", errMsg=" + rsp.getErrMsg());
                h rsp2 = rsp.getRsp();
                if (!rsp.isFailed() && rsp2 != null) {
                    ur4.a[] aVarArr = rsp2.f439918a;
                    boolean z16 = true;
                    if (aVarArr != null) {
                        if (!(aVarArr.length == 0)) {
                            z16 = false;
                        }
                    }
                    if (!z16) {
                        HistoryChatMsgModel.this.f(rsp2);
                        return;
                    }
                }
                bVar = HistoryChatMsgModel.this.callback;
                if (bVar != null) {
                    list = HistoryChatMsgModel.this.chatMsgList;
                    bVar.a(list, rsp2 != null ? rsp2.f439920c : 0);
                }
                HistoryChatMsgModel.this.f(rsp2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(h response) {
        Integer num;
        ur4.a[] aVarArr;
        this.chatMsgList.clear();
        int i3 = 0;
        if (response != null && (aVarArr = response.f439918a) != null) {
            for (ur4.a aVar : aVarArr) {
                this.chatMsgList.add(d(aVar));
            }
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        int size = this.chatMsgList.size();
        Integer num2 = null;
        if (response != null) {
            num = Integer.valueOf(response.f439919b);
        } else {
            num = null;
        }
        if (response != null) {
            num2 = Integer.valueOf(response.f439920c);
        }
        companion.i("Audience|HistoryChatMsgModel", "msgSize:" + size + ", allTime:" + num + ", singleTime:" + num2);
        b bVar = this.callback;
        if (bVar != null) {
            List<LiveMessageData> list = this.chatMsgList;
            if (response != null) {
                i3 = response.f439920c;
            }
            bVar.a(list, i3);
        }
    }

    public final void g(long roomId, @Nullable String platform, @NotNull b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        e(roomId, platform);
    }
}
