package com.tencent.mobileqq.guild.channel.joinchannel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0002R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/x;", "", "", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "guildProfileData", "c", "d", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "b", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JumpGuildParam jumpGuildParam;

    public x(@NotNull Context context, @NotNull JumpGuildParam jumpGuildParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        this.context = context;
        this.jumpGuildParam = jumpGuildParam;
    }

    private final void a() {
        int i3;
        int extraJoinGuildSource = this.jumpGuildParam.getExtraJoinGuildSource();
        String extraJoinGuildTinyId = this.jumpGuildParam.getExtraJoinGuildTinyId();
        Bundle bundle = this.jumpGuildParam.extras;
        if (bundle != null) {
            i3 = bundle.getInt(JumpGuildParam.EXTRA_PERSON_CARD_SCENE_TYPE);
        } else {
            i3 = 6;
        }
        int i16 = i3;
        if ((extraJoinGuildSource == 1 || extraJoinGuildSource == 2) && extraJoinGuildTinyId != null) {
            GuildProfileData guildProfileData = new GuildProfileData(this.jumpGuildParam.guildId, "", extraJoinGuildTinyId, 6, i16);
            Context context = this.context;
            if (context instanceof Activity) {
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    c((Activity) this.context, guildProfileData);
                    return;
                }
            }
            QBaseActivity sTopActivity = QBaseActivity.sTopActivity;
            if (sTopActivity != null) {
                Intrinsics.checkNotNullExpressionValue(sTopActivity, "sTopActivity");
                c(sTopActivity, guildProfileData);
            } else {
                Logger.f235387a.d().i("Guild.join.StepJump2JoinSuccessDialog", 1, "openProfileCard failed");
            }
        }
    }

    private final void c(Activity activity, GuildProfileData guildProfileData) {
        GuildProfileCard.Mh(activity, guildProfileData, new b());
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final JumpGuildParam getJumpGuildParam() {
        return this.jumpGuildParam;
    }

    public final void d() {
        if (Intrinsics.areEqual(this.jumpGuildParam.getMainSource(), "small_world_distribution")) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.join.StepJump2JoinSuccessDialog", 2, "guildTabShow. " + getJumpGuildParam().getMainSource() + " dont show JoinGuildSuccessDialog");
            }
            com.tencent.mobileqq.guild.util.qqui.g.c(2, R.string.f147300wi);
            return;
        }
        com.tencent.mobileqq.guild.util.qqui.g.c(2, R.string.f147300wi);
        a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/channel/joinchannel/x$b", "Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/card/GuildProfileCard$e;", "", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements GuildProfileCard.e {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard.e
        public void a() {
            Logger.f235387a.d().i("Guild.join.StepJump2JoinSuccessDialog", 1, "GuildProfileCard onCardShow");
        }

        @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard.e
        public /* synthetic */ void c() {
            com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.h.a(this);
        }

        @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard.e
        public void b() {
        }
    }
}
