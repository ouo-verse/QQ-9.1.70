package pb1;

import android.app.Activity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.g;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    public static void a(QQAppInterface qQAppInterface, Activity activity, FileManagerEntity fileManagerEntity, g gVar) {
        String filePath = fileManagerEntity.getFilePath();
        if (QLog.isColorLevel()) {
            QLog.i("<FileAssistant>FileViewerFacade", 2, "open[" + filePath + "]");
        }
        if (filePath != null && filePath.lastIndexOf(".rename") > 0) {
            String replace = filePath.replace(".rename", "");
            String str = replace.substring(0, replace.lastIndexOf(".")) + replace.substring(replace.lastIndexOf(".")).replaceAll("[0-9]*", "").replace("(", "").replace(")", "");
            if (QLog.isColorLevel()) {
                QLog.i("<FileAssistant>FileViewerFacade", 2, "file maybe renmaed,realName[" + str + "]");
            }
            FMDialogUtil.b(activity, activity.getString(R.string.bfi), R.string.bf6, new C10994a(str, filePath, fileManagerEntity, qQAppInterface, activity, gVar));
            return;
        }
        if (fileManagerEntity.nFileType == 5 && (fileManagerEntity.isZipInnerFile || fileManagerEntity.nOpType == 190)) {
            FMDialogUtil.b(activity, activity.getString(R.string.bfi), R.string.ben, new b(activity, fileManagerEntity));
        } else {
            FileManagerUtil.installApkFile(activity, fileManagerEntity.getFilePath());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: pb1.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C10994a implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f425851a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f425852b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f425853c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f425854d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f425855e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f425856f;

        C10994a(String str, String str2, FileManagerEntity fileManagerEntity, QQAppInterface qQAppInterface, Activity activity, g gVar) {
            this.f425851a = str;
            this.f425852b = str2;
            this.f425853c = fileManagerEntity;
            this.f425854d = qQAppInterface;
            this.f425855e = activity;
            this.f425856f = gVar;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            String recreateFilePath = FileManagerUtil.recreateFilePath(this.f425851a);
            if (QLog.isColorLevel()) {
                QLog.i("<FileAssistant>FileViewerFacade", 2, "file maybe resoved ,recreateFilePath[" + this.f425851a + "]");
            }
            FileUtils.rename(this.f425852b, recreateFilePath);
            this.f425853c.fileName = FileManagerUtil.getFileName(recreateFilePath);
            this.f425853c.setFilePath(recreateFilePath);
            FileManagerEntity fileManagerEntity = this.f425853c;
            fileManagerEntity.nFileType = FileManagerUtil.getFileType(fileManagerEntity.getFilePath());
            this.f425854d.getFileManagerDataCenter().f0(this.f425853c);
            FileManagerEntity K = this.f425854d.getFileManagerDataCenter().K(this.f425852b);
            if (K != null) {
                K.setFilePath(recreateFilePath);
                K.fileName = this.f425853c.fileName;
                this.f425854d.getFileManagerDataCenter().f0(K);
                TroopFileTransferManager O = TroopFileTransferManager.O(this.f425854d, K.TroopUin);
                if (O != null) {
                    O.c0(K.strTroopFileID, this.f425853c.fileName);
                }
            }
            FileManagerUtil.installApkFile(this.f425855e, this.f425853c.getFilePath());
            g gVar = this.f425856f;
            if (gVar != null) {
                gVar.h2();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f425857a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f425858b;

        b(Activity activity, FileManagerEntity fileManagerEntity) {
            this.f425857a = activity;
            this.f425858b = fileManagerEntity;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            FileManagerUtil.installApkFile(this.f425857a, this.f425858b.getFilePath());
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }
}
