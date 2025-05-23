package com.tencent.state.publicchat.component;

import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.service.VasChatReadService;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B6\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012'\u0010\u0004\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001e\u0010\u0014\u001a\u00020\u000b2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u0016R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R/\u0010\u0004\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/publicchat/component/MsgSequenceLoader;", "", "appId", "", "onLoaded", "Lkotlin/Function1;", "", "Lcom/tencent/state/publicchat/data/MsgInfo;", "Lkotlin/ParameterName;", "name", "msgs", "", "(ILkotlin/jvm/functions/Function1;)V", "_seq", "cache", "", "Lcom/tencent/state/publicchat/component/MsgsWithSequence;", "waitingSeq", "handleLoaded", "seq", "load", "msgIds", "", "roomId", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MsgSequenceLoader {
    private static final String TAG = "MsgSequenceLoader";
    private int _seq;
    private final int appId;
    private List<MsgsWithSequence> cache;
    private final Function1<List<MsgInfo>, Unit> onLoaded;
    private int waitingSeq;

    /* JADX WARN: Multi-variable type inference failed */
    public MsgSequenceLoader(int i3, Function1<? super List<MsgInfo>, Unit> onLoaded) {
        Intrinsics.checkNotNullParameter(onLoaded, "onLoaded");
        this.appId = i3;
        this.onLoaded = onLoaded;
        this.cache = new ArrayList();
    }

    public final synchronized void handleLoaded(int seq, List<MsgInfo> msgs) {
        Object obj;
        Intrinsics.checkNotNullParameter(msgs, "msgs");
        SquareBaseKt.getSquareLog().d(TAG, this.appId + " handleLoaded seq=" + seq + ", waitingSeq=" + this.waitingSeq);
        int i3 = this.waitingSeq;
        if (seq == i3) {
            this.waitingSeq = i3 + 1;
            this.onLoaded.invoke(msgs);
        } else {
            this.cache.add(new MsgsWithSequence(seq, msgs));
        }
        if (this.cache.size() > 0) {
            Iterator<T> it = this.cache.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((MsgsWithSequence) obj).getSeq() == this.waitingSeq) {
                        break;
                    }
                }
            }
            MsgsWithSequence msgsWithSequence = (MsgsWithSequence) obj;
            if (msgsWithSequence != null) {
                this.cache.remove(msgsWithSequence);
                handleLoaded(msgsWithSequence.getSeq(), msgsWithSequence.getMsgs());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void load(List<Long> msgIds, long roomId) {
        List<Long> list = msgIds;
        if (list == null || list.isEmpty()) {
            return;
        }
        final int i3 = this._seq;
        this._seq = i3 + 1;
        SquareBaseKt.getSquareLog().d(TAG, this.appId + " load seq=" + i3 + ", waitingSeq=" + this.waitingSeq);
        VasChatReadService.INSTANCE.batchGetMsgInfos(this.appId, msgIds, roomId, new ResultCallback<List<? extends MsgInfo>>() { // from class: com.tencent.state.publicchat.component.MsgSequenceLoader$load$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i16, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i16, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public /* bridge */ /* synthetic */ void onResultSuccess(List<? extends MsgInfo> list2) {
                onResultSuccess2((List<MsgInfo>) list2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                int i16;
                List<MsgInfo> emptyList;
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                i16 = MsgSequenceLoader.this.appId;
                sb5.append(i16);
                sb5.append(" batchGetMsgInfos failed ");
                sb5.append(error);
                sb5.append(TokenParser.SP);
                sb5.append(message);
                SquareLogger.DefaultImpls.e$default(squareLog, "MsgSequenceLoader", sb5.toString(), null, 4, null);
                MsgSequenceLoader msgSequenceLoader = MsgSequenceLoader.this;
                int i17 = i3;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                msgSequenceLoader.handleLoaded(i17, emptyList);
            }

            /* renamed from: onResultSuccess, reason: avoid collision after fix types in other method */
            public void onResultSuccess2(List<MsgInfo> result) {
                int i16;
                Intrinsics.checkNotNullParameter(result, "result");
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                i16 = MsgSequenceLoader.this.appId;
                sb5.append(i16);
                sb5.append(" batchGetMsgInfos success ");
                sb5.append(result);
                squareLog.i("MsgSequenceLoader", sb5.toString());
                MsgSequenceLoader.this.handleLoaded(i3, result);
            }
        });
    }
}
