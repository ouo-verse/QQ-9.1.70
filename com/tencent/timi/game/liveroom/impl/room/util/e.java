package com.tencent.timi.game.liveroom.impl.room.util;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J/\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/util/e;", "", "Lcom/tencent/timi/game/databasecore/impl/base/BaseTimiGameEntity;", "info", "", "e", "", "whereClause", "", "whereArgs", "c", "(Lcom/tencent/timi/game/databasecore/impl/base/BaseTimiGameEntity;Ljava/lang/String;[Ljava/lang/String;)V", "b", "Ljava/lang/String;", "TAG", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f378633a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "LivingDBUtil";

    e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(BaseTimiGameEntity info, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(info, "$info");
        YesDataBaseHelper.f().n(info, str, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(BaseTimiGameEntity info) {
        Intrinsics.checkNotNullParameter(info, "$info");
        YesDataBaseHelper.f().h(info);
    }

    public final void c(@NotNull final BaseTimiGameEntity info, @Nullable final String whereClause, @Nullable final String[] whereArgs) {
        Intrinsics.checkNotNullParameter(info, "info");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.util.d
            @Override // java.lang.Runnable
            public final void run() {
                e.d(BaseTimiGameEntity.this, whereClause, whereArgs);
            }
        }, 32, null, true);
    }

    public final void e(@NotNull final BaseTimiGameEntity info) {
        Intrinsics.checkNotNullParameter(info, "info");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.util.c
            @Override // java.lang.Runnable
            public final void run() {
                e.f(BaseTimiGameEntity.this);
            }
        }, 32, null, true);
    }
}
