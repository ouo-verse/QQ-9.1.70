package com.tencent.mobileqq.guild.message.directmessage.model.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.DirectSessionInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000\u00a8\u0006\u0005"}, d2 = {"", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/DirectSessionInfo;", "Lkotlin/sequences/Sequence;", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DirectMessageNodeKt {
    @NotNull
    public static final Sequence<DirectMessageNode> a(@NotNull List<DirectSessionInfo> list) {
        Sequence asSequence;
        Sequence<DirectMessageNode> map;
        Intrinsics.checkNotNullParameter(list, "<this>");
        asSequence = CollectionsKt___CollectionsKt.asSequence(list);
        map = SequencesKt___SequencesKt.map(asSequence, new Function1<DirectSessionInfo, DirectMessageNode>() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNodeKt$toDirectMessageNodes$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final DirectMessageNode invoke(@NotNull DirectSessionInfo node) {
                Intrinsics.checkNotNullParameter(node, "node");
                return DirectMessageNode.INSTANCE.d(node);
            }
        });
        return map;
    }
}
