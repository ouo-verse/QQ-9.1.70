package com.tencent.mobileqq.multimsg.save;

import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes15.dex */
public class FileSaveRunnable implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private File f251661d;

    /* renamed from: e, reason: collision with root package name */
    private File f251662e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f251663f;

    /* renamed from: h, reason: collision with root package name */
    private d f251664h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f251665i;

    public FileSaveRunnable(File file, File file2, Handler handler, d dVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, file, file2, handler, dVar, Boolean.valueOf(z16));
            return;
        }
        this.f251661d = file;
        this.f251662e = file2;
        this.f251663f = handler;
        this.f251664h = dVar;
        this.f251665i = z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0128  */
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
        File file2 = this.f251661d;
        if (file2 != null && file2.exists()) {
            if (this.f251665i && (file = this.f251662e) != null && file.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.e("PictureSaveRunnable", 2, "desFile exist");
                }
                Message obtainMessage = this.f251663f.obtainMessage(3);
                obtainMessage.obj = this.f251664h;
                this.f251663f.sendMessage(obtainMessage);
                return;
            }
            int i16 = 0;
            try {
                if (this.f251662e != null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("PictureSaveRunnable", 2, "FileSaveRunnable run savePhotoToSysAlbum...destFile=" + this.f251662e);
                    }
                    if (!this.f251662e.getParentFile().exists()) {
                        boolean mkdir = this.f251662e.getParentFile().mkdir();
                        if (QLog.isColorLevel()) {
                            QLog.i("PictureSaveRunnable", 2, "FileSaveRunnable run savePhotoToSysAlbum...destFile.getParentFile() not exist mkdir=" + mkdir);
                        }
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("PictureSaveRunnable", 2, "save exception = " + e16.getMessage());
                }
                d dVar = this.f251664h;
                dVar.f251680c = 10005;
                dVar.f251681d = b.a(10005);
            }
            if (this.f251662e != null && n0.a.b(new VFSFile(this.f251661d), new VFSFile(this.f251662e), true)) {
                if (QLog.isColorLevel()) {
                    QLog.e("PictureSaveRunnable", 2, "savePhotoToSysAlbum...");
                }
                BaseImageUtil.savePic2SystemMedia(BaseApplicationImpl.getApplication(), this.f251662e);
                BaseImageUtil.savePhotoToSysAlbum(BaseApplication.getContext(), this.f251662e.getAbsolutePath());
                z16 = true;
                if (z16) {
                }
                d dVar2 = this.f251664h;
                if (!z16) {
                }
                dVar2.f251679b = i16;
                Message obtainMessage2 = this.f251663f.obtainMessage(i3);
                obtainMessage2.obj = this.f251664h;
                this.f251663f.sendMessage(obtainMessage2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("PictureSaveRunnable", 2, "copyFile error");
            }
            d dVar3 = this.f251664h;
            dVar3.f251680c = 10004;
            dVar3.f251681d = b.a(10004);
            z16 = false;
            if (z16) {
                i3 = 1;
            }
            d dVar22 = this.f251664h;
            if (!z16) {
                i16 = -1;
            }
            dVar22.f251679b = i16;
            Message obtainMessage22 = this.f251663f.obtainMessage(i3);
            obtainMessage22.obj = this.f251664h;
            this.f251663f.sendMessage(obtainMessage22);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("PictureSaveRunnable", 2, "save file fail");
        }
        Message obtainMessage3 = this.f251663f.obtainMessage(2);
        d dVar4 = this.f251664h;
        dVar4.f251680c = 10003;
        dVar4.f251681d = b.a(10003);
        obtainMessage3.obj = this.f251664h;
        this.f251663f.sendMessage(obtainMessage3);
    }
}
