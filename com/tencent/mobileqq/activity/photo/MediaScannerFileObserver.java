package com.tencent.mobileqq.activity.photo;

import android.os.FileObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MediaScannerFileObserver extends FileObserver {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQAlbum";
    private String mFolderPath;
    private MediaScanner mMediaScanner;

    public MediaScannerFileObserver(MediaScanner mediaScanner, String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mediaScanner, (Object) str);
        } else {
            this.mFolderPath = str;
            this.mMediaScanner = mediaScanner;
        }
    }

    @Override // android.os.FileObserver
    public void onEvent(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            return;
        }
        if (this.mMediaScanner == null) {
            return;
        }
        if ((i3 == 8 || i3 == 128) && str != null && str.endsWith(".mp4")) {
            this.mMediaScanner.handleFileObserverEvent(i3, this.mFolderPath, str);
        }
    }
}
