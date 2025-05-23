package com.tencent.mobileqq.zplan.download.api;

import bh3.e;
import bh3.f;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J&\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/download/api/IFileDownloadHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lbh3/e;", "listener", "Lbh3/f;", "createFileDownloadListenerWrapper", "listenerWrapper", "", "addFileDownloadListener", "removeFileDownloadListener", "Lcom/tencent/mobileqq/z1/download/ZPlanFileCategory;", "category", "", "url", "download", "Lkotlin/Function0;", "callback", "delete", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IFileDownloadHelper extends QRouteApi {
    void addFileDownloadListener(@NotNull f listenerWrapper);

    @NotNull
    f createFileDownloadListenerWrapper(@NotNull e listener);

    void delete(@NotNull ZPlanFileCategory category, @NotNull String url, @NotNull Function0<Unit> callback);

    void download(@NotNull ZPlanFileCategory category, @NotNull String url);

    void removeFileDownloadListener(@NotNull f listenerWrapper);
}
