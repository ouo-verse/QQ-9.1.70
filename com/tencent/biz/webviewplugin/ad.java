package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\\\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006Jf\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/webviewplugin/ad;", "", "", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "appid", "evilUin", "buddyFlag", "groupId", "", "d", "chatUin", "groupCode", "chatType", "uinName", "b", "appId", "Landroid/os/Bundle;", QQBrowserActivity.APP_PARAM, "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class ad {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ad f97536a = new ad();

    ad() {
    }

    public final boolean a() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("relation_tipoff_refactor_8973", false);
    }

    public final void b(@NotNull Activity activity, @NotNull String appid, @Nullable String evilUin, @Nullable String buddyFlag, @Nullable String groupId, @Nullable String chatUin, @Nullable String groupCode, @Nullable String chatType, @Nullable String uinName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appid, "appid");
        c(activity, appid, evilUin, buddyFlag, groupId, chatUin, groupCode, chatType, uinName, null);
    }

    public final void c(@NotNull Activity activity, @NotNull String appId, @Nullable String evilUin, @Nullable String buddyFlag, @Nullable String groupId, @Nullable String chatUin, @Nullable String groupCode, @Nullable String chatType, @Nullable String uinName, @Nullable Bundle extraParams) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appId, "appId");
        com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
        bVar.i(appId);
        bVar.n(evilUin);
        bVar.o(2);
        bVar.j(buddyFlag);
        bVar.s(0);
        bVar.r(groupId);
        bVar.l(chatUin);
        bVar.q(groupCode);
        bVar.k(chatType);
        bVar.w(uinName);
        if (extraParams != null) {
            bVar.p(extraParams);
        }
        ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(activity, bVar);
    }

    public final void d(@NotNull Activity activity, @NotNull String appid, @Nullable String evilUin, @Nullable String buddyFlag, @Nullable String groupId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appid, "appid");
        com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
        bVar.i(appid);
        bVar.n(evilUin);
        bVar.o(2);
        bVar.j(buddyFlag);
        bVar.s(0);
        bVar.r(groupId);
        ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(activity, bVar);
    }
}
