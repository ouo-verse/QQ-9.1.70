package com.tencent.biz.viewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class ViewPluginLoader$5 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ JSONObject f97251d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f97252e;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        String optString = this.f97251d.optString("url");
        if (TextUtils.isEmpty(this.f97252e)) {
            QLog.e("ViewPluginLoader", 1, "fTargetFile = " + this.f97252e);
            return;
        }
        File file = new File(this.f97252e);
        new Bundle();
        new g(optString, file).f313008f = 3;
        throw null;
    }
}
