package com.tencent.mobileqq.kandian.base.utils.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountHttpDownloaderImpl;
import com.tencent.mobileqq.kandian.base.utils.api.IImageUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import java.net.URL;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/ImageUtilImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IImageUtil;", "()V", "getDefaultFaceDrawable140_140", "Landroid/graphics/drawable/Drawable;", "getDrawableUrl", "Ljava/net/URL;", "path", "", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ImageUtilImpl implements IImageUtil {
    @Override // com.tencent.mobileqq.kandian.base.utils.api.IImageUtil
    public Drawable getDefaultFaceDrawable140_140() {
        return BaseImageUtil.getDefaultFaceDrawable140_140();
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IImageUtil
    public URL getDrawableUrl(String path) {
        return new PublicAccountHttpDownloaderImpl().makeURL(path, 3);
    }
}
