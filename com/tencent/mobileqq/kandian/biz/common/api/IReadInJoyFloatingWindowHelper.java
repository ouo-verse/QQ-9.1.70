package com.tencent.mobileqq.kandian.biz.common.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H&J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\bH&J&\u0010\f\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoyFloatingWindowHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "jump2FloatingWindow", "", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Ljava/util/HashMap;", "", "openFloatLayer", "", "urlString", "openFloatLayerVideo", "rowKey", WadlProxyConsts.EXTRA_DATA, "Landroid/os/Bundle;", "kandian-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IReadInJoyFloatingWindowHelper extends QRouteApi {
    void jump2FloatingWindow(@Nullable Context context, @Nullable HashMap<String, String> attrs);

    boolean openFloatLayer(@Nullable Context context, @Nullable String urlString);

    boolean openFloatLayerVideo(@Nullable Context context, @Nullable String rowKey, @Nullable Bundle extraData);
}
