package com.tencent.qqnt.chathistory.ui.troopMember.history.data.datasource;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.ui.base.j;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.kernel.nativeinterface.QueriedMsgInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002JX\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\nR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/datasource/PlatformTroopMemberHistorySource;", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/QueriedMsgInfo;", "data", "", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/model/a;", "d", "", "peerId", "", "chatType", "sendIds", "", "msgId", "msgTime", "msgSeq", "cnt", "Lkotlinx/coroutines/flow/Flow;", "b", "a", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/model/a;", "lastModel", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class PlatformTroopMemberHistorySource {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f353962b;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a lastModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/datasource/PlatformTroopMemberHistorySource$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51565);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f353962b = new a(null);
        }
    }

    public PlatformTroopMemberHistorySource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ Flow c(PlatformTroopMemberHistorySource platformTroopMemberHistorySource, String str, int i3, List list, long j3, long j16, long j17, int i16, int i17, Object obj) {
        long j18;
        long j19;
        long j26;
        int i18;
        if ((i17 & 8) != 0) {
            j18 = 0;
        } else {
            j18 = j3;
        }
        if ((i17 & 16) != 0) {
            j19 = 0;
        } else {
            j19 = j16;
        }
        if ((i17 & 32) != 0) {
            j26 = 0;
        } else {
            j26 = j17;
        }
        if ((i17 & 64) != 0) {
            i18 = 15;
        } else {
            i18 = i16;
        }
        return platformTroopMemberHistorySource.b(str, i3, list, j18, j19, j26, i18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a> d(ArrayList<QueriedMsgInfo> data) {
        int collectionSizeOrDefault;
        String str;
        d.f354054a.a("PlatformTroopMemberHistorySource", "wrapData data " + data);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(data, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = data.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a aVar = new com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a((QueriedMsgInfo) it.next());
            aVar.l(j.g(aVar, this.lastModel));
            if (aVar.c()) {
                String i3 = aVar.i();
                com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a aVar2 = this.lastModel;
                if (aVar2 != null) {
                    str = aVar2.i();
                } else {
                    str = null;
                }
                aVar.l(Intrinsics.areEqual(i3, str));
            }
            this.lastModel = aVar;
            arrayList.add(aVar);
        }
        return arrayList;
    }

    @NotNull
    public final Flow<List<com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a>> b(@NotNull String peerId, int chatType, @NotNull List<String> sendIds, long msgId, long msgTime, long msgSeq, int cnt) {
        List emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Flow) iPatchRedirector.redirect((short) 2, this, peerId, Integer.valueOf(chatType), sendIds, Long.valueOf(msgId), Long.valueOf(msgTime), Long.valueOf(msgSeq), Integer.valueOf(cnt));
        }
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        Intrinsics.checkNotNullParameter(sendIds, "sendIds");
        d dVar = d.f354054a;
        dVar.a("PlatformTroopMemberHistorySource", "getMemberHistoryFlow  peerId " + peerId + " chatType " + chatType + "  sendIds  " + sendIds + " msgId " + msgId + ", msgTime  " + msgTime + "  cnt  " + cnt);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        dVar.a("KernelService", "getMsgsAndAbstractsWithFilter chatType " + chatType + "  peerId " + peerId + " msgTime " + msgTime + ", msgSeq " + msgSeq + ", cnt 20 filterSendUids " + sendIds + ", filterStartTime 0filterEndTime 0");
        return FlowKt.callbackFlow(new PlatformTroopMemberHistorySource$getMemberHistoryFlow$$inlined$getMsgsAndAbstractsWithFilter$default$1(msgId, msgTime, msgSeq, chatType, peerId, emptyList, sendIds, 0L, 0L, 20, null, this));
    }
}
