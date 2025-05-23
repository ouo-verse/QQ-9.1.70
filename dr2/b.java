package dr2;

import android.os.Bundle;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f394683b;

    /* renamed from: a, reason: collision with root package name */
    private QIPCModule f394684a = new a("Module_VideoPlayIPCServer");

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends QIPCModule {
        a(String str) {
            super(str);
        }

        @Override // eipc.EIPCModule
        public EIPCResult onCall(String str, Bundle bundle, int i3) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            if ("CMD_GET_CURRENT_NICK_NAME".equals(str)) {
                String currentNickname = qQAppInterface.getCurrentNickname();
                Bundle bundle2 = new Bundle();
                bundle2.putString("VALUE_GET_CURRENT_NICK_NAME", currentNickname);
                return EIPCResult.createSuccessResult(bundle2);
            }
            if ("CMD_GET_CURRENT_USER_HEAD".equals(str)) {
                String customFaceFilePath = qQAppInterface.getCustomFaceFilePath(1, qQAppInterface.getCurrentUin(), 200);
                Bundle bundle3 = new Bundle();
                bundle3.putString("VALUE_GET_CURRENT_USER_HEAD", customFaceFilePath);
                return EIPCResult.createSuccessResult(bundle3);
            }
            int i16 = 0;
            if ("CMD_DOWNLOAD_PTU_BASE_RES".equals(str)) {
                ((IAEResDownload) QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.AE_RES_BASE_PACKAGE, null, false);
                ms.a.f("VideoPlayIPCServer", "launchForResult requestAEKitDownload : AEKIT_ADDITIONAL_PACKAGE");
                return EIPCResult.createSuccessResult(new Bundle());
            }
            if (!"CMD_QUERY_STATUS_PTU_RES".equals(str)) {
                return null;
            }
            if (bundle != null && bundle.getString("VALUE_MSG_LIGHT_BUNDLE_PREFIX") != null) {
                AEResInfo aEResInfoByPrefix = AEResInfo.getAEResInfoByPrefix(bundle.getString("VALUE_MSG_LIGHT_BUNDLE_PREFIX"));
                if (aEResInfoByPrefix != null) {
                    int resPackageStatus = ((IAEResDownload) QRoute.api(IAEResDownload.class)).getResPackageStatus(aEResInfoByPrefix);
                    ms.a.f("PreCheckAERes", "query additional_package:" + bundle.getString("VALUE_MSG_LIGHT_BUNDLE_PREFIX") + " result:" + resPackageStatus);
                    i16 = resPackageStatus;
                }
            } else {
                ms.a.c("VideoPlayIPCServer", "query additional_package:params is null");
            }
            Bundle bundle4 = new Bundle();
            bundle4.putInt("VALUE_MSG_PTU_RES_STATUS", i16);
            return EIPCResult.createSuccessResult(bundle4);
        }
    }

    public static b a() {
        if (f394683b == null) {
            synchronized (b.class) {
                if (f394683b == null) {
                    f394683b = new b();
                }
            }
        }
        return f394683b;
    }

    public QIPCModule b() {
        return this.f394684a;
    }
}
