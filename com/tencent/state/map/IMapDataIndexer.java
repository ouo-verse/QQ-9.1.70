package com.tencent.state.map;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/map/IMapDataIndexer;", "", "indexOf", "", "block", "Lkotlin/Function1;", "Lcom/tencent/state/map/MapItem;", "", "data", "uin", "", "type", "appId", "indexOfUnitType", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public interface IMapDataIndexer {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class DefaultImpls {
        public static int indexOf(IMapDataIndexer iMapDataIndexer, MapItem data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return iMapDataIndexer.indexOf(data.getUin(), data.getType(), data.getAppId());
        }

        public static int indexOfUnitType(IMapDataIndexer iMapDataIndexer, final String uin, final int i3) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            return iMapDataIndexer.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.map.IMapDataIndexer$indexOfUnitType$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                    return Boolean.valueOf(invoke2(mapItem));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(MapItem it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Intrinsics.areEqual(it.getUin(), uin) && it.getUnitType() == i3;
                }
            });
        }

        public static int indexOf(IMapDataIndexer iMapDataIndexer, final String uin, final int i3) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            return iMapDataIndexer.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.map.IMapDataIndexer$indexOf$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                    return Boolean.valueOf(invoke2(mapItem));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(MapItem it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Intrinsics.areEqual(it.getUin(), uin) && it.getType() == i3;
                }
            });
        }

        public static int indexOf(IMapDataIndexer iMapDataIndexer, final String uin, final int i3, final int i16) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            return iMapDataIndexer.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.map.IMapDataIndexer$indexOf$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                    return Boolean.valueOf(invoke2(mapItem));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(MapItem it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Intrinsics.areEqual(it.getUin(), uin) && it.getType() == i3 && it.getAppId() == i16;
                }
            });
        }
    }

    int indexOf(MapItem data);

    int indexOf(String uin, int type);

    int indexOf(String uin, int type, int appId);

    int indexOf(Function1<? super MapItem, Boolean> block);

    int indexOfUnitType(String uin, int type);
}
