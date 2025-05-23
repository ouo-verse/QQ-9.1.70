package com.tencent.mobileqq.zootopia.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IRedPacketApi;
import com.tencent.mobileqq.zootopia.redpacket.RedPacketDialogUtil;
import com.tencent.mobileqq.zootopia.redpacket.i;
import com.tencent.mobileqq.zootopia.redpacket.ui.RedPacketFragment;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.mobileqq.zplan.model.ZPlanMaintInfo;
import com.tencent.mobileqq.zplan.model.j;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.model.BusinessConfig;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J \u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J \u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J \u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\b\u0010\"\u001a\u00020\u001eH\u0016\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/impl/RedPacketApiImpl;", "Lcom/tencent/mobileqq/zootopia/api/IRedPacketApi;", "", "actionId", "frameCount", "width", "height", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "", "name", "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "getMemeAction", "size", "getAvatarMultipleSize", "id", "getRedPacketPreViewCover", "getRedPacketCover", "getBigRedPacketCover", "usrId", "", RedPacketApiImpl.AVATARID, "getAvatarPicSpUrl", "getAvatarPicApngUrl", "getAvatarPngUrl", "", "isShowZPlanRedPacketEntrance", "Landroid/app/Activity;", "context", "requestCode", "", "startRedPacketActivity", "isMaintenance", "isPreloadAvatar", "preloadAvatar", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RedPacketApiImpl implements IRedPacketApi {
    private static final String AVATARID = "avatarId";
    private static final int HEIGHT = 630;
    private static final int MULTIPLE = 4;
    private static final String PRELOAD_SWITCH = "zplan_redpack_preload_switch";
    private static final String TAG = "RedPacketApiImpl";
    private static final int WIDTH = 420;

    private final int getAvatarMultipleSize(int size) {
        return size - (size % 4);
    }

    private final MemeZPlanAction getMemeAction(int actionId, int frameCount, int width, int height, MODE mode, String name) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        String currentUin = waitAppRuntime != null ? waitAppRuntime.getCurrentUin() : null;
        MemeZPlanAction memeZPlanAction = new MemeZPlanAction(actionId, frameCount, width, height, mode, currentUin == null ? "" : currentUin, name);
        memeZPlanAction.getConfig().C(BusinessConfig.FrameType.PNG);
        return memeZPlanAction;
    }

    @Override // com.tencent.mobileqq.zootopia.api.IRedPacketApi
    public String getAvatarPicApngUrl(String usrId, int id5, long avatarId) {
        Intrinsics.checkNotNullParameter(usrId, "usrId");
        return i.f329070a.a(usrId, id5, avatarId);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IRedPacketApi
    public String getAvatarPicSpUrl(String usrId, int id5, long avatarId) {
        Intrinsics.checkNotNullParameter(usrId, "usrId");
        return i.f329070a.b(usrId, id5, avatarId);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IRedPacketApi
    public String getAvatarPngUrl(String usrId, int id5, long avatarId) {
        Intrinsics.checkNotNullParameter(usrId, "usrId");
        return i.f329070a.c(usrId, id5, avatarId);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IRedPacketApi
    public String getBigRedPacketCover(int id5) {
        return i.f329070a.d(id5);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IRedPacketApi
    public String getRedPacketCover(int id5) {
        return i.f329070a.f(id5);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IRedPacketApi
    public String getRedPacketPreViewCover(int id5) {
        return i.f329070a.h(id5);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IRedPacketApi
    public boolean isMaintenance() {
        return j.a(((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(MaintEntryType.ALL), new Date());
    }

    @Override // com.tencent.mobileqq.zootopia.api.IRedPacketApi
    public boolean isPreloadAvatar() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            return false;
        }
        IRuntimeService runtimeService = waitAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ava, ProcessConstant.ALL)");
        return ((IFeatureRuntimeService) runtimeService).isFeatureSwitchEnable(PRELOAD_SWITCH, false);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IRedPacketApi
    public boolean isShowZPlanRedPacketEntrance() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            return false;
        }
        IRuntimeService runtimeService = waitAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026ava, ProcessConstant.ALL)");
        return !((IFeatureRuntimeService) runtimeService).isFeatureSwitchEnable("zplan_redpack_close_switch", false) && ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(1000L, waitAppRuntime.getLongAccountUin());
    }

    @Override // com.tencent.mobileqq.zootopia.api.IRedPacketApi
    public void startRedPacketActivity(Activity context, int requestCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        ZPlanMaintInfo maintenanceInfo = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(MaintEntryType.ALL);
        if (j.a(maintenanceInfo, new Date())) {
            QLog.i(TAG, 1, "startRedPacketActivity but maintenance");
            if (context.isFinishing()) {
                return;
            }
            QLog.i(TAG, 1, "startRedPacketActivity show maintenance dialog");
            RedPacketDialogUtil.f329064a.g(context, maintenanceInfo);
            return;
        }
        ZootopiaActivity.Companion.e(ZootopiaActivity.INSTANCE, context, RedPacketFragment.class, requestCode, ZootopiaSource.INSTANCE.i(), null, 16, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0031, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    @Override // com.tencent.mobileqq.zootopia.api.IRedPacketApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void preloadAvatar() {
        Integer intOrNull;
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ava, ProcessConstant.ALL)");
        Map<String, String> isEnabledWithDataSet = ((IFeatureRuntimeService) runtimeService).isEnabledWithDataSet(PRELOAD_SWITCH, "");
        if (isEnabledWithDataSet == null || (r0 = isEnabledWithDataSet.get(AVATARID)) == null || intOrNull == null) {
            return;
        }
        int intValue = intOrNull.intValue();
        QLog.i(TAG, 1, "preload avatar id is " + intValue);
        int avatarMultipleSize = getAvatarMultipleSize(420);
        int avatarMultipleSize2 = getAvatarMultipleSize(630);
        MemeZPlanAction memeAction = getMemeAction(intValue, 1, avatarMultipleSize, avatarMultipleSize2, MODE.FRAME, String.valueOf(intValue));
        MemeZPlanAction memeAction2 = getMemeAction(intValue, -1, avatarMultipleSize, avatarMultipleSize2, MODE.SHARPP, String.valueOf(intValue));
        Meme meme = Meme.f385754h;
        Meme.y(meme, memeAction, false, null, 6, null);
        Meme.y(meme, memeAction2, false, null, 6, null);
    }
}
