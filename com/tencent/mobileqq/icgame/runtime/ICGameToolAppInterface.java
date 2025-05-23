package com.tencent.mobileqq.icgame.runtime;

import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.icgame.api.IQQLiveSDKManager;
import com.tencent.mobileqq.icgame.context.QQLiveContext;
import com.tencent.mobileqq.icgame.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.icgame.techreport.d;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppActivity;
import mqq.app.Constants;
import mqq.app.IToolProcEventListener;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.util.WeakReference;
import q42.b;
import t42.c;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ICGameToolAppInterface extends BaseToolAppInterface implements IToolProcEventListener {

    /* renamed from: d, reason: collision with root package name */
    private MobileQQServiceBase f237755d;

    /* renamed from: e, reason: collision with root package name */
    private ComponentCallbacks f237756e;

    public ICGameToolAppInterface(MobileQQ mobileQQ, String str) {
        super(mobileQQ, str);
        try {
            if (this.f237756e == null) {
                this.f237756e = new a();
                getApplication().getApplicationContext().registerComponentCallbacks(this.f237756e);
            }
        } catch (Throwable th5) {
            rt0.a.d("ICGameOpen_Live|ICGameToolAppInterface", "QQLiveToolAppInterface", "throwable:", th5);
        }
    }

    private boolean f() {
        Long valueOf;
        String currentAccountUin = getCurrentAccountUin();
        QQLiveAnchorRecord existAnchorRecord = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getExistAnchorRecord(r22.a.f430572a, currentAccountUin);
        if (existAnchorRecord == null) {
            valueOf = null;
        } else {
            valueOf = Long.valueOf(existAnchorRecord.roomId);
        }
        rt0.a.f("ICGameOpen_Live|ICGameToolAppInterface", "isOpenLive", "uin=" + currentAccountUin + ", roomId=" + String.valueOf(valueOf));
        if (existAnchorRecord != null) {
            return true;
        }
        return false;
    }

    private boolean g() {
        boolean decodeBool = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME).decodeBool("key_qqlive_float_window_is_show", false);
        rt0.a.f("ICGameOpen_Live|ICGameToolAppInterface", "isShowFloatWindow", "isShow=" + decodeBool);
        return decodeBool;
    }

    private void h(String str) {
        String str2 = "";
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString("process_memInfo_com.tencent.mobileqq:tool", "");
        QQLiveContext b16 = QQLiveContext.INSTANCE.b("1078");
        if (b16 != null) {
            str2 = b16.getTraceId();
        }
        rt0.a.f("ICGameOpen_Live|ICGameToolAppInterface", "reportLiveMemory", "memInfo=" + decodeString);
        HashMap hashMap = new HashMap();
        hashMap.put("ext1", str2);
        hashMap.put("ext2", decodeString);
        hashMap.put("ext3", str);
        d.g("ev_icgame_pre_exit_process", hashMap);
    }

    private void j() {
        try {
            if (this.f237756e != null) {
                getApplication().unregisterComponentCallbacks(this.f237756e);
            }
        } catch (Throwable th5) {
            rt0.a.d("ICGameOpen_Live|ICGameToolAppInterface", "unregisterComponentCallbacks", "throwable:", th5);
        }
    }

    private void release() {
        MobileQQServiceBase mobileQQServiceBase = this.f237755d;
        if (mobileQQServiceBase != null) {
            mobileQQServiceBase.destroy();
        }
        j();
    }

    @Override // mqq.app.AppRuntime
    public void exit(boolean z16) {
        rt0.a.e("ICGameOpen_Live|ICGameToolAppInterface", "exit");
        release();
        super.exit(z16);
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        return AppSetting.f();
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        return getAccount();
    }

    @Override // com.tencent.common.app.AppInterface
    public MobileQQServiceBase getMobileQQService() {
        return this.f237755d;
    }

    @Override // mqq.app.AppRuntime
    public String getModuleId() {
        return "icgame_live_tool";
    }

    @Override // mqq.app.AppRuntime
    public boolean highPriorityWhenBackground() {
        if (f()) {
            rt0.a.f("ICGameOpen_Live|ICGameToolAppInterface", "highPriorityWhenBackground", "opening live");
            return true;
        }
        rt0.a.f("ICGameOpen_Live|ICGameToolAppInterface", "highPriorityWhenBackground", "no live");
        if (g()) {
            rt0.a.f("ICGameOpen_Live|ICGameToolAppInterface", "highPriorityWhenBackground", "show float window");
            return true;
        }
        return false;
    }

    public void i(int i3) {
        String str;
        if (i3 > 15) {
            QQLiveContext b16 = QQLiveContext.INSTANCE.b("1078");
            if (b16 != null) {
                str = b16.getTraceId();
            } else {
                str = "";
            }
            double round = Math.round(c.f435382a.a() * 10000.0d) / 100;
            rt0.a.f("ICGameOpen_Live|ICGameToolAppInterface", "onTrimMemory", "level:" + i3 + " usedMemPercentage\uff1a" + round);
            HashMap hashMap = new HashMap();
            hashMap.put("ext1", str);
            hashMap.put("ext2", String.valueOf(round));
            hashMap.put("ext3", String.valueOf(i3));
            d.g("ev_icgame_on_trim_memory", hashMap);
        }
    }

    @Override // mqq.app.AppRuntime
    public boolean isProcessIdle() {
        if (f()) {
            rt0.a.f("ICGameOpen_Live|ICGameToolAppInterface", "isProcessIdle", "opening live");
            return false;
        }
        rt0.a.f("ICGameOpen_Live|ICGameToolAppInterface", "isProcessIdle", "no live");
        if (g()) {
            rt0.a.f("ICGameOpen_Live|ICGameToolAppInterface", "isProcessIdle", "show float window");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void logout(Constants.LogoutReason logoutReason, boolean z16) {
        rt0.a.e("ICGameOpen_Live|ICGameToolAppInterface", "logout");
        release();
        super.logout(logoutReason, z16);
    }

    @Override // mqq.app.IToolProcEventListener
    public void onBeforeExitProc() {
        rt0.a.e("ICGameOpen_Live|ICGameToolAppInterface", "onBeforeExitProc");
        h("1");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f237755d = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onDestroy() {
        rt0.a.e("ICGameOpen_Live|ICGameToolAppInterface", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        release();
        super.onDestroy();
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveAccountAction(String str, Intent intent) {
        if (TextUtils.equals(str, NewIntent.ACTION_ACCOUNT_KICKED)) {
            Iterator<WeakReference<AppActivity>> it = MobileQQ.sMobileQQ.appActivities.iterator();
            while (it.hasNext()) {
                AppActivity appActivity = it.next().get();
                if (appActivity != null && !appActivity.isFinishing()) {
                    rt0.a.f("ICGameOpen_Live|ICGameToolAppInterface", "onReceiveAccountAction", "has activity");
                    return true;
                }
            }
        }
        rt0.a.f("ICGameOpen_Live|ICGameToolAppInterface", "onReceiveAccountAction", "no activity");
        return false;
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveLegalExitProcAction(Intent intent) {
        if (f()) {
            rt0.a.f("ICGameOpen_Live|ICGameToolAppInterface", "onReceiveLegalExitProcAction", "opening live");
            return true;
        }
        rt0.a.f("ICGameOpen_Live|ICGameToolAppInterface", "onReceiveLegalExitProcAction", "no live");
        if (g()) {
            rt0.a.f("ICGameOpen_Live|ICGameToolAppInterface", "onReceiveLegalExitProcAction", "show float window");
            return true;
        }
        return false;
    }

    @Override // mqq.app.AppRuntime
    public void preExit() {
        rt0.a.e("ICGameOpen_Live|ICGameToolAppInterface", "preExit");
        h("2");
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements ComponentCallbacks2 {
        a() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i3) {
            ICGameToolAppInterface.this.i(i3);
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }
    }
}
