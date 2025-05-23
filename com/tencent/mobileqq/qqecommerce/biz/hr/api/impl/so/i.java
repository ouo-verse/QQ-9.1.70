package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so;

import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\u0016\u0010\n\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/i;", "", "", IProfileCardConst.KEY_FROM_TYPE, "", "b", "code", "a", "", "Ljava/lang/String;", "from", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/h;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/h;", "callback", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/h;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String from;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.qqecommerce.biz.hr.api.h callback;

    public i(String str, com.tencent.mobileqq.qqecommerce.biz.hr.api.h hVar) {
        this.from = str;
        this.callback = hVar;
    }

    public final void a(int code) {
        QLog.e("ViolaSoLoaderV2", 1, "[loadSoRequest]: load v8 error. from: " + this.from + ", code: " + code);
        com.tencent.mobileqq.qqecommerce.biz.hr.api.h hVar = this.callback;
        if (hVar != null) {
            hVar.onError(code);
        }
    }

    public final void b(int fromType) {
        com.tencent.mobileqq.qqecommerce.biz.hr.api.h hVar = this.callback;
        if (hVar != null) {
            hVar.b(fromType);
        }
        QLog.w("ViolaSoLoaderV2", 1, "[loadSoRequest]: load success. from: " + this.from + ", loaderType: " + fromType);
    }
}
