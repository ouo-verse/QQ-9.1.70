package hr2;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f406077d = false;

    /* renamed from: e, reason: collision with root package name */
    private static a f406078e;

    public a() {
        super(IStudyModeManager.STUDY_MODE_ULR_FILTER_PROCESS_NAME);
    }

    public static a b() {
        if (f406078e == null) {
            synchronized (a.class) {
                if (f406078e == null) {
                    f406078e = new a();
                }
            }
        }
        return f406078e;
    }

    public EIPCResult d(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        bundle2.putString(IStudyModeManager.STUDY_MODE_URL_FILTER_PATH, str);
        bundle2.putString(IStudyModeManager.STUDY_MODE_ULR_FILTER_EQUAL, str);
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).urlFilterCheckedSupportOpen(str)) {
            bundle2.putString(IStudyModeManager.STUDY_MODE_ULR_FILTER_RESULT, IStudyModeManager.STUDY_MODE_URL_FILTER_RESULT_SUC);
        } else {
            bundle2.putString(IStudyModeManager.STUDY_MODE_ULR_FILTER_RESULT, IStudyModeManager.STUDY_MODE_URL_FILTER_RESULT_FAIL);
        }
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.code = 0;
        eIPCResult.data = bundle2;
        return eIPCResult;
    }

    public void register() {
        if (f406077d) {
            return;
        }
        QIPCServerHelper.getInstance().register(f406078e);
        f406077d = true;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (str == null || bundle == null || !str.equals(IStudyModeManager.STUDY_MODE_URL_FILTER_PATH)) {
            return null;
        }
        String string = bundle.getString(IStudyModeManager.STUDY_MODE_ULR_FILTER_EQUAL);
        if (string != null) {
            return d(bundle, string);
        }
        c(bundle);
        return null;
    }

    public void c(Bundle bundle) {
    }
}
