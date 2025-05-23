package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorDataRoomRichTitle {
    static IPatchRedirector $redirector_;
    public ArrayList<QQLiveAnchorDataRichTitleElement> elements;

    public QQLiveAnchorDataRoomRichTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveAnchorDataRoomRichTitle(QQLiveAnchorDataRoomRichTitle qQLiveAnchorDataRoomRichTitle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataRoomRichTitle);
            return;
        }
        if (qQLiveAnchorDataRoomRichTitle == null || qQLiveAnchorDataRoomRichTitle.elements == null) {
            return;
        }
        this.elements = new ArrayList<>();
        Iterator<QQLiveAnchorDataRichTitleElement> it = qQLiveAnchorDataRoomRichTitle.elements.iterator();
        while (it.hasNext()) {
            this.elements.add(new QQLiveAnchorDataRichTitleElement(it.next()));
        }
    }
}
