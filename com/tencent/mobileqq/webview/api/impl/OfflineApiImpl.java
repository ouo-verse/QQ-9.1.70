package com.tencent.mobileqq.webview.api.impl;

import com.tencent.mobileqq.webview.api.IOfflineApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import px.e;
import v43.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/webview/api/impl/OfflineApiImpl;", "Lcom/tencent/mobileqq/webview/api/IOfflineApi;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/service/profile/a;", "getCheckUpdateItemInterface", "Lpx/c;", "getOfflineDownloader", "", "release", "<init>", "()V", "Companion", "a", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class OfflineApiImpl implements IOfflineApi {
    public static final String TAG = "OfflineApiImpl";

    @Override // com.tencent.mobileqq.webview.api.IOfflineApi
    public com.tencent.mobileqq.service.profile.a getCheckUpdateItemInterface(AppRuntime app) {
        Intrinsics.checkNotNullParameter(app, "app");
        return new a.C11393a(app);
    }

    @Override // com.tencent.mobileqq.webview.api.IOfflineApi
    public px.c getOfflineDownloader() {
        return new e();
    }

    @Override // com.tencent.mobileqq.webview.api.IOfflineApi
    public void release() {
        a.C11393a.g();
    }
}
