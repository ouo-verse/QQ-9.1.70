package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.SocketImplFactory;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MonitorSocketImplFactory implements SocketImplFactory {
    static IPatchRedirector $redirector_ = null;
    private static HashSet<String> mServerSocketSet = null;
    public static final String tag = "MSF.D.MonitorSocket";
    Context context;
    Class socketClass;
    SocketImpl socketImpl;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ProfileContants.FIELD_THEME_FONT_TYPE);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            mServerSocketSet = new HashSet<>();
        }
    }

    public MonitorSocketImplFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.socketClass = null;
        }
    }

    public static void addServerSocket(String str) {
        mServerSocketSet.add(str);
    }

    public static boolean isNetworkTypeMobile(int i3) {
        if (i3 != 0 && i3 != 2 && i3 != 3 && i3 != 4 && i3 != 5) {
            return false;
        }
        return true;
    }

    public static boolean isServerSocket(String str) {
        if (mServerSocketSet.contains(str)) {
            return true;
        }
        return false;
    }

    public static void removeServerSocket(String str) {
        mServerSocketSet.remove(str);
    }

    @Override // java.net.SocketImplFactory
    public SocketImpl createSocketImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SocketImpl) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new c(this.socketClass, this.context);
    }

    public boolean getMsfSocketImpl(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
        }
        try {
            this.context = context;
            Socket socket = new Socket();
            Field declaredField = Socket.class.getDeclaredField("impl");
            declaredField.setAccessible(true);
            SocketImpl socketImpl = (SocketImpl) declaredField.get(socket);
            this.socketImpl = socketImpl;
            this.socketClass = socketImpl.getClass();
            new c(this.socketClass, context);
            QLog.i(tag, 1, "Socket impl class: " + this.socketClass.getName());
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "get SocketImpl failed " + e16.getMessage());
                return false;
            }
            return false;
        }
    }
}
