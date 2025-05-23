package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/ZootopiaClearCookieManagerImpl;", "Lcom/tencent/mobileqq/zootopia/ipc/i;", "", "clearCookie", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaClearCookieManagerImpl implements i {
    public static final String TAG = "ZootopiaClearCookieManagerImpl";

    @Override // com.tencent.mobileqq.zootopia.ipc.i
    public void clearCookie() {
        QLog.i(TAG, 1, "clearCookie :: start");
        CookieManager.getInstance().removeAllCookies(null);
    }
}
