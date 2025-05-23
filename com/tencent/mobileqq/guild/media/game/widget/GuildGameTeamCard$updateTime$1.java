package com.tencent.mobileqq.guild.media.game.widget;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildGameTeamCard$updateTime$1", "Ljava/util/TimerTask;", TencentLocation.RUN_MODE, "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildGameTeamCard$updateTime$1 extends TimerTask {
    final /* synthetic */ GuildGameTeamCard this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildGameTeamCard$updateTime$1(GuildGameTeamCard guildGameTeamCard) {
        this.this$0 = guildGameTeamCard;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildGameTeamCard this$0) {
        long j3;
        TextView textView;
        long j16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long j17 = 1000;
        long currentTimeMillis = System.currentTimeMillis() / j17;
        j3 = this$0.mGameStartTime;
        long j18 = ((currentTimeMillis - j3) / 60) + 1;
        textView = this$0.mRoomState;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this$0.getResources().getString(R.string.f1376007a, Long.valueOf(j18));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.game_started, time)");
        String format = String.format(string, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
        long currentTimeMillis2 = System.currentTimeMillis() / j17;
        j16 = this$0.mGameStartTime;
        QLog.i("QMGame.GuildGameTeamCard", 1, "time: " + j18 + ", cur: " + currentTimeMillis2 + ", start: " + j16);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        boolean z16;
        z16 = this.this$0.mGameStarted;
        if (z16) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final GuildGameTeamCard guildGameTeamCard = this.this$0;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.game.widget.u
                @Override // java.lang.Runnable
                public final void run() {
                    GuildGameTeamCard$updateTime$1.b(GuildGameTeamCard.this);
                }
            });
        }
    }
}
