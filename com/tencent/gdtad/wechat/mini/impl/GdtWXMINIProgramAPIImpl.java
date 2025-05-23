package com.tencent.gdtad.wechat.mini.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.gdtad.wechat.mini.GdtWXMINIProgramUtil;
import com.tencent.gdtad.wechat.mini.IGdtWXMINIProgramAPI;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public final class GdtWXMINIProgramAPIImpl implements IGdtWXMINIProgramAPI {
    @Override // com.tencent.gdtad.wechat.mini.IGdtWXMINIProgramAPI
    public boolean handleOpenUrl(WeakReference<Activity> weakReference, Bundle bundle, String str) {
        return GdtWXMINIProgramUtil.b(weakReference, bundle, str);
    }

    @Override // com.tencent.gdtad.wechat.mini.IGdtWXMINIProgramAPI
    public void updateTuringAIDTicketAsync(WeakReference<Context> weakReference) {
        GdtWXMINIProgramUtil.e(weakReference);
    }
}
