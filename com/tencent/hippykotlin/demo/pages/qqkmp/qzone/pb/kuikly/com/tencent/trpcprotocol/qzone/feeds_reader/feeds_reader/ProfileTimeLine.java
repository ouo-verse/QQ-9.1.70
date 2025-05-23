package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import c45.k;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import pbandk.a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u001f\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/ProfileTimeLine;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/ProfileCalendar;", "mapTimeline", "Ljava/util/Map;", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/util/Map;)V", "MapTimelineEntry", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ProfileTimeLine extends j {
    public static final int $stable = 8;
    public final Map<Integer, ProfileCalendar> mapTimeline;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002B\u001d\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016R\"\u0010\r\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\f\u0010\u0017R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/ProfileTimeLine$MapTimelineEntry;", "Lc45/j;", "", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/ProfileCalendar;", "Lc45/f;", "u", "decodeWith", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "key", "I", "getKey", "()Ljava/lang/Integer;", VasCommonJsbProxy.JSON_KEY_SET_KEY, "(I)V", "value", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/ProfileCalendar;", HippyTextInputController.COMMAND_getValue, "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/ProfileCalendar;", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/ProfileCalendar;)V", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(ILcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/ProfileCalendar;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class MapTimelineEntry extends j implements Map.Entry<Integer, ProfileCalendar>, KMappedMarker {
        private int key;
        private ProfileCalendar value;

        public MapTimelineEntry() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        @Override // c45.j
        public j decodeWith(f u16) {
            return u16.g(new MapTimelineEntry(0, null, 3, 0 == true ? 1 : 0));
        }

        public void setKey(int i3) {
            this.key = i3;
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public ProfileCalendar setValue2(ProfileCalendar profileCalendar) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* synthetic */ MapTimelineEntry(int i3, ProfileCalendar profileCalendar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? null : profileCalendar);
        }

        @Override // c45.j
        public Map<Integer, h> getIndexes() {
            Map<Integer, h> mapOf;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, getKey(), new b.e.C0168e(false))), TuplesKt.to(2, new h(2, getValue(), new b.d(new ProfileCalendar(null, 1, 0 == true ? 1 : 0)))));
            return mapOf;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map.Entry
        public Integer getKey() {
            return Integer.valueOf(this.key);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map.Entry
        public ProfileCalendar getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public /* bridge */ /* synthetic */ ProfileCalendar setValue(ProfileCalendar profileCalendar) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public MapTimelineEntry(int i3, ProfileCalendar profileCalendar) {
            this.key = i3;
            this.value = profileCalendar;
        }

        public void setValue(ProfileCalendar profileCalendar) {
            this.value = profileCalendar;
        }

        @Override // c45.j
        public void setValue(int fieldNumber, Object v3) {
            if (fieldNumber == 1) {
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                setKey(((Integer) v3).intValue());
            } else {
                if (fieldNumber != 2) {
                    return;
                }
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.ProfileCalendar");
                setValue((ProfileCalendar) v3);
            }
        }
    }

    public ProfileTimeLine() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new ProfileTimeLine(null, 1, 0 == true ? 1 : 0));
    }

    public /* synthetic */ ProfileTimeLine(Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new LinkedHashMap() : map);
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1, new h(1, this.mapTimeline, new b.C0166b(new b.e.C0168e(false), new b.d(new ProfileCalendar(null, 1, 0 == true ? 1 : 0))))));
        return mapOf;
    }

    public ProfileTimeLine(Map<Integer, ProfileCalendar> map) {
        this.mapTimeline = map;
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        if (fieldNumber == 1) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type pbandk.MessageMap.Entry<kotlin.Int, com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.ProfileCalendar?>");
            k.a((a.c) v3, this.mapTimeline);
        }
    }
}
