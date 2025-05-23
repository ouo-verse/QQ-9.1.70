package com.tencent.mobileqq.qqecommerce.base.image;

import android.graphics.drawable.Drawable;
import com.tencent.ecommerce.base.imageloader.api.IECApngLoader;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/image/a;", "Lcom/tencent/ecommerce/base/imageloader/api/IECApngLoader;", "", "url", "Lcom/tencent/image/URLDrawable;", "a", "src", "Lcom/tencent/ecommerce/base/imageloader/api/IECApngLoader$a;", "option", "filePath", "Landroid/graphics/drawable/Drawable;", "getApngDrawable", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a implements IECApngLoader {
    @Override // com.tencent.ecommerce.base.imageloader.api.IECApngLoader
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public URLDrawable getAnimDrawable(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("ECApngLoader", url, new ApngOptions());
    }

    @Override // com.tencent.ecommerce.base.imageloader.api.IECApngLoader
    public Drawable getApngDrawable(String src, IECApngLoader.a option, String filePath) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        new ApngOptions();
        throw null;
    }
}
