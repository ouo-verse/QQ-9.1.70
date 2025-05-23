package com.tencent.mobileqq.search.searchdetail.content.template.model;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/QSearchEnumJumpType;", "", "", "type", "I", "getType", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "JUMP_TYPE_H5", "JUMP_TYPE_TAB", "JUMP_TYPE_GUILD", "JUMP_TYPE_GUILD_ARTICLE", "JUMP_TYPE_QEVENT", "JUMP_TYPE_PYMK", "JUMP_TYPE_USER", "JUMP_TYPE_CIRCLE_FEED_DETAIL", "JUMP_TYPE_CIRCLE_USER", "JUMP_TYPE_CIRCLE_HOT_TAG", "JUMP_TYPE_GROUP_JOIN", "JUMP_TYPE_GROUP_INFO_CARD", "JUMP_TYPE_GUILD_TOPIC", "JUMP_TYPE_JOIN_GUILD", "JUMP_TYPE_QQ_SEARCH_TOPIC", "JUMP_TYPE_MINI_APP", "JUMP_TYPE_GUILD_AGGREGATION", "JUMP_TYPE_GUILD_OPENCHANNEL", "JUMP_TYPE_LIKE_FEED_CLICK", "JUMP_TYPE_SHARE_FEED_CLICK", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public enum QSearchEnumJumpType {
    JUMP_TYPE_H5(0),
    JUMP_TYPE_TAB(1),
    JUMP_TYPE_GUILD(2),
    JUMP_TYPE_GUILD_ARTICLE(3),
    JUMP_TYPE_QEVENT(4),
    JUMP_TYPE_PYMK(5),
    JUMP_TYPE_USER(6),
    JUMP_TYPE_CIRCLE_FEED_DETAIL(7),
    JUMP_TYPE_CIRCLE_USER(8),
    JUMP_TYPE_CIRCLE_HOT_TAG(9),
    JUMP_TYPE_GROUP_JOIN(10),
    JUMP_TYPE_GROUP_INFO_CARD(11),
    JUMP_TYPE_GUILD_TOPIC(12),
    JUMP_TYPE_JOIN_GUILD(13),
    JUMP_TYPE_QQ_SEARCH_TOPIC(14),
    JUMP_TYPE_MINI_APP(15),
    JUMP_TYPE_GUILD_AGGREGATION(16),
    JUMP_TYPE_GUILD_OPENCHANNEL(17),
    JUMP_TYPE_LIKE_FEED_CLICK(18),
    JUMP_TYPE_SHARE_FEED_CLICK(19);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Map<Integer, QSearchEnumJumpType> map;
    private final int type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/QSearchEnumJumpType$a;", "", "", "type", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/QSearchEnumJumpType;", "a", "", "b", "", "map", "Ljava/util/Map;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.QSearchEnumJumpType$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final QSearchEnumJumpType a(int type) {
            return (QSearchEnumJumpType) QSearchEnumJumpType.map.get(Integer.valueOf(type));
        }

        public final boolean b(int type) {
            return QSearchEnumJumpType.map.containsKey(Integer.valueOf(type));
        }

        Companion() {
        }
    }

    static {
        int mapCapacity;
        int coerceAtLeast;
        QSearchEnumJumpType[] values = values();
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(values.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (QSearchEnumJumpType qSearchEnumJumpType : values) {
            linkedHashMap.put(Integer.valueOf(qSearchEnumJumpType.type), qSearchEnumJumpType);
        }
        map = linkedHashMap;
    }

    QSearchEnumJumpType(int i3) {
        this.type = i3;
    }

    public final int getType() {
        return this.type;
    }
}
