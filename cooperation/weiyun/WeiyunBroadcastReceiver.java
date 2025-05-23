package cooperation.weiyun;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WeiyunBroadcastReceiver extends BroadcastReceiver {
    public void a(Context context, WeiYunFileInfo weiYunFileInfo, FileManagerEntity fileManagerEntity) {
        ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
        forwardFileInfo.w(fileManagerEntity.getCloudType());
        forwardFileInfo.N(10001);
        forwardFileInfo.E(fileManagerEntity.nSessionId);
        forwardFileInfo.y(weiYunFileInfo.f209605f);
        forwardFileInfo.x(weiYunFileInfo.f209603d);
        forwardFileInfo.a0(2);
        forwardFileInfo.z(weiYunFileInfo.f209606h);
        forwardFileInfo.b0(weiYunFileInfo);
        forwardFileInfo.C(fileManagerEntity.getFilePath());
        forwardFileInfo.V(fileManagerEntity.uniseq);
        forwardFileInfo.Z(fileManagerEntity.Uuid);
        Intent intent = new Intent(context, (Class<?>) FileBrowserActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("fileinfo", forwardFileInfo);
        context.startActivity(intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            Bundle extras = intent.getExtras();
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
            if (extras != null) {
                ArrayList parcelableArrayList = extras.getParcelableArrayList("fileinfos");
                Iterator it = parcelableArrayList.iterator();
                FileManagerEntity fileManagerEntity = null;
                while (it.hasNext()) {
                    fileManagerEntity = FileManagerUtil.newEntityByWeiYunFileInfo((WeiYunFileInfo) it.next());
                    fileManagerEntity.nOpType = 5;
                    qQAppInterface.getFileManagerDataCenter().t(fileManagerEntity);
                    qQAppInterface.getFileManagerRSCenter().h(fileManagerEntity);
                }
                if (parcelableArrayList.size() == 1) {
                    a(qQAppInterface.getApp(), (WeiYunFileInfo) parcelableArrayList.get(0), fileManagerEntity);
                } else {
                    ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).openFileSelectorByWeiyunBoroadcast(qQAppInterface.getApp(), extras);
                }
            }
        } catch (Exception unused) {
        }
    }
}
