package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.guild.config.subconfig.parser.GuildNewUserNoticeConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/util/l;", "", "", "a", "", "channelType", "c", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f235569a = new l();

    l() {
    }

    private final boolean a() {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_sgrp_guide_newuser_open_push");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance()\n          \u2026_GUIDE_NEWUSER_OPEN_PUSH)");
        if (expEntity.isExperiment("exp_sgrp_guide_newuser_open_push_A")) {
            expEntity.reportExpExposure();
            QLog.d("GuildChannelMsgNotifyUtil", 1, "showNewUserMsgNotify| EXP_SGRP_GUIDE_NEWUSER_OPEN_PUSH_A, false");
            return false;
        }
        if (expEntity.isExperiment("exp_sgrp_guide_newuser_open_push_B")) {
            expEntity.reportExpExposure();
            QLog.d("GuildChannelMsgNotifyUtil", 1, "showNewUserMsgNotify| EXP_SGRP_GUIDE_NEWUSER_OPEN_PUSH_B, true");
            return true;
        }
        QLog.d("GuildChannelMsgNotifyUtil", 1, "showNewUserMsgNotify| NOTHING, true");
        return true;
    }

    public final boolean b() {
        GuildNewUserNoticeConfigParser.b bVar;
        if (!a() || (bVar = (GuildNewUserNoticeConfigParser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100531")) == null) {
            return false;
        }
        return bVar.getNeedShow();
    }

    public final boolean c(int channelType) {
        if (channelType != 5 && channelType != 8 && channelType != 2) {
            return false;
        }
        return true;
    }
}
