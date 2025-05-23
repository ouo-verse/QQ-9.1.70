package com.tencent.mobileqq.gamecenter.api.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.gamecenter.api.IGameCenterAioEggApi;
import com.tencent.mobileqq.gamecenter.trpcprotocol.AioEggSpring2024Svr$CollectActionReq;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameCenterAioEggApiImpl implements IGameCenterAioEggApi {
    private static final String CMD_EGG_REQ = "trpc.gamecenter.aio_egg_spring_2024.AioEggSpring2024.SsoCollectAction";
    public static final String TAG = "GameCenterAioEggApiImpl";

    private void openSchema(Context context, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "[openSchema], schema:" + str);
        }
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent();
                intent.setData(Uri.parse(str));
                intent.setPackage(context.getPackageName());
                context.startActivity(intent);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "[openSchema], th:", th5);
            }
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterAioEggApi
    public void jumpWeb(Context context, String str, int i3, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            if (str.startsWith("mqqapi://")) {
                openSchema(context, str);
                return;
            } else {
                QLog.e(TAG, 1, "[], url NOT supported");
                return;
            }
        }
        if (com.tencent.mobileqq.webview.util.s.h(str, 2).contains("ti.qq.com")) {
            ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).openSpringHbWebView(context, str, i3, str2, true, bundle);
            return;
        }
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
        intent.putExtra("url", str);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0098 A[Catch: all -> 0x00a6, TryCatch #1 {all -> 0x00a6, blocks: (B:3:0x0004, B:8:0x0069, B:10:0x0098, B:13:0x009f, B:21:0x0063, B:6:0x003c, B:17:0x004c, B:20:0x005d), top: B:2:0x0004, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x009f A[Catch: all -> 0x00a6, TRY_LEAVE, TryCatch #1 {all -> 0x00a6, blocks: (B:3:0x0004, B:8:0x0069, B:10:0x0098, B:13:0x009f, B:21:0x0063, B:6:0x003c, B:17:0x004c, B:20:0x005d), top: B:2:0x0004, inners: #0 }] */
    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterAioEggApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void triggerEggReq(boolean z16, int i3, int i16, String str, String str2, String str3, String str4) {
        AppRuntime peekAppRuntime;
        try {
            AioEggSpring2024Svr$CollectActionReq aioEggSpring2024Svr$CollectActionReq = new AioEggSpring2024Svr$CollectActionReq();
            aioEggSpring2024Svr$CollectActionReq.qq_version.set(AppSetting.n());
            aioEggSpring2024Svr$CollectActionReq.proactive.set(z16);
            aioEggSpring2024Svr$CollectActionReq.act_id.set(str4);
            aioEggSpring2024Svr$CollectActionReq.egg_id.set(Integer.valueOf(str2).intValue());
            aioEggSpring2024Svr$CollectActionReq.scene.set(i3);
            aioEggSpring2024Svr$CollectActionReq.platform.set(2);
            aioEggSpring2024Svr$CollectActionReq.key_word.set(str3);
            try {
            } catch (Throwable unused) {
                QLog.w(TAG, 1, "uin transfer error");
            }
            if (i16 == 1) {
                aioEggSpring2024Svr$CollectActionReq.friend_uin.set(Long.valueOf(str).longValue());
            } else if (i16 == 2) {
                aioEggSpring2024Svr$CollectActionReq.group_id.set(Long.valueOf(str).longValue());
            } else {
                if (i16 == 4) {
                    aioEggSpring2024Svr$CollectActionReq.channel_id.set(str);
                }
                NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, com.tencent.gamecenter.wadl.biz.b.class);
                Bundle bundle = new Bundle();
                bundle.putString(WadlProxyConsts.EXTRA_CMD, CMD_EGG_REQ);
                bundle.putByteArray(WadlProxyConsts.PARAM_WEBSSO_REQ, aioEggSpring2024Svr$CollectActionReq.toByteArray());
                bundle.putInt(WadlProxyConsts.KEY_SSO_TYPE, 2);
                peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    QLog.e(TAG, 2, "[getAutoDownloadTask] appRuntime is null");
                    return;
                } else {
                    newIntent.putExtras(bundle);
                    peekAppRuntime.startServlet(newIntent);
                    return;
                }
            }
            NewIntent newIntent2 = new NewIntent(MobileQQ.sMobileQQ, com.tencent.gamecenter.wadl.biz.b.class);
            Bundle bundle2 = new Bundle();
            bundle2.putString(WadlProxyConsts.EXTRA_CMD, CMD_EGG_REQ);
            bundle2.putByteArray(WadlProxyConsts.PARAM_WEBSSO_REQ, aioEggSpring2024Svr$CollectActionReq.toByteArray());
            bundle2.putInt(WadlProxyConsts.KEY_SSO_TYPE, 2);
            peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
            }
        } catch (Throwable th5) {
            QLog.w(TAG, 1, "[triggerEggReq], th:", th5);
        }
    }
}
