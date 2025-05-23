package com.tencent.tmassistant.common;

import android.os.Build;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.jce.JceCmd;
import com.tencent.tmassistant.common.jce.Net;
import com.tencent.tmassistant.common.jce.ReportLogRequest;
import com.tencent.tmassistant.common.jce.ReqHead;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistant.common.jce.RomInfo;
import com.tencent.tmassistant.common.jce.RspHead;
import com.tencent.tmassistant.common.jce.Terminal;
import com.tencent.tmassistantbase.common.a;
import com.tencent.tmassistantbase.common.b;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.c;
import com.tencent.tmassistantbase.util.d;
import com.tencent.tmassistantbase.util.h;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmassistantbase.util.s;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* loaded from: classes26.dex */
public class ProtocolPackage {
    public static final String CRYPT_KEY = "ji*9^&43U0X-~./(";
    public static final String ServerEncoding = "utf-8";
    protected static String TAG = "ProtocolPackage";

    public static byte[] buildPostData(Request request) {
        if (request == null) {
            return null;
        }
        request.head.encryptWithPack = (byte) 0;
        byte[] bArr = request.body;
        if (bArr.length > 256) {
            request.body = s.b(bArr);
            ReqHead reqHead = request.head;
            reqHead.encryptWithPack = (byte) (reqHead.encryptWithPack | 1);
        }
        request.body = encrypt(request.body, CRYPT_KEY.getBytes());
        ReqHead reqHead2 = request.head;
        reqHead2.encryptWithPack = (byte) (reqHead2.encryptWithPack | 2);
        return jceStructToUTF8Byte(request);
    }

    public static JceStruct buildReportRequest(byte b16, List<byte[]> list, String str, int i3, String str2) {
        ReportLogRequest reportLogRequest = new ReportLogRequest();
        reportLogRequest.logType = b16;
        reportLogRequest.logData = formatLogData(list);
        reportLogRequest.hostAppPackageName = str;
        reportLogRequest.hostAppVersion = i3;
        reportLogRequest.hostUserId = str2;
        return reportLogRequest;
    }

    public static Request buildRequest(JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        Request request = new Request();
        request.head = getReqHead(jceStruct);
        request.body = jceStructToUTF8Byte(jceStruct);
        return request;
    }

    public static JceStruct bytes2JceObj(byte[] bArr, Class<? extends JceStruct> cls) {
        if (bArr == null) {
            return null;
        }
        try {
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding("utf-8");
            JceStruct newInstance = cls.newInstance();
            newInstance.readFrom(jceInputStream);
            return newInstance;
        } catch (Exception e16) {
            r.c(TAG, "exception: ", e16);
            return null;
        }
    }

