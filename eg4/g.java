package eg4;

import ag4.i;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.timi.game.component.gamecore.impl.db.UserGameInfoEntity;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.utils.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameRoleListRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0012J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0012J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0012J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015J\u0016\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0018\u00a8\u0006!"}, d2 = {"Leg4/g;", "", "", "yesGameId", "Lcom/tencent/timi/game/component/gamecore/impl/db/UserGameInfoEntity;", "p", "entity", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "authInfo", "v", "roleListRsp", ReportConstant.COSTREPORT_PREFIX, "defaultRole", "y", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameRoleListRsp;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lag4/i$b;", "callback", DomainData.DOMAIN_NAME, "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "j", "k", "Ltrpc/yes/common/GameAuthOuterClass$GetGameAuthRsp;", "g", h.F, "rsp", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", "t", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f396273a = new g();

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int i3, i.b bVar) {
        GameAuthOuterClass$GetGameAuthRsp g16 = f396273a.g(i3);
        if (g16 != null) {
            if (bVar != null) {
                bVar.i(true, 0, "", g16);
            }
        } else if (bVar != null) {
            bVar.i(false, 0, "", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(int i3, i.b bVar) {
        YesGameInfoOuterClass$GetUserGameDefaultRoleRsp j3 = f396273a.j(i3);
        if (j3 != null) {
            if (bVar != null) {
                bVar.i(true, 0, "", j3);
            }
        } else if (bVar != null) {
            bVar.i(false, 0, "", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(int i3, i.b bVar) {
        YesGameInfoOuterClass$GetUserGameRoleListRsp m3 = f396273a.m(i3);
        if (m3 != null) {
            if (bVar != null) {
                bVar.i(true, 0, "", m3);
            }
        } else if (bVar != null) {
            bVar.i(false, 0, "", null);
        }
    }

    private final synchronized UserGameInfoEntity p(int yesGameId) {
        UserGameInfoEntity userGameInfoEntity;
        String uin = ((ll4.a) mm4.b.b(ll4.a.class)).B();
        YesDataBaseHelper f16 = YesDataBaseHelper.f();
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        List<? extends Entity> k3 = f16.k(UserGameInfoEntity.class, true, "uin = ? AND yesGameId = ?", new String[]{uin, String.valueOf(yesGameId)}, null, null, null, null);
        l.i("UserGameInfoManager_", "loadUserGameInfoFromDB entityList:" + k3);
        if (k3 != null && (true ^ k3.isEmpty())) {
            userGameInfoEntity = (UserGameInfoEntity) k3.get(0);
        } else {
            userGameInfoEntity = null;
        }
        return userGameInfoEntity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(int i3, YesGameInfoOuterClass$GetUserGameRoleListRsp yesGameInfoOuterClass$GetUserGameRoleListRsp) {
        byte[] bArr;
        g gVar = f396273a;
        if (yesGameInfoOuterClass$GetUserGameRoleListRsp != null) {
            bArr = yesGameInfoOuterClass$GetUserGameRoleListRsp.toByteArray();
        } else {
            bArr = null;
        }
        gVar.s(i3, bArr);
    }

    private final synchronized void s(int yesGameId, byte[] roleListRsp) {
        UserGameInfoEntity p16 = p(yesGameId);
        if (p16 == null) {
            p16 = UserGameInfoEntity.INSTANCE.a(yesGameId);
        }
        p16.accountListInfo = roleListRsp;
        z(p16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(int i3, GameAuthOuterClass$GetGameAuthRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        f396273a.v(i3, rsp.toByteArray());
    }

    private final synchronized void v(int yesGameId, byte[] authInfo) {
        UserGameInfoEntity p16 = p(yesGameId);
        if (p16 == null) {
            p16 = UserGameInfoEntity.INSTANCE.a(yesGameId);
        }
        p16.authDescInfo = authInfo;
        z(p16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(int i3, YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp) {
        byte[] bArr;
        g gVar = f396273a;
        if (yesGameInfoOuterClass$GetUserGameDefaultRoleRsp != null) {
            bArr = yesGameInfoOuterClass$GetUserGameDefaultRoleRsp.toByteArray();
        } else {
            bArr = null;
        }
        gVar.y(i3, bArr);
    }

    private final synchronized void y(int yesGameId, byte[] defaultRole) {
        UserGameInfoEntity p16 = p(yesGameId);
        if (p16 == null) {
            p16 = UserGameInfoEntity.INSTANCE.a(yesGameId);
        }
        p16.defaultAccountInfo = defaultRole;
        z(p16);
    }

    private final synchronized void z(UserGameInfoEntity entity) {
        boolean z16;
        l.i("UserGameInfoManager_", "saveUserGameInfoToDB entity:" + entity);
        if (entity.uin.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            l.i("UserGameInfoManager_", "saveUserGameInfoToDB bad uin!");
            return;
        }
        l.i("UserGameInfoManager_", "saveUserGameInfoToDB insertOrUpdateEntity:" + YesDataBaseHelper.f().h(entity));
    }

    @Nullable
    public final GameAuthOuterClass$GetGameAuthRsp g(int yesGameId) {
        byte[] bArr;
        UserGameInfoEntity p16 = p(yesGameId);
        GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp = null;
        if (p16 != null) {
            bArr = p16.authDescInfo;
        } else {
            bArr = null;
        }
        if (bArr == null) {
            l.i("UserGameInfoDbUtils_", "getAuthDescInfoFromDB null.");
            return null;
        }
        GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp2 = new GameAuthOuterClass$GetGameAuthRsp();
        try {
            gameAuthOuterClass$GetGameAuthRsp2.mergeFrom(p16.authDescInfo);
            gameAuthOuterClass$GetGameAuthRsp = gameAuthOuterClass$GetGameAuthRsp2;
        } catch (Exception e16) {
            l.f("UserGameInfoDbUtils_", "getAuthDescInfoFromDB failed!", e16);
        }
        l.i("UserGameInfoDbUtils_", "getAuthDescInfoFromDB rsp:" + gameAuthOuterClass$GetGameAuthRsp);
        return gameAuthOuterClass$GetGameAuthRsp;
    }

    public final void h(final int yesGameId, @Nullable final i.b<GameAuthOuterClass$GetGameAuthRsp> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: eg4.c
            @Override // java.lang.Runnable
            public final void run() {
                g.i(yesGameId, callback);
            }
        }, 32, null, true);
    }

    @Nullable
    public final YesGameInfoOuterClass$GetUserGameDefaultRoleRsp j(int yesGameId) {
        byte[] bArr;
        UserGameInfoEntity p16 = p(yesGameId);
        YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp = null;
        if (p16 != null) {
            bArr = p16.defaultAccountInfo;
        } else {
            bArr = null;
        }
        if (bArr == null) {
            l.i("UserGameInfoDbUtils_", "getUserDefaultAccountFromDB null.");
            return null;
        }
        YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp2 = new YesGameInfoOuterClass$GetUserGameDefaultRoleRsp();
        try {
            yesGameInfoOuterClass$GetUserGameDefaultRoleRsp2.mergeFrom(p16.defaultAccountInfo);
            yesGameInfoOuterClass$GetUserGameDefaultRoleRsp = yesGameInfoOuterClass$GetUserGameDefaultRoleRsp2;
        } catch (Exception e16) {
            l.f("UserGameInfoDbUtils_", "getUserDefaultAccountFromDB failed!", e16);
        }
        l.i("UserGameInfoDbUtils_", "getUserDefaultAccountFromDB rsp:" + yesGameInfoOuterClass$GetUserGameDefaultRoleRsp);
        return yesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
    }

    public final void k(final int yesGameId, @Nullable final i.b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: eg4.e
            @Override // java.lang.Runnable
            public final void run() {
                g.l(yesGameId, callback);
            }
        }, 32, null, true);
    }

    @Nullable
    public final YesGameInfoOuterClass$GetUserGameRoleListRsp m(int yesGameId) {
        byte[] bArr;
        UserGameInfoEntity p16 = p(yesGameId);
        YesGameInfoOuterClass$GetUserGameRoleListRsp yesGameInfoOuterClass$GetUserGameRoleListRsp = null;
        if (p16 != null) {
            bArr = p16.accountListInfo;
        } else {
            bArr = null;
        }
        if (bArr == null) {
            l.i("UserGameInfoDbUtils_", "getUserGameRoleListRspFromDB null.");
            return null;
        }
        YesGameInfoOuterClass$GetUserGameRoleListRsp yesGameInfoOuterClass$GetUserGameRoleListRsp2 = new YesGameInfoOuterClass$GetUserGameRoleListRsp();
        try {
            yesGameInfoOuterClass$GetUserGameRoleListRsp2.mergeFrom(p16.accountListInfo);
            yesGameInfoOuterClass$GetUserGameRoleListRsp = yesGameInfoOuterClass$GetUserGameRoleListRsp2;
        } catch (Exception e16) {
            l.f("UserGameInfoDbUtils_", "getUserGameRoleListRspFromDB failed!", e16);
        }
        l.i("UserGameInfoDbUtils_", "getUserGameRoleListRspFromDB rsp:" + yesGameInfoOuterClass$GetUserGameRoleListRsp);
        return yesGameInfoOuterClass$GetUserGameRoleListRsp;
    }

    public final void n(final int yesGameId, @Nullable final i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: eg4.b
            @Override // java.lang.Runnable
            public final void run() {
                g.o(yesGameId, callback);
            }
        }, 32, null, true);
    }

    public final void q(final int yesGameId, @Nullable final YesGameInfoOuterClass$GetUserGameRoleListRsp rsp) {
        ThreadManagerV2.excute(new Runnable() { // from class: eg4.f
            @Override // java.lang.Runnable
            public final void run() {
                g.r(yesGameId, rsp);
            }
        }, 32, null, true);
    }

    public final void t(final int yesGameId, @NotNull final GameAuthOuterClass$GetGameAuthRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        ThreadManagerV2.excute(new Runnable() { // from class: eg4.d
            @Override // java.lang.Runnable
            public final void run() {
                g.u(yesGameId, rsp);
            }
        }, 32, null, true);
    }

    public final void w(final int yesGameId, @Nullable final YesGameInfoOuterClass$GetUserGameDefaultRoleRsp rsp) {
        ThreadManagerV2.excute(new Runnable() { // from class: eg4.a
            @Override // java.lang.Runnable
            public final void run() {
                g.x(yesGameId, rsp);
            }
        }, 32, null, true);
    }
}
