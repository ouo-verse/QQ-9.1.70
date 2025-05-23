package com.tencent.comic.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.comic.VipComicHelper;
import com.tencent.comic.VipComicJumpActivity;
import com.tencent.comic.VipComicProxyActivity;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.comic.data.f;
import com.tencent.comic.ipc.QQComicIPCModule;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.comic.utils.b;
import com.tencent.comic.utils.g;
import com.tencent.comic.utils.h;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.ISecurityFileHelper;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQComicUtilImpl implements IQQComicUtil {
    public static final String TAG = "QQComicUtilImpl";

    @Override // com.tencent.comic.api.IQQComicUtil
    public String addParamToUrl(String str, String str2) {
        return h.a(str, str2);
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public void fetchReportInfo(Intent intent, boolean z16) {
        int intExtra = intent.getIntExtra("reportSourceFrom", 0);
        if (intExtra != 0) {
            String str = intExtra + "";
            f.f99344a = str;
            if (!TextUtils.isEmpty(str) && !"NULL".equalsIgnoreCase(f.f99344a)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "[webFragment] from is " + f.f99344a);
                }
            } else {
                QLog.e(TAG, 1, "[webFragment] from is null");
            }
            if (z16) {
                try {
                    URL url = new URL(intent.getStringExtra("url"));
                    f.f99346c = url.getPath().substring(url.getPath().lastIndexOf("/") + 1);
                } catch (Exception unused) {
                }
            }
            f.f99345b = intent.getStringExtra("reportActionFrom");
            f.a();
        }
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public String getActionId() {
        return f.f99345b;
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public Intent getBackgroundQQComicIntent(AppRuntime appRuntime) {
        VipComicJumpActivity.c cVar = new VipComicJumpActivity.c();
        cVar.f99204c = -1001;
        cVar.f99202a = System.currentTimeMillis();
        return VipComicJumpActivity.V2(appRuntime, cVar);
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public Class getComicJumpActivityClass() {
        return VipComicJumpActivity.class;
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public ISecurityFileHelper getComicSecurityFileHelper() {
        return new g();
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public QIPCModule getIpcModule() {
        return QQComicIPCModule.c();
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public Class<? extends Activity> getProxyActivityClass(String str) {
        return VipComicProxyActivity.getProxyActivityClass(str);
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public String getUrl(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return VipComicJumpActivity.getUrl(str, str2, str3, str4, str5, str6, str7);
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public boolean handleParam(AppRuntime appRuntime, Activity activity, Intent intent) {
        VipComicJumpActivity.c cVar = new VipComicJumpActivity.c();
        if (intent != null) {
            cVar = VipComicJumpActivity.y3(intent);
        }
        return VipComicJumpActivity.f3(appRuntime, activity, cVar);
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public boolean initPluginBeforeEnter(AppInterface appInterface, Activity activity, Intent intent) {
        if (!VipComicJumpActivity.f3(appInterface, activity, VipComicJumpActivity.y3(intent))) {
            return false;
        }
        VipComicJumpActivity.i3(appInterface, true);
        return true;
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public void initUrlMap(Intent intent) {
        h.d(intent);
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public boolean isVideoUrl(String str, Intent intent) {
        return VipComicHelper.e(str, intent);
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public void notifyFirstInObservableChanged(Context context) {
        b bVar = QQComicPluginBridge.f99474c;
        if (bVar != null) {
            bVar.a(context);
        }
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public void openQQBrowserActivityForComic(Activity activity, Intent intent, int i3) {
        VipComicHelper.f(activity, intent, i3);
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public void reportClickEventTo644(AppInterface appInterface, String str, String str2, String str3, int i3, int i16, String... strArr) {
        String[] strArr2 = {"", "", "", ""};
        if (strArr != null) {
            int length = strArr.length;
            for (int i17 = 0; i17 < length && i17 < 4; i17++) {
                if (!TextUtils.isEmpty(strArr[i17])) {
                    strArr2[i17] = strArr[i17];
                }
            }
        }
        if (appInterface instanceof BaseQQAppInterface) {
            ReportController.o(appInterface, "P_CliOper", TextUtils.isEmpty(str) ? "UNKNOWN" : str, "", str2, str3, i3, i16, strArr2[0], strArr2[1], strArr2[2], strArr2[3]);
        } else if (appInterface != null) {
            ReportController.o(appInterface, "P_CliOper", TextUtils.isEmpty(str) ? "UNKNOWN" : str, "", str2, str3, i3, i16, strArr2[0], strArr2[1], strArr2[2], strArr2[3]);
        } else {
            ReportController.o(null, "P_CliOper", TextUtils.isEmpty(str) ? "UNKNOWN" : str, "", str2, str3, i3, i16, strArr2[0], strArr2[1], strArr2[2], strArr2[3]);
        }
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public void setDefaultComicTab(String str) {
        VipComicHelper.i(str);
    }

    @Override // com.tencent.comic.api.IQQComicUtil
    public void preloadQQBoodoComic(AppRuntime appRuntime) {
    }
}
