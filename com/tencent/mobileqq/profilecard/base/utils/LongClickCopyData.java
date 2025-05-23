package com.tencent.mobileqq.profilecard.base.utils;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class LongClickCopyData {
    static IPatchRedirector $redirector_;
    public List<CopyItem> mDataList;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private static class CopyItem {
        static IPatchRedirector $redirector_;
        final String mCopyContent;
        final String mMenuTitle;

        CopyItem(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            } else {
                this.mMenuTitle = str;
                this.mCopyContent = str2;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return String.format("CopyItem{mMenuTitle=%s mCopyContent=%s}", this.mMenuTitle, this.mCopyContent);
        }
    }

    public LongClickCopyData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mDataList = new ArrayList(1);
        }
    }

    public void addCopyItem(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            this.mDataList.add(new CopyItem(str, str2));
        }
    }

    public void attachToMenu(com.tencent.mobileqq.utils.dialogutils.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else if (aVar != null) {
            aVar.d();
            Iterator<CopyItem> it = this.mDataList.iterator();
            while (it.hasNext()) {
                aVar.b(R.id.u9j, it.next().mMenuTitle, 0);
            }
        }
    }

    public String getCopyContent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        for (CopyItem copyItem : this.mDataList) {
            if (str != null && str.equals(copyItem.mMenuTitle)) {
                return copyItem.mCopyContent;
            }
        }
        return null;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return Arrays.toString(this.mDataList.toArray());
    }
}
