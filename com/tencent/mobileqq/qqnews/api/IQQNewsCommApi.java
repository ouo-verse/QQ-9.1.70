package com.tencent.mobileqq.qqnews.api;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqnews/api/IQQNewsCommApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isQQNewsPa", "", "uin", "", "startHippy", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Ljava/util/HashMap;", "startQQNewsPA", "startQQNewsPAIfMatched", "qqnews-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQNewsCommApi extends QRouteApi {
    boolean isQQNewsPa(@NotNull String uin);

    boolean startHippy(@NotNull Context context, @NotNull HashMap<String, String> attrs);

    boolean startQQNewsPA(@NotNull Context context);

    boolean startQQNewsPAIfMatched(@NotNull Context context, @NotNull String uin);
}
