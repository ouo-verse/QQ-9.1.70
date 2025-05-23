package com.tencent.icgame.game.userinfo.impl.loader;

import com.tencent.icgame.game.userinfo.api.IUserInfo;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.timi.game.utils.IResultListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ly0.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u000b\u0018\u0000 \u000e2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J,\u0010\f\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0014\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R.\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/icgame/game/userinfo/impl/loader/UserInfoAutoLoader;", "Lcom/tencent/icgame/game/userinfo/impl/loader/c;", "", "Lcom/tencent/icgame/game/userinfo/api/IUserInfo;", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "", "l", "", "requestList", "Lcom/tencent/timi/game/utils/IResultListener;", "callback", "g", "", "e", "", "d", "Ljava/util/Map;", "getLeftQQUserInfo", "()Ljava/util/Map;", "setLeftQQUserInfo", "(Ljava/util/Map;)V", "leftQQUserInfo", "<init>", "()V", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class UserInfoAutoLoader extends c<List<? extends IUserInfo>> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<UserInfoAutoLoader> f115997f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Long, CommonOuterClass$QQUserId> leftQQUserInfo = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/icgame/game/userinfo/impl/loader/UserInfoAutoLoader$a;", "", "Lcom/tencent/icgame/game/userinfo/impl/loader/UserInfoAutoLoader;", "stance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/icgame/game/userinfo/impl/loader/UserInfoAutoLoader;", "stance", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.game.userinfo.impl.loader.UserInfoAutoLoader$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserInfoAutoLoader a() {
            return (UserInfoAutoLoader) UserInfoAutoLoader.f115997f.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<UserInfoAutoLoader> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<UserInfoAutoLoader>() { // from class: com.tencent.icgame.game.userinfo.impl.loader.UserInfoAutoLoader$Companion$stance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final UserInfoAutoLoader invoke() {
                return new UserInfoAutoLoader();
            }
        });
        f115997f = lazy;
    }

    @Override // com.tencent.icgame.game.userinfo.impl.loader.c
    @NotNull
    public String e() {
        return "UserInfoAutoLoader";
    }

    @Override // com.tencent.icgame.game.userinfo.impl.loader.c
    public void g(@NotNull List<Long> requestList, @Nullable IResultListener<List<? extends IUserInfo>> callback) {
        Intrinsics.checkNotNullParameter(requestList, "requestList");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = requestList.iterator();
        while (it.hasNext()) {
            CommonOuterClass$QQUserId remove = this.leftQQUserInfo.remove(Long.valueOf(((Number) it.next()).longValue()));
            if (remove != null) {
                arrayList.add(remove);
            }
        }
        jy0.b.f411152a.a(arrayList, callback);
    }

    public final void l(@Nullable CommonOuterClass$QQUserId qqUserId) {
        List<Long> mutableListOf;
        if (qqUserId != null) {
            long e16 = n.f415773a.e(qqUserId);
            this.leftQQUserInfo.put(Long.valueOf(e16), qqUserId);
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Long.valueOf(e16));
            h(mutableListOf);
        }
    }
}
