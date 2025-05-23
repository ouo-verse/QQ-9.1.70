package com.tencent.mobileqq.troop.selectmember.config;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0004*\u00020\u0000\u001a\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007*\u00020\u0000\u00a2\u0006\u0004\b\b\u0010\t\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u0004*\u00020\u0000\u001a\u0014\u0010\r\u001a\u00020\f*\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0004*\u00020\u0000\u001a\f\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u0000\u001a\u0014\u0010\u0010\u001a\u00020\f*\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u001a\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007*\u00020\u0000\u00a2\u0006\u0004\b\u0011\u0010\t\u001a!\u0010\u0013\u001a\u00020\f*\u00020\u00002\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a\f\u0010\u0015\u001a\u0004\u0018\u00010\u0004*\u00020\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "", "i", "j", "", "a", "b", "", "f", "(Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;)[Ljava/lang/String;", "g", PushClientConstants.TAG_CLASS_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "c", "k", "e", "clazzNameArray", "l", "(Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;[Ljava/lang/String;)V", "d", "qqtroop-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    @NotNull
    public static final String a(@NotNull TroopSelectMemberConfig troopSelectMemberConfig) {
        Intrinsics.checkNotNullParameter(troopSelectMemberConfig, "<this>");
        return troopSelectMemberConfig.o().c();
    }

    @NotNull
    public static final String b(@NotNull TroopSelectMemberConfig troopSelectMemberConfig) {
        Intrinsics.checkNotNullParameter(troopSelectMemberConfig, "<this>");
        return troopSelectMemberConfig.o().a();
    }

    @Nullable
    public static final String c(@NotNull TroopSelectMemberConfig troopSelectMemberConfig) {
        Intrinsics.checkNotNullParameter(troopSelectMemberConfig, "<this>");
        return troopSelectMemberConfig.e().a();
    }

    @Nullable
    public static final String d(@NotNull TroopSelectMemberConfig troopSelectMemberConfig) {
        Intrinsics.checkNotNullParameter(troopSelectMemberConfig, "<this>");
        return troopSelectMemberConfig.e().b();
    }

    @NotNull
    public static final String[] e(@NotNull TroopSelectMemberConfig troopSelectMemberConfig) {
        Intrinsics.checkNotNullParameter(troopSelectMemberConfig, "<this>");
        return troopSelectMemberConfig.e().c();
    }

    @NotNull
    public static final String[] f(@NotNull TroopSelectMemberConfig troopSelectMemberConfig) {
        Intrinsics.checkNotNullParameter(troopSelectMemberConfig, "<this>");
        return troopSelectMemberConfig.e().e();
    }

    @Nullable
    public static final String g(@NotNull TroopSelectMemberConfig troopSelectMemberConfig) {
        Intrinsics.checkNotNullParameter(troopSelectMemberConfig, "<this>");
        return troopSelectMemberConfig.e().f();
    }

    @Nullable
    public static final String h(@NotNull TroopSelectMemberConfig troopSelectMemberConfig) {
        Intrinsics.checkNotNullParameter(troopSelectMemberConfig, "<this>");
        return troopSelectMemberConfig.e().g();
    }

    public static final boolean i(@NotNull TroopSelectMemberConfig troopSelectMemberConfig) {
        Intrinsics.checkNotNullParameter(troopSelectMemberConfig, "<this>");
        if (troopSelectMemberConfig.q().length() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean j(@NotNull TroopSelectMemberConfig troopSelectMemberConfig) {
        Intrinsics.checkNotNullParameter(troopSelectMemberConfig, "<this>");
        return troopSelectMemberConfig.o().b();
    }

    public static final void k(@NotNull TroopSelectMemberConfig troopSelectMemberConfig, @Nullable String str) {
        Intrinsics.checkNotNullParameter(troopSelectMemberConfig, "<this>");
        troopSelectMemberConfig.e().j(str);
    }

    public static final void l(@NotNull TroopSelectMemberConfig troopSelectMemberConfig, @NotNull String[] clazzNameArray) {
        Intrinsics.checkNotNullParameter(troopSelectMemberConfig, "<this>");
        Intrinsics.checkNotNullParameter(clazzNameArray, "clazzNameArray");
        troopSelectMemberConfig.e().k(clazzNameArray);
    }

    public static final void m(@NotNull TroopSelectMemberConfig troopSelectMemberConfig, @Nullable String str) {
        Intrinsics.checkNotNullParameter(troopSelectMemberConfig, "<this>");
        troopSelectMemberConfig.e().l(str);
    }
}
