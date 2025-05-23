package gg1;

import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static boolean a(String str) {
        ScannerResult decodeQQCodeFromFile = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(Uri.parse("file://" + new File(str).getAbsolutePath()), (Context) BaseApplication.getContext(), 3, false);
        if (decodeQQCodeFromFile != null) {
            return decodeQQCodeFromFile.l() || decodeQQCodeFromFile.j();
        }
        return false;
    }
}
