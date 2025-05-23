package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.SyncLoadTask;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes11.dex */
public class g extends SyncLoadTask {

    /* renamed from: a, reason: collision with root package name */
    PromotionConfigInfo f196952a;

    /* renamed from: b, reason: collision with root package name */
    final String f196953b;

    /* renamed from: c, reason: collision with root package name */
    WeakReference<AppInterface> f196954c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(String str, String str2, AppInterface appInterface) {
        super(str);
        this.f196953b = str2;
        this.f196954c = new WeakReference<>(appInterface);
    }

    @Override // com.tencent.mobileqq.utils.SyncLoadTask
    public void innerClean() {
        this.f196952a = null;
    }

    @Override // com.tencent.mobileqq.utils.SyncLoadTask
    public boolean runOnSubThread(Resources resources) {
        this.f196952a = ty2.a.a(this.f196953b, null);
        QLog.w(this.mTAG, 1, "ReadConfigTask,ConfigInfo[" + this.f196952a + "]");
        c.c();
        QQAudioHelper.n(this.f196954c.get());
        return true;
    }
}
