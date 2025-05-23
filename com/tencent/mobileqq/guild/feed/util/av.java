package com.tencent.mobileqq.guild.feed.util;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedTroopInitBean;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0017\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/av;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", "", tl.h.F, "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/feed/viewmodel/k;", "model", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "initBean", "", "e", "d", "", "businessType", "c", "(Ljava/lang/Integer;)Ljava/lang/String;", "g", "squareTabType", "a", "sortMode", "b", "f", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class av {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final av f223852a = new av();

    av() {
    }

    public final int a(int squareTabType) {
        if (squareTabType != 2) {
            if (squareTabType != 4) {
                if (squareTabType != 5) {
                    return 15;
                }
            } else {
                return 16;
            }
        }
        return 14;
    }

    public final int b(int sortMode) {
        if (sortMode == 2) {
            return 14;
        }
        return 16;
    }

    @NotNull
    public final String c(@Nullable Integer businessType) {
        boolean z16 = true;
        if ((businessType == null || businessType.intValue() != 14) && (businessType == null || businessType.intValue() != 16)) {
            z16 = false;
        }
        if (z16) {
            return "home";
        }
        return "default";
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004e  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String d(@NotNull Context context, @NotNull com.tencent.mobileqq.guild.feed.viewmodel.k model) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        boolean areEqual = Intrinsics.areEqual(model.U1().getValue(), Boolean.TRUE);
        if (model.L1().getValue() != null) {
            Long value = model.L1().getValue();
            Intrinsics.checkNotNull(value);
            if (value.longValue() != 0) {
                z16 = true;
                long serverTime = NetConnInfoCenter.getServerTime();
                if (model.T1().getValue() != null) {
                    Long value2 = model.T1().getValue();
                    Intrinsics.checkNotNull(value2);
                    if (value2.longValue() > serverTime) {
                        z17 = true;
                        if (z16) {
                            String string = context.getString(R.string.f143790n1);
                            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026can_not_publish_mute_all)");
                            return string;
                        }
                        if (z17) {
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String qqStr = HardCodeUtil.qqStr(R.string.f143800n2);
                            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_fee\u2026an_not_publish_mute_self)");
                            String format = String.format(qqStr, Arrays.copyOf(new Object[]{com.tencent.mobileqq.guild.setting.mute.c.B(model.T1().getValue())}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                            return format;
                        }
                        if (areEqual) {
                            String string2 = context.getString(R.string.f143810n3);
                            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026n_not_publish_only_admin)");
                            return string2;
                        }
                        String string3 = context.getString(R.string.f143780n0);
                        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026ild_feed_can_not_publish)");
                        return string3;
                    }
                }
                z17 = false;
                if (z16) {
                }
            }
        }
        z16 = false;
        long serverTime2 = NetConnInfoCenter.getServerTime();
        if (model.T1().getValue() != null) {
        }
        z17 = false;
        if (z16) {
        }
    }

    @NotNull
    public final String e(@NotNull Context context, @NotNull com.tencent.mobileqq.guild.feed.viewmodel.k model, @NotNull GuildFeedMainInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        if (initBean instanceof GuildFeedTroopInitBean) {
            return d(context, model);
        }
        String string = context.getString(R.string.f143780n0);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ild_feed_can_not_publish)");
        return string;
    }

    @NotNull
    public final String f(int businessType) {
        if (businessType != 5 && businessType != 14) {
            return "feed_channel";
        }
        return "feed_square";
    }

    public final int g(int businessType) {
        switch (businessType) {
            case 14:
                return 5;
            case 15:
                return 1;
            case 16:
                return 4;
            default:
                return 0;
        }
    }

    public final boolean h(@NotNull GProStFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (feed.feedType == 0) {
            return true;
        }
        return false;
    }
}
