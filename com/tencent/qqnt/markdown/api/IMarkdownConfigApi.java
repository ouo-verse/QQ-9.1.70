package com.tencent.qqnt.markdown.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H&\u00a2\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/markdown/api/IMarkdownConfigApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getWhitelistedSchemeClickListener", "T", "wrappedListener", "(Ljava/lang/Object;)Ljava/lang/Object;", "isWhiteListScheme", "", "url", "", "enableBypassWhenNotHit", "rich_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IMarkdownConfigApi extends QRouteApi {
    <T> T getWhitelistedSchemeClickListener(T wrappedListener);

    boolean isWhiteListScheme(@Nullable String url, boolean enableBypassWhenNotHit);
}
