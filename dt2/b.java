package dt2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.listentogether.api.IListenTogetherApi;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.shortcut.actions.TroopShortcutAction;
import com.tencent.mobileqq.troop.shortcut.actions.a;
import com.tencent.mobileqq.troop.utils.r;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQZoneGroupAlbumArkUtil;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J:\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0010H\u0002J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100\u00152\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a8\u0006\u001e"}, d2 = {"Ldt2/b;", "Lcom/tencent/mobileqq/troop/shortcut/actions/a;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "troopUin", "", "appId", "", h.F, "Lcom/tencent/mobileqq/app/QQAppInterface;", "appRuntime", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "", "e", "f", "isFreezedLiangTroop", "Lkotlin/Triple;", "d", "Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction;", "action", "Lcom/tencent/mobileqq/troop/shortcut/actions/b;", "shortcutContext", "a", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements com.tencent.mobileqq.troop.shortcut.actions.a {
    private final boolean e(QQAppInterface appRuntime, Context context, Activity activity, TroopInfo troopInfo, String troopUin, int appId) {
        IQZoneGroupAlbumArkUtil iQZoneGroupAlbumArkUtil = (IQZoneGroupAlbumArkUtil) QRoute.api(IQZoneGroupAlbumArkUtil.class);
        if (iQZoneGroupAlbumArkUtil.isFromShortcutUrl(appId)) {
            iQZoneGroupAlbumArkUtil.jumpToGroupAlbumEntry(context, troopUin);
            return true;
        }
        switch (appId) {
            case IChatSettingForTroopApi.APPID_TOGETHERLISTEN /* 101761547 */:
                ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).gotoListenTogetherSettingPage(activity, 1, troopUin, 0);
                return true;
            case IChatSettingForTroopApi.APPID_TOGETHERSING /* 101817424 */:
                r.g(appRuntime, activity, troopInfo, troopUin);
                return true;
            case IChatSettingForTroopApi.APPID_TEACHERMESSAGE /* 101847770 */:
                Intent intent = new Intent();
                intent.putExtra("troop_uin", troopUin);
                intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 19);
                intent.putExtra(AppConstants.Key.TROOP_INFO_MEMBER_NUM, troopInfo.wMemberNum);
                RouteUtils.startActivity(context, intent, "/troop/memberlist/TroopMemberList");
                return true;
            case IChatSettingForTroopApi.APPID_EC_WINDOW /* 102061052 */:
                r.i(activity, troopInfo, appRuntime.getCurrentUin());
                return true;
            case IChatSettingForTroopApi.APPID_HW_NOTICE /* 102075478 */:
                ((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).openNoticeListPage(activity, troopUin);
                return true;
            case IChatSettingForTroopApi.APPID_HW_CLOCKIN /* 102083361 */:
                ((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).openClockInListPage(activity, troopUin);
                return true;
            case IChatSettingForTroopApi.APPID_MULTI_TROOP_MANAGE /* 1109863013 */:
                Intent intent2 = new Intent();
                intent2.putExtra("troop_uin", troopUin);
                intent2.putExtra("is_from_app_item_clk", true);
                ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openTroopManageForResult(activity, intent2, troopInfo.isOwner(), 8);
                return true;
            default:
                return false;
        }
    }

    private final void f(Context context, String troopUin, TroopInfo troopInfo) {
        QVipBigTroopExpiredConfig config = QVipBigTroopExpiredProcessor.getConfig();
        Intrinsics.checkNotNull(config, "null cannot be cast to non-null type com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredConfig");
        if (config.mIsEnable && troopInfo.mIsFreezed == 1 && troopInfo.isOwnerOrAdmin()) {
            final boolean a16 = TroopManager.g.a(troopInfo.groupFreezeReason);
            if (!troopInfo.isOwner()) {
                ff.d0(context, a16);
                return;
            }
            Triple<Integer, String, Integer> d16 = d(a16);
            int intValue = d16.component1().intValue();
            String component2 = d16.component2();
            int intValue2 = d16.component3().intValue();
            String spannableString = ff.j(0, intValue).toString();
            Intrinsics.checkNotNullExpressionValue(spannableString, "getExpiredString(0, expiredType).toString()");
            ff.b0(context, troopUin, spannableString, HardCodeUtil.qqStr(R.string.j6l), new DialogInterface.OnClickListener() { // from class: dt2.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    b.g(a16, dialogInterface, i3);
                }
            }, component2, intValue2, a16);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcut.actions.a
    public boolean a(TroopShortcutAction action, com.tencent.mobileqq.troop.shortcut.actions.b shortcutContext) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(shortcutContext, "shortcutContext");
        if (action.f() != TroopShortcutAction.Type.APP_ID && action.f() != TroopShortcutAction.Type.SCHEMA) {
            return false;
        }
        AppRuntime c16 = shortcutContext.c();
        QQAppInterface qQAppInterface = c16 instanceof QQAppInterface ? (QQAppInterface) c16 : null;
        if (qQAppInterface == null) {
            QLog.e("TroopShortcut.AppIdActionProcessor", 1, "check params failed for appRuntime is " + shortcutContext.c());
            return false;
        }
        Context d16 = shortcutContext.d();
        if (d16 == null) {
            QLog.e("TroopShortcut.AppIdActionProcessor", 1, "check params failed for context is null");
            return false;
        }
        FragmentActivity a16 = shortcutContext.a();
        if (a16 == null) {
            QLog.e("TroopShortcut.AppIdActionProcessor", 1, "check params failed for activity is null");
            return false;
        }
        TroopInfo e16 = shortcutContext.e(action.e());
        if (e16 == null) {
            QLog.e("TroopShortcut.AppIdActionProcessor", 1, "check params failed for troopUin is null");
            return false;
        }
        if (e(qQAppInterface, d16, a16, e16, action.e(), Integer.parseInt(action.a()))) {
            return true;
        }
        h(d16, e16, action.e(), Long.parseLong(action.a()));
        return false;
    }

    @Override // com.tencent.mobileqq.troop.shortcut.actions.a
    public void b(com.tencent.mobileqq.troop.shortcut.actions.b bVar) {
        a.C8771a.b(this, bVar);
    }

    @Override // com.tencent.mobileqq.troop.shortcut.actions.a
    public void destroy() {
        a.C8771a.a(this);
    }

    private final Triple<Integer, String, Integer> d(boolean isFreezedLiangTroop) {
        if (isFreezedLiangTroop) {
            return new Triple<>(15, "0X800A57F", 1);
        }
        return new Triple<>(8, "0X8009E38", 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(boolean z16, DialogInterface dialogInterface, int i3) {
        if (z16) {
            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A57F", 2, 0, "", "", "", "");
        }
    }

    private final void h(Context context, TroopInfo troopInfo, String troopUin, long appId) {
        if (appId == 1101236949) {
            f(context, troopUin, troopInfo);
        } else if (appId == 101914115) {
            QQGameTroopManager.p(0, troopUin, false);
        }
    }
}
