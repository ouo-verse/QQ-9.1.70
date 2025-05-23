package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.SocketImpl;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class i extends Socket {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f248768a = "MSFSocket";

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        long j3 = 0;
        try {
            int b16 = b();
            if (b16 != -1) {
                j3 = CodecWarpper.getPacketLossLength(b16);
            }
            if (QLog.isColorLevel()) {
                QLog.d(f248768a, 1, "getLossPacketLength = " + j3);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(f248768a, 1, "getLossPacketLength fail", th5);
            }
        }
        return j3;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        int i3 = -1;
        try {
            Field declaredField = Socket.class.getDeclaredField("impl");
            declaredField.setAccessible(true);
            SocketImpl socketImpl = (SocketImpl) declaredField.get(this);
            Method declaredMethod = Socket.class.getClassLoader().loadClass("java.net.SocketImpl").getDeclaredMethod("getFileDescriptor", new Class[0]);
            declaredMethod.setAccessible(true);
            FileDescriptor fileDescriptor = (FileDescriptor) declaredMethod.invoke(socketImpl, new Object[0]);
            if (fileDescriptor != null) {
                Field declaredField2 = FileDescriptor.class.getDeclaredField("descriptor");
                declaredField2.setAccessible(true);
                i3 = ((Integer) declaredField2.get(fileDescriptor)).intValue();
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(f248768a, 1, "getSocketFd fail", th5);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(f248768a, 1, "getSocketFd = " + i3);
        }
        return i3;
    }
}
