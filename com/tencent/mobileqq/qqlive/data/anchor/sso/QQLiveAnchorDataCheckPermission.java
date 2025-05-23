package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes17.dex */
public class QQLiveAnchorDataCheckPermission extends QQLiveAnchorDataBase {
    static IPatchRedirector $redirector_;
    public List<String> unGrantPermissions;

    public QQLiveAnchorDataCheckPermission() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.unGrantPermissions = new ArrayList();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public QQLiveAnchorDataCheckPermission(boolean z16, QQLiveErrorMsg qQLiveErrorMsg) {
        super(z16, qQLiveErrorMsg);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.unGrantPermissions = new ArrayList();
        } else {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), qQLiveErrorMsg);
        }
    }

    public QQLiveAnchorDataCheckPermission(QQLiveAnchorDataCheckPermission qQLiveAnchorDataCheckPermission) {
        super(qQLiveAnchorDataCheckPermission);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorDataCheckPermission);
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.unGrantPermissions = arrayList;
        if (qQLiveAnchorDataCheckPermission == null || qQLiveAnchorDataCheckPermission.unGrantPermissions == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.unGrantPermissions.add((String) it.next());
        }
    }
}
