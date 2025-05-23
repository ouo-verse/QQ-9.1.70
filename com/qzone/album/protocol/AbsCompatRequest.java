package com.qzone.album.protocol;

import com.qq.taf.jce.JceStruct;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class AbsCompatRequest<T> extends QZoneRequest {
    private boolean bCancel;
    private boolean bIsGetMore;
    private a mCallback;
    private boolean mComplete;
    private HashMap<Object, Object> mExtParams;
    private b mRespListener;
    private int mTimeout;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        boolean a(AbsCompatRequest absCompatRequest, s sVar);
    }

    public AbsCompatRequest(String str) {
        super(str);
        this.mExtParams = new HashMap<>();
        this.mComplete = false;
        this.mTimeout = -1;
    }

    public AbsCompatRequest addParam(Object obj, Object obj2) {
        this.mExtParams.put(obj, obj2);
        return this;
    }

    public void cancel(boolean z16) {
        this.bCancel = z16;
    }

    public a getCallback() {
        return this.mCallback;
    }

    public b getOnJceParseListener() {
        return this.mRespListener;
    }

    public Object getParam(Object obj) {
        return this.mExtParams.get(obj);
    }

    public JceStruct getReqJce() {
        return this.req;
    }

    public int getTimeout() {
        return this.mTimeout;
    }

    public boolean isCancel() {
        return this.bCancel;
    }

    public boolean isComplete() {
        return this.mComplete;
    }

    public boolean isGetMore() {
        return this.bIsGetMore;
    }

    public abstract T onJceRespParse(JceStruct jceStruct) throws Exception;

    public AbsCompatRequest setCallback(a aVar) {
        this.mCallback = aVar;
        return this;
    }

    public void setComplete(boolean z16) {
        this.mComplete = z16;
    }

    public AbsCompatRequest setGetMore(boolean z16) {
        this.bIsGetMore = z16;
        return this;
    }

    public AbsCompatRequest setOnJceParseListener(b bVar) {
        this.mRespListener = bVar;
        return this;
    }

    public void setReqJce(JceStruct jceStruct) {
        this.req = jceStruct;
    }

    public AbsCompatRequest setTimeout(int i3) {
        this.mTimeout = i3;
        return this;
    }

    public AbsCompatRequest(String str, boolean z16) {
        super(str, z16);
        this.mExtParams = new HashMap<>();
        this.mComplete = false;
        this.mTimeout = -1;
    }
}
