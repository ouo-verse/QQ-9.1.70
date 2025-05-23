package com.tencent.mobileqq.winkpublish.report;

import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/e;", "Lcom/tencent/mobileqq/winkpublish/report/WinkBaseErrorCode;", "", "getTag", "", "getErrorCodePrefix", "errorCode", "errorMsg", "<init>", "(JLjava/lang/String;)V", "d", "a", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e extends WinkBaseErrorCode {

    /* renamed from: e, reason: collision with root package name */
    @WinkErrorCode(msg = "can not find symbol")
    public static final long f327396e = Long.parseLong("-20000001");

    static {
        WinkBaseErrorCode.INSTANCE.loadPredefinedCode(Reflection.getOrCreateKotlinClass(e.class));
    }

    public e(long j3, String str) {
        super(j3, str);
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    public long getErrorCodePrefix() {
        return 20L;
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    public String getTag() {
        return "WinkHookTestErrorCode";
    }
}
