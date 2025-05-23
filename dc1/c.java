package dc1;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends a {

    /* renamed from: i, reason: collision with root package name */
    private Context f393540i;

    /* renamed from: j, reason: collision with root package name */
    private FileManagerEntity f393541j;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<String> f393542k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f393543l;

    public c(QQAppInterface qQAppInterface, Context context, FileManagerEntity fileManagerEntity) {
        super(qQAppInterface, context);
        this.f393540i = context;
        this.f393541j = fileManagerEntity;
        this.f393543l = false;
    }

    @Override // dc1.e
    public boolean a() {
        FileManagerEntity fileManagerEntity = this.f393541j;
        if (fileManagerEntity == null) {
            return false;
        }
        int fileType = FileManagerUtil.getFileType(fileManagerEntity.fileName);
        if (fileType != 2) {
            if (QLog.isColorLevel()) {
                QLog.i("FileVideo", 1, "id:" + this.f393541j.nSessionId + " type is:" + fileType + " use old filebrowser:");
            }
            return false;
        }
        boolean fileExist = FileManagerUtil.fileExist(this.f393541j.strFilePath);
        if (QLog.isColorLevel()) {
            QLog.i("FileVideo", 1, "id:" + this.f393541j.nSessionId + " status:" + this.f393541j.status + " isLocal:" + fileExist);
        }
        if (!fileExist) {
            return false;
        }
        if (fileExist) {
            FileManagerEntity fileManagerEntity2 = this.f393541j;
            if (fileManagerEntity2.status != 1 && fileManagerEntity2.isSend()) {
                return false;
            }
        }
        return true;
    }

    @Override // dc1.a, dc1.e
    public boolean b() {
        return false;
    }

    @Override // dc1.e
    public Intent d() {
        FileManagerEntity fileManagerEntity = this.f393541j;
        if (fileManagerEntity == null) {
            return null;
        }
        ForwardFileInfo U = ForwardFileOption.U(fileManagerEntity);
        U.N(10009);
        Intent intent = new Intent();
        intent.putExtra("fileinfo", U);
        ArrayList<String> arrayList = this.f393542k;
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra("Aio_SessionId_ImageList", this.f393542k);
        }
        intent.putExtra("_from_aio_", this.f393543l);
        return intent;
    }

    @Override // dc1.a
    protected String m() {
        FileManagerEntity fileManagerEntity = this.f393541j;
        if (fileManagerEntity != null) {
            return fileManagerEntity.fileName;
        }
        return "";
    }

    @Override // dc1.a
    protected String n() {
        FileManagerEntity fileManagerEntity = this.f393541j;
        if (fileManagerEntity != null) {
            return fileManagerEntity.getFilePath();
        }
        return "";
    }

    @Override // dc1.a
    protected long o() {
        FileManagerEntity fileManagerEntity = this.f393541j;
        if (fileManagerEntity != null) {
            return fileManagerEntity.fileSize;
        }
        return 0L;
    }

    @Override // dc1.a
    protected int p() {
        FileManagerEntity fileManagerEntity = this.f393541j;
        if (fileManagerEntity != null) {
            return fileManagerEntity.status;
        }
        return 0;
    }

    public void v(ArrayList<String> arrayList) {
        this.f393542k = arrayList;
    }
}
