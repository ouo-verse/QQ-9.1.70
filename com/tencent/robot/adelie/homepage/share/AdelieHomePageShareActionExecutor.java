package com.tencent.robot.adelie.homepage.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import com.heytap.databaseengine.type.DataTableNameType;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOUniteConfigApi;
import com.tencent.qqnt.kernel.nativeinterface.RobotShareScene;
import com.tencent.qqnt.kernel.nativeinterface.RobotShareTarget;
import com.tencent.util.QQCustomArkDialogUtil;
import h54.RobotShareToWXConfigData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bR\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/robot/adelie/homepage/share/AdelieHomePageShareActionExecutor;", "", "Lorg/json/JSONObject;", "arkJson", "Landroid/content/Intent;", "d", "", "shareType", "", "k", "e", "g", "", "uin", "type", h.F, "i", "j", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/robot/adelie/homepage/share/d;", "b", "Lcom/tencent/robot/adelie/homepage/share/d;", "provider", "<init>", "(Landroid/app/Activity;Lcom/tencent/robot/adelie/homepage/share/d;)V", "c", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieHomePageShareActionExecutor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d provider;

    public AdelieHomePageShareActionExecutor(@NotNull Activity activity, @NotNull d provider) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.activity = activity;
        this.provider = provider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent d(JSONObject arkJson) {
        String str;
        String str2;
        String str3;
        String str4;
        Intent intent = new Intent();
        intent.putExtra("forward_type", DataTableNameType.TABLE_WRIST_TEMPERATURE_STAT);
        String optString = arkJson.optString("app");
        if (optString == null) {
            optString = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(optString, "arkJson.optString(\"app\") ?: \"\"");
        }
        intent.putExtra("forward_ark_app_name", optString);
        String optString2 = arkJson.optString("view");
        if (optString2 == null) {
            optString2 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(optString2, "arkJson.optString(\"view\") ?: \"\"");
        }
        intent.putExtra("forward_ark_app_view", optString2);
        String optString3 = arkJson.optString("prompt");
        if (optString3 == null) {
            optString3 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(optString3, "arkJson.optString(\"prompt\") ?: \"\"");
        }
        intent.putExtra("forward_ark_app_prompt", optString3);
        String optString4 = arkJson.optString(QQCustomArkDialogUtil.BIZ_SRC);
        if (optString4 == null) {
            optString4 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(optString4, "arkJson.optString(\"bizsrc\") ?: \"\"");
        }
        intent.putExtra("forward_ark_biz_src", optString4);
        String optString5 = arkJson.optString("ver");
        if (optString5 == null) {
            optString5 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(optString5, "arkJson.optString(\"ver\") ?: \"\"");
        }
        intent.putExtra("forward_ark_app_ver", optString5);
        String optString6 = arkJson.optString(PublicAccountMessageUtilImpl.META_NAME);
        if (optString6 == null) {
            optString6 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(optString6, "arkJson.optString(\"meta\") ?: \"\"");
        }
        intent.putExtra("forward_ark_app_meta", optString6);
        String optString7 = arkJson.optString(DownloadInfo.spKey_Config);
        if (optString7 == null) {
            optString7 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(optString7, "arkJson.optString(\"config\") ?: \"\"");
        }
        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optString7);
        intent.putExtra("is_ark_display_share", true);
        intent.putExtra("robot_list_share", true);
        String optString8 = arkJson.optString("app");
        if (optString8 == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(optString8, "arkJson.optString(\"app\") ?: \"\"");
            str = optString8;
        }
        String optString9 = arkJson.optString("view");
        if (optString9 == null) {
            str2 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(optString9, "arkJson.optString(\"view\") ?: \"\"");
            str2 = optString9;
        }
        String optString10 = arkJson.optString("ver");
        if (optString10 == null) {
            str3 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(optString10, "arkJson.optString(\"ver\") ?: \"\"");
            str3 = optString10;
        }
        String optString11 = arkJson.optString(PublicAccountMessageUtilImpl.META_NAME);
        if (optString11 == null) {
            str4 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(optString11, "arkJson.optString(\"meta\") ?: \"\"");
            str4 = optString11;
        }
        intent.putExtras(QQCustomArkDialogUtil.zipArgs(str, str2, str3, str4, MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density, null, null));
        intent.putExtra(ShortVideoConstants.FROM_UIN, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        intent.putExtra("is_need_show_toast", true);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
        return intent;
    }

    private final void e(int shareType) {
        String str;
        String str2;
        String str3;
        String str4;
        RobotShareToWXConfigData robotConfigData;
        RobotShareToWXConfigData robotConfigData2;
        RobotShareToWXConfigData robotConfigData3;
        RobotShareToWXConfigData robotConfigData4;
        QRouteApi api = QRoute.api(IShareActionHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(\n            IShareA\u2026per::class.java\n        )");
        IShareActionHelper iShareActionHelper = (IShareActionHelper) api;
        com.tencent.adelie.qqmc.model.b d16 = this.provider.g().d();
        h54.b bVar = (h54.b) ((IAIOUniteConfigApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOUniteConfigApi.class)).loadConfig("102606");
        if (bVar == null || (robotConfigData4 = bVar.getRobotConfigData()) == null || (str = robotConfigData4.getFrontPath()) == null) {
            str = "pages-index/index";
        }
        String str5 = str + "?from=1";
        if (bVar == null || (robotConfigData3 = bVar.getRobotConfigData()) == null || (str2 = robotConfigData3.getOriginId()) == null) {
            str2 = "gh_6630fc192c4d";
        }
        String str6 = str2;
        if (bVar == null || (robotConfigData2 = bVar.getRobotConfigData()) == null || (str3 = robotConfigData2.getFrontTitle()) == null) {
            str3 = "\u8d85\u591a\u4fe1\u606f\u597d\u73a9\u7684\u667a\u80fd\u4f53\uff0c\u5373\u53ef\u5f00\u542f\u8da3\u5473\u4f53\u9a8c\uff01";
        }
        String str7 = str3;
        if (bVar == null || (robotConfigData = bVar.getRobotConfigData()) == null || (str4 = robotConfigData.getFrontIconUrl()) == null) {
            str4 = "https://static-res.qq.com/static-res/Bot/ark/ark.png";
        }
        iShareActionHelper.shareQQMiniProgramToWX("robotShare", shareType, d16.b(), this.activity, String.valueOf(System.currentTimeMillis()), d16.c(), str7, str4, str5, str6);
    }

    private final void k(int shareType) {
        com.tencent.adelie.qqmc.model.b a16;
        QRouteApi api = QRoute.api(IShareActionHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(\n            IShareA\u2026per::class.java\n        )");
        IShareActionHelper iShareActionHelper = (IShareActionHelper) api;
        if (shareType == 9) {
            a16 = this.provider.g().d();
        } else {
            a16 = this.provider.g().a();
        }
        iShareActionHelper.doShareLinkToWeChat("robotShare", shareType, a16.b(), this.activity, String.valueOf(System.currentTimeMillis()), a16.c(), a16.d(), a16.a(), new Runnable() { // from class: com.tencent.robot.adelie.homepage.share.a
            @Override // java.lang.Runnable
            public final void run() {
                AdelieHomePageShareActionExecutor.l();
            }
        });
    }

    public final void f() {
        String str = this.provider.d() + this.provider.g().c().b();
        Object systemService = this.activity.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("group_pro_url", str));
        QQToast.makeText(this.activity, 2, this.provider.e(), 0).show(R.dimen.title_bar_height);
    }

    public final void g() {
        QRouteApi api = QRoute.api(ITroopUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopUtilApi::class.java)");
        final ITroopUtilApi iTroopUtilApi = (ITroopUtilApi) api;
        this.provider.b(RobotShareScene.KC2C, RobotShareTarget.KROBOTLIST, new Function1<String, Unit>() { // from class: com.tencent.robot.adelie.homepage.share.AdelieHomePageShareActionExecutor$shareToFriend$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String arkInfoStr) {
                Activity activity;
                Intrinsics.checkNotNullParameter(arkInfoStr, "arkInfoStr");
                ITroopUtilApi iTroopUtilApi2 = ITroopUtilApi.this;
                activity = this.activity;
                iTroopUtilApi2.forwardRobotList(activity, arkInfoStr);
                if (QLog.isColorLevel()) {
                    QLog.d("AdelieHomePageShareActionExecutor", 1, "shareToFriend success");
                }
            }
        });
    }

    public final void h(@NotNull final String uin, final int type) {
        RobotShareScene robotShareScene;
        Intrinsics.checkNotNullParameter(uin, "uin");
        QRouteApi api = QRoute.api(ITroopUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopUtilApi::class.java)");
        final ITroopUtilApi iTroopUtilApi = (ITroopUtilApi) api;
        if (type == 1) {
            robotShareScene = RobotShareScene.KGROUP;
        } else {
            robotShareScene = RobotShareScene.KC2C;
        }
        this.provider.b(robotShareScene, RobotShareTarget.KROBOTLIST, new Function1<String, Unit>() { // from class: com.tencent.robot.adelie.homepage.share.AdelieHomePageShareActionExecutor$shareToFriendByUin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String arkInfoStr) {
                Activity activity;
                Activity activity2;
                Intrinsics.checkNotNullParameter(arkInfoStr, "arkInfoStr");
                ITroopUtilApi iTroopUtilApi2 = ITroopUtilApi.this;
                activity = this.activity;
                Bundle forwardRobotListBundle = iTroopUtilApi2.getForwardRobotListBundle(activity, arkInfoStr);
                forwardRobotListBundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                forwardRobotListBundle.putInt("key_direct_show_uin_type", 1);
                forwardRobotListBundle.putString("key_direct_show_uin", uin);
                forwardRobotListBundle.putInt("key_direct_show_uin_type", type);
                if (type == 10014) {
                    forwardRobotListBundle.putInt("forward_type", DataTableNameType.TABLE_WRIST_TEMPERATURE_STAT);
                }
                forwardRobotListBundle.putBoolean("is_need_show_toast", true);
                Intent intent = new Intent();
                intent.putExtra("isFromShare", true);
                intent.putExtras(forwardRobotListBundle);
                activity2 = this.activity;
                RouteUtils.startActivityForResult(activity2, intent, RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS, -1);
                if (QLog.isColorLevel()) {
                    QLog.d("AdelieHomePageShareActionExecutor", 1, "directlyShareToFriend success");
                }
            }
        });
    }

    public final void i() {
        this.provider.b(RobotShareScene.KCHANNEL, RobotShareTarget.KROBOTLIST, new Function1<String, Unit>() { // from class: com.tencent.robot.adelie.homepage.share.AdelieHomePageShareActionExecutor$shareToGuild$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String arkInfoStr) {
                JSONObject jSONObject;
                Intent d16;
                Activity activity;
                Intrinsics.checkNotNullParameter(arkInfoStr, "arkInfoStr");
                try {
                    jSONObject = new JSONObject(arkInfoStr);
                } catch (Throwable unused) {
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    return;
                }
                d16 = AdelieHomePageShareActionExecutor.this.d(jSONObject);
                d16.putExtra("call_by_forward", true);
                IGuildFeatureAdapterApi iGuildFeatureAdapterApi = (IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class);
                activity = AdelieHomePageShareActionExecutor.this.activity;
                iGuildFeatureAdapterApi.startQQGuildForwardGuildListFragment(activity, d16, 20000);
                if (QLog.isColorLevel()) {
                    QLog.d("AdelieHomePageShareActionExecutor", 1, "shareToGuild success");
                }
            }
        });
    }

    public final void j() {
        com.tencent.mobileqq.sharehelper.d f16 = this.provider.f();
        QRouteApi api = QRoute.api(IShareActionHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IShareActionHelper::class.java)");
        ((IShareActionHelper) api).doShareToQZoneWithLink("robotShare", this.activity, f16);
    }

    public final void m() {
        k(10);
    }

    public final void n() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102606", false)) {
            e(9);
        } else {
            k(9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l() {
    }
}
