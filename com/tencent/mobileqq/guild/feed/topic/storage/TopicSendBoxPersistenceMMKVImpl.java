package com.tencent.mobileqq.guild.feed.topic.storage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0002\u0010\u001bB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\n\u001a\u00020\u00072)\u0010\t\u001a%\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003\u0012\u0004\u0012\u00020\u00070\u0002\u00a2\u0006\u0002\b\bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/storage/TopicSendBoxPersistenceMMKVImpl;", "Lcom/tencent/mobileqq/guild/feed/topic/storage/a;", "Lkotlin/Function1;", "", "", "", "", "", "Lkotlin/ExtensionFunctionType;", "block", "b", "Lcom/tencent/mobileqq/guild/feed/topic/storage/TopicSendBoxPersistenceMMKVImpl$TopicSendBoxListTable;", "c", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "add", "remove", "a", "Ljava/lang/String;", "key", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "entity", "()Ljava/util/Set;", "currentTaskIds", "topicId", "<init>", "(J)V", "TopicSendBoxListTable", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicSendBoxPersistenceMMKVImpl implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String key;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MMKVOptionEntityV2 entity;

    @Parcelize
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R)\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/storage/TopicSendBoxPersistenceMMKVImpl$TopicSendBoxListTable;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "", "", "d", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "entries", "<init>", "(Ljava/util/Map;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class TopicSendBoxListTable implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<TopicSendBoxListTable> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Map<String, Set<Long>> entries;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes13.dex */
        public static final class a implements Parcelable.Creator<TopicSendBoxListTable> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final TopicSendBoxListTable createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                for (int i3 = 0; i3 != readInt; i3++) {
                    String readString = parcel.readString();
                    int readInt2 = parcel.readInt();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(readInt2);
                    for (int i16 = 0; i16 != readInt2; i16++) {
                        linkedHashSet.add(Long.valueOf(parcel.readLong()));
                    }
                    linkedHashMap.put(readString, linkedHashSet);
                }
                return new TopicSendBoxListTable(linkedHashMap);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final TopicSendBoxListTable[] newArray(int i3) {
                return new TopicSendBoxListTable[i3];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public TopicSendBoxListTable(@NotNull Map<String, ? extends Set<Long>> entries) {
            Intrinsics.checkNotNullParameter(entries, "entries");
            this.entries = entries;
        }

        @NotNull
        public final Map<String, Set<Long>> a() {
            return this.entries;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof TopicSendBoxListTable) && Intrinsics.areEqual(this.entries, ((TopicSendBoxListTable) other).entries)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.entries.hashCode();
        }

        @NotNull
        public String toString() {
            return "TopicSendBoxListTable(entries=" + this.entries + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Map<String, Set<Long>> map = this.entries;
            parcel.writeInt(map.size());
            for (Map.Entry<String, Set<Long>> entry : map.entrySet()) {
                parcel.writeString(entry.getKey());
                Set<Long> value = entry.getValue();
                parcel.writeInt(value.size());
                Iterator<Long> it = value.iterator();
                while (it.hasNext()) {
                    parcel.writeLong(it.next().longValue());
                }
            }
        }
    }

    public TopicSendBoxPersistenceMMKVImpl(long j3) {
        this.key = "TopicSendBoxTable" + j3;
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.context, "guild_mmkv_configurations_TopicSendBoxDB");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(\n        MobileQQ\u2026LD}_TopicSendBoxDB\"\n    )");
        this.entity = fromV2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        r0 = kotlin.collections.MapsKt__MapsKt.toMutableMap(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void b(Function1<? super Map<String, Set<Long>>, Unit> block) {
        Map linkedHashMap;
        TopicSendBoxListTable c16 = c();
        if (c16 == null || (r0 = c16.a()) == null || linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
        }
        block.invoke(linkedHashMap);
        this.entity.putParcelable(this.key, new TopicSendBoxListTable(linkedHashMap));
    }

    private final TopicSendBoxListTable c() {
        return (TopicSendBoxListTable) this.entity.getParcelable(this.key, TopicSendBoxListTable.class, null, true);
    }

    @Override // com.tencent.mobileqq.guild.feed.topic.storage.a
    @NotNull
    public Set<String> a() {
        Set<String> emptySet;
        Map<String, Set<Long>> a16;
        Set<String> keySet;
        TopicSendBoxListTable c16 = c();
        if (c16 == null || (a16 = c16.a()) == null || (keySet = a16.keySet()) == null) {
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }
        return keySet;
    }

    @Override // com.tencent.mobileqq.guild.feed.topic.storage.a
    public void add(@NotNull final String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        b(new Function1<Map<String, Set<? extends Long>>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.storage.TopicSendBoxPersistenceMMKVImpl$add$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, Set<? extends Long>> map) {
                invoke2((Map<String, Set<Long>>) map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Map<String, Set<Long>> readAndFlushTable) {
                Set<Long> emptySet;
                Intrinsics.checkNotNullParameter(readAndFlushTable, "$this$readAndFlushTable");
                QLog.i("ITopicSendBoxPersistenceApi", 1, "add: " + taskId);
                String str = taskId;
                emptySet = SetsKt__SetsKt.emptySet();
                readAndFlushTable.put(str, emptySet);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.topic.storage.a
    public void remove(@NotNull final String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        b(new Function1<Map<String, Set<? extends Long>>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.storage.TopicSendBoxPersistenceMMKVImpl$remove$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, Set<? extends Long>> map) {
                invoke2((Map<String, Set<Long>>) map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Map<String, Set<Long>> readAndFlushTable) {
                Intrinsics.checkNotNullParameter(readAndFlushTable, "$this$readAndFlushTable");
                QLog.i("ITopicSendBoxPersistenceApi", 1, "remove: " + taskId);
                readAndFlushTable.remove(taskId);
            }
        });
    }
}
