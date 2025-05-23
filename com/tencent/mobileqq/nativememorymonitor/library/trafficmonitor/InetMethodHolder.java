package com.tencent.mobileqq.nativememorymonitor.library.trafficmonitor;

import android.os.Build;
import com.tencent.mobileqq.nativememorymonitor.library.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.upload.report.UploadQualityReportBuilder;
import java.io.FileDescriptor;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* compiled from: P */
/* loaded from: classes15.dex */
public class InetMethodHolder {
    static IPatchRedirector $redirector_;
    private static final String ioCoreClass;
    public long close;
    public long connect;
    public long connectSocketAddress;
    public long readBytes;
    public long readv;
    public long recvfromBytes;
    public long recvmsg;
    public long sendmsg;
    public long sendtoBytes;
    public long sendtoBytesSocketAddress;
    public long socketRead0;
    public long socketWrite0;
    public long writeBytes;
    public long writev;

    static {
        String str;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11893);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        if (Build.VERSION.SDK_INT > 25) {
            str = "libcore.io.Linux";
        } else {
            str = "libcore.io.Posix";
        }
        ioCoreClass = str;
    }

    public InetMethodHolder() {
        long hiddenArtMethod;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 28) {
            return;
        }
        String str = ioCoreClass;
        Class cls = Integer.TYPE;
        this.connect = Utils.getHiddenArtMethod(str, UploadQualityReportBuilder.STATE_CONNECT, FileDescriptor.class, InetAddress.class, cls);
        this.connectSocketAddress = Utils.getHiddenArtMethod(str, UploadQualityReportBuilder.STATE_CONNECT, FileDescriptor.class, SocketAddress.class);
        this.close = Utils.getHiddenArtMethod(str, "close", FileDescriptor.class);
        this.readBytes = Utils.getHiddenArtMethod(str, "readBytes", FileDescriptor.class, Object.class, cls, cls);
        this.readv = Utils.getHiddenArtMethod(str, "readv", FileDescriptor.class, Object[].class, int[].class, int[].class);
        this.recvfromBytes = Utils.getHiddenArtMethod(str, "recvfromBytes", FileDescriptor.class, Object.class, cls, cls, cls, InetSocketAddress.class);
        if (i3 > 30) {
            try {
                hiddenArtMethod = Utils.getHiddenArtMethod(str, "recvmsg", FileDescriptor.class, Class.forName("android.system.StructMsghdr"), cls);
            } catch (Exception unused) {
                this.recvmsg = 0L;
                this.sendmsg = 0L;
            }
        } else {
            hiddenArtMethod = 0;
        }
        this.recvmsg = hiddenArtMethod;
        if (i3 > 30) {
            j3 = Utils.getHiddenArtMethod(str, "sendmsg", FileDescriptor.class, Class.forName("android.system.StructMsghdr"), cls);
        } else {
            j3 = 0;
        }
        this.sendmsg = j3;
        String str2 = ioCoreClass;
        Class cls2 = Integer.TYPE;
        this.sendtoBytes = Utils.getHiddenArtMethod(str2, "sendtoBytes", FileDescriptor.class, Object.class, cls2, cls2, cls2, InetAddress.class, cls2);
        this.sendtoBytesSocketAddress = Utils.getHiddenArtMethod(str2, "sendtoBytes", FileDescriptor.class, Object.class, cls2, cls2, cls2, SocketAddress.class);
        this.writeBytes = Utils.getHiddenArtMethod(str2, "writeBytes", FileDescriptor.class, Object.class, cls2, cls2);
        this.writev = Utils.getHiddenArtMethod(str2, "writev", FileDescriptor.class, Object[].class, int[].class, int[].class);
        this.socketWrite0 = Utils.getHiddenArtMethod("java.net.SocketOutputStream", "socketWrite0", FileDescriptor.class, byte[].class, cls2, cls2);
        this.socketRead0 = Utils.getHiddenArtMethod("java.net.SocketInputStream", "socketRead0", FileDescriptor.class, byte[].class, cls2, cls2, cls2);
    }
}
