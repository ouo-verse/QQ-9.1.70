package com.tencent.mobileqq.guild.message.directmessage.utils;

import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.utils.a;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\r\u0017\u0018B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\bJ\u0014\u0010\r\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/utils/DiagnosisUtils;", "", "Lcom/tencent/mobileqq/guild/message/directmessage/utils/DiagnosisUtils$UpdateSource;", "updateSource", "", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", "oldNodes", "directMessageNodes", "Lcom/tencent/mobileqq/guild/message/directmessage/utils/a$a;", "unreadResult", "", "b", "deletedNodes", "a", "", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "enable", "<init>", "()V", "NodeChangeState", "UpdateSource", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DiagnosisUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final DiagnosisUtils f230535a = new DiagnosisUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean enable;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/utils/DiagnosisUtils$NodeChangeState;", "", "(Ljava/lang/String;I)V", "NotChange", "Changed", "New", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum NodeChangeState {
        NotChange,
        Changed,
        New
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/utils/DiagnosisUtils$UpdateSource;", "", "(Ljava/lang/String;I)V", "CreateSession", "NtsdkNotifyAllNodes", "NtsdkNotifyPartialNodes", "BlackListChanged", "NotifyTypeChanged", "UIVisibleChanged", "SummaryUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum UpdateSource {
        CreateSession,
        NtsdkNotifyAllNodes,
        NtsdkNotifyPartialNodes,
        BlackListChanged,
        NotifyTypeChanged,
        UIVisibleChanged,
        SummaryUpdated
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/utils/DiagnosisUtils$a;", "", "", "a", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", "b", "()Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", "node", "Lcom/tencent/mobileqq/guild/message/directmessage/utils/DiagnosisUtils$NodeChangeState;", "Lcom/tencent/mobileqq/guild/message/directmessage/utils/DiagnosisUtils$NodeChangeState;", "getChangeState", "()Lcom/tencent/mobileqq/guild/message/directmessage/utils/DiagnosisUtils$NodeChangeState;", "changeState", "<init>", "(Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;Lcom/tencent/mobileqq/guild/message/directmessage/utils/DiagnosisUtils$NodeChangeState;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.message.directmessage.utils.DiagnosisUtils$a, reason: from toString */
    /* loaded from: classes14.dex */
    private static final /* data */ class DiagnosisDirectMessageNode {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final DirectMessageNode node;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final NodeChangeState changeState;

        public DiagnosisDirectMessageNode(@NotNull DirectMessageNode node, @NotNull NodeChangeState changeState) {
            Intrinsics.checkNotNullParameter(node, "node");
            Intrinsics.checkNotNullParameter(changeState, "changeState");
            this.node = node;
            this.changeState = changeState;
        }

        @NotNull
        public final String a() {
            return this.changeState + " - " + this.node.e();
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final DirectMessageNode getNode() {
            return this.node;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DiagnosisDirectMessageNode)) {
                return false;
            }
            DiagnosisDirectMessageNode diagnosisDirectMessageNode = (DiagnosisDirectMessageNode) other;
            if (Intrinsics.areEqual(this.node, diagnosisDirectMessageNode.node) && this.changeState == diagnosisDirectMessageNode.changeState) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.node.hashCode() * 31) + this.changeState.hashCode();
        }

        @NotNull
        public String toString() {
            return "DiagnosisDirectMessageNode(node=" + this.node + ", changeState=" + this.changeState + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((DiagnosisDirectMessageNode) t17).getNode().m()), Long.valueOf(((DiagnosisDirectMessageNode) t16).getNode().m()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((DirectMessageNode) t17).m()), Long.valueOf(((DirectMessageNode) t16).m()));
            return compareValues;
        }
    }

    DiagnosisUtils() {
    }

    public final void a(@NotNull List<DirectMessageNode> deletedNodes) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(deletedNodes, "deletedNodes");
        if (enable && QLog.isColorLevel()) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("logNodesDelete() from =deletedNodes.size = " + deletedNodes.size());
                List<DirectMessageNode> list = deletedNodes;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((DirectMessageNode) it.next()).e());
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, arrayList2);
                arrayList.add("===============================================");
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().d("Guild.C2C.DirectMessage-Diagnosis-Nodes", 2, (String) it5.next());
                }
                return;
            }
            return;
        }
        Logger.f235387a.d().i("Guild.C2C.DirectMessage-Diagnosis", 1, "logNodesDelete() deletedNodes.size = " + deletedNodes.size());
    }

    public final void b(@NotNull UpdateSource updateSource, @NotNull List<DirectMessageNode> oldNodes, @NotNull List<DirectMessageNode> directMessageNodes, @NotNull a.UnreadResult unreadResult) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        int collectionSizeOrDefault2;
        List sortedWith;
        List sortedWith2;
        int collectionSizeOrDefault3;
        int collectionSizeOrDefault4;
        DiagnosisDirectMessageNode diagnosisDirectMessageNode;
        NodeChangeState nodeChangeState;
        Intrinsics.checkNotNullParameter(updateSource, "updateSource");
        Intrinsics.checkNotNullParameter(oldNodes, "oldNodes");
        Intrinsics.checkNotNullParameter(directMessageNodes, "directMessageNodes");
        Intrinsics.checkNotNullParameter(unreadResult, "unreadResult");
        if (enable && QLog.isColorLevel()) {
            List<DirectMessageNode> list = oldNodes;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (Object obj : list) {
                linkedHashMap.put(((DirectMessageNode) obj).getChannelId(), obj);
            }
            List<DirectMessageNode> list2 = directMessageNodes;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
            for (DirectMessageNode directMessageNode : list2) {
                if (linkedHashMap.containsKey(directMessageNode.getChannelId())) {
                    if (!Intrinsics.areEqual(directMessageNode, linkedHashMap.get(directMessageNode.getChannelId()))) {
                        nodeChangeState = NodeChangeState.Changed;
                    } else {
                        nodeChangeState = NodeChangeState.NotChange;
                    }
                    diagnosisDirectMessageNode = new DiagnosisDirectMessageNode(directMessageNode, nodeChangeState);
                } else {
                    diagnosisDirectMessageNode = new DiagnosisDirectMessageNode(directMessageNode, NodeChangeState.New);
                }
                arrayList.add(diagnosisDirectMessageNode);
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new b());
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("logNodesUpdate() from = " + updateSource + " remove.size = " + oldNodes.size() + ", add.size = " + sortedWith.size() + " unread:" + unreadResult);
                sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(oldNodes, new c());
                List list3 = sortedWith2;
                collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
                Iterator it = list3.iterator();
                while (it.hasNext()) {
                    arrayList3.add(((DirectMessageNode) it.next()).e());
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList2, arrayList3);
                arrayList2.add("-----");
                List list4 = sortedWith;
                collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault4);
                Iterator it5 = list4.iterator();
                while (it5.hasNext()) {
                    arrayList4.add(((DiagnosisDirectMessageNode) it5.next()).a());
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList2, arrayList4);
                arrayList2.add("===============================================");
                Iterator it6 = arrayList2.iterator();
                while (it6.hasNext()) {
                    Logger.f235387a.d().d("Guild.C2C.DirectMessage-Diagnosis-Nodes", 2, (String) it6.next());
                }
                return;
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("Guild.C2C.DirectMessage-Diagnosis", 1, "logNodesUpdate() from = " + updateSource + " remove.size = " + oldNodes.size() + ", add.size = " + directMessageNodes.size());
        }
    }
}
