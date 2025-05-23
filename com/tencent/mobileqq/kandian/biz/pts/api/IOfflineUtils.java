package com.tencent.mobileqq.kandian.biz.pts.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.InputStream;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/pts/api/IOfflineUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "init", "", "preCache", "isBackground", "", "readInputStreamAsString", "", "inputStream", "Ljava/io/InputStream;", "kandian-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IOfflineUtils extends QRouteApi {
    void init();

    void preCache(boolean isBackground);

    @Nullable
    String readInputStreamAsString(@Nullable InputStream inputStream);
}
