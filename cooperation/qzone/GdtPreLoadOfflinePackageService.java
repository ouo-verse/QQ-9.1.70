package cooperation.qzone;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.util.QZLog;

/* loaded from: classes28.dex */
public class GdtPreLoadOfflinePackageService extends Service {
    private static final String TAG = "GdtPreLoadOfflinePackageService";
    public static final String URL = "url";

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("url");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    BaseApplicationImpl application = BaseApplicationImpl.getApplication();
                    HtmlOffline.D();
                    HtmlOffline.d(stringExtra, application.getRuntime());
                } catch (Exception e16) {
                    QZLog.e(TAG, e16.getMessage());
                }
            }
        }
        return super.onStartCommand(intent, i3, i16);
    }
}
