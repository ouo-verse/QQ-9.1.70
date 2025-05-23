package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filebrowser.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class o extends n implements View.OnClickListener, e.a {
    static IPatchRedirector $redirector_;
    protected boolean V;
    protected long W;
    private boolean X;

    public o(com.tencent.mobileqq.filebrowser.e eVar, Activity activity) {
        super(eVar, activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) activity);
            return;
        }
        this.V = false;
        this.W = 0L;
        this.X = false;
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.n, com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter, com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter, com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.H();
        this.H.N(false);
        this.H.B(com.tencent.mobileqq.filemanager.util.q.g(this.f205964e.getFileSize()));
        this.f205963d.u(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filebrowser.presenter.n, com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter
    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.H.L(this.X);
        if (FileUtils.fileExistsAndNotEmpty(this.f205964e.getFilePath())) {
            super.Y();
        } else if (this.X) {
            this.H.F(this.f205966h.getString(R.string.beu), this);
            this.H.L(this.X);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.V) {
            return;
        }
        this.V = true;
        this.H.N(true);
        if (QLog.isDevelopLevel()) {
            QLog.d("PreviewVideoSimpleFilePresenter", 4, "executeOnNetWorkThread setCanPreview false-------------");
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e.a
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f205963d.W(this.f205965f);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e.a
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.X = true;
            Y();
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e.a
    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            com.tencent.mobileqq.filemanager.util.d.f("\u7f51\u7edc\u8fde\u63a5\u5f02\u5e38\u6216\u662f\u89c6\u9891\u5185\u5bb9\u65e0\u6cd5\u6253\u5f00\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else if (System.currentTimeMillis() - this.W < 500) {
            if (QLog.isColorLevel()) {
                QLog.d("PreviewVideoSimpleFilePresenter", 2, "click online preview video too fast");
            }
        } else {
            this.W = System.currentTimeMillis();
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                com.tencent.mobileqq.filemanager.util.d.f(this.f205966h.getString(R.string.zst));
            } else {
                this.f205963d.N(this);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
