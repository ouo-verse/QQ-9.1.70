package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
class SogouEmoji$3 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f204674d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f204675e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f204676f;
    final /* synthetic */ s this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SogouEmoji", 2, "func pullSingleEmojiKey begins, packId=" + this.f204674d + ",exprId:" + this.f204675e + ",isNewTask:" + this.f204676f);
        }
        throw null;
    }
}
