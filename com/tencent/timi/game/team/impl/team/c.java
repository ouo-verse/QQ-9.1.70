package com.tencent.timi.game.team.impl.team;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.team.impl.team.c;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.w;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J(\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/timi/game/team/impl/team/c;", "", "", "roomId", "", "c", "(Ljava/lang/Long;)Ljava/lang/String;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "Lcom/tencent/timi/game/team/impl/team/TeamInfoEx;", "d", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "", "isCaptain", "Lsl4/a;", tl.h.F, "kickedUid", "Lcom/tencent/timi/game/team/impl/team/c$a;", "kickOutListener", "", "e", "<init>", "()V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f379747a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/timi/game/team/impl/team/c$a;", "", "", "success", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void success();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/team/impl/team/c$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "", "errorCode", "", "errorMessage", "", "onError", "result", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f379748a;

        b(a aVar) {
            this.f379748a = aVar;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomCmdRsp result) {
            com.tencent.timi.game.ui.widget.f.c("\u8e22\u51fa\u8f66\u961f\u6210\u529f");
            a aVar = this.f379748a;
            if (aVar != null) {
                aVar.success();
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @NotNull String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/team/impl/team/c$c", "Lrl4/c;", "Lsl4/a;", "dialog", "", "c", "d", "profileDialog", "b", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.team.impl.team.c$c, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C9980c implements rl4.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f379749a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f379750b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f379751c;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/timi/game/team/impl/team/c$c$a", "Lcom/tencent/timi/game/team/impl/team/c$a;", "", "success", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.timi.game.team.impl.team.c$c$a */
        /* loaded from: classes26.dex */
        public static final class a implements a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ sl4.a f379752a;

            a(sl4.a aVar) {
                this.f379752a = aVar;
            }

            @Override // com.tencent.timi.game.team.impl.team.c.a
            public void success() {
                this.f379752a.dismiss();
            }
        }

        C9980c(CommonOuterClass$QQUserId commonOuterClass$QQUserId, long j3, QBaseActivity qBaseActivity) {
            this.f379749a = commonOuterClass$QQUserId;
            this.f379750b = j3;
            this.f379751c = qBaseActivity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(CommonOuterClass$QQUserId qqUserId, QBaseActivity activity, sl4.a profileDialog) {
            Function1<Dialog, Unit> a16;
            Intrinsics.checkNotNullParameter(qqUserId, "$qqUserId");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(profileDialog, "$profileDialog");
            SpecialMsgUtil.Action a17 = SpecialMsgUtil.f376345a.a(qqUserId, activity);
            if (a17 != null && (a16 = a17.a()) != null) {
                a16.invoke(profileDialog);
            }
        }

        @Override // rl4.c
        public void a() {
            com.tencent.timi.game.gift.impl.timi.b.a(this.f379750b, this.f379749a, "1", this.f379751c);
        }

        @Override // rl4.c
        public void b(@NotNull final sl4.a profileDialog) {
            Intrinsics.checkNotNullParameter(profileDialog, "profileDialog");
            profileDialog.dismiss();
            final CommonOuterClass$QQUserId commonOuterClass$QQUserId = this.f379749a;
            final QBaseActivity qBaseActivity = this.f379751c;
            w.d(new Runnable() { // from class: com.tencent.timi.game.team.impl.team.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.C9980c.f(CommonOuterClass$QQUserId.this, qBaseActivity, profileDialog);
                }
            }, 500L);
        }

        @Override // rl4.c
        public void c(@NotNull sl4.a dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            c.f379747a.e(this.f379749a, new a(dialog), this.f379750b);
        }

        @Override // rl4.c
        public void d(@NotNull sl4.a dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            com.tencent.timi.game.team.impl.main.f.e(vf4.a.b(), this.f379750b);
            dialog.dismiss();
        }
    }

    c() {
    }

    private final String c(Long roomId) {
        long j3;
        String num;
        fm4.g gVar = (fm4.g) mm4.b.b(fm4.g.class);
        if (gVar != null) {
            if (roomId != null) {
                j3 = roomId.longValue();
            } else {
                j3 = 0;
            }
            gm4.c K0 = gVar.K0(j3);
            if (K0 != null && (num = Integer.valueOf(K0.o1()).toString()) != null) {
                return num;
            }
        }
        return "";
    }

    private final TeamInfoEx d(YoloRoomOuterClass$YoloRoomInfo roomInfo) {
        TeamInfoEx teamInfoEx = new TeamInfoEx(0, 1, null);
        if (roomInfo.game_data_info.common_game_data_info.gift_config.has()) {
            teamInfoEx.a(1);
        }
        return teamInfoEx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(long j3, CommonOuterClass$QQUserId kickedUid, a aVar, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(kickedUid, "$kickedUid");
        ((fm4.g) mm4.b.b(fm4.g.class)).A(j3).W(kickedUid, new b(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    public final void e(@NotNull final CommonOuterClass$QQUserId kickedUid, @Nullable final a kickOutListener, final long roomId) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(kickedUid, "kickedUid");
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        YoloRoomOuterClass$YoloRoomInfo roomInfo = ((fm4.g) mm4.b.b(fm4.g.class)).K0(roomId).getRoomInfo();
        Intrinsics.checkNotNullExpressionValue(roomInfo, "roomInfo");
        TeamInfoEx d16 = d(roomInfo);
        if (qBaseActivity == null) {
            return;
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.team.impl.team.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                c.f(roomId, kickedUid, kickOutListener, dialogInterface, i3);
            }
        };
        DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.team.impl.team.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                c.g(dialogInterface, i3);
            }
        };
        String str3 = "\u786e\u8ba4";
        if (d16.getType() == 0) {
            str = "\u786e\u8ba4\u8e22\u51fa\u8be5\u73a9\u5bb6\u5417\uff1f";
            str2 = "\u518d\u8003\u8651\u4e0b";
        } else if (d16.getType() == 1) {
            str = "\u786e\u8ba4\u79fb\u9664\u8fd9\u4f4d\u9001\u793c\u7528\u6237\u5417\uff1f";
            str2 = "\u53d6\u6d88";
        } else {
            str3 = "";
            str = "";
            str2 = str;
        }
        e.a aVar = new e.a(qBaseActivity);
        aVar.j(str);
        aVar.k(17);
        aVar.p(str3);
        aVar.o(onClickListener);
        aVar.n(str2);
        aVar.m(onClickListener2);
        com.tencent.timi.game.ui.widget.e c16 = aVar.c();
        TextView messageView = c16.getMessageView();
        messageView.setTypeface(Typeface.defaultFromStyle(1));
        messageView.setTextSize(1, 16.0f);
        ((ug4.b) mm4.b.b(ug4.b.class)).G2(c16.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), "pg_yes_smoba_team");
        ConcurrentHashMap<String, String> L = YoloRoomUtil.L(roomInfo);
        Intrinsics.checkNotNullExpressionValue(L, "getCommonRoomInfoReportParam(roomInfo)");
        L.put("yes_to_uid", String.valueOf(kickedUid.uid.get()));
        L.put("yes_to_yes_uid", nn4.a.a(kickedUid.yes_uid.get()));
        ((ug4.b) mm4.b.b(ug4.b.class)).a(c16.getPositiveButton(), true, null, "em_yes_kickout_win_confirm", L);
        ((ug4.b) mm4.b.b(ug4.b.class)).a(c16.getNegativeButton(), true, null, "em_yes_kickout_win_close", L);
        c16.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
    
        if (r5 == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        if (r5 != false) goto L28;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final sl4.a h(@NotNull QBaseActivity activity, @NotNull CommonOuterClass$QQUserId qqUserId, boolean isCaptain, long roomId) {
        CommonOuterClass$QQUserId commonOuterClass$QQUserId;
        boolean z16;
        PBUInt64Field pBUInt64Field;
        boolean z17;
        PBUInt64Field pBUInt64Field2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        gm4.c K0 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(roomId);
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = null;
        if (K0 != null) {
            commonOuterClass$QQUserId = K0.E();
        } else {
            commonOuterClass$QQUserId = null;
        }
        boolean z18 = true;
        if (qqUserId.uid.get() != 0) {
            if (commonOuterClass$QQUserId != null && (pBUInt64Field2 = commonOuterClass$QQUserId.uid) != null && qqUserId.uid.get() == pBUInt64Field2.get()) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        if (qqUserId.yes_uid.get() != 0) {
            if (commonOuterClass$QQUserId != null && (pBUInt64Field = commonOuterClass$QQUserId.yes_uid) != null && qqUserId.yes_uid.get() == pBUInt64Field.get()) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        z18 = false;
        if (K0 != null) {
            yoloRoomOuterClass$YoloRoomInfo = K0.getRoomInfo();
        }
        ConcurrentHashMap<String, String> reportParam = YoloRoomUtil.L(yoloRoomOuterClass$YoloRoomInfo);
        if (!z18) {
            reportParam.put("yes_to_uid", String.valueOf(qqUserId.uid.get()));
            reportParam.put("yes_to_yes_uid", nn4.a.a(qqUserId.yes_uid.get()));
        }
        reportParam.put("yes_game_id", c(Long.valueOf(roomId)));
        ql4.a aVar = (ql4.a) mm4.b.b(ql4.a.class);
        C9980c c9980c = new C9980c(qqUserId, roomId, activity);
        Intrinsics.checkNotNullExpressionValue(reportParam, "reportParam");
        return aVar.E2(activity, commonOuterClass$QQUserId, qqUserId, isCaptain, c9980c, reportParam, roomId);
    }
}
