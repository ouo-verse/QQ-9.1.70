package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FavoriteDownloader extends AlbumThumbDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final String PROTOCOL_FAVORITE = "favorite";
    public static final String TAG = "FavoriteDownloader";

    public FavoriteDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static URL generateURL(String str, String str2) {
        StringBuilder sb5 = new StringBuilder("favorite");
        sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        sb5.append(str);
        if (str2 != null) {
            sb5.append("#");
            sb5.append(str2);
        }
        try {
            return new URL(sb5.toString());
        } catch (MalformedURLException unused) {
            return null;
        }
    }
}
