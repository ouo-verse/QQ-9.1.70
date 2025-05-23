package com.tencent.mobileqq.troop.troopnotification.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J(\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/utils/d;", "", "Landroid/content/Context;", "context", "", "memberUin", "Lcom/tencent/qqnt/notification/f;", "msg", "groupUin", "", "e", "b", WadlProxyConsts.KEY_JUMP_URL, "g", "c", "f", tl.h.F, "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f300927a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59763);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f300927a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(Context context, String memberUin) {
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(memberUin);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        if (iFriendsInfoService.isFriend(uid, "TroopNotificationJumpUtils")) {
            ProfileUtils.openProfileCard(context, new AllInOne(memberUin, 1));
            return;
        }
        AllInOne allInOne = new AllInOne(memberUin, 26);
        allInOne.chatAbility = 1;
        ProfileUtils.openProfileCard(context, allInOne);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, "\u7fa4\u804a\u5df2\u89e3\u6563", 0).show();
    }

    private final void e(Context context, String memberUin, com.tencent.qqnt.notification.f msg2, String groupUin) {
        AllInOne allInOne = new AllInOne(memberUin, 24);
        Bundle bundle = new Bundle();
        bundle.putString("troop_uin", groupUin);
        int i3 = msg2.j().originMsgType;
        bundle.putInt("flc_notify_type", i3);
        if (i3 == 2 || i3 == 22) {
            bundle.putString("flc_recommend_uin", memberUin);
        }
        if (i3 != 1 && i3 != 22) {
            if (i3 != 12) {
                if (i3 == 13) {
                    allInOne.subSourceId = 3;
                }
            } else {
                allInOne.subSourceId = 2;
            }
        } else {
            allInOne.subSourceId = 1;
        }
        allInOne.extras.putBundle("flc_extra_param", bundle);
        ProfileUtils.openProfileCard(context, allInOne);
    }

    public final void c(@NotNull final Context context, @NotNull String groupUin, @NotNull com.tencent.qqnt.notification.f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, groupUin, msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.j().originMsgType == 8) {
            bg.k(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.utils.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.d(context);
                }
            });
            return;
        }
        Bundle b16 = aq.b(groupUin, 4);
        b16.putInt("t_s_f", 1001);
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).openTroopInfoActivity(context, b16, 2);
    }

    public final void f(@NotNull Context context, @Nullable String groupUin, @NotNull String memberUin, @NotNull com.tencent.qqnt.notification.f msg2) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, groupUin, memberUin, msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (memberUin.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("TroopNotificationJumpUtils", 1, "launchMemberCard: memberUin is null");
        }
        if (groupUin == null || groupUin.length() == 0) {
            z17 = true;
        }
        if (!z17 && TroopInfoRepo.INSTANCE.getTroopInfoFromCache(groupUin) != null) {
            e(context, memberUin, msg2, groupUin);
        } else {
            b(context, memberUin);
        }
    }

    public final void g(@NotNull Context context, @NotNull String jumpUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) jumpUrl);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        ((IReadInJoyUtils) QRoute.api(IReadInJoyUtils.class)).jumpToUrl(context, jumpUrl);
    }

    public final void h(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d("TroopNotificationJumpUtils", 1, "openDetailPage");
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", "https://act.qzone.qq.com/v2/vip/tx/p/48495_6eae02f9");
        intent.putExtra("webStyle", "noBottomBar");
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        if (context instanceof Activity) {
            context.startActivity(intent);
        }
    }
}
