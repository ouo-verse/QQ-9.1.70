package com.tencent.mobileqq.vas.pay.page;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J:\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/ao;", "", "Lmqq/app/AppRuntime;", "app", "", "aid", "", "", "businessType", "policyId", "Lh23/d;", "Ldu4/i;", "callback", "", "c", "<init>", "()V", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ao {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final h23.d callback, int i3, final boolean z16, final Object obj) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.page.an
            @Override // java.lang.Runnable
            public final void run() {
                ao.e(z16, obj, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(boolean z16, Object obj, h23.d callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (z16 && (obj instanceof byte[])) {
            try {
                du4.i result = du4.i.c((byte[]) obj);
                Intrinsics.checkNotNullExpressionValue(result, "result");
                callback.success(result, obj);
                return;
            } catch (InvalidProtocolBufferNanoException e16) {
                QLog.i("VipRenewalModel", 1, "\u6570\u636e\u89e3\u6790\u5f02\u5e38:" + e16.getMessage());
                callback.a(-100, "exception_happened");
                return;
            }
        }
        callback.a(-101, "");
    }

    public final void c(@NotNull AppRuntime app, @NotNull String aid, @NotNull List<Integer> businessType, @NotNull String policyId, @NotNull final h23.d<du4.i> callback) {
        int[] intArray;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        Intrinsics.checkNotNullParameter(policyId, "policyId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        du4.h hVar = new du4.h();
        hVar.f394986a = aid;
        intArray = CollectionsKt___CollectionsKt.toIntArray(businessType);
        hVar.f394987b = intArray;
        hVar.f394988c = policyId;
        VasUtil.getService(app).getPbRequest().request("trpc.qqclub.user_profile_server.SsoPayInfo.SsoGetPayInfo", MessageNano.toByteArray(hVar), new BusinessObserver() { // from class: com.tencent.mobileqq.vas.pay.page.am
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                ao.d(h23.d.this, i3, z16, obj);
            }
        });
    }
}
