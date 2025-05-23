package com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter;

import android.content.Context;
import com.tencent.ark.ark;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyLottieView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/adapter/e;", "Ld01/j;", "Landroid/content/Context;", "context", "", ark.ARKMETADATA_JSON, "Ld01/q;", "b", "filePath", "a", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e implements d01.j {
    @Override // d01.j
    public d01.q a(Context context, String filePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return new QQKuiklyLottieView(context, 1, filePath);
    }

    @Override // d01.j
    public d01.q b(Context context, String json) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(json, "json");
        return new QQKuiklyLottieView(context, 2, json);
    }
}
