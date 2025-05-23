package com.tencent.qqnt.aio.adapter.api.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.qqnt.aio.adapter.api.IOidbApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J:\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/OidbApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IOidbApi;", "Lmqq/app/AppRuntime;", "app", "", "data", "", "cmd", "", "ssoCommand", "serviceType", "Lcom/tencent/qqnt/aio/adapter/api/IOidbApi$a;", "observer", "", "sendOIDBRequest", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class OidbApiImpl implements IOidbApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/OidbApiImpl$a", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IOidbApi.a f348576d;

        a(IOidbApi.a aVar) {
            this.f348576d = aVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, byte[] data, Bundle bundle) {
            IOidbApi.a aVar = this.f348576d;
            if (aVar != null) {
                aVar.a(errorCode, data, bundle);
            }
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IOidbApi
    public void sendOIDBRequest(AppRuntime app, byte[] data, String cmd, int ssoCommand, int serviceType, IOidbApi.a observer) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        ProtoUtils.c(app, new a(observer), data, cmd, ssoCommand, serviceType, new Bundle(), 5000L);
    }
}
