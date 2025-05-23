package com.tencent.mobileqq.qwallet.web.api.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.gson.Gson;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.base.c;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.mobileqq.qwallet.web.DoubleWebContainerFragment;
import com.tencent.mobileqq.qwallet.web.api.IDoubleWebApi;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl2.WebPageList;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/web/api/impl/DoubleWebApiImpl;", "Lcom/tencent/mobileqq/qwallet/web/api/IDoubleWebApi;", "Landroid/content/Context;", "context", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "", "start", "<init>", "()V", "Companion", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class DoubleWebApiImpl implements IDoubleWebApi {

    @NotNull
    private static final String TAG = "DoubleWebApi";

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041 A[Catch: Exception -> 0x0092, TryCatch #0 {Exception -> 0x0092, blocks: (B:3:0x000b, B:5:0x0014, B:12:0x0023, B:14:0x0041, B:17:0x0048, B:19:0x0052, B:21:0x0071, B:23:0x008b), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[Catch: Exception -> 0x0092, TryCatch #0 {Exception -> 0x0092, blocks: (B:3:0x000b, B:5:0x0014, B:12:0x0023, B:14:0x0041, B:17:0x0048, B:19:0x0052, B:21:0x0071, B:23:0x008b), top: B:2:0x000b }] */
    @Override // com.tencent.mobileqq.qwallet.web.api.IDoubleWebApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean start(@Nullable Context context, @NotNull Uri uri) {
        boolean z16;
        WebPageList webPageList;
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            String queryParameter = uri.getQueryParameter(QFSEdgeItem.KEY_EXTEND);
            if (queryParameter != null && queryParameter.length() != 0) {
                z16 = false;
                if (!z16 && context != null) {
                    webPageList = (WebPageList) new Gson().fromJson(URLDecoder.decode(queryParameter, "UTF-8"), WebPageList.class);
                    if (!webPageList.a().isEmpty()) {
                        QLog.e(TAG, 1, "webList isEmpty");
                        return false;
                    }
                    if (webPageList.a().size() == 1) {
                        k.c(context, webPageList.a().get(0).getUrl(), false, false, null, 28, null);
                        QLog.e(TAG, 1, "webList size is 1");
                        return true;
                    }
                    Intent intent = new Intent();
                    intent.putParcelableArrayListExtra("web_list", webPageList.a());
                    c.f(context, intent, DoubleWebContainerFragment.class, false, 8, null);
                    return true;
                }
                QLog.e(TAG, 1, "extend isEmpty or context is null");
                return false;
            }
            z16 = true;
            if (!z16) {
                webPageList = (WebPageList) new Gson().fromJson(URLDecoder.decode(queryParameter, "UTF-8"), WebPageList.class);
                if (!webPageList.a().isEmpty()) {
                }
            }
            QLog.e(TAG, 1, "extend isEmpty or context is null");
            return false;
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return false;
        }
    }
}
