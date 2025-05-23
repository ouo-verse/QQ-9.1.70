package com.tencent.mobileqq.notification.util;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/notification/util/a;", "", "", "uin", "", "a", "Lmqq/app/AppRuntime;", "appRuntime", "b", "Ljava/lang/String;", "TRACE_GET_RING_ID", "", "c", "Z", "shouldUseNewGetRingIdInterface", "<init>", "()V", "qq_notification_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f254337a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TRACE_GET_RING_ID;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final boolean shouldUseNewGetRingIdInterface;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25792);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f254337a = new a();
        TRACE_GET_RING_ID = "getC2CRingId";
        shouldUseNewGetRingIdInterface = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("use_new_get_ring_id_interface_910", true);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b5, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0109, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r3);
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int a(@NotNull String uin) {
        boolean z16;
        int i3;
        Integer intOrNull;
        Integer intOrNull2;
        Intrinsics.checkNotNullParameter(uin, "uin");
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        boolean z17 = false;
        if (uidFromUin != null && uidFromUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("RingIdUtil", 1, "[getC2CRingId] uid is null or empty, uin=" + uin);
            return 0;
        }
        QRouteApi api = QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IFriendsInfoService::class.java)");
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) api;
        String str = TRACE_GET_RING_ID;
        d friendsSimpleInfoWithUid = iFriendsInfoService.getFriendsSimpleInfoWithUid(uidFromUin, str);
        if (friendsSimpleInfoWithUid == null) {
            QLog.w("RingIdUtil", 1, "[getC2CRingId] simpleInfo is null, uin=" + uin);
            return 0;
        }
        QLog.i("RingIdUtil", 1, "[getC2CRingId] uin=" + uin + " uid=" + uidFromUin + " ringId=" + friendsSimpleInfoWithUid.u() + " timestamp=" + friendsSimpleInfoWithUid.l() + " simpleInfo=" + friendsSimpleInfoWithUid);
        if (!shouldUseNewGetRingIdInterface) {
            String u16 = friendsSimpleInfoWithUid.u();
            if (u16 != null && intOrNull2 != null) {
                return intOrNull2.intValue();
            }
            QLog.w("RingIdUtil", 1, "[getC2CRingId] invalid ring id, ringId=" + friendsSimpleInfoWithUid.u() + ", uin=" + uin);
            return 0;
        }
        Integer ringId = iFriendsInfoService.getRingId(uidFromUin, str);
        if (ringId != null) {
            i3 = ringId.intValue();
        } else {
            QLog.w("RingIdUtil", 1, "[getC2CRingId] ring id is null, return 0, uin=" + uin);
            i3 = 0;
        }
        if (i3 != 0) {
            String u17 = friendsSimpleInfoWithUid.u();
            if (u17 != null && intOrNull != null && i3 == intOrNull.intValue()) {
                z17 = true;
            }
            if (!z17) {
                QLog.w("RingIdUtil", 1, "[getC2CRingId] ring id is different, ringId=" + i3 + ", simpleInfo.ringId=" + friendsSimpleInfoWithUid.u() + ", uin=" + uin + " simpleInfo=" + friendsSimpleInfoWithUid);
            }
        }
        return i3;
    }

    @JvmStatic
    public static final int b(@NotNull AppRuntime appRuntime, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(uin, "uin");
        SharedPreferences sharedPreferences = appRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "appRuntime.getApp().getS\u2026xt.MODE_PRIVATE\n        )");
        return sharedPreferences.getInt(AppConstants.Preferences.SPECIAL_SOUND_TYPE + appRuntime.getCurrentAccountUin() + uin, -1);
    }
}
