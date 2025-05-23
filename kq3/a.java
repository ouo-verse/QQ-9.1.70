package kq3;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MSFServlet;
import mqq.app.MainService;
import mqq.app.Packet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a8\u0006\u0016"}, d2 = {"Lkq3/a;", "Lmqq/app/MSFServlet;", "", "c", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lmqq/app/Packet;", "packet", "", "onSend", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "onReceive", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "msg", "sendToMSF", "", "extra", "a", "<init>", "()V", "d", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a extends MSFServlet {
    public static /* synthetic */ byte[] b(a aVar, byte[] bArr, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        return aVar.a(bArr, str);
    }

    private final byte[] c(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length + 4);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            try {
                dataOutputStream.writeInt(bArr.length + 4);
                dataOutputStream.write(bArr);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                    QLog.e("OpenSDKOIDBServlet-MSF", 1, "io failed");
                }
                try {
                    dataOutputStream.close();
                } catch (IOException unused2) {
                    QLog.e("OpenSDKOIDBServlet-MSF", 1, "io failed");
                }
                return byteArray;
            } catch (IOException e16) {
                e16.printStackTrace();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused3) {
                    QLog.e("OpenSDKOIDBServlet-MSF", 1, "io failed");
                }
                try {
                    dataOutputStream.close();
                    return null;
                } catch (IOException unused4) {
                    QLog.e("OpenSDKOIDBServlet-MSF", 1, "io failed");
                    return null;
                }
            }
        } catch (Throwable th5) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused5) {
                QLog.e("OpenSDKOIDBServlet-MSF", 1, "io failed");
            }
            try {
                dataOutputStream.close();
                throw th5;
            } catch (IOException unused6) {
                QLog.e("OpenSDKOIDBServlet-MSF", 1, "io failed");
                throw th5;
            }
        }
    }

    @Nullable
    public final byte[] a(@NotNull byte[] bArr, @NotNull String extra) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(extra, "extra");
        byte[] bArr2 = new byte[0];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        try {
            try {
                int readInt = dataInputStream.readInt() - 4;
                if (readInt > 52428800) {
                    QLog.d("OpenSDKOIDBServlet-MSF", 1, "pb size over size: " + readInt + ", extra: " + extra);
                }
                bArr2 = new byte[readInt];
                dataInputStream.read(bArr2);
                try {
                    byteArrayInputStream.close();
                    dataInputStream.close();
                } catch (IOException unused) {
                }
                return bArr2;
            } catch (IOException e16) {
                e16.printStackTrace();
                try {
                    byteArrayInputStream.close();
                    dataInputStream.close();
                } catch (IOException unused2) {
                }
                return bArr2;
            }
        } catch (Throwable th5) {
            try {
                byteArrayInputStream.close();
                dataInputStream.close();
            } catch (IOException unused3) {
            }
            throw th5;
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(@Nullable Intent request, @NotNull FromServiceMsg response) {
        Intrinsics.checkNotNullParameter(response, "response");
        QLog.d("OpenSDKOIDBServlet-MSF", 2, "onReceive result " + response.isSuccess() + " uinType: " + response.getUinType());
        if (!response.isSuccess()) {
            boolean isSuccess = response.isSuccess();
            byte[] wupBuffer = response.getWupBuffer();
            Intrinsics.checkNotNullExpressionValue(wupBuffer, "response.wupBuffer");
            QLog.e("OpenSDKOIDBServlet-MSF", 1, "res.isSuccess() = " + isSuccess + ", data = " + b(this, wupBuffer, null, 1, null));
            notifyObserver(request, 0, false, null, null);
            return;
        }
        byte[] wupBuffer2 = response.getWupBuffer();
        Intrinsics.checkNotNullExpressionValue(wupBuffer2, "response.wupBuffer");
        try {
            oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(b(this, wupBuffer2, null, 1, null));
            Intrinsics.checkNotNullExpressionValue(mergeFrom, "{\n            pkg.mergeFrom(bytes)\n        }");
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = mergeFrom;
            if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                if (oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("data", oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    notifyObserver(request, 0, response.isSuccess(), bundle, null);
                    return;
                }
                QLog.e("OpenSDKOIDBServlet-MSF", 1, "pkg.bytes_bodybuffer.has() = " + oidb_sso_oidbssopkg.bytes_bodybuffer.has() + " pkg.bytes_bodybuffer.get() = " + oidb_sso_oidbssopkg.bytes_bodybuffer.get());
                notifyObserver(request, 0, false, null, null);
                return;
            }
            QLog.e("OpenSDKOIDBServlet-MSF", 1, "pkg.uint32_result.has() = " + oidb_sso_oidbssopkg.uint32_result.has() + " pkg.uint32_result.get() = " + oidb_sso_oidbssopkg.uint32_result.get());
            notifyObserver(request, 0, false, null, null);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("OpenSDKOIDBServlet-MSF", 1, e16, new Object[0]);
            notifyObserver(request, 0, false, null, null);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(@Nullable Intent request, @Nullable Packet packet) {
        String stringExtra;
        Object obj;
        if (request != null && (stringExtra = request.getStringExtra("cmd")) != null) {
            QLog.d("OpenSDKOIDBServlet-MSF", 1, "onSend cmd=" + stringExtra);
            Intrinsics.checkNotNullExpressionValue(stringExtra, "req.getStringExtra(EXTRA\u2026)\n            } ?: return");
            long longExtra = request.getLongExtra("timeout", 30000L);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(4138);
            oidb_sso_oidbssopkg.uint32_service_type.set(0);
            oidb_sso_oidbssopkg.uint32_result.set(0);
            PBBytesField pBBytesField = oidb_sso_oidbssopkg.bytes_bodybuffer;
            Bundle extras = request.getExtras();
            if (extras != null) {
                obj = extras.get("data");
            } else {
                obj = null;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
            pBBytesField.set(ByteStringMicro.copyFrom((byte[]) obj));
            if (packet != null) {
                packet.setSSOCommand(stringExtra);
                byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
                if (byteArray != null) {
                    Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray()");
                    byte[] c16 = c(byteArray);
                    if (c16 != null) {
                        packet.putSendData(c16);
                    }
                }
                packet.setTimeout(longExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet
    public void sendToMSF(@Nullable Intent request, @Nullable ToServiceMsg msg2) {
        String str;
        Bundle extras;
        QLog.d("OpenSDKOIDBServlet-MSF", 1, "sendToMSF ");
        boolean z16 = false;
        if (request != null && request.getBooleanExtra("use_open_sdk_ticket", false)) {
            z16 = true;
        }
        if (z16) {
            QLog.d("OpensdkServlet", 1, "service use sso for open sdk");
            if (msg2 != null) {
                msg2.setUinType((byte) 6);
            }
        }
        if (msg2 != null) {
            if (request != null && (extras = request.getExtras()) != null) {
                str = extras.getString("uin");
            } else {
                str = null;
            }
            msg2.setUin(str);
        }
        if (msg2 != null) {
            msg2.addAttribute(MainService.UIN_NOT_MATCH_TAG, "1");
        }
        super.sendToMSF(request, msg2);
    }
}
