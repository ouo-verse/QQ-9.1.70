package com.tencent.mobileqq.qqecommerce.base.searchbar;

import android.content.Context;
import com.tencent.ecommerce.base.searchbar.IECSearchBarCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/searchbar/a;", "Lcom/tencent/ecommerce/base/searchbar/IECSearchBarCreator;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqecommerce/base/searchbar/ECSearchBar;", "a", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a implements IECSearchBarCreator {
    @Override // com.tencent.ecommerce.base.searchbar.IECSearchBarCreator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ECSearchBar create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ECSearchBar(context);
    }
}
