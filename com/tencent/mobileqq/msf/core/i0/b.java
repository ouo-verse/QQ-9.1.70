package com.tencent.mobileqq.msf.core.i0;

import android.net.NetworkInfo;
import com.tencent.mobileqq.msf.core.net.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a(int i3) {
        StringBuilder sb5 = new StringBuilder(32);
        if (i3 > 0) {
            sb5.append("(");
            sb5.append(Integer.toHexString(i3));
            sb5.append(")");
        } else {
            sb5.append(QzoneWebMusicJsPlugin.EVENT_UNKOWN);
        }
        return sb5.toString();
    }

    public static String a() {
        NetworkInfo[] a16 = k.a();
        if (a16 == null || a16.length <= 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder(128);
        sb5.append(a16.length);
        sb5.append("#");
        for (NetworkInfo networkInfo : a16) {
            if (networkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
                sb5.append(NetworkMonitor.getTypeName(networkInfo));
                sb5.append(",");
                sb5.append(networkInfo.getDetailedState());
                sb5.append(",");
                sb5.append(k.a(networkInfo));
                sb5.append(",");
                sb5.append(networkInfo.isAvailable() ? "1" : "0");
                sb5.append(",");
                sb5.append(networkInfo.isFailover() ? "1" : "0");
                sb5.append("|");
            }
        }
        return sb5.toString();
    }
}
