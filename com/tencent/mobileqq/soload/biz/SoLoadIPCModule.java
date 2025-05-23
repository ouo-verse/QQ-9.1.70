package com.tencent.mobileqq.soload.biz;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoLoadResService;
import com.tencent.mobileqq.soload.download.DownloadParam;
import com.tencent.mobileqq.soload.util.e;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.MobileQQ;

/* loaded from: classes18.dex */
public class SoLoadIPCModule extends QIPCModule {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_COM_IPC_UTILS = "ComIPCUtils";
    public static final String ACTION_PRELOAD_COMMON = "soPreload";
    public static final String KEY_DOWNLOAD_PARAMS = "download_params";
    public static final String KEY_DOWNLOAD_RECEIVER = "receiver";
    public static final String KEY_IS_SYNC = "is_sync";
    public static final String KEY_LOAD_ITEM = "load_item";
    public static final String KEY_LOAD_PARAM = "load_param";
    public static final String KEY_METHOD_TYPE = "method_type";
    public static final String KEY_OPER_TYPE = "oper_type";
    public static final String KEY_PATH = "path";
    public static final String KEY_PATH_RESULT = "path_result";
    public static final String KEY_RESULT = "res";
    public static final String KEY_RESULT_CODE = "result_code";
    public static final String KEY_URL = "url";
    public static final int METHOD_TYPE_GET_RES_PATH = 1;
    public static final int METHOD_TYPE_GET_RES_PATH_SYNC = 2;
    public static final String NAME = "SoLoadWidget.SoLoadIPCModule";
    public static final int OPER_TYPE_GET_SO_LOAD_INFO = 17;
    public static final int OPER_TYPE_TEST_FILE_EXIST = 18;
    private static final String TAG = "SoLoadWidget.SoLoadWidget.SoLoadIPCModule";
    public static SoLoadIPCModule mInstance;

    SoLoadIPCModule() {
        super(NAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private EIPCResult executePreloadMethod(Bundle bundle, final int i3) {
        if ((MobileQQ.sMobileQQ.peekAppRuntime() instanceof BaseQQAppInterface) && bundle != null) {
            int i16 = bundle.getInt("method_type", -1);
            if (i16 != 1) {
                if (i16 != 2) {
                    return null;
                }
                ISoLoadResService.PathResult resPathSync = ((ISoLoadResService) QRoute.api(ISoLoadResService.class)).getResPathSync((DownloadParam) bundle.getSerializable("download_params"));
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("path_result", resPathSync);
                return EIPCResult.createSuccessResult(bundle2);
            }
            final DownloadParam downloadParam = (DownloadParam) bundle.getSerializable("download_params");
            if (downloadParam == null) {
                return null;
            }
            ((ISoLoadResService) QRoute.api(ISoLoadResService.class)).getResPath(downloadParam, new ISoLoadResService.OnGetPathListener() { // from class: com.tencent.mobileqq.soload.biz.a
                @Override // com.tencent.mobileqq.soload.api.ISoLoadResService.OnGetPathListener
                public final void onResult(int i17, ISoLoadResService.PathResult pathResult) {
                    SoLoadIPCModule.this.lambda$executePreloadMethod$0(downloadParam, i3, i17, pathResult);
                }
            });
        }
        return null;
    }

    public static SoLoadIPCModule getInstance() {
        if (mInstance == null) {
            synchronized (SoLoadIPCModule.class) {
                if (mInstance == null) {
                    mInstance = new SoLoadIPCModule();
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executePreloadMethod$0(DownloadParam downloadParam, int i3, int i16, ISoLoadResService.PathResult pathResult) {
        QLog.i(TAG, 1, "getResPath back,downloadParams:" + downloadParam.url);
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i16);
        bundle.putSerializable("path_result", pathResult);
        callbackResult(i3, EIPCResult.createSuccessResult(bundle));
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "action = " + str + ", params = " + bundle);
        }
        if (ACTION_COM_IPC_UTILS.equals(str)) {
            try {
                if (bundle.getInt("oper_type", -1) == 18) {
                    int e16 = e.e(bundle.getString("path"));
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("res", e16);
                    return EIPCResult.createSuccessResult(bundle2);
                }
                return null;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
                return null;
            }
        }
        if (ACTION_PRELOAD_COMMON.equals(str)) {
            return executePreloadMethod(bundle, i3);
        }
        return null;
    }
}
