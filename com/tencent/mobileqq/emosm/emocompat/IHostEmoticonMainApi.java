package com.tencent.mobileqq.emosm.emocompat;

import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/emosm/emocompat/IHostEmoticonMainApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getEmoticonMainApi", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "onClear", "", "onInit", "emoticonPanel", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IHostEmoticonMainApi extends QRouteApi {
    @Nullable
    IEmoticonMainPanel getEmoticonMainApi();

    void onClear();

    void onInit(@NotNull IEmoticonMainPanel emoticonPanel);
}
