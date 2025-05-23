package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorDataFrame {
    static IPatchRedirector $redirector_;
    public ArrayList<QQLiveAnchorDataAddress> addresses;
    public int codecType;
    public String definition;
    public int level;

    public QQLiveAnchorDataFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveAnchorDataFrame(QQLiveAnchorDataFrame qQLiveAnchorDataFrame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataFrame);
            return;
        }
        if (qQLiveAnchorDataFrame == null) {
            return;
        }
        this.level = qQLiveAnchorDataFrame.level;
        this.definition = qQLiveAnchorDataFrame.definition;
        this.codecType = qQLiveAnchorDataFrame.codecType;
        if (qQLiveAnchorDataFrame.addresses != null) {
            this.addresses = new ArrayList<>();
            Iterator<QQLiveAnchorDataAddress> it = qQLiveAnchorDataFrame.addresses.iterator();
            while (it.hasNext()) {
                this.addresses.add(new QQLiveAnchorDataAddress(it.next()));
            }
        }
    }
}
