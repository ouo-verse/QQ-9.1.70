package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForVideoEmoticon;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class s {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public MessageRecord f205289a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f205290b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f205291c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f205292d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f205293e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f205294f;

    public s(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) messageRecord);
            return;
        }
        this.f205289a = messageRecord;
        this.f205291c = messageRecord instanceof MessageForPic;
        this.f205293e = messageRecord instanceof MessageForVideoEmoticon;
    }
}
