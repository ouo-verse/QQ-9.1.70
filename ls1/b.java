package ls1;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeJoinInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000f"}, d2 = {"Lls1/b;", "", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "fromClickChannel", "", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f415492a = new b();

    b() {
    }

    private final void a(FacadeArgsData facadeArgsData, JumpGuildParam jumpGuildParam, boolean fromClickChannel) {
        JumpGuildParam.JoinInfoParam joinInfoParam;
        JumpGuildParam.JoinInfoParam a16;
        String str;
        String str2;
        JumpGuildParam.JoinInfoParam a17;
        JumpGuildParam.JoinInfoParam a18;
        JumpGuildParam.JoinInfoParam a19;
        FacadeJoinInfo facadeJoinInfo = facadeArgsData.f227659i;
        GuildAppReportSourceInfo guildAppReportSourceInfo = null;
        r1 = null;
        String str3 = null;
        if (facadeJoinInfo != null) {
            joinInfoParam = facadeJoinInfo.a();
        } else {
            joinInfoParam = null;
        }
        if (joinInfoParam != null) {
            jumpGuildParam.setJoinSignature(facadeArgsData.f227659i.a().getJoinSignature());
            jumpGuildParam.setMainAndSubSource(facadeArgsData.f227659i.a().getMainSource(), facadeArgsData.f227659i.a().getSubSource());
            JumpGuildParam.JoinInfoParam joinInfoParam2 = jumpGuildParam.getJoinInfoParam();
            FacadeJoinInfo facadeJoinInfo2 = facadeArgsData.f227659i;
            if (facadeJoinInfo2 != null && (a19 = facadeJoinInfo2.a()) != null) {
                str = a19.getArkInviteCode();
            } else {
                str = null;
            }
            FacadeJoinInfo facadeJoinInfo3 = facadeArgsData.f227659i;
            if (facadeJoinInfo3 != null && (a18 = facadeJoinInfo3.a()) != null) {
                str3 = a18.getArkContentId();
            }
            joinInfoParam2.setArkJumpId(str, str3);
            JumpGuildParam.JoinInfoParam joinInfoParam3 = jumpGuildParam.getJoinInfoParam();
            FacadeJoinInfo facadeJoinInfo4 = facadeArgsData.f227659i;
            if (facadeJoinInfo4 == null || (a17 = facadeJoinInfo4.a()) == null || (str2 = a17.getInviteUUID()) == null) {
                str2 = "";
            }
            joinInfoParam3.setInviteUUID(str2);
        } else if (facadeArgsData.C != null) {
            FacadeJoinInfo facadeJoinInfo5 = facadeArgsData.f227659i;
            if (facadeJoinInfo5 != null && (a16 = facadeJoinInfo5.a()) != null) {
                jumpGuildParam.setJoinInfoParam(a16);
            }
            Bundle bundle = facadeArgsData.C;
            jumpGuildParam.extras = bundle;
            Serializable serializable = bundle.getSerializable("GuildAppReportSourceInfo");
            if (serializable instanceof GuildAppReportSourceInfo) {
                guildAppReportSourceInfo = (GuildAppReportSourceInfo) serializable;
            }
            if (guildAppReportSourceInfo != null) {
                if (fromClickChannel && TextUtils.isEmpty(guildAppReportSourceInfo.getReportInfoMap().get("sgrp_stream_pgin_into_source"))) {
                    guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_into_source", "pg_sgrp_channel");
                }
                jumpGuildParam.setReportSourceInfo(guildAppReportSourceInfo);
            }
        }
        jumpGuildParam.getExtras().putAll(facadeArgsData.C);
        jumpGuildParam.getExtras().putString("guild_id", facadeArgsData.f227656e);
        jumpGuildParam.getExtras().putString(AppConstants.Key.COLUMN_MSG_SENDER_UIN, facadeArgsData.f227656e);
        jumpGuildParam.getExtras().putInt(JumpGuildParam.EXTRA_KEY_OPEN_FROM, 1);
    }

    @NotNull
    public final JumpGuildParam b(@NotNull IGProChannelInfo channelInfo, @NotNull FacadeArgsData facadeArgsData, boolean fromClickChannel) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        JumpGuildParam jumpGuildParam = new JumpGuildParam(channelInfo.getGuildId(), channelInfo.getChannelUin());
        a(facadeArgsData, jumpGuildParam, fromClickChannel);
        jumpGuildParam.getJoinInfoParam().setAfterJoinJumpChannelId(channelInfo.getChannelUin());
        return jumpGuildParam;
    }
}
