package com.tencent.biz.qqcircle.debug;

import androidx.annotation.Nullable;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {
    @Nullable
    private static byte[] a(BaseRequest baseRequest) {
        try {
            Method declaredMethod = BaseRequest.class.getDeclaredMethod("getRequestByteData", new Class[0]);
            declaredMethod.setAccessible(true);
            return (byte[]) declaredMethod.invoke(baseRequest, new Object[0]);
        } catch (Exception e16) {
            QLog.e("QCircleAIServerRequestHelper", 1, "\u53cd\u5c04\u8c03\u7528getRequestByteData\u5931\u8d25: " + e16.getMessage());
            return null;
        }
    }

    public static void b(BaseRequest baseRequest, VSDispatchObserver.OnVSRspCallBack onVSRspCallBack) {
        if (onVSRspCallBack == null) {
            QLog.e("QCircleAIServerRequestHelper", 1, "listener is null");
            return;
        }
        byte[] a16 = a(baseRequest);
        if (a16 == null) {
            QLog.e("QCircleAIServerRequestHelper", 1, "encodeBytes is null");
            onVSRspCallBack.onReceive(baseRequest, false, -1L, "encodeBytes is null", null);
            return;
        }
        try {
            QLog.i("QCircleAIServerRequestHelper", 1, "\u5f00\u59cb\u8bf7\u6c42AI\u670d\u52a1\u5668\uff0cURL: http://qvideoai.woa.com/client_svr/MultiInferText");
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://qvideoai.woa.com/client_svr/MultiInferText").openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-protobuf");
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(a16);
                outputStream.flush();
                QLog.i("QCircleAIServerRequestHelper", 1, "\u8bf7\u6c42\u6570\u636e\u53d1\u9001\u5b8c\u6210\uff0c\u5927\u5c0f: " + a16.length + " bytes");
                outputStream.close();
                int responseCode = httpURLConnection.getResponseCode();
                QLog.i("QCircleAIServerRequestHelper", 1, "\u6536\u5230\u670d\u52a1\u5668\u54cd\u5e94\uff0c\u72b6\u6001\u7801: " + responseCode);
                if (responseCode == 200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        QLog.i("QCircleAIServerRequestHelper", 1, "\u63a5\u6536\u5230\u54cd\u5e94\u6570\u636e\uff0c\u5927\u5c0f: " + byteArray.length + " bytes");
                        Object decode = baseRequest.decode(byteArray);
                        if (decode != null) {
                            QLog.i("QCircleAIServerRequestHelper", 1, "\u54cd\u5e94\u6570\u636e\u89e3\u7801\u6210\u529f");
                            onVSRspCallBack.onReceive(baseRequest, true, 0L, "\u8bf7\u6c42\u6210\u529f", decode);
                        } else {
                            QLog.e("QCircleAIServerRequestHelper", 1, "\u54cd\u5e94\u6570\u636e\u89e3\u7801\u5931\u8d25");
                            onVSRspCallBack.onReceive(baseRequest, false, -1L, "\u89e3\u7801\u54cd\u5e94\u6570\u636e\u5931\u8d25", null);
                        }
                        inputStream.close();
                        return;
                    } finally {
                    }
                }
                QLog.e("QCircleAIServerRequestHelper", 1, "\u8bf7\u6c42\u5931\u8d25\uff0c\u54cd\u5e94\u7801\uff1a" + responseCode);
                onVSRspCallBack.onReceive(baseRequest, false, responseCode, "\u8bf7\u6c42\u5931\u8d25\uff0c\u54cd\u5e94\u7801\uff1a" + responseCode, null);
            } finally {
            }
        } catch (Exception e16) {
            QLog.e("QCircleAIServerRequestHelper", 1, "\u8bf7\u6c42\u5f02\u5e38\uff1a" + e16.getMessage(), e16);
            onVSRspCallBack.onReceive(baseRequest, false, -1L, "\u8bf7\u6c42\u5f02\u5e38\uff1a" + e16.getMessage(), null);
        }
    }
}
