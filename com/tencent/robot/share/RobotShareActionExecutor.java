package com.tencent.robot.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import com.heytap.databaseengine.type.DataTableNameType;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
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
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOUniteConfigApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.robot.data.RobotInfo;
import com.tencent.robot.data.RobotShareState;
import com.tencent.robot.qrcode.QRDisplayRobotCardFragment;
import com.tencent.util.QQCustomArkDialogUtil;
import h54.RobotShareToWXConfigData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b!\u0010\"J\u001c\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/robot/share/RobotShareActionExecutor;", "", "Lkotlin/Function1;", "", "", "callback", "e", "Lorg/json/JSONObject;", "arkJson", "Landroid/content/Intent;", "f", "", "shareType", DomainData.DOMAIN_NAME, tl.h.F, "j", "uin", "type", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "i", "g", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "mActivity", "Lcom/tencent/robot/share/n;", "b", "Lcom/tencent/robot/share/n;", "mProvider", "<init>", "(Landroid/app/Activity;Lcom/tencent/robot/share/n;)V", "c", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotShareActionExecutor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity mActivity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final n mProvider;

    public RobotShareActionExecutor(@NotNull Activity mActivity, @NotNull n mProvider) {
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        Intrinsics.checkNotNullParameter(mProvider, "mProvider");
        this.mActivity = mActivity;
        this.mProvider = mProvider;
    }

    private final void e(Function1<? super String, Unit> callback) {
        this.mProvider.b(new RobotShareActionExecutor$checkShareSign$1(callback, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent f(JSONObject arkJson) {
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
        intent.putExtra("robot_appid", this.mProvider.i());
        intent.putExtra("robot_uin", this.mProvider.l());
        return intent;
    }

    private final void h(int shareType) {
        String str;
        String str2;
        RobotShareToWXConfigData robotConfigData;
        RobotShareToWXConfigData robotConfigData2;
        QRouteApi api = QRoute.api(IShareActionHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api<IShareActionHelper>(\u2026per::class.java\n        )");
        IShareActionHelper iShareActionHelper = (IShareActionHelper) api;
        h54.b bVar = (h54.b) ((IAIOUniteConfigApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOUniteConfigApi.class)).loadConfig("102606");
        if (bVar == null || (robotConfigData2 = bVar.getRobotConfigData()) == null || (str = robotConfigData2.getAioPath()) == null) {
            str = "/pages-aio/aio/aio";
        }
        if (bVar == null || (robotConfigData = bVar.getRobotConfigData()) == null || (str2 = robotConfigData.getOriginId()) == null) {
            str2 = "gh_6630fc192c4d";
        }
        String str3 = str2;
        String l3 = this.mProvider.l();
        iShareActionHelper.shareQQMiniProgramToWX("robotShare", shareType, this.mProvider.o(), this.mActivity, String.valueOf(System.currentTimeMillis()), this.mProvider.m(), this.mProvider.n(), this.mProvider.e(), str + "?robotUid=" + this.mProvider.k() + "&robotUin=" + l3 + "&from=1", str3);
    }

    private final void n(int shareType) {
        QRouteApi api = QRoute.api(IShareActionHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api<IShareActionHelper>(\u2026per::class.java\n        )");
        ((IShareActionHelper) api).doShareLinkToWeChat("robotShare", shareType, this.mProvider.o(), this.mActivity, String.valueOf(System.currentTimeMillis()), this.mProvider.m(), this.mProvider.n(), this.mProvider.e(), new Runnable() { // from class: com.tencent.robot.share.h
            @Override // java.lang.Runnable
            public final void run() {
                RobotShareActionExecutor.o();
            }
        });
    }

    public final void g() {
        v44.c.f440966a.c(new Function1<RobotShareState, Unit>() { // from class: com.tencent.robot.share.RobotShareActionExecutor$jumpToQRCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RobotShareState robotShareState) {
                invoke2(robotShareState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RobotShareState it) {
                n nVar;
                n nVar2;
                n nVar3;
                n nVar4;
                n nVar5;
                n nVar6;
                Activity activity;
                Activity activity2;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it == RobotShareState.LIMIT) {
                    activity2 = RobotShareActionExecutor.this.mActivity;
                    QQToast.makeText(activity2, 1, "\u5206\u4eab\u592a\u9891\u7e41\u4e86\uff0c\u4f11\u606f\u4f1a\u513f\u518d\u8bd5", 0).show();
                    return;
                }
                nVar = RobotShareActionExecutor.this.mProvider;
                String i3 = nVar.i();
                nVar2 = RobotShareActionExecutor.this.mProvider;
                String j3 = nVar2.j();
                nVar3 = RobotShareActionExecutor.this.mProvider;
                String m3 = nVar3.m();
                nVar4 = RobotShareActionExecutor.this.mProvider;
                String e16 = nVar4.e();
                nVar5 = RobotShareActionExecutor.this.mProvider;
                String o16 = nVar5.o();
                nVar6 = RobotShareActionExecutor.this.mProvider;
                RobotInfo robotInfo = new RobotInfo(i3, j3, m3, e16, o16, nVar6.l(), it, false, null, MsgConstant.KRMFILETHUMBSIZE384, null);
                QRDisplayRobotCardFragment.a aVar = QRDisplayRobotCardFragment.F;
                activity = RobotShareActionExecutor.this.mActivity;
                aVar.a(activity, robotInfo, 1);
            }
        });
    }

    public final void i() {
        String f16 = this.mProvider.f();
        Object systemService = this.mActivity.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("group_pro_url", f16));
        QQToast.makeText(this.mActivity, 2, this.mProvider.g(), 0).show(R.dimen.title_bar_height);
    }

    public final void j() {
        QRouteApi api = QRoute.api(ITroopUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopUtilApi::class.java)");
        final ITroopUtilApi iTroopUtilApi = (ITroopUtilApi) api;
        e(new Function1<String, Unit>() { // from class: com.tencent.robot.share.RobotShareActionExecutor$shareToFriend$1
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
                n nVar;
                Intrinsics.checkNotNullParameter(arkInfoStr, "arkInfoStr");
                ITroopUtilApi iTroopUtilApi2 = ITroopUtilApi.this;
                activity = this.mActivity;
                nVar = this.mProvider;
                iTroopUtilApi2.forwardRobotCard(activity, nVar.l(), arkInfoStr);
                if (QLog.isColorLevel()) {
                    QLog.d("robot.share.RobotShareActionExecutor", 1, "shareToFriend success");
                }
            }
        });
    }

    public final void k(@NotNull String uin, int type) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        QRouteApi api = QRoute.api(ITroopUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopUtilApi::class.java)");
        e(new RobotShareActionExecutor$shareToFriendByUin$1((ITroopUtilApi) api, this, uin, type));
    }

    public final void l() {
        e(new Function1<String, Unit>() { // from class: com.tencent.robot.share.RobotShareActionExecutor$shareToGuild$1
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
                Intent f16;
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
                f16 = RobotShareActionExecutor.this.f(jSONObject);
                f16.putExtra("call_by_forward", true);
                IGuildFeatureAdapterApi iGuildFeatureAdapterApi = (IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class);
                activity = RobotShareActionExecutor.this.mActivity;
                iGuildFeatureAdapterApi.startQQGuildForwardGuildListFragment(activity, f16, 20000);
                if (QLog.isColorLevel()) {
                    QLog.d("robot.share.RobotShareActionExecutor", 1, "shareToGuild success");
                }
            }
        });
    }

    public final void m() {
        com.tencent.mobileqq.sharehelper.d h16 = this.mProvider.h();
        QRouteApi api = QRoute.api(IShareActionHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IShareActionHelper::class.java)");
        ((IShareActionHelper) api).doShareToQZoneWithLink("robotShare", this.mActivity, h16);
    }

    public final void p() {
        n(10);
    }

    public final void q() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102606", false)) {
            if (this.mProvider.d()) {
                h(9);
                return;
            } else {
                n(9);
                return;
            }
        }
        n(9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o() {
    }
}
