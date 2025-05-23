package cooperation.qqfav.ipc;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static volatile d f390656d;

    d(String str) {
        super(str);
    }

    public static d c() {
        if (f390656d == null) {
            synchronized (d.class) {
                if (f390656d == null) {
                    f390656d = new d("QfavMainQIPCModule");
                }
            }
        }
        return f390656d;
    }

    QQAppInterface b() {
        return (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        Bundle bundle2 = new Bundle();
        QQAppInterface b16 = b();
        if (b16 == null) {
            return EIPCResult.createResult(100, bundle2);
        }
        int i16 = 0;
        if ("getfavList".equals(str)) {
            bundle.setClassLoader(getClass().getClassLoader());
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("favfile_list");
            if (parcelableArrayList != null) {
                i16 = parcelableArrayList.size();
            }
            b16.getFileManagerEngine().W().onGettedFileList(bundle.getLong("reqTimestamp"), parcelableArrayList, bundle);
            QLog.d("QfavMainQIPCModule", 1, "onCall ACTION_GET_FAVLIST \u6536\u5230" + i16 + "\u6761\u6536\u85cf");
        } else if ("refreshFavList".equals(str)) {
            bundle.setClassLoader(getClass().getClassLoader());
            boolean z16 = bundle.getBoolean("refresh_list_succ", false);
            bundle.putString(IQQFavProxy.DELETE_FAVIDS, bundle.getString("refresh_deleted_list"));
            b16.getFileManagerEngine().W().onFileListRefreshed(z16, bundle);
            QLog.d("QfavMainQIPCModule", 1, "onCall ACTION_REFRESH_FAVLIST bSucc:" + z16);
        } else if ("ondownloadThumb".equals(str)) {
            b16.getFileManagerEngine().W().onFileThumbUpdated(bundle.getLong("download_fav_id"), bundle.getString("fav_thumb_path"), bundle.getInt("thumb_format"));
        } else if ("ondownloadFile".equals(str)) {
            b16.getFileManagerEngine().W().onFileDownloaded(bundle.getLong("download_fav_id"), bundle.getString("fav_save_path"));
        } else if ("onAVChatting".equals(str)) {
            bundle2.putBoolean("is_videochatting", b16.isVideoChatting());
        }
        return EIPCResult.createSuccessResult(bundle2);
    }
}
