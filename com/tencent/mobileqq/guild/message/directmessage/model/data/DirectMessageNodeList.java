package com.tencent.mobileqq.guild.message.directmessage.model.data;

import android.util.Log;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.guild.message.directmessage.utils.DiagnosisUtils;
import com.tencent.mobileqq.guild.message.directmessage.utils.a;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u001e\u0010\u000f\u001a\u00020\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\r\u001a\u00020\fH\u0007J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0007R0\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0019R$\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\b0\u001bj\b\u0012\u0004\u0012\u00020\b`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010 R\"\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/model/data/DirectMessageNodeList;", "", "", "c", "", "prefix", "d", "channelId", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", "e", "", "newNodes", "Lcom/tencent/mobileqq/guild/message/directmessage/utils/DiagnosisUtils$UpdateSource;", "source", "", "b", "guildId", "g", "<set-?>", "a", "Ljava/util/List;", "f", "()Ljava/util/List;", "nodes", "Lcom/tencent/mobileqq/guild/message/directmessage/utils/a$a;", "Lcom/tencent/mobileqq/guild/message/directmessage/utils/a$a;", "unreadResult", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "directMessageNodes", "", "J", "lastThread", "", "Ljava/util/Map;", "nodesByChannelId", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DirectMessageNodeList {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<DirectMessageNode> nodes;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a.UnreadResult unreadResult;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<DirectMessageNode> directMessageNodes;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long lastThread;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, DirectMessageNode> nodesByChannelId;

    public DirectMessageNodeList() {
        List<DirectMessageNode> emptyList;
        Map<String, DirectMessageNode> emptyMap;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.nodes = emptyList;
        this.unreadResult = new a.UnreadResult(0L, 0L, 3, null);
        this.directMessageNodes = new ArrayList<>();
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.nodesByChannelId = emptyMap;
    }

    private final void c() {
        boolean z16;
        long j3 = this.lastThread;
        if (j3 != 0 && j3 != Thread.currentThread().getId()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.lastThread = Thread.currentThread().getId();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(String prefix) {
        String joinToString$default;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.directMessageNodes, ",", null, null, 0, null, new Function1<DirectMessageNode, CharSequence>() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNodeList$debugLogOfNodes$tinyIds$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull DirectMessageNode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getSource().getTinyId();
            }
        }, 30, null);
        return prefix + ":  size = " + this.directMessageNodes.size() + " tinyIds=" + joinToString$default;
    }

    @WorkerThread
    public final boolean b(@NotNull List<DirectMessageNode> newNodes, @NotNull DiagnosisUtils.UpdateSource source) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        final Map mutableMap;
        List<DirectMessageNode> list;
        List list2;
        int collectionSizeOrDefault2;
        int mapCapacity2;
        int coerceAtLeast2;
        Intrinsics.checkNotNullParameter(newNodes, "newNodes");
        Intrinsics.checkNotNullParameter(source, "source");
        c();
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DirectMessageNodeList", d("appendOrUpdateNodes() before"));
        }
        List<DirectMessageNode> list3 = newNodes;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : list3) {
            linkedHashMap.put(((DirectMessageNode) obj).getGuildId(), obj);
        }
        mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
        final ArrayList arrayList = new ArrayList();
        CollectionsKt__MutableCollectionsKt.removeAll((List) this.directMessageNodes, (Function1) new Function1<DirectMessageNode, Boolean>() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNodeList$addOrUpdateNodes$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull DirectMessageNode node) {
                Intrinsics.checkNotNullParameter(node, "node");
                DirectMessageNode directMessageNode = mutableMap.get(node.getGuildId());
                if (directMessageNode == null) {
                    return Boolean.FALSE;
                }
                directMessageNode.f(node);
                boolean z16 = !Intrinsics.areEqual(directMessageNode, node);
                if (z16) {
                    arrayList.add(node);
                } else {
                    mutableMap.remove(node.getGuildId());
                }
                return Boolean.valueOf(z16);
            }
        });
        list = CollectionsKt___CollectionsKt.toList(mutableMap.values());
        this.directMessageNodes.addAll(list);
        list2 = CollectionsKt___CollectionsKt.toList(this.directMessageNodes);
        List<DirectMessageNode> unmodifiableList = Collections.unmodifiableList(list2);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(directMessageNodes.toList())");
        this.nodes = unmodifiableList;
        List<DirectMessageNode> list4 = unmodifiableList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(mapCapacity2, 16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(coerceAtLeast2);
        for (Object obj2 : list4) {
            linkedHashMap2.put(((DirectMessageNode) obj2).getChannelId(), obj2);
        }
        this.nodesByChannelId = linkedHashMap2;
        this.unreadResult = com.tencent.mobileqq.guild.message.directmessage.utils.a.a(this.directMessageNodes);
        if ((!arrayList.isEmpty()) || (!r5.isEmpty())) {
            DiagnosisUtils.f230535a.b(source, arrayList, list, this.unreadResult);
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DirectMessageNodeList", d("appendOrUpdateNodes() after"));
        }
        if ((!arrayList.isEmpty()) || (!r5.isEmpty())) {
            return true;
        }
        return false;
    }

    @WorkerThread
    @Nullable
    public final DirectMessageNode e(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return this.nodesByChannelId.get(channelId);
    }

    @NotNull
    public final List<DirectMessageNode> f() {
        return this.nodes;
    }

    @WorkerThread
    @NotNull
    public final List<DirectMessageNode> g(@NotNull List<String> guildId) {
        final Set set;
        List list;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        c();
        set = CollectionsKt___CollectionsKt.toSet(guildId);
        final ArrayList arrayList = new ArrayList(set.size());
        CollectionsKt__MutableCollectionsKt.removeAll((List) this.directMessageNodes, (Function1) new Function1<DirectMessageNode, Boolean>() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNodeList$removeNodeByGuildId$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull DirectMessageNode node) {
                Intrinsics.checkNotNullParameter(node, "node");
                if (set.contains(node.getGuildId())) {
                    arrayList.add(node);
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
        });
        list = CollectionsKt___CollectionsKt.toList(this.directMessageNodes);
        List<DirectMessageNode> unmodifiableList = Collections.unmodifiableList(list);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(directMessageNodes.toList())");
        this.nodes = unmodifiableList;
        List<DirectMessageNode> list2 = unmodifiableList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : list2) {
            linkedHashMap.put(((DirectMessageNode) obj).getChannelId(), obj);
        }
        this.nodesByChannelId = linkedHashMap;
        DiagnosisUtils.f230535a.a(arrayList);
        return arrayList;
    }
}
