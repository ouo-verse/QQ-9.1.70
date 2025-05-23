package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e extends SimpleFilePresenter {
    public e(FileBrowserModelBase fileBrowserModelBase, Activity activity) {
        super(fileBrowserModelBase, activity);
    }

    private void A0(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                this.G.f0(this.f208461f.getString(R.string.b8y));
                return;
            } else {
                this.G.f0(this.f208461f.getString(R.string.b8z));
                return;
            }
        }
        this.G.f0(this.f208461f.getString(R.string.b8x));
    }

    private void B0(int i3) {
        switch (i3) {
            case 5:
            case 7:
                this.G.f0(this.f208461f.getString(R.string.cmj));
                break;
            case 6:
                this.G.f0(this.f208461f.getString(R.string.cmm));
                break;
            case 8:
            case 9:
                this.G.f0(this.f208461f.getString(R.string.cmn));
                break;
            case 10:
            default:
                if (QLog.isColorLevel()) {
                    QLog.e("SimpleFilePresenter<FileAssistant>", 2, "getFileTips: opType[OPERATION_TYPE_OLFILE_BE_PC_HANDLED] status[" + i3 + "not implemented");
                    break;
                }
                break;
            case 11:
            case 12:
            case 13:
            case 14:
                break;
        }
        this.G.m0(true);
        this.G.n(false);
    }

    private void C0(int i3) {
        switch (i3) {
            case 10:
            case 11:
            case 12:
                this.G.f0(this.f208461f.getString(R.string.cmi));
                this.G.n(false);
                return;
            case 13:
            default:
                if (QLog.isColorLevel()) {
                    QLog.e("SimpleFilePresenter<FileAssistant>", 2, "getFileTips: opType[OPERATION_TYPE_OLFILE_GOTO_UPLOAD] status[" + i3 + "not implemented");
                    return;
                }
                return;
            case 14:
            case 15:
                return;
        }
    }

    private void y0() {
        int M = this.f208460e.M();
        A0(this.f208460e.V());
        z0(M);
    }

    private void z0(int i3) {
        if (i3 != -1 && i3 != 1) {
            switch (i3) {
                case 9:
                    C0(this.f208460e.R());
                    return;
                case 10:
                    this.G.o(false);
                    this.G.n(false);
                    this.G.f0(this.f208461f.getString(R.string.cmn));
                    return;
                case 11:
                    B0(this.f208460e.R());
                    return;
                case 12:
                case 13:
                    return;
                default:
                    if (QLog.isColorLevel()) {
                        QLog.e("SimpleFilePresenter<FileAssistant>", 2, "getFileTips: opType[" + i3 + "not implemented");
                        return;
                    }
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void I() {
        super.I();
        int R = this.f208460e.R();
        if (R == 8 || R == 9 || R == 5 || R == 7 || R == 12 || R == 6 || R == 16) {
            this.G.n(false);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter, com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void K() {
        super.K();
        if (QLog.isColorLevel()) {
            QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = online simple");
        }
        this.G.V(q.g(this.f208460e.Q()));
        y0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void e() {
        P();
        y0();
    }
}
