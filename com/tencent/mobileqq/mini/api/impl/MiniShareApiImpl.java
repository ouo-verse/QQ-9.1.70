package com.tencent.mobileqq.mini.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.api.IMiniShareApi;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniShareApiImpl implements IMiniShareApi {
    public static final String TAG = "MiniShareApiImpl";

    @Override // com.tencent.mobileqq.mini.api.IMiniShareApi
    public void addMyMiniApp(final String str, final int i3, final MiniAppCmdInterface miniAppCmdInterface) {
        Bundle bundle = new Bundle();
        bundle.putString("appid", str);
        bundle.putInt(MiniChatConstants.MINI_APP_TOP_TYPE, 1);
        bundle.putInt("verType", i3);
        QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_SYNC_MINI_APP_DATA, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.mini.api.impl.t
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                MiniShareApiImpl.lambda$addMyMiniApp$0(str, i3, miniAppCmdInterface, eIPCResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniShareApi
    public void jumpReportPage(Context context, String str) {
        String str2;
        try {
            str2 = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            QLog.e(TAG, 1, "startReportPage exception, avatarUrl= ", e16);
            str2 = "";
        }
        jumpUrl(context, "https://tucao.qq.com/qq_miniprogram/tucao?_wwv=4&appid=" + str + "&openid=" + MainPageFragment.getUin() + "&avatar=" + str2 + HardCodeUtil.qqStr(R.string.k7o));
        QLog.d(TAG, 2, "startReportPage, prepare to upload log ");
        Bundle bundle = new Bundle();
        bundle.putString("appid", str);
        QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_UPLOAD_USER_LOG, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.mini.api.impl.MiniShareApiImpl.1
            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                QLog.e(MiniShareApiImpl.TAG, 2, " upload action callback ");
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniShareApi
    public void jumpUrl(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("hide_more_button", true);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniShareApi
    public void removeMyMiniApp(String str, int i3, MiniAppCmdInterface miniAppCmdInterface) {
        MiniAppCmdUtil.getInstance().setUserAppTop(str, 0, i3, null, miniAppCmdInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addMyMiniApp$0(String str, int i3, MiniAppCmdInterface miniAppCmdInterface, EIPCResult eIPCResult) {
        if (eIPCResult != null && eIPCResult.code == -100) {
            QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.qqStr(R.string.k7n) + MiniAppConfProcessor.d() + HardCodeUtil.qqStr(R.string.k7m), 0).show();
            return;
        }
        MiniAppCmdUtil.getInstance().setUserAppTop(str, 1, i3, null, miniAppCmdInterface);
    }
}
