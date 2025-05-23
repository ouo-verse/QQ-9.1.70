package com.tencent.mobileqq.app.message.filescan.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t81.a;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J.\u0010\u000f\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/app/message/filescan/api/IStorageScanApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "", "pathList", "Ljava/lang/Runnable;", "callback", "", "onNTFileDelete", "paths", "", "type", "order", "Lt81/a;", "listener", "loadFileDataByType", "tag", "clearFilePathKeyMap", "storage-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IStorageScanApi extends QRouteApi {
    void clearFilePathKeyMap(@NotNull String tag);

    void loadFileDataByType(@NotNull List<String> paths, int type, int order, @NotNull a listener);

    void onNTFileDelete(@NotNull List<String> pathList, @NotNull Runnable callback);
}
