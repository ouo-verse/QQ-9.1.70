package com.tencent.mobileqq.qqlive.room.gamedownloader.widget;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/a;", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/QQLiveCustomDistributeController$b;", "", "d", "onDownloadStart", "", "progress", "a", "onDownloadPause", "onDownloadFinish", "", "fromQQLive", "c", "errorCode", "e", "b", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class a implements QQLiveCustomDistributeController.b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
    public void a(int progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, progress);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
    public void c(boolean fromQQLive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, fromQQLive);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
    public void e(int errorCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, errorCode);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
    public void onDownloadFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
    public void onDownloadPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
    public void onDownloadStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
