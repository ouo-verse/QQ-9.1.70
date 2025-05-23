package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.request.BookShelfInsertRequest;
import com.tencent.qqmini.sdk.request.BookShelfQueryRequest;
import com.tencent.qqmini.sdk.request.BookShelfUpdateRequest;
import com.tencent.qqmini.sdk.request.DataReportRequest;
import com.tencent.qqmini.sdk.request.GetReactiveFriendListRequest;
import com.tencent.qqmini.sdk.request.ProtoBufRequest;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class RequestServer {
    public static final String KEY_ERRMSG = "errMsg";
    public static final String KEY_RETCODE = "retCode";
    public static final String TAG = "RequestServer";
    private static volatile RequestServer sInstance;
    private boolean useHttpDirectly;

    public RequestServer() {
        boolean z16;
        if (!QUAUtil.isAlienApp() && !QUAUtil.isDemoApp()) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.useHttpDirectly = z16;
    }

    private byte[] encodeRequest(ProtoBufRequest protoBufRequest) {
        try {
            return protoBufRequest.encode();
        } catch (Exception e16) {
            QMLog.e(TAG, "handleRequest Exception", e16);
            return null;
        }
    }

    public static RequestServer getInstance() {
        if (sInstance == null) {
            synchronized (RequestServer.class) {
                if (sInstance == null) {
                    sInstance = new RequestServer();
                }
            }
        }
        return sInstance;
    }

    private void handleRequest(ProtoBufRequest protoBufRequest, AsyncResult asyncResult) {
        try {
            byte[] encode = protoBufRequest.encode();
            QMLog.w(TAG, "sendData " + protoBufRequest);
            if (this.useHttpDirectly) {
                sendDataByHttpServer(protoBufRequest, asyncResult, encode);
            } else {
                sendRequestByMsf(protoBufRequest, asyncResult, encode);
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "handleRequest Exception", e16);
            if (asyncResult != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("retCode", -1);
                    jSONObject.put("errMsg", "\u6570\u636e\u7f16\u7801\u9519\u8bef");
                } catch (Throwable unused) {
                }
                asyncResult.onReceiveResult(false, jSONObject);
            }
        }
    }

    private void sendDataByHttpServer(final ProtoBufRequest protoBufRequest, final AsyncResult asyncResult, byte[] bArr) {
        HttpServer.sendData(bArr, new MiniAppProxy.SenderListener() { // from class: com.tencent.qqmini.sdk.core.manager.RequestServer.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.SenderListener
            public boolean onReply(int i3, byte[] bArr2, String str) {
                QMLog.w(RequestServer.TAG, "useHttpDirectly recvData " + protoBufRequest + ",retCode = " + i3);
                if (i3 == 0) {
                    if (asyncResult != null) {
                        JSONObject response = protoBufRequest.getResponse(bArr2);
                        if (response != null) {
                            if (response.optInt("retCode", 0) == 0) {
                                asyncResult.onReceiveResult(true, response);
                            } else {
                                asyncResult.onReceiveResult(false, response);
                            }
                        } else {
                            asyncResult.onReceiveResult(false, new JSONObject());
                        }
                    }
                } else {
                    AsyncResult asyncResult2 = asyncResult;
                    if (asyncResult2 != null) {
                        asyncResult2.onReceiveResult(false, new JSONObject());
                    }
                }
                return true;
            }
        });
    }

    private void sendRequestByMsf(final ProtoBufRequest protoBufRequest, final AsyncResult asyncResult, byte[] bArr) {
        ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).sendRequestByMsf(bArr, protoBufRequest.getCmdString(), new MiniAppProxy.SenderListener() { // from class: com.tencent.qqmini.sdk.core.manager.RequestServer.1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.SenderListener
            public boolean onReply(int i3, byte[] bArr2, String str) {
                if (QMLog.isColorLevel()) {
                    QMLog.w(RequestServer.TAG, "recvData " + protoBufRequest + ",retCode = " + i3);
                }
                if (i3 == 0) {
                    if (asyncResult != null) {
                        JSONObject response = protoBufRequest.getResponse(bArr2);
                        if (response != null) {
                            if (response.optInt("retCode", 0) == 0) {
                                asyncResult.onReceiveResult(true, response);
                            } else {
                                asyncResult.onReceiveResult(false, response);
                            }
                        } else {
                            asyncResult.onReceiveResult(false, new JSONObject());
                        }
                    }
                } else {
                    AsyncResult asyncResult2 = asyncResult;
                    if (asyncResult2 != null) {
                        asyncResult2.onReceiveResult(false, new JSONObject());
                    }
                }
                return true;
            }
        });
    }

    private void wrapResult(Boolean bool, int i3, String str, AsyncResult asyncResult) {
        if (asyncResult != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("retCode", i3);
                jSONObject.put("errMsg", str);
            } catch (Throwable unused) {
            }
            asyncResult.onReceiveResult(bool.booleanValue(), jSONObject);
        }
    }

    public void dataReport(byte[] bArr, AsyncResult asyncResult) {
        handleRequest(new DataReportRequest(bArr), asyncResult);
    }

    public void getReactiveFriendList(String str, AsyncResult asyncResult) {
        handleRequest(new GetReactiveFriendListRequest(str), asyncResult);
    }

    public void insertBookShelf(String str, String str2, ArrayList<String> arrayList, AsyncResult asyncResult) {
        handleRequest(new BookShelfInsertRequest(str, str2, arrayList), asyncResult);
    }

    public void queryBookShelf(String str, ArrayList<String> arrayList, AsyncResult asyncResult) {
        handleRequest(new BookShelfQueryRequest(str, arrayList), asyncResult);
    }

    public void updateBookshelfReadtime(String str, String str2, String str3, AsyncResult asyncResult) {
        handleRequest(new BookShelfUpdateRequest(str, str2, str3), asyncResult);
    }
}
