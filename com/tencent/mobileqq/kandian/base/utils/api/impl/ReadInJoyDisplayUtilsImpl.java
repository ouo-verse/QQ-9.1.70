package com.tencent.mobileqq.kandian.base.utils.api.impl;

import android.content.Context;
import android.util.Pair;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.utils.f;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import java.net.URL;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0012H\u0016J\u001c\u0010\u0014\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/ReadInJoyDisplayUtilsImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyDisplayUtils;", "()V", "configImage", "", "imageView", "Lcom/tencent/mobileqq/kandian/base/view/widget/KandianUrlImageView;", "picUrl", "Ljava/net/URL;", "context", "Landroid/content/Context;", "blackPlaceHolder", "", "getDisplayDuration", "", "duration", "", "getReadinjoyFeedsBigPictureSize", "Landroid/util/Pair;", "getReadinjoyFeedsSmallPictureSize", "shouldShowPlaceHolder", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ReadInJoyDisplayUtilsImpl implements IReadInJoyDisplayUtils {
    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils
    public void configImage(KandianUrlImageView imageView, URL picUrl, Context context) {
        f.a(imageView, picUrl, context);
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils
    public String getDisplayDuration(int duration) {
        return f.e(duration);
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils
    public Pair<Integer, Integer> getReadinjoyFeedsBigPictureSize() {
        return f.f();
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils
    public Pair<Integer, Integer> getReadinjoyFeedsSmallPictureSize() {
        return f.g();
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils
    public boolean shouldShowPlaceHolder(Context context, URL picUrl) {
        return f.k(context, picUrl);
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils
    public void configImage(KandianUrlImageView imageView, URL picUrl, Context context, boolean blackPlaceHolder) {
        f.b(imageView, picUrl, context, blackPlaceHolder);
    }
}
