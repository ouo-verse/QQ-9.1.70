package com.tencent.qqnt.chathistory.ui.sticker.data.datasource;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.ui.sticker.data.model.SearchStickerItemModel;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J3\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJK\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/sticker/data/datasource/PlatformSearchStickerSource;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "input", "", "chatType", "", "peerId", "", "Lcom/tencent/qqnt/chathistory/ui/sticker/data/model/SearchStickerItemModel;", "d", "requestCount", "Lkotlinx/coroutines/flow/Flow;", "b", "(ILjava/lang/String;I)Lkotlinx/coroutines/flow/Flow;", "", "msgId", "msgTime", "msgSeq", "c", "(ILjava/lang/String;JJJI)Lkotlinx/coroutines/flow/Flow;", "<init>", "()V", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class PlatformSearchStickerSource {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/sticker/data/datasource/PlatformSearchStickerSource$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.sticker.data.datasource.PlatformSearchStickerSource$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50372);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PlatformSearchStickerSource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SearchStickerItemModel> d(MsgRecord input, int chatType, String peerId) {
        Sequence asSequence;
        Sequence<MsgElement> filterNot;
        ArrayList arrayList = new ArrayList();
        ArrayList<MsgElement> arrayList2 = input.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "input.elements");
        asSequence = CollectionsKt___CollectionsKt.asSequence(arrayList2);
        filterNot = SequencesKt___SequencesKt.filterNot(asSequence, PlatformSearchStickerSource$wrapMsgRecord2SearchStickerItemModel$1.INSTANCE);
        for (MsgElement it : filterNot) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            SearchStickerItemModel searchStickerItemModel = new SearchStickerItemModel(input, it, chatType, peerId);
            if (searchStickerItemModel.n()) {
                arrayList.add(searchStickerItemModel);
            }
        }
        return arrayList;
    }

    @NotNull
    public final Flow<List<SearchStickerItemModel>> b(int chatType, @NotNull String peerId, int requestCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Flow) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(chatType), peerId, Integer.valueOf(requestCount));
        }
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        return FlowKt.callbackFlow(new PlatformSearchStickerSource$getStickerData$1(chatType, peerId, requestCount, this, null));
    }

    @NotNull
    public final Flow<List<SearchStickerItemModel>> c(int chatType, @NotNull String peerId, long msgId, long msgTime, long msgSeq, int requestCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Flow) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(chatType), peerId, Long.valueOf(msgId), Long.valueOf(msgTime), Long.valueOf(msgSeq), Integer.valueOf(requestCount));
        }
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        return FlowKt.callbackFlow(new PlatformSearchStickerSource$getStickerMoreData$1(msgId, msgTime, msgSeq, chatType, peerId, requestCount, this, null));
    }
}
