package com.tencent.msfcap;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes21.dex */
public class MSFCapTools {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f336871a = "MSFCapTools";

    /* renamed from: b, reason: collision with root package name */
    public static final int f336872b = 18989;

    /* renamed from: c, reason: collision with root package name */
    public static final int f336873c = 50;

    /* renamed from: d, reason: collision with root package name */
    private static final int f336874d = 2048;

    public MSFCapTools() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int a(int i3, int i16, int i17) {
        return i17 + (i3 * 2) + i16;
    }

    public static Parcel b(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        return obtain;
    }

    public static void a(ToServiceMsg toServiceMsg, int i3) {
        if (toServiceMsg == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Socket socket = new Socket();
        try {
            try {
                byte[] a16 = a(toServiceMsg);
                socket.connect(new InetSocketAddress("127.0.0.1", f336872b), 50);
                if (socket.isConnected()) {
                    a(new DataOutputStream(socket.getOutputStream()), i3, a16);
                    toServiceMsg.putWupBuffer(((ToServiceMsg) a(a(new DataInputStream(socket.getInputStream())), ToServiceMsg.CREATOR)).getWupBuffer());
                }
                try {
                    if (socket.isConnected()) {
                        socket.close();
                    }
                } catch (IOException unused) {
                }
                Log.d(f336871a, String.format("CapToServiceMsg %s used %sms", toServiceMsg, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            } catch (Exception unused2) {
                if (socket.isConnected()) {
                    socket.close();
                }
                Log.d(f336871a, String.format("CapToServiceMsg %s used %sms", toServiceMsg, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            } catch (Throwable th5) {
                try {
                    if (socket.isConnected()) {
                        socket.close();
                    }
                } catch (IOException unused3) {
                }
                Log.d(f336871a, String.format("CapToServiceMsg %s used %sms", toServiceMsg, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                throw th5;
            }
        } catch (IOException unused4) {
            Log.d(f336871a, String.format("CapToServiceMsg %s used %sms", toServiceMsg, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
    }

    public static byte[] a(DataInputStream dataInputStream) throws IOException {
        dataInputStream.readInt();
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(bArr);
        return bArr;
    }

    public static void a(DataOutputStream dataOutputStream, int i3, byte[] bArr) throws IOException {
        dataOutputStream.writeInt(i3);
        dataOutputStream.flush();
        dataOutputStream.writeInt(bArr.length);
        dataOutputStream.flush();
        dataOutputStream.write(bArr);
        dataOutputStream.flush();
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x002f: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:31:0x002f */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(Serializable serializable) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream3 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (IOException e16) {
                e = e16;
                objectOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (objectOutputStream3 != null) {
                }
                try {
                    byteArrayOutputStream.close();
                    throw th;
                } catch (IOException unused) {
                    throw th;
                }
            }
            try {
                objectOutputStream.writeObject(serializable);
                objectOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                } catch (IOException unused2) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused3) {
                }
                return byteArray;
            } catch (IOException e17) {
                e = e17;
                e.printStackTrace();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused5) {
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            objectOutputStream3 = objectOutputStream2;
            if (objectOutputStream3 != null) {
                try {
                    objectOutputStream3.close();
                } catch (IOException unused6) {
                }
            }
            byteArrayOutputStream.close();
            throw th;
        }
    }

    public static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            messageDigest.update(bArr);
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static void a(FromServiceMsg fromServiceMsg, int i3) {
        if (fromServiceMsg == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Socket socket = new Socket();
        try {
            try {
                byte[] a16 = a(fromServiceMsg);
                socket.connect(new InetSocketAddress("127.0.0.1", f336872b), 50);
                if (socket.isConnected()) {
                    a(new DataOutputStream(socket.getOutputStream()), i3, a16);
                    if (a16.length > 2048 && fromServiceMsg.getWupBuffer() != null) {
                        Log.d(f336871a, String.format("CapFromServerMsg send %s buffermd5:%s", fromServiceMsg, a(fromServiceMsg.getWupBuffer())));
                    }
                    byte[] a17 = a(new DataInputStream(socket.getInputStream()));
                    FromServiceMsg fromServiceMsg2 = (FromServiceMsg) a(a17, FromServiceMsg.CREATOR);
                    if (a17.length > 2048 && fromServiceMsg.getWupBuffer() != null) {
                        Log.d(f336871a, String.format("CapFromServerMsg recv %s buffermd5:%s", fromServiceMsg, a(fromServiceMsg2.getWupBuffer())));
                    }
                    fromServiceMsg.putWupBuffer(fromServiceMsg2.getWupBuffer());
                }
                try {
                    if (socket.isConnected()) {
                        socket.close();
                    }
                } catch (IOException unused) {
                }
                Log.d(f336871a, String.format("CapFromServiceMsg %s used %sms", fromServiceMsg, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            } catch (Exception unused2) {
                if (socket.isConnected()) {
                    socket.close();
                }
                Log.d(f336871a, String.format("CapFromServiceMsg %s used %sms", fromServiceMsg, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            } catch (Throwable th5) {
                try {
                    if (socket.isConnected()) {
                        socket.close();
                    }
                } catch (IOException unused3) {
                }
                Log.d(f336871a, String.format("CapFromServiceMsg %s used %sms", fromServiceMsg, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                throw th5;
            }
        } catch (IOException unused4) {
            Log.d(f336871a, String.format("CapFromServiceMsg %s used %sms", fromServiceMsg, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
    }

    public static byte[] a(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        return marshall;
    }

    public static <T> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel b16 = b(bArr);
        T createFromParcel = creator.createFromParcel(b16);
        OaidMonitor.parcelRecycle(b16);
        return createFromParcel;
    }
}
