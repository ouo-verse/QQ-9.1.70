package com.qzone.adapter.feedcomponent;

import android.os.Bundle;
import android.os.Handler;

/* compiled from: P */
/* loaded from: classes39.dex */
public class s implements IResult {

    /* renamed from: d, reason: collision with root package name */
    IResult f41923d;

    s() {
    }

    public static s b(int i3) {
        s sVar = new s();
        sVar.f41923d = i.H().A1(i3);
        return sVar;
    }

    public static s c(IResult iResult) {
        s sVar = new s();
        sVar.f41923d = iResult;
        return sVar;
    }

    public IResult a() {
        return this.f41923d;
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public Bundle getBundle() {
        return this.f41923d.getBundle();
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public Object getData() {
        return this.f41923d.getData();
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public boolean getHasMore() {
        return this.f41923d.getHasMore();
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public String getMessage() {
        return this.f41923d.getMessage();
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public long getNewCnt() {
        return this.f41923d.getNewCnt();
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public Object getObjectData() {
        return this.f41923d.getObjectData();
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public int getReturnCode() {
        return this.f41923d.getReturnCode();
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public boolean getSucceed() {
        return this.f41923d.getSucceed();
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public int getWhat() {
        return this.f41923d.getWhat();
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void sendToHandler(Handler handler) {
        this.f41923d.sendToHandler(handler);
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void setData(Object obj) {
        this.f41923d.setData(obj);
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void setFailReason(String str) {
        this.f41923d.setFailReason(str);
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void setHasMore(boolean z16) {
        this.f41923d.setHasMore(z16);
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void setNewCnt(long j3) {
        this.f41923d.setNewCnt(j3);
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void setObjectData(Object obj) {
        this.f41923d.setObjectData(obj);
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void setReturnCode(int i3) {
        this.f41923d.setReturnCode(i3);
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void setSucceed(boolean z16) {
        this.f41923d.setSucceed(z16);
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void setWhat(int i3) {
        this.f41923d.setWhat(i3);
    }
}
