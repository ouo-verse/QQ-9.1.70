package com.tencent.qqnt.chathistory.ui.shortvideo.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel;
import com.tencent.qqnt.chathistory.ui.shortvideo.data.source.ChatHistoryShortVideoSource;
import ew3.a;
import ew3.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/shortvideo/viewmodel/ChatHistoryShortVideoViewModel;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "Lew3/a;", "Lew3/b;", "", "requestCount", "", "X1", "", "msgId", "msgTime", "msgSeq", "Z1", "userIntent", "W1", "Lcom/tencent/qqnt/chathistory/ui/shortvideo/data/source/ChatHistoryShortVideoSource;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "T1", "()Lcom/tencent/qqnt/chathistory/ui/shortvideo/data/source/ChatHistoryShortVideoSource;", "mDataSource", "U1", "()Lew3/b;", "mNoneValueIntent", "<init>", "()V", "G", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryShortVideoViewModel extends BaseHistoryViewModel<a, b> {

    @NotNull
    private static final String H = "QCHV-ChatHistoryShortVideoViewModel";

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDataSource;

    public ChatHistoryShortVideoViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ChatHistoryShortVideoSource>() { // from class: com.tencent.qqnt.chathistory.ui.shortvideo.viewmodel.ChatHistoryShortVideoViewModel$mDataSource$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ChatHistoryShortVideoSource invoke() {
                return new ChatHistoryShortVideoSource();
            }
        });
        this.mDataSource = lazy;
    }

    private final ChatHistoryShortVideoSource T1() {
        return (ChatHistoryShortVideoSource) this.mDataSource.getValue();
    }

    private final void X1(int requestCount) {
        FlowKt.launchIn(FlowKt.onEach(T1().c(M1(), N1(), requestCount), new ChatHistoryShortVideoViewModel$loadFirstPageShortVideoList$1(this, requestCount, null)), ViewModelKt.getViewModelScope(this));
    }

    private final void Z1(long msgId, long msgTime, long msgSeq, int requestCount) {
        FlowKt.launchIn(FlowKt.onEach(T1().b(M1(), N1(), msgId, msgTime, msgSeq, requestCount), new ChatHistoryShortVideoViewModel$loadShortVideoMoreList$1(this, requestCount, null)), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public b getMNoneValueIntent() {
        return b.c.f397306a;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: W1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b userIntent) {
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.GetShortVideoList) {
            X1(((b.GetShortVideoList) userIntent).getRequestCount());
        }
        if (userIntent instanceof b.GetMoreShortVideoList) {
            b.GetMoreShortVideoList getMoreShortVideoList = (b.GetMoreShortVideoList) userIntent;
            Z1(getMoreShortVideoList.getMsgId(), getMoreShortVideoList.getMsgTime(), getMoreShortVideoList.getMsgSeq(), getMoreShortVideoList.getRequestCount());
        }
    }
}
