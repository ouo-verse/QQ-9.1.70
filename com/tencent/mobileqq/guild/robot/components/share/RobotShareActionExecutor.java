package com.tencent.mobileqq.guild.robot.components.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.api.IGuildShareToFeedApi;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.robot.api.model.share.RobotShareInGuildParams;
import com.tencent.mobileqq.guild.robot.api.model.share.RobotShareInQQParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.data.RobotInfo;
import com.tencent.robot.data.RobotShareState;
import com.tencent.robot.qrcode.api.IRobotQRCodeApi;
import com.tencent.util.QQCustomArkDialogUtil;
import com.tencent.util.QQToastUtil;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RobotShareActionExecutor {

    /* renamed from: a, reason: collision with root package name */
    private final d f232210a;

    /* renamed from: b, reason: collision with root package name */
    private final Activity f232211b;

    /* renamed from: c, reason: collision with root package name */
    private final Bundle f232212c;

    /* renamed from: d, reason: collision with root package name */
    private final IShareActionHelper f232213d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f232214e;

    public RobotShareActionExecutor(@NonNull Activity activity, @NonNull d dVar, @Nullable Bundle bundle) {
        Bundle bundle2 = new Bundle();
        this.f232212c = bundle2;
        this.f232213d = (IShareActionHelper) QRoute.api(IShareActionHelper.class);
        this.f232214e = false;
        this.f232210a = dVar;
        this.f232211b = activity;
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        this.f232214e = !((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel("robot_card");
    }

    private Intent b(String str, String str2, String str3, long j3, String str4) {
        Intent intent = new Intent();
        intent.putExtra("forward_type", 1052);
        intent.putExtra("call_by_forward", true);
        intent.putExtra("forward_ark_app_name", str);
        intent.putExtra("forward_ark_app_view", str3);
        intent.putExtra("forward_ark_app_ver", str2);
        intent.putExtra("forward_ark_app_prompt", this.f232210a.d());
        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, "QQ\u673a\u5668\u4eba\u5206\u4eab");
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        intent.putExtra("forward_ark_app_meta", str4);
        Bundle bundle = new Bundle();
        bundle.putLong("req_share_id", j3);
        bundle.putBoolean("is_ark_display_share", true);
        bundle.putString("appName", str);
        bundle.putString(QQCustomArkDialogUtil.APP_MIN_VERSION, str2);
        bundle.putString(QQCustomArkDialogUtil.APP_VIEW, str3);
        bundle.putString(QQCustomArkDialogUtil.META_DATA, str4);
        bundle.putFloat("scale", ViewUtils.getDensity());
        bundle.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, "{\"autosize\": 1, \"forward\": 1}");
        bundle.putLong("robot_id", this.f232210a.j());
        bundle.putLong("robot_uin", this.f232210a.k());
        bundle.putString("robot_name", this.f232210a.m());
        bundle.putString("robot_desc", this.f232210a.l());
        bundle.putString("robot_avatar", this.f232210a.a());
        bundle.putLong("robot_appid", this.f232210a.f());
        intent.putExtras(bundle);
        return intent;
    }

    private Intent c(int i3, String str) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        bundle.putInt("key_direct_show_uin_type", i3);
        bundle.putString("key_direct_show_uin", str);
        intent.putExtras(bundle);
        intent.putExtra("caller_name", this.f232211b.getClass().getSimpleName());
        intent.putExtra("forward_source_business_type", -1);
        intent.putExtra("forward_source_sub_business_type", "");
        return intent;
    }

    private Intent e(int i3) {
        Intent b16;
        if (i3 < 3) {
            RobotShareInQQParams i16 = this.f232210a.i();
            b16 = b("com.tencent.guild.robot.share", "1.0.0.0", "index", 101979740L, i16.b());
            b16.putExtra("ROBOT_SHARE_PARAMS", i16);
        } else {
            RobotShareInGuildParams h16 = this.f232210a.h();
            b16 = b("com.tencent.guild.robot.share", "1.0.0.0", "index", 101979740L, h16.e());
            b16.putExtra("ROBOT_SHARE_PARAMS", h16);
        }
        b16.getExtras().putInt("uintype", i3);
        return b16;
    }

    private void g(RobotShareState robotShareState) {
        ((IRobotQRCodeApi) QRoute.api(IRobotQRCodeApi.class)).openRobotQRCodeCard(this.f232211b, new RobotInfo(String.valueOf(this.f232210a.f()), this.f232210a.g(), this.f232210a.l(), this.f232210a.a(), this.f232210a.n(), "", robotShareState, false, ""), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit h(RobotShareState robotShareState) {
        QLog.d("RobotShareActionExecutor", 1, "queryRobotShareState " + robotShareState);
        if (robotShareState == RobotShareState.LIMIT) {
            QQToast.makeText(this.f232211b, 1, "\u5206\u4eab\u592a\u9891\u7e41\u4e86\uff0c\u4f11\u606f\u4f1a\u513f\u518d\u8bd5", 0).show();
            return null;
        }
        g(robotShareState);
        return null;
    }

    @NonNull
    private Bundle i() {
        if (this.f232210a == null) {
            QLog.d("RobotShareActionExecutor", 1, "[addShareLinkToPostFeedExtras]: provider should not be null");
            return Bundle.EMPTY;
        }
        Bundle bundle = new Bundle();
        bundle.putString("detail_url", this.f232210a.n());
        bundle.putString("title", this.f232210a.m());
        bundle.putString("image_url", this.f232210a.a());
        bundle.putString("desc", this.f232210a.l());
        return bundle;
    }

    private void j(@Nullable String str) {
        if (!TextUtils.isEmpty(str) && this.f232211b != null) {
            SharePublishGuildFeedParam.LinkTypeParam a16 = SharePublishGuildFeedParam.LinkTypeParam.INSTANCE.a(i());
            if (a16 != null && a16.isValid()) {
                ((IGuildShareToFeedApi) QRoute.api(IGuildShareToFeedApi.class)).shareToFeedPostAwareForbidden(this.f232211b, str, a16, GuildSharePageSource.UNKNOWN.ordinal(), null);
                return;
            } else {
                QQToastUtil.showQQToast(0, ForwardRecentActivity.NOT_SUPPORT_SHARE_TO_GUILD);
                return;
            }
        }
        QLog.e("RobotShareActionExecutor", 1, "[shareLinkInfoToPostFeed]: guildId should not be empty: " + str);
    }

    private void p(int i3) {
        this.f232213d.doShareLinkToWeChat("guildShare", i3, this.f232210a.n(), this.f232211b, String.valueOf(System.currentTimeMillis()), this.f232210a.l(), this.f232210a.m(), this.f232210a.a(), new Runnable() { // from class: com.tencent.mobileqq.guild.robot.components.share.RobotShareActionExecutor.1
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    public Intent d() {
        Intent e16 = e(0);
        e16.putExtras(i());
        return e16;
    }

    public void f() {
        ((IRobotQRCodeApi) QRoute.api(IRobotQRCodeApi.class)).queryRobotShareState(new Function1() { // from class: com.tencent.mobileqq.guild.robot.components.share.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h16;
                h16 = RobotShareActionExecutor.this.h((RobotShareState) obj);
                return h16;
            }
        });
    }

    public void k() {
        ClipboardMonitor.setPrimaryClip((ClipboardManager) this.f232211b.getSystemService("clipboard"), ClipData.newPlainText("group_pro_url", this.f232210a.b()));
        QQToast.makeText(this.f232211b, 2, this.f232210a.c(), 0).show(R.dimen.title_bar_height);
    }

    public void l() {
        Intent e16 = e(0);
        e16.putExtras(i());
        e16.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, !this.f232214e);
        RouteUtils.startActivityForResult(this.f232211b, e16, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, -1);
        if (QLog.isColorLevel()) {
            QLog.d("RobotShareActionExecutor", 1, "shareToFriend success");
        }
    }

    public void m(String str, int i3) {
        if (i3 == 10027) {
            QLog.d("RobotShareActionExecutor", 2, "[shareToFriendByUin]: uin=" + str);
            j(str);
            return;
        }
        Intent e16 = e(i3);
        e16.putExtras(c(i3, str));
        RouteUtils.startActivityForResult(this.f232211b, e16, RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS, -1);
        if (QLog.isColorLevel()) {
            QLog.d("RobotShareActionExecutor", 1, "directlyShareToFriend success");
        }
    }

    public void n() {
        RobotShareInGuildParams h16 = this.f232210a.h();
        Intent b16 = b("com.tencent.guild.robot.share", "1.0.0.0", "index", 101979740L, h16.e());
        b16.putExtra("ROBOT_SHARE_PARAMS", h16);
        b16.putExtras(i());
        QPublicFragmentActivity.startForResult(this.f232211b, b16, (Class<? extends QPublicBaseFragment>) ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getGuildForwardListFragmentClass(), -1);
        if (QLog.isColorLevel()) {
            QLog.d("RobotShareActionExecutor", 1, "shareToGuild success");
        }
    }

    public void o() {
        this.f232213d.doShareToQZoneWithLink("guildShare", this.f232211b, this.f232210a.e());
    }

    public void q() {
        if (!m02.d.i()) {
            QQToastUtil.showQQToast(R.string.f156731l0);
        } else {
            p(10);
        }
    }

    public void r() {
        if (!m02.d.i()) {
            QQToastUtil.showQQToast(R.string.f156731l0);
        } else {
            p(9);
        }
    }
}
