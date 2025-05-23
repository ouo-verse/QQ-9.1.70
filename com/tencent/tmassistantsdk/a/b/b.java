package com.tencent.tmassistantsdk.a.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import com.tencent.assistant.sdk.remote.BaseService;
import com.tencent.assistant.sdk.remote.SDKActionCallback;
import com.tencent.tmassistantbase.util.c;
import com.tencent.tmdownloader.d;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends com.tencent.tmdownloader.a {

    /* renamed from: a, reason: collision with root package name */
    ArrayList<com.tencent.tmassistantsdk.a.b.a> f380548a;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a extends SDKActionCallback.Stub {
        a() {
        }

        @Override // com.tencent.assistant.sdk.remote.SDKActionCallback
        public void onActionResult(byte[] bArr) {
            d.a().a(bArr, b.this.f380548a);
        }
    }

    public b(Context context, String str, String str2) {
        super(context, str, str2);
        this.f380548a = new ArrayList<>();
        this.mServiceCallback = new a();
    }

    public void a(byte[] bArr) {
        if (TextUtils.isEmpty(this.mClientKey)) {
            return;
        }
        BaseService baseService = (BaseService) super.getServiceInterface();
        if (baseService != null) {
            baseService.sendAsyncData(this.mClientKey, bArr);
        } else {
            super.initTMAssistantDownloadSDK();
        }
    }

    public byte[] b(byte[] bArr) {
        if (!TextUtils.isEmpty(this.mClientKey)) {
            BaseService baseService = (BaseService) super.getServiceInterface();
            if (baseService != null) {
                return baseService.sendSyncData(this.mClientKey, bArr);
            }
            super.initTMAssistantDownloadSDK();
            return null;
        }
        return null;
    }

    @Override // com.tencent.tmdownloader.a
    protected Intent getBindServiceIntent() {
        return null;
    }

    @Override // com.tencent.tmdownloader.a
    public IInterface getServiceInterface() {
        return super.getServiceInterface();
    }

    @Override // com.tencent.tmdownloader.a
    protected void onDownloadSDKServiceInvalid() {
        ArrayList<com.tencent.tmassistantsdk.a.b.a> arrayList = this.f380548a;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<com.tencent.tmassistantsdk.a.b.a> it = this.f380548a.iterator();
            while (it.hasNext()) {
                com.tencent.tmassistantsdk.a.b.a next = it.next();
                if (next != null) {
                    next.a();
                }
            }
        }
    }

    @Override // com.tencent.tmdownloader.a
    protected void registerServiceCallback() {
        try {
            if (((BaseService) this.mServiceInterface).registerActionCallback(this.mClientKey, com.tencent.tmassistantbase.util.a.b(new c().b(String.valueOf(System.currentTimeMillis()).getBytes(), this.mClientKey.getBytes()), 0), (SDKActionCallback) this.mServiceCallback) == 2) {
                onDownloadSDKServiceInvalid();
            }
        } catch (IllegalArgumentException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.tmdownloader.a
    protected void stubAsInterface(IBinder iBinder) {
        this.mServiceInterface = BaseService.Stub.asInterface(iBinder);
    }

    @Override // com.tencent.tmdownloader.a
    protected void unRegisterServiceCallback() {
        if (((BaseService) this.mServiceInterface).unregisterActionCallback((SDKActionCallback) this.mServiceCallback) == 2) {
            onDownloadSDKServiceInvalid();
        }
    }

    public void a(com.tencent.tmassistantsdk.a.b.a aVar) {
        if (aVar == null || this.f380548a.contains(aVar)) {
            return;
        }
        this.f380548a.add(aVar);
    }
}
