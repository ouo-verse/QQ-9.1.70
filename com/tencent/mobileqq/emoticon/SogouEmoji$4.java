package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
class SogouEmoji$4 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f204677d;
    final /* synthetic */ s this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmoji", 2, "func pullMultipleEmojiKey begins, allPackId:" + this.f204677d);
        }
        List list = this.f204677d;
        if (list != null && list.size() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("SogouEmoji", 2, "func pullMultipleEmojiKey,size:" + this.f204677d.size());
            }
            Iterator it = this.f204677d.iterator();
            if (!it.hasNext()) {
                return;
            }
            throw null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmoji", 2, "func pullMultipleEmojiKey ends, param packid is null.");
        }
    }
}
