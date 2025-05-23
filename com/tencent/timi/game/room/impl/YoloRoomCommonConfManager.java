package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.utils.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/timi/game/room/impl/YoloRoomCommonConfManager;", "Lfm4/d;", "", "sendIntervalTime", "", "f", "e", "", "", "enterRoomGreetWordsList", "d", "b", "a", "c", "I", "mSendIntervalTime", "mGameRoomSendIntervalTime", "Ljava/util/List;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class YoloRoomCommonConfManager implements fm4.d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final YoloRoomCommonConfManager f379027a = new YoloRoomCommonConfManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int mSendIntervalTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int mGameRoomSendIntervalTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static List<String> enterRoomGreetWordsList;

    static {
        List<String> emptyList;
        mSendIntervalTime = 5;
        mGameRoomSendIntervalTime = 1;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        enterRoomGreetWordsList = emptyList;
        mSendIntervalTime = rm4.a.c("tag_send_interval_time", 5);
        mGameRoomSendIntervalTime = rm4.a.c("tag_game_room_send_interval_time", 1);
    }

    YoloRoomCommonConfManager() {
    }

    @Override // fm4.d
    public int a() {
        return mGameRoomSendIntervalTime;
    }

    @Override // fm4.d
    public int b() {
        return mSendIntervalTime;
    }

    @NotNull
    public String c() {
        boolean z16;
        List<String> list = enterRoomGreetWordsList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        return enterRoomGreetWordsList.get(Random.INSTANCE.nextInt(enterRoomGreetWordsList.size()));
    }

    public final void d(@NotNull List<String> enterRoomGreetWordsList2) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(enterRoomGreetWordsList2, "enterRoomGreetWordsList");
        enterRoomGreetWordsList = enterRoomGreetWordsList2;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(enterRoomGreetWordsList2, ", ", null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.tencent.timi.game.room.impl.YoloRoomCommonConfManager$setEnterRoomGreetWordsList$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it;
            }
        }, 30, null);
        l.e("YoloRoomCommonConfManager", "setEnterRoomGreetWordsList # " + joinToString$default);
    }

    public final void e(int sendIntervalTime) {
        int coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(sendIntervalTime, 1);
        mGameRoomSendIntervalTime = coerceAtLeast;
        l.e("YoloRoomCommonConfManager", "setGameRoomSendIntervalTime # " + sendIntervalTime + " - " + coerceAtLeast);
        rm4.a.i("tag_game_room_send_interval_time", mSendIntervalTime);
    }

    public final void f(int sendIntervalTime) {
        int max = Math.max(sendIntervalTime, 3);
        mSendIntervalTime = max;
        l.e("YoloRoomCommonConfManager", "setSendIntervalTime # " + sendIntervalTime + " - " + max);
        rm4.a.i("tag_send_interval_time", mSendIntervalTime);
    }
}
