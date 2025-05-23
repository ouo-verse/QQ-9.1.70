package com.tencent.mobileqq.kandian.base.image.api;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.kandian.base.image.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.net.URL;
import k52.a;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\b\u0010\u0010\u001a\u00020\u0006H&J\u001c\u0010\u0013\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/image/api/IImageManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/net/URL;", "url", "", "isLocalFileExist", "", "clean", "resume", "Lcom/tencent/mobileqq/kandian/base/image/b;", Const.BUNDLE_KEY_REQUEST, "Lk52/a;", "uicallback", "loadImage", "Lk52/b;", "getBitmap", "pauseDownload", "", "reason", "cancelRequest", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IImageManager extends QRouteApi {
    void cancelRequest(@Nullable b request, @Nullable String reason);

    void clean();

    @Nullable
    k52.b getBitmap(@Nullable b request);

    boolean isLocalFileExist(@Nullable URL url);

    void loadImage(@Nullable b request, @Nullable a uicallback);

    void pauseDownload();

    void resume();
}
