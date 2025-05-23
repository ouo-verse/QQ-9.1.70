package com.tencent.beacon.base.net.adapter;

import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.NetException;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.pack.SocketRequestPackage;
import com.tencent.beacon.pack.SocketResponsePackage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f extends AbstractNetAdapter {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.beacon.base.net.a.c<byte[], SocketResponsePackage> f77715a = new com.tencent.beacon.base.net.a.e();

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.beacon.base.net.a.c<JceRequestEntity, SocketRequestPackage> f77716b = new com.tencent.beacon.base.net.a.d();

    f() {
    }

    public static AbstractNetAdapter a() {
        return new f();
    }

    @Override // com.tencent.beacon.base.net.adapter.AbstractNetAdapter
    public void request(com.tencent.beacon.base.net.call.e eVar, Callback<BResponse> callback) {
    }

    private void a(Callback<byte[]> callback, String str, SocketResponsePackage socketResponsePackage) throws NetException {
        String str2 = socketResponsePackage.f78093msg;
        if (str2 != null && str2.equals("decrypt Data fail!")) {
            callback.onFailure(new com.tencent.beacon.base.net.d(str, "405", socketResponsePackage.statusCode, "server encrypt-status error!"));
        } else {
            callback.onResponse(socketResponsePackage.body);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.tencent.beacon.base.net.call.JceRequestEntity, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r11v7 */
    @Override // com.tencent.beacon.base.net.adapter.AbstractNetAdapter
    public void request(JceRequestEntity jceRequestEntity, Callback<byte[]> callback) {
        String domain = jceRequestEntity.getDomain();
        if (TextUtils.isEmpty(domain)) {
            return;
        }
        String name = jceRequestEntity.getType().name();
        try {
            try {
                try {
                    try {
                        try {
                            byte[] byteArray = this.f77716b.a(jceRequestEntity).toByteArray();
                            if (byteArray != null && byteArray.length > 65535) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("content length is too long:");
                                sb5.append(byteArray.length);
                                callback.onFailure(new com.tencent.beacon.base.net.d(name, PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE, -1, sb5.toString()));
                                return;
                            }
                            Socket a16 = a(domain, jceRequestEntity.getPort());
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("send data size: ");
                            sb6.append(jceRequestEntity.getContent().length);
                            com.tencent.beacon.base.util.c.a("SocketAdapter", 0, sb6.toString(), new Object[0]);
                            a(a16, this.f77716b.a(jceRequestEntity));
                            byte[] a17 = a(a16, jceRequestEntity.getType() == RequestType.EVENT);
                            if (a17 != null && a17.length > 0) {
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("receivedData: ");
                                sb7.append(a17.length);
                                com.tencent.beacon.base.util.c.a("SocketAdapter", 1, sb7.toString(), new Object[0]);
                                SocketResponsePackage a18 = this.f77715a.a(a17);
                                if (a18 == null) {
                                    callback.onFailure(new com.tencent.beacon.base.net.d(name, "402", -1, "responsePackage == null"));
                                    if (a16 == null || a16.isClosed()) {
                                        return;
                                    }
                                    try {
                                        a16.close();
                                        return;
                                    } catch (IOException e16) {
                                        com.tencent.beacon.base.util.c.a(e16);
                                        return;
                                    }
                                }
                                com.tencent.beacon.base.util.c.a("SocketAdapter", 2, "socket response code: %s, header: %s, msg: %s", Integer.valueOf(a18.statusCode), a18.header, a18.f78093msg);
                                int i3 = a18.statusCode;
                                if (i3 == 200) {
                                    a(callback, name, a18);
                                } else {
                                    StringBuilder sb8 = new StringBuilder();
                                    sb8.append("responsePackage msg: ");
                                    sb8.append(a18.f78093msg);
                                    callback.onFailure(new com.tencent.beacon.base.net.d(name, "402", i3, sb8.toString()));
                                }
                                if (a16 == null || a16.isClosed()) {
                                    return;
                                }
                                a16.close();
                                return;
                            }
                            callback.onFailure(new com.tencent.beacon.base.net.d(name, "402", -1, "receiveData == null"));
                            if (a16 == null || a16.isClosed()) {
                                return;
                            }
                            try {
                                a16.close();
                            } catch (IOException e17) {
                                com.tencent.beacon.base.util.c.a(e17);
                            }
                        } finally {
                        }
                    } catch (ConnectException e18) {
                        Socket socket = null;
                        callback.onFailure(new com.tencent.beacon.base.net.d(name, "401", -1, " connect time more than 30s", e18));
                        jceRequestEntity = socket;
                        if (0 != 0) {
                            boolean isClosed = socket.isClosed();
                            jceRequestEntity = socket;
                            if (!isClosed) {
                                socket.close();
                                jceRequestEntity = socket;
                            }
                        }
                    }
                } catch (SocketTimeoutException e19) {
                    Socket socket2 = null;
                    callback.onFailure(new com.tencent.beacon.base.net.d(name, "401", -1, " request time more than 30s", e19));
                    jceRequestEntity = socket2;
                    if (0 != 0) {
                        boolean isClosed2 = socket2.isClosed();
                        jceRequestEntity = socket2;
                        if (!isClosed2) {
                            socket2.close();
                            jceRequestEntity = socket2;
                        }
                    }
                }
            } catch (IOException e26) {
                com.tencent.beacon.base.util.c.a(e26);
            }
        } catch (Throwable th5) {
            if (jceRequestEntity != 0 && !jceRequestEntity.isClosed()) {
                try {
                    jceRequestEntity.close();
                } catch (IOException e27) {
                    com.tencent.beacon.base.util.c.a(e27);
                }
            }
        }
    }

    private byte[] a(Socket socket, boolean z16) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = socket.getInputStream();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!z16) {
                ByteBuffer allocate = ByteBuffer.allocate(byteArray.length - 4);
                allocate.put(byteArray, 2, byteArray.length - 4);
                byteArray = allocate.array();
            }
            byteArrayOutputStream.close();
            inputStream.close();
            com.tencent.beacon.base.util.b.a(inputStream, byteArrayOutputStream);
            return byteArray;
        } catch (Throwable th7) {
            th = th7;
            inputStream2 = inputStream;
            try {
                com.tencent.beacon.base.util.c.a(th);
                com.tencent.beacon.base.util.b.a(inputStream2, byteArrayOutputStream);
                throw th;
            } catch (Throwable th8) {
                com.tencent.beacon.base.util.b.a(inputStream2, byteArrayOutputStream);
                throw th8;
            }
        }
    }

    private void a(Socket socket, SocketRequestPackage socketRequestPackage) throws IOException {
        com.tencent.beacon.pack.b bVar = new com.tencent.beacon.pack.b();
        socketRequestPackage.writeTo(bVar);
        OutputStream outputStream = socket.getOutputStream();
        byte[] b16 = bVar.b();
        outputStream.write(a(b16, b16.length));
        outputStream.flush();
    }

    private byte[] a(byte[] bArr, int i3) {
        int i16 = i3 + 4;
        ByteBuffer allocate = ByteBuffer.allocate(i16);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.putShort((short) (i16 & 65535));
        allocate.put(bArr);
        allocate.put((byte) 13);
        allocate.put((byte) 10);
        return allocate.array();
    }

    private Socket a(String str, int i3) throws IOException {
        com.tencent.beacon.base.util.c.a("SocketAdapter", "create socket domain: %s, port: %d", str, Integer.valueOf(i3));
        Socket socket = new Socket(InetAddress.getByName(str).getHostAddress(), i3);
        socket.setSoTimeout(30000);
        return socket;
    }
}
