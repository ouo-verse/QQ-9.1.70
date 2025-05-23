package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.paiyipai.PaiYiPaiHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IPaiYiPaiApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/PaiYiPaiApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IPaiYiPaiApi;", "Landroid/content/Context;", "context", "", "jumpToWeb", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "sendDoubleClickReq", "", "uin", "sendRevokePaiYiPaiReq", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Ljava/lang/Long;)V", "", "shouldAddGuideTip", "Ljava/text/SimpleDateFormat;", "mFormatter", "Ljava/text/SimpleDateFormat;", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PaiYiPaiApiImpl implements IPaiYiPaiApi {
    public static final String TAG = "PaiYiPaiApiImpl";
    private final SimpleDateFormat mFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.CHINESE);

    @Override // com.tencent.qqnt.aio.adapter.api.IPaiYiPaiApi
    public void jumpToWeb(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((ISettingApi) QRoute.api(ISettingApi.class)).startMainSettingPage(context, new Intent());
        ((ISettingApi) QRoute.api(ISettingApi.class)).startGeneralSettingPage(context, new Intent());
        if (VasUtil.getTempApi().isCanOpenHippyPage(HippyQQConstants.ModuleName.QQ_GXH_NUDGE_MALL)) {
            VasUtil.getTempApi().openHippyPageWithConfig(HippyQQConstants.ModuleName.QQ_GXH_NUDGE_MALL, "");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", "https://zb.vip.qq.com/v2/pages/nudgeMall?_wv=2");
        intent.putExtra("key_isReadModeEnabled", true);
        intent.putExtra("big_brother_source_key", "biz_src_jc_aio");
        context.startActivity(intent);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IPaiYiPaiApi
    public void sendDoubleClickReq(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        BusinessHandler businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.PAI_YI_PAI_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.paiyipai.PaiYiPaiHandler");
        ((PaiYiPaiHandler) businessHandler).N2(msgRecord);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IPaiYiPaiApi
    public void sendRevokePaiYiPaiReq(MsgRecord msgRecord, Long uin) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        BusinessHandler businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.PAI_YI_PAI_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.paiyipai.PaiYiPaiHandler");
        ((PaiYiPaiHandler) businessHandler).O2(msgRecord, uin != null ? uin.longValue() : 0L, 15000L);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IPaiYiPaiApi
    public synchronized boolean shouldAddGuideTip() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "handleAioMsgForDoutu error, app is not BaseQQAppInterface!");
            return false;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.activity.aio.avatardoubletap.PaiYiPaiManager");
        if (((z51.a) manager).a()) {
            return false;
        }
        String currentAccountUin = ((QQAppInterface) peekAppRuntime).getCurrentAccountUin();
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pai_yi_pai_add_guide_tip_info" + currentAccountUin, 0);
        long j3 = sharedPreferences.getLong("totalTimes", 0L);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "shouldAddGuideTip() called with: totalTimes = [" + j3 + "]");
        }
        if (j3 >= 3) {
            return false;
        }
        String format = this.mFormatter.format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "mFormatter.format(date)");
        long j16 = sharedPreferences.getLong(format, 0L);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "shouldAddGuideTip() called with: times = [" + j16 + "] in " + format);
        }
        if (j16 != 0) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(format, j16 + 1);
        edit.putLong("totalTimes", j3 + 1);
        edit.apply();
        return true;
    }
}
