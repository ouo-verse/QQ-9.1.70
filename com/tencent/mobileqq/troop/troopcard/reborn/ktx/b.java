package com.tencent.mobileqq.troop.troopcard.reborn.ktx;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.QZoneContant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/ktx/b;", "", "", WadlProxyConsts.KEY_JUMP_URL, "Lcom/tencent/mobileqq/utils/ax;", "b", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "ntTroopName", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f299536a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57112);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f299536a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull Context context, @NotNull TroopInfo troopInfo, @NotNull String ntTroopName) {
        boolean z16;
        String qqStr;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, troopInfo, ntTroopName);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        Intrinsics.checkNotNullParameter(ntTroopName, "ntTroopName");
        boolean isOwnerOrAdmin = troopInfo.isOwnerOrAdmin();
        boolean canModifyTroopName = troopInfo.canModifyTroopName();
        QLog.i("JumpUtils", 1, "[gotoEditTroopName] isOwnerOrAdmin:" + isOwnerOrAdmin + ", isNewTroop:" + troopInfo.isNewTroop + ", switch:" + troopInfo.getMemberChangeGroupNameSwitch());
        if (canModifyTroopName) {
            if (QVipBigTroopExpiredProcessor.getConfig().mIsEnable && troopInfo.mIsFreezed == 1 && isOwnerOrAdmin) {
                ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).handleModifyNameFreezedByTroopInfo(troopInfo, context);
                return;
            }
            String b16 = com.tencent.mobileqq.troop.troopsetting.modules.base.b.b(troopInfo, ntTroopName);
            String str2 = "";
            if (!troopInfo.hasSetTroopName()) {
                b16 = "";
            }
            if (!troopInfo.isQidianPrivateTroop() && !troopInfo.isNewTroop) {
                z16 = true;
            } else {
                z16 = false;
            }
            Intent intent = new Intent();
            intent.putExtra(QZoneContant.KEY_EDIT_TYPE, 1);
            intent.putExtra("edit_mode", 2);
            if (canModifyTroopName) {
                qqStr = HardCodeUtil.qqStr(R.string.kh6);
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.kh5);
            }
            intent.putExtra("title", qqStr);
            intent.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, b16);
            intent.putExtra("max_num", 96);
            intent.putExtra("canPostNull", false);
            if (!canModifyTroopName) {
                str = "";
            } else {
                str = HardCodeUtil.qqStr(R.string.kgq);
            }
            intent.putExtra("right_btn", str);
            intent.putExtra("edit_mode", canModifyTroopName);
            if (z16) {
                str2 = troopInfo.troopuin;
            }
            intent.putExtra("troopUin", str2);
            intent.putExtra("default_hint", HardCodeUtil.qqStr(R.string.f235047al));
            intent.putExtra("max_limit_mode", 1);
            RouteUtils.startActivityForResult(context, intent, RouterConstants.UI_ROUTE_EDITINFO_ACTIVITY, 18);
        }
    }

    @Nullable
    public final ax b(@NotNull String jumpUrl) {
        AppRuntime appRuntime;
        BaseQQAppInterface baseQQAppInterface;
        Context applicationContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ax) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jumpUrl);
        }
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) appRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null || (applicationContext = baseQQAppInterface.getApplicationContext()) == null) {
            return null;
        }
        return bi.c(baseQQAppInterface, applicationContext, jumpUrl);
    }
}
