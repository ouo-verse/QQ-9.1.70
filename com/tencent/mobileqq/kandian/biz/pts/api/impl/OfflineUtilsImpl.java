package com.tencent.mobileqq.kandian.biz.pts.api.impl;

import com.tencent.mobileqq.kandian.biz.pts.api.IOfflineUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.b;
import java.io.InputStream;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/pts/api/impl/OfflineUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/pts/api/IOfflineUtils;", "()V", "init", "", "preCache", "isBackground", "", "readInputStreamAsString", "", "inputStream", "Ljava/io/InputStream;", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class OfflineUtilsImpl implements IOfflineUtils {
    @Override // com.tencent.mobileqq.kandian.biz.pts.api.IOfflineUtils
    public void init() {
        b.a();
    }

    @Override // com.tencent.mobileqq.kandian.biz.pts.api.IOfflineUtils
    public String readInputStreamAsString(InputStream inputStream) {
        return b.b(inputStream);
    }

    @Override // com.tencent.mobileqq.kandian.biz.pts.api.IOfflineUtils
    public void preCache(boolean isBackground) {
    }
}
