package com.qzone.reborn.groupalbum.selectmedia.data.datasource;

import com.qzone.reborn.groupalbum.selectmedia.data.model.SearchMediaItemModel;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J6\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\r0\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007JN\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\r0\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/data/datasource/PlatformSearchMediaSource;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "input", "", "Lcom/qzone/reborn/groupalbum/selectmedia/data/model/SearchMediaItemModel;", "d", "", "chatType", "", "peerUid", "pageCount", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Pair;", "b", "", "msgId", "msgTime", "msgSeq", "requestCount", "c", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class PlatformSearchMediaSource {
    /* JADX INFO: Access modifiers changed from: private */
    public final List<SearchMediaItemModel> d(MsgRecord input) {
        Sequence asSequence;
        Sequence<MsgElement> filterNot;
        ArrayList arrayList = new ArrayList();
        ArrayList<MsgElement> arrayList2 = input.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "input.elements");
        asSequence = CollectionsKt___CollectionsKt.asSequence(arrayList2);
        filterNot = SequencesKt___SequencesKt.filterNot(asSequence, new Function1<MsgElement, Boolean>() { // from class: com.qzone.reborn.groupalbum.selectmedia.data.datasource.PlatformSearchMediaSource$wrapMsgRecord2SearchMediaModel$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(MsgElement msgElement) {
                PicElement picElement = msgElement.picElement;
                return Boolean.valueOf(picElement != null ? Intrinsics.areEqual(picElement.isFlashPic, Boolean.TRUE) : false);
            }
        });
        for (MsgElement it : filterNot) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            SearchMediaItemModel searchMediaItemModel = new SearchMediaItemModel(input, it);
            if (searchMediaItemModel.r() || searchMediaItemModel.p()) {
                if (searchMediaItemModel.q()) {
                    arrayList.add(searchMediaItemModel);
                }
            }
        }
        return arrayList;
    }

    public final Flow<Pair<Integer, List<SearchMediaItemModel>>> b(int chatType, String peerUid, int pageCount) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        return FlowKt.callbackFlow(new PlatformSearchMediaSource$getMediaList$1(chatType, peerUid, pageCount, this, null));
    }

    public final Flow<Pair<Integer, List<SearchMediaItemModel>>> c(int chatType, String peerUid, long msgId, long msgTime, long msgSeq, int requestCount) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        return FlowKt.callbackFlow(new PlatformSearchMediaSource$getMoreMediaList$1(msgId, msgTime, msgSeq, chatType, peerUid, requestCount, this, null));
    }
}
