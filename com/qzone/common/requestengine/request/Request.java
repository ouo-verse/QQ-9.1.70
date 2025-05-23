package com.qzone.common.requestengine.request;

import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.common.requestengine.callbacks.ITransFinished;
import com.qzone.common.requestengine.callbacks.QZoneServiceCallback;
import e6.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class Request extends QZoneRequest {
    public HashMap<Object, Object> extraData;
    protected a mResponse;
    protected WeakReference<QZoneServiceCallback> mResponseMainThread;
    protected ITransFinished mTransFinishListener;
    public int mWhat;

    public Request(String str) {
        super(str);
        this.extraData = new HashMap<>();
    }

    public a getResponse() {
        return this.mResponse;
    }

    public QZoneServiceCallback getResponseFinishedListener() {
        WeakReference<QZoneServiceCallback> weakReference = this.mResponseMainThread;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getWhat() {
        return this.mWhat;
    }

    public String requestTrait() {
        return "Raw Request";
    }

    public void setOnResponseMainThread(QZoneServiceCallback qZoneServiceCallback) {
        this.mResponseMainThread = new WeakReference<>(qZoneServiceCallback);
    }

    public void setResponse(a aVar) {
        this.mResponse = aVar;
    }

    public void setWhat(int i3) {
        this.mWhat = i3;
    }
}
