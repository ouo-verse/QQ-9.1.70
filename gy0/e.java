package gy0;

import android.content.Context;
import com.tencent.icgame.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.icgame.game.userinfo.api.IUserInfo;
import com.tencent.icgame.game.userinfo.impl.db.UserInfoEntity;
import com.tencent.icgame.game.userinfo.impl.db.role.UserDefaultRoleEntity;
import com.tencent.icgame.game.userinfo.impl.loader.UserRoleInfoAutoLoader;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ly0.k;
import ly0.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016\u00a8\u0006\u0017"}, d2 = {"Lgy0/e;", "Ley0/d;", "", "initRegisterDatabaseModelClass", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/icgame/game/userinfo/api/IUserInfo;", "callback", "i0", "j", "Landroid/content/Context;", "context", "init", "userId", "", VirtualAppProxy.KEY_GAME_ID, "", "c3", "o2", "<init>", "()V", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class e implements ey0.d {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f403869b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"gy0/e$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/icgame/game/userinfo/api/IUserInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<IUserInfo> f403870a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f403871b;

        b(IResultListener<IUserInfo> iResultListener, CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            this.f403870a = iResultListener;
            this.f403871b = commonOuterClass$QQUserId;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo result) {
            if (result != null) {
                IResultListener<IUserInfo> iResultListener = this.f403870a;
                if (iResultListener != null) {
                    iResultListener.onSuccess(result);
                    return;
                }
                return;
            }
            jy0.c.f411154a.a(this.f403871b, this.f403870a);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            jy0.c.f411154a.a(this.f403871b, this.f403870a);
        }
    }

    @Override // ey0.d
    public boolean c3(@Nullable CommonOuterClass$QQUserId userId, int gameId) {
        return n.f415773a.h(userId, gameId);
    }

    @Override // ey0.d
    public void i0(@NotNull CommonOuterClass$QQUserId qqUserId, @Nullable IResultListener<IUserInfo> callback) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        k.f415769a.s(qqUserId, new b(callback, qqUserId));
    }

    @Override // ey0.d
    public void initRegisterDatabaseModelClass() {
        YesDataBaseHelper.j(new UserInfoEntity(), new hy0.c());
        YesDataBaseHelper.j(new UserDefaultRoleEntity(), new iy0.a());
    }

    @Override // ey0.d
    public void j() {
        iy0.b.INSTANCE.a().c();
        hy0.a.INSTANCE.a().c();
        UserRoleInfoAutoLoader.INSTANCE.a().l().clear();
        f403869b = false;
    }

    @Override // mm4.a
    public void o2() {
        hy0.b.INSTANCE.a().c();
        iy0.c.INSTANCE.a().c();
    }

    @Override // mm4.a
    public void init(@Nullable Context context) {
    }
}
