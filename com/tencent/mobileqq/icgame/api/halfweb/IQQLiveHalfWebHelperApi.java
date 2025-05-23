package com.tencent.mobileqq.icgame.api.halfweb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/halfweb/IQQLiveHalfWebHelperApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "start", "", "context", "Landroid/content/Context;", "url", "", "bundle", "Landroid/os/Bundle;", "preloadWebView", "Lcom/tencent/biz/ui/TouchWebView;", "backgroundDrawable", "Landroid/graphics/drawable/Drawable;", "ic-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IQQLiveHalfWebHelperApi extends QRouteApi {
    void start(@Nullable Context context, @Nullable String url, @Nullable Bundle bundle, @Nullable TouchWebView preloadWebView, @Nullable Drawable backgroundDrawable);
}
