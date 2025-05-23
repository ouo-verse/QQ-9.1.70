package com.tencent.mobileqq.vas.social.config;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.ISquareOnlineStatusHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/p;", "Lcom/tencent/state/square/ISquareOnlineStatusHelper;", "", "getBatteryCapacity", "batteryCapacity", "type", "Landroid/graphics/Bitmap;", "getBatteryDrawable", "", "isBatteryPowerConnect", "id", "Landroid/graphics/drawable/Drawable;", "getDiyStatusDrawable", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class p implements ISquareOnlineStatusHelper {
    @Override // com.tencent.state.square.ISquareOnlineStatusHelper
    public int getBatteryCapacity() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getBatteryCapacity();
        }
        return 0;
    }

    @Override // com.tencent.state.square.ISquareOnlineStatusHelper
    public Bitmap getBatteryDrawable(int batteryCapacity, int type) {
        Bitmap onlineStatusBatteryIcon = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusBatteryIcon(batteryCapacity, type);
        Intrinsics.checkNotNullExpressionValue(onlineStatusBatteryIcon, "api(IOnLineStatueHelperA\u2026on(batteryCapacity, type)");
        return onlineStatusBatteryIcon;
    }

    @Override // com.tencent.state.square.ISquareOnlineStatusHelper
    public Drawable getDiyStatusDrawable(int id5, int type) {
        try {
            if (type == 1) {
                int convertToLocal = QQSysFaceUtil.convertToLocal(id5);
                if (QLog.isColorLevel()) {
                    QLog.i("VasSquareOnlineStatusHelper", 1, "localId: " + convertToLocal);
                }
                return QQSysFaceUtil.getFaceDrawable(convertToLocal);
            }
            QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(type);
            int localId = resImpl.getLocalId(id5);
            if (QLog.isColorLevel()) {
                QLog.i("VasSquareOnlineStatusHelper", 1, "localId: " + localId);
            }
            return resImpl.getDrawable(localId);
        } catch (Exception unused) {
            QLog.e("VasSquareOnlineStatusHelper", 1, "id: " + id5 + ", type: " + type);
            return null;
        }
    }

    @Override // com.tencent.state.square.ISquareOnlineStatusHelper
    public boolean isBatteryPowerConnect() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return peekAppRuntime != null && ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getPowerConnect() == 1;
    }
}
