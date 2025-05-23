package com.tencent.comic.ipc;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.comic.VipComicJumpActivity;
import com.tencent.comic.api.IQQComicConfigApi;
import com.tencent.comic.config.QQComicConfBean;
import com.tencent.comic.data.BoodoHippyConfig;
import com.tencent.comic.data.IPExpressionConfig;
import com.tencent.comic.hippy.BoodoHippyBirdge;
import com.tencent.comic.i;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.redtouch.g;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class QQComicIPCModule extends QIPCModule {

    /* renamed from: e, reason: collision with root package name */
    private static QQComicIPCModule f99377e;

    /* renamed from: d, reason: collision with root package name */
    b f99378d;

    /* loaded from: classes32.dex */
    class a implements BoodoHippyBirdge.ICheckPluginListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f99380a;

        a(int i3) {
            this.f99380a = i3;
        }

        @Override // com.tencent.comic.hippy.BoodoHippyBirdge.ICheckPluginListener
        public void onResult(int i3, String str) {
            QLog.i("QQComicIPCModule", 1, "checkPluginInstall onResult retCode:" + i3 + " msg:" + str);
            Bundle bundle = new Bundle();
            bundle.putInt("retCode", i3);
            bundle.putString("msg", str);
            QQComicIPCModule.this.callbackResult(this.f99380a, EIPCResult.createSuccessResult(bundle));
        }
    }

    /* loaded from: classes32.dex */
    class b extends CallBacker {

        /* renamed from: a, reason: collision with root package name */
        int f99382a;

        b(int i3) {
            this.f99382a = i3;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
        public void callback(long j3, String str, String str2, String str3, int i3, int i16) {
            JSONObject jSONFromLocal;
            if (i3 == 0 && j3 == 1000 && VasUpdateConstants.SCID_COMIC_CONFIG.equals(str) && (jSONFromLocal = VasUpdateUtil.getJSONFromLocal(com.tencent.comic.utils.a.a(), str, false, null)) != null) {
                Bundle bundle = new Bundle();
                bundle.putString("config_json", jSONFromLocal.toString());
                QQComicIPCModule.this.callbackResult(this.f99382a, EIPCResult.createResult(0, bundle));
            }
        }
    }

    public QQComicIPCModule(String str) {
        super(str);
    }

    private void b(final int i3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.comic.ipc.QQComicIPCModule.2
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle = new Bundle();
                IPExpressionConfig c16 = QQComicConfBean.c();
                if (QLog.isColorLevel()) {
                    QLog.d("QQComicIPCModule", 2, " ipExpressionConfig" + c16);
                }
                bundle.putSerializable("ipExpressionConfig", c16);
                BoodoHippyConfig b16 = QQComicConfBean.b();
                if (QLog.isColorLevel()) {
                    QLog.d("QQComicIPCModule", 2, " hippyConfig" + b16);
                }
                bundle.putSerializable("hippyConfig", b16);
                QQComicIPCModule.this.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
            }
        }, 64, null, false);
    }

    public static QQComicIPCModule c() {
        if (f99377e == null) {
            synchronized (QQComicIPCModule.class) {
                if (f99377e == null) {
                    f99377e = new QQComicIPCModule("QQComicIPCModule");
                }
            }
        }
        return f99377e;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("QQComicIPCModule", 2, "action = " + str);
        }
        if (bundle == null) {
            QLog.d("QQComicIPCModule", 2, "QQComicIPCModule Err params = null, action = " + str);
            return null;
        }
        AppRuntime a16 = com.tencent.comic.utils.a.a();
        if (!(a16 instanceof BaseQQAppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.d("QQComicIPCModule", 2, "onRemoteInvoke cannot get QQAppInterface");
            }
            return null;
        }
        AppInterface appInterface = (AppInterface) a16;
        if (IQQComicConfigApi.ACTION_GET_IP_EXPRESSION_CONFIG.equals(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("QQComicIPCModule", 2, " ACTION_GET_IP_EXPRESSION_CONFIGgetIpExpressionConfig");
            }
            b(i3);
        } else {
            if ("isLebaItemOpen".equals(str)) {
                int i16 = bundle.getInt("appId", -1);
                Iterator<BusinessInfoCheckUpdate.AppSetting> it = ((IRedTouchManager) appInterface.getRuntimeService(IRedTouchManager.class, "")).requestSettingInfoList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z16 = false;
                        break;
                    }
                    BusinessInfoCheckUpdate.AppSetting next = it.next();
                    if (next.appid.get() == i16) {
                        z16 = next.setting.get();
                        break;
                    }
                }
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("isLebaItemOpen", z16);
                return EIPCResult.createResult(0, bundle2);
            }
            if ("getRedTouchInfo".equals(str)) {
                IRedTouchManager iRedTouchManager = (IRedTouchManager) appInterface.getRuntimeService(IRedTouchManager.class, "");
                ArrayList<String> stringArrayList = bundle.getStringArrayList("pathList");
                if (iRedTouchManager != null && stringArrayList != null) {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    Iterator<String> it5 = stringArrayList.iterator();
                    while (it5.hasNext()) {
                        BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(it5.next());
                        if (appInfoByPath != null) {
                            arrayList.add(g.a(appInfoByPath));
                        }
                    }
                    Bundle bundle3 = new Bundle();
                    bundle3.putParcelableArrayList("redTouchInfoList", arrayList);
                    return EIPCResult.createResult(0, bundle3);
                }
            } else if ("reportRedTouchClick".equals(str)) {
                IRedTouchManager iRedTouchManager2 = (IRedTouchManager) appInterface.getRuntimeService(IRedTouchManager.class, "");
                String string = bundle.getString("path");
                if (iRedTouchManager2 != null && string != null) {
                    iRedTouchManager2.onRedTouchItemClick(string);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("service_type", 2);
                        jSONObject.put("act_id", 1002);
                        iRedTouchManager2.onReportBusinessRedTouch(iRedTouchManager2.getAppInfoByPath(string), jSONObject.toString());
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            } else if ("initPluginBeforeEnter".equals(str)) {
                VipComicJumpActivity.i3(appInterface, bundle.getBoolean("doLoadModule"));
            } else if ("check_qqcomic_plugin".equals(str)) {
                BoodoHippyBirdge.checkPluginInstall(com.tencent.comic.utils.a.b(), appInterface, new a(i3));
            } else if ("launch_qqcomic_hippy".equals(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQComicIPCModule", 2, "ACTION_LAUNCH_QQCOMIC_HIPPY launchHippyPage");
                }
            } else if (IQQComicConfigApi.ACTION_GET_COMIC_CONFIG.equals(str)) {
                VasCommonReporter.getHistoryFeature("feature_comic").setValue2(IQQComicConfigApi.ACTION_GET_COMIC_CONFIG).report();
                if (VasNormalToggle.VAS_DELIST_COMIC.isEnable(false)) {
                    return null;
                }
                IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) appInterface.getRuntimeService(IVasQuickUpdateService.class, "");
                if (i3 > 0 && iVasQuickUpdateService != null) {
                    if (this.f99378d == null) {
                        this.f99378d = new b(i3);
                    }
                    iVasQuickUpdateService.addCallBacker(this.f99378d);
                }
                JSONObject jSONFromLocal = VasUpdateUtil.getJSONFromLocal(appInterface, VasUpdateConstants.SCID_COMIC_CONFIG, true, null);
                if (jSONFromLocal != null) {
                    Bundle bundle4 = new Bundle();
                    bundle4.putString("config_json", jSONFromLocal.toString());
                    EIPCResult createResult = EIPCResult.createResult(0, bundle4);
                    if (i3 <= 0) {
                        return createResult;
                    }
                    callbackResult(i3, createResult);
                }
            } else if ("getPlayerSo".equals(str)) {
                VasCommonReporter.getHistoryFeature("feature_comic").setValue2("getPlayerSo").report();
                i.b(appInterface);
            }
        }
        return null;
    }
}
