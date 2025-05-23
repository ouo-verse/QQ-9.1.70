package com.tencent.timi.game.liveroom.impl.room.playtogether.util;

import ag4.i;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.liveroom.impl.room.playtogether.widget.AnchorAccountSwitchContainerView;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.utils.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameAuthOuterClass$AgreeGameAuthRsp;
import trpc.yes.common.GameRoleOuterClass$SmobaGameRoleInfo;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameRoleListRsp;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAbsInfo;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0004\u001a\u00020\u00022\u0014\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00020\u0000\u001aU\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u001a\u0010\u0003\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\r\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a\u001a\u0010\u0010\u001a\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0000\u001a\u0010\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014\u001a\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u001a\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001\u00a8\u0006\u001b"}, d2 = {"Lkotlin/Function1;", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleInfo;", "", "cb", "k", "", "isAnchor", "Lcom/tencent/mobileqq/app/QBaseActivity;", "qBaseActivity", "", "roomId", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "extraInfo", "Lkotlin/Function2;", "e", "(ZLcom/tencent/mobileqq/app/QBaseActivity;Ljava/lang/Long;Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;Lkotlin/jvm/functions/Function2;)V", "g", "role", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "ctx", DomainData.DOMAIN_NAME, "Ltrpc/yes/common/GameRoleOuterClass$SmobaGameRoleInfo;", "originalInfo", "i", "j", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class h {
    public static final void e(boolean z16, @Nullable QBaseActivity qBaseActivity, @Nullable Long l3, @Nullable LiveRoomExtraInfo liveRoomExtraInfo, @NotNull Function2<? super YesGameInfoOuterClass$YesGameRoleInfo, ? super Boolean, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (qBaseActivity == null) {
            qBaseActivity = vf4.a.b();
        }
        if (qBaseActivity == null) {
            return;
        }
        ((i) mm4.b.b(i.class)).F3(101, qBaseActivity, Boolean.FALSE, new a(qBaseActivity, z16, l3, liveRoomExtraInfo, cb5), null);
    }

    public static /* synthetic */ void f(boolean z16, QBaseActivity qBaseActivity, Long l3, LiveRoomExtraInfo liveRoomExtraInfo, Function2 function2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            qBaseActivity = null;
        }
        if ((i3 & 4) != 0) {
            l3 = null;
        }
        if ((i3 & 8) != 0) {
            liveRoomExtraInfo = null;
        }
        e(z16, qBaseActivity, l3, liveRoomExtraInfo, function2);
    }

    public static final void g(@NotNull final Function1<? super Boolean, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((i) mm4.b.b(i.class)).M1(101, new i.b() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.util.f
            @Override // ag4.i.b
            public final void i(boolean z16, int i3, String str, Object obj) {
                h.h(Function1.this, z16, i3, str, (YesGameInfoOuterClass$GetUserGameRoleListRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 cb5, boolean z16, int i3, String str, YesGameInfoOuterClass$GetUserGameRoleListRsp yesGameInfoOuterClass$GetUserGameRoleListRsp) {
        List<YesGameInfoOuterClass$YesGameRoleAbsInfo> list;
        boolean z17;
        PBRepeatMessageField<YesGameInfoOuterClass$YesGameRoleAbsInfo> pBRepeatMessageField;
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        if (z16) {
            if (yesGameInfoOuterClass$GetUserGameRoleListRsp != null && (pBRepeatMessageField = yesGameInfoOuterClass$GetUserGameRoleListRsp.role_list) != null) {
                list = pBRepeatMessageField.get();
            } else {
                list = null;
            }
            List<YesGameInfoOuterClass$YesGameRoleAbsInfo> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                cb5.invoke(Boolean.TRUE);
                return;
            }
        }
        cb5.invoke(Boolean.FALSE);
    }

    @Nullable
    public static final YesGameInfoOuterClass$YesGameRoleInfo i(@Nullable GameRoleOuterClass$SmobaGameRoleInfo gameRoleOuterClass$SmobaGameRoleInfo) {
        if (gameRoleOuterClass$SmobaGameRoleInfo != null) {
            YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo = new YesGameInfoOuterClass$YesGameRoleInfo();
            yesGameInfoOuterClass$YesGameRoleInfo.area.set(gameRoleOuterClass$SmobaGameRoleInfo.area.get());
            yesGameInfoOuterClass$YesGameRoleInfo.partition.set(gameRoleOuterClass$SmobaGameRoleInfo.partition.get());
            yesGameInfoOuterClass$YesGameRoleInfo.display_hero_list.set(gameRoleOuterClass$SmobaGameRoleInfo.display_hero_list.get());
            yesGameInfoOuterClass$YesGameRoleInfo.display_branch_list.set(gameRoleOuterClass$SmobaGameRoleInfo.display_branch_list.get());
            yesGameInfoOuterClass$YesGameRoleInfo.win_num.set(gameRoleOuterClass$SmobaGameRoleInfo.win_num.get());
            yesGameInfoOuterClass$YesGameRoleInfo.lose_num.set(gameRoleOuterClass$SmobaGameRoleInfo.lose_num.get());
            yesGameInfoOuterClass$YesGameRoleInfo.win_mvp.set(gameRoleOuterClass$SmobaGameRoleInfo.win_mvp.get());
            yesGameInfoOuterClass$YesGameRoleInfo.lose_mvp.set(gameRoleOuterClass$SmobaGameRoleInfo.lose_mvp.get());
            yesGameInfoOuterClass$YesGameRoleInfo.logic_grade_level.set(gameRoleOuterClass$SmobaGameRoleInfo.logic_grade_level.get());
            yesGameInfoOuterClass$YesGameRoleInfo.disp_grade_level.set(gameRoleOuterClass$SmobaGameRoleInfo.disp_grade_level.get());
            yesGameInfoOuterClass$YesGameRoleInfo.ranking_star.set(gameRoleOuterClass$SmobaGameRoleInfo.ranking_star.get());
            yesGameInfoOuterClass$YesGameRoleInfo.hero_count.set(gameRoleOuterClass$SmobaGameRoleInfo.hero_count.get());
            yesGameInfoOuterClass$YesGameRoleInfo.role_name.set(gameRoleOuterClass$SmobaGameRoleInfo.role_name.get());
            yesGameInfoOuterClass$YesGameRoleInfo.role_level.set(gameRoleOuterClass$SmobaGameRoleInfo.role_level.get());
            yesGameInfoOuterClass$YesGameRoleInfo.register_time.set(gameRoleOuterClass$SmobaGameRoleInfo.register_time.get());
            yesGameInfoOuterClass$YesGameRoleInfo.head_url.set(gameRoleOuterClass$SmobaGameRoleInfo.head_url.get());
            yesGameInfoOuterClass$YesGameRoleInfo.big_grade_level.set(gameRoleOuterClass$SmobaGameRoleInfo.big_grade_level.get());
            yesGameInfoOuterClass$YesGameRoleInfo.role_desc.set(gameRoleOuterClass$SmobaGameRoleInfo.role_desc.get());
            yesGameInfoOuterClass$YesGameRoleInfo.grade_level_name.set(gameRoleOuterClass$SmobaGameRoleInfo.grade_level_name.get());
            yesGameInfoOuterClass$YesGameRoleInfo.grade_level_short_name.set(gameRoleOuterClass$SmobaGameRoleInfo.grade_level_short_name.get());
            yesGameInfoOuterClass$YesGameRoleInfo.role_id.set(gameRoleOuterClass$SmobaGameRoleInfo.role_id.get());
            yesGameInfoOuterClass$YesGameRoleInfo.vip_level.set(gameRoleOuterClass$SmobaGameRoleInfo.vip_level.get());
            return yesGameInfoOuterClass$YesGameRoleInfo;
        }
        return null;
    }

    @Nullable
    public static final GameRoleOuterClass$SmobaGameRoleInfo j(@Nullable YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo) {
        if (yesGameInfoOuterClass$YesGameRoleInfo != null) {
            GameRoleOuterClass$SmobaGameRoleInfo gameRoleOuterClass$SmobaGameRoleInfo = new GameRoleOuterClass$SmobaGameRoleInfo();
            gameRoleOuterClass$SmobaGameRoleInfo.area.set(yesGameInfoOuterClass$YesGameRoleInfo.area.get());
            gameRoleOuterClass$SmobaGameRoleInfo.partition.set(yesGameInfoOuterClass$YesGameRoleInfo.partition.get());
            gameRoleOuterClass$SmobaGameRoleInfo.display_hero_list.set(yesGameInfoOuterClass$YesGameRoleInfo.display_hero_list.get());
            gameRoleOuterClass$SmobaGameRoleInfo.display_branch_list.set(yesGameInfoOuterClass$YesGameRoleInfo.display_branch_list.get());
            gameRoleOuterClass$SmobaGameRoleInfo.win_num.set(yesGameInfoOuterClass$YesGameRoleInfo.win_num.get());
            gameRoleOuterClass$SmobaGameRoleInfo.lose_num.set(yesGameInfoOuterClass$YesGameRoleInfo.lose_num.get());
            gameRoleOuterClass$SmobaGameRoleInfo.win_mvp.set(yesGameInfoOuterClass$YesGameRoleInfo.win_mvp.get());
            gameRoleOuterClass$SmobaGameRoleInfo.lose_mvp.set(yesGameInfoOuterClass$YesGameRoleInfo.lose_mvp.get());
            gameRoleOuterClass$SmobaGameRoleInfo.logic_grade_level.set(yesGameInfoOuterClass$YesGameRoleInfo.logic_grade_level.get());
            gameRoleOuterClass$SmobaGameRoleInfo.disp_grade_level.set(yesGameInfoOuterClass$YesGameRoleInfo.disp_grade_level.get());
            gameRoleOuterClass$SmobaGameRoleInfo.ranking_star.set(yesGameInfoOuterClass$YesGameRoleInfo.ranking_star.get());
            gameRoleOuterClass$SmobaGameRoleInfo.hero_count.set(yesGameInfoOuterClass$YesGameRoleInfo.hero_count.get());
            gameRoleOuterClass$SmobaGameRoleInfo.role_name.set(yesGameInfoOuterClass$YesGameRoleInfo.role_name.get());
            gameRoleOuterClass$SmobaGameRoleInfo.role_level.set(yesGameInfoOuterClass$YesGameRoleInfo.role_level.get());
            gameRoleOuterClass$SmobaGameRoleInfo.register_time.set(yesGameInfoOuterClass$YesGameRoleInfo.register_time.get());
            gameRoleOuterClass$SmobaGameRoleInfo.head_url.set(yesGameInfoOuterClass$YesGameRoleInfo.head_url.get());
            gameRoleOuterClass$SmobaGameRoleInfo.big_grade_level.set(yesGameInfoOuterClass$YesGameRoleInfo.big_grade_level.get());
            gameRoleOuterClass$SmobaGameRoleInfo.role_desc.set(yesGameInfoOuterClass$YesGameRoleInfo.role_desc.get());
            gameRoleOuterClass$SmobaGameRoleInfo.grade_level_name.set(yesGameInfoOuterClass$YesGameRoleInfo.grade_level_name.get());
            gameRoleOuterClass$SmobaGameRoleInfo.grade_level_short_name.set(yesGameInfoOuterClass$YesGameRoleInfo.grade_level_short_name.get());
            gameRoleOuterClass$SmobaGameRoleInfo.role_id.set(yesGameInfoOuterClass$YesGameRoleInfo.role_id.get());
            gameRoleOuterClass$SmobaGameRoleInfo.vip_level.set(yesGameInfoOuterClass$YesGameRoleInfo.vip_level.get());
            return gameRoleOuterClass$SmobaGameRoleInfo;
        }
        return null;
    }

    public static final void k(@NotNull final Function1<? super YesGameInfoOuterClass$YesGameRoleInfo, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ((i) mm4.b.b(i.class)).s0(101, new i.b() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.util.g
            @Override // ag4.i.b
            public final void i(boolean z16, int i3, String str, Object obj) {
                h.l(Function1.this, z16, i3, str, (YesGameInfoOuterClass$GetUserGameDefaultRoleRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 cb5, boolean z16, int i3, String str, YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp) {
        YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo;
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        if (z16) {
            if (yesGameInfoOuterClass$GetUserGameDefaultRoleRsp != null) {
                yesGameInfoOuterClass$YesGameRoleInfo = yesGameInfoOuterClass$GetUserGameDefaultRoleRsp.role_info;
            } else {
                yesGameInfoOuterClass$YesGameRoleInfo = null;
            }
            cb5.invoke(yesGameInfoOuterClass$YesGameRoleInfo);
            return;
        }
        l.e("SmobaRoleUtils", "errorCode: " + i3 + "; errorMsg: " + str);
    }

    @NotNull
    public static final String m(@Nullable YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo) {
        String str;
        if (yesGameInfoOuterClass$YesGameRoleInfo == null) {
            return "";
        }
        int i3 = yesGameInfoOuterClass$YesGameRoleInfo.partition.get();
        int i16 = i3 / 1000;
        int i17 = (i3 % 1000) - 10;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    str = "\u82f9\u679c\u5fae\u4fe1";
                } else {
                    str = "\u5b89\u5353\u5fae\u4fe1";
                }
            } else {
                str = "\u82f9\u679cQQ";
            }
        } else {
            str = "\u5b89\u5353QQ";
        }
        return str + i17 + "\u533a";
    }

    public static final void n(@NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        new e.a(ctx).q("\u9700\u8981\u7ed1\u5b9a\u4f60\u7684\u9ed8\u8ba4\u738b\u8005\u8363\u8000\u8d26\u53f7").j("\u4f60\u7684QQ\u8d26\u53f7\u6682\u65e0\u738b\u8005\u8363\u8000\u89d2\u8272\u4fe1\u606f\uff0c\u53bb\u6e38\u620f\u5185\u521b\u5efa\u540e\u624d\u53ef\u52a0\u5165\u7ec4\u961f").n("\u77e5\u9053\u4e86").m(new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.util.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                h.o(dialogInterface, i3);
            }
        }).p("\u53bb\u521b\u5efa").o(new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.util.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                h.p(dialogInterface, i3);
            }
        }).c().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        ((i) mm4.b.b(i.class)).Q2(101);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/util/h$a", "Lag4/i$a;", "Ltrpc/yes/common/GameAuthOuterClass$AgreeGameAuthRsp;", "authInfo", "", "g", "f", "", "errorCode", "", "errorMsg", "d", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements i.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f378366a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f378367b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Long f378368c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LiveRoomExtraInfo f378369d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2<YesGameInfoOuterClass$YesGameRoleInfo, Boolean, Unit> f378370e;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/util/h$a$a", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchContainerView$b;", "", "a", "Ltrpc/yes/common/GameRoleOuterClass$SmobaGameRoleInfo;", "roleRsp", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.timi.game.liveroom.impl.room.playtogether.util.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static final class C9951a implements AnchorAccountSwitchContainerView.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function2<YesGameInfoOuterClass$YesGameRoleInfo, Boolean, Unit> f378371a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.tencent.timi.game.liveroom.impl.room.playtogether.widget.b f378372b;

            /* JADX WARN: Multi-variable type inference failed */
            C9951a(Function2<? super YesGameInfoOuterClass$YesGameRoleInfo, ? super Boolean, Unit> function2, com.tencent.timi.game.liveroom.impl.room.playtogether.widget.b bVar) {
                this.f378371a = function2;
                this.f378372b = bVar;
            }

            @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.widget.AnchorAccountSwitchContainerView.b
            public void a() {
                this.f378371a.invoke(null, Boolean.TRUE);
            }

            @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.widget.AnchorAccountSwitchContainerView.b
            public void b(@Nullable GameRoleOuterClass$SmobaGameRoleInfo roleRsp) {
                this.f378371a.invoke(h.i(roleRsp), Boolean.FALSE);
                this.f378372b.dismiss();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(QBaseActivity qBaseActivity, boolean z16, Long l3, LiveRoomExtraInfo liveRoomExtraInfo, Function2<? super YesGameInfoOuterClass$YesGameRoleInfo, ? super Boolean, Unit> function2) {
            this.f378366a = qBaseActivity;
            this.f378367b = z16;
            this.f378368c = l3;
            this.f378369d = liveRoomExtraInfo;
            this.f378370e = function2;
        }

        @Override // ag4.i.a
        public void d(int errorCode, @Nullable String errorMsg) {
            l.e("SmobaRoleUtils", "authFailed # errorCode: " + errorCode + "; errorMsg: " + errorMsg);
        }

        @Override // ag4.i.a
        public void f() {
            this.f378370e.invoke(null, Boolean.TRUE);
        }

        @Override // ag4.i.a
        public void g(@NotNull GameAuthOuterClass$AgreeGameAuthRsp authInfo) {
            Intrinsics.checkNotNullParameter(authInfo, "authInfo");
            com.tencent.timi.game.liveroom.impl.room.playtogether.widget.b bVar = new com.tencent.timi.game.liveroom.impl.room.playtogether.widget.b(this.f378366a, this.f378367b, this.f378368c, this.f378369d);
            bVar.j0(new C9951a(this.f378370e, bVar));
            bVar.show();
        }

        @Override // ag4.i.c
        public void c() {
        }
    }
}
