package com.tencent.mobileqq.vas.gift;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/gift/ITroopGiftComponent;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/vas/gift/b;", "createGiftView", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "preLoadGiftRes", "preLoadPag", "", "isPause", "setPause", "", "selfId", "needAutoShowAnim", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface ITroopGiftComponent extends QRouteApi {
    @NotNull
    b createGiftView(@NotNull Context context);

    boolean needAutoShowAnim(@NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull String selfId);

    void preLoadGiftRes(@NotNull com.tencent.aio.data.msglist.a msgItem);

    void preLoadPag();

    void setPause(boolean isPause);
}
