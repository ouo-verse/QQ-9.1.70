package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so;

import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/d;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/h;", "", "from", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/h;", "callback", "", "loadLibrary", "", "a", "[Ljava/lang/String;", "violaSoNames", "", "b", "Z", "enablePreloadViolaEngine", "", "c", "I", "retryCount", "d", "loadSuccess", "<init>", "([Ljava/lang/String;)V", "e", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String[] violaSoNames;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile boolean enablePreloadViolaEngine;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile int retryCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile boolean loadSuccess;

    public d(String[] violaSoNames) {
        Intrinsics.checkNotNullParameter(violaSoNames, "violaSoNames");
        this.violaSoNames = violaSoNames;
        this.enablePreloadViolaEngine = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(d this$0, com.tencent.mobileqq.qqecommerce.biz.hr.api.h hVar, String str, int i3, LoadExtResult loadExtResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            this$0.loadSuccess = true;
            if (hVar != null) {
                hVar.b(4);
            }
            this$0.retryCount = 0;
            QLog.d("ViolaSoLoader", 1, "load viola so success, from: " + str);
            return;
        }
        this$0.loadSuccess = false;
        if (this$0.retryCount < 3) {
            this$0.loadLibrary(str, hVar);
            this$0.retryCount++;
            QLog.e("ViolaSoLoader", 1, "load viola so error, from: " + str + ", retryCount: " + this$0.retryCount + ", errorCode: " + i3);
            return;
        }
        this$0.retryCount = 0;
        if (hVar != null) {
            hVar.onError(i3);
        }
        QLog.d("ViolaSoLoader", 1, "load viola so error, from: " + str + ", errorCode: " + i3);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so.h
    public void loadLibrary(final String from, final com.tencent.mobileqq.qqecommerce.biz.hr.api.h callback) {
        if (this.loadSuccess) {
            if (callback != null) {
                callback.b(5);
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("ViolaSoLoader", 2, "viola loadLibrary from: " + from);
            }
            SoLoadManager.getInstance().loadSequentially(this.violaSoNames, new OnLoadListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so.c
                @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
                public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                    d.b(d.this, callback, from, i3, loadExtResult);
                }
            });
        }
    }
}
