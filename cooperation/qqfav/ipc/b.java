package cooperation.qqfav.ipc;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.ipc.a;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b implements a.InterfaceC10113a {
    @Override // cooperation.qqfav.ipc.a.InterfaceC10113a
    public boolean a(int i3, Bundle bundle) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 == 5) {
                        bundle.putBoolean("isVideoChatting", qQAppInterface.isVideoChatting());
                    }
                } else {
                    bundle.putString("configInfo", ((IFMConfig) QRoute.api(IFMConfig.class)).getConfigValue(qQAppInterface.getApp().getBaseContext(), bundle.getString("configKey")));
                }
            } else {
                long j3 = bundle.getLong("previewSize", -1L);
                String string = bundle.getString("previewName");
                Intent intent = new Intent(qQAppInterface.getApplication().getBaseContext(), (Class<?>) FilePreviewActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("offline_file_type", 0);
                intent.putExtra("offline_file_name", string);
                intent.putExtra("offline_file_size", j3);
                qQAppInterface.getFileManagerDataCenter().Q(new QfavFilePreviewController(bundle));
                QLog.i("FavoritesRemoteCommandHandler", 1, "open zip favorite,open new activity");
                qQAppInterface.getApplication().getBaseContext().startActivity(intent);
            }
        } else {
            String string2 = bundle.getString("installAppName");
            String string3 = bundle.getString("installAppUrl");
            long j16 = 0;
            try {
                try {
                    j16 = new URL(string3).openConnection().getContentLength();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            } catch (MalformedURLException e17) {
                e17.printStackTrace();
            }
            Bundle bundle2 = new Bundle();
            bundle2.putLong(IUniformDownloadMgr.FILESIZE_FROM_DIALOG, j16);
            bundle2.putString(IUniformDownloadMgr.FILENAME_FROM_DIALOG, string2);
            bundle2.putString(IUniformDownloadMgr.DOWNLOAD_BIG_BROTHER_SOURCE, "biz_src_qfav");
            ((IUniformDownloadMgr) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).startDownload(string3, bundle2);
        }
        return true;
    }
}
