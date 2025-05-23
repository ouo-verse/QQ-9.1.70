package com.tencent.qqnt.robot.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.guild.aio.msglist.markdown.innerkeyboard.BtnCallBackHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.utils.e;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.aio.settings.NTFriendSettingHelper;
import com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator;
import com.tencent.qqnt.robot.api.IRobotExtApi;
import com.tencent.qqnt.robot.chatsetting.RobotSettingGroup;
import cooperation.qzone.panorama.util.PanoramaConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\u001a\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002H\u0016J$\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J0\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J(\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u000fH\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\f\u0010\"\u001a\u0006\u0012\u0002\b\u00030!H\u0016J \u0010&\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\nH\u0016\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/robot/api/impl/RobotExtApiImpl;", "Lcom/tencent/qqnt/robot/api/IRobotExtApi;", "", "", "Lkotlin/Function0;", "Lcom/tencent/aio/main/businesshelper/h;", "getRobotBaseHelpers", "Lmqq/app/AppRuntime;", "appRuntime", "uin", "", "fetchIfNotExist", "getBuddyName", "Landroid/content/Context;", "context", "", "status", "promptType", QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT, "promptIcon", "", "handleOnBackendReply", "isNetWorkAvailable", "getSkinAIOPanelIconBgResId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "bundle", "uinType", "shareRobotLocalPicToFriend", "shareRobotLocalPicToGuild", "", "createRobotSettingGroup", "Ljava/lang/Class;", "getRobotSettingGroupClass", PanoramaConfig.KEY_CURRENT_UIN, "currentUid", "isChecked", "setMsgNotDisturb", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RobotExtApiImpl implements IRobotExtApi {
    @Override // com.tencent.qqnt.robot.api.IRobotExtApi
    public Object createRobotSettingGroup(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new RobotSettingGroup(context);
    }

    @Override // com.tencent.qqnt.robot.api.IRobotExtApi
    public String getBuddyName(AppRuntime appRuntime, String uin, boolean fetchIfNotExist) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        return ac.g(appRuntime, uin, fetchIfNotExist);
    }

    @Override // com.tencent.qqnt.robot.api.IRobotExtApi
    public Map<String, Function0<h>> getRobotBaseHelpers() {
        return new RobotBaseHelpersCreator().a();
    }

    @Override // com.tencent.qqnt.robot.api.IRobotExtApi
    public Class<?> getRobotSettingGroupClass() {
        return RobotSettingGroup.class;
    }

    @Override // com.tencent.qqnt.robot.api.IRobotExtApi
    public int getSkinAIOPanelIconBgResId() {
        return R.drawable.skin_aio_panel_icon_bg;
    }

    @Override // com.tencent.qqnt.robot.api.IRobotExtApi
    public void handleOnBackendReply(Context context, int status, int promptType, String promptText, int promptIcon) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promptText, "promptText");
        BtnCallBackHandler.INSTANCE.c(context, status, promptType, promptText, promptIcon);
    }

    @Override // com.tencent.qqnt.robot.api.IRobotExtApi
    public boolean isNetWorkAvailable() {
        return NetworkUtil.isNetworkAvailable();
    }

    @Override // com.tencent.qqnt.robot.api.IRobotExtApi
    public void setMsgNotDisturb(String currentUin, String currentUid, boolean isChecked) {
        Intrinsics.checkNotNullParameter(currentUin, "currentUin");
        Intrinsics.checkNotNullParameter(currentUid, "currentUid");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        NTFriendSettingHelper.f352067a.P(new NTFriendSettingHelper.a(qQAppInterface, currentUin, currentUid, isChecked, 0), true);
    }

    @Override // com.tencent.qqnt.robot.api.IRobotExtApi
    public void shareRobotLocalPicToFriend(Activity activity, Bundle bundle, String uin, int uinType) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(uin, "uin");
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        bundle.putBoolean("key_allow_multiple_forward_from_limit", false);
        bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        bundle.putInt("key_direct_show_uin_type", uinType);
        bundle.putString("key_direct_show_uin", uin);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ForwardBaseOption.startForwardActivityForResult(activity, intent, (Class<?>) ForwardRecentTranslucentActivity.class, 19005, ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getSharePanelType(), "biz_src_jc_photo");
    }

    @Override // com.tencent.qqnt.robot.api.IRobotExtApi
    public void shareRobotLocalPicToGuild(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        bundle.putBoolean("key_allow_multiple_forward_from_limit", false);
        bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        e.c(activity, intent);
    }
}
