package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorDataStream {
    static IPatchRedirector $redirector_;
    public ArrayList<QQLiveAnchorDataFrame> frames;
    public String name;
    public int rawLevel;

    public QQLiveAnchorDataStream() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveAnchorDataStream(QQLiveAnchorDataStream qQLiveAnchorDataStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataStream);
            return;
        }
        if (qQLiveAnchorDataStream == null) {
            return;
        }
        this.name = qQLiveAnchorDataStream.name;
        this.rawLevel = qQLiveAnchorDataStream.rawLevel;
        this.frames = new ArrayList<>();
        ArrayList<QQLiveAnchorDataFrame> arrayList = qQLiveAnchorDataStream.frames;
        if (arrayList != null) {
            Iterator<QQLiveAnchorDataFrame> it = arrayList.iterator();
            while (it.hasNext()) {
                this.frames.add(new QQLiveAnchorDataFrame(it.next()));
            }
        }
    }
}
