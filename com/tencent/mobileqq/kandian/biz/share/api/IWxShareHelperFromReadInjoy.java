package com.tencent.mobileqq.kandian.biz.share.api;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001 JD\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&JB\u0010\u000e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fH&J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&JD\u0010\u0014\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H&JB\u0010\u0015\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fH&J,\u0010\u001a\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H&J\u001c\u0010\u001f\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/share/api/IWxShareHelperFromReadInjoy;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "transaction", "title", "Landroid/graphics/Bitmap;", "icon", "description", "webPageUrl", "rowKey", "", "shareVideoMiniProgram", "", "scene", "shareVideo", "Lcom/tencent/mobileqq/kandian/biz/share/api/IWxShareHelperFromReadInjoy$a;", "observer", "removeObserver", "addObserver", "path", "shareToMiniProgramWithPath", "shareWebPage", "filePath", "bmp", "", "outSquare", "shareImageToWX", "Landroid/app/Activity;", "wxEntryActivity", "Landroid/content/Intent;", "intent", "handleWXEntryActivityIntent", "a", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IWxShareHelperFromReadInjoy extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/share/api/IWxShareHelperFromReadInjoy$a;", "", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "resp", "", "onWXShareResp", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface a {
        void onWXShareResp(@Nullable BaseResp resp);
    }

    void addObserver(@Nullable a observer);

    void handleWXEntryActivityIntent(@Nullable Activity wxEntryActivity, @Nullable Intent intent);

    void removeObserver(@Nullable a observer);

    void shareImageToWX(@Nullable String filePath, @Nullable Bitmap bmp, int scene, boolean outSquare);

    void shareToMiniProgramWithPath(@Nullable String transaction, @Nullable String title, @Nullable Bitmap icon, @Nullable String description, @Nullable String webPageUrl, @Nullable String path);

    void shareVideo(@Nullable String transaction, @Nullable String title, @Nullable Bitmap icon, @Nullable String description, @Nullable String webPageUrl, int scene);

    void shareVideoMiniProgram(@Nullable String transaction, @Nullable String title, @Nullable Bitmap icon, @Nullable String description, @Nullable String webPageUrl, @Nullable String rowKey);

    void shareWebPage(@Nullable String transaction, @Nullable String title, @Nullable Bitmap icon, @Nullable String description, @Nullable String webPageUrl, int scene);
}
