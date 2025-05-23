package mqq.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import mqq.manager.ISecurityFileFrameworkService;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SecurityFileModule extends QIPCModule {
    public static final String ACTION_GET_BUSINESS_ROOT_PATH = "ACTION_GET_BUSINESS_ROOT_PATH";
    public static final String BUNDLE_KEY_RETURN_FILE_PATH = "BUNDLE_KEY_RETURN_FILE_PATH";
    public static final String BUNDLE_KEY_SECURITY_FILE_HELPER_CLASS_NAME = "BUNDLE_KEY_SECURITY_FILE_HELPER_CLASS_NAME";
    public static final String NAME = "SecurityFileModule";
    public static SecurityFileModule mInstance;

    public SecurityFileModule(String str) {
        super(str);
    }

    public static SecurityFileModule getInstance() {
        if (mInstance == null) {
            synchronized (SecurityFileModule.class) {
                if (mInstance == null) {
                    mInstance = new SecurityFileModule(NAME);
                }
            }
        }
        return mInstance;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0100  */
    @Override // eipc.EIPCModule
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        ISecurityFileHelper iSecurityFileHelper;
        File uINRootFile;
        String str2;
        String str3;
        if (QLog.isColorLevel()) {
            QLog.d(NAME, 2, "action = " + str + ", params = " + bundle);
        }
        if (ACTION_GET_BUSINESS_ROOT_PATH.equals(str)) {
            if (bundle != null) {
                String string = bundle.getString(BUNDLE_KEY_SECURITY_FILE_HELPER_CLASS_NAME);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        Class<?> cls = Class.forName(string);
                        if (QLog.isColorLevel()) {
                            QLog.d(NAME, 2, "className=", string, " realClassName=", cls.getName());
                        }
                        iSecurityFileHelper = (ISecurityFileHelper) cls.newInstance();
                    } catch (ClassNotFoundException e16) {
                        QLog.d(NAME, 1, e16.getMessage());
                    } catch (IllegalAccessException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.d(NAME, 2, e17.getMessage());
                        }
                    } catch (InstantiationException e18) {
                        if (QLog.isColorLevel()) {
                            QLog.d(NAME, 2, e18.getMessage());
                        }
                    }
                    if (QLog.isColorLevel()) {
                        if (iSecurityFileHelper == null) {
                            str3 = "helper = null ";
                        } else {
                            str3 = "helper=" + iSecurityFileHelper.declareBusinessFileName();
                        }
                        QLog.d(NAME, 2, str3);
                    }
                    uINRootFile = ((ISecurityFileFrameworkService) MobileQQ.sMobileQQ.waitAppRuntime().getRuntimeService(ISecurityFileFrameworkService.class, "")).getUINRootFile(iSecurityFileHelper);
                    if (QLog.isColorLevel()) {
                        if (uINRootFile == null) {
                            str2 = "result = null";
                        } else {
                            str2 = "result = " + uINRootFile.getAbsolutePath();
                        }
                        QLog.d(NAME, 2, str2);
                    }
                    Bundle bundle2 = new Bundle();
                    if (uINRootFile != null) {
                        bundle2.putString(BUNDLE_KEY_RETURN_FILE_PATH, "");
                    } else {
                        bundle2.putString(BUNDLE_KEY_RETURN_FILE_PATH, uINRootFile.getAbsolutePath());
                    }
                    return EIPCResult.createSuccessResult(bundle2);
                }
            }
            iSecurityFileHelper = null;
            if (QLog.isColorLevel()) {
            }
            uINRootFile = ((ISecurityFileFrameworkService) MobileQQ.sMobileQQ.waitAppRuntime().getRuntimeService(ISecurityFileFrameworkService.class, "")).getUINRootFile(iSecurityFileHelper);
            if (QLog.isColorLevel()) {
            }
            Bundle bundle22 = new Bundle();
            if (uINRootFile != null) {
            }
            return EIPCResult.createSuccessResult(bundle22);
        }
        return EIPCResult.createExceptionResult(new Throwable("Action=" + str + " Not Found"));
    }
}
