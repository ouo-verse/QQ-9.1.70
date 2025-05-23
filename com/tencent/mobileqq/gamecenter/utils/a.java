package com.tencent.mobileqq.gamecenter.utils;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.HTTP_METHOD;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/utils/a;", "", "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/utils/a$a;", "", "", "body", "Lcom/tencent/qqnt/http/api/l;", "callback", "", "a", "BUS_TAG", "Ljava/lang/String;", "HOST", "TAG", "<init>", "()V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.utils.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String body, @NotNull com.tencent.qqnt.http.api.l callback) {
            Intrinsics.checkNotNullParameter(body, "body");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (QLog.isDevelopLevel()) {
                QLog.d("AttaReportUtils", 1, "[doReport]");
            }
            b.a aVar = new b.a("h5_perfermance_atta_report", "https://h.trace.qq.com/kv");
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            com.tencent.qqnt.http.api.k kVar = new com.tencent.qqnt.http.api.k();
            byte[] bytes = body.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            kVar.c(bytes);
            aVar.a(hashMap);
            aVar.I(HTTP_METHOD.POST);
            aVar.M(kVar);
            aVar.T(callback);
            ((IHttpService) QRoute.api(IHttpService.class)).asyncExecute(aVar.c());
        }

        Companion() {
        }
    }
}
