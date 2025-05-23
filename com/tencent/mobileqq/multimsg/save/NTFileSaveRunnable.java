package com.tencent.mobileqq.multimsg.save;

import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import java.io.File;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NTFileSaveRunnable implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private File f251666d;

    /* renamed from: e, reason: collision with root package name */
    private File f251667e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f251668f;

    /* renamed from: h, reason: collision with root package name */
    private d f251669h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f251670i;

    /* renamed from: m, reason: collision with root package name */
    private FileTransNotifyInfo f251671m;

    public NTFileSaveRunnable(File file, File file2, Handler handler, FileTransNotifyInfo fileTransNotifyInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, file, file2, handler, fileTransNotifyInfo, Boolean.valueOf(z16));
            return;
        }
        this.f251666d = file;
        this.f251667e = file2;
        this.f251668f = handler;
        this.f251669h = new d();
        this.f251670i = z16;
        this.f251671m = fileTransNotifyInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0142  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z16;
        File file;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f251668f == null) {
            return;
        }
        File file2 = this.f251666d;
        if (file2 != null && file2.exists()) {
            if (this.f251670i && (file = this.f251667e) != null && file.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.e("PictureSaveRunnable", 2, "desFile exist");
                }
                Message obtainMessage = this.f251668f.obtainMessage(3);
                this.f251669h.f251680c = (int) this.f251671m.getFileErrCode();
                this.f251669h.f251681d = this.f251671m.getFileErrMsg();
                obtainMessage.obj = this.f251669h;
                this.f251668f.sendMessage(obtainMessage);
                return;
            }
            int i16 = 0;
            try {
                if (this.f251667e != null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("PictureSaveRunnable", 2, "FileSaveRunnable run savePhotoToSysAlbum...destFile=" + this.f251667e);
                    }
                    if (!this.f251667e.getParentFile().exists()) {
                        boolean mkdir = this.f251667e.getParentFile().mkdir();
                        if (QLog.isColorLevel()) {
                            QLog.i("PictureSaveRunnable", 2, "FileSaveRunnable run savePhotoToSysAlbum...destFile.getParentFile() not exist mkdir=" + mkdir);
                        }
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("PictureSaveRunnable", 2, "save exception = " + e16.getMessage());
                }
                d dVar = this.f251669h;
                dVar.f251680c = 10005;
                dVar.f251681d = b.a(10005);
            }
            if (this.f251667e != null && n0.a.b(new VFSFile(this.f251666d), new VFSFile(this.f251667e), true)) {
                if (QLog.isColorLevel()) {
                    QLog.e("PictureSaveRunnable", 2, "savePhotoToSysAlbum...");
                }
                BaseImageUtil.savePic2SystemMedia(BaseApplicationImpl.getApplication(), this.f251667e);
                BaseImageUtil.savePhotoToSysAlbum(BaseApplication.getContext(), this.f251667e.getAbsolutePath());
                z16 = true;
                if (z16) {
                }
                d dVar2 = this.f251669h;
                if (!z16) {
                }
                dVar2.f251679b = i16;
                Message obtainMessage2 = this.f251668f.obtainMessage(i3);
                obtainMessage2.obj = this.f251669h;
                this.f251668f.sendMessage(obtainMessage2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("PictureSaveRunnable", 2, "copyFile error");
            }
            d dVar3 = this.f251669h;
            dVar3.f251680c = 10004;
            dVar3.f251681d = b.a(10004);
            z16 = false;
            if (z16) {
                i3 = 1;
            }
            d dVar22 = this.f251669h;
            if (!z16) {
                i16 = -1;
            }
            dVar22.f251679b = i16;
            Message obtainMessage22 = this.f251668f.obtainMessage(i3);
            obtainMessage22.obj = this.f251669h;
            this.f251668f.sendMessage(obtainMessage22);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("PictureSaveRunnable", 2, "save file fail");
        }
        Message obtainMessage3 = this.f251668f.obtainMessage(2);
        d dVar4 = this.f251669h;
        dVar4.f251680c = 10003;
        dVar4.f251681d = b.a(10003);
        obtainMessage3.obj = this.f251669h;
        this.f251668f.sendMessage(obtainMessage3);
    }
}
