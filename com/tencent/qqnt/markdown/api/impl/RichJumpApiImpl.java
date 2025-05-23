package com.tencent.qqnt.markdown.api.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qqnt.markdown.api.IRichJumpApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/markdown/api/impl/RichJumpApiImpl;", "Lcom/tencent/qqnt/markdown/api/IRichJumpApi;", "()V", "doUrlAction", "", "context", "Landroid/content/Context;", "url", "", "openBrowser", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class RichJumpApiImpl implements IRichJumpApi {
    @Override // com.tencent.qqnt.markdown.api.IRichJumpApi
    public void doUrlAction(Context context, String url) {
        ax c16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        BaseQQAppInterface baseQQAppInterface = waitAppRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) waitAppRuntime : null;
        if ((url.length() == 0) || baseQQAppInterface == null || (c16 = bi.c(baseQQAppInterface, context, url)) == null) {
            return;
        }
        c16.b();
    }

    @Override // com.tencent.qqnt.markdown.api.IRichJumpApi
    public void openBrowser(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("url", url);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
    }
}
