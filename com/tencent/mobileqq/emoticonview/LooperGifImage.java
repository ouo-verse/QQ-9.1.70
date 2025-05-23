package com.tencent.mobileqq.emoticonview;

import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes12.dex */
public class LooperGifImage extends NativeGifImage {
    static IPatchRedirector $redirector_;
    private int maxLoopTimes;

    public LooperGifImage(File file, boolean z16, float f16, int i3) throws IOException {
        super(file, z16, false, 0, 0, f16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, file, Boolean.valueOf(z16), Float.valueOf(f16), Integer.valueOf(i3));
        } else {
            this.maxLoopTimes = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.NativeGifImage, com.tencent.image.AbstractGifImage
    public void executeNewTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            if (this.mCurrentLoop == this.maxLoopTimes) {
                return;
            }
            super.executeNewTask();
        }
    }
}
