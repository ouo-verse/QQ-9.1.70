package com.tencent.mobileqq.hotpic;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes9.dex */
public class HotPicTagInfo extends Entity implements Comparable<HotPicTagInfo> {
    static IPatchRedirector $redirector_;
    public int position;

    @unique
    public int tagId;
    public String tagName;
    public int tagType;
    public int version;

    public HotPicTagInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(HotPicTagInfo hotPicTagInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) hotPicTagInfo)).intValue();
        }
        int i3 = this.position;
        int i16 = hotPicTagInfo.position;
        if (i3 < i16) {
            return -1;
        }
        return i3 == i16 ? 0 : 1;
    }
}
