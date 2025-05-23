package com.tencent.icgame.game.userinfo.impl.loader;

import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.GameDataServerOuterClass$UserDefaultRole;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.utils.IResultListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ly0.n;
import my0.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u000b\u0018\u0000 \u000e2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J,\u0010\u000e\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0017R.\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u00198\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/icgame/game/userinfo/impl/loader/UserRoleInfoAutoLoader;", "Lcom/tencent/icgame/game/userinfo/impl/loader/c;", "", "Lcom/tencent/icgame/trpc/yes/common/GameDataServerOuterClass$UserDefaultRole;", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "", VirtualAppProxy.KEY_GAME_ID, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "requestList", "Lcom/tencent/timi/game/utils/IResultListener;", "callback", "g", "", "e", "", "d", "Ljava/util/Set;", "l", "()Ljava/util/Set;", "roleInfoRequestedSet", "I", "currentGameId", "", "f", "Ljava/util/Map;", "getLeftQQUserInfo", "()Ljava/util/Map;", "setLeftQQUserInfo", "(Ljava/util/Map;)V", "leftQQUserInfo", "<init>", "()V", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class UserRoleInfoAutoLoader extends c<List<? extends GameDataServerOuterClass$UserDefaultRole>> {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy<UserRoleInfoAutoLoader> f116000h;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int currentGameId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> roleInfoRequestedSet = new LinkedHashSet();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Long, CommonOuterClass$QQUserId> leftQQUserInfo = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/icgame/game/userinfo/impl/loader/UserRoleInfoAutoLoader$a;", "", "Lcom/tencent/icgame/game/userinfo/impl/loader/UserRoleInfoAutoLoader;", "stance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/icgame/game/userinfo/impl/loader/UserRoleInfoAutoLoader;", "stance", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.game.userinfo.impl.loader.UserRoleInfoAutoLoader$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserRoleInfoAutoLoader a() {
            return (UserRoleInfoAutoLoader) UserRoleInfoAutoLoader.f116000h.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<UserRoleInfoAutoLoader> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<UserRoleInfoAutoLoader>() { // from class: com.tencent.icgame.game.userinfo.impl.loader.UserRoleInfoAutoLoader$Companion$stance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final UserRoleInfoAutoLoader invoke() {
                return new UserRoleInfoAutoLoader();
            }
        });
        f116000h = lazy;
    }

    @Override // com.tencent.icgame.game.userinfo.impl.loader.c
    @NotNull
    public String e() {
        return "UserRoleInfoAutoLoader";
    }

    @Override // com.tencent.icgame.game.userinfo.impl.loader.c
    public void g(@NotNull List<Long> requestList, @Nullable IResultListener<List<? extends GameDataServerOuterClass$UserDefaultRole>> callback) {
        Intrinsics.checkNotNullParameter(requestList, "requestList");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = requestList.iterator();
        while (it.hasNext()) {
            CommonOuterClass$QQUserId remove = this.leftQQUserInfo.remove(Long.valueOf(((Number) it.next()).longValue()));
            if (remove != null) {
                arrayList.add(remove);
            }
        }
        jy0.a.f411148a.c(this.currentGameId, 1, arrayList, callback);
    }

    @NotNull
    public final Set<String> l() {
        return this.roleInfoRequestedSet;
    }

    public final void m(@Nullable CommonOuterClass$QQUserId qqUserId, int gameId) {
        List<Long> mutableListOf;
        if (qqUserId != null) {
            String a16 = h.f417777a.a(qqUserId, Integer.valueOf(gameId));
            long e16 = n.f415773a.e(qqUserId);
            if (e16 != 0 && !this.roleInfoRequestedSet.contains(a16)) {
                this.currentGameId = gameId;
                this.leftQQUserInfo.put(Long.valueOf(e16), qqUserId);
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Long.valueOf(e16));
                h(mutableListOf);
            }
        }
    }
}
