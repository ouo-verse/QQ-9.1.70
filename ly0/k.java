package ly0;

import android.os.Looper;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.icgame.game.userinfo.api.IUserInfo;
import com.tencent.icgame.game.userinfo.impl.db.UserInfoEntity;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.timi.game.utils.IResultListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u001a\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0016\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006J\u001c\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lly0/k;", "", "Lcom/tencent/icgame/game/userinfo/impl/db/UserInfoEntity;", "entity", "dbEntity", "y", "", "Lcom/tencent/icgame/game/userinfo/api/IUserInfo;", "infoList", "", "p", "info", DomainData.DOMAIN_NAME, "", "uid", "Lcom/tencent/icgame/game/databasecore/impl/YesDataBaseHelper;", "yesDataBaseHelper", HippyTKDListViewAdapter.X, "qqUin", "r", "j", "entityList", "l", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "Lcom/tencent/timi/game/utils/IResultListener;", "listener", ReportConstant.COSTREPORT_PREFIX, "i", "", "b", "Ljava/lang/String;", "TAG", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f415769a = new k();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "ICGameUserInfoDbUtil";

    k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(UserInfoEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "$entity");
        YesDataBaseHelper.f().h(entity);
        k kVar = f415769a;
        IUserInfo i3 = kVar.i(entity);
        kVar.n(i3);
        hy0.a.INSTANCE.a().e(Long.valueOf(i3.b()), i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(List entityList) {
        Intrinsics.checkNotNullParameter(entityList, "$entityList");
        YesDataBaseHelper yesDataBaseHelper = YesDataBaseHelper.f();
        ArrayList arrayList = new ArrayList();
        Iterator it = entityList.iterator();
        while (it.hasNext()) {
            UserInfoEntity userInfoEntity = (UserInfoEntity) it.next();
            k kVar = f415769a;
            long j3 = userInfoEntity.uid;
            Intrinsics.checkNotNullExpressionValue(yesDataBaseHelper, "yesDataBaseHelper");
            UserInfoEntity y16 = kVar.y(userInfoEntity, kVar.x(j3, yesDataBaseHelper));
            yesDataBaseHelper.h(y16);
            IUserInfo i3 = kVar.i(y16);
            hy0.a.INSTANCE.a().e(Long.valueOf(i3.b()), i3);
            arrayList.add(i3);
        }
        f415769a.p(arrayList);
    }

    private final void n(final IUserInfo info) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ly0.h
            @Override // java.lang.Runnable
            public final void run() {
                k.o(IUserInfo.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(IUserInfo info) {
        Intrinsics.checkNotNullParameter(info, "$info");
        hy0.b.INSTANCE.a().d(info);
    }

    private final void p(final List<? extends IUserInfo> infoList) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ly0.j
            @Override // java.lang.Runnable
            public final void run() {
                k.q(infoList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(List infoList) {
        Intrinsics.checkNotNullParameter(infoList, "$infoList");
        Iterator it = infoList.iterator();
        while (it.hasNext()) {
            hy0.b.INSTANCE.a().d((IUserInfo) it.next());
        }
    }

    private final UserInfoEntity r(long qqUin, YesDataBaseHelper yesDataBaseHelper) {
        if (qqUin == 0) {
            return null;
        }
        List<? extends Entity> i3 = yesDataBaseHelper.i(UserInfoEntity.class, false, "qqUin=?", new String[]{String.valueOf(qqUin)}, null, null, "uid desc", null);
        if (i3 != null && i3.size() > 0) {
            Entity entity = i3.get(0);
            if (entity instanceof UserInfoEntity) {
                return (UserInfoEntity) entity;
            }
        }
        com.tencent.icgame.game.utils.g.d(TAG, "queryUserByUinSync not find ");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(IResultListener listener, IUserInfo iUserInfo) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onSuccess(iUserInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(long j3, long j16, final IResultListener listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        YesDataBaseHelper yesDataBaseHelper = YesDataBaseHelper.f();
        k kVar = f415769a;
        Intrinsics.checkNotNullExpressionValue(yesDataBaseHelper, "yesDataBaseHelper");
        UserInfoEntity x16 = kVar.x(j3, yesDataBaseHelper);
        if (x16 == null) {
            x16 = kVar.r(j16, yesDataBaseHelper);
        }
        if (x16 == null) {
            x16 = kVar.x(j16, yesDataBaseHelper);
        }
        if (x16 != null) {
            final IUserInfo i3 = kVar.i(x16);
            if (j3 == 0) {
                j3 = j16;
            }
            hy0.a.INSTANCE.a().d(Long.valueOf(j3), i3);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ly0.e
                @Override // java.lang.Runnable
                public final void run() {
                    k.v(IResultListener.this, i3);
                }
            });
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ly0.f
            @Override // java.lang.Runnable
            public final void run() {
                k.w(IResultListener.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(IResultListener listener, IUserInfo userInfo) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(userInfo, "$userInfo");
        listener.onSuccess(userInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(IResultListener listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onError(1, "data not found");
    }

    private final UserInfoEntity x(long uid, YesDataBaseHelper yesDataBaseHelper) {
        if (uid == 0) {
            return null;
        }
        List<? extends Entity> i3 = yesDataBaseHelper.i(UserInfoEntity.class, false, "uid=?", new String[]{String.valueOf(uid)}, null, null, null, null);
        if (i3 != null && i3.size() > 0) {
            Entity entity = i3.get(0);
            if (entity instanceof UserInfoEntity) {
                return (UserInfoEntity) entity;
            }
        }
        com.tencent.icgame.game.utils.g.d(TAG, "queryUserInfoSync not find ");
        return null;
    }

    private final UserInfoEntity y(UserInfoEntity entity, UserInfoEntity dbEntity) {
        if (dbEntity != null) {
            dbEntity.extensionAvatar = entity.extensionAvatar;
            dbEntity.extensionNick = entity.extensionNick;
            dbEntity.qqBaseInfo = entity.qqBaseInfo;
            dbEntity.groupProInfo = entity.groupProInfo;
            dbEntity.nearbyUserInfo = entity.nearbyUserInfo;
            return dbEntity;
        }
        return entity;
    }

    @NotNull
    public final IUserInfo i(@NotNull UserInfoEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        return new gy0.b(entity);
    }

    public final void j(@NotNull final UserInfoEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        ThreadManagerV2.excute(new Runnable() { // from class: ly0.g
            @Override // java.lang.Runnable
            public final void run() {
                k.k(UserInfoEntity.this);
            }
        }, 32, null, true);
    }

    public final void l(@NotNull final List<? extends UserInfoEntity> entityList) {
        Intrinsics.checkNotNullParameter(entityList, "entityList");
        ThreadManagerV2.excute(new Runnable() { // from class: ly0.i
            @Override // java.lang.Runnable
            public final void run() {
                k.m(entityList);
            }
        }, 32, null, true);
    }

    public final void s(@NotNull CommonOuterClass$QQUserId qqUserId, @NotNull final IResultListener<IUserInfo> listener) {
        final IUserInfo g16;
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final long j3 = qqUserId.yes_uid.get();
        final long j16 = qqUserId.uid.get();
        if (j3 != 0) {
            g16 = hy0.a.INSTANCE.a().a(Long.valueOf(j3));
        } else {
            g16 = hy0.a.INSTANCE.a().g(j16);
        }
        if (g16 != null) {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                listener.onSuccess(g16);
                return;
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ly0.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        k.t(IResultListener.this, g16);
                    }
                });
                return;
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: ly0.d
            @Override // java.lang.Runnable
            public final void run() {
                k.u(j3, j16, listener);
            }
        }, 32, null, true);
    }
}
