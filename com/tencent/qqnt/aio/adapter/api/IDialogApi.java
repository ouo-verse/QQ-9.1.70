package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0001\rJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J8\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IDialogApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", "title", "content", "Lcom/tencent/qqnt/aio/adapter/api/IDialogApi$a;", "listener", "", "showAlert", "leftButtonText", "rightButtonText", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IDialogApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IDialogApi$a;", "", "", "onConfirm", "onCancel", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    void showAlert(@NotNull Context context, @NotNull String title, @NotNull String content, @NotNull a listener);

    void showAlert(@NotNull Context context, @NotNull String title, @NotNull String content, @NotNull String leftButtonText, @NotNull String rightButtonText, @NotNull a listener);
}
