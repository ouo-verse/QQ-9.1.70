package com.tencent.mobileqq.guild.util;

import android.os.Build;
import com.tencent.mobileqq.guild.config.QQGuildMCBean;
import com.tencent.mobileqq.guild.config.QQGuildMCParser;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u0002H\u0007J\b\u0010\u000b\u001a\u00020\u0002H\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u0006H\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0007J\b\u0010\u000f\u001a\u00020\u0004H\u0007J\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0004\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/util/bs;", "", "", "l", "", "b", "", "e", "i", "j", "k", "a", "f", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "Lcom/tencent/mobileqq/guild/config/y;", "c", "configId", "Lcom/tencent/mobileqq/guild/config/QQGuildMCBean;", tl.h.F, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bs {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bs f235483a = new bs();

    bs() {
    }

    @JvmStatic
    public static final boolean a() {
        com.tencent.mobileqq.guild.config.y c16 = f235483a.c();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.config.QQGuildConfigUtil", 2, "getAddQQFriendManage:" + c16.M0);
        }
        return c16.M0;
    }

    @JvmStatic
    @NotNull
    public static final String b() {
        String str = f235483a.c().S;
        Intrinsics.checkNotNullExpressionValue(str, "configBean.mClientIdentityIconPrefix");
        return str;
    }

    @JvmStatic
    @NotNull
    public static final String d() {
        return QQGuildMCParser.INSTANCE.f("100561", "guildHelpAndFeedbackUrl", "https://ifeedback.qq.com/platform/feedback?app_id=950");
    }

    @JvmStatic
    public static final int e() {
        return QQGuildMCParser.INSTANCE.d("102984", "verificationThreshold", 990);
    }

    @JvmStatic
    @NotNull
    public static final String f() {
        com.tencent.mobileqq.guild.config.y c16 = f235483a.c();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.config.QQGuildConfigUtil", 2, "getMediaChannelSecurityMsg:" + c16.A0);
        }
        String str = c16.A0;
        Intrinsics.checkNotNullExpressionValue(str, "configBean.mMediaChannelSecurityMsg");
        return str;
    }

    @JvmStatic
    public static final int g() {
        com.tencent.mobileqq.guild.config.y c16 = f235483a.c();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.config.QQGuildConfigUtil", 2, "mMicSequenceTime:" + c16.N0);
        }
        return c16.N0;
    }

    @JvmStatic
    @NotNull
    public static final String i() {
        com.tencent.mobileqq.guild.config.y c16 = f235483a.c();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.config.QQGuildConfigUtil", 2, "getRobotFaqUrl:" + c16.f216282w0);
        }
        String str = c16.f216282w0;
        Intrinsics.checkNotNullExpressionValue(str, "configBean.mRobotFaqUrl");
        return str;
    }

    @JvmStatic
    @NotNull
    public static final String j() {
        com.tencent.mobileqq.guild.config.y c16 = f235483a.c();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.config.QQGuildConfigUtil", 2, "getRobotFaqUrl:" + c16.f216284x0);
        }
        String str = c16.f216284x0;
        Intrinsics.checkNotNullExpressionValue(str, "configBean.mRobotRequirementPageUrl");
        return str;
    }

    @JvmStatic
    public static final boolean k() {
        return QQGuildMCParser.INSTANCE.c("100540", "speakThresholdFaceAuth", true);
    }

    @JvmStatic
    public static final boolean l() {
        return QQGuildMCParser.INSTANCE.c("100592", "isChannelNumberSearchableOpen", false);
    }

    @JvmStatic
    public static final boolean m() {
        com.tencent.mobileqq.guild.config.y c16 = f235483a.c();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.config.QQGuildConfigUtil", 2, "mEnableListenTogetherPreload:" + c16.J0);
        }
        if (Build.VERSION.SDK_INT >= c16.J0) {
            return true;
        }
        return false;
    }

    @NotNull
    public final com.tencent.mobileqq.guild.config.y c() {
        Object x16 = com.tencent.mobileqq.config.am.s().x(733);
        Intrinsics.checkNotNullExpressionValue(x16, "getSingleton().loadConOb\u2026dConfProcessor.CONFIG_ID)");
        return (com.tencent.mobileqq.guild.config.y) x16;
    }

    @NotNull
    public final QQGuildMCBean h(@NotNull String configId) {
        Intrinsics.checkNotNullParameter(configId, "configId");
        QQGuildMCBean e16 = QQGuildMCParser.INSTANCE.e(configId);
        if (e16 == null) {
            return new QQGuildMCBean();
        }
        return e16;
    }
}
