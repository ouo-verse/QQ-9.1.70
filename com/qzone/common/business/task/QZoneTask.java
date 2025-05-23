package com.qzone.common.business.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.qzone.adapter.feedcomponent.IResult;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.a;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.protocol.IQZoneProtocolListener;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.publish.business.process.base.QZoneProcessType;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneTask implements IQZoneProtocolListener, SmartParcelable {
    static final String TAG = "com.qzone.common.business.task.QZoneTask";
    public static boolean needPrintRequest = false;

    @NeedParcel
    public String clientKey;
    private QZoneProcessType mBreakTaskProcessType;
    private WeakReference<a> mCallback;
    private WeakReference<Handler> mHandler;
    public transient IQZoneServiceListener mListener;

    @NeedParcel
    public QZoneRequest mRequest;

    @NeedParcel
    public int mResultCode;

    @NeedParcel
    public int mType;
    public transient UniAttribute mUniAttr;

    @NeedParcel
    public int taskRetryCount;

    @NeedParcel
    public String ugcKey;
    private static Handler mMainHandler = new Handler(Looper.getMainLooper());
    protected static final d6.a protocolHelper = d6.a.a();

    /* renamed from: msg, reason: collision with root package name */
    @NeedParcel
    public transient String f45835msg = "";

    @NeedParcel
    public HashMap<Object, Object> extraData = new HashMap<>();
    public long timestamp = System.currentTimeMillis();

    public QZoneTask() {
    }

    public void addParameter(Object obj, Object obj2) {
        this.extraData.put(obj, obj2);
    }

    public QZoneProcessType getBreakTaskProcessType() {
        return this.mBreakTaskProcessType;
    }

    public Handler getHandler() {
        WeakReference<Handler> weakReference = this.mHandler;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Object getParameter(Object obj) {
        return this.extraData.get(obj);
    }

    public QZoneResult getResult(int i3) {
        QZoneResult qZoneResult = new QZoneResult(i3);
        qZoneResult.setSucceed(succeeded());
        qZoneResult.setReturnCode(this.mResultCode);
        qZoneResult.setMessage(this.f45835msg);
        qZoneResult.setUgcKey(this.ugcKey);
        return qZoneResult;
    }

    @Override // com.qzone.common.protocol.IQZoneProtocolListener
    public void onProtocolResponse(UniAttribute uniAttribute, int i3, int i16, String str, boolean z16) {
        onProtocolResponse(QZoneProcessType.PROCESS_UNKNOW, uniAttribute, i3, i16, str, z16);
    }

    public void run() {
        QZoneRequest qZoneRequest = this.mRequest;
        if (qZoneRequest != null) {
            qZoneRequest.setRequestRetryCount(this.taskRetryCount);
            if (needPrintRequest) {
                StringBuilder sb5 = new StringBuilder();
                JceStruct jceStruct = this.mRequest.req;
                if (jceStruct != null) {
                    jceStruct.display(sb5, 0);
                }
            }
        }
        int b16 = protocolHelper.b(this.mRequest, this);
        if (b16 != 0) {
            onProtocolResponse(null, b16, b16, getErrString(b16), false);
        }
    }

    public void sendResultMsg(int i3, boolean z16, boolean z17, String str) {
        sendResultMsg(i3, z16, z17 ? 1 : 0, str);
    }

    public void setCallback(a aVar) {
        this.mCallback = new WeakReference<>(aVar);
    }

    public void setHandler(Handler handler) {
        this.mHandler = new WeakReference<>(handler);
    }

    public void setListener(IQZoneServiceListener iQZoneServiceListener) {
        this.mListener = iQZoneServiceListener;
    }

    public void setTaskRetryCount(int i3) {
        this.taskRetryCount = i3;
    }

    public boolean succeeded() {
        int i3 = this.mResultCode;
        return (i3 == 0 || (Math.abs(i3) <= 19999 && Math.abs(this.mResultCode) >= 19000)) && this.mUniAttr != null;
    }

    @Override // com.qzone.common.protocol.IQZoneProtocolListener
    public void onProtocolResponse(QZoneProcessType qZoneProcessType, UniAttribute uniAttribute, int i3, int i16, String str, boolean z16) {
        this.mBreakTaskProcessType = qZoneProcessType;
        this.mUniAttr = uniAttribute;
        this.mResultCode = i3;
        this.f45835msg = str;
        if (1000006 == i3) {
            this.f45835msg = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5");
        }
        if (z16) {
            run();
        } else {
            QZoneBusinessLooper.getInstance().comleteTask(this);
        }
    }

    public void sendResultMsg(int i3, boolean z16) {
        sendResultMsg(i3, z16, 0, (Object) null);
    }

    public void sendResultMsg(int i3, boolean z16, int i16) {
        sendResultMsg(i3, z16, i16, (Object) null);
    }

    public void sendResultMsg(int i3, boolean z16, Object obj) {
        sendResultMsg(i3, z16, 0, obj);
    }

    public QZoneTask(QZoneRequest qZoneRequest, Handler handler, IQZoneServiceListener iQZoneServiceListener, int i3) {
        this.mRequest = qZoneRequest;
        this.mType = i3;
        this.mListener = iQZoneServiceListener;
        if (handler != null) {
            this.mHandler = new WeakReference<>(handler);
        }
    }

    public void sendResultMsg(int i3, boolean z16, int i16, Object obj) {
        synchronized (this) {
            WeakReference<Handler> weakReference = this.mHandler;
            Handler handler = weakReference == null ? null : weakReference.get();
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage(i3);
                obtainMessage.arg1 = z16 ? 1 : 0;
                obtainMessage.arg2 = i16;
                obtainMessage.obj = obj;
                obtainMessage.sendToTarget();
            }
        }
    }

    public String getErrString(int i3) {
        if (i3 != 1000006) {
            return "";
        }
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, TAG + "\t \u7f51\u7edc\u65e0\u8fde\u63a5");
        return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5");
    }

    public void sendResultMsg(final IResult iResult) {
        WeakReference<Handler> weakReference = this.mHandler;
        Handler handler = weakReference == null ? null : weakReference.get();
        WeakReference<a> weakReference2 = this.mCallback;
        final a aVar = weakReference2 != null ? weakReference2.get() : null;
        if (handler != null && iResult != null) {
            iResult.sendToHandler(handler);
        }
        if (aVar == null || iResult == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aVar.onResult(iResult);
        } else {
            mMainHandler.post(new Runnable() { // from class: com.qzone.common.business.task.QZoneTask.1
                @Override // java.lang.Runnable
                public void run() {
                    aVar.onResult(iResult);
                }
            });
        }
    }
}
