package com.tencent.mobileqq.icgame.api.halfweb.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.icgame.api.halfweb.IQQLiveHalfWebHelperApi;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import q22.a;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/halfweb/impl/QQLiveHalfWebHelperApiImpl;", "Lcom/tencent/mobileqq/icgame/api/halfweb/IQQLiveHalfWebHelperApi;", "()V", "start", "", "context", "Landroid/content/Context;", "url", "", "bundle", "Landroid/os/Bundle;", "preloadWebView", "Lcom/tencent/biz/ui/TouchWebView;", "backgroundDrawable", "Landroid/graphics/drawable/Drawable;", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class QQLiveHalfWebHelperApiImpl implements IQQLiveHalfWebHelperApi {
    @Override // com.tencent.mobileqq.icgame.api.halfweb.IQQLiveHalfWebHelperApi
    public void start(@Nullable Context context, @Nullable String url, @Nullable Bundle bundle, @Nullable TouchWebView preloadWebView, @Nullable Drawable backgroundDrawable) {
        a.e(context, url, bundle, preloadWebView, backgroundDrawable);
    }
}
