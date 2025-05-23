package go0;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import vh2.av;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000f"}, d2 = {"Lgo0/i;", "", "", "state", "Landroid/content/Context;", "context", "", "d", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Lgo0/f;", "callback", "g", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f402720a = new i();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J4\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"go0/i$a", "Lvh2/av;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "searchResult", "", "b", "", "result", "", "errMsg", "failList", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements av {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f402721a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f402722b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GuildMsgItem f402723c;

        a(Context context, f fVar, GuildMsgItem guildMsgItem) {
            this.f402721a = context;
            this.f402722b = fVar;
            this.f402723c = guildMsgItem;
        }

        private final boolean b(List<? extends IGProUserInfo> searchResult) {
            boolean contains$default;
            String robotTestGuilds = searchResult.get(0).getRobotTestGuilds();
            Intrinsics.checkNotNullExpressionValue(robotTestGuilds, "searchResult[0].robotTestGuilds");
            String str = this.f402723c.getMsgRecord().guildId;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.guildId");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) robotTestGuilds, (CharSequence) str, false, 2, (Object) null);
            if (!contains$default || searchResult.get(0).getRobotPunishmentStatus() != 4) {
                return false;
            }
            return true;
        }

        @Override // vh2.av
        public void a(int result, @NotNull String errMsg, @NotNull List<? extends IGProUserInfo> searchResult, @NotNull List<String> failList) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(searchResult, "searchResult");
            Intrinsics.checkNotNullParameter(failList, "failList");
            if (result != 0) {
                if (result == 24000) {
                    i.f402720a.d(R.string.f153991dl, this.f402721a);
                    return;
                }
                return;
            }
            if (searchResult.isEmpty()) {
                return;
            }
            int i3 = 0;
            IGProUserInfo iGProUserInfo = searchResult.get(0);
            int robotMuteStatus = iGProUserInfo.getRobotMuteStatus();
            int robotPunishmentStatus = iGProUserInfo.getRobotPunishmentStatus();
            if (QLog.isColorLevel()) {
                QLog.i("RobotAtUtil", 2, "tryRobotInsert,muteStatus:" + robotMuteStatus + ", punished:" + robotPunishmentStatus + ", testGuilds:" + iGProUserInfo.getRobotTestGuilds());
            }
            if (robotMuteStatus == 1) {
                i3 = R.string.f153981dk;
            }
            if (robotPunishmentStatus != 3) {
                if (robotPunishmentStatus == 4) {
                    i3 = R.string.f153961di;
                }
            } else {
                i3 = R.string.f153971dj;
            }
            boolean b16 = b(searchResult);
            if (i3 != 0 && !b16) {
                i.f402720a.d(i3, this.f402721a);
            } else if (robotMuteStatus == 1) {
                i.f402720a.d(R.string.f153981dk, this.f402721a);
            } else {
                this.f402722b.a(this.f402723c);
            }
        }
    }

    i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(final int state, final Context context) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: go0.g
            @Override // java.lang.Runnable
            public final void run() {
                i.e(context, state);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Context context, final int i3) {
        Intrinsics.checkNotNullParameter(context, "$context");
        com.tencent.mobileqq.guild.util.qqui.c.a(context, 230).setMessage(i3).setPositiveButton(R.string.ddx, new DialogInterface.OnClickListener() { // from class: go0.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                i.f(i3, dialogInterface, i16);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3, DialogInterface dialogInterface, int i16) {
        if (QLog.isColorLevel()) {
            QLog.i("RobotAtUtil", 1, "robot is: " + i3);
        }
    }

    public final void g(@NotNull GuildMsgItem msgItem, @NotNull Context context, @NotNull f callback) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = new ArrayList();
        String str = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
        arrayList.add(str);
        ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).fetchVisibleMemberListByTinyId(msgItem.getMsgRecord().guildId, msgItem.getMsgRecord().channelId, arrayList, new a(context, callback, msgItem));
    }
}
