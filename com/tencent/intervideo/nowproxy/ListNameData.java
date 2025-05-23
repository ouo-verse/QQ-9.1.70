package com.tencent.intervideo.nowproxy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ListNameData {
    static IPatchRedirector $redirector_;
    public int mCurIndex;
    public ArrayList<String> mListNames;

    public ListNameData(ArrayList<String> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) arrayList, i3);
        } else {
            this.mListNames = arrayList;
            this.mCurIndex = i3;
        }
    }
}
