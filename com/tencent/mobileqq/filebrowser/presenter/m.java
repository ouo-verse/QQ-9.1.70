package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class m extends SimpleFilePresenter {
    static IPatchRedirector $redirector_;
    private WeakReference<Activity> K;
    private MsgRecordParams L;

    public m(com.tencent.mobileqq.filebrowser.e eVar, Activity activity) {
        super(eVar, activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) activity);
            return;
        }
        b0(new SimpleFileBrowserView(activity));
        this.K = new WeakReference<>(activity);
        this.L = eVar.B();
    }

    private void k0() {
        l0(this.f205964e.a());
    }

    private void l0(int i3) {
        if (i3 != -1 && i3 != 1) {
            switch (i3) {
                case 9:
                    n0(this.f205964e.c());
                    return;
                case 10:
                    this.H.q(false);
                    this.H.o(false);
                    this.H.J(this.f205966h.getString(R.string.cmn));
                    return;
                case 11:
                    m0(this.f205964e.c());
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

    private void m0(int i3) {
        switch (i3) {
            case 5:
            case 7:
                this.H.J(this.f205966h.getString(R.string.cmj));
                break;
            case 6:
                this.H.J(this.f205966h.getString(R.string.cmm));
                break;
            case 8:
            case 9:
                this.H.J(this.f205966h.getString(R.string.cmn));
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
        this.H.N(true);
        this.H.o(false);
    }

    private void n0(int i3) {
        switch (i3) {
            case 10:
            case 11:
            case 12:
                this.H.J(this.f205966h.getString(R.string.cmi));
                this.H.o(false);
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(int i3) {
        if (i3 != 0) {
            QQToast.makeText(this.f205966h, 1, R.string.f1359302s, 0).show();
            return;
        }
        Activity activity = this.K.get();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(final int i3, String str) {
        QLog.i("SimpleFilePresenter<FileAssistant>", 1, "reqToOfflineSendMsg result:" + i3 + ", errMsg:" + str);
        this.H.c().post(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.presenter.l
            @Override // java.lang.Runnable
            public final void run() {
                m.this.o0(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.L == null) {
            QLog.i("SimpleFilePresenter<FileAssistant>", 1, "msgRecordParams is null");
        } else {
            com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 == null) {
                QLog.i("SimpleFilePresenter<FileAssistant>", 1, "getKernelMsgService return null");
            } else {
                e16.reqToOfflineSendMsg(new Contact(this.L.a(), this.L.e(), ""), this.L.b(), new IOperateCallback() { // from class: com.tencent.mobileqq.filebrowser.presenter.j
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        m.this.p0(i3, str);
                    }
                });
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(int i3) {
        if (i3 != 0) {
            QQToast.makeText(this.f205966h, 1, R.string.f1359302s, 0).show();
            return;
        }
        Activity activity = this.K.get();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(final int i3, String str) {
        QLog.i("SimpleFilePresenter<FileAssistant>", 1, "refuseReceiveOnlineFileMsg result:" + i3 + ", errMsg:" + str);
        this.H.c().post(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.presenter.k
            @Override // java.lang.Runnable
            public final void run() {
                m.this.r0(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.L == null) {
            QLog.i("SimpleFilePresenter<FileAssistant>", 1, "msgRecordParams is null");
        } else {
            com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 == null) {
                QLog.i("SimpleFilePresenter<FileAssistant>", 1, "getKernelMsgService return null");
            } else {
                e16.refuseReceiveOnlineFileMsg(new Contact(this.L.a(), this.L.e(), ""), this.L.b(), new IOperateCallback() { // from class: com.tencent.mobileqq.filebrowser.presenter.i
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        m.this.s0(i3, str);
                    }
                });
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.E.e(this.f205966h.getString(R.string.f1359502u), new View.OnClickListener() { // from class: com.tencent.mobileqq.filebrowser.presenter.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    m.this.q0(view);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter, com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.H();
        if (QLog.isColorLevel()) {
            QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = online simple");
        }
        this.H.B(com.tencent.mobileqq.filemanager.util.q.g(this.f205964e.getFileSize()));
        k0();
        Y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter
    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.H.F(this.f205966h.getString(R.string.f1359402t), new View.OnClickListener() { // from class: com.tencent.mobileqq.filebrowser.presenter.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    m.this.t0(view);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter, com.tencent.mobileqq.filebrowser.e.f
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            M();
            k0();
        }
    }
}
