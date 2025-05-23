package com.tencent.qqnt.emotion.relatedemo.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.emotion.relatedemo.c;
import com.tencent.qqnt.emotion.relatedemo.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/api/IRelatedEmoPanelApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/emotion/relatedemo/d;", "vm", "Lcom/tencent/qqnt/emotion/relatedemo/c;", "getPanelVB", "getPanelVM", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IRelatedEmoPanelApi extends QRouteApi {
    @NotNull
    c getPanelVB(@NotNull Context context, @NotNull d vm5);

    @NotNull
    d getPanelVM();
}
