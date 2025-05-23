package my0;

import android.os.Looper;
import com.tencent.icgame.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.icgame.game.userinfo.impl.db.role.UserDefaultRoleEntity;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.utils.IResultListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0014\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\fJ$\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0015R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lmy0/g;", "", "", "yesId", "", VirtualAppProxy.KEY_GAME_ID, "Lcom/tencent/icgame/game/databasecore/impl/YesDataBaseHelper;", "yesDataBaseHelper", "Lcom/tencent/icgame/game/userinfo/impl/db/role/UserDefaultRoleEntity;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "uin", "k", "", "Ley0/c;", "infoList", "", "i", "entityList", "g", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "Lcom/tencent/timi/game/utils/IResultListener;", "listener", "l", "", "b", "Ljava/lang/String;", "TAG", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f417775a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "ICGameUserDefaultRoleDbUtil";

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(List entityList) {
        Intrinsics.checkNotNullParameter(entityList, "$entityList");
        YesDataBaseHelper f16 = YesDataBaseHelper.f();
        ArrayList arrayList = new ArrayList();
        Iterator it = entityList.iterator();
        while (it.hasNext()) {
            UserDefaultRoleEntity userDefaultRoleEntity = (UserDefaultRoleEntity) it.next();
            f16.h(userDefaultRoleEntity);
            ey0.c d16 = h.f417777a.d(userDefaultRoleEntity);
            iy0.b a16 = iy0.b.INSTANCE.a();
            String acquireKey = userDefaultRoleEntity.acquireKey();
            Intrinsics.checkNotNullExpressionValue(acquireKey, "entity.acquireKey()");
            a16.e(acquireKey, d16);
            arrayList.add(d16);
        }
        f417775a.i(arrayList);
    }

    private final void i(final List<? extends ey0.c> infoList) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: my0.f
            @Override // java.lang.Runnable
            public final void run() {
                g.j(infoList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(List infoList) {
        Intrinsics.checkNotNullParameter(infoList, "$infoList");
        Iterator it = infoList.iterator();
        while (it.hasNext()) {
            iy0.c.INSTANCE.a().d((ey0.c) it.next());
        }
    }

    private final UserDefaultRoleEntity k(long uin, int gameId, YesDataBaseHelper yesDataBaseHelper) {
        if (uin == 0) {
            return null;
        }
        List<? extends Entity> i3 = yesDataBaseHelper.i(UserDefaultRoleEntity.class, false, "qqUin = ? AND gameId = ?", new String[]{String.valueOf(uin), String.valueOf(gameId)}, null, null, "uid desc", null);
        if (i3 != null && i3.size() > 0) {
            Entity entity = i3.get(0);
            if (entity instanceof UserDefaultRoleEntity) {
                return (UserDefaultRoleEntity) entity;
            }
        }
        com.tencent.icgame.game.utils.g.d(TAG, "queryUserByUinSync not find ");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(WeakReference weakReference, ey0.c cVar) {
        Intrinsics.checkNotNullParameter(weakReference, "$weakReference");
        IResultListener iResultListener = (IResultListener) weakReference.get();
        if (iResultListener != null) {
            iResultListener.onSuccess(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(long j3, int i3, long j16, final WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "$weakReference");
        YesDataBaseHelper yesDataBaseHelper = YesDataBaseHelper.f();
        g gVar = f417775a;
        Intrinsics.checkNotNullExpressionValue(yesDataBaseHelper, "yesDataBaseHelper");
        UserDefaultRoleEntity q16 = gVar.q(j3, i3, yesDataBaseHelper);
        if (q16 == null) {
            q16 = gVar.k(j16, i3, yesDataBaseHelper);
        }
        if (q16 == null) {
            q16 = gVar.q(j16, i3, yesDataBaseHelper);
        }
        if (q16 != null) {
            h hVar = h.f417777a;
            final ey0.c d16 = hVar.d(q16);
            if (j3 == 0) {
                j3 = j16;
            }
            iy0.b.INSTANCE.a().d(hVar.b(Long.valueOf(j3), Integer.valueOf(i3)), d16);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: my0.c
                @Override // java.lang.Runnable
                public final void run() {
                    g.o(WeakReference.this, d16);
                }
            });
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: my0.d
            @Override // java.lang.Runnable
            public final void run() {
                g.p(WeakReference.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(WeakReference weakReference, ey0.c userRoleInfo) {
        Intrinsics.checkNotNullParameter(weakReference, "$weakReference");
        Intrinsics.checkNotNullParameter(userRoleInfo, "$userRoleInfo");
        IResultListener iResultListener = (IResultListener) weakReference.get();
        if (iResultListener != null) {
            iResultListener.onSuccess(userRoleInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "$weakReference");
        IResultListener iResultListener = (IResultListener) weakReference.get();
        if (iResultListener != null) {
            iResultListener.onError(1, "data not found");
        }
    }

    private final UserDefaultRoleEntity q(long yesId, int gameId, YesDataBaseHelper yesDataBaseHelper) {
        if (yesId == 0) {
            return null;
        }
        List<? extends Entity> i3 = yesDataBaseHelper.i(UserDefaultRoleEntity.class, false, "uid = ? AND gameId = ?", new String[]{String.valueOf(yesId), String.valueOf(gameId)}, null, null, null, null);
        if (i3 != null && i3.size() > 0) {
            Entity entity = i3.get(0);
            if (entity instanceof UserDefaultRoleEntity) {
                return (UserDefaultRoleEntity) entity;
            }
        }
        com.tencent.icgame.game.utils.g.d(TAG, "queryUserInfoSync not find ");
        return null;
    }

    public final void g(@NotNull final List<? extends UserDefaultRoleEntity> entityList) {
        Intrinsics.checkNotNullParameter(entityList, "entityList");
        ThreadManagerV2.excute(new Runnable() { // from class: my0.e
            @Override // java.lang.Runnable
            public final void run() {
                g.h(entityList);
            }
        }, 32, null, true);
    }

    public final void l(@NotNull CommonOuterClass$QQUserId qqUserId, final int gameId, @NotNull IResultListener<ey0.c> listener) {
        final ey0.c g16;
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final long j3 = qqUserId.yes_uid.get();
        final long j16 = qqUserId.uid.get();
        String b16 = h.f417777a.b(Long.valueOf(qqUserId.yes_uid.get()), Integer.valueOf(gameId));
        if (j3 != 0) {
            g16 = iy0.b.INSTANCE.a().a(b16);
        } else {
            g16 = iy0.b.INSTANCE.a().g(j16);
        }
        final WeakReference weakReference = new WeakReference(listener);
        if (g16 != null) {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                listener.onSuccess(g16);
                return;
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: my0.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.m(WeakReference.this, g16);
                    }
                });
                return;
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: my0.b
            @Override // java.lang.Runnable
            public final void run() {
                g.n(j3, gameId, j16, weakReference);
            }
        }, 32, null, true);
    }
}
