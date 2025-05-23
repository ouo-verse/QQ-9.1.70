package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import eipc.EIPCResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/api/IAiEmoticonService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAiEmoticonAlbumIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "maxMediaSize", "", IEmoticonPanelIpcService.ACTION_UPLOAD_PIC_AND_CHECK, "Leipc/EIPCResult;", "filePath", "", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IAiEmoticonService extends QRouteApi {
    @Nullable
    Intent getAiEmoticonAlbumIntent(@NotNull Context context, int maxMediaSize);

    @NotNull
    EIPCResult uploadPicAndCheck(@NotNull String filePath);
}
