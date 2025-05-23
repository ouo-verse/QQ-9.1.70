package jo4;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.userinfo.impl.db.role.UserDefaultRoleEntity;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0014\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\fJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J$\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0017R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Ljo4/g;", "", "", "yesId", "", VirtualAppProxy.KEY_GAME_ID, "Lcom/tencent/timi/game/databasecore/impl/YesDataBaseHelper;", "yesDataBaseHelper", "Lcom/tencent/timi/game/userinfo/impl/db/role/UserDefaultRoleEntity;", "r", "uin", "l", "", "Lbo4/c;", "infoList", "", "j", "entityList", tl.h.F, "uid", "g", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "Lcom/tencent/timi/game/utils/IResultListener;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "b", "Ljava/lang/String;", "TAG", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f410756a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "UserDefaultRoleDbUtil";

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(List entityList) {
        Intrinsics.checkNotNullParameter(entityList, "$entityList");
        YesDataBaseHelper f16 = YesDataBaseHelper.f();
        ArrayList arrayList = new ArrayList();
        Iterator it = entityList.iterator();
        while (it.hasNext()) {
            UserDefaultRoleEntity userDefaultRoleEntity = (UserDefaultRoleEntity) it.next();
            f16.h(userDefaultRoleEntity);
            bo4.c d16 = h.f410758a.d(userDefaultRoleEntity);
            fo4.b a16 = fo4.b.INSTANCE.a();
            String acquireKey = userDefaultRoleEntity.acquireKey();
            Intrinsics.checkNotNullExpressionValue(acquireKey, "entity.acquireKey()");
            a16.e(acquireKey, d16);
            arrayList.add(d16);
        }
        f410756a.j(arrayList);
    }

    private final void j(final List<? extends bo4.c> infoList) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: jo4.f
            @Override // java.lang.Runnable
            public final void run() {
                g.k(infoList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(List infoList) {
        Intrinsics.checkNotNullParameter(infoList, "$infoList");
        Iterator it = infoList.iterator();
        while (it.hasNext()) {
            fo4.c.INSTANCE.a().d((bo4.c) it.next());
        }
    }

    private final UserDefaultRoleEntity l(long uin, int gameId, YesDataBaseHelper yesDataBaseHelper) {
        if (uin == 0) {
            return null;
        }
        List<? extends Entity> k3 = yesDataBaseHelper.k(UserDefaultRoleEntity.class, false, "qqUin = ? AND gameId = ?", new String[]{String.valueOf(uin), String.valueOf(gameId)}, null, null, "uid desc", null);
        if (k3 != null && k3.size() > 0) {
            Entity entity = k3.get(0);
            if (entity instanceof UserDefaultRoleEntity) {
                return (UserDefaultRoleEntity) entity;
            }
        }
        l.e(TAG, "queryUserByUinSync not find ");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(WeakReference weakReference, bo4.c cVar) {
        Intrinsics.checkNotNullParameter(weakReference, "$weakReference");
        IResultListener iResultListener = (IResultListener) weakReference.get();
        if (iResultListener != null) {
            iResultListener.onSuccess(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(long j3, int i3, long j16, final WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "$weakReference");
        YesDataBaseHelper yesDataBaseHelper = YesDataBaseHelper.f();
        g gVar = f410756a;
        Intrinsics.checkNotNullExpressionValue(yesDataBaseHelper, "yesDataBaseHelper");
        UserDefaultRoleEntity r16 = gVar.r(j3, i3, yesDataBaseHelper);
        if (r16 == null) {
            r16 = gVar.l(j16, i3, yesDataBaseHelper);
        }
        if (r16 == null) {
            r16 = gVar.r(j16, i3, yesDataBaseHelper);
        }
        if (r16 != null) {
            h hVar = h.f410758a;
            final bo4.c d16 = hVar.d(r16);
            if (j3 == 0) {
                j3 = j16;
            }
            fo4.b.INSTANCE.a().d(hVar.a(Long.valueOf(j3), Integer.valueOf(i3)), d16);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: jo4.c
                @Override // java.lang.Runnable
                public final void run() {
                    g.p(WeakReference.this, d16);
                }
            });
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: jo4.d
            @Override // java.lang.Runnable
            public final void run() {
                g.q(WeakReference.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(WeakReference weakReference, bo4.c userRoleInfo) {
        Intrinsics.checkNotNullParameter(weakReference, "$weakReference");
        Intrinsics.checkNotNullParameter(userRoleInfo, "$userRoleInfo");
        IResultListener iResultListener = (IResultListener) weakReference.get();
        if (iResultListener != null) {
            iResultListener.onSuccess(userRoleInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "$weakReference");
        IResultListener iResultListener = (IResultListener) weakReference.get();
        if (iResultListener != null) {
            iResultListener.onError(1, "data not found");
        }
    }

    private final UserDefaultRoleEntity r(long yesId, int gameId, YesDataBaseHelper yesDataBaseHelper) {
        if (yesId == 0) {
            return null;
        }
        List<? extends Entity> k3 = yesDataBaseHelper.k(UserDefaultRoleEntity.class, false, "uid = ? AND gameId = ?", new String[]{String.valueOf(yesId), String.valueOf(gameId)}, null, null, null, null);
        if (k3 != null && k3.size() > 0) {
            Entity entity = k3.get(0);
            if (entity instanceof UserDefaultRoleEntity) {
                return (UserDefaultRoleEntity) entity;
            }
        }
        l.e(TAG, "queryUserInfoSync not find ");
        return null;
    }

    @Nullable
    public final bo4.c g(long uid, int gameId) {
        return fo4.b.INSTANCE.a().a(h.f410758a.a(Long.valueOf(uid), Integer.valueOf(gameId)));
    }

    public final void h(@NotNull final List<? extends UserDefaultRoleEntity> entityList) {
        Intrinsics.checkNotNullParameter(entityList, "entityList");
        ThreadManagerV2.excute(new Runnable() { // from class: jo4.e
            @Override // java.lang.Runnable
            public final void run() {
                g.i(entityList);
            }
        }, 32, null, true);
    }

    public final void m(@NotNull CommonOuterClass$QQUserId qqUserId, final int gameId, @NotNull IResultListener<bo4.c> listener) {
        final bo4.c g16;
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final long j3 = qqUserId.yes_uid.get();
        final long j16 = qqUserId.uid.get();
        String a16 = h.f410758a.a(Long.valueOf(qqUserId.yes_uid.get()), Integer.valueOf(gameId));
        if (j3 != 0) {
            g16 = fo4.b.INSTANCE.a().a(a16);
        } else {
            g16 = fo4.b.INSTANCE.a().g(j16);
        }
        final WeakReference weakReference = new WeakReference(listener);
        if (g16 != null) {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                listener.onSuccess(g16);
                return;
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: jo4.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.n(WeakReference.this, g16);
                    }
                });
                return;
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: jo4.b
            @Override // java.lang.Runnable
            public final void run() {
                g.o(j3, gameId, j16, weakReference);
            }
        }, 32, null, true);
    }
}
