package com.tencent.mobileqq.zplan.emoticon.api.impl;

import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.zplan.aio.panel.panel.view.AioPanelLayout;
import com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi;
import com.tencent.mobileqq.zplan.emoticon.detail.ZPlanEmoticonDetailExpGroup;
import com.tencent.mobileqq.zplan.emoticon.detail.ZPlanEmoticonDetailManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.api.IRobotIdentityApi;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.zplan.common.utils.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016R\u0014\u0010\u0015\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/api/impl/ZPlanEmoticonApi;", "Lcom/tencent/mobileqq/zplan/emoticon/api/IZPlanEmoticonApi;", "", "checkCreateRole", "Lcom/tencent/mobileqq/zplan/emoticon/api/IZPlanEmoticonApi$b;", "zPlanEmoticonDetailRequestListener", "", "setZPlanEmoticonDetailView", "Landroid/content/Context;", "context", "", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "Landroid/widget/RelativeLayout;", "generateZPlanAioPanelLayout", "", "peerUin", "updateVersion", "getVersion", "friendUin", "jumpFromSource", "jumpToEmoticon", "TAG", "Ljava/lang/String;", "version", "I", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonApi implements IZPlanEmoticonApi {
    private static final String TAG = "ZPlanEmoticonApi";
    public static final ZPlanEmoticonApi INSTANCE = new ZPlanEmoticonApi();
    private static int version = 1;

    ZPlanEmoticonApi() {
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi
    public boolean checkCreateRole() {
        if (!ZPlanQQMC.INSTANCE.enableCreateRoleFromEmoticon()) {
            QLog.i(TAG, 1, "checkCreateRole failed, enableCreateRoleFromEmoticon false.");
            return false;
        }
        ZPlanEmoticonDetailManager zPlanEmoticonDetailManager = ZPlanEmoticonDetailManager.f333107a;
        boolean p16 = zPlanEmoticonDetailManager.p();
        ZPlanEmoticonDetailExpGroup g16 = zPlanEmoticonDetailManager.g();
        QLog.i(TAG, 1, "checkCreateRole, isDefault: " + p16 + ", tabExpGroup: " + g16);
        return p16 && g16 == ZPlanEmoticonDetailExpGroup.GROUP_AVATAR_JUMP_TO_CREATE_ROLE;
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi
    public RelativeLayout generateZPlanAioPanelLayout(Context context, int sessionType) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (getVersion(sessionType) == 2) {
            return new AioPanelLayout(context, null, 0, 6, null);
        }
        return new RelativeLayout(context);
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi
    public int getVersion(int sessionType) {
        QLog.i(TAG, 1, "getVersion, version:" + version + ", sessionType:" + sessionType);
        if (sessionType == 0) {
            return version;
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi
    public void jumpToEmoticon(Context context, String friendUin, String jumpFromSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(jumpFromSource, "jumpFromSource");
        QLog.i(TAG, 1, "jumpToEmoticon, context:" + context + ", friendUin:" + i.a(friendUin) + ", jumpFromSource:" + jumpFromSource);
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(context), null);
        m3.putExtra("uin", friendUin);
        m3.putExtra("uintype", 0);
        m3.putExtra(AppConstants.Key.OPEN_ZPLAN_EMOTICON_TAB, true);
        m3.putExtra(AppConstants.Key.OPEN_ZPLAN_EMOTICON_TAB_SOURCE, jumpFromSource);
        context.startActivity(m3);
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi
    public void setZPlanEmoticonDetailView(IZPlanEmoticonApi.b zPlanEmoticonDetailRequestListener) {
        Intrinsics.checkNotNullParameter(zPlanEmoticonDetailRequestListener, "zPlanEmoticonDetailRequestListener");
        ZPlanEmoticonDetailManager.f333107a.r(zPlanEmoticonDetailRequestListener);
    }

    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi
    public void updateVersion(int sessionType, String peerUin) {
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        boolean hasAvatarFeature = ((IZPlanAIOWhiteListApi) QRoute.api(IZPlanAIOWhiteListApi.class)).hasAvatarFeature();
        boolean z16 = false;
        int i3 = 1;
        boolean z17 = sessionType == 0 && ((IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class)).isRobotUin(peerUin);
        QLog.i(TAG, 1, "updateVersion, hasCoupleAvatarFeature:" + hasAvatarFeature);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.getCurrentUin().equals(peerUin)) {
            z16 = true;
        }
        if (hasAvatarFeature && !z17 && !z16) {
            i3 = 2;
        }
        version = i3;
    }
}
