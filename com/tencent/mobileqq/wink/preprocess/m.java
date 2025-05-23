package com.tencent.mobileqq.wink.preprocess;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.request.QQWinkGetHokBattleInfoReq;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import mqq.app.MobileQQ;
import qbattle.QQBattleInfo$GetShareBattleVideoInfoRsp;

/* compiled from: P */
/* loaded from: classes21.dex */
public class m {
    public static boolean c(Context context, boolean z16) {
        String string;
        if (context == null) {
            return false;
        }
        try {
            WinkContext.Companion companion = WinkContext.INSTANCE;
            String p16 = companion.d().p(QQWinkConstants.WINK_SHARE_APPID);
            String p17 = companion.d().p(QQWinkConstants.WINK_SHARE_PKGNAME);
            if (p16 != null && p17 != null) {
                QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).removeKey("wink_share_tag" + p16);
                if (z16) {
                    string = context.getString(R.string.f216365y4);
                } else {
                    string = context.getString(R.string.f216355y3);
                }
                try {
                    xp3.b.e((Activity) context, p17, z16, Long.parseLong(p16), string);
                    ((Activity) context).finish();
                    return true;
                } catch (Exception e16) {
                    QLog.e("WinkShareUtils", 1, e16, new Object[0]);
                }
            }
            return false;
        } catch (Exception e17) {
            QLog.e("WinkShareUtils", 1, "WinkContext not init = " + e17);
            return false;
        }
    }

    public static String d(String str) {
        if (!QZoneShareManager.GLORY_OF_KINGS.equals(str) && !"1104791911".equals(str)) {
            return "";
        }
        return "wangzheapp";
    }

    public static void e(final String str, final String str2, final String str3, final String str4) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.preprocess.k
            @Override // java.lang.Runnable
            public final void run() {
                m.h(str2, str3, str4, str);
            }
        }, 16, null, false);
    }

    public static String f() {
        String p16 = WinkContext.INSTANCE.d().p(QQWinkConstants.WINK_SHARE_APPID);
        if (TextUtils.isEmpty(p16)) {
            return "";
        }
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).decodeString("wink_share_tag" + p16, "");
        if (!TextUtils.isEmpty(decodeString)) {
            QLog.e("WinkShareUtils", 1, "getTags" + decodeString);
            return decodeString;
        }
        if (!p16.equals(QZoneShareManager.GLORY_OF_KINGS) && !p16.equals("1104791911")) {
            if (!p16.equals("1111058862")) {
                return "";
            }
            return MobileQQ.sMobileQQ.getApplicationContext().getString(R.string.f216405y8);
        }
        return MobileQQ.sMobileQQ.getApplicationContext().getString(R.string.f216395y7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(String str, BaseRequest baseRequest, boolean z16, long j3, String str2, QQBattleInfo$GetShareBattleVideoInfoRsp qQBattleInfo$GetShareBattleVideoInfoRsp) {
        if (z16 && j3 == 0 && qQBattleInfo$GetShareBattleVideoInfoRsp != null) {
            if (qQBattleInfo$GetShareBattleVideoInfoRsp.titles.get().size() > 0) {
                String str3 = "";
                for (String str4 : qQBattleInfo$GetShareBattleVideoInfoRsp.titles.get()) {
                    if (!TextUtils.isEmpty(str4)) {
                        str3 = str3 + "#" + str4 + " ";
                    }
                }
                QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).encodeString("wink_share_tag" + str, str3);
                return;
            }
            QLog.e("WinkShareUtils", 1, "return titles 0");
            return;
        }
        QLog.e("WinkShareUtils", 1, "retCode:" + j3 + ", errMsg:" + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(String str, String str2, String str3, final String str4) {
        VSNetworkHelper.getInstance().sendRequest(MobileQQ.sMobileQQ, new QQWinkGetHokBattleInfoReq(str, str2, str3), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.preprocess.l
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str5, Object obj) {
                m.g(str4, baseRequest, z16, j3, str5, (QQBattleInfo$GetShareBattleVideoInfoRsp) obj);
            }
        });
    }
}
