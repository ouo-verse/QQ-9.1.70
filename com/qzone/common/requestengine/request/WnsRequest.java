package com.qzone.common.requestengine.request;

import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.requestengine.callbacks.ITransFinished;
import com.qzone.common.requestengine.callbacks.QZoneServiceCallback;
import e6.a;
import e6.b;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WnsRequest extends Request {
    private String cmd;
    private long mPkgId;
    private long mRequestUin;

    protected WnsRequest() {
        this("");
    }

    private String getSubRequestCmd() {
        if (!TextUtils.isEmpty(this.cmd)) {
            String str = this.cmd;
            return str.substring(str.lastIndexOf(46) + 1);
        }
        return this.cmd;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public void addParameter(Object obj, Object obj2) {
        this.extraData.put(obj, obj2);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public Object getParameter(Object obj) {
        return this.extraData.get(obj);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return this.cmd;
    }

    public QZoneTask getTask() {
        return getResponse().g();
    }

    @Override // com.qzone.common.requestengine.request.Request
    public String requestTrait() {
        return " WNS Request: PkgId:" + this.mPkgId;
    }

    public void response() {
        ITransFinished iTransFinished = this.mTransFinishListener;
        if (iTransFinished != null) {
            iTransFinished.transFinished(this);
        }
    }

    public void setTask(QZoneTask qZoneTask) {
        getResponse().h(qZoneTask);
    }

    public void setTransFinishListener(ITransFinished iTransFinished) {
        this.mTransFinishListener = iTransFinished;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return getSubRequestCmd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WnsRequest(String str) {
        this(str, null, 0, null, null);
    }

    @Override // com.qzone.common.requestengine.request.Request
    public b getResponse() {
        a response = super.getResponse();
        if (response != null && (response instanceof b)) {
            return (b) response;
        }
        b bVar = new b();
        bVar.f(getWhat());
        bVar.e(getResponseFinishedListener());
        setResponse(bVar);
        return bVar;
    }

    public WnsRequest(String str, JceStruct jceStruct) {
        this(str, jceStruct, 0, null, null);
    }

    public WnsRequest(String str, JceStruct jceStruct, int i3, ITransFinished iTransFinished) {
        this(str, jceStruct, i3, iTransFinished, null);
    }

    public WnsRequest(String str, JceStruct jceStruct, int i3, ITransFinished iTransFinished, QZoneServiceCallback qZoneServiceCallback) {
        super(str);
        this.cmd = str;
        this.req = jceStruct;
        this.mPkgId = System.currentTimeMillis();
        this.mRequestUin = LoginData.getInstance().getUin();
        this.mWhat = i3;
        this.mTransFinishListener = iTransFinished;
        this.mResponseMainThread = new WeakReference<>(qZoneServiceCallback);
    }
}
