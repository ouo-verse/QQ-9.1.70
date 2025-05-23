package com.tencent.state.square.detail;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.SquareAvatarItem;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J8\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u000eR\u00b9\u0001\u0010\u0003\u001a\u00ac\u0001\u0012\u0004\u0012\u00020\u0005\u0012K\u0012I\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u00060\u0004jU\u0012\u0004\u0012\u00020\u0005\u0012K\u0012I\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0006`\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/detail/UIStrategy;", "", "()V", "handleMap", "Ljava/util/HashMap;", "Lcom/tencent/state/square/detail/EnsureType;", "Lkotlin/Function3;", "Lcom/tencent/state/square/detail/EntranceSource;", "Lkotlin/ParameterName;", "name", "source", "Lcom/tencent/state/square/data/SquareAvatarItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "extra", "", "Lkotlin/collections/HashMap;", "ensure", "type", RemoteHandleConst.PARAM_DEFAULT_VALUE, "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class UIStrategy {
    public static final UIStrategy INSTANCE = new UIStrategy();
    private static final HashMap<EnsureType, Function3<EntranceSource, SquareAvatarItem, Object, Boolean>> handleMap;

    static {
        HashMap<EnsureType, Function3<EntranceSource, SquareAvatarItem, Object, Boolean>> hashMap = new HashMap<>();
        hashMap.put(EnsureType.SHOW_USER_INFO, new Function3<EntranceSource, SquareAvatarItem, Object, Boolean>() { // from class: com.tencent.state.square.detail.UIStrategy$handleMap$1$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(EntranceSource source, SquareAvatarItem item, Object obj) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(item, "item");
                return true;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(EntranceSource entranceSource, SquareAvatarItem squareAvatarItem, Object obj) {
                return Boolean.valueOf(invoke2(entranceSource, squareAvatarItem, obj));
            }
        });
        hashMap.put(EnsureType.CLICK_USER_INFO, new Function3<EntranceSource, SquareAvatarItem, Object, Boolean>() { // from class: com.tencent.state.square.detail.UIStrategy$handleMap$1$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(EntranceSource entranceSource, SquareAvatarItem squareAvatarItem, Object obj) {
                return Boolean.valueOf(invoke2(entranceSource, squareAvatarItem, obj));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(EntranceSource source, SquareAvatarItem item, Object obj) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(item, "item");
                return !item.getExtra().isStranger();
            }
        });
        hashMap.put(EnsureType.SHOW_MORE_BUTTON, new Function3<EntranceSource, SquareAvatarItem, Object, Boolean>() { // from class: com.tencent.state.square.detail.UIStrategy$handleMap$1$3
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(EntranceSource entranceSource, SquareAvatarItem squareAvatarItem, Object obj) {
                return Boolean.valueOf(invoke2(entranceSource, squareAvatarItem, obj));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(EntranceSource source, SquareAvatarItem item, Object obj) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(item, "item");
                return source.fromSquare() && item.getExtra().getInSquare();
            }
        });
        hashMap.put(EnsureType.SHOW_STATUS_BUBBLE, new Function3<EntranceSource, SquareAvatarItem, Object, Boolean>() { // from class: com.tencent.state.square.detail.UIStrategy$handleMap$1$4
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(EntranceSource entranceSource, SquareAvatarItem squareAvatarItem, Object obj) {
                return Boolean.valueOf(invoke2(entranceSource, squareAvatarItem, obj));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(EntranceSource source, SquareAvatarItem item, Object obj) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(item, "item");
                return item.getExtra().getOnlineStatus() != null;
            }
        });
        hashMap.put(EnsureType.SHOW_AVATAR_MOTION, new Function3<EntranceSource, SquareAvatarItem, Object, Boolean>() { // from class: com.tencent.state.square.detail.UIStrategy$handleMap$1$5
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(EntranceSource source, SquareAvatarItem item, Object obj) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(item, "item");
                return true;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(EntranceSource entranceSource, SquareAvatarItem squareAvatarItem, Object obj) {
                return Boolean.valueOf(invoke2(entranceSource, squareAvatarItem, obj));
            }
        });
        hashMap.put(EnsureType.SHOW_LOCATION_INFO, new Function3<EntranceSource, SquareAvatarItem, Object, Boolean>() { // from class: com.tencent.state.square.detail.UIStrategy$handleMap$1$6
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(EntranceSource entranceSource, SquareAvatarItem squareAvatarItem, Object obj) {
                return Boolean.valueOf(invoke2(entranceSource, squareAvatarItem, obj));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(EntranceSource source, SquareAvatarItem item, Object obj) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(item, "item");
                return !item.getExtra().isStranger();
            }
        });
        hashMap.put(EnsureType.SHOW_QZONE_BUTTON, new Function3<EntranceSource, SquareAvatarItem, Object, Boolean>() { // from class: com.tencent.state.square.detail.UIStrategy$handleMap$1$7
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(EntranceSource entranceSource, SquareAvatarItem squareAvatarItem, Object obj) {
                return Boolean.valueOf(invoke2(entranceSource, squareAvatarItem, obj));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(EntranceSource source, SquareAvatarItem item, Object obj) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(item, "item");
                return !item.getExtra().isStranger();
            }
        });
        hashMap.put(EnsureType.SHOW_SMALL_HOME_BUTTON, new Function3<EntranceSource, SquareAvatarItem, Object, Boolean>() { // from class: com.tencent.state.square.detail.UIStrategy$handleMap$1$8
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(EntranceSource entranceSource, SquareAvatarItem squareAvatarItem, Object obj) {
                return Boolean.valueOf(invoke2(entranceSource, squareAvatarItem, obj));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(EntranceSource source, SquareAvatarItem item, Object obj) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(item, "item");
                return !item.getExtra().isStranger();
            }
        });
        hashMap.put(EnsureType.SHOW_BUY_SAME_BUTTON, new Function3<EntranceSource, SquareAvatarItem, Object, Boolean>() { // from class: com.tencent.state.square.detail.UIStrategy$handleMap$1$9
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(EntranceSource source, SquareAvatarItem item, Object obj) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(item, "item");
                return true;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(EntranceSource entranceSource, SquareAvatarItem squareAvatarItem, Object obj) {
                return Boolean.valueOf(invoke2(entranceSource, squareAvatarItem, obj));
            }
        });
        hashMap.put(EnsureType.SHOW_AIO_INFO, new Function3<EntranceSource, SquareAvatarItem, Object, Boolean>() { // from class: com.tencent.state.square.detail.UIStrategy$handleMap$1$10
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(EntranceSource entranceSource, SquareAvatarItem squareAvatarItem, Object obj) {
                return Boolean.valueOf(invoke2(entranceSource, squareAvatarItem, obj));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(EntranceSource source, SquareAvatarItem item, Object obj) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(item, "item");
                return (item.getExtra().isFriend() || !(SquareBaseKt.getSquareCommon().getNeedShieldTeenager() && SquareBaseKt.getSquareCommon().getStudyMode())) && (item.getExtra().getInSquare() || item.getExtra().isFriend());
            }
        });
        hashMap.put(EnsureType.SHOW_ADD_SQUARE_BUTTON, new Function3<EntranceSource, SquareAvatarItem, Object, Boolean>() { // from class: com.tencent.state.square.detail.UIStrategy$handleMap$1$11
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(EntranceSource entranceSource, SquareAvatarItem squareAvatarItem, Object obj) {
                return Boolean.valueOf(invoke2(entranceSource, squareAvatarItem, obj));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(EntranceSource source, SquareAvatarItem item, Object obj) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(item, "item");
                return !item.getExtra().getInSquare();
            }
        });
        hashMap.put(EnsureType.SHOW_ADD_FRIEND_BUTTON, new Function3<EntranceSource, SquareAvatarItem, Object, Boolean>() { // from class: com.tencent.state.square.detail.UIStrategy$handleMap$1$12
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(EntranceSource entranceSource, SquareAvatarItem squareAvatarItem, Object obj) {
                return Boolean.valueOf(invoke2(entranceSource, squareAvatarItem, obj));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(EntranceSource source, SquareAvatarItem item, Object obj) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(item, "item");
                return item.getExtra().getInSquare() && item.getExtra().isStranger();
            }
        });
        hashMap.put(EnsureType.SHOW_MULTI_MOTION_INFO, new Function3<EntranceSource, SquareAvatarItem, Object, Boolean>() { // from class: com.tencent.state.square.detail.UIStrategy$handleMap$1$13
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(EntranceSource entranceSource, SquareAvatarItem squareAvatarItem, Object obj) {
                return Boolean.valueOf(invoke2(entranceSource, squareAvatarItem, obj));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(EntranceSource source, SquareAvatarItem item, Object obj) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(item, "item");
                return item.getExtra().getOnlineStatus() != null;
            }
        });
        handleMap = hashMap;
    }

    UIStrategy() {
    }

    public final boolean ensure(EnsureType type, EntranceSource source, SquareAvatarItem r46, Object extra, boolean r65) {
        Function3<EntranceSource, SquareAvatarItem, Object, Boolean> function3;
        Boolean invoke;
        Intrinsics.checkNotNullParameter(type, "type");
        return (source == null || r46 == null || r46.isMe() || (function3 = handleMap.get(type)) == null || (invoke = function3.invoke(source, r46, extra)) == null) ? r65 : invoke.booleanValue();
    }

    public static /* synthetic */ boolean ensure$default(UIStrategy uIStrategy, EnsureType ensureType, EntranceSource entranceSource, SquareAvatarItem squareAvatarItem, Object obj, boolean z16, int i3, Object obj2) {
        if ((i3 & 8) != 0) {
            obj = null;
        }
        Object obj3 = obj;
        if ((i3 & 16) != 0) {
            z16 = true;
        }
        return uIStrategy.ensure(ensureType, entranceSource, squareAvatarItem, obj3, z16);
    }
}
