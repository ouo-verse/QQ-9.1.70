package com.tencent.mobileqq.guild.guide;

import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.data.GuildSpeakParamsInfo;
import com.tencent.mobileqq.guild.data.k;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.GuildSpeakRuleManageFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.GuildSpeakRuleSettingFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r12.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJB\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0007J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J5\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\tH\u0007J\"\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\u0019\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/guide/GuildSpeakManageGuide;", "", "Lcom/tencent/mobileqq/guild/data/j;", CacheTable.TABLE_NAME, "", "guildId", "senderUid", "", "hintTextStringId", "Lkotlin/Function1;", "", "", "callback", "d", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "b", "eventId", "g", "Lkotlin/ParameterName;", "name", "canShowGuideTips", "block", "f", h.F, "hintText", "i", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildSpeakManageGuide {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildSpeakManageGuide f224623a = new GuildSpeakManageGuide();

    GuildSpeakManageGuide() {
    }

    private final IGPSService b() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return (IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "");
        }
        return null;
    }

    @JvmStatic
    @JvmOverloads
    public static final void c(@NotNull GuildSpeakParamsInfo reportInfo, @Nullable String str, @Nullable String str2, int i3) {
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        e(reportInfo, str, str2, i3, null, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void d(@NotNull final GuildSpeakParamsInfo reportInfo, @Nullable final String guildId, @Nullable String senderUid, final int hintTextStringId, @NotNull final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        GuildSpeakManageGuide guildSpeakManageGuide = f224623a;
        IGPSService b16 = guildSpeakManageGuide.b();
        if (b16 == null) {
            Logger.f235387a.d().i("GuildSpeakManageGuide", 1, "[onRecallMsg] gpsService is null");
            callback.invoke(Boolean.TRUE);
            return;
        }
        String selfTinyId = b16.getSelfTinyId();
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildSpeakManageGuide", "[onRecallMsg] selfTinyId:" + selfTinyId + ", senderUid:" + senderUid);
        }
        if (Intrinsics.areEqual(selfTinyId, senderUid)) {
            Logger.f235387a.d().i("GuildSpeakManageGuide", 1, "[onRecallMsg] recall self msg");
            callback.invoke(Boolean.TRUE);
        } else {
            guildSpeakManageGuide.f(guildId, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.guide.GuildSpeakManageGuide$needShowChannelSpeakTips$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    if (z16) {
                        GuildSpeakManageGuide.f224623a.h(guildId, hintTextStringId, reportInfo);
                    }
                    callback.invoke(Boolean.valueOf(!z16));
                }
            });
        }
    }

    public static /* synthetic */ void e(GuildSpeakParamsInfo guildSpeakParamsInfo, String str, String str2, int i3, Function1 function1, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.guide.GuildSpeakManageGuide$needShowChannelSpeakTips$1
                public final void invoke(boolean z16) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            };
        }
        d(guildSpeakParamsInfo, str, str2, i3, function1);
    }

    private final void g(String eventId, GuildSpeakParamsInfo reportInfo) {
        IGPSService b16 = b();
        if (b16 == null) {
            Logger.f235387a.d().i("GuildSpeakManageGuide", 1, "[needShowGuildTipsAsync] gpsService is null");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", reportInfo.getGuildId());
        String channelId = reportInfo.getChannelId();
        if (channelId != null) {
            hashMap.put("sgrp_sub_channel_id", channelId);
        }
        IGProChannelInfo channelInfo = b16.getChannelInfo(reportInfo.getChannelId());
        if (channelInfo != null) {
            hashMap.put("sgrp_profile_scene", Integer.valueOf(k.a(channelInfo.getType())));
        }
        Integer sceneType = reportInfo.getSceneType();
        if (sceneType != null) {
            hashMap.put("sgrp_profile_scene", Integer.valueOf(sceneType.intValue()));
        }
        IGProGuildInfo guildInfo = b16.getGuildInfo(reportInfo.getGuildId());
        if (guildInfo != null) {
            hashMap.put("sgrp_user_type", Integer.valueOf(guildInfo.getUserType()));
        }
        hashMap.put("sgrp_toast_type", Integer.valueOf(reportInfo.getToastType()));
        VideoReport.reportEvent(eventId, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(String str, QBaseActivity qBaseActivity, GuildSpeakParamsInfo reportInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(reportInfo, "$reportInfo");
        Logger logger = Logger.f235387a;
        logger.d().i("GuildSpeakManageGuide", 1, "[showCommonSpeakManageGuideToast] on click");
        if (str == null) {
            logger.d().i("GuildSpeakManageGuide", 1, "[showCommonSpeakManageGuideToast] gpsService is null");
        } else {
            QPublicFragmentActivity.b.b(qBaseActivity, GuildSpeakRuleSettingFragment.INSTANCE.a(str), QPublicFragmentActivity.class, GuildSpeakRuleManageFragment.class);
            f224623a.g("ev_sgrp_scene_guide_toast_clk", reportInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @JvmOverloads
    public final void f(@Nullable String guildId, @NotNull Function1<? super Boolean, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(Boolean.FALSE);
    }

    @JvmOverloads
    public final void h(@Nullable String guildId, int hintTextStringId, @NotNull GuildSpeakParamsInfo reportInfo) {
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        String string = BaseApplication.getContext().getResources().getString(hintTextStringId);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().resources.getString(hintTextStringId)");
        i(guildId, string, reportInfo);
    }

    public final void i(@Nullable final String guildId, @NotNull String hintText, @NotNull final GuildSpeakParamsInfo reportInfo) {
        Intrinsics.checkNotNullParameter(hintText, "hintText");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        final QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            r12.a a16 = r12.a.a(qBaseActivity, new a.C11105a(hintText, "\u53bb\u8bbe\u7f6e", 2, 0, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.guide.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildSpeakManageGuide.j(guildId, qBaseActivity, reportInfo, view);
                }
            }));
            f224623a.g("ev_sgrp_scene_guide_toast_imp", reportInfo);
            a16.b();
        }
    }
}
