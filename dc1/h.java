package dc1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class h extends e {

    /* renamed from: g, reason: collision with root package name */
    private WeiYunFileInfo f393578g;

    /* renamed from: h, reason: collision with root package name */
    private Context f393579h;

    /* renamed from: i, reason: collision with root package name */
    private QQAppInterface f393580i;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<WeiYunFileInfo> f393581j;

    /* renamed from: k, reason: collision with root package name */
    private FileManagerEntity f393582k;

    public h(QQAppInterface qQAppInterface, Context context, WeiYunFileInfo weiYunFileInfo) {
        this.f393580i = qQAppInterface;
        this.f393579h = context;
        this.f393578g = weiYunFileInfo;
    }

    @Override // dc1.e
    public boolean b() {
        return false;
    }

    @Override // dc1.e
    public Intent d() {
        FileManagerEntity fileManagerEntity = this.f393582k;
        if (fileManagerEntity == null && this.f393578g != null && (fileManagerEntity = this.f393580i.getFileManagerRSCenter().c(this.f393578g.f209603d)) == null && (fileManagerEntity = this.f393580i.getFileManagerDataCenter().H(this.f393578g.f209603d)) == null) {
            fileManagerEntity = FileManagerUtil.newEntityByWeiYunFileInfo(this.f393578g);
        }
        if (fileManagerEntity == null) {
            QLog.i("WeiYunFileBrowserParams<FileAssistant>", 1, "");
            return new Intent(this.f393579h, (Class<?>) FileBrowserActivity.class);
        }
        if (QLog.isColorLevel()) {
            QLog.i("WeiYunFileBrowserParams<FileAssistant>", 1, "open a weiyun file with filebrowser, fileSessionId[" + fileManagerEntity.nSessionId + "] fileName[" + this.f393578g.f209605f + "]fileId[" + this.f393578g.f209603d + "]");
        }
        ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
        forwardFileInfo.w(2);
        forwardFileInfo.N(10003);
        forwardFileInfo.E(fileManagerEntity.nSessionId);
        forwardFileInfo.y(fileManagerEntity.fileName);
        forwardFileInfo.x(fileManagerEntity.WeiYunFileId);
        forwardFileInfo.a0(fileManagerEntity.nWeiYunSrcType);
        forwardFileInfo.z(fileManagerEntity.fileSize);
        Intent intent = new Intent(this.f393579h, (Class<?>) FileBrowserActivity.class);
        intent.putExtra("fileinfo", forwardFileInfo);
        ArrayList<WeiYunFileInfo> arrayList = this.f393581j;
        if (arrayList != null && arrayList.size() > 0) {
            intent.putParcelableArrayListExtra("local_weiyun_list", this.f393581j);
        }
        return intent;
    }

    public void m(FileManagerEntity fileManagerEntity) {
        this.f393582k = fileManagerEntity;
    }

    @Override // dc1.e
    public void k(Bundle bundle) {
    }
}
