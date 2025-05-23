package com.tencent.mobileqq.guild.media.core;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildThemeInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0000\u001a\n\u0010\t\u001a\u00020\u0007*\u00020\u0000\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u0007*\u00020\u0000\u001a\n\u0010\f\u001a\u00020\u000b*\u00020\u0000\u001a\n\u0010\r\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u000f\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0010\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0011\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0012\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/l;", "", DomainData.DOMAIN_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "i", "", "d", "b", "c", "", "e", tl.h.F, "f", "g", "k", "l", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class m {
    public static final boolean a(@NotNull l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        return Intrinsics.areEqual(lVar.g().getValue(), Boolean.TRUE);
    }

    @NotNull
    public static final String b(@NotNull l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        return lVar.e();
    }

    @Nullable
    public static final String c(@NotNull l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        IGProGuildThemeInfo value = lVar.Q().getValue();
        if (value != null) {
            return value.getThemeBgImg();
        }
        return null;
    }

    @NotNull
    public static final String d(@NotNull l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        return lVar.r();
    }

    public static final long e(@NotNull l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        Long value = lVar.S().getValue();
        Intrinsics.checkNotNull(value);
        return value.longValue();
    }

    public static final boolean f(@NotNull l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        EnterChannelState value = lVar.l().getValue();
        if (value != null) {
            return o.a(value);
        }
        return false;
    }

    public static final boolean g(@NotNull l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        EnterChannelState value = lVar.l().getValue();
        if (value != null) {
            return o.c(value);
        }
        return true;
    }

    public static final boolean h(@NotNull l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        EnterChannelState value = lVar.l().getValue();
        if (value != null) {
            return o.d(value);
        }
        return false;
    }

    public static final boolean i(@NotNull l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        return lVar.getSelfUserInfo().f228114v;
    }

    public static final boolean j(@NotNull l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        return lVar.getSelfUserInfo().f228113u;
    }

    public static final boolean k(@NotNull l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        if (lVar.I() != null) {
            IGProPlayInfo I = lVar.I();
            Intrinsics.checkNotNull(I);
            return Intrinsics.areEqual(String.valueOf(I.getPlayNodeExInfo().getCompereTinyid()), lVar.getSelfUserInfo().f228093a);
        }
        return false;
    }

    public static final boolean l(@NotNull l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        return Intrinsics.areEqual(lVar.i0().getValue(), Boolean.TRUE);
    }

    public static final boolean m(@NotNull l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        return lVar.getSelfUserInfo().f228101i;
    }

    public static final int n(@NotNull l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        Integer value = lVar.T().getValue();
        if (value == null) {
            value = 0;
        }
        return value.intValue();
    }
}