    private static JceStruct createFromRequest(JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        try {
            return (JceStruct) Class.forName(jceStruct.getClass().getName().substring(0, r5.length() - 7) + "Response").newInstance();
        } catch (ClassNotFoundException e16) {
            r.c(TAG, "exception: ", e16);
            e16.printStackTrace();
            return null;
        } catch (IllegalAccessException e17) {
            r.c(TAG, "exception: ", e17);
            e17.printStackTrace();
            return null;
        } catch (InstantiationException e18) {
            r.c(TAG, "exception: ", e18);
            e18.printStackTrace();
            return null;
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return new c().a(bArr, bArr2);
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        return new c().b(bArr, bArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] formatLogData(List<byte[]> list) {
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e16) {
                e = e16;
                byteArrayOutputStream = null;
                dataOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                outputStream = null;
                if (byteArrayOutputStream2 != null) {
                }
                if (outputStream == null) {
                }
            }
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            } catch (Exception e17) {
                e = e17;
                dataOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e18) {
                        r.c(TAG, "exception: ", e18);
                        e18.printStackTrace();
                    }
                }
                if (outputStream == null) {
                    try {
                        outputStream.close();
                        throw th;
                    } catch (IOException e19) {
                        r.c(TAG, "exception: ", e19);
                        e19.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
            try {
                for (byte[] bArr : list) {
                    dataOutputStream.writeInt(bArr.length);
                    dataOutputStream.write(bArr);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e26) {
                    r.c(TAG, "exception: ", e26);
                    e26.printStackTrace();
                }
                try {
                    dataOutputStream.close();
                } catch (IOException e27) {
                    r.c(TAG, "exception: ", e27);
                    e27.printStackTrace();
                }
                return byteArray;
            } catch (Exception e28) {
                e = e28;
                r.c(TAG, "exception: ", e);
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e29) {
                        r.c(TAG, "exception: ", e29);
                        e29.printStackTrace();
                    }
                }
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e36) {
                        r.c(TAG, "exception: ", e36);
                        e36.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static ReqHead getReqHead(JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        ReqHead reqHead = new ReqHead();
        reqHead.requestId = GlobalUtil.getMemUUID();
        String simpleName = jceStruct.getClass().getSimpleName();
        if (simpleName.endsWith("Request")) {
            simpleName = simpleName.substring(0, simpleName.length() - 7);
        } else if (simpleName.endsWith("Req")) {
            simpleName = simpleName.substring(0, simpleName.length() - 3);
        }
        reqHead.cmdId = JceCmd.convert(simpleName).value();
        reqHead.qua = GlobalUtil.getInstance().mQUA;
        reqHead.phoneGuid = GlobalUtil.getInstance().getPhoneGuid();
        Terminal terminal = new Terminal();
        terminal.androidId = GlobalUtil.getInstance().getAndroidIdInPhone();
        terminal.androidIdSdCard = "";
        terminal.imei = GlobalUtil.getInstance().getImei();
        terminal.imsi = GlobalUtil.getInstance().getImsi();
        terminal.macAdress = GlobalUtil.getInstance().getMacAddress();
        terminal.manufacture = GlobalUtil.getInstance().getManufacture();
        terminal.product = GlobalUtil.getInstance().getProduct();
        terminal.xResolution = GlobalUtil.getInstance().getScreenWidth();
        terminal.yResolution = GlobalUtil.getInstance().getScreenHeight();
        terminal.brand = GlobalUtil.getInstance().getBrand();
        terminal.mode = GlobalUtil.getInstance().getModel();
        reqHead.terminal = terminal;
        reqHead.terminalExtra = d.c().j();
        reqHead.assistantAPILevel = GlobalUtil.getInstance().getQQDownloaderAPILevel();
        reqHead.assistantVersionCode = 0;
        b a16 = h.a();
        Net net = new Net();
        if (a16 != null) {
            a aVar = a16.f380422a;
            if (aVar != null) {
                net.netType = (byte) GlobalUtil.getInt(Integer.valueOf(aVar.a()));
            }
            if (a16.f380425d) {
                net.isWap = (byte) 1;
            } else {
                net.isWap = (byte) 0;
            }
            net.extNetworkOperator = a16.f380423b;
            net.extNetworkType = a16.f380424c;
        }
        reqHead.net = net;
        reqHead.hostPackageName = GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext());
        reqHead.hostVersionCode = GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext());
        RomInfo romInfo = new RomInfo();
        romInfo.sysVersionCode = GlobalUtil.getString(String.valueOf(Build.VERSION.SDK_INT));
        romInfo.sysVersionName = GlobalUtil.getString(Build.VERSION.RELEASE);
        if (GlobalUtil.getInstance().getContext() != null) {
            romInfo.sysId = "";
        }
        reqHead.romInfo = romInfo;
        GlobalUtil.getInstance().getQimei();
        return reqHead;
    }

    public static byte[] jceStructToUTF8Byte(JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding("utf-8");
        jceStruct.writeTo(jceOutputStream);
        return jceOutputStream.toByteArray();
    }

    public static Response unpackPackage(byte[] bArr) {
        if (bArr != null && bArr.length >= 4) {
            Response response = new Response();
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr);
                jceInputStream.setServerEncoding("utf-8");
                response.readFrom(jceInputStream);
                RspHead rspHead = response.head;
                if (rspHead.ret == 0) {
                    if ((rspHead.encryptWithPack & 2) == 2) {
                        response.body = decrypt(response.body, CRYPT_KEY.getBytes());
                    }
                    if ((response.head.encryptWithPack & 1) == 1) {
                        response.body = s.a(response.body);
                    }
                    if (!TextUtils.isEmpty(response.head.phoneGuid)) {
                        GlobalUtil.getInstance().setPhoneGuid(response.head.phoneGuid);
                    }
                }
                return response;
            } catch (Exception e16) {
                e16.printStackTrace();
                r.c(TAG, "exception: ", e16);
            }
        }
        return null;
    }

    public static Request unpackRequestPackage(byte[] bArr) {
        if (bArr != null && bArr.length >= 4) {
            Request request = new Request();
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr);
                jceInputStream.setServerEncoding("utf-8");
                request.readFrom(jceInputStream);
                if ((request.head.encryptWithPack & 2) == 2) {
                    request.body = decrypt(request.body, CRYPT_KEY.getBytes());
                }
                if ((request.head.encryptWithPack & 1) == 1) {
                    request.body = s.a(request.body);
                }
                return request;
            } catch (Exception e16) {
                e16.printStackTrace();
                r.c(TAG, "exception: ", e16);
            }
        }
        return null;
    }

    public static JceStruct unpageageJceResponse(JceStruct jceStruct, byte[] bArr) {
        JceStruct createFromRequest;
        if (jceStruct != null && bArr != null && (createFromRequest = createFromRequest(jceStruct)) != null) {
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr);
                jceInputStream.setServerEncoding("utf-8");
                createFromRequest.readFrom(jceInputStream);
                return createFromRequest;
            } catch (Exception e16) {
                e16.printStackTrace();
                r.c(TAG, "exception: ", e16);
            }
        }
        return null;
    }

    public static JceStruct unpageageJceResponse(byte[] bArr, Class<? extends JceStruct> cls) {
        if (bArr != null) {
            try {
                JceStruct newInstance = cls.newInstance();
                JceInputStream jceInputStream = new JceInputStream(bArr);
                jceInputStream.setServerEncoding("utf-8");
                newInstance.readFrom(jceInputStream);
                return newInstance;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }
}
